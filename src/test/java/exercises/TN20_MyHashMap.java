
package exercises;

import java.util.Objects;
import org.junit.jupiter.api.Test;


public class TN20_MyHashMap {
    
    class SameHashObject{
        public String test;

        public SameHashObject(String test) {
            this.test = test;
        }
        
        @Override
        public int hashCode() {
            return 0;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final SameHashObject other = (SameHashObject) obj;
            if(!other.test.equals(this.test)) return false;
            return Objects.equals(this.test, other.test);
        }
    }
    
    @Test
    public void test(){
        N20_MyHashMap m = new N20_MyHashMap();
        m.put("Hello", "World");
        m.put("Good", "Bye");
        m.put("Wel", "Come");
        m.put("!", "?");
        
        System.out.println(m.get("Hello"));
        System.out.println(m.get("Good"));
        System.out.println(m.get("Wel"));
        System.out.println(m.get("!"));
        
        m.put("Hello", "World2");
        m.put("Good", "Bye2");
        m.put("Wel", "Come2");
        m.put("!", "?2");
        
        System.out.println(m.get("Hello"));
        System.out.println(m.get("Good"));
        System.out.println(m.get("Wel"));
        System.out.println(m.get("!"));
        
        SameHashObject o0 = new SameHashObject("123123");
        SameHashObject o1 = new SameHashObject("123123");
        SameHashObject o2 = new SameHashObject("123123");
        
        m.put(o0, "OBJ0");
        m.put(o1, "OBJ1");
        m.put(o2, "OBJ2");
        
        System.out.println(m.get(o0));
        System.out.println(m.get(o1));
        System.out.println(m.get(o2));
    }
}
