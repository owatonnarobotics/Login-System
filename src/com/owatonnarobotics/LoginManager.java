package com.owatonnarobotics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Edits the properties file that will contain 
 * @author Eson
 */
public class LoginManager {
    
    private static final String PROP_LOCATION = "login.properties";
    
    public static void createUser(String id) throws FileNotFoundException, IOException{
        
        Properties property = new Properties();
        OutputStream output = new FileOutputStream(PROP_LOCATION);
        
        property.setProperty(id, "out");
        
        property.store(output, null);
        
        output.close();
    }
    
    public static boolean userSignedIn(String id) throws FileNotFoundException, IOException{
        
        Properties property = new Properties();
        InputStream input = new FileInputStream(PROP_LOCATION);
        
        property.load(input);
        
        return ! property.getProperty(id).equals("out");
    }
}
