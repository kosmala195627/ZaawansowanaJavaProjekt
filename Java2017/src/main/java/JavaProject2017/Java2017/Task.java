package JavaProject2017.Java2017;

import java.util.Date;


public class Task {
    private String _id;
    private int taskId;
    private String name;
    private Date startDate;
    private Date endDate = null;
    private int projectId;
    private int managerId;
    private boolean status = false;
    
    public Task () {}
    
    public Task(int taskId, String name, Date startDate, Date endDate, int projectId, int managerId, boolean status) {
        
    }
    
    public String get_id () {
        return _id;
    }
    
    public void set_id (String _id) {
        this._id = _id;
    }
    
    public int getTaskId () {
        return taskId;
    }
    
    public void setTaskId (int taskId) {
        this.taskId = taskId;
    }
    
    public String getName () {
        return name;
    }
    
    public void setName (String name) {
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
    
    public void setProjectId (int projectId) {
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
    
    public void setStatus (boolean status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "Task { _id: "+ _id + ", taskId: " + taskId + ", name: " + name + ", startDate: " + startDate + ", endDate: " + endDate + ", projectId: " + projectId + ", managerId: " + managerId + ", status: " + status +" }";
    }
}
