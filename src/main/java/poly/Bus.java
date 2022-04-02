package poly;

public class Bus implements Transport, Vehicle {
    @Override
    public void toGo() {
        System.out.println("Автобус отправляется\n Двери закрываются");
    }

    @Override
    public void passengers(int number) {
        System.out.println("Пасажиров в автобусе: " + number);
    }

    @Override
    public int refuel(int amount) {
        int rate = 55;
        return amount * rate;
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " едет по скоростной трассе.");
    }
}
