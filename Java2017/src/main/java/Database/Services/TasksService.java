package Database.Services;

import Database.Collections;
import org.codehaus.jackson.map.JsonMappingException;

import Database.MongoConnection;
import Database.Models.Task;
import GUI.RegistrationEvents;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TasksService {

    public TasksService() {

    }

    public Task[] getAllTasks() {
        Task[] result = new Task[Collections.tasksList.size()];
        return Collections.tasksList.toArray(result);
    }

    public String[] getAllTasks(Task[] tab) {
        String[] result = new String[tab.length];
        ArrayList<String> temp = new ArrayList<String>();
        for (Task x : tab) {
            temp.add(x.getName());
        }
        return temp.toArray(result);
    }

    public void addNewTask(String name, Date startDate, Date endDate, String projectId, String managerId) {
        Task task = new Task(name, startDate, endDate, projectId, managerId);

        try {
            new MongoConnection().insertTask(task);
        } catch (JsonMappingException ex) {
            Logger.getLogger(RegistrationEvents.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RegistrationEvents.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
