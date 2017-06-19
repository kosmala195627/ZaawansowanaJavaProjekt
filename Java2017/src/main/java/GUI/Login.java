package GUI;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login extends JFrame{
	
	private JTextField loginField;
	
	private JLabel loginFieldLbl;
	private JLabel passwordFieldLbl;
	private JLabel badAuthLbl;
	
	private JPasswordField passwordField;
	
	private JButton loginBtn;
	private JButton signUpBtn;
	
	public Login(Main mainWindow)
	{
		setResizable(false);
		Container c = getContentPane(); 
		//setSize(240, 240);
		setMinimumSize(new Dimension(480,320));
		setTitle("JAVA 2017 - Project - Login page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLocationRelativeTo(null);
		c.setLayout(null);
		
		loginFieldLbl = new JLabel("Login:");
		loginFieldLbl.setBounds(120, 60, 240, 30);
		c.add(loginFieldLbl);
		
		loginField = new JTextField(20);
		loginField.setBounds(120, 90, 240, 30);
		c.add(loginField);
		
		passwordFieldLbl = new JLabel("Password:");
		passwordFieldLbl.setBounds(120, 120, 240, 30);
		c.add(passwordFieldLbl);
		
		passwordField = new JPasswordField(20);
		passwordField.setBounds(120, 150, 240, 30);
		c.add(passwordField);
		
		badAuthLbl = new JLabel("Bad login or password!");
		badAuthLbl.setBounds(175, 190, 180, 30);
		badAuthLbl.setVisible(false);
		c.add(badAuthLbl);
		
		loginBtn = new JButton("Sign in");
		loginBtn.setBounds(100, 230, 140, 30);
		c.add(loginBtn);
		
		signUpBtn = new JButton("Sign up");
		signUpBtn.setBounds(250, 230, 140, 30);
		c.add(signUpBtn);
		
		LoginEvents log = new LoginEvents(mainWindow,this);
		loginBtn.addActionListener(log);
		signUpBtn.addActionListener(log);
		
		setVisible(true);
	}
	
	public void init()
	{
		this.loginField.setText("");
		this.passwordField.setText("");
		this.badAuthLbl.setVisible(false);
	}
	
	public void badAuth()
	{
		badAuthLbl.setVisible(true);
	}

	public JButton getLoginBtn() {
		return loginBtn;
	}

	public JButton getSignUpBtn() {
		return signUpBtn;
	}

	public JTextField getLoginField() {
		return loginField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

}