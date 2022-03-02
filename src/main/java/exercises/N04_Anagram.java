package exercises;

public class N04_Anagram {
    public static void checkTrue(boolean b){
        if(b)
            System.out.println("Correct");
        else
            System.out.println("Error");
    }

    public static void main(String[] args) {
        checkTrue(checkIsAnagram("string0", "0gnirts") == true);
        checkTrue(checkIsAnagram("white", "black") == false);
        checkTrue(checkIsAnagram("white0", "white1") == false);
        checkTrue(checkIsAnagram("white", "eithw") == true);
        checkTrue(checkIsAnagram("white", "a") == false);
        checkTrue(checkIsAnagram("abc", "cba") == true);
        checkTrue(checkIsAnagram("abcdefgh", "eghfdbca") == true);
    }

    public static boolean checkIsAnagram(String s0, String s1){
        if(s0.length()!=s1.length()) return false;

        boolean found;
        boolean[] foundInS0 = new boolean[s1.length()];
        for (int x=0; x<s1.length(); x++){
            foundInS0[x] = false;
        }

        for(int x=0; x<s0.length(); x++){
            found = false;
            for (int y=0; y<s1.length(); y++){
                if(s0.charAt(x) == s1.charAt(y) && !foundInS0[y]) {
                    found = true;
                    foundInS0[y] = true;
                }
            }
            if(!found) return false;
        }
        return true;
    }
}
