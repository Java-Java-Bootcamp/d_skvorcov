package exercises;

import java.util.Scanner;

public class N02_Quiz_Alt {

    //Альтернативный вариант с вводом через индекс ответа
    public static void main(String[] args) {

        //Тексты ответов для вопросов
        String[][] answerTexts = new String[][]{
                {"Вторник", "Четверг", "Суббота"},
                {"Суббота", "Воскресенье", "Понедельник"},
                {"10", "7", "25"}
        };

        //Тексты самих вопросов
        String[] questionTexts = new String[]{
                "Какой из указанных дней недели - выходной?",
                "Какой из указанных дней недели - будний?",
                "Сколько в неделе дней?"
        };

        //Индексы правильных ответов
        int[] rightAnswers = new int[]{2, 2, 1};

        //Узнать, сколько вопросов, убедиться что кол-во вопросов и ответов совпадает в массивах
        int questionCount = questionTexts.length;
        assert (questionCount == rightAnswers.length && questionCount == answerTexts.length);

        //Создаем сканнер, инициализируем переменные
        Scanner scanner = new Scanner(System.in);
        int userInput;
        int rightAnswerCount = 0;

        //Итерируем массив вопросов
        for (int questionIndex = 0; questionIndex < questionCount; questionIndex++) {

            //Печатаем текст вопроса и ответы с их индексами
            System.out.println("Вопрос: " + questionTexts[questionIndex]);
            for (int x = 0; x < answerTexts.length; x++) {
                System.out.println(x + ": " + answerTexts[questionIndex][x]);
            }

            //Принимаем ввод пользователя в виде ИНДЕКСА
            do {
                System.out.println("Введите ответ: ");
                userInput = scanner.nextInt();
                if(userInput>0 && userInput<answerTexts[questionIndex].length){
                    break;
                }else{
                    System.out.println("Пожалуйста, введите индекс правильного ответа!");
                }
            }while (true);
            System.out.println("Ваш ответ: " + userInput);
            System.out.println("Правильный ответ: " + rightAnswers[questionIndex]);

            //Сравниваем правильный ответ с вводом
            if (rightAnswers[questionIndex] == userInput) {
                System.out.println("Правильно!");
                rightAnswerCount++;
            } else {
                System.out.println("Неправильно!");
            }

        }

        System.out.println("Правильно отвечено: " + rightAnswerCount + " из " + questionCount);
    }
}