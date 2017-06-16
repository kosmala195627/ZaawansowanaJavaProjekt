package JavaProject2017.Java2017;

import GUI.Main;
import GUI.Users;
import java.io.IOException;
import org.codehaus.jackson.map.JsonMappingException;

public class App 
{
    public static void main( String[] args ) throws JsonMappingException, IOException {

      new Main();
      
      MongoConnection conn = new MongoConnection();
      
      conn.insertUser(222221, "Jan", "Kowalski", "jkowalski", "1q2w3e4r");
      conn.readUsers();
      conn.updateUsers("lastName", "Kowalski", "Nowak");
      conn.readUsers();
      conn.removeUser(222221);
      conn.readUsers();
      new Users();
    }
}
