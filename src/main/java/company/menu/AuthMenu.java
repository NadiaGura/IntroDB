package company.menu;

import company.controllers.AuthController;
import company.controllers.StudentController;

import java.sql.SQLException;
import java.util.Scanner;

public class AuthMenu {

    public static void menu() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to do?: ");
        System.out.println("1. Register as new user.");
        System.out.println("2. LogIn into your account.");


        System.out.println("Select an option: ");
        int option = sc.nextInt();

        switch (option) {
            case 1:
                System.out.println(AuthController.signUpUser() ? "Successfully added new user." : "User not added!");
                break;
            case 2:
                System.out.println(AuthController.logInUser().getUsername());
                break;
            default:
                System.out.println("Invalid option try again!");
                menu();
        }
    }
}