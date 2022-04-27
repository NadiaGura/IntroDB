package company.books;

import java.util.List;

public class Books {

    //properties
    private int id;
    private String name;
    private int price;

    // empty constructor
    public Books() {

    }

    //constructor
    public Books(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    //getters and setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }


}
