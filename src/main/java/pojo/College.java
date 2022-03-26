package pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Joe Doe");
        student.setGroup(1);
        student.setEntry(new Date());
        System.out.println(student.getName() + " в группе # " + student.getGroup() + " c " + student.getEntry());
    }
}
