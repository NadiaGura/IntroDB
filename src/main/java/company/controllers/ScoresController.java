package company.controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static company.dbhelper.DBConnection.getConnection;

public class ScoresController {

    //initialize scanner
    private static Scanner sc = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    //METHOD TO ADD SCORE

    public static boolean addScore() {
        //prompt the user for data
//        System.out.println("Enter name of the Student : ");
//        String studentName = sc.nextLine();
        System.out.println("Enter id of the Student: ");
        int studentId = sc.nextInt();

        System.out.println("Enter scores for Math: ");
        int mathScore = sc.nextInt();
        System.out.println("Enter scores for English: ");
        int engScore = sc.nextInt();
        System.out.println("Enter scores for Physics: ");
        int physScore = sc.nextInt();
        System.out.println("Enter scores for Chemistry: ");
        int chemScore = sc.nextInt();

        try {
            //INSERT INTO scores(studentid,mathematics,english,physics,chemistry)VALUES(idValues, scoresValues);
            ps = getConnection().prepareStatement("INSERT INTO scores(studentid,mathematics,english,physics,chemistry)VALUES(" + studentId + "," + mathScore + "," + engScore + "," + physScore + "," + chemScore + ")");

            ps.execute(); //execute the sql command
            return true; //return true if successful
        } catch (SQLException ex2) {
            System.out.println("Database Error!");
            return false;
        }
    }

    //METHOD TO DELETE SCORES by studentid

    public static boolean deleteScores() {
        //prompt the user for data
        System.out.println("Enter students id: ");
        int id = sc.nextInt();

        try {
            //DELETE FROM scores WHERE id = idEntered;
            ps = getConnection().prepareStatement("DELETE from scores WHERE studentid =" + id );

            ps.execute(); //execute the sql command
            return true; //return true if successful
        } catch (SQLException ex) {
            //ex.printStackTrace();
            return false;
        }
    }

}
