package exercises;

import org.junit.jupiter.api.Test;

import static exercises.N04_Anagram.checkIsAnagram;
import static org.junit.jupiter.api.Assertions.*;

public class TN04 {

    @Test
    public void testAnagram() {
        assertTrue(checkIsAnagram("string0", "0gnirts"));
        assertFalse(checkIsAnagram("white", "black"));
        assertFalse(checkIsAnagram("white0", "white1"));
        assertTrue(checkIsAnagram("white", "eithw"));
        assertFalse(checkIsAnagram("white", "a"));
        assertTrue(checkIsAnagram("abc", "cba"));
        assertTrue(checkIsAnagram("abcdefgh", "eghfdbca"));
    }
}
