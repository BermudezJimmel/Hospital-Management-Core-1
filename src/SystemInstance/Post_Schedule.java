
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemInstance;

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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author iRHONman
 */
public class Post_Schedule extends javax.swing.JFrame {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    CallableStatement cst = null;
    DefaultTableModel mode;
    String Gender;

    public Post_Schedule() {
        initComponents();
        con = MysqlConnect.ConnectDB();
        Update_dr_tbl();
        Update_dr_tbl_cancel();
        clock();
    }
    reserve_appointment showdata = new reserve_appointment();

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
                        time.setText(+hour + ":" + mn + day_night);
                        Update_dr_tbl();
                        Update_dr_tbl_cancel();
                        sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        clock.start();

    }

    private void Update_dr_tbl_cancel() {

        tbl_view.setSelectionBackground(Color.red);

        try {
            String sql = "select Name as Doctor, Specialization, Schedule, Consult_start as 'From' , Consult_end as 'Until',Status\n"
                    + "from Core1_dra_publish where Status = 'Cancelled clinic' and Schedule = DATENAME(weekday, GETDATE()) and Max_patient_today >=1 and cast (consult_date as date) =    convert (nvarchar,GETDATE(),101)";
            // Consult_end = LTRIM(RIGHT(CONVERT(VARCHAR(20), GETDATE(), 100), 7))";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            tbl_view1.setModel(DbUtils.resultSetToTableModel(rs));

            try {
                String query2 = "update Core1_dra_publish set Status = 'Off duty' where   Consult_end = LTRIM(RIGHT(CONVERT(VARCHAR(20), GETDATE(), 100), 7))";

                java.sql.Statement st = null;

                con = MysqlConnect.ConnectDB();
                st = con.createStatement();
                st.executeUpdate(query2);
            } catch (Exception e) {
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void Update_dr_tbl() {

        tbl_view.setSelectionBackground(Color.red);

        try {
            String sql = "select Name as Doctor, Specialization, Schedule, Consult_start as 'From' , Consult_end as 'Until', Max_patient_today as 'Patient slot',Status\n"
                    + "from Core1_dra_publish where Status = 'On duty' and Schedule = DATENAME(weekday, GETDATE()) and Max_patient_today >=1 and cast (consult_date as date) =    convert (nvarchar,GETDATE(),101)";
            // Consult_end = LTRIM(RIGHT(CONVERT(VARCHAR(20), GETDATE(), 100), 7))";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            tbl_view.setModel(DbUtils.resultSetToTableModel(rs));

            try {
                String query2 = "update Core1_dra_publish set Status = 'Off duty' where   Consult_end = LTRIM(RIGHT(CONVERT(VARCHAR(20), GETDATE(), 100), 7))";

                java.sql.Statement st = null;

                con = MysqlConnect.ConnectDB();
                st = con.createStatement();
                st.executeUpdate(query2);
            } catch (Exception e) {
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
        jPanel2 = new javax.swing.JPanel();
        icon_SystemLogo = new javax.swing.JLabel();
        label4 = new java.awt.Label();
        label3 = new java.awt.Label();
        Search1 = new javax.swing.JPanel();
        scrollPatient = new javax.swing.JScrollPane();
        tbl_view = new rojerusan.RSTableMetro()

        {
            @Override

            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;

            }

            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex)
            {
                Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);

                Object value = getModel().getValueAt(rowIndex,columnIndex);

                if(columnIndex == 6)
                {

                    if(value.equals("On duty"))
                    {
                        // if date  equal current date
                        componenet.setBackground(Color.GREEN);
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
        time = new javax.swing.JLabel();
        HEADER = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        scrollPatient1 = new javax.swing.JScrollPane();
        tbl_view1 = new rojerusan.RSTableMetro()
        {
            @Override

            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex)
            {
                Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);

                Object value = getModel().getValueAt(rowIndex,columnIndex);

                if(columnIndex == 5)
                {

                    if(value.equals("Cancelled clinic"))
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
        jPanel3 = new javax.swing.JPanel();
        label2 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 630));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon_SystemLogo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        icon_SystemLogo.setForeground(new java.awt.Color(102, 102, 255));
        icon_SystemLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon_SystemLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hms50x48.png"))); // NOI18N
        jPanel2.add(icon_SystemLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        label4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label4.setForeground(new java.awt.Color(255, 255, 255));
        label4.setText("CONTACT US: 8-7000");
        jPanel2.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(985, 5, 270, 20));

        label3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 255, 255));
        label3.setText("EMAIL : HMS@bsIT.com.ph");
        jPanel2.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(985, 25, 270, 20));
        label3.getAccessibleContext().setAccessibleName("");

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1280, 50);

        Search1.setBackground(new java.awt.Color(255, 255, 255));
        Search1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollPatient.setBackground(new java.awt.Color(255, 255, 255));
        scrollPatient.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192), 3));

        tbl_view.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_view.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        tbl_view.setFuenteFilas(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        tbl_view.setFuenteFilasSelect(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        tbl_view.setFuenteHead(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        tbl_view.setGrosorBordeFilas(0);
        tbl_view.setGrosorBordeHead(0);
        tbl_view.setMultipleSeleccion(false);
        tbl_view.setRowHeight(20);
        tbl_view.getTableHeader().setReorderingAllowed(false);
        tbl_view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_viewMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbl_viewMouseEntered(evt);
            }
        });
        scrollPatient.setViewportView(tbl_view);

        Search1.add(scrollPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 340));

        jPanel1.add(Search1);
        Search1.setBounds(20, 280, 1240, 340);

        time.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setText("-");
        jPanel1.add(time);
        time.setBounds(60, 590, 50, 30);

        HEADER.setBackground(new java.awt.Color(51, 102, 255));
        HEADER.setPreferredSize(new java.awt.Dimension(300, 40));
        HEADER.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("CANCELLED CLINIC");
        HEADER.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 380, 20));

        scrollPatient1.setBackground(new java.awt.Color(255, 255, 255));
        scrollPatient1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192), 3));

        tbl_view1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_view1.setAltoHead(30);
        tbl_view1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        tbl_view1.setFuenteFilas(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        tbl_view1.setFuenteFilasSelect(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        tbl_view1.setFuenteHead(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        tbl_view1.setGrosorBordeFilas(0);
        tbl_view1.setGrosorBordeHead(0);
        tbl_view1.setMultipleSeleccion(false);
        tbl_view1.getTableHeader().setReorderingAllowed(false);
        tbl_view1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_view1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbl_view1MouseEntered(evt);
            }
        });
        scrollPatient1.setViewportView(tbl_view1);

        HEADER.add(scrollPatient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1240, 110));

        jPanel1.add(HEADER);
        HEADER.setBounds(20, 70, 1240, 150);

        jPanel3.setBackground(new java.awt.Color(51, 102, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label2.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setText("TODAY DOCTORS");
        jPanel3.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 380, 20));

        jPanel1.add(jPanel3);
        jPanel3.setBounds(20, 230, 1240, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_view1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_view1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_view1MouseClicked

    private void tbl_view1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_view1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_view1MouseEntered

    private void tbl_viewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_viewMouseEntered
        Update_dr_tbl();
    }//GEN-LAST:event_tbl_viewMouseEntered

    private void tbl_viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_viewMouseClicked
        /*  int row = tblPatient.rowAtPoint(evt.getPoint());
        if ((evt.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
            this.tblPatient.setRowSelectionInterval(row, row);
            MousePos = evt.getY() / 16;
            menuC.show(evt.getComponent(), evt.getX(), evt.getY());
        } else {
            this.tblPatient.setRowSelectionInterval(row, row);
        }*/
        try {
            int i = tbl_view.getSelectedRow();

            TableModel model = tbl_view.getModel();

            String ln = model.getValueAt(i, 0).toString();
            String sp = model.getValueAt(i, 1).toString();
            String day = model.getValueAt(i, 2).toString();
            String slot = model.getValueAt(i, 5).toString();

            showdata.setVisible(true);
            showdata.pack();
            showdata.setLocationRelativeTo(null);
            showdata.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            showdata.txt_lastname6.setText(ln);
            showdata.txt_lastname7.setText(sp);
            showdata.txt_lastname8.setText(day);
            showdata.Patient_slot.setText(slot);

        } catch (Exception e) {
            System.out.println(e);

        }
    }//GEN-LAST:event_tbl_viewMouseClicked

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
            java.util.logging.Logger.getLogger(Post_Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Post_Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Post_Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Post_Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Post_Schedule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HEADER;
    private javax.swing.JPanel Search1;
    private javax.swing.JLabel icon_SystemLogo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    public static javax.swing.JScrollPane scrollPatient;
    public static javax.swing.JScrollPane scrollPatient1;
    private rojerusan.RSTableMetro tbl_view;
    public static rojerusan.RSTableMetro tbl_view1;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables
}
