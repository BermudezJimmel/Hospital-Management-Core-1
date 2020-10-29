package SystemInstance;

import SystemModules.Module1;
import SystemModules.Module2;
import SystemModules.Module3;
import SystemModules.Module4;
import SystemModules.Module5;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class MainScreen extends javax.swing.JFrame {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    CallableStatement cst = null;
    DefaultTableModel mode;
    Module1 m1;
    Module2 m2;
    Module3 m3;
    Module4 m4;
    Module5 m5;
    Home home;
    Dashboard dashboard;
    User userprofile;
    SystemLog systemlog;

    int timecount = 0;

    public MainScreen() {
        initComponents();
        id.setVisible(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/hms50x48.png")).getImage());
        this.setLocationRelativeTo(this);
        this.m1 = new Module1();
        this.m2 = new Module2();
        this.m3 = new Module3();
        this.m4 = new Module4();
        this.m5 = new Module5();

        this.home = new Home();
        this.dashboard = new Dashboard();
        this.userprofile = new User();
        this.systemlog = new SystemLog();

        displayPanel.add(home);
        btn_Home.setForeground(new Color(46, 41, 241));
        ImageIcon IIa = new ImageIcon(getClass().getResource("/Images/btnIndicator2.png"));
        icon_Indicator1.setIcon(IIa);

        new Thread() {
            public void run() {
                while (timecount == 0) {

                    Date t = new Date();
                    Date d = new Date();
                    Date m = new Date();
                    Date y = new Date();

                    SimpleDateFormat sdft = new SimpleDateFormat("hh:mm:ss a");
                    SimpleDateFormat sdfy = new SimpleDateFormat("yyyy");
                    SimpleDateFormat sdfm = new SimpleDateFormat("MMMM");
                    SimpleDateFormat sdfd = new SimpleDateFormat("dd");

                    txt_time.setText(sdft.format(t));
                    txt_month.setText(sdfm.format(m));
                    txt_year.setText(sdfy.format(y));
                    txt_day.setText(sdfd.format(d));
                }

            }
        }.start();
    }

     

    public void Cursor() {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image img = toolkit.getImage("icons8_Hand_Cursor_30px.png");
        Point point = new Point(0, 0);
        Cursor cursor = toolkit.createCustomCursor(img, point, "Cursor");

        setCursor(cursor);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        icon_SystemLogo = new javax.swing.JLabel();
        header = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        Department = new javax.swing.JLabel();
        POSITION = new javax.swing.JLabel();
        txt_user = new javax.swing.JLabel();
        txt_day = new javax.swing.JLabel();
        txt_month = new javax.swing.JLabel();
        txt_year = new javax.swing.JLabel();
        txt_time = new javax.swing.JLabel();
        icon_VerticalSeparator = new javax.swing.JLabel();
        icon_SystemLogo1 = new javax.swing.JLabel();
        btn_Module1 = new javax.swing.JButton();
        btn_Module2 = new javax.swing.JButton();
        btn_Module3 = new javax.swing.JButton();
        btn_Module4 = new javax.swing.JButton();
        btn_Module5 = new javax.swing.JButton();
        btn_Home = new javax.swing.JButton();
        icon_Indicator1 = new javax.swing.JLabel();
        btn_Dashboard = new javax.swing.JButton();
        icon_Indicator2 = new javax.swing.JLabel();
        btn_UserProfile = new javax.swing.JButton();
        icon_Indicator3 = new javax.swing.JLabel();
        btn_SystemLog = new javax.swing.JButton();
        icon_Indicator4 = new javax.swing.JLabel();
        btn_Notifications = new javax.swing.JButton();
        icon_Indicator5 = new javax.swing.JLabel();
        btn_Messages = new javax.swing.JButton();
        btnIndicator6 = new javax.swing.JLabel();
        btn_LogOut = new javax.swing.JButton();
        btn_Help = new javax.swing.JButton();
        btn_About = new javax.swing.JButton();
        btn_Option = new javax.swing.JButton();
        displayPanel = new javax.swing.JPanel();
        txt_Others = new javax.swing.JLabel();
        txt_Help = new javax.swing.JLabel();
        txt_About = new javax.swing.JLabel();
        txt_Option = new javax.swing.JLabel();
        bg_MainScreen = new javax.swing.JLabel();
        imahe = new javax.swing.JLabel();
        emp_ID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setUndecorated(true);
        getContentPane().setLayout(null);

        mainPanel.setLayout(null);

        icon_SystemLogo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        icon_SystemLogo.setForeground(new java.awt.Color(102, 102, 255));
        icon_SystemLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon_SystemLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/System_Logo_50px.png"))); // NOI18N
        mainPanel.add(icon_SystemLogo);
        icon_SystemLogo.setBounds(10, 0, 50, 60);

        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/System_Header1.png"))); // NOI18N
        mainPanel.add(header);
        header.setBounds(0, 0, 1366, 60);

        id.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        id.setForeground(new java.awt.Color(153, 153, 255));
        mainPanel.add(id);
        id.setBounds(80, 20, 80, 20);

        Department.setFont(new java.awt.Font("Dialog", 1, 40)); // NOI18N
        Department.setForeground(new java.awt.Color(102, 102, 255));
        Department.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainPanel.add(Department);
        Department.setBounds(1060, 10, 140, 40);

        POSITION.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        POSITION.setForeground(new java.awt.Color(153, 153, 255));
        POSITION.setText("user");
        mainPanel.add(POSITION);
        POSITION.setBounds(100, 130, 80, 20);

        txt_user.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txt_user.setForeground(new java.awt.Color(153, 153, 255));
        txt_user.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_user.setText("user");
        mainPanel.add(txt_user);
        txt_user.setBounds(20, 340, 150, 20);

        txt_day.setFont(new java.awt.Font("Dialog", 1, 40)); // NOI18N
        txt_day.setForeground(new java.awt.Color(102, 102, 255));
        txt_day.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_day.setText("04");
        mainPanel.add(txt_day);
        txt_day.setBounds(1300, 10, 50, 40);

        txt_month.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_month.setForeground(new java.awt.Color(102, 102, 255));
        txt_month.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_month.setText("December");
        mainPanel.add(txt_month);
        txt_month.setBounds(1210, 10, 80, 20);

        txt_year.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txt_year.setForeground(new java.awt.Color(153, 153, 255));
        txt_year.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_year.setText("2018");
        mainPanel.add(txt_year);
        txt_year.setBounds(1240, 30, 50, 20);

        txt_time.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_time.setForeground(new java.awt.Color(153, 153, 255));
        txt_time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_time.setText(" 12:12 AM");
        mainPanel.add(txt_time);
        txt_time.setBounds(1255, 80, 100, 20);
        txt_time.getAccessibleContext().setAccessibleName("");

        icon_VerticalSeparator.setFont(new java.awt.Font("Dialog", 1, 40)); // NOI18N
        icon_VerticalSeparator.setForeground(new java.awt.Color(0, 204, 204));
        icon_VerticalSeparator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon_VerticalSeparator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/VerticalSeparator.png"))); // NOI18N
        mainPanel.add(icon_VerticalSeparator);
        icon_VerticalSeparator.setBounds(1295, 10, 2, 40);

        icon_SystemLogo1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        icon_SystemLogo1.setForeground(new java.awt.Color(153, 153, 255));
        icon_SystemLogo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon_SystemLogo1.setText("Welcome");
        mainPanel.add(icon_SystemLogo1);
        icon_SystemLogo1.setBounds(10, 130, 90, 20);

        btn_Module1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        btn_Module1.setForeground(new java.awt.Color(51, 51, 51));
        btn_Module1.setText("Patient registration");
        btn_Module1.setBorderPainted(false);
        btn_Module1.setContentAreaFilled(false);
        btn_Module1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Module1.setFocusable(false);
        btn_Module1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_Module1MousePressed(evt);
            }
        });
        btn_Module1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Module1ActionPerformed(evt);
            }
        });
        mainPanel.add(btn_Module1);
        btn_Module1.setBounds(10, 80, 230, 27);

        btn_Module2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        btn_Module2.setForeground(new java.awt.Color(51, 51, 51));
        btn_Module2.setText("Doctors Appointment");
        btn_Module2.setBorderPainted(false);
        btn_Module2.setContentAreaFilled(false);
        btn_Module2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Module2.setFocusable(false);
        btn_Module2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_Module2MousePressed(evt);
            }
        });
        btn_Module2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Module2ActionPerformed(evt);
            }
        });
        mainPanel.add(btn_Module2);
        btn_Module2.setBounds(250, 80, 230, 27);

        btn_Module3.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        btn_Module3.setForeground(new java.awt.Color(51, 51, 51));
        btn_Module3.setText("Outpatient management ");
        btn_Module3.setBorderPainted(false);
        btn_Module3.setContentAreaFilled(false);
        btn_Module3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Module3.setFocusable(false);
        btn_Module3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_Module3MousePressed(evt);
            }
        });
        btn_Module3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Module3ActionPerformed(evt);
            }
        });
        mainPanel.add(btn_Module3);
        btn_Module3.setBounds(490, 80, 230, 27);

        btn_Module4.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        btn_Module4.setForeground(new java.awt.Color(51, 51, 51));
        btn_Module4.setText("Inpatient management");
        btn_Module4.setBorderPainted(false);
        btn_Module4.setContentAreaFilled(false);
        btn_Module4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Module4.setFocusable(false);
        btn_Module4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_Module4MousePressed(evt);
            }
        });
        btn_Module4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Module4ActionPerformed(evt);
            }
        });
        mainPanel.add(btn_Module4);
        btn_Module4.setBounds(730, 80, 230, 27);

        btn_Module5.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        btn_Module5.setForeground(new java.awt.Color(51, 51, 51));
        btn_Module5.setText("Bed and Linen management");
        btn_Module5.setBorderPainted(false);
        btn_Module5.setContentAreaFilled(false);
        btn_Module5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Module5.setFocusable(false);
        btn_Module5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_Module5MousePressed(evt);
            }
        });
        btn_Module5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Module5ActionPerformed(evt);
            }
        });
        mainPanel.add(btn_Module5);
        btn_Module5.setBounds(970, 80, 230, 27);

        btn_Home.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        btn_Home.setForeground(new java.awt.Color(51, 51, 51));
        btn_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Clinic_20px.png"))); // NOI18N
        btn_Home.setText("Home");
        btn_Home.setBorderPainted(false);
        btn_Home.setContentAreaFilled(false);
        btn_Home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Home.setFocusable(false);
        btn_Home.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_Home.setIconTextGap(20);
        btn_Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_HomeMousePressed(evt);
            }
        });
        btn_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HomeActionPerformed(evt);
            }
        });
        mainPanel.add(btn_Home);
        btn_Home.setBounds(0, 370, 200, 29);

        icon_Indicator1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnIndicator1.png"))); // NOI18N
        mainPanel.add(icon_Indicator1);
        icon_Indicator1.setBounds(5, 410, 190, 2);

        btn_Dashboard.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        btn_Dashboard.setForeground(new java.awt.Color(51, 51, 51));
        btn_Dashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Pie_Chart_20px_1.png"))); // NOI18N
        btn_Dashboard.setText("Dashboard");
        btn_Dashboard.setBorderPainted(false);
        btn_Dashboard.setContentAreaFilled(false);
        btn_Dashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Dashboard.setFocusable(false);
        btn_Dashboard.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_Dashboard.setIconTextGap(20);
        btn_Dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_DashboardMousePressed(evt);
            }
        });
        btn_Dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DashboardActionPerformed(evt);
            }
        });
        mainPanel.add(btn_Dashboard);
        btn_Dashboard.setBounds(0, 415, 200, 29);

        icon_Indicator2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnIndicator1.png"))); // NOI18N
        mainPanel.add(icon_Indicator2);
        icon_Indicator2.setBounds(5, 455, 190, 2);

        btn_UserProfile.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        btn_UserProfile.setForeground(new java.awt.Color(51, 51, 51));
        btn_UserProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_User_Groups_20px_1.png"))); // NOI18N
        btn_UserProfile.setText("User Profile");
        btn_UserProfile.setBorderPainted(false);
        btn_UserProfile.setContentAreaFilled(false);
        btn_UserProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_UserProfile.setFocusable(false);
        btn_UserProfile.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_UserProfile.setIconTextGap(20);
        btn_UserProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_UserProfileMousePressed(evt);
            }
        });
        btn_UserProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UserProfileActionPerformed(evt);
            }
        });
        mainPanel.add(btn_UserProfile);
        btn_UserProfile.setBounds(0, 460, 200, 29);

        icon_Indicator3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnIndicator1.png"))); // NOI18N
        mainPanel.add(icon_Indicator3);
        icon_Indicator3.setBounds(5, 500, 190, 2);

        btn_SystemLog.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        btn_SystemLog.setForeground(new java.awt.Color(51, 51, 51));
        btn_SystemLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Index_20px_1.png"))); // NOI18N
        btn_SystemLog.setText("System Log");
        btn_SystemLog.setBorderPainted(false);
        btn_SystemLog.setContentAreaFilled(false);
        btn_SystemLog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_SystemLog.setFocusable(false);
        btn_SystemLog.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_SystemLog.setIconTextGap(20);
        btn_SystemLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_SystemLogMousePressed(evt);
            }
        });
        btn_SystemLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SystemLogActionPerformed(evt);
            }
        });
        mainPanel.add(btn_SystemLog);
        btn_SystemLog.setBounds(0, 505, 200, 29);

        icon_Indicator4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnIndicator1.png"))); // NOI18N
        mainPanel.add(icon_Indicator4);
        icon_Indicator4.setBounds(5, 545, 190, 2);

        btn_Notifications.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        btn_Notifications.setForeground(new java.awt.Color(51, 51, 51));
        btn_Notifications.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Bell_20px.png"))); // NOI18N
        btn_Notifications.setText("Notifications");
        btn_Notifications.setBorderPainted(false);
        btn_Notifications.setContentAreaFilled(false);
        btn_Notifications.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Notifications.setFocusable(false);
        btn_Notifications.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_Notifications.setIconTextGap(20);
        btn_Notifications.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_NotificationsMousePressed(evt);
            }
        });
        btn_Notifications.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NotificationsActionPerformed(evt);
            }
        });
        mainPanel.add(btn_Notifications);
        btn_Notifications.setBounds(0, 550, 200, 29);

        icon_Indicator5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnIndicator1.png"))); // NOI18N
        mainPanel.add(icon_Indicator5);
        icon_Indicator5.setBounds(5, 590, 190, 2);

        btn_Messages.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        btn_Messages.setForeground(new java.awt.Color(51, 51, 51));
        btn_Messages.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Envelope_20px_1.png"))); // NOI18N
        btn_Messages.setText("Messages");
        btn_Messages.setBorderPainted(false);
        btn_Messages.setContentAreaFilled(false);
        btn_Messages.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Messages.setFocusable(false);
        btn_Messages.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_Messages.setIconTextGap(20);
        btn_Messages.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_MessagesMousePressed(evt);
            }
        });
        btn_Messages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MessagesActionPerformed(evt);
            }
        });
        mainPanel.add(btn_Messages);
        btn_Messages.setBounds(0, 595, 200, 29);

        btnIndicator6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnIndicator1.png"))); // NOI18N
        mainPanel.add(btnIndicator6);
        btnIndicator6.setBounds(5, 635, 190, 2);

        btn_LogOut.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        btn_LogOut.setForeground(new java.awt.Color(51, 51, 51));
        btn_LogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Sign_Out_20px_1.png"))); // NOI18N
        btn_LogOut.setText("Log Out");
        btn_LogOut.setBorderPainted(false);
        btn_LogOut.setContentAreaFilled(false);
        btn_LogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_LogOut.setFocusable(false);
        btn_LogOut.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_LogOut.setIconTextGap(20);
        btn_LogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_LogOutMousePressed(evt);
            }
        });
        btn_LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LogOutActionPerformed(evt);
            }
        });
        mainPanel.add(btn_LogOut);
        btn_LogOut.setBounds(0, 643, 200, 29);

        btn_Help.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_Help.setForeground(new java.awt.Color(51, 51, 51));
        btn_Help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Help_20px_1.png"))); // NOI18N
        btn_Help.setToolTipText("Help");
        btn_Help.setBorderPainted(false);
        btn_Help.setContentAreaFilled(false);
        btn_Help.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Help.setFocusPainted(false);
        btn_Help.setHideActionText(true);
        btn_Help.setIconTextGap(20);
        btn_Help.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_HelpMousePressed(evt);
            }
        });
        btn_Help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HelpActionPerformed(evt);
            }
        });
        mainPanel.add(btn_Help);
        btn_Help.setBounds(10, 705, 40, 40);

        btn_About.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_About.setForeground(new java.awt.Color(51, 51, 51));
        btn_About.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_About_20px_1.png"))); // NOI18N
        btn_About.setToolTipText("About");
        btn_About.setBorderPainted(false);
        btn_About.setContentAreaFilled(false);
        btn_About.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_About.setFocusPainted(false);
        btn_About.setHideActionText(true);
        btn_About.setIconTextGap(20);
        btn_About.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_AboutMousePressed(evt);
            }
        });
        btn_About.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AboutActionPerformed(evt);
            }
        });
        mainPanel.add(btn_About);
        btn_About.setBounds(75, 705, 40, 40);

        btn_Option.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_Option.setForeground(new java.awt.Color(51, 51, 51));
        btn_Option.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Services_20px_1.png"))); // NOI18N
        btn_Option.setToolTipText("Option");
        btn_Option.setBorderPainted(false);
        btn_Option.setContentAreaFilled(false);
        btn_Option.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Option.setFocusPainted(false);
        btn_Option.setHideActionText(true);
        btn_Option.setIconTextGap(20);
        btn_Option.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_OptionMousePressed(evt);
            }
        });
        btn_Option.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_OptionActionPerformed(evt);
            }
        });
        mainPanel.add(btn_Option);
        btn_Option.setBounds(140, 705, 40, 40);

        displayPanel.setMaximumSize(new java.awt.Dimension(1162, 652));
        displayPanel.setMinimumSize(new java.awt.Dimension(1162, 652));
        displayPanel.setName(""); // NOI18N
        displayPanel.setLayout(new java.awt.CardLayout());
        mainPanel.add(displayPanel);
        displayPanel.setBounds(204, 115, 1158, 648);

        txt_Others.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        txt_Others.setForeground(new java.awt.Color(153, 153, 255));
        txt_Others.setText("Others");
        mainPanel.add(txt_Others);
        txt_Others.setBounds(10, 689, 50, 18);

        txt_Help.setForeground(new java.awt.Color(51, 51, 51));
        txt_Help.setText("Help");
        mainPanel.add(txt_Help);
        txt_Help.setBounds(21, 740, 21, 14);

        txt_About.setForeground(new java.awt.Color(51, 51, 51));
        txt_About.setText("About");
        mainPanel.add(txt_About);
        txt_About.setBounds(80, 740, 29, 14);

        txt_Option.setForeground(new java.awt.Color(51, 51, 51));
        txt_Option.setText("Option");
        mainPanel.add(txt_Option);
        txt_Option.setBounds(140, 740, 32, 14);

        bg_MainScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/TemplateRework5.png"))); // NOI18N
        mainPanel.add(bg_MainScreen);
        bg_MainScreen.setBounds(0, 0, 1366, 768);

        imahe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainPanel.add(imahe);
        imahe.setBounds(20, 175, 160, 160);

        emp_ID.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        emp_ID.setForeground(new java.awt.Color(153, 153, 255));
        emp_ID.setText("user");
        mainPanel.add(emp_ID);
        emp_ID.setBounds(100, 130, 80, 20);

        getContentPane().add(mainPanel);
        mainPanel.setBounds(0, 0, 1366, 768);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_Module1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Module1ActionPerformed
        ImageIcon ii = new ImageIcon("icons8_Hand_Cursor_30px.png");
        JLabel icon = new JLabel(ii);
        JLabel text = new JLabel("Are you sure you want to move to Module 1?");
        JPanel panel = new JPanel();
        panel.setSize(200, 70);
        panel.setLayout(new BorderLayout());
        panel.add(icon, BorderLayout.WEST);
        panel.add(text, BorderLayout.EAST);

