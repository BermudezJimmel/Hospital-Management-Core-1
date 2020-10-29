/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module4SubModules;

import Notifications.DesktopNotify;
import SystemInstance.MysqlConnect;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showConfirmDialog;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Jimmel Bermudez
 */
public class INPATIENTM extends javax.swing.JPanel {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    GridBagLayout layout = new GridBagLayout();
    Statement stmt = null;
    boolean true_false;

    /**
     * Creates new form INPATIENT
     */
    public INPATIENTM() {
        initComponents();
        conn = MysqlConnect.ConnectDB();
   /*     Diagnosis();
        addllergy();
        Clinical();
        CurrentDate();
        date_dayv2.setVisible(false);
        qqqq();
        fillAll1.setVisible(false);
        txt_dr_ln.setVisible(false);
        PE();
        Ros();
        Vitals();
        jim1();
        jim2();
        jim3();
//        jim4();
//        jim5();
//        jim6();
//        jim7();
//        jim8();
//        jim9();
//        jim10();

        fillAll.setVisible(false);
        fillAll3.setVisible(false);
        fillAll2.setVisible(false);
        one();
        Linenitems();
        Linenna();
        Linenna1();
        Diagnosisview();
        DateValidation();
   //     Diagnosisview1();
        MedList_tbl();
        Request_tbl();
        combo_item4();*/
    }

