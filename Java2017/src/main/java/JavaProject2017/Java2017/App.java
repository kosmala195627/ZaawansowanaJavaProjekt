package JavaProject2017.Java2017;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


public class App 
{
    public static void main( String[] args ) throws JsonMappingException, IOException {
      
        JSONTester tester = new JSONTester();
		
      User student = new User();
      student.setId(195690);
      student.setFirstName("Karolina");
      student.setLastName("Pryk");
      tester.writeJSON(student);
      //String jsonString = "{\"id\":195690,\"firstName\":\"Karolina\",\"lastName\":\"Pryk\"}";
      //User student1 = tester.readJSON(jsonString);
      //System.out.println(student1);
      
      MongoConnection conn = new MongoConnection();
      
      List<User> usersList = new ArrayList<User>();
      List<Project> projectsList = new ArrayList<Project>();
      List<Task> tasksList = new ArrayList<Task>();
    }
}
