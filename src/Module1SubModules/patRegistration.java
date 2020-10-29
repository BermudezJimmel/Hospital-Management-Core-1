package Module1SubModules;

import Notifications.DesktopNotify;
import SystemInstance.MysqlConnect;
import com.github.sarxos.webcam.Webcam;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import necesario.RSAWTUtilities;
import rojerusan.RSPanelsSlider;

public class patRegistration extends javax.swing.JFrame {

    public String imgPath = null;

    Webcam webcam;
    Boolean isRunning = false;
    private boolean minimize = false;

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    CallableStatement cst = null;
    DefaultTableModel mode;
    String Gender;

    public patRegistration() {
        initComponents();
        con = MysqlConnect.ConnectDB();
        bday.setDateFormatString("MMM dd, yyyy");
        webcam = Webcam.getDefault();
        webcam.setViewSize(new Dimension(320, 240));
        webcam.open();

        RSAWTUtilities.setOpaque(this, false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height);

        this.btnAtras.setEnabled(false);
        CurrentDate();
        reset();
        this.txt_time.setVisible(false);
        this.txtdate2.setVisible(false);
        this.nievel4.setVisible(false);
        this.lblNivel4.setVisible(false);
        this.nievel5.setVisible(false);
        this.lblNivel5.setVisible(false);
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

        txt_time.setText(+hour + ":" + min + " " + day_night);
        txtdate2.setText((buwan) + "/" + (day1) + "/" + year);

    }

    private void reset() {
        Module1SubModules.Variables.PASS = 1;

        this.lblNivel1.setVisible(false);
        this.lblNivel2.setVisible(false);
        this.lblNivel3.setVisible(false);

        this.nievel1.setColorBorde(new Color(0, 204, 0));

        this.line1.setBackground(new Color(0, 112, 192));
        this.nievel2.setColorBorde(new Color(0, 112, 192));

        this.line2.setBackground(new Color(0, 112, 192));
        this.nievel3.setColorBorde(new Color(0, 112, 192));
        this.fname.setText("");
        this.lname.setText("");
        this.mi.setText("");
        this.bday.setDate(null);
        this.adds.setText("");
        this.PhoneNumber.setText("");
        this.MobileNumber.setText("");
        this.occupation.setText("");

        focusLevel1();
        //   this.patient_ID.setVisible(false);
        this.nievel4.setVisible(false);
        this.lblNivel4.setVisible(false);
        this.nievel5.setVisible(false);
        this.lblNivel5.setVisible(false);
    }

    private void focusLevel1() {
        this.lname.requestFocus();
        this.lname.setNextFocusableComponent(fname);
        this.fname.setNextFocusableComponent(mi);
        this.mi.setNextFocusableComponent(bday);

    }

    private void focusLevel2() {
        this.adds.requestFocus();
        this.adds.setNextFocusableComponent(PhoneNumber);
        this.PhoneNumber.setNextFocusableComponent(MobileNumber);
        this.MobileNumber.setNextFocusableComponent(occupation);

    }

    private void focusLevel3() {

        this.txtdate2.requestFocus();
    }

    private void passLevel(int paso) {
        if (paso == 2) {
            this.lblNivel1.setVisible(true);

            this.line1.setBackground(new Color(0, 204, 0));
            this.nievel1.setColorBorde(new Color(0, 204, 0));
        }
        if (paso == 3) {
            this.lblNivel4.setVisible(true);

            this.line2.setBackground(new Color(0, 204, 0));
            this.nievel2.setColorBorde(new Color(0, 204, 0));
        }
        if (paso == 4) {
            this.lblNivel5.setVisible(true);

            //   this.line3.setBackground(new Color(0, 204, 0));
            //  this.nievel4.setColorBorde(new Color(0, 204, 0));
        }
        /*   if (paso == 5) {
            this.lblNivel4.setVisible(true);

            this.line4.setBackground(new Color(0, 204, 0));
            this.nievel5.setColorBorde(new Color(0, 204, 0));
        }
        if (paso == 6) {
            this.lblNivel5.setVisible(true);

            this.line5.setBackground(new Color(0, 204, 0));
            this.nievel6.setColorBorde(new Color(0, 204, 0));
        }
        if (paso == 7) {
            this.lblNivel6.setVisible(true);

            this.line6.setBackground(new Color(0, 204, 0));
            this.nievel7.setColorBorde(new Color(0, 204, 0));
        }
        if (paso == 8) {
            this.lblNivel7.setVisible(true);
        }*/
    }

