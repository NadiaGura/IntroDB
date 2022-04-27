package company.menu;

import company.controllers.BookController;

import java.util.Scanner;

public class BooksMenu {

    public static void menu2(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do?: ");
        System.out.println("1. Add new Book.");
        System.out.println("2. Delete Book.");
        System.out.println("3. Change Book name.");
        System.out.println("4. Change Book price.");
        System.out.println("5. Get Book by ID.");

        System.out.println("Select an option: ");
        int option2 = scanner.nextInt();

        switch (option2){
            case  1:
                System.out.println(BookController.addBook() ? "Successfully added new Book." : "Book not added.");
                break;
            case  2:
                BookController.deleteBook();
                break;
            case  3:
                BookController.editBookName();
                break;
            case  4:
                BookController.editBookPrice();
                break;
            case  5:
                System.out.println(BookController.getBookById().getName());
                break;
            default:
                System.out.println("Invalid option try again.");
                menu2();
        }

    }
}
