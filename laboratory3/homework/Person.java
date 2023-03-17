import java.util.*;
import java.time.LocalDate;

public abstract class Person implements Comparable<Person>, Node {
    protected String name;
    protected LocalDate birthDate;
    protected Map<Node, String> relationships = new HashMap<>();
    public Person() {
    }
    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void addRelationship(Node node, String value) {
        relationships.put(node, value);
    }

    @Override
    public int compareTo(Person otherPerson) {

        return this.name.compareTo(otherPerson.name);
    }
    public Integer getNodeImportance()
    {
        return this.relationships.size();
    }
}


