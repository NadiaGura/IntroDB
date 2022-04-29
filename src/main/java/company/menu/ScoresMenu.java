package company.menu;

import company.controllers.BookController;
import company.controllers.ScoresController;

import java.util.Scanner;

public class ScoresMenu {

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do?: ");
        System.out.println("1. Add scores.");
//        System.out.println("2. Get student by ID.");
//        System.out.println("3. Edit scores.");
        System.out.println("2. DELETE scores.");


        System.out.println("Select an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println(ScoresController.addScore() ? "Successfully added scores." : "Scores not added!");
                break;
            case 2:
                System.out.println(ScoresController.deleteScores() ? "Successfully DELETED scores." : "Scores not DELETED!");
                break;

            default:
                System.out.println("Invalid option try again.");
                menu();
        }
    }
}
