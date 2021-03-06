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

/**
 *
 * @author Eson
 */
public class ForgotIDScreen extends javax.swing.JFrame {

    /**
     * Creates new form ForgotIDScreen
     */
    public ForgotIDScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idDialog = new javax.swing.JDialog();
        dialogLabel = new javax.swing.JLabel();
        idDialogLabel = new javax.swing.JLabel();
        okDialogButton = new javax.swing.JButton();
        lNameTextBox = new javax.swing.JTextField();
        fNameLabel = new javax.swing.JLabel();
        findButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        lNameLabel = new javax.swing.JLabel();
        fNameTextBox = new javax.swing.JTextField();
        errorLabel = new javax.swing.JLabel();

        idDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        idDialog.setTitle("Your ID");
        idDialog.setBounds(new java.awt.Rectangle(0, 0, 105, 88));
        idDialog.setResizable(false);
        idDialog.getContentPane().setLayout(new java.awt.FlowLayout());

        dialogLabel.setText("Your ID is:");
        idDialog.getContentPane().add(dialogLabel);

        idDialogLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        idDialogLabel.setText("321");
        idDialog.getContentPane().add(idDialogLabel);

        okDialogButton.setText("OK");
        okDialogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okDialogButtonActionPerformed(evt);
            }
        });
        idDialog.getContentPane().add(okDialogButton);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Forgot ID");
        setResizable(false);

        lNameTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lNameTextBoxActionPerformed(evt);
            }
        });

        fNameLabel.setText("First Name:");

        findButton.setText("Find");
        findButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        lNameLabel.setText("Last Name:");

        errorLabel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fNameLabel)
                            .addComponent(fNameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lNameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lNameLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(errorLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(findButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fNameLabel)
                    .addComponent(lNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fNameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(findButton)
                        .addComponent(errorLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findButtonActionPerformed
        String fName = fNameTextBox.getText().replace(" ", "");
        String lName = lNameTextBox.getText().replace(" ", "");
        
        if(fName.equals("") || lName.equals("")){
            errorLabel.setText("Fill box");
        }
        else{
            try {
                String id = ExcelManager.findUser(fName, lName);
                
                if(id == null){
                    errorLabel.setText("Not Fnd");
                }
                else{
                    idDialogLabel.setText(id);
                    idDialog.setBounds(this.getX() + 35, this.getY() + 30, idDialog.getWidth(), idDialog.getHeight());
                    idDialog.setVisible(true);
                    this.dispose();
                }
            } catch (IOException | BiffException ex) {
                errorLabel.setText("Error");
                Logger.getLogger(ForgotIDScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_findButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        idDialog.dispose();
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okDialogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okDialogButtonActionPerformed
        idDialog.dispose();
    }//GEN-LAST:event_okDialogButtonActionPerformed

    private void lNameTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lNameTextBoxActionPerformed
        findButtonActionPerformed(evt);
    }//GEN-LAST:event_lNameTextBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel dialogLabel;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel fNameLabel;
    private javax.swing.JTextField fNameTextBox;
    private javax.swing.JButton findButton;
    private javax.swing.JDialog idDialog;
    private javax.swing.JLabel idDialogLabel;
    private javax.swing.JLabel lNameLabel;
    private javax.swing.JTextField lNameTextBox;
    private javax.swing.JButton okDialogButton;
    // End of variables declaration//GEN-END:variables
}
