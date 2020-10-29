/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module1SubModules;

import SystemInstance.MysqlConnect;
import java.awt.Cursor;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author jerome
 */
public final class Patientregistration extends javax.swing.JPanel {

    DefaultListModel model;
    int enter = 0;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    Statement stmt = null;
    private static int CHAR_DELTA = 1000;
    private String m_key;
    private long m_time;
    private int MousePos;

    public Patientregistration() {
        initComponents();
        conn = MysqlConnect.ConnectDB();
        PatientTable();
        PatientCount();

        this.cbFilter.setCursor(new Cursor(12));
        this.menuTomer.add(pnelTomer);

        jList2.setVisible(false);
        Searchings();
        model = new DefaultListModel();
        jList2.setModel(model);
        lista();
        removelist();
        int timecount = 0;
        new Thread() {

            public void run() {
                while (timecount == 0) {
                    Calendar cal = new GregorianCalendar();

                    int hour = cal.get(Calendar.HOUR);
                    int min = cal.get(Calendar.MINUTE);
                    int sec = cal.get(Calendar.SECOND);
                    int AM_PM = cal.get(Calendar.AM_PM);

                    String day_night = "";

                    if (AM_PM == 1) {
                        day_night = "PM";
                    } else {
                        day_night = "AM";
                    }
                    String count = hour + ":" + min + ":" + sec + " " + day_night;

                }
            }
        }.start();

    }

