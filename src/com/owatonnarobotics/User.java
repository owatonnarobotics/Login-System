/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.owatonnarobotics;

/**
 *
 * @author Eson
 */
public class User {
    private String firstName;
    private String secondName;
    private String id;

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public User(String fName, String lName, String num){
        firstName = fName;
        secondName = lName;
        id = num;
    }
}
