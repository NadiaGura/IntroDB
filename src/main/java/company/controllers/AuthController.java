package company.controllers;

import company.login.Auth;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static company.dbhelper.DBConnection.getConnection;

public class AuthController {

    //initialize scanner
    private static Scanner sc = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    //METHOD TO AUNTH USER/ SIGN UP

    public static boolean signUpUser() {
        //prompt the user for data
        System.out.println("Please enter your username: ");
        String name = sc.next();

        System.out.println("Please enter your password: ");
        String password = sc.next();

        System.out.println("Are your user or admin?");
        String role = sc.next();

        try {
            //INSERT INTO users2(username, password,role) VALUES (username, password,role);
            ps = getConnection().prepareStatement("INSERT INTO users2(username, password,role) VALUES('" + name + "','" + password + "','" + role + "')");

            ps.execute(); //execute the sql command
            return true; //return true if successful
        } catch (SQLException e) {
            return false;
        }
    }


    //METHOD TO SIGN UP - CHECK WHETHER USER IS ALREADY REGISTERED,IF NOT -> PROCEED WITH signUpUser()

    public static Auth logInUser() {

        //promt user to enter the ID od the student they want to return

        System.out.println("Enter username.");
        String name = sc.nextLine();

        try {
            ps = getConnection().prepareStatement("SELECT * FROM users2 WHERE username = '" + name + "'");
            rs = ps.executeQuery();

            //instantiate the Auth object to return at the end of the method execution

            Auth auth = new Auth();

            if (rs.next() == Boolean.parseBoolean(null)) {
                System.out.println("No user found. You will be redirected to Sign Up page.");

                //if not registered,proceed with signUpUser() method

                signUpUser();
            } else {
                System.out.println("You are logged in into your account.");

            }


            //loop through the result set and add the necessary values in the Auth object

            while (rs.next()) {
                name = rs.getString("username");
                auth.setUsername(name);
            }
            return auth;

        } catch (SQLException ex) {
            return null;
        }
    }
}