//        JOptionPane.showMessageDialog(null,"","Confirmation", JOptionPane.PLAIN_MESSAGE);
        int a = JOptionPane.showConfirmDialog(null, "Are you sure you want to move to Patient registration?", "Confirmation", JOptionPane.YES_NO_OPTION);
//        int a = JOptionPane.showMessageDialog(null,panel,"Confirmation", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            displayPanel.removeAll();
            displayPanel.add(m1);
            displayPanel.revalidate();
            displayPanel.repaint();

            btn_Module1.setForeground(new Color(46, 41, 241));
            btn_Module2.setForeground(new Color(51, 51, 51));
            btn_Module3.setForeground(new Color(51, 51, 51));
            btn_Module4.setForeground(new Color(51, 51, 51));
            btn_Module5.setForeground(new Color(51, 51, 51));

            ImageIcon IIa = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
            icon_Indicator1.setIcon(IIa);
            ImageIcon IIb = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
            icon_Indicator2.setIcon(IIb);
            ImageIcon IIc = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
            icon_Indicator3.setIcon(IIc);
            ImageIcon IId = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
            icon_Indicator4.setIcon(IId);
            ImageIcon II1 = new ImageIcon(getClass().getResource("/Images/icons8_Clinic_20px_1.png"));
            btn_Home.setIcon(II1);
            btn_Home.setForeground(new Color(51, 51, 51));
            ImageIcon II2 = new ImageIcon(getClass().getResource("/Images/icons8_Pie_Chart_20px_1.png"));
            btn_Dashboard.setIcon(II2);
            btn_Dashboard.setForeground(new Color(51, 51, 51));
            ImageIcon II3 = new ImageIcon(getClass().getResource("/Images/icons8_User_Groups_20px_1.png"));
            btn_UserProfile.setIcon(II3);
            btn_UserProfile.setForeground(new Color(51, 51, 51));
            ImageIcon II4 = new ImageIcon(getClass().getResource("/Images/icons8_Index_20px_1.png"));
            btn_SystemLog.setIcon(II4);
            btn_SystemLog.setForeground(new Color(51, 51, 51));
        } else {

        }
    }//GEN-LAST:event_btn_Module1ActionPerformed
    private void btn_Module2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Module2ActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Are you sure you want to move to Doctors appointment?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            displayPanel.removeAll();
            displayPanel.add(m2);
            displayPanel.revalidate();
            displayPanel.repaint();

            btn_Module2.setForeground(new Color(46, 41, 241));
            btn_Module1.setForeground(new Color(51, 51, 51));
            btn_Module3.setForeground(new Color(51, 51, 51));
            btn_Module4.setForeground(new Color(51, 51, 51));
            btn_Module5.setForeground(new Color(51, 51, 51));

            ImageIcon IIa = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
            icon_Indicator1.setIcon(IIa);
            ImageIcon IIb = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
            icon_Indicator2.setIcon(IIb);
            ImageIcon IIc = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
            icon_Indicator3.setIcon(IIc);
            ImageIcon IId = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
            icon_Indicator4.setIcon(IId);
            ImageIcon II1 = new ImageIcon(getClass().getResource("/Images/icons8_Clinic_20px_1.png"));
            btn_Home.setIcon(II1);
            btn_Home.setForeground(new Color(51, 51, 51));
            ImageIcon II2 = new ImageIcon(getClass().getResource("/Images/icons8_Pie_Chart_20px_1.png"));
            btn_Dashboard.setIcon(II2);
            btn_Dashboard.setForeground(new Color(51, 51, 51));
            ImageIcon II3 = new ImageIcon(getClass().getResource("/Images/icons8_User_Groups_20px_1.png"));
            btn_UserProfile.setIcon(II3);
            btn_UserProfile.setForeground(new Color(51, 51, 51));
            ImageIcon II4 = new ImageIcon(getClass().getResource("/Images/icons8_Index_20px_1.png"));
            btn_SystemLog.setIcon(II4);
            btn_SystemLog.setForeground(new Color(51, 51, 51));
        } else {

        }
    }//GEN-LAST:event_btn_Module2ActionPerformed
    private void btn_Module3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Module3ActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Are you sure you want to move to Outpatient management?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            displayPanel.removeAll();
            displayPanel.add(m3);
            displayPanel.revalidate();
            displayPanel.repaint();

            btn_Module3.setForeground(new Color(46, 41, 241));
            btn_Module1.setForeground(new Color(51, 51, 51));
            btn_Module2.setForeground(new Color(51, 51, 51));
            btn_Module4.setForeground(new Color(51, 51, 51));
            btn_Module5.setForeground(new Color(51, 51, 51));

            ImageIcon IIa = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
            icon_Indicator1.setIcon(IIa);
            ImageIcon IIb = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
            icon_Indicator2.setIcon(IIb);
            ImageIcon IIc = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
            icon_Indicator3.setIcon(IIc);
            ImageIcon IId = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
            icon_Indicator4.setIcon(IId);
            ImageIcon II1 = new ImageIcon(getClass().getResource("/Images/icons8_Clinic_20px_1.png"));
            btn_Home.setIcon(II1);
            btn_Home.setForeground(new Color(51, 51, 51));
            ImageIcon II2 = new ImageIcon(getClass().getResource("/Images/icons8_Pie_Chart_20px_1.png"));
            btn_Dashboard.setIcon(II2);
            btn_Dashboard.setForeground(new Color(51, 51, 51));
            ImageIcon II3 = new ImageIcon(getClass().getResource("/Images/icons8_User_Groups_20px_1.png"));
            btn_UserProfile.setIcon(II3);
            btn_UserProfile.setForeground(new Color(51, 51, 51));
            ImageIcon II4 = new ImageIcon(getClass().getResource("/Images/icons8_Index_20px_1.png"));
            btn_SystemLog.setIcon(II4);
            btn_SystemLog.setForeground(new Color(51, 51, 51));
        } else {

        }
    }//GEN-LAST:event_btn_Module3ActionPerformed
    private void btn_Module4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Module4ActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Are you sure you want to move to Inpatient management?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            displayPanel.removeAll();
            displayPanel.add(m4);
            displayPanel.revalidate();
            displayPanel.repaint();

            btn_Module4.setForeground(new Color(46, 41, 241));
            btn_Module1.setForeground(new Color(51, 51, 51));
            btn_Module2.setForeground(new Color(51, 51, 51));
            btn_Module3.setForeground(new Color(51, 51, 51));
            btn_Module5.setForeground(new Color(51, 51, 51));

            ImageIcon IIa = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
            icon_Indicator1.setIcon(IIa);
            ImageIcon IIb = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
            icon_Indicator2.setIcon(IIb);
            ImageIcon IIc = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
            icon_Indicator3.setIcon(IIc);
            ImageIcon IId = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
            icon_Indicator4.setIcon(IId);
            ImageIcon II1 = new ImageIcon(getClass().getResource("/Images/icons8_Clinic_20px_1.png"));
            btn_Home.setIcon(II1);
            btn_Home.setForeground(new Color(51, 51, 51));
            ImageIcon II2 = new ImageIcon(getClass().getResource("/Images/icons8_Pie_Chart_20px_1.png"));
            btn_Dashboard.setIcon(II2);
            btn_Dashboard.setForeground(new Color(51, 51, 51));
            ImageIcon II3 = new ImageIcon(getClass().getResource("/Images/icons8_User_Groups_20px_1.png"));
            btn_UserProfile.setIcon(II3);
            btn_UserProfile.setForeground(new Color(51, 51, 51));
            ImageIcon II4 = new ImageIcon(getClass().getResource("/Images/icons8_Index_20px_1.png"));
            btn_SystemLog.setIcon(II4);
            btn_SystemLog.setForeground(new Color(51, 51, 51));
        } else {

        }
    }//GEN-LAST:event_btn_Module4ActionPerformed
    private void btn_Module5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Module5ActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Are you sure you want to move to Bed and Linen management?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            displayPanel.removeAll();
            displayPanel.add(m5);
            displayPanel.revalidate();
            displayPanel.repaint();

            btn_Module5.setForeground(new Color(46, 41, 241));
            btn_Module1.setForeground(new Color(51, 51, 51));
            btn_Module2.setForeground(new Color(51, 51, 51));
            btn_Module3.setForeground(new Color(51, 51, 51));
            btn_Module4.setForeground(new Color(51, 51, 51));

            ImageIcon IIa = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
            icon_Indicator1.setIcon(IIa);
            ImageIcon IIb = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
            icon_Indicator2.setIcon(IIb);
            ImageIcon IIc = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
            icon_Indicator3.setIcon(IIc);
            ImageIcon IId = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
            icon_Indicator4.setIcon(IId);
            ImageIcon II1 = new ImageIcon(getClass().getResource("/Images/icons8_Clinic_20px_1.png"));
            btn_Home.setIcon(II1);
            btn_Home.setForeground(new Color(51, 51, 51));
            ImageIcon II2 = new ImageIcon(getClass().getResource("/Images/icons8_Pie_Chart_20px_1.png"));
            btn_Dashboard.setIcon(II2);
            btn_Dashboard.setForeground(new Color(51, 51, 51));
            ImageIcon II3 = new ImageIcon(getClass().getResource("/Images/icons8_User_Groups_20px_1.png"));
            btn_UserProfile.setIcon(II3);
            btn_UserProfile.setForeground(new Color(51, 51, 51));
            ImageIcon II4 = new ImageIcon(getClass().getResource("/Images/icons8_Index_20px_1.png"));
            btn_SystemLog.setIcon(II4);
            btn_SystemLog.setForeground(new Color(51, 51, 51));
        } else {

        }
    }//GEN-LAST:event_btn_Module5ActionPerformed
    private void btn_Module1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_Module1MousePressed
