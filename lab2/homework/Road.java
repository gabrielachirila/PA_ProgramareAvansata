import java.util.Objects;
import java.lang.Math;

public class Road {
    private String name;
    private double length;
    private int speedLimit;
    private RoadType type;
    private Location startLocation;
    private Location endLocation;
  
    public Road() {}
    public Road(String name, double length, int speedLimit, RoadType type, Location startLocation, Location endLocation) {
        this.name = name;
        this.length = length;
        this.speedLimit = speedLimit;
        this.type = type;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
    }
  
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {

        this.length = length;
    }
    public int getSpeedLimit() {

        return speedLimit;
    }
    public void setSpeedLimit(int speedLimit) {

        this.speedLimit = speedLimit;
    }
    public RoadType getType() {

        return type;
    }
    public void setType(RoadType type) {

        this.type = type;
    }
    public Location getStartLocation() {

        return startLocation;
    }
    public Location getEndLocation() {

        return endLocation;
    }
    public void setStartLocation(Location startLocation) {

        this.startLocation = startLocation;
    }
    public void setEndLocation(Location endLocation) {

        this.endLocation = endLocation;
    }
  
    public double getCoordinatesLength(Location startLocation, Location endLocation)
    {
        return Math.sqrt((endLocation.getY() - startLocation.getY()) * (endLocation.getY() - startLocation.getY()) + (endLocation.getX() - startLocation.getX()) * (endLocation.getX() - startLocation.getX()));
    }
  
    public String testLength()
    {
        return "length= " + length + " coordinatesLength= " + getCoordinatesLength(startLocation,endLocation) ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Road road)) return false;
        return Double.compare(road.getLength(), getLength()) == 0 && getSpeedLimit() == road.getSpeedLimit() && getName().equals(road.getName()) && getType() == road.getType() && getStartLocation().equals(road.getStartLocation()) && getEndLocation().equals(road.getEndLocation());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLength(), getSpeedLimit(), getType(), getStartLocation(), getEndLocation());
    }

    @Override
    public String toString() {
        return "Road{" + "name='" + name + '\'' + ", length=" + length + ", speedLimit=" + speedLimit + ", type=" + type + ", startLocation=" + startLocation + ", endLocation=" + endLocation + '}' + '\n';
    }
}
