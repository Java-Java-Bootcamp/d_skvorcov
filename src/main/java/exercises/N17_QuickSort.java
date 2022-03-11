package exercises;

public class N17_QuickSort {
    public static void main(String[] a){
        int[] mergeSort = quickSort(new int[]{9,1,8,2,7,3,6,4,5});
        for (int i = 0; i < mergeSort.length; i++) {
            System.out.println(mergeSort[i]);
        }
    }

    public static int partition (int array[], int start, int end){
        int temp;

        //БЕРЕМ ОДНО КЛЮЧЕВОЕ ЗНАЧЕНИЕ ДЛЯ КОТОРОГО НАХОДИМ ПРАВИЛЬНУЮ ПОЗИЦИЮ
        int pivot = array[end];
        int pivotCorrectPos = start;

        //ПЕРЕМЕЩАЕМ ТАК ЧТО ВСЕ ЗНАЧЕНИЯ МЕНЬШЕ КЛЮЧЕВОГО УХОДЯТ НАЛЕВО ОТ ЕГО ПРАВИЛЬНОЙ ПОЗИЦИИ,
        //А ЕГО ПРАВИЛЬНАЯ ПОЗИЦИЯ ПОСТЕПЕННО ПЕРЕМЕЩАЕТСЯ ПРАВЕЕ ОТ НИХ
        //ПРИ ЭТОМ ЭТИ ОСТАЛЬНЫЕ ЗНАЧЕНИЯ НЕ СОРТИРУЕМ МЕЖДУ СОБОЙ
        for (int checkIndex = pivotCorrectPos; checkIndex < end; checkIndex++)  {
            if (array[checkIndex] < pivot)  {
                temp = array[pivotCorrectPos];
                array[pivotCorrectPos++] = array[checkIndex];
                array[checkIndex] = temp;
            }
        }

        //СТАВИМ НАШЕ ЗНАЧЕНИЕ РОВНО СПРАВА ОТ ВСЕХ КОТОРЫЕ МЕНЬШЕ ЕГО
        temp = array[pivotCorrectPos];
        array[pivotCorrectPos] = array[end];
        array[end] = temp;
        return pivotCorrectPos;
    }

    public static int[] quickSort(int fullArray[], int start, int end){
        if (start < end){

            //СТАВИМ ОДНО ЗНАЧЕНИЕ НА ПРАВИЛЬНУЮ ПОЗИЦИЮ И БЕРЕМ ЭТУ ПОЗИЦИЮ
            int middleIndex = partition(fullArray, start, end);

            //СОРТИРУЕМ ПРАВИЛЬНО СПРАВА ОТ НЕЁ И СЛЕВА
            quickSort(fullArray, start, middleIndex - 1);
            quickSort(fullArray, middleIndex + 1, end);
        }
        return fullArray;
    }

    public static int[] quickSort(int fullArray[]){
        return quickSort(fullArray, 0, fullArray.length-1);
    }
}
