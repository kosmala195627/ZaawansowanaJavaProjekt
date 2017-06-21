package Database;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

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
    }

    public User readUsersJSON(String jsonString) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        User student = mapper.readValue(replaceString(jsonString), User.class);
        Collections.usersList.add(student);
        return student;
    }

    public Project readProjectsJSON(String jsonString) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Project project = mapper.readValue(replaceString(jsonString), Project.class);
        Collections.projectsList.add(project);
        return project;
    }

    public Task readTasksJSON(String jsonString) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Task task = mapper.readValue(replaceString(jsonString), Task.class);
        Date startDate = new Date(task.getStartDate().getTime());
        Date endDate = new Date(task.getEndDate().getTime());
        startDate.setHours(0);
        endDate.setHours(0);
        task.setStartDate(startDate);
        task.setEndDate(endDate);
        Collections.tasksList.add(task);
        return task;
    }

    public TaskUser readTasksUsersJSON(String jsonString) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        TaskUser taskUser = mapper.readValue(replaceString(jsonString), TaskUser.class);
        Collections.tasksUsersList.add(taskUser);
        return taskUser;
    }

    public String replaceString(String value) {
        value = value.replace(" { \"$oid\" : ", " ");
        value = value.replace("} ,", " ,");
        value = value.replace("{\"$oid\":"," ");
        value = value.replace("},"," ,");
        return value;
    }
}
