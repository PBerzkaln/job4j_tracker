package poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " катится по рельсам.");
    }
}
