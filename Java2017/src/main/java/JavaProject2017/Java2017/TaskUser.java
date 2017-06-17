package JavaProject2017.Java2017;

public class TaskUser {
    private String _id;
    private int userId;
    private int taskId;
    
    public TaskUser () {}
    
    public TaskUser (int userId, int taskId) {
        this.userId = userId;
        this.taskId = taskId;
    }
    
    public String get_id () {
        return _id;
    }
    
    public void set_id (String _id) {
        this._id = _id;
    }
    
    public int getUserId () {
        return userId;
    }
    
    public void setuUserId (int userId) {
        this.userId = userId;
    }
    
    public int getTaskId () {
        return taskId;
    }
    
    public void setTaskId (int taskId) {
        this.taskId = taskId;
    }
    
    @Override
    public String toString() {
        return "TaskUser { _id: "+ _id + ", userId: " + userId + ", taskId: " + taskId + " }";
    }
}
