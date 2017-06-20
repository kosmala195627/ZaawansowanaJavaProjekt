package GUI.Panels;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Database.Collections;
import Database.Models.Project;
import Database.Models.User;
import Database.Services.ProjectService;
import Database.Services.UsersService;
import GUI.TableOfTasks;

public class ProjectsPanel extends JPanel {

    private ProjectService projectService = new ProjectService();
    private Project[] projects;
    private UsersService usersService = new UsersService();
    private User[] users;
    User selectedUser;

    public ProjectsPanel() {
        this.users = usersService.getAllUsers();
        this.projects = projectService.getAllProjects();

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
        projectsCmbBox.setMaximumSize(new Dimension(250, 25));
        projectsCmbBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
        selectOrCreatePanel.add(projectsCmbBox);

        String[] dataProjects = projectService.getAllProjects(projects);
        for (String s : dataProjects) {
            projectsCmbBox.addItem(s);
        }
        projectsCmbBox.setSelectedIndex(-1);

        JButton addNewProjectBtn = new JButton("Add new project");
        selectOrCreatePanel.add(addNewProjectBtn);

        //// project name
        JPanel projectNamePanel = new JPanel();
        projectNamePanel.setLayout(new BoxLayout(projectNamePanel, BoxLayout.X_AXIS));
        projectNamePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        this.add(projectNamePanel);

        JLabel nameLbl = new JLabel();
        nameLbl.setText("Name:   ");
        nameLbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 30));
        projectNamePanel.add(nameLbl);

        JTextField nameField = new JTextField(100);
        nameField.setMaximumSize(new Dimension(350, 25));
        projectNamePanel.add(nameField);

        //// project leader
        JPanel projectLeaderPanel = new JPanel();
        projectLeaderPanel.setLayout(new BoxLayout(projectLeaderPanel, BoxLayout.X_AXIS));
        projectLeaderPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        this.add(projectLeaderPanel);

        JLabel leaderLbl = new JLabel();
        leaderLbl.setText("   Leader: ");
        leaderLbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 30));
        projectLeaderPanel.add(leaderLbl);

        JComboBox leaderCmbBox = new JComboBox();
        leaderCmbBox.setMaximumSize(new Dimension(360, 25));
        leaderCmbBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
        projectLeaderPanel.add(leaderCmbBox);

        String[] dataUsers = usersService.getAllUsers(users);
        for (String s : dataUsers) {
            leaderCmbBox.addItem(s);
        }
        leaderCmbBox.setSelectedIndex(-1);

        //// project participants
        JPanel projectParticipantsPanel = new JPanel();
        projectParticipantsPanel.setLayout(new BoxLayout(projectParticipantsPanel, BoxLayout.X_AXIS));
        projectParticipantsPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        this.add(projectParticipantsPanel);

        JLabel participantsLbl = new JLabel();
        participantsLbl.setText("Participants: ");
        participantsLbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
        projectParticipantsPanel.add(participantsLbl);

        String[] data = {"aaaa", "bbbb", "cccc", "ddd"};
        JList participantsList = new JList(data); //data has type Object[]
        participantsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        participantsList.setLayoutOrientation(JList.VERTICAL);
        participantsList.setVisibleRowCount(-1);

        JScrollPane listScroller = new JScrollPane(participantsList);
        listScroller.setMaximumSize(new Dimension(320, 100));
        projectParticipantsPanel.add(listScroller);

        JLabel empty0Lbl = new JLabel(" ");
        empty0Lbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
        projectParticipantsPanel.add(empty0Lbl);

        JButton removeBtn = new JButton("Remove");
        projectParticipantsPanel.add(removeBtn);

        JLabel emptyLbl = new JLabel(" ");
        emptyLbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
        projectParticipantsPanel.add(emptyLbl);

        JButton addBtn = new JButton("   Add   ");
        projectParticipantsPanel.add(addBtn);

        //// Project task list
        JLabel empty2Lbl = new JLabel(" ");
        empty2Lbl.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 20));
        this.add(empty2Lbl);

        TableOfTasks model = new TableOfTasks();
        model.add();
        final JTable tTable = new JTable();
        tTable.setModel(model);
        tTable.setPreferredScrollableViewportSize(new Dimension(600, 200));
        tTable.setFillsViewportHeight(true);
        tTable.setCellSelectionEnabled(true);
        tTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                selectedUser = Collections.usersList.get(tTable.getSelectedRow());
                System.out.println(selectedUser.getLastName());
            }
        });
        JScrollPane spPane = new JScrollPane(tTable);
        spPane.setMaximumSize(new Dimension(600, 200));
        this.add(spPane);

        /// buttons Panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        this.add(buttonsPanel);

        JButton addbtn = new JButton("Add task");
        buttonsPanel.add(addbtn);

        JLabel space1Lbl = new JLabel();
        space1Lbl.setText(" ");
        space1Lbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
        buttonsPanel.add(space1Lbl);

        JButton updateBtn = new JButton("Update task");
        buttonsPanel.add(updateBtn);

        JLabel space2Lbl = new JLabel();
        space2Lbl.setText(" ");
        space2Lbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
        buttonsPanel.add(space2Lbl);

        JButton deleteBtn = new JButton("Delete task");
        buttonsPanel.add(deleteBtn);
    }
}
