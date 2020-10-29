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
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showConfirmDialog;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ivy tromata
 */
public class Ward extends javax.swing.JPanel {

    GridBagLayout layout = new GridBagLayout();
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    CallableStatement cst = null;
    Statement st;

//WardRoom2 p2;
//WardRoom3 p3;
//WardRoom4 p4;
//WardRoom5 p5;
    /**
     * Creates new form Ward
     */
    public Ward() {
        initComponents();
        conn = MysqlConnect.ConnectDB();
        one();
        two();
        three();
        four();
        five();
//BindCombo();
        view();
//Clinical();

        ward.setVisible(false);
        RoomID.setVisible(false);
        beed.setVisible(false);
        CurrentDate();

        dokid.setVisible(false);
        date_dayv2.setVisible(false);
        WARD.setVisible(false);
        bed.setVisible(false);
//discharge
        rate.setVisible(false);
        Admission.setVisible(false);
        roomid.setVisible(false);

        drid.setVisible(false);
    }

    public void one() {
        try {
            String q = "select Distinct Core1_bm_rooms.id as 'No.',Core1_bm_roomroom.RoomName as Room,Core1_bm_rooms.Bed_No as Bed,concat(Core1_pr_PatientRegistration.LastName,', ',Core1_pr_PatientRegistration.FirstName,' ',Core1_pr_PatientRegistration.MiddleName) as Name, Core1_bm_rooms.bed_status as Availability\n"
                    + "from Core1_bm_roomroom\n"
                    + "inner join Core1_bm_rooms\n"
                    + "on Core1_bm_roomroom.Roomlegitid=Core1_bm_rooms.Room_ID\n"
                    + "left join Core1_pr_PatientRegistration\n"
                    + "on Core1_bm_rooms.Patient_ID=Core1_pr_PatientRegistration.Patient_ID\n"
                    + "where Core1_bm_rooms.Room_type='Ward' and Core1_bm_roomroom.Roomlegitid='32000'";

            pst = conn.prepareStatement(q);

            rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    public void two() {
        try {
            String q = "select Distinct Core1_bm_rooms.id as 'No.',Core1_bm_roomroom.RoomName as Room,Core1_bm_rooms.Bed_No as Bed,concat(Core1_pr_PatientRegistration.LastName,', ',Core1_pr_PatientRegistration.FirstName,' ',Core1_pr_PatientRegistration.MiddleName) as Name, Core1_bm_rooms.bed_status as Availability\n"
                    + "from Core1_bm_roomroom\n"
                    + "inner join Core1_bm_rooms\n"
                    + "on Core1_bm_roomroom.Roomlegitid=Core1_bm_rooms.Room_ID\n"
                    + "left join Core1_pr_PatientRegistration\n"
                    + "on Core1_bm_rooms.Patient_ID=Core1_pr_PatientRegistration.Patient_ID\n"
                    + "where Core1_bm_rooms.Room_type='Ward' and Core1_bm_roomroom.Roomlegitid='32001'";

            pst = conn.prepareStatement(q);

            rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    public void three() {
        try {
            String q = "select Distinct Core1_bm_rooms.id as 'No.',Core1_bm_roomroom.RoomName as Room,Core1_bm_rooms.Bed_No as Bed,concat(Core1_pr_PatientRegistration.LastName,', ',Core1_pr_PatientRegistration.FirstName,' ',Core1_pr_PatientRegistration.MiddleName) as Name, Core1_bm_rooms.bed_status as Availability\n"
                    + "from Core1_bm_roomroom\n"
                    + "inner join Core1_bm_rooms\n"
                    + "on Core1_bm_roomroom.Roomlegitid=Core1_bm_rooms.Room_ID\n"
                    + "left join Core1_pr_PatientRegistration\n"
                    + "on Core1_bm_rooms.Patient_ID=Core1_pr_PatientRegistration.Patient_ID\n"
                    + "where Core1_bm_rooms.Room_type='Ward' and Core1_bm_roomroom.Roomlegitid='32002'";

            pst = conn.prepareStatement(q);

            rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    public void four() {
        try {
            String q = "select Distinct Core1_bm_rooms.id as 'No.',Core1_bm_roomroom.RoomName as Room,Core1_bm_rooms.Bed_No as Bed,concat(Core1_pr_PatientRegistration.LastName,', ',Core1_pr_PatientRegistration.FirstName,' ',Core1_pr_PatientRegistration.MiddleName) as Name, Core1_bm_rooms.bed_status as Availability\n"
                    + "from Core1_bm_roomroom\n"
                    + "inner join Core1_bm_rooms\n"
                    + "on Core1_bm_roomroom.Roomlegitid=Core1_bm_rooms.Room_ID\n"
                    + "left join Core1_pr_PatientRegistration\n"
                    + "on Core1_bm_rooms.Patient_ID=Core1_pr_PatientRegistration.Patient_ID\n"
                    + "where Core1_bm_rooms.Room_type='Ward' and Core1_bm_roomroom.Roomlegitid='32003'";

            pst = conn.prepareStatement(q);

            rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    public void five() {
        try {
            String q = "select Distinct Core1_bm_rooms.id as 'No.',Core1_bm_roomroom.RoomName as Room,Core1_bm_rooms.Bed_No as Bed,concat(Core1_pr_PatientRegistration.LastName,', ',Core1_pr_PatientRegistration.FirstName,' ',Core1_pr_PatientRegistration.MiddleName) as Name, Core1_bm_rooms.bed_status as Availability\n"
                    + "from Core1_bm_roomroom\n"
                    + "inner join Core1_bm_rooms\n"
                    + "on Core1_bm_roomroom.Roomlegitid=Core1_bm_rooms.Room_ID\n"
                    + "left join Core1_pr_PatientRegistration\n"
                    + "on Core1_bm_rooms.Patient_ID=Core1_pr_PatientRegistration.Patient_ID\n"
                    + "where Core1_bm_rooms.Room_type='Ward' and Core1_bm_roomroom.Roomlegitid='32004'";

            pst = conn.prepareStatement(q);

            rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }
//    public void comboselect(){
//    int tmp =rooms.getSelectedIndex();
//        if(tmp==0){
//        one();
//        }
//        if(tmp==1){
//         two();
//        } 
//        if(tmp==2){
//           three();
//        } 
//        if(tmp==3){
//         four();
//        }
//        if(tmp==4){
//           five();
//        } 
//}            

    private void view() {

        try {

            String sql = "select Distinct Core1_bm_rooms.id as 'No.',Core1_bm_roomroom.RoomName as Room,Core1_bm_rooms.Bed_No as Bed,concat(Core1_pr_PatientRegistration.LastName,', ',Core1_pr_PatientRegistration.FirstName,' ',Core1_pr_PatientRegistration.MiddleName) as Name, Core1_bm_rooms.bed_status as Availability\n"
                    + "from Core1_bm_roomroom\n"
                    + "inner join Core1_bm_rooms\n"
                    + "on Core1_bm_roomroom.Roomlegitid=Core1_bm_rooms.Room_ID\n"
                    + "left join Core1_pr_PatientRegistration\n"
                    + "on Core1_bm_rooms.Patient_ID=Core1_pr_PatientRegistration.Patient_ID\n"
                    + "where Core1_bm_rooms.Room_type='Ward' order by Core1_bm_rooms.id";
            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
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
        //dd.setText((buwan) + "/" + (day1) + "/" + year + " " + hour + ":" + mn + day_night);
    }

//public void BindCombo(){
//    MysqlConnect mq = new MysqlConnect();
//    HashMap<String, Integer> map = mq.populateCombo();
//    for(String s : map.keySet()){
//    rooms.addItem(s);
//}
//}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        patientverify = new javax.swing.JDialog();
        addpatient = new javax.swing.JPanel();
        search = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        dokid = new javax.swing.JLabel();
        gender = new javax.swing.JTextField();
        date_dayv2 = new javax.swing.JLabel();
        WARD = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        beed = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        room = new javax.swing.JLabel();
        bed = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        search3 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        search7 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Discharge = new javax.swing.JDialog();
        addpatient1 = new javax.swing.JPanel();
        search4 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        imageHolder = new javax.swing.JLabel();
        name1 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        room1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        search8 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        rate = new javax.swing.JLabel();
        roomid = new javax.swing.JLabel();
        Admission = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel32 = new javax.swing.JLabel();
        doc = new javax.swing.JTextField();
        drid = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        root1 = new javax.swing.JPanel();
        rooms = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable()
        {
            @Override

            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex)
            {
                Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);

                Object value = getModel().getValueAt(rowIndex,columnIndex);

                if(columnIndex == 4)
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
        jLabel4 = new javax.swing.JLabel();
        ward = new javax.swing.JLabel();
        RoomID = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        fillAll11 = new rojerusan.RSMaterialButtonRound();

        patientverify.setTitle("Admit Patient");
        patientverify.setBackground(new java.awt.Color(0, 0, 255));
        patientverify.setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);
        patientverify.setUndecorated(true);
        patientverify.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                patientverifyComponentResized(evt);
            }
        });
        patientverify.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                patientverifyKeyPressed(evt);
            }
        });
        patientverify.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addpatient.setBackground(new java.awt.Color(255, 255, 255));
        addpatient.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        addpatient.setPreferredSize(new java.awt.Dimension(380, 310));
        addpatient.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                addpatientAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        addpatient.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchKeyTyped(evt);
            }
        });
        addpatient.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 250, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("SAVE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });
        addpatient.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, 90, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        addpatient.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 240, 190));

        name.setEditable(false);
        name.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        addpatient.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 290, 30));

        dokid.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dokid.setText("doctor id");
        addpatient.add(dokid, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 70, 30));

        gender.setEditable(false);
        gender.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderActionPerformed(evt);
            }
        });
        addpatient.add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 290, 30));

        date_dayv2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        date_dayv2.setText("date");
        addpatient.add(date_dayv2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 70, 30));

        WARD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        WARD.setText("Ward");
        addpatient.add(WARD, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 70, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/search.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        addpatient.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 40, 30));

        beed.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        beed.setText("BED:");
        addpatient.add(beed, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 70, 30));

        jPanel4.setBackground(new java.awt.Color(51, 102, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        room.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        room.setText("ROOM:");
        jPanel4.add(room, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, 30));

        bed.setText("bed");
        jPanel4.add(bed, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 30, 30));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 30, 30));

        addpatient.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "REGULAR", "EMERGENCY" }));
        addpatient.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 250, 30));
        addpatient.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 410, 10));

        search3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
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
        addpatient.add(search3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 250, 30));

        jLabel27.setText("Doctor ID");
        addpatient.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 110, 30));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/search.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        addpatient.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 40, 30));

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
        addpatient.add(search7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 290, 30));

        jLabel28.setText("Dr. Name");
        addpatient.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 110, 30));
        addpatient.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 410, 10));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Patient Photo");
        addpatient.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 240, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Name");
        addpatient.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 70, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Gender");
        addpatient.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 70, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Type of IP:");
        addpatient.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 70, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Patient ID");
        addpatient.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 70, 30));

        patientverify.getContentPane().add(addpatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 330));

        Discharge.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Discharge.setUndecorated(true);

        addpatient1.setBackground(new java.awt.Color(255, 255, 255));
        addpatient1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        addpatient1.setPreferredSize(new java.awt.Dimension(380, 310));
        addpatient1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                addpatient1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        addpatient1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search4KeyTyped(evt);
            }
        });
        addpatient1.add(search4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 250, 30));

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton5.setText("Discharge");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton5KeyPressed(evt);
            }
        });
        addpatient1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 390, 90, 30));

        imageHolder.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        imageHolder.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        addpatient1.add(imageHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 240, 190));

        name1.setEditable(false);
        name1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        name1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name1ActionPerformed(evt);
            }
        });
        addpatient1.add(name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 290, 30));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/search.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        addpatient1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 40, 30));

        jPanel5.setBackground(new java.awt.Color(51, 102, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        room1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        room1.setText("DISCHARGE PATIENT");
        jPanel5.add(room1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, 30));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 30, 30));

        addpatient1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 30));
        addpatient1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 410, 10));

        search8.setEditable(false);
        search8.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
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
        addpatient1.add(search8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 290, 30));

        jLabel30.setText("Note");
        addpatient1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 70, 30));
        addpatient1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 410, 10));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Patient ID");
        addpatient1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 70, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Name");
        addpatient1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 70, 30));

        rate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rate.setText("rate");
        addpatient1.add(rate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 50, 30));

        roomid.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        roomid.setText("roomid");
        addpatient1.add(roomid, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 70, 30));

        Admission.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Admission.setText("admisiion");
        addpatient1.add(Admission, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 70, 30));

        jLabel31.setText("Doctor");
        addpatient1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 110, 30));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        addpatient1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 290, 140));

        jLabel32.setText("Location");
        addpatient1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 110, 30));

        doc.setEditable(false);
        addpatient1.add(doc, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 290, 30));

        drid.setText("drid");
        addpatient1.add(drid, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 70, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Patient Photo");
        addpatient1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 240, 30));

        Discharge.getContentPane().add(addpatient1, java.awt.BorderLayout.CENTER);

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        root1.setBackground(new java.awt.Color(51, 153, 255));
        root1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rooms.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rooms.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Room1", "Room2", "Room3", "Room4", "Room5" }));
        rooms.setToolTipText("Select Room");
        rooms.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rooms.setName(""); // NOI18N
        rooms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomsMouseClicked(evt);
            }
        });
        rooms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomsActionPerformed(evt);
            }
        });
        root1.add(rooms, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 250, 30));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        table.setToolTipText("Left Click to Add Patient in Available Bed");
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tableComponentAdded(evt);
            }
        });
        table.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tableAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
        }

        root1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 980, 520));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Select Room:");
        root1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 30));

        ward.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ward.setText("ward'");
        root1.add(ward, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 120, 30));

        RoomID.setText("jTextField1");
        RoomID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomIDActionPerformed(evt);
            }
        });
        root1.add(RoomID, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 130, 30));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Module4SubModules/icons8_Bed_25px.png"))); // NOI18N
        jButton3.setToolTipText("Select all Bed");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        root1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 30, 30));

        fillAll11.setText("Discharge");
        fillAll11.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        fillAll11.setMaximumSize(new java.awt.Dimension(82, 26));
        fillAll11.setMinimumSize(new java.awt.Dimension(82, 26));
        fillAll11.setPreferredSize(new java.awt.Dimension(88, 28));
        fillAll11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillAll11ActionPerformed(evt);
            }
        });
        root1.add(fillAll11, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 110, 40));

        add(root1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 580));
    }// </editor-fold>//GEN-END:initComponents

    private void roomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomsActionPerformed
        int tmp = rooms.getSelectedIndex();
        if (tmp == 0) {
            one();
        }
        if (tmp == 1) {
            two();
        }
        if (tmp == 2) {
            three();
        }
        if (tmp == 3) {
            four();
        }
        if (tmp == 4) {
            five();
        }
