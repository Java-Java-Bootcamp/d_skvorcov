
package exercises;

import org.junit.jupiter.api.Test;


public class TN19_MyMap {

    @Test
    public void test(){
        N19_MyMap m = new N19_MyMap();
        m.put("Hello", "World");
        m.put("Good", "Bye");
        m.put("Wel", "Come");
        m.put("!", "?");
        
        System.out.println(m.get("Hello"));
        System.out.println(m.get("Good"));
        System.out.println(m.get("Wel"));
        System.out.println(m.get("!"));
    }
}
