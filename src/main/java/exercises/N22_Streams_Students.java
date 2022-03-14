package exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class N22_Streams_Students {
    static class Student{
        private String name;
        private String lastName;
        private String specialty;
        private int points;

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSpecialty() {
            return specialty;
        }

        public void setSpecialty(String specialty) {
            this.specialty = specialty;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public Student(String name, String specialty, int points) {
            this.name = name;
            this.specialty = specialty;
            this.points = points;
        }
    }

    public static Map<String, List<Student>> groupBySpecialty(List<Student> list){
        return list.stream().collect(Collectors.groupingBy(Student::getSpecialty));
    }

    public static Double getAveragePoints(List<Student> list){
        return list.stream().collect(Collectors.averagingInt(Student::getPoints));
    }

    public static List<Student> getPointsMoreThan51(List<Student> list){
        return list.stream().filter(student -> student.getPoints()>51).toList();
    }

    public static List<Student> getPoints100BySpecialty(List<Student> list, String specialty){
        return list.stream().filter(student -> student.getSpecialty().equals(specialty) && (student.getPoints() == 100)).toList();
    }

    public static List<Student> filterByFullname(List<Student> list, String fullName){
        return list.stream().filter(student -> (student.getName() + student.getLastName()).equals(fullName)).toList();
    }

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("name", "specialty", 50));
        list.add(new Student("name", "specialty", 25));
        System.out.println(getAveragePoints(list));
    }

}
