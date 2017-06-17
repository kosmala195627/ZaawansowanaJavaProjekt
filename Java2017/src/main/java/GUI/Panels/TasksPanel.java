package GUI.Panels;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

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
        
        JComboBox belongCmbBox = new JComboBox();
        belongCmbBox.setMaximumSize(new Dimension(400,25));
        belongCmbBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
        belongsPanel.add(belongCmbBox);
            
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
        
        JComboBox managerCmbBox = new JComboBox();
        managerCmbBox.setMaximumSize(new Dimension(400,25));
        managerCmbBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
        managerPanel.add(managerCmbBox);
		      
   //// task name and activity
        
        JPanel nameAndActivityPanel = new JPanel();
        nameAndActivityPanel.setLayout(new BoxLayout(nameAndActivityPanel, BoxLayout.X_AXIS));
        nameAndActivityPanel.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
        this.add(nameAndActivityPanel);
        
		JLabel taskNameLbl = new JLabel();
		taskNameLbl.setText("Task name:   ");
		taskNameLbl.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 82));
        nameAndActivityPanel.add(taskNameLbl);
        nameAndActivityPanel.setAlignmentX( Component.LEFT_ALIGNMENT );
        
        JTextField taskNameField = new JTextField(100);
        taskNameField.setMaximumSize(new Dimension(300,25));
        nameAndActivityPanel.add(taskNameField);
        
		JLabel taskActivityLbl = new JLabel();
		taskActivityLbl.setText("Activity:   ");
		taskActivityLbl.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 20));
        nameAndActivityPanel.add(taskActivityLbl);
        
        JComboBox activityCmbBox = new JComboBox();
        activityCmbBox.setMaximumSize(new Dimension(200,25));
        activityCmbBox.setMinimumSize(new Dimension(200,25));   
        nameAndActivityPanel.add(activityCmbBox);
        
   //// task begin end date
        
        JPanel taskDatePanel = new JPanel();
        taskDatePanel.setLayout(new BoxLayout(taskDatePanel, BoxLayout.X_AXIS));
        taskDatePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        this.add(taskDatePanel);
        
		JLabel beginDateLbl = new JLabel();
		beginDateLbl.setText("Start date:   ");
		beginDateLbl.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 90));
		taskDatePanel.add(beginDateLbl);
		taskDatePanel.setAlignmentX( Component.LEFT_ALIGNMENT );
        
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl beginDatePanel = new JDatePanelImpl(model);
		JDatePickerImpl beginDatePicker = new JDatePickerImpl(beginDatePanel);
		beginDatePicker.setMaximumSize(new Dimension(200,35));
		taskDatePanel.add(beginDatePicker);
		
		JLabel endDateLbl = new JLabel();
		endDateLbl.setText("End date:   ");
		endDateLbl.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
		taskDatePanel.add(endDateLbl);
		
		JDatePanelImpl endDatePanel = new JDatePanelImpl(model);
		JDatePickerImpl endDatePicker = new JDatePickerImpl(endDatePanel);
		endDatePicker.setMaximumSize(new Dimension(200,35));
		taskDatePanel.add(endDatePicker);
		
   //// task responsibility
        
        JPanel responsibilityPanel = new JPanel();
        responsibilityPanel.setLayout(new BoxLayout(responsibilityPanel, BoxLayout.X_AXIS));
        responsibilityPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        this.add(responsibilityPanel);
        
		JLabel responsibilityLbl = new JLabel();
		responsibilityLbl.setText("Responsible for a task:   ");
		responsibilityLbl.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 20));
		responsibilityPanel.add(responsibilityLbl);
		responsibilityPanel.setAlignmentX( Component.LEFT_ALIGNMENT );
        
        String[] data = {"aaaa", "bbbb","cccc","ddd"};
        JList responsibilityList = new JList(data); //data has type Object[]
        responsibilityList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        responsibilityList.setLayoutOrientation(JList.VERTICAL);
        responsibilityList.setVisibleRowCount(-1);
        
        JScrollPane listScroller = new JScrollPane(responsibilityList);
        listScroller.setMaximumSize(new Dimension(320, 100));
        responsibilityPanel.add(listScroller);
		
		JLabel space2Lbl = new JLabel();
		space2Lbl.setText(" ");
		space2Lbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
		responsibilityPanel.add(space2Lbl);
        
		JButton bAdd = new JButton("Add");
		responsibilityPanel.add(bAdd);
		
		JLabel space3Lbl = new JLabel();
		space3Lbl.setText(" ");
		space3Lbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
		responsibilityPanel.add(space3Lbl);
	        
		JButton bDelete = new JButton("Remove");
		responsibilityPanel.add(bDelete);	
        
   //// task create
        
        JPanel createButtonPanel = new JPanel();
        createButtonPanel.setLayout(new BoxLayout(createButtonPanel, BoxLayout.X_AXIS));
        createButtonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        createButtonPanel.setAlignmentX( Component.LEFT_ALIGNMENT );
        this.add(createButtonPanel);
        
        JLabel space4Lbl = new JLabel();
		space4Lbl.setText(" ");
		space4Lbl.setBorder(BorderFactory.createEmptyBorder(200, 320, 0 , 0));
		createButtonPanel.add(space4Lbl);
        
		JButton createNewBtn = new JButton("Create new task");
		createButtonPanel.add(createNewBtn);
		
	}
		
}
