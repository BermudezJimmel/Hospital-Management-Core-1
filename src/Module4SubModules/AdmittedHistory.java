/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module4SubModules;

import SystemInstance.MysqlConnect;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showConfirmDialog;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ivy tromata
 */
public class AdmittedHistory extends javax.swing.JPanel {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    Statement stmt = null;

    /**
     * Creates new form AdmittedHistory
     */
    public AdmittedHistory() {
        initComponents();
        conn = MysqlConnect.ConnectDB();
        view();
        PatientCount();
        update2();
        update3();
        this.cbFilter.setCursor(new Cursor(12));

    }

    private void update2() {

        try {
            String q = "Select Count(*) from  Core1_ipd_admission where status='Inpatient'";
            String sql = "select DISTINCT Core1_bm_rooms.Room_type as 'Room Type',Core1_bm_roomroom.RoomName as 'Room Name',Core1_bm_rooms.Bed_No as Bed,concat(Core1_pr_PatientRegistration.LastName,', ',Core1_pr_PatientRegistration.FirstName,' ',Core1_pr_PatientRegistration.MiddleName) as 'Patient Name', \n"
                    + "concat ('Dr.',Core1_dra_registered.surname,', ',Core1_dra_registered.name,' ',Core1_dra_registered.middlename,'  -  ',Core1_dra_registered.specialization )as 'Doctor Name',Core1_ipd_admission.admitdate as 'Date Admit',Core1_ipd_admission.status as 'Status'\n"
                    + "from Core1_bm_roomroom\n"
                    + "inner join Core1_bm_rooms\n"
                    + "on Core1_bm_roomroom.Roomlegitid=Core1_bm_rooms.Room_ID\n"
                    + "inner join Core1_ipd_admission\n"
                    + "on Core1_bm_rooms.id=Core1_ipd_admission.idroom\n"
                    + "inner join Core1_pr_PatientRegistration\n"
                    + "on Core1_pr_PatientRegistration.Patient_ID=Core1_ipd_admission.Patient_ID\n"
                    + "inner join Core1_dra_registered\n"
                    + "on Core1_dra_registered.Dr_ID=Core1_ipd_admission.Dr_ID\n"
                    + "where Core1_ipd_admission.status='Inpatient' order by Core1_ipd_admission.admitdate";
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            conn = MysqlConnect.ConnectDB();
            pst = conn.prepareStatement(q);
            rs = pst.executeQuery();
            if (rs.next()) {
                String total = rs.getString("");
                PatientCount.setText(total);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void update3() {

        try {
            String q = "Select Count(*) from  Core1_ipd_admission where status='Discharge'";
            String sql = "select DISTINCT Core1_bm_rooms.Room_type as 'Room Type',Core1_bm_roomroom.RoomName as 'Room Name',Core1_bm_rooms.Bed_No as Bed,concat(Core1_pr_PatientRegistration.LastName,', ',Core1_pr_PatientRegistration.FirstName,' ',Core1_pr_PatientRegistration.MiddleName) as 'Patient Name', \n"
                    + "concat ('Dr.',Core1_dra_registered.surname,', ',Core1_dra_registered.name,' ',Core1_dra_registered.middlename,'  -  ',Core1_dra_registered.specialization )as 'Doctor Name',Core1_ipd_admission.admitdate as 'Date Admit',Core1_ipd_admission.status as 'Status'\n"
                    + "from Core1_bm_roomroom\n"
                    + "inner join Core1_bm_rooms\n"
                    + "on Core1_bm_roomroom.Roomlegitid=Core1_bm_rooms.Room_ID\n"
                    + "inner join Core1_ipd_admission\n"
                    + "on Core1_bm_rooms.id=Core1_ipd_admission.idroom\n"
                    + "inner join Core1_pr_PatientRegistration\n"
                    + "on Core1_pr_PatientRegistration.Patient_ID=Core1_ipd_admission.Patient_ID\n"
                    + "inner join Core1_dra_registered\n"
                    + "on Core1_dra_registered.Dr_ID=Core1_ipd_admission.Dr_ID\n"
                    + "where Core1_ipd_admission.status='Discharge' order by Core1_ipd_admission.admitdate";
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            conn = MysqlConnect.ConnectDB();
            pst = conn.prepareStatement(q);
            rs = pst.executeQuery();
            if (rs.next()) {
                String total = rs.getString("");
                PatientCount.setText(total);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void PatientCount() {
        try {

            String q = "Select Count(*) from  Core1_ipd_admission ";
            conn = MysqlConnect.ConnectDB();
            pst = conn.prepareStatement(q);
            rs = pst.executeQuery();
            if (rs.next()) {
                String total = rs.getString("");
                PatientCount.setText(total);
            }
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    private void view() {

        try {

            String sql = "select DISTINCT Core1_bm_rooms.Room_type as 'Room Type',Core1_bm_roomroom.RoomName as 'Room Name',Core1_bm_rooms.Bed_No as Bed,concat(Core1_pr_PatientRegistration.LastName,', ',Core1_pr_PatientRegistration.FirstName,' ',Core1_pr_PatientRegistration.MiddleName) as 'Patient Name', \n"
                    + "concat ('Dr.',Core1_dra_registered.surname,', ',Core1_dra_registered.name,' ',Core1_dra_registered.middlename,'  -  ',Core1_dra_registered.specialization )as 'Doctor Name',Core1_ipd_admission.admitdate as 'Date Admit',Core1_ipd_admission.status as 'Status'\n"
                    + "from Core1_bm_roomroom\n"
                    + "inner join Core1_bm_rooms\n"
                    + "on Core1_bm_roomroom.Roomlegitid=Core1_bm_rooms.Room_ID\n"
                    + "inner join Core1_ipd_admission\n"
                    + "on Core1_bm_rooms.id=Core1_ipd_admission.idroom\n"
                    + "inner join Core1_pr_PatientRegistration\n"
                    + "on Core1_pr_PatientRegistration.Patient_ID=Core1_ipd_admission.Patient_ID\n"
                    + "inner join Core1_dra_registered\n"
                    + "on Core1_dra_registered.Dr_ID=Core1_ipd_admission.Dr_ID order by Core1_ipd_admission.admitdate";
            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this cod @SuppressWarnings("unchecked") e. The
     * content of this method is always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        patientverify = new javax.swing.JDialog();
        addpatient = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        room = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Consultation = new javax.swing.JButton();
        Consultation1 = new javax.swing.JButton();
        Consultation2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable()
        {
            @Override

            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex)
            {
                Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);

                Object value = getModel().getValueAt(rowIndex,columnIndex);

                if(columnIndex == 6)
                {

                    if(value.equals("Inpatient"))
                    {

                        componenet.setBackground(Color.GREEN);
                        componenet.setForeground(Color.BLACK);

                    }
                    if(value.equals("Discharge"))
                    {
                        // if date  equal current date
                        componenet.setBackground(Color.RED);
                        componenet.setForeground(Color.BLACK);
                    }

                }

                else
                {

                    componenet.setBackground(Color.WHITE);
                    componenet.setForeground(Color.BLACK);
                }

                return componenet;
            }
        }
        ;
        module_name1 = new javax.swing.JLabel();
        fillAll = new rojerusan.RSMaterialButtonRound();
        fillOpd = new rojerusan.RSMaterialButtonRound();
        fillIpd = new rojerusan.RSMaterialButtonRound();
        PatientCount = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel43 = new javax.swing.JLabel();
        cbFilter = new rojerusan.RSComboMetro();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        fillAll1 = new rojerusan.RSMaterialButtonRound();

        patientverify.setTitle("Admit Patient");
        patientverify.setBackground(new java.awt.Color(0, 0, 255));
        patientverify.setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);
        patientverify.setUndecorated(true);
        patientverify.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                patientverifyComponentResized(evt);
            }
        });
        patientverify.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                patientverifyKeyPressed(evt);
            }
        });
        patientverify.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addpatient.setBackground(new java.awt.Color(255, 255, 255));
        addpatient.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        addpatient.setPreferredSize(new java.awt.Dimension(380, 310));
        addpatient.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                addpatientAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        addpatient.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(51, 102, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        room.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        room.setText("INPATIENT REPORT'S");
        jPanel4.add(room, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 220, 30));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 30, 30));

        addpatient.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 30));

        Consultation.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Consultation.setForeground(new java.awt.Color(51, 153, 255));
        Consultation.setText("ALL DISCHARGE PATIENT");
        Consultation.setBorderPainted(false);
        Consultation.setContentAreaFilled(false);
        Consultation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Consultation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultationActionPerformed(evt);
            }
        });
        addpatient.add(Consultation, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 310, 30));

        Consultation1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Consultation1.setForeground(new java.awt.Color(51, 153, 255));
        Consultation1.setText("ALL INPATIENT'S");
        Consultation1.setBorderPainted(false);
        Consultation1.setContentAreaFilled(false);
        Consultation1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Consultation1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Consultation1ActionPerformed(evt);
            }
        });
        addpatient.add(Consultation1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 310, 30));

        Consultation2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Consultation2.setForeground(new java.awt.Color(51, 153, 255));
        Consultation2.setText("ALL INPATIENT PATIENT");
        Consultation2.setBorderPainted(false);
        Consultation2.setContentAreaFilled(false);
        Consultation2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Consultation2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Consultation2ActionPerformed(evt);
            }
        });
        addpatient.add(Consultation2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 310, 30));

        patientverify.getContentPane().add(addpatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 330));

        setBackground(new java.awt.Color(51, 153, 255));
        setPreferredSize(new java.awt.Dimension(980, 580));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tableAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(table);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 970, 500));

        module_name1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        module_name1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        module_name1.setText("History of Patient Admitted");
        add(module_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 340, -1));

        fillAll.setText("All");
        fillAll.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        fillAll.setMaximumSize(new java.awt.Dimension(82, 26));
        fillAll.setMinimumSize(new java.awt.Dimension(82, 26));
        fillAll.setPreferredSize(new java.awt.Dimension(88, 28));
        fillAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillAllActionPerformed(evt);
            }
        });
        add(fillAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 48, -1, 30));

        fillOpd.setText("INPATIENT");
        fillOpd.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        fillOpd.setMaximumSize(new java.awt.Dimension(82, 26));
        fillOpd.setMinimumSize(new java.awt.Dimension(82, 26));
        fillOpd.setPreferredSize(new java.awt.Dimension(88, 28));
        fillOpd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillOpdActionPerformed(evt);
            }
        });
        add(fillOpd, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 48, -1, 30));

        fillIpd.setText("DISCHARGE");
        fillIpd.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        fillIpd.setMaximumSize(new java.awt.Dimension(82, 26));
        fillIpd.setMinimumSize(new java.awt.Dimension(82, 26));
        fillIpd.setPreferredSize(new java.awt.Dimension(88, 28));
        fillIpd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillIpdActionPerformed(evt);
            }
        });
        add(fillIpd, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 48, -1, 30));

        PatientCount.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PatientCount.setForeground(new java.awt.Color(204, 0, 0));
        PatientCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PatientCount.setText("0");
        PatientCount.setToolTipText("");
        add(PatientCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 60, 30));

        jLabel42.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel42.setText("Total Patient Admitted:");
        add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 30));

        jSeparator2.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator2.setForeground(new java.awt.Color(0, 102, 102));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, -1, -1));

        jSeparator3.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator3.setForeground(new java.awt.Color(0, 102, 102));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, -1, -1));

        jLabel43.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel43.setText("Filter patient by:");
        add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 50, -1, 30));

        cbFilter.setEditable(true);
        cbFilter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Today", "Weekly", "Monthly", "Yearly" }));
        cbFilter.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        cbFilter.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbFilterPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cbFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFilterActionPerformed(evt);
            }
        });
        add(cbFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 50, -1, -1));

        jSeparator4.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator4.setForeground(new java.awt.Color(0, 102, 102));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 10, 30));

        jSeparator5.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator5.setForeground(new java.awt.Color(0, 102, 102));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 10, 30));

        jSeparator6.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator6.setForeground(new java.awt.Color(0, 102, 102));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 30, 30));

        fillAll1.setText("Print Report");
        fillAll1.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        fillAll1.setMaximumSize(new java.awt.Dimension(82, 26));
        fillAll1.setMinimumSize(new java.awt.Dimension(82, 26));
        fillAll1.setPreferredSize(new java.awt.Dimension(88, 28));
        fillAll1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillAll1ActionPerformed(evt);
            }
        });
        add(fillAll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(778, 10, 180, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void tableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tableAncestorAdded
        view();         // TODO add your handling code here:
    }//GEN-LAST:event_tableAncestorAdded

    private void fillAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillAllActionPerformed
        jLabel42.setText("Total Patient Admitted:");
        PatientCount();
        view();
    }//GEN-LAST:event_fillAllActionPerformed

    private void fillOpdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillOpdActionPerformed
        jLabel42.setText("Total Patient(Inpatient):");
        update2();
    }//GEN-LAST:event_fillOpdActionPerformed

    private void fillIpdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillIpdActionPerformed
        jLabel42.setText("Total Patient(Discharged):");
        update3();
    }//GEN-LAST:event_fillIpdActionPerformed

    private void cbFilterPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbFilterPopupMenuWillBecomeInvisible

    }//GEN-LAST:event_cbFilterPopupMenuWillBecomeInvisible

    private void cbFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFilterActionPerformed
        ((JLabel) cbFilter.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        if (cbFilter.getSelectedItem().equals("Today")) {
            try {
                String q = " select Core1_bm_rooms.Room_type as 'Room Type',Core1_bm_roomroom.RoomName as 'Room Name',Core1_bm_rooms.Bed_No as Bed,concat(Core1_pr_PatientRegistration.LastName,', ',Core1_pr_PatientRegistration.FirstName,' ',Core1_pr_PatientRegistration.MiddleName) as 'Patient Name', \n"
                        + "concat ('Dr.',Core1_dra_registered.surname,', ',Core1_dra_registered.name,' ',Core1_dra_registered.middlename,'  -  ',Core1_dra_registered.specialization )as 'Doctor Name',Core1_ipd_admission.admitdate as 'Date Admit',Core1_ipd_admission.status as 'Status'\n"
                        + "from Core1_bm_roomroom\n"
                        + "inner join Core1_bm_rooms\n"
                        + "on Core1_bm_roomroom.Roomlegitid=Core1_bm_rooms.Room_ID\n"
                        + "inner join Core1_ipd_admission\n"
                        + "on Core1_bm_rooms.id=Core1_ipd_admission.idroom\n"
                        + "inner join Core1_pr_PatientRegistration\n"
                        + "on Core1_pr_PatientRegistration.Patient_ID=Core1_ipd_admission.Patient_ID\n"
                        + "inner join Core1_dra_registered\n"
                        + "on Core1_dra_registered.Dr_ID=Core1_ipd_admission.Dr_ID\n"
                        + "where cast (Core1_ipd_admission.admitdate as date) =  convert (nvarchar,GETDATE(),101) ";

                pst = conn.prepareStatement(q);
                rs = pst.executeQuery();

                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            }
        } else if (cbFilter.getSelectedItem().equals("Weekly")) {
            try {
                String q = " select Core1_bm_rooms.Room_type as 'Room Type',Core1_bm_roomroom.RoomName as 'Room Name',Core1_bm_rooms.Bed_No as Bed,concat(Core1_pr_PatientRegistration.LastName,', ',Core1_pr_PatientRegistration.FirstName,' ',Core1_pr_PatientRegistration.MiddleName) as 'Patient Name', \n"
                        + "concat ('Dr.',Core1_dra_registered.surname,', ',Core1_dra_registered.name,' ',Core1_dra_registered.middlename,'  -  ',Core1_dra_registered.specialization )as 'Doctor Name',Core1_ipd_admission.admitdate as 'Date Admit',Core1_ipd_admission.status as 'Status'\n"
                        + "from Core1_bm_roomroom\n"
                        + "inner join Core1_bm_rooms\n"
                        + "on Core1_bm_roomroom.Roomlegitid=Core1_bm_rooms.Room_ID\n"
                        + "inner join Core1_ipd_admission\n"
                        + "on Core1_bm_rooms.id=Core1_ipd_admission.idroom\n"
                        + "inner join Core1_pr_PatientRegistration\n"
                        + "on Core1_pr_PatientRegistration.Patient_ID=Core1_ipd_admission.Patient_ID\n"
                        + "inner join Core1_dra_registered\n"
                        + "on Core1_dra_registered.Dr_ID=Core1_ipd_admission.Dr_ID\n"
                        + "Where Core1_ipd_admission.admitdate BETWEEN DATEADD(DAY, -7, GETDATE()) AND DATEADD(DAY, 1, GETDATE())";

                pst = conn.prepareStatement(q);
                rs = pst.executeQuery();

                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            }

        } else if (cbFilter.getSelectedItem().equals("Monthly")) {
            try {
                String q = "select Core1_bm_rooms.Room_type as 'Room Type',Core1_bm_roomroom.RoomName as 'Room Name',Core1_bm_rooms.Bed_No as Bed,concat(Core1_pr_PatientRegistration.LastName,', ',Core1_pr_PatientRegistration.FirstName,' ',Core1_pr_PatientRegistration.MiddleName) as 'Patient Name', \n"
                        + "concat ('Dr.',Core1_dra_registered.surname,', ',Core1_dra_registered.name,' ',Core1_dra_registered.middlename,'  -  ',Core1_dra_registered.specialization )as 'Doctor Name',Core1_ipd_admission.admitdate as 'Date Admit',Core1_ipd_admission.status as 'Status'\n"
                        + "from Core1_bm_roomroom\n"
                        + "inner join Core1_bm_rooms\n"
                        + "on Core1_bm_roomroom.Roomlegitid=Core1_bm_rooms.Room_ID\n"
                        + "inner join Core1_ipd_admission\n"
                        + "on Core1_bm_rooms.id=Core1_ipd_admission.idroom\n"
                        + "inner join Core1_pr_PatientRegistration\n"
                        + "on Core1_pr_PatientRegistration.Patient_ID=Core1_ipd_admission.Patient_ID\n"
                        + "inner join Core1_dra_registered\n"
                        + "on Core1_dra_registered.Dr_ID=Core1_ipd_admission.Dr_ID\n"
                        + "WHERE MONTH(Core1_ipd_admission.admitdate) = MONTH(dateadd(dd, -1, GetDate())) AND YEAR(Core1_ipd_admission.admitdate) = YEAR(dateadd(dd, -1, GetDate()))";

                pst = conn.prepareStatement(q);
                rs = pst.executeQuery();

                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            }

        } else if (cbFilter.getSelectedItem().equals("Yearly")) {
            try {
                String q = " select Core1_bm_rooms.Room_type as 'Room Type',Core1_bm_roomroom.RoomName as 'Room Name',Core1_bm_rooms.Bed_No as Bed,concat(Core1_pr_PatientRegistration.LastName,', ',Core1_pr_PatientRegistration.FirstName,' ',Core1_pr_PatientRegistration.MiddleName) as 'Patient Name', \n"
                        + "concat ('Dr.',Core1_dra_registered.surname,', ',Core1_dra_registered.name,' ',Core1_dra_registered.middlename,'  -  ',Core1_dra_registered.specialization )as 'Doctor Name',Core1_ipd_admission.admitdate as 'Date Admit',Core1_ipd_admission.status as 'Status'\n"
                        + "from Core1_bm_roomroom\n"
                        + "inner join Core1_bm_rooms\n"
                        + "on Core1_bm_roomroom.Roomlegitid=Core1_bm_rooms.Room_ID\n"
                        + "inner join Core1_ipd_admission\n"
                        + "on Core1_bm_rooms.id=Core1_ipd_admission.idroom\n"
                        + "inner join Core1_pr_PatientRegistration\n"
                        + "on Core1_pr_PatientRegistration.Patient_ID=Core1_ipd_admission.Patient_ID\n"
                        + "inner join Core1_dra_registered\n"
                        + "on Core1_dra_registered.Dr_ID=Core1_ipd_admission.Dr_ID\n"
                        + "WHERE Core1_ipd_admission.admitdate > DATEADD(year,-1,GETDATE())";

                pst = conn.prepareStatement(q);
                rs = pst.executeQuery();

                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            }

        } else {
            cbFilter.getSelectedItem().equals("All");
            try {
                String q = "select Core1_bm_rooms.Room_type as 'Room Type',Core1_bm_roomroom.RoomName as 'Room Name',Core1_bm_rooms.Bed_No as Bed,concat(Core1_pr_PatientRegistration.LastName,', ',Core1_pr_PatientRegistration.FirstName,' ',Core1_pr_PatientRegistration.MiddleName) as 'Patient Name', \n"
                        + "concat ('Dr.',Core1_dra_registered.surname,', ',Core1_dra_registered.name,' ',Core1_dra_registered.middlename,'  -  ',Core1_dra_registered.specialization )as 'Doctor Name',Core1_ipd_admission.admitdate as 'Date Admit',Core1_ipd_admission.status as 'Status'\n"
                        + "from Core1_bm_roomroom\n"
                        + "inner join Core1_bm_rooms\n"
                        + "on Core1_bm_roomroom.Roomlegitid=Core1_bm_rooms.Room_ID\n"
                        + "inner join Core1_ipd_admission\n"
                        + "on Core1_bm_rooms.id=Core1_ipd_admission.idroom\n"
                        + "inner join Core1_pr_PatientRegistration\n"
                        + "on Core1_pr_PatientRegistration.Patient_ID=Core1_ipd_admission.Patient_ID\n"
                        + "inner join Core1_dra_registered\n"
                        + "on Core1_dra_registered.Dr_ID=Core1_ipd_admission.Dr_ID";

                pst = conn.prepareStatement(q);
                rs = pst.executeQuery();

                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_cbFilterActionPerformed

    private void fillAll1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillAll1ActionPerformed
        int h = showConfirmDialog(null, "Do you want to Print a Report?", "Printing Report", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            patientverify.setVisible(true);
            patientverify.setSize(311, 150);
            patientverify.setLocationRelativeTo(null);
        }
        if (h == 1) {

        }
//try {
//            //path of .jrxml
//            InputStream in = new FileInputStream(new File("C:\\Users\\ivy tromata\\Desktop\\CORE1 para maka Graduate\\itopo\\src\\Module4SubModules\\sampRep.jrxml"));
//            JasperDesign jd = JRXmlLoader.load(in);
//            String sql = "select Core1_bm_rooms.Room_type as 'Room Type',Core1_bm_roomroom.RoomName as 'Room Name',Core1_bm_rooms.Bed_No as Bed,concat(Core1_pr_PatientRegistration.LastName,', ',Core1_pr_PatientRegistration.FirstName,' ',Core1_pr_PatientRegistration.MiddleName) as 'Patient Name',\n" +
//"concat ('Dr.',Core1_dra_registered.surname,', ',Core1_dra_registered.name,' ',Core1_dra_registered.middlename,'  -  ',Core1_dra_registered.specialization )as 'Doctor Name',Core1_ipd_admission.admitdate as 'Date Admit',Core1_ipd_admission.status as 'Status'\n" +
//"from Core1_bm_roomroom\n" +
//"inner join Core1_bm_rooms\n" +
//"on Core1_bm_roomroom.Roomlegitid=Core1_bm_rooms.Room_ID\n" +
//"inner join Core1_ipd_admission\n" +
//"on Core1_bm_rooms.id=Core1_ipd_admission.idroom\n" +
//"inner join Core1_pr_PatientRegistration\n" +
//"on Core1_pr_PatientRegistration.Patient_ID=Core1_ipd_admission.Patient_ID\n" +
//"inner join Core1_dra_registered\n" +
//"on Core1_dra_registered.Dr_ID=Core1_ipd_admission.Dr_ID";
//            JRDesignQuery newQuery = new JRDesignQuery();
//            newQuery.setText(sql);
//            jd.setQuery(newQuery);
//            JasperReport jr = JasperCompileManager.compileReport(jd);
//            HashMap para = new HashMap();
//            JasperPrint j = JasperFillManager.fillReport(jr, para, conn);
//            JasperViewer.viewReport(j,false);
//         //   OutputStream os = new FileOutputStream(new File("D:\\reports"));
//           // JasperExportManager.exportReportToPdfStream(j, os);
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }        // TODO add your handling code here:
    }//GEN-LAST:event_fillAll1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        int h = showConfirmDialog(null, "Do you want to Close Printing Report?", "Printing Report Inpatient", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            patientverify.setVisible(false);

        }
        if (h == 1) {

        }        // TODO add your handling code here:     // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void addpatientAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_addpatientAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_addpatientAncestorAdded

    private void patientverifyComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_patientverifyComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_patientverifyComponentResized

    private void patientverifyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_patientverifyKeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_patientverifyKeyPressed

    private void Consultation1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Consultation1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Consultation1ActionPerformed

    private void Consultation2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Consultation2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Consultation2ActionPerformed

    private void ConsultationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultationActionPerformed

    }//GEN-LAST:event_ConsultationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Consultation;
    private javax.swing.JButton Consultation1;
    private javax.swing.JButton Consultation2;
    private javax.swing.JLabel PatientCount;
    private javax.swing.JPanel addpatient;
    private rojerusan.RSComboMetro cbFilter;
    private rojerusan.RSMaterialButtonRound fillAll;
    private rojerusan.RSMaterialButtonRound fillAll1;
    private rojerusan.RSMaterialButtonRound fillIpd;
    private rojerusan.RSMaterialButtonRound fillOpd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel module_name1;
    private javax.swing.JDialog patientverify;
    private javax.swing.JLabel room;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
