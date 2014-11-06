/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.owatonnarobotics;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

/**
 *
 * @author Eson
 */
public class UserCreator extends javax.swing.JFrame {

    /**
     * Creates new form UserCreator
     */
    public UserCreator() {
        initComponents();
        
        try {
            id = ExcelManager.getFreeID();
        } catch (IOException | BiffException ex) {
            okButton.setText("Error");
            Logger.getLogger(UserCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
        idLabel.setText(id);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fNameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        teamComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        gradeComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        phoneTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        lNameTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        errorLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        shirtSizeComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New User");
        setResizable(false);

        jLabel1.setText("First Name:");

        jLabel2.setText("Team:");

        teamComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Build", "Business", "CAD", "Captain", "Design", "Electrical", "Programming" }));

        jLabel3.setText("Grade:");

        gradeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "9", "10", "11", "12" }));

        jLabel4.setText("Phone:");

        jLabel5.setText("Email:");

        jLabel6.setText("Your ID is:");

        idLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        idLabel.setText("123");
        idLabel.setToolTipText("Remember this!");

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Last Name:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel8.setText("Ex: 507-123-4567");

        errorLabel.setForeground(new java.awt.Color(255, 0, 0));

        jLabel9.setText("T-Shirt Size");

        shirtSizeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "S", "M", "L", "XL", "XXL" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(errorLabel)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8))
                            .addComponent(gradeComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fNameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(teamComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lNameTextField)
                            .addComponent(phoneTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailTextField)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel1))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(idLabel))
                                    .addComponent(jLabel6)))
                            .addComponent(jLabel9))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(shirtSizeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(teamComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gradeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(errorLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shirtSizeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        if(inputsCorrect().equals("yes")){
            
            String fName = fNameTextField.getText().replace(" ", "");
            String lName = lNameTextField.getText().replace(" ", "");
            
            User user = new User(Character.toUpperCase(fName.charAt(0)) + fName.substring(1),
                                 Character.toUpperCase(lName.charAt(0)) + lName.substring(1),
                                 id,
                                 String.valueOf(gradeComboBox.getSelectedItem()),
                                 String.valueOf(teamComboBox.getSelectedItem()),
                                 phoneTextField.getText().replace(" ", ""),
                                 emailTextField.getText().replace(" ", ""),
                                 String.valueOf(shirtSizeComboBox.getSelectedItem()),
                                 0);
            try {
                ExcelManager.writeUser(user);
                this.dispose();
            } catch (IOException | BiffException | WriteException ex) {
                okButton.setText("Error");
                Logger.getLogger(UserCreator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            errorLabel.setText(inputsCorrect());
        }
    }//GEN-LAST:event_okButtonActionPerformed

    // Checks all the the text boxes to make sure inputs are there and correctly formatted,
    // returns error text if not or returns yes if correctly formated
    private String inputsCorrect(){
        if(fNameTextField.getText().equals("") || lNameTextField.getText().equals("") || 
           phoneTextField.getText().equals("") || emailTextField.getText().equals("")){
            return "Fill out all boxes";
        }
        else{
            return "yes";
        }
    }

    private String id;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JTextField fNameTextField;
    private javax.swing.JComboBox gradeComboBox;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lNameTextField;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JComboBox shirtSizeComboBox;
    private javax.swing.JComboBox teamComboBox;
    // End of variables declaration//GEN-END:variables
}
