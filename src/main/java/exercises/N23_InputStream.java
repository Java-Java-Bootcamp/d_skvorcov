package exercises;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class N23_InputStream {

    public static void main(String[] args) {
        try (InputStream is = new BufferedInputStream(new FileInputStream("file.txt"));
             ZipOutputStream os = new ZipOutputStream(new FileOutputStream("zip.zip"))) {

            /*
            byte[] buf = new byte[10];
            int b;
            while((b = is.read(buf)) > 0){
                os.write(b);
            }
             */

            os.putNextEntry(new ZipEntry("file.txt"));
            is.transferTo(os);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
