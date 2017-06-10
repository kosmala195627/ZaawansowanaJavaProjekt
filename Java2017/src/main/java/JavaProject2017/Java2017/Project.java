package JavaProject2017.Java2017;


public class Project {
    private int projectId;
    private String name;
    private int leaderId;
    
    public Project() {
        
    }
    
    public int getProjectId () {
        return projectId;
    }
    
    public void setProjectId (int projectId) {
        this.projectId = projectId;
    }
    
    public String getProjectName () {
        return name;
    }
    
    public void setProjectName (String name) {
        this.name = name;
    }
    
    public int getLeaderId () {
        return leaderId;
    }
    
    public void setLeaderId (int leaderId) {
        this.leaderId = leaderId;
    }
}
