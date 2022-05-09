package inheritance;

public class PizzaExtraCheese extends Pizza {
    private static final String NAME = "extra cheese";

    @Override
    public String name() {
        return super.name() + " + " + NAME;
    }
}