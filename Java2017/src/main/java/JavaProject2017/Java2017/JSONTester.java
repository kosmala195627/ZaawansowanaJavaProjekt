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
      String jsonString = "{\"id\":195690,\"firstName\":\"Karolina\",\"lastName\":\"Pryk\"}";
     jsonString = mapper.writeValueAsString(student);
     System.out.println("jsonString: " + jsonString);
   }

   public User readJSON() throws JsonParseException, JsonMappingException, IOException{
      ObjectMapper mapper = new ObjectMapper();
      String jsonString = "{\"id\":195690,\"firstName\":\"Karolina\",\"lastName\":\"Pryk\"}";
      User student = student = mapper.readValue(jsonString, User.class);;
      return student;
   }
}
