package ooa;

public final class Airbus extends Aircraft {
    private static final int COUNT_ENGINE = 2;

    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printModel() {
        System.out.println("Модель самолета: " + name);
    }

    public void printCountEngine() {
        int result = "A320".equals(this.name) ? COUNT_ENGINE : COUNT_ENGINE * 2;
        System.out.println("Количество двигателей равно: " + result);
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}