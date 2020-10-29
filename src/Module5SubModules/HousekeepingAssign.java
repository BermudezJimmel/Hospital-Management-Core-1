/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module5SubModules;

import Notifications.DesktopNotify;
import SystemInstance.MysqlConnect;
import static com.sbix.jnotify.NoticeWindow.LONG_DELAY;
import static java.lang.Thread.sleep;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import net.sf.jcarrierpigeon.WindowPosition;
import net.sf.jtelegraph.Telegraph;
import net.sf.jtelegraph.TelegraphQueue;
import net.sf.jtelegraph.TelegraphType;

/**
 *
 * @author jerome
 */
public final class HousekeepingAssign extends javax.swing.JPanel {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    java.sql.PreparedStatement pst = null;
    CallableStatement cst = null;

    public HousekeepingAssign() {
        initComponents();
        con = MysqlConnect.ConnectDB();
        Update_assign_tbl();
        select_pat();
        CurrentDate();
        Update_assign_tbl();
        Update_assign_tblv2();
        jTextField1.setVisible(false);
    }
public void clock() {

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

                        // lbl_clockWeek.setText("" + weekday);
                        //lbl_Clock.setText("" + month + "-" + day + "-" + year);
                        //lbl_Clock1.setText("" + hour + ":" + minute + ":" + second);
                        //lbl_AP.setText(day_night);
                        // lbl_TIme_Register.setText("" + hour + "" + Sec + "" + mn);
                        //  lbl_DayNight.setText(""+day_night);
                        //  lbl_AMPM.setText("" + day_night);
                        //  lbl_Date_Exam.setText("" + day + " " + M + " " + year);
                        //   DateJob = "" + month + "-" + day1 + "-" + year;
                        //  jLabel4.setText(DateJob);
                        //  lbl_Week.setText(""+weekday);
                        //  time.setText(+hour + ":" + mn + day_night);
                        Update_assign_tbl();
                     
                        sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        clock.start();

    }

