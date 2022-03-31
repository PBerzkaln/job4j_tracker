package poly;

public interface Transport {
    String toGo(String yesNo);

    int passengers(int number);

    int refuel(int amount, int rate);
}
