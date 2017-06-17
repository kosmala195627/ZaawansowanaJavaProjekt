package Database.Services;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import Database.Collections;
import Database.Models.User;

public class LoginService {

	public LoginService()
	{
		
	}
	/*
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
	*/
	
    public User getUserByLogin(String login){
    	
		for(User x : Collections.usersList)	{
			if(x.getLogin().equals(login)) return x;			
		}  	
       return null; 
    }
}