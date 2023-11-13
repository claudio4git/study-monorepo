package algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class SortAndRanking {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Maria", 5),
                new Student("John", 9),
                new Student("Paul", 7),
                new Student("Ada", 5),
        };

        System.out.println("Students without sort: " + Arrays.toString(students));
        
        Arrays.sort(students);
        System.out.println("Students sorted by score: " + Arrays.toString(students));

        Comparator<Student> studentComparator = Comparator
            .comparingInt(Student::getScore)
            .thenComparing(Student::getName);

        Arrays.sort(students, studentComparator);
        System.out.println("Students sorted by score and name: " + Arrays.toString(students));

        for (int i = 0; i < students.length; i++) {
            students[i].setRank(i + 1);
        }

        Arrays.sort(students, (a, b) -> Integer.compare(a.getRank(), b.getRank()));
        System.out.println("Students sorted by rank: " + Arrays.toString(students));

        List<Student> studentList = Arrays.asList(students);
        System.out.println("Students array list: " + studentList);

        Collections.sort(studentList, (a, b) -> Integer.compare(b.getRank(), a.getRank()));
        System.out.println("Students array list sorted by rank descending: " + studentList);

        // ArrayList.sort
        // Collections.sort
        // Arrays.sort
    }
}

class Student implements Comparable<Student> {
    private String name;
    private Integer score;
    private Integer rank;

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public int compareTo(Student other) {
        return Integer.compare(this.score, other.score);
    }

    public String toString() {
        return "[" + this.name +
            ", " + this.score +
            ", " + this.rank + "]";
    }
}
