public class Main {
    public static void main(String[] args)
    {
        Location c1 = new Location();
        c1.setName("Iași");
        c1.setX(0.1);
        c1.setY(0.2);
        c1.setType(LocationType.AIRPORTS);
        System.out.println(c1);
        Location c2 = new Location("Bucuresti", 10.0, 20.0,LocationType.CITIES);
        System.out.println(c2);

        Road r1 = new Road();
        r1.setName("A2");
        r1.setLength(165.6);
        r1.setSpeedLimit(100);
        r1.setType(RoadType.HIGHWAYS);
        System.out.println(r1);
    }
}
