/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module2SubModules;

import SystemInstance.MysqlConnect;
import java.awt.Color;
import java.awt.Component;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import net.proteanit.sql.DbUtils;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author jerome
 */
public final class View_appointment extends javax.swing.JPanel {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    CallableStatement cst = null;
    DefaultTableModel mode;
    String Gender;

    public View_appointment() {
        initComponents();
        con = MysqlConnect.ConnectDB();
        select_dr();
        countall();
        tbl_appointment_monitoring();
        tbl_all_patients();
        count();
        total();

        AutoCompleteDecorator.decorate(Filter_schedule);
    }

    private void total() {

    }

    private void count() {
        try {

            String q = "Select Count(status) as 'stat' FROM Core1_opd_consultlist where\n"
                    + "cast (appontment_registered as date) =    convert (nvarchar,GETDATE(),101)";
            pst = con.prepareStatement(q);
            rs = pst.executeQuery();
            if (rs.next()) {
                String sum = rs.getString("stat");
                total_patient.setText(sum);
            }
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    private void countall() {
        try {

            String q = "Select Count(*) as 'stat' FROM Core1_opd_consultlist ";
            pst = con.prepareStatement(q);
            rs = pst.executeQuery();
            if (rs.next()) {
                String sum = rs.getString("stat");
                Totalallpatient.setText(sum);
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

    private void tbl_appointment_monitoring() {

        tbl_view.setSelectionBackground(Color.red);

        try {
            String sql = "select name as 'Patient name',patient_illness as 'Illness',age as 'Age',address as 'Location', mode_of_payment as 'Payment',"
                    + "doctor_name as 'Doctor',specialization as 'Specialization',appontment_registered as 'Registered date',status 'Status'\n"
                    + "   from Core1_opd_consultlist where consult_day = DATENAME(weekday, GETDATE()) and "
                    + "cast (appontment_registered as date) =    convert (nvarchar,GETDATE(),101)";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            tbl_view.setModel(DbUtils.resultSetToTableModel(rs));

            tbl_view.getColumnModel().getColumn(0).setPreferredWidth(80);
            tbl_view.getColumnModel().getColumn(1).setPreferredWidth(10);
            tbl_view.getColumnModel().getColumn(2).setPreferredWidth(15);
            tbl_view.getColumnModel().getColumn(3).setPreferredWidth(10);
            tbl_view.getColumnModel().getColumn(4).setPreferredWidth(10);
            tbl_view.getColumnModel().getColumn(6).setPreferredWidth(100);

            JTableHeader theader = tbl_view.getTableHeader();

            theader.setBackground(Color.CYAN);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void tbl_all_patients() {

        tbl_view1.setSelectionBackground(Color.red);

        try {
            String sql = "select name as 'Patient name',patient_illness as 'Illness',age as 'Age',address as 'Location', mode_of_payment as 'Payment',\n"
                    + "                    doctor_name as 'Doctor',specialization as 'Specialization',appontment_registered as 'Registered date',status 'Status'\n"
                    + "                     from Core1_opd_consultlist";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            tbl_view1.setModel(DbUtils.resultSetToTableModel(rs));

            tbl_view1.getColumnModel().getColumn(0).setPreferredWidth(80);
            tbl_view1.getColumnModel().getColumn(1).setPreferredWidth(10);
            tbl_view1.getColumnModel().getColumn(2).setPreferredWidth(15);
            tbl_view1.getColumnModel().getColumn(3).setPreferredWidth(10);
            tbl_view1.getColumnModel().getColumn(4).setPreferredWidth(10);
            tbl_view1.getColumnModel().getColumn(6).setPreferredWidth(100);

            JTableHeader theader = tbl_view1.getTableHeader();

            theader.setBackground(Color.CYAN);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        root = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        Totaall = new javax.swing.JLabel();
        Search = new javax.swing.JPanel();
        tab2 = new javax.swing.JPanel();
        PatientAll = new javax.swing.JPanel();
        scrollPatient = new javax.swing.JScrollPane();
        tbl_view1 = new rojerusan.RSTableMetro()
        {
            @Override

            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex)
            {
                Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);

                Object value = getModel().getValueAt(rowIndex,columnIndex);

                if(columnIndex == 8)
                {

                    if(value.equals("Done Consultation"))
                    {

                        componenet.setBackground(Color.GREEN);
                        componenet.setForeground(Color.BLACK);

                    }
                    if(value.equals("No vital signs yet"))
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
        PatientToday = new javax.swing.JPanel();
        scrollPatient1 = new javax.swing.JScrollPane();
        tbl_view = new rojerusan.RSTableMetro()
        {
            @Override

            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex)
            {
                Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);

                Object value = getModel().getValueAt(rowIndex,columnIndex);

                if(columnIndex == 8)
                {

                    if(value.equals("Done Consultation"))
                    {

                        componenet.setBackground(Color.GREEN);
                        componenet.setForeground(Color.BLACK);

                    }
                    if(value.equals("No vital signs yet"))
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
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Filter_schedule = new rojerusan.RSComboMetro();
        PatientMonitoring = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        total_done = new javax.swing.JTextField();
        total_apoint = new javax.swing.JTextField();
        total_wait = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        total_apoint1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        total_slot = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        total_cash = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        total_hmo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        total_new = new javax.swing.JTextField();
        total_old = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Totalallpatient = new javax.swing.JTextField();
        total_patient = new javax.swing.JTextField();
        totalToday = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        root.setBackground(new java.awt.Color(255, 255, 255));
        root.setLayout(null);

        jSeparator1.setForeground(new java.awt.Color(0, 102, 102));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        root.add(jSeparator1);
        jSeparator1.setBounds(920, 80, 10, 500);

        Totaall.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Totaall.setPreferredSize(new java.awt.Dimension(114, 21));
        root.add(Totaall);
        Totaall.setBounds(940, 510, 160, 40);

        Search.setBackground(new java.awt.Color(255, 255, 255));
        Search.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab2.setLayout(new java.awt.CardLayout());

        scrollPatient.setBackground(new java.awt.Color(255, 255, 255));
        scrollPatient.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192), 3));

        tbl_view1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_view1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        tbl_view1.setFuenteFilas(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        tbl_view1.setFuenteFilasSelect(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        tbl_view1.setFuenteHead(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        tbl_view1.setGrosorBordeFilas(0);
        tbl_view1.setGrosorBordeHead(0);
        tbl_view1.setMultipleSeleccion(false);
        tbl_view1.getTableHeader().setReorderingAllowed(false);
        tbl_view1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_view1MouseClicked(evt);
            }
        });
        scrollPatient.setViewportView(tbl_view1);

        javax.swing.GroupLayout PatientAllLayout = new javax.swing.GroupLayout(PatientAll);
        PatientAll.setLayout(PatientAllLayout);
        PatientAllLayout.setHorizontalGroup(
            PatientAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientAllLayout.createSequentialGroup()
                .addComponent(scrollPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PatientAllLayout.setVerticalGroup(
            PatientAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientAllLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(scrollPatient, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
        );

        tab2.add(PatientAll, "card4");

        PatientToday.setBackground(new java.awt.Color(255, 255, 255));
        PatientToday.setLayout(new javax.swing.BoxLayout(PatientToday, javax.swing.BoxLayout.LINE_AXIS));

        scrollPatient1.setBackground(new java.awt.Color(255, 255, 255));
        scrollPatient1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192), 3));

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
        });
        scrollPatient1.setViewportView(tbl_view);

        PatientToday.add(scrollPatient1);

        tab2.add(PatientToday, "card4");

        Search.add(tab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 890, 380));

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(0, 124, 134));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Select Doctor");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 50, 100, 30));

        jLabel16.setBackground(new java.awt.Color(0, 85, 94));
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Today patients");
        jLabel16.setOpaque(true);
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 110, 30));

        jLabel15.setBackground(new java.awt.Color(0, 85, 94));
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("All patients");
        jLabel15.setOpaque(true);
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 110, 30));

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
        jPanel1.add(Filter_schedule, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 130, -1));

        Search.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 90));

        root.add(Search);
        Search.setBounds(20, 90, 890, 480);

        PatientMonitoring.setBackground(new java.awt.Color(255, 255, 255));
        PatientMonitoring.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Patient monitoring", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        PatientMonitoring.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Total of Consultation done =");
        jLabel3.setPreferredSize(new java.awt.Dimension(114, 21));
        PatientMonitoring.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 160, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Total of patient appointment =");
        jLabel4.setPreferredSize(new java.awt.Dimension(114, 21));
        PatientMonitoring.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 170, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Total of waiting patients =");
        jLabel5.setPreferredSize(new java.awt.Dimension(114, 21));
        PatientMonitoring.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 160, 30));

        total_done.setBackground(new java.awt.Color(51, 102, 255));
        total_done.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        total_done.setForeground(new java.awt.Color(255, 255, 255));
        total_done.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total_done.setText("0");
        total_done.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        total_done.setEnabled(false);
        PatientMonitoring.add(total_done, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 45, 34));

        total_apoint.setBackground(new java.awt.Color(51, 102, 255));
        total_apoint.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        total_apoint.setForeground(new java.awt.Color(255, 255, 255));
        total_apoint.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total_apoint.setText("0");
        total_apoint.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        total_apoint.setEnabled(false);
        PatientMonitoring.add(total_apoint, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 45, 34));

        total_wait.setBackground(new java.awt.Color(51, 102, 255));
        total_wait.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        total_wait.setForeground(new java.awt.Color(255, 255, 255));
        total_wait.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total_wait.setText("0");
        total_wait.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        total_wait.setEnabled(false);
        PatientMonitoring.add(total_wait, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 45, 34));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Total of patient appointment:");
        PatientMonitoring.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 160, 30));

        total_apoint1.setBackground(new java.awt.Color(0, 153, 153));
        total_apoint1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        total_apoint1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total_apoint1.setEnabled(false);
        PatientMonitoring.add(total_apoint1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 45, 34));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Available slot");
        jLabel7.setPreferredSize(new java.awt.Dimension(155, 21));
        PatientMonitoring.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 80, 30));

        total_slot.setBackground(new java.awt.Color(51, 102, 255));
        total_slot.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        total_slot.setForeground(new java.awt.Color(255, 255, 255));
        total_slot.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total_slot.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        total_slot.setEnabled(false);
        PatientMonitoring.add(total_slot, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 45, 34));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Total of patient use Cash = ");
        jLabel8.setPreferredSize(new java.awt.Dimension(114, 21));
        PatientMonitoring.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 160, 30));

        total_cash.setBackground(new java.awt.Color(51, 102, 255));
        total_cash.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        total_cash.setForeground(new java.awt.Color(255, 255, 255));
        total_cash.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total_cash.setText("0");
        total_cash.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        total_cash.setEnabled(false);
        PatientMonitoring.add(total_cash, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 45, 34));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Total of patient use HMO = ");
        jLabel9.setPreferredSize(new java.awt.Dimension(114, 21));
        PatientMonitoring.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 160, 30));

        total_hmo.setBackground(new java.awt.Color(51, 102, 255));
        total_hmo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        total_hmo.setForeground(new java.awt.Color(255, 255, 255));
        total_hmo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total_hmo.setText("0");
        total_hmo.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        total_hmo.setEnabled(false);
        PatientMonitoring.add(total_hmo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 45, 34));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Total of  new patient = ");
        jLabel10.setPreferredSize(new java.awt.Dimension(114, 21));
        PatientMonitoring.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 160, 30));

        total_new.setBackground(new java.awt.Color(51, 102, 255));
        total_new.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        total_new.setForeground(new java.awt.Color(255, 255, 255));
        total_new.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total_new.setText("0");
        total_new.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        total_new.setDoubleBuffered(true);
        total_new.setEnabled(false);
        PatientMonitoring.add(total_new, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 45, 34));

        total_old.setEditable(false);
        total_old.setBackground(new java.awt.Color(51, 102, 255));
        total_old.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        total_old.setForeground(new java.awt.Color(255, 255, 255));
        total_old.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total_old.setText("0");
        total_old.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        total_old.setEnabled(false);
        PatientMonitoring.add(total_old, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 45, 34));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Total of  old patient = ");
        jLabel11.setPreferredSize(new java.awt.Dimension(114, 21));
        PatientMonitoring.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 160, 30));

        root.add(PatientMonitoring);
        PatientMonitoring.setBounds(930, 130, 230, 370);

        Totalallpatient.setBackground(new java.awt.Color(51, 102, 255));
        Totalallpatient.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Totalallpatient.setForeground(new java.awt.Color(255, 255, 255));
        Totalallpatient.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Totalallpatient.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        Totalallpatient.setEnabled(false);
        root.add(Totalallpatient);
        Totalallpatient.setBounds(1100, 510, 45, 40);

        total_patient.setBackground(new java.awt.Color(51, 102, 255));
        total_patient.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        total_patient.setForeground(new java.awt.Color(255, 255, 255));
        total_patient.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total_patient.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        total_patient.setEnabled(false);
        root.add(total_patient);
        total_patient.setBounds(1100, 510, 45, 40);

        totalToday.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        totalToday.setPreferredSize(new java.awt.Dimension(114, 21));
        root.add(totalToday);
        totalToday.setBounds(940, 510, 160, 40);

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
            .addComponent(root, javax.swing.GroupLayout.PREFERRED_SIZE, 1166, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(root, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        lblColor(jLabel16);
        rstColor(jLabel15);
        PatientToday.setVisible(true);
        totalToday.setText("Total of today patient :");
        totalToday.setVisible(true);
        total_patient.setVisible(true);
        Totalallpatient.setVisible(false);
        Totaall.setVisible(false);
        PatientAll.setVisible(false);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked

        lblColor(jLabel15);
        rstColor(jLabel16);
        PatientAll.setVisible(true);
        Totaall.setText("Total of all patient :");
        Totaall.setVisible(true);
        Totalallpatient.setVisible(true);
        total_patient.setVisible(false);
        totalToday.setVisible(false);
        PatientToday.setVisible(false);
    }//GEN-LAST:event_jLabel15MouseClicked

    private void tbl_view1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_view1MouseClicked
        /*  int row = tblPatient.rowAtPoint(evt.getPoint());
        if ((evt.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
            this.tblPatient.setRowSelectionInterval(row, row);
            MousePos = evt.getY() / 16;
            menuC.show(evt.getComponent(), evt.getX(), evt.getY());
        } else {
            this.tblPatient.setRowSelectionInterval(row, row);
        }*/
    }//GEN-LAST:event_tbl_view1MouseClicked

    private void tbl_viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_viewMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_viewMouseClicked

    private void Filter_schedulePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_Filter_schedulePopupMenuWillBecomeInvisible

    }//GEN-LAST:event_Filter_schedulePopupMenuWillBecomeInvisible

    private void Filter_scheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Filter_scheduleActionPerformed
        ((JLabel) Filter_schedule.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        Object obj = evt.getSource();
        {
            if (obj == Filter_schedule) {

                try {
                    String q = "select * from Core1_opd_consultlist where consult_day = DATENAME(weekday, GETDATE()) and \n"
                            + "                    cast (appontment_registered as date) =    convert (nvarchar,GETDATE(),101) and  doctor_name = '" + Filter_schedule.getSelectedItem() + "'";
                    //String q = "select * from Core1_opd_consultlist where doctor_name='" + Filter_schedule + "' ";

                    pst = con.prepareStatement(q);
                    rs = pst.executeQuery();
                    tbl_view.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                    System.out.println(e);
                }
                try {
                    String q = "select * from Core1_opd_consultlist where doctor_name = '" + Filter_schedule.getSelectedItem() + "' ";
                    //String q = "select * from Core1_opd_consultlist where doctor_name='" + Filter_schedule + "' ";

                    pst = con.prepareStatement(q);
                    rs = pst.executeQuery();
                    tbl_view1.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                    System.out.println(e);
                }
                try {

                    String q = "Select (Max_patient_today) as 'stat' FROM Core1_dra_publish where name='" + Filter_schedule.getSelectedItem() + "' ";

                    pst = con.prepareStatement(q);
                    rs = pst.executeQuery();
                    if (rs.next()) {

                        String stat = rs.getString("stat");
                        total_slot.setText(stat);
                    }
                } catch (Exception e) {
                    System.out.println(e);

                }
                try {

                    String q = "Select Count(status) as 'stat' FROM Core1_opd_consultlist where doctor_name='" + Filter_schedule.getSelectedItem() + "' "
                            + "and  cast (appontment_registered as date) =    convert (nvarchar,GETDATE(),101)";
                    pst = con.prepareStatement(q);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String total = rs.getString("stat");
                        total_apoint.setText(total);
                    }
                } catch (Exception e) {
                    System.out.println(e);

                }

                try {

                    String q = "Select Count(Status) as 'stat' FROM Core1_opd_consultlist where doctor_name='" + Filter_schedule.getSelectedItem() + "'\n"
                            + "and status='No vital signs yet' or status='Pending consultation' and  cast (appontment_registered as date) =    convert (nvarchar,GETDATE(),101)";

                    pst = con.prepareStatement(q);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String sum = rs.getString("stat");
                        total_wait.setText(sum);
                    }
                } catch (Exception e) {
                    System.out.println(e);

                }
                try {

                    String q = "Select Count(Status) as 'stat' FROM Core1_opd_consultlist where doctor_name='" + Filter_schedule.getSelectedItem() + "' and status='Done consultation' "
                            + "and  cast (appontment_registered as date) =    convert (nvarchar,GETDATE(),101)";

                    pst = con.prepareStatement(q);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String sum = rs.getString("stat");
                        total_done.setText(sum);
                    }
                } catch (Exception e) {
                    System.out.println(e);

                }
                try {

                    String q = "Select Count(mode_of_payment) as 'stat' FROM Core1_opd_consultlist where doctor_name='" + Filter_schedule.getSelectedItem() + "' and mode_of_payment ='CASH' "
                            + "and  cast (appontment_registered as date) =    convert (nvarchar,GETDATE(),101)";

                    pst = con.prepareStatement(q);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String sum = rs.getString("stat");
                        total_cash.setText(sum);
                    }
                } catch (Exception e) {
                    System.out.println(e);

                }
                try {

                    String q = "Select Count(mode_of_payment) as 'stat' FROM Core1_opd_consultlist where doctor_name='" + Filter_schedule.getSelectedItem() + "' and mode_of_payment ='HMO' "
                            + "and  cast (appontment_registered as date) =    convert (nvarchar,GETDATE(),101)";

                    pst = con.prepareStatement(q);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String sum = rs.getString("stat");
                        total_hmo.setText(sum);
                    }
                } catch (Exception e) {
                    System.out.println(e);

                }
                try {

                    String q = "Select Count(patient_type) as 'stat' FROM Core1_opd_consultlist where doctor_name='" + Filter_schedule.getSelectedItem() + "' and patient_type ='NEW' "
                            + "and  cast (appontment_registered as date) =    convert (nvarchar,GETDATE(),101)";

                    pst = con.prepareStatement(q);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String sum = rs.getString("stat");
                        total_old.setText(sum);
                    }
                } catch (Exception e) {
                    System.out.println(e);

                }
                try {

                    String q = "Select Count(patient_type) as 'stat' FROM Core1_opd_consultlist where doctor_name='" + Filter_schedule.getSelectedItem() + "' and patient_type ='OLD' "
                            + "and  cast (appontment_registered as date) =    convert (nvarchar,GETDATE(),101)";

                    pst = con.prepareStatement(q);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String sum = rs.getString("stat");
                        total_old.setText(sum);
                    }
                } catch (Exception e) {
                    System.out.println(e);

                }

            } else {
                try {
                    String sql = "Select   Count(*) from  Core1_opd_consultlist where    consult_day= DATENAME(weekday, GETDATE()) and appontment_registered<=(getdate()) ";
                    //where Schedule = DATENAME(weekday, GETDATE())
                    stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    rs = stmt.executeQuery(sql);
                    tbl_view.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        }
    }//GEN-LAST:event_Filter_scheduleActionPerformed
    public void lblColor(JLabel lbl) {
        lbl.setBackground(new Color(0, 85, 94));
    }

    public void rstColor(JLabel lbl) {
        lbl.setBackground(new Color(0, 124, 134));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSComboMetro Filter_schedule;
    private javax.swing.JPanel PatientAll;
    private javax.swing.JPanel PatientMonitoring;
    private javax.swing.JPanel PatientToday;
    private javax.swing.JPanel Search;
    private javax.swing.JLabel Totaall;
    private javax.swing.JTextField Totalallpatient;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel root;
    public static javax.swing.JScrollPane scrollPatient;
    public static javax.swing.JScrollPane scrollPatient1;
    private javax.swing.JPanel tab2;
    public static rojerusan.RSTableMetro tbl_view;
    public static rojerusan.RSTableMetro tbl_view1;
    private javax.swing.JLabel totalToday;
    private javax.swing.JTextField total_apoint;
    private javax.swing.JTextField total_apoint1;
    private javax.swing.JTextField total_cash;
    private javax.swing.JTextField total_done;
    private javax.swing.JTextField total_hmo;
    private javax.swing.JTextField total_new;
    private javax.swing.JTextField total_old;
    private javax.swing.JTextField total_patient;
    private javax.swing.JTextField total_slot;
    private javax.swing.JTextField total_wait;
    // End of variables declaration//GEN-END:variables
}
