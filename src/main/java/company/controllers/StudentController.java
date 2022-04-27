package company.controllers;

import company.objects.Students;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static company.dbhelper.DBConnection.getConnection;

public class StudentController {

    //initialize scanner
    private static Scanner sc = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    //Add student controller
    public  static boolean addStudent() {
        //prompt the user for data
        System.out.println("Enter the name of the student : ");
        String name = sc.next();

        System.out.println("Enter the age of the student : ");
        int age = sc.nextInt();

        try {
            //INSERT INTO students(name, age) VALUES ('name', age);
            ps = getConnection().prepareStatement("INSERT INTO students(name, age) VALUES('" + name + "', " + age + ")");

            ps.execute(); //execute the sql command
            return true; //return true if successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

            //method to delete student
    public  static boolean deleteStudent(){
        //prompt the user for data
        System.out.println("Enter the name of the student you would like to delete : ");
        String name2 = sc.next();

        try{
            //DELETE FROM students WHERE name = name;
            ps = getConnection().prepareStatement("DELETE FROM students WHERE name = '" + name2 + "' ");

            ps.execute(); //execute the sql command
            return true; //return true if successful
        }catch (SQLException ex){
            ex.printStackTrace();
            return false;
        }
        }
    //method to edit student name
    public  static boolean editStudentName(){
        //prompt the user for data
        System.out.println("Enter the name of the student you would like to edit : ");
        String name3 = sc.next();
        System.out.println("Enter name you would like to add : ");
        String name4 = sc.next();

        try{
            //UPDATE students set name = 'newName' where name = 'oldName';
            ps = getConnection().prepareStatement("UPDATE students set name = '" + name4 + "' WHERE name = '"+ name3 + "'");

            ps.execute(); //execute the sql command
            return true; //return true if successful
        }catch (SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }

    //method to edit student age

    public  static boolean editStudentAge(){
        //prompt the user for data
        System.out.println("Enter the name of the student you would like to edit age for : ");
        String stName = sc.next();
        System.out.println("Enter age you would like to add : ");
        String newAge = sc.next();

        try{
            //UPDATE students set age = 'newAge' where name = 'stName';
            ps = getConnection().prepareStatement("UPDATE students set age = '" + newAge + "' WHERE name = '"+ stName + "'");

            ps.execute(); //execute the sql command
            return true; //return true if successful
        }catch (SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }

    //GET STUDENT BY ID CONTROLLER
    public static Students getStudentById(){
        //promt user to enter the ID od the student they want to return
        System.out.println("Enter the ID of the Student");
        int id = sc.nextInt();

        try{
            ps = getConnection().prepareStatement("SELECT * FROM students WHERE id = "+ id);
            rs = ps.executeQuery();

            //define var to temporarily hold each field in the result set.
            int studid,age;
            String name;

            //instantiate the student objet to return at the end of the method execution
            Students student1 = new Students();

            //loop through the result set and add the necessary values in the student object
            while (rs.next()){
                studid = rs.getInt("id");
                name = rs.getString("name");
                age = rs.getInt("age");
                student1.setName(name);
                student1.setId(studid);
                student1.setAge(age);
            }
            return student1;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    }

