package GUI;

import Database.Collections;
import Database.Models.Task;
import Database.Models.User;
import Database.Services.TasksService;
import Database.Services.UsersService;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class TableOfTasks extends DefaultTableModel implements ITable {

    UsersService usersService = new UsersService();
    TasksService taskService = new TasksService();
    
    public TableOfTasks() {
        this.addColumn("Task name");
        this.addColumn("Status");
        this.addColumn("End Date");
        this.addColumn("Responsible person");
    }

    public void add() {
        for (Task x : Collections.tasksList) {
            Object[] a = {x.getName(), taskService.returnTaskStatus(x.getStatus()), x.getEndDate(), usersService.returnUserName(x.getManagerId())};
            this.addRow(a);
        }
    }
    
    public void add(String id) {
        List<Task> tasksOfProject = new ArrayList<Task>();
        for (Task x : Collections.tasksList) {
            if(x.getProjectId().equals(id)) {
                tasksOfProject.add(x);
            }
        }
        for (Task x : tasksOfProject) {
            Object[] a = {x.getName(), taskService.returnTaskStatus(x.getStatus()), x.getEndDate(), usersService.returnUserName(x.getManagerId())};
            this.addRow(a);
        }
    }


    

}
