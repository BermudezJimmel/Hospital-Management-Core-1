/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module1SubModules;

import SystemInstance.MysqlConnect;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import static java.lang.Thread.sleep;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import net.proteanit.sql.DbUtils;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author jerome
 */
public final class PatientInformation extends javax.swing.JPanel {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    CallableStatement cst = null;
    DefaultTableModel mode;

    public PatientInformation() {
        initComponents();
        this.cbFilter.setCursor(new Cursor(12));
        con = MysqlConnect.ConnectDB();
        tblUpcoming();
        tblCurrent();
        select_pat();
        tblconsultDone();
        tbllabDone();
        Motion();
        clock();

        AutoCompleteDecorator.decorate(cbFilter);

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
                        tblUpcoming();
                        tblCurrent();
                        tbllabDone();
                        tblconsultDone();
                        sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        clock.start();

    }

    public void Motion() {

        Thread clock;
        clock = new Thread() {

            @Override
            public void run() {
                try {

                    for (;;) {
                        Color F = noMED.getForeground();
                        if (F.equals(Color.BLACK)) {
                            noMED.setText("Review information of " + jTextField3.getText());
                            noMED.setForeground(Color.WHITE);
                        } else {
                            noMED.setText("Review information of " + jTextField3.getText());
                            noMED.setForeground(Color.BLACK);
                        }
                        sleep(900);
                        if (tbl_view1.getRowCount() == 0) {
                            noMED2.setVisible(true);

                            noMED2.setText("NO MEDICAL HISTORY");
                        } else {
                            noMED2.setVisible(false);
                            noMED2.setText("");

                        }
                        sleep(900);
                        if (tbl_view.getRowCount() == 0) {
                            noMED3.setVisible(true);

                            noMED3.setText("JP ANU NA! ANU NA!?!");
                        } else {

                            noMED3.setVisible(false);
                            noMED3.setText("");
                        }
                        sleep(900);
                        if (tbl_view3.getRowCount() == 0) {
                            noMED4.setVisible(true);

                            noMED4.setText("NO UPCOMING CONSULTATION");
                        } else {

                            noMED4.setVisible(false);
                            noMED4.setText("");
                        }
                        sleep(900);
                        if (tbl_view2.getRowCount() == 0) {
                            noMED5.setVisible(true);

                            noMED5.setText("NO CONSULTATION TODAY");
                        } else {

                            noMED5.setVisible(false);
                            noMED5.setText("");
                        }
                    }
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        };
        clock.start();

    }

    private void select_pat() {
        try {
            String sql = "select Patient_ID from Core1_pr_PatientRegistration";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                cbFilter.addItem(rs.getString("Patient_ID"));
            }

        } catch (Exception e) {
        }
    }

    public void tbllabDone() {

        try {
            String q = "select  date_req as 'Laboratory date',status\n"
                    + " from Core2_labmngt_labreqDUMMY where pat_name ='" + jTextField2.getText() + "'";

            pst = con.prepareStatement(q);

            rs = pst.executeQuery();
            tbl_view.setModel(DbUtils.resultSetToTableModel(rs));
            /*  tbl_view1.getColumnModel().getColumn(1).setPreferredWidth(20);
            tbl_view1.getColumnModel().getColumn(2).setPreferredWidth(15);
            tbl_view1.getColumnModel().getColumn(3).setPreferredWidth(15);
            tbl_view1.getColumnModel().getColumn(5).setPreferredWidth(15);
            tbl_view1.getColumnModel().getColumn(6).setPreferredWidth(20);*/

        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public void tblconsultDone() {

        try {
            String q = "select  date_diagnose as 'Diagnose date',status as Status\n"
                    + " from Core1_opd_consultationProgress where name ='" + concatName.getText() + "'";

            pst = con.prepareStatement(q);

            rs = pst.executeQuery();
            tbl_view1.setModel(DbUtils.resultSetToTableModel(rs));
            /*  tbl_view1.getColumnModel().getColumn(1).setPreferredWidth(20);
            tbl_view1.getColumnModel().getColumn(2).setPreferredWidth(15);
            tbl_view1.getColumnModel().getColumn(3).setPreferredWidth(15);
            tbl_view1.getColumnModel().getColumn(5).setPreferredWidth(15);
            tbl_view1.getColumnModel().getColumn(6).setPreferredWidth(20);*/

        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public void tblUpcoming() {

        try {
            String q = "select  date_nxt_visit as 'Next visit',remarks as Remarks,patient_type as Department\n"
                    + " from Core1_PR_Overview where name ='" + concatName.getText() + "' and remarks = 'Upcoming'";

            pst = con.prepareStatement(q);

            rs = pst.executeQuery();
            tbl_view3.setModel(DbUtils.resultSetToTableModel(rs));
            /*  tbl_view1.getColumnModel().getColumn(1).setPreferredWidth(20);
            tbl_view1.getColumnModel().getColumn(2).setPreferredWidth(15);
            tbl_view1.getColumnModel().getColumn(3).setPreferredWidth(15);
            tbl_view1.getColumnModel().getColumn(5).setPreferredWidth(15);
            tbl_view1.getColumnModel().getColumn(6).setPreferredWidth(20);*/

        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public void tblCurrent() {

        try {
            String q = "select  dateTime as 'Diagnose date',status as Status\n"
                    + " from Core1_opd_consultwaiting where name ='" + concatName.getText() + "' and "
                    + "cast (dateTime as date) =    convert (nvarchar,GETDATE(),101)";

            pst = con.prepareStatement(q);

            rs = pst.executeQuery();
            tbl_view2.setModel(DbUtils.resultSetToTableModel(rs));
            /*  tbl_view1.getColumnModel().getColumn(1).setPreferredWidth(20);
            tbl_view1.getColumnModel().getColumn(2).setPreferredWidth(15);
            tbl_view1.getColumnModel().getColumn(3).setPreferredWidth(15);
            tbl_view1.getColumnModel().getColumn(5).setPreferredWidth(15);
            tbl_view1.getColumnModel().getColumn(6).setPreferredWidth(20);*/

        } catch (Exception e) {
            System.out.println(e);

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        root = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cbFilter = new rojerusan.RSComboMetro();
        jPanel2 = new javax.swing.JPanel();
        concatName = new javax.swing.JTextField();
        patID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        bod2 = new javax.swing.JLabel();
        age = new javax.swing.JLabel();
        age1 = new javax.swing.JLabel();
        DG = new javax.swing.JLayeredPane();
        jLabel14 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        noMED5 = new javax.swing.JLabel();
        noMED4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_view2 = new javax.swing.JTable()
        {
            @Override

            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex)
            {
                Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);

                Object value = getModel().getValueAt(rowIndex,columnIndex);

                if(columnIndex == 1)
                {

                    if(value.equals("Done Consultation"))
                    {

                        componenet.setBackground(Color.GREEN);
                        componenet.setForeground(Color.BLACK);

                    }
                    if(value.equals("Pending Consultation"))
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
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_view3 = new javax.swing.JTable()
        {
            @Override

            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex)
            {
                Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);

                Object value = getModel().getValueAt(rowIndex,columnIndex);

                if(columnIndex == 2)
                {

                    if(value.equals("Outpatient"))
                    {

                        componenet.setBackground(Color.GREEN);
                        componenet.setForeground(Color.BLACK);

                    }
                    if(value.equals("Inpatient"))
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
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        patTransac = new javax.swing.JPanel();
        noMED3 = new javax.swing.JLabel();
        noMED2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_view = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_view1 = new javax.swing.JTable()
        {
            @Override

            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex)
            {
                Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);

                Object value = getModel().getValueAt(rowIndex,columnIndex);

                if(columnIndex == 1)
                {

                    if(value.equals("Done consultation"))
                    {

                        componenet.setBackground(Color.GREEN);
                        componenet.setForeground(Color.BLACK);

                    }
                    if(value.equals("Pending Consultation"))
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
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        noMED = new javax.swing.JLabel();
        gndr = new javax.swing.JLabel();
        viewLab = new rojerusan.RSMaterialButtonRound();
        viewMed = new rojerusan.RSMaterialButtonRound();

        root.setBackground(new java.awt.Color(255, 255, 255));
        root.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Search Patient:");

        cbFilter.setEditable(true);
        cbFilter.setMaximumRowCount(4);
        cbFilter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Click here" }));
        cbFilter.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        cbFilter.setPreferredSize(new java.awt.Dimension(188, 30));
        cbFilter.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbFilterPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(834, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        root.add(jPanel1);
        jPanel1.setBounds(0, 0, 1166, 50);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        root.add(jPanel2);
        jPanel2.setBounds(60, 110, 130, 110);

        concatName.setEditable(false);
        concatName.setBackground(new java.awt.Color(255, 255, 255));
        concatName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        concatName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        root.add(concatName);
        concatName.setBounds(20, 240, 200, 30);

        patID.setEditable(false);
        patID.setBackground(new java.awt.Color(255, 255, 255));
        patID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        root.add(patID);
        patID.setBounds(80, 280, 30, 20);

        jLabel3.setText("Patient ID");
        root.add(jLabel3);
        jLabel3.setBounds(20, 280, 70, 20);

        bod2.setText("-");
        root.add(bod2);
        bod2.setBounds(20, 310, 80, 20);

        age.setText("-");
        root.add(age);
        age.setBounds(110, 310, 60, 20);

        age1.setText("years old");
        root.add(age1);
        age1.setBounds(140, 310, 60, 20);

        DG.setBackground(new java.awt.Color(240, 240, 240));
        DG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setText("Mobile:");

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setText("Address:");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Firsname:");

        jLabel11.setText("Lastname:");

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(255, 255, 255));

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel9.setBackground(new java.awt.Color(51, 102, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Demographics");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(204, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        DG.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DG.setLayer(jTextField4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DG.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DG.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DG.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DG.setLayer(jTextField3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DG.setLayer(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DG.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DG.setLayer(jPanel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DGLayout = new javax.swing.GroupLayout(DG);
        DG.setLayout(DGLayout);
        DGLayout.setHorizontalGroup(
            DGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DGLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(DGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DGLayout.createSequentialGroup()
                        .addGroup(DGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DGLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DGLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(DGLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(DGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DGLayout.setVerticalGroup(
            DGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DGLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(DGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(DGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DGLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 52, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(DGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
            .addGroup(DGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DGLayout.createSequentialGroup()
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 166, Short.MAX_VALUE)))
        );

        root.add(DG);
        DG.setBounds(230, 120, 300, 210);

        jPanel3.setBackground(new java.awt.Color(240, 240, 240));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        root.add(jPanel3);
        jPanel3.setBounds(230, 390, 300, 170);

        jPanel4.setBackground(new java.awt.Color(240, 240, 240));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        noMED5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        noMED5.setForeground(new java.awt.Color(255, 0, 51));
        noMED5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(noMED5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 260, 60));

        noMED4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        noMED4.setForeground(new java.awt.Color(255, 0, 51));
        noMED4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(noMED4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 260, 60));

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane5.setBorder(null);
        jScrollPane5.setOpaque(false);

        tbl_view2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbl_view2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tbl_view2.setForeground(new java.awt.Color(51, 51, 51));
        tbl_view2.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_view2.setToolTipText("Select one of history to view the medical records of patient");
        tbl_view2.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_view2.setOpaque(false);
        tbl_view2.setRowHeight(20);
        tbl_view2.setSelectionBackground(new java.awt.Color(0, 171, 82));
        tbl_view2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbl_view2AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tbl_view2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_view2MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_view2);

        jPanel4.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 300, 80));

        jSeparator2.setBackground(new java.awt.Color(51, 102, 255));
        jSeparator2.setForeground(new java.awt.Color(0, 102, 102));
        jSeparator2.setOpaque(true);
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 300, 10));

        jScrollPane6.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane6.setBorder(null);
        jScrollPane6.setOpaque(false);

        tbl_view3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbl_view3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tbl_view3.setForeground(new java.awt.Color(51, 51, 51));
        tbl_view3.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_view3.setToolTipText("Select one of history to view the medical records of patient");
        tbl_view3.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_view3.setOpaque(false);
        tbl_view3.setRowHeight(20);
        tbl_view3.setSelectionBackground(new java.awt.Color(0, 171, 82));
        tbl_view3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbl_view3AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tbl_view3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_view3MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_view3);

        jPanel4.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 80));

        root.add(jPanel4);
        jPanel4.setBounds(850, 160, 300, 170);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        root.add(jPanel5);
        jPanel5.setBounds(540, 390, 300, 170);

        jPanel6.setBackground(new java.awt.Color(240, 240, 240));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        root.add(jPanel6);
        jPanel6.setBounds(850, 390, 300, 170);

        jPanel14.setBackground(new java.awt.Color(51, 102, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setText("-");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        root.add(jPanel14);
        jPanel14.setBounds(850, 350, 300, 40);

        jPanel13.setBackground(new java.awt.Color(51, 102, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setText("-");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        root.add(jPanel13);
        jPanel13.setBounds(540, 350, 300, 40);

        jPanel12.setBackground(new java.awt.Color(51, 102, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Allergies");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        root.add(jPanel12);
        jPanel12.setBounds(230, 350, 300, 40);

        jPanel11.setBackground(new java.awt.Color(51, 102, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Upcoming & Current Appointment");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        root.add(jPanel11);
        jPanel11.setBounds(850, 120, 300, 40);

        patTransac.setBackground(new java.awt.Color(240, 240, 240));
        patTransac.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        noMED3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        noMED3.setForeground(new java.awt.Color(255, 0, 51));
        noMED3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patTransac.add(noMED3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 260, 60));

        noMED2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        noMED2.setForeground(new java.awt.Color(255, 0, 51));
        noMED2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patTransac.add(noMED2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 260, 60));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(null);
        jScrollPane3.setOpaque(false);

        tbl_view.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbl_view.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tbl_view.setForeground(new java.awt.Color(51, 51, 51));
        tbl_view.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_view.setToolTipText("Select one of history to view the medical records of patient");
        tbl_view.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_view.setOpaque(false);
        tbl_view.setRowHeight(20);
        tbl_view.setSelectionBackground(new java.awt.Color(0, 171, 82));
        tbl_view.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbl_viewAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tbl_view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_viewMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_view);

        patTransac.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 300, 80));

        jSeparator1.setBackground(new java.awt.Color(51, 102, 255));
        jSeparator1.setForeground(new java.awt.Color(0, 102, 102));
        jSeparator1.setOpaque(true);
        patTransac.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 120, 300, 10));

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setBorder(null);
        jScrollPane4.setOpaque(false);

        tbl_view1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbl_view1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tbl_view1.setForeground(new java.awt.Color(51, 51, 51));
        tbl_view1.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_view1.setToolTipText("Select one of history to view the medical records of patient");
        tbl_view1.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_view1.setOpaque(false);
        tbl_view1.setRowHeight(20);
        tbl_view1.setSelectionBackground(new java.awt.Color(0, 171, 82));
        tbl_view1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbl_view1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tbl_view1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_view1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_view1);

        patTransac.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 300, 80));

        jPanel10.setBackground(new java.awt.Color(51, 102, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Patient transaction");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        patTransac.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 300, -1));

        root.add(patTransac);
        patTransac.setBounds(540, 120, 300, 210);

        noMED.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        noMED.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        root.add(noMED);
        noMED.setBounds(400, 70, 600, 40);

        gndr.setText("-");
        root.add(gndr);
        gndr.setBounds(120, 280, 60, 20);

        viewLab.setText("View lab");
        viewLab.setToolTipText("");
        viewLab.setFont(new java.awt.Font("Roboto Medium", 1, 9)); // NOI18N
        viewLab.setMaximumSize(new java.awt.Dimension(82, 26));
        viewLab.setMinimumSize(new java.awt.Dimension(82, 26));
        viewLab.setPreferredSize(new java.awt.Dimension(88, 28));
        viewLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewLabActionPerformed(evt);
            }
        });
        root.add(viewLab);
        viewLab.setBounds(700, 330, 100, 20);

        viewMed.setText("View medical");
        viewMed.setFont(new java.awt.Font("Roboto Medium", 1, 9)); // NOI18N
        viewMed.setMaximumSize(new java.awt.Dimension(82, 26));
        viewMed.setMinimumSize(new java.awt.Dimension(82, 26));
        viewMed.setPreferredSize(new java.awt.Dimension(88, 28));
        viewMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewMedActionPerformed(evt);
            }
        });
        root.add(viewMed);
        viewMed.setBounds(570, 330, 100, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(root, javax.swing.GroupLayout.PREFERRED_SIZE, 1166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(root, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_viewAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_viewAncestorAdded

    }//GEN-LAST:event_tbl_viewAncestorAdded

    private void tbl_viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_viewMouseClicked
        boolean a = tbl_view.isEditing();

        if (a == false) {
            JOptionPane.showMessageDialog(null, "You can not edit this table");
        }

        try {
            int i = tbl_view.getSelectedRow();

            /*   TableModel model = tbl_view.getModel();

            String fn = model.getValueAt(i, 0).toString();
            String dr = model.getValueAt(i, 1).toString();
            String sp = model.getValueAt(i, 2).toString();
            String bp = model.getValueAt(i, 3).toString();
            String bt = model.getValueAt(i, 4).toString();
            String h = model.getValueAt(i, 5).toString();
            String w = model.getValueAt(i, 6).toString();
            String dd = model.getValueAt(i, 7).toString();
            String sick = model.getValueAt(i, 8).toString();
            String sick_desc = model.getValueAt(i, 9).toString();
            String sick_date = model.getValueAt(i, 10).toString();
            String diagnose = model.getValueAt(i, 11).toString();
            String diagnose_desc = model.getValueAt(i, 12).toString();
            String diagnose_date = model.getValueAt(i, 13).toString();
            String medicine = model.getValueAt(i, 14).toString();
            String dosage = model.getValueAt(i, 15).toString();
            String tablet = model.getValueAt(i, 16).toString();
            String take_medicine = model.getValueAt(i, 17).toString();
            String take_for = model.getValueAt(i, 18).toString();
            String medicine_desc = model.getValueAt(i, 19).toString();

            showdata.setVisible(true);
            showdata.pack();
            showdata.setLocationRelativeTo(null);
            showdata.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            showdata.find_patName.setText(fn);

            showdata.find_patDr.setText(dr);
            showdata.find_drSpecia.setText(sp);
            showdata.find_patSick.setText(sick);
            showdata.bp.setText(bp);
            showdata.bt.setText(bt);
            showdata.w.setText(h);
            showdata.h.setText(w);
            showdata.dd.setText(dd);
            showdata.find_patSick.setText(sick);
            showdata.jTextArea1.setText(sick_date);
            showdata.find_dd.setText(sick_desc);
            showdata.find_diag.setText(diagnose);
            showdata.diag_dd.setText(diagnose_date);
            showdata.jTextArea2.setText(diagnose_desc);
            showdata.medicine.setText(medicine);
            showdata.medDosage.setText(dosage);
            showdata.medType.setText(tablet);
            showdata.take.setText(take_medicine);
            showdata.find_for.setText(take_for);
            showdata.jTextArea3.setText(medicine_desc);*/
        } catch (Exception err) {
            JOptionPane.showConfirmDialog(null, err);

        }
    }//GEN-LAST:event_tbl_viewMouseClicked

    private void tbl_view1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_view1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_view1AncestorAdded

    private void tbl_view1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_view1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_view1MouseClicked

    private void cbFilterPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbFilterPopupMenuWillBecomeInvisible

        String diagnose = (String) cbFilter.getSelectedItem();
        //       String sql = "select diagnose_description,medicine,dosage,medicine_type,take,medicine_description"
        //               + "from  Core1_opd_treatmentmedicine where title = ?";

        String sql = "select FirstName+', '+LastName+' '+MiddleName as fullname ,Patient_ID,PR_Birthdate,DATEDIFF(YEAR,PR_Birthdate,convert (nvarchar,GETDATE(),101) )  as age ,\n"
                + "LastName,FirstName,address,PR_MobileNo,PR_Gender\n"
                + " from  Core1_pr_PatientRegistration where Patient_ID = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, diagnose);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("LastName");
                jTextField2.setText(add1);
                String add2 = rs.getString("FirstName");
                jTextField3.setText(add2);
                String add3 = rs.getString("address");
                jTextArea1.setText(add3);
                String add4 = rs.getString("PR_MobileNo");
                jTextField4.setText(add4);
                String add6 = rs.getString("fullname");
                concatName.setText(add6);
                String add7 = rs.getString("Patient_ID");
                patID.setText(add7);
                String add8 = rs.getString("PR_Birthdate");
                bod2.setText(add8);
                String add9 = rs.getString("age");
                age.setText(add9);
                String add10 = rs.getString("PR_Gender");
                gndr.setText(add10);
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, err);
        }
    }//GEN-LAST:event_cbFilterPopupMenuWillBecomeInvisible

    private void viewMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewMedActionPerformed
        medHistory med = new medHistory();
        medHistory.patID.setText(this.patID.getText());
        medHistory.patName.setText(this.concatName.getText());
        medHistory.age2.setText(this.age.getText());
        medHistory.gndr.setText(this.gndr.getText());
        med.setVisible(true);
    }//GEN-LAST:event_viewMedActionPerformed

    private void viewLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewLabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewLabActionPerformed

    private void tbl_view2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_view2AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_view2AncestorAdded

    private void tbl_view2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_view2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_view2MouseClicked

    private void tbl_view3AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_view3AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_view3AncestorAdded

    private void tbl_view3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_view3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_view3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane DG;
    public static javax.swing.JLabel age;
    private javax.swing.JLabel age1;
    private javax.swing.JLabel bod2;
    private rojerusan.RSComboMetro cbFilter;
    private javax.swing.JTextField concatName;
    private javax.swing.JLabel gndr;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel noMED;
    private javax.swing.JLabel noMED2;
    private javax.swing.JLabel noMED3;
    private javax.swing.JLabel noMED4;
    private javax.swing.JLabel noMED5;
    private javax.swing.JTextField patID;
    private javax.swing.JPanel patTransac;
    private javax.swing.JPanel root;
    private javax.swing.JTable tbl_view;
    private javax.swing.JTable tbl_view1;
    private javax.swing.JTable tbl_view2;
    private javax.swing.JTable tbl_view3;
    private rojerusan.RSMaterialButtonRound viewLab;
    private rojerusan.RSMaterialButtonRound viewMed;
    // End of variables declaration//GEN-END:variables
}
