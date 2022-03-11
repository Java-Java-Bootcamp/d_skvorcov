package exercises;

import org.junit.jupiter.api.Test;

import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ListIterator;

public class TN18_MyArrayList {
    @Test
    public void test(){
        N18_MyArrayList.MyList l = new N18_MyArrayList.MyList();
        l.add("hello1");
        l.add("hello2");
        l.add("hello3");
        l.add("hello4");
        l.add("hello5");
        l.add(3, "hello33");
        for (Object o:l) {
            System.out.println(o);
        }
        System.out.println("--");
        ListIterator listIterator = l.listIterator(2);
        boolean test = false;
        while(listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
            if(listIterator.hasPrevious() && !test){
                test = true;
                listIterator.add("HELLO!");
                listIterator.next();
            }
        }
        System.out.println("--");
        for (Object o:l) {
            System.out.println(o);
        }
    }
}
