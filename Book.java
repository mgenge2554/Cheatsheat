public class Book {
    String title;
    int pages;
    String author;

    Book(String title, int pages, String author){
        this.title = title;
        this.pages = pages;
        this.author = author;
    }
    void displayInfo() {
        System.out.println("the " + this.title + " is by " + this.author + " it has " + this.pages + " pages");
    }
    }

