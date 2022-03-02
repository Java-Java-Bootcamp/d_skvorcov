import java.util.Scanner;

public class N02_Quiz_Alt {
    public static void main(String[] args) {
        String[][] answerTexts = new String[][] {
                {"Вторник", "Четверг", "Суббота"},
                {"Суббота", "Воскресенье", "Понедельник"},
                {"10", "7", "25"}
        };
        String[] questionTexts = new String[]{
                "Какой из указанных дней недели - выходной?",
                "Какой из указанных дней недели - будний?",
                "Сколько в неделе дней?"
        };
        int[] rightAnswers = new int[]{2, 2, 1};

        int questionCount = questionTexts.length;
        assert(questionCount==rightAnswers.length && questionCount==answerTexts.length);

        Scanner s = new Scanner(System.in);
        int in;
        int rightAnswerCount = 0;

        for(int questionIndex = 0; questionIndex<questionCount; questionIndex++){
            System.out.println("Вопрос: "+questionTexts[questionIndex]);
            for (int x = 0; x<answerTexts.length; x++){
                System.out.println(x+": "+answerTexts[questionIndex][x]);
            }
            in = s.nextInt();
            System.out.println("Ваш ответ: "+in);
            System.out.println("Правильный ответ: "+rightAnswers[questionIndex]);
            if(rightAnswers[questionIndex]==in){
                System.out.println("Правильно!");
                rightAnswerCount++;
            } else {
                System.out.println("Неправильно!");
            }
        }
        System.out.println("Правильно отвечено: "+rightAnswerCount);
    }
}
