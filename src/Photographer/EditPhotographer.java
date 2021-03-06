/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Photographer;

import ORM.Photographer;
import ORM_Controller.Photographer_Controller;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author El Gato
 */
public class EditPhotographer extends javax.swing.JFrame {
    protected DefaultTableModel model;
    private Integer key, index;
    private Photographer_Controller pc;
    private Photographer p;
    /**
     * Creates new form updatePhotographer
     */
    public EditPhotographer() {
        pc = new Photographer_Controller();
        p = new Photographer();
        initializeModel();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        edit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setModel(model);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 620, 240));

        edit.setText("Edit");
        edit.setEnabled(false);
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        getContentPane().add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 130, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Edit Photographer");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        key = Integer.valueOf(String.valueOf(model.getValueAt(table.getSelectedRow(),0)));
        p = pc.findPhotographer(key);
        index = table.getSelectedRow();
        edit.setEnabled(true);
    }//GEN-LAST:event_tableMouseClicked

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        //pc.updateP;
        new UpdatePhotographer(p, key, index, this).setVisible(true);
        edit.setEnabled(false);
        //model.removeRow(index);
    }//GEN-LAST:event_editActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    private void initializeModel() {
        model = new DefaultTableModel();
        model.addColumn("PID");
        model.addColumn("LastName");
        model.addColumn("FirstName");
        model.addColumn("EmploymentStatus");
        model.addColumn("Email ad");
        model.addColumn("Contact Number");
        ArrayList<Photographer> arr = new ArrayList<Photographer>(pc.viewAllPhotographers());
        for(Photographer p_tuple:arr){
            Object[] insert = {p_tuple.getPId(),p_tuple.getPLastname(),p_tuple.getPFirstname(),p_tuple.getEmploymentStatus(),p_tuple.getPEmailAd(),p_tuple.getPContactNumber()};
            model.addRow(insert);
        }
    }
}
