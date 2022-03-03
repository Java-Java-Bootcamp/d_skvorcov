package exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TN05 {

    @Test
    public void testStack() {
        N05_Stack.MyStack stack = new N05_Stack.MyStack(10);
        stack.put(5);
        stack.put(2);
        stack.put(4);
        assertEquals(stack.get(),4);
        assertEquals(stack.get(), 2);
        assertEquals(stack.get(),5);
        assertEquals(stack.get(),0);
        assertNotEquals(stack.get(),-1);
    }
}