//        btn1.setForeground(new Color(0, 204, 204));
//        btn2.setForeground(new Color(51, 51, 51));
//        btn3.setForeground(new Color(51, 51, 51));
//        btn4.setForeground(new Color(51, 51, 51));
//        btn5.setForeground(new Color(51, 51, 51));
    }//GEN-LAST:event_btn_Module1MousePressed
    private void btn_Module2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_Module2MousePressed
//        btn2.setForeground(new Color(0, 204, 204));
//        btn1.setForeground(new Color(51, 51, 51));
//        btn3.setForeground(new Color(51, 51, 51));
//        btn4.setForeground(new Color(51, 51, 51));
//        btn5.setForeground(new Color(51, 51, 51));
    }//GEN-LAST:event_btn_Module2MousePressed
    private void btn_Module3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_Module3MousePressed
//        btn3.setForeground(new Color(0, 204, 204));
//        btn1.setForeground(new Color(51, 51, 51));
//        btn2.setForeground(new Color(51, 51, 51));
//        btn4.setForeground(new Color(51, 51, 51));
//        btn5.setForeground(new Color(51, 51, 51));
    }//GEN-LAST:event_btn_Module3MousePressed
    private void btn_Module4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_Module4MousePressed
//        btn4.setForeground(new Color(0, 204, 204));
//        btn1.setForeground(new Color(51, 51, 51));
//        btn2.setForeground(new Color(51, 51, 51));
//        btn3.setForeground(new Color(51, 51, 51));
//        btn5.setForeground(new Color(51, 51, 51));
    }//GEN-LAST:event_btn_Module4MousePressed
    private void btn_Module5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_Module5MousePressed
