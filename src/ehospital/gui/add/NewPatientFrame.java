/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehospital.gui.add;

import ehospital.dao.DbHelper;
import ehospital.model.Patient;
import ehospital.service.PatientService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class NewPatientFrame extends javax.swing.JFrame {

    /**
     * Creates new form PatientRegistrFrame
     */
    private PatientService patientService;
   

    public NewPatientFrame(PatientService patientService) {
        initComponents();
        this.patientService = patientService;
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdBtnGenderMale);
        buttonGroup.add(rdBtnGenderFemale);
        rdBtnGenderMale.setSelected(true);
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDOB = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblSurName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtSurName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        dtDOB = new com.toedter.calendar.JDateChooser();
        rdBtnGenderMale = new javax.swing.JRadioButton();
        rdBtnGenderFemale = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblName.setText("Name:");

        lblSurName.setText("Surname:");

        jLabel3.setText("DOB:");

        lblAddress.setText("Address:");

        lblPhone.setText("Phone:");

        txtSurName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSurNameActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        rdBtnGenderMale.setText("Male");

        rdBtnGenderFemale.setText("Female");

        javax.swing.GroupLayout lblDOBLayout = new javax.swing.GroupLayout(lblDOB);
        lblDOB.setLayout(lblDOBLayout);
        lblDOBLayout.setHorizontalGroup(
            lblDOBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblDOBLayout.createSequentialGroup()
                .addGroup(lblDOBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblDOBLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(lblDOBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lblDOBLayout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(rdBtnGenderMale)
                                .addGap(52, 52, 52)
                                .addComponent(rdBtnGenderFemale))
                            .addGroup(lblDOBLayout.createSequentialGroup()
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(116, 116, 116)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(lblDOBLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(lblDOBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(lblDOBLayout.createSequentialGroup()
                                .addGroup(lblDOBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAddress)
                                    .addComponent(lblPhone))
                                .addGap(72, 72, 72)
                                .addGroup(lblDOBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPhone)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(lblDOBLayout.createSequentialGroup()
                                .addGroup(lblDOBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblName)
                                    .addComponent(lblSurName)
                                    .addComponent(jLabel3))
                                .addGap(72, 72, 72)
                                .addGroup(lblDOBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSurName)
                                    .addComponent(txtName)
                                    .addComponent(dtDOB, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))))))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        lblDOBLayout.setVerticalGroup(
            lblDOBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblDOBLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lblDOBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(lblDOBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSurName)
                    .addComponent(txtSurName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(lblDOBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(dtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(lblDOBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(lblDOBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(lblDOBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdBtnGenderMale)
                    .addComponent(rdBtnGenderFemale))
                .addGap(36, 36, 36)
                .addGroup(lblDOBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(lblDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSurNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSurNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSurNameActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {                                        
            Patient p = new Patient();
            p.setName(txtName.getText());
            p.setSurName(txtSurName.getText());
            p.setDob(dtDOB.getDate());
            p.setGenderID((rdBtnGenderMale.isSelected() == true) ? 1 : 2);
            p.setAddress(txtAddress.getText());
            p.setPhone(txtPhone.getText());
            patientService.addPatient(p);
       
            btnResetActionPerformed(evt);
            JOptionPane.showMessageDialog(null, "Patient Successfully added !!!","Success",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
             
            
          
        } catch (Exception ex) {
           ex.printStackTrace();
           JOptionPane.showMessageDialog(null, "Something went wrong !!!","Error",JOptionPane.ERROR_MESSAGE);
           this.dispose();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtName.setText("");
        txtSurName.setText("");
        dtDOB.setDate(null);
        txtAddress.setText("");
        txtPhone.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private com.toedter.calendar.JDateChooser dtDOB;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JPanel lblDOB;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblSurName;
    private javax.swing.JRadioButton rdBtnGenderFemale;
    private javax.swing.JRadioButton rdBtnGenderMale;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSurName;
    // End of variables declaration//GEN-END:variables
}
