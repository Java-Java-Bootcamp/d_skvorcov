package exercises;

import org.junit.jupiter.api.Test;

import static exercises.N03_Reverse_Avg_Array.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TN03 {
    @Test
    public void testReverseArray() {
        assertArrayEquals(new int[]{5,4,3,2,1}, reverseArray(new int[]{1,2,3,4,5}));
    }

    @Test
    public void testAverageArray() {
        assertEquals(avgArray(new int[]{1,2,3,4,5,6,7,8,9,10}), 5);
    }
}
