package GUI.Panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

import Database.Models.User;
import Database.Services.UsersService;

public class StartPanel extends JPanel implements ActionListener{

	private JButton addNewProjectBtn;
	
	private JTextField nameField;
	private JComboBox leaderCmbBox;
	private JList participantsList;
	private JButton addBtn;
	private JButton removeBtn;
	
	private UsersService log = new UsersService();
	private User[] users;
	
	public StartPanel()
	{
		this.users = log.getAllUsers();
		
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
 
   //// label at begin
        
        JPanel beginPanel = new JPanel();
        beginPanel.setLayout(new BoxLayout(beginPanel, BoxLayout.X_AXIS));
        beginPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 20));
        this.add(beginPanel);
        
		JLabel beginLbl = new JLabel();
		beginLbl.setText("     Add new project to begin");
		beginPanel.add(beginLbl);        
        
    //// project name
        
        JPanel projectNamePanel = new JPanel();
        projectNamePanel.setLayout(new BoxLayout(projectNamePanel, BoxLayout.X_AXIS));
        projectNamePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        this.add(projectNamePanel);
        
		JLabel nameLbl = new JLabel();
		nameLbl.setText("Name:   ");
        nameLbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
        projectNamePanel.add(nameLbl);
        
        nameField = new JTextField(100);
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
        
        leaderCmbBox = new JComboBox();
        leaderCmbBox.setMaximumSize(new Dimension(350,25));
        leaderCmbBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
        projectLeaderPanel.add(leaderCmbBox);
        
        String[] data = log.getAllUsers(users);
        for(String s : data) leaderCmbBox.addItem(s);
        this.leaderCmbBox.setSelectedIndex(-1);
        
        
   //// project participants
        
        JPanel projectParticipantsPanel = new JPanel();
        projectParticipantsPanel.setLayout(new BoxLayout(projectParticipantsPanel, BoxLayout.X_AXIS));
        projectParticipantsPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        this.add(projectParticipantsPanel);
        
		JLabel participantsLbl = new JLabel();
		participantsLbl.setText("Participants: ");
		participantsLbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
		projectParticipantsPanel.add(participantsLbl);
        
		String[] participantsData = {};      
        participantsList = new JList(participantsData); //data has type Object[]
        participantsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        participantsList.setLayoutOrientation(JList.VERTICAL);
        participantsList.setVisibleRowCount(-1);
        
        JScrollPane listScroller = new JScrollPane(participantsList);
        listScroller.setMaximumSize(new Dimension(320, 100));
        projectParticipantsPanel.add(listScroller);
        
        
   //// Add remove project participants
        
        JPanel removeOrAddParticipants = new JPanel();
        removeOrAddParticipants.setLayout(new BoxLayout(removeOrAddParticipants, BoxLayout.X_AXIS));
        removeOrAddParticipants.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        this.add(removeOrAddParticipants);
      
        removeBtn = new JButton("Remove participant");
        removeOrAddParticipants.add(removeBtn);
        removeBtn.addActionListener(this);
        
		JLabel emptyLbl = new JLabel(" ");
		emptyLbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
		removeOrAddParticipants.add(emptyLbl);
        
        addBtn = new JButton("   Add participant   ");
        removeOrAddParticipants.add(addBtn);
        addBtn.addActionListener(this);
        
   //// select or create project
        
        JPanel CreatePanel = new JPanel();
        CreatePanel.setLayout(new BoxLayout(CreatePanel, BoxLayout.X_AXIS));
        CreatePanel.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
        this.add(CreatePanel);
        
        addNewProjectBtn = new JButton("Add new project");
        CreatePanel.add(addNewProjectBtn);
        addNewProjectBtn.addActionListener(this);
		
	}
	
	private void refresh()
	{
		this.users = log.getAllUsers();
		
		this.nameField.setText("");
		
		leaderCmbBox.removeAllItems();
        String[] data = log.getAllUsers(users);
        for(String s : data) leaderCmbBox.addItem(s);
		this.leaderCmbBox.setSelectedIndex(-1);
		
		String[] data2 = {};
		this.participantsList.setListData(data2);
		
	}

	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == this.addNewProjectBtn)
		{
			refresh();
		}
		
		if(e.getSource() == this.addBtn)
		{
			refresh();
		}
		
		if(e.getSource() == this.removeBtn)
		{
			refresh();
		}
		
	}
}
