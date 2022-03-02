import java.util.Scanner;

public class N02_Quiz {

    //Вариант с вводом через текст ответа
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
        String userInput = "";
        String currentRightAnswerText = "";
        int rightAnswerCount = 0;

        //Итерируем массив вопросов
        for (int questionIndex = 0; questionIndex < questionCount; questionIndex++) {

            //Печатаем текст вопроса и ответы
            System.out.println("Вопрос: " + questionTexts[questionIndex]);
            for (String at : answerTexts[questionIndex]) {
                System.out.println(at);
            }

            //Принимаем ввод пользователя в виде текста
            userInput = scanner.next();
            System.out.println("Ваш ответ: " + userInput);

            //Получаем правильный ответ из массивов
            currentRightAnswerText = answerTexts[questionIndex][rightAnswers[questionIndex]];
            System.out.println("Правильный ответ: " + currentRightAnswerText);

            //Сравниваем правильный ответ с вводом
            if (currentRightAnswerText.equals(userInput)) {
                System.out.println("Правильно!");
                rightAnswerCount++;
            } else {
                System.out.println("Неправильно!");
            }

        }

        System.out.println("Правильно отвечено: " + rightAnswerCount);
    }
}