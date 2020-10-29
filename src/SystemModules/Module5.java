package SystemModules;

import Module5SubModules.Bedmonitoring;
import Module5SubModules.HousekeepingAssign;
import Module5SubModules.LinenInventory;
import Module5SubModules.LinenMonitoring;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Module5 extends javax.swing.JPanel {

    Bedmonitoring sm1;
    HousekeepingAssign sm3;
    LinenInventory sm4;
    LinenMonitoring sm5;

    public Module5() {
        initComponents();
        this.sm1 = new Bedmonitoring();
        this.sm3 = new HousekeepingAssign();
        this.sm4 = new LinenInventory();
        this.sm5 = new LinenMonitoring();

        root.add(sm1);
        btn1.setForeground(new Color(46, 41, 241));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        indicator = new javax.swing.JLabel();
        btn1 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        root = new javax.swing.JPanel();

        setBackground(new java.awt.Color(240, 240, 240));
        setMaximumSize(new java.awt.Dimension(1162, 652));
        setMinimumSize(new java.awt.Dimension(1162, 652));
        setPreferredSize(new java.awt.Dimension(1162, 652));
        setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(240, 240, 240));
        jPanel3.setLayout(null);

        indicator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/indicator1v.png"))); // NOI18N
        jPanel3.add(indicator);
        indicator.setBounds(10, 55, 1140, 5);

        btn1.setForeground(new java.awt.Color(153, 153, 153));
        btn1.setText("Bed Monitoring");
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

        btn3.setForeground(new java.awt.Color(153, 153, 153));
        btn3.setText("Housekeeping");
        btn3.setContentAreaFilled(false);
        btn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn3.setFocusable(false);
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        jPanel3.add(btn3);
        btn3.setBounds(160, 15, 150, 23);

        btn4.setForeground(new java.awt.Color(153, 153, 153));
        btn4.setText("Linen Inventory");
        btn4.setContentAreaFilled(false);
        btn4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn4.setFocusable(false);
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        jPanel3.add(btn4);
        btn4.setBounds(310, 15, 150, 23);

        btn5.setForeground(new java.awt.Color(153, 153, 153));
        btn5.setText("Linen Monitoring");
        btn5.setContentAreaFilled(false);
        btn5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn5.setFocusable(false);
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        jPanel3.add(btn5);
        btn5.setBounds(460, 15, 150, 23);

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
        btn3.setForeground(new Color(153, 153, 153));
        btn4.setForeground(new Color(153, 153, 153));
        btn5.setForeground(new Color(153, 153, 153));
        root.add(sm1);
        root.revalidate();
        root.repaint();
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed

        root.removeAll();
        ImageIcon II = new ImageIcon(getClass().getResource("/Images/indicator2v.png"));
        indicator.setIcon(II);
        btn3.setForeground(new Color(46, 41, 241));
        btn1.setForeground(new Color(153, 153, 153));
        btn4.setForeground(new Color(153, 153, 153));
        btn5.setForeground(new Color(153, 153, 153));
        root.add(sm3);
        root.revalidate();
        root.repaint();
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed

        root.removeAll();
        ImageIcon II = new ImageIcon(getClass().getResource("/Images/indicator3v.png"));
        indicator.setIcon(II);
        btn4.setForeground(new Color(46, 41, 241));
        btn1.setForeground(new Color(153, 153, 153));
        btn3.setForeground(new Color(153, 153, 153));
        btn5.setForeground(new Color(153, 153, 153));
        root.add(sm4);
        root.revalidate();
        root.repaint();

    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed

        root.removeAll();
        ImageIcon II = new ImageIcon(getClass().getResource("/Images/indicator4v.png"));
        indicator.setIcon(II);
        btn5.setForeground(new Color(46, 41, 241));
        btn1.setForeground(new Color(153, 153, 153));
        btn3.setForeground(new Color(153, 153, 153));
        btn4.setForeground(new Color(153, 153, 153));
        root.add(sm5);
        root.revalidate();
        root.repaint();

    }//GEN-LAST:event_btn5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JLabel indicator;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JPanel root;
    // End of variables declaration//GEN-END:variables
}
