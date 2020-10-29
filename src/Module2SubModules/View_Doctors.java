/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module2SubModules;

import SystemInstance.MysqlConnect;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author jerome
 */
public final class View_Doctors extends javax.swing.JPanel {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    CallableStatement cst = null;
    DefaultTableModel mode;
    String Registerno;
    String Gender;
    String GenderApp;
    String DateJob;
    String SexApp;

    public View_Doctors() {
        initComponents();
        con = MysqlConnect.ConnectDB();
        Update_dr_tbl();
        Hint();
    }
    Doctors_Schedule showdata = new Doctors_Schedule();

    private void Update_dr_tbl() {

        tbl_view.setSelectionBackground(Color.red);

        try {
            String sql = "select Dr_ID as 'Doctor ID', surname as Doctor,gender as Gender,specialization as Specialization ,status as Status  from Core1_dra_registered "
                    + "where status='No schedule yet'";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            tbl_view.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Hint() {
   //     txt_search_dr.setUI(new HintTextFeild(" Search by Doctor surname ", true));
    }

    private void remove() {
        while (tbl_view.getRowCount() > 0) {
            mode.removeRow(0);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        root = new javax.swing.JPanel();
        btnAdd = new rojerusan.RSButtonPane();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnUpdate = new rojerusan.RSButtonPane();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pnlDrInfo1 = new javax.swing.JPanel();
        txt_dr_ID = new rojerusan.RSMetroTextFullPlaceHolder();
        txt_dr_Surname = new rojerusan.RSMetroTextFullPlaceHolder();
        txt_dr_gndr = new rojerusan.RSMetroTextFullPlaceHolder();
        txt_dr_Specia = new rojerusan.RSMetroTextFullPlaceHolder();
        newG = new rojerusan.RSButtonHover();
        newG1 = new rojerusan.RSButtonHover();
        newG2 = new rojerusan.RSButtonHover();
        newG3 = new rojerusan.RSButtonHover();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        Filter_bed1 = new javax.swing.JComboBox<>();
        scrollPatient = new javax.swing.JScrollPane();
        tbl_view = new rojerusan.RSTableMetro()
        {
            @Override

            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex)
            {
                Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);

                Object value = getModel().getValueAt(rowIndex,columnIndex);

                if(columnIndex == 4)
                {

                    if(value.equals("Scheduled"))
                    {

                        componenet.setBackground(Color.GREEN);
                        componenet.setForeground(Color.BLACK);

                    }
                    if(value.equals("No schedule yet"))
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
        jPanel4 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txt_dr_ln = new rojerusan.RSMetroTextFullPlaceHolder();

        root.setBackground(new java.awt.Color(255, 255, 255));
        root.setLayout(null);

        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAddMousePressed(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add36x36.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel13MousePressed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Add Schedule");

        javax.swing.GroupLayout btnAddLayout = new javax.swing.GroupLayout(btnAdd);
        btnAdd.setLayout(btnAddLayout);
        btnAddLayout.setHorizontalGroup(
            btnAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAddLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel13)
                .addGap(0, 0, 0)
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnAddLayout.setVerticalGroup(
            btnAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        root.add(btnAdd);
        btnAdd.setBounds(970, 260, 150, 40);

        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnUpdateMousePressed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update36x36.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel11MousePressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Update Schedule");

        javax.swing.GroupLayout btnUpdateLayout = new javax.swing.GroupLayout(btnUpdate);
        btnUpdate.setLayout(btnUpdateLayout);
        btnUpdateLayout.setHorizontalGroup(
            btnUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnUpdateLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel11)
                .addGap(0, 0, 0)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnUpdateLayout.setVerticalGroup(
            btnUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        root.add(btnUpdate);
        btnUpdate.setBounds(780, 260, 170, 40);

        pnlDrInfo1.setBackground(new java.awt.Color(255, 255, 255));
        pnlDrInfo1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Doctor Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        txt_dr_ID.setForeground(new java.awt.Color(1, 113, 124));
        txt_dr_ID.setBorderColor(new java.awt.Color(1, 113, 124));
        txt_dr_ID.setBotonColor(new java.awt.Color(1, 113, 124));
        txt_dr_ID.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txt_dr_ID.setMayusculas(true);
        txt_dr_ID.setPlaceholder("ID");
        txt_dr_ID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dr_IDKeyTyped(evt);
            }
        });

        txt_dr_Surname.setForeground(new java.awt.Color(1, 113, 124));
        txt_dr_Surname.setBorderColor(new java.awt.Color(1, 113, 124));
        txt_dr_Surname.setBotonColor(new java.awt.Color(1, 113, 124));
        txt_dr_Surname.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txt_dr_Surname.setMayusculas(true);
        txt_dr_Surname.setPlaceholder("DOCTORS NAME");
        txt_dr_Surname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dr_SurnameKeyTyped(evt);
            }
        });

        txt_dr_gndr.setForeground(new java.awt.Color(1, 113, 124));
        txt_dr_gndr.setBorderColor(new java.awt.Color(1, 113, 124));
        txt_dr_gndr.setBotonColor(new java.awt.Color(1, 113, 124));
        txt_dr_gndr.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txt_dr_gndr.setMayusculas(true);
        txt_dr_gndr.setPlaceholder("GENDER");
        txt_dr_gndr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dr_gndrKeyTyped(evt);
            }
        });

        txt_dr_Specia.setForeground(new java.awt.Color(1, 113, 124));
        txt_dr_Specia.setBorderColor(new java.awt.Color(1, 113, 124));
        txt_dr_Specia.setBotonColor(new java.awt.Color(1, 113, 124));
        txt_dr_Specia.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txt_dr_Specia.setMayusculas(true);
        txt_dr_Specia.setPlaceholder("SPECIALIZATION");
        txt_dr_Specia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dr_SpeciaKeyTyped(evt);
            }
        });

        newG.setBackground(new java.awt.Color(255, 255, 255));
        newG.setBorder(null);
        newG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/drFINAL36x36_1.png"))); // NOI18N

        newG1.setBackground(new java.awt.Color(255, 255, 255));
        newG1.setBorder(null);
        newG1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/gender36x36_1.png"))); // NOI18N

        newG2.setBackground(new java.awt.Color(255, 255, 255));
        newG2.setBorder(null);
        newG2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dr36x36_1.png"))); // NOI18N

        newG3.setBackground(new java.awt.Color(255, 255, 255));
        newG3.setBorder(null);
        newG3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/id36x36_1.png"))); // NOI18N

        javax.swing.GroupLayout pnlDrInfo1Layout = new javax.swing.GroupLayout(pnlDrInfo1);
        pnlDrInfo1.setLayout(pnlDrInfo1Layout);
        pnlDrInfo1Layout.setHorizontalGroup(
            pnlDrInfo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDrInfo1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(pnlDrInfo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDrInfo1Layout.createSequentialGroup()
                        .addComponent(newG2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_dr_Specia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDrInfo1Layout.createSequentialGroup()
                        .addComponent(newG1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_dr_gndr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDrInfo1Layout.createSequentialGroup()
                        .addComponent(newG, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_dr_Surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDrInfo1Layout.createSequentialGroup()
                        .addComponent(newG3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_dr_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );
        pnlDrInfo1Layout.setVerticalGroup(
            pnlDrInfo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDrInfo1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDrInfo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_dr_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newG3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDrInfo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_dr_Surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDrInfo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_dr_gndr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newG1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDrInfo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_dr_Specia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newG2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        root.add(pnlDrInfo1);
        pnlDrInfo1.setBounds(120, 70, 360, 230);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("View");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        Filter_bed1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Doctors", "Scheduled", "No schedule yet" }));
        Filter_bed1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Filter_bed1ActionPerformed(evt);
            }
        });
        jPanel1.add(Filter_bed1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 10, 131, -1));

        root.add(jPanel1);
        jPanel1.setBounds(10, 330, 1150, 40);

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
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbl_viewAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
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
        scrollPatient.setBounds(10, 366, 1150, 200);

        jPanel4.setBackground(new java.awt.Color(51, 102, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/old1.png"))); // NOI18N
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(912, 0, -1, 50));

        txt_dr_ln.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txt_dr_ln.setPlaceholder("Search by Doctors name");
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
        jPanel4.add(txt_dr_ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 5, 170, -1));

        root.add(jPanel4);
        jPanel4.setBounds(0, 0, 1166, 50);

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

    private void Filter_bed1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Filter_bed1ActionPerformed
        ((JLabel) Filter_bed1.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        if (Filter_bed1.getSelectedItem().equals("Scheduled")) {
            try {
                String q = "select Dr_ID as 'Doctor ID', surname as Doctor,gender as Gender,specialization as Specialization ,status as Status  from Core1_dra_registered where status='Scheduled'";

                pst = con.prepareStatement(q);
                rs = pst.executeQuery();

                tbl_view.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            }
        } else if (Filter_bed1.getSelectedItem().equals("No schedule yet")) {
            try {
                String q = "select Dr_ID as 'Doctor ID', surname as Doctor,gender as Gender,specialization as Specialization ,status as Status  from Core1_dra_registered where status='No schedule yet'";

                pst = con.prepareStatement(q);
                rs = pst.executeQuery();

                tbl_view.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            }
        } else {
            Filter_bed1.getSelectedItem().equals("All Doctors");
            try {
                String q = "select Dr_ID as 'Doctor ID', surname as Doctor,gender as Gender,specialization as Specialization ,status as Status  from Core1_dra_registered";

                pst = con.prepareStatement(q);
                rs = pst.executeQuery();

                tbl_view.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_Filter_bed1ActionPerformed

    private void jLabel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MousePressed

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MousePressed

    private void btnUpdateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMousePressed

        Doctors_Schedule_update update = new Doctors_Schedule_update();
        update.setVisible(true);
    }//GEN-LAST:event_btnUpdateMousePressed

    private void jLabel13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MousePressed

    private void btnAddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMousePressed
        Doctors_Schedule sched = new Doctors_Schedule();

        Doctors_Schedule.txt_ID.setText(this.txt_dr_ID.getText());
        Doctors_Schedule.txt_name.setText(this.txt_dr_Surname.getText());
        Doctors_Schedule.txt_gen.setText(this.txt_dr_gndr.getText());
        Doctors_Schedule.txt_specia.setText(this.txt_dr_Specia.getText());

        sched.setVisible(true);
    }//GEN-LAST:event_btnAddMousePressed

    private void txt_dr_lnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dr_lnActionPerformed
       
    }//GEN-LAST:event_txt_dr_lnActionPerformed

    private void txt_dr_lnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dr_lnKeyPressed
      
    }//GEN-LAST:event_txt_dr_lnKeyPressed

    private void txt_dr_lnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dr_lnKeyReleased
        // Search doctors by name
        String sb = txt_dr_ln.getText().trim() + "%";
        try {
            String searchbed = "select Dr_ID as 'Doctor ID', surname as Doctor,gender as Gender,specialization as Specialization ,status as Status  from Core1_dra_registered "
                    + "where status='No schedule yet'";
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
         try {
            int row = tbl_view.getSelectedRow();
            String Table_transfer = (tbl_view.getModel().getValueAt(row, 0).toString());
            String sql = "select * from Core1_dra_registered where Dr_ID='" + Table_transfer + "'";

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                //Display data for update
                String add0 = rs.getString("Dr_ID");
                txt_dr_ID.setText(add0);
                String add1 = rs.getString("surname");
                txt_dr_Surname.setText(add1);
                String add2 = rs.getString("gender");
                txt_dr_gndr.setText(add2);
                String add3 = rs.getString("specialization");
                txt_dr_Specia.setText(add3);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_tbl_viewMouseClicked

    private void tbl_viewAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_viewAncestorAdded
       Update_dr_tbl();
    }//GEN-LAST:event_tbl_viewAncestorAdded

    private void tbl_viewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_viewMouseEntered
        Update_dr_tbl();
    }//GEN-LAST:event_tbl_viewMouseEntered

    private void txt_dr_IDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dr_IDKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }

        if (!Character.isAlphabetic(evt.getKeyChar()) && !Character.isSpaceChar(evt.getKeyChar())) {
            evt.consume();
        } else if (txt_dr_ID.getText().trim().length() == 0 && Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_txt_dr_IDKeyTyped

    private void txt_dr_SurnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dr_SurnameKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dr_SurnameKeyTyped

    private void txt_dr_gndrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dr_gndrKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dr_gndrKeyTyped

    private void txt_dr_SpeciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dr_SpeciaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dr_SpeciaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Filter_bed1;
    private rojerusan.RSButtonPane btnAdd;
    private rojerusan.RSButtonPane btnUpdate;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private rojerusan.RSButtonHover newG;
    private rojerusan.RSButtonHover newG1;
    private rojerusan.RSButtonHover newG2;
    private rojerusan.RSButtonHover newG3;
    private javax.swing.JPanel pnlDrInfo1;
    private javax.swing.JPanel root;
    public static javax.swing.JScrollPane scrollPatient;
    public static rojerusan.RSTableMetro tbl_view;
    private rojerusan.RSMetroTextFullPlaceHolder txt_dr_ID;
    private rojerusan.RSMetroTextFullPlaceHolder txt_dr_Specia;
    private rojerusan.RSMetroTextFullPlaceHolder txt_dr_Surname;
    private rojerusan.RSMetroTextFullPlaceHolder txt_dr_gndr;
    private rojerusan.RSMetroTextFullPlaceHolder txt_dr_ln;
    // End of variables declaration//GEN-END:variables
}
