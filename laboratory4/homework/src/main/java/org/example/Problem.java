package org.example;

import java.util.*;

public class Problem {
    List<Student> listOfStudents = new LinkedList<>();
    SortedSet<Project> listOfProjects = new TreeSet<>();

    public Problem() {
    }
    public Problem(List<Student> listOfStudents, SortedSet<Project> listOfProjects) {
        this.listOfStudents = listOfStudents;
        this.listOfProjects = listOfProjects;
    }

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public SortedSet<Project> getListOfProjects() {
        return listOfProjects;
    }

    public void setListOfStudents(List<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public void setListOfProjects(SortedSet<Project> listOfProjects) {
        this.listOfProjects = listOfProjects;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Problem{");
        sb.append("listOfStudents=").append(listOfStudents);
        sb.append(", listOfProjects=").append(listOfProjects);
        sb.append('}');
        return sb.toString();
    }
}
