import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        Location location0 = new City();
        location0.setName("Suceava");
        location0.setX(20.4);
        location0.setY(50.7);

        Location location1 = new Airport("Iasi", 10.0, 20.0);
        Location location2 = new GasStation("Golden Fuel", 15.6, 16.1,7.80);
        Location location3 = new City("Timisoara", 45.0, 55.0);

        Road road0 = new Road();
        road0.setName("A2");
        road0.setLength(250.5);
        road0.setSpeedLimit(100);
        road0.setType(RoadType.COUNTRY);
        road0.setStartLocation(location0);
        road0.setEndLocation(location1);

        Road road1 = new Road("A3", 154.6, 120,RoadType.EXPRESS, location1, location3);
        Road road2 = new Road("A4", 203.6, 120,RoadType.HIGHWAYS, location2, location3);

        ArrayList<Location> locationsAdded = new ArrayList<>();
        locationsAdded.add(location0);
        locationsAdded.add(location1);
        locationsAdded.add(location2);
        locationsAdded.add(location3);
        locationsAdded.add(location3);

        ArrayList<Road> roadsAdded = new ArrayList<>();
        roadsAdded.add(road0);
        roadsAdded.add(road0);
        roadsAdded.add(road1);

        Problem p = new Problem(locationsAdded,roadsAdded);
        System.out.println(p);
        System.out.println(p.getNumberOfLocations() + " locations & " + p.getNumberOfRoads() + " roads added.");

        if(p.isValid()) {
            System.out.println("Instance p IS valid");

            if (p.doesPathExists(location0, location2))
                System.out.println("Path exists! From " + location0.getName() + " to " +  location2.getName());
            else
                System.out.println("Path doesn't exist! From " + location0.getName() + " to " + location2.getName());

            if (p.doesPathExists(location0, location3))
                System.out.println("Path exists! From " + location0.getName() + " to " + location3.getName());
            else
                System.out.println("Path doesn't exist! From " + location0.getName() + " to " + location3.getName());
        }
        else
            System.out.println("Instance p IS NOT valid");

        Problem p1 = new Problem();

        p1.addLocation(location0);
        p1.addLocation(location1);
        p1.addLocation(location1);
        p1.addLocation(location2);

        p1.addRoad(road0);
        p1.addRoad(road0);
    }
}
