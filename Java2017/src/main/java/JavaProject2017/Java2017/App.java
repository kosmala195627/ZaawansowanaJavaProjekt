package JavaProject2017.Java2017;

import GUI.Main;
import java.io.IOException;
import org.codehaus.jackson.map.JsonMappingException;

import Database.MongoConnection;

public class App {

    public static void main(String[] args) throws JsonMappingException, IOException {

        MongoConnection conn = new MongoConnection();
        new Main();
    }
}