    public void PatientTable() {

        try {

            String sql = "select Patient_ID as ID,concat(LastName,', ',FirstName,' ',MiddleName) as Name,PR_Gender as Gender,PR_Date as 'Date registered'  from Core1_pr_PatientRegistration";
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            pat.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void PatientCount() {
        try {

            String q = "Select Count(*) from  Core1_PR_PatientRegistration ";
            conn = MysqlConnect.ConnectDB();
            pst = conn.prepareStatement(q);
            rs = pst.executeQuery();
            if (rs.next()) {
                String total = rs.getString("");
                PatientCount.setText(total);
            }
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    private void update() {

        try {
            String sql = "select Patient_ID as ID,concat(LastName,', ',FirstName,' ',MiddleName) as Name,PR_Gender as Gender,PR_Date as 'Date registered'  from Core1_pr_PatientRegistration";
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            pat.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void update2() {

        try {
            String sql = "select patient_ID as ID,name as Patient,gender as Gender,date_undergo as  Date,patient_type as Status  from Core1_PR_Overview where patient_type='Inpatient'";
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            pat.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void update3() {

        try {
            String sql = "select patient_ID as ID,name as Patient,gender as Gender,date_undergo as  Date,patient_type as Status  from Core1_PR_Overview where patient_type='Outpatient'";
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            pat.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void removelist() {
        if (txt_dr_ln.getText().length() == 0) {
            jList2.setVisible(false);

        }
    }

    private void lista() {

        try {

            String q = "Select concat(LastName,', ',FirstName,' ',MiddleName) as Name FROM Core1_pr_PatientRegistration where FirstName  like '" + txt_dr_ln.getText() + "%' ORDER BY FirstName ";

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

                String q = "Select LastName FROM Core1_pr_PatientRegistration where LastName like '"
                        + "" + txt_dr_ln.getText() + "%' ORDER BY LastName LIMIT " + list + ",1";

                pst = conn.prepareStatement(q);
                rs = pst.executeQuery();

            } catch (Exception e) {
                System.out.println(e);

            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuTomer = new rojerusan.RSPopuMenu();
        pnelTomer = new javax.swing.JPanel();
        btnUpdate = new rojerusan.RSButtonPane();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnDel = new rojerusan.RSButtonPane();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnView = new rojerusan.RSButtonPane();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        root = new javax.swing.JPanel();
        fillAll2 = new rojerusan.RSMaterialButtonRound();
        fillAll1 = new rojerusan.RSMaterialButtonRound();
        cbFilter = new rojerusan.RSComboMetro();
        fillOpd = new rojerusan.RSMaterialButtonRound();
        fillIpd = new rojerusan.RSMaterialButtonRound();
        fillAll = new rojerusan.RSMaterialButtonRound();
        btnAddPat = new rojerusan.RSButtonPane();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        PatientCount = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        txt_dr_ln = new rojerusan.RSMetroTextFullPlaceHolder();
        jLabel21 = new javax.swing.JLabel();
        jList2 = new javax.swing.JList<>();
        jSeparator3 = new javax.swing.JSeparator();
        scrollPatient = new javax.swing.JScrollPane();
        pat = new rojerusan.RSTableMetro();

        pnelTomer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setColorHover(new java.awt.Color(240, 240, 240));
        btnUpdate.setColorNormal(new java.awt.Color(255, 255, 255));
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnUpdateMousePressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 112, 192));
        jLabel9.setText("Update");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnUpdate.png"))); // NOI18N

        javax.swing.GroupLayout btnUpdateLayout = new javax.swing.GroupLayout(btnUpdate);
        btnUpdate.setLayout(btnUpdateLayout);
        btnUpdateLayout.setHorizontalGroup(
            btnUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnUpdateLayout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
            .addGroup(btnUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnUpdateLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(185, Short.MAX_VALUE)))
        );
        btnUpdateLayout.setVerticalGroup(
            btnUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addGroup(btnUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnelTomer.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 235, -1));

        btnDel.setBackground(new java.awt.Color(255, 255, 255));
        btnDel.setColorHover(new java.awt.Color(240, 240, 240));
        btnDel.setColorNormal(new java.awt.Color(255, 255, 255));
        btnDel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDelMousePressed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 112, 192));
        jLabel13.setText("Print");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/print40x40.png"))); // NOI18N

        javax.swing.GroupLayout btnDelLayout = new javax.swing.GroupLayout(btnDel);
        btnDel.setLayout(btnDelLayout);
        btnDelLayout.setHorizontalGroup(
            btnDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnDelLayout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
            .addGroup(btnDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnDelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(185, Short.MAX_VALUE)))
        );
        btnDelLayout.setVerticalGroup(
            btnDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addGroup(btnDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnelTomer.add(btnDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 235, -1));

        btnView.setBackground(new java.awt.Color(255, 255, 255));
        btnView.setColorHover(new java.awt.Color(240, 240, 240));
        btnView.setColorNormal(new java.awt.Color(255, 255, 255));
        btnView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnViewMousePressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 112, 192));
        jLabel15.setText("Refresh");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/refresh40x40.png"))); // NOI18N

        javax.swing.GroupLayout btnViewLayout = new javax.swing.GroupLayout(btnView);
        btnView.setLayout(btnViewLayout);
        btnViewLayout.setHorizontalGroup(
            btnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnViewLayout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
            .addGroup(btnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(185, Short.MAX_VALUE)))
        );
        btnViewLayout.setVerticalGroup(
            btnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addGroup(btnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnelTomer.add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 235, -1));

        root.setBackground(new java.awt.Color(255, 255, 255));
        root.setLayout(null);

        fillAll2.setText("Update Information");
        fillAll2.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        fillAll2.setMaximumSize(new java.awt.Dimension(82, 26));
        fillAll2.setMinimumSize(new java.awt.Dimension(82, 26));
        fillAll2.setPreferredSize(new java.awt.Dimension(88, 28));
        fillAll2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillAll2ActionPerformed(evt);
            }
        });
        root.add(fillAll2);
        fillAll2.setBounds(10, 460, 170, 40);

        fillAll1.setText("PRINT ID");
        fillAll1.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        fillAll1.setMaximumSize(new java.awt.Dimension(82, 26));
        fillAll1.setMinimumSize(new java.awt.Dimension(82, 26));
        fillAll1.setPreferredSize(new java.awt.Dimension(88, 28));
        fillAll1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillAll1ActionPerformed(evt);
            }
        });
        root.add(fillAll1);
        fillAll1.setBounds(20, 500, 150, 40);

        cbFilter.setEditable(true);
        cbFilter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Today", "Weekly", "Monthly", "Yearly" }));
        cbFilter.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        cbFilter.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbFilterPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cbFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFilterActionPerformed(evt);
            }
        });
        root.add(cbFilter);
        cbFilter.setBounds(950, 80, 100, 32);

        fillOpd.setText("inpatient");
        fillOpd.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        fillOpd.setMaximumSize(new java.awt.Dimension(82, 26));
        fillOpd.setMinimumSize(new java.awt.Dimension(82, 26));
        fillOpd.setPreferredSize(new java.awt.Dimension(88, 28));
        fillOpd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillOpdActionPerformed(evt);
            }
        });
        root.add(fillOpd);
        fillOpd.setBounds(610, 80, 100, 40);

        fillIpd.setText("outpatient");
        fillIpd.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        fillIpd.setMaximumSize(new java.awt.Dimension(82, 26));
        fillIpd.setMinimumSize(new java.awt.Dimension(82, 26));
        fillIpd.setPreferredSize(new java.awt.Dimension(88, 28));
        fillIpd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillIpdActionPerformed(evt);
            }
        });
        root.add(fillIpd);
        fillIpd.setBounds(710, 80, 100, 40);

        fillAll.setText("All");
        fillAll.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        fillAll.setMaximumSize(new java.awt.Dimension(82, 26));
        fillAll.setMinimumSize(new java.awt.Dimension(82, 26));
        fillAll.setPreferredSize(new java.awt.Dimension(88, 28));
        fillAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillAllActionPerformed(evt);
            }
        });
        root.add(fillAll);
        fillAll.setBounds(510, 80, 100, 40);

        btnAddPat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAddPatMousePressed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/addPat36x36.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel11MousePressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Add patient");

        javax.swing.GroupLayout btnAddPatLayout = new javax.swing.GroupLayout(btnAddPat);
        btnAddPat.setLayout(btnAddPatLayout);
        btnAddPatLayout.setHorizontalGroup(
            btnAddPatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAddPatLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel11)
                .addGap(0, 0, 0)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
        );
        btnAddPatLayout.setVerticalGroup(
            btnAddPatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        root.add(btnAddPat);
        btnAddPat.setBounds(210, 80, 130, 40);

        jLabel43.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel43.setText("Filter patient by:");
        root.add(jLabel43);
        jLabel43.setBounds(830, 80, 120, 30);

        PatientCount.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PatientCount.setForeground(new java.awt.Color(204, 0, 0));
        PatientCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PatientCount.setText("0");
        PatientCount.setToolTipText("");
        root.add(PatientCount);
        PatientCount.setBounds(440, 80, 40, 40);

        jLabel42.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel42.setText("Total Patients:");
        root.add(jLabel42);
        jLabel42.setBounds(350, 80, 100, 40);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        root.add(jPanel3);
        jPanel3.setBounds(950, 80, 230, 0);

        jSeparator2.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator2.setForeground(new java.awt.Color(0, 102, 102));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        root.add(jSeparator2);
        jSeparator2.setBounds(820, 80, 10, 40);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        txt_dr_ln.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txt_dr_ln.setPlaceholder("Search by patient name");
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

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/old1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(txt_dr_ln, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(935, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(txt_dr_ln, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        root.add(jPanel1);
        jPanel1.setBounds(0, 0, 1166, 50);

        jList2.setToolTipText("");
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
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
        root.add(jList2);
        jList2.setBounds(20, 50, 170, 0);

        jSeparator3.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator3.setForeground(new java.awt.Color(0, 102, 102));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        root.add(jSeparator3);
        jSeparator3.setBounds(500, 80, 10, 40);

        scrollPatient.setBackground(new java.awt.Color(255, 255, 255));
        scrollPatient.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192), 3));

        pat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(212, Short.MAX_VALUE)
                .addComponent(scrollPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 944, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(root, javax.swing.GroupLayout.PREFERRED_SIZE, 1166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(scrollPatient, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                .addGap(29, 29, 29))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(root, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

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
        }

    }//GEN-LAST:event_jList2KeyPressed

    private void jList2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jList2KeyReleased

    private void txt_dr_lnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dr_lnActionPerformed
        jList2.setVisible(false);
        enter = 1;
    }//GEN-LAST:event_txt_dr_lnActionPerformed

    private void txt_dr_lnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dr_lnKeyPressed
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

        String sb = txt_dr_ln.getText().trim() + "%";
        try {
            String searchbed = "select  Patient_ID as ID,concat(LastName,', ',FirstName,' ',MiddleName) as Name,PR_Gender as Gender  from Core1_pr_PatientRegistration where FirstName  like '" + sb + "'";

            pst = conn.prepareStatement(searchbed);
            rs = pst.executeQuery();
            pat.setModel(DbUtils.resultSetToTableModel(rs));

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

        jList2.setBounds(20, 50, 170, 430);
    }//GEN-LAST:event_txt_dr_lnKeyTyped

    private void patMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patMouseClicked
        int row = pat.rowAtPoint(evt.getPoint());
        if ((evt.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
            this.pat.setRowSelectionInterval(row, row);
            MousePos = evt.getY() / 16;
            menuTomer.show(evt.getComponent(), evt.getX(), evt.getY());
        } else {
            this.pat.setRowSelectionInterval(row, row);
        }
        //    PatientCount();
        //    PatientTable();
    }//GEN-LAST:event_patMouseClicked

    private void btnAddPatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddPatMousePressed

        patRegistration add = new patRegistration();
        add.setVisible(true);
    }//GEN-LAST:event_btnAddPatMousePressed

    private void fillIpdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillIpdActionPerformed
        update3();
    }//GEN-LAST:event_fillIpdActionPerformed

    private void fillAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillAllActionPerformed
        update();
    }//GEN-LAST:event_fillAllActionPerformed

    private void fillOpdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillOpdActionPerformed
        update2();
    }//GEN-LAST:event_fillOpdActionPerformed

    private void cbFilterPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbFilterPopupMenuWillBecomeInvisible


    }//GEN-LAST:event_cbFilterPopupMenuWillBecomeInvisible

    private void cbFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFilterActionPerformed
        ((JLabel) cbFilter.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        if (cbFilter.getSelectedItem().equals("Today")) {
            try {
                String q = " select FirstName as Patient ,DATEDIFF(YEAR,PR_Birthdate,convert (nvarchar,GETDATE(),101) )  as age ,PR_Gender as Gender,PR_Date as 'Registered date' "
                        + "from Core1_pr_PatientRegistration where cast (PR_Date as date) =  convert (nvarchar,GETDATE(),101) ";

                pst = conn.prepareStatement(q);
                rs = pst.executeQuery();

                pat.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            }
        } else if (cbFilter.getSelectedItem().equals("Weekly")) {
            try {
                String q = " select FirstName as Patient ,DATEDIFF(YEAR,PR_Birthdate,convert (nvarchar,GETDATE(),101) )  as age ,PR_Gender as Gender,PR_Date as 'Registered date' "
                        + "From Core1_pr_PatientRegistration Where PR_Date BETWEEN DATEADD(DAY, -7, GETDATE()) AND DATEADD(DAY, 1, GETDATE())";

                pst = conn.prepareStatement(q);
                rs = pst.executeQuery();

                pat.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            }

        } else if (cbFilter.getSelectedItem().equals("Monthly")) {
            try {
                String q = " select FirstName as Patient ,DATEDIFF(YEAR,PR_Birthdate,convert (nvarchar,GETDATE(),101) )  as age ,PR_Gender as Gender,PR_Date as 'Registered date' "
                        + "FROM Core1_pr_PatientRegistration WHERE MONTH(PR_Date) = MONTH(dateadd(dd, -1, GetDate())) AND YEAR(PR_Date) = YEAR(dateadd(dd, -1, GetDate()))";

                pst = conn.prepareStatement(q);
                rs = pst.executeQuery();

                pat.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            }

        } else if (cbFilter.getSelectedItem().equals("Yearly")) {
            try {
                String q = " select FirstName as Patient ,DATEDIFF(YEAR,PR_Birthdate,convert (nvarchar,GETDATE(),101) )  as age ,PR_Gender as Gender,PR_Date as 'Registered date' "
                        + "From Core1_pr_PatientRegistration WHERE PR_Date > DATEADD(year,-1,GETDATE())";

                pst = conn.prepareStatement(q);
                rs = pst.executeQuery();

                pat.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            }

        } else {
            cbFilter.getSelectedItem().equals("All");
            try {
                String q = "select FirstName as Patient ,DATEDIFF(YEAR,PR_Birthdate,convert (nvarchar,GETDATE(),101) )  as age ,PR_Gender as Gender,PR_Date as 'Registered date'"
                        + " from Core1_pr_PatientRegistration";

                pst = conn.prepareStatement(q);
                rs = pst.executeQuery();

                pat.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_cbFilterActionPerformed

    private void jLabel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MousePressed

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MousePressed

    private void patMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patMouseEntered


    }//GEN-LAST:event_patMouseEntered

    private void patAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_patAncestorAdded
        PatientTable();
        PatientCount();
    }//GEN-LAST:event_patAncestorAdded

    private void btnUpdateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMousePressed
        if ((evt.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {
            this.menuTomer.setVisible(false);

            UpdateINFO update = new UpdateINFO();
            update.setVisible(true);
        }
    }//GEN-LAST:event_btnUpdateMousePressed

    private void btnDelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDelMousePressed
        if ((evt.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {
            this.menuTomer.setVisible(false);

            printID update = new printID();
            update.setVisible(true);
        }
    }//GEN-LAST:event_btnDelMousePressed

    private void btnViewMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewMousePressed
        PatientTable();
    }//GEN-LAST:event_btnViewMousePressed

    private void fillAll1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillAll1ActionPerformed
        printID prnt = new printID();
        prnt.setVisible(true);
    }//GEN-LAST:event_fillAll1ActionPerformed

    private void fillAll2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillAll2ActionPerformed
        UpdateINFO up = new UpdateINFO();
        up.setVisible(true);
    }//GEN-LAST:event_fillAll2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PatientCount;
    private rojerusan.RSButtonPane btnAddPat;
    private rojerusan.RSButtonPane btnDel;
    private rojerusan.RSButtonPane btnUpdate;
    private rojerusan.RSButtonPane btnView;
    private rojerusan.RSComboMetro cbFilter;
    private rojerusan.RSMaterialButtonRound fillAll;
    private rojerusan.RSMaterialButtonRound fillAll1;
    private rojerusan.RSMaterialButtonRound fillAll2;
    private rojerusan.RSMaterialButtonRound fillIpd;
    private rojerusan.RSMaterialButtonRound fillOpd;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private rojerusan.RSPopuMenu menuTomer;
    public static rojerusan.RSTableMetro pat;
    private javax.swing.JPanel pnelTomer;
    public static javax.swing.JPanel root;
    public static javax.swing.JScrollPane scrollPatient;
    private rojerusan.RSMetroTextFullPlaceHolder txt_dr_ln;
    // End of variables declaration//GEN-END:variables

    private Object patUpdate(Patientregistration aThis, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
