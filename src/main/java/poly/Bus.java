package poly;

public class Bus implements Transport {
    @Override
    public String toGo(String yesNo) {
        return null;
    }

    @Override
    public int passengers(int number) {
        return 0;
    }

    @Override
    public int refuel(int amount, int rate) {
        int price = rate * amount;
        return price;
    }
}