    private void select_pat() {

        try {
            String sql = "select name from Attendance1$ where department='Core/PM' or   department='Core/AM' and Note='Regesterd'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

                hk_toeday.addItem(rs.getString("name"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }
   

    public void CurrentDate() {
        Calendar cal = new GregorianCalendar();
        int month1 = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int min = cal.get(Calendar.MINUTE);

        int hour = cal.get(Calendar.HOUR);
        int AM_PM = cal.get(Calendar.AM_PM);

        int month = month1 + 1;

        String day_night = "";

        if (AM_PM == 1) {
            day_night = "PM";
        } else {
            day_night = "AM";
        }
        String weekday = "";
        if (hour == 0) {
            hour = 12;
        }

        String mn = null;
        switch (min) {
            case 0:
                mn = "0" + min;
                break;
            case 1:
                mn = "0" + min;
                break;
            case 2:
                mn = "0" + min;
                break;
            case 3:
                mn = "0" + min;
                break;
            case 4:
                mn = "0" + min;
                break;
            case 5:
                mn = "0" + min;
                break;
            case 6:
                mn = "0" + min;
                break;
            case 7:
                mn = "0" + min;
                break;
            case 8:
                mn = "0" + min;
                break;
            case 9:
                mn = "0" + min;
                break;
            default:
                mn = "" + min;
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

        String buwan;
        if (month == 1) {
            buwan = "0" + month;
        } else if (month1 == 1) {
            buwan = "0" + month;
        } else if (month1 == 2) {
            buwan = "0" + month;
        } else if (month1 == 3) {
            buwan = "0" + month;
        } else if (month1 == 4) {
            buwan = "0" + month;
        } else if (month1 == 5) {
            buwan = "0" + month;
        } else if (month1 == 6) {
            buwan = "0" + month;
        } else if (month1 == 7) {
            buwan = "0" + month;
        } else if (month1 == 8) {
            buwan = "0" + month;
        } else {
            buwan = "" + month;
        }
        jTextField3.setText((buwan) + "/" + (day1) + "/" + year);
        jTextField4.setText(hour + ":" + mn + " " + day_night);

    }

    private void Update_assign_tbl() {

        try {
            String sql = "select id,Room_ID as Room,Bed_No as Bed, bed_status as Status from Core1_bm_rooms where bed_status = 'For Cleaning'";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            tbl_view.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void Update_assign_tblv2() {

        try {
            String sql = "select Name , datetime as 'Date and time',Room,Bed,Status from Core1_lm_assign";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            tbl_view2.setModel(DbUtils.resultSetToTableModel(rs));
                tbl_view2.getColumnModel().getColumn(0).setPreferredWidth(40);
                tbl_view2.getColumnModel().getColumn(1).setPreferredWidth(100);
                tbl_view2.getColumnModel().getColumn(2).setPreferredWidth(10);
                 tbl_view2.getColumnModel().getColumn(3).setPreferredWidth(10);
                tbl_view2.getColumnModel().getColumn(4).setPreferredWidth(100);
             

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        root = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        hk_toeday = new rojerusan.RSComboMetro();
        jLabel4 = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        fillAll = new rojerusan.RSMaterialButtonRound();
        jTextField4 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        forCleaning = new javax.swing.JPanel();
        scrollPatient = new javax.swing.JScrollPane();
        tbl_view2 = new rojerusan.RSTableMetro();
        jPanel1 = new javax.swing.JPanel();
        scrollPatient1 = new javax.swing.JScrollPane();
        tbl_view = new rojerusan.RSTableMetro();

        root.setBackground(new java.awt.Color(255, 255, 255));
        root.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Assign Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hk_toeday.setEditable(true);
        hk_toeday.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select here" }));
        hk_toeday.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jPanel4.add(hk_toeday, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 135, 34));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Date assign");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 20));

        label1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        label1.setText("Housekeeping assign");
        jPanel4.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, 20));

        label2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        label2.setText("To");
        jPanel4.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, 20));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Bed:");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 80, 40, 20));

        jLabel25.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Room:");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, -1));

        fillAll.setText("Assign");
        fillAll.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        fillAll.setMaximumSize(new java.awt.Dimension(82, 26));
        fillAll.setMinimumSize(new java.awt.Dimension(82, 26));
        fillAll.setPreferredSize(new java.awt.Dimension(88, 28));
        fillAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillAllActionPerformed(evt);
            }
        });
        jPanel4.add(fillAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 130, 50));

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(255, 255, 255));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 120, -1));

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(255, 255, 255));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 120, -1));

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 50, -1));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 50, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 10, 180));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Time assign");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, 20));

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(255, 255, 255));
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 50, -1));

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(255, 255, 255));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 50, -1));

        root.add(jPanel4);
        jPanel4.setBounds(70, 120, 480, 230);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("View");
        root.add(jLabel14);
        jLabel14.setBounds(10, 410, 100, 30);

        forCleaning.setBackground(new java.awt.Color(255, 255, 255));
        forCleaning.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Scheduled for cleaning", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        forCleaning.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollPatient.setBackground(new java.awt.Color(255, 255, 255));
        scrollPatient.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192), 3));

        tbl_view2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_view2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        tbl_view2.setFuenteFilas(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        tbl_view2.setFuenteFilasSelect(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        tbl_view2.setFuenteHead(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        tbl_view2.setGrosorBordeFilas(0);
        tbl_view2.setGrosorBordeHead(0);
        tbl_view2.setMultipleSeleccion(false);
        tbl_view2.getTableHeader().setReorderingAllowed(false);
        tbl_view2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_view2MouseClicked(evt);
            }
        });
        scrollPatient.setViewportView(tbl_view2);

        forCleaning.add(scrollPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 30, 540, 280));

        root.add(forCleaning);
        forCleaning.setBounds(580, 110, 570, 320);

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

        scrollPatient1.setBackground(new java.awt.Color(255, 255, 255));
        scrollPatient1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192), 3));

        tbl_view.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_view.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        tbl_view.setFuenteFilas(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        tbl_view.setFuenteFilasSelect(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        tbl_view.setFuenteHead(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        tbl_view.setGrosorBordeFilas(0);
        tbl_view.setGrosorBordeHead(0);
        tbl_view.setMultipleSeleccion(false);
        tbl_view.getTableHeader().setReorderingAllowed(false);
        tbl_view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_viewMouseClicked(evt);
            }
        });
        scrollPatient1.setViewportView(tbl_view);

        root.add(scrollPatient1);
        scrollPatient1.setBounds(10, 436, 1140, 140);

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

    private void fillAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillAllActionPerformed

        String a = this.jTextField6.getText();
        String b = this.jTextField2.getText();
           


        if (a.isEmpty() || hk_toeday.getSelectedItem() == "Select here") {

            DesktopNotify.showDesktopMessage("INPUT MISSING...", "Please select on table!",
                    DesktopNotify.INPUT_REQUEST, 8000);

        } else {
            try {
                String query = "insert into Core1_lm_assign values(?,?,?,?,?,?)";

                pst = con.prepareStatement(query);

                pst.setString(1, hk_toeday.getSelectedItem().toString());
                pst.setString(2, jTextField3.getText() + " " + jTextField4.getText());
                pst.setString(3, jTextField6.getText());
                pst.setString(4, jTextField2.getText());
                pst.setString(5, "Scheduled for cleaning");
                pst.setString(6, jTextField1.getText());

                pst.execute();

                try {
                    String query2 = "update Core1_bm_rooms set bed_status = 'Scheduled for cleaning',bed_remarks='Ongoing Cleaning'"
                            + " where id='" + jTextField1.getText() + "' ";

                    java.sql.Statement st = null;

                    st = con.createStatement();
                    st.executeUpdate(query2);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

            DesktopNotify.showDesktopMessage("Successfully...", "Assigned houseskeeping!",
                    DesktopNotify.SUCCESS, 8000);

            Update_assign_tbl();
            Update_assign_tblv2();
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField6.setText("");
            hk_toeday.setSelectedIndex(0);
        }
    }//GEN-LAST:event_fillAllActionPerformed

    private void tbl_view2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_view2MouseClicked
        /*  int row = tblPatient.rowAtPoint(evt.getPoint());
        if ((evt.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
            this.tblPatient.setRowSelectionInterval(row, row);
            MousePos = evt.getY() / 16;
            menuC.show(evt.getComponent(), evt.getX(), evt.getY());
        } else {
            this.tblPatient.setRowSelectionInterval(row, row);
        }*/
    }//GEN-LAST:event_tbl_view2MouseClicked

    private void tbl_viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_viewMouseClicked
        try {
            int row = tbl_view.getSelectedRow();
            String table_update = (tbl_view.getModel().getValueAt(row, 0).toString());
            String sql = "select id as No,Room_ID as Room,Bed_No as Bed, bed_status as Status from Core1_bm_rooms where id='" + table_update + "'";
            //  String table_update = (tbl_view.getModel().getValueAt(row, 0).toString());
            //     String sql = "select Room_ID as Room,Bed_No as Bed, bed_status as Status from Core1_bm_rooms where Room_ID='" + table_update + "'";

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                //Display data for update
                String add0 = rs.getString("Room");
                jTextField6.setText(add0);
                String add1 = rs.getString("Bed");
                jTextField2.setText(add1);
                String add11 = rs.getString("No").toString();
                jTextField1.setText(add11);

            }
            boolean a = tbl_view.isEditing();

            if (a == false) {
                JOptionPane.showMessageDialog(null, "You cannot edit this table");
                //  System.out.println("You cannot edit this table");

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_tbl_viewMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonRound fillAll;
    private javax.swing.JPanel forCleaning;
    private rojerusan.RSComboMetro hk_toeday;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JPanel root;
    public static javax.swing.JScrollPane scrollPatient;
    public static javax.swing.JScrollPane scrollPatient1;
    public static rojerusan.RSTableMetro tbl_view;
    public static rojerusan.RSTableMetro tbl_view2;
    // End of variables declaration//GEN-END:variables
}
