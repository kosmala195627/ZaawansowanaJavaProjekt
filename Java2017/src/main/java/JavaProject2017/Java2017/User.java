package JavaProject2017.Java2017;


public class User {
    private int id;
    private String firstName;
    private String lastName;
    
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

    @Override
    public String toString() {
        return "User { id: " + id + ", firstName: " + firstName + ", lastName: " + lastName + " }";
    }
}