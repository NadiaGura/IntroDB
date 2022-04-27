package company.menu;

import company.controllers.StudentController;

import java.util.Scanner;

public class StudentMenu {

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to do?: ");
        System.out.println("1. Add a new student");
        System.out.println("2. Delete student.");
        System.out.println("3. Change student name.");
        System.out.println("4. Change student age.");
        System.out.println("5. Get student by ID.");

        System.out.println("Select an option: ");
        int option = sc.nextInt();

        switch (option) {
            case 1:
                System.out.println(StudentController.addStudent() ? "Successfully added new Student." : "Student not added!");
                break;
            case 2:
                System.out.println(StudentController.deleteStudent() ? "Successfully deleted Student." : "Student not deleted!");
                break;
            case 3:
                StudentController.editStudentName();
                break;
            case 4:
                StudentController.editStudentAge();
                break;
            case 5:
                System.out.println(StudentController.getStudentById().getName());
                break;
            default:
                System.out.println("Invalid option try again!");
                menu();
        }
    }
}
