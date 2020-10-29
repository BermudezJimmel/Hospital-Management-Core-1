/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module2SubModules;

import SystemInstance.HintTextFeild;
import SystemInstance.MysqlConnect;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author jerome
 */
public final class SubModule4 extends javax.swing.JPanel {

    public String imgPath = null;
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    CallableStatement cst = null;
    DefaultTableModel mode;
    String Registerno;
    String Gender;
    String GenderApp;
    String word;

    public SubModule4() {
        initComponents();
        con = MysqlConnect.ConnectDB();
        //   
        auto_dr_number();
        txt_R_ID1.setVisible(false);
        //  HinntText();
        // PlaceHolder();
        Limit();

    }

    public void PlaceHolder() {
        // new PlaceHolder(txt_Surname, "Surname");

        txt_dr_ln.setUI(new HintTextFeild(" Last name", false));
        txt_dr_fn.setUI(new HintTextFeild(" First name", false));
        txt_dr_mi.setUI(new HintTextFeild(" Middle name", false));
        txt_dr_State.setUI(new HintTextFeild(" State", false));
        txt_dr_Contact.setUI(new HintTextFeild(" Contact no", false));
        txt_dr_Email.setUI(new HintTextFeild(" Email", false));
        txt_noAddress.setUI(new HintTextFeild(" Street", false));
        txt_Brgy.setUI(new HintTextFeild(" Brgy", false));
        txt_City.setUI(new HintTextFeild(" Municipal / City", false));
        txt_App_School.setUI(new HintTextFeild(" School/University", false));
        txt_App_Course.setUI(new HintTextFeild(" Course", false));
    }

