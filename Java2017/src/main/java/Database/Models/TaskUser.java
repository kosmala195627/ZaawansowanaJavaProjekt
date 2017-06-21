package Database.Models;

public class TaskUser {

    private String _id;
    private String userId;
    private String taskId;

    public TaskUser() {
    }

    public TaskUser(String userId, String taskId) {
        this.userId = userId;
        this.taskId = taskId;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUserId() {
        return userId;
    }

    public void setuUserId(String userId) {
        this.userId = userId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return "TaskUser { _id: " + _id + ", userId: " + userId + ", taskId: " + taskId + " }";
    }
}
