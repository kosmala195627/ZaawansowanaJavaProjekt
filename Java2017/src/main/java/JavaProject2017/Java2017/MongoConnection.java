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
    public void insertUser(User user) {
        Collections.usersList.clear();
        BasicDBObject document = new BasicDBObject();
        document.put("id", user.getId());
        document.put("firstName", user.getFirstName());
        document.put("lastName", user.getLastName());
        document.put("login", user.getLogin());
        document.put("password", user.getPassword());
        usersCollection.insert(document);
    }

    public void insertProject(Project project) {
        Collections.projectsList.clear();
        BasicDBObject document = new BasicDBObject();
        document.put("projectId", project.getProjectId());
        document.put("name", project.getName());
        document.put("leaderId", project.getLeaderId());
        projectsCollection.insert(document);
    }

    public void insertTask(Task task) {
        Collections.tasksList.clear();
        BasicDBObject document = new BasicDBObject();
        document.put("taskId", task.getTaskId());
        document.put("name", task.getName());
        document.put("startDate", task.getStartDate());
        document.put("endDate", task.getEndDate());
        document.put("projectId", task.getProjectId());
        document.put("managerId", task.getManagerId());
        document.put("status", task.getStatus());
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

    public <T> void updateInDB(Class<T> obj, String whichField, String oldValue, String newValue) {
        BasicDBObject query = new BasicDBObject();
        BasicDBObject newDocument = new BasicDBObject();
        BasicDBObject updateObj = new BasicDBObject();

        if (obj.isAssignableFrom(User.class)) {
            Collections.usersList.clear();
            query.put(whichField, oldValue);
            newDocument.put(whichField, newValue);
            updateObj.put("$set", newDocument);
            usersCollection.update(query, updateObj);
        } else if (obj.isAssignableFrom(Project.class)) {
            Collections.projectsList.clear();
            query.put(whichField, oldValue);
            newDocument.put(whichField, newValue);
            updateObj.put("$set", newDocument);
            projectsCollection.update(query, updateObj);
        } else if (obj.isAssignableFrom(Task.class)) {
            Collections.tasksList.clear();
            query.put(whichField, oldValue);
            newDocument.put(whichField, newValue);
            updateObj.put("$set", newDocument);
            tasksCollection.update(query, updateObj);
        }
    }

    /**
     * * ** Remove from DB***
     */
    public <T> void removeFromDB(Class<T> obj, int idValue) {
        BasicDBObject document = new BasicDBObject();
        if (obj.isAssignableFrom(User.class)) {
            Collections.usersList.clear();
            document.put("id", idValue);
            usersCollection.remove(document);
        } else if (obj.isAssignableFrom(Project.class)) {
            Collections.projectsList.clear();
            document.put("projectId", idValue);
            projectsCollection.remove(document);
        } else if (obj.isAssignableFrom(Task.class)) {
            Collections.tasksList.clear();
            document.put("taskId", idValue);
            tasksCollection.remove(document);
        }

    }
}
