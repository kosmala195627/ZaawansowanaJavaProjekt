package Database.Services;

import java.util.ArrayList;

import Database.Collections;
import Database.Models.User;

public class UsersService {

    public UsersService() {

    }

    public User[] getAllUsers() {
        User[] result = new User[Collections.usersList.size()];
        return Collections.usersList.toArray(result);
    }

    public String[] getAllUsers(User[] tab) {
        String[] result = new String[tab.length];
        ArrayList<String> temp = new ArrayList<String>();
        for (User x : tab) {
            temp.add(x.getFirstName() + " " + x.getLastName());
        }
        return temp.toArray(result);
    }
    
    public String returnUserName(String userId) {
        for (User x : Collections.usersList) {
            if (x.get_id().equals(userId)) {
                return x.getFirstName() + " " + x.getLastName();
            }
        }
        return null;
    }
}
