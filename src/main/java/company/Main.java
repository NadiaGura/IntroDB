package company;

import company.menu.BooksMenu;
import company.menu.StudentMenu;

public class Main {

    public static void main(String[] args) {

       //connection
        //DBConnection.getConnection();

        //StudentMenu.menu();
        BooksMenu.menu2();




/*

        //Array of Books
        List<Books> books = new ArrayList<>();
        books.add(new Books(1,"Hobbit",15));
        books.add(new Books(2,"Philosophy of Java",5));
        books.add(new Books(3,"Peter Pan",3));
        books.add(new Books(4,"Lord of Rings",20));
        books.add(new Books(5,"Castle",3));

        System.out.println(filterLessThanFive(books));
    }
    public static  List<String> filterLessThanFive(List<Books>books) {
//        //an anonymous function - lambda
//   books.removeIf(book -> book.getPrice() < 5);
//        return books;

        List<String> bookNames = new ArrayList<>();

        //if book price is less than 5, remove book from the List
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getPrice() < 5) books.remove(books.get(i));
        }

        //add each remaining book name to the bookName List.
        books.forEach(books1 -> bookNames.add(books1.getName()));

        //return List of bookNames
        return bookNames;

 */
    }
}
