package JavaProject2017.Java2017;


public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    
    public User () {
        
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
        return "User { id: " + id + ", firstName: " + firstName + ", lastName: " + lastName + ", login: " + login + ", password: " + password + " }";
    }
}