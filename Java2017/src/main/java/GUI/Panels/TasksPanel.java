package GUI.Panels;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TasksPanel extends JPanel{

	public TasksPanel()
	{
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
    //// project belongs 
        
        JPanel belongsPanel = new JPanel();
        belongsPanel.setLayout(new BoxLayout(belongsPanel, BoxLayout.X_AXIS));
        belongsPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        this.add(belongsPanel);
        
		JLabel belongLbl = new JLabel();
		belongLbl.setText("Belongs to the project:   ");
		belongLbl.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 20));
        belongsPanel.add(belongLbl);
        belongsPanel.setAlignmentX( Component.LEFT_ALIGNMENT );
        
        JTextField belongField = new JTextField(100);
        belongField.setMaximumSize(new Dimension(400,25));
        belongsPanel.add(belongField);
            
		JLabel space1Lbl = new JLabel();
		space1Lbl.setText(" ");
		space1Lbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));		
		belongsPanel.add(space1Lbl);
		
        JButton backToProjectBtn = new JButton("Back to project");
        belongsPanel.add(backToProjectBtn);
	
    //// project manager 
        
        JPanel managerPanel = new JPanel();
        managerPanel.setLayout(new BoxLayout(managerPanel, BoxLayout.X_AXIS));
        managerPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        this.add(managerPanel);
        
		JLabel managerLbl = new JLabel();
		managerLbl.setText("Project manager:   ");
		managerLbl.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 50));
        managerPanel.add(managerLbl);
        managerPanel.setAlignmentX( Component.LEFT_ALIGNMENT );
        
        JTextField managerField = new JTextField(100);
        managerField.setMaximumSize(new Dimension(400,25));
        managerPanel.add(managerField);
		
	}
}
