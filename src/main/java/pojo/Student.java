package pojo;

import java.util.Date;

public class Student {
    private String name;
    private int group;
    private Date entry;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public Date getEntry() {
        return entry;
    }

    public void setEntry(Date entry) {
        this.entry = entry;
    }
}
