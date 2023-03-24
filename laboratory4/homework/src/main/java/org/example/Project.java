package org.example;
public class Project implements Comparable<Project> {
    private String name;

    public Project() {
    }

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Project o) {
        return name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Project{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}