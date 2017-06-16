package JavaProject2017.Java2017;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Date;
import org.codehaus.jackson.map.JsonMappingException;

public class MongoConnection {

    DBCollection usersCollection, projectsCollection, tasksCollection;
    JSONTester test = new JSONTester();
    MongoClient mongo = new MongoClient("localhost", 27017);
    DB db = mongo.getDB("Java2017");

    public MongoConnection() throws UnknownHostException, JsonMappingException, IOException {
        try {
            readUsers();
            readProjects();
            readTasks();
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
            System.out.println(obj.toString());
            test.readProjectsJSON(obj.toString());
        }
    }

    public void readTasks() throws JsonMappingException, IOException {
        tasksCollection = db.getCollection("tasks");
        DBCursor cursor3 = tasksCollection.find();
        while (cursor3.hasNext()) {
            DBObject obj = cursor3.next();
            System.out.println(obj.toString());
            test.readTasksJSON(obj.toString());
        }
    }

    /**
     * * ** Insert new data to DB***
     */
    public void insertUser(int id, String firstName, String lastName, String login, String password) {
        Collections.usersList.clear();
        BasicDBObject document = new BasicDBObject();
        document.put("id", id);
        document.put("firstName", firstName);
        document.put("lastName", lastName);
        document.put("login", login);
        document.put("password", password);
        usersCollection.insert(document);
    }

    public void insertProject(int projectId, String name, int leaderId) {
        Collections.projectsList.clear();
        BasicDBObject document = new BasicDBObject();
        document.put("projectId", projectId);
        document.put("name", name);
        document.put("leaderId", leaderId);
        projectsCollection.insert(document);
    }

    public void insertTask(int taskId, String name, Date startDate, Date endDate, int projectId, int managerId, boolean status) {
        Collections.tasksList.clear();
        BasicDBObject document = new BasicDBObject();
        document.put("taskId", taskId);
        document.put("name", name);
        document.put("startDate", startDate);
        document.put("endDate", endDate);
        document.put("projectId", projectId);
        document.put("managerId", managerId);
        document.put("status", status);
        tasksCollection.insert(document);
    }

    /**
     * * ** Update data in DB***
     */
    public void updateUsers(String whichField, String oldValue, String newValue) {
        Collections.usersList.clear();
        BasicDBObject query = new BasicDBObject();
        query.put(whichField, oldValue);

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put(whichField, newValue);

        BasicDBObject updateObj = new BasicDBObject();
        updateObj.put("$set", newDocument);

        usersCollection.update(query, updateObj);
    }

    public void updateProjects(String whichField, String oldValue, String newValue) {
        Collections.projectsList.clear();
        BasicDBObject query = new BasicDBObject();
        query.put(whichField, oldValue);

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put(whichField, newValue);

        BasicDBObject updateObj = new BasicDBObject();
        updateObj.put("$set", newDocument);

        projectsCollection.update(query, updateObj);
    }

    public void updateTasks(String whichField, String oldValue, String newValue) {
        Collections.tasksList.clear();
        BasicDBObject query = new BasicDBObject();
        query.put(whichField, oldValue);

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put(whichField, newValue);

        BasicDBObject updateObj = new BasicDBObject();
        updateObj.put("$set", newDocument);

        tasksCollection.update(query, updateObj);
    }
    
    public void removeUser (int userId) {
        Collections.usersList.clear();
        BasicDBObject document = new BasicDBObject();
        document.put("id", userId);
        usersCollection.remove(document);
    }
    
    public void removeProject (int projectId) {
        Collections.projectsList.clear();
        BasicDBObject document = new BasicDBObject();
        document.put("projectId", projectId);
        projectsCollection.remove(document);
    }
    
    public void removeTask (int taskId) {
        Collections.tasksList.clear();
        BasicDBObject document = new BasicDBObject();
        document.put("taskId", taskId);
        tasksCollection.remove(document);
    }
}
