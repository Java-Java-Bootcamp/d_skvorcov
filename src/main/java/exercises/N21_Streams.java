
package exercises;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;


public class N21_Streams {
    
    static class Worker{

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Gender getGender() {
            return gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getProfession() {
            return profession;
        }

        public void setProfession(String profession) {
            this.profession = profession;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
        public enum Gender{
            MALE,
            FEMALE
        }
        
        private String firstName;
        private String lastName;
        private Gender gender;
        private Integer age;
        private String profession;
        private String city;

        public Worker(String firstName, String lastName, Gender gender, Integer age, String profession, String city) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.gender = gender;
            this.age = age;
            this.profession = profession;
            this.city = city;
        }
    }
    
    public static List<Worker> getYoungWorkers(List<Worker> list){
        return list.stream().filter((t) -> {
            return t.age<30;
        }).toList();
    }
    
    public static Optional<Worker> getFirstOlderThan25(List<Worker> list){
        return list.stream().filter((t) -> {
            return t.age>25;
        }).findFirst();
    }
    
    public static Map<Worker.Gender, Long> countMenAndWomen(List<Worker> list){
        /*
        return list.stream().collect(HashMap::new,
                (genderIntegerHashMap, worker) -> genderIntegerHashMap.compute(worker.getGender(), (gender, integer) -> integer == null ? 1 : integer + 1),
                (genderIntegerHashMap, genderIntegerHashMap2) -> genderIntegerHashMap2.forEach(
                        (gender, integer0) -> genderIntegerHashMap.compute(gender,(gender1, integer1) -> integer1 == null ? integer0 : integer0 + integer1)));
        */
        return list.stream().collect(Collectors.groupingBy(o -> o.gender, Collectors.counting()));
    }

    public static Map<String, List<Worker>> groupByCity(List<Worker> list){
        return list.stream().collect(Collectors.groupingBy(o -> o.city));
    }

    public static List<String> getShortInfo(List<Worker> list){
        return list.stream().map(worker -> String.format("%s %s %d %s", StringUtils.capitalize(worker.firstName),
                StringUtils.capitalize(worker.lastName), worker.age, worker.profession)).collect(Collectors.toList());
    }

    public static List<Worker> getWillGetPensionIn5Years(List<Worker> list){
        return list.stream().filter(worker -> worker.age==60).toList();
    }
}