    private void MedList_tbl() {
        try {
            String sql = "SELECT Item_Name,Description,Unit,Stock_Status,Price FROM Core3_PMC_Inventory";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            available.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void Request_tbl() {
        try {
            String sql = "SELECT RequestMedicineName AS 'MedicineName',Type AS 'Medicine Type',Items AS 'Medicine Item',Quantity AS 'Quantity' "
                    + "FROM Core3_PMC_MedRequestList WHERE Status = 'Pending'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            Request.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void combo_item4() {

        try {
            Item_Name1.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Select Item"}));
            String sql = "SELECT * FROM Core3_PMC_Inventory";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Item_Name1.addItem(rs.getString("Item_Name"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void DateValidation() {

        Date min = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
        sdf.format(min);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 2);
        Date max = cal.getTime();

        bday6.setDate(min);
        bday6.setSelectableDateRange(min, max);

    }

    private void Diagnosisview() {

        try {
            Timer timer = new Timer(30, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String sql = "select Core1_ipd_AddDiagnosis .Diagnosis_no,\n"
                                + "Core1_pr_PatientRegistration.FirstName,\n"
                                + "concat ('Dr.',Core1_dra_registered.surname,', ',Core1_dra_registered.name,' ',Core1_dra_registered.middlename,'  -  ',Core1_dra_registered.specialization )as 'Doctor Name',\n"
                                + "Core1_ipd_AddDiagnosis.Title,\n"
                                + "Core1_ipd_AddDiagnosis.Date\n"
                                + "from Core1_dra_registered\n"
                                + "inner join Core1_ipd_AddDiagnosis\n"
                                + "on Core1_dra_registered.Dr_ID=Core1_ipd_AddDiagnosis.Doctor_ID\n"
                                + "inner join Core1_pr_PatientRegistration\n"
                                + "on Core1_ipd_AddDiagnosis.Patient_ID=Core1_pr_PatientRegistration.Patient_ID where Core1_pr_PatientRegistration.Patient_ID='" + NAME.getText() + "'";
                        pst = conn.prepareStatement(sql);
                        rs = pst.executeQuery();

                        jTable2.setModel(DbUtils.resultSetToTableModel(rs));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Eroor" + ex, "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }
            });
            timer.start();
        } catch (Exception e) {

        }

    }

    private void Diagnosisview1() {

        try {
            Timer timer = new Timer(30, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String sql = "select concat(Date,'  -  ',Title) as 'Add Surgery' from Core1_ipd_AddSurgery where Patient_ID='" + NAME.getText() + "'";
                        pst = conn.prepareStatement(sql);
                        rs = pst.executeQuery();

                        tbl_allergy.setModel(DbUtils.resultSetToTableModel(rs));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Eroor" + ex, "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }
            });
            timer.start();
        } catch (Exception e) {

        }

    }

    private void Linenna() {
        try {
            Timer timer = new Timer(30, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String sql = "select Requestor,item,quantity,datereq,status from Core1_ipd_linenreq where Patient_ID='" + NAME.getText() + "'";
                        pst = conn.prepareStatement(sql);
                        rs = pst.executeQuery();
                        jTable11.setModel(DbUtils.resultSetToTableModel(rs));

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Eroor" + ex, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            timer.start();
        } catch (Exception e) {

        }

    }

    private void Linenna1() {
        try {
            Timer timer = new Timer(30, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String sql = "select concat(datereq,'  -  ',item) as 'Linen Request' from Core1_ipd_linenreq where Patient_ID='" + NAME.getText() + "'";
                        pst = conn.prepareStatement(sql);
                        rs = pst.executeQuery();
                        tbl_treatment.setModel(DbUtils.resultSetToTableModel(rs));

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Eroor" + ex, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            timer.start();
        } catch (Exception e) {

        }

    }

    private void Linenitems() {

        try {
            String sql = "select Stock_ID as 'STOCK NO.',Item as ITEM , Quantity as QUANTITY from Core1_lm_inventory";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable12.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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
        date_dayv2.setText((buwan) + "/" + (day1) + "/" + year + " " + hour + ":" + mn + day_night);
        //  dd.setText((buwan) + "/" + (day1) + "/" + year + " " + hour + ":" + mn + day_night);
    }

    private void two() {
        fillAll3.setVisible(true);
        search12.setEditable(true);
        lname2.setEditable(true);
        insert1.setEditable(true);
    }

    private void one() {

//ROS    
        search9.setEditable(false);
        search8.setEditable(false);
        q1.setEditable(false);
        w1.setEditable(false);
        e1.setEditable(false);
        r1.setEditable(false);
        t1.setEditable(false);
        u1.setEditable(false);
        i1.setEditable(false);
        o1.setEditable(false);
        fillAll.setVisible(false);
        jButton9.setVisible(false);

        search9.setText("");
        search8.setText("");
        q1.setText("");
        w1.setText("");
        e1.setText("");
        r1.setText("");
        t1.setText("");
        u1.setText("");
        i1.setText("");
        o1.setText("");
//vitals
        z.setEditable(false);
        x.setEditable(false);
        c.setEditable(false);
        v.setEditable(false);
        fillAll1.setVisible(false);

        z.setText("");
        x.setText("");
        c.setText("");
        v.setText("");

        //PE
        search17.setEditable(false);
        qq1.setEditable(false);
        ww1.setEditable(false);
        ee1.setEditable(false);
        rr1.setEditable(false);
        tt1.setEditable(false);
        yy1.setEditable(false);
        uu1.setEditable(false);
        ii1.setEditable(false);
        oo1.setEditable(false);
        pp1.setEditable(false);
        aa1.setEditable(false);
        ss1.setEditable(false);
        fillAll1.setVisible(false);

        search17.setText("");
        qq1.setText("");
        ww1.setText("");
        ee1.setText("");
        rr1.setText("");
        tt1.setText("");
        yy1.setText("");
        uu1.setText("");
        ii1.setText("");
        oo1.setText("");
        pp1.setText("");
        aa1.setText("");
        ss1.setText("");
        search16.setText("");

    }

    private void jim2() {
        try {
            Timer timer = new Timer(30, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String sql = "Select Core1_ipd_vitals.vitalno as 'No.',\n"
                                + "concat(Core1_ipd_vitals.bp,'  -  ',Core1_ipd_vitals.temp,' - (',Core1_ipd_vitals.height,', ',Core1_ipd_vitals.weight,')') as Vitals,\n"
                                + "Core1_ipd_vitals.date as 'Date'\n"
                                + "from Core1_ipd_vitals\n"
                                + "inner join Core1_dra_registered\n"
                                + "on Core1_ipd_vitals.Doctor=Core1_dra_registered.Dr_ID\n"
                                + "where Core1_ipd_vitals.Patient='" + NAME.getText() + "'";
                        pst = conn.prepareStatement(sql);
                        rs = pst.executeQuery();

                        jTable3.setModel(DbUtils.resultSetToTableModel(rs));

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Eroor" + ex, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            timer.start();
        } catch (Exception e) {

        }

    }

    private void jim1() {
        try {
            Timer timer = new Timer(30, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String sql = "select Core1_ipd_ROS.Ros as 'No.',Core1_ipd_ROS.General as Title, concat ('Dr.',Core1_dra_registered.surname,', ',Core1_dra_registered.name,' ',Core1_dra_registered.middlename,'  -  ',Core1_dra_registered.specialization )as 'Doctor Name',\n"
                                + "Core1_ipd_ROS.date as 'Date'\n"
                                + "from Core1_ipd_ROS\n"
                                + "inner join Core1_dra_registered\n"
                                + "on Core1_ipd_ROS.Dr_id=Core1_dra_registered.Dr_ID\n"
                                + "where Core1_ipd_ROS.Patient_ID='" + NAME.getText() + "'";
                        pst = conn.prepareStatement(sql);
                        rs = pst.executeQuery();

                        jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Eroor" + ex, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            timer.start();
        } catch (Exception e) {

        }

        try {

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void jim3() {
        try {
            Timer timer = new Timer(30, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String sql = "select Core1_ipd_PE.PEno as 'No.',\n"
                                + "Core1_ipd_PE.General as General,\n"
                                + "concat ('Dr.',Core1_dra_registered.surname,', ',Core1_dra_registered.name,' ',Core1_dra_registered.middlename,'  -  ',Core1_dra_registered.specialization )as 'Doctor Name',\n"
                                + "Core1_ipd_PE.date\n"
                                + "from Core1_ipd_PE\n"
                                + "inner join Core1_dra_registered\n"
                                + "on Core1_ipd_PE.Dr_id=Core1_dra_registered.Dr_ID\n"
                                + "where Core1_ipd_PE.Patient_ID='" + NAME.getText() + "'";
                        pst = conn.prepareStatement(sql);
                        rs = pst.executeQuery();

                        jTable5.setModel(DbUtils.resultSetToTableModel(rs));

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Eroor" + ex, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            timer.start();
        } catch (Exception e) {

        }

        try {

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
//    private void jim4() {
//
//        try {
//            String sql = "";
//            pst = conn.prepareStatement(sql);
//            rs = pst.executeQuery();
//
//            tbl_consultation2.setModel(DbUtils.resultSetToTableModel(rs));
//        } catch (Exception e) {
//             JOptionPane.showMessageDialog(null, e);
//        }
//
//    }
//    private void jim5() {
//
//        try {
//            String sql = "";
//            pst = conn.prepareStatement(sql);
//            rs = pst.executeQuery();
//
//            tbl_consultation2.setModel(DbUtils.resultSetToTableModel(rs));
//        } catch (Exception e) {
//             JOptionPane.showMessageDialog(null, e);
//        }
//
//    }
//    private void jim6() {
//
//        try {
//            String sql = "";
//            pst = conn.prepareStatement(sql);
//            rs = pst.executeQuery();
//
//            tbl_consultation2.setModel(DbUtils.resultSetToTableModel(rs));
//        } catch (Exception e) {
//             JOptionPane.showMessageDialog(null, e);
//        }
//
//    }
//    private void jim7() {
//
//        try {
//            String sql = "";
//            pst = conn.prepareStatement(sql);
//            rs = pst.executeQuery();
//
//            tbl_consultation2.setModel(DbUtils.resultSetToTableModel(rs));
//        } catch (Exception e) {
//             JOptionPane.showMessageDialog(null, e);
//        }
//
//    }
//    private void jim8() {
//
//        try {
//            String sql = "";
//            pst = conn.prepareStatement(sql);
//            rs = pst.executeQuery();
//
//            tbl_consultation2.setModel(DbUtils.resultSetToTableModel(rs));
//        } catch (Exception e) {
//             JOptionPane.showMessageDialog(null, e);
//        }
//
//    }
//    private void jim9() {
//
//        try {
//            String sql = "";
//            pst = conn.prepareStatement(sql);
//            rs = pst.executeQuery();
//
//            tbl_consultation2.setModel(DbUtils.resultSetToTableModel(rs));
//        } catch (Exception e) {
//             JOptionPane.showMessageDialog(null, e);
//        }
//
//    }
//    private void jim10() {
//
//        try {
//            String sql = "";
//            pst = conn.prepareStatement(sql);
//            rs = pst.executeQuery();
//
//            tbl_consultation2.setModel(DbUtils.resultSetToTableModel(rs));
//        } catch (Exception e) {
//             JOptionPane.showMessageDialog(null, e);
//        }
//
//    }

    private void addllergy() {

        try {
            Timer timer = new Timer(30, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String sql = "select concat(Date,'   -   ',Title) as 'Allergies' from Core1_ipd_AddAllergy where Patient_ID='" + NAME.getText() + "'";
                        pst = conn.prepareStatement(sql);
                        rs = pst.executeQuery();

                        tbl_surgeries.setModel(DbUtils.resultSetToTableModel(rs));

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Eroor" + ex, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            timer.start();
        } catch (Exception e) {

        }

    }

    private void Clinical() {
        try {
            Timer timer = new Timer(30, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String sql = "select concat(Date,'  -  ',Title) as 'Clinical Finding' from Core1_ipd_AddClinicalFindings where Patient_ID='" + NAME.getText() + "'";
                        pst = conn.prepareStatement(sql);
                        rs = pst.executeQuery();

                        tbl_clinical.setModel(DbUtils.resultSetToTableModel(rs));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Eroor" + ex, "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }
            });
            timer.start();
        } catch (Exception e) {

        }

    }

    private void Vitals() {

        try {
            Timer timer = new Timer(30, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String sql = "select\n"
                                + "concat(date,' - (',bp,'  -  ',temp,'(',height,', ',weight,'))') as Vitals\n"
                                + "from Core1_ipd_vitals where Patient='" + NAME.getText() + "'";
                        pst = conn.prepareStatement(sql);
                        rs = pst.executeQuery();

                        tbl_consultation2.setModel(DbUtils.resultSetToTableModel(rs));

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Eroor" + ex, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            timer.start();
        } catch (Exception e) {

        }

    }

    private void qqqq() {

        try {
            String sql = "select Title as Questions from Core1_ipd_q";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            qqqq.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void Diagnosis() {

        try {
            Timer timer = new Timer(30, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String sql = "select concat(Date,'  -  ',Title) as 'Diagnosis' from Core1_ipd_AddDiagnosis where Patient_ID='" + NAME.getText() + "'";
                        pst = conn.prepareStatement(sql);
                        rs = pst.executeQuery();

                        tbl_diagnosis.setModel(DbUtils.resultSetToTableModel(rs));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Eroor" + ex, "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }
            });
            timer.start();
        } catch (Exception e) {

        }

    }

//    private void Diagnosis() {
//
//        try {
//            String sql = "select concat(Date,'  -  ',Title) as 'Diagnosis' from Core1_ipd_AddDiagnosis where Patient_ID='"+ID.getText()+"'";
//            pst = conn.prepareStatement(sql);
//            rs = pst.executeQuery();
//
//            tbl_diagnosis.setModel(DbUtils.resultSetToTableModel(rs));
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//
//    }
    private void Ros() {
        try {
            Timer timer = new Timer(30, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String sql = "select concat(date,'  -  ',General) as 'Review of Systems' from Core1_ipd_ROS where Patient_ID='" + NAME.getText() + "'";
                        pst = conn.prepareStatement(sql);
                        rs = pst.executeQuery();

                        tbl_consultation1.setModel(DbUtils.resultSetToTableModel(rs));

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Eroor" + ex, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            timer.start();
        } catch (Exception e) {

        }

    }

    private void PE() {

        try {
            Timer timer = new Timer(30, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String sql = "select concat(date,'  -  ',General) as 'Physical Examination' from Core1_ipd_PE where Patient_ID='" + NAME.getText() + "'";
                        pst = conn.prepareStatement(sql);
                        rs = pst.executeQuery();

                        tbl_consultation.setModel(DbUtils.resultSetToTableModel(rs));

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Eroor" + ex, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            timer.start();
        } catch (Exception e) {

        }

        try {

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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

        AddConsultation = new javax.swing.JDialog();
        paraclinicalfinding = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        room5 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        search3 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        search7 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jTabbedPane7 = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        q = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        t = new javax.swing.JTextArea();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        u = new javax.swing.JTextArea();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        i = new javax.swing.JTextArea();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        o = new javax.swing.JTextArea();
        jScrollPane19 = new javax.swing.JScrollPane();
        r = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        e = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        w = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txt_day = new javax.swing.JTextField();
        txt_c_id = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        note = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        ss = new javax.swing.JTextField();
        aa = new javax.swing.JTextField();
        pp = new javax.swing.JTextField();
        oo = new javax.swing.JTextField();
        ii = new javax.swing.JTextField();
        uu = new javax.swing.JTextField();
        yy = new javax.swing.JTextField();
        tt = new javax.swing.JTextField();
        rr = new javax.swing.JTextField();
        ee = new javax.swing.JTextField();
        ww = new javax.swing.JTextField();
        qq = new javax.swing.JTextField();
        sub_module_1_btn4 = new javax.swing.JButton();
        AddTreatment = new javax.swing.JDialog();
        treatment = new javax.swing.JPanel();
        sub_module_1_btn2 = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();
        sub_module_1_btn8 = new javax.swing.JButton();
        sub_module_1_btn9 = new javax.swing.JButton();
        AddDiagnosis1 = new javax.swing.JDialog();
        diagnosis = new javax.swing.JPanel();
        lname = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        insert = new javax.swing.JTextArea();
        sub_module_1_btn1 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        room2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        sub_module_1_btn10 = new javax.swing.JButton();
        search1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        search2 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        AddMedicine = new javax.swing.JDialog();
        paraclinicalfinding2 = new javax.swing.JPanel();
        jPanel66 = new javax.swing.JPanel();
        jLabel142 = new javax.swing.JLabel();
        room8 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        search29 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        search30 = new javax.swing.JTextField();
        jLabel144 = new javax.swing.JLabel();
        jTabbedPane9 = new javax.swing.JTabbedPane();
        jPanel70 = new javax.swing.JPanel();
        jPanel67 = new javax.swing.JPanel();
        jPanel68 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        Request_Name = new javax.swing.JTextField();
        Medicine_Type = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        Inpatient = new javax.swing.JTextField();
        jLabel161 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        Item_Name1 = new javax.swing.JComboBox();
        IQuantity = new javax.swing.JTextField();
        Requestor = new javax.swing.JTextField();
        Price = new javax.swing.JTextField();
        Urgent = new javax.swing.JComboBox();
        jLabel168 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        available = new javax.swing.JTable();
        jLabel169 = new javax.swing.JLabel();
        jScrollPane66 = new javax.swing.JScrollPane();
        Request = new javax.swing.JTable();
        jLabel170 = new javax.swing.JLabel();
        add1 = new javax.swing.JButton();
        add = new javax.swing.JButton();
        AddClinicalFinding1 = new javax.swing.JDialog();
        clinicalfinding = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        sub_module_1_btn3 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        title = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        room3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        AddAllergyDRID = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        search4 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        AddAllergy1 = new javax.swing.JDialog();
        allergy1 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        sub_module_1_btn7 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        title1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        room4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        search5 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        search6 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        AddBedandLinen = new javax.swing.JDialog();
        diagnosis10 = new javax.swing.JPanel();
        jPanel69 = new javax.swing.JPanel();
        jLabel147 = new javax.swing.JLabel();
        room17 = new javax.swing.JLabel();
        jPanel71 = new javax.swing.JPanel();
        jScrollPane63 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable()
        {
            @Override

            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex)
            {
                Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);

                Object value = getModel().getValueAt(rowIndex,columnIndex);

                if(columnIndex == 4)
                {

                    if(value.equals("Pending request"))
                    {

                        componenet.setBackground(Color.GREEN);
                        componenet.setForeground(Color.BLACK);

                    }
                    if(value.equals("Approved request"))
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
        room18 = new javax.swing.JLabel();
        txt_item = new javax.swing.JTextField();
        jLabel150 = new javax.swing.JLabel();
        jScrollPane65 = new javax.swing.JScrollPane();
        jTable12 = new javax.swing.JTable();
        room19 = new javax.swing.JLabel();
        txt_item1 = new javax.swing.JTextField();
        jLabel159 = new javax.swing.JLabel();
        txt_dr_ln = new javax.swing.JTextField();
        sub_module_1_btn5 = new javax.swing.JButton();
        AddBedandLinenTbl = new javax.swing.JDialog();
        diagnosis7 = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        jLabel126 = new javax.swing.JLabel();
        room14 = new javax.swing.JLabel();
        jButton23 = new javax.swing.JButton();
        fillAll8 = new rojerusan.RSMaterialButtonRound();
        jPanel51 = new javax.swing.JPanel();
        jScrollPane47 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jLabel127 = new javax.swing.JLabel();
        cbFilter8 = new rojerusan.RSComboMetro();
        jLabel128 = new javax.swing.JLabel();
        search24 = new javax.swing.JTextField();
        jButton24 = new javax.swing.JButton();
        search25 = new javax.swing.JTextField();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        lname7 = new javax.swing.JTextField();
        jScrollPane48 = new javax.swing.JScrollPane();
        insert6 = new javax.swing.JTextArea();
        jLabel131 = new javax.swing.JLabel();
        Q = new javax.swing.JDialog();
        diagnosis1 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        qqqq = new javax.swing.JTable();
        AddLaboratory = new javax.swing.JDialog();
        LABORATORY_PANEL = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox17 = new javax.swing.JCheckBox();
        jCheckBox19 = new javax.swing.JCheckBox();
        jCheckBox21 = new javax.swing.JCheckBox();
        jPanel12 = new javax.swing.JPanel();
        jCheckBox22 = new javax.swing.JCheckBox();
        jCheckBox23 = new javax.swing.JCheckBox();
        jCheckBox24 = new javax.swing.JCheckBox();
        jCheckBox25 = new javax.swing.JCheckBox();
        jCheckBox26 = new javax.swing.JCheckBox();
        jCheckBox27 = new javax.swing.JCheckBox();
        jCheckBox28 = new javax.swing.JCheckBox();
        jCheckBox31 = new javax.swing.JCheckBox();
        jLabel57 = new javax.swing.JLabel();
        LMP = new com.toedter.calendar.JDateChooser();
        jPanel17 = new javax.swing.JPanel();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox20 = new javax.swing.JCheckBox();
        jCheckBox29 = new javax.swing.JCheckBox();
        jCheckBox30 = new javax.swing.JCheckBox();
        jPanel18 = new javax.swing.JPanel();
        jCheckBox41 = new javax.swing.JCheckBox();
        jCheckBox42 = new javax.swing.JCheckBox();
        jCheckBox43 = new javax.swing.JCheckBox();
        jPanel19 = new javax.swing.JPanel();
        jCheckBox32 = new javax.swing.JCheckBox();
        jCheckBox33 = new javax.swing.JCheckBox();
        jCheckBox34 = new javax.swing.JCheckBox();
        jCheckBox35 = new javax.swing.JCheckBox();
        jCheckBox36 = new javax.swing.JCheckBox();
        jCheckBox40 = new javax.swing.JCheckBox();
        jCheckBox46 = new javax.swing.JCheckBox();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        cb3 = new javax.swing.JComboBox<>();
        cb2 = new javax.swing.JComboBox<>();
        cb1 = new javax.swing.JComboBox<>();
        cb = new javax.swing.JComboBox<>();
        jPanel20 = new javax.swing.JPanel();
        jCheckBox37 = new javax.swing.JCheckBox();
        jCheckBox38 = new javax.swing.JCheckBox();
        jCheckBox39 = new javax.swing.JCheckBox();
        jPanel25 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox18 = new javax.swing.JCheckBox();
        jPanel26 = new javax.swing.JPanel();
        jScrollPane25 = new javax.swing.JScrollPane();
        jTextArea8 = new javax.swing.JTextArea();
        labBtn = new javax.swing.JButton();
        lname1 = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        search10 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        search11 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        room6 = new javax.swing.JLabel();
        AddConsultationTbl = new javax.swing.JDialog();
        paraclinicalfinding1 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        room7 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jTabbedPane8 = new javax.swing.JTabbedPane();
        jPanel29 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        search9 = new javax.swing.JTextField();
        search8 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jPanel33 = new javax.swing.JPanel();
        jScrollPane34 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel67 = new javax.swing.JLabel();
        cbFilter = new rojerusan.RSComboMetro();
        jLabel74 = new javax.swing.JLabel();
        jScrollPane26 = new javax.swing.JScrollPane();
        q1 = new javax.swing.JTextArea();
        jLabel75 = new javax.swing.JLabel();
        jScrollPane27 = new javax.swing.JScrollPane();
        t1 = new javax.swing.JTextArea();
        jLabel76 = new javax.swing.JLabel();
        jScrollPane28 = new javax.swing.JScrollPane();
        u1 = new javax.swing.JTextArea();
        jLabel77 = new javax.swing.JLabel();
        jScrollPane29 = new javax.swing.JScrollPane();
        i1 = new javax.swing.JTextArea();
        jLabel78 = new javax.swing.JLabel();
        jScrollPane30 = new javax.swing.JScrollPane();
        o1 = new javax.swing.JTextArea();
        jScrollPane31 = new javax.swing.JScrollPane();
        r1 = new javax.swing.JTextArea();
        jLabel79 = new javax.swing.JLabel();
        jScrollPane32 = new javax.swing.JScrollPane();
        e1 = new javax.swing.JTextArea();
        jLabel80 = new javax.swing.JLabel();
        jScrollPane33 = new javax.swing.JScrollPane();
        w1 = new javax.swing.JTextArea();
        jLabel81 = new javax.swing.JLabel();
        fillAll = new rojerusan.RSMaterialButtonRound();
        jPanel32 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        search16 = new javax.swing.JTextField();
        search17 = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        fillAll2 = new rojerusan.RSMaterialButtonRound();
        jLabel73 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        ss1 = new javax.swing.JTextField();
        aa1 = new javax.swing.JTextField();
        pp1 = new javax.swing.JTextField();
        oo1 = new javax.swing.JTextField();
        ii1 = new javax.swing.JTextField();
        uu1 = new javax.swing.JTextField();
        yy1 = new javax.swing.JTextField();
        tt1 = new javax.swing.JTextField();
        rr1 = new javax.swing.JTextField();
        ee1 = new javax.swing.JTextField();
        ww1 = new javax.swing.JTextField();
        qq1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel41 = new javax.swing.JPanel();
        jScrollPane38 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel83 = new javax.swing.JLabel();
        cbFilter2 = new rojerusan.RSComboMetro();
        jPanel31 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        c = new javax.swing.JTextField();
        z = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        x = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        v = new javax.swing.JTextField();
        fillAll1 = new rojerusan.RSMaterialButtonRound();
        jPanel40 = new javax.swing.JPanel();
        jScrollPane35 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel82 = new javax.swing.JLabel();
        cbFilter1 = new rojerusan.RSComboMetro();
        UpdateConsultation = new javax.swing.JDialog();
        diagnosis9 = new javax.swing.JPanel();
        jPanel65 = new javax.swing.JPanel();
        jLabel141 = new javax.swing.JLabel();
        room16 = new javax.swing.JLabel();
        Pass = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        fillAll11 = new rojerusan.RSMaterialButtonRound();
        AddDiagnosisTbl = new javax.swing.JDialog();
        diagnosis2 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        room9 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        fillAll3 = new rojerusan.RSMaterialButtonRound();
        jPanel36 = new javax.swing.JPanel();
        jScrollPane36 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel68 = new javax.swing.JLabel();
        cbFilter3 = new rojerusan.RSComboMetro();
        jLabel69 = new javax.swing.JLabel();
        search12 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        search13 = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        lname2 = new javax.swing.JTextField();
        jScrollPane37 = new javax.swing.JScrollPane();
        insert1 = new javax.swing.JTextArea();
        jLabel89 = new javax.swing.JLabel();
        AddClinicalFindingTbl = new javax.swing.JDialog();
        diagnosis3 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jLabel102 = new javax.swing.JLabel();
        room10 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        fillAll4 = new rojerusan.RSMaterialButtonRound();
        jPanel43 = new javax.swing.JPanel();
        jScrollPane39 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel103 = new javax.swing.JLabel();
        cbFilter4 = new rojerusan.RSComboMetro();
        jLabel104 = new javax.swing.JLabel();
        search14 = new javax.swing.JTextField();
        jButton16 = new javax.swing.JButton();
        search15 = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        lname3 = new javax.swing.JTextField();
        jScrollPane40 = new javax.swing.JScrollPane();
        insert2 = new javax.swing.JTextArea();
        jLabel107 = new javax.swing.JLabel();
        AddLaboratoryTbl = new javax.swing.JDialog();
        diagnosis5 = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        jLabel114 = new javax.swing.JLabel();
        room12 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        fillAll6 = new rojerusan.RSMaterialButtonRound();
        jPanel47 = new javax.swing.JPanel();
        jScrollPane43 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jLabel115 = new javax.swing.JLabel();
        cbFilter6 = new rojerusan.RSComboMetro();
        jLabel116 = new javax.swing.JLabel();
        search20 = new javax.swing.JTextField();
        jButton20 = new javax.swing.JButton();
        search21 = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        lname5 = new javax.swing.JTextField();
        jScrollPane44 = new javax.swing.JScrollPane();
        insert4 = new javax.swing.JTextArea();
        jLabel119 = new javax.swing.JLabel();
        AddAllergyTbl = new javax.swing.JDialog();
        diagnosis4 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jLabel108 = new javax.swing.JLabel();
        room11 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        fillAll5 = new rojerusan.RSMaterialButtonRound();
        jPanel45 = new javax.swing.JPanel();
        jScrollPane41 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel109 = new javax.swing.JLabel();
        cbFilter5 = new rojerusan.RSComboMetro();
        jLabel110 = new javax.swing.JLabel();
        search18 = new javax.swing.JTextField();
        jButton18 = new javax.swing.JButton();
        search19 = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        lname4 = new javax.swing.JTextField();
        jScrollPane42 = new javax.swing.JScrollPane();
        insert3 = new javax.swing.JTextArea();
        jLabel113 = new javax.swing.JLabel();
        AddSurgeryTbl = new javax.swing.JDialog();
        diagnosis6 = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        jLabel120 = new javax.swing.JLabel();
        room13 = new javax.swing.JLabel();
        jButton21 = new javax.swing.JButton();
        fillAll7 = new rojerusan.RSMaterialButtonRound();
        jPanel49 = new javax.swing.JPanel();
        jScrollPane45 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jLabel121 = new javax.swing.JLabel();
        cbFilter7 = new rojerusan.RSComboMetro();
        jLabel122 = new javax.swing.JLabel();
        search22 = new javax.swing.JTextField();
        jButton22 = new javax.swing.JButton();
        search23 = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        lname6 = new javax.swing.JTextField();
        jScrollPane46 = new javax.swing.JScrollPane();
        insert5 = new javax.swing.JTextArea();
        jLabel125 = new javax.swing.JLabel();
        AddMedicineTbl = new javax.swing.JDialog();
        diagnosis8 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        jLabel132 = new javax.swing.JLabel();
        room15 = new javax.swing.JLabel();
        jButton25 = new javax.swing.JButton();
        fillAll9 = new rojerusan.RSMaterialButtonRound();
        jPanel53 = new javax.swing.JPanel();
        jScrollPane49 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jLabel133 = new javax.swing.JLabel();
        cbFilter9 = new rojerusan.RSComboMetro();
        jLabel134 = new javax.swing.JLabel();
        search26 = new javax.swing.JTextField();
        jButton26 = new javax.swing.JButton();
        search27 = new javax.swing.JTextField();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        lname8 = new javax.swing.JTextField();
        jScrollPane50 = new javax.swing.JScrollPane();
        insert7 = new javax.swing.JTextArea();
        jLabel137 = new javax.swing.JLabel();
        AddSurgery = new javax.swing.JDialog();
        allergy2 = new javax.swing.JPanel();
        jLabel148 = new javax.swing.JLabel();
        jScrollPane64 = new javax.swing.JScrollPane();
        jTextArea9 = new javax.swing.JTextArea();
        sub_module_1_btn11 = new javax.swing.JButton();
        jLabel149 = new javax.swing.JLabel();
        title2 = new javax.swing.JTextField();
        jLabel151 = new javax.swing.JLabel();
        jPanel72 = new javax.swing.JPanel();
        room20 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        search31 = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        search32 = new javax.swing.JTextField();
        jLabel163 = new javax.swing.JLabel();
        bday6 = new com.toedter.calendar.JDateChooser();
        jLabel164 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        imageHolder = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tbl_allergies = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_clinical = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_consultation = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_consultation1 = new javax.swing.JTable();
        jScrollPane24 = new javax.swing.JScrollPane();
        tbl_consultation2 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbl_allergy = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tbl_treatment = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_diagnosis = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tbl_surgeries = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tbl_medication = new javax.swing.JTable();
        DrugPrescription = new javax.swing.JButton();
        Diagnosis = new javax.swing.JButton();
        Consultation = new javax.swing.JButton();
        ClinicalFinding = new javax.swing.JButton();
        Allergy = new javax.swing.JButton();
        Surgery = new javax.swing.JButton();
        Treatment = new javax.swing.JButton();
        Allergy1 = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        date_dayv2 = new javax.swing.JLabel();
        Consultation1 = new javax.swing.JButton();
        Consultation2 = new javax.swing.JButton();
        Consultation3 = new javax.swing.JButton();
        Consultation4 = new javax.swing.JButton();
        Consultation5 = new javax.swing.JButton();
        Consultation6 = new javax.swing.JButton();
        Consultation7 = new javax.swing.JButton();
        Consultation8 = new javax.swing.JButton();
        GENDER = new javax.swing.JTextField();
        ID = new javax.swing.JTextField();
        NAME = new javax.swing.JTextField();
        jPanel54 = new javax.swing.JPanel();
        jPanel55 = new javax.swing.JPanel();
        jPanel56 = new javax.swing.JPanel();
        imageHolder1 = new javax.swing.JLabel();
        name1 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jPanel57 = new javax.swing.JPanel();
        jScrollPane51 = new javax.swing.JScrollPane();
        tbl_allergies1 = new javax.swing.JTable();
        jPanel58 = new javax.swing.JPanel();
        jScrollPane52 = new javax.swing.JScrollPane();
        tbl_clinical1 = new javax.swing.JTable();
        jPanel59 = new javax.swing.JPanel();
        jScrollPane53 = new javax.swing.JScrollPane();
        tbl_consultation3 = new javax.swing.JTable();
        jScrollPane54 = new javax.swing.JScrollPane();
        tbl_consultation4 = new javax.swing.JTable();
        jScrollPane55 = new javax.swing.JScrollPane();
        tbl_consultation5 = new javax.swing.JTable();
        jPanel60 = new javax.swing.JPanel();
        jScrollPane56 = new javax.swing.JScrollPane();
        tbl_allergy1 = new javax.swing.JTable();
        jPanel61 = new javax.swing.JPanel();
        jScrollPane57 = new javax.swing.JScrollPane();
        tbl_treatment1 = new javax.swing.JTable();
        jPanel62 = new javax.swing.JPanel();
        jScrollPane58 = new javax.swing.JScrollPane();
        tbl_diagnosis1 = new javax.swing.JTable();
        jPanel63 = new javax.swing.JPanel();
        jScrollPane59 = new javax.swing.JScrollPane();
        tbl_surgeries1 = new javax.swing.JTable();
        jPanel64 = new javax.swing.JPanel();
        jScrollPane60 = new javax.swing.JScrollPane();
        tbl_medication1 = new javax.swing.JTable();
        DrugPrescription1 = new javax.swing.JButton();
        Diagnosis1 = new javax.swing.JButton();
        Consultation9 = new javax.swing.JButton();
        ClinicalFinding1 = new javax.swing.JButton();
        Allergy2 = new javax.swing.JButton();
        Surgery1 = new javax.swing.JButton();
        Treatment1 = new javax.swing.JButton();
        Allergy3 = new javax.swing.JButton();
        search28 = new javax.swing.JTextField();
        jLabel140 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        date_dayv3 = new javax.swing.JLabel();
        Consultation10 = new javax.swing.JButton();
        Consultation11 = new javax.swing.JButton();
        Consultation12 = new javax.swing.JButton();
        Consultation13 = new javax.swing.JButton();
        Consultation14 = new javax.swing.JButton();
        Consultation15 = new javax.swing.JButton();
        Consultation16 = new javax.swing.JButton();
        Consultation17 = new javax.swing.JButton();
        NAME1 = new javax.swing.JTextField();
        ID1 = new javax.swing.JTextField();
        GENDER1 = new javax.swing.JTextField();

        AddConsultation.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AddConsultation.setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);
        AddConsultation.setUndecorated(true);

        paraclinicalfinding.setBackground(new java.awt.Color(255, 255, 255));
        paraclinicalfinding.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 1, true));
        paraclinicalfinding.setPreferredSize(new java.awt.Dimension(581, 625));
        paraclinicalfinding.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                paraclinicalfindingAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        paraclinicalfinding.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel24.setBackground(new java.awt.Color(51, 102, 255));
        jPanel24.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("X");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel24.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 30, 30));

        room5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        room5.setText("ADD CONSULTATION");
        jPanel24.add(room5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, 30));

        paraclinicalfinding.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 30));

        jLabel27.setText("Doctor ID:");
        paraclinicalfinding.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, 30));

        search3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        search3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search3MouseClicked(evt);
            }
        });
        search3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search3ActionPerformed(evt);
            }
        });
        search3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search3KeyTyped(evt);
            }
        });
        paraclinicalfinding.add(search3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 270, 30));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/search.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        paraclinicalfinding.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 30, 30));

        search7.setEditable(false);
        search7.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search7ActionPerformed(evt);
            }
        });
        search7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search7KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search7KeyReleased(evt);
            }
        });
        paraclinicalfinding.add(search7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 300, 30));

        jLabel28.setText("Dr. Name:");
        paraclinicalfinding.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, 30));

        jTabbedPane7.setBackground(new java.awt.Color(204, 204, 204));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("General");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 30));

        q.setColumns(20);
        q.setLineWrap(true);
        q.setRows(5);
        jScrollPane16.setViewportView(q);

        jPanel1.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 260, 70));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("Cardiovascular");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 210, 30));

        t.setColumns(20);
        t.setLineWrap(true);
        t.setRows(5);
        jScrollPane20.setViewportView(t);

        jPanel1.add(jScrollPane20, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 260, 70));

        jLabel29.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel29.setText("Respiratory");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 210, 30));

        u.setColumns(20);
        u.setLineWrap(true);
        u.setRows(5);
        jScrollPane21.setViewportView(u);

        jPanel1.add(jScrollPane21, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 260, 70));

        jLabel30.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel30.setText("Musculoskeletal");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 210, 30));

        i.setColumns(20);
        i.setLineWrap(true);
        i.setRows(5);
        jScrollPane22.setViewportView(i);

        jPanel1.add(jScrollPane22, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 260, 70));

        jLabel31.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel31.setText("Gastrointestinal");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 210, 30));

        o.setColumns(20);
        o.setLineWrap(true);
        o.setRows(5);
        jScrollPane23.setViewportView(o);

        jPanel1.add(jScrollPane23, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, 260, 70));

        r.setColumns(20);
        r.setLineWrap(true);
        r.setRows(5);
        jScrollPane19.setViewportView(r);

        jPanel1.add(jScrollPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 260, 70));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("Endocrine");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 210, 30));

        e.setColumns(20);
        e.setLineWrap(true);
        e.setRows(5);
        jScrollPane18.setViewportView(e);

        jPanel1.add(jScrollPane18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 260, 70));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Neurological");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 210, 30));

        w.setColumns(20);
        w.setLineWrap(true);
        w.setRows(5);
        jScrollPane17.setViewportView(w);

        jPanel1.add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 260, 70));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Eyes");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 210, 30));

        jPanel13.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane7.addTab("Review of Systems", jPanel13);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setText("Blood pressure:");
        jPanel14.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 90, 30));

        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField11KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField11KeyTyped(evt);
            }
        });
        jPanel14.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 30, 30));

        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField12KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField12KeyTyped(evt);
            }
        });
        jPanel14.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 40, 30));

        jLabel32.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("/");
        jPanel14.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 10, 30));

        jTextField17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField17KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField17KeyTyped(evt);
            }
        });
        jPanel14.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 40, 30));

        jLabel33.setText("Body temperature:");
        jPanel14.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 110, 30));

        jLabel34.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("°F");
        jPanel14.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 30, 30));

        jLabel35.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel35.setText("kg");
        jPanel14.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, 30));

        jLabel38.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel38.setText("cm");
        jPanel14.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, 30));

        jTextField18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField18KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField18KeyTyped(evt);
            }
        });
        jPanel14.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 40, 30));

        jTextField20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField20KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField20KeyTyped(evt);
            }
        });
        jPanel14.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 40, 30));

        jLabel41.setText("Height:");
        jPanel14.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 30));

        jLabel42.setText("Weight:");
        jPanel14.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, 30));

        txt_day.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_day.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_day.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_day.setEnabled(false);
        txt_day.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_dayKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dayKeyTyped(evt);
            }
        });
        jPanel14.add(txt_day, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 120, 30));

        txt_c_id.setBackground(new java.awt.Color(0, 102, 102));
        txt_c_id.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_c_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_c_id.setEnabled(false);
        jPanel14.add(txt_c_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 40, 30));

        jTabbedPane7.addTab("Vitals", jPanel14);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        note.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        note.setForeground(new java.awt.Color(204, 0, 0));
        jPanel15.add(note, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 520, 190, 20));

        jLabel43.setText("General");
        jPanel15.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 20));

        jLabel45.setText("Head");
        jPanel15.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, 20));

        jLabel47.setText("Eyes");
        jPanel15.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 110, 20));

        jLabel48.setText("Ears");
        jPanel15.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 110, 20));

        jLabel49.setText("Nose");
        jPanel15.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 110, 20));

        jLabel50.setText("Mouth and Troath");
        jPanel15.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 110, 20));

        jLabel51.setText("Neck");
        jPanel15.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 110, 20));

        jLabel52.setText("Breast");
        jPanel15.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 110, 20));

        jLabel53.setText("Gastrointestinal");
        jPanel15.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 110, 20));

        jLabel54.setText("Genitourinary");
        jPanel15.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 110, 20));

        jLabel55.setText("Neurologic");
        jPanel15.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 110, 20));

        jLabel56.setText("Phschiatric");
        jPanel15.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 110, 20));

        ss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ssActionPerformed(evt);
            }
        });
        jPanel15.add(ss, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 260, 20));
        jPanel15.add(aa, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 260, 20));
        jPanel15.add(pp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 260, 20));
        jPanel15.add(oo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 260, 20));
        jPanel15.add(ii, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 260, 20));
        jPanel15.add(uu, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 260, 20));
        jPanel15.add(yy, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 260, 20));
        jPanel15.add(tt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 260, 20));
        jPanel15.add(rr, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 260, 20));

        ee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eeActionPerformed(evt);
            }
        });
        jPanel15.add(ee, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 260, 20));
        jPanel15.add(ww, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 260, 20));
        jPanel15.add(qq, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 260, 20));

        jTabbedPane7.addTab("Physical Exam", jPanel15);

        paraclinicalfinding.add(jTabbedPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 580, 470));

        sub_module_1_btn4.setBackground(new java.awt.Color(153, 153, 153));
        sub_module_1_btn4.setText("Save & Close");
        sub_module_1_btn4.setToolTipText("Sub Module 1");
        sub_module_1_btn4.setBorder(null);
        sub_module_1_btn4.setBorderPainted(false);
        sub_module_1_btn4.setContentAreaFilled(false);
        sub_module_1_btn4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sub_module_1_btn4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sub_module_1_btn4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sub_module_1_btn4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sub_module_1_btn4MouseExited(evt);
            }
        });
        sub_module_1_btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sub_module_1_btn4ActionPerformed(evt);
            }
        });
        paraclinicalfinding.add(sub_module_1_btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 590, 130, 30));

        AddConsultation.getContentPane().add(paraclinicalfinding, java.awt.BorderLayout.CENTER);

        AddTreatment.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AddTreatment.setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);
        AddTreatment.setUndecorated(true);

        treatment.setBackground(new java.awt.Color(255, 255, 255));
        treatment.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        treatment.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                treatmentAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        treatment.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sub_module_1_btn2.setBackground(new java.awt.Color(153, 153, 153));
        sub_module_1_btn2.setForeground(new java.awt.Color(51, 153, 255));
        sub_module_1_btn2.setText("Add Bill of Materials");
        sub_module_1_btn2.setToolTipText("Sub Module 1");
        sub_module_1_btn2.setBorder(null);
        sub_module_1_btn2.setBorderPainted(false);
        sub_module_1_btn2.setContentAreaFilled(false);
        sub_module_1_btn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sub_module_1_btn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sub_module_1_btn2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sub_module_1_btn2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sub_module_1_btn2MouseExited(evt);
            }
        });
        sub_module_1_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sub_module_1_btn2ActionPerformed(evt);
            }
        });
        treatment.add(sub_module_1_btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 120, 30));

        jLabel44.setText("Details");
        treatment.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 100, 30));

        jLabel46.setText("Medic");
        treatment.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 30));

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        treatment.add(jComboBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 240, 30));

        jTextArea7.setColumns(20);
        jTextArea7.setRows(5);
        jScrollPane14.setViewportView(jTextArea7);

        treatment.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 710, 500));

        sub_module_1_btn8.setBackground(new java.awt.Color(153, 153, 153));
        sub_module_1_btn8.setForeground(new java.awt.Color(51, 153, 255));
        sub_module_1_btn8.setText("Insert Questionaire");
        sub_module_1_btn8.setToolTipText("Sub Module 1");
        sub_module_1_btn8.setBorder(null);
        sub_module_1_btn8.setBorderPainted(false);
        sub_module_1_btn8.setContentAreaFilled(false);
        sub_module_1_btn8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sub_module_1_btn8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sub_module_1_btn8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sub_module_1_btn8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sub_module_1_btn8MouseExited(evt);
            }
        });
        sub_module_1_btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sub_module_1_btn8ActionPerformed(evt);
            }
        });
        treatment.add(sub_module_1_btn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 120, 30));

        sub_module_1_btn9.setBackground(new java.awt.Color(153, 153, 153));
        sub_module_1_btn9.setText("Save & Close");
        sub_module_1_btn9.setToolTipText("Sub Module 1");
        sub_module_1_btn9.setBorder(null);
        sub_module_1_btn9.setBorderPainted(false);
        sub_module_1_btn9.setContentAreaFilled(false);
        sub_module_1_btn9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sub_module_1_btn9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sub_module_1_btn9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sub_module_1_btn9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sub_module_1_btn9MouseExited(evt);
            }
        });
        sub_module_1_btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sub_module_1_btn9ActionPerformed(evt);
            }
        });
        treatment.add(sub_module_1_btn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 640, 120, 30));

        AddTreatment.getContentPane().add(treatment, java.awt.BorderLayout.CENTER);

        AddDiagnosis1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AddDiagnosis1.setUndecorated(true);

        diagnosis.setBackground(new java.awt.Color(255, 255, 255));
        diagnosis.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 1, true));
        diagnosis.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                diagnosisAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        diagnosis.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        lname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lnameKeyTyped(evt);
            }
        });
        diagnosis.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 280, 30));

        jLabel14.setText("Diagnosis");
        diagnosis.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 110, 30));

        jLabel17.setText("Dr. Name:");
        diagnosis.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, 30));

        insert.setColumns(20);
        insert.setLineWrap(true);
        insert.setRows(5);
        jScrollPane5.setViewportView(insert);

        diagnosis.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 700, 340));

        sub_module_1_btn1.setBackground(new java.awt.Color(153, 153, 153));
        sub_module_1_btn1.setForeground(new java.awt.Color(51, 153, 255));
        sub_module_1_btn1.setText("Insert Questionaires");
        sub_module_1_btn1.setToolTipText("Sub Module 1");
        sub_module_1_btn1.setBorder(null);
        sub_module_1_btn1.setBorderPainted(false);
        sub_module_1_btn1.setContentAreaFilled(false);
        sub_module_1_btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sub_module_1_btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sub_module_1_btn1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sub_module_1_btn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sub_module_1_btn1MouseExited(evt);
            }
        });
        sub_module_1_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sub_module_1_btn1ActionPerformed(evt);
            }
        });
        diagnosis.add(sub_module_1_btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, 120, 30));

        jPanel21.setBackground(new java.awt.Color(51, 102, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        room2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        room2.setText("ADD DIAGNOSIS");
        jPanel21.add(room2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, 30));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("X");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel21.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 40, 30));

        diagnosis.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 30));

        jLabel16.setText("Details");
        diagnosis.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 100, 30));

        sub_module_1_btn10.setBackground(new java.awt.Color(153, 153, 153));
        sub_module_1_btn10.setText("Save & Close");
        sub_module_1_btn10.setToolTipText("Sub Module 1");
        sub_module_1_btn10.setBorder(null);
        sub_module_1_btn10.setBorderPainted(false);
        sub_module_1_btn10.setContentAreaFilled(false);
        sub_module_1_btn10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sub_module_1_btn10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sub_module_1_btn10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sub_module_1_btn10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sub_module_1_btn10MouseExited(evt);
            }
        });
        sub_module_1_btn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sub_module_1_btn10ActionPerformed(evt);
            }
        });
        diagnosis.add(sub_module_1_btn10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 520, 120, 30));

        search1.setEditable(false);
        search1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search1ActionPerformed(evt);
            }
        });
        search1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search1KeyReleased(evt);
            }
        });
        diagnosis.add(search1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 280, 30));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/search.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        diagnosis.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 30, 30));

        search2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search2MouseClicked(evt);
            }
        });
        search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search2ActionPerformed(evt);
            }
        });
        search2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search2KeyTyped(evt);
            }
        });
        diagnosis.add(search2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 250, 30));

        jLabel19.setText("Doctor ID:");
        diagnosis.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, 30));

        AddDiagnosis1.getContentPane().add(diagnosis, java.awt.BorderLayout.CENTER);

        AddMedicine.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AddMedicine.setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);
        AddMedicine.setUndecorated(true);

        paraclinicalfinding2.setBackground(new java.awt.Color(255, 255, 255));
        paraclinicalfinding2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 1, true));
        paraclinicalfinding2.setPreferredSize(new java.awt.Dimension(961, 625));
        paraclinicalfinding2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                paraclinicalfinding2AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        paraclinicalfinding2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel66.setBackground(new java.awt.Color(51, 102, 255));
        jPanel66.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel66.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel142.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel142.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel142.setText("X");
        jLabel142.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel142MouseClicked(evt);
            }
        });
        jPanel66.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, 30, 30));

        room8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        room8.setText("ADD MEDICINE");
        jPanel66.add(room8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, 30));

        paraclinicalfinding2.add(jPanel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 30));

        jLabel143.setText("Doctor ID:");
        paraclinicalfinding2.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, 30));

        search29.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        search29.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search29MouseClicked(evt);
            }
        });
        search29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search29ActionPerformed(evt);
            }
        });
        search29.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search29KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search29KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search29KeyTyped(evt);
            }
        });
        paraclinicalfinding2.add(search29, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 270, 30));

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/search.png"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        paraclinicalfinding2.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 30, 30));

        search30.setEditable(false);
        search30.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search30ActionPerformed(evt);
            }
        });
        search30.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search30KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search30KeyReleased(evt);
            }
        });
        paraclinicalfinding2.add(search30, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 300, 30));

        jLabel144.setText("Dr. Name:");
        paraclinicalfinding2.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, 30));

        jTabbedPane9.setBackground(new java.awt.Color(204, 204, 204));

        jPanel70.setBackground(new java.awt.Color(255, 255, 255));
        jPanel70.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jTabbedPane9.addTab("MEDICAL PACKAGE", jPanel70);

        jPanel67.setBackground(new java.awt.Color(255, 255, 255));
        jPanel67.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel68.setBackground(new java.awt.Color(255, 255, 255));
        jPanel68.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel67.add(jPanel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel37.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel37.setText("Title");
        jPanel67.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 140, 30));

        Request_Name.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        Request_Name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Request_Name.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));
        Request_Name.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Request_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Request_NameActionPerformed(evt);
            }
        });
        jPanel67.add(Request_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 240, 30));

        Medicine_Type.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        Medicine_Type.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Medicine_Type.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));
        Medicine_Type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Medicine_TypeActionPerformed(evt);
            }
        });
        jPanel67.add(Medicine_Type, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 240, 30));

        jLabel39.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel39.setText("Medicine Type:");
        jPanel67.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 150, 30));

        jLabel40.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel40.setText("Department:");
        jPanel67.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 130, 30));

        Inpatient.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        Inpatient.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Inpatient.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));
        Inpatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InpatientActionPerformed(evt);
            }
        });
        jPanel67.add(Inpatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 240, 30));

        jLabel161.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel161.setText("Item Name:");
        jPanel67.add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 140, 30));

        jLabel165.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel165.setText("Quantity:");
        jPanel67.add(jLabel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 90, 30));

        Item_Name1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        Item_Name1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Item_Name1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                Item_Name1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        Item_Name1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item_Name1ActionPerformed(evt);
            }
        });
        jPanel67.add(Item_Name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 240, 30));

        IQuantity.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        IQuantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        IQuantity.setText("0");
        IQuantity.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        IQuantity.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        IQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IQuantityActionPerformed(evt);
            }
        });
        jPanel67.add(IQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 240, 30));

        Requestor.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        Requestor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Requestor.setText("Bermudez, Jimmel");
        Requestor.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));
        Requestor.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Requestor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequestorActionPerformed(evt);
            }
        });
        jPanel67.add(Requestor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 240, 30));

        Price.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jPanel67.add(Price, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 100, 30));

        Urgent.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        Urgent.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "YES", "NO" }));
        jPanel67.add(Urgent, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 100, 30));

        jLabel168.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel168.setText("Urgent:");
        jPanel67.add(jLabel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 100, 30));

        available.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane13.setViewportView(available);

        jPanel67.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, -1, 190));

        jLabel169.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel169.setForeground(new java.awt.Color(0, 0, 255));
        jLabel169.setText("Available Medicine");
        jPanel67.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 170, 30));

        Request.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Request.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                RequestAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane66.setViewportView(Request);

        jPanel67.add(jScrollPane66, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 490, 550));

        jLabel170.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel170.setForeground(new java.awt.Color(0, 0, 255));
        jLabel170.setText("Medicine Request List");
        jPanel67.add(jLabel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 200, 30));

        add1.setBackground(new java.awt.Color(255, 255, 255));
        add1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        add1.setForeground(new java.awt.Color(0, 51, 255));
        add1.setText("AddItem");
        add1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1ActionPerformed(evt);
            }
        });
        jPanel67.add(add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 90, 30));

        add.setBackground(new java.awt.Color(255, 255, 255));
        add.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        add.setForeground(new java.awt.Color(0, 51, 255));
        add.setText("Submit");
        add.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel67.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 90, 30));

        jTabbedPane9.addTab("PHARMACY", jPanel67);

        paraclinicalfinding2.add(jTabbedPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 960, 620));

        AddMedicine.getContentPane().add(paraclinicalfinding2, java.awt.BorderLayout.CENTER);

        AddClinicalFinding1.setTitle("Add Clinical Findings");
        AddClinicalFinding1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AddClinicalFinding1.setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);
        AddClinicalFinding1.setUndecorated(true);

        clinicalfinding.setBackground(new java.awt.Color(255, 255, 255));
        clinicalfinding.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 1, true));
        clinicalfinding.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                clinicalfindingAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        clinicalfinding.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setText("Title:");
        clinicalfinding.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 50, 30));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane6.setViewportView(jTextArea2);

        clinicalfinding.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 700, 280));

        sub_module_1_btn3.setBackground(new java.awt.Color(153, 153, 153));
        sub_module_1_btn3.setText("Save & Close");
        sub_module_1_btn3.setToolTipText("Sub Module 1");
        sub_module_1_btn3.setBorder(null);
        sub_module_1_btn3.setBorderPainted(false);
        sub_module_1_btn3.setContentAreaFilled(false);
        sub_module_1_btn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sub_module_1_btn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sub_module_1_btn3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sub_module_1_btn3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sub_module_1_btn3MouseExited(evt);
            }
        });
        sub_module_1_btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sub_module_1_btn3ActionPerformed(evt);
            }
        });
        clinicalfinding.add(sub_module_1_btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 470, 120, 30));

        jLabel22.setText("Note");
        clinicalfinding.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 100, 30));
        clinicalfinding.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 240, 30));

        jPanel22.setBackground(new java.awt.Color(51, 102, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        room3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        room3.setText("ADD CLINICAL FINDINGS");
        jPanel22.add(room3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, 30));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("X");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel22.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 40, 30));

        clinicalfinding.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 30));

        jLabel20.setText("Doctor ID:");
        clinicalfinding.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, 30));

        AddAllergyDRID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        AddAllergyDRID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddAllergyDRIDMouseClicked(evt);
            }
        });
        AddAllergyDRID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAllergyDRIDActionPerformed(evt);
            }
        });
        AddAllergyDRID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AddAllergyDRIDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AddAllergyDRIDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AddAllergyDRIDKeyTyped(evt);
            }
        });
        clinicalfinding.add(AddAllergyDRID, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 250, 30));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/search.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        clinicalfinding.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 30, 30));

        search4.setEditable(false);
        search4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search4ActionPerformed(evt);
            }
        });
        search4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search4KeyReleased(evt);
            }
        });
        clinicalfinding.add(search4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 280, 30));

        jLabel25.setText("Dr. Name:");
        clinicalfinding.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, 30));

        AddClinicalFinding1.getContentPane().add(clinicalfinding, java.awt.BorderLayout.CENTER);

        AddAllergy1.setTitle("Add Allergy");
        AddAllergy1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AddAllergy1.setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);
        AddAllergy1.setUndecorated(true);

        allergy1.setBackground(new java.awt.Color(255, 255, 255));
        allergy1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 1, true));
        allergy1.setToolTipText("");
        allergy1.setPreferredSize(new java.awt.Dimension(639, 322));
        allergy1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                allergy1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        allergy1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setText("Note");
        allergy1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 100, 30));

        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jScrollPane7.setViewportView(jTextArea5);

        allergy1.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 620, 190));

        sub_module_1_btn7.setBackground(new java.awt.Color(153, 153, 153));
        sub_module_1_btn7.setText("Save & Close");
        sub_module_1_btn7.setToolTipText("Sub Module 1");
        sub_module_1_btn7.setBorder(null);
        sub_module_1_btn7.setBorderPainted(false);
        sub_module_1_btn7.setContentAreaFilled(false);
        sub_module_1_btn7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sub_module_1_btn7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sub_module_1_btn7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sub_module_1_btn7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sub_module_1_btn7MouseExited(evt);
            }
        });
        sub_module_1_btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sub_module_1_btn7ActionPerformed(evt);
            }
        });
        allergy1.add(sub_module_1_btn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 370, 120, 40));

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        allergy1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        allergy1.add(title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 240, 30));

        jLabel24.setText("Title:");
        allergy1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 50, 30));

        jPanel23.setBackground(new java.awt.Color(51, 102, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        room4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        room4.setText("ADD ALLERGY");
        jPanel23.add(room4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, 30));

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("X");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel23.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 40, 30));

        allergy1.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 30));

        jLabel23.setText("Doctor ID:");
        allergy1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, 30));

        search5.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search5MouseClicked(evt);
            }
        });
        search5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search5ActionPerformed(evt);
            }
        });
        search5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search5KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search5KeyTyped(evt);
            }
        });
        allergy1.add(search5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 250, 30));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/search.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        allergy1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 30, 30));

        search6.setEditable(false);
        search6.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search6ActionPerformed(evt);
            }
        });
        search6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search6KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search6KeyReleased(evt);
            }
        });
        allergy1.add(search6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 280, 30));

        jLabel26.setText("Dr. Name:");
        allergy1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, 30));

        AddAllergy1.getContentPane().add(allergy1, java.awt.BorderLayout.CENTER);

        AddBedandLinen.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AddBedandLinen.setUndecorated(true);

        diagnosis10.setBackground(new java.awt.Color(255, 255, 255));
        diagnosis10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 1, true));
        diagnosis10.setPreferredSize(new java.awt.Dimension(1141, 630));
        diagnosis10.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                diagnosis10AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        diagnosis10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel69.setBackground(new java.awt.Color(51, 102, 255));
        jPanel69.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel69.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel147.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel147.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel147.setText("X");
        jLabel147.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel147MouseClicked(evt);
            }
        });
        jPanel69.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 30, 30));

        room17.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        room17.setText("LINEN REQUEST");
        jPanel69.add(room17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, 30));

        diagnosis10.add(jPanel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 30));

        jPanel71.setBackground(new java.awt.Color(255, 255, 255));
        jPanel71.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jPanel71.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable11.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable11AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable11MouseClicked(evt);
            }
        });
        jScrollPane63.setViewportView(jTable11);

        jPanel71.add(jScrollPane63, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 550, 550));

        room18.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        room18.setText("REQUESTED");
        jPanel71.add(room18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 280, 30));

        diagnosis10.add(jPanel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 550, 590));

        txt_item.setEditable(false);
        txt_item.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_itemActionPerformed(evt);
            }
        });
        txt_item.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_itemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_itemKeyReleased(evt);
            }
        });
        diagnosis10.add(txt_item, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 280, 30));

        jLabel150.setText("Item");
        diagnosis10.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 110, 30));

        jTable12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable12.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable12AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable12MouseClicked(evt);
            }
        });
        jScrollPane65.setViewportView(jTable12);

        diagnosis10.add(jScrollPane65, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 570, 350));

        room19.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        room19.setText("LINEN ITEMS");
        diagnosis10.add(room19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 280, 30));

        txt_item1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_item1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_item1ActionPerformed(evt);
            }
        });
        txt_item1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_item1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_item1KeyReleased(evt);
            }
        });
        diagnosis10.add(txt_item1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 280, 30));

        jLabel159.setText("Qty");
        diagnosis10.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 110, 30));

        txt_dr_ln.setText("Bermudez, Jimmel B.");
        txt_dr_ln.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
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
        });
        diagnosis10.add(txt_dr_ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 280, 30));

        sub_module_1_btn5.setBackground(new java.awt.Color(153, 153, 153));
        sub_module_1_btn5.setText("Save");
        sub_module_1_btn5.setToolTipText("Sub Module 1");
        sub_module_1_btn5.setBorder(null);
        sub_module_1_btn5.setBorderPainted(false);
        sub_module_1_btn5.setContentAreaFilled(false);
        sub_module_1_btn5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sub_module_1_btn5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sub_module_1_btn5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sub_module_1_btn5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sub_module_1_btn5MouseExited(evt);
            }
        });
        sub_module_1_btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sub_module_1_btn5ActionPerformed(evt);
            }
        });
        diagnosis10.add(sub_module_1_btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 130, 30));

        AddBedandLinen.getContentPane().add(diagnosis10, java.awt.BorderLayout.CENTER);

        AddBedandLinenTbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AddBedandLinenTbl.setUndecorated(true);

        diagnosis7.setBackground(new java.awt.Color(255, 255, 255));
        diagnosis7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 1, true));
        diagnosis7.setPreferredSize(new java.awt.Dimension(1141, 630));
        diagnosis7.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                diagnosis7AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        diagnosis7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel50.setBackground(new java.awt.Color(51, 102, 255));
        jPanel50.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel50.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel126.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel126.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel126.setText("X");
        jLabel126.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel126MouseClicked(evt);
            }
        });
        jPanel50.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 30, 30));

        room14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        room14.setText("VIEW LINEN REQUEST");
        jPanel50.add(room14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, 30));

        diagnosis7.add(jPanel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 30));

        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/lock.png"))); // NOI18N
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        diagnosis7.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 30, 30));

        fillAll8.setText("Update");
        fillAll8.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        fillAll8.setMaximumSize(new java.awt.Dimension(82, 26));
        fillAll8.setMinimumSize(new java.awt.Dimension(82, 26));
        fillAll8.setPreferredSize(new java.awt.Dimension(88, 28));
        fillAll8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillAll8ActionPerformed(evt);
            }
        });
        diagnosis7.add(fillAll8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 110, 30));

        jPanel51.setBackground(new java.awt.Color(255, 255, 255));
        jPanel51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jPanel51.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable9.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable9AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable9MouseClicked(evt);
            }
        });
        jScrollPane47.setViewportView(jTable9);

        jPanel51.add(jScrollPane47, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 550, 550));

        jLabel127.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel127.setText("Filter by:");
        jPanel51.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 5, 70, 30));

        cbFilter8.setEditable(true);
        cbFilter8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Today", "Weekly", "Monthly", "Yearly" }));
        cbFilter8.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        cbFilter8.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbFilter8PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cbFilter8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFilter8ActionPerformed(evt);
            }
        });
        jPanel51.add(cbFilter8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 5, -1, -1));

        diagnosis7.add(jPanel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 550, 590));

        jLabel128.setText("Doctor ID");
        diagnosis7.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, 30));

        search24.setEditable(false);
        search24.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search24MouseClicked(evt);
            }
        });
        search24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search24ActionPerformed(evt);
            }
        });
        search24.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search24KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search24KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search24KeyTyped(evt);
            }
        });
        diagnosis7.add(search24, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 280, 30));

        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/search.png"))); // NOI18N
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        diagnosis7.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 30, 30));

        search25.setEditable(false);
        search25.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search25ActionPerformed(evt);
            }
        });
        search25.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search25KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search25KeyReleased(evt);
            }
        });
        diagnosis7.add(search25, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 280, 30));

        jLabel129.setText("Dr. Name");
        diagnosis7.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, 30));

        jLabel130.setText("Title");
        diagnosis7.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 110, 30));

        lname7.setEditable(false);
        lname7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lname7ActionPerformed(evt);
            }
        });
        lname7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lname7KeyTyped(evt);
            }
        });
        diagnosis7.add(lname7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 280, 30));

        insert6.setEditable(false);
        insert6.setColumns(20);
        insert6.setLineWrap(true);
        insert6.setRows(5);
        jScrollPane48.setViewportView(insert6);

        diagnosis7.add(jScrollPane48, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 570, 440));

        jLabel131.setText("Note");
        diagnosis7.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 100, 30));

        AddBedandLinenTbl.getContentPane().add(diagnosis7, java.awt.BorderLayout.CENTER);

        Q.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        diagnosis1.setBackground(new java.awt.Color(255, 255, 255));
        diagnosis1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 1, true));
        diagnosis1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                diagnosis1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        diagnosis1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        qqqq.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        qqqq.setShowHorizontalLines(false);
        qqqq.setShowVerticalLines(false);
        qqqq.getTableHeader().setResizingAllowed(false);
        qqqq.getTableHeader().setReorderingAllowed(false);
        qqqq.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                qqqqAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        qqqq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qqqqMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(qqqq);

        diagnosis1.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 270));

        Q.getContentPane().add(diagnosis1, java.awt.BorderLayout.CENTER);

        AddLaboratory.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AddLaboratory.setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);
        AddLaboratory.setUndecorated(true);

        LABORATORY_PANEL.setBackground(new java.awt.Color(255, 255, 255));
        LABORATORY_PANEL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        LABORATORY_PANEL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Blood Chemisitry", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox10.setText("FBS");
        jPanel16.add(jCheckBox10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jCheckBox11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox11.setText("HbA1C");
        jPanel16.add(jCheckBox11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jCheckBox12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox12.setText("BUN");
        jPanel16.add(jCheckBox12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jCheckBox14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox14.setText("BUA");
        jPanel16.add(jCheckBox14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jCheckBox15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox15.setText("Creatinine");
        jPanel16.add(jCheckBox15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jCheckBox16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox16.setText("Lipid Profile");
        jPanel16.add(jCheckBox16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jCheckBox17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox17.setText("SGPT/SGOT");
        jPanel16.add(jCheckBox17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jCheckBox19.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox19.setText("OGTT 75gm");
        jPanel16.add(jCheckBox19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jCheckBox21.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox21.setText("OGCT 50gm");
        jPanel16.add(jCheckBox21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        LABORATORY_PANEL.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 160, 220));

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Microscopy", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox22.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox22.setText("Urine Pregtest");
        jPanel12.add(jCheckBox22, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jCheckBox23.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox23.setText("Fecalysis");
        jPanel12.add(jCheckBox23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jCheckBox24.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox24.setText("Stool Occult blood");
        jPanel12.add(jCheckBox24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jCheckBox25.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox25.setText("Urine Culture & Sensitivity");
        jPanel12.add(jCheckBox25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jCheckBox26.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox26.setText("AFB Smear");
        jPanel12.add(jCheckBox26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jCheckBox27.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox27.setText("Lipid Profile");
        jPanel12.add(jCheckBox27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jCheckBox28.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox28.setText("PAP smear");
        jPanel12.add(jCheckBox28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jCheckBox31.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox31.setText("Urinalysis");
        jPanel12.add(jCheckBox31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel57.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel57.setText("LMP:");
        jPanel12.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 30, 20));
        jPanel12.add(LMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 140, -1));

        LABORATORY_PANEL.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 290, 170));

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Electrolytes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox13.setText("Sodium");
        jPanel17.add(jCheckBox13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jCheckBox20.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox20.setText("Potassium");
        jPanel17.add(jCheckBox20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jCheckBox29.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox29.setText("Calcium (Total/Ionized)");
        jPanel17.add(jCheckBox29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jCheckBox30.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox30.setText("Magnesium");
        jPanel17.add(jCheckBox30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        LABORATORY_PANEL.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, 170, 110));

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Serology", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox41.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox41.setText("ASO");
        jPanel18.add(jCheckBox41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jCheckBox42.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox42.setText("ESR");
        jPanel18.add(jCheckBox42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jCheckBox43.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox43.setText("PSA");
        jPanel18.add(jCheckBox43, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        LABORATORY_PANEL.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 180, 100));

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Radiology", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox32.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox32.setText("ECG");
        jPanel19.add(jCheckBox32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 70, -1));

        jCheckBox33.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox33.setText("Chest X-Ray");
        jPanel19.add(jCheckBox33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jCheckBox34.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox34.setText("X-Ray");
        jPanel19.add(jCheckBox34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jCheckBox35.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox35.setText("Ultrasound");
        jPanel19.add(jCheckBox35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jCheckBox36.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox36.setText("2D Echo  with Doppler Study");
        jPanel19.add(jCheckBox36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jCheckBox40.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox40.setText("Treadmill Stress Test");
        jPanel19.add(jCheckBox40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jCheckBox46.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox46.setText("Spirometry");
        jCheckBox46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox46ActionPerformed(evt);
            }
        });
        jPanel19.add(jCheckBox46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jLabel58.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel58.setText("Protocol:");
        jPanel19.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 60, 20));

        jLabel59.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel59.setText("View:");
        jPanel19.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 40, 20));

        cb3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Stage 1: 1.7 mph and 10% gradient", "Stage 2: 2.5 mph and 12% gradient", "Stage 3: 3.4 mph and 14% gradient" }));
        cb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb3ActionPerformed(evt);
            }
        });
        jPanel19.add(cb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 250, -1));

        cb2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Transvaginal Scans", "Standard Ultrasound", "Advanced Ultrasound", "Doppler Ultrasound", "3-D Ultrasound", "4-D or Dynamic 3-D Ultrasound", "Fetal Echocardiography" }));
        cb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb2ActionPerformed(evt);
            }
        });
        jPanel19.add(cb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 240, -1));

        cb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bone cancer", "Breast tumors", "Enlarged heart", "Blocked blood vessels", "Conditions affecting your lungs", "Digestive problems", "Fractures", "Infections", "Osteoporosis", "Arthritis", "Tooth decay", "Needing to retrieve swallowed items" }));
        cb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb1ActionPerformed(evt);
            }
        });
        jPanel19.add(cb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 240, -1));

        cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cough", "Shortness of breath", "Chest pain", "Poor oxygenation (hypoxia)", "Back pain", "Chest injury", "Fever", "Abnormal heart sounds,", "Abnormal lung sounds,", "Chest wall deformity", "abnormal chest X-ray test" }));
        cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbActionPerformed(evt);
            }
        });
        jPanel19.add(cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 240, -1));

        LABORATORY_PANEL.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 430, 230));

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thyroid Function Test", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox37.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox37.setText("TSH");
        jPanel20.add(jCheckBox37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jCheckBox38.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox38.setText("FT3");
        jPanel20.add(jCheckBox38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jCheckBox39.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox39.setText("FT4");
        jPanel20.add(jCheckBox39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        LABORATORY_PANEL.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 320, 190, 100));

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Hematology", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox1.setText("CBC with Platelet");
        jPanel25.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jCheckBox2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox2.setText("Peripheral smear");
        jPanel25.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jCheckBox3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox3.setText("Retic Count");
        jPanel25.add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jCheckBox4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox4.setText("Blood Typing");
        jPanel25.add(jCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jCheckBox5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox5.setText("Clotting/Bleeding Time");
        jPanel25.add(jCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jCheckBox6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox6.setText("Proctime/Prothrombin");
        jPanel25.add(jCheckBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jCheckBox7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox7.setText("HbsAg");
        jPanel25.add(jCheckBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jCheckBox8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox8.setText("Heap Profile");
        jPanel25.add(jCheckBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        jCheckBox9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox9.setText("Serum Pregtest");
        jPanel25.add(jCheckBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jCheckBox18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox18.setText("VDRL/RPR (quali)");
        jPanel25.add(jCheckBox18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 163, -1, 20));

        LABORATORY_PANEL.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 200, 220));

        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Others", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jTextArea8.setColumns(20);
        jTextArea8.setRows(5);
        jScrollPane25.setViewportView(jTextArea8);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane25, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addComponent(jScrollPane25, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addContainerGap())
        );

        LABORATORY_PANEL.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 460, -1, -1));

        labBtn.setBackground(new java.awt.Color(0, 102, 102));
        labBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labBtn.setText("Send request");
        labBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        labBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labBtnActionPerformed(evt);
            }
        });
        LABORATORY_PANEL.add(labBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 560, 120, 30));

        lname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lname1ActionPerformed(evt);
            }
        });
        lname1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lname1KeyTyped(evt);
            }
        });
        LABORATORY_PANEL.add(lname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 280, 30));

        jLabel63.setText("Title:");
        LABORATORY_PANEL.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 110, 30));

        search10.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search10MouseClicked(evt);
            }
        });
        search10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search10ActionPerformed(evt);
            }
        });
        search10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search10KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search10KeyReleased(evt);
            }
        });
        LABORATORY_PANEL.add(search10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 250, 30));

        jLabel64.setText("Doctor ID:");
        LABORATORY_PANEL.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 30));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/search.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        LABORATORY_PANEL.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 30, 30));

        search11.setEditable(false);
        search11.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search11ActionPerformed(evt);
            }
        });
        search11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search11KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search11KeyReleased(evt);
            }
        });
        LABORATORY_PANEL.add(search11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 280, 30));

        jLabel65.setText("Dr. Name:");
        LABORATORY_PANEL.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 110, 30));

        AddLaboratory.getContentPane().add(LABORATORY_PANEL, java.awt.BorderLayout.CENTER);

        jPanel27.setBackground(new java.awt.Color(51, 102, 255));
        jPanel27.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel60.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("X");
        jLabel60.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel60MouseClicked(evt);
            }
        });
        jPanel27.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 30, 30));

        room6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        room6.setText("ADD LABORATORY");
        jPanel27.add(room6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, 30));

        AddLaboratory.getContentPane().add(jPanel27, java.awt.BorderLayout.PAGE_START);

        AddConsultationTbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AddConsultationTbl.setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);
        AddConsultationTbl.setUndecorated(true);
        AddConsultationTbl.setResizable(false);

        paraclinicalfinding1.setBackground(new java.awt.Color(255, 255, 255));
        paraclinicalfinding1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 1, true));
        paraclinicalfinding1.setPreferredSize(new java.awt.Dimension(581, 625));
        paraclinicalfinding1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                paraclinicalfinding1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        paraclinicalfinding1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel28.setBackground(new java.awt.Color(51, 102, 255));
        jPanel28.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel61.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("X");
        jLabel61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel61MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel61MouseEntered(evt);
            }
        });
        jPanel28.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 30, 30));

        room7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        room7.setText("VIEW CONSULTATION");
        jPanel28.add(room7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, 30));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/lock.png"))); // NOI18N
        jButton7.setToolTipText("Lock/Unlock Editing");
        jButton7.setContentAreaFilled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel28.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 0, 30, 30));

        paraclinicalfinding1.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 30));

        jTabbedPane8.setBackground(new java.awt.Color(204, 204, 204));

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel29.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        search9.setEditable(false);
        search9.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search9ActionPerformed(evt);
            }
        });
        search9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search9KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search9KeyReleased(evt);
            }
        });
        jPanel29.add(search9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 300, 30));

        search8.setEditable(false);
        search8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        search8.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search8MouseClicked(evt);
            }
        });
        search8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search8ActionPerformed(evt);
            }
        });
        search8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search8KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search8KeyReleased(evt);
            }
        });
        jPanel29.add(search8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 300, 30));

        jLabel62.setText("Doctor ID");
        jPanel29.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 30));

        jLabel66.setText("Dr. Name");
        jPanel29.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 110, 30));

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/search.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel29.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 30, 30));

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));
        jPanel33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane34.setViewportView(jTable1);

        jPanel33.add(jScrollPane34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 550, 530));

        jLabel67.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel67.setText("Filter by:");
        jPanel33.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 5, 70, 30));

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
        jPanel33.add(cbFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 5, -1, -1));

        jPanel29.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 550, 570));

        jLabel74.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel74.setText("General");
        jPanel29.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 210, 30));

        q1.setEditable(false);
        q1.setColumns(20);
        q1.setLineWrap(true);
        q1.setRows(5);
        jScrollPane26.setViewportView(q1);

        jPanel29.add(jScrollPane26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 260, 70));

        jLabel75.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel75.setText("Cardiovascular");
        jPanel29.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 210, 30));

        t1.setEditable(false);
        t1.setColumns(20);
        t1.setLineWrap(true);
        t1.setRows(5);
        jScrollPane27.setViewportView(t1);

        jPanel29.add(jScrollPane27, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 260, 70));

        jLabel76.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel76.setText("Respiratory");
        jPanel29.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 210, 30));

        u1.setEditable(false);
        u1.setColumns(20);
        u1.setLineWrap(true);
        u1.setRows(5);
        jScrollPane28.setViewportView(u1);

        jPanel29.add(jScrollPane28, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 260, 70));

        jLabel77.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel77.setText("Musculoskeletal");
        jPanel29.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, 210, 30));

        i1.setEditable(false);
        i1.setColumns(20);
        i1.setLineWrap(true);
        i1.setRows(5);
        jScrollPane29.setViewportView(i1);

        jPanel29.add(jScrollPane29, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 260, 70));

        jLabel78.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel78.setText("Gastrointestinal");
        jPanel29.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 470, 210, 30));

        o1.setEditable(false);
        o1.setColumns(20);
        o1.setLineWrap(true);
        o1.setRows(5);
        jScrollPane30.setViewportView(o1);

        jPanel29.add(jScrollPane30, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 500, 260, 70));

        r1.setEditable(false);
        r1.setColumns(20);
        r1.setLineWrap(true);
        r1.setRows(5);
        jScrollPane31.setViewportView(r1);

        jPanel29.add(jScrollPane31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 260, 70));

        jLabel79.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel79.setText("Endocrine");
        jPanel29.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 210, 30));

        e1.setEditable(false);
        e1.setColumns(20);
        e1.setLineWrap(true);
        e1.setRows(5);
        jScrollPane32.setViewportView(e1);

        jPanel29.add(jScrollPane32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 260, 70));

        jLabel80.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel80.setText("Neurological");
        jPanel29.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 210, 30));

        w1.setEditable(false);
        w1.setColumns(20);
        w1.setLineWrap(true);
        w1.setRows(5);
        jScrollPane33.setViewportView(w1);

        jPanel29.add(jScrollPane33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 260, 70));

        jLabel81.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel81.setText("Eyes");
        jPanel29.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 210, 30));

        fillAll.setText("Update");
        fillAll.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        fillAll.setMaximumSize(new java.awt.Dimension(82, 26));
        fillAll.setMinimumSize(new java.awt.Dimension(82, 26));
        fillAll.setPreferredSize(new java.awt.Dimension(88, 28));
        fillAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillAllActionPerformed(evt);
            }
        });
        jPanel29.add(fillAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 110, 30));

        jTabbedPane8.addTab("Review of Systems", jPanel29);

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel37.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        search16.setEditable(false);
        search16.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search16ActionPerformed(evt);
            }
        });
        search16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search16KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search16KeyReleased(evt);
            }
        });
        jPanel37.add(search16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 300, 30));

        search17.setEditable(false);
        search17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        search17.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search17MouseClicked(evt);
            }
        });
        search17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search17ActionPerformed(evt);
            }
        });
        search17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search17KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search17KeyReleased(evt);
            }
        });
        jPanel37.add(search17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 300, 30));

        jLabel71.setText("Doctor ID");
        jPanel37.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 30));

        jLabel72.setText("Dr. Name");
        jPanel37.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 110, 30));

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/search.png"))); // NOI18N
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel37.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 30, 30));

        fillAll2.setText("Update");
        fillAll2.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        fillAll2.setMaximumSize(new java.awt.Dimension(82, 26));
        fillAll2.setMinimumSize(new java.awt.Dimension(82, 26));
        fillAll2.setPreferredSize(new java.awt.Dimension(88, 28));
        fillAll2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillAll2ActionPerformed(evt);
            }
        });
        jPanel37.add(fillAll2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 110, 30));

        jLabel73.setText("General");
        jPanel37.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 110, 20));

        jLabel91.setText("Head");
        jPanel37.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 110, 20));

        jLabel92.setText("Eyes");
        jPanel37.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 110, 20));

        jLabel93.setText("Ears");
        jPanel37.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 110, 20));

        jLabel94.setText("Nose");
        jPanel37.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 110, 20));

        jLabel95.setText("Mouth and Troath");
        jPanel37.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 110, 20));

        jLabel96.setText("Neck");
        jPanel37.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 110, 20));

        jLabel97.setText("Breast");
        jPanel37.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 110, 20));

        jLabel98.setText("Gastrointestinal");
        jPanel37.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 110, 20));

        jLabel99.setText("Genitourinary");
        jPanel37.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 110, 20));

        jLabel100.setText("Neurologic");
        jPanel37.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 110, 20));

        jLabel101.setText("Phschiatric");
        jPanel37.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 110, 20));

        ss1.setEditable(false);
        ss1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ss1ActionPerformed(evt);
            }
        });
        jPanel37.add(ss1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 260, 20));

        aa1.setEditable(false);
        jPanel37.add(aa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, 260, 20));

        pp1.setEditable(false);
        jPanel37.add(pp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 260, 20));

        oo1.setEditable(false);
        oo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oo1ActionPerformed(evt);
            }
        });
        jPanel37.add(oo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 260, 20));

        ii1.setEditable(false);
        jPanel37.add(ii1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 260, 20));

        uu1.setEditable(false);
        jPanel37.add(uu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 260, 20));

        yy1.setEditable(false);
        jPanel37.add(yy1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 260, 20));

        tt1.setEditable(false);
        jPanel37.add(tt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 260, 20));

        rr1.setEditable(false);
        jPanel37.add(rr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 260, 20));

        ee1.setEditable(false);
        ee1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ee1ActionPerformed(evt);
            }
        });
        jPanel37.add(ee1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 260, 20));

        ww1.setEditable(false);
        jPanel37.add(ww1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 260, 20));

        qq1.setEditable(false);
        jPanel37.add(qq1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 260, 20));
        jPanel37.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 550, -1));

        jPanel32.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 570));

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));
        jPanel41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable5.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable5AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane38.setViewportView(jTable5);

        jPanel41.add(jScrollPane38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 550, 530));

        jLabel83.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel83.setText("Filter by:");
        jPanel41.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 5, 70, 30));

        cbFilter2.setEditable(true);
        cbFilter2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Today", "Weekly", "Monthly", "Yearly" }));
        cbFilter2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        cbFilter2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbFilter2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cbFilter2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFilter2ActionPerformed(evt);
            }
        });
        jPanel41.add(cbFilter2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 5, -1, -1));

        jPanel32.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 550, 570));

        jTabbedPane8.addTab("Physical Exam", jPanel32);

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));
        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel34.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel70.setText("Height");
        jPanel34.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 110, 30));

        c.setEditable(false);
        c.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        c.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        c.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cMouseClicked(evt);
            }
        });
        c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cActionPerformed(evt);
            }
        });
        c.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cKeyReleased(evt);
            }
        });
        jPanel34.add(c, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 300, 30));

        z.setEditable(false);
        z.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        z.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        z.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                zMouseClicked(evt);
            }
        });
        z.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zActionPerformed(evt);
            }
        });
        z.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                zKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                zKeyReleased(evt);
            }
        });
        jPanel34.add(z, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 300, 30));

        jLabel84.setText("Blood Pressure");
        jPanel34.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 30));

        x.setEditable(false);
        x.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        x.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        x.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xMouseClicked(evt);
            }
        });
        x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xActionPerformed(evt);
            }
        });
        x.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                xKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                xKeyReleased(evt);
            }
        });
        jPanel34.add(x, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 300, 30));

        jLabel85.setText("Temperature");
        jPanel34.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 110, 30));

        jLabel86.setText("Weight");
        jPanel34.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 110, 30));

        v.setEditable(false);
        v.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        v.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        v.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vMouseClicked(evt);
            }
        });
        v.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vActionPerformed(evt);
            }
        });
        v.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                vKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                vKeyReleased(evt);
            }
        });
        jPanel34.add(v, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 300, 30));

        fillAll1.setText("Update");
        fillAll1.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        fillAll1.setMaximumSize(new java.awt.Dimension(82, 26));
        fillAll1.setMinimumSize(new java.awt.Dimension(82, 26));
        fillAll1.setPreferredSize(new java.awt.Dimension(88, 28));
        fillAll1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillAll1ActionPerformed(evt);
            }
        });
        jPanel34.add(fillAll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 110, 30));

        jPanel31.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 570));

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable3AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane35.setViewportView(jTable3);

        jPanel40.add(jScrollPane35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 550, 530));

        jLabel82.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel82.setText("Filter by:");
        jPanel40.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 5, 70, 30));

        cbFilter1.setEditable(true);
        cbFilter1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Today", "Weekly", "Monthly", "Yearly" }));
        cbFilter1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        cbFilter1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbFilter1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cbFilter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFilter1ActionPerformed(evt);
            }
        });
        jPanel40.add(cbFilter1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 5, -1, -1));

        jPanel31.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 550, 570));

        jTabbedPane8.addTab("Vitals", jPanel31);

        paraclinicalfinding1.add(jTabbedPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1140, 600));

        AddConsultationTbl.getContentPane().add(paraclinicalfinding1, java.awt.BorderLayout.CENTER);

        UpdateConsultation.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        UpdateConsultation.setUndecorated(true);

        diagnosis9.setBackground(new java.awt.Color(255, 255, 255));
        diagnosis9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 1, true));
        diagnosis9.setPreferredSize(new java.awt.Dimension(1141, 630));
        diagnosis9.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                diagnosis9AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        diagnosis9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel65.setBackground(new java.awt.Color(51, 102, 255));
        jPanel65.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel65.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel141.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel141.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel141.setText("X");
        jLabel141.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel141MouseClicked(evt);
            }
        });
        jPanel65.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 30, 30));

        room16.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        room16.setText("Enter Password");
        jPanel65.add(room16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 30));

        diagnosis9.add(jPanel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 30));

        Pass.setBackground(new java.awt.Color(108, 192, 240));
        Pass.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Pass.setBorder(null);
        Pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PassMouseClicked(evt);
            }
        });
        Pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PassKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PassKeyReleased(evt);
            }
        });
        diagnosis9.add(Pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 280, 30));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        diagnosis9.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 280, 10));

        fillAll11.setText("Enter");
        fillAll11.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        fillAll11.setMaximumSize(new java.awt.Dimension(82, 26));
        fillAll11.setMinimumSize(new java.awt.Dimension(82, 26));
        fillAll11.setPreferredSize(new java.awt.Dimension(88, 28));
        fillAll11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillAll11ActionPerformed(evt);
            }
        });
        diagnosis9.add(fillAll11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 110, 30));

        UpdateConsultation.getContentPane().add(diagnosis9, java.awt.BorderLayout.CENTER);

        AddDiagnosisTbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AddDiagnosisTbl.setUndecorated(true);

        diagnosis2.setBackground(new java.awt.Color(255, 255, 255));
        diagnosis2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 1, true));
        diagnosis2.setPreferredSize(new java.awt.Dimension(1141, 630));
        diagnosis2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                diagnosis2AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        diagnosis2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel39.setBackground(new java.awt.Color(51, 102, 255));
        jPanel39.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel90.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel90.setText("X");
        jLabel90.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel90MouseClicked(evt);
            }
        });
        jPanel39.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 30, 30));

        room9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        room9.setText("VIEW DIAGNOSIS");
        jPanel39.add(room9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, 30));

        diagnosis2.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 30));

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/lock.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        diagnosis2.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 30, 30));

        fillAll3.setText("Update");
        fillAll3.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        fillAll3.setMaximumSize(new java.awt.Dimension(82, 26));
        fillAll3.setMinimumSize(new java.awt.Dimension(82, 26));
        fillAll3.setPreferredSize(new java.awt.Dimension(88, 28));
        fillAll3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillAll3ActionPerformed(evt);
            }
        });
        diagnosis2.add(fillAll3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 110, 30));

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));
        jPanel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable2AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane36.setViewportView(jTable2);

        jPanel36.add(jScrollPane36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 550, 550));

        jLabel68.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel68.setText("Filter by:");
        jPanel36.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 5, 70, 30));

        cbFilter3.setEditable(true);
        cbFilter3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Today", "Weekly", "Monthly", "Yearly" }));
        cbFilter3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        cbFilter3.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbFilter3PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cbFilter3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFilter3ActionPerformed(evt);
            }
        });
        jPanel36.add(cbFilter3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 5, -1, -1));

        diagnosis2.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 550, 590));

        jLabel69.setText("Doctor ID:");
        diagnosis2.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, 30));

        search12.setEditable(false);
        search12.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search12MouseClicked(evt);
            }
        });
        search12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search12ActionPerformed(evt);
            }
        });
        search12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search12KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search12KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search12KeyTyped(evt);
            }
        });
        diagnosis2.add(search12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 280, 30));

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/search.png"))); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        diagnosis2.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 30, 30));

        search13.setEditable(false);
        search13.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search13ActionPerformed(evt);
            }
        });
        search13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search13KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search13KeyReleased(evt);
            }
        });
        diagnosis2.add(search13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 280, 30));

        jLabel87.setText("Dr. Name:");
        diagnosis2.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, 30));

        jLabel88.setText("Diagnosis");
        diagnosis2.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 110, 30));

        lname2.setEditable(false);
        lname2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lname2ActionPerformed(evt);
            }
        });
        lname2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lname2KeyTyped(evt);
            }
        });
        diagnosis2.add(lname2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 280, 30));

        insert1.setEditable(false);
        insert1.setColumns(20);
        insert1.setLineWrap(true);
        insert1.setRows(5);
        jScrollPane37.setViewportView(insert1);

        diagnosis2.add(jScrollPane37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 570, 440));

        jLabel89.setText("Details");
        diagnosis2.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 100, 30));

        AddDiagnosisTbl.getContentPane().add(diagnosis2, java.awt.BorderLayout.CENTER);

        AddClinicalFindingTbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AddClinicalFindingTbl.setUndecorated(true);

        diagnosis3.setBackground(new java.awt.Color(255, 255, 255));
        diagnosis3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 1, true));
        diagnosis3.setPreferredSize(new java.awt.Dimension(1141, 630));
        diagnosis3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                diagnosis3AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        diagnosis3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel42.setBackground(new java.awt.Color(51, 102, 255));
        jPanel42.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel42.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel102.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel102.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel102.setText("X");
        jLabel102.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel102MouseClicked(evt);
            }
        });
        jPanel42.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 30, 30));

        room10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        room10.setText("VIEW CLINICAL FINDINGS");
        jPanel42.add(room10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, 30));

        diagnosis3.add(jPanel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 30));

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/lock.png"))); // NOI18N
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        diagnosis3.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 30, 30));

        fillAll4.setText("Update");
        fillAll4.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        fillAll4.setMaximumSize(new java.awt.Dimension(82, 26));
        fillAll4.setMinimumSize(new java.awt.Dimension(82, 26));
        fillAll4.setPreferredSize(new java.awt.Dimension(88, 28));
        fillAll4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillAll4ActionPerformed(evt);
            }
        });
        diagnosis3.add(fillAll4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 110, 30));

        jPanel43.setBackground(new java.awt.Color(255, 255, 255));
        jPanel43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jPanel43.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable4.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable4AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane39.setViewportView(jTable4);

        jPanel43.add(jScrollPane39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 550, 550));

        jLabel103.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel103.setText("Filter by:");
        jPanel43.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 5, 70, 30));

        cbFilter4.setEditable(true);
        cbFilter4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Today", "Weekly", "Monthly", "Yearly" }));
        cbFilter4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        cbFilter4.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbFilter4PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cbFilter4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFilter4ActionPerformed(evt);
            }
        });
        jPanel43.add(cbFilter4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 5, -1, -1));

        diagnosis3.add(jPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 550, 590));

        jLabel104.setText("Doctor ID");
        diagnosis3.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, 30));

        search14.setEditable(false);
        search14.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search14MouseClicked(evt);
            }
        });
        search14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search14ActionPerformed(evt);
            }
        });
        search14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search14KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search14KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search14KeyTyped(evt);
            }
        });
        diagnosis3.add(search14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 280, 30));

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/search.png"))); // NOI18N
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        diagnosis3.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 30, 30));

        search15.setEditable(false);
        search15.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search15ActionPerformed(evt);
            }
        });
        search15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search15KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search15KeyReleased(evt);
            }
        });
        diagnosis3.add(search15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 280, 30));

        jLabel105.setText("Dr. Name");
        diagnosis3.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, 30));

        jLabel106.setText("Title");
        diagnosis3.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 110, 30));

        lname3.setEditable(false);
        lname3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lname3ActionPerformed(evt);
            }
        });
        lname3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lname3KeyTyped(evt);
            }
        });
        diagnosis3.add(lname3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 280, 30));

        insert2.setEditable(false);
        insert2.setColumns(20);
        insert2.setLineWrap(true);
        insert2.setRows(5);
        jScrollPane40.setViewportView(insert2);

        diagnosis3.add(jScrollPane40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 570, 440));

        jLabel107.setText("Note");
        diagnosis3.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 100, 30));

        AddClinicalFindingTbl.getContentPane().add(diagnosis3, java.awt.BorderLayout.CENTER);

        AddLaboratoryTbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AddLaboratoryTbl.setUndecorated(true);

        diagnosis5.setBackground(new java.awt.Color(255, 255, 255));
        diagnosis5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 1, true));
        diagnosis5.setPreferredSize(new java.awt.Dimension(1141, 630));
        diagnosis5.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                diagnosis5AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        diagnosis5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel46.setBackground(new java.awt.Color(51, 102, 255));
        jPanel46.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel46.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel114.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel114.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel114.setText("X");
        jLabel114.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel114MouseClicked(evt);
            }
        });
        jPanel46.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 30, 30));

        room12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        room12.setText("VIEW LABORATORY");
        jPanel46.add(room12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, 30));

        diagnosis5.add(jPanel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 30));

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/lock.png"))); // NOI18N
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        diagnosis5.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 30, 30));

        fillAll6.setText("Update");
        fillAll6.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        fillAll6.setMaximumSize(new java.awt.Dimension(82, 26));
        fillAll6.setMinimumSize(new java.awt.Dimension(82, 26));
        fillAll6.setPreferredSize(new java.awt.Dimension(88, 28));
        fillAll6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillAll6ActionPerformed(evt);
            }
        });
        diagnosis5.add(fillAll6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 110, 30));

        jPanel47.setBackground(new java.awt.Color(255, 255, 255));
        jPanel47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jPanel47.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable7.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable7AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable7MouseClicked(evt);
            }
        });
        jScrollPane43.setViewportView(jTable7);

        jPanel47.add(jScrollPane43, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 550, 550));

        jLabel115.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel115.setText("Filter by:");
        jPanel47.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 5, 70, 30));

        cbFilter6.setEditable(true);
        cbFilter6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Today", "Weekly", "Monthly", "Yearly" }));
        cbFilter6.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        cbFilter6.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbFilter6PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cbFilter6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFilter6ActionPerformed(evt);
            }
        });
        jPanel47.add(cbFilter6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 5, -1, -1));

        diagnosis5.add(jPanel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 550, 590));

        jLabel116.setText("Doctor ID");
        diagnosis5.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, 30));

        search20.setEditable(false);
        search20.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search20MouseClicked(evt);
            }
        });
        search20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search20ActionPerformed(evt);
            }
        });
        search20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search20KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search20KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search20KeyTyped(evt);
            }
        });
        diagnosis5.add(search20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 280, 30));

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/search.png"))); // NOI18N
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        diagnosis5.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 30, 30));

        search21.setEditable(false);
        search21.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search21ActionPerformed(evt);
            }
        });
        search21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search21KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search21KeyReleased(evt);
            }
        });
        diagnosis5.add(search21, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 280, 30));

        jLabel117.setText("Dr. Name");
        diagnosis5.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, 30));

        jLabel118.setText("Title");
        diagnosis5.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 110, 30));

        lname5.setEditable(false);
        lname5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lname5ActionPerformed(evt);
            }
        });
        lname5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lname5KeyTyped(evt);
            }
        });
        diagnosis5.add(lname5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 280, 30));

        insert4.setEditable(false);
        insert4.setColumns(20);
        insert4.setLineWrap(true);
        insert4.setRows(5);
        jScrollPane44.setViewportView(insert4);

        diagnosis5.add(jScrollPane44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 570, 440));

        jLabel119.setText("Note");
        diagnosis5.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 100, 30));

        AddLaboratoryTbl.getContentPane().add(diagnosis5, java.awt.BorderLayout.CENTER);

        AddAllergyTbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AddAllergyTbl.setUndecorated(true);

        diagnosis4.setBackground(new java.awt.Color(255, 255, 255));
        diagnosis4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 1, true));
        diagnosis4.setPreferredSize(new java.awt.Dimension(1141, 630));
        diagnosis4.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                diagnosis4AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        diagnosis4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel44.setBackground(new java.awt.Color(51, 102, 255));
        jPanel44.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel44.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel108.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel108.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel108.setText("X");
        jLabel108.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel108MouseClicked(evt);
            }
        });
        jPanel44.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 30, 30));

        room11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        room11.setText("VIEW ALLERGY");
        jPanel44.add(room11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, 30));

        diagnosis4.add(jPanel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 30));

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/lock.png"))); // NOI18N
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        diagnosis4.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 30, 30));

        fillAll5.setText("Update");
        fillAll5.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        fillAll5.setMaximumSize(new java.awt.Dimension(82, 26));
        fillAll5.setMinimumSize(new java.awt.Dimension(82, 26));
        fillAll5.setPreferredSize(new java.awt.Dimension(88, 28));
        fillAll5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillAll5ActionPerformed(evt);
            }
        });
        diagnosis4.add(fillAll5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 110, 30));

        jPanel45.setBackground(new java.awt.Color(255, 255, 255));
        jPanel45.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jPanel45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable6.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable6AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jScrollPane41.setViewportView(jTable6);

        jPanel45.add(jScrollPane41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 550, 550));

        jLabel109.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel109.setText("Filter by:");
        jPanel45.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 5, 70, 30));

        cbFilter5.setEditable(true);
        cbFilter5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Today", "Weekly", "Monthly", "Yearly" }));
        cbFilter5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        cbFilter5.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbFilter5PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cbFilter5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFilter5ActionPerformed(evt);
            }
        });
        jPanel45.add(cbFilter5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 5, -1, -1));

        diagnosis4.add(jPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 550, 590));

        jLabel110.setText("Doctor ID");
        diagnosis4.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, 30));

        search18.setEditable(false);
        search18.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search18MouseClicked(evt);
            }
        });
        search18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search18ActionPerformed(evt);
            }
        });
        search18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search18KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search18KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search18KeyTyped(evt);
            }
        });
        diagnosis4.add(search18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 280, 30));

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/search.png"))); // NOI18N
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        diagnosis4.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 30, 30));

        search19.setEditable(false);
        search19.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search19ActionPerformed(evt);
            }
        });
        search19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search19KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search19KeyReleased(evt);
            }
        });
        diagnosis4.add(search19, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 280, 30));

        jLabel111.setText("Dr. Name");
        diagnosis4.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, 30));

        jLabel112.setText("Title");
        diagnosis4.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 110, 30));

        lname4.setEditable(false);
        lname4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lname4ActionPerformed(evt);
            }
        });
        lname4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lname4KeyTyped(evt);
            }
        });
        diagnosis4.add(lname4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 280, 30));

        insert3.setEditable(false);
        insert3.setColumns(20);
        insert3.setLineWrap(true);
        insert3.setRows(5);
        jScrollPane42.setViewportView(insert3);

        diagnosis4.add(jScrollPane42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 570, 440));

        jLabel113.setText("Note");
        diagnosis4.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 100, 30));

        AddAllergyTbl.getContentPane().add(diagnosis4, java.awt.BorderLayout.CENTER);

        AddSurgeryTbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AddSurgeryTbl.setUndecorated(true);

        diagnosis6.setBackground(new java.awt.Color(255, 255, 255));
        diagnosis6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 1, true));
        diagnosis6.setPreferredSize(new java.awt.Dimension(1141, 630));
        diagnosis6.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                diagnosis6AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        diagnosis6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel48.setBackground(new java.awt.Color(51, 102, 255));
        jPanel48.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel48.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel120.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel120.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel120.setText("X");
        jLabel120.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel120MouseClicked(evt);
            }
        });
        jPanel48.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 30, 30));

        room13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        room13.setText("VIEW SURGERY");
        jPanel48.add(room13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, 30));

        diagnosis6.add(jPanel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 30));

        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/lock.png"))); // NOI18N
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        diagnosis6.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 30, 30));

        fillAll7.setText("Update");
        fillAll7.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        fillAll7.setMaximumSize(new java.awt.Dimension(82, 26));
        fillAll7.setMinimumSize(new java.awt.Dimension(82, 26));
        fillAll7.setPreferredSize(new java.awt.Dimension(88, 28));
        fillAll7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillAll7ActionPerformed(evt);
            }
        });
        diagnosis6.add(fillAll7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 110, 30));

        jPanel49.setBackground(new java.awt.Color(255, 255, 255));
        jPanel49.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jPanel49.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable8.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable8AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable8MouseClicked(evt);
            }
        });
        jScrollPane45.setViewportView(jTable8);

        jPanel49.add(jScrollPane45, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 550, 550));

        jLabel121.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel121.setText("Filter by:");
        jPanel49.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 5, 70, 30));

        cbFilter7.setEditable(true);
        cbFilter7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Today", "Weekly", "Monthly", "Yearly" }));
        cbFilter7.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        cbFilter7.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbFilter7PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cbFilter7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFilter7ActionPerformed(evt);
            }
        });
        jPanel49.add(cbFilter7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 5, -1, -1));

        diagnosis6.add(jPanel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 550, 590));

        jLabel122.setText("Doctor ID");
        diagnosis6.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, 30));

        search22.setEditable(false);
        search22.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search22MouseClicked(evt);
            }
        });
        search22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search22ActionPerformed(evt);
            }
        });
        search22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search22KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search22KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search22KeyTyped(evt);
            }
        });
        diagnosis6.add(search22, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 280, 30));

        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/search.png"))); // NOI18N
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        diagnosis6.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 30, 30));

        search23.setEditable(false);
        search23.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search23ActionPerformed(evt);
            }
        });
        search23.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search23KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search23KeyReleased(evt);
            }
        });
        diagnosis6.add(search23, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 280, 30));

        jLabel123.setText("Dr. Name");
        diagnosis6.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, 30));

        jLabel124.setText("Title");
        diagnosis6.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 110, 30));

        lname6.setEditable(false);
        lname6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lname6ActionPerformed(evt);
            }
        });
        lname6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lname6KeyTyped(evt);
            }
        });
        diagnosis6.add(lname6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 280, 30));

        insert5.setEditable(false);
        insert5.setColumns(20);
        insert5.setLineWrap(true);
        insert5.setRows(5);
        jScrollPane46.setViewportView(insert5);

        diagnosis6.add(jScrollPane46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 570, 440));

        jLabel125.setText("Note");
        diagnosis6.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 100, 30));

        AddSurgeryTbl.getContentPane().add(diagnosis6, java.awt.BorderLayout.CENTER);

        AddMedicineTbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AddMedicineTbl.setUndecorated(true);

        diagnosis8.setBackground(new java.awt.Color(255, 255, 255));
        diagnosis8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 1, true));
        diagnosis8.setPreferredSize(new java.awt.Dimension(1141, 630));
        diagnosis8.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                diagnosis8AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        diagnosis8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel52.setBackground(new java.awt.Color(51, 102, 255));
        jPanel52.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel52.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel132.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel132.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel132.setText("X");
        jLabel132.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel132MouseClicked(evt);
            }
        });
        jPanel52.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 30, 30));

        room15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        room15.setText("VIEW MEDICINE");
        jPanel52.add(room15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, 30));

        diagnosis8.add(jPanel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 30));

        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/lock.png"))); // NOI18N
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        diagnosis8.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 30, 30));

        fillAll9.setText("Update");
        fillAll9.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        fillAll9.setMaximumSize(new java.awt.Dimension(82, 26));
        fillAll9.setMinimumSize(new java.awt.Dimension(82, 26));
        fillAll9.setPreferredSize(new java.awt.Dimension(88, 28));
        fillAll9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillAll9ActionPerformed(evt);
            }
        });
        diagnosis8.add(fillAll9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 110, 30));

        jPanel53.setBackground(new java.awt.Color(255, 255, 255));
        jPanel53.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jPanel53.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable10.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable10AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable10MouseClicked(evt);
            }
        });
        jScrollPane49.setViewportView(jTable10);

        jPanel53.add(jScrollPane49, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 550, 550));

        jLabel133.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel133.setText("Filter by:");
        jPanel53.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 5, 70, 30));

        cbFilter9.setEditable(true);
        cbFilter9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Today", "Weekly", "Monthly", "Yearly" }));
        cbFilter9.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        cbFilter9.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbFilter9PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cbFilter9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFilter9ActionPerformed(evt);
            }
        });
        jPanel53.add(cbFilter9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 5, -1, -1));

        diagnosis8.add(jPanel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 550, 590));

        jLabel134.setText("Doctor ID");
        diagnosis8.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, 30));

        search26.setEditable(false);
        search26.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search26MouseClicked(evt);
            }
        });
        search26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search26ActionPerformed(evt);
            }
        });
        search26.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search26KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search26KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search26KeyTyped(evt);
            }
        });
        diagnosis8.add(search26, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 280, 30));

        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/search.png"))); // NOI18N
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        diagnosis8.add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 30, 30));

        search27.setEditable(false);
        search27.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search27ActionPerformed(evt);
            }
        });
        search27.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search27KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search27KeyReleased(evt);
            }
        });
        diagnosis8.add(search27, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 280, 30));

        jLabel135.setText("Dr. Name");
        diagnosis8.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, 30));

        jLabel136.setText("Title");
        diagnosis8.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 110, 30));

        lname8.setEditable(false);
        lname8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lname8ActionPerformed(evt);
            }
        });
        lname8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lname8KeyTyped(evt);
            }
        });
        diagnosis8.add(lname8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 280, 30));

        insert7.setEditable(false);
        insert7.setColumns(20);
        insert7.setLineWrap(true);
        insert7.setRows(5);
        jScrollPane50.setViewportView(insert7);

        diagnosis8.add(jScrollPane50, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 570, 440));

        jLabel137.setText("Note");
        diagnosis8.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 100, 30));

        AddMedicineTbl.getContentPane().add(diagnosis8, java.awt.BorderLayout.CENTER);

        AddSurgery.setTitle("Add Allergy");
        AddSurgery.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AddSurgery.setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);
        AddSurgery.setUndecorated(true);

        allergy2.setBackground(new java.awt.Color(255, 255, 255));
        allergy2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 1, true));
        allergy2.setToolTipText("");
        allergy2.setPreferredSize(new java.awt.Dimension(639, 322));
        allergy2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                allergy2AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        allergy2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel148.setText("Note");
        allergy2.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 100, 30));

        jTextArea9.setColumns(20);
        jTextArea9.setRows(5);
        jScrollPane64.setViewportView(jTextArea9);

        allergy2.add(jScrollPane64, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 620, 200));

        sub_module_1_btn11.setBackground(new java.awt.Color(153, 153, 153));
        sub_module_1_btn11.setText("Save & Close");
        sub_module_1_btn11.setToolTipText("Sub Module 1");
        sub_module_1_btn11.setBorder(null);
        sub_module_1_btn11.setBorderPainted(false);
        sub_module_1_btn11.setContentAreaFilled(false);
        sub_module_1_btn11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sub_module_1_btn11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sub_module_1_btn11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sub_module_1_btn11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sub_module_1_btn11MouseExited(evt);
            }
        });
        sub_module_1_btn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sub_module_1_btn11ActionPerformed(evt);
            }
        });
        allergy2.add(sub_module_1_btn11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 440, 120, 40));

        jLabel149.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        allergy2.add(jLabel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        allergy2.add(title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 280, 30));

        jLabel151.setText("Title:");
        allergy2.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 50, 30));

        jPanel72.setBackground(new java.awt.Color(51, 102, 255));
        jPanel72.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel72.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        room20.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        room20.setText("ADD SURGERY");
        jPanel72.add(room20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, 30));

        jLabel152.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel152.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel152.setText("X");
        jLabel152.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel152MouseClicked(evt);
            }
        });
        jPanel72.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 40, 30));

        allergy2.add(jPanel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 30));

        jLabel162.setText("Doctor ID:");
        allergy2.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, 30));

        search31.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search31MouseClicked(evt);
            }
        });
        search31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search31ActionPerformed(evt);
            }
        });
        search31.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search31KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search31KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search31KeyTyped(evt);
            }
        });
        allergy2.add(search31, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 250, 30));

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/search.png"))); // NOI18N
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        allergy2.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 30, 30));

        search32.setEditable(false);
        search32.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search32ActionPerformed(evt);
            }
        });
        search32.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search32KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search32KeyReleased(evt);
            }
        });
        allergy2.add(search32, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 280, 30));

        jLabel163.setText("Dr. Name:");
        allergy2.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, 30));
        allergy2.add(bday6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 240, 30));

        jLabel164.setText("Date of Surgery");
        allergy2.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 120, 30));
        allergy2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 620, -1));

        AddSurgery.getContentPane().add(allergy2, java.awt.BorderLayout.CENTER);

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(1166, 582));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1280, 500));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(imageHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 120));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 140, 120));

        name.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        name.setText("ID:");
        jPanel2.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 130, 20));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel3.setText("GENDER:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 130, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setText("Search Patient:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 30));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_allergies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Laboratory"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_allergies.getTableHeader().setResizingAllowed(false);
        tbl_allergies.getTableHeader().setReorderingAllowed(false);
        tbl_allergies.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbl_allergiesAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane12.setViewportView(tbl_allergies);

        jPanel4.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 240));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 240, 240));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_clinical.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_clinical.getTableHeader().setResizingAllowed(false);
        tbl_clinical.getTableHeader().setReorderingAllowed(false);
        tbl_clinical.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbl_clinicalAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane3.setViewportView(tbl_clinical);
        if (tbl_clinical.getColumnModel().getColumnCount() > 0) {
            tbl_clinical.getColumnModel().getColumn(0).setResizable(false);
            tbl_clinical.getColumnModel().getColumn(1).setResizable(false);
            tbl_clinical.getColumnModel().getColumn(2).setResizable(false);
            tbl_clinical.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 220));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 240, 220));

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_consultation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_consultation.getTableHeader().setResizingAllowed(false);
        tbl_consultation.getTableHeader().setReorderingAllowed(false);
        tbl_consultation.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbl_consultationAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(tbl_consultation);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 240, 70));

        tbl_consultation1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_consultation1.getTableHeader().setResizingAllowed(false);
        tbl_consultation1.getTableHeader().setReorderingAllowed(false);
        tbl_consultation1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbl_consultation1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane4.setViewportView(tbl_consultation1);

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 80));

        tbl_consultation2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_consultation2.getTableHeader().setResizingAllowed(false);
        tbl_consultation2.getTableHeader().setReorderingAllowed(false);
        tbl_consultation2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbl_consultation2AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane24.setViewportView(tbl_consultation2);

        jPanel6.add(jScrollPane24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 240, 70));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 240, -1));

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_allergy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Surgery"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_allergy.getTableHeader().setResizingAllowed(false);
        tbl_allergy.getTableHeader().setReorderingAllowed(false);
        tbl_allergy.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbl_allergyAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane8.setViewportView(tbl_allergy);

        jPanel7.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 240));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 240, 240));

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_treatment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Bed and Linen Request"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_treatment.getTableHeader().setResizingAllowed(false);
        tbl_treatment.getTableHeader().setReorderingAllowed(false);
        tbl_treatment.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbl_treatmentAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane10.setViewportView(tbl_treatment);

        jPanel8.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 240));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 300, 240, 240));

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_diagnosis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_diagnosis.getTableHeader().setResizingAllowed(false);
        tbl_diagnosis.getTableHeader().setReorderingAllowed(false);
        tbl_diagnosis.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbl_diagnosisAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane2.setViewportView(tbl_diagnosis);

        jPanel9.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 220));

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 240, 220));

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_surgeries.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_surgeries.getTableHeader().setResizingAllowed(false);
        tbl_surgeries.getTableHeader().setReorderingAllowed(false);
        tbl_surgeries.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbl_surgeriesAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane11.setViewportView(tbl_surgeries);

        jPanel10.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 220));

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 50, 240, 220));

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_medication.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Medicine"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_medication.getTableHeader().setResizingAllowed(false);
        tbl_medication.getTableHeader().setReorderingAllowed(false);
        tbl_medication.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbl_medicationAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane9.setViewportView(tbl_medication);

        jPanel11.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 240));

        jPanel2.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 300, 240, 240));

        DrugPrescription.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        DrugPrescription.setForeground(new java.awt.Color(51, 153, 255));
        DrugPrescription.setText("Add Medicine");
        DrugPrescription.setBorderPainted(false);
        DrugPrescription.setContentAreaFilled(false);
        DrugPrescription.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DrugPrescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DrugPrescriptionActionPerformed(evt);
            }
        });
        jPanel2.add(DrugPrescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 540, 110, -1));

        Diagnosis.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Diagnosis.setForeground(new java.awt.Color(51, 153, 255));
        Diagnosis.setText("Add Diagnosis");
        Diagnosis.setBorderPainted(false);
        Diagnosis.setContentAreaFilled(false);
        Diagnosis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Diagnosis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiagnosisActionPerformed(evt);
            }
        });
        jPanel2.add(Diagnosis, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 110, -1));

        Consultation.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Consultation.setForeground(new java.awt.Color(51, 153, 255));
        Consultation.setText("Add Consultation");
        Consultation.setBorderPainted(false);
        Consultation.setContentAreaFilled(false);
        Consultation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Consultation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultationActionPerformed(evt);
            }
        });
        jPanel2.add(Consultation, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 130, -1));

        ClinicalFinding.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        ClinicalFinding.setForeground(new java.awt.Color(51, 153, 255));
        ClinicalFinding.setText("Add Clinical Finding");
        ClinicalFinding.setBorderPainted(false);
        ClinicalFinding.setContentAreaFilled(false);
        ClinicalFinding.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ClinicalFinding.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClinicalFindingActionPerformed(evt);
            }
        });
        jPanel2.add(ClinicalFinding, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 270, 140, -1));

        Allergy.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Allergy.setForeground(new java.awt.Color(51, 153, 255));
        Allergy.setText("AddLaboratory");
        Allergy.setBorderPainted(false);
        Allergy.setContentAreaFilled(false);
        Allergy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Allergy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllergyActionPerformed(evt);
            }
        });
        jPanel2.add(Allergy, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 540, 110, -1));

        Surgery.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Surgery.setForeground(new java.awt.Color(51, 153, 255));
        Surgery.setText("Add Surgery");
        Surgery.setBorderPainted(false);
        Surgery.setContentAreaFilled(false);
        Surgery.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Surgery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SurgeryActionPerformed(evt);
            }
        });
        jPanel2.add(Surgery, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 540, 100, -1));

        Treatment.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Treatment.setForeground(new java.awt.Color(51, 153, 255));
        Treatment.setText("Linen Reqest");
        Treatment.setBorderPainted(false);
        Treatment.setContentAreaFilled(false);
        Treatment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Treatment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TreatmentActionPerformed(evt);
            }
        });
        jPanel2.add(Treatment, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 540, 130, -1));

        Allergy1.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Allergy1.setForeground(new java.awt.Color(51, 153, 255));
        Allergy1.setText("Add Allergy");
        Allergy1.setBorderPainted(false);
        Allergy1.setContentAreaFilled(false);
        Allergy1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Allergy1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Allergy1ActionPerformed(evt);
            }
        });
        jPanel2.add(Allergy1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 270, 100, -1));

        search.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        jPanel2.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 250, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel6.setText("NAME:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 130, 20));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/search.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 30, 30));

        date_dayv2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        date_dayv2.setText("date");
        jPanel2.add(date_dayv2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 80, 30));

        Consultation1.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Consultation1.setForeground(new java.awt.Color(51, 153, 255));
        Consultation1.setText("View/Edit");
        Consultation1.setToolTipText("View/Edit Dianosis");
        Consultation1.setBorderPainted(false);
        Consultation1.setContentAreaFilled(false);
        Consultation1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Consultation1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Consultation1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Consultation1ActionPerformed(evt);
            }
        });
        jPanel2.add(Consultation1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 90, -1));

        Consultation2.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Consultation2.setForeground(new java.awt.Color(51, 153, 255));
        Consultation2.setText("View/Edit");
        Consultation2.setToolTipText("View/Edit Clinical Findings");
        Consultation2.setBorderPainted(false);
        Consultation2.setContentAreaFilled(false);
        Consultation2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Consultation2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Consultation2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Consultation2ActionPerformed(evt);
            }
        });
        jPanel2.add(Consultation2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, 90, -1));

        Consultation3.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Consultation3.setForeground(new java.awt.Color(51, 153, 255));
        Consultation3.setText("View/Edit");
        Consultation3.setToolTipText("View/Edit Allergy");
        Consultation3.setBorderPainted(false);
        Consultation3.setContentAreaFilled(false);
        Consultation3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Consultation3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Consultation3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Consultation3ActionPerformed(evt);
            }
        });
        jPanel2.add(Consultation3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 270, 90, -1));

        Consultation4.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Consultation4.setForeground(new java.awt.Color(51, 153, 255));
        Consultation4.setText("View/Edit");
        Consultation4.setToolTipText("View/Edit Consultation");
        Consultation4.setBorderPainted(false);
        Consultation4.setContentAreaFilled(false);
        Consultation4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Consultation4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Consultation4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Consultation4ActionPerformed(evt);
            }
        });
        jPanel2.add(Consultation4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 90, -1));

        Consultation5.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Consultation5.setForeground(new java.awt.Color(51, 153, 255));
        Consultation5.setText("View/Edit");
        Consultation5.setToolTipText("View/Edit Laboratory");
        Consultation5.setBorderPainted(false);
        Consultation5.setContentAreaFilled(false);
        Consultation5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Consultation5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Consultation5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Consultation5ActionPerformed(evt);
            }
        });
        jPanel2.add(Consultation5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 540, 90, -1));

        Consultation6.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Consultation6.setForeground(new java.awt.Color(51, 153, 255));
        Consultation6.setText("View/Edit");
        Consultation6.setToolTipText("View/Edit Surgery");
        Consultation6.setBorderPainted(false);
        Consultation6.setContentAreaFilled(false);
        Consultation6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Consultation6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Consultation6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Consultation6ActionPerformed(evt);
            }
        });
        jPanel2.add(Consultation6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 540, 90, -1));

        Consultation7.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Consultation7.setForeground(new java.awt.Color(51, 153, 255));
        Consultation7.setText("View/Edit");
        Consultation7.setToolTipText("View/Edit Bed&Linen");
        Consultation7.setBorderPainted(false);
        Consultation7.setContentAreaFilled(false);
        Consultation7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Consultation7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Consultation7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Consultation7ActionPerformed(evt);
            }
        });
        jPanel2.add(Consultation7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 540, 90, -1));

        Consultation8.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Consultation8.setForeground(new java.awt.Color(51, 153, 255));
        Consultation8.setText("View/Edit");
        Consultation8.setToolTipText("View/Edit Medicine");
        Consultation8.setBorderPainted(false);
        Consultation8.setContentAreaFilled(false);
        Consultation8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Consultation8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Consultation8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Consultation8ActionPerformed(evt);
            }
        });
        jPanel2.add(Consultation8, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 540, 90, -1));

        GENDER.setEditable(false);
        jPanel2.add(GENDER, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 140, -1));

        ID.setEditable(false);
        jPanel2.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 140, -1));

        NAME.setEditable(false);
        jPanel2.add(NAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 140, -1));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 580));

        jPanel54.setBackground(new java.awt.Color(204, 204, 204));
        jPanel54.setPreferredSize(new java.awt.Dimension(1166, 582));
        jPanel54.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel55.setBackground(new java.awt.Color(255, 255, 255));
        jPanel55.setPreferredSize(new java.awt.Dimension(1280, 500));
        jPanel55.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel56.setBackground(new java.awt.Color(204, 204, 204));
        jPanel56.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel56.add(imageHolder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 120));

        jPanel55.add(jPanel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 140, 120));

        name1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        name1.setText("ID:");
        jPanel55.add(name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 130, 20));

        jLabel138.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel138.setText("GENDER:");
        jPanel55.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 130, 20));

        jLabel139.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel139.setText("Search Patient:");
        jPanel55.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 30));

        jPanel57.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_allergies1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Laboratory"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_allergies1.getTableHeader().setResizingAllowed(false);
        tbl_allergies1.getTableHeader().setReorderingAllowed(false);
        tbl_allergies1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbl_allergies1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane51.setViewportView(tbl_allergies1);

        jPanel57.add(jScrollPane51, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 240));

        jPanel55.add(jPanel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 240, 240));

        jPanel58.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_clinical1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_clinical1.getTableHeader().setResizingAllowed(false);
        tbl_clinical1.getTableHeader().setReorderingAllowed(false);
        tbl_clinical1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbl_clinical1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane52.setViewportView(tbl_clinical1);
        if (tbl_clinical1.getColumnModel().getColumnCount() > 0) {
            tbl_clinical1.getColumnModel().getColumn(0).setResizable(false);
            tbl_clinical1.getColumnModel().getColumn(1).setResizable(false);
            tbl_clinical1.getColumnModel().getColumn(2).setResizable(false);
            tbl_clinical1.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel58.add(jScrollPane52, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 220));

        jPanel55.add(jPanel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 240, 220));

        jPanel59.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_consultation3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_consultation3.getTableHeader().setResizingAllowed(false);
        tbl_consultation3.getTableHeader().setReorderingAllowed(false);
        tbl_consultation3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbl_consultation3AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane53.setViewportView(tbl_consultation3);

        jPanel59.add(jScrollPane53, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 240, 70));

        tbl_consultation4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_consultation4.getTableHeader().setResizingAllowed(false);
        tbl_consultation4.getTableHeader().setReorderingAllowed(false);
        tbl_consultation4.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbl_consultation4AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane54.setViewportView(tbl_consultation4);

        jPanel59.add(jScrollPane54, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 80));

        tbl_consultation5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_consultation5.getTableHeader().setResizingAllowed(false);
        tbl_consultation5.getTableHeader().setReorderingAllowed(false);
        tbl_consultation5.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbl_consultation5AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane55.setViewportView(tbl_consultation5);

        jPanel59.add(jScrollPane55, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 240, 70));

        jPanel55.add(jPanel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 240, -1));

        jPanel60.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_allergy1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Surgery"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_allergy1.getTableHeader().setResizingAllowed(false);
        tbl_allergy1.getTableHeader().setReorderingAllowed(false);
        tbl_allergy1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbl_allergy1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane56.setViewportView(tbl_allergy1);

        jPanel60.add(jScrollPane56, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 240));

        jPanel55.add(jPanel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 240, 240));

        jPanel61.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_treatment1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Bed and Linen Request"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_treatment1.getTableHeader().setResizingAllowed(false);
        tbl_treatment1.getTableHeader().setReorderingAllowed(false);
        tbl_treatment1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbl_treatment1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane57.setViewportView(tbl_treatment1);

        jPanel61.add(jScrollPane57, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 240));

        jPanel55.add(jPanel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 300, 240, 240));

        jPanel62.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_diagnosis1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_diagnosis1.getTableHeader().setResizingAllowed(false);
        tbl_diagnosis1.getTableHeader().setReorderingAllowed(false);
        tbl_diagnosis1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbl_diagnosis1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane58.setViewportView(tbl_diagnosis1);

        jPanel62.add(jScrollPane58, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 220));

        jPanel55.add(jPanel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 240, 220));

        jPanel63.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_surgeries1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_surgeries1.getTableHeader().setResizingAllowed(false);
        tbl_surgeries1.getTableHeader().setReorderingAllowed(false);
        tbl_surgeries1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbl_surgeries1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane59.setViewportView(tbl_surgeries1);

        jPanel63.add(jScrollPane59, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 220));

        jPanel55.add(jPanel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 50, 240, 220));

        jPanel64.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_medication1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Medicine"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_medication1.getTableHeader().setResizingAllowed(false);
        tbl_medication1.getTableHeader().setReorderingAllowed(false);
        tbl_medication1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbl_medication1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane60.setViewportView(tbl_medication1);

        jPanel64.add(jScrollPane60, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 240));

        jPanel55.add(jPanel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 300, 240, 240));

        DrugPrescription1.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        DrugPrescription1.setForeground(new java.awt.Color(51, 153, 255));
        DrugPrescription1.setText("Add Medicine");
        DrugPrescription1.setBorderPainted(false);
        DrugPrescription1.setContentAreaFilled(false);
        DrugPrescription1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DrugPrescription1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DrugPrescription1ActionPerformed(evt);
            }
        });
        jPanel55.add(DrugPrescription1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 540, 110, -1));

        Diagnosis1.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Diagnosis1.setForeground(new java.awt.Color(51, 153, 255));
        Diagnosis1.setText("Add Diagnosis");
        Diagnosis1.setBorderPainted(false);
        Diagnosis1.setContentAreaFilled(false);
        Diagnosis1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Diagnosis1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Diagnosis1ActionPerformed(evt);
            }
        });
        jPanel55.add(Diagnosis1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 110, -1));

        Consultation9.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Consultation9.setForeground(new java.awt.Color(51, 153, 255));
        Consultation9.setText("Add Consultation");
        Consultation9.setBorderPainted(false);
        Consultation9.setContentAreaFilled(false);
        Consultation9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Consultation9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Consultation9ActionPerformed(evt);
            }
        });
        jPanel55.add(Consultation9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 130, -1));

        ClinicalFinding1.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        ClinicalFinding1.setForeground(new java.awt.Color(51, 153, 255));
        ClinicalFinding1.setText("Add Clinical Finding");
        ClinicalFinding1.setBorderPainted(false);
        ClinicalFinding1.setContentAreaFilled(false);
        ClinicalFinding1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ClinicalFinding1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClinicalFinding1ActionPerformed(evt);
            }
        });
        jPanel55.add(ClinicalFinding1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 270, 140, -1));

        Allergy2.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Allergy2.setForeground(new java.awt.Color(51, 153, 255));
        Allergy2.setText("AddLaboratory");
        Allergy2.setBorderPainted(false);
        Allergy2.setContentAreaFilled(false);
        Allergy2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Allergy2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Allergy2ActionPerformed(evt);
            }
        });
        jPanel55.add(Allergy2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 540, 110, -1));

        Surgery1.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Surgery1.setForeground(new java.awt.Color(51, 153, 255));
        Surgery1.setText("Add Surgery");
        Surgery1.setBorderPainted(false);
        Surgery1.setContentAreaFilled(false);
        Surgery1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Surgery1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Surgery1ActionPerformed(evt);
            }
        });
        jPanel55.add(Surgery1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 540, 100, -1));

        Treatment1.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Treatment1.setForeground(new java.awt.Color(51, 153, 255));
        Treatment1.setText("Bed and Linen Req.");
        Treatment1.setBorderPainted(false);
        Treatment1.setContentAreaFilled(false);
        Treatment1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Treatment1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Treatment1ActionPerformed(evt);
            }
        });
        jPanel55.add(Treatment1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 540, 130, -1));

        Allergy3.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Allergy3.setForeground(new java.awt.Color(51, 153, 255));
        Allergy3.setText("Add Allergy");
        Allergy3.setBorderPainted(false);
        Allergy3.setContentAreaFilled(false);
        Allergy3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Allergy3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Allergy3ActionPerformed(evt);
            }
        });
        jPanel55.add(Allergy3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 270, 100, -1));

        search28.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search28ActionPerformed(evt);
            }
        });
        search28.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search28KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search28KeyReleased(evt);
            }
        });
        jPanel55.add(search28, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 250, 30));

        jLabel140.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel140.setText("NAME:");
        jPanel55.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 130, 20));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/search.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel55.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 30, 30));

        date_dayv3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        date_dayv3.setText("date");
        jPanel55.add(date_dayv3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 80, 30));

        Consultation10.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Consultation10.setForeground(new java.awt.Color(51, 153, 255));
        Consultation10.setText("View/Edit");
        Consultation10.setToolTipText("View/Edit Dianosis");
        Consultation10.setBorderPainted(false);
        Consultation10.setContentAreaFilled(false);
        Consultation10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Consultation10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Consultation10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Consultation10ActionPerformed(evt);
            }
        });
        jPanel55.add(Consultation10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 90, -1));

        Consultation11.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Consultation11.setForeground(new java.awt.Color(51, 153, 255));
        Consultation11.setText("View/Edit");
        Consultation11.setToolTipText("View/Edit Clinical Findings");
        Consultation11.setBorderPainted(false);
        Consultation11.setContentAreaFilled(false);
        Consultation11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Consultation11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Consultation11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Consultation11ActionPerformed(evt);
            }
        });
        jPanel55.add(Consultation11, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, 90, -1));

        Consultation12.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Consultation12.setForeground(new java.awt.Color(51, 153, 255));
        Consultation12.setText("View/Edit");
        Consultation12.setToolTipText("View/Edit Allergy");
        Consultation12.setBorderPainted(false);
        Consultation12.setContentAreaFilled(false);
        Consultation12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Consultation12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Consultation12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Consultation12ActionPerformed(evt);
            }
        });
        jPanel55.add(Consultation12, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 270, 90, -1));

        Consultation13.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Consultation13.setForeground(new java.awt.Color(51, 153, 255));
        Consultation13.setText("View/Edit");
        Consultation13.setToolTipText("View/Edit Consultation");
        Consultation13.setBorderPainted(false);
        Consultation13.setContentAreaFilled(false);
        Consultation13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Consultation13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Consultation13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Consultation13ActionPerformed(evt);
            }
        });
        jPanel55.add(Consultation13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 90, -1));

        Consultation14.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Consultation14.setForeground(new java.awt.Color(51, 153, 255));
        Consultation14.setText("View/Edit");
        Consultation14.setToolTipText("View/Edit Laboratory");
        Consultation14.setBorderPainted(false);
        Consultation14.setContentAreaFilled(false);
        Consultation14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Consultation14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Consultation14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Consultation14ActionPerformed(evt);
            }
        });
        jPanel55.add(Consultation14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 540, 90, -1));

        Consultation15.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Consultation15.setForeground(new java.awt.Color(51, 153, 255));
        Consultation15.setText("View/Edit");
        Consultation15.setToolTipText("View/Edit Surgery");
        Consultation15.setBorderPainted(false);
        Consultation15.setContentAreaFilled(false);
        Consultation15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Consultation15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Consultation15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Consultation15ActionPerformed(evt);
            }
        });
        jPanel55.add(Consultation15, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 540, 90, -1));

        Consultation16.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Consultation16.setForeground(new java.awt.Color(51, 153, 255));
        Consultation16.setText("View/Edit");
        Consultation16.setToolTipText("View/Edit Bed&Linen");
        Consultation16.setBorderPainted(false);
        Consultation16.setContentAreaFilled(false);
        Consultation16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Consultation16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Consultation16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Consultation16ActionPerformed(evt);
            }
        });
        jPanel55.add(Consultation16, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 540, 90, -1));

        Consultation17.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Consultation17.setForeground(new java.awt.Color(51, 153, 255));
        Consultation17.setText("View/Edit");
        Consultation17.setToolTipText("View/Edit Medicine");
        Consultation17.setBorderPainted(false);
        Consultation17.setContentAreaFilled(false);
        Consultation17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Consultation17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Consultation17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Consultation17ActionPerformed(evt);
            }
        });
        jPanel55.add(Consultation17, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 540, 90, -1));

        NAME1.setEditable(false);
        jPanel55.add(NAME1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 140, -1));

        ID1.setEditable(false);
        jPanel55.add(ID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 140, -1));

        GENDER1.setEditable(false);
        jPanel55.add(GENDER1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 140, -1));

        jPanel54.add(jPanel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 580));

        add(jPanel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void ConsultationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultationActionPerformed
        int h = showConfirmDialog(null, "Do you want to Add a Consultation?", "Add Consultation", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            AddConsultation.setVisible(true);
            AddConsultation.setSize(581, 626);
            AddConsultation.setLocationRelativeTo(null);
        }
        if (h == 1) {

        }// TODO add your handling code here:
    }//GEN-LAST:event_ConsultationActionPerformed

    private void DiagnosisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiagnosisActionPerformed
        int h = showConfirmDialog(null, "Are you sure you want to Add Diagnosis ?", "Add Diagnosis", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            AddDiagnosis1.setVisible(true);
            AddDiagnosis1.setSize(719, 551);
            AddDiagnosis1.setLocationRelativeTo(null);
        }
        if (h == 1) {

        }

    }//GEN-LAST:event_DiagnosisActionPerformed

    private void ClinicalFindingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClinicalFindingActionPerformed

        int h = showConfirmDialog(null, "Are you sure you want to Add Clinical Findings?", "Add Clinical Findings", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            AddClinicalFinding1.setVisible(true);
            AddClinicalFinding1.setSize(720, 505);
            AddClinicalFinding1.setLocationRelativeTo(null);
        }
        if (h == 1) {

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_ClinicalFindingActionPerformed

    private void AllergyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllergyActionPerformed
        int h = showConfirmDialog(null, "Do you want to Add Laboratory?", "Add Laboratory", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            AddLaboratory.setVisible(true);
            AddLaboratory.setSize(891, 630);
            AddLaboratory.setLocationRelativeTo(null);
        }
        if (h == 1) {

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_AllergyActionPerformed

    private void SurgeryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SurgeryActionPerformed
        int h = showConfirmDialog(null, "Do you want to add Surgery?", "Add Surgery", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            AddSurgery.setVisible(true);
            AddSurgery.setSize(641, 482);
            AddSurgery.setLocationRelativeTo(null);
        }
        if (h == 1) {

        }

// TODO add your handling code here:
    }//GEN-LAST:event_SurgeryActionPerformed

    private void TreatmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TreatmentActionPerformed
        int h = showConfirmDialog(null, "Do you want to add Linen?", " Linen Request", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            AddBedandLinen.setVisible(true);
            AddBedandLinen.setSize(1141, 630);
            AddBedandLinen.setLocationRelativeTo(null);
        }
        if (h == 1) {

        }
    }//GEN-LAST:event_TreatmentActionPerformed

    private void DrugPrescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DrugPrescriptionActionPerformed

        int h = showConfirmDialog(null, "Are you sure you want to Add Medicine?", "Add Medicine", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            AddMedicine.setVisible(true);
            AddMedicine.setSize(961, 625);
            AddMedicine.setLocationRelativeTo(null);
        }
        if (h == 1) {

        }              // TODO add your handling code here:
    }//GEN-LAST:event_DrugPrescriptionActionPerformed

    private void tbl_consultationAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_consultationAncestorAdded
        JTableHeader Theader = tbl_consultation.getTableHeader();

        Theader.setBackground(Color.WHITE);

        Theader.setFont(new Font("Arial", Font.BOLD, 11));

