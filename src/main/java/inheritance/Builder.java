package inheritance;

public class Builder extends Engineer {
    private String doBuilding;

    public Builder(String name, String surname, String education, int birthday, String toProject, String doBuilding) {
        super(name, surname, education, birthday, toProject);
        this.doBuilding = doBuilding;
    }

    public String doBuilding(String doBuilding) {
        return doBuilding;
    }
}
