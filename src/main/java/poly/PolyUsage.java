package poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle train = new Train();
        Vehicle airplane = new Airplane();
        Vehicle bus = new Bus();
        Vehicle[] vehicles = new Vehicle[]{train, airplane, bus};
        for (Vehicle a : vehicles) {
            a.move();
        }
    }
}
