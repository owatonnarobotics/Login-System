package com.owatonnarobotics;

import java.util.Random;

/**
 * A user signing in and out of the database
 * @author Eson
 */
public class User {
    private String firstName;
    private String lastName;
    private String grade;
    private String team;
    private String phone;
    private String email;
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
    
    public String getGrade() {
        return grade;
    }

    public String getTeam() {
        return team;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
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

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setTotalTime(int totalTime){
        this.totalTime = totalTime;
    }
    
    // Generates a random ID
    public static String randomID(Random random){
        
        String randomNum1 = Integer.toString(random.nextInt(10));
        String randomNum2 = Integer.toString(random.nextInt(10));
        String randomNum3 = Integer.toString(random.nextInt(10));
        
        return randomNum1 + randomNum2 + randomNum3;
    }
    
    public User(String firstName, String lastName, String id, String grade, String team, String phone, String email, int totalTime){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.totalTime = totalTime;
        this.grade = grade;
        this.team = team;
        this.phone = phone;
        this.email = email;
    }
}
