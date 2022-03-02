package exercises;

public class N03_Reverse_Avg_Array {
    public static void printArr(int[] arr){
        for (int i :
                arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printArr(reverseArray(new int[]{1,2,3,4,5}));
        System.out.println(avgArray(new int[]{1,2,3,4,5,6,7,8,9,10}));
    }

    public static int[] reverseArray(int[] arr){
        int temp=0;
        for (int x=0; x<arr.length && x!=arr.length-1-x; x++){
            temp = arr[arr.length-1-x];
            arr[arr.length-1-x] = arr[x];
            arr[x] = temp;
        }
        return arr;
    }

    public static int avgArray(int[] arr){
        int sum = 0;
        for (int x=0; x<arr.length; x++){
            sum += arr[x];
        }
        return sum / arr.length;
    }
}
