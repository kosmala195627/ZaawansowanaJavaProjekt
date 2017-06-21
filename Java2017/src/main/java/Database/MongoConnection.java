package Database;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

import Database.Models.Project;
import Database.Models.Task;
import Database.Models.TaskUser;
import Database.Models.User;

import java.io.IOException;
import java.net.UnknownHostException;
import org.codehaus.jackson.map.JsonMappingException;

public class MongoConnection {

    private DBCollection usersCollection, projectsCollection, tasksCollection, tasksUsersCollection;
    JSONTester test = new JSONTester();
    MongoClient mongo = new MongoClient("localhost", 27017);
    DB db = mongo.getDB("Java2017");

    public MongoConnection() throws UnknownHostException, JsonMappingException, IOException {
        try {
            readUsers();
            readProjects();
            readTasks();
            readTasksUsers();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    /**
     * * ** Read from DB ***
     */
    public void readUsers() throws JsonMappingException, IOException {
        usersCollection = db.getCollection("users");
        DBCursor cursor1 = usersCollection.find();
        while (cursor1.hasNext()) {
            DBObject obj = cursor1.next();
            test.readUsersJSON(obj.toString());
        }
    }

    public void readProjects() throws JsonMappingException, IOException {
        projectsCollection = db.getCollection("projects");
        DBCursor cursor2 = projectsCollection.find();
        while (cursor2.hasNext()) {
            DBObject obj = cursor2.next();
            test.readProjectsJSON(obj.toString());
        }
    }

    public void readTasks() throws JsonMappingException, IOException {
        tasksCollection = db.getCollection("tasks");
        DBCursor cursor3 = tasksCollection.find();
        while (cursor3.hasNext()) {
            DBObject obj = cursor3.next();
            test.readTasksJSON(obj.toString());
        }
    }
    
    public void readTasksUsers() throws JsonMappingException, IOException {
        tasksUsersCollection = db.getCollection("taskUsers");
        DBCursor cursor3 = tasksUsersCollection.find();
        while (cursor3.hasNext()) {
            DBObject obj = cursor3.next();
            test.readTasksUsersJSON(obj.toString());
        }
    }

    /**
     * * ** Insert new data to DB***
     */
    public void insertUser(User user) throws IOException {
        Collections.usersList.clear();
        BasicDBObject document = new BasicDBObject();
        document.put("firstName", user.getFirstName());
        document.put("lastName", user.getLastName());
        document.put("login", user.getLogin());
        document.put("password", user.getPassword());
        usersCollection.insert(document);
        readUsers();
    }

    public void insertProject(Project project) throws IOException {
        Collections.projectsList.clear();
        BasicDBObject document = new BasicDBObject();
        document.put("name", project.getName());
        document.put("leaderId", project.getLeaderId());
        projectsCollection.insert(document);
        readProjects();
    }

    public void insertTask(Task task) throws IOException {
        Collections.tasksList.clear();
        BasicDBObject document = new BasicDBObject();
        document.put("name", task.getName());
        document.put("startDate", task.getStartDate());
        document.put("endDate", task.getEndDate());
        document.put("projectId", task.getProjectId());
        document.put("managerId", task.getManagerId());
        document.put("status", task.getStatus());
        tasksCollection.insert(document);
        readTasks();
    }
    
    public void insertTaskUser(TaskUser taskUser) throws IOException {
        Collections.tasksUsersList.clear();
        BasicDBObject document = new BasicDBObject();
        document.put("userId", taskUser.getUserId());
        document.put("taskId", taskUser.getTaskId());
        tasksUsersCollection.insert(document);
        readTasksUsers();
    }

    /**
     * * ** Update data in DB***
     */
    public <T> void updateInDB(Class<T> obj, String whichField, String oldValue, String newValue) throws IOException {
        BasicDBObject query = new BasicDBObject();
        BasicDBObject newDocument = new BasicDBObject();
        BasicDBObject updateObj = new BasicDBObject();

        if (obj.isAssignableFrom(User.class)) {
            Collections.usersList.clear();
            query.put(whichField, oldValue);
            newDocument.put(whichField, newValue);
            updateObj.put("$set", newDocument);
            usersCollection.update(query, updateObj);
            readUsers();
        } else if (obj.isAssignableFrom(Project.class)) {
            Collections.projectsList.clear();
            query.put(whichField, oldValue);
            newDocument.put(whichField, newValue);
            updateObj.put("$set", newDocument);
            projectsCollection.update(query, updateObj);
            readProjects();
        } else if (obj.isAssignableFrom(Task.class)) {
            Collections.tasksList.clear();
            query.put(whichField, oldValue);
            newDocument.put(whichField, newValue);
            updateObj.put("$set", newDocument);
            tasksCollection.update(query, updateObj);
            readTasks();
        } else if (obj.isAssignableFrom(TaskUser.class)) {
            Collections.tasksUsersList.clear();
            query.put(whichField, oldValue);
            newDocument.put(whichField, newValue);
            updateObj.put("$set", newDocument);
            tasksUsersCollection.update(query, updateObj);
            readTasksUsers();
        }
    }

    /**
     * * ** Remove from DB***
     */
    public <T> void removeFromDB(Class<T> obj, String Value) throws IOException {
        BasicDBObject document = new BasicDBObject();
        if (obj.isAssignableFrom(User.class)) {
            Collections.usersList.clear();
            document.put("login", Value);
            usersCollection.remove(document);
            readUsers();
        } else if (obj.isAssignableFrom(Project.class)) {
            Collections.projectsList.clear();
            document.put("name", Value);
            projectsCollection.remove(document);
            readProjects();
        } else if (obj.isAssignableFrom(Task.class)) {
            Collections.tasksList.clear();
            document.put("name", Value);
            tasksCollection.remove(document);
            readTasks();
        } else if (obj.isAssignableFrom(TaskUser.class)) {
            Collections.tasksUsersList.clear();
            document.put("userId", Value);
            tasksUsersCollection.remove(document);
            readTasksUsers();
        }
        

    }

}
