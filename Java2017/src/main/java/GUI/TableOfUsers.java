package GUI;

import javax.swing.table.DefaultTableModel;

import Database.Collections;
import Database.Models.User;

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
