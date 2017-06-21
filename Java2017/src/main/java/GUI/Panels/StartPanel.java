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
import Database.Services.ProjectService;
import Database.Services.UsersService;
import java.awt.Frame;
import javax.swing.JOptionPane;

public class StartPanel extends JPanel implements ActionListener {

    private JButton addNewProjectBtn;

    private JTextField nameField;
    private JComboBox leaderCmbBox;
    private JList participantsList;
    private JButton addBtn;
    private JButton removeBtn;

    private UsersService usersService = new UsersService();
    private ProjectService projectService = new ProjectService();
    private User[] users;

    public StartPanel() {
        this.users = usersService.getAllUsers();

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
        nameField.setMaximumSize(new Dimension(350, 25));
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
        leaderCmbBox.setMaximumSize(new Dimension(350, 25));
        leaderCmbBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
        projectLeaderPanel.add(leaderCmbBox);

        String[] data = usersService.getAllUsers(users);
        for (String s : data) {
            leaderCmbBox.addItem(s);
        }
        this.leaderCmbBox.setSelectedIndex(-1);

        //// select or create project
        JPanel CreatePanel = new JPanel();
        CreatePanel.setLayout(new BoxLayout(CreatePanel, BoxLayout.X_AXIS));
        CreatePanel.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
        this.add(CreatePanel);

        addNewProjectBtn = new JButton("Add new project");
        CreatePanel.add(addNewProjectBtn);
        addNewProjectBtn.addActionListener(this);

    }

    private void refresh() {
        this.users = usersService.getAllUsers();

        this.nameField.setText("");

        leaderCmbBox.removeAllItems();
        String[] data = usersService.getAllUsers(users);
        for (String s : data) {
            leaderCmbBox.addItem(s);
        }
        this.leaderCmbBox.setSelectedIndex(-1);

 //       String[] data2 = {};
//        this.participantsList.setListData(data2);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.addNewProjectBtn) {
            if (this.nameField.getText().isEmpty() && this.leaderCmbBox.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(new Frame(), "You have to fill Name of Project field and choose the Leader of the new Project");
            } else {
                User u = this.users[this.leaderCmbBox.getSelectedIndex()];
                projectService.addNewProject(this.nameField.getText(), u.get_id());
                refresh();
            }
        }
    }
}
