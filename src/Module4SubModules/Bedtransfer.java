/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module4SubModules;

import SystemInstance.MysqlConnect;
import static java.lang.Thread.sleep;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author jerome
 */
public final class Bedtransfer extends javax.swing.JPanel {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    java.sql.PreparedStatement pst = null;
    CallableStatement cst = null;

    public Bedtransfer() {
        initComponents();
        con = MysqlConnect.ConnectDB();
        clockJobView ();
        view();
    

   
    }
     public void clockJobView() {

        Thread clock;
        clock = new Thread() {

            @Override
            public void run() {
                try {
                    for (;;) {
                        Calendar cal = new GregorianCalendar();
                        int day = cal.get(Calendar.DAY_OF_MONTH);
                        int month1 = cal.get(Calendar.MONTH);
                        int year = cal.get(Calendar.YEAR);

                        int am_pm = cal.get(Calendar.AM_PM);

                        int second = cal.get(Calendar.SECOND);
                        int minute = cal.get(Calendar.MINUTE);
                        int hour = cal.get(Calendar.HOUR);
                        int week = cal.get(Calendar.DAY_OF_WEEK);
                        int month = month1 + 1;

                        String day_night;
                        if (am_pm == 1) {
                            day_night = "PM";
                        } else {
                            day_night = "AM";
                        }
                        String weekday = "";
                        if (hour == 0) {
                            hour = 12;
                        }

                        switch (week) {
                            case 1:
                                weekday = "Sunday";
                                break;
                            case 2:
                                weekday = "Monday";
                                break;
                            case 3:
                                weekday = "Tuesday";
                                break;
                            case 4:
                                weekday = "Wednesday";
                                break;
                            case 5:
                                weekday = "Thursday";
                                break;
                            case 6:
                                weekday = "Friday";
                                break;
                            case 7:
                                weekday = "Saturday";
                                break;
                            default:
                                break;
                        }

                        String day1;
                        if (day == 1) {
                            day1 = "0" + day;
                        } else if (day == 1) {
                            day1 = "0" + day;
                        } else if (day == 2) {
                            day1 = "0" + day;
                        } else if (day == 3) {
                            day1 = "0" + day;
                        } else if (day == 4) {
                            day1 = "0" + day;
                        } else if (day == 5) {
                            day1 = "0" + day;
                        } else if (day == 6) {
                            day1 = "0" + day;
                        } else if (day == 7) {
                            day1 = "0" + day;
                        } else if (day == 8) {
                            day1 = "0" + day;
                        } else if (day == 9) {
                            day1 = "0" + day;
                        } else {
                            day1 = "" + day;
                        }

                        String M = "";
                        switch (month) {
                            case 1:
                                M = "January";
                                break;
                            case 2:
                                M = "February";
                                break;
                            case 3:
                                M = "March";
                                break;
                            case 4:
                                M = "April";
                                break;
                            case 5:
                                M = "May";
                                break;
                            case 6:
                                M = "June";
                                break;
                            case 7:
                                M = "July";
                                break;
                            case 8:
                                M = "August";
                                break;
                            case 9:
                                M = "September";
                                break;
                            case 10:
                                M = "October";
                                break;
                            case 11:
                                M = "November";
                                break;
                            case 12:
                                M = "December";
                                break;
                            default:
                                break;
                        }
                        String Sec = ":";
                        switch (second) {
                            case 1:
                                Sec = ":";
                                break;
                            case 3:
                                Sec = ":";
                                break;
                            case 5:
                                Sec = ":";
                                break;
                            case 7:
                                Sec = ":";
                                break;
                            case 9:
                                Sec = ":";
                                break;
                            case 11:
                                Sec = ":";
                                break;
                            case 13:
                                Sec = ":";
                                break;
                            case 15:
                                Sec = ":";
                                break;
                            case 17:
                                Sec = ":";
                                break;
                            case 19:
                                Sec = ":";
                                break;
                            case 21:
                                Sec = ":";
                                break;
                            case 23:
                                Sec = ":";
                                break;
                            case 25:
                                Sec = ":";
                                break;
                            case 27:
                                Sec = ":";
                                break;
                            case 29:
                                Sec = ":";
                                break;
                            case 31:
                                Sec = ":";
                                break;
                            case 33:
                                Sec = ":";
                                break;
                            case 35:
                                Sec = ":";
                                break;
                            case 37:
                                Sec = ":";
                                break;
                            case 39:
                                Sec = ":";
                                break;
                            case 41:
                                Sec = ":";
                                break;
                            case 43:
                                Sec = ":";
                                break;
                            case 45:
                                Sec = ":";
                                break;
                            case 47:
                                Sec = ":";
                                break;
                            case 49:
                                Sec = ":";
                                break;
                            case 51:
                                Sec = ":";
                                break;
                            case 53:
                                Sec = ":";
                                break;
                            case 55:
                                Sec = ":";
                                break;
                            case 57:
                                Sec = ":";
                                break;
                            case 59:
                                Sec = ":";
                                break;
                            default:
                                Sec = " ";
                                break;
                        }
                        String mn = null;
                        switch (minute) {
                            case 0:
                                mn = "0" + minute;
                                break;
                            case 1:
                                mn = "0" + minute;
                                break;
                            case 2:
                                mn = "0" + minute;
                                break;
                            case 3:
                                mn = "0" + minute;
                                break;
                            case 4:
                                mn = "0" + minute;
                                break;
                            case 5:
                                mn = "0" + minute;
                                break;
                            case 6:
                                mn = "0" + minute;
                                break;
                            case 7:
                                mn = "0" + minute;
                                break;
                            case 8:
                                mn = "0" + minute;
                                break;
                            case 9:
                                mn = "0" + minute;
                                break;
                            default:
                                mn = "" + minute;
                                break;
                        }

                        //     Update_dr_tbl();
                        view();
                        sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        clock.start();

    }

    private void view() {

        try {

            String sql = "select distinct \n"
                    + "Core1_bm_rooms.id as 'No.',\n"
                    + "Core1_bm_roomroom.RoomName as Room,\n"
                    + "Core1_bm_rooms.Bed_No as Bed,\n"
                    + "Core1_bm_rooms.Room_type as type,\n"
                    + "Core1_pr_PatientRegistration.Patient_ID as ID,\n"
                    + "concat(Core1_pr_PatientRegistration.LastName,', ',Core1_pr_PatientRegistration.FirstName,' ',Core1_pr_PatientRegistration.MiddleName) as Name,\n"
                    + "Core1_bm_rooms.rate as Rate,\n"
                    + "Core1_bm_rooms.date_occopied as DaT,\n"
                    + "Core1_bm_rooms.bed_status as Availability,bed_remarks as Remarks\n"
                    + "from Core1_bm_roomroom\n"
                    + "inner join Core1_bm_rooms\n"
                    + "on Core1_bm_roomroom.Roomlegitid=Core1_bm_rooms.Room_ID\n"
                    + "left join Core1_pr_PatientRegistration\n"
                    + "on Core1_bm_rooms.Patient_ID=Core1_pr_PatientRegistration.Patient_ID where  Core1_bm_rooms.bed_remarks = 'Inpatient' ";
            pst = con.prepareStatement(sql);

            rs = pst.executeQuery();
            tblTransfer.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
// 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        root = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTransfer = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        Search = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_search_Patient = new javax.swing.JTextField();
        PatientPanel = new javax.swing.JPanel();
        Name = new javax.swing.JLabel();
        Admission = new javax.swing.JLabel();
        lbl_name = new javax.swing.JLabel();
        no = new javax.swing.JLabel();
        Admission1 = new javax.swing.JLabel();
        lbl_pr_id = new javax.swing.JLabel();
        Admission2 = new javax.swing.JLabel();
        deprt = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        date = new javax.swing.JLabel();
        Rate = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_room = new javax.swing.JTextField();
        date_occu = new javax.swing.JLabel();
        lvl_status = new javax.swing.JLabel();
        txt_rate = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_bedno = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_roomno = new javax.swing.JTextField();
        lbl_mop1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();

        root.setBackground(new java.awt.Color(255, 255, 255));
        root.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(0, 124, 134));
        jPanel6.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Transfer request");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        root.add(jPanel6);
        jPanel6.setBounds(10, 420, 1260, 40);

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(null);

        tblTransfer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblTransfer.setForeground(new java.awt.Color(51, 51, 51));
        tblTransfer.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTransfer.setGridColor(new java.awt.Color(255, 255, 255));
        tblTransfer.setRowHeight(20);
        tblTransfer.setSelectionBackground(new java.awt.Color(0, 171, 82));
        tblTransfer.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblTransferAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblTransfer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTransferMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblTransferMouseEntered(evt);
            }
        });
        jScrollPane3.setViewportView(tblTransfer);

        root.add(jScrollPane3);
        jScrollPane3.setBounds(10, 460, 1160, 120);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Search.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Search  By: Name", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search Patient : ");

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
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_search_Patient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        SearchLayout.setVerticalGroup(
            SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_search_Patient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PatientPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Patient Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        Name.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name.setText("Name:");

        Admission.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Admission.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Admission.setText("No.");

        lbl_name.setText("-");

        no.setText("-");

        Admission1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Admission1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Admission1.setText("Patient ID");

        lbl_pr_id.setText("-");

        Admission2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Admission2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Admission2.setText("Department: ");

        deprt.setText("-");

        javax.swing.GroupLayout PatientPanelLayout = new javax.swing.GroupLayout(PatientPanel);
        PatientPanel.setLayout(PatientPanelLayout);
        PatientPanelLayout.setHorizontalGroup(
            PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientPanelLayout.createSequentialGroup()
                .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PatientPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(Admission1)
                        .addGap(6, 6, 6)
                        .addComponent(lbl_pr_id, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PatientPanelLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(Name)
                        .addGap(6, 6, 6)
                        .addComponent(lbl_name, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PatientPanelLayout.createSequentialGroup()
                        .addComponent(Admission2)
                        .addGap(13, 13, 13)
                        .addComponent(deprt, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PatientPanelLayout.createSequentialGroup()
                        .addComponent(Admission)
                        .addGap(13, 13, 13)
                        .addComponent(no, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        PatientPanelLayout.setVerticalGroup(
            PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Admission1)
                    .addGroup(PatientPanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_pr_id)
                            .addComponent(Admission)
                            .addComponent(no))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Name)
                    .addGroup(PatientPanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lbl_name))
                    .addComponent(Admission2)
                    .addComponent(deprt))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Admission details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        date.setText("-");
        jPanel4.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 140, 20));

        Rate.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Rate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Rate.setText("Rate:");
        jPanel4.add(Rate, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 71, -1, -1));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Bed status:");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(431, 83, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Room type:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 36, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Admit date:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("per day");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 69, -1, -1));

