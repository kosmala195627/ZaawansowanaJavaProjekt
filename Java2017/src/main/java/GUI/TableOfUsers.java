package GUI;

import JavaProject2017.Java2017.Collections;
import JavaProject2017.Java2017.User;
import javax.swing.table.DefaultTableModel;

/*
    Klasa odpowiedzialna za stworzenie tabeli zawierajacej uzytkownikow
 */
public class TableOfUsers extends DefaultTableModel implements ITable {
    public TableOfUsers() {
        this.addColumn("Id");
        this.addColumn("FirstName");
        this.addColumn("LastName");
	this.addColumn("Login");
    }
    
    public void add()
	{
		for(User x : Collections.usersList)
		{
			Object[] a = { x.getId(), x.getFirstName(), x.getLastName(), x.getLogin()};
			this.addRow(a);
			
		}
	}
}
