package Module5SubModules;

import AlertsCore1.AWTUtilities;
import AlertsCore1.WarningAlert;
import Notifications.DesktopNotify;
import SystemInstance.MysqlConnect;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class HousekeepingRequest extends javax.swing.JFrame {

    public String imgPath = null;
    DefaultListModel model;
    int enter = 0;
    int enter2 = 0;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    Statement stmt = null;
    private static int CHAR_DELTA = 1000;
    private String m_key;
    private long m_time;
    private static int CHAR_DELTA2 = 1000;
    private String m_key2;
    private long m_time2;
    private int MousePos;

    public HousekeepingRequest() {
        initComponents();
        conn = MysqlConnect.ConnectDB();

        // jList2.setVisible(false);
        AWTUtilities.setOpaque(this, false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height);
        jList2.setVisible(false);
        Searchings();
        model = new DefaultListModel();
        jList2.setModel(model);
        lista();
        removelist();
        Searchings2();
        jList3.setModel(model);
        lista2();
        removelist2();
        CurrentDate();
        tbl();
        auto_id_nga1.setVisible(false);

    }

  

    public void executeSQlQuery(String query, String message) {
        conn = MysqlConnect.ConnectDB();
        try {
            stmt = conn.createStatement();
            if ((stmt.executeUpdate(query)) == 1) {
                // refresh jtable data
                DefaultTableModel model = (DefaultTableModel) pat.getModel();
                model.setRowCount(0);
                tbl();

            } else {
                JOptionPane.showMessageDialog(null, "Data Not " + message);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void tbl() {
        try {

            String q = "select Req_ID as 'Request number' ,Name,item as Item,qty as Quantity from Core1_lm_hk_request";

            pst = conn.prepareStatement(q);

            rs = pst.executeQuery();
            pat.setTableHeader(null);
            pat.setModel(DbUtils.resultSetToTableModel(rs));
            // tblGuest.getColumnModel().getColumn(1).setPreferredWidth(120);
            // tblGuest.getColumnModel().getColumn(2).setPreferredWidth(25);
            pat.setCursor(new Cursor(12));

        } catch (Exception ee) {
            System.out.println(ee);

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
        req_date.setText((buwan) + "/" + (day1) + "/" + year + " " + hour + ":" + mn + day_night);

    }

    public void removelist2() {
        if (txt_item.getText().length() == 0) {
            jList3.setVisible(false);

        }
    }

    private void lista2() {

        try {

            //  String q = "Select concat(FirstName,', ',LastName,' ',MiddleName) as Name FROM Core1_pr_PatientRegistration where FirstName  like '" + txt_dr_ln.getText() + "%' ORDER BY FirstName ";
            // String q = "Select Name FROM HR2_ESS_EmployeeInfo where  Position = 'Housekeeping' and Name  like '" + txt_dr_ln.getText() + "%' ORDER BY Name ";
            String q = "Select Item FROM Core1_lm_inventory where Item  like '" + txt_item.getText() + "%' ORDER BY Item ";

            pst = conn.prepareStatement(q);
            rs = pst.executeQuery();
            model.removeAllElements();
            int vv = 0;
            while (rs.next() & vv < 10) {
                model.addElement(rs.getString("Item"));
                vv++;
            }
            if (vv >= 1) {
                jList3.setVisible(true);
            } else {
                jList3.setVisible(false);

            }
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public void Searchings2() {
        int list2 = jList3.getSelectedIndex();
        if (list2 >= 0) {
            try {

                String q = "Select Name FROM Core1_lm_inventory where Item like '"
                        + "" + txt_item.getText() + "%' ORDER BY Item LIMIT " + list2 + ",1";

                pst = conn.prepareStatement(q);
                rs = pst.executeQuery();

            } catch (Exception e) {
                System.out.println(e);

            }
        }

    }

    public void removelist() {
        if (txt_dr_ln.getText().length() == 0) {
            jList2.setVisible(false);

        }
    }

    private void lista() {

        try {

            //  String q = "Select concat(FirstName,', ',LastName,' ',MiddleName) as Name FROM Core1_pr_PatientRegistration where FirstName  like '" + txt_dr_ln.getText() + "%' ORDER BY FirstName ";
            // String q = "Select Name FROM HR2_ESS_EmployeeInfo where  Position = 'Housekeeping' and Name  like '" + txt_dr_ln.getText() + "%' ORDER BY Name ";
            String q = "Select Name FROM HR2_ESS_EmployeeInfo where Name  like '" + txt_dr_ln.getText() + "%' ORDER BY Name ";

            pst = conn.prepareStatement(q);
            rs = pst.executeQuery();
            model.removeAllElements();
            int v = 0;
            while (rs.next() & v < 10) {
                model.addElement(rs.getString("Name"));
                v++;
            }
            if (v >= 1) {
                jList2.setVisible(true);
            } else {
                jList2.setVisible(false);

            }
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public void Searchings() {
        int list = jList2.getSelectedIndex();
        if (list >= 0) {
            try {

                String q = "Select Name FROM HR2_ESS_EmployeeInfo where Name like '"
                        + "" + txt_dr_ln.getText() + "%' ORDER BY Name LIMIT " + list + ",1";

                pst = conn.prepareStatement(q);
                rs = pst.executeQuery();

            } catch (Exception e) {
                System.out.println(e);

            }
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

        rSPanelImage1 = new rojerusan.RSPanelImage();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        auto_id_nga1 = new javax.swing.JLabel();
        auto_id_nga = new javax.swing.JLabel();
        asterisk11 = new javax.swing.JLabel();
        asterisk10 = new javax.swing.JLabel();
        asterisk9 = new javax.swing.JLabel();
        req_date = new javax.swing.JLabel();
        txt_dr_ln = new app.bolivia.swing.JCTextField();
        txt_item1 = new app.bolivia.swing.JCTextField();
        txt_item = new app.bolivia.swing.JCTextField();
        jList3 = new javax.swing.JList<>();
        jList2 = new javax.swing.JList<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        fillAll1 = new rojerusan.RSMaterialButtonRound();
        jLabel8 = new javax.swing.JLabel();
        scrollPatient = new javax.swing.JScrollPane();
        pat = new rojerusan.RSTableMetro();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        cerrar = new principal.MaterialButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Images/transparent.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        jPanel4.setBorder(dropShadowBorder1);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(auto_id_nga1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 50, 30));
        jPanel4.add(auto_id_nga, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 50, 30));

        asterisk11.setBackground(new java.awt.Color(255, 255, 255));
        asterisk11.setFont(new java.awt.Font("Arial", 3, 9)); // NOI18N
        asterisk11.setForeground(new java.awt.Color(204, 0, 0));
        jPanel4.add(asterisk11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 120, 30));

        asterisk10.setBackground(new java.awt.Color(255, 255, 255));
        asterisk10.setFont(new java.awt.Font("Arial", 3, 9)); // NOI18N
        asterisk10.setForeground(new java.awt.Color(204, 0, 0));
        jPanel4.add(asterisk10, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 250, 30));

        asterisk9.setBackground(new java.awt.Color(255, 255, 255));
        asterisk9.setFont(new java.awt.Font("Arial", 3, 9)); // NOI18N
        asterisk9.setForeground(new java.awt.Color(204, 0, 0));
        jPanel4.add(asterisk9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 250, 30));

        req_date.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        req_date.setForeground(new java.awt.Color(58, 159, 171));
        jPanel4.add(req_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 115, 160, 30));

        txt_dr_ln.setBorder(null);
        txt_dr_ln.setForeground(new java.awt.Color(58, 159, 171));
        txt_dr_ln.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_dr_ln.setPlaceholder("FULLNAME");
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
        jPanel4.add(txt_dr_ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 230, 30));

        txt_item1.setBorder(null);
        txt_item1.setForeground(new java.awt.Color(58, 159, 171));
        txt_item1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_item1.setPlaceholder("QUANTITY");
        txt_item1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_item1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_item1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_item1KeyTyped(evt);
            }
        });
        jPanel4.add(txt_item1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 100, 30));

        txt_item.setBorder(null);
        txt_item.setForeground(new java.awt.Color(58, 159, 171));
        txt_item.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_item.setPlaceholder("SEARCH ITEM");
        txt_item.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_itemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_itemKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_itemKeyTyped(evt);
            }
        });
        jPanel4.add(txt_item, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 230, 30));

        jList3.setToolTipText("");
        jList3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList3MousePressed(evt);
            }
        });
        jList3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jList3KeyReleased(evt);
            }
        });
        jPanel4.add(jList3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 230, -1));

        jList2.setToolTipText("");
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList2MousePressed(evt);
            }
        });
        jList2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jList2KeyReleased(evt);
            }
        });
        jPanel4.add(jList2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 230, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/q_txtfield.png"))); // NOI18N
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 180, 50));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/item_txtfield.png"))); // NOI18N
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 310, 50));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hp_txtfield.png"))); // NOI18N
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 310, 50));

        fillAll1.setText("Print request");
        fillAll1.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        fillAll1.setMaximumSize(new java.awt.Dimension(82, 26));
        fillAll1.setMinimumSize(new java.awt.Dimension(82, 26));
        fillAll1.setPreferredSize(new java.awt.Dimension(88, 28));
        fillAll1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillAll1ActionPerformed(evt);
            }
        });
        jPanel4.add(fillAll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 190, 50));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bday40x40.png"))); // NOI18N
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 40, 40));

        scrollPatient.setBackground(new java.awt.Color(255, 255, 255));
        scrollPatient.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192), 3));

        pat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Item", "Quantity"
            }
        ));
        pat.setToolTipText("");
        pat.setAutoscrolls(false);
        pat.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        pat.setFuenteFilas(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        pat.setFuenteFilasSelect(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        pat.setFuenteHead(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        pat.setGrosorBordeFilas(0);
        pat.setGrosorBordeHead(0);
        pat.setMultipleSeleccion(false);
        pat.getTableHeader().setReorderingAllowed(false);
        pat.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                patAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        pat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                patMouseEntered(evt);
            }
        });
        scrollPatient.setViewportView(pat);

        jPanel4.add(scrollPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 166, 760, 140));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/deleteItem40x40.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 40, 40));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/addItem40x40.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, 40, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 820, 380));

        jPanel3.setBackground(new java.awt.Color(0, 112, 192));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 860, 150));

        jPanel2.setBackground(new java.awt.Color(0, 112, 192));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Housekeeping request");
        jPanel2.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 14, 258, -1));

        cerrar.setBackground(new java.awt.Color(255, 255, 255));
        cerrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 159, 171), 2));
        cerrar.setText("X");
        cerrar.setToolTipText("<html> <head> <style> #contenedor{background:white;color:black; padding-left:10px;padding-right:10px;margin:0; padding-top:5px;padding-bottom:5px;} </style> </head> <body> <h4 id=\"contenedor\">Exit</h4> </body> </html>");
        cerrar.setAlignmentX(5.0F);
        cerrar.setAlignmentY(1.0F);
        cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cerrar.setFont(new java.awt.Font("Roboto Medium", 1, 20)); // NOI18N
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });
        jPanel2.add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 5, 40, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, -1));

        javax.swing.GroupLayout rSPanelImage1Layout = new javax.swing.GroupLayout(rSPanelImage1);
        rSPanelImage1.setLayout(rSPanelImage1Layout);
        rSPanelImage1Layout.setHorizontalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelImage1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        rSPanelImage1Layout.setVerticalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelImage1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(rSPanelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 572, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(rSPanelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_dr_lnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dr_lnKeyTyped
        asterisk9.setVisible(false);
        
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

        jList2.setBounds(80, 90, 130, 230);
    }//GEN-LAST:event_txt_dr_lnKeyTyped

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cerrarActionPerformed

    private void fillAll1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillAll1ActionPerformed

        /*
        try {
            //path of .jrxml
            InputStream in = new FileInputStream(new File("C:\\Users\\iRHONman\\Desktop\\PS1\\Template\\HMSTemplate(Final)\\src"
                    + "\\Module1SubModules\\printIDF.jrxml"));
            //     InputStream in = new FileInputStream(new File("C:\\Users\\iRHONman\\Desktop\\PS1\\Template\\HMSTemplate(Final)\\src"
            //           + "\\Module1SubModules\\raffy.jrxml"));
            JasperDesign jd = JRXmlLoader.load(in);
            String sql = "select LastName,FirstName,MiddleName,Patient_ID,PR_Date,PR_Birthdate,image,PR_Date_Issued,address from Core1_pr_PatientRegistration "
                    + "where Patient_ID= '" + jLabel1.getText() + "' ";
            //  String sql = "select LastName,FirstName from Core1_pr_PatientRegistration";
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql);
            jd.setQuery(newQuery);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            HashMap para = new HashMap();
            JasperPrint j = JasperFillManager.fillReport(jr, para, conn);
            JasperViewer.viewReport(j, false);
            //   OutputStream os = new FileOutputStream(new File("D:\\reports"));
            // JasperExportManager.exportReportToPdfStream(j, os);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }*/

    }//GEN-LAST:event_fillAll1ActionPerformed

    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
        Object obj = evt.getSource();
        if (obj == jList2) {
            txt_dr_ln.setText("" + jList2.getSelectedValue());
            jList2.setVisible(false);
        }
    }//GEN-LAST:event_jList2MouseClicked

    private void jList2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList2KeyPressed
        Object obj = evt.getSource();
        if (obj == jList2) {
            txt_dr_ln.setText("" + jList2.getSelectedValue());
            jList2.setVisible(false);
        }
    }//GEN-LAST:event_jList2KeyPressed

    private void jList2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jList2KeyReleased

    private void txt_dr_lnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dr_lnKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            jList2.requestFocus();
        }
        char ch = evt.getKeyChar();

        //ignore searches for non alpha-numeric characters
        if (!Character.isLetterOrDigit(ch)) {
            return;
        }

        // reset string if too much time has elapsed
        if (m_time + CHAR_DELTA < System.currentTimeMillis()) {
            m_key = "";

        }

        m_time = System.currentTimeMillis();
        m_key += Character.toLowerCase(ch);

        for (int i = 0; i < jList2.getModel().getSize(); i++) {
            String str = ((String) jList2.getModel().getElementAt(i)).toLowerCase();
            if (str.startsWith(m_key)) {
                jList2.setSelectedIndex(i);     //change selected item in list
                jList2.ensureIndexIsVisible(i); //change listbox scroll-position
                break;
            }

        }
    }//GEN-LAST:event_txt_dr_lnKeyPressed

    private void txt_dr_lnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dr_lnKeyReleased
        if (enter == 0) {
            lista();
        } else {
            enter = 0;

        }
        removelist();
    }//GEN-LAST:event_txt_dr_lnKeyReleased

    private void jList2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MousePressed


    }//GEN-LAST:event_jList2MousePressed

    private void txt_itemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_itemKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            jList3.requestFocus();
        }
        char ch = evt.getKeyChar();

        //ignore searches for non alpha-numeric characters
        if (!Character.isLetterOrDigit(ch)) {
            return;
        }

        // reset string if too much time has elapsed
        if (m_time2 + CHAR_DELTA2 < System.currentTimeMillis()) {
            m_key2 = "";

        }

        m_time2 = System.currentTimeMillis();
        m_key2 += Character.toLowerCase(ch);

        for (int i = 0; i < jList3.getModel().getSize(); i++) {
            String str = ((String) jList3.getModel().getElementAt(i)).toLowerCase();
            if (str.startsWith(m_key2)) {
                jList3.setSelectedIndex(i);     //change selected item in list
                jList3.ensureIndexIsVisible(i); //change listbox scroll-position
                break;
            }

        }
    }//GEN-LAST:event_txt_itemKeyPressed

    private void txt_itemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_itemKeyReleased
        if (enter2 == 0) {
            lista2();
        } else {
            enter2 = 0;

        }
        removelist2();
    }//GEN-LAST:event_txt_itemKeyReleased

    private void txt_itemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_itemKeyTyped
                asterisk10.setVisible(false);

        char c = evt.getKeyChar();
        if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }

        if (!Character.isAlphabetic(evt.getKeyChar()) && !Character.isSpaceChar(evt.getKeyChar())) {
            evt.consume();
        } else if (txt_item.getText().trim().length() == 0 && Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }

        jList3.setBounds(490, 90, 70, 230);
    }//GEN-LAST:event_txt_itemKeyTyped

    private void jList3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList3MouseClicked
        Object obj = evt.getSource();
        if (obj == jList3) {
            txt_item.setText("" + jList3.getSelectedValue());
            jList3.setVisible(false);
        }
    }//GEN-LAST:event_jList3MouseClicked

    private void jList3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList3MousePressed

    }//GEN-LAST:event_jList3MousePressed

    private void jList3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList3KeyPressed
        Object obj = evt.getSource();
        if (obj == jList3) {
            txt_item.setText("" + jList3.getSelectedValue());
        }
    }//GEN-LAST:event_jList3KeyPressed

    private void jList3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jList3KeyReleased

    private void txt_item1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_item1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_item1KeyPressed

    private void txt_item1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_item1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_item1KeyReleased

    private void txt_item1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_item1KeyTyped
               asterisk11.setVisible(false);

    }//GEN-LAST:event_txt_item1KeyTyped

    private void patAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_patAncestorAdded

    }//GEN-LAST:event_patAncestorAdded

    private void patMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patMouseClicked
        try {
            int row = pat.getSelectedRow();
            String table_update = (pat.getModel().getValueAt(row, 0).toString());
            String sql = "select * from Core1_lm_hk_request where Req_ID='" + table_update + "'";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                //Display data for update  
                String add0 = rs.getString("Req_ID");
                auto_id_nga1.setText(add0);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_patMouseClicked

    private void patMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patMouseEntered

    }//GEN-LAST:event_patMouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        DefaultTableModel model = (DefaultTableModel) pat.getModel();

        if (txt_dr_ln.getText().isEmpty()) {
            // Validation message. 
            DesktopNotify.showDesktopMessage("INPUT MISSING...", "Please enter your name",
                    DesktopNotify.INPUT_REQUEST, 8000);
            asterisk9.setBorder(BorderFactory.createLineBorder(Color.red));
            asterisk9.setVisible(true);
        } else if (txt_item.getText().isEmpty()) {
            DesktopNotify.showDesktopMessage("INPUT MISSING...", "Please enter item name",
                    DesktopNotify.INPUT_REQUEST, 8000);
            asterisk10.setBorder(BorderFactory.createLineBorder(Color.red));
            asterisk10.setVisible(true);
        } else if (txt_item1.getText().isEmpty()) {
            DesktopNotify.showDesktopMessage("INPUT MISSING...", "Please enter quantity of item",
                    DesktopNotify.INPUT_REQUEST, 8000);
            asterisk11.setBorder(BorderFactory.createLineBorder(Color.red));
            asterisk11.setVisible(true);
        } else {
            try {
                String query = "insert  into Core1_lm_hk_request (Name,item,qty,date_req,status)values(?,?,?,?,?)";

                conn = MysqlConnect.ConnectDB();
                pst = conn.prepareStatement(query);
                pst.setString(1, txt_dr_ln.getText());
                pst.setString(2, txt_item.getText());
                pst.setString(3, txt_item1.getText());
                pst.setString(4, req_date.getText());
                pst.setString(5, "Pending request");

                pst.execute();
                tbl();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        WarningAlert a = new WarningAlert(this, true);
        a.titulo.setText("Delete the item.");
        a.msj.setText("Do you want to continue?");
        a.msj1.setText("deleting item" + txt_item.getText());
        a.setVisible(true);

        String query = "DELETE FROM Core1_lm_hk_request WHERE Req_ID = " + auto_id_nga1.getText();
        executeSQlQuery(query, "");


    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(HousekeepingRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HousekeepingRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HousekeepingRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HousekeepingRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HousekeepingRequest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel asterisk10;
    private javax.swing.JLabel asterisk11;
    private javax.swing.JLabel asterisk9;
    private javax.swing.JLabel auto_id_nga;
    private javax.swing.JLabel auto_id_nga1;
    private principal.MaterialButton cerrar;
    private rojerusan.RSMaterialButtonRound fillAll1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public static rojerusan.RSTableMetro pat;
    private rojerusan.RSPanelImage rSPanelImage1;
    private javax.swing.JLabel req_date;
    public static javax.swing.JScrollPane scrollPatient;
    public static javax.swing.JLabel titulo;
    public static app.bolivia.swing.JCTextField txt_dr_ln;
    public static app.bolivia.swing.JCTextField txt_item;
    public static app.bolivia.swing.JCTextField txt_item1;
    // End of variables declaration//GEN-END:variables
}
