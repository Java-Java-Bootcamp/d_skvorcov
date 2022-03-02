import java.util.Scanner;

public class N02_Quiz {
    public static void main(String[] args) {
        String[][] answerTexts = new String[][] {
                {"Вторник", "Четверг", "Суббота"},
                {"Суббота", "Воскресенье", "Понедельник"},
                {"10", "7", "25"}
        };
        String[] questionTexts = new String[]{"Какой из указанных дней недели - выходной?", "Какой из указанных дней недели - будний?", "Сколько в неделе дней?"};
        int[] rightAnswers = new int[]{2, 2, 1};

        int questionCount = questionTexts.length;
        assert(questionCount==rightAnswers.length && questionCount==answerTexts.length);

        Scanner s = new Scanner(System.in);
        String in = "";
        String rightAnswer = "";
        int rightAnswerCount = 0;

        for(int questionIndex = 0; questionIndex<questionCount; questionIndex++){
            System.out.println("Вопрос: "+questionTexts[questionIndex]);
            for (String at : answerTexts[questionIndex]) {
                System.out.println(at);
            }
            in = s.next();
            System.out.println("Ваш ответ: "+in);
            rightAnswer = answerTexts[questionIndex][rightAnswers[questionIndex]];
            System.out.println("Правильный ответ: "+rightAnswer);
            if(rightAnswer.equals(in)){
                System.out.println("Правильно!");
                rightAnswerCount++;
            } else {
                System.out.println("Неправильно!");
            }
        }
        System.out.println("Правильно отвечено: "+rightAnswerCount);
    }
}
