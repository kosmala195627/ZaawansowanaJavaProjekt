package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Database.Collections;
import GUI.Panels.ProjectsPanel;
import GUI.Panels.StartPanel;
import GUI.Panels.TasksPanel;
import GUI.Panels.UsersPanel;

public class Main extends JFrame implements ActionListener {

    private JButton signOutBtn;
    private Login loginWindow;
    
    final JTabbedPane tabbedPanel;

    public Main() {
        loginWindow = new Login(this);

        // main window class
        setResizable(false);
        setMinimumSize(new Dimension(800, 600));
        setTitle("JAVA 2017 - Project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPanel = new JTabbedPane();
        getContentPane().add(tabbedPanel);
        StartPanel start = new StartPanel();
        tabbedPanel.addTab("Start", start);
        ProjectsPanel projects = new ProjectsPanel();
        tabbedPanel.addTab("Projects", projects);
        TasksPanel tasks = new TasksPanel();
        tabbedPanel.addTab("Tasks", tasks);
        UsersPanel users = new UsersPanel();
        tabbedPanel.addTab("Team members", users);

        // to allow signOut
        signOutBtn = new JButton("Sign out");

        final JPanel signOutPanel = new JPanel();
        JLabel signOutLabel = new JLabel("Please confirm.    ");
        signOutPanel.add(signOutLabel);
        signOutPanel.add(signOutBtn);
        tabbedPanel.addTab("Sign out", signOutPanel);

        signOutBtn.addActionListener(this);
    }
    
    public void refresh()
    {	
    	tabbedPanel.removeAll();
    	
        StartPanel start = new StartPanel();
        tabbedPanel.addTab("Start", start);
        ProjectsPanel projects = new ProjectsPanel();
        tabbedPanel.addTab("Projects", projects);
        TasksPanel tasks = new TasksPanel();
        tabbedPanel.addTab("Tasks", tasks);
        UsersPanel users = new UsersPanel();
        tabbedPanel.addTab("Team members", users);
        
        // to allow signOut
        signOutBtn = new JButton("Sign out");

        final JPanel signOutPanel = new JPanel();
        JLabel signOutLabel = new JLabel("Please confirm.    ");
        signOutPanel.add(signOutLabel);
        signOutPanel.add(signOutBtn);
        tabbedPanel.addTab("Sign out", signOutPanel);

        signOutBtn.addActionListener(this);
    	
    }


    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == signOutBtn) {
            loginWindow.init();
            loginWindow.setVisible(true);
            this.setVisible(false);
            tabbedPanel.setSelectedIndex(0);
        }

    }

}
