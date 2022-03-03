package exercises;

public class N04_Anagram {
    public static boolean checkIsAnagram(String s0, String s1){
        if(s0.length()!=s1.length()) return false;

        boolean found;
        boolean[] foundInS1 = new boolean[s1.length()];

        for(int x=0; x<s0.length(); x++){
            found = false;
            for (int y=0; y<s1.length(); y++){
                if(s0.charAt(x) == s1.charAt(y) && !foundInS1[y]) {
                    found = true;
                    foundInS1[y] = true;
                }
            }
            if(!found) return false;
        }
        return true;
    }
}
