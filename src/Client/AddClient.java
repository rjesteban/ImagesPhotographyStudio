/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import ORM.Client;
import ORM_Controller.Client_Controller;
import handlers.InputMatcher;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author El Gato
 */
public class AddClient extends javax.swing.JFrame {
    private DefaultComboBoxModel listmodel;
    private EditClient aThis;
    private Integer index;
    
    /**
     * Creates new form AddClient
     */
    public AddClient() {
        setAvailableClientTypes();
        initComponents();
        if(listmodel.getSize()==0)
            ListOfPossibleClientTypes.setEnabled(false);
        
        listmodel.addListDataListener(ListOfPossibleClientTypes);
    }
    
    public AddClient(EditClient _aThis, Integer _index){
        aThis = _aThis;
        index = _index;
        setAvailableClientTypes();
        initComponents();
        if(listmodel.getSize()==0)
            ListOfPossibleClientTypes.setEnabled(false);
        
        listmodel.addListDataListener(ListOfPossibleClientTypes);
    }

    private void setAvailableClientTypes(){
        
        ArrayList ar = new ArrayList(new Client_Controller().viewAllTypes());
        ar.add(0,"Individual");
        ar.add(0,"Corporate");
        listmodel = new DefaultComboBoxModel(ar.toArray());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Add = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ContactNumber_input = new javax.swing.JTextField();
        LastName_input = new javax.swing.JTextField();
        FirstName_input = new javax.swing.JTextField();
        EmailAd_input = new javax.swing.JTextField();
        ListOfPossibleClientTypes = new javax.swing.JComboBox();
        Other = new javax.swing.JRadioButton();
        OtherType_input = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Add.setText("Add");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });
        getContentPane().add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 90, 50));

        jLabel1.setText("Contact Number:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel2.setText("Last Name:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel3.setText("First Name:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel4.setText("Client Type:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel5.setText("Email Ad:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));
        getContentPane().add(ContactNumber_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 190, -1));
        getContentPane().add(LastName_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 190, -1));
        getContentPane().add(FirstName_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 190, -1));
        getContentPane().add(EmailAd_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 190, -1));

        ListOfPossibleClientTypes.setModel(listmodel);
        getContentPane().add(ListOfPossibleClientTypes, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 190, -1));

        Other.setText("Other");
        Other.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OtherActionPerformed(evt);
            }
        });
        getContentPane().add(Other, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, -1, -1));

        OtherType_input.setEnabled(false);
        getContentPane().add(OtherType_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 120, -1));

        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 80, 50));

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 110, 50));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel6.setText("Add Client");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 80, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OtherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OtherActionPerformed
        // TODO add your handling code here:
        if(Other.isSelected()){
            ListOfPossibleClientTypes.setEnabled(false);
            OtherType_input.setEnabled(true);
        }
        else{
            ListOfPossibleClientTypes.setEnabled(true);
            OtherType_input.setEnabled(false);
        }
    }//GEN-LAST:event_OtherActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        // TODO add your handling code here:
        Client c = new Client();
        //c.setCId(1);
        c.setCContactNumber(ContactNumber_input.getText());
        c.setCEmailAd(EmailAd_input.getText());
        c.setCFirstname(FirstName_input.getText());
        c.setCLastname(LastName_input.getText());
        
        if(Other.isSelected()){
            c.setClientType(OtherType_input.getText());
        }
        else{
            c.setClientType(String.valueOf(ListOfPossibleClientTypes.getSelectedItem()));
        }
        
        
        Client r = new Client_Controller().findDuplicate(c);
        
        if(r!=null){
            JOptionPane.showMessageDialog(null,"Contact already exists");
            return;
        }
        else if(InputMatcher.isEmail(c.getCEmailAd()) && !InputMatcher.isContactNumber(c.getCContactNumber()) &&
                !c.getCFirstname().isEmpty() && !c.getCLastname().isEmpty() && !c.getClientType().isEmpty()){
            c.save();
            JOptionPane.showMessageDialog(null, "Contact Added");
            
            
            
            //aThis.model.setValueAt(aThis, index, WIDTH);
            aThis.model.addRow(new Object[]{c.getCId(), 
                c.getCLastname(), 
                c.getCFirstname(),
                c.getClientType(),
                c.getCEmailAd(),
                c.getCContactNumber()
            });
            
        }
        else{
            System.out.println(InputMatcher.isEmail(c.getCEmailAd()));
            System.out.println(!InputMatcher.isContactNumber(c.getCContactNumber()));
            System.out.println(!c.getCFirstname().isEmpty());
            System.out.println(!c.getCLastname().isEmpty());
            System.out.println(!c.getClientType().isEmpty());
            JOptionPane.showMessageDialog(null, "Fill out the information properly");
        }
        
    }//GEN-LAST:event_AddActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ContactNumber_input.setText("");
        EmailAd_input.setText("");
        FirstName_input.setText("");
        LastName_input.setText("");
        OtherType_input.setText("");
        Other.setSelected(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JTextField ContactNumber_input;
    private javax.swing.JTextField EmailAd_input;
    private javax.swing.JTextField FirstName_input;
    private javax.swing.JTextField LastName_input;
    private javax.swing.JComboBox ListOfPossibleClientTypes;
    private javax.swing.JRadioButton Other;
    private javax.swing.JTextField OtherType_input;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
