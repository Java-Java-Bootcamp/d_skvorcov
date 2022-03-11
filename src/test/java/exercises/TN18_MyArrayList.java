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
        for (Object o:l) {
            System.out.println(o);
        }
        ListIterator listIterator = l.listIterator(4);
        while(listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }
    }
}
