package org.example;

import java.util.LinkedList;
import java.util.List;

public class Student implements Comparable<Student> {
    private String name;
    List<Project> studentPreferences = new LinkedList<>();

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, List<Project> studentPreferences) {
        this.name = name;
        this.studentPreferences = studentPreferences;
    }

    public void addStudentPreference(Project p1)
    {
        this.studentPreferences.add(p1);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getStudentPreferences() {
        return studentPreferences;
    }

    public void setStudentPreferences(List<Project> studentPreferences) {
        this.studentPreferences = studentPreferences;
    }

    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", studentPreferences=").append(studentPreferences);
        sb.append('}');
        return sb.toString();
    }
}