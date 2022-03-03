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
}
