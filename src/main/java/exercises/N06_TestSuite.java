package exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N06_TestSuite {

    public static class TestSuite {
        public UserInterface ui;
        public Question[] questions;
        public int correctAnswerCount;

        public TestSuite(UserInterface ui, Question[] questions){
            this.ui = ui;
            this.questions = questions;
        }

        public void run(){
            for (int x = 0; x < questions.length; x++) {
                Question currentQuestion = questions[x];

                ui.print(currentQuestion.text);
                for (int y = 0; y < currentQuestion.variants.length; y++) {
                    ui.print(y+": "+currentQuestion.variants[y]);
                }

                int result = ui.query();
                if(questions[x].isValidVariant(result)){
                    ui.print("Правильно!");
                    correctAnswerCount++;
                }else{
                    ui.print("Неправильно!");
                }
            }
        };

        public interface UserInterface {
            public void print(String text);
            public int query();
        }

        public static class ConsoleUserInterface implements UserInterface{
            Scanner s = new Scanner(System.in);

            @Override
            public void print(String text) {
                System.out.println(text);
            }

            @Override
            public int query() {
                return(s.nextInt());
            }
        }

        public static class Question {
            String text;
            String[] variants;
            int validVariant;

            public Question(String text, String[] variants, int validVariant) {
                this.text = text;
                this.variants = variants;
                this.validVariant = validVariant;
            }

            boolean isValidVariant(int i) {
                return this.validVariant==i;
            }
        }
    }

}
