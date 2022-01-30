/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehospital.gui.edit;

import ehospital.model.Receipt;
import ehospital.model.Registration;
import ehospital.service.DiseaseService;
import ehospital.service.DoctorService;
import ehospital.service.PatientService;
import ehospital.service.ReceiptService;
import ehospital.service.RegistrationService;
import java.awt.Image;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class EditReceiptFrame extends javax.swing.JFrame {
    
    PatientService patientService;
    DoctorService doctorService;
    DiseaseService diseaseService;
    RegistrationService registrationService;
    ReceiptService receiptService;
    private Long selectedRow;
    
    public EditReceiptFrame(PatientService patientService, DoctorService doctorService, DiseaseService diseaseService, RegistrationService registrationService, ReceiptService receiptService, Long selectedRow) {
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.diseaseService = diseaseService;
        this.registrationService = registrationService;
        this.receiptService = receiptService;
        this.selectedRow = selectedRow;
        initComponents();
        fillRegistrationCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnReset = new javax.swing.JButton();
        lblRegistration = new javax.swing.JLabel();
        lblRegisterIcn = new javax.swing.JLabel();
        lblMedicine = new javax.swing.JLabel();
        txtMedicine = new javax.swing.JTextField();
        cmbRegistration = new javax.swing.JComboBox<>();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnReset.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        lblRegistration.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        lblRegistration.setForeground(java.awt.Color.blue);
        lblRegistration.setText("Receipt");

        lblRegisterIcn.setAutoscrolls(true);
        lblRegisterIcn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lblMedicine.setText("Medicine:");

        cmbRegistration.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbRegistration.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Registration" }));
        cmbRegistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRegistrationActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnReset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(lblRegisterIcn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbRegistration, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMedicine)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMedicine)))
                .addGap(85, 85, 85))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRegisterIcn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88)
                .addComponent(cmbRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMedicine)
                    .addComponent(txtMedicine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(121, 121, 121)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\hp\\Desktop\\Java\\iconsEhospital\\receipticon.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);  // transform it back}
    lblRegisterIcn.setIcon(imageIcon);

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        cmbRegistration.setSelectedItem("Select Registration");
        txtMedicine.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void cmbRegistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRegistrationActionPerformed

    }//GEN-LAST:event_cmbRegistrationActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            
            Receipt receipt = new Receipt();
            receipt.setId(selectedRow);
            Registration registration = (Registration) cmbRegistration.getSelectedItem();
            System.out.println(txtMedicine.getText());
            receipt.setMedicineName(txtMedicine.getText());
            receipt.setRegistration(registration);
            receiptService.updateReceipt(receipt);
            JOptionPane.showMessageDialog(null, "Receipt Successfully updated !!!", "Success", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed
    private void fillRegistrationCombo() {
        try {
            List<Registration> registrations = registrationService.getRegistationList(1);
            Receipt receipt = receiptService.getReceiptById(selectedRow);
            txtMedicine.setText(receipt.getMedicineName());
            DefaultComboBoxModel registrationCombo = (DefaultComboBoxModel) cmbRegistration.getModel();
            Registration registration1 = registrationService.getRegistrationById(receipt.getRegistration().getId());
            for (Registration registration : registrations) {                
                registrationCombo.addElement(registration);
                if (registration.getId() == registration1.getId()) {
                   registration1.setR(registration.getR());
                }
            }
            registrationCombo.setSelectedItem(registration1);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbRegistration;
    private javax.swing.JLabel lblMedicine;
    private javax.swing.JLabel lblRegisterIcn;
    private javax.swing.JLabel lblRegistration;
    private javax.swing.JTextField txtMedicine;
    // End of variables declaration//GEN-END:variables
}