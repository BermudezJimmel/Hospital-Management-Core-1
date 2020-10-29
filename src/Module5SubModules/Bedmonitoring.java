/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module5SubModules;

import SystemInstance.MysqlConnect;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import static java.lang.Thread.sleep;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author jerome
 */
public final class Bedmonitoring extends javax.swing.JPanel {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    CallableStatement cst = null;
    DefaultTableModel mode;

    public Bedmonitoring() {
        initComponents();
        con = MysqlConnect.ConnectDB();
        //sm1
        Update_bed_tbl();
        Hint();
        count();

    }

   
    private void count() {
        try {

            String q = "Select Count(Room_ID) as 'room' FROM Core1_bm_rooms ";

            pst = con.prepareStatement(q);
            rs = pst.executeQuery();
            if (rs.next()) {
                String sum = rs.getString("room");
                total_beds.setText(sum);
            }
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    private void Update_bed_tbl() {

        try {
            String q = "select Room_ID as Room, Bed_No as Bed,Room_type as 'Room type',rate as Rate,Patient_ID as Patient,date_occopied as 'Date occupied',\n"
                    + "bed_remarks as Remarks,bed_status as Status from Core1_bm_rooms ";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(q);
            tbl_view.setModel(DbUtils.resultSetToTableModel(rs));
            tbl_view.getColumnModel().getColumn(0).setPreferredWidth(10);
            tbl_view.getColumnModel().getColumn(1).setPreferredWidth(10);
            tbl_view.getColumnModel().getColumn(2).setPreferredWidth(35);
            tbl_view.getColumnModel().getColumn(3).setPreferredWidth(5);
            tbl_view.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbl_view.getColumnModel().getColumn(5).setPreferredWidth(80);
            tbl_view.getColumnModel().getColumn(6).setPreferredWidth(80);
            tbl_view.getColumnModel().getColumn(7).setPreferredWidth(90);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Hint() {
        //    room_search.setUI(new HintTextFeild(" Search room ", true));
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
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        bed = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        total_beds = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        Filter_bed = new rojerusan.RSComboMetro();
        room_search = new rojerusan.RSMetroTextFullPlaceHolder();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        scrollPatient = new javax.swing.JScrollPane();
        tbl_view = new rojerusan.RSTableMetro()
        {
            @Override

            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex)
            {
                Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);

                Object value = getModel().getValueAt(rowIndex,columnIndex);

                if(columnIndex == 7)
                {

                    if(value.equals("Available"))
                    {

                        componenet.setBackground(Color.GREEN);
                        componenet.setForeground(Color.BLACK);

                    }
                    if(value.equals("Occupied"))
                    {
                        // if date  equal current date
                        componenet.setBackground(Color.RED);
                        componenet.setForeground(Color.BLACK);
                    }
                    if(value.equals("Scheduled for cleaning"))
                    {
                        // if date  equal current date
                        componenet.setBackground(Color.YELLOW);
                        componenet.setForeground(Color.BLACK);
                    }
                    if(value.equals("For Cleaning"))
                    {
                        // if date  equal current date
                        componenet.setBackground(Color.ORANGE);
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

        root.setBackground(new java.awt.Color(255, 255, 255));
        root.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1166, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        root.add(jPanel1);
        jPanel1.setBounds(0, 0, 1166, 50);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bed.setBackground(new java.awt.Color(255, 255, 255));
        bed.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Search Room type", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Total of beds");

        total_beds.setEditable(false);
        total_beds.setBackground(new java.awt.Color(0, 102, 102));
        total_beds.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        total_beds.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total_beds.setPreferredSize(new java.awt.Dimension(200, 30));
        total_beds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                total_bedsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 149, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Bed Availability", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        Filter_bed.setEditable(true);
        Filter_bed.setMaximumRowCount(3);
        Filter_bed.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Available", "Not available" }));
        Filter_bed.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        Filter_bed.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                Filter_bedPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        Filter_bed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Filter_bedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(Filter_bed, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(Filter_bed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        room_search.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        room_search.setPlaceholder("Search room type");
        room_search.setPreferredSize(new java.awt.Dimension(250, 40));
        room_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room_searchActionPerformed(evt);
            }
        });
        room_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                room_searchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                room_searchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                room_searchKeyTyped(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bed36x36_1.png"))); // NOI18N

        javax.swing.GroupLayout bedLayout = new javax.swing.GroupLayout(bed);
        bed.setLayout(bedLayout);
        bedLayout.setHorizontalGroup(
            bedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(bedLayout.createSequentialGroup()
                .addGroup(bedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bedLayout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bedLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bedLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bedLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(room_search, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bedLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(total_beds, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bedLayout.setVerticalGroup(
            bedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bedLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(bedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(room_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(48, 48, 48)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(bedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total_beds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(bed, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 260, 356));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel5.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 11, 17, 408));

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
        tbl_view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_viewMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbl_viewMouseEntered(evt);
            }
        });
        scrollPatient.setViewportView(tbl_view);

        jPanel5.add(scrollPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 36, 779, 374));

        root.add(jPanel5);
        jPanel5.setBounds(10, 90, 1130, 450);

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

    private void total_bedsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_total_bedsActionPerformed

    }//GEN-LAST:event_total_bedsActionPerformed

    private void tbl_viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_viewMouseClicked
        /*  int row = tblPatient.rowAtPoint(evt.getPoint());
        if ((evt.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
            this.tblPatient.setRowSelectionInterval(row, row);
            MousePos = evt.getY() / 16;
            menuC.show(evt.getComponent(), evt.getX(), evt.getY());
        } else {
            this.tblPatient.setRowSelectionInterval(row, row);
        }*/
    }//GEN-LAST:event_tbl_viewMouseClicked

    private void tbl_viewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_viewMouseEntered

        Update_bed_tbl();
    }//GEN-LAST:event_tbl_viewMouseEntered

    private void Filter_bedPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_Filter_bedPopupMenuWillBecomeInvisible

    }//GEN-LAST:event_Filter_bedPopupMenuWillBecomeInvisible

    private void Filter_bedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Filter_bedActionPerformed
        ((JLabel) Filter_bed.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        if (Filter_bed.getSelectedItem().equals("Available")) {
            try {
                String q = "select Room_ID as Room, Bed_No as Bed,Room_type as 'Room type',rate as Rate,Patient_ID as Patient,date_occopied as 'Date occupied',\n"
                        + "bed_remarks as Remarks,bed_status as Status from Core1_bm_rooms where bed_status='Available' ";

                pst = con.prepareStatement(q);
                rs = pst.executeQuery();

                tbl_view.setModel(DbUtils.resultSetToTableModel(rs));
                tbl_view.getColumnModel().getColumn(0).setPreferredWidth(10);
                tbl_view.getColumnModel().getColumn(1).setPreferredWidth(10);
                tbl_view.getColumnModel().getColumn(2).setPreferredWidth(35);
                tbl_view.getColumnModel().getColumn(3).setPreferredWidth(5);
                tbl_view.getColumnModel().getColumn(4).setPreferredWidth(80);
                tbl_view.getColumnModel().getColumn(5).setPreferredWidth(80);
                tbl_view.getColumnModel().getColumn(6).setPreferredWidth(80);
                tbl_view.getColumnModel().getColumn(7).setPreferredWidth(90);

            } catch (Exception e) {
            }
        } else if (Filter_bed.getSelectedItem().equals("Not available")) {
            try {
                String q = "select Room_ID as Room, Bed_No as Bed,Room_type as 'Room type',rate as Rate,Patient_ID as Patient,date_occopied as 'Date occupied',\n"
                        + "bed_remarks as Remarks,bed_status as Status from Core1_bm_rooms  where bed_status='Occupied'";

                pst = con.prepareStatement(q);
                rs = pst.executeQuery();

                tbl_view.setModel(DbUtils.resultSetToTableModel(rs));
                tbl_view.getColumnModel().getColumn(0).setPreferredWidth(10);
                tbl_view.getColumnModel().getColumn(1).setPreferredWidth(10);
                tbl_view.getColumnModel().getColumn(2).setPreferredWidth(35);
                tbl_view.getColumnModel().getColumn(3).setPreferredWidth(5);
                tbl_view.getColumnModel().getColumn(4).setPreferredWidth(80);
                tbl_view.getColumnModel().getColumn(5).setPreferredWidth(80);
                tbl_view.getColumnModel().getColumn(6).setPreferredWidth(80);
                tbl_view.getColumnModel().getColumn(7).setPreferredWidth(90);

            } catch (Exception e) {
            }
        } else {
            Filter_bed.getSelectedItem().equals("All beds");
            try {
                String q = "select Room_ID as Room, Bed_No as Bed,Room_type as 'Room type',rate as Rate,Patient_ID as Patient,date_occopied as 'Date occupied',\n"
                        + "bed_remarks as Remarks,bed_status as Status from Core1_bm_rooms ";

                pst = con.prepareStatement(q);
                rs = pst.executeQuery();

                tbl_view.setModel(DbUtils.resultSetToTableModel(rs));
                tbl_view.getColumnModel().getColumn(0).setPreferredWidth(10);
                tbl_view.getColumnModel().getColumn(1).setPreferredWidth(10);
                tbl_view.getColumnModel().getColumn(2).setPreferredWidth(35);
                tbl_view.getColumnModel().getColumn(3).setPreferredWidth(5);
                tbl_view.getColumnModel().getColumn(4).setPreferredWidth(80);
                tbl_view.getColumnModel().getColumn(5).setPreferredWidth(80);
                tbl_view.getColumnModel().getColumn(6).setPreferredWidth(80);
                tbl_view.getColumnModel().getColumn(7).setPreferredWidth(90);

            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_Filter_bedActionPerformed

    private void room_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room_searchActionPerformed

    }//GEN-LAST:event_room_searchActionPerformed

    private void room_searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_room_searchKeyPressed

    }//GEN-LAST:event_room_searchKeyPressed

    private void room_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_room_searchKeyReleased
        //Search rooms availability
        String sb = room_search.getText().trim() + "%";
        try {
            String searchbed = "select Room_ID as Room, Bed_No as Bed,Room_type as 'Room type',rate as Rate,Patient_ID as Patient,date_occopied as 'Date occupied',\n"
                    + "bed_remarks as Remarks,bed_status as Status from Core1_bm_rooms where Room_type like '" + sb + "'";

            pst = con.prepareStatement(searchbed);
            rs = pst.executeQuery();
            tbl_view.setModel(DbUtils.resultSetToTableModel(rs));
            tbl_view.getColumnModel().getColumn(0).setPreferredWidth(10);
            tbl_view.getColumnModel().getColumn(1).setPreferredWidth(10);
            tbl_view.getColumnModel().getColumn(2).setPreferredWidth(35);
            tbl_view.getColumnModel().getColumn(3).setPreferredWidth(5);
            tbl_view.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbl_view.getColumnModel().getColumn(5).setPreferredWidth(80);
            tbl_view.getColumnModel().getColumn(6).setPreferredWidth(80);
            tbl_view.getColumnModel().getColumn(7).setPreferredWidth(90);

        } catch (Exception e) {
        }
    }//GEN-LAST:event_room_searchKeyReleased

    private void room_searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_room_searchKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }

        if (!Character.isAlphabetic(evt.getKeyChar()) && !Character.isSpaceChar(evt.getKeyChar())) {
            evt.consume();
        } else if (room_search.getText().trim().length() == 0 && Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_room_searchKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSComboMetro Filter_bed;
    private javax.swing.JPanel bed;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private rojerusan.RSMetroTextFullPlaceHolder room_search;
    private javax.swing.JPanel root;
    public static javax.swing.JScrollPane scrollPatient;
    public static rojerusan.RSTableMetro tbl_view;
    private javax.swing.JTextField total_beds;
    // End of variables declaration//GEN-END:variables
}
