package GUI;

import Database.Models.User;
import Database.MongoConnection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.codehaus.jackson.map.JsonMappingException;


public class UpdatingUser extends JDialog implements ActionListener{
    
    JComboBox whatUpdate;
    JLabel lblNew;
    JTextField txtNew;
    JButton btnAcept;
    User user;
    
    public UpdatingUser(User user) {
        this.user = user;
        
        this.setTitle("Updating User");
	setSize(400,250);
	setLocationRelativeTo(null);
	setLayout(null);
	setResizable(false);
        setVisible(true);
        
        btnAcept = new JButton("Ok");
        btnAcept.setBounds(130, 180, 100, 30);
        add(btnAcept);
        btnAcept.addActionListener(this);
        
        lblNew = new JLabel("What update? ");
        lblNew.setBounds(25, 50, 100, 30);
        add(lblNew);
        
        whatUpdate = new JComboBox();
        whatUpdate.setBounds(120, 50, 150, 30);
        add(whatUpdate);
        whatUpdate.addItem("firstName");
        whatUpdate.addItem("lastName");
        
        lblNew = new JLabel("New Value: ");
        lblNew.setBounds(25, 120, 100, 30);
        add(lblNew);
        
        txtNew = new JTextField();
        txtNew.setBounds(120, 120, 150, 30);
        add(txtNew);
        
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAcept) {
            String field = whatUpdate.getSelectedItem().toString();
            String old;
            if (field.equals("firstName")) {
                old = user.getFirstName();
            } else {
                old = user.getLastName();
            }
            try {
                new MongoConnection().updateInDB(user.getClass(), field, old, txtNew.getText());
            } catch (JsonMappingException ex) {
                Logger.getLogger(UpdatingUser.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(UpdatingUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
