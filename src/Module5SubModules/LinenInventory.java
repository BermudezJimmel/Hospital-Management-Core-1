/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module5SubModules;

import Notifications.DesktopNotify;
import SystemInstance.MysqlConnect;
import java.awt.Color;
import static java.lang.Thread.sleep;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author jerome
 */
public final class LinenInventory extends javax.swing.JPanel {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    java.sql.PreparedStatement pst = null;
    CallableStatement cst = null;

    public LinenInventory() {
        initComponents();
        con = MysqlConnect.ConnectDB();
        Update_Inventory_tbl();
        Hk_request();
        clockJobView();
    }

    public void clockJobView() {

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

                        //     Update_dr_tbl();
                        Update_Inventory_tbl();
                        Hk_request();
                        sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        clock.start();

    }

    private void Update_Inventory_tbl() {

        try {
            String sql = "select Stock_ID as 'STOCK NO.',Item as ITEM , Quantity as QUANTITY from Core1_lm_inventory where Item = '" + stocks.getText() + "'";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            inventory_tbl.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void Hk_request() {

        try {
            String sql = "select Req_ID as 'REQUEST NUMBER',Name,item as ITEM,qty as QUANTITY,date_req  as 'REQUEST DATE' ,status as Status from Core1_lm_hk_request where status= 'Pending request'";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            inventory_tbl1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        root = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Search = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_search_Patient = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        asterisk10 = new javax.swing.JLabel();
        asterisk9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        stocks = new javax.swing.JTextField();
        date_req1 = new javax.swing.JLabel();
        date_req = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        jLabel14 = new javax.swing.JLabel();
        qty = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        hk_name = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        quanInvent = new javax.swing.JTextField();
        quanInvent1 = new javax.swing.JTextField();
        scrollPatient1 = new javax.swing.JScrollPane();
        inventory_tbl1 = new rojerusan.RSTableMetro();
        jLabel15 = new javax.swing.JLabel();
        UpdateInventory = new rojerusan.RSMaterialButtonRound();
        scrollPatient = new javax.swing.JScrollPane();
        inventory_tbl = new rojerusan.RSTableMetro();
        jPanel2 = new javax.swing.JPanel();

        root.setBackground(new java.awt.Color(255, 255, 255));
        root.setLayout(null);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("Stocks item view");
        root.add(jLabel13);
        jLabel13.setBounds(10, 420, 97, 15);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1260, 100));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Search.setBackground(new java.awt.Color(255, 255, 255));
        Search.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Search  By: Name", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Search  : ");

        txt_search_Patient.setPreferredSize(new java.awt.Dimension(200, 25));
        txt_search_Patient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_search_PatientKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout SearchLayout = new javax.swing.GroupLayout(Search);
        Search.setLayout(SearchLayout);
        SearchLayout.setHorizontalGroup(
            SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_search_Patient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        SearchLayout.setVerticalGroup(
            SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_search_Patient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Linen details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        asterisk10.setBackground(new java.awt.Color(255, 255, 255));
        asterisk10.setFont(new java.awt.Font("Arial", 3, 9)); // NOI18N
        asterisk10.setForeground(new java.awt.Color(204, 0, 0));
        asterisk10.setEnabled(false);
        jPanel4.add(asterisk10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 80, 22));

        asterisk9.setBackground(new java.awt.Color(255, 255, 255));
        asterisk9.setFont(new java.awt.Font("Arial", 3, 9)); // NOI18N
        asterisk9.setForeground(new java.awt.Color(204, 0, 0));
        asterisk9.setEnabled(false);
        jPanel4.add(asterisk9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 80, 22));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Stocks Name:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Date request:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        stocks.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        stocks.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel4.add(stocks, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 80, -1));

