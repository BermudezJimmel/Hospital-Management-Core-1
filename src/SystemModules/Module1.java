package SystemModules;

import Module1SubModules.Patientregistration;
import Module1SubModules.PatientInformation;
import Module1SubModules.SubModule3;
import Module1SubModules.SubModule4;
import Module1SubModules.SubModule5;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Module1 extends javax.swing.JPanel {

    Patientregistration sm1;
    PatientInformation sm2;
    SubModule3 sm3;
    SubModule4 sm4;
    SubModule5 sm5;

    public Module1() {
        initComponents();
        this.sm1 = new Patientregistration();
        this.sm2 = new PatientInformation();
        this.sm3 = new SubModule3();
        this.sm4 = new SubModule4();
        this.sm5 = new SubModule5();

        root.add(sm1);
        btn1.setForeground(new Color(46, 41, 241));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        indicator = new javax.swing.JLabel();
        root = new javax.swing.JPanel();

        setBackground(new java.awt.Color(240, 240, 240));
        setMaximumSize(new java.awt.Dimension(1162, 652));
        setMinimumSize(new java.awt.Dimension(1162, 652));
        setPreferredSize(new java.awt.Dimension(1162, 652));
        setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(240, 240, 240));
        jPanel3.setLayout(null);

        btn1.setForeground(new java.awt.Color(153, 153, 153));
        btn1.setText("Patient Registration");
        btn1.setContentAreaFilled(false);
        btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn1.setFocusable(false);
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jPanel3.add(btn1);
        btn1.setBounds(11, 15, 150, 23);

        btn2.setForeground(new java.awt.Color(153, 153, 153));
        btn2.setText("Patient Information");
        btn2.setContentAreaFilled(false);
        btn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn2.setFocusable(false);
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jPanel3.add(btn2);
        btn2.setBounds(161, 15, 150, 23);

        indicator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/indicator1v.png"))); // NOI18N
        jPanel3.add(indicator);
        indicator.setBounds(10, 55, 1140, 5);

        add(jPanel3);
        jPanel3.setBounds(0, 0, 1166, 70);

        root.setBackground(new java.awt.Color(255, 255, 255));
        root.setForeground(new java.awt.Color(255, 255, 255));
        add(root);
        root.setBounds(0, 70, 1166, 582);
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed

        root.removeAll();
        ImageIcon II = new ImageIcon(getClass().getResource("/Images/indicator1v.png"));
        indicator.setIcon(II);
        btn1.setForeground(new Color(46, 41, 241));
        btn2.setForeground(new Color(153, 153, 153));

        root.add(sm1);
        root.revalidate();
        root.repaint();

    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed

        root.removeAll();
        ImageIcon II = new ImageIcon(getClass().getResource("/Images/indicator2v.png"));
        indicator.setIcon(II);
        btn2.setForeground(new Color(46, 41, 241));
        btn1.setForeground(new Color(153, 153, 153));

        root.add(sm2);
        root.revalidate();
        root.repaint();

    }//GEN-LAST:event_btn2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JLabel indicator;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JPanel root;
    // End of variables declaration//GEN-END:variables
}
