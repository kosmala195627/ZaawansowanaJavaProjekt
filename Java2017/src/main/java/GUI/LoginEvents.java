package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import org.mindrot.jbcrypt.BCrypt;


public class LoginEvents implements ActionListener {
	
	Main mainWindow;
	Login loginWindow;
	
	public LoginEvents(Main mainWindow, Login loginWindow)
	{
		this.mainWindow = mainWindow;
		this.loginWindow = loginWindow;
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == this.loginWindow.getLoginBtn())
		{	
			//TODO
			// implement real login function with connection to Mongo database
			
			String exampleUser = "user";
			String exampleHashedPassword ="$2a$10$6BhnrXJtEqAh13afhtWedeU4mxtWaxcyebQbbsnxJKxPPiWuV.IMW";
		if (BCrypt.checkpw(new String(this.loginWindow.getPasswordField().getPassword()),exampleHashedPassword) 
				&& (this.loginWindow.getLoginField().getText().equals(exampleUser)))
		{
			this.mainWindow.setVisible(true);
			this.loginWindow.setVisible(false);
			
		}
		else
		{
			this.loginWindow.getLoginField().setText("");
			this.loginWindow.getPasswordField().setText("");
			this.loginWindow.badAuth();
		}
		}
		else if(event.getSource() == this.loginWindow.getSignUpBtn())
		{
			//TODO
			// implement registration
			
			//Below example of generating hashed password
			//String hashed = BCrypt.hashpw("pass", BCrypt.gensalt());
			//System.out.println(hashed);
		}
			
	}
	
	

}
