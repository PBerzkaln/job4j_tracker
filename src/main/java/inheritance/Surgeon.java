package inheritance;

public class Surgeon extends Doctor {
    private String doSurgery;

    public Surgeon(String name, String surname, String education, int birthday, String diagnosis, String doSurgery) {
        super(name, surname, education, birthday, diagnosis);
        this.doSurgery = doSurgery;
    }

    public String doSurgery(String doSurgery) {
        return doSurgery;
    }
}
