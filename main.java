import org.w3c.dom.ls.LSOutput;

import javax.xml.crypto.Data;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//Variables

        Admin admin1 = new Admin("Mgenge", "password");
        Admin admin2 = new Admin("Mpowell", "password1");
        Admin admin3 = new Admin("Pwait", "password2");
        ArrayList<Admin> AdminLogInfo = new ArrayList<>();
        AdminLogInfo.add(admin1);
        AdminLogInfo.add(admin2);
        AdminLogInfo.add(admin3);
        int AdminLength = AdminLogInfo.toArray().length;

        ArrayList<String> rentedList = new ArrayList<>();

        User user1 = new User("Mgenge", "password");
        User user2 = new User("Mpowell", "password1");
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        int usersLength = users.toArray().length;

        ArrayList<Book> books = new ArrayList<>();
        Book book1 = new Book("Mistborn", 600, "Brandon", false);
        Book book2 = new Book("Mistborn 2", 592, "Brandon", false);
        books.add(book1);
        books.add(book2);
        int libaryLength = books.toArray().length;


        char logInChoice;
        char AdminChoice;
        String username;
        String password;
        boolean isRunning = true;
        boolean isLogedIn = true;


        //Libary system (log in)
        while (isRunning) {
            System.out.println("""
                    Welcome to the Libary System. Please select an option:
                    1. Admin Login
                    2. Customer Login
                    3. Turn off""");

            logInChoice = scanner.next().charAt(0);


            if (logInChoice == '1') {
                System.out.println("Please enter your Username and password");
                System.out.print("Username: ");
                scanner.nextLine();
                username = scanner.nextLine();
                System.out.println(username);
                System.out.print("Password: ");

                password = scanner.nextLine();
                System.out.println(password);

                isLogedIn = true;

                // Admin menu
                while (isLogedIn) {
                    for (int i = 0; i < AdminLength; i++) {
                        if (AdminLogInfo.get(i).getUsername().equals(username) && (AdminLogInfo.get(i).getPassword().equals(password))) {

                            System.out.println("Welcome " + username);
                            System.out.println("""
                                    Please choose an Option
                                    1. Add a book to the libary
                                    2. Remove a book
                                    3. Add an account
                                    4. Log out
                                    """);

                            AdminChoice = scanner.next().charAt(0);
                            scanner.nextLine();


                            if (AdminChoice == '1') {
                                System.out.print("please input a Book title: \n");
                                String bookTitle = scanner.nextLine();

                                System.out.print("please input a Book Author: \n");
                                scanner.nextLine();
                                String bookAuthor = scanner.nextLine();

                                System.out.println("please input the number of pages: \n");
                                int bookPages = scanner.nextInt();
                                boolean isRented = false;

                                Book book = new Book(bookTitle, bookPages, bookAuthor, isRented);
                                book.displayInfo();
                                books.add(book);


                                for (int y = 0; y < libaryLength; y++) {
                                    System.out.println(Arrays.asList(books));

                                }

                            } else if (AdminChoice == '2') {

                                System.out.print("Type in a Book title to delete: ");
                                String search = scanner.nextLine();

                                for (int y = 0; y < libaryLength; y++) {
                                    for (Book book : books) {
                                        if (search.equals(book.getTitle())) {
                                            books.remove(book);
                                            System.out.println("book deleted");
                                            System.out.println(Arrays.asList(books));
                                        } else {
                                            System.out.println("not found");
                                        }


                                    if (username.length() < 4 || username.length() > 12) {
                                        System.out.println("username must be between 4 - 12 characters");

                                    }else if (username.contains(" ") || username.contains("_")) {
                                        System.out.println("make sure there is no spaces or _");

                                    }else if (!password.contains("!") && !password.contains("£")
                                            && !password.contains("#") && !password.contains("%") &&
                                            !password.contains("@")) {
                                        System.out.println("A password must include a !, £, #, %, @");

                                    }else{
                                        users.add(new User(username, password));

                                    //System.out.println(Arrays.asList(users)); // Confirms data entered
                                    isCorrect= false;
                                    isLogedIn = false;

                                    }

                                }
                            } else if (AdminChoice == '3') {
                                System.out.print("please enter a Username: ");
                                username = scanner.nextLine();
                                System.out.print("please enter a Password: ");
                                password = scanner.nextLine();

                                users.add(new User(username, password));
                                System.out.println(Arrays.asList(users));
                                isLogedIn = false;

                            } else if (AdminChoice == '4') {
                                isLogedIn = false;

                                return;
                            }
                        }
                    }
                }
            }
            else if (logInChoice == '2') {
=======
                            }

                        }
                    }
                }
            } else if (logInChoice == '2') {

                System.out.println("Please enter your Username and password");
                System.out.print("Username: ");
                scanner.nextLine();
                username = scanner.nextLine();
                System.out.println(username);
                System.out.print("Password: ");

                password = scanner.nextLine();
                System.out.println(password);

                isLogedIn = true;

                while (isLogedIn) {
                    for (int i = 0; i < users.toArray().length; i++) {
                        if (users.get(i).getUsername().equals(username) && (users.get(i).getPassword().equals(password))) {
                            System.out.println("Welcome " + username);
                            System.out.println("""
                                    Please choose an Option
                                       1. Search a book
                                       2. Return a book
                                       3. Log out
                                    """);
                            char option = scanner.next().charAt(0);
                            scanner.nextLine();

                            if (option == '1') {

                                System.out.println("Please type in a book title: ");
                                String TitleSearch = scanner.nextLine();

                                System.out.println(TitleSearch);



                                for (Book book : books) {
                                    if (TitleSearch.equals(book.getTitle())) {
                                        System.out.println("Book found");
                                        if (book.isRented) {
                                            System.out.println("cannot be rented");
                                        } else if (!book.isRented) {
                                            System.out.println("Would you like to rent? [Y/N] ");
                                            char answer = scanner.next().toUpperCase().charAt(0);
                                            if (answer == 'Y') {
                                                book.setisRented(true);
                                                user1.numberOfBooks++;
                                                System.out.println(users.get(i).numberOfBooks);
                                                rentedList.add(TitleSearch);
                                                System.out.println(rentedList);


                                            } else {
                                                System.out.println("not found");
                                            }
                                            if (users.get(i).numberOfBooks > 3) {
                                                book.setisRented(false);
                                                System.out.println("you have too many books out");
                                                users.get(i).numberOfBooks--;
                                                System.out.println(users.get(i).numberOfBooks);
                                            }
                                        }
                                    }
                                }

                                    for (Book book : books) {
                                        if (TitleSearch.equals(book.getTitle())) {
                                            System.out.println("Book found");
                                            if (book.isRented) {
                                                System.out.println("cannot be rented");
                                            } else if (!book.isRented) {
                                                System.out.println("Would you like to rent? [Y/N] ");
                                                char answer = scanner.next().toUpperCase().charAt(0);
                                                if (answer == 'Y') {
                                                    book.setisRented(true);
                                                    user1.numberOfBooks++;
                                                    System.out.println(users.get(i).numberOfBooks);
                                                    rentedList.add(TitleSearch);
                                                    System.out.println(rentedList);
                                                } else {
                                                    System.out.println("not found");
                                                }

                                                    if (users.get(i).numberOfBooks > 3) {
                                                        book.setisRented(false);
                                                        System.out.println("you have too many books out");
                                                        users.get(i).numberOfBooks--;
                                                        System.out.println(users.get(i).numberOfBooks);
                                                    }

                                            }
                                        }
                                    }





                            } else if (option == '2') {
                                System.out.print("please enter the title of the book: ");
                                String bookReturn = scanner.nextLine();
                                for (int y = 0; y < users.toArray().length; y++) {
                                    if(bookReturn.equals(books.get(y).getTitle())){
                                        if(books.get(y).isRented){
                                            books.get(y).setisRented(false);
                                            users.get(y).numberOfBooks--;
                                            users.get(y).rentedList.remove(bookReturn);
                                            System.out.println("book has been returned");
                                        }
                                    }

                                }
                            }

                            else if (option == '3') {
                                isLogedIn = false;
                            }


                        }
                    }
                }

            }
            else if (logInChoice == '3') {
                System.out.println("Thank you");
                isRunning = false;
            }
        }
        scanner.close();
    }
}