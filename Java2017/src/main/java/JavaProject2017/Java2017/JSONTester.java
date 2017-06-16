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

   public User readUsersJSON(String jsonString) throws JsonParseException, JsonMappingException, IOException{
      ObjectMapper mapper = new ObjectMapper();
      jsonString = jsonString.replace(" { \"$oid\" : "," ");
      jsonString = jsonString.replace("} ,"," ,");
      User student = mapper.readValue(jsonString, User.class);;
      System.out.println(student.toString());
      Collections.usersList.add(student);
      return student;
   }
   
   public Project readProjectsJSON(String jsonString) throws JsonParseException, JsonMappingException, IOException{
      ObjectMapper mapper = new ObjectMapper();
      jsonString = jsonString.replace(" { \"$oid\" : "," ");
      jsonString = jsonString.replace("} ,"," ,");
      Project project = mapper.readValue(jsonString, Project.class);
      System.out.println(project.toString());
      Collections.projectsList.add(project);
      return project;
   }
   
   public Task readTasksJSON(String jsonString) throws JsonParseException, JsonMappingException, IOException{
      ObjectMapper mapper = new ObjectMapper();
      jsonString = jsonString.replace(" { \"$oid\" : "," ");
      jsonString = jsonString.replace("} ,"," ,");
      Task task = mapper.readValue(jsonString, Task.class);
      System.out.println(task.toString());
      Collections.tasksList.add(task);
      return task;
   }
}
