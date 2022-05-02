package company.menu;

import company.controllers.BookController;

import java.util.Scanner;

public class BooksMenu {

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do?: ");
        System.out.println("1. Add new Book.");
        System.out.println("2. Delete Book.");
        System.out.println("3. Change Book name.");
        System.out.println("4. Change Book price.");
        System.out.println("5. Get Book by ID.");
        System.out.println("6. Add author by ID/Name.");
        System.out.println("7. Delete author by ID/Name.");
        System.out.println("8. Update author by ID/Name.");
        System.out.println("9. Get Author by Book ID.");

        System.out.println("Select an option: ");
        int option2 = scanner.nextInt();

        switch (option2) {
            case 1:
                System.out.println(BookController.addBook() ? "Successfully added new Book." : "Book not added!");
                break;
            case 2:
                System.out.println(BookController.deleteBook() ? "Successfully deleted Book." : "Book is not deleted!");
                break;
            case 3:
                System.out.println(BookController.editBookName() ? "Successfully edited book name." : "Book name is not edited!");
                break;
            case 4:
                System.out.println(BookController.editBookPrice() ? "Successfully edited book price." : "Books price is not edited!");
                break;
            case 5:
                System.out.println(BookController.getBookById().getName());
                break;
            case 6:
                System.out.println(BookController.addAuthor()? "Successfully added books Author." : "Author not added!");
                break;
            case 7:
                System.out.println(BookController.deleteAuthor()? "Successfully deleted books Author." : "Author not deleted!");
                break;
            case 8:
                System.out.println(BookController.editAuthors()? "Successfully edited books Author." : "Authors name not edited!");
                break;
            case 9:
                System.out.println(BookController.getAuthorById().getName());
                break;
            default:
                System.out.println("Invalid option try again.");
                menu();
        }
    }
}
