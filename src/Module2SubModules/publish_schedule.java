package Module2SubModules;

import SystemInstance.MysqlConnect;
import SystemInstance.Post_Schedule;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author iRHONman
 */
public class publish_schedule extends javax.swing.JFrame {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    CallableStatement cst = null;
    DefaultTableModel mode;
    String Registerno;
    String Gender;
    String GenderApp;

    public publish_schedule() {
        initComponents();
        con = MysqlConnect.ConnectDB();
        auto_dr_number();
        CurrentDate();

    }

    public void audio() {
        InputStream in;
        try {

            in = new FileInputStream(new File("C:\\Users\\iRHONman\\Desktop\\PS1\\Template\\undone\\src\\VoiceOverNotif\\VoiceOver\\doctor.wav"));

            AudioStream audios = new AudioStream(in);
            AudioPlayer.player.start(audios);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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

        //txt_date.setText(+hour+":"+minute+" "+day_night+", "+month+"/"+(day)+"/"+year);
        date.setText((buwan) + "/" + (day1) + "/" + year + " " + hour + ":" + mn + day_night);

    }

    public void auto_dr_number() {

        try {
            String sql = "SELECT Count(Schedule_ID)AS no FROM Core1_dra_publish";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                if (rs.first() == false) {
                    txt_sched_dr.setText("1");
                } else {
                    rs.last();
                    int auto_id = rs.getInt(1) + 1;
                    String no = String.valueOf(auto_id);
                    int nolong = no.length();
                    for (int a = 0; a < 3 - nolong; a++) {
                        no = "" + no;
                    }
                    txt_sched_dr.setText(no);
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

        jPanel3 = new javax.swing.JPanel();
        lbl_hms = new javax.swing.JLabel();
        txt_hms_CompanyName = new javax.swing.JTextField();
        lbl_loc = new javax.swing.JLabel();
        txt_hms_Location = new javax.swing.JTextField();
        txt_hms_Email = new javax.swing.JTextField();
        lbl_email = new javax.swing.JLabel();
        lbl_contct = new javax.swing.JLabel();
        txt_hms_Contact = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel166 = new javax.swing.JLabel();
        txt_sched_dr = new javax.swing.JTextField();
        jLabel162 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        CB_Day = new javax.swing.JTextField();
        txt_specia = new javax.swing.JTextField();
        jLabel163 = new javax.swing.JLabel();
        txt_max_pat = new javax.swing.JTextField();
        jLabel167 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        txt_frm = new javax.swing.JTextField();
        jLabel165 = new javax.swing.JLabel();
        txt_to = new javax.swing.JTextField();
        date = new javax.swing.JLabel();
        cbFilter = new rojerusan.RSComboMetro();
        jButton35 = new javax.swing.JButton();
        jExit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        icon_SystemLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_hms.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbl_hms.setText("Hospital name:");
        jPanel3.add(lbl_hms, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 90, -1));

        txt_hms_CompanyName.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_hms_CompanyName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_hms_CompanyName.setText("Kaizen hospital");
        txt_hms_CompanyName.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_hms_CompanyName.setEnabled(false);
        jPanel3.add(txt_hms_CompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 170, -1));

        lbl_loc.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbl_loc.setText("Location:");
        jPanel3.add(lbl_loc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 50, -1));

        txt_hms_Location.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_hms_Location.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_hms_Location.setText("Quirino Highway Quezon City");
        txt_hms_Location.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_hms_Location.setEnabled(false);
        jPanel3.add(txt_hms_Location, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 170, -1));

