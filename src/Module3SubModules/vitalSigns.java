package Module3SubModules;

import SystemInstance.MysqlConnect;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.text.AbstractDocument;
import net.proteanit.sql.DbUtils;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author iRHONman
 */
public class vitalSigns extends javax.swing.JFrame {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    CallableStatement cst = null;

    public vitalSigns() {
        initComponents();
        con = MysqlConnect.ConnectDB();
        select_dr();
        tblSchedule();
        CurrentDate();
        Limit();
        auto_vs_number();
        //   pat_ID.setVisible(false);
        //txt_day.setVisible(false);
        // txt_c_id.setVisible(false);

    }

    public void close() {
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    public void Limit() {
// limit of per textfield
        ((AbstractDocument) jTextField11.getDocument()).setDocumentFilter(new SystemInstance.LimitText(3));
        ((AbstractDocument) jTextField12.getDocument()).setDocumentFilter(new SystemInstance.LimitText(3));
        ((AbstractDocument) jTextField17.getDocument()).setDocumentFilter(new SystemInstance.LimitText(4));
        ((AbstractDocument) jTextField20.getDocument()).setDocumentFilter(new SystemInstance.LimitText(3));
        ((AbstractDocument) jTextField18.getDocument()).setDocumentFilter(new SystemInstance.LimitText(3));

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

        //     txt_day.setText((buwan) + "/" + (day1) + "/" + year + " " + hour + ":" + mn + day_night);
        txt_day.setText((buwan) + "/" + (day1) + "/" + year);

    }

    public void auto_vs_number() {

        try {
            String sql = "SELECT Count(vitalSigns_no)AS no FROM Core1_opd_consultwaiting";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                if (rs.first() == false) {
                    txt_c_id.setText("0");
                } else {
                    rs.last();
                    int auto_id = rs.getInt(1) + 1;
                    String no = String.valueOf(auto_id);
                    int nolong = no.length();
                    for (int a = 0; a < 3 - nolong; a++) {
                        no = "000" + no;
                    }
                    txt_c_id.setText(no);
                }
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

    public void tblSchedule() {

        try {

            String q = "select Consultation_ID as ID,name as 'Patient name',gender as 'Gender',age as 'Age',patContact as 'Contact no',patient_illness as 'Illness',"
                    + "doctor_name as 'Doctor',specialization as 'Specialization',status 'Status'\n"
                    + "   from Core1_opd_consultlist where consult_day = DATENAME(weekday, GETDATE()) and "
                    + "cast (appontment_registered as date) =    convert (nvarchar,GETDATE(),101) and status = 'No vital signs yet'";

            pst = con.prepareStatement(q);
            rs = pst.executeQuery();

            tbl_view.setModel(DbUtils.resultSetToTableModel(rs));

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
        scrollPatient = new javax.swing.JScrollPane();
        tbl_view = new rojerusan.RSTableMetro(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;

            }
        };
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        asterisk3 = new javax.swing.JLabel();
        asterisk2 = new javax.swing.JLabel();
        asterisk1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jTextField18 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_day = new javax.swing.JTextField();
        asterisk5 = new javax.swing.JLabel();
        asterisk4 = new javax.swing.JLabel();
        txt_c_id = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        lab_patName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lab_patAge = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lab_patGender = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        lab_patSick = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        lab_patNo = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        lab_patDr = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        lab_drSpecia = new javax.swing.JTextField();
        pat_ID = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        Filter_schedule = new rojerusan.RSComboMetro();
        asterisk6 = new javax.swing.JLabel();
        fillAll1 = new rojerusan.RSMaterialButtonRound();
        fillAll = new rojerusan.RSMaterialButtonRound();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        });
        scrollPatient.setViewportView(tbl_view);

        jPanel1.add(scrollPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 850, 330));

        jPanel7.setBackground(new java.awt.Color(240, 240, 240));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Vital signs"));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("°F");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 30, 20));

        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField12KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField12KeyTyped(evt);
            }
        });
        jPanel7.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 40, -1));

        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField11KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField11KeyTyped(evt);
            }
        });
        jPanel7.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 30, -1));

        jTextField17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField17KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField17KeyTyped(evt);
            }
        });
        jPanel7.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 40, -1));

        asterisk3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        asterisk3.setForeground(new java.awt.Color(255, 0, 0));
        asterisk3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel7.add(asterisk3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 20, 20));

        asterisk2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        asterisk2.setForeground(new java.awt.Color(255, 0, 0));
        asterisk2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel7.add(asterisk2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 20, 20));

        asterisk1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        asterisk1.setForeground(new java.awt.Color(255, 0, 0));
        asterisk1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel7.add(asterisk1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 20, 20));

        jLabel11.setText("Body temperature:");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("/");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 10, 20));

        jLabel7.setText("Blood presusre:");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 90, -1));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 290, 120));

        jPanel9.setBackground(new java.awt.Color(240, 240, 240));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Initial Weight - Height"));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField18KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField18KeyTyped(evt);
            }
        });
        jPanel9.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 40, -1));

        jLabel19.setText("Weight:");
        jPanel9.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jTextField20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField20KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField20KeyTyped(evt);
            }
        });
        jPanel9.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 40, -1));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel22.setText("cm");
        jPanel9.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel23.setText("kg");
        jPanel9.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, -1, -1));

        jLabel21.setText("Height:");
        jPanel9.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        txt_day.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_day.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_day.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_day.setEnabled(false);
        txt_day.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_dayKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dayKeyTyped(evt);
            }
        });
        jPanel9.add(txt_day, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 120, 20));

        asterisk5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        asterisk5.setForeground(new java.awt.Color(255, 0, 0));
        asterisk5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel9.add(asterisk5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 20, 20));

        asterisk4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        asterisk4.setForeground(new java.awt.Color(255, 0, 0));
        asterisk4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel9.add(asterisk4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 20, 20));

        txt_c_id.setBackground(new java.awt.Color(0, 102, 102));
        txt_c_id.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_c_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_c_id.setEnabled(false);
        jPanel9.add(txt_c_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 120, 30));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 290, 100));

        jPanel8.setBackground(new java.awt.Color(240, 240, 240));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Patient Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lab_patName.setEditable(false);
        lab_patName.setBackground(new java.awt.Color(255, 255, 255));
        lab_patName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lab_patName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.add(lab_patName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 190, -1));

        jLabel2.setText("Name:");
        jPanel8.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 40, -1));

        jLabel13.setText("Age:");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 40, -1));

        lab_patAge.setEditable(false);
        lab_patAge.setBackground(new java.awt.Color(255, 255, 255));
        lab_patAge.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lab_patAge.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.add(lab_patAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 50, -1));

        jLabel4.setText("Gender:");
        jPanel8.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        lab_patGender.setEditable(false);
        lab_patGender.setBackground(new java.awt.Color(255, 255, 255));
        lab_patGender.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lab_patGender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.add(lab_patGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 49, -1));

        jLabel14.setText("Diagnosis:");
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        lab_patSick.setEditable(false);
        lab_patSick.setBackground(new java.awt.Color(255, 255, 255));
        lab_patSick.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lab_patSick.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.add(lab_patSick, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 89, -1));

        jLabel15.setText("Contact no.");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        lab_patNo.setEditable(false);
        lab_patNo.setBackground(new java.awt.Color(255, 255, 255));
        lab_patNo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lab_patNo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.add(lab_patNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 87, -1));

        jLabel17.setText("Doctor: ");
        jPanel8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        lab_patDr.setEditable(false);
        lab_patDr.setBackground(new java.awt.Color(255, 255, 255));
        lab_patDr.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lab_patDr.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.add(lab_patDr, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 102, -1));

        jLabel18.setText("Specialization");
        jPanel8.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        lab_drSpecia.setEditable(false);
        lab_drSpecia.setBackground(new java.awt.Color(255, 255, 255));
        lab_drSpecia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lab_drSpecia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.add(lab_drSpecia, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 102, -1));

        pat_ID.setEditable(false);
        pat_ID.setBackground(new java.awt.Color(255, 255, 255));
        pat_ID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pat_ID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pat_ID.setEnabled(false);
        pat_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pat_IDActionPerformed(evt);
            }
        });
        jPanel8.add(pat_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 130, 30));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 310, 240));

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setBackground(new java.awt.Color(0, 124, 134));
        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Select Doctor");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 100, 30));

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
        jPanel2.add(Filter_schedule, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 130, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 850, 50));

        asterisk6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        asterisk6.setForeground(new java.awt.Color(255, 0, 0));
        asterisk6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(asterisk6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 470, 20, 30));

        fillAll1.setText("Add  vital signs");
        fillAll1.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        fillAll1.setMaximumSize(new java.awt.Dimension(82, 26));
        fillAll1.setMinimumSize(new java.awt.Dimension(82, 26));
        fillAll1.setPreferredSize(new java.awt.Dimension(88, 28));
        fillAll1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillAll1ActionPerformed(evt);
            }
        });
        jPanel1.add(fillAll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 480, 150, 50));

        fillAll.setText("EXIT");
        fillAll.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        fillAll.setMaximumSize(new java.awt.Dimension(82, 26));
        fillAll.setMinimumSize(new java.awt.Dimension(82, 26));
        fillAll.setPreferredSize(new java.awt.Dimension(88, 28));
        fillAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillAllActionPerformed(evt);
            }
        });
        jPanel1.add(fillAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 480, 150, 50));

        jPanel3.setBackground(new java.awt.Color(51, 102, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_dayKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txt_dayKeyReleased
    {//GEN-HEADEREND:event_txt_dayKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dayKeyReleased

    private void txt_dayKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txt_dayKeyTyped
    {//GEN-HEADEREND:event_txt_dayKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dayKeyTyped

    private void jTextField11KeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTextField11KeyTyped
    {//GEN-HEADEREND:event_jTextField11KeyTyped
// accept number only
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11KeyTyped

    private void jTextField12KeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTextField12KeyTyped
    {//GEN-HEADEREND:event_jTextField12KeyTyped
// accept number only
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12KeyTyped

    private void jTextField17KeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTextField17KeyTyped
    {//GEN-HEADEREND:event_jTextField17KeyTyped
// accept number only
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17KeyTyped

    private void jTextField20KeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTextField20KeyTyped
    {//GEN-HEADEREND:event_jTextField20KeyTyped
// accept number only
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20KeyTyped

    private void jTextField18KeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTextField18KeyTyped
    {//GEN-HEADEREND:event_jTextField18KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18KeyTyped

    private void jTextField11KeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTextField11KeyReleased
    {//GEN-HEADEREND:event_jTextField11KeyReleased
        asterisk1.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11KeyReleased

    private void jTextField12KeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTextField12KeyReleased
    {//GEN-HEADEREND:event_jTextField12KeyReleased
        asterisk2.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12KeyReleased

    private void jTextField17KeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTextField17KeyReleased
    {//GEN-HEADEREND:event_jTextField17KeyReleased
        asterisk3.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17KeyReleased

    private void jTextField20KeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTextField20KeyReleased
    {//GEN-HEADEREND:event_jTextField20KeyReleased
        asterisk4.setText("");           // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20KeyReleased

    private void jTextField18KeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTextField18KeyReleased
    {//GEN-HEADEREND:event_jTextField18KeyReleased
        asterisk5.setText("");           // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18KeyReleased

    private void pat_IDActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_pat_IDActionPerformed
    {//GEN-HEADEREND:event_pat_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pat_IDActionPerformed

    private void fillAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillAllActionPerformed

        this.dispose();
    }//GEN-LAST:event_fillAllActionPerformed

    private void fillAll1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillAll1ActionPerformed
        String aa = this.jTextField11.getText();
        String bb = this.jTextField12.getText();
        String cc = this.jTextField17.getText();
        String dd = this.jTextField20.getText();
        String ee = this.jTextField18.getText();
        if (aa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please get Blood presure of patient");
            asterisk1.setText("*");
        } else if (bb.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please get Blood presure of patient");
            asterisk2.setText("*");
        } else if (cc.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please get Body temperature of patient");
            asterisk3.setText("*");
        } else if (dd.isEmpty()) {

        } else if (ee.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please get Weight of patient");
            asterisk5.setText("*");
        } else {

            String blood = jTextField11.getText() + jLabel9.getText() + jTextField12.getText();
            String bt = jTextField17.getText() + jLabel8.getText();
            String h = jTextField20.getText() + " " + jLabel22.getText();
            String w = jTextField18.getText() + " " + jLabel23.getText();
            try {

                String query = "insert into Core1_opd_consultwaiting values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                pst = con.prepareStatement(query);

                pst.setString(1, txt_c_id.getText());
                pst.setString(2, lab_patName.getText());
                pst.setString(3, lab_patAge.getText());
                pst.setString(4, lab_patGender.getText());
                pst.setString(5, lab_patNo.getText());
                pst.setString(6, lab_patSick.getText());
                pst.setString(7, lab_patDr.getText());
                pst.setString(8, lab_drSpecia.getText());
                pst.setString(9, blood);
                pst.setString(10, bt);
                pst.setString(11, h);
                pst.setString(12, w);
                pst.setString(13, txt_day.getText());
                pst.setString(14, "Pending consultation");
                pst.setString(15, pat_ID.getText());
                pst.setString(16, "Outpatient");

                //    pst.setString(10, "Scheduled");
                pst.execute();
                InputStream in;
                try {

                    in = new FileInputStream(new File("C:\\Users\\iRHONman\\Desktop\\PS1\\Template\\undone\\src\\VoiceOverNotif\\VoiceOver\\vitalsigns.wav"));

                    AudioStream audios = new AudioStream(in);
                    AudioPlayer.player.start(audios);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }

                try {

                    String query2 = "update Core1_opd_consultlist set status = 'Pending Consultation' "
                            + "where name='" + lab_patName.getText() + "' and Consultation_ID = '" + pat_ID.getText() + "' ";

                    java.sql.Statement st = null;

                    st = con.createStatement();
                    st.executeUpdate(query2);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                    //"Not Saved!, please check your remaining filled"

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }
            JOptionPane.showMessageDialog(null, "Patient Successfully  add vital signs");
            auto_vs_number();
            tblSchedule();

        }
    }//GEN-LAST:event_fillAll1ActionPerformed

    private void tbl_viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_viewMouseClicked
        /*  int row = tblPatient.rowAtPoint(evt.getPoint());
        if ((evt.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
            this.tblPatient.setRowSelectionInterval(row, row);
            MousePos = evt.getY() / 16;
            menuC.show(evt.getComponent(), evt.getX(), evt.getY());
        } else {
            this.tblPatient.setRowSelectionInterval(row, row);
        }*/
 /*     boolean a = tbl_view.isEditing();

        if (a == false) {
            JOptionPane.showMessageDialog(null, "You can not edit this table");

        }*/
        try {

            int row = tbl_view.getSelectedRow();
            String Table_transfer = (tbl_view.getModel().getValueAt(row, 0).toString());
            String sql = "select Patient_ID as ID,name ,gender ,age,patContact,patient_illness as Illness,"
                    + "doctor_name ,specialization ,status \n"
                    + "   from Core1_opd_consultlist where Consultation_ID='" + Table_transfer + "' ";

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                String add111 = rs.getString("ID");
                pat_ID.setText(add111);
                String add1 = rs.getString("name");
                lab_patName.setText(add1);
                String add2 = rs.getString("age");
                lab_patGender.setText(add2);
                String add3 = rs.getString("gender");
                lab_patAge.setText(add3);
                String add4 = rs.getString("patContact");
                lab_patNo.setText(add4);
                String add5 = rs.getString("Illness");
                lab_patSick.setText(add5);
                String add6 = rs.getString("doctor_name");
                lab_patDr.setText(add6);
                String add7 = rs.getString("specialization");
                lab_drSpecia.setText(add7);
            }

        } catch (Exception e) {
            System.out.println(e);

        }
    }//GEN-LAST:event_tbl_viewMouseClicked

    private void tbl_viewAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_viewAncestorAdded

        tblSchedule();
    }//GEN-LAST:event_tbl_viewAncestorAdded

    private void Filter_schedulePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_Filter_schedulePopupMenuWillBecomeInvisible

    }//GEN-LAST:event_Filter_schedulePopupMenuWillBecomeInvisible

    private void Filter_scheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Filter_scheduleActionPerformed
        ((JLabel) Filter_schedule.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        Object obj = evt.getSource();
        {
            if (obj == Filter_schedule) {

                try {
                    String q = "select name as 'Patient name',patient_illness as 'Illness',age as 'Age',gender as 'Gender',patContact as 'Contact no', mode_of_payment as 'Payment',"
                            + "doctor_name as 'Doctor',specialization as 'Specialization',appontment_registered as 'Registered date',status 'Status'\n"
                            + "   from Core1_opd_consultlist where consult_day = DATENAME(weekday, GETDATE()) and "
                            + "cast (appontment_registered as date) =    convert (nvarchar,GETDATE(),101) and doctor_name = '" + Filter_schedule.getSelectedItem() + "'";
                    //String q = "select * from Core1_opd_consultlist where doctor_name='" + Filter_schedule + "' ";

                    pst = con.prepareStatement(q);
                    rs = pst.executeQuery();
                    tbl_view.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        }
    }//GEN-LAST:event_Filter_scheduleActionPerformed

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
            java.util.logging.Logger.getLogger(vitalSigns.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vitalSigns.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vitalSigns.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vitalSigns.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vitalSigns().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSComboMetro Filter_schedule;
    private javax.swing.JLabel asterisk1;
    private javax.swing.JLabel asterisk2;
    private javax.swing.JLabel asterisk3;
    private javax.swing.JLabel asterisk4;
    private javax.swing.JLabel asterisk5;
    private javax.swing.JLabel asterisk6;
    private rojerusan.RSMaterialButtonRound fillAll;
    private rojerusan.RSMaterialButtonRound fillAll1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField20;
    public static javax.swing.JTextField lab_drSpecia;
    public static javax.swing.JTextField lab_patAge;
    public static javax.swing.JTextField lab_patDr;
    public static javax.swing.JTextField lab_patGender;
    public static javax.swing.JTextField lab_patName;
    public static javax.swing.JTextField lab_patNo;
    public static javax.swing.JTextField lab_patSick;
    public static javax.swing.JTextField pat_ID;
    public static javax.swing.JScrollPane scrollPatient;
    public static rojerusan.RSTableMetro tbl_view;
    public static javax.swing.JTextField txt_c_id;
    public static javax.swing.JTextField txt_day;
    // End of variables declaration//GEN-END:variables

}