// TODO add your handling code here:
    }//GEN-LAST:event_roomsActionPerformed

    private void tableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tableAncestorAdded

        view();

        JTableHeader Theader = table.getTableHeader();

        Theader.setBackground(Color.WHITE);

        Theader.setFont(new Font("Arial", Font.BOLD, 11));

        // TODO add your handling code here:
    }//GEN-LAST:event_tableAncestorAdded

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            try {

                String sql = "select * from Core1_pr_PatientRegistration where Patient_ID=?";

                pst = conn.prepareStatement(sql);
                pst.setString(1, search.getText());
                rs = pst.executeQuery();

                if (rs.next()) {
                    try {
                        String sql1 = "select PR_Gender,concat (Lastname,', ',FirstName,' ',MiddleName) as Name,image from Core1_pr_PatientRegistration where Patient_ID=?";
                        pst = conn.prepareStatement(sql1);
                        pst.setString(1, search.getText());
                        rs = pst.executeQuery();
                        if (rs.next()) {
                            String add1 = rs.getString("Name");
                            name.setText(add1);
                            String add2 = rs.getString("PR_Gender");
                            gender.setText(add2);
                            byte[] img2 = rs.getBytes("image");
                            ImageIcon img3 = new ImageIcon(img2);
                            Image img = img3.getImage();
                            Image newImg = img.getScaledInstance(jLabel7.getWidth(), jLabel7.getHeight(), Image.SCALE_SMOOTH);
                            ImageIcon newImc = new ImageIcon(newImg);
                            jLabel7.setIcon(newImc);

                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                } else {
                    //    JOpjimmeltionPane.showMessageDialog(null, "Not a Patient","Search Patient",JOptionPane.ERROR_MESSAGE);
                    DesktopNotify.showDesktopMessage("Wrong Patient No.", "Right Patient",
                            DesktopNotify.FAIL, 8000);

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }        // TODO add your handling code here:
    }//GEN-LAST:event_searchKeyPressed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased

        // TODO add your handling code here:
    }//GEN-LAST:event_searchKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int h = showConfirmDialog(null, "Are you sure you want to Save?", " ", JOptionPane.YES_NO_OPTION);

        if (h == 0) {
            try {

                String sql = "select * from Core1_pr_PatientRegistration where Patient_ID=? and PR_Status='New Patient'";

                pst = conn.prepareStatement(sql);
                pst.setString(1, search.getText());
                rs = pst.executeQuery();

                if (rs.next()) {

                    try {

                        String sql1 = "insert into Core1_ipd_admission(Patient_ID,Name,Dr_ID,Room_Type,Type,admitdate,status,idroom)values(?,?,?,?,?,?,?,?)";

                        pst = conn.prepareStatement(sql1);
                        pst.setString(1, search.getText());
                        pst.setString(2, name.getText());
                        pst.setString(3, search3.getText());
                        pst.setString(4, WARD.getText());
                        String value1 = jComboBox1.getSelectedItem().toString();
                        pst.setString(5, value1);
                        pst.setString(6, date_dayv2.getText());
                        pst.setString(7, "Inpatient");
                        pst.setString(8, bed.getText());

                        pst.execute();

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }        // TODO add your handling code here:
                    try {

                        String sql1 = "insert into Core1_bm_roomshistory(Room_ID,Patient_ID,Doctor_ID,date_used,status)values(?,?,?,?,?)";

                        pst = conn.prepareStatement(sql1);
                        pst.setString(1, bed.getText());
                        pst.setString(2, search.getText());
                        pst.setString(3, search3.getText());
                        pst.setString(4, date_dayv2.getText());
                        pst.setString(5, "Inpatient");

                        pst.execute();

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }        // TODO add your handling code here:
                    try {

                        String sql2 = "insert into Core1_PR_Overview(Patient_ID,name,gender,date_undergo,patient_type)values(?,?,?,?,?)";

                        pst = conn.prepareStatement(sql2);
                        pst.setString(1, search.getText());
                        pst.setString(2, name.getText());
                        pst.setString(3, gender.getText());
                        pst.setString(4, date_dayv2.getText());
                        pst.setString(5, "Inpatient");

                        pst.execute();

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }        // TODO add your handling code here:
                    try {

                        String value2 = search.getText();

                        String sql3 = "update Core1_pr_PatientRegistration set PR_Status='Inpatient' where Patient_ID='" + value2 + "'";

                        pst = conn.prepareStatement(sql3);
                        pst.execute();

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                    try {

                        String value1 = bed.getText();
                        String value2 = search.getText();
                        String value3 = date_dayv2.getText();
                        String sql3 = "update Core1_bm_rooms set date_occopied='" + value3 + "',bed_status='Occupied',bed_remarks='Inpatient',Patient_ID='" + value2 + "' where id='" + value1 + "'";

                        pst = conn.prepareStatement(sql3);

                        pst.execute();
                        search.setText("");
                        name.setText("");
                        gender.setText("");

                        patientverify.setVisible(false);
                        search.setText("");
                        name.setText("");
                        name.setText("");
                        gender.setText("");

                        //     JOptionPane.showMessageDialog(null, "The Patient are now Admitted");
                        DesktopNotify.showDesktopMessage("Success Admission", "The Patient are now Admitted",
                                DesktopNotify.SUCCESS, 8000);

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                } else {
                    //   JOptionPane.showMessageDialog(null, "This Patient is Admitted Already","Error Admission",JOptionPane.ERROR_MESSAGE);

                    DesktopNotify.showDesktopMessage("Error Admission", "This Patient is Admitted Already",
                            DesktopNotify.FAIL, 8000);
                    patientverify.setVisible(true);

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

            // TODO add your handling code here:
        }

        if (h == 1) {

        }

        view();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed

    }//GEN-LAST:event_jButton2KeyPressed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {

            String sql = "select * from Core1_pr_PatientRegistration where Patient_ID=?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, search.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                try {
                    String sql1 = "select PR_Gender,concat (Lastname,', ',FirstName,' ',MiddleName) as Name from Core1_pr_PatientRegistration where Patient_ID=?";
                    pst = conn.prepareStatement(sql1);
                    pst.setString(1, search.getText());
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String add1 = rs.getString("Name");
                        name.setText(add1);
                        String add2 = rs.getString("PR_Gender");
                        gender.setText(add2);
                        byte[] img2 = rs.getBytes("image");
                        ImageIcon img3 = new ImageIcon(img2);
                        Image img = img3.getImage();
                        Image newImg = img.getScaledInstance(jLabel7.getWidth(), jLabel7.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon newImc = new ImageIcon(newImg);
                        jLabel7.setIcon(newImc);

                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            } else {
                //JOptionPane.showMessageDialog(null, "Not a Patient","Search Patient",JOptionPane.ERROR_MESSAGE);
                DesktopNotify.showDesktopMessage("Wrong Patient No.", "Right Patient",
                        DesktopNotify.FAIL, 8000);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addpatientAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_addpatientAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_addpatientAncestorAdded

    private void patientverifyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_patientverifyKeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_patientverifyKeyPressed

    private void roomsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_roomsMouseClicked

    private void tableComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tableComponentAdded
        // TODO add your handling code here: 
    }//GEN-LAST:event_tableComponentAdded

    private void patientverifyComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_patientverifyComponentResized
// TODO add your handling code here:
    }//GEN-LAST:event_patientverifyComponentResized

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int h = showConfirmDialog(null, "Add Patient to Admit ?", "Admission", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            int row = table.getSelectedRow();
            String Table_click = (table.getModel().getValueAt(row, 0).toString());
            try {
                String sql = "select Core1_bm_rooms.id as ID,concat(Core1_bm_roomroom.RoomName,'-',Core1_bm_rooms.Bed_No) as Room from Core1_bm_roomroom inner join Core1_bm_rooms on Core1_bm_roomroom.Roomlegitid=Core1_bm_rooms.Room_ID left join Core1_pr_PatientRegistration on Core1_bm_rooms.Patient_ID=Core1_pr_PatientRegistration.Patient_ID where Core1_bm_rooms.Room_type='Ward' and Core1_bm_rooms.id='" + Table_click + "'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    String add = rs.getString("Room");
                    room.setText(add);
                    String add1 = rs.getString("ID");
                    bed.setText(add1);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            try {

                String sql = "select * from Core1_bm_rooms where id=? and bed_status='Available'";

                pst = conn.prepareStatement(sql);
                pst.setString(1, bed.getText());
                rs = pst.executeQuery();

                if (rs.next()) {
                    patientverify.setVisible(true);
                    patientverify.setSize(681, 330);
                    patientverify.setLocationRelativeTo(null);

                } else {
//               JOptionPane.showMessageDialog(null, "This B"
//                       + "ed is Occupied","Occupied",JOptionPane.ERROR_MESSAGE);
                    DesktopNotify.showDesktopMessage("This Bed is Occupied", "Other bed",
                            DesktopNotify.ERROR, 8000);

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        if (h == 1) {

        }

// TODO add your handling code here:
    }//GEN-LAST:event_tableMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        int h = showConfirmDialog(null, "Do you want to Close Admission?", "Admission", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            patientverify.setVisible(false);
            search.setText("");
            name.setText("");
            gender.setText("");
            search3.setText("");
            search7.setText("");
        }
        if (h == 1) {

        }        // TODO add your handling code here:     // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyTyped
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
    }//GEN-LAST:event_searchKeyTyped

    private void RoomIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RoomIDActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        view();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
                    //JOptionPane.showMessageDialog(null, "Not a Doctor","Search Doctor",JOptionPane.ERROR_MESSAGE);
                    DesktopNotify.showDesktopMessage("Not a Doctor", "Search Doctor",
                            DesktopNotify.FAIL, 8000);
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
                // JOptionPane.showMessageDialog(null, "Not a Doctor","Search Doctor",JOptionPane.ERROR_MESSAGE);
                DesktopNotify.showDesktopMessage("Not a Doctor", "Search Doctor",
                        DesktopNotify.FAIL, 8000);
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

    private void search3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search3KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            evt.consume();

        }
        if (search3.getText().length() == 15) {
            JOptionPane.showMessageDialog(null, "Maximum Reach", null, JOptionPane.ERROR_MESSAGE);
            evt.consume();
        }
        char num = evt.getKeyChar();
        if (!Character.isDigit(num)) {
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_search3KeyTyped

    private void search4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search4ActionPerformed

    private void search4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search4KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {

                String sql = "select * from Core1_pr_PatientRegistration where Patient_ID=? and PR_Status='Inpatient'";

                pst = conn.prepareStatement(sql);
                pst.setString(1, search4.getText());
                rs = pst.executeQuery();

                if (rs.next()) {
                    try {
                        String sql1 = "select\n"
                                + "Core1_bm_rooms.id as ROOMID,\n"
                                + "Core1_ipd_admission.Ipd_ID as IPDID,\n"
                                + "concat(Core1_pr_PatientRegistration.LastName,', ',Core1_pr_PatientRegistration.FirstName,' ',Core1_pr_PatientRegistration.MiddleName) as Name,Core1_pr_PatientRegistration.image,\n"
                                + "concat (Core1_dra_registered.surname,', ',Core1_dra_registered.name,' ',Core1_dra_registered.middlename,'   -   ',Core1_dra_registered.specialization) as Doctor,\n"
                                + "Core1_dra_registered.Dr_ID as drid,\n"
                                + "concat(Core1_bm_rooms.Room_type,'-',Core1_bm_roomroom.RoomName,'-',Core1_bm_rooms.Bed_No) as Title,\n"
                                + "Core1_bm_rooms.rate as Rate\n"
                                + "from Core1_bm_roomroom\n"
                                + "inner join Core1_bm_rooms\n"
                                + "on Core1_bm_roomroom.Roomlegitid=Core1_bm_rooms.Room_ID\n"
                                + "left join Core1_pr_PatientRegistration\n"
                                + "on Core1_bm_rooms.Patient_ID=Core1_pr_PatientRegistration.Patient_ID\n"
                                + "inner join Core1_ipd_admission\n"
                                + "on Core1_ipd_admission.Patient_ID=Core1_pr_PatientRegistration.Patient_ID\n"
                                + "inner join Core1_dra_registered\n"
                                + "on Core1_dra_registered.Dr_ID=Core1_ipd_admission.Dr_ID\n"
                                + "where Core1_pr_PatientRegistration.Patient_ID=? and Core1_bm_rooms.Room_type='Ward' and Core1_ipd_admission.status='Inpatient' and Core1_pr_PatientRegistration.PR_Status='Inpatient'";
                        pst = conn.prepareStatement(sql1);
                        pst.setString(1, search4.getText());
                        rs = pst.executeQuery();
                        if (rs.next()) {
                            String add1 = rs.getString("Name");
                            name1.setText(add1);
                            String add2 = rs.getString("Title");
                            search8.setText(add2);
                            String add3 = rs.getString("Rate");
                            rate.setText(add3);
                            String add22 = rs.getString("ROOMID");
                            roomid.setText(add22);
                            String add33 = rs.getString("IPDID");
                            Admission.setText(add33);
                            String add331 = rs.getString("Doctor");
                            doc.setText(add331);
                            String add3311 = rs.getString("drid");
                            drid.setText(add3311);
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
                    //    JOpjimmeltionPane.showMessageDialog(null, "Not a Patient","Search Patient",JOptionPane.ERROR_MESSAGE);
                    DesktopNotify.showDesktopMessage("Not a Inpatient to Discharge", "Discharge",
                            DesktopNotify.FAIL, 8000);

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_search4KeyPressed

    private void search4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search4KeyReleased

    private void search4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search4KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            evt.consume();

        }
        if (search4.getText().length() == 15) {
            JOptionPane.showMessageDialog(null, "Maximum Reach", null, JOptionPane.ERROR_MESSAGE);
            evt.consume();
        }
        char num = evt.getKeyChar();
        if (!Character.isDigit(num)) {
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_search4KeyTyped

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        int h = showConfirmDialog(null, "Are you sure you want to Discharge this Patient?", " ", JOptionPane.YES_NO_OPTION);

        if (h == 0) {
            try {

                String sql = "select * from Core1_pr_PatientRegistration where Patient_ID=? and PR_Status='Inpatient'";

                pst = conn.prepareStatement(sql);
                pst.setString(1, search4.getText());
                rs = pst.executeQuery();

                if (rs.next()) {
//1
                    try {

                        String sql1 = "insert into Core1_ipd_Discharge(Patient_ID,Title,Amount,DateReq,Status,Note,Doctor_ID)values(?,?,?,?,?,?,?)";

                        pst = conn.prepareStatement(sql1);
                        pst.setString(1, search4.getText());
                        pst.setString(2, search8.getText());
                        pst.setString(3, rate.getText());
                        pst.setString(4, date_dayv2.getText());
                        pst.setString(5, "Discharged");
                        pst.setString(6, jTextArea1.getText());
                        pst.setString(7, drid.getText());
                        pst.execute();

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
//2
                    try {

                        String value1 = "Discharge Succesful";
                        String value2 = "For Cleaning";
                        String id = roomid.getText();

                        String sql3 = "update Core1_bm_rooms set Patient_ID='',bed_status='" + value2 + "',bed_remarks='" + value1 + "' where id='" + id + "'";

                        pst = conn.prepareStatement(sql3);
                        pst.execute();

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
//3
                    try {

                        String date = date_dayv2.getText();
                        String id = Admission.getText();

                        String sql3 = "update Core1_ipd_admission set Dischargedate='" + date + "',status='Discharge' where Ipd_ID='" + id + "' and status='Inpatient'";

                        pst = conn.prepareStatement(sql3);
                        pst.execute();

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
//4
                    try {

                        String id = search4.getText();
                        String status = "New Patient";
                        String sql3 = "update Core1_pr_PatientRegistration set PR_Status='" + status + "' where Patient_ID='" + id + "'";

                        pst = conn.prepareStatement(sql3);

                        pst.execute();
                        search.setText("");
                        name.setText("");
                        gender.setText("");

                        Discharge.setVisible(false);
                        search4.setText("");
                        name1.setText("");
                        search8.setText("");
                        rate.setText("");
                        doc.setText("");

                        //     JOptionPane.showMessageDialog(null, "The Patient are now Admitted");
                        DesktopNotify.showDesktopMessage("Success Discharging", "The Patient are Discharged",
                                DesktopNotify.SUCCESS, 8000);

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                } else {
                    //   JOptionPane.showMessageDialog(null, "This Patient is Admitted Already","Error Admission",JOptionPane.ERROR_MESSAGE);

                    DesktopNotify.showDesktopMessage("Error Admission", "This Patient is Not Admitted",
                            DesktopNotify.FAIL, 8000);
                    patientverify.setVisible(true);

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

            // TODO add your handling code here:
        }

        if (h == 1) {

        }
        view();// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5KeyPressed

    private void name1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {

            String sql = "select * from Core1_pr_PatientRegistration where Patient_ID=? and PR_Status='Inpatient'";

            pst = conn.prepareStatement(sql);
            pst.setString(1, search4.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                try {
                    String sql1 = "select\n"
                            + "Core1_bm_rooms.id as ROOMID,\n"
                            + "Core1_ipd_admission.Ipd_ID as IPDID,\n"
                            + "concat(Core1_pr_PatientRegistration.LastName,', ',Core1_pr_PatientRegistration.FirstName,' ',Core1_pr_PatientRegistration.MiddleName) as Name,Core1_pr_PatientRegistration.image,\n"
                            + "concat (Core1_dra_registered.surname,', ',Core1_dra_registered.name,' ',Core1_dra_registered.middlename,'   -   ',Core1_dra_registered.specialization) as Doctor,\n"
                            + "Core1_dra_registered.Dr_ID as drid,\n"
                            + "concat(Core1_bm_rooms.Room_type,'-',Core1_bm_roomroom.RoomName,'-',Core1_bm_rooms.Bed_No) as Title,\n"
                            + "Core1_bm_rooms.rate as Rate\n"
                            + "from Core1_bm_roomroom\n"
                            + "inner join Core1_bm_rooms\n"
                            + "on Core1_bm_roomroom.Roomlegitid=Core1_bm_rooms.Room_ID\n"
                            + "left join Core1_pr_PatientRegistration\n"
                            + "on Core1_bm_rooms.Patient_ID=Core1_pr_PatientRegistration.Patient_ID\n"
                            + "inner join Core1_ipd_admission\n"
                            + "on Core1_ipd_admission.Patient_ID=Core1_pr_PatientRegistration.Patient_ID\n"
                            + "inner join Core1_dra_registered\n"
                            + "on Core1_dra_registered.Dr_ID=Core1_ipd_admission.Dr_ID\n"
                            + "where Core1_pr_PatientRegistration.Patient_ID=? and Core1_bm_rooms.Room_type='Ward' and Core1_ipd_admission.status='Inpatient' and Core1_pr_PatientRegistration.PR_Status='Inpatient'";
                    pst = conn.prepareStatement(sql1);
                    pst.setString(1, search4.getText());
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String add1 = rs.getString("Name");
                        name1.setText(add1);
                        String add2 = rs.getString("Title");
                        search8.setText(add2);
                        String add3 = rs.getString("Rate");
                        rate.setText(add3);
                        String add22 = rs.getString("ROOMID");
                        roomid.setText(add22);
                        String add33 = rs.getString("IPDID");
                        Admission.setText(add33);
                        String add331 = rs.getString("Doctor");
                        doc.setText(add331);
                        String add3311 = rs.getString("drid");
                        drid.setText(add3311);
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
                //    JOpjimmeltionPane.showMessageDialog(null, "Not a Patient","Search Patient",JOptionPane.ERROR_MESSAGE);
                DesktopNotify.showDesktopMessage("Not a Inpatient to Discharge", "Discharge",
                        DesktopNotify.FAIL, 8000);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }               // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        int h = showConfirmDialog(null, "Do you want to Exit Discharge Request?", "Discharge Request", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            Discharge.setVisible(false);
            search4.setText("");
            name1.setText("");
            search8.setText("");
            rate.setText("");
            doc.setText("");
        }
        if (h == 1) {

        }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void search8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search8ActionPerformed

    private void search8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search8KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_search8KeyPressed

    private void search8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search8KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search8KeyReleased

    private void addpatient1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_addpatient1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_addpatient1AncestorAdded

    private void fillAll11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillAll11ActionPerformed
        int h = showConfirmDialog(null, "Do you want to Request Discharge?", "Request Discharge", JOptionPane.YES_NO_OPTION);
        if (h == 0) {
            Discharge.setVisible(true);
            Discharge.setSize(680, 437);
            Discharge.setLocationRelativeTo(null);
        }
        if (h == 1) {

        }
        //        String sql = "select * from SignUp where pass=? and App_ID='1050    private void fillAll11ActionPerformed(java.awt.event.ActionEvent evt) {                                          
//28'";
//
//        try {
//            pst=conn.prepareStatement(sql);
//            pst.setString(1,Pass.getText());
//            rs=pst.executeQuery();
//
//            if(rs.next()){
//                //JOptionPane.showMessageDialog(null, "WELCOME!");
//                AddConsultationTbl.setVisible(true);
//                DesktopNotify.showDesktopMessage("Updated", "Correct Password",
//                    DesktopNotify.SUCCESS, 8000);
//                pst.execute();
//            }
//
//            else{
//
//                //JOptionPane.showMessageDialog(null, "WRONG ID NO.","ERROR",JOptionPane.ERROR_MESSAGE);
//                DesktopNotify.showDesktopMessage("Wrong Password", "Password",
//                    DesktopNotify.FAIL, 8000);
//
//                Pass.setText("");
//            }
//        }
//        catch(Exception e){
//            JOptionPane.showMessageDialog(null, e);
//        }
    }//GEN-LAST:event_fillAll11ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Admission;
    private javax.swing.JDialog Discharge;
    private javax.swing.JTextField RoomID;
    private javax.swing.JLabel WARD;
    private javax.swing.JPanel addpatient;
    private javax.swing.JPanel addpatient1;
    private javax.swing.JLabel bed;
    private javax.swing.JLabel beed;
    private javax.swing.JLabel date_dayv2;
    private javax.swing.JTextField doc;
    private javax.swing.JLabel dokid;
    private javax.swing.JLabel drid;
    private rojerusan.RSMaterialButtonRound fillAll11;
    private javax.swing.JTextField gender;
    private javax.swing.JLabel imageHolder;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField name1;
    private javax.swing.JDialog patientverify;
    private javax.swing.JLabel rate;
    private javax.swing.JLabel room;
    private javax.swing.JLabel room1;
    private javax.swing.JLabel roomid;
    private javax.swing.JComboBox<String> rooms;
    private javax.swing.JPanel root1;
    private javax.swing.JTextField search;
    private javax.swing.JTextField search3;
    private javax.swing.JTextField search4;
    private javax.swing.JTextField search7;
    private javax.swing.JTextField search8;
    private javax.swing.JTable table;
    private javax.swing.JLabel ward;
    // End of variables declaration//GEN-END:variables
private ImageIcon format = null;
    String filename = null;
    int s = 0;
    byte[] person_image = null;
}
