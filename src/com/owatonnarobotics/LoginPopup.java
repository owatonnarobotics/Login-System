/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.owatonnarobotics;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.read.biff.BiffException;

/**
 *
 * @author Eson
 */
public class LoginPopup extends javax.swing.JFrame {

    /**
     * Creates new form LoginPopup
     * @param user the user that is signing in
     */
    public LoginPopup(User user) {
        initComponents();
        
        this.user = user;
        this.calendar = new GregorianCalendar();
        
        setLabels();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inOutButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        fNameLabel = new javax.swing.JLabel();
        lNameLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        timeWeekLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        inOutButton.setText("Out");
        inOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inOutButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        fNameLabel.setText("First Name");

        lNameLabel.setText("Last Name");

        timeLabel.setText("Time: 12:12");

        timeWeekLabel.setText("X hours");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fNameLabel)
                            .addComponent(lNameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(timeWeekLabel))
                            .addComponent(timeLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fNameLabel)
                    .addComponent(timeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNameLabel)
                    .addComponent(timeWeekLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inOutButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void inOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inOutButtonActionPerformed
        if(inOutButton.getText().equals("Out")){
            try {
                int loginTime = LoginManager.signOut(user.getId());
                int totalWorkTime = currentTimeMinutes() - loginTime;
                ExcelManager.setTotalWorkTime(user.getId(), totalWorkTime);
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(LoginPopup.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BiffException ex) {
                Logger.getLogger(LoginPopup.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(inOutButton.getText().equals("In")){
            try {
                LoginManager.signIn(user.getId(), currentTimeMinutes());
                this.dispose();
            } catch(IOException ex) {
                Logger.getLogger(LoginPopup.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_inOutButtonActionPerformed
    
    private void setLabels(){
        fNameLabel.setText(user.getFirstName());
        lNameLabel.setText(user.getLastName());
        
        String formatTime = Integer.toString(calendar.get(Calendar.MINUTE));
        if(formatTime.length() < 2){
            formatTime += "0";
        }
        
        timeLabel.setText("Time: " + calendar.get(Calendar.HOUR) + ":" + formatTime);
        // If there are minutes (not just hours), set the String to those minutes
        String minutes = (user.getTotalTime() % 60 == 0) ? "" : user.getTotalTime() % 60 + "M";
        // Ex: 2H 5M
        timeWeekLabel.setText(Integer.toString(user.getTotalTime() / 60) + "H " + minutes);
        
        try {
            if(LoginManager.userSignedIn(user.getId())){
                inOutButton.setText("Out");
            }
            else{
                inOutButton.setText("In");
            }
        } catch (NullPointerException ex) {
            try {
                // If user doesn't exist in properties, create new user logged out
                LoginManager.createUser(user.getId());
                inOutButton.setText("Out");
            } catch (IOException ex1) {
                Logger.getLogger(LoginPopup.class.getName()).log(Level.SEVERE, null, ex1);
                inOutButton.setText("Error");
            }
        } catch (IOException ex) {
            Logger.getLogger(LoginPopup.class.getName()).log(Level.SEVERE, null, ex);
            inOutButton.setText("Error");
        }
    }
    
    private int currentTimeMinutes(){
        return calendar.get(Calendar.HOUR) * 60 + calendar.get(Calendar.MINUTE);
    }
    
    private User user;
    private GregorianCalendar calendar;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel fNameLabel;
    private javax.swing.JButton inOutButton;
    private javax.swing.JLabel lNameLabel;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel timeWeekLabel;
    // End of variables declaration//GEN-END:variables
}
