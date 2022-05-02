package company.controllers;

import company.books.Authors;
import company.books.Books;
import company.objects.Students;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static company.dbhelper.DBConnection.getConnection;

public class BookController {

    //initialize scanner
    private static Scanner sc = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    //METHOD TO ADD BOOK

    public static boolean addBook() {
        //prompt the user for data
        System.out.println("Enter name of the Book : ");
        String bookName = sc.nextLine();

        System.out.println("Enter price of the Book : ");
        int price = sc.nextInt();

        try {
            //INSERT INTO books(name, price) VALUES ('name', price);
            ps = getConnection().prepareStatement("INSERT INTO books(name, price) VALUES('" + bookName + "', " + price + ")");

            ps.execute(); //execute the sql command
            return true; //return true if successful
        } catch (SQLException ex2) {
            System.out.println("Database Error!");
            return false;
        }
    }

    //METHOD TO DELETE BOOK

    public static boolean deleteBook() {
        //prompt the user for data
        System.out.println("Enter the name of the Book you would like to delete : ");
        String bookName2 = sc.next();

        try {
            //DELETE FROM books WHERE name = 'name';
            ps = getConnection().prepareStatement("DELETE FROM books WHERE name = '" + bookName2 + "'");

            ps.execute(); //execute the sql command
            return true; //return true if successful
        } catch (SQLException ex2) {
            //ex2.printStackTrace();
            return false;
        }
    }

    //METHOD TO EDIT BOOKS NAME

    public static boolean editBookName() {
        //prompt the user for data
        System.out.println("Enter the name of the Book you would like to edit : ");
        String oldBookName = sc.next();
        System.out.println("Enter name you would like to add : ");
        String newNookName = sc.next();

        try {
            //UPDATE books set name = 'newName' where name = 'oldName';
            ps = getConnection().prepareStatement("UPDATE books set name = '" + newNookName + "' WHERE name = '" + oldBookName + "'");

            ps.execute(); //execute the sql command
            return true; //return true if successful
        } catch (SQLException ex2) {
            //ex2.printStackTrace();
            return false;
        }
    }

    //METHOD EDIT PRICE IN BOOKS

    public static boolean editBookPrice() {
        //prompt the user for data
        System.out.println("Enter the name of the Book you would like to change price for : ");
        String bName = sc.next();
        System.out.println("Enter new price : ");
        String newPrice = sc.next();

        try {
            //UPDATE books set price = new Price where name = 'stName';
            ps = getConnection().prepareStatement("UPDATE books set price = " + newPrice + " WHERE name = '" + bName + "'");

            ps.execute(); //execute the sql command
            return true; //return true if successful
        } catch (SQLException ex2) {
            //ex2.printStackTrace();
            return false;
        }
    }

    //GET STUDENT BY ID CONTROLLER

    public static Books getBookById() {
        //promt user to enter the ID od the student they want to return
        System.out.println("Enter the ID of the Book.");
        int idBook = sc.nextInt();

        try {
            ps = getConnection().prepareStatement("SELECT * FROM books WHERE id = " + idBook);
            rs = ps.executeQuery();

            //define var to temporarily hold each field in the result set.
            int bookid, price;
            String name;

            //instantiate the student objet to return at the end of the method execution
            Books books1 = new Books();

            //loop through the result set and add the necessary values in the student object
            while (rs.next()) {
                bookid = rs.getInt("id");
                name = rs.getString("name");
                price = rs.getInt("price");
                books1.setName(name);
                books1.setId(bookid);
                books1.setPrice(price);
            }
            return books1;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    //METHOD TO ADD AUTHOR BY ID/NAME

    public static boolean addAuthor() {
        //prompt the user for data
        System.out.println("Enter Books ID : ");
        String bookID = sc.nextLine();

        System.out.println("Enter books author : ");
        String authorName = sc.nextLine();
        System.out.println("Enter authors age in order to complete table: ");
        int authorAge = sc.nextInt();

        try {
            //INSERT INTO authors(bookid,name, age) VALUES ('name', age);
            ps = getConnection().prepareStatement("INSERT INTO authors(bookid,name, age) VALUES("+bookID+",'" + authorName + "'," + authorAge + ")");

            ps.execute(); //execute the sql command
            return true; //return true if successful
        } catch (SQLException ex2) {
            System.out.println("Database Error!");
            return false;
        }
    }

    //METHOD TO DELETE BOOKS AUTHOR

    public static boolean deleteAuthor() {
        //prompt the user for data
        System.out.println("Enter Books ID you would like to delete Author for: ");
        String bookID = sc.next();

        try {
            //DELETE FROM authors WHERE bookid = 'bookid';
            ps = getConnection().prepareStatement("DELETE FROM authors WHERE bookid = " + bookID);

            ps.execute(); //execute the sql command
            return true; //return true if successful
        } catch (SQLException ex2) {
            //ex2.printStackTrace();
            return false;
        }
    }

    //METHOD TO EDIT AUTHORS NAME BY NAME/ID

    public static boolean editAuthors() {
        //prompt the user for data
        System.out.println("Enter the name of the Author you would like to change name for: ");
        String aName = sc.next();
        System.out.println("Enter new name: ");
        String newName = sc.next();

        try {
            //UPDATE authors set name = newName where name = 'oldName';
            ps = getConnection().prepareStatement("UPDATE authors set name = '" + newName + "' WHERE name = '" + aName + "'");

            ps.execute(); //execute the sql command
            return true; //return true if successful
        } catch (SQLException ex2) {
            //ex2.printStackTrace();
            return false;
        }
    }
    //GET AUTHOR BY ID

    public static Authors getAuthorById() {
        //promt user to enter the ID od the student they want to return
        System.out.println("Enter the ID of the Book.");
        int idBook = sc.nextInt();

        try {
            ps = getConnection().prepareStatement("SELECT * FROM authors WHERE bookid = " + idBook);
            rs = ps.executeQuery();

            //define var to temporarily hold each field in the result set.
            int bookid, age;
            String nameAut;

            //instantiate the student objet to return at the end of the method execution
            Authors author = new Authors();

            //loop through the result set and add the necessary values in the student object
            while (rs.next()) {
                bookid = rs.getInt("id");
                nameAut = rs.getString("name");
                age = rs.getInt("age");
                author.setName(nameAut);
                author.setId(bookid);
                author.setAge(age);
            }
            return author;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
