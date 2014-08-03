package com.owatonnarobotics;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Edits the properties file that will contain 
 * @author Eson
 */
public class LoginManager {
    
    private static final String PROP_LOCATION = "login.properties";
    
    public static void createUser(String id) throws FileNotFoundException, IOException{
        
        Properties prop = new Properties();
        OutputStream output = null;
        
        output = new FileOutputStream(PROP_LOCATION);
        
        prop.setProperty(id, "out");
        
        prop.store(output, null);
        
        output.close();
    }
}
