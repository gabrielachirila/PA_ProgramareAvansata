import java.time.LocalDate;
import java.util.*;
public class Main {
    public static void main(String[] args) {

        Person p1 = new Designer("Ioana", LocalDate.of(1993, 10, 4), 4);
        Person p2 = new Programmer("Silvia", LocalDate.of(1999, 8, 17), "C++");
        Person p3 = new Programmer("Alin", LocalDate.of(2000, 1, 13), "Java");
        Person p4 = new Designer("Iosif", LocalDate.of(1995, 8, 6), 1);

        Company c1 = new Company("Amazon");
        Company c2 = new Company("Bitdefender");

        p1.addRelationship(p2,"best-friend");
        p1.addRelationship(c1,"boss");

        p2.addRelationship(p3, "co-worker");
        p2.addRelationship(c2, "employer");

        List<Node> node1 = new ArrayList<>();
        node1.add(p1);
        node1.add(p2);
        node1.add(p3);
        node1.add(p4);
        node1.add(c1);
        node1.add(c2);

        Network network1 = new Network(node1);
        System.out.println(network1);
    }
}