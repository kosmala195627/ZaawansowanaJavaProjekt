package Database.Models;

public class Project {

    private String _id;
    private String name;
    private String leaderId;

    public Project() {
    }

    public Project(String name, String leaderId) {
        this.name = name;
        this.leaderId = leaderId;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId;
    }

    @Override
    public String toString() {
        return "Project { _id: " + _id + ", name: " + name + ", leaderId: " + leaderId + " }";
    }
}
