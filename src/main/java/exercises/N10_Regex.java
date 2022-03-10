package exercises;

import java.util.regex.Pattern;

public class N10_Regex {
    public enum ValidationType{
        PHONE(Pattern.compile("\\+?\\d\\(?\\d{3}\\)?\\d{3}-?\\d{2}-?\\d{2}")),
        EMAIL(Pattern.compile("\\w+@\\w+\\.\\w+")),
        FLOAT(Pattern.compile("\\-?\\d+\\.\\d+e?\\d*")),
        HTML_COLOR(Pattern.compile("#([0-9A-F]{3}){1,2}")),
        QUOTED_TEXT(Pattern.compile("\".*?\"")),
        DATETIME(Pattern.compile("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z"));
        Pattern pattern;
        ValidationType(Pattern pattern){
            this.pattern = pattern;
        }
    }

    public static class Validator{
        private ValidationType validationType;
        public Validator(ValidationType validationType) {
            this.validationType = validationType;
        }
        public boolean validate(String s){
            return validationType.pattern.matcher(s).find();
        }
        public String toString(){
            return validationType.pattern.toString();
        }
    }
}
