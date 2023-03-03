
public class Road {
    private String name;
    private double length;
    private int speedLimit;
    private RoadType type;
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

    public Road() {}

    public Road(String name, double length, int speedLimit, RoadType type) {
        this.name = name;
        this.length = length;
        this.speedLimit = speedLimit;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Road{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                ", type=" + type +
                '}';
    }
}