        txt_room.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_room.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel4.add(txt_room, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 32, 80, -1));

        date_occu.setText("-");
        jPanel4.add(date_occu, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 140, 20));

        lvl_status.setText("-");
        jPanel4.add(lvl_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 84, 128, -1));

        txt_rate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_rate.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel4.add(txt_rate, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 65, 80, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Bed no:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, -1));

        txt_bedno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_bedno.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel4.add(txt_bedno, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 80, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Room no:");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        txt_roomno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_roomno.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel4.add(txt_roomno, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 80, -1));

        lbl_mop1.setText("-");
        jPanel4.add(lbl_mop1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel5.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jButton4.setText("Transfer Bed");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PatientPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PatientPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(74, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))))
        );

        root.add(jPanel1);
        jPanel1.setBounds(10, 70, 1140, 340);

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

    private void tblTransferMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTransferMouseClicked

        try {
            int row = tblTransfer.getSelectedRow();
            String Table_transfer = (tblTransfer.getModel().getValueAt(row, 0).toString());
            String sql = "select \n"
                    + "Core1_bm_rooms.id as 'No.',\n"
                    + "Core1_bm_roomroom.RoomName as Room,\n"
                    + "Core1_bm_rooms.Bed_No as Bed,\n"
                    + "Core1_bm_rooms.Room_type as type,\n"
                    + "Core1_pr_PatientRegistration.Patient_ID as ID,\n"
                    + "concat(Core1_pr_PatientRegistration.LastName,', ',Core1_pr_PatientRegistration.FirstName,' ',Core1_pr_PatientRegistration.MiddleName) as Name,\n"
                    + "Core1_bm_rooms.rate as Rate,\n"
                    + "Core1_bm_rooms.date_occopied as DaT,\n"
                    + "Core1_bm_rooms.bed_status as Availability,bed_remarks as Remarks\n"
                    + "from Core1_bm_roomroom\n"
                    + "inner join Core1_bm_rooms\n"
                    + "on Core1_bm_roomroom.Roomlegitid=Core1_bm_rooms.Room_ID\n"
                    + "left join Core1_pr_PatientRegistration\n"
                    + "on Core1_bm_rooms.Patient_ID=Core1_pr_PatientRegistration.Patient_ID where Core1_bm_rooms.id='" + Table_transfer + "' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                String add10 = rs.getString("No.");
                no.setText(add10);
                String add0 = rs.getString("Room");
                txt_roomno.setText(add0);
                String add7 = rs.getString("Bed");
                txt_bedno.setText(add7);
                String add3 = rs.getString("Name");
                lbl_name.setText(add3);
                String add9 = rs.getString("Availability");
                lvl_status.setText(add9);
                String add4 = rs.getString("Remarks");
                deprt.setText(add4);
                String add8 = rs.getString("Rate");
                txt_rate.setText(add8);
                String add1 = rs.getString("ID");
                lbl_pr_id.setText(add1);
                String add2 = rs.getString("DaT");
                date.setText(add2);
                String add22 = rs.getString("type");
                txt_room.setText(add22);


                /*     String add5 = rs.getString("Payment");
                lbl_mop.setText(add5);
                String add6 = rs.getString("Room type");
                txt_room.setText(add6);

                String add8 = rs.getString("Rate");
                txt_rate.setText(add8);

                Date add11 = rs.getDate("Admit date");
                date_admit.setDate(add11);
                String add12 = rs.getString("Doctor");
                combo_dr.addItem(add12);
                combo_dr.setSelectedItem(add12);*/
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_tblTransferMouseClicked

    private void tblTransferMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTransferMouseEntered

    }//GEN-LAST:event_tblTransferMouseEntered

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
            tblTransfer.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
        }
    }//GEN-LAST:event_txt_search_PatientKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        BedtranferFinal bed = new BedtranferFinal();
        BedtranferFinal.txt_roomno2.setText(this.txt_roomno.getText());
        BedtranferFinal.lbl_admitid2.setText(this.no.getText());
        BedtranferFinal.lbl_pr_id2.setText(this.lbl_pr_id.getText());
        BedtranferFinal.lbl_name2.setText(this.lbl_name.getText());
        BedtranferFinal.txt_bedno2.setText(this.txt_bedno.getText());
        BedtranferFinal.room_type.setText(this.txt_room.getText());
        BedtranferFinal.txt_rate2.setText(this.txt_rate.getText());
        BedtranferFinal.date_lbl3.setText(this.date.getText());

        bed.setVisible(true);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void tblTransferAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblTransferAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tblTransferAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Admission;
    private javax.swing.JLabel Admission1;
    private javax.swing.JLabel Admission2;
    private javax.swing.JLabel Name;
    private javax.swing.JPanel PatientPanel;
    private javax.swing.JLabel Rate;
    private javax.swing.JPanel Search;
    private javax.swing.JLabel date;
    private javax.swing.JLabel date_occu;
    private javax.swing.JLabel deprt;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_mop1;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_pr_id;
    private javax.swing.JLabel lvl_status;
    private javax.swing.JLabel no;
    private javax.swing.JPanel root;
    private javax.swing.JTable tblTransfer;
    private javax.swing.JTextField txt_bedno;
    private javax.swing.JTextField txt_rate;
    private javax.swing.JTextField txt_room;
    private javax.swing.JTextField txt_roomno;
    private javax.swing.JTextField txt_search_Patient;
    // End of variables declaration//GEN-END:variables
}
