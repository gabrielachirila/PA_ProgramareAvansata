package org.example;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {

        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i) )
                .toArray(Student[]::new);

        var projects = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Project("P" + i) )
                .toArray(Project[]::new);

        List<Student> listOfStudents = new LinkedList<>();
        SortedSet<Project> listOfProjects = new TreeSet<>();

        listOfStudents.add(students[0]);
        listOfStudents.add(students[1]);
        listOfStudents.add(students[2]);

        listOfProjects.add(projects[0]);
        listOfProjects.add(projects[1]);
        listOfProjects.add(projects[2]);

        Collections.sort(listOfStudents);

        System.out.println(listOfStudents);
        System.out.println(listOfProjects);

    }
}
