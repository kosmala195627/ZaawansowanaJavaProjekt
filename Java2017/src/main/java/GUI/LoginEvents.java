package GUI;

import Database.Models.User;
import Database.Services.LoginService;

import javax.swing.*;

import org.mindrot.jbcrypt.BCrypt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginEvents implements ActionListener {

    Main mainWindow;
    Login loginWindow;
    LoginService loginService;

    public LoginEvents(Main mainWindow, Login loginWindow) {
        this.mainWindow = mainWindow;
        this.loginWindow = loginWindow;
        this.loginService = new LoginService();
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this.loginWindow.getLoginBtn()) {

            String userLogin = this.loginWindow.getLoginField().getText();
            User user = loginService.getUserByLogin(userLogin);

            if (user == null) {
                JOptionPane.showMessageDialog(new Frame(), "No such user in the system, please create account");
            } else if (BCrypt.checkpw(new String(this.loginWindow.getPasswordField().getPassword()), user.getPassword())) {
                this.mainWindow.refresh();
                this.mainWindow.setVisible(true);
                this.loginWindow.setVisible(false);

            } else {
                this.loginWindow.getLoginField().setText("");
                this.loginWindow.getPasswordField().setText("");
                this.loginWindow.badAuth();
            }

        } else if (event.getSource() == this.loginWindow.getSignUpBtn()) {
            new Registration();
        }

    }

}