        date_req1.setText("-");
        jPanel4.add(date_req1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 132, 19));

        date_req.setText("-");
        jPanel4.add(date_req, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 132, 19));

        button1.setLabel("Clear");
        jPanel4.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(559, 214, 91, -1));

        button2.setLabel("Update");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        jPanel4.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 214, 91, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Quantity:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        qty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        qty.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel4.add(qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 80, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Item name:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Item no.");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Date use:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel4.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 40, -1));

        hk_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        hk_name.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel4.add(hk_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 120, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Request no:");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Requestor Name:");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 50, 100, -1));

        quanInvent.setEditable(false);
        quanInvent.setBackground(new java.awt.Color(255, 255, 255));
        quanInvent.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quanInvent.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel4.add(quanInvent, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 80, -1));

        quanInvent1.setEditable(false);
        quanInvent1.setBackground(new java.awt.Color(255, 255, 255));
        quanInvent1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quanInvent1.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel4.add(quanInvent1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 80, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 510, 210));

        scrollPatient1.setBackground(new java.awt.Color(255, 255, 255));
        scrollPatient1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192), 3));

        inventory_tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        inventory_tbl1.setToolTipText("");
        inventory_tbl1.setAutoscrolls(false);
        inventory_tbl1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        inventory_tbl1.setFuenteFilas(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        inventory_tbl1.setFuenteFilasSelect(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        inventory_tbl1.setFuenteHead(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        inventory_tbl1.setGrosorBordeFilas(0);
        inventory_tbl1.setGrosorBordeHead(0);
        inventory_tbl1.setMultipleSeleccion(false);
        inventory_tbl1.getTableHeader().setReorderingAllowed(false);
        inventory_tbl1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                inventory_tbl1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        inventory_tbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inventory_tbl1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inventory_tbl1MouseEntered(evt);
            }
        });
        scrollPatient1.setViewportView(inventory_tbl1);

        jPanel1.add(scrollPatient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, 510, 260));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("Housekeeping request");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, -1, -1));

        UpdateInventory.setText("Approve request");
        UpdateInventory.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        UpdateInventory.setMaximumSize(new java.awt.Dimension(82, 26));
        UpdateInventory.setMinimumSize(new java.awt.Dimension(82, 26));
        UpdateInventory.setPreferredSize(new java.awt.Dimension(88, 28));
        UpdateInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateInventoryActionPerformed(evt);
            }
        });
        jPanel1.add(UpdateInventory, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 300, 170, 50));

        root.add(jPanel1);
        jPanel1.setBounds(10, 60, 1140, 350);

        scrollPatient.setBackground(new java.awt.Color(255, 255, 255));
        scrollPatient.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192), 3));

        inventory_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        inventory_tbl.setToolTipText("");
        inventory_tbl.setAutoscrolls(false);
        inventory_tbl.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        inventory_tbl.setFuenteFilas(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        inventory_tbl.setFuenteFilasSelect(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        inventory_tbl.setFuenteHead(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        inventory_tbl.setGrosorBordeFilas(0);
        inventory_tbl.setGrosorBordeHead(0);
        inventory_tbl.setMultipleSeleccion(false);
        inventory_tbl.getTableHeader().setReorderingAllowed(false);
        inventory_tbl.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                inventory_tblAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        inventory_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inventory_tblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inventory_tblMouseEntered(evt);
            }
        });
        scrollPatient.setViewportView(inventory_tbl);

        root.add(scrollPatient);
        scrollPatient.setBounds(10, 436, 1140, 130);

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

    private void txt_search_PatientKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_search_PatientKeyReleased
        // Search patient by name
        /*    String sp = txt_search_Patient.getText().trim() + "%";
        try {
            String searchbed = "select ip.Ipd_ID,p.Patient_ID,p.FirstName,p.LastName, p.Mode_of_payment,r.Room_ID,r.Bed_No, \n" +
            "r.Room_type,r.rate,r.bed_status,dr.Drname,r.date_occopied,ip.admitdate,ip.Admitedby\n" +
            "from Core1_pr_PatientRegistration p\n" +
            "\n" +
            "\n" +
            "\n" +
            "join Core1_bm_rooms r on \n" +
            "p.Patient_ID = r.Patient_ID\n" +
            "\n" +
            "join Core1_ipd_admission ip on\n" +
            "ip.Patient_ID = r.Patient_ID\n" +
            "\n" +
            "join Core1_dra_drinfo dr  on \n" +
            "dr.Doctor_ID = ip.Doctor_ID\n" +
            "where FirstName like '%"+sp+"%'";

            pst = con.prepareStatement(searchbed);
            rs = pst.executeQuery();
            transfer_tbl.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
        }*/
    }//GEN-LAST:event_txt_search_PatientKeyReleased

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button2ActionPerformed

    private void inventory_tblAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_inventory_tblAncestorAdded

    }//GEN-LAST:event_inventory_tblAncestorAdded

    private void inventory_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventory_tblMouseClicked

        try {
            int row = inventory_tbl.getSelectedRow();
            String table_update = (inventory_tbl.getModel().getValueAt(row, 0).toString());
            String sql = "select * from Core1_lm_inventory where Stock_ID='" + table_update + "'";

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                //Display data for update  
                String add0 = rs.getString("Stock_ID");
                quanInvent.setText(add0);
                String add10 = rs.getString("Quantity");
                quanInvent1.setText(add10);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_inventory_tblMouseClicked

    private void inventory_tblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventory_tblMouseEntered

    }//GEN-LAST:event_inventory_tblMouseEntered

    private void inventory_tbl1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_inventory_tbl1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_inventory_tbl1AncestorAdded

    private void inventory_tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventory_tbl1MouseClicked

        try {
            int row = inventory_tbl1.getSelectedRow();
            String table_update = (inventory_tbl1.getModel().getValueAt(row, 0).toString());
            String sql = "select * from Core1_lm_hk_request where Req_ID='" + table_update + "'";

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                //Display data for update  
                String add0 = rs.getString("Req_ID");
                id.setText(add0);
                String add01 = rs.getString("Name");
                hk_name.setText(add01);
                String add012 = rs.getString("item");
                stocks.setText(add012);
                String add03 = rs.getString("qty");
                qty.setText(add03);
                String add04 = rs.getString("date_req");
                date_req.setText(add04);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_inventory_tbl1MouseClicked

    private void inventory_tbl1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventory_tbl1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_inventory_tbl1MouseEntered

    private void UpdateInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateInventoryActionPerformed
        try {

            if (quanInvent.getText().isEmpty()) {
                // Validation message. 
                DesktopNotify.showDesktopMessage("INPUT MISSING...", "Please click on table to fill automatic requested item",
                        DesktopNotify.INPUT_REQUEST, 8000);
                asterisk9.setBorder(BorderFactory.createLineBorder(Color.red));
                asterisk9.setVisible(true);
            } else if (quanInvent1.getText().isEmpty()) {
                // Validation message. 
                DesktopNotify.showDesktopMessage("INPUT MISSING...", "Please click on table to fill automatic requested item",
                        DesktopNotify.INPUT_REQUEST, 8000);
                asterisk10.setBorder(BorderFactory.createLineBorder(Color.red));
                asterisk10.setVisible(true);
            } else {
                int qt = Integer.parseInt(quanInvent1.getText());
                int qa = Integer.parseInt(qty.getText());

                int totalqa = qt - qa;

                if (qa > qt) {

                    DesktopNotify.showDesktopMessage("OUT OF STOCK...", "Please request stock.",
                            DesktopNotify.WARNING, 8000);
                } else {
                    try {
                        String sql = "Update Core1_lm_inventory set Quantity = '" + totalqa + "' where Item = '" + stocks.getText() + "'";
                        pst = con.prepareStatement(sql);
                        pst.execute();
                        try {
                            String sql2 = "Update Core1_lm_hk_request set status = 'Approved request' where Req_ID = '" + id.getText() + "'";
                            pst = con.prepareStatement(sql2);
                            pst.execute();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e);

                        }

                        DesktopNotify.showDesktopMessage("GRANT REQUEST...", "Please check stocks after granting request of  " + hk_name.getText(),
                                DesktopNotify.SUCCESS, 8000);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);

                    }

                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }


    }//GEN-LAST:event_UpdateInventoryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Search;
    private rojerusan.RSMaterialButtonRound UpdateInventory;
    private javax.swing.JLabel asterisk10;
    private javax.swing.JLabel asterisk9;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private javax.swing.JLabel date_req;
    private javax.swing.JLabel date_req1;
    private javax.swing.JTextField hk_name;
    private javax.swing.JTextField id;
    public static rojerusan.RSTableMetro inventory_tbl;
    public static rojerusan.RSTableMetro inventory_tbl1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField qty;
    private javax.swing.JTextField quanInvent;
    private javax.swing.JTextField quanInvent1;
    private javax.swing.JPanel root;
    public static javax.swing.JScrollPane scrollPatient;
    public static javax.swing.JScrollPane scrollPatient1;
    private javax.swing.JTextField stocks;
    private javax.swing.JTextField txt_search_Patient;
    // End of variables declaration//GEN-END:variables
}
