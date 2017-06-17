package Database.Models;


public class User {
    private String _id;
    private int id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    
    public User () {}
    
    public User (int id, String firstName, String lastName, String login, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
    }
    
    public String get_id () {
        return _id;
    }
    
    public void set_id (String _id) {
        this._id = _id;
    }
    
    public int getId () {
        return id;
    }
    
    public void setId (int id) {
        this.id = id;
    }
    
    public String getFirstName () {
        return firstName;
    }
    
    public void setFirstName (String fName) {
        this.firstName = fName;
    }
    
    public String getLastName () {
        return lastName;
    }
    
    public void setLastName (String lName) {
        this.lastName = lName;
    }
    
    public String getLogin () {
        return login;
    }
    
    public void setLogin (String login) {
        this.login = login;
    }
    
    public String getPassword () {
        return password;
    }
    
    public void setPassword (String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User { _id: "+ _id + ", id: " + id + ", firstName: " + firstName + ", lastName: " + lastName + ", login: " + login + ", password: " + password + " }";
    }
}