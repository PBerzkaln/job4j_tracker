package pojo;

public class Book {
    private String name;
    private int numberOFPages;

    public Book(String name, int numberOFPages) {
        this.name = name;
        this.numberOFPages = numberOFPages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOFPages() {
        return numberOFPages;
    }

    public void setNumberOFPages(int numberOFPages) {
        this.numberOFPages = numberOFPages;
    }
}