    private void lvlReturned(int paso) {
        if (paso == 1) {
            this.lblNivel1.setVisible(false);
            this.line1.setBackground(new Color(0, 112, 192));
            this.nievel2.setColorBorde(new Color(0, 112, 192));
        }
        if (paso == 2) {
            this.lblNivel2.setVisible(false);
            this.line2.setBackground(new Color(0, 112, 192));
            this.nievel3.setColorBorde(new Color(0, 112, 192));
        }
        if (paso == 3) {
            this.lblNivel3.setVisible(false);

            this.line2.setBackground(new Color(0, 112, 192));
            this.nievel3.setColorBorde(new Color(0, 112, 192));
        }
        /*  if (paso == 4) {
            this.lblNivel4.setVisible(false);
            this.line4.setBackground(new Color(0, 112, 192));
            this.nievel5.setColorBorde(new Color(0, 112, 192));
        }
        if (paso == 5) {
            this.lblNivel5.setVisible(false);
            this.line5.setBackground(new Color(0, 112, 192));
            this.nievel6.setColorBorde(new Color(0, 112, 192));
        }
        if (paso == 6) {
            this.lblNivel6.setVisible(false);
            this.line6.setBackground(new Color(0, 112, 192));
            this.nievel7.setColorBorde(new Color(0, 112, 192));
        }*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        jButton3 = new javax.swing.JButton();
        imageHolder1 = new javax.swing.JLabel();
        attach_image1 = new javax.swing.JButton();
        path1 = new javax.swing.JTextField();
        rSPanelImage1 = new rojerusan.RSPanelImage();
        jPanel1 = new javax.swing.JPanel();
        cerrar = new principal.MaterialButton();
        lblNivel4 = new javax.swing.JLabel();
        nievel4 = new rojerusan.RSLabelCircleImage();
        lblNivel5 = new javax.swing.JLabel();
        nievel5 = new rojerusan.RSLabelCircleImage();
        lblNivel2 = new javax.swing.JLabel();
        lblNivel3 = new javax.swing.JLabel();
        lblNivel1 = new javax.swing.JLabel();
        line1 = new javax.swing.JPanel();
        line2 = new javax.swing.JPanel();
        nievel1 = new rojerusan.RSLabelCircleImage();
        nievel2 = new rojerusan.RSLabelCircleImage();
        nievel3 = new rojerusan.RSLabelCircleImage();
        rSPanelsSlider1 = new rojerusan.RSPanelsSlider();
        pnlOne = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        newG = new rojerusan.RSButtonHover();
        mi = new rojerusan.RSMetroTextFullPlaceHolder();
        fname = new rojerusan.RSMetroTextFullPlaceHolder();
        lname = new rojerusan.RSMetroTextFullPlaceHolder();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        bday = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        gndr = new app.bolivia.swing.JCTextField();
        bod = new app.bolivia.swing.JCTextField();
        pnlTwo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        adds = new rojerusan.RSMetroTextFullPlaceHolder();
        newG1 = new rojerusan.RSButtonHover();
        newG5 = new rojerusan.RSButtonHover();
        newG2 = new rojerusan.RSButtonHover();
        newG4 = new rojerusan.RSButtonHover();
        jLabel5 = new javax.swing.JLabel();
        MaritalStatus = new rojerusan.RSComboMetro();
        PhoneNumber = new rojerusan.RSMetroTextFullPlaceHolder();
        MobileNumber = new rojerusan.RSMetroTextFullPlaceHolder();
        exCP1 = new javax.swing.JLabel();
        exCP = new javax.swing.JLabel();
        occupation = new rojerusan.RSMetroTextFullPlaceHolder();
        pnlThree = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        imageHolder = new javax.swing.JLabel();
        attach_image = new javax.swing.JButton();
        path = new javax.swing.JTextField();
        txtdate2 = new app.bolivia.swing.JCTextField();
        patient_ID = new app.bolivia.swing.JCTextField();
        pnlCuatro = new javax.swing.JPanel();
        scroll3 = new javax.swing.JScrollPane();
        txtInspeccionGen1 = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        pnlCinco = new javax.swing.JPanel();
        lblFinal = new javax.swing.JLabel();
        btnNuevo = new rojerusan.RSButtonHover();
        iconoFinal = new javax.swing.JLabel();
        btnCerrar = new rojerusan.RSButtonMetro();
        jPanel2 = new javax.swing.JPanel();
        btnAtras = new rojerusan.RSButtonHover();
        btnnxt = new rojerusan.RSButtonHover();
        txt_time = new app.bolivia.swing.JCTextField();
        jLabel8 = new javax.swing.JLabel();

        jDialog1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setBackground(new java.awt.Color(0, 102, 204));
        jButton3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("CAPTURE");
        jButton3.setContentAreaFilled(false);
        jButton3.setOpaque(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jDialog1.getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 130, 30));

        imageHolder1.setBorder(new javax.swing.border.MatteBorder(null));
        jDialog1.getContentPane().add(imageHolder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 330, 160));

        attach_image1.setText("ATTACH IMAGE");
        attach_image1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attach_image1ActionPerformed(evt);
            }
        });
        jDialog1.getContentPane().add(attach_image1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 130, 30));
        jDialog1.getContentPane().add(path1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 310, 30));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Images/transparent.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(1, 113, 124), 5));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cerrar.setBackground(new java.awt.Color(58, 159, 171));
        cerrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 159, 171), 2));
        cerrar.setText("X");
        cerrar.setToolTipText("<html> <head> <style> #contenedor{background:white;color:black; padding-left:10px;padding-right:10px;margin:0; padding-top:5px;padding-bottom:5px;} </style> </head> <body> <h4 id=\"contenedor\">Exit</h4> </body> </html>");
        cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cerrar.setFont(new java.awt.Font("Roboto Medium", 1, 20)); // NOI18N
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });
        jPanel1.add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 40, 40));

        lblNivel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNivel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/check.png"))); // NOI18N
        jPanel1.add(lblNivel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 50, 50));

        nievel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/circle.png"))); // NOI18N
        nievel4.setColorBorde(new java.awt.Color(0, 204, 0));
        jPanel1.add(nievel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 70, 70));

        lblNivel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNivel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/check.png"))); // NOI18N
        jPanel1.add(lblNivel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 50, 50));

        nievel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/circle.png"))); // NOI18N
        nievel5.setColorBorde(new java.awt.Color(0, 204, 0));
        jPanel1.add(nievel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 70, 70));

        lblNivel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblNivel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 50, 50));

        lblNivel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblNivel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 50, 50));

        lblNivel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNivel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/check.png"))); // NOI18N
        jPanel1.add(lblNivel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 50, 50));

        line1.setBackground(new java.awt.Color(0, 112, 192));

        javax.swing.GroupLayout line1Layout = new javax.swing.GroupLayout(line1);
        line1.setLayout(line1Layout);
        line1Layout.setHorizontalGroup(
            line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        line1Layout.setVerticalGroup(
            line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(line1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 46, -1));

        line2.setBackground(new java.awt.Color(0, 112, 192));

        javax.swing.GroupLayout line2Layout = new javax.swing.GroupLayout(line2);
        line2.setLayout(line2Layout);
        line2Layout.setHorizontalGroup(
            line2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        line2Layout.setVerticalGroup(
            line2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(line2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 46, -1));

        nievel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/circle.png"))); // NOI18N
        nievel1.setColorBorde(new java.awt.Color(0, 204, 0));
        jPanel1.add(nievel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 70, 70));

        nievel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/circle.png"))); // NOI18N
        jPanel1.add(nievel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 70, 70));

        nievel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/circle.png"))); // NOI18N
        jPanel1.add(nievel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 70, 70));

        pnlOne.setBackground(new java.awt.Color(255, 255, 255));
        pnlOne.setForeground(new java.awt.Color(0, 112, 192));
        pnlOne.setMinimumSize(new java.awt.Dimension(461, 390));
        pnlOne.setName("pnlOne"); // NOI18N
        pnlOne.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                pnlOneAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        pnlOne.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 112, 192));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("INFORMATION");
        jLabel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        pnlOne.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 50));

        newG.setBackground(new java.awt.Color(255, 255, 255));
        newG.setBorder(null);
        newG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Pat.png"))); // NOI18N
        pnlOne.add(newG, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 47, -1));

        mi.setForeground(new java.awt.Color(1, 113, 124));
        mi.setBorderColor(new java.awt.Color(1, 113, 124));
        mi.setBotonColor(new java.awt.Color(1, 113, 124));
        mi.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        mi.setMayusculas(true);
        mi.setPlaceholder("MIDDLENAME");
        mi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                miKeyTyped(evt);
            }
        });
        pnlOne.add(mi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, -1, -1));

        fname.setForeground(new java.awt.Color(1, 113, 124));
        fname.setBorderColor(new java.awt.Color(1, 113, 124));
        fname.setBotonColor(new java.awt.Color(1, 113, 124));
        fname.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        fname.setMayusculas(true);
        fname.setPlaceholder("FIRSTNAME");
        fname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fnameKeyTyped(evt);
            }
        });
        pnlOne.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, -1, -1));

        lname.setForeground(new java.awt.Color(1, 113, 124));
        lname.setBorderColor(new java.awt.Color(1, 113, 124));
        lname.setBotonColor(new java.awt.Color(1, 113, 124));
        lname.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lname.setMayusculas(true);
        lname.setPlaceholder("LASTNAME");
        lname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lnameKeyTyped(evt);
            }
        });
        pnlOne.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        male.setBackground(new java.awt.Color(1, 113, 124));
        male.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        male.setText("Male");
        male.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        male.setPreferredSize(new java.awt.Dimension(250, 42));
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });
        pnlOne.add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 60, -1));

        female.setBackground(new java.awt.Color(1, 113, 124));
        female.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        female.setText("Female");
        female.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        female.setPreferredSize(new java.awt.Dimension(250, 42));
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });
        pnlOne.add(female, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 70, -1));

        bday.setBackground(new java.awt.Color(1, 113, 124));
        bday.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(1, 113, 124), 2));
        bday.setPreferredSize(new java.awt.Dimension(250, 42));
        bday.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                bdayAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        bday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bdayMousePressed(evt);
            }
        });
        pnlOne.add(bday, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 200, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/female40x40.png"))); // NOI18N
        pnlOne.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 40, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/male40x40.png"))); // NOI18N
        pnlOne.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 40, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bday40x40.png"))); // NOI18N
        pnlOne.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 40, 40));

        gndr.setBorder(null);
        gndr.setForeground(new java.awt.Color(58, 159, 171));
        gndr.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        gndr.setPhColor(new java.awt.Color(0, 112, 192));
        gndr.setPlaceholder("Gender");
        gndr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gndrActionPerformed(evt);
            }
        });
        pnlOne.add(gndr, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 110, 20));

        bod.setBorder(null);
        bod.setForeground(new java.awt.Color(58, 159, 171));
        bod.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bod.setPhColor(new java.awt.Color(0, 112, 192));
        bod.setPlaceholder("Birthdate");
        bod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bodActionPerformed(evt);
            }
        });
        pnlOne.add(bod, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 110, 20));

        rSPanelsSlider1.add(pnlOne, "card10");

        pnlTwo.setBackground(new java.awt.Color(255, 255, 255));
        pnlTwo.setMinimumSize(new java.awt.Dimension(461, 390));
        pnlTwo.setName("pnlTwo"); // NOI18N
        pnlTwo.setPreferredSize(new java.awt.Dimension(461, 390));
        pnlTwo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 112, 192));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("More details");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        pnlTwo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 48));

        adds.setForeground(new java.awt.Color(1, 113, 124));
        adds.setBorderColor(new java.awt.Color(1, 113, 124));
        adds.setBotonColor(new java.awt.Color(1, 113, 124));
        adds.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        adds.setMayusculas(true);
        adds.setPlaceholder("ADDRESS");
        pnlTwo.add(adds, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));

        newG1.setBackground(new java.awt.Color(255, 255, 255));
        newG1.setBorder(null);
        newG1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/adds40x40.png"))); // NOI18N
        pnlTwo.add(newG1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 47, -1));

        newG5.setBackground(new java.awt.Color(255, 255, 255));
        newG5.setBorder(null);
        newG5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pno40x40.png"))); // NOI18N
        pnlTwo.add(newG5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 47, -1));

        newG2.setBackground(new java.awt.Color(255, 255, 255));
        newG2.setBorder(null);
        newG2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cno40x40.png"))); // NOI18N
        pnlTwo.add(newG2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 47, -1));

        newG4.setBackground(new java.awt.Color(255, 255, 255));
        newG4.setBorder(null);
        newG4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/work40x40.png"))); // NOI18N
        pnlTwo.add(newG4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 47, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/martial40x40.png"))); // NOI18N
        pnlTwo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 40, 40));

        MaritalStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Single", "Married", "Widdowed", "Separated", "Divorce" }));
        MaritalStatus.setColorArrow(new java.awt.Color(0, 204, 204));
        MaritalStatus.setColorBorde(new java.awt.Color(0, 153, 153));
        MaritalStatus.setColorFondo(new java.awt.Color(1, 113, 124));
        MaritalStatus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlTwo.add(MaritalStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 250, 40));

        PhoneNumber.setForeground(new java.awt.Color(1, 113, 124));
        PhoneNumber.setBorderColor(new java.awt.Color(1, 113, 124));
        PhoneNumber.setBotonColor(new java.awt.Color(1, 113, 124));
        PhoneNumber.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        PhoneNumber.setMayusculas(true);
        PhoneNumber.setPlaceholder("PHONE NUMBER");
        PhoneNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PhoneNumberKeyTyped(evt);
            }
        });
        pnlTwo.add(PhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, -1));

        MobileNumber.setForeground(new java.awt.Color(1, 113, 124));
        MobileNumber.setBorderColor(new java.awt.Color(1, 113, 124));
        MobileNumber.setBotonColor(new java.awt.Color(1, 113, 124));
        MobileNumber.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        MobileNumber.setMayusculas(true);
        MobileNumber.setPlaceholder("MOBILE NUMBER");
        MobileNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                MobileNumberKeyTyped(evt);
            }
        });
        pnlTwo.add(MobileNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));

        exCP1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        exCP1.setForeground(new java.awt.Color(255, 0, 0));
        exCP1.setText("(e.g., 9359117)");
        pnlTwo.add(exCP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 100, -1));

        exCP.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        exCP.setForeground(new java.awt.Color(255, 0, 0));
        exCP.setText("(e.g., 9123456789)");
        pnlTwo.add(exCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 110, -1));

        occupation.setForeground(new java.awt.Color(1, 113, 124));
        occupation.setBorderColor(new java.awt.Color(1, 113, 124));
        occupation.setBotonColor(new java.awt.Color(1, 113, 124));
        occupation.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        occupation.setMayusculas(true);
        occupation.setPlaceholder("FIRSTNAME");
        occupation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                occupationKeyTyped(evt);
            }
        });
        pnlTwo.add(occupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, -1, -1));

        rSPanelsSlider1.add(pnlTwo, "card3");

        pnlThree.setBackground(new java.awt.Color(255, 255, 255));
        pnlThree.setName("pnlThree"); // NOI18N
        pnlThree.setPreferredSize(new java.awt.Dimension(461, 390));

        jLabel17.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 112, 192));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("CAPTURE IMAGE");
        jLabel17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jButton2.setBackground(new java.awt.Color(0, 102, 204));
        jButton2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CAPTURE");
        jButton2.setContentAreaFilled(false);
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        imageHolder.setBorder(new javax.swing.border.MatteBorder(null));

        attach_image.setText("ATTACH IMAGE");
        attach_image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attach_imageActionPerformed(evt);
            }
        });

        txtdate2.setBorder(null);
        txtdate2.setForeground(new java.awt.Color(58, 159, 171));
        txtdate2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtdate2.setPlaceholder("Current date");
        txtdate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdate2ActionPerformed(evt);
            }
        });

        patient_ID.setBorder(null);
        patient_ID.setForeground(new java.awt.Color(58, 159, 171));
        patient_ID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        patient_ID.setPlaceholder("id");
        patient_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patient_IDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlThreeLayout = new javax.swing.GroupLayout(pnlThree);
        pnlThree.setLayout(pnlThreeLayout);
        pnlThreeLayout.setHorizontalGroup(
            pnlThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThreeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(path, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThreeLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(txtdate2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(attach_image, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(patient_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(pnlThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlThreeLayout.createSequentialGroup()
                    .addGap(90, 90, 90)
                    .addGroup(pnlThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(imageHolder, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlThreeLayout.createSequentialGroup()
                            .addGap(110, 110, 110)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(90, Short.MAX_VALUE)))
        );
        pnlThreeLayout.setVerticalGroup(
            pnlThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThreeLayout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
                .addGroup(pnlThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThreeLayout.createSequentialGroup()
                        .addComponent(attach_image, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThreeLayout.createSequentialGroup()
                        .addGroup(pnlThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtdate2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patient_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)))
                .addComponent(path, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(pnlThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlThreeLayout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addComponent(imageHolder, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(105, Short.MAX_VALUE)))
        );

        rSPanelsSlider1.add(pnlThree, "card8");

        pnlCuatro.setBackground(new java.awt.Color(255, 255, 255));
        pnlCuatro.setName("pnlCuatro"); // NOI18N
        pnlCuatro.setPreferredSize(new java.awt.Dimension(461, 390));

        scroll3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192), 3));

        txtInspeccionGen1.setColumns(20);
        txtInspeccionGen1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtInspeccionGen1.setForeground(new java.awt.Color(0, 112, 192));
        txtInspeccionGen1.setLineWrap(true);
        txtInspeccionGen1.setRows(5);
        txtInspeccionGen1.setMargin(new java.awt.Insets(10, 10, 10, 10));
        txtInspeccionGen1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtInspeccionGen1KeyTyped(evt);
            }
        });
        scroll3.setViewportView(txtInspeccionGen1);

        jLabel16.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 112, 192));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("other");

        javax.swing.GroupLayout pnlCuatroLayout = new javax.swing.GroupLayout(pnlCuatro);
        pnlCuatro.setLayout(pnlCuatroLayout);
        pnlCuatroLayout.setHorizontalGroup(
            pnlCuatroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCuatroLayout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlCuatroLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(scroll3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCuatroLayout.setVerticalGroup(
            pnlCuatroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCuatroLayout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 99, Short.MAX_VALUE))
        );

        rSPanelsSlider1.add(pnlCuatro, "card5");

        pnlCinco.setBackground(new java.awt.Color(255, 255, 255));
        pnlCinco.setMinimumSize(new java.awt.Dimension(452, 395));
        pnlCinco.setName("pnlCinco"); // NOI18N
        pnlCinco.setPreferredSize(new java.awt.Dimension(461, 390));
        pnlCinco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFinal.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        lblFinal.setForeground(new java.awt.Color(0, 112, 192));
        lblFinal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFinal.setText("REGISTRATION SUCCESS");
        pnlCinco.add(lblFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 61, 490, 57));

        btnNuevo.setText("Patient registered");
        btnNuevo.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        pnlCinco.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 235, -1));

        iconoFinal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconoFinal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/success.png"))); // NOI18N
        pnlCinco.add(iconoFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 224, -1));

        rSPanelsSlider1.add(pnlCinco, "card6");

        jPanel1.add(rSPanelsSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 126, 500, 390));

        btnCerrar.setBackground(new java.awt.Color(255, 0, 51));
        btnCerrar.setText("X");
        btnCerrar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnCerrar.setGrosorLinea(3);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(798, 5, 40, 34));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAtras.setBackground(new java.awt.Color(1, 113, 124));
        btnAtras.setText("Back");
        btnAtras.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel2.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 19, 104, -1));

        btnnxt.setBackground(new java.awt.Color(1, 113, 124));
        btnnxt.setText("Next");
        btnnxt.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnnxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnxtActionPerformed(evt);
            }
        });
        jPanel2.add(btnnxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 104, -1));

        txt_time.setBorder(null);
        txt_time.setForeground(new java.awt.Color(58, 159, 171));
        txt_time.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_time.setPlaceholder("Current time");
        txt_time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timeActionPerformed(evt);
            }
        });
        jPanel2.add(txt_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 110, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 503, 510, 70));

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(1, 113, 124));
        jLabel8.setText("Patient registration");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, -1));

        javax.swing.GroupLayout rSPanelImage1Layout = new javax.swing.GroupLayout(rSPanelImage1);
        rSPanelImage1.setLayout(rSPanelImage1Layout);
        rSPanelImage1Layout.setHorizontalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelImage1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        rSPanelImage1Layout.setVerticalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelImage1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtInspeccionGen1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInspeccionGen1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInspeccionGen1KeyTyped

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        try {
            InputStream img2 = new FileInputStream(new File(imgPath));

            String sql = "insert into Core1_pr_PatientRegistration (FirstName,LastName,MiddleName,"
                    + "PR_Gender,PR_Birthdate,"
                    + "PR_MaritalStatus,address,\n"
                    + "PR_PhoneNo,PR_MobileNo,PR_Occupation,\n"
                    + "PR_Time,PR_Date,image,PR_Status) \n"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            pst = con.prepareStatement(sql);
            // pst.setString(1, fname.getText());

            pst.setString(1, fname.getText());
            pst.setString(2, lname.getText());
            pst.setString(3, mi.getText());
            pst.setString(4, Gender);
            pst.setString(5, ((JTextField) bday.getDateEditor().getUiComponent()).getText());
            String value = MaritalStatus.getSelectedItem().toString();
            pst.setString(6, value);
            pst.setString(7, adds.getText());
            pst.setString(8, PhoneNumber.getText());
            pst.setString(9, MobileNumber.getText());
            pst.setString(10, occupation.getText());
            pst.setString(11, txt_time.getText());
            pst.setString(12, txtdate2.getText());
            pst.setBinaryStream(13, img2);
            pst.setString(14, "New Patient");

            pst.execute();

            try {
                InputStream img3 = new FileInputStream(new File(imgPath));
                String query22 = "update Core1_pr_PatientRegistration set  image = ?  where Patient_ID='" + fname.getText() + "' ";

                PreparedStatement ps = con.prepareStatement(query22);

                ps.setBlob(1, img3);

                ps.executeUpdate();
            } catch (Exception e) {

            }

        } catch (Exception e) {
            //  
            //"Not Saved!, please check your remaining filled"
        }
        DesktopNotify.showDesktopMessage("REGISTRATION SUCCESSFULLY...", "You can reserve appointment to ON DUTY  Doctors",
                DesktopNotify.SUCCESS, 8000);

        rSPanelsSlider1.slidPanel(2, pnlOne, RSPanelsSlider.direct.Right);
        this.btnAtras.setEnabled(false);
        this.btnnxt.setVisible(true);
        this.btnAtras.setVisible(true);
        this.MaritalStatus.setSelectedItem("Single");
        this.male.setSelected(false);
        this.female.setSelected(false);
        reset();

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void pnlOneAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_pnlOneAncestorAdded

    }//GEN-LAST:event_pnlOneAncestorAdded

    private void txtdate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdate2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdate2ActionPerformed

    private void btnnxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnxtActionPerformed
        if (Module1SubModules.Variables.PASS < 9 && Module1SubModules.Variables.PASS > 0) {
            if (verificoNivel(Module1SubModules.Variables.PASS)) {
                Module1SubModules.Variables.PASS++;
                if (Module1SubModules.Variables.PASS == 2) {
                    rSPanelsSlider1.slidPanel(2, pnlTwo, RSPanelsSlider.direct.Right);
                    this.btnAtras.setEnabled(true);
                    passLevel(2);
                    focusLevel2();

                }
                if (Module1SubModules.Variables.PASS == 3) {
                    rSPanelsSlider1.slidPanel(2, pnlThree, RSPanelsSlider.direct.Right);

                    passLevel(3);
                    focusLevel3();
                    //   this.btnnxt.setVisible(false);

                }
                /*  if (pacientes.Variables.PASO == 4) {
                    rSPanelsSlider1.slidPanel(2, pnlCuatro, RSPanelsSlider.direct.Right);
                    passLevel(4);
                }*/
                if (Module1SubModules.Variables.PASS == 4) {
                    rSPanelsSlider1.slidPanel(2, pnlCinco, RSPanelsSlider.direct.Right);
                    // passLevel(4);
                    this.btnnxt.setText("Register");

                    registrarTodo();
                    this.btnNuevo.requestFocus();
                    this.nievel4.setVisible(true);
                    this.lblNivel4.setVisible(true);
                    this.nievel5.setVisible(true);
                    this.lblNivel5.setVisible(true);

                }

                /* if (pacientes.Variables.PASO == 8) {
                    registrarTodo();
                    this.btnNuevo.requestFocus();
                }*/
            } else {

                DesktopNotify.showDesktopMessage("INPUT MISSING...", "Please fill all missing fields to proceed the registration.",
                        DesktopNotify.INPUT_REQUEST, 8000);

            }
        }
    }//GEN-LAST:event_btnnxtActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        if (Module1SubModules.Variables.PASS < 9 && Module1SubModules.Variables.PASS > 0) {
            Module1SubModules.Variables.PASS--;
            if (Module1SubModules.Variables.PASS == 1) {
                rSPanelsSlider1.slidPanel(2, pnlOne, RSPanelsSlider.direct.Left);
                lvlReturned(1);
                this.btnAtras.setEnabled(false);
                focusLevel1();
                this.patient_ID.setVisible(false);
                this.nievel4.setVisible(false);
                this.lblNivel4.setVisible(false);
                this.nievel5.setVisible(false);
                this.lblNivel5.setVisible(false);
            }
            if (Module1SubModules.Variables.PASS == 2) {
                rSPanelsSlider1.slidPanel(2, pnlTwo, RSPanelsSlider.direct.Left);
                lvlReturned(2);
                focusLevel2();

            }
            /*  if (systemtemplatebsit4109.module1.submodules.Variables.PASO == 3) {
                rSPanelsSlider1.slidPanel(2, pnlThree, RSPanelsSlider.direct.Left);
                lvlReturned(3);
                focusNivel3();
            }*/
            if (Module1SubModules.Variables.PASS == 4) {
                rSPanelsSlider1.slidPanel(2, pnlCuatro, RSPanelsSlider.direct.Left);
                lvlReturned(4);
                this.btnnxt.setText("Register");
                //     focusNivel4();
            }
            if (Module1SubModules.Variables.PASS == 5) {
                rSPanelsSlider1.slidPanel(2, pnlCinco, RSPanelsSlider.direct.Left);
                lvlReturned(5);

                //    focusNivel5();
            }

        }
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void txt_timeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timeActionPerformed

    private void patient_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patient_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patient_IDActionPerformed

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cerrarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (!isRunning) {
            isRunning = true;
            new VideoFeedTaker().start();

        } else {
            isRunning = false;
            Webcam webcam = Webcam.getDefault();
            webcam.open();
            try {
                ImageIO.write(webcam.getImage(), "JPG", new File("Patient.jpg"));
            } catch (IOException ex) {
                Logger.getLogger(patRegistration.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void attach_imageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attach_imageActionPerformed
        /*  JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        path.setText(filename);

        try {
            File image = new File(filename);
            FileInputStream fis = new FileInputStream(image);

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];

            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);

            }
            person_image = bos.toByteArray();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);;
        }*/
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
            Image newImg = img.getScaledInstance(imageHolder.getWidth(), imageHolder.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon newImc = new ImageIcon(newImg);
            imageHolder.setIcon(newImc);

        } else if (result == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "No Images Selected");

        }
    }//GEN-LAST:event_attach_imageActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void attach_image1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attach_image1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_attach_image1ActionPerformed

    private void miKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_miKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_miKeyTyped

    private void fnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fnameKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }

        if (!Character.isAlphabetic(evt.getKeyChar()) && !Character.isSpaceChar(evt.getKeyChar())) {
            evt.consume();
        } else if (fname.getText().trim().length() == 0 && Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_fnameKeyTyped

    private void lnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lnameKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_lnameKeyTyped

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed

        Gender = "Male";
    }//GEN-LAST:event_maleActionPerformed

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        Gender = "Female";
    }//GEN-LAST:event_femaleActionPerformed

    private void bdayAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_bdayAncestorAdded

        //    d.setText("Todaydate"+((JTextField) bday.getDateEditor().getUiComponent()).getText());
    }//GEN-LAST:event_bdayAncestorAdded

    private void bdayMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bdayMousePressed

        // TODO add your handling code here:
    }//GEN-LAST:event_bdayMousePressed

    private void gndrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gndrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gndrActionPerformed

    private void bodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bodActionPerformed

    private void PhoneNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PhoneNumberKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }
        String a = this.PhoneNumber.getText();
        if (a.isEmpty()) {
            exCP1.setVisible(true);
        } else {
            exCP1.setVisible(false);
        }
    }//GEN-LAST:event_PhoneNumberKeyTyped

    private void MobileNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MobileNumberKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }

        String a = this.MobileNumber.getText();
        if (a.isEmpty()) {
            exCP.setVisible(true);
        } else {
            exCP.setVisible(false);
        }
    }//GEN-LAST:event_MobileNumberKeyTyped

    private void occupationKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_occupationKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_occupationKeyTyped

    private boolean verificoNivel(int nivel) {
        if (nivel == 1) {
            if (lname.getText().length() == 0
                    || fname.getText().length() == 0
                    || mi.getText().length() == 0) {

                return false;
            } else {
                return true;
            }
        }

        if (nivel == 2) {
            if (adds.getText().length() == 0
                    || PhoneNumber.getText().length() == 0
                    || MobileNumber.getText().length() == 0
                    || occupation.getText().length() == 0) {

                return false;
            } else {
                return true;
            }
        }

        if (nivel == 3) {
            if (txtdate2.getText().length() == 0) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

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
            java.util.logging.Logger.getLogger(patRegistration.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(patRegistration.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(patRegistration.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(patRegistration.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new patRegistration().setVisible(true);
            }
        });
    }

    class VideoFeedTaker extends Thread {

        @Override
        public void run() {
            while (isRunning) {
                try {
                    Image image = webcam.getImage();
                    imageHolder.setIcon(new ImageIcon(image));
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(patRegistration.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSComboMetro MaritalStatus;
    private rojerusan.RSMetroTextFullPlaceHolder MobileNumber;
    private rojerusan.RSMetroTextFullPlaceHolder PhoneNumber;
    private rojerusan.RSMetroTextFullPlaceHolder adds;
    private javax.swing.JButton attach_image;
    private javax.swing.JButton attach_image1;
    private com.toedter.calendar.JDateChooser bday;
    public static app.bolivia.swing.JCTextField bod;
    private rojerusan.RSButtonHover btnAtras;
    private rojerusan.RSButtonMetro btnCerrar;
    private rojerusan.RSButtonHover btnNuevo;
    private rojerusan.RSButtonHover btnnxt;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private principal.MaterialButton cerrar;
    private javax.swing.JLabel exCP;
    private javax.swing.JLabel exCP1;
    private javax.swing.JRadioButton female;
    private rojerusan.RSMetroTextFullPlaceHolder fname;
    public static app.bolivia.swing.JCTextField gndr;
    private javax.swing.JLabel iconoFinal;
    private javax.swing.JLabel imageHolder;
    private javax.swing.JLabel imageHolder1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblFinal;
    private javax.swing.JLabel lblNivel1;
    private javax.swing.JLabel lblNivel2;
    private javax.swing.JLabel lblNivel3;
    private javax.swing.JLabel lblNivel4;
    private javax.swing.JLabel lblNivel5;
    private javax.swing.JPanel line1;
    private javax.swing.JPanel line2;
    private rojerusan.RSMetroTextFullPlaceHolder lname;
    private javax.swing.JRadioButton male;
    private rojerusan.RSMetroTextFullPlaceHolder mi;
    private rojerusan.RSButtonHover newG;
    private rojerusan.RSButtonHover newG1;
    private rojerusan.RSButtonHover newG2;
    private rojerusan.RSButtonHover newG4;
    private rojerusan.RSButtonHover newG5;
    private rojerusan.RSLabelCircleImage nievel1;
    private rojerusan.RSLabelCircleImage nievel2;
    private rojerusan.RSLabelCircleImage nievel3;
    private rojerusan.RSLabelCircleImage nievel4;
    private rojerusan.RSLabelCircleImage nievel5;
    private rojerusan.RSMetroTextFullPlaceHolder occupation;
    private javax.swing.JTextField path;
    private javax.swing.JTextField path1;
    public static app.bolivia.swing.JCTextField patient_ID;
    private javax.swing.JPanel pnlCinco;
    private javax.swing.JPanel pnlCuatro;
    private javax.swing.JPanel pnlOne;
    private javax.swing.JPanel pnlThree;
    private javax.swing.JPanel pnlTwo;
    private rojerusan.RSPanelImage rSPanelImage1;
    private rojerusan.RSPanelsSlider rSPanelsSlider1;
    private javax.swing.JScrollPane scroll3;
    private javax.swing.JTextArea txtInspeccionGen1;
    public static app.bolivia.swing.JCTextField txt_time;
    public static app.bolivia.swing.JCTextField txtdate2;
    // End of variables declaration//GEN-END:variables
 private void registrarTodo() {
        int errores = 0;

        if (errores == 0) {
            this.btnnxt.setVisible(false);
            this.btnAtras.setVisible(false);
            passLevel(5);
            rSPanelsSlider1.slidPanel(2, pnlCinco, RSPanelsSlider.direct.Right);
            this.btnnxt.setText("NEXT");

        }
    }
    private ImageIcon format = null;
    String filename = null;
    int s = 0;
    byte[] person_image = null;
}
