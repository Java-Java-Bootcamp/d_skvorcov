package exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static exercises.TN10_Regex.ValidationPair.pairs;

public class TN10_Regex {

    public class ValidationPair{
        public static ArrayList<ValidationPair> pairs = new ArrayList<>();

        N10_Regex.Validator validator;
        String[] string;

        public ValidationPair(N10_Regex.ValidationType type, String[] string) {
            this.validator = new N10_Regex.Validator(type);
            this.string = string;
            pairs.add(this);
        }
    }

    @Test
    public void test(){
        ValidationPair phone = new ValidationPair(N10_Regex.ValidationType.PHONE,
                new String[]{"+1(111)111-11-11", "+11111111111"});
        ValidationPair email = new ValidationPair(N10_Regex.ValidationType.EMAIL,
                new String[]{"aaa@aaaaa.aa", "a@a.a"});
        ValidationPair zfloat = new ValidationPair(N10_Regex.ValidationType.FLOAT,
                new String[]{"-5125.22", "2525.2e222"});
        ValidationPair htmlColor = new ValidationPair(N10_Regex.ValidationType.HTML_COLOR,
                new String[]{"#AB3DDE", "#33A"});
        ValidationPair quotedText = new ValidationPair(N10_Regex.ValidationType.QUOTED_TEXT,
                new String[]{"\"hello world\""});
        ValidationPair dateTime = new ValidationPair(N10_Regex.ValidationType.DATETIME,
                new String[]{ "1111-11-11T11:11:11Z"});

        for(ValidationPair pair1 : pairs){
            for(ValidationPair pair2 : pairs){
                for(String s : pair2.string){
                    System.out.println(pair1.validator.toString()+" VS "+s);
                    if(pair1.validator == pair2.validator)
                        Assertions.assertTrue(pair1.validator.validate(s));
                    else
                        Assertions.assertFalse(pair1.validator.validate(s));
                }
            }
        }
    }
}
