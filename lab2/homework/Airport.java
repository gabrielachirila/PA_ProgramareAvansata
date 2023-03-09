public class Airport extends Location{
  
    public Airport() {
    }
    public Airport(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
  
    @Override
    public String toString() {
        return "Airport{" + "name='" + name + '\'' + ", x=" + x + ", y=" + y + '}' + '\n';
    }
}
