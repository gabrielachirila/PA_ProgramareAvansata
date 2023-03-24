package org.example;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {

        Faker faker = new Faker();

        Project project1 = new Project(faker.name().username());
        Project project2 = new Project(faker.name().username());
        Project project3 = new Project(faker.name().username());

        Student student1 = new Student(faker.name().name());
        Student student2 = new Student(faker.name().name());
        Student student3 = new Student(faker.name().name());

        student1.addStudentPreference(project1);
        student1.addStudentPreference(project2);
        student1.addStudentPreference(project3);

        student2.addStudentPreference(project1);
        student2.addStudentPreference(project2);

        student3.addStudentPreference(project1);

        SortedSet<Project> listOfProjects1 = new TreeSet<>();
        List<Student> listOfStudents1 = new LinkedList<>();

        listOfProjects1.add(project1);
        listOfProjects1.add(project2);
        listOfProjects1.add(project3);

        listOfStudents1.add(student1);
        listOfStudents1.add(student2);
        listOfStudents1.add(student3);

        Problem p2 = new Problem(listOfStudents1,listOfProjects1);

        System.out.println(p2);

        double averageNumberOfPreferences = p2.listOfStudents.stream()
                .mapToInt(s -> s.getStudentPreferences().size())
                .average()
                .orElse(0);

        System.out.println("Average number of preferences: " +  averageNumberOfPreferences);

        List<Student> result = p2.listOfStudents.stream()
                .filter(s -> s.getStudentPreferences().size() < averageNumberOfPreferences)
                .collect(Collectors.toList());

        System.out.println("All the students that have a number of preferences lower than the average number of preferences: ");

        result.forEach(System.out::println);
    }
}
