import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//Variables

       Admin admin1 = new Admin("Mgenge", "password");
        Admin admin2 = new Admin("Mpowell", "password1");
        Admin admin3 = new Admin("Pwait", "password2");
        Admin[] AdminLogInfo = {admin1, admin2, admin3};


        //String[] AdminUserName = {"mgenge", "mpowell", "pwait"};
        //String[] AdminPasswords = {"Password", "Password1", "Password2"};
        int AdminLength = AdminLogInfo.length;
        char logInChoice;
        char AdminChoice;
        String username;
        String password;

        //Libary system (log in)
        System.out.println("""
                Welcome to the Libary System. Please select an option:
                1. Admin Login
                2. Customer Login
                """);
        logInChoice = scanner.next().charAt(0);

        if(logInChoice == '1'){
            System.out.println("Please enter your Username and password");
            System.out.print("Username: ");
            scanner.nextLine();
            username = scanner.nextLine();
            System.out.println(username);
            System.out.print("Password: ");

            password = scanner.nextLine();
            System.out.println(password);
            // Admin menu
            for (int i = 0 ; i < AdminLength ; i++){
                if(AdminLogInfo[i].getUsername().equals(username)
             && (AdminLogInfo[i].getPassword().equals(password))){
                    System.out.println("Welcome " + username);
                    System.out.println("""
                    Please choose an Option
                    1. Add a book to the libary
                    2. Remove a book
                    3. Add an account
                    4. 
                    """);
                    AdminChoice = scanner.next().charAt(0);
                    scanner.nextLine();
                    if (AdminChoice == '1'){
                        System.out.print("please input a Book title: \n");
                        String bookTitle = scanner.nextLine();
                        scanner.nextLine();
                        System.out.print("please input a Book Author: \n");
                        String bookAuthor = scanner.nextLine();
                        scanner.nextLine();
                        System.out.println("please input the number of pages: \n");
                        int bookPages = scanner.nextInt();

                        Book book = new Book(bookTitle, bookPages, bookAuthor);
                        book.displayInfo();

                        System.out.println(book);
                    }


                    break;
            }
            else {
                    System.out.println("Error");
                }

        }
            }else if (logInChoice == '2') {
            System.out.println("option 2");
        }else{
            System.out.println("incorrect choice");
        }

scanner.close();
    }

}