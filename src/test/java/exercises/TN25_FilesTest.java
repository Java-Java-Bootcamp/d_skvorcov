package exercises;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TN25_FilesTest {

    @Test
    void printFilesFromTwoCatalogs() {
        Set<File> set = new HashSet<>();
        set.add(new File("src"));
        set.add(new File("target"));
        N25_Files.printFilesFromMultipleCatalogs(set);
    }

    @Test
    void sameFile() {
        Assertions.assertThat(N25_Files.sameFile(new File("sameFile0.txt"), new File("sameFile1.txt"))).isTrue();
    }
}