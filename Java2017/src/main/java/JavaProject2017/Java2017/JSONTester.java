package JavaProject2017.Java2017;

import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


public class JSONTester {
    
        
    public void writeJSON(User student) throws JsonGenerationException, JsonMappingException, IOException{
      ObjectMapper mapper = new ObjectMapper();	
      String jsonString;
     jsonString = mapper.writeValueAsString(student);
     System.out.println("jsonString: " + jsonString);
   }

   public User readJSON(String jsonString) throws JsonParseException, JsonMappingException, IOException{
      ObjectMapper mapper = new ObjectMapper();
      User student = student = mapper.readValue(jsonString, User.class);;
      return student;
   }
}
