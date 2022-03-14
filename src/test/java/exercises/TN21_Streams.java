package exercises;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class TN21_Streams {
    @Test
    public void test0(){
        List<N21_Streams.Worker> list = new ArrayList<>();
        list.add(new N21_Streams.Worker("1", "l", N21_Streams.Worker.Gender.MALE,25, "p", "c"));
        list.add(new N21_Streams.Worker("2", "l", N21_Streams.Worker.Gender.FEMALE,35, "p", "c"));
        list.add(new N21_Streams.Worker("3", "l", N21_Streams.Worker.Gender.MALE,45, "p", "c2"));
        list.add(new N21_Streams.Worker("4", "l", N21_Streams.Worker.Gender.FEMALE,55, "p", "c2"));
        list.add(new N21_Streams.Worker("5", "l", N21_Streams.Worker.Gender.MALE,65, "p", "c3"));
        list.add(new N21_Streams.Worker("6", "l", N21_Streams.Worker.Gender.FEMALE,75, "p", "c3"));
        list.add(new N21_Streams.Worker("7", "l", N21_Streams.Worker.Gender.MALE,85, "p", "c4"));
        Assertions.assertThat(N21_Streams.getYoungWorkers(list)).map(N21_Streams.Worker::getFirstName).containsExactly("1");
        Assertions.assertThat(N21_Streams.countMenAndWomen(list))
                .containsEntry(N21_Streams.Worker.Gender.MALE, 4L)
                .containsEntry(N21_Streams.Worker.Gender.FEMALE, 3L);
        Assertions.assertThat(N21_Streams.getFirstOlderThan25(list)).map(N21_Streams.Worker::getFirstName).contains("2");
        List<N21_Streams.Worker> l = new ArrayList<N21_Streams.Worker>();
        l.add(list.get(6));
        Assertions.assertThat(N21_Streams.groupByCity(list))
                .contains(new AbstractMap.SimpleEntry[]{
                        new AbstractMap.SimpleEntry<>("c4", l)
                });
    }
}
