/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module2SubModules;

import SystemInstance.MysqlConnect;
import java.awt.HeadlessException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author iRHONman
 */
public class Doctors_Schedule extends javax.swing.JFrame {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    CallableStatement cst= null;
    DefaultTableModel mode;
    String Gender;
    public Doctors_Schedule() {
        initComponents();
         con = MysqlConnect.ConnectDB();
         auto_number_Registerschedno();
         
    }
     public void theQueryLogin(String query) {

        java.sql.Statement st;
        try {
            
            st = con.createStatement();
            st.executeUpdate(query);
            // JOptionPane.showMessageDialog(null, "You listed");

        } catch (SQLException | HeadlessException ee) {
            JOptionPane.showMessageDialog(null, ee.getMessage());;
        }

    }
     
      public void   auto_number_Registerschedno(){
        
        

          try {
            String sql = "SELECT Count(Schedule_ID)AS no FROM Core1_dra_schedule";
         
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                if (rs.first() == false) {
                    txt_S_ID1.setText("Doctor0001");
                } else {
                    rs.last();

                    int auto_id = rs.getInt(1) + 1;
                    String no = String.valueOf(auto_id);
                    int nolong = no.length();
                    for (int a = 0; a < 2 - nolong; a++) {
                        no = "S" + no;
                    }

                    txt_S_ID1.setText("" + no);

                }
            }

        } catch (Exception e) {
            System.out.println(e);

        }

    

        
    } 
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        bg_panel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel189 = new javax.swing.JLabel();
        CB_Day = new javax.swing.JComboBox<>();
        jLabel238 = new javax.swing.JLabel();
        CB_Initial_Minute = new javax.swing.JComboBox<>();
        jLabel237 = new javax.swing.JLabel();
        CB_Initial_Day = new javax.swing.JComboBox<>();
        jLabel190 = new javax.swing.JLabel();
        CB_Initial_Hour1 = new javax.swing.JComboBox<>();
        jLabel191 = new javax.swing.JLabel();
        CB_Initial_Hour2 = new javax.swing.JComboBox<>();
        jLabel239 = new javax.swing.JLabel();
        CB_Initial_Minute1 = new javax.swing.JComboBox<>();
        CB_Initial_Day1 = new javax.swing.JComboBox<>();
        jLabel240 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txt_ID = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_gen = new javax.swing.JTextField();
        txt_specia = new javax.swing.JTextField();
        txt_S_ID1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel163 = new javax.swing.JLabel();
        txt_max_pat = new javax.swing.JTextField();
        jExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Add schedule");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, 150, 30));

        bg_panel.setBackground(new java.awt.Color(240, 240, 240));
        bg_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Consultation schedule", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        bg_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(240, 240, 240));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Set schedule", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jLabel189.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel189.setText("Schedule:");

        CB_Day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));

        jLabel238.setText(":");

        CB_Initial_Minute.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "10", "15", "20", "25", "30", "35", "40", "45", "50", " " }));
        CB_Initial_Minute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_Initial_MinuteActionPerformed(evt);
            }
        });

        jLabel237.setText(",");

        CB_Initial_Day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));
        CB_Initial_Day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_Initial_DayActionPerformed(evt);
            }
        });

        jLabel190.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel190.setText("From");

        CB_Initial_Hour1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "9", "10", "11", "12", "1", "2", "3", "4", "5", "6", "7", "8" }));

        jLabel191.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel191.setText("To");

        CB_Initial_Hour2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel239.setText(":");

        CB_Initial_Minute1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "10", "15", "20", "25", "30", "35", "40", "45", "50", " " }));
        CB_Initial_Minute1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_Initial_Minute1ActionPerformed(evt);
            }
        });

        CB_Initial_Day1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PM", "AM" }));
        CB_Initial_Day1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_Initial_Day1ActionPerformed(evt);
            }
        });

        jLabel240.setText(",");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel189)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(CB_Day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel191)
                                .addGap(18, 18, 18)
                                .addComponent(CB_Initial_Hour2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel239, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(CB_Initial_Minute1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel240, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(CB_Initial_Day1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel190)
                                .addGap(18, 18, 18)
                                .addComponent(CB_Initial_Hour1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel238, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(CB_Initial_Minute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel237, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(CB_Initial_Day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel189, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CB_Day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel238, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CB_Initial_Hour1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel190, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CB_Initial_Minute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel237, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CB_Initial_Day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel239, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CB_Initial_Hour2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel191, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CB_Initial_Minute1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel240, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CB_Initial_Day1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        bg_panel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 300, 150));

        jPanel5.setBackground(new java.awt.Color(240, 240, 240));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Doctor Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Doctors ID:");

        jLabel162.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel162.setText("Gender:");

        jLabel33.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel33.setText("Name:");

        jLabel42.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel42.setText("Specialization:");

        txt_ID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ID.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_ID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_ID.setEnabled(false);
        txt_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IDActionPerformed(evt);
            }
        });

        txt_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_name.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_name.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_name.setEnabled(false);

        txt_gen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_gen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_gen.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_gen.setEnabled(false);

        txt_specia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_specia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_specia.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_specia.setEnabled(false);

        txt_S_ID1.setBackground(new java.awt.Color(0, 153, 153));
        txt_S_ID1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_S_ID1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_S_ID1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_S_ID1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_S_ID1.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Schedule ID:");

        jLabel163.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel163.setText("Max Patient:");

        txt_max_pat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_max_pat.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(99, 99, 99)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_S_ID1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_max_pat, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_specia, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel162, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_gen)
                                .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel163))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel33)
                                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel162)
                                    .addComponent(txt_gen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel163, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txt_S_ID1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_max_pat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)))
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(txt_specia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        bg_panel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 300, 180));

        jPanel1.add(bg_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 670, 280));

        jExit.setBackground(new java.awt.Color(0, 102, 102));
        jExit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jExit.setText("Exit");
        jExit.setPreferredSize(new java.awt.Dimension(83, 25));
        jExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExitActionPerformed(evt);
            }
        });
        jPanel1.add(jExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 130, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(730, 424));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CB_Initial_MinuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_Initial_MinuteActionPerformed
        if(CB_Initial_Minute.getSelectedItem().equals(" ")){
            CB_Initial_Minute.setEditable(true);

        }else{
            CB_Initial_Minute.setEditable(false);

        }
    }//GEN-LAST:event_CB_Initial_MinuteActionPerformed

    private void CB_Initial_DayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_Initial_DayActionPerformed
        boolean ID =CB_Initial_Day.getSelectedItem().equals("PM");

        /*  if(ID==ID){
            CB_Exam_Day.setSelectedItem("PM");
            CB_Final_Day.setSelectedItem("PM");
        }*/
    }//GEN-LAST:event_CB_Initial_DayActionPerformed

    private void jExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_jExitActionPerformed

    private void CB_Initial_Minute1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_Initial_Minute1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_Initial_Minute1ActionPerformed

    private void CB_Initial_Day1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_Initial_Day1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_Initial_Day1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Add schedule
        try {

            String query = "insert into Core1_dra_schedule values(?,?,?,?,?,?,?,?,?,?)";

           
            pst = con.prepareStatement(query);

          //  pst.setString(1, Schedule_Interview_no);
            pst.setString(1, txt_S_ID1.getText());
            pst.setString(2, txt_ID.getText());
            pst.setString(3, txt_name.getText());
            pst.setString(4, txt_gen.getText());
            pst.setString(5, txt_specia.getText());
            pst.setString(6, (String) CB_Day.getSelectedItem());
            pst.setString(7, CB_Initial_Hour1.getSelectedItem().toString()+":"+CB_Initial_Minute.getSelectedItem().toString() + CB_Initial_Day.getSelectedItem().toString());
            pst.setString(8, CB_Initial_Hour2.getSelectedItem().toString()+":"+CB_Initial_Minute.getSelectedItem().toString() + CB_Initial_Day1.getSelectedItem().toString());
            pst.setString(9, txt_max_pat.getText());
            pst.setString(10, "Off duty");

            pst.execute();
            
             try {

         
            String query2 = "update Core1_dra_registered set Status = 'Scheduled' where Dr_ID='" + txt_ID.getText() + "' ";

            java.sql.Statement st = null;

            st = con.createStatement();
            st.executeUpdate(query2);
         
           

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            //"Not Saved!, please check your remaining filled"

        }
            
             } catch (Exception e) {
            System.out.println(e);

        }
        JOptionPane.showMessageDialog(null, "Doctor Successfully  Scheduled");
         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IDActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Doctors_Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Doctors_Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Doctors_Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Doctors_Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Doctors_Schedule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_Day;
    private javax.swing.JComboBox<String> CB_Initial_Day;
    private javax.swing.JComboBox<String> CB_Initial_Day1;
    private javax.swing.JComboBox<String> CB_Initial_Hour1;
    private javax.swing.JComboBox<String> CB_Initial_Hour2;
    private javax.swing.JComboBox<String> CB_Initial_Minute;
    private javax.swing.JComboBox<String> CB_Initial_Minute1;
    private javax.swing.JPanel bg_panel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jExit;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel237;
    private javax.swing.JLabel jLabel238;
    private javax.swing.JLabel jLabel239;
    private javax.swing.JLabel jLabel240;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    public static javax.swing.JTextField txt_ID;
    private javax.swing.JTextField txt_S_ID1;
    public static javax.swing.JTextField txt_gen;
    public static javax.swing.JTextField txt_max_pat;
    public static javax.swing.JTextField txt_name;
    public static javax.swing.JTextField txt_specia;
    // End of variables declaration//GEN-END:variables
}