//        
//consultation();
        tbl_consultation.setShowGrid(false);
        tbl_consultation.setShowVerticalLines(false);
        tbl_consultation.setShowHorizontalLines(false);        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_consultationAncestorAdded

    private void tbl_diagnosisAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_diagnosisAncestorAdded

        JTableHeader Theader = tbl_diagnosis.getTableHeader();

        Theader.setBackground(Color.WHITE);

        Theader.setFont(new Font("Arial", Font.BOLD, 11));

        Diagnosis();
        tbl_diagnosis.setShowGrid(false);
        tbl_diagnosis.setShowVerticalLines(false);
        tbl_diagnosis.setShowHorizontalLines(false);        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_diagnosisAncestorAdded

    private void tbl_clinicalAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_clinicalAncestorAdded
        Clinical();
        JTableHeader Theader = tbl_clinical.getTableHeader();

        Theader.setBackground(Color.WHITE);

        Theader.setFont(new Font("Arial", Font.BOLD, 11));

//clinical();
        tbl_clinical.setShowGrid(false);
        tbl_clinical.setShowVerticalLines(false);
        tbl_clinical.setShowHorizontalLines(false);        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_clinicalAncestorAdded

    private void tbl_allergyAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_allergyAncestorAdded
        addllergy();
        JTableHeader Theader = tbl_allergy.getTableHeader();

        Theader.setBackground(Color.WHITE);

        Theader.setFont(new Font("Arial", Font.BOLD, 11));

