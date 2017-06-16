package GUI.Panels;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProjectsPanel extends JPanel{

	public ProjectsPanel()
	{
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
        //// select or create project
        
        JPanel selectOrCreatePanel = new JPanel();
        selectOrCreatePanel.setLayout(new BoxLayout(selectOrCreatePanel, BoxLayout.X_AXIS));
        selectOrCreatePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        this.add(selectOrCreatePanel);
        
		JLabel label1 = new JLabel();
        label1.setText("Select existing project: ");
        label1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
        selectOrCreatePanel.add(label1);
        
        JComboBox projectsCmbBox = new JComboBox();
        projectsCmbBox.setMaximumSize(new Dimension(250,25));
        projectsCmbBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
        selectOrCreatePanel.add(projectsCmbBox);
        
        JButton addNewProjectBtn = new JButton("Add new project");
        selectOrCreatePanel.add(addNewProjectBtn);
              
        //// project name
        
        JPanel projectNamePanel = new JPanel();
        projectNamePanel.setLayout(new BoxLayout(projectNamePanel, BoxLayout.X_AXIS));
        projectNamePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        this.add(projectNamePanel);
        
		JLabel nameLbl = new JLabel();
		nameLbl.setText("Name:   ");
        nameLbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
        projectNamePanel.add(nameLbl);
        
        JTextField nameField = new JTextField(100);
        nameField.setMaximumSize(new Dimension(350,25));
        projectNamePanel.add(nameField);
        
        //// project leader
        
        JPanel projectLeaderPanel = new JPanel();
        projectLeaderPanel.setLayout(new BoxLayout(projectLeaderPanel, BoxLayout.X_AXIS));
        projectLeaderPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        this.add(projectLeaderPanel);
        
		JLabel leaderLbl = new JLabel();
		leaderLbl.setText("Leader: ");
		leaderLbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
        projectLeaderPanel.add(leaderLbl);
        
        JTextField leaderField = new JTextField(100);
        leaderField.setMaximumSize(new Dimension(350,25));
        projectLeaderPanel.add(leaderField);
        
   //// project participants
        /*
        JPanel projectParticipantsPanel = new JPanel();
        projectParticipantsPanel.setLayout(new BoxLayout(projectLeaderPanel, BoxLayout.X_AXIS));
        projectParticipantsPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        this.add(projectLeaderPanel);
        
		JLabel leaderLbl = new JLabel();
		leaderLbl.setText("Leader: ");
		leaderLbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
        projectLeaderPanel.add(leaderLbl);
        
        JTextField leaderField = new JTextField(100);
        leaderField.setMaximumSize(new Dimension(350,25));
        projectLeaderPanel.add(leaderField);*/
        
	}
}
