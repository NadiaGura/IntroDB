package company.menu;

import company.controllers.StudentController;
import company.objects.Students;

import java.util.Scanner;

public class StudentMenu {

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to do?: ");
        System.out.println("1. Add a new student");
        System.out.println("2. Delete student.");
        System.out.println("3. Delete student with all data.");
        System.out.println("4. Change student name.");
        System.out.println("5. Change student age.");
        System.out.println("6. Get student by ID.");
        System.out.println("7. Add student scores.");
        System.out.println("8. Delete student scores.");
        System.out.println("9. Delete student data and scores.");


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
                System.out.println(StudentController.deleteStudent(sc.nextInt()) ? "Successfully deleted ALL Student data." : "Student data not deleted!");
                break;
            case 4:
                StudentController.editStudentName();
                break;
            case 5:
                StudentController.editStudentAge();
                break;
            case 6:
                System.out.println(StudentController.getStudentById().getName());
                break;
            case 7:
                System.out.println(StudentController.addScores()? "Successfully added Student scores." : "Student scores are not added!");
                break;
            case 8:
                System.out.println(StudentController.deleteScore()? "Successfully deleted Student scores." : "Student scores are not deleted!");
                break;
            case 9:
                System.out.println(StudentController.deleteScore(sc.nextInt())? "Successfully deleted Student data." : "Student data is not deleted!");
                break;
            default:
                System.out.println("Invalid option try again!");
                menu();
        }
    }
}
