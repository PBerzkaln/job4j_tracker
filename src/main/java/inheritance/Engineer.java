package inheritance;

public class Engineer extends Profession {
    private String toProject;

    public Engineer(String name, String surname, String education, int birthday, String toProject) {
        super(name, surname, education, birthday);
        this.toProject = toProject;
    }

    public String toProject(String toProject) {
        return toProject;
    }
}
