package com.owatonnarobotics;

/**
 * A user signing in and out of the database
 * @author Eson
 */
public class User {
    private String firstName;
    private String lastName;
    private int totalTime;
    // A 3 digit id
    private String id;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }
    
    public int getTotalTime(){
        return totalTime;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void setTotalTime(int totalTime){
        this.totalTime = totalTime;
    }
    
    public User(String firstName, String lastName, String id, int totalTime){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.totalTime = totalTime;
    }
}
