package Database.Services;

import Database.Collections;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.codehaus.jackson.map.JsonMappingException;

import Database.MongoConnection;
import Database.Models.Project;
import GUI.RegistrationEvents;
import java.util.ArrayList;

public class ProjectService {

    public ProjectService() {

    }

    public Project[] getAllProjects() {
        Project[] result = new Project[Collections.projectsList.size()];
        return Collections.projectsList.toArray(result);
    }

    public String[] getAllProjects(Project[] tab) {
        String[] result = new String[tab.length];
        ArrayList<String> temp = new ArrayList<String>();
        for (Project x : tab) {
            temp.add(x.getName());
        }
        return temp.toArray(result);
    }

    public void addNewProject(String name, String leaderId) {
        Project p = new Project(name, leaderId);

        try {
            new MongoConnection().insertProject(p);
        } catch (JsonMappingException ex) {
            Logger.getLogger(RegistrationEvents.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RegistrationEvents.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
