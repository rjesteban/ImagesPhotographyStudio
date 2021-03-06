/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Booking;

import Client.EditClient;
import ORM.Booking;
import ORM.Client;
import ORM_Controller.Booking_Controller;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author El Gato
 */
public class ClientBookings extends javax.swing.JFrame {
    protected DefaultTableModel model;
    private Client client;
    private Integer key, index;
    private Booking booking;
    private EditClient aThis;
    /**
     * Creates new form Bookings
     * @param _c
     */
    public ClientBookings(Client _c, EditClient _aThis) {
        aThis = _aThis;
        client = _c;
        model = new DefaultTableModel();
        setTable();
        
        initComponents();
        Name_display.setText(_c.getCLastname()+ ", " + _c.getCFirstname());
        Cid_display.setText(String.valueOf(_c.getCId()));
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
        Name_display = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Cid_display = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        ADD_Booking = new javax.swing.JButton();
        Edit_Booking = new javax.swing.JButton();
        Delete_Booking = new javax.swing.JButton();
        Archive_Booking = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ribbon", 0, 24)); // NOI18N
        jLabel1.setText("Bookings of: ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 22, -1, 37));

        Name_display.setFont(new java.awt.Font("Ribbon", 0, 18)); // NOI18N
        Name_display.setText(" ");
        getContentPane().add(Name_display, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 411, 37));

        jLabel2.setFont(new java.awt.Font("Ribbon", 0, 14)); // NOI18N
        jLabel2.setText("CID:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 27));

        Cid_display.setFont(new java.awt.Font("Ribbon", 0, 14)); // NOI18N
        Cid_display.setText(" ");
        getContentPane().add(Cid_display, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 90, 22));

        table.setModel(model);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 115, 690, 250));

        ADD_Booking.setText("ADD");
        ADD_Booking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD_BookingActionPerformed(evt);
            }
        });
        getContentPane().add(ADD_Booking, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, -1, -1));

        Edit_Booking.setText("EDIT");
        Edit_Booking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Edit_BookingActionPerformed(evt);
            }
        });
        getContentPane().add(Edit_Booking, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, -1, -1));

        Delete_Booking.setText("DELETE");
        Delete_Booking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_BookingActionPerformed(evt);
            }
        });
        getContentPane().add(Delete_Booking, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 400, -1, -1));

        Archive_Booking.setText("ARCHIVE");
        Archive_Booking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Archive_BookingActionPerformed(evt);
            }
        });
        getContentPane().add(Archive_Booking, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 400, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        key = Integer.valueOf(String.valueOf(model.getValueAt(table.getSelectedRow(),0)));
        booking = new Booking_Controller().findBooking(key);
        
        System.out.println("id: " + booking.getCId());
        index = table.getSelectedRow();
        
        ADD_Booking.setEnabled(true);
        Edit_Booking.setEnabled(true);
        Delete_Booking.setEnabled(true);
        Archive_Booking.setEnabled(true);
    }//GEN-LAST:event_tableMouseClicked

    private void ADD_BookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD_BookingActionPerformed
        // TODO add your handling code here:
        new BookOldClient(
                client,
                key, 
                index,this).setVisible(true);
    }//GEN-LAST:event_ADD_BookingActionPerformed

    private void Edit_BookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Edit_BookingActionPerformed
        // TODO add your handling code here:
        new EditBooking(booking, key, index, this).setVisible(true);
    }//GEN-LAST:event_Edit_BookingActionPerformed

    private void Delete_BookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_BookingActionPerformed
        // TODO add your handling code here:
        
        
        
//        ArrayList<Booking> delete = new ArrayList<>(aThis.getTheClient().getBookingCollection());
//        delete.remove(new Booking_Controller().deleteBooking(key));
        new Booking_Controller().deleteBooking(key);
        aThis.getTheClient().save();
        model.removeRow(index);
    }//GEN-LAST:event_Delete_BookingActionPerformed

    private void Archive_BookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Archive_BookingActionPerformed
        // TODO add your handling code here:
        Booking r = new Booking_Controller().findBooking(key);
        if(r.getIsArchived())
            r.setIsArchived(false);
        else
            r.setIsArchived(true);
        model.setValueAt(r.getIsArchived(), index, 9);
        r.save();
        
    }//GEN-LAST:event_Archive_BookingActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD_Booking;
    private javax.swing.JButton Archive_Booking;
    private javax.swing.JLabel Cid_display;
    private javax.swing.JButton Delete_Booking;
    private javax.swing.JButton Edit_Booking;
    private javax.swing.JLabel Name_display;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    private void setTable(){
        model.addColumn("B ID");
        model.addColumn("Photographer");
        model.addColumn("Assistant");
        model.addColumn("Service Ordered");
        model.addColumn("Event Type");
        model.addColumn("Date");
        model.addColumn("Time in");
        model.addColumn("Time out");
        model.addColumn("Location");
        model.addColumn("Archived");
        
        
        
//        aThis.model.setValueAt(b.getPId(), index, 1);
//        aThis.model.setValueAt(b.getApId(), index, 2);
//        aThis.model.setValueAt(b.getSId().getServiceName(), index, 3);
//        aThis.model.setValueAt(b.getSId().getEventType(), index, 4);
//        aThis.model.setValueAt(b.getSDate().getMonth()  +"/" + b.getSDate().getDate() + "/" + b.getSDate().getYear(), index, 5);
//        aThis.model.setValueAt(b.getTimeIn(), index, 6);
//        aThis.model.setValueAt(b.getTimeOut(), index, 7);
//        aThis.model.setValueAt(b.getLocation(), index, 8);
//        aThis.model.setValueAt(b.getIsArchived(), index, 9);
        ArrayList<Booking> allBookings = new ArrayList<>(new Booking_Controller().viewAllBookings());
        ArrayList<Booking> allbookingsofthisclient = new ArrayList<>();
        
        for(Booking tuple : allBookings){
            if(tuple.getCId().getCId()== client.getCId()) {
                //were talking about the same client
                allbookingsofthisclient = new ArrayList<>(tuple.getCId().getBookingCollection());
                break;
            }
        }
        
        for(Booking tuple: allbookingsofthisclient){
            int _year = tuple.getSDate().getYear()+1900;
            Object[] rowData = new Object[]{
                tuple.getBId(), 
                tuple.getPId(), 
                tuple.getApId(),
                tuple.getSId().getServiceName(), 
                tuple.getSId().getEventType(), 
                tuple.getSDate().getMonth()  +"/" + tuple.getSDate().getDate() + "/" + _year, 
                tuple.getTimeIn(), 
                tuple.getTimeOut(),
                tuple.getLocation(), 
                tuple.getIsArchived()};
            model.addRow(rowData);
        }
        
    }
}
