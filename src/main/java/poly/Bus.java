package poly;

public class Bus implements Transport {
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
}
