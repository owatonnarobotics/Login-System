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
    
    // Signs out a user, can also be used to create a new user
    public static void signOut(String id) throws FileNotFoundException, IOException{
        
        Properties property = new Properties();
        
        try (FileInputStream in = new FileInputStream(PROP_LOCATION)) {
            property.load(in);
        }
        
        try (OutputStream output = new FileOutputStream(PROP_LOCATION)) {
            property.setProperty(id, "out");
            
            property.store(output, null);
        }
    }
    
    // Signs a user in through the properties file
    public static void signIn(String id, String time) throws FileNotFoundException, IOException {
        
        Properties property = new Properties();
        
        try (FileInputStream in = new FileInputStream(PROP_LOCATION)) {
            property.load(in);
        }
        
        try (OutputStream output = new FileOutputStream(PROP_LOCATION)) {
            property.setProperty(id, time);
            
            property.store(output, null);
        }
    }
}
;