package oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public void printInfo() {
        System.out.println("Идем по дороге " + active);
        System.out.println("Расстояние " + status);
        System.out.println("Внимание ! " + message);
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public Error() {

    }

    public static void main(String[] args) {
        Error oneHundred = new Error(true, 100, "ямка");
        oneHundred.printInfo();
        Error twoHundred = new Error(true, 200, "ветка");
        twoHundred.printInfo();
        Error def = new Error();
        def.printInfo();
    }
}
