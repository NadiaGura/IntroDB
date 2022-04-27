package company.objects;

public class Students {

    //properties
    private int id;
    private String name;
    private int age;


    //getters and setters

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }



    //constructor
    public Students(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age =- age;
    }

}
