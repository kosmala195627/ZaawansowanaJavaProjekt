package Database;

import java.util.ArrayList;
import java.util.List;

import Database.Models.Project;
import Database.Models.Task;
import Database.Models.TaskUser;
import Database.Models.User;

public class Collections {

    static public List<User> usersList = new ArrayList<User>();
    static public List<Project> projectsList = new ArrayList<Project>();
    static public List<Task> tasksList = new ArrayList<Task>();
    static public List<TaskUser> tasksUsersList = new ArrayList<TaskUser>();
}
