package Database.Services;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.codehaus.jackson.map.JsonMappingException;

import Database.MongoConnection;
import Database.Models.Project;
import GUI.RegistrationEvents;

public class ProjectService {
	
	public ProjectService()
	{
		
	}

	public void addNewProject(String name, String leaderId)
	{
		Project p = new Project(name,leaderId);
		
        try {
            new MongoConnection().insertProject(p);
        } catch (JsonMappingException ex) {
            Logger.getLogger(RegistrationEvents.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RegistrationEvents.class.getName()).log(Level.SEVERE, null, ex);
        }
			
	}
}
