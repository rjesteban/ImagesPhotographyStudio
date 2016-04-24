/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Photographer;

import ORM.Client;
import ORM.Photographer;
import ORM_Controller.Client_Controller;
import ORM_Controller.Controller;
import ORM_Controller.Photographer_Controller;
import handlers.InputMatcher;
import java.util.ArrayList;
import java.util.TreeSet;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class addPhotographer_Frame extends javax.swing.JFrame {

    /**
     * Creates new form addPhotographer_Frame
     */
    public addPhotographer_Frame() {
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

        basicInfo = new javax.swing.JPanel();
        name_Label = new javax.swing.JLabel();
        last_name_Input = new javax.swing.JTextField();
        contactNumber_Label = new javax.swing.JLabel();
        contactNumber_Input = new javax.swing.JTextField();
        emailAddress_Label = new javax.swing.JLabel();
        emailAddress_Input = new javax.swing.JTextField();
        name_Label1 = new javax.swing.JLabel();
        first_name_Input1 = new javax.swing.JTextField();
        otherInfo = new javax.swing.JPanel();
        status_Label = new javax.swing.JLabel();
        regular_RadioB = new javax.swing.JRadioButton();
        freelance_RadioB = new javax.swing.JRadioButton();
        other_radioB = new javax.swing.JRadioButton();
        otherStatus_Input = new javax.swing.JTextField();
        addPG_Buttons = new javax.swing.JPanel();
        cancelP_Button = new javax.swing.JButton();
        confirmP_Button = new javax.swing.JButton();
        resetP_Button = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        basicInfo.setBackground(new java.awt.Color(0, 102, 204));
        basicInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Basic Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        name_Label.setFont(new java.awt.Font("Homestead Display", 0, 18)); // NOI18N
        name_Label.setText("Last Name");

        last_name_Input.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        contactNumber_Label.setFont(new java.awt.Font("Homestead Display", 0, 18)); // NOI18N
        contactNumber_Label.setText("Contact Number");

        contactNumber_Input.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        emailAddress_Label.setFont(new java.awt.Font("Homestead Display", 0, 18)); // NOI18N
        emailAddress_Label.setText("Email Address");

        emailAddress_Input.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        name_Label1.setFont(new java.awt.Font("Homestead Display", 0, 18)); // NOI18N
        name_Label1.setText("First Name");

        first_name_Input1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        javax.swing.GroupLayout basicInfoLayout = new javax.swing.GroupLayout(basicInfo);
        basicInfo.setLayout(basicInfoLayout);
        basicInfoLayout.setHorizontalGroup(
            basicInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(basicInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(basicInfoLayout.createSequentialGroup()
                        .addComponent(emailAddress_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(emailAddress_Input))
                    .addGroup(basicInfoLayout.createSequentialGroup()
                        .addComponent(contactNumber_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contactNumber_Input, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, basicInfoLayout.createSequentialGroup()
                        .addGroup(basicInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name_Label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(basicInfoLayout.createSequentialGroup()
                                .addComponent(name_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(basicInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(last_name_Input, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                            .addComponent(first_name_Input1))))
                .addContainerGap())
        );
        basicInfoLayout.setVerticalGroup(
            basicInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(basicInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(basicInfoLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(last_name_Input, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(basicInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name_Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(basicInfoLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(first_name_Input1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(basicInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contactNumber_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactNumber_Input, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(basicInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailAddress_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(basicInfoLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(emailAddress_Input, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        getContentPane().add(basicInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 190));

        otherInfo.setBackground(new java.awt.Color(0, 102, 153));
        otherInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Other Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        status_Label.setFont(new java.awt.Font("Homestead Display", 0, 18)); // NOI18N
        status_Label.setText("Employment Status");

        regular_RadioB.setFont(new java.awt.Font("Ribbon", 0, 18)); // NOI18N
        regular_RadioB.setText("Regular");
        regular_RadioB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regular_RadioBActionPerformed(evt);
            }
        });

        freelance_RadioB.setFont(new java.awt.Font("Ribbon", 0, 18)); // NOI18N
        freelance_RadioB.setText("Freelance");
        freelance_RadioB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                freelance_RadioBActionPerformed(evt);
            }
        });

        other_radioB.setFont(new java.awt.Font("Ribbon", 0, 18)); // NOI18N
        other_radioB.setText("other");
        other_radioB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                other_radioBActionPerformed(evt);
            }
        });

        otherStatus_Input.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        otherStatus_Input.setEnabled(false);

        javax.swing.GroupLayout otherInfoLayout = new javax.swing.GroupLayout(otherInfo);
        otherInfo.setLayout(otherInfoLayout);
        otherInfoLayout.setHorizontalGroup(
            otherInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(otherInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(otherInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(otherInfoLayout.createSequentialGroup()
                        .addGroup(otherInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(status_Label)
                            .addGroup(otherInfoLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(regular_RadioB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(freelance_RadioB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(other_radioB, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 61, Short.MAX_VALUE))
                    .addComponent(otherStatus_Input))
                .addContainerGap())
        );
        otherInfoLayout.setVerticalGroup(
            otherInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(otherInfoLayout.createSequentialGroup()
                .addComponent(status_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(otherInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regular_RadioB)
                    .addComponent(freelance_RadioB)
                    .addComponent(other_radioB))
                .addGap(16, 16, 16)
                .addComponent(otherStatus_Input, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(otherInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 410, 150));

        addPG_Buttons.setBackground(new java.awt.Color(0, 102, 102));

        cancelP_Button.setFont(new java.awt.Font("Homestead Display", 0, 14)); // NOI18N
        cancelP_Button.setText("Cancel");
        cancelP_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelP_ButtonActionPerformed(evt);
            }
        });

        confirmP_Button.setFont(new java.awt.Font("Homestead Display", 0, 14)); // NOI18N
        confirmP_Button.setText("Confirm");
        confirmP_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmP_ButtonActionPerformed(evt);
            }
        });

        resetP_Button.setFont(new java.awt.Font("Homestead Display", 0, 14)); // NOI18N
        resetP_Button.setText("Reset");
        resetP_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetP_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addPG_ButtonsLayout = new javax.swing.GroupLayout(addPG_Buttons);
        addPG_Buttons.setLayout(addPG_ButtonsLayout);
        addPG_ButtonsLayout.setHorizontalGroup(
            addPG_ButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPG_ButtonsLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(confirmP_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(resetP_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelP_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        addPG_ButtonsLayout.setVerticalGroup(
            addPG_ButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPG_ButtonsLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(addPG_ButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetP_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelP_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmP_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(addPG_Buttons, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 410, 70));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Backgrounds.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regular_RadioBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regular_RadioBActionPerformed
        freelance_RadioB.setSelected(false);
        other_radioB.setSelected(false);
        otherStatus_Input.setEnabled(false);
    }//GEN-LAST:event_regular_RadioBActionPerformed

    private void freelance_RadioBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_freelance_RadioBActionPerformed
        other_radioB.setSelected(false);
        regular_RadioB.setSelected(false);
        otherStatus_Input.setEnabled(false);
    }//GEN-LAST:event_freelance_RadioBActionPerformed

    private void other_radioBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_other_radioBActionPerformed
        freelance_RadioB.setSelected(false);
        regular_RadioB.setSelected(false);
        otherStatus_Input.setEnabled(true);
    }//GEN-LAST:event_other_radioBActionPerformed

    private void cancelP_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelP_ButtonActionPerformed
        this.dispose();
        resetP_ButtonActionPerformed(null);
    }//GEN-LAST:event_cancelP_ButtonActionPerformed

    private void confirmP_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmP_ButtonActionPerformed
        // TODO add your handling code here:
        Photographer p = new Photographer();
        Photographer_Controller pc = new Photographer_Controller();
        
        String lname = last_name_Input.getText();
        String fname = first_name_Input1.getText();
        String cnum = contactNumber_Input.getText();
        String email = emailAddress_Input.getText();
        boolean reg = regular_RadioB.isSelected();
        boolean free = freelance_RadioB.isSelected();
        boolean other = other_radioB.isSelected();
        String other_c = otherStatus_Input.getText();
        
        
        if(reg == true){
            p.setEmploymentStatus("Regular");
        }
        else if(free == true){
            p.setEmploymentStatus("Freelance");
        }
        
        else if(other == true){
            if(!other_c.isEmpty())
                p.setEmploymentStatus(other_c);
            else{
                JOptionPane.showMessageDialog(null, "Fill out the information properly");
                return;
            }
        }
        
        p.setPContactNumber(cnum);
        p.setPEmailAd(email);
        p.setPFirstname(fname);
        p.setPLastname(lname);
        
        Photographer s = pc.findDuplicate(p);
        
        if(s!=null){
            JOptionPane.showMessageDialog(null, "Photographer Already Exists");
        }
        
        else if(InputMatcher.isEmail(email) && !InputMatcher.isContactNumber(cnum) &&
                !lname.isEmpty() && !fname.isEmpty()
           ){
            p.save();
            JOptionPane.showMessageDialog(null, "Photographer Added");
        }
        else{
            System.out.println(InputMatcher.isEmail(email));
            System.out.println(InputMatcher.isContactNumber(cnum));
            System.out.println(!lname.isEmpty());
            System.out.println(!fname.isEmpty());
            JOptionPane.showMessageDialog(null, "Fill out the information properly");
        }
        
    }//GEN-LAST:event_confirmP_ButtonActionPerformed

    private void resetP_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetP_ButtonActionPerformed
        other_radioB.setSelected(false);
        regular_RadioB.setSelected(false);
        freelance_RadioB.setSelected(false);
        otherStatus_Input.setEnabled(false);
        otherStatus_Input.setText("");
        last_name_Input.setText("");
        first_name_Input1.setText("");
        contactNumber_Input.setText("");
        emailAddress_Input.setText("");
    }//GEN-LAST:event_resetP_ButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addPG_Buttons;
    private javax.swing.JPanel basicInfo;
    private javax.swing.JButton cancelP_Button;
    private javax.swing.JButton confirmP_Button;
    private javax.swing.JTextField contactNumber_Input;
    private javax.swing.JLabel contactNumber_Label;
    private javax.swing.JTextField emailAddress_Input;
    private javax.swing.JLabel emailAddress_Label;
    private javax.swing.JTextField first_name_Input1;
    private javax.swing.JRadioButton freelance_RadioB;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField last_name_Input;
    private javax.swing.JLabel name_Label;
    private javax.swing.JLabel name_Label1;
    private javax.swing.JPanel otherInfo;
    private javax.swing.JTextField otherStatus_Input;
    private javax.swing.JRadioButton other_radioB;
    private javax.swing.JRadioButton regular_RadioB;
    private javax.swing.JButton resetP_Button;
    private javax.swing.JLabel status_Label;
    // End of variables declaration//GEN-END:variables
}
