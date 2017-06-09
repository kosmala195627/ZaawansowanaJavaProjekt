package JavaProject2017.Java2017;

import java.io.File;
import java.io.IOException;

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
      User student1 = tester.readJSON();
      System.out.println(student1);
      
      MongoConnection conn = new MongoConnection();
    }
}
