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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.map.JsonMappingException;

public class MongoConnection {

    public MongoConnection() throws UnknownHostException, JsonMappingException, IOException {
        try {
            JSONTester test = new JSONTester();

            MongoClient mongo = new MongoClient("localhost", 27017);
            DB db = mongo.getDB("Java2017");

            DBCollection usersCollection = db.getCollection("users");
            DBCursor cursor1 = usersCollection.find();
            while (cursor1.hasNext()) {
                DBObject obj = cursor1.next();
                test.readUsersJSON(obj.toString());
            }
            
            DBCollection projectsCollection = db.getCollection("projects");
            DBCursor cursor2 = projectsCollection.find();
            while (cursor2.hasNext()) {
                DBObject obj = cursor2.next();
                System.out.println(obj.toString());
                test.readProjectsJSON(obj.toString());
            }

            DBCollection tasksCollection = db.getCollection("tasks");
            DBCursor cursor3 = tasksCollection.find();
            while (cursor3.hasNext()) {
                DBObject obj = cursor3.next();
                System.out.println(obj.toString());
                test.readTasksJSON(obj.toString());
            }
            /**
             * ** Find and display ***
             */
            /*BasicDBObject searchQuery = new BasicDBObject();
	searchQuery.put("id", 195690);

	DBCursor cursor = table.find(searchQuery);

	while (cursor.hasNext()) {
		//System.out.println(cursor.next());
	}*/
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
}