        txt_hms_Email.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_hms_Email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_hms_Email.setText("HMS@bsIT.com.ph");
        txt_hms_Email.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_hms_Email.setEnabled(false);
        jPanel3.add(txt_hms_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 170, -1));

        lbl_email.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbl_email.setText("Email:");
        jPanel3.add(lbl_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 40, -1));

        lbl_contct.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbl_contct.setText("Contact:");
        jPanel3.add(lbl_contct, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 50, 20));

        txt_hms_Contact.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_hms_Contact.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_hms_Contact.setText("8-7000");
        txt_hms_Contact.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_hms_Contact.setEnabled(false);
        jPanel3.add(txt_hms_Contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 170, -1));

        jPanel5.setBackground(new java.awt.Color(240, 240, 240));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Doctor Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel166.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel166.setText("Schedule no:");
        jPanel5.add(jLabel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 28));

        txt_sched_dr.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_sched_dr.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_sched_dr.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_sched_dr.setEnabled(false);
        jPanel5.add(txt_sched_dr, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 48, 30));

        jLabel162.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel162.setText("Schedule");
        jPanel5.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 60, 30));

        jLabel33.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel33.setText("Name:");
        jPanel5.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 30));

        jLabel42.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel42.setText("Specialization:");
        jPanel5.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 30));

        txt_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_name.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_name.setEnabled(false);
        jPanel5.add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 94, 30));

        CB_Day.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CB_Day.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        CB_Day.setEnabled(false);
        jPanel5.add(CB_Day, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 70, 30));

        txt_specia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_specia.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_specia.setEnabled(false);
        jPanel5.add(txt_specia, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 142, 30));

        jLabel163.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel163.setText("Max Patient:");
        jPanel5.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, 28));

        txt_max_pat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_max_pat.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_max_pat.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_max_pat.setEnabled(false);
        jPanel5.add(txt_max_pat, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 19, 48, 30));

        jLabel167.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel167.setText("Date");
        jPanel5.add(jLabel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 30, 30));

        jLabel164.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel164.setText("From:");
        jPanel5.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 40, 30));

        txt_frm.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_frm.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_frm.setEnabled(false);
        jPanel5.add(txt_frm, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 60, 30));

        jLabel165.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel165.setText("To:");
        jPanel5.add(jLabel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 20, 30));

        txt_to.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_to.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_to.setEnabled(false);
        jPanel5.add(txt_to, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 70, 30));

        date.setBackground(new java.awt.Color(255, 255, 255));
        date.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        date.setText("-");
        jPanel5.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 160, 30));

        cbFilter.setEditable(true);
        cbFilter.setMaximumRowCount(2);
        cbFilter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "On duty", "Cancelled clinic" }));
        cbFilter.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jPanel5.add(cbFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 150, -1));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 310, 260));

        jButton35.setBackground(new java.awt.Color(0, 102, 102));
        jButton35.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton35.setForeground(new java.awt.Color(255, 255, 255));
        jButton35.setText("Schedule");
        jButton35.setToolTipText("Click to publish the schedule of doctors today");
        jButton35.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 490, 290, -1));

        jExit.setBackground(new java.awt.Color(0, 102, 102));
        jExit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jExit.setText("Exit");
        jExit.setPreferredSize(new java.awt.Dimension(83, 25));
        jExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExitActionPerformed(evt);
            }
        });
        jPanel3.add(jExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, 130, 30));

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon_SystemLogo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        icon_SystemLogo.setForeground(new java.awt.Color(102, 102, 255));
        icon_SystemLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon_SystemLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hms50x48.png"))); // NOI18N
        jPanel1.add(icon_SystemLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 49));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(340, 562));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton35ActionPerformed
    {//GEN-HEADEREND:event_jButton35ActionPerformed
        // Add schedule
        try {

            String query = "insert into Core1_dra_publish values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

            pst = con.prepareStatement(query);

            pst.setString(1, txt_sched_dr.getText());
            pst.setString(2, txt_name.getText());
            pst.setString(3, txt_specia.getText());
            pst.setString(4, date.getText());
            pst.setString(5, CB_Day.getText());
            pst.setString(6, txt_frm.getText());
            pst.setString(7, txt_to.getText());
            pst.setString(8, txt_max_pat.getText());
            pst.setString(9, txt_hms_CompanyName.getText());
            pst.setString(10, txt_hms_Location.getText());
            pst.setString(11, txt_hms_Email.getText());
            pst.setString(12, txt_hms_Contact.getText());
            //   pst.setString(13, "On duty");
            pst.setString(13, cbFilter.getSelectedItem().toString());

            pst.execute();

            try {

                //   String query2 = "update Core1_dra_schedule set Status = 'On duty' where surname='" + txt_name.getText() + "' ";
                String query2 = "update Core1_dra_schedule set Status = '" + cbFilter.getSelectedItem().toString() + "' where surname='" + txt_name.getText() + "' ";

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
        audio();
        JOptionPane.showMessageDialog(null, "Doctor Successfully  Scheduled");
        int choice1 = JOptionPane.showConfirmDialog(null, "Do you want to view today doctors?", "Warning", JOptionPane.YES_NO_OPTION);
        if (choice1 == JOptionPane.YES_OPTION) {
            new Post_Schedule().setVisible(true);
            setVisible(false);
        } else {
            this.dispose();
        }

    }//GEN-LAST:event_jButton35ActionPerformed

    private void jExitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jExitActionPerformed
    {//GEN-HEADEREND:event_jExitActionPerformed
        int choice1 = JOptionPane.showConfirmDialog(null, "Choose another doctor?", "Warning", JOptionPane.YES_NO_OPTION);
        if (choice1 == JOptionPane.YES_OPTION) {
            this.dispose();
        }


    }//GEN-LAST:event_jExitActionPerformed

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
            java.util.logging.Logger.getLogger(publish_schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(publish_schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(publish_schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(publish_schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new publish_schedule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField CB_Day;
    private rojerusan.RSComboMetro cbFilter;
    private javax.swing.JLabel date;
    private javax.swing.JLabel icon_SystemLogo;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jExit;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbl_contct;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_hms;
    private javax.swing.JLabel lbl_loc;
    public static javax.swing.JTextField txt_frm;
    private javax.swing.JTextField txt_hms_CompanyName;
    private javax.swing.JTextField txt_hms_Contact;
    private javax.swing.JTextField txt_hms_Email;
    private javax.swing.JTextField txt_hms_Location;
    public static javax.swing.JTextField txt_max_pat;
    public static javax.swing.JTextField txt_name;
    public static javax.swing.JTextField txt_sched_dr;
    public static javax.swing.JTextField txt_specia;
    public static javax.swing.JTextField txt_to;
    // End of variables declaration//GEN-END:variables
}
