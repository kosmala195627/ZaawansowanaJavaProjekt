package GUI;

import JavaProject2017.Java2017.MongoUtils;
import JavaProject2017.Java2017.User;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginEvents implements ActionListener {
    
    Main mainWindow;
    Login loginWindow;
    
    MongoUtils mongo = new MongoUtils();
    
    public LoginEvents(Main mainWindow, Login loginWindow) {
        this.mainWindow = mainWindow;
        this.loginWindow = loginWindow;
    }
    
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this.loginWindow.getLoginBtn()) {
            
            DB database = mongo.connectToDatabase();
            DBCollection users = mongo.getCollectionFromDatabase(database, "users");
            DBObject userToLogin = mongo.findUserByLogin(users, this.loginWindow.getLoginField().getText());
            System.out.println(this.loginWindow.getLoginField().getText());
            System.out.println(users);
            
            if (userToLogin==null) {
                JOptionPane.showMessageDialog(new Frame(), "No such user in the system, Please create account");
            } else {
                if ((mongo.findUserByLoginAndPassword(users,this.loginWindow.getLoginField().getText(),this.loginWindow.getPasswordField().getText()))!=null) {
                    this.mainWindow.setVisible(true);
                    this.loginWindow.setVisible(false);
                    
                } else {
                    this.loginWindow.getLoginField().setText("");
                    this.loginWindow.getPasswordField().setText("");
                    this.loginWindow.badAuth();
                }
            }
            
            
        } else if (event.getSource() == this.loginWindow.getSignUpBtn()) {
            //TODO
            // implement registration
            
            //Below example of generating hashed password
            //String hashed = BCrypt.hashpw("pass", BCrypt.gensalt());
            //System.out.println(hashed);
        }
        
    }

    
    
}