//        btn5.setForeground(new Color(0, 204, 204));
//        btn1.setForeground(new Color(51, 51, 51));
//        btn2.setForeground(new Color(51, 51, 51));
//        btn3.setForeground(new Color(51, 51, 51));
//        btn4.setForeground(new Color(51, 51, 51));
    }//GEN-LAST:event_btn_Module5MousePressed

    private void btn_HomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HomeMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_HomeMousePressed

    private void btn_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HomeActionPerformed
        displayPanel.removeAll();
        displayPanel.add(home);
        displayPanel.revalidate();
        displayPanel.repaint();

        ImageIcon IIa = new ImageIcon(getClass().getResource("/Images/btnIndicator2.png"));
        icon_Indicator1.setIcon(IIa);
        ImageIcon IIb = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
        icon_Indicator2.setIcon(IIb);
        ImageIcon IIc = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
        icon_Indicator3.setIcon(IIc);
        ImageIcon IId = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
        icon_Indicator4.setIcon(IId);
        ImageIcon II1 = new ImageIcon(getClass().getResource("/Images/icons8_Clinic_20px.png"));
        btn_Home.setIcon(II1);
        btn_Home.setForeground(new Color(46, 41, 241));
        btn_Module1.setForeground(new Color(51, 51, 51));
        btn_Module2.setForeground(new Color(51, 51, 51));
        btn_Module3.setForeground(new Color(51, 51, 51));
        btn_Module4.setForeground(new Color(51, 51, 51));
        btn_Module5.setForeground(new Color(51, 51, 51));
        ImageIcon II2 = new ImageIcon(getClass().getResource("/Images/icons8_Pie_Chart_20px_1.png"));
        btn_Dashboard.setIcon(II2);
        btn_Dashboard.setForeground(new Color(51, 51, 51));
        ImageIcon II3 = new ImageIcon(getClass().getResource("/Images/icons8_User_Groups_20px_1.png"));
        btn_UserProfile.setIcon(II3);
        btn_UserProfile.setForeground(new Color(51, 51, 51));
        ImageIcon II4 = new ImageIcon(getClass().getResource("/Images/icons8_Index_20px_1.png"));
        btn_SystemLog.setIcon(II4);
        btn_SystemLog.setForeground(new Color(51, 51, 51));
    }//GEN-LAST:event_btn_HomeActionPerformed

    private void btn_DashboardMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DashboardMousePressed

    }//GEN-LAST:event_btn_DashboardMousePressed

    private void btn_DashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DashboardActionPerformed
        displayPanel.removeAll();
        displayPanel.add(dashboard);
        displayPanel.revalidate();
        displayPanel.repaint();

        ImageIcon IIa = new ImageIcon(getClass().getResource("/Images/btnIndicator2.png"));
        icon_Indicator2.setIcon(IIa);
        ImageIcon IIb = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
        icon_Indicator1.setIcon(IIb);
        ImageIcon IIc = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
        icon_Indicator3.setIcon(IIc);
        ImageIcon IId = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
        icon_Indicator4.setIcon(IId);
        ImageIcon II1 = new ImageIcon(getClass().getResource("/Images/icons8_Pie_Chart_20px.png"));
        btn_Dashboard.setIcon(II1);
        btn_Dashboard.setForeground(new Color(46, 41, 241));
        btn_Module1.setForeground(new Color(51, 51, 51));
        btn_Module2.setForeground(new Color(51, 51, 51));
        btn_Module3.setForeground(new Color(51, 51, 51));
        btn_Module4.setForeground(new Color(51, 51, 51));
        btn_Module5.setForeground(new Color(51, 51, 51));
        ImageIcon II2 = new ImageIcon(getClass().getResource("/Images/icons8_Clinic_20px_1.png"));
        btn_Home.setIcon(II2);
        btn_Home.setForeground(new Color(51, 51, 51));
        ImageIcon II3 = new ImageIcon(getClass().getResource("/Images/icons8_User_Groups_20px_1.png"));
        btn_UserProfile.setIcon(II3);
        btn_UserProfile.setForeground(new Color(51, 51, 51));
        ImageIcon II4 = new ImageIcon(getClass().getResource("/Images/icons8_Index_20px_1.png"));
        btn_SystemLog.setIcon(II4);
        btn_SystemLog.setForeground(new Color(51, 51, 51));
    }//GEN-LAST:event_btn_DashboardActionPerformed

    private void btn_UserProfileMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_UserProfileMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_UserProfileMousePressed

    private void btn_UserProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UserProfileActionPerformed
        displayPanel.removeAll();
        displayPanel.add(userprofile);
        displayPanel.revalidate();
        displayPanel.repaint();

        ImageIcon IIa = new ImageIcon(getClass().getResource("/Images/btnIndicator2.png"));
        icon_Indicator3.setIcon(IIa);
        ImageIcon IIb = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
        icon_Indicator1.setIcon(IIb);
        ImageIcon IIc = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
        icon_Indicator2.setIcon(IIc);
        ImageIcon IId = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
        icon_Indicator4.setIcon(IId);
        ImageIcon II1 = new ImageIcon(getClass().getResource("/Images/icons8_User_Groups_20px.png"));
        btn_UserProfile.setIcon(II1);
        btn_UserProfile.setForeground(new Color(46, 41, 241));
        btn_Module1.setForeground(new Color(51, 51, 51));
        btn_Module2.setForeground(new Color(51, 51, 51));
        btn_Module3.setForeground(new Color(51, 51, 51));
        btn_Module4.setForeground(new Color(51, 51, 51));
        btn_Module5.setForeground(new Color(51, 51, 51));
        ImageIcon II2 = new ImageIcon(getClass().getResource("/Images/icons8_Clinic_20px_1.png"));
        btn_Home.setIcon(II2);
        btn_Home.setForeground(new Color(51, 51, 51));
        ImageIcon II3 = new ImageIcon(getClass().getResource("/Images/icons8_Pie_Chart_20px_1.png"));
        btn_Dashboard.setIcon(II3);
        btn_Dashboard.setForeground(new Color(51, 51, 51));
        ImageIcon II4 = new ImageIcon(getClass().getResource("/Images/icons8_Index_20px_1.png"));
        btn_SystemLog.setIcon(II4);
        btn_SystemLog.setForeground(new Color(51, 51, 51));
    }//GEN-LAST:event_btn_UserProfileActionPerformed

    private void btn_SystemLogMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SystemLogMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_SystemLogMousePressed

    private void btn_SystemLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SystemLogActionPerformed
        displayPanel.removeAll();
        displayPanel.add(systemlog);
        displayPanel.revalidate();
        displayPanel.repaint();

        ImageIcon IIa = new ImageIcon(getClass().getResource("/Images/btnIndicator2.png"));
        icon_Indicator4.setIcon(IIa);
        ImageIcon IIb = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
        icon_Indicator1.setIcon(IIb);
        ImageIcon IIc = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
        icon_Indicator2.setIcon(IIc);
        ImageIcon IId = new ImageIcon(getClass().getResource("/Images/btnIndicator1.png"));
        icon_Indicator3.setIcon(IId);
        ImageIcon II1 = new ImageIcon(getClass().getResource("/Images/icons8_Index_20px.png"));
        btn_SystemLog.setIcon(II1);
        btn_SystemLog.setForeground(new Color(46, 41, 241));
        btn_Module1.setForeground(new Color(51, 51, 51));
        btn_Module2.setForeground(new Color(51, 51, 51));
        btn_Module3.setForeground(new Color(51, 51, 51));
        btn_Module4.setForeground(new Color(51, 51, 51));
        btn_Module5.setForeground(new Color(51, 51, 51));
        ImageIcon II2 = new ImageIcon(getClass().getResource("/Images/icons8_Clinic_20px_1.png"));
        btn_Home.setIcon(II2);
        btn_Home.setForeground(new Color(51, 51, 51));
        ImageIcon II3 = new ImageIcon(getClass().getResource("/Images/icons8_Pie_Chart_20px_1.png"));
        btn_Dashboard.setIcon(II3);
        btn_Dashboard.setForeground(new Color(51, 51, 51));
        ImageIcon II4 = new ImageIcon(getClass().getResource("/Images/icons8_User_Groups_20px_1.png"));
        btn_UserProfile.setIcon(II4);
        btn_UserProfile.setForeground(new Color(51, 51, 51));
    }//GEN-LAST:event_btn_SystemLogActionPerformed

    private void btn_LogOutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LogOutMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_LogOutMousePressed

    private void btn_LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LogOutActionPerformed
               int Logout = JOptionPane.showConfirmDialog(null, "Are you sure you want to Log Out", "Exit", JOptionPane.YES_NO_OPTION);
        if (Logout == 0) {
            try {
                String sql = "select * from HMSdb.dbo.SignUP";

                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();

                if (rs.next()) {

                    String user = txt_user.getText();

                    try {

                        Date d = new Date();
                        SimpleDateFormat sdft = new SimpleDateFormat("hh:mm:ss a");
                        SimpleDateFormat sdfd = new SimpleDateFormat("MMMM dd, yyyy");
                        String activity = "System Log Out";
                        String time = sdft.format(d);
                        String date = sdfd.format(d);

                        String query = "insert into SYS_LOG (ACTIVITY,SYS_USER,DATE,TIME)"
                                + "values(?,?,?,?)";

                        pst = con.prepareStatement(query);

                        pst.setString(1, activity);
                        pst.setString(2, user);
                        pst.setString(3, date);
                        pst.setString(4, time);

                        pst.execute();

                    } catch (Exception e) {
                        System.out.println(e + "Error 2nd try");
                    }
                    LogInPanel lp = new LogInPanel();
                    lp.setVisible(true);
                    dispose();
                }
            } catch (Exception e) {
                System.out.println(e + "Error 1st try");
            }

        } else {

        }
    }//GEN-LAST:event_btn_LogOutActionPerformed

    private void btn_NotificationsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_NotificationsMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_NotificationsMousePressed

    private void btn_NotificationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NotificationsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_NotificationsActionPerformed

    private void btn_MessagesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_MessagesMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_MessagesMousePressed

    private void btn_MessagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MessagesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_MessagesActionPerformed

    private void btn_HelpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HelpMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_HelpMousePressed

    private void btn_HelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_HelpActionPerformed

    private void btn_AboutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AboutMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_AboutMousePressed

    private void btn_AboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AboutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_AboutActionPerformed

    private void btn_OptionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_OptionMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_OptionMousePressed

    private void btn_OptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_OptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_OptionActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel Department;
    public static javax.swing.JLabel POSITION;
    private javax.swing.JLabel bg_MainScreen;
    private javax.swing.JLabel btnIndicator6;
    private javax.swing.JButton btn_About;
    private javax.swing.JButton btn_Dashboard;
    private javax.swing.JButton btn_Help;
    private javax.swing.JButton btn_Home;
    private javax.swing.JButton btn_LogOut;
    private javax.swing.JButton btn_Messages;
    private javax.swing.JButton btn_Module1;
    private javax.swing.JButton btn_Module2;
    private javax.swing.JButton btn_Module3;
    private javax.swing.JButton btn_Module4;
    private javax.swing.JButton btn_Module5;
    private javax.swing.JButton btn_Notifications;
    private javax.swing.JButton btn_Option;
    private javax.swing.JButton btn_SystemLog;
    private javax.swing.JButton btn_UserProfile;
    private javax.swing.JPanel displayPanel;
    public static javax.swing.JLabel emp_ID;
    private javax.swing.JLabel header;
    private javax.swing.JLabel icon_Indicator1;
    private javax.swing.JLabel icon_Indicator2;
    private javax.swing.JLabel icon_Indicator3;
    private javax.swing.JLabel icon_Indicator4;
    private javax.swing.JLabel icon_Indicator5;
    private javax.swing.JLabel icon_SystemLogo;
    private javax.swing.JLabel icon_SystemLogo1;
    private javax.swing.JLabel icon_VerticalSeparator;
    public static javax.swing.JLabel id;
    public static javax.swing.JLabel imahe;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel txt_About;
    private javax.swing.JLabel txt_Help;
    private javax.swing.JLabel txt_Option;
    private javax.swing.JLabel txt_Others;
    private javax.swing.JLabel txt_day;
    private javax.swing.JLabel txt_month;
    private javax.swing.JLabel txt_time;
    public static javax.swing.JLabel txt_user;
    private javax.swing.JLabel txt_year;
    // End of variables declaration//GEN-END:variables
private ImageIcon ImageIcon(byte[] pic) {
        throw new UnsupportedOperationException("Not Supported Yet.");

    }}
