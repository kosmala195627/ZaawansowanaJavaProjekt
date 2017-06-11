package JavaProject2017.Java2017;

import java.util.Date;


public class Task {
    private int taskId;
    private String name;
    private Date startDate;
    private Date endDate;
    private int projectId;
    private int managerId;
    private boolean status = false;
    
    public Task() {
        
    }
    
    public int getTaskId () {
        return taskId;
    }
    
    public void setTaskId (int taskId) {
        this.taskId = taskId;
    }
    
    public String getTaskName () {
        return name;
    }
    
    public void setTaskName (String name) {
        this.name = name;
    }
    
    public Date getStartDate () {
        return startDate; 
    }
    
    public void setStartDate (Date startDate) {
        this.startDate = startDate;
    }
    
    public Date getEndDate () {
        return endDate; 
    }
    
    public void setEndDate (Date endDate) {
        this.endDate = endDate;
    }
    
    public int getProjectId () {
        return projectId;
    }
    
    public void setprojectId (int projectId) {
        this.projectId = projectId;
    }
    
    public int getManagerId () {
        return managerId;
    }
    
    public void setManagerId (int managerId) {
        this.managerId = managerId;
    }
    
    public boolean getStatus () {
        return status;
    }
    
    public void setStatus (boolean ststus) {
        this.status = ststus;
    }
}
