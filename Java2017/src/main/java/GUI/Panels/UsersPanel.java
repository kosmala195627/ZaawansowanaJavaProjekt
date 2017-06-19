package GUI.Panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Database.Collections;
import Database.Models.User;
import Database.MongoConnection;
import GUI.TableOfUsers;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.map.JsonMappingException;

public class UsersPanel extends JPanel implements ActionListener {

    private final JButton bAdd, bDelete;
    private final TableOfUsers model;
    private JTable tTable;
    private final JScrollPane spPane;
    private User selectedUser;

    public UsersPanel() {

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        model = new TableOfUsers();
        model.add();
        tTable = new JTable();
        tTable.setModel(model);
        tTable.setPreferredScrollableViewportSize(new Dimension(550, 400));
        tTable.setFillsViewportHeight(true);
        tTable.setCellSelectionEnabled(true);
        tTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                selectedUser = Collections.usersList.get(tTable.getSelectedRow());
                System.out.println(selectedUser.getLastName());
            }
        });
        spPane = new JScrollPane(tTable);
        spPane.setMaximumSize(new Dimension(800, 480));
        this.add(spPane);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        this.add(buttonsPanel);

        bAdd = new JButton("Refresh List");
        buttonsPanel.add(bAdd);
        bAdd.addActionListener(this);

        JLabel space1Lbl = new JLabel();
        space1Lbl.setText(" ");
        space1Lbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
        buttonsPanel.add(space1Lbl);

        bDelete = new JButton("Delete");
        buttonsPanel.add(bDelete);
        bDelete.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        Object z = e.getSource();

        if (z == bAdd) {

        }
        if (z == bDelete) {

            if (Collections.usersList.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Currently the user list is empty!", "No users", JOptionPane.ERROR_MESSAGE);
            } else {
                int odp = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this user?", "Question", JOptionPane.YES_NO_OPTION);
                if (odp == JOptionPane.YES_OPTION) {
                    Collections.usersList.remove(selectedUser);
                }
            }
        }
    }
}
