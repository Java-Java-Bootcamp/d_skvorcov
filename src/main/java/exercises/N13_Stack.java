package exercises;

public class N13_Stack {

    static class Stack{
        int size;
        Integer[] data = new Integer[2];

        public Stack(){}

        void push(Integer i){
            System.out.println("Вставляем на индекс " + size + " из " + data.length + " значение " + i);
            if(size > data.length*0.75){
                System.out.println("Увеличиваем размер с " + data.length + " до "+ data.length*2);
                Integer[] newArray = new Integer[data.length * 2];
                for (int j = 0; j < data.length; j++) {
                    newArray[j] = data[j];
                }
                data = newArray;
            }
            data[size] = i;
            size+=1;
        }

        Integer top(){
            return data[size-1];
        }

        Integer pop(){
            if(size-1<0) return null;
            Integer ret = data[size-1];
            delete(size-1);
            return ret;
        }

        void delete(int i){
            System.out.println("Удаляю значение " + data[i] + " в " + i);
            for (int j = i; j < data.length-1; j++) {
                data[j] = data[j+1];
            }
            size -= 1;

            if(size < data.length*0.25){
                System.out.println("Значений "+size+" меньше "+data.length*0.25+", уменьшаю с "+data.length+" до "+data.length/2);
                Integer[] newArray = new Integer[data.length / 2];
                for (int j = 0; j < newArray.length; j++) {
                    newArray[j] = data[j];
                }
                data = newArray;
            }
        }

        void printAll(){
            for (int i = 0; i < data.length; i++) {
                System.out.println(i + ":" +data[i]);
            }
        }

        boolean isEmpty(){
            return size==0;
        }

        int getSize(){
            return size;
        }
    }

    public static void main(String[] args) {
        Stack array = new Stack();
        array.push(0);
        array.push(1);
        array.push(2);
        array.push(3);
        array.push(4);
        array.push(5);
        array.push(6);
        array.push(7);
        array.push(8);
        System.out.println(array.top());
        System.out.println(array.top());
        System.out.println(array.top());
        System.out.println(array.top());
        System.out.println(array.pop());
        System.out.println(array.pop());
        System.out.println(array.pop());
        System.out.println(array.pop());
        System.out.println(array.pop());
        System.out.println(array.pop());
        System.out.println(array.pop());
        System.out.println(array.pop());
        System.out.println(array.pop());
        System.out.println(array.pop());
        array.printAll();
    }
}
