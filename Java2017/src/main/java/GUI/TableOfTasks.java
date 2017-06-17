package GUI;

import javax.swing.table.DefaultTableModel;

import Database.Collections;
import Database.Models.User;

/*
    Klasa odpowiedzialna za stworzenie tabeli zawierajacej uzytkownikow
 */
public class TableOfTasks extends DefaultTableModel implements ITable {
    public TableOfTasks() {
        this.addColumn("Task name");
        this.addColumn("Status");
        this.addColumn("End Date");
        this.addColumn("Responsible person");
    }

	public void add() {
		// TODO Auto-generated method stub
		
	}
    
}
