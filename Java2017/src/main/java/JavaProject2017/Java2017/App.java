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

		

      MongoConnection conn = new MongoConnection();
      
      System.out.println(Collections.usersList.size());
      System.out.println(Collections.projectsList.size());
      System.out.println(Collections.tasksList.size());
    }
}
