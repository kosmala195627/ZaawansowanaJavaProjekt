package JavaProject2017.Java2017;

import com.mongodb.*;

/**
 * Created by Piotr on 2017-06-17.
 */
public class MongoUtils {
    
    public DB connectToDatabase() {
        MongoClient mongoClient = new MongoClient("localhost" , 27017);
        return mongoClient.getDB("Java2017");
        
    }
    
    public DBCollection getCollectionFromDatabase(DB database , String collection) {
        return database.getCollection(collection);
    }
    
    public DBObject findUserByLogin(DBCollection collection , String login){
        BasicDBObject query = new BasicDBObject();
        query.put("login" , login);
        return collection.findOne(query);
        
    }
    
    public DBCursor findUserByLoginAndPassword(DBCollection collection , String loginToCheck, String passwordToCheck) {
        BasicDBObject query = new BasicDBObject();
        query.put("login" , loginToCheck);
        query.put("password" , passwordToCheck);
        return collection.find(query);
        


    
        
    }
    
}
