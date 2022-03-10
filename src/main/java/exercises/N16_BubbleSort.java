package exercises;

public class N16_BubbleSort {

    public static void main(String[] a){
        int[] bubbleSort = bubbleSort(new int[]{9,8,7,6,5,4,3,2,1});
    }

    //СРАВНИВАЕМ ДВЕ СОСЕДНИЕ МНОГО МНОГО РАЗ
    public static int[] bubbleSort(int[] arr){
        int temp;
        for(int leftCount = 0; leftCount < arr.length; leftCount++){
            for(int rightCount = 1; rightCount < (arr.length - leftCount); rightCount++){
                if(arr[rightCount - 1] > arr[rightCount]){
                    temp = arr[rightCount-1];
                    arr[rightCount-1] = arr[rightCount];
                    arr[rightCount] = temp;
                }
            }
        }
        return arr;
    }
}
