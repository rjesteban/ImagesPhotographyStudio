/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import ORM.Service;
import javax.swing.JOptionPane;

/**
 *
 * @author El Gato
 */
public class AddService extends javax.swing.JFrame {
    
    private Service service;
    private ViewServices view;
    
    /**
     * Creates new form AddService
     */
    public AddService(ViewServices _view) {
        view = _view;
        service = new Service();
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

        jLabel1 = new javax.swing.JLabel();
        confirm = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        servicename = new javax.swing.JTextField();
        servicetype = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Homestead Regular", 0, 18)); // NOI18N
        jLabel1.setText("Add Service");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 11, -1, -1));

        confirm.setText("Confirm");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });
        getContentPane().add(confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, -1, -1));

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        getContentPane().add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, -1, -1));

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        getContentPane().add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, -1, -1));

        jLabel2.setFont(new java.awt.Font("Ribbon", 0, 12)); // NOI18N
        jLabel2.setText("Service Name:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Ribbon", 0, 12)); // NOI18N
        jLabel3.setText("Service Type:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));
        getContentPane().add(servicename, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 230, -1));
        getContentPane().add(servicetype, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 230, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        servicename.setText("");
        servicetype.setText("");
    }//GEN-LAST:event_resetActionPerformed

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        // TODO add your handling code here:
        if(servicename.getText().isEmpty()){
            WrongInputException();
            return;
        }
        else
            service.setServiceName(servicename.getText());
        if(servicetype.getText().isEmpty()){
            WrongInputException();
            return;
        }
        else
            service.setEventType(servicetype.getText());
        
        service.save();
        
        view.model.addRow(new Object[]{service.getSId(),service.getServiceName(),service.getEventType()});
        
        JOptionPane.showMessageDialog(null, "Service successfully added");
        this.dispose();
        
    }//GEN-LAST:event_confirmActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JButton confirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton reset;
    private javax.swing.JTextField servicename;
    private javax.swing.JTextField servicetype;
    // End of variables declaration//GEN-END:variables

    private void WrongInputException(){
        JOptionPane.showMessageDialog(null, "Fill in the form properly.");
    }
}
