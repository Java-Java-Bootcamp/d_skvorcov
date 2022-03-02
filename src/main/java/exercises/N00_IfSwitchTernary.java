package exercises;

import java.util.Scanner;

public class N00_IfSwitchTernary {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Введите день недели");

        String in = s.next();
        String result = "Ошибка";

        System.out.println("Вы ввели: "+in);

        if (in.equals("Понедельник"))
            result = "1";
        else if(in.equals("Вторник"))
            result = "2";
        else if(in.equals("Среда"))
            result = "3";
        else{
            switch (in){
                case "Четверг":
                    result = "4";
                    break;
                case "Пятница":
                    result = "5";
                    break;
                case "Суббота":
                    result = "6";
                    break;
                default:
                    result = (in.equals("Воскресенье")) ? "7" : "Ошибка";
            }
        }

        System.out.println("Результат: "+result);
    }
}
