package exercises;

import java.util.regex.Pattern;

public class N11_RegexBlacklist {
    public static Pattern createRegexPattern(String list){
        return Pattern.compile(list.replace(',', '|').toString());
    }

    private static boolean isMsisdnValid(String m){
        if(m==null) return false;
        return Pattern.compile("(70|77|55|99)[0-9]{7}").matcher(m).matches();
    }

    public static void main(String[] args) {
        Pattern blacklist = createRegexPattern("701111111,771111111,5511111111");
        Pattern whitelist = createRegexPattern("991111111");

        String[] list = new String[]{"991111111", "701111111"};

        for (int i = 0; i < list.length; i++) {
            String s = list[i];
            if(!blacklist.matcher(s).lookingAt()) {
                System.out.println("-");
                continue;
            }
            if(whitelist.matcher(s).lookingAt()) {
                System.out.println("+");
            }
        }

    }
}
