package exercises;

public class N12_DynamicArray {

    static class DynamicArray{

        int size;
        Integer[] data = new Integer[2];

        public DynamicArray(){}

        void insert(Integer i){
            System.out.println("Вставляем на индекс " + size + " из " + data.length + " значение " + i);
            if(size > data.length*0.75){
                System.out.println("Увеличиваем размер с " + data.length + " до "+ data.length*2);
                Integer[] newArray = new Integer[data.length * 2];
                for (int j = 0; j < data.length; j++) {
                    System.out.println("Переместил " + data[j]);
                    newArray[j] = data[j];
                }
                data = newArray;
            }
            data[size] = i;
            size+=1;
        }

        Integer get(int i){
            return data[i];
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
                    System.out.println("Переместил " + data[j]);
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

        int getSize(){
            return size;
        }
    }

    public static void main(String[] args) {
        DynamicArray array = new DynamicArray();
        array.insert(0);
        array.insert(1);
        array.insert(2);
        array.insert(3);
        array.insert(4);
        array.insert(5);
        array.insert(6);
        array.insert(7);
        array.insert(8);
        System.out.println(array.get(2));
        System.out.println(array.get(4));
        System.out.println(array.get(6));
        System.out.println(array.get(8));
        array.delete(0);
        array.delete(0);
        array.delete(0);
        array.delete(0);
        array.delete(0);
        array.delete(0);
        array.delete(0);
        array.delete(0);
        array.printAll();
    }
}
