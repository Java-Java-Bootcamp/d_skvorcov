package exercises;
import java.util.Arrays;
public class N15_InsertionSort {

    public static void main(String[] a){
        int[] insertionSort = insertionSortAlt(new int[]{50,49,38,37,36,35,34,33});
    }

    //СРАВНИВАЕМ ПРАВУЮ С ЛЕВЫМИ И СМЕЩАЕМ ЛЕВЫЕ НА МЕСТО ПРАВОЙ А ПРАВУЮ НА МЕСТО САМОЙ ЛЕВОЙ
    public static int[] insertionSort(int[] array){
        int temp;
        for(int rightCount=1; rightCount<array.length; rightCount++)   {
            for(int leftCount=0; leftCount<rightCount; leftCount++){
                if(array[rightCount] < array[leftCount]){
                    temp = array[rightCount];
                    for(int midCount=rightCount; midCount>leftCount; midCount--){
                        array[midCount] = array[midCount-1];
                    }
                    array[leftCount]=temp;
                }
            }
        }
        return array;
    }

    public static int[] insertionSortAlt(int[] array){
        for(int rightCount=1;rightCount<array.length;rightCount++){
            int leftCount = rightCount-1;
            int rightCountVal = array[rightCount];
            while(leftCount>=0 && array[leftCount]>rightCountVal)
                array[leftCount+1] = array[leftCount--];
            array[leftCount+1] = rightCountVal;
        }
        return array;
    }
}
