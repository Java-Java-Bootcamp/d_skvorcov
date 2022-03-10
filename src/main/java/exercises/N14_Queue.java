package exercises;

public class N14_Queue {
    static class Queue {
        int size;
        Integer[] data = new Integer[2];

        public Queue(){}

        void enqueue(Integer i){
            System.out.println("Вставляем на индекс " + 0 + " из " + data.length + " значение " + i);
            if(size > data.length*0.75){
                System.out.println("Увеличиваем размер с " + data.length + " до "+ data.length*2);
                Integer[] newArray = new Integer[data.length * 2];
                for (int j = 0; j < data.length; j++) {
                    newArray[j] = data[j];
                }
                data = newArray;
            }
            for (int j = size-1; j >= 0; j--) {
                System.out.println("Перемещаю с "+(j)+" на "+(j+1)+" значение "+data[j]);
                data[j+1] = data[j];
            }
            data[0] = i;
            size+=1;
        }

        Integer top(){
            return data[size-1];
        }

        Integer dequeue(){
            if(size-1<0) return null;
            Integer ret = data[size-1];
            delete(size-1);
            return ret;
        }

        void delete(int i){
            System.out.println("Удаляю значение " + data[i] + " в " + i);
            data[i] = null;
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
        Queue array = new Queue();
        array.enqueue(1);
        array.enqueue(2);
        array.enqueue(3);
        array.enqueue(4);
        array.enqueue(5);
        array.enqueue(6);
        array.enqueue(7);
        array.enqueue(8);
        array.enqueue(9);
        array.printAll();
        System.out.println(array.top());
        System.out.println(array.top());
        System.out.println(array.top());
        System.out.println(array.top());
        System.out.println(array.dequeue());
        System.out.println(array.dequeue());
        System.out.println(array.dequeue());
        System.out.println(array.dequeue());
        System.out.println(array.dequeue());
        System.out.println(array.dequeue());
        System.out.println(array.dequeue());
        System.out.println(array.dequeue());
        System.out.println(array.dequeue());
        System.out.println(array.dequeue());
        array.printAll();
    }
}
