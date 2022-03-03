package exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TN05_Stack {

    @Test
    public void testStack() {
        N05_Stack.MyStack stack = new N05_Stack.MyStack(10);
        stack.put(5);
        stack.put(2);
        stack.put(4);
        assertEquals(4, stack.get());
        assertEquals(2, stack.get());
        assertEquals(5, stack.get());
        assertEquals(0, stack.get());
        assertNotEquals(-1, stack.get());
    }
}
