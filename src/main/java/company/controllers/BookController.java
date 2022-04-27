package company.controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static company.dbhelper.DBConnection.getConnection;

public class BookController {

    //initialize scanner
    private static Scanner sc2 = new Scanner(System.in);
    private static PreparedStatement ps2;
    private static ResultSet rs2;

    //METHOD TO ADD BOOK

    public  static boolean addBook() {
        //prompt the user for data
        System.out.println("Enter name of the Book : ");
        String bookName = sc2.nextLine();

        System.out.println("Enter price of the Book : ");
        int price = sc2.nextInt();

        try {
            //INSERT INTO books(name, price) VALUES ('name', price);
            ps2 = getConnection().prepareStatement("INSERT INTO books(name, price) VALUES('" + bookName + "', " + price + ")");

            ps2.execute(); //execute the sql command
            return true; //return true if successful
        } catch (SQLException ex2) {
            ex2.printStackTrace();
            return false;
        }
    }

    //METHOD TO DELETE BOOK

    public  static boolean deleteBook(){
        //prompt the user for data
        System.out.println("Enter the name of the Book you would like to delete : ");
        String bookName2 = sc2.next();

        try{
            //DELETE FROM books WHERE name = 'name';
            ps2 = getConnection().prepareStatement("DELETE FROM books WHERE name = '" + bookName2 + "'");

            ps2.execute(); //execute the sql command
            return true; //return true if successful
        }catch (SQLException ex2){
            ex2.printStackTrace();
            return false;
        }
    }

    //METHOD TO EDIT BOOKS NAME

    public  static boolean editBookName(){
        //prompt the user for data
        System.out.println("Enter the name of the Book you would like to edit : ");
        String oldBookName = sc2.next();
        System.out.println("Enter name you would like to add : ");
        String newNookName = sc2.next();

        try{
            //UPDATE books set name = 'newName' where name = 'oldName';
            ps2 = getConnection().prepareStatement("UPDATE books set name = '" + newNookName + "' WHERE name = '"+ oldBookName + "'");

            ps2.execute(); //execute the sql command
            return true; //return true if successful
        }catch (SQLException ex2){
            ex2.printStackTrace();
            return false;
        }
    }

    //METHOD EDIT PRICE IN BOOKS

    public  static boolean editBookPrice(){
        //prompt the user for data
        System.out.println("Enter the name of the Book you would like to change price for : ");
        String bName = sc2.next();
        System.out.println("Enter new price : ");
        String newPrice = sc2.next();

        try{
            //UPDATE books set price = new Price where name = 'stName';
            ps2 = getConnection().prepareStatement("UPDATE books set price = " + newPrice + " WHERE name = '"+ bName + "'");

            ps2.execute(); //execute the sql command
            return true; //return true if successful
        }catch (SQLException ex2){
            ex2.printStackTrace();
            return false;
        }
    }
}
