package poly;

public class Airplane implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летит по воздуху.");
    }
}