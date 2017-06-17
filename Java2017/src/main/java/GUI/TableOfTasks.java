package GUI;

import JavaProject2017.Java2017.Collections;
import JavaProject2017.Java2017.User;
import javax.swing.table.DefaultTableModel;

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
