package exercises;

import exercises.N06_TestSuite.TestSuite;
import exercises.N06_TestSuite.TestSuite.ConsoleUserInterface;
import exercises.N06_TestSuite.TestSuite.Question;
import exercises.N06_TestSuite.TestSuite.UserInterface;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TN06 {
    public class ConsoleUserInterfaceMock extends ConsoleUserInterface{
        public int[] mockAnswers;
        private int answerIndex;

        public ConsoleUserInterfaceMock(int[] mockAnswers){
            this.mockAnswers = mockAnswers;
        }

        @Override
        public int query() {
            return mockAnswers[answerIndex++];
        }
    }

    @Test
    public void testTestSuite(){
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

        //Берем данные для вопросов из массивов, указанных выше, через цикл
        Question[] questionList = new Question[rightAnswers.length];
        for(int x=0; x<rightAnswers.length; x++){
            questionList[x] = new Question(questionTexts[x], answerTexts[x], rightAnswers[x]);
        }

        //Инициализируем, запускаем тест сьют
        UserInterface ui = new ConsoleUserInterfaceMock(new int[]{2,2,1}); //Используем mock интерфейса
        TestSuite testSuite = new TestSuite(ui, questionList);
        testSuite.run();
        //Проверяем правильность, сверяясь с кол-вом правильно отвеченных вопросов в testSuite
        assertEquals(3, testSuite.correctAnswerCount);

        //Пробуем еще
        ui = new ConsoleUserInterfaceMock(new int[]{3,6,1});
        testSuite = new TestSuite(ui, questionList);
        testSuite.run();
        assertEquals(1, testSuite.correctAnswerCount);

        ui = new ConsoleUserInterfaceMock(new int[]{5,5,5});
        testSuite = new TestSuite(ui, questionList);
        testSuite.run();
        assertEquals(0, testSuite.correctAnswerCount);

        ui = new ConsoleUserInterfaceMock(new int[]{2,10,50});
        testSuite = new TestSuite(ui, questionList);
        testSuite.run();
        assertEquals(1, testSuite.correctAnswerCount);
    }
}
