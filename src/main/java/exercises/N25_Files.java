package exercises;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Arrays;
import java.util.Set;

public class N25_Files {

    public static void main(String[] args) {
        File path = new File("newDir/");
        File file = new File("file.txt");
        path.mkdir();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(File in, File out){
        try(BufferedInputStream is = new BufferedInputStream(new FileInputStream(in));
            BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(out))) {

            os.write(is.readAllBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printFilesFromMultipleCatalogs(Set<File> catalogs){
        catalogs.stream()
                .filter(File::isDirectory)
                .map(File::listFiles)
                .flatMap(Arrays::stream)
                .forEach(System.out::println);
    }

    public static boolean sameFile(File f0, File f1){
        //FileUtils.contentEquals(f0, f1);

        try(InputStream is0 = new BufferedInputStream(new FileInputStream(f0.toString()));
            InputStream is1 = new BufferedInputStream(new FileInputStream(f1.toString()))) {
            return(Arrays.equals(is0.readAllBytes(),is1.readAllBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
