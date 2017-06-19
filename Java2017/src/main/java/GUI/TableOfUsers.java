package GUI;

import javax.swing.table.DefaultTableModel;
import Database.Collections;
import Database.Models.User;

public class TableOfUsers extends DefaultTableModel implements ITable {

    public TableOfUsers() {
        this.addColumn("FirstName");
        this.addColumn("LastName");
        this.addColumn("Login");
    }

    public void add() {
        for (User x : Collections.usersList) {
            Object[] a = {x.getFirstName(), x.getLastName(), x.getLogin()};
            this.addRow(a);

        }
    }
}
