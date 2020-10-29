/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module2SubModules;

import SystemInstance.MysqlConnect;
import java.awt.Color;
import java.awt.event.KeyEvent;
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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author jerome
 */
public final class Schedule_appointment extends javax.swing.JPanel {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    CallableStatement cst = null;
    DefaultTableModel mode;
    String Gender;

    public Schedule_appointment() {
        initComponents();
        con = MysqlConnect.ConnectDB();
        tblSchedule();
        Schedule();
       
    }
    publish_schedule showdata = new publish_schedule();
    
     

    public void tblSchedule() {

        try {

            tbl_view.setSelectionBackground(Color.red);

            String q = "select surname as Doctor,specialization as Specialization,consult_day as 'Consult day' ,consult_time_from as 'From',consult_time_to as 'To',max_patient as 'Patient a day',status as Status from Core1_dra_schedule where status='Off duty' and consult_day =   DATENAME(weekday, GETDATE())";
            pst = con.prepareStatement(q);
            rs = pst.executeQuery();

            tbl_view.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);

        }

    }
// Guide to search   

    public void Hint() {
    //    txt_search_dr.setUI(new HintTextFeild("Search by specialization", true));
    }

    private void remove() {
        while (tbl_view.getRowCount() > 0) {
            mode.removeRow(0);

        }
    }

