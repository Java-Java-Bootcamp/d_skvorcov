package exercises;

import java.util.Scanner;

public class N01_Array_For_DoWhile_ForEach {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Введите день недели");

        String in = s.next();
        String result = "Ошибка";

        System.out.println("Вы ввели: "+in);

        String[][] resultData = new String[][]{
                {"Mon", "Пон"},
                {"Tue", "Вто"},
                {"Wed", "Сре"},
                {"Thu", "Чет"},
                {"Fri", "Пят"},
                {"Sat", "Суб"},
                {"Sun", "Вос"}
        };

        for(int x=0; x<resultData.length; x++){
            if(!resultData[x][0].equals(in)) continue;

            result = resultData[x][resultData[x].length-1];
            break;
        }

        System.out.println("Результат For: "+result);

        int dwIndex = 0;
        do{
            if(!resultData[dwIndex][0].equals(in)) continue;

            result = resultData[dwIndex][resultData[dwIndex].length-1];
            break;
        } while (dwIndex++<resultData.length);

        System.out.println("Результат DoWhile: "+result);

        for (String[] resultArr : resultData) {
            if(!resultArr[0].equals(in)) continue;

            result = resultArr[resultArr.length-1];
            break;
        }

        System.out.println("Результат ForEach: "+result);
    }
}
