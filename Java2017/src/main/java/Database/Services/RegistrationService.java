package Database.Services;

import Database.Collections;
import Database.Models.User;

public class RegistrationService {

    public RegistrationService() {

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
    public boolean checkUsersList(String login) {
        for (User x : Collections.usersList) {
            if (x.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }
}