// Display current date and day    
    public void Schedule() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    Calendar Cal = new GregorianCalendar();
                    int hour = Cal.get(Calendar.HOUR);
                    int min = Cal.get(Calendar.MINUTE);
                    int sec = Cal.get(Calendar.SECOND);
                    int am_pm = Cal.get(Calendar.AM_PM);
                    int week = Cal.get(Calendar.DAY_OF_WEEK);
                    int day = Cal.get(Calendar.DAY_OF_MONTH);
                    int month1 = Cal.get(Calendar.MONTH);
                    int year = Cal.get(Calendar.YEAR);
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

                    String M = null;
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

                    // lbl_day.setText("" + weekday);
                    //   lbl_date.setText("" + month + "-" + day1 + "-" + year);
                    //  DateOverview = day;
                    //   lbl_Month_Over.setText(M);
                    // lbl_Month_Over1.setText(M);
                    // System.out.println("hout : "+hour+" min: "+min+" sec: "+sec+"");
                    try {
                        //    tblSchedule();
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }

                }
            }
        }.start();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        root = new javax.swing.JPanel();
        scrollPatient = new javax.swing.JScrollPane();
        tbl_view = new rojerusan.RSTableMetro();
        Search = new javax.swing.JPanel();
        Filter_schedule = new rojerusan.RSComboMetro();
        jLabel21 = new javax.swing.JLabel();
        txt_dr_ln = new rojerusan.RSMetroTextFullPlaceHolder();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        root.setBackground(new java.awt.Color(255, 255, 255));
        root.setLayout(null);

        scrollPatient.setBackground(new java.awt.Color(255, 255, 255));
        scrollPatient.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192), 3));

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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbl_viewMouseEntered(evt);
            }
        });
        scrollPatient.setViewportView(tbl_view);

        root.add(scrollPatient);
        scrollPatient.setBounds(20, 220, 1120, 340);

        Search.setBackground(new java.awt.Color(1, 113, 124));
        Search.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Search.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Filter_schedule.setEditable(true);
        Filter_schedule.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All Schedule", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));
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
        Search.add(Filter_schedule, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 13, 135, 34));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/old1.png"))); // NOI18N
        Search.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 60));

        txt_dr_ln.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txt_dr_ln.setPlaceholder("Search by Specialization");
        txt_dr_ln.setPreferredSize(new java.awt.Dimension(250, 40));
        txt_dr_ln.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dr_lnActionPerformed(evt);
            }
        });
        txt_dr_ln.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dr_lnKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_dr_lnKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dr_lnKeyTyped(evt);
            }
        });
        Search.add(txt_dr_ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 170, -1));

        root.add(Search);
        Search.setBounds(740, 90, 361, 60);

        jLabel15.setBackground(new java.awt.Color(51, 102, 255));
        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Today Doctors");
        jLabel15.setOpaque(true);
        jLabel15.setPreferredSize(new java.awt.Dimension(300, 15));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        root.add(jLabel15);
        jLabel15.setBounds(15, 165, 1130, 50);

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

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked

    }//GEN-LAST:event_jLabel15MouseClicked

    private void Filter_schedulePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_Filter_schedulePopupMenuWillBecomeInvisible

    }//GEN-LAST:event_Filter_schedulePopupMenuWillBecomeInvisible

    private void Filter_scheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Filter_scheduleActionPerformed
        ((JLabel) Filter_schedule.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        if (Filter_schedule.getSelectedItem().equals("Monday")) {
            try {
                String q = "select surname as Doctor,specialization as Specialization,consult_day as 'Consult day' ,consult_time_from as 'From',consult_time_to as 'To',max_patient as 'Patient a day'"
                        + " from Core1_dra_schedule where consult_day =  'Monday' ";
                pst = con.prepareStatement(q);
                rs = pst.executeQuery();

                tbl_view.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            }
        } else if (Filter_schedule.getSelectedItem().equals("Tuesday")) {
            try {
                String q = "select surname as Doctor,specialization as Specialization,consult_day as 'Consult day' ,consult_time_from as 'From',consult_time_to as 'To',max_patient as 'Patient a day'"
                        + " from Core1_dra_schedule where consult_day =  'Tuesday' ";
                pst = con.prepareStatement(q);
                rs = pst.executeQuery();

                tbl_view.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            }
        } else if (Filter_schedule.getSelectedItem().equals("Wednesday")) {
            try {
                String q = "select surname as Doctor,specialization as Specialization,consult_day as 'Consult day' ,consult_time_from as 'From',consult_time_to as 'To',max_patient as 'Patient a day'"
                        + " from Core1_dra_schedule where consult_day =  'Wednesday' ";
                pst = con.prepareStatement(q);
                rs = pst.executeQuery();

                tbl_view.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            }
        } else if (Filter_schedule.getSelectedItem().equals("Thursday")) {
            try {
                String q = "select surname as Doctor,specialization as Specialization,consult_day as 'Consult day' ,consult_time_from as 'From',consult_time_to as 'To',max_patient as 'Patient a day'"
                        + " from Core1_dra_schedule where consult_day =  'Thursday' ";
                pst = con.prepareStatement(q);
                rs = pst.executeQuery();

                tbl_view.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            }
        } else if (Filter_schedule.getSelectedItem().equals("Friday")) {
            try {
                String q = "select surname as Doctor,specialization as Specialization,consult_day as 'Consult day' ,consult_time_from as 'From',consult_time_to as 'To',max_patient as 'Patient a day'"
                        + " from Core1_dra_schedule where consult_day =  'Friday' ";
                pst = con.prepareStatement(q);
                rs = pst.executeQuery();

                tbl_view.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            }
        } else if (Filter_schedule.getSelectedItem().equals("Saturday")) {
            try {
                String q = "select surname as Doctor,specialization as Specialization,consult_day as 'Consult day' ,consult_time_from as 'From',consult_time_to as 'To',max_patient as 'Patient a day'"
                        + " from Core1_dra_schedule where consult_day =  'Saturday' ";
                pst = con.prepareStatement(q);
                rs = pst.executeQuery();

                tbl_view.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            }
        } else if (Filter_schedule.getSelectedItem().equals("Sunday")) {
            try {
                String q = "select surname as Doctor,specialization as Specialization,consult_day as 'Consult day' ,consult_time_from as 'From',consult_time_to as 'To',max_patient as 'Patient a day' from Core1_dra_schedule where consult_day =  'Sunday' ";
                pst = con.prepareStatement(q);
                rs = pst.executeQuery();

                tbl_view.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            }
        } else {
            Filter_schedule.getSelectedItem().equals("All Doctors");
            try {
                String q = "select surname as Doctor,specialization as Specialization,consult_day as 'Consult day' ,consult_time_from as 'From',consult_time_to as 'To',max_patient as 'Patient a day'"
                        + " from Core1_dra_schedule";
                pst = con.prepareStatement(q);
                rs = pst.executeQuery();

                tbl_view.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_Filter_scheduleActionPerformed

    private void txt_dr_lnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dr_lnActionPerformed

    }//GEN-LAST:event_txt_dr_lnActionPerformed

    private void txt_dr_lnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dr_lnKeyPressed

    }//GEN-LAST:event_txt_dr_lnKeyPressed

    private void txt_dr_lnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dr_lnKeyReleased
        // Search doctors by name
        String sb = txt_dr_ln.getText().trim() + "%";
        try {
            String searchbed = "select surname as Doctor,specialization as Specialization,consult_day as 'Consult day' ,consult_time_from as 'From',consult_time_to as 'To',max_patient as 'Patient a day' from Core1_dra_schedule where   specialization like '" + sb + "'";
            pst = con.prepareStatement(searchbed);
            rs = pst.executeQuery();
            tbl_view.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
        }
    }//GEN-LAST:event_txt_dr_lnKeyReleased

    private void txt_dr_lnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dr_lnKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }

        if (!Character.isAlphabetic(evt.getKeyChar()) && !Character.isSpaceChar(evt.getKeyChar())) {
            evt.consume();
        } else if (txt_dr_ln.getText().trim().length() == 0 && Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_txt_dr_lnKeyTyped

    private void tbl_viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_viewMouseClicked
        /*  int row = tblPatient.rowAtPoint(evt.getPoint());
        if ((evt.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
            this.tblPatient.setRowSelectionInterval(row, row);
            MousePos = evt.getY() / 16;
            menuC.show(evt.getComponent(), evt.getX(), evt.getY());
        } else {
            this.tblPatient.setRowSelectionInterval(row, row);
        }*/
         try
        {
            int i = tbl_view.getSelectedRow();

            TableModel model = tbl_view.getModel();

            String ln = model.getValueAt(i, 0).toString();
            String sp = model.getValueAt(i, 1).toString();
            String cd = model.getValueAt(i, 2).toString();
            String frm = model.getValueAt(i, 3).toString();
            String to = model.getValueAt(i, 4).toString();
            String max = model.getValueAt(i, 5).toString();

            showdata.setVisible(true);
            showdata.pack();
            showdata.setLocationRelativeTo(null);
            showdata.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            showdata.txt_name.setText(ln);
            showdata.txt_specia.setText(sp);
            showdata.CB_Day.setText(cd);
            showdata.txt_frm.setText(frm);
            showdata.txt_to.setText(to);
            showdata.txt_max_pat.setText(max);

        } catch (Exception e)
        {
            System.out.println(e);

        }
    }//GEN-LAST:event_tbl_viewMouseClicked

    private void tbl_viewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_viewMouseEntered
        tblSchedule();
    }//GEN-LAST:event_tbl_viewMouseEntered

    private void tbl_viewAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_viewAncestorAdded
        tblSchedule();
    }//GEN-LAST:event_tbl_viewAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSComboMetro Filter_schedule;
    private javax.swing.JPanel Search;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel root;
    public static javax.swing.JScrollPane scrollPatient;
    public static rojerusan.RSTableMetro tbl_view;
    private rojerusan.RSMetroTextFullPlaceHolder txt_dr_ln;
    // End of variables declaration//GEN-END:variables
}
