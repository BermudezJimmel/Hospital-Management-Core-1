package Module3SubModules;

import SystemInstance.MysqlConnect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author iRHONman
 */
public class patientHistory extends javax.swing.JFrame
{

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    CallableStatement cst = null;

    public patientHistory()
    {
        initComponents();
        con = MysqlConnect.ConnectDB();

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
        Findings_pnl = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel9 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        w = new javax.swing.JTextField();
        h = new javax.swing.JTextField();
        dd = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        find_patName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        find_patDr = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        find_drSpecia = new javax.swing.JTextField();
        Treatment = new javax.swing.JPanel();
        medType = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        medDosage = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        find_for = new javax.swing.JTextField();
        take = new javax.swing.JTextField();
        medicine = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        Diagnosis = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel34 = new javax.swing.JLabel();
        find_diag = new javax.swing.JTextField();
        diag_dd = new javax.swing.JTextField();
        Symptoms = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        find_dd = new javax.swing.JTextField();
        find_patSick = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        bt = new javax.swing.JTextField();
        bp = new javax.swing.JTextField();
        jExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Findings_pnl.setBackground(new java.awt.Color(255, 255, 255));
        Findings_pnl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        Findings_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(3, 131, 140));
        Findings_pnl.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1240, 10));

        jPanel9.setBackground(new java.awt.Color(240, 240, 240));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Initial Weight - Height", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setText("Weight:");
        jPanel9.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel21.setText("Height:");
        jPanel9.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        w.setEditable(false);
        w.setBackground(new java.awt.Color(255, 255, 255));
        w.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        w.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel9.add(w, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 60, -1));

        h.setEditable(false);
        h.setBackground(new java.awt.Color(255, 255, 255));
        h.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel9.add(h, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 60, -1));

        dd.setEditable(false);
        dd.setBackground(new java.awt.Color(255, 255, 255));
        dd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel9.add(dd, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 120, -1));

        jLabel35.setText("As of:");
        jPanel9.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, 30));

        Findings_pnl.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 290, 110));

        jPanel8.setBackground(new java.awt.Color(240, 240, 240));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Patient Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        find_patName.setEditable(false);
        find_patName.setBackground(new java.awt.Color(255, 255, 255));
        find_patName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.add(find_patName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 100, -1));

        jLabel3.setText("Name:");
        jPanel8.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, -1));

        jLabel17.setText("Doctor: ");
        jPanel8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        find_patDr.setEditable(false);
        find_patDr.setBackground(new java.awt.Color(255, 255, 255));
        find_patDr.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        find_patDr.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.add(find_patDr, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 102, -1));

        jLabel18.setText("Specialization");
        jPanel8.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        find_drSpecia.setEditable(false);
        find_drSpecia.setBackground(new java.awt.Color(255, 255, 255));
        find_drSpecia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        find_drSpecia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.add(find_drSpecia, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 102, -1));

        Findings_pnl.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 270, 110));

        Treatment.setBackground(new java.awt.Color(240, 240, 240));
        Treatment.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Treatment.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        medType.setEditable(false);
        medType.setBackground(new java.awt.Color(255, 255, 255));
        medType.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        medType.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        medType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                medTypeKeyReleased(evt);
            }
        });
        Treatment.add(medType, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 70, 30));

        jLabel28.setText("For");
        Treatment.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 30, 30));

        jLabel27.setText("Take every");
        Treatment.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, 30));

        jLabel30.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("-");
        Treatment.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 20, 30));

        jLabel25.setText("Dosage");
        Treatment.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 30));

        medDosage.setEditable(false);
        medDosage.setBackground(new java.awt.Color(255, 255, 255));
        medDosage.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        medDosage.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        medDosage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medDosageActionPerformed(evt);
            }
        });
        medDosage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                medDosageKeyReleased(evt);
            }
        });
        Treatment.add(medDosage, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 90, 30));

        jPanel6.setBackground(new java.awt.Color(3, 131, 140));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Prescription");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(343, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Treatment.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 460, -1));

        find_for.setEditable(false);
        find_for.setBackground(new java.awt.Color(255, 255, 255));
        find_for.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        find_for.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        find_for.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                find_forKeyReleased(evt);
            }
        });
        Treatment.add(find_for, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 90, 30));

        take.setEditable(false);
        take.setBackground(new java.awt.Color(255, 255, 255));
        take.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        take.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        take.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                takeKeyReleased(evt);
            }
        });
        Treatment.add(take, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 90, 30));

        medicine.setEditable(false);
        medicine.setBackground(new java.awt.Color(255, 255, 255));
        medicine.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        medicine.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Treatment.add(medicine, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 240, 30));

        jLabel26.setText("Medicine");
        Treatment.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 30));

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Medicine description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jTextArea3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTextArea3AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTextArea3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea3KeyReleased(evt);
            }
        });
        jScrollPane6.setViewportView(jTextArea3);

        Treatment.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 430, 120));

        Findings_pnl.add(Treatment, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 140, 460, 250));

        Diagnosis.setBackground(new java.awt.Color(240, 240, 240));
        Diagnosis.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Diagnosis.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setText("Diagnosis Title:");
        Diagnosis.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 30));

        jPanel2.setBackground(new java.awt.Color(3, 131, 140));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Diagnostics");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Diagnosis.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 370, -1));

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Diagnosis description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jTextArea2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTextArea2AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTextArea2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea2KeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(jTextArea2);

        Diagnosis.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 310, 120));

        jLabel34.setText("Date");
        Diagnosis.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 60, 30));

        find_diag.setEditable(false);
        find_diag.setBackground(new java.awt.Color(255, 255, 255));
        find_diag.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        find_diag.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        find_diag.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                find_diagKeyReleased(evt);
            }
        });
        Diagnosis.add(find_diag, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 150, 30));

        diag_dd.setEditable(false);
        diag_dd.setBackground(new java.awt.Color(255, 255, 255));
        diag_dd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        diag_dd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        diag_dd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                diag_ddKeyReleased(evt);
            }
        });
        Diagnosis.add(diag_dd, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 120, 30));

        Findings_pnl.add(Diagnosis, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 360, 260));

        Symptoms.setBackground(new java.awt.Color(240, 240, 240));
        Symptoms.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Symptoms.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setText("Since:");
        Symptoms.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 40, 30));

        find_dd.setEditable(false);
        find_dd.setBackground(new java.awt.Color(255, 255, 255));
        find_dd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        find_dd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        find_dd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                find_ddActionPerformed(evt);
            }
        });
        Symptoms.add(find_dd, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 110, 30));

        find_patSick.setEditable(false);
        find_patSick.setBackground(new java.awt.Color(255, 255, 255));
        find_patSick.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        find_patSick.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Symptoms.add(find_patSick, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 180, 30));

        jPanel3.setBackground(new java.awt.Color(3, 131, 140));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Symptoms");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Symptoms.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 380, 30));

        jLabel31.setText("Symptoms Title:");
        Symptoms.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 30));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Symptoms description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jTextArea1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTextArea1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        Symptoms.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 340, 130));

        Findings_pnl.add(Symptoms, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 360, 260));

        jPanel7.setBackground(new java.awt.Color(240, 240, 240));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Vital signs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setText("Body temperature:");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 110, -1));

        jLabel7.setText("Blood presusre:");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 90, -1));

        bt.setEditable(false);
        bt.setBackground(new java.awt.Color(255, 255, 255));
        bt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.add(bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 60, -1));

        bp.setEditable(false);
        bp.setBackground(new java.awt.Color(255, 255, 255));
        bp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.add(bp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 60, -1));

        Findings_pnl.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 230, 110));

        jPanel1.add(Findings_pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 1240, 420));

        jExit.setBackground(new java.awt.Color(0, 102, 102));
        jExit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jExit.setText("Back");
        jExit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jExit.setPreferredSize(new java.awt.Dimension(83, 25));
        jExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExitActionPerformed(evt);
            }
        });
        jPanel1.add(jExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 530, 180, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextArea1KeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTextArea1KeyReleased
    {//GEN-HEADEREND:event_jTextArea1KeyReleased
    }//GEN-LAST:event_jTextArea1KeyReleased

    private void jTextArea2KeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTextArea2KeyReleased
    {//GEN-HEADEREND:event_jTextArea2KeyReleased
    }//GEN-LAST:event_jTextArea2KeyReleased

    private void jTextArea3KeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTextArea3KeyReleased
    {//GEN-HEADEREND:event_jTextArea3KeyReleased
    }//GEN-LAST:event_jTextArea3KeyReleased

    private void jTextArea2AncestorAdded(javax.swing.event.AncestorEvent evt)//GEN-FIRST:event_jTextArea2AncestorAdded
    {//GEN-HEADEREND:event_jTextArea2AncestorAdded
        jTextArea2.setLineWrap(true);
        jTextArea2.setWrapStyleWord(true);
    }//GEN-LAST:event_jTextArea2AncestorAdded

    private void jTextArea3AncestorAdded(javax.swing.event.AncestorEvent evt)//GEN-FIRST:event_jTextArea3AncestorAdded
    {//GEN-HEADEREND:event_jTextArea3AncestorAdded
        jTextArea3.setLineWrap(true);
        jTextArea3.setWrapStyleWord(true);
    }//GEN-LAST:event_jTextArea3AncestorAdded

    private void medDosageKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_medDosageKeyReleased
    {//GEN-HEADEREND:event_medDosageKeyReleased


    }//GEN-LAST:event_medDosageKeyReleased

    private void takeKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_takeKeyReleased
    {//GEN-HEADEREND:event_takeKeyReleased

    }//GEN-LAST:event_takeKeyReleased

    private void medTypeKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_medTypeKeyReleased
    {//GEN-HEADEREND:event_medTypeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_medTypeKeyReleased

    private void diag_ddKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_diag_ddKeyReleased
    {//GEN-HEADEREND:event_diag_ddKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_diag_ddKeyReleased

    private void jTextArea1AncestorAdded(javax.swing.event.AncestorEvent evt)//GEN-FIRST:event_jTextArea1AncestorAdded
    {//GEN-HEADEREND:event_jTextArea1AncestorAdded
        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
    }//GEN-LAST:event_jTextArea1AncestorAdded

    private void medDosageActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_medDosageActionPerformed
    {//GEN-HEADEREND:event_medDosageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_medDosageActionPerformed

    private void find_diagKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_find_diagKeyReleased
    {//GEN-HEADEREND:event_find_diagKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_find_diagKeyReleased

    private void find_forKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_find_forKeyReleased
    {//GEN-HEADEREND:event_find_forKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_find_forKeyReleased

    private void jExitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jExitActionPerformed
    {//GEN-HEADEREND:event_jExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_jExitActionPerformed

    private void find_ddActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_find_ddActionPerformed
    {//GEN-HEADEREND:event_find_ddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_find_ddActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(patientHistory.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(patientHistory.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(patientHistory.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(patientHistory.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new patientHistory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Diagnosis;
    private javax.swing.JPanel Findings_pnl;
    private javax.swing.JPanel Symptoms;
    private javax.swing.JPanel Treatment;
    public static javax.swing.JTextField bp;
    public static javax.swing.JTextField bt;
    public static javax.swing.JTextField dd;
    public static javax.swing.JTextField diag_dd;
    public static javax.swing.JTextField find_dd;
    public static javax.swing.JTextField find_diag;
    public static javax.swing.JTextField find_drSpecia;
    public static javax.swing.JTextField find_for;
    public static javax.swing.JTextField find_patDr;
    public static javax.swing.JTextField find_patName;
    public static javax.swing.JTextField find_patSick;
    public static javax.swing.JTextField h;
    private javax.swing.JButton jExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JTextArea jTextArea1;
    public static javax.swing.JTextArea jTextArea2;
    public static javax.swing.JTextArea jTextArea3;
    public static javax.swing.JTextField medDosage;
    public static javax.swing.JTextField medType;
    public static javax.swing.JTextField medicine;
    public static javax.swing.JTextField take;
    public static javax.swing.JTextField w;
    // End of variables declaration//GEN-END:variables
}
