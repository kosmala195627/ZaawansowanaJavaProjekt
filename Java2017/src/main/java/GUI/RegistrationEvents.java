package GUI;

import Database.Collections;
import Database.Models.User;
import Database.MongoConnection;
import Database.Services.LoginService;
import Database.Services.RegistrationService;

import javax.swing.*;

import org.mindrot.jbcrypt.BCrypt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.map.JsonMappingException;

public class RegistrationEvents implements ActionListener {

    //Login loginWindow;
    Registration registrationWindow;
    RegistrationService registrationService;

    public RegistrationEvents(Registration registrationWindow) {
        //this.loginWindow = loginWindow;
        this.registrationWindow = registrationWindow;
        this.registrationService = new RegistrationService();
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this.registrationWindow.getAcceptBtn()) {
            if (registrationWindow.getFirstNameField().getText().isEmpty() == false && registrationWindow.getLastNameField().getText().isEmpty() == false
                    && registrationWindow.getLoginField().getText().isEmpty() == false && registrationWindow.getPasswordField().getText().isEmpty() == false) {
                
                boolean isUserExists = registrationService.checkUsersList(registrationWindow.getLoginField().getText());
                if (isUserExists) {
                    JOptionPane.showMessageDialog(new Frame(), "User with given Login already exists!");
                } else {
                    User user = new User();
                    user.setFirstName(registrationWindow.getFirstNameField().getText());
                    user.setLastName(registrationWindow.getLastNameField().getText());
                    user.setLogin(registrationWindow.getLoginField().getText());
                    user.setPassword(BCrypt.hashpw(registrationWindow.getPasswordField().getText(), BCrypt.gensalt()));

                    try {
                        new MongoConnection().insertUser(user);
                    } catch (JsonMappingException ex) {
                        Logger.getLogger(RegistrationEvents.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(RegistrationEvents.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(new Frame(), "The user has been added!");
                    registrationWindow.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(new Frame(), "Fill in all fields!!!");
            }

        } else if (event.getSource() == this.registrationWindow.getCancelBtn()) {
            registrationWindow.dispose();
        }
    }
}
