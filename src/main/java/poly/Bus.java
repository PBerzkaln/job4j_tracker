package poly;

public class Bus implements Transport {
    @Override
    public void toGo() {
    }

    @Override
    public void passengers(int number) {
    }

    @Override
    public int refuel(int amount) {
        int rate = 55;
        return amount * rate;
    }
}