    // auto increment id
    public void auto_dr_number() {

        try {
            String sql = "SELECT Count(Dr_ID)AS no FROM Core1_dra_registered";
            //  con = MysqlConnect.ConnectDB();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                if (rs.first() == false) {
                    txt_R_ID1.setText("1");
                } else {
                    rs.last();
                    int auto_id = rs.getInt(1) + 1;
                    String no = String.valueOf(auto_id);
                    int nolong = no.length();
                    for (int a = 0; a < 3 - nolong; a++) {
                        no = "" + no;
                    }
                    txt_R_ID1.setText(no);
                }
            }

        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public void Limit() {
// limit of per textfield
        ((AbstractDocument) txt_dr_ln.getDocument()).setDocumentFilter(new Module2SubModules.LimitText(20));
        ((AbstractDocument) txt_dr_fn.getDocument()).setDocumentFilter(new Module2SubModules.LimitText(20));
        ((AbstractDocument) txt_dr_mi.getDocument()).setDocumentFilter(new Module2SubModules.LimitText(20));
        ((AbstractDocument) txt_dr_Contact.getDocument()).setDocumentFilter(new Module2SubModules.LimitText(10));
        ((AbstractDocument) txt_noAddress.getDocument()).setDocumentFilter(new Module2SubModules.LimitText(20));
        ((AbstractDocument) txt_Brgy.getDocument()).setDocumentFilter(new Module2SubModules.LimitText(20));
        ((AbstractDocument) txt_City.getDocument()).setDocumentFilter(new Module2SubModules.LimitText(20));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        root = new javax.swing.JPanel();
        dr_pic = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        User = new javax.swing.JLabel();
        txt_R_ID1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        bod = new com.toedter.calendar.JDateChooser();
        txt_dr_mi = new javax.swing.JTextField();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel185 = new javax.swing.JLabel();
        txt_dr_State = new javax.swing.JTextField();
        jLabel152 = new javax.swing.JLabel();
        txt_dr_ln = new javax.swing.JTextField();
        txt_dr_fn = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel186 = new javax.swing.JLabel();
        txt_dr_Email = new javax.swing.JTextField();
        txt_City = new javax.swing.JTextField();
        txt_noAddress = new javax.swing.JTextField();
        jLabel159 = new javax.swing.JLabel();
        txt_dr_Contact = new javax.swing.JTextField();
        txt_Brgy = new javax.swing.JTextField();
        jLabel160 = new javax.swing.JLabel();
        CB_Civil_Stat = new javax.swing.JComboBox<>();
        jLabel161 = new javax.swing.JLabel();
        error1 = new javax.swing.JLabel();
        error2 = new javax.swing.JLabel();
        error11 = new javax.swing.JLabel();
        error10 = new javax.swing.JLabel();
        error9 = new javax.swing.JLabel();
        error8 = new javax.swing.JLabel();
        error7 = new javax.swing.JLabel();
        error6 = new javax.swing.JLabel();
        error5 = new javax.swing.JLabel();
        error3 = new javax.swing.JLabel();
        error16phone = new javax.swing.JLabel();
        error15mail = new javax.swing.JLabel();
        pnl_dr_bg = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txt_App_School = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        txt_App_Course = new javax.swing.JTextField();
        DC_Date_Graduated = new com.toedter.calendar.JDateChooser();
        specia = new javax.swing.JComboBox<>();
        error14 = new javax.swing.JLabel();
        error13 = new javax.swing.JLabel();
        error16 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        CitizenShip = new javax.swing.JComboBox<>();
        fillAll = new rojerusan.RSMaterialButtonRound();
        jPanel2 = new javax.swing.JPanel();

        root.setBackground(new java.awt.Color(255, 255, 255));
        root.setLayout(null);

        dr_pic.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        dr_pic.setForeground(new java.awt.Color(0, 102, 102));
        dr_pic.setText("-");
        root.add(dr_pic);
        dr_pic.setBounds(20, 70, 150, 120);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("User:");
        root.add(jLabel2);
        jLabel2.setBounds(130, 590, 50, 30);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("-");
        root.add(jLabel3);
        jLabel3.setBounds(170, 590, 50, 30);

        ID.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ID.setForeground(new java.awt.Color(255, 255, 255));
        ID.setText("-");
        root.add(ID);
        ID.setBounds(60, 590, 50, 30);

        User.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        User.setForeground(new java.awt.Color(255, 255, 255));
        User.setText("ID:");
        root.add(User);
        User.setBounds(40, 590, 50, 30);

        txt_R_ID1.setBackground(new java.awt.Color(0, 153, 153));
        txt_R_ID1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_R_ID1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_R_ID1.setEnabled(false);
        root.add(txt_R_ID1);
        txt_R_ID1.setBounds(90, 240, 100, 30);

        jButton2.setText("Browse");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        root.add(jButton2);
        jButton2.setBounds(20, 200, 160, 23);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Doctors information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(bod, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 190, -1));

