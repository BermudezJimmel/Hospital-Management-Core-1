/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module3SubModules;

import SystemInstance.MysqlConnect;
import java.awt.Color;
import java.awt.Component;
import static java.lang.Thread.sleep;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author jerome
 */
public final class Consultation extends javax.swing.JPanel {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    CallableStatement cst = null;
    DefaultTableModel mode;
    String Gender;

    public Consultation() {
        initComponents();
        con = MysqlConnect.ConnectDB();
        tblSchedule();
        tblpatients();
        waitingPatient();
        clockJobView();
        count();
        countall();
        select_dr();
        total();
    }
    Module3SubModules.findings showdata = new Module3SubModules.findings();

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
                        tblSchedule();
                        tblpatients();
                        waitingPatient();
                        sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        clock.start();

    }

    private void total() {

    }

    private void count() {
        try {

            String q = "Select Count(status) as 'stat' FROM Core1_opd_consultlist where\n"
                    + "cast (appontment_registered as date) =    convert (nvarchar,GETDATE(),101)";
            pst = con.prepareStatement(q);
            rs = pst.executeQuery();
            if (rs.next()) {
                String sum = rs.getString("stat");
                total_patient.setText(sum);
            }
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    private void countall() {
        try {

            String q = "Select Count(*) as 'stat' FROM Core1_opd_consultlist ";
            pst = con.prepareStatement(q);
            rs = pst.executeQuery();
            if (rs.next()) {
                String sum = rs.getString("stat");
                Totalallpatient.setText(sum);
            }
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    private void select_dr() {
        try {
            String sql = "select name from Core1_dra_publish where schedule = DATENAME(weekday, GETDATE())";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Filter_schedule.addItem(rs.getString("name"));
            }

        } catch (Exception e) {
        }
    }

    public void tblpatients() {

        try {

            String q = "select Patient_ID as ID, name as 'Patient name',patient_illness as 'Illness',age as 'Age',gender as 'Gender',address as 'Location', mode_of_payment as 'Pay',\n"
                    + "doctor_name as 'Doctor',specialization as 'Specialization',appontment_registered as 'Registered date',status 'Status'\n"
                    + "from Core1_opd_consultlist";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(q);

            all_tbl.setModel(DbUtils.resultSetToTableModel(rs));

            all_tbl.getColumnModel().getColumn(0).setPreferredWidth(5);
            all_tbl.getColumnModel().getColumn(1).setPreferredWidth(100);
            all_tbl.getColumnModel().getColumn(2).setPreferredWidth(35);
            all_tbl.getColumnModel().getColumn(3).setPreferredWidth(5);
            all_tbl.getColumnModel().getColumn(4).setPreferredWidth(40);
            all_tbl.getColumnModel().getColumn(5).setPreferredWidth(40);
            all_tbl.getColumnModel().getColumn(6).setPreferredWidth(25);
            all_tbl.getColumnModel().getColumn(7).setPreferredWidth(30);
            all_tbl.getColumnModel().getColumn(8).setPreferredWidth(105);
            all_tbl.getColumnModel().getColumn(9).setPreferredWidth(90);

        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public void tblSchedule() {

        try {

            String q = "select Patient_ID as ID,name as 'Patient name',patient_illness as 'Illness',age as 'Age',gender as 'Gender',address as 'Location', mode_of_payment as 'Payment',"
                    + "doctor_name as 'Doctor',specialization as 'Specialization',appontment_registered as 'Registered date',status 'Status'\n"
                    + "from Core1_opd_consultlist where consult_day = DATENAME(weekday, GETDATE()) and "
                    + "cast (appontment_registered as date) =    convert (nvarchar,GETDATE(),101)";
            pst = con.prepareStatement(q);
            rs = pst.executeQuery();

            today_tbl.setModel(DbUtils.resultSetToTableModel(rs));
            today_tbl.getColumnModel().getColumn(0).setPreferredWidth(5);
            today_tbl.getColumnModel().getColumn(1).setPreferredWidth(100);
            today_tbl.getColumnModel().getColumn(2).setPreferredWidth(35);
            today_tbl.getColumnModel().getColumn(3).setPreferredWidth(5);
            today_tbl.getColumnModel().getColumn(4).setPreferredWidth(40);
            today_tbl.getColumnModel().getColumn(5).setPreferredWidth(40);
            today_tbl.getColumnModel().getColumn(6).setPreferredWidth(25);
            today_tbl.getColumnModel().getColumn(7).setPreferredWidth(30);
            today_tbl.getColumnModel().getColumn(8).setPreferredWidth(105);
            today_tbl.getColumnModel().getColumn(9).setPreferredWidth(90);

        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public void waitingPatient() {

        try {

            String q = "select Patient_ID as ID,name as Patient,age as Age,gender as Gender,patContact as 'Contact no',\n"
                    + "patient_illness as illnes,doctor_name as  Doctor,specialization as Specialization ,\n"
                    + "bp as 'Blood presure',temp as 'Body temperature',height as  Height,weight as Weight,dateTime as 'As of'\n"
                    + " from Core1_opd_consultwaiting where status = 'Pending consultation' and \n"
                    + "cast (dateTime as date) =    convert (nvarchar,GETDATE(),101)";
            pst = con.prepareStatement(q);
            rs = pst.executeQuery();

            pending_tbl.setModel(DbUtils.resultSetToTableModel(rs));
            pending_tbl.getColumnModel().getColumn(0).setPreferredWidth(5);
            pending_tbl.getColumnModel().getColumn(1).setPreferredWidth(100);
            pending_tbl.getColumnModel().getColumn(2).setPreferredWidth(35);
            pending_tbl.getColumnModel().getColumn(3).setPreferredWidth(5);
            pending_tbl.getColumnModel().getColumn(4).setPreferredWidth(40);
            pending_tbl.getColumnModel().getColumn(5).setPreferredWidth(40);
            pending_tbl.getColumnModel().getColumn(6).setPreferredWidth(25);
            pending_tbl.getColumnModel().getColumn(7).setPreferredWidth(30);
            pending_tbl.getColumnModel().getColumn(8).setPreferredWidth(105);
            pending_tbl.getColumnModel().getColumn(9).setPreferredWidth(90);

        } catch (Exception e) {
            System.out.println(e);

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        root = new javax.swing.JPanel();
        Search = new javax.swing.JPanel();
        tab2 = new javax.swing.JPanel();
        AllPatient = new javax.swing.JPanel();
        scrollPatient = new javax.swing.JScrollPane();
        all_tbl = new rojerusan.RSTableMetro()
        {
            @Override

            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex)
            {
                Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);

                Object value = getModel().getValueAt(rowIndex,columnIndex);

                if(columnIndex == 10)
                {

                    if(value.equals("Done Consultation"))
                    {

                        componenet.setBackground(Color.GREEN);
                        componenet.setForeground(Color.BLACK);

                    }
                    if(value.equals("No vital signs yet"))
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
        Today_Patients = new javax.swing.JPanel();
        scrollPatient1 = new javax.swing.JScrollPane();
        today_tbl = new rojerusan.RSTableMetro()
        {
            @Override

            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex)
            {
                Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);

                Object value = getModel().getValueAt(rowIndex,columnIndex);

                if(columnIndex == 10)
                {

                    if(value.equals("Done Consultation"))
                    {

                        componenet.setBackground(Color.GREEN);
                        componenet.setForeground(Color.BLACK);

                    }
                    if(value.equals("No vital signs yet"))
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
        ConsultationPending = new javax.swing.JPanel();
        scrollPatient2 = new javax.swing.JScrollPane();
        pending_tbl = new rojerusan.RSTableMetro()
        {
            @Override

            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex)
            {
                Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);

                Object value = getModel().getValueAt(rowIndex,columnIndex);

                if(columnIndex == 8)
                {

                    if(value.equals("Done Consultation"))
                    {

                        componenet.setBackground(Color.GREEN);
                        componenet.setForeground(Color.BLACK);

                    }
                    if(value.equals("No vital signs yet"))
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
        jPanel1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Filter_schedule = new rojerusan.RSComboMetro();
        Totaall = new javax.swing.JLabel();
        totalToday = new javax.swing.JLabel();
        Totalallpatient = new javax.swing.JTextField();
        total_patient = new javax.swing.JTextField();
        Search1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        total_done = new javax.swing.JTextField();
        total_apoint = new javax.swing.JTextField();
        total_wait = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        total_apoint1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        total_slot = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        total_cash = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        total_hmo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        total_new = new javax.swing.JTextField();
        total_old = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        fillAll = new rojerusan.RSMaterialButtonRound();

        root.setBackground(new java.awt.Color(255, 255, 255));
        root.setLayout(null);

        Search.setBackground(new java.awt.Color(255, 255, 255));
        Search.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab2.setLayout(new java.awt.CardLayout());

        scrollPatient.setBackground(new java.awt.Color(255, 255, 255));
        scrollPatient.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192), 3));

        all_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        all_tbl.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        all_tbl.setFuenteFilas(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        all_tbl.setFuenteFilasSelect(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        all_tbl.setFuenteHead(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        all_tbl.setGrosorBordeFilas(0);
        all_tbl.setGrosorBordeHead(0);
        all_tbl.setMultipleSeleccion(false);
        all_tbl.getTableHeader().setReorderingAllowed(false);
        all_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                all_tblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                all_tblMouseEntered(evt);
            }
        });
        scrollPatient.setViewportView(all_tbl);

        javax.swing.GroupLayout AllPatientLayout = new javax.swing.GroupLayout(AllPatient);
        AllPatient.setLayout(AllPatientLayout);
        AllPatientLayout.setHorizontalGroup(
            AllPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
            .addGroup(AllPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AllPatientLayout.createSequentialGroup()
                    .addComponent(scrollPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        AllPatientLayout.setVerticalGroup(
            AllPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
            .addGroup(AllPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scrollPatient, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
        );

        tab2.add(AllPatient, "card4");

        Today_Patients.setBackground(new java.awt.Color(255, 255, 255));
        Today_Patients.setLayout(new javax.swing.BoxLayout(Today_Patients, javax.swing.BoxLayout.LINE_AXIS));

        scrollPatient1.setBackground(new java.awt.Color(255, 255, 255));
        scrollPatient1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192), 3));

        today_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        today_tbl.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        today_tbl.setFuenteFilas(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        today_tbl.setFuenteFilasSelect(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        today_tbl.setFuenteHead(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        today_tbl.setGrosorBordeFilas(0);
        today_tbl.setGrosorBordeHead(0);
        today_tbl.setMultipleSeleccion(false);
        today_tbl.getTableHeader().setReorderingAllowed(false);
        today_tbl.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                today_tblAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        today_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                today_tblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                today_tblMouseEntered(evt);
            }
        });
        scrollPatient1.setViewportView(today_tbl);

        Today_Patients.add(scrollPatient1);

        tab2.add(Today_Patients, "card4");

        ConsultationPending.setBackground(new java.awt.Color(255, 255, 255));
        ConsultationPending.setLayout(new javax.swing.BoxLayout(ConsultationPending, javax.swing.BoxLayout.LINE_AXIS));

        scrollPatient2.setBackground(new java.awt.Color(255, 255, 255));
        scrollPatient2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192), 3));

        pending_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        pending_tbl.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        pending_tbl.setFuenteFilas(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        pending_tbl.setFuenteFilasSelect(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        pending_tbl.setFuenteHead(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        pending_tbl.setGrosorBordeFilas(0);
        pending_tbl.setGrosorBordeHead(0);
        pending_tbl.setMultipleSeleccion(false);
        pending_tbl.getTableHeader().setReorderingAllowed(false);
        pending_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pending_tblMouseClicked(evt);
            }
        });
        scrollPatient2.setViewportView(pending_tbl);

        ConsultationPending.add(scrollPatient2);

        tab2.add(ConsultationPending, "card4");

        Search.add(tab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 890, 390));

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setBackground(new java.awt.Color(0, 85, 94));
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Pending Consultation");
        jLabel17.setOpaque(true);
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 120, 30));

        jLabel14.setBackground(new java.awt.Color(0, 124, 134));
        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Select Doctor");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(644, 50, 100, 30));

        jLabel16.setBackground(new java.awt.Color(0, 85, 94));
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Today patients");
        jLabel16.setOpaque(true);
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 110, 30));

        jLabel15.setBackground(new java.awt.Color(0, 85, 94));
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("All patients");
        jLabel15.setOpaque(true);
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 110, 30));

        Filter_schedule.setEditable(true);
        Filter_schedule.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Click me!" }));
        Filter_schedule.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        Filter_schedule.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                Filter_schedulePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        Filter_schedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Filter_scheduleActionPerformed(evt);
            }
        });
        jPanel1.add(Filter_schedule, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 130, -1));

        Search.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 90));

        root.add(Search);
        Search.setBounds(20, 90, 890, 480);

        Totaall.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Totaall.setPreferredSize(new java.awt.Dimension(114, 21));
        root.add(Totaall);
        Totaall.setBounds(930, 520, 160, 40);

        totalToday.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        totalToday.setPreferredSize(new java.awt.Dimension(114, 21));
        root.add(totalToday);
        totalToday.setBounds(930, 520, 160, 40);

        Totalallpatient.setBackground(new java.awt.Color(51, 102, 255));
        Totalallpatient.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Totalallpatient.setForeground(new java.awt.Color(255, 0, 51));
        Totalallpatient.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Totalallpatient.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        Totalallpatient.setDoubleBuffered(true);
        Totalallpatient.setEnabled(false);
        Totalallpatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalallpatientActionPerformed(evt);
            }
        });
        root.add(Totalallpatient);
        Totalallpatient.setBounds(1110, 520, 45, 40);

        total_patient.setBackground(new java.awt.Color(255, 0, 51));
        total_patient.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        total_patient.setForeground(new java.awt.Color(255, 0, 51));
        total_patient.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total_patient.setText("0");
        total_patient.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        total_patient.setEnabled(false);
        root.add(total_patient);
        total_patient.setBounds(1110, 520, 45, 40);

        Search1.setBackground(new java.awt.Color(255, 255, 255));
        Search1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Patient monitoring", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        Search1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Consultation done =");
        jLabel3.setPreferredSize(new java.awt.Dimension(114, 21));
        Search1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 160, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Remaining  appointment =");
        jLabel5.setPreferredSize(new java.awt.Dimension(114, 21));
        Search1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 160, 30));

        total_done.setBackground(new java.awt.Color(51, 102, 255));
        total_done.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        total_done.setForeground(new java.awt.Color(255, 0, 51));
        total_done.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total_done.setText("0");
        total_done.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        total_done.setEnabled(false);
        Search1.add(total_done, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 45, 34));

        total_apoint.setBackground(new java.awt.Color(51, 102, 255));
        total_apoint.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        total_apoint.setForeground(new java.awt.Color(255, 0, 51));
        total_apoint.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total_apoint.setText("0");
        total_apoint.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        total_apoint.setEnabled(false);
        Search1.add(total_apoint, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 45, 34));

        total_wait.setBackground(new java.awt.Color(51, 102, 255));
        total_wait.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        total_wait.setForeground(new java.awt.Color(255, 0, 51));
        total_wait.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total_wait.setText("0");
        total_wait.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        total_wait.setEnabled(false);
        Search1.add(total_wait, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 45, 34));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Today`s total Appointment =");
        Search1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 160, 30));

        total_apoint1.setBackground(new java.awt.Color(0, 153, 153));
        total_apoint1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        total_apoint1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total_apoint1.setEnabled(false);
        Search1.add(total_apoint1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 45, 34));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Available slot");
        jLabel7.setPreferredSize(new java.awt.Dimension(155, 21));
        Search1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 80, 30));

        total_slot.setBackground(new java.awt.Color(51, 102, 255));
        total_slot.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        total_slot.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total_slot.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        total_slot.setEnabled(false);
        Search1.add(total_slot, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 45, 34));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Total of patient use Cash = ");
        jLabel8.setPreferredSize(new java.awt.Dimension(114, 21));
        Search1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 160, 30));

        total_cash.setBackground(new java.awt.Color(51, 102, 255));
        total_cash.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        total_cash.setForeground(new java.awt.Color(255, 0, 51));
        total_cash.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total_cash.setText("0");
        total_cash.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        total_cash.setEnabled(false);
        Search1.add(total_cash, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 45, 34));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Total of patient use HMO = ");
        jLabel9.setPreferredSize(new java.awt.Dimension(114, 21));
        Search1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 160, 30));

        total_hmo.setBackground(new java.awt.Color(51, 102, 255));
        total_hmo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        total_hmo.setForeground(new java.awt.Color(255, 0, 51));
        total_hmo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total_hmo.setText("0");
        total_hmo.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        total_hmo.setEnabled(false);
        Search1.add(total_hmo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 45, 34));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Total of  new patient = ");
        jLabel10.setPreferredSize(new java.awt.Dimension(114, 21));
        Search1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 160, 30));

        total_new.setBackground(new java.awt.Color(51, 102, 255));
        total_new.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        total_new.setForeground(new java.awt.Color(255, 0, 51));
        total_new.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total_new.setText("0");
        total_new.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        total_new.setEnabled(false);
        Search1.add(total_new, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 45, 34));

        total_old.setBackground(new java.awt.Color(51, 102, 255));
        total_old.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        total_old.setForeground(new java.awt.Color(255, 0, 51));
        total_old.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total_old.setText("0");
        total_old.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        total_old.setEnabled(false);
        Search1.add(total_old, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 45, 34));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Total of  old patient = ");
        jLabel11.setPreferredSize(new java.awt.Dimension(114, 21));
        Search1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 160, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 102, 102));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        Search1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, -120, 10, 500));

        root.add(Search1);
        Search1.setBounds(920, 140, 240, 367);

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1166, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        root.add(jPanel2);
        jPanel2.setBounds(0, 0, 1166, 50);

        fillAll.setText("View no vital signs yet");
        fillAll.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        fillAll.setMaximumSize(new java.awt.Dimension(82, 26));
        fillAll.setMinimumSize(new java.awt.Dimension(82, 26));
        fillAll.setPreferredSize(new java.awt.Dimension(88, 28));
        fillAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillAllActionPerformed(evt);
            }
        });
        root.add(fillAll);
        fillAll.setBounds(920, 80, 240, 50);

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

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        lblColor(jLabel17);
        rstColor(jLabel16);
        rstColor(jLabel15);
        ConsultationPending.setVisible(true);
        Today_Patients.setVisible(false);
        AllPatient.setVisible(false);
        totalToday.setText("Total of today patient :");
        totalToday.setVisible(true);
        total_patient.setVisible(true);
        Totalallpatient.setVisible(false);
        Totaall.setVisible(false);

    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        lblColor(jLabel16);
        rstColor(jLabel15);
        rstColor(jLabel17);
        Today_Patients.setVisible(true);
        AllPatient.setVisible(false);
        ConsultationPending.setVisible(false);
        totalToday.setText("Total of today patient :");
        totalToday.setVisible(true);
        total_patient.setVisible(true);
        Totalallpatient.setVisible(false);
        Totaall.setVisible(false);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        lblColor(jLabel15);
        rstColor(jLabel16);
        rstColor(jLabel17);
        AllPatient.setVisible(true);
        Today_Patients.setVisible(false);
        ConsultationPending.setVisible(false);
        Totaall.setText("Total of all patient :");
        Totaall.setVisible(true);
        Totalallpatient.setVisible(true);
        total_patient.setVisible(false);
        totalToday.setVisible(false);
    }//GEN-LAST:event_jLabel15MouseClicked

    private void TotalallpatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalallpatientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalallpatientActionPerformed

    private void all_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all_tblMouseClicked
        /*  int row = tblPatient.rowAtPoint(evt.getPoint());
        if ((evt.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
            this.tblPatient.setRowSelectionInterval(row, row);
            MousePos = evt.getY() / 16;
            menuC.show(evt.getComponent(), evt.getX(), evt.getY());
        } else {
            this.tblPatient.setRowSelectionInterval(row, row);
        }*/
    }//GEN-LAST:event_all_tblMouseClicked

    private void today_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_today_tblMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_today_tblMouseClicked

    private void pending_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pending_tblMouseClicked
        try {
            int i = pending_tbl.getSelectedRow();

            TableModel model = pending_tbl.getModel();

            String id = model.getValueAt(i, 0).toString();
            String fn = model.getValueAt(i, 1).toString();
            String age = model.getValueAt(i, 2).toString();
            String gndr = model.getValueAt(i, 3).toString();
            String no = model.getValueAt(i, 4).toString();
            String sick = model.getValueAt(i, 5).toString();
            String dr = model.getValueAt(i, 6).toString();
            String sp = model.getValueAt(i, 7).toString();
            String bp = model.getValueAt(i, 8).toString();
            String bt = model.getValueAt(i, 9).toString();
            String h = model.getValueAt(i, 10).toString();
            String w = model.getValueAt(i, 11).toString();
            String dd = model.getValueAt(i, 12).toString();

            showdata.setVisible(true);
            showdata.pack();
            showdata.setLocationRelativeTo(null);
            showdata.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            showdata.find_patName.setText(fn);
            showdata.find_patAge.setText(age);
            showdata.find_patGender.setText(gndr);
            showdata.find_patNo.setText(no);
            showdata.find_patDr.setText(dr);
            showdata.find_drSpecia.setText(sp);
            showdata.find_patSick.setText(sick);
            showdata.bp.setText(bp);
            showdata.bt.setText(bt);
            showdata.w.setText(h);
            showdata.h.setText(w);
            showdata.dd.setText(dd);
            showdata.pat_ID.setText(id);

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_pending_tblMouseClicked

    private void all_tblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all_tblMouseEntered
        //tblpatients();
    }//GEN-LAST:event_all_tblMouseEntered

    private void today_tblAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_today_tblAncestorAdded
      //  waitingPatient();
    }//GEN-LAST:event_today_tblAncestorAdded

    private void today_tblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_today_tblMouseEntered
       // tblSchedule();
    }//GEN-LAST:event_today_tblMouseEntered

    private void Filter_schedulePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_Filter_schedulePopupMenuWillBecomeInvisible

    }//GEN-LAST:event_Filter_schedulePopupMenuWillBecomeInvisible

    private void Filter_scheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Filter_scheduleActionPerformed
        ((JLabel) Filter_schedule.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        Object obj = evt.getSource();
        {
            if (obj == Filter_schedule) {

                try {
                    String q = "select Patient_ID as ID,name as 'Patient name',patient_illness as 'Illness',age as 'Age',gender as 'Gender',patContact as 'Contact no', mode_of_payment as 'Payment',"
                            + "doctor_name as 'Doctor',specialization as 'Specialization',appontment_registered as 'Registered date',status 'Status'\n"
                            + "   from Core1_opd_consultlist where consult_day = DATENAME(weekday, GETDATE()) and "
                            + "cast (appontment_registered as date) =    convert (nvarchar,GETDATE(),101) and doctor_name = '" + Filter_schedule.getSelectedItem() + "'";

                    pst = con.prepareStatement(q);
                    rs = pst.executeQuery();
                    today_tbl.setModel(DbUtils.resultSetToTableModel(rs));
                    today_tbl.getColumnModel().getColumn(0).setPreferredWidth(10);
                    today_tbl.getColumnModel().getColumn(1).setPreferredWidth(80);
                    today_tbl.getColumnModel().getColumn(2).setPreferredWidth(15);
                    today_tbl.getColumnModel().getColumn(3).setPreferredWidth(10);
                    today_tbl.getColumnModel().getColumn(4).setPreferredWidth(15);
                    today_tbl.getColumnModel().getColumn(6).setPreferredWidth(20);

                } catch (Exception e) {
                    System.out.println(e);
                }
                try {
                    String q = "select Patient_ID as ID,name as 'Patient name',patient_illness as 'Illness',age as 'Age',gender as 'Gender',address as 'Location', mode_of_payment as 'Payment',"
                            + "doctor_name as 'Doctor',specialization as 'Specialization',appontment_registered as 'Registered date',status 'Status'\n"
                            + "   from Core1_opd_consultlist  where doctor_name = '" + Filter_schedule.getSelectedItem() + "' ";
                    //String q = "select * from Core1_opd_consultlist where doctor_name='" + Filter_schedule + "' ";

                    pst = con.prepareStatement(q);
                    rs = pst.executeQuery();
                    all_tbl.setModel(DbUtils.resultSetToTableModel(rs));
                    all_tbl.getColumnModel().getColumn(0).setPreferredWidth(10);
                    all_tbl.getColumnModel().getColumn(1).setPreferredWidth(80);
                    all_tbl.getColumnModel().getColumn(2).setPreferredWidth(15);
                    all_tbl.getColumnModel().getColumn(3).setPreferredWidth(10);
                    all_tbl.getColumnModel().getColumn(4).setPreferredWidth(15);
                    all_tbl.getColumnModel().getColumn(6).setPreferredWidth(20);

                } catch (Exception e) {
                    System.out.println(e);
                }
                try {
                    String q = "select Patient_ID as ID, name as Patient,age as Age,gender as Gender,patContact as 'Contact no',\n"
                            + "patient_illness as illnes,doctor_name as  Doctor,specialization as Specialization ,\n"
                            + "bp as 'Blood presure',temp as 'Body temperature',height as  Height,weight as Weight,dateTime as 'As of'\n"
                            + " from Core1_opd_consultwaiting where status = 'Pending consultation' and \n"
                            + "                    cast (dateTime as date) =    convert (nvarchar,GETDATE(),101) and doctor_name = '" + Filter_schedule.getSelectedItem() + "' ";
                    //String q = "select * from Core1_opd_consultlist where doctor_name='" + Filter_schedule + "' ";

                    pst = con.prepareStatement(q);
                    rs = pst.executeQuery();
                    pending_tbl.setModel(DbUtils.resultSetToTableModel(rs));
                    pending_tbl.setModel(DbUtils.resultSetToTableModel(rs));
                    pending_tbl.getColumnModel().getColumn(0).setPreferredWidth(10);
                    pending_tbl.getColumnModel().getColumn(1).setPreferredWidth(80);
                    pending_tbl.getColumnModel().getColumn(2).setPreferredWidth(15);
                    pending_tbl.getColumnModel().getColumn(3).setPreferredWidth(10);
                    pending_tbl.getColumnModel().getColumn(4).setPreferredWidth(15);
                    pending_tbl.getColumnModel().getColumn(6).setPreferredWidth(20);
                } catch (Exception e) {
                    System.out.println(e);
                }
                try {

                    String q = "Select (Max_patient_today) as 'stat' FROM Core1_dra_publish where name='" + Filter_schedule.getSelectedItem() + "' ";

                    pst = con.prepareStatement(q);
                    rs = pst.executeQuery();
                    if (rs.next()) {

                        String stat = rs.getString("stat");
                        total_slot.setText(stat);
                    }
                } catch (Exception e) {
                    System.out.println(e);

                }
                try {

                    String q = "Select Count(status) as 'stat' FROM Core1_opd_consultlist where doctor_name='" + Filter_schedule.getSelectedItem() + "' "
                            + "and  cast (appontment_registered as date) =    convert (nvarchar,GETDATE(),101)";
                    pst = con.prepareStatement(q);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String total = rs.getString("stat");
                        total_apoint.setText(total);
                    }
                } catch (Exception e) {
                    System.out.println(e);

                }

                try {

                    String q = "Select Count(Status) as 'stat' FROM Core1_opd_consultlist where doctor_name='" + Filter_schedule.getSelectedItem() + "'\n"
                            + "and status='No vital signs yet' or status='Pending consultation' and  cast (appontment_registered as date) =    convert (nvarchar,GETDATE(),101)";

                    pst = con.prepareStatement(q);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String sum = rs.getString("stat");
                        total_wait.setText(sum);
                    }
                } catch (Exception e) {
                    System.out.println(e);

                }
                try {

                    String q = "Select Count(Status) as 'stat' FROM Core1_opd_consultlist where doctor_name='" + Filter_schedule.getSelectedItem() + "' and status='Done consultation' "
                            + "and  cast (appontment_registered as date) =    convert (nvarchar,GETDATE(),101)";

                    pst = con.prepareStatement(q);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String sum = rs.getString("stat");
                        total_done.setText(sum);
                    }
                } catch (Exception e) {
                    System.out.println(e);

                }
                try {

                    String q = "Select Count(mode_of_payment) as 'stat' FROM Core1_opd_consultlist where doctor_name='" + Filter_schedule.getSelectedItem() + "' and mode_of_payment ='CASH' "
                            + "and  cast (appontment_registered as date) =    convert (nvarchar,GETDATE(),101)";

                    pst = con.prepareStatement(q);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String sum = rs.getString("stat");
                        total_cash.setText(sum);
                    }
                } catch (Exception e) {
                    System.out.println(e);

                }
                try {

                    String q = "Select Count(mode_of_payment) as 'stat' FROM Core1_opd_consultlist where doctor_name='" + Filter_schedule.getSelectedItem() + "' and mode_of_payment ='HMO' "
                            + "and  cast (appontment_registered as date) =    convert (nvarchar,GETDATE(),101)";

                    pst = con.prepareStatement(q);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String sum = rs.getString("stat");
                        total_hmo.setText(sum);
                    }
                } catch (Exception e) {
                    System.out.println(e);

                }
                try {

                    String q = "Select Count(patient_type) as 'stat' FROM Core1_opd_consultlist where doctor_name='" + Filter_schedule.getSelectedItem() + "' and patient_type ='NEW' "
                            + "and  cast (appontment_registered as date) =    convert (nvarchar,GETDATE(),101)";

                    pst = con.prepareStatement(q);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String sum = rs.getString("stat");
                        total_old.setText(sum);
                    }
                } catch (Exception e) {
                    System.out.println(e);

                }
                try {

                    String q = "Select Count(patient_type) as 'stat' FROM Core1_opd_consultlist where doctor_name='" + Filter_schedule.getSelectedItem() + "' and patient_type ='OLD' "
                            + "and  cast (appontment_registered as date) =    convert (nvarchar,GETDATE(),101)";

                    pst = con.prepareStatement(q);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String sum = rs.getString("stat");
                        total_old.setText(sum);
                    }
                } catch (Exception e) {
                    System.out.println(e);

                }

            } else {

            }

        }
    }//GEN-LAST:event_Filter_scheduleActionPerformed

    private void fillAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillAllActionPerformed
        vitalSigns vital = new vitalSigns();
        vital.setVisible(true);
    }//GEN-LAST:event_fillAllActionPerformed
    public void lblColor(JLabel lbl) {
        lbl.setBackground(new Color(0, 85, 94));
    }

    public void rstColor(JLabel lbl) {
        lbl.setBackground(new Color(0, 124, 134));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AllPatient;
    private javax.swing.JPanel ConsultationPending;
    private rojerusan.RSComboMetro Filter_schedule;
    private javax.swing.JPanel Search;
    private javax.swing.JPanel Search1;
    private javax.swing.JPanel Today_Patients;
    private javax.swing.JLabel Totaall;
    private javax.swing.JTextField Totalallpatient;
    public static rojerusan.RSTableMetro all_tbl;
    private rojerusan.RSMaterialButtonRound fillAll;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    public static rojerusan.RSTableMetro pending_tbl;
    private javax.swing.JPanel root;
    public static javax.swing.JScrollPane scrollPatient;
    public static javax.swing.JScrollPane scrollPatient1;
    public static javax.swing.JScrollPane scrollPatient2;
    private javax.swing.JPanel tab2;
    public static rojerusan.RSTableMetro today_tbl;
    private javax.swing.JLabel totalToday;
    private javax.swing.JTextField total_apoint;
    private javax.swing.JTextField total_apoint1;
    private javax.swing.JTextField total_cash;
    private javax.swing.JTextField total_done;
    private javax.swing.JTextField total_hmo;
    private javax.swing.JTextField total_new;
    private javax.swing.JTextField total_old;
    private javax.swing.JTextField total_patient;
    private javax.swing.JTextField total_slot;
    private javax.swing.JTextField total_wait;
    // End of variables declaration//GEN-END:variables
}
