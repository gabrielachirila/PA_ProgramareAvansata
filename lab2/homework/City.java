public class City extends Location{

    public City() {
    }
    public City(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "City{" + "name='" + name + '\'' + ", x=" + x + ", y=" + y + '}' + '\n';
    }
}
