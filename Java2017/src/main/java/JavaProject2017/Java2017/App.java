package JavaProject2017.Java2017;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import GUI.Login;
import GUI.Main;


public class App 
{
    public static void main( String[] args ) throws JsonMappingException, IOException {
    	
    	
    	Main mainWindow = new Main();
    	Login gui = new Login(mainWindow);
      
  
		
     
    }
}
