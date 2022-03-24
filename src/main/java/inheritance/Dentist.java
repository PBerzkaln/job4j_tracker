package inheritance;

public class Dentist extends Doctor {
    private String doHealTooth;

    public Dentist(String name, String surname, String education, int birthday, String diagnosis, String doHealTooth) {
        super(name, surname, education, birthday, diagnosis);
        this.doHealTooth = doHealTooth;
    }

    public String getDoHealTooth(String doHealTooth) {
        return doHealTooth;
    }
}