        txt_dr_mi.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_dr_mi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_dr_miKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dr_miKeyTyped(evt);
            }
        });
        jPanel1.add(txt_dr_mi, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 31, 190, 30));

        jRadioButton4.setText("Male");
        jRadioButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));

        jRadioButton3.setText("Female");
        jRadioButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, -1));

        jLabel185.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel185.setText("+63");
        jPanel1.add(jLabel185, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 30, 20));

        txt_dr_State.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_dr_StateKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dr_StateKeyTyped(evt);
            }
        });
        jPanel1.add(txt_dr_State, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 190, -1));

        jLabel152.setText("Address:");
        jPanel1.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        txt_dr_ln.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_dr_ln.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dr_lnActionPerformed(evt);
            }
        });
        txt_dr_ln.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_dr_lnKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dr_lnKeyTyped(evt);
            }
        });
        jPanel1.add(txt_dr_ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 31, 190, 30));

        txt_dr_fn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_dr_fn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_dr_fnKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dr_fnKeyTyped(evt);
            }
        });
        jPanel1.add(txt_dr_fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 31, 190, 30));

        jLabel33.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel33.setText("Name:");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 20, 320));

        jLabel186.setText("Email:");
        jPanel1.add(jLabel186, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        txt_dr_Email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_dr_EmailKeyReleased(evt);
            }
        });
        jPanel1.add(txt_dr_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 190, -1));

        txt_City.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_CityKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CityKeyTyped(evt);
            }
        });
        jPanel1.add(txt_City, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 190, -1));

        txt_noAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_noAddressKeyReleased(evt);
            }
        });
        jPanel1.add(txt_noAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 190, -1));

        jLabel159.setText("Birthdate:");
        jPanel1.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 80, 20));

        txt_dr_Contact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_dr_ContactKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dr_ContactKeyTyped(evt);
            }
        });
        jPanel1.add(txt_dr_Contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 190, -1));

        txt_Brgy.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BrgyKeyReleased(evt);
            }
        });
        jPanel1.add(txt_Brgy, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 190, -1));

        jLabel160.setText("Civil Status:");
        jPanel1.add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 70, 20));

        CB_Civil_Stat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select here", "Single", "Married", "Widdowed", "Separated", "Divorce" }));
        jPanel1.add(CB_Civil_Stat, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 190, -1));

        jLabel161.setText("Citizenship:");
        jPanel1.add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        error1.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        error1.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(error1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 190, 30));

        error2.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        error2.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(error2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 190, 30));

        error11.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        error11.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(error11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 190, 20));

        error10.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        error10.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(error10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 190, 20));

        error9.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        error9.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(error9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 190, 20));

        error8.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        error8.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(error8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 190, 20));

        error7.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        error7.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(error7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 190, 20));

        error6.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        error6.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(error6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 190, 20));

        error5.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        error5.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(error5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 190, 20));

        error3.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        error3.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(error3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 190, 30));

        error16phone.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        error16phone.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(error16phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 190, 20));

        error15mail.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        error15mail.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(error15mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 190, 20));

        pnl_dr_bg.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Doctors background", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        pnl_dr_bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setText("School / University:");
        pnl_dr_bg.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 110, -1));

        jLabel42.setText("Specialization");
        pnl_dr_bg.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        txt_App_School.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_App_SchoolKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_App_SchoolKeyTyped(evt);
            }
        });
        pnl_dr_bg.add(txt_App_School, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 210, -1));

        jLabel43.setText("Date Graduated:");
        pnl_dr_bg.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel44.setText("Course:");
        pnl_dr_bg.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 80, -1));

        txt_App_Course.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_App_CourseKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_App_CourseKeyTyped(evt);
            }
        });
        pnl_dr_bg.add(txt_App_Course, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 220, -1));
        pnl_dr_bg.add(DC_Date_Graduated, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 210, -1));

        specia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select here", "Allergist/Immunologist", "Anesthesiologist ", "Cardiologist ", "Dermatologist ", "Gastroenterologist ", "Hematologist/Oncologist ", "Family medicine", "Nephrologist ", "Neurologist ", "Neurosurgeon ", "Obstetrician ", "Obstetrician ", "Ophthalmologist ", "Oral and Maxillofacial Surgeon", "Orthopaedic Surgeon", "Otolaryngologist ", "Pathologist ", "Pediatrician ", "Plastic Surgeon", "Podiatrist ", "Psychiatrist ", "Pulmonary Medicine Physician", "Radiation Onconlogist" }));
        pnl_dr_bg.add(specia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, -1));

        error14.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        error14.setForeground(new java.awt.Color(204, 0, 0));
        pnl_dr_bg.add(error14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 210, 20));

        error13.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        error13.setForeground(new java.awt.Color(204, 0, 0));
        pnl_dr_bg.add(error13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 210, 20));

        error16.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        error16.setForeground(new java.awt.Color(204, 0, 0));
        pnl_dr_bg.add(error16, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 210, 20));

        jPanel1.add(pnl_dr_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 390, 250));

        jLabel162.setText("Gender:");
        jPanel1.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        CitizenShip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select here", "American", "Afganistan", "Arabic", "Chinese", "Japanese", "Pakistan", "Philippines", "Russian", "Venezuela" }));
        jPanel1.add(CitizenShip, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 190, -1));

        fillAll.setText("Register");
        fillAll.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        fillAll.setMaximumSize(new java.awt.Dimension(82, 26));
        fillAll.setMinimumSize(new java.awt.Dimension(82, 26));
        fillAll.setPreferredSize(new java.awt.Dimension(88, 28));
        fillAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillAllActionPerformed(evt);
            }
        });
        jPanel1.add(fillAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 360, 140, 50));

        root.add(jPanel1);
        jPanel1.setBounds(200, 70, 940, 460);

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        root.add(jPanel2);
        jPanel2.setBounds(0, 0, 1166, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(root, javax.swing.GroupLayout.PREFERRED_SIZE, 1166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(root, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // import image
        JFileChooser chooser = new JFileChooser("c:\\Documents");

        LookAndFeel previousLF = UIManager.getLookAndFeel();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            chooser = new JFileChooser();
            UIManager.setLookAndFeel(previousLF);
        } catch (IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException e) {
        }
        //Add whatever other settings you want to the method
        // chooser.showOpenDialog(frame);

        chooser.setDialogTitle("Choose Photo");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
        chooser.addChoosableFileFilter(fnef);
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {

            File fs = chooser.getSelectedFile();
            String path = fs.getAbsolutePath();
            imgPath = path;
            ImageIcon icon = new ImageIcon(path);

            Image img = icon.getImage();
            Image newImg = img.getScaledInstance(dr_pic.getWidth(), dr_pic.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon newImc = new ImageIcon(newImg);
            dr_pic.setIcon(newImc);

        } else if (result == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "No Images Selected");

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_dr_miKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dr_miKeyReleased
        error3.setText("");
    }//GEN-LAST:event_txt_dr_miKeyReleased

    private void txt_dr_miKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dr_miKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }
        if (!Character.isAlphabetic(evt.getKeyChar()) && !Character.isSpaceChar(evt.getKeyChar())) {
            evt.consume();
        } else if (txt_dr_mi.getText().trim().length() == 0 && Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_txt_dr_miKeyTyped

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed

        Gender = "Male";
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        Gender = "Female";
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void txt_dr_StateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dr_StateKeyReleased
        error6.setText("");
    }//GEN-LAST:event_txt_dr_StateKeyReleased

    private void txt_dr_StateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dr_StateKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txt_dr_StateKeyTyped

    private void txt_dr_lnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dr_lnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dr_lnActionPerformed

    private void txt_dr_lnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dr_lnKeyReleased

        error1.setText("");
        //   error1.setVisible(false);
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

    private void txt_dr_fnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dr_fnKeyReleased
        error2.setText("");
        //  error2.setVisible(false);
    }//GEN-LAST:event_txt_dr_fnKeyReleased

    private void txt_dr_fnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dr_fnKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }

        if (!Character.isAlphabetic(evt.getKeyChar()) && !Character.isSpaceChar(evt.getKeyChar())) {
            evt.consume();
        } else if (txt_dr_fn.getText().trim().length() == 0 && Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_txt_dr_fnKeyTyped

    private void txt_dr_EmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dr_EmailKeyReleased
        //   String PATTERN ="^[a-zA-Z0-9]{0,30}{@}[a-zA-Z0-9]{0,10}[a-zA-Z]{0,10}$";
        String PATTERN = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";

        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(txt_dr_Email.getText());
        if (!match.matches()) {
            error15mail.setText("Incorrect format");
        } else {
            error15mail.setText(null);
        }

        error8.setText("");
        error8.setVisible(false);

    }//GEN-LAST:event_txt_dr_EmailKeyReleased

    private void txt_CityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CityKeyReleased
        error11.setText("");
    }//GEN-LAST:event_txt_CityKeyReleased

    private void txt_CityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CityKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txt_CityKeyTyped

    private void txt_noAddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_noAddressKeyReleased
        error9.setText("");
    }//GEN-LAST:event_txt_noAddressKeyReleased

    private void txt_dr_ContactKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dr_ContactKeyReleased

        /*  String PATTERN = "/^[0-9+]+$/";

        Pattern patt= Pattern.compile(PATTERN);
        Matcher match=patt.matcher(txt_App_Email.getText());
        if(!match.matches())
        {
            error16phone.setText("Incorrect format");
        }else
        {
            error16phone.setText(null);
        }
         */
        error16phone.setText("");
        error16phone.setVisible(false);
    }//GEN-LAST:event_txt_dr_ContactKeyReleased

    private void txt_dr_ContactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dr_ContactKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txt_dr_ContactKeyTyped

    private void txt_BrgyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BrgyKeyReleased
        error10.setText("");
    }//GEN-LAST:event_txt_BrgyKeyReleased

    private void txt_App_SchoolKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_App_SchoolKeyReleased
        error13.setText("");
    }//GEN-LAST:event_txt_App_SchoolKeyReleased

    private void txt_App_SchoolKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_App_SchoolKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txt_App_SchoolKeyTyped

    private void txt_App_CourseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_App_CourseKeyReleased
        error14.setText("");
    }//GEN-LAST:event_txt_App_CourseKeyReleased

    private void txt_App_CourseKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_App_CourseKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txt_App_CourseKeyTyped

    private void fillAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillAllActionPerformed
        // combine text

        String a = this.txt_dr_ln.getText();
        String b = this.txt_dr_fn.getText();
        String c = this.txt_dr_Contact.getText();
        String d = this.txt_dr_Email.getText();

        if (a.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your surname");
            error1.setText("Please enter your  Surname");
            error1.setBorder(BorderFactory.createLineBorder(Color.red));
            error1.setVisible(true);
        } else if (b.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your firstname");
            error2.setBorder(BorderFactory.createLineBorder(Color.red));
            error2.setVisible(true);
        } else if (c.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your active mobile number");
            error16phone.setBorder(BorderFactory.createLineBorder(Color.red));
            error16phone.setVisible(true);

        } else if (d.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your active email");
            //   asterisk4.setText("*Dosage required");
            error8.setBorder(BorderFactory.createLineBorder(Color.red));
            error8.setVisible(true);

        } else {
            String Address = txt_noAddress.getText() + " " + txt_Brgy.getText() + " " + txt_City.getText();

            try {

                // inserting data in database
                String query = "insert into Core1_dra_registered (Dr_ID,surname,name,middlename,bod,gender,citizenship,state,civil_status,contact_no,email,address,school,course,date_grad,specialization,dr_pic,status)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                pst = con.prepareStatement(query);

                InputStream img2 = new FileInputStream(new File(imgPath));

                pst.setString(1, txt_R_ID1.getText());
                pst.setString(2, txt_dr_ln.getText());
                pst.setString(3, txt_dr_fn.getText());
                pst.setString(4, txt_dr_mi.getText());
                pst.setString(6, Gender);
                pst.setString(5, ((JTextField) bod.getDateEditor().getUiComponent()).getText());
                pst.setString(7, (String) CitizenShip.getSelectedItem());
                pst.setString(8, txt_dr_State.getText());
                pst.setString(9, (String) CB_Civil_Stat.getSelectedItem());
                pst.setString(10, txt_dr_Contact.getText());
                pst.setString(11, txt_dr_Email.getText());
                pst.setString(12, Address);
                pst.setString(13, txt_App_School.getText());
                pst.setString(14, txt_App_Course.getText());
                pst.setString(15, ((JTextField) DC_Date_Graduated.getDateEditor().getUiComponent()).getText());
                pst.setString(16, (String) specia.getSelectedItem());
                pst.setBinaryStream(17, img2);
                pst.setString(18, "No schedule yet");
                // PlaceHolder();

                pst.execute();
                JOptionPane.showMessageDialog(null, "Doctor successfully Registered");

                int choice1 = JOptionPane.showConfirmDialog(null, "Register another doctor?", "Warning", JOptionPane.YES_NO_OPTION);
                if (choice1 == JOptionPane.YES_OPTION) {
                    txt_dr_ln.setText("");
                    txt_dr_fn.setText("");
                    txt_dr_mi.setText("");
                    bod.setDate(null);
                    CitizenShip.setSelectedItem("Select here");
                    CB_Civil_Stat.setSelectedItem("Select here");
                    txt_dr_State.setText("");
                    txt_dr_Contact.setText("");
                    txt_dr_Email.setText("");
                    txt_noAddress.setText("");
                    txt_Brgy.setText("");
                    txt_City.setText("");
                    txt_App_School.setText("");
                    DC_Date_Graduated.setDate(null);
                    txt_App_Course.setText("");
                    specia.setSelectedItem("Select here");

                    auto_dr_number();
                    setVisible(true);
                } else {
                    txt_dr_ln.setText("");
                    txt_dr_fn.setText("");
                    txt_dr_mi.setText("");
                    bod.setDate(null);
                    CitizenShip.setSelectedItem("Select here");
                    CB_Civil_Stat.setSelectedItem("Select here");
                    txt_dr_State.setText("");
                    txt_dr_Contact.setText("");
                    txt_dr_Email.setText("");
                    txt_noAddress.setText("");
                    txt_Brgy.setText("");
                    txt_City.setText("");
                    txt_App_School.setText("");
                    DC_Date_Graduated.setDate(null);
                    txt_App_Course.setText("");
                    specia.setSelectedItem("Select here");
                    setVisible(false);
                    View_Doctors update = new View_Doctors();
                    update.setVisible(true);

                }

            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, err);

            }

        }
    }//GEN-LAST:event_fillAllActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_Civil_Stat;
    private javax.swing.JComboBox<String> CitizenShip;
    private com.toedter.calendar.JDateChooser DC_Date_Graduated;
    private javax.swing.JLabel ID;
    private javax.swing.JLabel User;
    private com.toedter.calendar.JDateChooser bod;
    private javax.swing.JLabel dr_pic;
    private javax.swing.JLabel error1;
    private javax.swing.JLabel error10;
    private javax.swing.JLabel error11;
    private javax.swing.JLabel error13;
    private javax.swing.JLabel error14;
    private javax.swing.JLabel error15mail;
    private javax.swing.JLabel error16;
    private javax.swing.JLabel error16phone;
    private javax.swing.JLabel error2;
    private javax.swing.JLabel error3;
    private javax.swing.JLabel error5;
    private javax.swing.JLabel error6;
    private javax.swing.JLabel error7;
    private javax.swing.JLabel error8;
    private javax.swing.JLabel error9;
    private rojerusan.RSMaterialButtonRound fillAll;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel pnl_dr_bg;
    private javax.swing.JPanel root;
    private javax.swing.JComboBox<String> specia;
    private javax.swing.JTextField txt_App_Course;
    private javax.swing.JTextField txt_App_School;
    private javax.swing.JTextField txt_Brgy;
    private javax.swing.JTextField txt_City;
    private javax.swing.JTextField txt_R_ID1;
    private javax.swing.JTextField txt_dr_Contact;
    private javax.swing.JTextField txt_dr_Email;
    private javax.swing.JTextField txt_dr_State;
    private javax.swing.JTextField txt_dr_fn;
    private javax.swing.JTextField txt_dr_ln;
    private javax.swing.JTextField txt_dr_mi;
    private javax.swing.JTextField txt_noAddress;
    // End of variables declaration//GEN-END:variables
}
