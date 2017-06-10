package GUI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main extends JFrame{
	
	private JButton signOutBtn;
	private Login loginWindow;
	
	public Main()
	{
		loginWindow = new Login(this);
		
		// main window class
		setResizable(false);
		Container c = getContentPane(); 
		//setSize(240, 240);
		setMinimumSize(new Dimension(800,600));
		setTitle("JAVA 2017 - Project");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout(null);
		
		signOutBtn = new JButton("Sign out");
		signOutBtn.setBounds(650, 10, 140, 30);
		c.add(signOutBtn);
		
		
		final Main self = this;
		signOutBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event)
			{
				loginWindow.init();
				loginWindow.setVisible(true);
				self.setVisible(false);
			}	
		});
	}


}
