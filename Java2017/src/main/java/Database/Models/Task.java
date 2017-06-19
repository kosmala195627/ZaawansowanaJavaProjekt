package Database.Models;

import java.util.Date;


public class Task {
    private String _id;
    private String name;
    private Date startDate;
    private Date endDate = null;
    private String projectId;
    private String managerId;
    private boolean status = false;
    
    public Task () {}
    
    public Task(String name, Date startDate, Date endDate, String projectId, String managerId) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectId = projectId;
        this.managerId = managerId;
    }
    
    public String get_id () {
        return _id;
    }
    
    public void set_id (String _id) {
        this._id = _id;
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
    
    public String getProjectId () {
        return projectId;
    }
    
    public void setProjectId (String projectId) {
        this.projectId = projectId;
    }
    
    public String getManagerId () {
        return managerId;
    }
    
    public void setManagerId (String managerId) {
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
        return "Task { _id: "+ _id + ", name: " + name + ", startDate: " + startDate + ", endDate: " + endDate + ", projectId: " + projectId + ", managerId: " + managerId + ", status: " + status +" }";
    }
}
