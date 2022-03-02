package exercises;

public class N05_Stack {

    public static class MyStack{
        private int[] values;
        private int valueCount = 0;
        public MyStack(int size){
            values = new int[size];
        }

        public void put(int val){
            values[valueCount++] = val;
        }

        public int get(){
            if(valueCount==0) return 0;
            return values[(valueCount--)-1];
        }
    }

    public static void checkTrue(boolean b){
        if(b)
            System.out.println("Correct");
        else
            System.out.println("Error");
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(10);
        stack.put(5);
        stack.put(2);
        stack.put(4);
        checkTrue(stack.get() == 4);
        checkTrue(stack.get() == 2);
        checkTrue(stack.get() == 5);
        checkTrue(stack.get() == 0);
        checkTrue(stack.get() == -1);
    }
}
