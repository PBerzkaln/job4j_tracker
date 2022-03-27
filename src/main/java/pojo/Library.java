package pojo;

public class Library {
    public static void main(String[] args) {
        Book white = new Book("white", 100);
        Book black = new Book("black", 200);
        Book yellow = new Book("yellow", 300);
        Book cleanCode = new Book("Clean Code", 400);
        Book[] books = new Book[4];
        books[0] = white;
        books[1] = black;
        books[2] = yellow;
        books[3] = cleanCode;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " " + books[i].getNumberOFPages());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " " + books[i].getNumberOFPages());
        }
        for (int i = 0; i < books.length; i++) {
            if ("Clean Code".equals(books[i].getName())) {
                System.out.println(books[i].getName() + " " + books[i].getNumberOFPages());
            }
        }
    }
}
