package company.login;

public class Auth {
    //Authentication - method to sign up users on this student management platform.

    //create table users that have the following field with the following properties
    // (id serial, primary key;username varchar(255),unique;password varchar(255),role varchar(255))

    //Each user shall have password,username,role.
    //Role is to be one of two items - admin/user.
    //validate it such that anything else that is entered i snot passed into db.
    //Make the username unique as well on your table(you can choose to make the username an email instead).

private int id;//serial pk
    private String username;//unique
    private String password;
    private String role; //admin/user

    //empty constructor
    public Auth(){

    }

    //getters setters
    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }





}
