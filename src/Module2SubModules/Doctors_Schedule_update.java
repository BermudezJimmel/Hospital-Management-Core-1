/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module2SubModules;

import SystemInstance.HintTextFeild;
import SystemInstance.MysqlConnect;
import java.awt.Color;
import java.awt.HeadlessException;
import static java.lang.Thread.sleep;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author iRHONman
 */
public class Doctors_Schedule_update extends javax.swing.JFrame
{

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    CallableStatement cst = null;
    DefaultTableModel mode;
    String Gender;

    public Doctors_Schedule_update()
    {
        initComponents();
        con = MysqlConnect.ConnectDB();
        Update_dr_tbl();
        clocks();
        Hint();

    }
    // This  method is going to auto refresh table

    public void clocks()
    {

        Thread clock;
        clock = new Thread()
        {

            @Override
            public void run()
            {
                try
                {
                    for (;;)
                    {
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
                        if (am_pm == 1)
                        {
                            day_night = "PM";
                        } else
                        {
                            day_night = "AM";
                        }
                        String weekday = "";
                        if (hour == 0)
                        {
                            hour = 12;
                        }

                        switch (week)
                        {
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
                        if (day == 1)
                        {
                            day1 = "0" + day;
                        } else if (day == 1)
                        {
                            day1 = "0" + day;
                        } else if (day == 2)
                        {
                            day1 = "0" + day;
                        } else if (day == 3)
                        {
                            day1 = "0" + day;
                        } else if (day == 4)
                        {
                            day1 = "0" + day;
                        } else if (day == 5)
                        {
                            day1 = "0" + day;
                        } else if (day == 6)
                        {
                            day1 = "0" + day;
                        } else if (day == 7)
                        {
                            day1 = "0" + day;
                        } else if (day == 8)
                        {
                            day1 = "0" + day;
                        } else if (day == 9)
                        {
                            day1 = "0" + day;
                        } else
                        {
                            day1 = "" + day;
                        }

                        String M = "";
                        switch (month)
                        {
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
                        switch (second)
                        {
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
                        switch (minute)
                        {
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
                        sleep(1000);
                    }
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        };

        clock.start();

    }

    public void theQueryLogin(String query)
    {

        java.sql.Statement st;
        try
        {
            st = con.createStatement();
            st.executeUpdate(query);
            // JOptionPane.showMessageDialog(null, "You listed");

        } catch (SQLException | HeadlessException ee)
        {
            JOptionPane.showMessageDialog(null, ee.getMessage());;
        }

    }

    private void Update_dr_tbl()
    {

        tbl_dr.setSelectionBackground(Color.red);

        try
        {
            String sql = "select Schedule_ID ,Dr_ID,surname,gender,specialization,consult_day,consult_time_from,consult_time_to  from Core1_dra_schedule where status='Scheduled'";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            tbl_dr.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void Hint()
    {
        txt_search_dr.setUI(new HintTextFeild(" Search by SURNAME ", true));
    }

    private void remove()
    {
        while (tbl_dr.getRowCount() > 0)
        {
            mode.removeRow(0);

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

        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
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
        CB_Initial_Minute2 = new javax.swing.JComboBox<>();
        CB_Initial_Day2 = new javax.swing.JComboBox<>();
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
        jLabel7 = new javax.swing.JLabel();
        txt_S_ID1 = new javax.swing.JTextField();
        Search = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_search_dr = new javax.swing.JTextField();
        jExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_dr = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Doctors schedule");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(596, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Update schedule");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 530, 150, 30));

        bg_panel.setBackground(new java.awt.Color(240, 240, 240));
        bg_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Consultation schedule", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        bg_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        CB_Initial_Hour1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel191.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel191.setText("To");

        CB_Initial_Hour2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel239.setText(":");

        CB_Initial_Minute2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "10", "15", "20", "25", "30", "35", "40", "45", "50", " " }));
        CB_Initial_Minute2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_Initial_Minute2ActionPerformed(evt);
            }
        });

        CB_Initial_Day2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PM", "AM" }));
        CB_Initial_Day2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_Initial_Day2ActionPerformed(evt);
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
                                .addComponent(CB_Initial_Minute2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel240, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(CB_Initial_Day2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(CB_Initial_Minute2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel240, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CB_Initial_Day2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        bg_panel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 300, 150));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Doctor Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Doctors ID:");

        jLabel162.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel162.setText("Gender:");

        jLabel33.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel33.setText("Name:");

        jLabel42.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel42.setText("Specialization:");

        txt_ID.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_ID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ID.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_ID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_ID.setEnabled(false);

        txt_name.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_name.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_name.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_name.setEnabled(false);

        txt_gen.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_gen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_gen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_gen.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_gen.setEnabled(false);

        txt_specia.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_specia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_specia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_specia.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_specia.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Schedule ID:");

        txt_S_ID1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_S_ID1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_S_ID1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_S_ID1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_S_ID1.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_specia, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel33)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_S_ID1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 26, Short.MAX_VALUE))))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel162)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_gen, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_S_ID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel162)
                    .addComponent(txt_gen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(txt_specia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        bg_panel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 300, 180));

        Search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Search Doctors : ");

        txt_search_dr.setPreferredSize(new java.awt.Dimension(200, 25));
        txt_search_dr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_search_drKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout SearchLayout = new javax.swing.GroupLayout(Search);
        Search.setLayout(SearchLayout);
        SearchLayout.setHorizontalGroup(
            SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_search_dr, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        SearchLayout.setVerticalGroup(
            SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_search_dr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bg_panel.add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 20, 270, -1));

        jPanel1.add(bg_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 670, 240));

        jExit.setBackground(new java.awt.Color(0, 102, 102));
        jExit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jExit.setText("Exit");
        jExit.setPreferredSize(new java.awt.Dimension(83, 25));
        jExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExitActionPerformed(evt);
            }
        });
        jPanel1.add(jExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 530, 130, 30));

        tbl_dr.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbl_dr.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbl_dr.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_dr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_drMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_dr);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 670, 140));

        jPanel4.setBackground(new java.awt.Color(240, 240, 240));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Request update schedule");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(479, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 670, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(730, 576));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_jExitActionPerformed

    private void tbl_drMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_drMouseClicked
        // Update schedule       
        try
        {
            int row = tbl_dr.getSelectedRow();
            String table_update = (tbl_dr.getModel().getValueAt(row, 0).toString());
            String sql = "select * from Core1_dra_schedule where Schedule_ID='" + table_update + "'";

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next())
            {
                //Display data for update  
                String add0 = rs.getString("Schedule_ID");
                txt_S_ID1.setText(add0);
                String add1 = rs.getString("Dr_ID");
                txt_ID.setText(add1);
                String add2 = rs.getString("surname");
                txt_name.setText(add2);
                String add3 = rs.getString("gender");
                txt_gen.setText(add3);
                String add4 = rs.getString("specialization");
                txt_specia.setText(add4);
            }

        } catch (Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_tbl_drMouseClicked

    private void txt_search_drKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_search_drKeyReleased
        // Search doctors by name
        String sb = txt_search_dr.getText().trim() + "%";
        try
        {
            String searchbed = "select * from Core1_dra_schedule where surname like '" + sb + "'";

            pst = con.prepareStatement(searchbed);
            rs = pst.executeQuery();
            tbl_dr.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e)
        {
        }

    }//GEN-LAST:event_txt_search_drKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        try
        {
            String query2 = "update Core1_dra_schedule set consult_day = '" + CB_Day.getSelectedItem() + "', consult_time_from = '" + CB_Initial_Hour1.getSelectedItem() + ":" + CB_Initial_Minute.getSelectedItem()   + CB_Initial_Day.getSelectedItem() + "',"
            + "consult_time_to = '" + CB_Initial_Hour2.getSelectedItem() + ":" + CB_Initial_Minute2.getSelectedItem()  + CB_Initial_Day2.getSelectedItem() + "'"
            + " where Dr_ID='" + txt_ID.getText() + "' ";

            java.sql.Statement st = null;
            st = con.createStatement();
            st.executeUpdate(query2);

        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            //"Not Saved!, please check your remaining filled"
        }
        JOptionPane.showMessageDialog(null, "Doctor Successfully update schedule");
        txt_S_ID1.setText("");
        txt_ID.setText("");
        txt_name.setText("");
        txt_gen.setText("");
        txt_specia.setText("");
        Update_dr_tbl();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CB_Initial_Day2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_Initial_Day2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_Initial_Day2ActionPerformed

    private void CB_Initial_Minute2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_Initial_Minute2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_Initial_Minute2ActionPerformed

    private void CB_Initial_DayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_Initial_DayActionPerformed
        boolean ID = CB_Initial_Day.getSelectedItem().equals("PM");

        /*  if(ID==ID){
            CB_Exam_Day.setSelectedItem("PM");
            CB_Final_Day.setSelectedItem("PM");
        }*/
    }//GEN-LAST:event_CB_Initial_DayActionPerformed

    private void CB_Initial_MinuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_Initial_MinuteActionPerformed
        if (CB_Initial_Minute.getSelectedItem().equals(" "))
        {
            CB_Initial_Minute.setEditable(true);

        } else
        {
            CB_Initial_Minute.setEditable(false);

        }
    }//GEN-LAST:event_CB_Initial_MinuteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Doctors_Schedule_update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Doctors_Schedule_update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Doctors_Schedule_update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Doctors_Schedule_update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Doctors_Schedule_update().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_Day;
    private javax.swing.JComboBox<String> CB_Initial_Day;
    private javax.swing.JComboBox<String> CB_Initial_Day2;
    private javax.swing.JComboBox<String> CB_Initial_Hour1;
    private javax.swing.JComboBox<String> CB_Initial_Hour2;
    private javax.swing.JComboBox<String> CB_Initial_Minute;
    private javax.swing.JComboBox<String> CB_Initial_Minute2;
    private javax.swing.JPanel Search;
    private javax.swing.JPanel bg_panel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jExit;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel237;
    private javax.swing.JLabel jLabel238;
    private javax.swing.JLabel jLabel239;
    private javax.swing.JLabel jLabel240;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_dr;
    public static javax.swing.JTextField txt_ID;
    public static javax.swing.JTextField txt_S_ID1;
    public static javax.swing.JTextField txt_gen;
    public static javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_search_dr;
    public static javax.swing.JTextField txt_specia;
    // End of variables declaration//GEN-END:variables
}
