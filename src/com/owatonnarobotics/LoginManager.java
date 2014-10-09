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
    
    // Tells if the user is signed in
    public static boolean userSignedIn(String id) throws FileNotFoundException, IOException{
        
        Properties property = new Properties();
        try (InputStream input = new FileInputStream(PROP_LOCATION)) {
            property.load(input);
        
            return ! property.getProperty(id).equals("out");
        }
    }
    
    public static void createUser(String id) throws FileNotFoundException, IOException{
        Properties property = new Properties();
        
        try (FileInputStream in = new FileInputStream(PROP_LOCATION)) {
            property.load(in);
        }
        
        try (OutputStream output = new FileOutputStream(PROP_LOCATION)) {
            property.setProperty(id, "out");
            
            property.store(output, null);
        }
    }
    
    // Signs out a user and returns the inital time they signed in
    public static int signOut(String id) throws FileNotFoundException, IOException{
        
        Properties property = new Properties();
        
        try (FileInputStream in = new FileInputStream(PROP_LOCATION)) {
            property.load(in);
        }
        
        try (OutputStream output = new FileOutputStream(PROP_LOCATION)) {
            int time = Integer.getInteger(property.getProperty(id));
            property.setProperty(id, "out");
            
            property.store(output, null);
            return time;
        }
    }
    
    // Signs a user in through the properties file
    public static void signIn(String id, int time) throws FileNotFoundException, IOException {
        
        Properties property = new Properties();
        
        try (FileInputStream in = new FileInputStream(PROP_LOCATION)) {
            property.load(in);
        }
        
        try (OutputStream output = new FileOutputStream(PROP_LOCATION)) {
            property.setProperty(id, Integer.toString(time));
            
            property.store(output, null);
        }
    }
}
;