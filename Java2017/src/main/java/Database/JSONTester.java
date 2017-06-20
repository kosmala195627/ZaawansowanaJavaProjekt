package Database;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import Database.Models.Project;
import Database.Models.Task;
import Database.Models.TaskUser;
import Database.Models.User;

public class JSONTester {

    public void writeJSON(User student) throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString;
        jsonString = mapper.writeValueAsString(student);
        System.out.println("jsonString: " + jsonString);
    }

    public User readUsersJSON(String jsonString) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        User student = mapper.readValue(replaceString(jsonString), User.class);
        System.out.println(student.toString());
        Collections.usersList.add(student);
        return student;
    }

    public Project readProjectsJSON(String jsonString) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Project project = mapper.readValue(replaceString(jsonString), Project.class);
        System.out.println(project.toString());
        Collections.projectsList.add(project);
        return project;
    }

    public Task readTasksJSON(String jsonString) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Task task = mapper.readValue(replaceString(jsonString), Task.class);
        System.out.println(task.toString());
        Collections.tasksList.add(task);
        return task;
    }

    public TaskUser readTasksUsersJSON(String jsonString) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        TaskUser taskUser = mapper.readValue(replaceString(jsonString), TaskUser.class);
        System.out.println(taskUser.toString());
        Collections.tasksUsersList.add(taskUser);
        return taskUser;
    }

    public String replaceString(String value) {
        value = value.replace(" { \"$oid\" : ", " ");
        value = value.replace("} ,", " ,");
        return value;
    }
}
