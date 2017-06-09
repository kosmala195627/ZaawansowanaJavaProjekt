package JavaProject2017.Java2017;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MongoConnection {
	

    public MongoConnection() throws UnknownHostException {
         try {
	/**** Connect to MongoDB ****/
	MongoClient mongo = new MongoClient("localhost", 27017);

	/**** Get database ****/
	DB db = mongo.getDB("Java2017");

	/**** Get collection / table ****/
	DBCollection table = db.getCollection("users");

	/**** Find and display ****/
	BasicDBObject searchQuery = new BasicDBObject();
	searchQuery.put("id", 195690);

	DBCursor cursor = table.find(searchQuery);

	while (cursor.hasNext()) {
		System.out.println(cursor.next());
	}


    } catch (UnknownHostException e) {
	e.printStackTrace();
    } catch (MongoException e) {
	e.printStackTrace();
    }
}
}