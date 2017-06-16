package GUI;

import JavaProject2017.Java2017.Collections;
import JavaProject2017.Java2017.User;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Users extends JFrame implements ActionListener {

    private final JButton bAdd, bDelete, bBack;
    private final TableOfUsers model;
    private JTable tTable;
    private final JScrollPane spPane;
    private User selectedUser;
    
    public Users() {
        super("Users");
	setSize(800,600);
	setLayout(null);
	setLocationRelativeTo(null);
	setVisible(true);
	setResizable(false);
        
        bAdd = new JButton("Add");
	bAdd.setBounds(50,480,200,40);
	add(bAdd);
	bAdd.addActionListener(this);
        
	bDelete = new JButton("Delete");
	bDelete.setBounds(300,480,200,40);
	add(bDelete);	
	bDelete.addActionListener(this);
        
        bBack = new JButton("Back");
	bBack.setBounds(550,480,200,40);
	add(bBack);	
	bBack.addActionListener(this);
        
        model = new TableOfUsers();
	model.add();
	tTable = new JTable();
	tTable.setModel(model);
	tTable.setPreferredScrollableViewportSize(new Dimension(550,400));
	tTable.setFillsViewportHeight(true);
        tTable.setCellSelectionEnabled(true);
        tTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	tTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                selectedUser=Collections.usersList.get(tTable.getSelectedRow());
                System.out.println(selectedUser.getLastName());
            }
        });
	spPane = new JScrollPane(tTable);
	add(spPane);
	spPane.setBounds(50,30,700,430);
    }
    
    public void actionPerformed(ActionEvent e) {
        
        Object z = e.getSource();
        
        if (z == bBack) {
            //this.dispose();
        }
        if (z == bAdd) {

        }
        if (z == bDelete) {
            
            if (Collections.usersList.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Currently the user list is empty!", "No users", JOptionPane.ERROR_MESSAGE );
                        } else {
                            int odp = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this user?", "Question", JOptionPane.YES_NO_OPTION);
                            if (odp == JOptionPane.YES_OPTION) { 
                        Collections.usersList.remove(selectedUser);
                        //--TUTAJ OBSLUGA BAZY DANYCH--
                        
                        //this.dispose();

                    }
        }
    }    
}
}