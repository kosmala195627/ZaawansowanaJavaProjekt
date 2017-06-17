package Database.Models;


public class Project {
    private String _id;
    private int projectId;
    private String name;
    private int leaderId;
    
    public Project () {}
    
    public Project(int projectId, String name, int leaderId) {
        this.projectId = projectId;
        this.name = name;
        this.leaderId = leaderId;
    }
    
    public String get_id () {
        return _id;
    }
    
    public void set_id (String _id) {
        this._id = _id;
    }
    
    public int getProjectId () {
        return projectId;
    }
    
    public void setProjectId (int projectId) {
        this.projectId = projectId;
    }
    
    public String getName () {
        return name;
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    public int getLeaderId () {
        return leaderId;
    }
    
    public void setLeaderId (int leaderId) {
        this.leaderId = leaderId;
    }
    
    @Override
    public String toString() {
        return "Project { _id: "+ _id + ", id: " + projectId + ", name: " + name + ", leaderId: " + leaderId + " }";
    }
}
