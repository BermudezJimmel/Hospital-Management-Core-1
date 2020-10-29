/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module5SubModules;

import SystemInstance.MysqlConnect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author jerome
 */
public final class LinenMonitoring extends javax.swing.JPanel {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    java.sql.PreparedStatement pst = null;
    CallableStatement cst = null;

    public LinenMonitoring() {
        initComponents();
        con = MysqlConnect.ConnectDB();
        Update_monitoring_tbl();
    }

    private void Update_monitoring_tbl() {

        try {
            String sql = "select * from Core1_lm_monitoring ";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            monitoring_tbl.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        root = new javax.swing.JPanel();
        fillAll1 = new rojerusan.RSMaterialButtonRound();
        Search = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_search_Patient = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        Rate = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        date_admit = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        combo_dr = new javax.swing.JComboBox<>();
        txt_room = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        lbl_admi = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lvl_status = new javax.swing.JLabel();
        txt_room1 = new javax.swing.JTextField();
        Rate1 = new javax.swing.JLabel();
        txt_room2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        date_lbl = new java.awt.Label();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        monitoring_tbl = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();

        root.setBackground(new java.awt.Color(255, 255, 255));
        root.setLayout(null);

        fillAll1.setText("Housekeeping Request");
        fillAll1.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        fillAll1.setMaximumSize(new java.awt.Dimension(82, 26));
        fillAll1.setMinimumSize(new java.awt.Dimension(82, 26));
        fillAll1.setPreferredSize(new java.awt.Dimension(88, 28));
        fillAll1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillAll1ActionPerformed(evt);
            }
        });
        root.add(fillAll1);
        fillAll1.setBounds(888, 368, 200, 50);

        Search.setBackground(new java.awt.Color(255, 255, 255));
        Search.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Search  By: Name", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Search  : ");

        txt_search_Patient.setPreferredSize(new java.awt.Dimension(200, 25));
        txt_search_Patient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_search_PatientKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout SearchLayout = new javax.swing.GroupLayout(Search);
        Search.setLayout(SearchLayout);
        SearchLayout.setHorizontalGroup(
            SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_search_Patient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        SearchLayout.setVerticalGroup(
            SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_search_Patient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        root.add(Search);
        Search.setBounds(750, 70, 387, 71);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Linen details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Rate.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Rate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Rate.setText("Surname:");
        jPanel4.add(Rate, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 67, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Name:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 34, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Date Assign:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, -1, -1));
        jPanel4.add(date_admit, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 135, -1));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Floor category: ");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 33, -1, -1));

        combo_dr.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo_drFocusLost(evt);
            }
        });
        combo_dr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_drActionPerformed(evt);
            }
        });
        jPanel4.add(combo_dr, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 30, 126, -1));

        txt_room.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_room.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel4.add(txt_room, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 30, 91, -1));

        jLabel26.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Assign by:");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        lbl_admi.setText("-");
        jPanel4.add(lbl_admi, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 132, 19));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Cleaning status:");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 63, -1, 14));

        lvl_status.setText("-");
        jPanel4.add(lvl_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 64, 128, -1));

        txt_room1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_room1.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel4.add(txt_room1, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 63, 93, -1));

        Rate1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Rate1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Rate1.setText("Room assign:");
        jPanel4.add(Rate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 98, -1, -1));

        txt_room2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_room2.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel4.add(txt_room2, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 94, 93, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Date Time of finish:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 123, -1, 20));

        date_lbl.setText("-");
        jPanel4.add(date_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 123, 110, -1));

        root.add(jPanel4);
        jPanel4.setBounds(40, 80, 540, 160);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("View");
        root.add(jLabel13);
        jLabel13.setBounds(10, 420, 30, 15);

        monitoring_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        monitoring_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                monitoring_tblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(monitoring_tbl);

        root.add(jScrollPane1);
        jScrollPane1.setBounds(10, 440, 1140, 120);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1166, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        root.add(jPanel1);
        jPanel1.setBounds(0, 0, 1166, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1166, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(root, javax.swing.GroupLayout.PREFERRED_SIZE, 1166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 582, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(root, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_search_PatientKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_search_PatientKeyReleased
        // Search patient by name
        String sp = txt_search_Patient.getText().trim() + "%";
        try {
            String searchbed = "select ip.Ipd_ID,p.Patient_ID,p.FirstName,p.LastName, p.Mode_of_payment,r.Room_ID,r.Bed_No, \n"
                    + "r.Room_type,r.rate,r.bed_status,dr.Drname,r.date_occopied,ip.admitdate,ip.Admitedby\n"
                    + "from Core1_pr_PatientRegistration p\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "join Core1_bm_rooms r on \n"
                    + "p.Patient_ID = r.Patient_ID\n"
                    + "\n"
                    + "join Core1_ipd_admission ip on\n"
                    + "ip.Patient_ID = r.Patient_ID\n"
                    + "\n"
                    + "join Core1_dra_drinfo dr  on \n"
                    + "dr.Doctor_ID = ip.Doctor_ID\n"
                    + "where FirstName like '%" + sp + "%'";

            pst = con.prepareStatement(searchbed);
            rs = pst.executeQuery();
            monitoring_tbl.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
        }
    }//GEN-LAST:event_txt_search_PatientKeyReleased

    private void combo_drFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo_drFocusLost
        combo_dr.removeAllItems();
    }//GEN-LAST:event_combo_drFocusLost

    private void combo_drActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_drActionPerformed
        ((JLabel) combo_dr.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
    }//GEN-LAST:event_combo_drActionPerformed

    private void monitoring_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monitoring_tblMouseClicked
        /*   try {
            int row = transfer_tbl.getSelectedRow();
            String Table_transfer = (transfer_tbl.getModel().getValueAt(row, 0).toString());
            String sql = "select ip.Ipd_ID,p.Patient_ID,p.FirstName,p.LastName, p.Mode_of_payment,r.Room_ID,r.Bed_No, \n" +
            "r.Room_type,r.rate,r.bed_status,dr.Drname,r.date_occopied,ip.admitdate,ip.Admitedby\n" +
            "from Core1_pr_PatientRegistration p\n" +
            "\n" +
            "\n" +
            "\n" +
            "join Core1_bm_rooms r on \n" +
            "p.Patient_ID = r.Patient_ID\n" +
            "\n" +
            "join Core1_ipd_admission ip on\n" +
            "ip.Patient_ID = r.Patient_ID\n" +
            "\n" +
            "join Core1_dra_drinfo dr  on \n" +
            "dr.Doctor_ID = ip.Doctor_ID\n" +
            " where Ipd_ID='"+Table_transfer+"' ";
            pst = con.prepareStatement(sql);
            rs=pst.executeQuery();

            if(rs.next()){
                String add0 = rs.getString("Room_ID");
                txt_roomno.setText(add0);
                String add1 = rs.getString("Ipd_ID");
                lbl_admitid.setText(add1);
                String add2 = rs.getString("Patient_ID");
                lbl_pr_id.setText(add2);
                String add3 = rs.getString("FirstName");
                lbl_name.setText(add3);
                String add4 = rs.getString("LastName");
                lbl_surname.setText(add4);
                String add5 = rs.getString("Mode_of_payment");
                lbl_mop.setText(add5);
                String add6 = rs.getString("Room_type");
                txt_room.setText(add6);
                String add7 = rs.getString("Bed_No");
                txt_bedno.setText(add7);
                String add8 = rs.getString("rate");
                txt_rate.setText(add8);
                String add9 = rs.getString("bed_status");
                lvl_status.setText(add9);
                String add10 = rs.getString("Admitedby");
                lbl_admi.setText(add10);
                Date add11 = rs.getDate("admitdate");
                date_admit.setDate(add11);
                String add12 =  rs.getString("Drname");
                combo_dr.addItem(add12);
                combo_dr.setSelectedItem(add12);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        {

        }*/
    }//GEN-LAST:event_monitoring_tblMouseClicked

    private void fillAll1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillAll1ActionPerformed
        HousekeepingRequest hk = new HousekeepingRequest();
        hk.setVisible(true);

    }//GEN-LAST:event_fillAll1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Rate;
    private javax.swing.JLabel Rate1;
    private javax.swing.JPanel Search;
    private javax.swing.JComboBox<String> combo_dr;
    private com.toedter.calendar.JDateChooser date_admit;
    private java.awt.Label date_lbl;
    private rojerusan.RSMaterialButtonRound fillAll1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_admi;
    private javax.swing.JLabel lvl_status;
    private javax.swing.JTable monitoring_tbl;
    private javax.swing.JPanel root;
    private javax.swing.JTextField txt_room;
    private javax.swing.JTextField txt_room1;
    private javax.swing.JTextField txt_room2;
    private javax.swing.JTextField txt_search_Patient;
    // End of variables declaration//GEN-END:variables
}
