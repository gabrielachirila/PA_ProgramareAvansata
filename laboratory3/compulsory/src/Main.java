import java.util.*;
public class Main {
    public static void main(String[] args) {

        Person p1 = new Person();
        p1.setName("Maria");
        Person p2 = new Person("Elena");
        Person p3 = new Person("Alina");

        Company c1 = new Company();
        c1.setName("Compania1");
        Company c2 = new Company("Compania2");
        Company c3 = new Company("Compania3");

        List<Node> node1 = new ArrayList<>();
        node1.add(p1);
        node1.add(p2);
        node1.add(p3);
        node1.add(c1);
        node1.add(c2);
        node1.add(c3);

        System.out.println(node1);

    }
}