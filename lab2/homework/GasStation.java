public class GasStation extends Location{
    private double gasPrice;
  
    public GasStation() {
    }
    public GasStation(String name, double x, double y, double gasPrice) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.gasPrice = gasPrice;
    }

    @Override
    public String toString() {
        return "GasStation{" + "gasPrice=" + gasPrice + ", name='" + name + '\'' + ", x=" + x + ", y=" + y + '}' + '\n';
    }
}
