import java.util.Objects;

public abstract class Location {
    protected String name;
    protected double x;
    protected double y;
  
    public String getName() {
        return name;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location location)) return false;
        return Double.compare(location.getX(), getX()) == 0 && Double.compare(location.getY(), getY()) == 0 && getName().equals(location.getName());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getX(), getY());
    }
}
