package JavaProject2017.Java2017;

import GUI.Main;
import java.io.IOException;
import org.codehaus.jackson.map.JsonMappingException;

import Database.MongoConnection;
import Database.Models.User;

public class App 
{
    public static void main( String[] args ) throws JsonMappingException, IOException {
      
      MongoConnection conn = new MongoConnection();
      User user = new User(222221, "Jan", "Kowalski", "jkowalski", "1q2w3e4r");
      //conn.insertUser(user);
      //conn.readUsers();
      //conn.updateUsers("lastName", "Kowalski", "Nowak");
      conn.updateInDB(user.getClass(), "lastName", "Kowalski", "Nowak");
      conn.readUsers();
      //conn.removeFromDB(user.getClass(), user.getId());
      //conn.readUsers();
      new Main();
    }
}
