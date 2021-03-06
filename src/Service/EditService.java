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
public class EditService extends javax.swing.JFrame {
    
    private Service service;
    private ViewServices view;
    private Integer index;
    /**
     * Creates new form AddService
     * @param _view
     * @param _service
     * @param _index
     */
    public EditService(ViewServices _view, Service _service, Integer _index) {
        service = _service;
        index = _index;
        view = _view;
        initComponents();
        
        servicename.setText(service.getServiceName());
        servicetype.setText(service.getEventType());
        
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
        servicename = new javax.swing.JTextField();
        servicetype = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Edit");
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

        servicename.setEnabled(false);
        getContentPane().add(servicename, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 230, -1));

        servicetype.setEnabled(false);
        getContentPane().add(servicetype, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 230, -1));

        jCheckBox1.setText("Service Name:");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jCheckBox2.setText("Service Type:");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

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
        if(jCheckBox1.isSelected()){
            if(servicename.getText().isEmpty()){
                WrongInputException();
                return;
            }
            else
                service.setServiceName(servicename.getText());
        }
        if(jCheckBox2.isSelected()){
            if(servicetype.getText().isEmpty()){
                WrongInputException();
                return;
            }
            else
                service.setEventType(servicetype.getText());
        }
        service.save();
        
        //view.model.addRow(new Object[]{service.getSId(),service.getServiceName(),service.getEventType()});
        view.model.setValueAt(service.getServiceName(), index, 1);
        view.model.setValueAt(service.getEventType(), index, 2);
        
        JOptionPane.showMessageDialog(null, "Service successfully added");
        
    }//GEN-LAST:event_confirmActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if(jCheckBox1.isSelected())
            servicename.setEnabled(true);
        else
            servicename.setEnabled(false);
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
        if(jCheckBox2.isSelected())
            servicetype.setEnabled(true);
        else
            servicetype.setEnabled(false);

    }//GEN-LAST:event_jCheckBox2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JButton confirm;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton reset;
    private javax.swing.JTextField servicename;
    private javax.swing.JTextField servicetype;
    // End of variables declaration//GEN-END:variables

    private void WrongInputException(){
        JOptionPane.showMessageDialog(null, "Fill in the form properly.");
    }
}
