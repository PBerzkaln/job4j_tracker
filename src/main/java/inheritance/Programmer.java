package inheritance;

public class Programmer extends Engineer {
    private String doCoding;

    public Programmer(String name, String surname, String education, int birthday, String toProject, String doCoding) {
        super(name, surname, education, birthday, toProject);
        this.doCoding = doCoding;
    }

    public String doCoding(String doCoding) {
        return doCoding;
    }
}
