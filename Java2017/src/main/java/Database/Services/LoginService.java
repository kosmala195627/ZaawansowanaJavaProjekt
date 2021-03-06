package Database.Services;

import Database.Collections;
import Database.Models.User;

public class LoginService {

    public LoginService() {

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
    public User getUserByLogin(String login) {
        if (login != null && !login.isEmpty()) {
            for (User x : Collections.usersList) {
                if (x.getLogin().equals(login)) {
                    return x;
                }
            }
        }
        return null;
    }
}