//paraclinical();
        tbl_allergy.setShowGrid(false);
        tbl_allergy.setShowVerticalLines(false);
        tbl_allergy.setShowHorizontalLines(false);        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_allergyAncestorAdded

    private void tbl_medicationAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_medicationAncestorAdded
        JTableHeader Theader = tbl_medication.getTableHeader();

        Theader.setBackground(Color.WHITE);

        Theader.setFont(new Font("Arial", Font.BOLD, 11));

//medication();
        tbl_medication.setShowGrid(false);
        tbl_medication.setShowVerticalLines(false);
        tbl_medication.setShowHorizontalLines(false);        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_medicationAncestorAdded

    private void tbl_treatmentAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_treatmentAncestorAdded
        JTableHeader Theader = tbl_treatment.getTableHeader();

        Theader.setBackground(Color.WHITE);

        Theader.setFont(new Font("Arial", Font.BOLD, 11));

//        
//treatments();
        tbl_treatment.setShowGrid(false);
        tbl_treatment.setShowVerticalLines(false);
        tbl_treatment.setShowHorizontalLines(false);        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_treatmentAncestorAdded

    private void tbl_surgeriesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_surgeriesAncestorAdded
        addllergy();
        JTableHeader Theader = tbl_surgeries.getTableHeader();

        Theader.setBackground(Color.WHITE);

        Theader.setFont(new Font("Arial", Font.BOLD, 11));

