package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Registration extends JFrame {

    private final JButton btnAccept, btnCancel;
    private final JLabel lblInform, lblFirstName, lblLastName, lblLogin, lblPassword;
    private final JPasswordField txtPassword;
    private final JTextField txtFirstName, txtLastName, txtLogin;

    public Registration() {
        this.setTitle("Registration Panel");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        lblInform = new JLabel("Please, enter the informations about new User.");
        lblInform.setBounds(60, 10, 300, 30);
        add(lblInform);

        lblFirstName = new JLabel("First name: ");
        lblFirstName.setBounds(25, 50, 100, 30);
        add(lblFirstName);

        lblLastName = new JLabel("Last name: ");
        lblLastName.setBounds(25, 100, 100, 30);
        add(lblLastName);

        lblLogin = new JLabel("Login: ");
        lblLogin.setBounds(25, 200, 100, 30);
        add(lblLogin);

        lblPassword = new JLabel("Password: ");
        lblPassword.setBounds(25, 250, 100, 30);
        add(lblPassword);

        txtFirstName = new JTextField();
        txtFirstName.setBounds(120, 50, 150, 30);
        add(txtFirstName);

        txtLastName = new JTextField();
        txtLastName.setBounds(120, 100, 150, 30);
        add(txtLastName);

        txtLogin = new JTextField();
        txtLogin.setBounds(120, 200, 150, 30);
        add(txtLogin);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(120, 250, 150, 30);
        add(txtPassword);

        btnAccept = new JButton("Accept");
        btnAccept.setBounds(100, 320, 100, 30);
        add(btnAccept);

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(210, 320, 100, 30);
        add(btnCancel);

        RegistrationEvents log = new RegistrationEvents(this);
        btnAccept.addActionListener(log);
        btnCancel.addActionListener(log);

        setVisible(true);

    }

    public JButton getAcceptBtn() {
        return btnAccept;
    }

    public JButton getCancelBtn() {
        return btnCancel;
    }

    public JTextField getFirstNameField() {
        return txtFirstName;
    }

    public JTextField getLastNameField() {
        return txtLastName;
    }

    public JTextField getLoginField() {
        return txtLogin;
    }

    public JPasswordField getPasswordField() {
        return txtPassword;
    }
}
