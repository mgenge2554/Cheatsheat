public class Libary {
    String name;
    int year;
    Book[] books;

    Libary(String name, int year, Book[] books) {
        this.name = name;
        this.year = year;
        this.books = books;
    }
/*
    void displayInfo() {
        System.out.println("the " + this.year + " " + this.name);
        System.out.println("Books Available: ");
        for (Book book : books) {
            System.out.println(book.displayInfo());
        }
    }

 */
}