//surgeries();
        tbl_surgeries.setShowGrid(false);
        tbl_surgeries.setShowVerticalLines(false);
        tbl_surgeries.setShowHorizontalLines(false);        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_surgeriesAncestorAdded

    private void tbl_allergiesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_allergiesAncestorAdded
        JTableHeader Theader = tbl_allergies.getTableHeader();

        Theader.setBackground(Color.WHITE);

        Theader.setFont(new Font("Arial", Font.BOLD, 11));

//allergies();
        tbl_allergies.setShowGrid(false);
        tbl_allergies.setShowVerticalLines(false);
        tbl_allergies.setShowHorizontalLines(false);        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_allergiesAncestorAdded

    private void Allergy1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Allergy1ActionPerformed

        int h = showConfirmDialog(null, "Are you sure you want to Add Allergy?", "Add Allergy", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            AddAllergy1.setVisible(true);
            AddAllergy1.setSize(641, 412);
            AddAllergy1.setLocationRelativeTo(null);
        }
        if (h == 1) {

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_Allergy1ActionPerformed

    private void paraclinicalfindingAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_paraclinicalfindingAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_paraclinicalfindingAncestorAdded

    private void sub_module_1_btn3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn3MouseClicked

    private void sub_module_1_btn3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn3MouseEntered

    private void sub_module_1_btn3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn3MouseExited

    private void sub_module_1_btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sub_module_1_btn3ActionPerformed
        int h = showConfirmDialog(null, "Are you sure you want to Save Clinial Findings?", "Save Findings", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            try {

                String sql = "insert into Core1_ipd_AddClinicalFindings(Doctor_ID,Patient_ID,Title,Note,Date,Status)values(?,?,?,?,?,?);";

                pst = conn.prepareStatement(sql);

                pst.setString(1, AddAllergyDRID.getText());
                pst.setString(2, NAME.getText());
                pst.setString(3, title.getText());
                pst.setString(4, jTextArea2.getText());
                pst.setString(5, date_dayv2.getText());
                pst.setString(6, "Active");

                pst.execute();
                jTextArea2.setText("");
                title.setText("");
                AddAllergyDRID.setText("");
                search4.setText("");
                AddClinicalFinding1.setVisible(false);
                JOptionPane.showMessageDialog(null, "Saved");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        if (h == 1) {

        }
        Clinical();
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn3ActionPerformed

    private void clinicalfindingAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_clinicalfindingAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_clinicalfindingAncestorAdded

    private void sub_module_1_btn7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn7MouseClicked

    private void sub_module_1_btn7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn7MouseEntered

    private void sub_module_1_btn7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn7MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn7MouseExited

    private void sub_module_1_btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sub_module_1_btn7ActionPerformed
        int h = showConfirmDialog(null, "Are you sure you want to Save Allergy?", "Save Allergy", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            try {

                String sql = "insert into Core1_ipd_AddAllergy(Doctor_ID,Patient_ID,Title,Note,Date,Status)values(?,?,?,?,?,?);";

                pst = conn.prepareStatement(sql);
                pst.setString(1, search5.getText());
                pst.setString(2, NAME.getText());
                pst.setString(3, title1.getText());
                pst.setString(4, jTextArea5.getText());
                pst.setString(5, date_dayv2.getText());
                pst.setString(6, "Active");

                pst.execute();
                jTextArea5.setText("");
                search5.setText("");
                title1.setText("");
                AddAllergy1.setVisible(false);

                JOptionPane.showMessageDialog(null, "Saved");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        if (h == 1) {

        }

        addllergy();

// TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn7ActionPerformed

    private void allergy1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_allergy1AncestorAdded

        allergy1.setSize(639, 322);
        // TODO add your handling code here:
    }//GEN-LAST:event_allergy1AncestorAdded

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {

            String sql = "select * from Core1_pr_PatientRegistration where Patient_ID=?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, search.getText());
            rs = pst.executeQuery();

            if (rs.next()) {

                try {
                    String sql1 = "select Patient_ID,PR_Gender,concat (Lastname,', ',FirstName) as Name, image from Core1_pr_PatientRegistration where Patient_ID =?";
                    pst = conn.prepareStatement(sql1);
                    pst.setString(1, search.getText());
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String add1 = rs.getString("Name");
                        ID.setText(add1);
                        String add2 = rs.getString("PR_Gender");
                        GENDER.setText(add2);
                        String add3 = rs.getString("Patient_ID");
                        NAME.setText(add3);
                        byte[] img2 = rs.getBytes("image");
                        ImageIcon img3 = new ImageIcon(img2);
                        Image img = img3.getImage();
                        Image newImg = img.getScaledInstance(imageHolder.getWidth(), imageHolder.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon newImc = new ImageIcon(newImg);
                        imageHolder.setIcon(newImc);

                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            } else {
//                JOptionPane.showMessageDialog(null, "Not a Patient", "Search Patient", JOptionPane.ERROR_MESSAGE);
                DesktopNotify.showDesktopMessage("Wrong Patient No.", "Right Patient",
                        DesktopNotify.FAIL, 8000);

            }

        } catch (Exception e) {
            DesktopNotify.showDesktopMessage("Wrong Patient No.", "Right Patient",
                    DesktopNotify.FAIL, 8000);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        int h = showConfirmDialog(null, "Do you want to Close Clinical Findings?", "Clinical Findings", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            AddClinicalFinding1.setVisible(false);
            jTextArea2.setText("");
            title.setText("");
            AddAllergyDRID.setText("");
            search4.setText("");
        }
        if (h == 1) {

        }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        int h = showConfirmDialog(null, "Do you want to Close Add Allergy?", "Add Allergy", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            AddAllergy1.setVisible(false);
            jTextArea5.setText("");
            search5.setText("");
            title1.setText("");
        }
        if (h == 1) {

        }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked

    private void diagnosis1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_diagnosis1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_diagnosis1AncestorAdded

    private void qqqqAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_qqqqAncestorAdded
        qqqq();         // TODO add your handling code here:
    }//GEN-LAST:event_qqqqAncestorAdded

    private void qqqqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qqqqMouseClicked
        int h = showConfirmDialog(null, "Do you want to Insert this Question?", "Insert Question", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            int row = qqqq.getSelectedRow();
            String Table_click = (qqqq.getModel().getValueAt(row, 0).toString());
            try {
                String sql = "SELECT * from Core1_ipd_q where Title='" + Table_click + "'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {

                    String add1 = rs.getString("Note");
                    insert.setText(add1);

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            Q.setVisible(false);
        }
        if (h == 1) {

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_qqqqMouseClicked

    private void AddAllergyDRIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddAllergyDRIDMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_AddAllergyDRIDMouseClicked

    private void AddAllergyDRIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddAllergyDRIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddAllergyDRIDActionPerformed

    private void AddAllergyDRIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddAllergyDRIDKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {

                String sql = "select * from Core1_dra_registered where Dr_ID=?";

                pst = conn.prepareStatement(sql);
                pst.setString(1, AddAllergyDRID.getText());
                rs = pst.executeQuery();

                if (rs.next()) {
                    try {
                        String sql1 = "select concat (surname,', ',name,' ',middlename,'   -   ',specialization) as Name from Core1_dra_registered where Dr_ID=?";
                        pst = conn.prepareStatement(sql1);
                        pst.setString(1, AddAllergyDRID.getText());
                        rs = pst.executeQuery();
                        if (rs.next()) {
                            String add1 = rs.getString("Name");
                            search4.setText(add1);

                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Not a Doctor", "Search Doctor", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }        // TODO add your handling code here:

        // TODO add your handling code here:
    }//GEN-LAST:event_AddAllergyDRIDKeyPressed

    private void AddAllergyDRIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddAllergyDRIDKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_AddAllergyDRIDKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        try {

            String sql = "select * from Core1_dra_registered where Dr_ID=?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, AddAllergyDRID.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                try {
                    String sql1 = "select concat (surname,', ',name,' ',middlename,'   -   ',specialization) as Name from Core1_dra_registered where Dr_ID=?";
                    pst = conn.prepareStatement(sql1);
                    pst.setString(1, AddAllergyDRID.getText());
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String add1 = rs.getString("Name");
                        search4.setText(add1);

                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Not a Doctor", "Search Doctor", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void search4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search4ActionPerformed

    private void search4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_search4KeyPressed

    private void search4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search4KeyReleased

    private void search5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_search5MouseClicked

    private void search5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search5ActionPerformed

    private void search5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search5KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {

                String sql = "select * from Core1_dra_registered where Dr_ID=?";

                pst = conn.prepareStatement(sql);
                pst.setString(1, search5.getText());
                rs = pst.executeQuery();

                if (rs.next()) {
                    try {
                        String sql1 = "select concat (surname,', ',name,' ',middlename,'   -   ',specialization) as Name from Core1_dra_registered where Dr_ID=?";
                        pst = conn.prepareStatement(sql1);
                        pst.setString(1, search5.getText());
                        rs = pst.executeQuery();
                        if (rs.next()) {
                            String add1 = rs.getString("Name");
                            search6.setText(add1);

                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Not a Doctor", "Search Doctor", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_search5KeyPressed

    private void search5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search5KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search5KeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        try {

            String sql = "select * from Core1_dra_registered where Dr_ID=?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, search5.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                try {
                    String sql1 = "select concat (surname,', ',name,' ',middlename,'   -   ',specialization) as Name from Core1_dra_registered where Dr_ID=?";
                    pst = conn.prepareStatement(sql1);
                    pst.setString(1, search5.getText());
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String add1 = rs.getString("Name");
                        search6.setText(add1);

                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Not a Doctor", "Search Doctor", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void search6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search6ActionPerformed

    private void search6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search6KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_search6KeyPressed

    private void search6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search6KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search6KeyReleased

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        int h = showConfirmDialog(null, "Do you want to Close Add Consultation?", "Add Consultation", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            AddConsultation.setVisible(false);
        }
        if (h == 1) {

        }         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void search3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_search3MouseClicked

    private void search3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search3ActionPerformed

    private void search3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search3KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {

                String sql = "select * from Core1_dra_registered where Dr_ID=?";

                pst = conn.prepareStatement(sql);
                pst.setString(1, search3.getText());
                rs = pst.executeQuery();

                if (rs.next()) {
                    try {
                        String sql1 = "select concat (surname,', ',name,' ',middlename,'   -   ',specialization) as Name from Core1_dra_registered where Dr_ID=?";
                        pst = conn.prepareStatement(sql1);
                        pst.setString(1, search3.getText());
                        rs = pst.executeQuery();
                        if (rs.next()) {
                            String add1 = rs.getString("Name");
                            search7.setText(add1);

                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Not a Doctor", "Search Doctor", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }// TODO add your handling code here:
    }//GEN-LAST:event_search3KeyPressed

    private void search3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search3KeyReleased

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {

            String sql = "select * from Core1_dra_registered where Dr_ID=?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, search3.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                try {
                    String sql1 = "select concat (surname,', ',name,' ',middlename,'   -   ',specialization) as Name from Core1_dra_registered where Dr_ID=?";
                    pst = conn.prepareStatement(sql1);
                    pst.setString(1, search3.getText());
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String add1 = rs.getString("Name");
                        search7.setText(add1);

                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Not a Doctor", "Search Doctor", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void search7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search7ActionPerformed

    private void search7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search7KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_search7KeyPressed

    private void search7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search7KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search7KeyReleased

    private void treatmentAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_treatmentAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_treatmentAncestorAdded

    private void sub_module_1_btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sub_module_1_btn9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn9ActionPerformed

    private void sub_module_1_btn9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn9MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn9MouseExited

    private void sub_module_1_btn9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn9MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn9MouseEntered

    private void sub_module_1_btn9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn9MouseClicked

    private void sub_module_1_btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sub_module_1_btn8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn8ActionPerformed

    private void sub_module_1_btn8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn8MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn8MouseExited

    private void sub_module_1_btn8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn8MouseEntered

    private void sub_module_1_btn8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn8MouseClicked

    private void sub_module_1_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sub_module_1_btn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn2ActionPerformed

    private void sub_module_1_btn2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn2MouseExited

    private void sub_module_1_btn2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn2MouseEntered

    private void sub_module_1_btn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn2MouseClicked

    private void sub_module_1_btn4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn4MouseClicked

    private void sub_module_1_btn4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn4MouseEntered

    private void sub_module_1_btn4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn4MouseExited

    private void sub_module_1_btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sub_module_1_btn4ActionPerformed
        int h = showConfirmDialog(null, "Are you sure you want to Save Consultation?", "Add Consultation", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            try {

                String sql = "insert into Core1_ipd_PE(Patient_ID,Dr_id,General,Head,Eyes,Ears,Nose,MaT,Neck,Breast,Gastrointestinal,Genitourinary,Neurologic,Phschiatric,date)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                pst = conn.prepareStatement(sql);
                pst.setString(1, NAME.getText());
                pst.setString(2, search3.getText());
                pst.setString(3, qq.getText());
                pst.setString(4, ww.getText());
                pst.setString(5, ee.getText());
                pst.setString(6, rr.getText());
                pst.setString(7, tt.getText());
                pst.setString(8, yy.getText());
                pst.setString(9, uu.getText());
                pst.setString(10, ii.getText());
                pst.setString(11, oo.getText());
                pst.setString(12, pp.getText());
                pst.setString(13, aa.getText());
                pst.setString(14, ss.getText());
                pst.setString(15, date_dayv2.getText());

                pst.execute();

                AddConsultation.setVisible(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            try {

                String sql = "insert into Core1_ipd_ROS(Patient_ID,Dr_id,General,Eyes,Neurological,Endocrine,Cardiovascular,Respiratory,Musculoskeletal,Gastrointestinal,date)values(?,?,?,?,?,?,?,?,?,?,?)";

                pst = conn.prepareStatement(sql);
                pst.setString(1, NAME.getText());
                pst.setString(2, search3.getText());
                pst.setString(3, q.getText());
                pst.setString(4, w.getText());
                pst.setString(5, e.getText());
                pst.setString(6, r.getText());
                pst.setString(7, t.getText());
                pst.setString(8, u.getText());
                pst.setString(9, i.getText());
                pst.setString(10, o.getText());
                pst.setString(11, date_dayv2.getText());
                pst.execute();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            try {
                // vital signs insert
                String bp = jTextField11.getText() + jLabel32.getText() + jTextField12.getText();
                String bt = jTextField17.getText() + jLabel34.getText();
                String a = jTextField20.getText() + " " + jLabel38.getText();
                String m = jTextField18.getText() + " " + jLabel35.getText();

                String query = "insert into Core1_ipd_vitals (Patient, Doctor, bp, temp, height, weight,date)values(?,?,?,?,?,?,?)";

                pst = conn.prepareStatement(query);

                pst.setString(1, NAME.getText());
                pst.setString(2, search3.getText());
                pst.setString(3, bp);
                pst.setString(4, bt);
                pst.setString(5, a);
                pst.setString(6, m);
                pst.setString(7, date_dayv2.getText());

                pst.execute();

                //    pst.setString(10, "Scheduled");
                q.setText("");
                w.setText("");
                e.setText("");
                r.setText("");
                t.setText("");
                u.setText("");
                i.setText("");
                o.setText("");
                qq.setText("");
                search3.setText("");
                ww.setText("");
                ee.setText("");
                rr.setText("");
                tt.setText("");
                yy.setText("");
                uu.setText("");
                ii.setText("");
                oo.setText("");
                pp.setText("");
                aa.setText("");
                ss.setText("");

                AddConsultation.setVisible(false);
                JOptionPane.showMessageDialog(null, "Saved");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }
        if (h == 1) {

        }

        PE();
        Ros();
        Vitals();

    }//GEN-LAST:event_sub_module_1_btn4ActionPerformed

    private void ssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ssActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ssActionPerformed

    private void txt_dayKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dayKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dayKeyTyped

    private void txt_dayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dayKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dayKeyReleased

    private void jTextField20KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField20KeyTyped
        // accept number only
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20KeyTyped

    private void jTextField20KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField20KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20KeyReleased

    private void jTextField18KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField18KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18KeyTyped

    private void jTextField18KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField18KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18KeyReleased

    private void jTextField17KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField17KeyTyped
        // accept number only
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17KeyTyped

    private void jTextField17KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField17KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17KeyReleased

    private void jTextField12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyTyped
        // accept number only
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12KeyTyped

    private void jTextField12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12KeyReleased

    private void jTextField11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyTyped
        // accept number only
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11KeyTyped

    private void jTextField11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11KeyReleased

    private void tbl_consultation1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_consultation1AncestorAdded
        JTableHeader Theader = tbl_consultation1.getTableHeader();

        Theader.setBackground(Color.WHITE);

        Theader.setFont(new Font("Arial", Font.BOLD, 11));

//        
//consultation();
        tbl_consultation1.setShowGrid(false);
        tbl_consultation1.setShowVerticalLines(false);
        tbl_consultation1.setShowHorizontalLines(false);         // TODO add your handling code here:
    }//GEN-LAST:event_tbl_consultation1AncestorAdded

    private void tbl_consultation2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_consultation2AncestorAdded
        Vitals();
        JTableHeader Theader = tbl_consultation2.getTableHeader();

        Theader.setBackground(Color.WHITE);

        Theader.setFont(new Font("Arial", Font.BOLD, 11));

//        
//consultation();
        tbl_consultation2.setShowGrid(false);
        tbl_consultation2.setShowVerticalLines(false);
        tbl_consultation2.setShowHorizontalLines(false);         // TODO add your handling code here:
    }//GEN-LAST:event_tbl_consultation2AncestorAdded

    private void eeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eeActionPerformed

    private void jCheckBox46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox46ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox46ActionPerformed

    private void cb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb3ActionPerformed
        //        ((JLabel) cb3.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
    }//GEN-LAST:event_cb3ActionPerformed

    private void cb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb2ActionPerformed
        //        ((JLabel) cb2.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
    }//GEN-LAST:event_cb2ActionPerformed

    private void cb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb1ActionPerformed
        //        ((JLabel) cb1.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
    }//GEN-LAST:event_cb1ActionPerformed

    private void cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbActionPerformed
        //        ((JLabel) cb.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
    }//GEN-LAST:event_cbActionPerformed

    private void labBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labBtnActionPerformed
        /*
        try {

            String query = "insert into Core2_labmngt_labreq values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            pst = conn.prepareStatement(query);

            pst.setString(1, consult_id.getText());
            pst.setString(2, NAME.getText());
            pst.setString(3, find_patAge.getText());
            pst.setString(4, find_patGender.getText());
            pst.setString(5, find_patNo.getText());
            pst.setString(6, find_patSick.getText());
            pst.setString(7, find_patDr.getText());
            pst.setString(8, dd.getText());
            String hema = "";
            if (jCheckBox1.isSelected()) {
                hema += jCheckBox1.getText() + ", ";
            }
            if (jCheckBox2.isSelected()) {
                hema += jCheckBox2.getText() + ", ";
            }
            if (jCheckBox3.isSelected()) {
                hema += jCheckBox3.getText() + ", ";
            }
            if (jCheckBox4.isSelected()) {
                hema += jCheckBox4.getText() + ", ";
            }
            if (jCheckBox5.isSelected()) {
                hema += jCheckBox5.getText() + ", ";
            }
            if (jCheckBox6.isSelected()) {
                hema += jCheckBox6.getText() + ", ";
            }
            if (jCheckBox7.isSelected()) {
                hema += jCheckBox7.getText() + ", ";
            }
            if (jCheckBox8.isSelected()) {
                hema += jCheckBox8.getText() + ", ";
            }
            if (jCheckBox9.isSelected()) {
                hema += jCheckBox9.getText() + ", ";
            }
            if (jCheckBox18.isSelected()) {
                hema += jCheckBox18.getText() + ", ";
            }
            pst.setString(9, hema);

            String bloodChem = "";
            if (jCheckBox10.isSelected()) {
                bloodChem += jCheckBox10.getText() + " ";
            }
            if (jCheckBox11.isSelected()) {
                bloodChem += jCheckBox11.getText() + ", ";
            }
            if (jCheckBox12.isSelected()) {
                bloodChem += jCheckBox12.getText() + ", ";
            }
            if (jCheckBox14.isSelected()) {
                bloodChem += jCheckBox14.getText() + ", ";
            }
            if (jCheckBox15.isSelected()) {
                bloodChem += jCheckBox15.getText() + ", ";
            }
            if (jCheckBox16.isSelected()) {
                bloodChem += jCheckBox16.getText() + ", ";
            }
            if (jCheckBox17.isSelected()) {
                bloodChem += jCheckBox17.getText() + ", ";
            }
            if (jCheckBox19.isSelected()) {
                bloodChem += jCheckBox19.getText() + ", ";
            }
            if (jCheckBox21.isSelected()) {
                bloodChem += jCheckBox21.getText() + ", ";
            }

            pst.setString(10, bloodChem);
            String micro = "";
            if (jCheckBox22.isSelected()) {
                micro += jCheckBox22.getText() + " ";
            }
            if (jCheckBox23.isSelected()) {
                micro += jCheckBox23.getText() + ", ";
            }
            if (jCheckBox24.isSelected()) {
                micro += jCheckBox24.getText() + ", ";
            }
            if (jCheckBox25.isSelected()) {
                micro += jCheckBox25.getText() + ", ";
            }
            if (jCheckBox26.isSelected()) {
                micro += jCheckBox26.getText() + ", ";
            }
            if (jCheckBox27.isSelected()) {
                micro += jCheckBox27.getText() + ", ";
            }
            if (jCheckBox28.isSelected()) {
                micro += jCheckBox28.getText() + ", " + "LMP:" + ((JTextField) LMP.getDateEditor().getUiComponent()).getText() + ", ";
            }
            if (jCheckBox31.isSelected()) {
                micro += jCheckBox31.getText() + ", ";
            }
            pst.setString(11, micro);

            String electro = "";
            if (jCheckBox13.isSelected()) {
                electro += jCheckBox13.getText() + ", ";
            }
            if (jCheckBox20.isSelected()) {
                electro += jCheckBox20.getText() + ", ";
            }
            if (jCheckBox29.isSelected()) {
                electro += jCheckBox29.getText() + ", ";
            }
            if (jCheckBox30.isSelected()) {
                electro += jCheckBox30.getText() + ", ";
            }
            pst.setString(12, electro);

            String thyroid = "";
            if (jCheckBox37.isSelected()) {
                thyroid += jCheckBox37.getText() + ", ";
            }
            if (jCheckBox38.isSelected()) {
                thyroid += jCheckBox38.getText() + ", ";
            }
            if (jCheckBox39.isSelected()) {
                thyroid += jCheckBox39.getText() + ", ";
            }

            pst.setString(13, thyroid);

            String serology = "";
            if (jCheckBox41.isSelected()) {
                serology += jCheckBox41.getText() + ", ";
            }
            if (jCheckBox42.isSelected()) {
                serology += jCheckBox42.getText() + ", ";
            }
            if (jCheckBox43.isSelected()) {
                serology += jCheckBox43.getText() + ", ";
            }
            pst.setString(14, serology);

            String radiology = "";
            if (jCheckBox32.isSelected()) {
                radiology += jCheckBox32.getText() + ", ";
            }
            if (jCheckBox33.isSelected()) {
                radiology += jCheckBox33.getText() + ", " + "Reason:" + cb.getSelectedItem().toString() + ", ";
            }
            if (jCheckBox34.isSelected()) {
                radiology += jCheckBox34.getText() + ", " + "Reason:" + cb1.getSelectedItem().toString() + ", ";
            }
            if (jCheckBox35.isSelected()) {
                radiology += jCheckBox35.getText() + ", " + "Reason:" + cb2.getSelectedItem().toString() + ", ";
            }
            if (jCheckBox36.isSelected()) {
                radiology += jCheckBox36.getText() + ", ";
            }
            if (jCheckBox40.isSelected()) {
                radiology += jCheckBox40.getText() + ", " + "Protocol:" + cb3.getSelectedItem().toString() + ", ";
            }
            if (jCheckBox46.isSelected()) {
                radiology += jCheckBox46.getText() + ", ";
            }
            pst.setString(15, radiology);
            pst.setString(16, jTextArea1.getText());
            pst.setString(17, "Pending laboratory");

            pst.execute();
            JOptionPane.showMessageDialog(null, "Laboratory successfully Requested");
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, err);
        }*/
    }//GEN-LAST:event_labBtnActionPerformed

    private void jLabel60MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel60MouseClicked
        int h = showConfirmDialog(null, "Do you want to Close Add Laboratory?", "Add Laboratory", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            AddLaboratory.setVisible(false);
        }
        if (h == 1) {

        }         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel60MouseClicked

    private void lname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lname1ActionPerformed

    private void lname1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lname1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_lname1KeyTyped

    private void search10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_search10MouseClicked

    private void search10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search10ActionPerformed

    private void search10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search10KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {

                String sql = "select * from Core1_dra_registered where Dr_ID=?";

                pst = conn.prepareStatement(sql);
                pst.setString(1, search10.getText());
                rs = pst.executeQuery();

                if (rs.next()) {
                    try {
                        String sql1 = "select concat (surname,', ',name,' ',middlename,'   -   ',specialization) as Name from Core1_dra_registered where Dr_ID=?";
                        pst = conn.prepareStatement(sql1);
                        pst.setString(1, search10.getText());
                        rs = pst.executeQuery();
                        if (rs.next()) {
                            String add1 = rs.getString("Name");
                            search11.setText(add1);

                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Not a Doctor", "Search Doctor", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_search10KeyPressed

    private void search10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search10KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search10KeyReleased

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {

            String sql = "select * from Core1_dra_registered where Dr_ID=?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, search10.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                try {
                    String sql1 = "select concat (surname,', ',name,' ',middlename,'   -   ',specialization) as Name from Core1_dra_registered where Dr_ID=?";
                    pst = conn.prepareStatement(sql1);
                    pst.setString(1, search10.getText());
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String add1 = rs.getString("Name");
                        search11.setText(add1);

                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Not a Doctor", "Search Doctor", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void search11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search11ActionPerformed

    private void search11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search11KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_search11KeyPressed

    private void search11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search11KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search11KeyReleased

    private void jLabel61MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel61MouseClicked
        int h = showConfirmDialog(null, "Do you want to Exit", "Exit Consultation", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            one();
            AddConsultationTbl.setVisible(false);
        }
        if (h == 1) {

        }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel61MouseClicked

    private void search8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_search8MouseClicked

    private void search8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search8ActionPerformed

    private void search8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search8KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_search8KeyPressed

    private void search8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search8KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search8KeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int h = showConfirmDialog(null, "Do you want to Edit a Review of Systems?", "Review of Systems", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            if (true_false == false) {

                //ros
                ImageIcon ii = new ImageIcon(getClass().getResource("/Module4SubModules/unlock.png"));
                jButton7.setIcon(ii);
                search8.setEditable(true);
                q1.setEditable(true);
                w1.setEditable(true);
                e1.setEditable(true);
                r1.setEditable(true);
                t1.setEditable(true);
                u1.setEditable(true);
                i1.setEditable(true);
                o1.setEditable(true);
                jButton9.setVisible(false);
                fillAll.setVisible(true);

                //pe
                search17.setEditable(true);
                qq1.setEditable(true);
                ww1.setEditable(true);
                ee1.setEditable(true);
                rr1.setEditable(true);
                tt1.setEditable(true);
                yy1.setEditable(true);
                uu1.setEditable(true);
                ii1.setEditable(true);
                oo1.setEditable(true);
                pp1.setEditable(true);
                aa1.setEditable(true);
                ss1.setEditable(true);
                fillAll1.setVisible(true);

                //vitals
                z.setEditable(true);
                x.setEditable(true);
                c.setEditable(true);
                v.setEditable(true);
                fillAll1.setVisible(true);

            }
            true_false = true;
        } else if (true_false == true) {

            //ros 
            ImageIcon ii = new ImageIcon(getClass().getResource("/Module4SubModules/lock.png"));
            jButton7.setIcon(ii);
            true_false = false;
            one();

        } else {

        }// TODO add your handling code here:

// TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void search9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search9ActionPerformed

    private void search9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search9KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_search9KeyPressed

    private void search9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search9KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search9KeyReleased

    private void paraclinicalfinding1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_paraclinicalfinding1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_paraclinicalfinding1AncestorAdded

    private void jTable1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable1AncestorAdded
        jim1();
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1AncestorAdded

    private void Consultation1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Consultation1ActionPerformed
        int h = showConfirmDialog(null, "Do you want to View/Edit a Diagnosis?", "Diagnosis", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            AddDiagnosisTbl.setVisible(true);
            AddDiagnosisTbl.setSize(1141, 630);
            AddDiagnosisTbl.setLocationRelativeTo(null);
        }
        if (h == 1) {

        }        // TODO add your handling code here:
    }//GEN-LAST:event_Consultation1ActionPerformed

    private void Consultation2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Consultation2ActionPerformed
        int h = showConfirmDialog(null, "Do you want to View/Edit a Clinical Findings?", "Clinical Findings", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            AddClinicalFindingTbl.setVisible(true);
            AddClinicalFindingTbl.setSize(1141, 630);
            AddClinicalFindingTbl.setLocationRelativeTo(null);
        }
        if (h == 1) {

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_Consultation2ActionPerformed

    private void Consultation3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Consultation3ActionPerformed
        int h = showConfirmDialog(null, "Do you want to View/Edit a Clinical Findings?", "Clinical Findings", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            AddAllergyTbl.setVisible(true);
            AddAllergyTbl.setSize(1141, 630);
            AddAllergyTbl.setLocationRelativeTo(null);
        }
        if (h == 1) {

        }        // TODO add your handling code here:
    }//GEN-LAST:event_Consultation3ActionPerformed

    private void Consultation4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Consultation4ActionPerformed
        int h = showConfirmDialog(null, "Do you want to View/Edit a Allergy?", "Allergy", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            AddConsultationTbl.setVisible(true);
            AddConsultationTbl.setSize(1141, 630);
            AddConsultationTbl.setLocationRelativeTo(null);
        }
        if (h == 1) {

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_Consultation4ActionPerformed
    private void Consultation5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Consultation5ActionPerformed
        int h = showConfirmDialog(null, "Do you want to View/Edit a Laboratory?", "Laboratory", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            AddLaboratoryTbl.setVisible(true);
            AddLaboratoryTbl.setSize(1141, 630);
            AddLaboratoryTbl.setLocationRelativeTo(null);
        }
        if (h == 1) {

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_Consultation5ActionPerformed

    private void Consultation6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Consultation6ActionPerformed
        int h = showConfirmDialog(null, "Do you want to View/Edit a Laboratory?", "Laboratory", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            AddSurgeryTbl.setVisible(true);
            AddSurgeryTbl.setSize(1141, 630);
            AddSurgeryTbl.setLocationRelativeTo(null);
        }
        if (h == 1) {

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_Consultation6ActionPerformed

    private void Consultation7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Consultation7ActionPerformed
        int h = showConfirmDialog(null, "Do you want to View/Edit a Bed and Linen?", "Bed and Linen", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            AddBedandLinenTbl.setVisible(true);
            AddBedandLinenTbl.setSize(1141, 630);
            AddBedandLinenTbl.setLocationRelativeTo(null);
        }
        if (h == 1) {

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_Consultation7ActionPerformed

    private void Consultation8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Consultation8ActionPerformed
        int h = showConfirmDialog(null, "Do you want to View/Edit a Medicine?", "Medicine", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            AddMedicineTbl.setVisible(true);
            AddMedicineTbl.setSize(1141, 630);
            AddMedicineTbl.setLocationRelativeTo(null);
        }
        if (h == 1) {

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_Consultation8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void cMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cMouseClicked

    private void cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cActionPerformed

    private void cKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cKeyPressed

    private void cKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cKeyReleased

    private void search16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search16ActionPerformed

    private void search16KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search16KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_search16KeyPressed

    private void search16KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search16KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search16KeyReleased

    private void search17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search17MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_search17MouseClicked

    private void search17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search17ActionPerformed

    private void search17KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search17KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_search17KeyPressed

    private void search17KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search17KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search17KeyReleased

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void fillAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillAllActionPerformed
        int h = showConfirmDialog(null, "Do you want to Update", "Update", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            one();

            AddConsultationTbl.setVisible(false);
            UpdateConsultation.setVisible(true);
            UpdateConsultation.setSize(300, 118);
            UpdateConsultation.setLocationRelativeTo(null);
        }
        if (h == 1) {

        }
    }//GEN-LAST:event_fillAllActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        String Table_click = (jTable1.getModel().getValueAt(row, 0).toString());

        try {
            String sql = "select Core1_dra_registered.Dr_ID,\n"
                    + "concat ('Dr.',Core1_dra_registered.surname,', ',Core1_dra_registered.name,' ',Core1_dra_registered.middlename,'  -  ',Core1_dra_registered.specialization )as 'Doctor',\n"
                    + "Core1_ipd_ROS.General as Title,\n"
                    + "Core1_ipd_ROS.Eyes as q1,\n"
                    + "Core1_ipd_ROS.Neurological as q2,\n"
                    + "Core1_ipd_ROS.Endocrine as q3,\n"
                    + "Core1_ipd_ROS.Cardiovascular as q4,\n"
                    + "Core1_ipd_ROS.Respiratory as q5,\n"
                    + "Core1_ipd_ROS.Musculoskeletal as q6,\n"
                    + "Core1_ipd_ROS.Gastrointestinal as q7\n"
                    + "from Core1_ipd_ROS\n"
                    + "inner join Core1_dra_registered\n"
                    + "on Core1_ipd_ROS.Dr_id=Core1_dra_registered.Dr_ID where Core1_ipd_ROS.Ros='" + Table_click + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {

                String add1 = rs.getString("Dr_ID");
                search8.setText(add1);
                String add2 = rs.getString("Doctor");
                search9.setText(add2);
                String add3 = rs.getString("Title");
                q1.setText(add3);
                String add4 = rs.getString("q1");
                w1.setText(add4);
                String add5 = rs.getString("q2");
                e1.setText(add5);
                String add6 = rs.getString("q3");
                r1.setText(add6);
                String add7 = rs.getString("q4");
                t1.setText(add7);
                String add8 = rs.getString("q5");
                u1.setText(add8);
                String add9 = rs.getString("q6");
                i1.setText(add9);
                String add10 = rs.getString("q7");
                o1.setText(add10);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void cbFilterPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbFilterPopupMenuWillBecomeInvisible

    }//GEN-LAST:event_cbFilterPopupMenuWillBecomeInvisible

    private void cbFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFilterActionPerformed
        ((JLabel) cbFilter.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        if (cbFilter.getSelectedItem().equals("Today")) {
            try {
                String q = " select Core1_bm_rooms.Room_type as 'Room Type',Core1_bm_roomroom.RoomName as 'Room Name',Core1_bm_rooms.Bed_No as Bed,concat(Core1_pr_PatientRegistration.LastName,', ',Core1_pr_PatientRegistration.FirstName,' ',Core1_pr_PatientRegistration.MiddleName) as 'Patient Name', \n"
                        + "concat ('Dr.',Core1_dra_registered.surname,', ',Core1_dra_registered.name,' ',Core1_dra_registered.middlename,'  -  ',Core1_dra_registered.specialization )as 'Doctor Name',Core1_ipd_admission.admitdate as 'Date Admit',Core1_ipd_admission.status as 'Status'\n"
                        + "from Core1_bm_roomroom\n"
                        + "inner join Core1_bm_rooms\n"
                        + "on Core1_bm_roomroom.Roomlegitid=Core1_bm_rooms.Room_ID\n"
                        + "inner join Core1_ipd_admission\n"
                        + "on Core1_bm_rooms.id=Core1_ipd_admission.idroom\n"
                        + "inner join Core1_pr_PatientRegistration\n"
                        + "on Core1_pr_PatientRegistration.Patient_ID=Core1_ipd_admission.Patient_ID\n"
                        + "inner join Core1_dra_registered\n"
                        + "on Core1_dra_registered.Dr_ID=Core1_ipd_admission.Dr_ID\n"
                        + "where cast (Core1_ipd_admission.admitdate as date) =  convert (nvarchar,GETDATE(),101) ";

                pst = conn.prepareStatement(q);
                rs = pst.executeQuery();

                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            }
        } else if (cbFilter.getSelectedItem().equals("Weekly")) {
            try {
                String q = " select Core1_bm_rooms.Room_type as 'Room Type',Core1_bm_roomroom.RoomName as 'Room Name',Core1_bm_rooms.Bed_No as Bed,concat(Core1_pr_PatientRegistration.LastName,', ',Core1_pr_PatientRegistration.FirstName,' ',Core1_pr_PatientRegistration.MiddleName) as 'Patient Name', \n"
                        + "concat ('Dr.',Core1_dra_registered.surname,', ',Core1_dra_registered.name,' ',Core1_dra_registered.middlename,'  -  ',Core1_dra_registered.specialization )as 'Doctor Name',Core1_ipd_admission.admitdate as 'Date Admit',Core1_ipd_admission.status as 'Status'\n"
                        + "from Core1_bm_roomroom\n"
                        + "inner join Core1_bm_rooms\n"
                        + "on Core1_bm_roomroom.Roomlegitid=Core1_bm_rooms.Room_ID\n"
                        + "inner join Core1_ipd_admission\n"
                        + "on Core1_bm_rooms.id=Core1_ipd_admission.idroom\n"
                        + "inner join Core1_pr_PatientRegistration\n"
                        + "on Core1_pr_PatientRegistration.Patient_ID=Core1_ipd_admission.Patient_ID\n"
                        + "inner join Core1_dra_registered\n"
                        + "on Core1_dra_registered.Dr_ID=Core1_ipd_admission.Dr_ID\n"
                        + "Where Core1_ipd_admission.admitdate BETWEEN DATEADD(DAY, -7, GETDATE()) AND DATEADD(DAY, 1, GETDATE())";

                pst = conn.prepareStatement(q);
                rs = pst.executeQuery();

                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            }

        } else if (cbFilter.getSelectedItem().equals("Monthly")) {
            try {
                String q = "select Core1_bm_rooms.Room_type as 'Room Type',Core1_bm_roomroom.RoomName as 'Room Name',Core1_bm_rooms.Bed_No as Bed,concat(Core1_pr_PatientRegistration.LastName,', ',Core1_pr_PatientRegistration.FirstName,' ',Core1_pr_PatientRegistration.MiddleName) as 'Patient Name', \n"
                        + "concat ('Dr.',Core1_dra_registered.surname,', ',Core1_dra_registered.name,' ',Core1_dra_registered.middlename,'  -  ',Core1_dra_registered.specialization )as 'Doctor Name',Core1_ipd_admission.admitdate as 'Date Admit',Core1_ipd_admission.status as 'Status'\n"
                        + "from Core1_bm_roomroom\n"
                        + "inner join Core1_bm_rooms\n"
                        + "on Core1_bm_roomroom.Roomlegitid=Core1_bm_rooms.Room_ID\n"
                        + "inner join Core1_ipd_admission\n"
                        + "on Core1_bm_rooms.id=Core1_ipd_admission.idroom\n"
                        + "inner join Core1_pr_PatientRegistration\n"
                        + "on Core1_pr_PatientRegistration.Patient_ID=Core1_ipd_admission.Patient_ID\n"
                        + "inner join Core1_dra_registered\n"
                        + "on Core1_dra_registered.Dr_ID=Core1_ipd_admission.Dr_ID\n"
                        + "WHERE MONTH(Core1_ipd_admission.admitdate) = MONTH(dateadd(dd, -1, GetDate())) AND YEAR(Core1_ipd_admission.admitdate) = YEAR(dateadd(dd, -1, GetDate()))";

                pst = conn.prepareStatement(q);
                rs = pst.executeQuery();

                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            }

        } else if (cbFilter.getSelectedItem().equals("Yearly")) {
            try {
                String q = " select Core1_bm_rooms.Room_type as 'Room Type',Core1_bm_roomroom.RoomName as 'Room Name',Core1_bm_rooms.Bed_No as Bed,concat(Core1_pr_PatientRegistration.LastName,', ',Core1_pr_PatientRegistration.FirstName,' ',Core1_pr_PatientRegistration.MiddleName) as 'Patient Name', \n"
                        + "concat ('Dr.',Core1_dra_registered.surname,', ',Core1_dra_registered.name,' ',Core1_dra_registered.middlename,'  -  ',Core1_dra_registered.specialization )as 'Doctor Name',Core1_ipd_admission.admitdate as 'Date Admit',Core1_ipd_admission.status as 'Status'\n"
                        + "from Core1_bm_roomroom\n"
                        + "inner join Core1_bm_rooms\n"
                        + "on Core1_bm_roomroom.Roomlegitid=Core1_bm_rooms.Room_ID\n"
                        + "inner join Core1_ipd_admission\n"
                        + "on Core1_bm_rooms.id=Core1_ipd_admission.idroom\n"
                        + "inner join Core1_pr_PatientRegistration\n"
                        + "on Core1_pr_PatientRegistration.Patient_ID=Core1_ipd_admission.Patient_ID\n"
                        + "inner join Core1_dra_registered\n"
                        + "on Core1_dra_registered.Dr_ID=Core1_ipd_admission.Dr_ID\n"
                        + "WHERE Core1_ipd_admission.admitdate > DATEADD(year,-1,GETDATE())";

                pst = conn.prepareStatement(q);
                rs = pst.executeQuery();

                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            }

        } else {
            cbFilter.getSelectedItem().equals("All");
            try {
                String q = "select Core1_bm_rooms.Room_type as 'Room Type',Core1_bm_roomroom.RoomName as 'Room Name',Core1_bm_rooms.Bed_No as Bed,concat(Core1_pr_PatientRegistration.LastName,', ',Core1_pr_PatientRegistration.FirstName,' ',Core1_pr_PatientRegistration.MiddleName) as 'Patient Name', \n"
                        + "concat ('Dr.',Core1_dra_registered.surname,', ',Core1_dra_registered.name,' ',Core1_dra_registered.middlename,'  -  ',Core1_dra_registered.specialization )as 'Doctor Name',Core1_ipd_admission.admitdate as 'Date Admit',Core1_ipd_admission.status as 'Status'\n"
                        + "from Core1_bm_roomroom\n"
                        + "inner join Core1_bm_rooms\n"
                        + "on Core1_bm_roomroom.Roomlegitid=Core1_bm_rooms.Room_ID\n"
                        + "inner join Core1_ipd_admission\n"
                        + "on Core1_bm_rooms.id=Core1_ipd_admission.idroom\n"
                        + "inner join Core1_pr_PatientRegistration\n"
                        + "on Core1_pr_PatientRegistration.Patient_ID=Core1_ipd_admission.Patient_ID\n"
                        + "inner join Core1_dra_registered\n"
                        + "on Core1_dra_registered.Dr_ID=Core1_ipd_admission.Dr_ID";

                pst = conn.prepareStatement(q);
                rs = pst.executeQuery();

                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_cbFilterActionPerformed

    private void jTable3AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable3AncestorAdded
        jim2();         // TODO add your handling code here:
    }//GEN-LAST:event_jTable3AncestorAdded

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        int row = jTable3.getSelectedRow();
        String Table_click = (jTable3.getModel().getValueAt(row, 0).toString());

        try {
            String sql = "select * from Core1_ipd_vitals where vitalno='" + Table_click + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {

                String add1 = rs.getString("bp");
                z.setText(add1);
                String add2 = rs.getString("temp");
                x.setText(add2);
                String add3 = rs.getString("height");
                c.setText(add3);
                String add4 = rs.getString("weight");
                v.setText(add4);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTable3MouseClicked

    private void cbFilter1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbFilter1PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFilter1PopupMenuWillBecomeInvisible

    private void cbFilter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFilter1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFilter1ActionPerformed

    private void jTable5AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable5AncestorAdded
        jim3();        // TODO add your handling code here:
    }//GEN-LAST:event_jTable5AncestorAdded

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable5MouseClicked

    private void cbFilter2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbFilter2PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFilter2PopupMenuWillBecomeInvisible

    private void cbFilter2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFilter2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFilter2ActionPerformed

    private void zMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_zMouseClicked

    private void zActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_zActionPerformed

    private void zKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_zKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_zKeyPressed

    private void zKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_zKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_zKeyReleased

    private void xMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_xMouseClicked

    private void xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xActionPerformed

    private void xKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_xKeyPressed

    private void xKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_xKeyReleased

    private void vMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_vMouseClicked

    private void vActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vActionPerformed

    private void vKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_vKeyPressed

    private void vKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_vKeyReleased

    private void fillAll1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillAll1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fillAll1ActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            evt.consume();

        }
        if (search.getText().length() == 15) {
            JOptionPane.showMessageDialog(null, "Maximum Reach", null, JOptionPane.ERROR_MESSAGE);
            evt.consume();
        }
        char num = evt.getKeyChar();
        if (!Character.isDigit(num)) {
            evt.consume();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_searchKeyReleased

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {

                String sql = "select * from Core1_pr_PatientRegistration where Patient_ID=?";

                pst = conn.prepareStatement(sql);
                pst.setString(1, search.getText());
                rs = pst.executeQuery();

                if (rs.next()) {

                    try {
                        String sql1 = "select Patient_ID,PR_Gender,concat (Lastname,', ',FirstName) as Name, image from Core1_pr_PatientRegistration where Patient_ID =?";
                        pst = conn.prepareStatement(sql1);
                        pst.setString(1, search.getText());
                        rs = pst.executeQuery();
                        if (rs.next()) {
                            String add1 = rs.getString("Name");
                            ID.setText(add1);
                            String add2 = rs.getString("PR_Gender");
                            GENDER.setText(add2);
                            String add3 = rs.getString("Patient_ID");
                            NAME.setText(add3);
                            byte[] img2 = rs.getBytes("image");
                            ImageIcon img3 = new ImageIcon(img2);
                            Image img = img3.getImage();
                            Image newImg = img.getScaledInstance(imageHolder.getWidth(), imageHolder.getHeight(), Image.SCALE_SMOOTH);
                            ImageIcon newImc = new ImageIcon(newImg);
                            imageHolder.setIcon(newImc);

                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                } else {
                    //         JOptionPane.showMessageDialog(null, "Not a Patient", "Search Patient", JOptionPane.ERROR_MESSAGE);
                    DesktopNotify.showDesktopMessage("Wrong Patient No.", "Right Patient",
                            DesktopNotify.FAIL, 8000);

                }

            } catch (Exception e) {
                DesktopNotify.showDesktopMessage("Wrong Patient No.", "Right Patient",
                        DesktopNotify.FAIL, 8000);
            }

        }        // TODO add your handling code here:
    }//GEN-LAST:event_searchKeyPressed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void search3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search3KeyTyped
        if (search3.getText().length() == 15) {
            JOptionPane.showMessageDialog(null, "You reach the maximum characters", null, JOptionPane.ERROR_MESSAGE);
            evt.consume();
        }
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            evt.consume();

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_search3KeyTyped

    private void AddAllergyDRIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddAllergyDRIDKeyTyped
        if (AddAllergyDRID.getText().length() == 15) {
            JOptionPane.showMessageDialog(null, "You reach the maximum characters", null, JOptionPane.ERROR_MESSAGE);
            evt.consume();
        }
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            evt.consume();

        }        // TODO add your handling code here:
    }//GEN-LAST:event_AddAllergyDRIDKeyTyped

    private void search5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search5KeyTyped
        if (search5.getText().length() == 15) {
            JOptionPane.showMessageDialog(null, "You reach the maximum characters", null, JOptionPane.ERROR_MESSAGE);
            evt.consume();
        }
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            evt.consume();

        }         // TODO add your handling code here:
    }//GEN-LAST:event_search5KeyTyped

    private void fillAll2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillAll2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fillAll2ActionPerformed

    private void diagnosis2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_diagnosis2AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_diagnosis2AncestorAdded

    private void jLabel90MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel90MouseClicked
        int h = showConfirmDialog(null, "Do you want to Exit View/Edit a Diagnosis?", "Diagnosis", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            AddDiagnosisTbl.setVisible(false);
        }
        if (h == 1) {

        }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel90MouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        two();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void fillAll3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillAll3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fillAll3ActionPerformed

    private void jTable2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable2AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2AncestorAdded

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseClicked

    private void cbFilter3PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbFilter3PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFilter3PopupMenuWillBecomeInvisible

    private void cbFilter3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFilter3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFilter3ActionPerformed

    private void search12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_search12MouseClicked

    private void search12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search12ActionPerformed

    private void search12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search12KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {

                String sql = "select * from Core1_dra_registered where Dr_ID=?";

                pst = conn.prepareStatement(sql);
                pst.setString(1, search12.getText());
                rs = pst.executeQuery();

                if (rs.next()) {
                    try {
                        String sql1 = "select concat (surname,', ',name,' ',middlename,'   -   ',specialization) as Name from Core1_dra_registered where Dr_ID=?";
                        pst = conn.prepareStatement(sql1);
                        pst.setString(1, search12.getText());
                        rs = pst.executeQuery();
                        if (rs.next()) {
                            String add1 = rs.getString("Name");
                            search13.setText(add1);

                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                } else {
                    //JOptionPane.showMessageDialog(null, "Not a Doctor","Search Doctor",JOptionPane.ERROR_MESSAGE);
                    DesktopNotify.showDesktopMessage("Not a Doctor", "Search Doctor",
                            DesktopNotify.FAIL, 8000);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }// TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_search12KeyPressed

    private void search12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search12KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search12KeyReleased

    private void search12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search12KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_search12KeyTyped

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void search13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search13ActionPerformed

    private void search13KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search13KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_search13KeyPressed

    private void search13KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search13KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search13KeyReleased

    private void lname2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lname2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lname2ActionPerformed

    private void lname2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lname2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_lname2KeyTyped

    private void ss1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ss1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ss1ActionPerformed

    private void ee1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ee1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ee1ActionPerformed

    private void oo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oo1ActionPerformed

    private void jLabel61MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel61MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel61MouseEntered

    private void jLabel102MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel102MouseClicked
        int h = showConfirmDialog(null, "Do you want to Exit Clinical Findings Table?", "Clinical Finding", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            AddClinicalFindingTbl.setVisible(false);
        }
        if (h == 1) {

        }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel102MouseClicked

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void fillAll4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillAll4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fillAll4ActionPerformed

    private void jTable4AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable4AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable4AncestorAdded

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable4MouseClicked

    private void cbFilter4PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbFilter4PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFilter4PopupMenuWillBecomeInvisible

    private void cbFilter4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFilter4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFilter4ActionPerformed

    private void search14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_search14MouseClicked

    private void search14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search14ActionPerformed

    private void search14KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search14KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {

                String sql = "select * from Core1_dra_registered where Dr_ID=?";

                pst = conn.prepareStatement(sql);
                pst.setString(1, search14.getText());
                rs = pst.executeQuery();

                if (rs.next()) {
                    try {
                        String sql1 = "select concat (surname,', ',name,' ',middlename,'   -   ',specialization) as Name from Core1_dra_registered where Dr_ID=?";
                        pst = conn.prepareStatement(sql1);
                        pst.setString(1, search14.getText());
                        rs = pst.executeQuery();
                        if (rs.next()) {
                            String add1 = rs.getString("Name");
                            search15.setText(add1);

                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                } else {
                    //JOptionPane.showMessageDialog(null, "Not a Doctor","Search Doctor",JOptionPane.ERROR_MESSAGE);
                    DesktopNotify.showDesktopMessage("Not a Doctor", "Search Doctor",
                            DesktopNotify.FAIL, 8000);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }// TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_search14KeyPressed

    private void search14KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search14KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search14KeyReleased

    private void search14KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search14KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_search14KeyTyped

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        try {

            String sql = "select * from Core1_dra_registered where Dr_ID=?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, search14.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                try {
                    String sql1 = "select concat (surname,', ',name,' ',middlename,'   -   ',specialization) as Name from Core1_dra_registered where Dr_ID=?";
                    pst = conn.prepareStatement(sql1);
                    pst.setString(1, search14.getText());
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String add1 = rs.getString("Name");
                        search15.setText(add1);

                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            } else {
                //JOptionPane.showMessageDialog(null, "Not a Doctor","Search Doctor",JOptionPane.ERROR_MESSAGE);
                DesktopNotify.showDesktopMessage("Not a Doctor", "Search Doctor",
                        DesktopNotify.FAIL, 8000);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void search15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search15ActionPerformed

    private void search15KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search15KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_search15KeyPressed

    private void search15KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search15KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search15KeyReleased

    private void lname3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lname3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lname3ActionPerformed

    private void lname3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lname3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_lname3KeyTyped

    private void diagnosis3AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_diagnosis3AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_diagnosis3AncestorAdded

    private void jLabel108MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel108MouseClicked
        int h = showConfirmDialog(null, "Do you want to Exit View/Edit a Allergy?", "Allergy", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            AddAllergyTbl.setVisible(false);
        }
        if (h == 1) {

        }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel108MouseClicked

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    private void fillAll5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillAll5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fillAll5ActionPerformed

    private void jTable6AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable6AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable6AncestorAdded

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable6MouseClicked

    private void cbFilter5PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbFilter5PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFilter5PopupMenuWillBecomeInvisible

    private void cbFilter5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFilter5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFilter5ActionPerformed

    private void search18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_search18MouseClicked

    private void search18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search18ActionPerformed

    private void search18KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search18KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {

                String sql = "select * from Core1_dra_registered where Dr_ID=?";

                pst = conn.prepareStatement(sql);
                pst.setString(1, search18.getText());
                rs = pst.executeQuery();

                if (rs.next()) {
                    try {
                        String sql1 = "select concat (surname,', ',name,' ',middlename,'   -   ',specialization) as Name from Core1_dra_registered where Dr_ID=?";
                        pst = conn.prepareStatement(sql1);
                        pst.setString(1, search18.getText());
                        rs = pst.executeQuery();
                        if (rs.next()) {
                            String add1 = rs.getString("Name");
                            search19.setText(add1);

                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                } else {
                    //JOptionPane.showMessageDialog(null, "Not a Doctor","Search Doctor",JOptionPane.ERROR_MESSAGE);
                    DesktopNotify.showDesktopMessage("Not a Doctor", "Search Doctor",
                            DesktopNotify.FAIL, 8000);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }// TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_search18KeyPressed

    private void search18KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search18KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search18KeyReleased

    private void search18KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search18KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_search18KeyTyped

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        try {

            String sql = "select * from Core1_dra_registered where Dr_ID=?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, search18.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                try {
                    String sql1 = "select concat (surname,', ',name,' ',middlename,'   -   ',specialization) as Name from Core1_dra_registered where Dr_ID=?";
                    pst = conn.prepareStatement(sql1);
                    pst.setString(1, search18.getText());
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String add1 = rs.getString("Name");
                        search19.setText(add1);

                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            } else {
                //JOptionPane.showMessageDialog(null, "Not a Doctor","Search Doctor",JOptionPane.ERROR_MESSAGE);
                DesktopNotify.showDesktopMessage("Not a Doctor", "Search Doctor",
                        DesktopNotify.FAIL, 8000);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void search19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search19ActionPerformed

    private void search19KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search19KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_search19KeyPressed

    private void search19KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search19KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search19KeyReleased

    private void lname4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lname4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lname4ActionPerformed

    private void lname4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lname4KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_lname4KeyTyped

    private void diagnosis4AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_diagnosis4AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_diagnosis4AncestorAdded

    private void jLabel114MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel114MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel114MouseClicked

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19ActionPerformed

    private void fillAll6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillAll6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fillAll6ActionPerformed

    private void jTable7AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable7AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable7AncestorAdded

    private void jTable7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable7MouseClicked

    private void cbFilter6PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbFilter6PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFilter6PopupMenuWillBecomeInvisible

    private void cbFilter6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFilter6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFilter6ActionPerformed

    private void search20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search20MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_search20MouseClicked

    private void search20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search20ActionPerformed

    private void search20KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search20KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_search20KeyPressed

    private void search20KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search20KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search20KeyReleased

    private void search20KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search20KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_search20KeyTyped

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton20ActionPerformed

    private void search21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search21ActionPerformed

    private void search21KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search21KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_search21KeyPressed

    private void search21KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search21KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search21KeyReleased

    private void lname5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lname5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lname5ActionPerformed

    private void lname5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lname5KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_lname5KeyTyped

    private void diagnosis5AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_diagnosis5AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_diagnosis5AncestorAdded

    private void jLabel120MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel120MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel120MouseClicked

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton21ActionPerformed

    private void fillAll7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillAll7ActionPerformed

    }//GEN-LAST:event_fillAll7ActionPerformed

    private void jTable8AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable8AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable8AncestorAdded

    private void jTable8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable8MouseClicked

    private void cbFilter7PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbFilter7PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFilter7PopupMenuWillBecomeInvisible

    private void cbFilter7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFilter7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFilter7ActionPerformed

    private void search22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search22MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_search22MouseClicked

    private void search22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search22ActionPerformed

    private void search22KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search22KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {

                String sql = "select * from Core1_dra_registered where Dr_ID=?";

                pst = conn.prepareStatement(sql);
                pst.setString(1, search22.getText());
                rs = pst.executeQuery();

                if (rs.next()) {
                    try {
                        String sql1 = "select concat (surname,', ',name,' ',middlename,'   -   ',specialization) as Name from Core1_dra_registered where Dr_ID=?";
                        pst = conn.prepareStatement(sql1);
                        pst.setString(1, search22.getText());
                        rs = pst.executeQuery();
                        if (rs.next()) {
                            String add1 = rs.getString("Name");
                            search23.setText(add1);

                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                } else {
                    //JOptionPane.showMessageDialog(null, "Not a Doctor","Search Doctor",JOptionPane.ERROR_MESSAGE);
                    DesktopNotify.showDesktopMessage("Not a Doctor", "Search Doctor",
                            DesktopNotify.FAIL, 8000);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }// TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_search22KeyPressed

    private void search22KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search22KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search22KeyReleased

    private void search22KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search22KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_search22KeyTyped

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton22ActionPerformed

    private void search23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search23ActionPerformed

    private void search23KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search23KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_search23KeyPressed

    private void search23KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search23KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search23KeyReleased

    private void lname6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lname6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lname6ActionPerformed

    private void lname6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lname6KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_lname6KeyTyped

    private void diagnosis6AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_diagnosis6AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_diagnosis6AncestorAdded

    private void jLabel126MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel126MouseClicked
        int h = showConfirmDialog(null, "Do you want to Close View Linen Request", "Linen Request", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            AddBedandLinenTbl.setVisible(false);
        }
        if (h == 1) {

        }         // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel126MouseClicked

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton23ActionPerformed

    private void fillAll8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillAll8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fillAll8ActionPerformed

    private void jTable9AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable9AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable9AncestorAdded

    private void jTable9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable9MouseClicked

    private void cbFilter8PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbFilter8PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFilter8PopupMenuWillBecomeInvisible

    private void cbFilter8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFilter8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFilter8ActionPerformed

    private void search24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search24MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_search24MouseClicked

    private void search24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search24ActionPerformed

    private void search24KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search24KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_search24KeyPressed

    private void search24KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search24KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search24KeyReleased

    private void search24KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search24KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_search24KeyTyped

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

    private void search25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search25ActionPerformed

    private void search25KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search25KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_search25KeyPressed

    private void search25KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search25KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search25KeyReleased

    private void lname7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lname7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lname7ActionPerformed

    private void lname7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lname7KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_lname7KeyTyped

    private void diagnosis7AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_diagnosis7AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_diagnosis7AncestorAdded

    private void jLabel132MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel132MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel132MouseClicked

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton25ActionPerformed

    private void fillAll9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillAll9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fillAll9ActionPerformed

    private void jTable10AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable10AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable10AncestorAdded

    private void jTable10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable10MouseClicked

    private void cbFilter9PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbFilter9PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFilter9PopupMenuWillBecomeInvisible

    private void cbFilter9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFilter9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFilter9ActionPerformed

    private void search26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search26MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_search26MouseClicked

    private void search26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search26ActionPerformed

    private void search26KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search26KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_search26KeyPressed

    private void search26KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search26KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search26KeyReleased

    private void search26KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search26KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_search26KeyTyped

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton26ActionPerformed

    private void search27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search27ActionPerformed

    private void search27KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search27KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_search27KeyPressed

    private void search27KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search27KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search27KeyReleased

    private void lname8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lname8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lname8ActionPerformed

    private void lname8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lname8KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_lname8KeyTyped

    private void diagnosis8AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_diagnosis8AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_diagnosis8AncestorAdded

    private void tbl_allergies1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_allergies1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_allergies1AncestorAdded

    private void tbl_clinical1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_clinical1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_clinical1AncestorAdded

    private void tbl_consultation3AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_consultation3AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_consultation3AncestorAdded

    private void tbl_consultation4AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_consultation4AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_consultation4AncestorAdded

    private void tbl_consultation5AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_consultation5AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_consultation5AncestorAdded

    private void tbl_allergy1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_allergy1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_allergy1AncestorAdded

    private void tbl_treatment1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_treatment1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_treatment1AncestorAdded

    private void tbl_diagnosis1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_diagnosis1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_diagnosis1AncestorAdded

    private void tbl_surgeries1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_surgeries1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_surgeries1AncestorAdded

    private void tbl_medication1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_medication1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_medication1AncestorAdded

    private void DrugPrescription1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DrugPrescription1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DrugPrescription1ActionPerformed

    private void Diagnosis1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Diagnosis1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Diagnosis1ActionPerformed

    private void Consultation9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Consultation9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Consultation9ActionPerformed

    private void ClinicalFinding1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClinicalFinding1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClinicalFinding1ActionPerformed

    private void Allergy2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Allergy2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Allergy2ActionPerformed

    private void Surgery1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Surgery1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Surgery1ActionPerformed

    private void Treatment1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Treatment1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Treatment1ActionPerformed

    private void Allergy3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Allergy3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Allergy3ActionPerformed

    private void search28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search28ActionPerformed

    private void search28KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search28KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_search28KeyPressed

    private void search28KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search28KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search28KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Consultation10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Consultation10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Consultation10ActionPerformed

    private void Consultation11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Consultation11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Consultation11ActionPerformed

    private void Consultation12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Consultation12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Consultation12ActionPerformed

    private void Consultation13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Consultation13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Consultation13ActionPerformed

    private void Consultation14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Consultation14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Consultation14ActionPerformed

    private void Consultation15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Consultation15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Consultation15ActionPerformed

    private void Consultation16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Consultation16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Consultation16ActionPerformed

    private void Consultation17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Consultation17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Consultation17ActionPerformed

    private void jLabel141MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel141MouseClicked
        int h = showConfirmDialog(null, "Do you want to Exit", "Exit", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            one();
            UpdateConsultation.setVisible(false);
            AddConsultationTbl.setVisible(true);
        }
        if (h == 1) {

        }         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel141MouseClicked

    private void diagnosis9AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_diagnosis9AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_diagnosis9AncestorAdded

    private void PassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PassMouseClicked
        Pass.setText("");
    }//GEN-LAST:event_PassMouseClicked

    private void PassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PassKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            //String sql = "select * from SignUp where pass=? and App_ID='105028'";
//                pst=conn.prepareStatement(sql);             
//                pst.setString(1,Pass.getText());
//                rs=pst.executeQuery();
//                String Pword = Pass.getText();
            String sql = "select * from SignUp where pass=? and App_ID='105028'";

            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, Pass.getText());
                rs = pst.executeQuery();

                if (rs.next()) {
                    //JOptionPane.showMessageDialog(null, "WELCOME!");
                    AddConsultationTbl.setVisible(true);
                    DesktopNotify.showDesktopMessage("Updated.", "Correct Password",
                            DesktopNotify.SUCCESS, 8000);
                    pst.execute();
                } else {

                    //JOptionPane.showMessageDialog(null, "WRONG ID NO.","ERROR",JOptionPane.ERROR_MESSAGE);
                    DesktopNotify.showDesktopMessage("Wrong Password", "Password",
                            DesktopNotify.FAIL, 8000);

                    Pass.setText("");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_PassKeyPressed

    private void PassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PassKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_PassKeyReleased

    private void fillAll11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillAll11ActionPerformed
        String sql = "select * from SignUp where pass=? and App_ID='105028'";

        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, Pass.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                //JOptionPane.showMessageDialog(null, "WELCOME!");
                AddConsultationTbl.setVisible(true);
                DesktopNotify.showDesktopMessage("Updated", "Correct Password",
                        DesktopNotify.SUCCESS, 8000);
                pst.execute();
            } else {

                //JOptionPane.showMessageDialog(null, "WRONG ID NO.","ERROR",JOptionPane.ERROR_MESSAGE);
                DesktopNotify.showDesktopMessage("Wrong Password", "Password",
                        DesktopNotify.FAIL, 8000);

                Pass.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_fillAll11ActionPerformed

    private void jLabel142MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel142MouseClicked
        int h = showConfirmDialog(null, "Do you want to Exit", "Exit", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            one();
            AddMedicine.setVisible(false);
        }
        if (h == 1) {

        }          // TODO add your handling code here:
    }//GEN-LAST:event_jLabel142MouseClicked

    private void search29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search29MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_search29MouseClicked

    private void search29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search29ActionPerformed

    private void search29KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search29KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {

                String sql = "select * from Core1_dra_registered where Dr_ID=?";

                pst = conn.prepareStatement(sql);
                pst.setString(1, search29.getText());
                rs = pst.executeQuery();

                if (rs.next()) {
                    try {
                        String sql1 = "select concat (surname,', ',name,' ',middlename,'   -   ',specialization) as Name from Core1_dra_registered where Dr_ID=?";
                        pst = conn.prepareStatement(sql1);
                        pst.setString(1, search29.getText());
                        rs = pst.executeQuery();
                        if (rs.next()) {
                            String add1 = rs.getString("Name");
                            search30.setText(add1);

                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                } else {
                    //JOptionPane.showMessageDialog(null, "Not a Doctor","Search Doctor",JOptionPane.ERROR_MESSAGE);
                    DesktopNotify.showDesktopMessage("Not a Doctor", "Search Doctor",
                            DesktopNotify.FAIL, 8000);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }// TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_search29KeyPressed

    private void search29KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search29KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search29KeyReleased

    private void search29KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search29KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_search29KeyTyped

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void search30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search30ActionPerformed

    private void search30KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search30KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_search30KeyPressed

    private void search30KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search30KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search30KeyReleased

    private void paraclinicalfinding2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_paraclinicalfinding2AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_paraclinicalfinding2AncestorAdded

    private void jLabel147MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel147MouseClicked
        int h = showConfirmDialog(null, "Do you want to Exit Linen Request?", "Linen Request", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            AddBedandLinen.setVisible(false);
        }
        if (h == 1) {

        }              // TODO add your handling code here:
    }//GEN-LAST:event_jLabel147MouseClicked

    private void jTable11AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable11AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable11AncestorAdded

    private void jTable11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable11MouseClicked

    private void txt_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_itemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_itemActionPerformed

    private void txt_itemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_itemKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_itemKeyPressed

    private void txt_itemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_itemKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_itemKeyReleased

    private void diagnosis10AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_diagnosis10AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_diagnosis10AncestorAdded

    private void jTable12AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable12AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable12AncestorAdded

    private void jTable12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable12MouseClicked

        try {
            int row = jTable12.getSelectedRow();
            String table_update = (jTable12.getModel().getValueAt(row, 0).toString());
            String sql = "select Stock_ID as 'STOCK NO.',Item as ITEM , Quantity as QUANTITY from Core1_lm_inventory where Stock_ID='" + table_update + "'";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                //Display data for update  
                String add0 = rs.getString("ITEM");
                txt_item.setText(add0);

            }

        } catch (Exception e) {
            System.out.println(e);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTable12MouseClicked

    private void txt_item1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_item1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_item1ActionPerformed

    private void txt_item1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_item1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_item1KeyPressed

    private void txt_item1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_item1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_item1KeyReleased

    private void txt_dr_lnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dr_lnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dr_lnActionPerformed

    private void txt_dr_lnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dr_lnKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dr_lnKeyPressed

    private void txt_dr_lnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dr_lnKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dr_lnKeyReleased

    private void sub_module_1_btn5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn5MouseClicked

    private void sub_module_1_btn5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn5MouseEntered

    private void sub_module_1_btn5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn5MouseExited

    private void sub_module_1_btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sub_module_1_btn5ActionPerformed

        if (txt_dr_ln.getText().isEmpty()) {
            // Validation message. 
            DesktopNotify.showDesktopMessage("INPUT MISSING...", "Please enter your name",
                    DesktopNotify.INPUT_REQUEST, 8000);

        } else if (txt_item.getText().isEmpty()) {
            DesktopNotify.showDesktopMessage("INPUT MISSING...", "Please enter item name",
                    DesktopNotify.INPUT_REQUEST, 8000);

        } else if (txt_item1.getText().isEmpty()) {
            DesktopNotify.showDesktopMessage("INPUT MISSING...", "Please enter quantity of item",
                    DesktopNotify.INPUT_REQUEST, 8000);

        } else {

//1
            try {
                String query = "insert into Core1_lm_hk_request (Name,item,qty,date_req,status)values(?,?,?,?,?)";

                conn = MysqlConnect.ConnectDB();
                pst = conn.prepareStatement(query);
                pst.setString(1, txt_dr_ln.getText());
                pst.setString(2, txt_item.getText());
                pst.setString(3, txt_item1.getText());
                pst.setString(4, date_dayv2.getText());
                pst.setString(5, "Pending request");

                pst.execute();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

//2            
            try {

                String sql = "insert into Core1_ipd_linenreq (Patient_ID,Requestor,item,quantity,department,datereq,status) values (?,?,?,?,?,?,?)";

                pst = conn.prepareStatement(sql);
                pst.setString(1, NAME.getText());
                pst.setString(2, txt_dr_ln.getText());
                pst.setString(3, txt_item.getText());
                pst.setString(4, txt_item1.getText());
                pst.setString(5, "Inpatient");
                pst.setString(6, date_dayv2.getText());
                pst.setString(7, "Pending request");

                pst.execute();

                txt_dr_ln.setText("");
                txt_item.setText("");
                txt_item1.setText("");

                DesktopNotify.showDesktopMessage("Saved item", "Linen Request",
                        DesktopNotify.SUCCESS, 8000);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn5ActionPerformed

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void lnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lnameKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameKeyTyped

    private void sub_module_1_btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn1MouseClicked

    private void sub_module_1_btn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn1MouseEntered

    private void sub_module_1_btn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn1MouseExited

    private void sub_module_1_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sub_module_1_btn1ActionPerformed
        int h = showConfirmDialog(null, "Are you sure you want to Insert Question?", "Insert Questions", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            Q.setSize(281, 270);
            Q.setVisible(true);
        }
        if (h == 1) {

        }                // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn1ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        int h = showConfirmDialog(null, "Do you want to Close Add Diagnosis?", "Add Diagnosis", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            search1.setText("");
            lname.setText("");
            insert.setText("");
            search2.setText("");
            AddDiagnosis1.setVisible(false);
            q.setVisible(false);
        }
        if (h == 1) {

        }         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void sub_module_1_btn10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn10MouseClicked

    private void sub_module_1_btn10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn10MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn10MouseEntered

    private void sub_module_1_btn10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn10MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn10MouseExited

    private void sub_module_1_btn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sub_module_1_btn10ActionPerformed

        int h = showConfirmDialog(null, "Are you sure you want to Save?", " ", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            try {

                String sql1 = "insert into Core1_ipd_AddDiagnosis(Doctor_ID,Patient_ID,Title,Note,Date)values(?,?,?,?,?)";

                pst = conn.prepareStatement(sql1);
                pst.setString(1, search2.getText());
                pst.setString(2, NAME.getText());
                pst.setString(3, lname.getText());
                pst.setString(4, insert.getText());
                pst.setString(5, date_dayv2.getText());

                pst.execute();

                search2.setText("");
                lname.setText("");
                search1.setText("");
                insert.setText("");

                AddDiagnosis1.setVisible(false);
                q.setVisible(false);
                JOptionPane.showMessageDialog(null, "Saved");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }        // TODO add your handling code here:
            // TODO add your handling code here:

        }
        if (h == 1) {

        }
        Diagnosis();

        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn10ActionPerformed

    private void search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search1ActionPerformed

    private void search1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_search1KeyPressed

    private void search1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search1KeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {

            String sql = "select * from Core1_dra_registered where Dr_ID=?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, search2.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                try {
                    String sql1 = "select concat (surname,', ',name,' ',middlename,'   -   ',specialization) as Name from Core1_dra_registered where Dr_ID=?";
                    pst = conn.prepareStatement(sql1);
                    pst.setString(1, search2.getText());
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String add1 = rs.getString("Name");
                        search1.setText(add1);

                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Not a Doctor", "Search Doctor", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void search2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_search2MouseClicked

    private void search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search2ActionPerformed

    private void search2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {

                String sql = "select * from Core1_dra_registered where Dr_ID=?";

                pst = conn.prepareStatement(sql);
                pst.setString(1, search2.getText());
                rs = pst.executeQuery();

                if (rs.next()) {
                    try {
                        String sql1 = "select concat (surname,', ',name,' ',middlename,'   -   ',specialization) as Name from Core1_dra_registered where Dr_ID=?";
                        pst = conn.prepareStatement(sql1);
                        pst.setString(1, search2.getText());
                        rs = pst.executeQuery();
                        if (rs.next()) {
                            String add1 = rs.getString("Name");
                            search1.setText(add1);

                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Not a Doctor", "Search Doctor", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_search2KeyPressed

    private void search2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search2KeyReleased

    private void search2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search2KeyTyped
        if (search2.getText().length() == 15) {
            JOptionPane.showMessageDialog(null, "You reach the maximum characters", null, JOptionPane.ERROR_MESSAGE);
            evt.consume();
        }
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            evt.consume();

        }        // TODO add your handling code here:
    }//GEN-LAST:event_search2KeyTyped

    private void diagnosisAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_diagnosisAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_diagnosisAncestorAdded

    private void sub_module_1_btn11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn11MouseClicked

    private void sub_module_1_btn11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn11MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn11MouseEntered

    private void sub_module_1_btn11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sub_module_1_btn11MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn11MouseExited

    private void sub_module_1_btn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sub_module_1_btn11ActionPerformed
        int h = showConfirmDialog(null, "Do you want to Save?", " ", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            try {

                String sql1 = "insert into Core1_ipd_AddSurgery(Doctor_ID,Patient_ID,Title,Sched,Note,Date,Status) values(?,?,?,?,?,?,?)";

                pst = conn.prepareStatement(sql1);
                pst.setString(1, search31.getText());
                pst.setString(2, NAME.getText());
                pst.setString(3, title2.getText());
                pst.setString(4, ((JTextField) bday6.getDateEditor().getUiComponent()).getText());
                pst.setString(5, jTextArea9.getText());
                pst.setString(6, date_dayv2.getText());
                pst.setString(7, "Pending");
                pst.execute();

                search31.setText("");
                title2.setText("");
                jTextArea9.setText("");
                AddDiagnosis1.setVisible(false);
                q.setVisible(false);
                JOptionPane.showMessageDialog(null, "Saved");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }        // TODO add your handling code here:
            // TODO add your handling code here:

        }
        if (h == 1) {

        }        // TODO add your handling code here:
    }//GEN-LAST:event_sub_module_1_btn11ActionPerformed

    private void jLabel152MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel152MouseClicked
        int h = showConfirmDialog(null, "Do you want to Close Add Surgery?", "Add Surgery", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            search31.setText("");
            search32.setText("");
            title2.setText("");
            jTextArea9.setText("");
            AddSurgery.setVisible(false);

        }
        if (h == 1) {

        }           // TODO add your handling code here:
    }//GEN-LAST:event_jLabel152MouseClicked

    private void search31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search31MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_search31MouseClicked

    private void search31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search31ActionPerformed

    private void search31KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search31KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {

                String sql = "select * from Core1_dra_registered where Dr_ID=?";

                pst = conn.prepareStatement(sql);
                pst.setString(1, search31.getText());
                rs = pst.executeQuery();

                if (rs.next()) {
                    try {
                        String sql1 = "select concat (surname,', ',name,' ',middlename,'   -   ',specialization) as Name from Core1_dra_registered where Dr_ID=?";
                        pst = conn.prepareStatement(sql1);
                        pst.setString(1, search31.getText());
                        rs = pst.executeQuery();
                        if (rs.next()) {
                            String add1 = rs.getString("Name");
                            search32.setText(add1);

                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                } else {
                    //JOptionPane.showMessageDialog(null, "Not a Doctor","Search Doctor",JOptionPane.ERROR_MESSAGE);
                    DesktopNotify.showDesktopMessage("Not a Doctor", "Search Doctor",
                            DesktopNotify.FAIL, 8000);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }// TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_search31KeyPressed

    private void search31KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search31KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search31KeyReleased

    private void search31KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search31KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_search31KeyTyped

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void search32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search32ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search32ActionPerformed

    private void search32KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search32KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_search32KeyPressed

    private void search32KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search32KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search32KeyReleased

    private void allergy2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_allergy2AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_allergy2AncestorAdded

    private void Request_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Request_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Request_NameActionPerformed

    private void Medicine_TypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Medicine_TypeActionPerformed

    }//GEN-LAST:event_Medicine_TypeActionPerformed

    private void InpatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InpatientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InpatientActionPerformed

    private void Item_Name1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_Item_Name1AncestorAdded
        combo_item4();
    }//GEN-LAST:event_Item_Name1AncestorAdded

    private void Item_Name1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item_Name1ActionPerformed
        try {
            String sql = "SELECT * FROM Core3_PMC_Inventory WHERE Item_Name = '" + Item_Name1.getSelectedItem().toString() + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                String b1 = rs.getString("Price");
                Price.setText(b1);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Item_Name1ActionPerformed

    private void IQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IQuantityActionPerformed

    private void RequestorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RequestorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RequestorActionPerformed

    private void RequestAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_RequestAncestorAdded
        Request_tbl();
    }//GEN-LAST:event_RequestAncestorAdded

    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
        try {
            String sql = "INSERT INTO Core3_PMC_MedRequestList(RequestMedicineName,Type,Department,Items,Quantity,Status)"
                    + "VALUES('" + Request_Name.getText() + "', '" + Medicine_Type.getText() + "', '" + Inpatient.getText() + "','" + Item_Name1.getSelectedItem().toString() + "',"
                    + "'" + IQuantity.getText() + "','Pending')";
            pst = conn.prepareStatement(sql);
            pst.execute();

            IQuantity.setText("0");
            Price.setText("0");

            DesktopNotify.showDesktopMessage("SEND SUCCESSFULLY...", "Your Request Medicine is Submitted.",
                    DesktopNotify.SUCCESS, 8000);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        Request_tbl();
    }//GEN-LAST:event_add1ActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        //saving on table

        try {
            String sql = "INSERT INTO Core3_PMC_Request(RequestMedicineName,Type,Requestor,Department,Urgent,Status)"
                    + "VALUES('" + Request_Name.getText() + "','" + Medicine_Type.getText() + "','" + Requestor.getText() + "','" + Inpatient.getText() + "',"
                    + "'" + Urgent.getSelectedItem().toString() + "','Pending'";
            pst = conn.prepareStatement(sql);
            pst.execute();

            Request_Name.setText("");
            Medicine_Type.setText("");
            Requestor.setText("");
            Inpatient.setText("");
            Urgent.setSelectedItem("Select");

            DesktopNotify.showDesktopMessage("SUCCESSFULLY SEND REQUEST...", "Wait Your Approval.",
                    DesktopNotify.SUCCESS, 8000);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_addActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog AddAllergy1;
    private javax.swing.JTextField AddAllergyDRID;
    private javax.swing.JDialog AddAllergyTbl;
    private javax.swing.JDialog AddBedandLinen;
    private javax.swing.JDialog AddBedandLinenTbl;
    private javax.swing.JDialog AddClinicalFinding1;
    private javax.swing.JDialog AddClinicalFindingTbl;
    private javax.swing.JDialog AddConsultation;
    private javax.swing.JDialog AddConsultationTbl;
    private javax.swing.JDialog AddDiagnosis1;
    private javax.swing.JDialog AddDiagnosisTbl;
    private javax.swing.JDialog AddLaboratory;
    private javax.swing.JDialog AddLaboratoryTbl;
    private javax.swing.JDialog AddMedicine;
    private javax.swing.JDialog AddMedicineTbl;
    private javax.swing.JDialog AddSurgery;
    private javax.swing.JDialog AddSurgeryTbl;
    private javax.swing.JDialog AddTreatment;
    private javax.swing.JButton Allergy;
    private javax.swing.JButton Allergy1;
    private javax.swing.JButton Allergy2;
    private javax.swing.JButton Allergy3;
    private javax.swing.JButton ClinicalFinding;
    private javax.swing.JButton ClinicalFinding1;
    private javax.swing.JButton Consultation;
    private javax.swing.JButton Consultation1;
    private javax.swing.JButton Consultation10;
    private javax.swing.JButton Consultation11;
    private javax.swing.JButton Consultation12;
    private javax.swing.JButton Consultation13;
    private javax.swing.JButton Consultation14;
    private javax.swing.JButton Consultation15;
    private javax.swing.JButton Consultation16;
    private javax.swing.JButton Consultation17;
    private javax.swing.JButton Consultation2;
    private javax.swing.JButton Consultation3;
    private javax.swing.JButton Consultation4;
    private javax.swing.JButton Consultation5;
    private javax.swing.JButton Consultation6;
    private javax.swing.JButton Consultation7;
    private javax.swing.JButton Consultation8;
    private javax.swing.JButton Consultation9;
    private javax.swing.JButton Diagnosis;
    private javax.swing.JButton Diagnosis1;
    private javax.swing.JButton DrugPrescription;
    private javax.swing.JButton DrugPrescription1;
    private javax.swing.JTextField GENDER;
    private javax.swing.JTextField GENDER1;
    private javax.swing.JTextField ID;
    private javax.swing.JTextField ID1;
    public static javax.swing.JTextField IQuantity;
    public static javax.swing.JTextField Inpatient;
    private javax.swing.JComboBox Item_Name1;
    private javax.swing.JPanel LABORATORY_PANEL;
    private com.toedter.calendar.JDateChooser LMP;
    public static javax.swing.JTextField Medicine_Type;
    private javax.swing.JTextField NAME;
    private javax.swing.JTextField NAME1;
    private javax.swing.JPasswordField Pass;
    private javax.swing.JTextField Price;
    private javax.swing.JDialog Q;
    private javax.swing.JTable Request;
    public static javax.swing.JTextField Request_Name;
    public static javax.swing.JTextField Requestor;
    private javax.swing.JButton Surgery;
    private javax.swing.JButton Surgery1;
    private javax.swing.JButton Treatment;
    private javax.swing.JButton Treatment1;
    private javax.swing.JDialog UpdateConsultation;
    private javax.swing.JComboBox Urgent;
    private javax.swing.JTextField aa;
    private javax.swing.JTextField aa1;
    private javax.swing.JButton add;
    private javax.swing.JButton add1;
    private javax.swing.JPanel allergy1;
    private javax.swing.JPanel allergy2;
    private javax.swing.JTable available;
    private com.toedter.calendar.JDateChooser bday6;
    private javax.swing.JTextField c;
    private javax.swing.JComboBox<String> cb;
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JComboBox<String> cb2;
    private javax.swing.JComboBox<String> cb3;
    private rojerusan.RSComboMetro cbFilter;
    private rojerusan.RSComboMetro cbFilter1;
    private rojerusan.RSComboMetro cbFilter2;
    private rojerusan.RSComboMetro cbFilter3;
    private rojerusan.RSComboMetro cbFilter4;
    private rojerusan.RSComboMetro cbFilter5;
    private rojerusan.RSComboMetro cbFilter6;
    private rojerusan.RSComboMetro cbFilter7;
    private rojerusan.RSComboMetro cbFilter8;
    private rojerusan.RSComboMetro cbFilter9;
    private javax.swing.JPanel clinicalfinding;
    private javax.swing.JLabel date_dayv2;
    private javax.swing.JLabel date_dayv3;
    private javax.swing.JPanel diagnosis;
    private javax.swing.JPanel diagnosis1;
    private javax.swing.JPanel diagnosis10;
    private javax.swing.JPanel diagnosis2;
    private javax.swing.JPanel diagnosis3;
    private javax.swing.JPanel diagnosis4;
    private javax.swing.JPanel diagnosis5;
    private javax.swing.JPanel diagnosis6;
    private javax.swing.JPanel diagnosis7;
    private javax.swing.JPanel diagnosis8;
    private javax.swing.JPanel diagnosis9;
    private javax.swing.JTextArea e;
    private javax.swing.JTextArea e1;
    private javax.swing.JTextField ee;
    private javax.swing.JTextField ee1;
    private rojerusan.RSMaterialButtonRound fillAll;
    private rojerusan.RSMaterialButtonRound fillAll1;
    private rojerusan.RSMaterialButtonRound fillAll11;
    private rojerusan.RSMaterialButtonRound fillAll2;
    private rojerusan.RSMaterialButtonRound fillAll3;
    private rojerusan.RSMaterialButtonRound fillAll4;
    private rojerusan.RSMaterialButtonRound fillAll5;
    private rojerusan.RSMaterialButtonRound fillAll6;
    private rojerusan.RSMaterialButtonRound fillAll7;
    private rojerusan.RSMaterialButtonRound fillAll8;
    private rojerusan.RSMaterialButtonRound fillAll9;
    private javax.swing.JTextArea i;
    private javax.swing.JTextArea i1;
    private javax.swing.JTextField ii;
    private javax.swing.JTextField ii1;
    private javax.swing.JLabel imageHolder;
    private javax.swing.JLabel imageHolder1;
    private javax.swing.JTextArea insert;
    private javax.swing.JTextArea insert1;
    private javax.swing.JTextArea insert2;
    private javax.swing.JTextArea insert3;
    private javax.swing.JTextArea insert4;
    private javax.swing.JTextArea insert5;
    private javax.swing.JTextArea insert6;
    private javax.swing.JTextArea insert7;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox21;
    private javax.swing.JCheckBox jCheckBox22;
    private javax.swing.JCheckBox jCheckBox23;
    private javax.swing.JCheckBox jCheckBox24;
    private javax.swing.JCheckBox jCheckBox25;
    private javax.swing.JCheckBox jCheckBox26;
    private javax.swing.JCheckBox jCheckBox27;
    private javax.swing.JCheckBox jCheckBox28;
    private javax.swing.JCheckBox jCheckBox29;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox30;
    private javax.swing.JCheckBox jCheckBox31;
    private javax.swing.JCheckBox jCheckBox32;
    private javax.swing.JCheckBox jCheckBox33;
    private javax.swing.JCheckBox jCheckBox34;
    private javax.swing.JCheckBox jCheckBox35;
    private javax.swing.JCheckBox jCheckBox36;
    private javax.swing.JCheckBox jCheckBox37;
    private javax.swing.JCheckBox jCheckBox38;
    private javax.swing.JCheckBox jCheckBox39;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox40;
    private javax.swing.JCheckBox jCheckBox41;
    private javax.swing.JCheckBox jCheckBox42;
    private javax.swing.JCheckBox jCheckBox43;
    private javax.swing.JCheckBox jCheckBox46;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane32;
    private javax.swing.JScrollPane jScrollPane33;
    private javax.swing.JScrollPane jScrollPane34;
    private javax.swing.JScrollPane jScrollPane35;
    private javax.swing.JScrollPane jScrollPane36;
    private javax.swing.JScrollPane jScrollPane37;
    private javax.swing.JScrollPane jScrollPane38;
    private javax.swing.JScrollPane jScrollPane39;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane40;
    private javax.swing.JScrollPane jScrollPane41;
    private javax.swing.JScrollPane jScrollPane42;
    private javax.swing.JScrollPane jScrollPane43;
    private javax.swing.JScrollPane jScrollPane44;
    private javax.swing.JScrollPane jScrollPane45;
    private javax.swing.JScrollPane jScrollPane46;
    private javax.swing.JScrollPane jScrollPane47;
    private javax.swing.JScrollPane jScrollPane48;
    private javax.swing.JScrollPane jScrollPane49;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane50;
    private javax.swing.JScrollPane jScrollPane51;
    private javax.swing.JScrollPane jScrollPane52;
    private javax.swing.JScrollPane jScrollPane53;
    private javax.swing.JScrollPane jScrollPane54;
    private javax.swing.JScrollPane jScrollPane55;
    private javax.swing.JScrollPane jScrollPane56;
    private javax.swing.JScrollPane jScrollPane57;
    private javax.swing.JScrollPane jScrollPane58;
    private javax.swing.JScrollPane jScrollPane59;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane60;
    private javax.swing.JScrollPane jScrollPane63;
    private javax.swing.JScrollPane jScrollPane64;
    private javax.swing.JScrollPane jScrollPane65;
    private javax.swing.JScrollPane jScrollPane66;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTabbedPane jTabbedPane8;
    private javax.swing.JTabbedPane jTabbedPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable11;
    private javax.swing.JTable jTable12;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextArea jTextArea8;
    private javax.swing.JTextArea jTextArea9;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JButton labBtn;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField lname1;
    private javax.swing.JTextField lname2;
    private javax.swing.JTextField lname3;
    private javax.swing.JTextField lname4;
    private javax.swing.JTextField lname5;
    private javax.swing.JTextField lname6;
    private javax.swing.JTextField lname7;
    private javax.swing.JTextField lname8;
    private javax.swing.JLabel name;
    private javax.swing.JLabel name1;
    private javax.swing.JLabel note;
    private javax.swing.JTextArea o;
    private javax.swing.JTextArea o1;
    private javax.swing.JTextField oo;
    private javax.swing.JTextField oo1;
    private javax.swing.JPanel paraclinicalfinding;
    private javax.swing.JPanel paraclinicalfinding1;
    private javax.swing.JPanel paraclinicalfinding2;
    private javax.swing.JTextField pp;
    private javax.swing.JTextField pp1;
    private javax.swing.JTextArea q;
    private javax.swing.JTextArea q1;
    private javax.swing.JTextField qq;
    private javax.swing.JTextField qq1;
    private javax.swing.JTable qqqq;
    private javax.swing.JTextArea r;
    private javax.swing.JTextArea r1;
    private javax.swing.JLabel room10;
    private javax.swing.JLabel room11;
    private javax.swing.JLabel room12;
    private javax.swing.JLabel room13;
    private javax.swing.JLabel room14;
    private javax.swing.JLabel room15;
    private javax.swing.JLabel room16;
    private javax.swing.JLabel room17;
    private javax.swing.JLabel room18;
    private javax.swing.JLabel room19;
    private javax.swing.JLabel room2;
    private javax.swing.JLabel room20;
    private javax.swing.JLabel room3;
    private javax.swing.JLabel room4;
    private javax.swing.JLabel room5;
    private javax.swing.JLabel room6;
    private javax.swing.JLabel room7;
    private javax.swing.JLabel room8;
    private javax.swing.JLabel room9;
    private javax.swing.JTextField rr;
    private javax.swing.JTextField rr1;
    private javax.swing.JTextField search;
    private javax.swing.JTextField search1;
    private javax.swing.JTextField search10;
    private javax.swing.JTextField search11;
    private javax.swing.JTextField search12;
    private javax.swing.JTextField search13;
    private javax.swing.JTextField search14;
    private javax.swing.JTextField search15;
    private javax.swing.JTextField search16;
    private javax.swing.JTextField search17;
    private javax.swing.JTextField search18;
    private javax.swing.JTextField search19;
    private javax.swing.JTextField search2;
    private javax.swing.JTextField search20;
    private javax.swing.JTextField search21;
    private javax.swing.JTextField search22;
    private javax.swing.JTextField search23;
    private javax.swing.JTextField search24;
    private javax.swing.JTextField search25;
    private javax.swing.JTextField search26;
    private javax.swing.JTextField search27;
    private javax.swing.JTextField search28;
    private javax.swing.JTextField search29;
    private javax.swing.JTextField search3;
    private javax.swing.JTextField search30;
    private javax.swing.JTextField search31;
    private javax.swing.JTextField search32;
    private javax.swing.JTextField search4;
    private javax.swing.JTextField search5;
    private javax.swing.JTextField search6;
    private javax.swing.JTextField search7;
    private javax.swing.JTextField search8;
    private javax.swing.JTextField search9;
    private javax.swing.JTextField ss;
    private javax.swing.JTextField ss1;
    private javax.swing.JButton sub_module_1_btn1;
    private javax.swing.JButton sub_module_1_btn10;
    private javax.swing.JButton sub_module_1_btn11;
    private javax.swing.JButton sub_module_1_btn2;
    private javax.swing.JButton sub_module_1_btn3;
    private javax.swing.JButton sub_module_1_btn4;
    private javax.swing.JButton sub_module_1_btn5;
    private javax.swing.JButton sub_module_1_btn7;
    private javax.swing.JButton sub_module_1_btn8;
    private javax.swing.JButton sub_module_1_btn9;
    private javax.swing.JTextArea t;
    private javax.swing.JTextArea t1;
    private javax.swing.JTable tbl_allergies;
    private javax.swing.JTable tbl_allergies1;
    private javax.swing.JTable tbl_allergy;
    private javax.swing.JTable tbl_allergy1;
    private javax.swing.JTable tbl_clinical;
    private javax.swing.JTable tbl_clinical1;
    private javax.swing.JTable tbl_consultation;
    private javax.swing.JTable tbl_consultation1;
    private javax.swing.JTable tbl_consultation2;
    private javax.swing.JTable tbl_consultation3;
    private javax.swing.JTable tbl_consultation4;
    private javax.swing.JTable tbl_consultation5;
    private javax.swing.JTable tbl_diagnosis;
    private javax.swing.JTable tbl_diagnosis1;
    private javax.swing.JTable tbl_medication;
    private javax.swing.JTable tbl_medication1;
    private javax.swing.JTable tbl_surgeries;
    private javax.swing.JTable tbl_surgeries1;
    private javax.swing.JTable tbl_treatment;
    private javax.swing.JTable tbl_treatment1;
    private javax.swing.JTextField title;
    private javax.swing.JTextField title1;
    private javax.swing.JTextField title2;
    private javax.swing.JPanel treatment;
    private javax.swing.JTextField tt;
    private javax.swing.JTextField tt1;
    public static javax.swing.JTextField txt_c_id;
    public static javax.swing.JTextField txt_day;
    private javax.swing.JTextField txt_dr_ln;
    private javax.swing.JTextField txt_item;
    private javax.swing.JTextField txt_item1;
    private javax.swing.JTextArea u;
    private javax.swing.JTextArea u1;
    private javax.swing.JTextField uu;
    private javax.swing.JTextField uu1;
    private javax.swing.JTextField v;
    private javax.swing.JTextArea w;
    private javax.swing.JTextArea w1;
    private javax.swing.JTextField ww;
    private javax.swing.JTextField ww1;
    private javax.swing.JTextField x;
    private javax.swing.JTextField yy;
    private javax.swing.JTextField yy1;
    private javax.swing.JTextField z;
    // End of variables declaration//GEN-END:variables
private ImageIcon format = null;
    String filename = null;
    int s = 0;
    byte[] person_image = null;
}
