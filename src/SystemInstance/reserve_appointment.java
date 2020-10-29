package SystemInstance;

import AlertsCore1.AWTUtilities;
import Module1SubModules.patRegistration;
import Notifications.DesktopNotify;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class reserve_appointment extends javax.swing.JFrame {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    CallableStatement cst = null;
    DefaultTableModel mode;
    String Registerno;
    String Gender;
    String type;
    String GenderApp;

    public reserve_appointment() {
        initComponents();

        AWTUtilities.setOpaque(this, false);
        this.CB_type3.setCursor(new Cursor(12));
        this.CB_type2.setCursor(new Cursor(12));
        con = MysqlConnect.ConnectDB();
        Motion();
        pat_ID.setVisible(false);
        auto_dr_number();
        CurrentDate();
        patient();
        CB_type3.setVisible(false);
        txt_pat_ill.setVisible(false);
        AutoCompleteDecorator.decorate(CB_type3);
        AutoCompleteDecorator.decorate(CB_type2);
        upcoming.setVisible(false);
        // noMED.setVisible(false);

    }

    public void Motion() {

        /*  Thread clock;
        clock = new Thread() {

            @Override
            public void run() {
                try {

                    for (;;) {
                        Object obj = evt.getSource();

                        Color F = noMED.getForeground();
                        if () {

                        }
                        if (tbl_view1.getRowCount() == 0) {
                            noMED2.setVisible(true);

                            noMED2.setText("NO MEDICAL HISTORY");
                        } else {
                            noMED2.setVisible(false);
                            noMED2.setText("");

                        }
                        sleep(900);
                    }
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        };
        clock.start();*/
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

        //  txt_date.setText((buwan) + "/" + (day1) + "/" + year + " " + hour + ":" + mn + day_night);
        txt_date.setText((buwan) + "/" + (day1) + "/" + year);

    }

    private void patient() {
        try {
            //      String sql = "select FirstName from Core1_pr_PatientRegistration";          
            String sql = "select Patient_ID from Core1_pr_PatientRegistration order by Patient_ID";

            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                CB_type2.addItem(rs.getString("Patient_ID"));
            }

        } catch (Exception e) {
        }
    }

    public void auto_dr_number() {

        try {
            String sql = "SELECT Count(Consultation_ID)AS no FROM Core1_opd_consultlist";
            con = MysqlConnect.ConnectDB();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                if (rs.first() == false) {
                    txt_c_id.setText("1");
                } else {
                    rs.last();
                    int auto_id = rs.getInt(1) + 1;
                    String no = String.valueOf(auto_id);
                    int nolong = no.length();
                    for (int a = 0; a < 3 - nolong; a++) {
                        no = "" + no;
                    }
                    txt_c_id.setText(no);
                }
            }

        } catch (Exception e) {
            System.out.println(e);

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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        Patient_slot = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        jLabel163 = new javax.swing.JLabel();
        txt_c_id = new javax.swing.JTextField();
        OLD = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        asterisk9 = new javax.swing.JLabel();
        asterisk12 = new javax.swing.JLabel();
        asterisk10 = new javax.swing.JLabel();
        CB_type3 = new rojerusan.RSComboMetro();
        txt_pat_ill = new app.bolivia.swing.JCTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        txt_lastname6 = new app.bolivia.swing.JCTextField();
        txt_lastname7 = new app.bolivia.swing.JCTextField();
        txt_lastname8 = new app.bolivia.swing.JCTextField();
        txt_date = new app.bolivia.swing.JCTextField();
        jLabel42 = new javax.swing.JLabel();
        checkBlue1 = new check.CheckBlue();
        checkRed1 = new check.CheckRed();
        jPanel5 = new javax.swing.JPanel();
        asterisk11 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jLabel167 = new javax.swing.JLabel();
        txt_lastname5 = new app.bolivia.swing.JCTextField();
        txt_lastname4 = new app.bolivia.swing.JCTextField();
        age = new app.bolivia.swing.JCTextField();
        gndr = new app.bolivia.swing.JCTextField();
        txt_lastname1 = new app.bolivia.swing.JCTextField();
        txt_mi = new app.bolivia.swing.JCTextField();
        txt_mi1 = new app.bolivia.swing.JCTextField();
        jLabel166 = new javax.swing.JLabel();
        pat_ID = new javax.swing.JTextField();
        CB_type2 = new rojerusan.RSComboMetro();
        reserveBTN = new rojerusan.RSMaterialButtonRound();
        upcomingBtn = new rojerusan.RSMaterialButtonRound();
        noMED1 = new javax.swing.JLabel();
        noMED = new javax.swing.JLabel();
        upcoming = new app.bolivia.swing.JCTextField();
        jPanel2 = new javax.swing.JPanel();
        icon_SystemLogo = new javax.swing.JLabel();
        cerrar = new principal.MaterialButton();
        CB_type = new rojerusan.RSComboMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Patient_slot.setBackground(new java.awt.Color(0, 102, 102));
        Patient_slot.setForeground(new java.awt.Color(0, 102, 102));
        Patient_slot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Patient_slot.setText("-");
        jPanel3.add(Patient_slot, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 30, 30));

        jLabel165.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel165.setText("slot left");
        jPanel3.add(jLabel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 50, 28));

        jLabel163.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel163.setText("Consultation ID:");
        jPanel3.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, -1, 28));

        txt_c_id.setBackground(new java.awt.Color(0, 102, 102));
        txt_c_id.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_c_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_c_id.setEnabled(false);
        txt_c_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_c_idActionPerformed(evt);
            }
        });
        jPanel3.add(txt_c_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 48, 30));

        OLD.setBackground(new java.awt.Color(255, 255, 255));
        OLD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 102, 102), null));
        OLD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(240, 240, 240));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Patient concern", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        asterisk9.setBackground(new java.awt.Color(255, 255, 255));
        asterisk9.setFont(new java.awt.Font("Arial", 3, 9)); // NOI18N
        asterisk9.setForeground(new java.awt.Color(204, 0, 0));
        jPanel6.add(asterisk9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 270, 30));

        asterisk12.setBackground(new java.awt.Color(255, 255, 255));
        asterisk12.setFont(new java.awt.Font("Arial", 3, 9)); // NOI18N
        asterisk12.setForeground(new java.awt.Color(204, 0, 0));
        jPanel6.add(asterisk12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 270, 30));

        asterisk10.setBackground(new java.awt.Color(255, 255, 255));
        asterisk10.setFont(new java.awt.Font("Arial", 3, 9)); // NOI18N
        asterisk10.setForeground(new java.awt.Color(204, 0, 0));
        jPanel6.add(asterisk10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 120, 22));

        CB_type3.setEditable(true);
        CB_type3.setMaximumRowCount(4);
        CB_type3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT PATIENT ILLNESS HERE", "Abdominal aortic aneurysm ", "Acne ", "Acute cholecystitis ", "Acute lymphoblastic leukaemia ", "Acute lymphoblastic leukaemia: Children", "Acute lymphoblastic leukaemia: Teenagers and young adults ", "Acute myeloid leukaemia ", "Acute myeloid leukaemia: Children ", "Acute myeloid leukaemia: Teenagers and young adults ", "Acute pancreatitis ", "Addison's disease ", "Alcohol misuse ", "Alcohol poisoning ", "Alcohol-related liver disease ", "Allergic rhinitis ", "Allergies ", "Alzheimer's disease ", "Anal cancer ", "Anaphylaxis ", "Angioedema ", "Ankylosing spondylitis ", "Anorexia nervosa ", "Anxiety ", "Anxiety disorders in children ", "Appendicitis ", "Arthritis ", "Asbestosis ", "Asthma ", "Atopic eczema ", "Attention deficit hyperactivity disorder (ADHD) ", "Autistic spectrum disorder (ASD) ", "Bacterial vaginosis ", "Benign prostate enlargement ", "Bile duct cancer (cholangiocarcinoma) ", "Binge eating ", "Bipolar disorder ", "Bladder cancer ", "Blood poisoning (sepsis) ", "Bone cancer ", "Bone cancer: Teenagers and young adults ", "Bowel cancer ", "Bowel incontinence ", "Bowel polyps ", "Brain stem death ", "Brain tumours ", "Brain tumours: Children ", "Brain tumours: Teeangers and young adults ", "Breast cancer (female) ", "Breast cancer (male) ", "Bronchiectasis ", "Bronchitis ", "Bulimia ", "Bunion ", "Bursitis", "Carcinoid syndrome and carcinoid tumours ", "Catarrh ", "Cellulitis ", "Cervical cancer ", "Chest infection ", "Chest pain ", "Chickenpox ", "Chilblains ", "Chronic fatigue syndrome ", "Chronic kidney disease ", "Chronic lymphocytic leukaemia ", "Chronic myeloid leukaemia ", "Chronic obstructive pulmonary disease ", "Chronic pancreatitis ", "Cirrhosis ", "Clostridium difficile ", "Coeliac disease ", "Cold sore ", "Coma ", "Common cold ", "Common heart conditions ", "Congenital heart disease", "Conjunctivitis ", "Constipation ", "Costochondritis ", "Cough", "Crohn's disease ", "Croup ", "Cystic fibrosis ", "Cystitis ", "Deafblindness ", "Deep vein thrombosis ", "Dehydration ", "Dementia ", "Dementia with Lewy bodies ", "Dental abscess ", "Depression ", "Dermatitis herpetiformis ", "Diabetes ", "Diabetic retinopathy ", "Diarrhoea ", "Discoid eczema ", "Diverticular disease and diverticulitis", "Dizziness (Lightheadedness) ", "Down's syndrome ", "Dry mouth ", "Dysphagia (swallowing problems) ", "Dystonia ", "Earache ", "Earwax build-up ", "Ebola virus disease ", "Ectopic pregnancy ", "Endometriosis ", "Epilepsy ", "Erectile dysfunction (impotence) ", "Escherichia coli (E. coli) O157 ", "Ewing sarcoma ", "Ewing sarcoma: Children ", "Eye cancer ", "Febrile seizures ", "Fever in children ", "Fibroids ", "Fibromyalgia ", "Flatulence ", "Flu", "Foetal alcohol syndrome ", "Food poisoning ", "Fungal nail infection ", "Gallbladder cancer ", "Gallstones ", "Ganglion cyst ", "Gastro-oesophageal reflux disease (GORD) ", "Genital herpes ", "Genital warts ", "Germ cell tumours ", "Glandular fever ", "Gout ", "Gum disease ", "Haemorrhoids (piles) ", "Hairy cell leukaemia ", "Hand, foot and mouth disease ", "Hay fever ", "Head and neck cancer ", "Head lice and nits ", "Headaches ", "Hearing loss ", "Heart failure ", "Hepatitis A ", "Hepatitis B ", "Hepatitis C ", "Hiatus hernia ", "High cholesterol ", "HIV", "Hodgkin lymphoma ", "Hodgkin lymphoma: Children ", "Hodgkin lymphoma: Teeangers and young adults ", "Huntington's disease ", "Hyperglycaemia (high blood sugar) ", "Hyperhidrosis ", "Hypoglycaemia (low blood sugar) ", "Idiopathic pulmonary fibrosis ", "Impetigo ", "Indigestion ", "Ingrown toenail ", "Inherited heart conditions", "Insomnia", "Iron deficiency anaemia", "Irritable bowel syndrome (IBS) ", "Irritable hip ", "Itching ", "Itchy bottom ", "Kaposi's sarcoma ", "Kidney cancer ", "Kidney infection ", "Kidney stones ", "Labyrinthitis ", "Lactose intolerance ", "Langerhans cell histiocytosis ", "Laryngeal (larynx) cancer ", "Laryngitis ", "Leg cramps ", "Lichen planus ", "Liver cancer ", "Liver disease ", "Liver tumours ", "Loss of libido ", "Lung cancer ", "Lupus ", "Lyme disease ", "Lymphoedema ", "Malaria ", "Malignant brain tumour (cancerous)", "Malnutrition ", "Measles ", "Meningitis ", "Menopause ", "Mesothelioma ", "Middle ear infection (otitis media) ", "Migraine ", "Miscarriage ", "Motor neurone disease (MND) ", "Mouth cancer ", "Mouth ulcer ", "Multiple myeloma ", "Multiple sclerosis (MS) ", "Mumps ", "Meniere's disease ", "Nasal and sinus cancer ", "Nasopharyngeal cancer ", "Neuroblastoma ", "Neuroblastoma: Children ", "Neuroendocrine tumours ", "New or worsening back pain ", "Non-alcoholic fatty liver disease (NAFLD) ", "Non-Hodgkin lymphoma ", "Non-Hodgkin lymphoma: Children ", "Norovirus ", "Nosebleed ", "Obesity ", "Obsessive compulsive disorder (OCD) ", "Obstructive sleep apnoea ", "Oesophageal cancer ", "Oral thrush in adults ", "Osteoarthritis ", "Osteoporosis ", "Osteosarcoma ", "Otitis externa ", "Ovarian cancer ", "Ovarian cancer: Teenagers and young adults ", "Ovarian cyst ", "Overactive thyroid ", "Paget's disease of the nipple ", "Pancreatic cancer ", "Panic disorder ", "Parkinson's disease ", "Pelvic organ prolapse ", "Penile cancer ", "Peripheral neuropathy ", "Personality disorder ", "Pleurisy ", "Pneumonia ", "Polymyalgia rheumatica ", "Post-traumatic stress disorder (PTSD)", "Postnatal depression ", "Pregnancy and baby ", "Pressure ulcers ", "Prostate cancer ", "Psoriasis ", "Psoriatic arthritis ", "Psychosis ", "Rare tumours ", "Raynaud's phenomenon ", "Reactive arthritis ", "Restless legs syndrome ", "Retinoblastoma ", "Retinoblastoma: Children ", "Rhabdomyosarcoma ", "Rheumatoid arthritis ", "Ringworm and other fungal infections", "Rosacea ", "Scabies ", "Scarlet fever ", "Schizophrenia ", "Scoliosis ", "Septic shock ", "Sexually transmitted infections (STIs)", "Shingles ", "Shortness of breath ", "Sickle cell disease ", "Sinusitis ", "Sjogren's syndrome ", "Skin cancer (melanoma) ", "Skin cancer (non-melanoma) ", "Slapped cheek syndrome ", "Soft tissue sarcomas ", "Soft tissue sarcomas: Teenagers and young adults ", "Sore throat ", "Spleen problems and spleen removal", "Stillbirth ", "Stomach ache and abdominal pain ", "Stomach cancer ", "Stomach ulcer ", "Stress, anxiety and low mood ", "Stroke ", "Sudden infant death syndrome (SIDS)", "Suicide ", "Sunburn ", "Swollen glands ", "Testicular cancer ", "Testicular cancer: Teeangers and young adults ", "Testicular lumps and swellings ", "Thirst ", "Threadworms ", "Thrush in men ", "Thyroid cancer ", "Thyroid cancer: Teeangers and young adults ", "Tinnitus ", "Tonsillitis ", "Tooth decay ", "Toothache ", "Transient ischaemic attack (TIA) ", "Trigeminal neuralgia ", "Tuberculosis (TB) ", "Type 1 diabetes ", "Type 2 diabetes ", "Ulcerative colitis ", "Underactive thyroid ", "Urinary incontinence ", "Urinary tract infection (UTI) ", "Urinary tract infection (UTI) in children ", "Urticaria (hives) ", "Vaginal cancer ", "Vaginal thrush ", "Varicose eczema ", "Varicose veins ", "Venous leg ulcer ", "Vertigo ", "Vitamin B12 or folate deficiency anaemia ", "Vomiting in adults ", "Vulval cancer ", "Warts and verrucas ", "Whooping cough", "Wilms’ tumour ", "Womb (uterus) cancer ", "Yellow fever" }));
        CB_type3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        CB_type3.setPreferredSize(new java.awt.Dimension(188, 30));
        CB_type3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CB_type3KeyTyped(evt);
            }
        });
        jPanel6.add(CB_type3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 270, -1));

        txt_pat_ill.setBorder(null);
        txt_pat_ill.setForeground(new java.awt.Color(58, 159, 171));
        txt_pat_ill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_pat_ill.setPlaceholder("Type patient illness");
        txt_pat_ill.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_pat_illKeyTyped(evt);
            }
        });
        jPanel6.add(txt_pat_ill, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 270, -1));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel41.setText("Date :");
        jPanel6.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 80, 30));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel40.setText("Specialization :");
        jPanel6.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 90, 30));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel37.setText("Doctor name :");
        jPanel6.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 80, 30));

        jLabel164.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel164.setText("Mode of payment");
        jPanel6.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 40));

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setText("CASH");
        jRadioButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });
        jPanel6.add(jRadioButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        buttonGroup2.add(jRadioButton6);
        jRadioButton6.setText("HMO");
        jRadioButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });
        jPanel6.add(jRadioButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, -1, -1));

        txt_lastname6.setEditable(false);
        txt_lastname6.setBackground(new java.awt.Color(255, 255, 255));
        txt_lastname6.setBorder(null);
        txt_lastname6.setForeground(new java.awt.Color(58, 159, 171));
        txt_lastname6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_lastname6.setPlaceholder("Doctor");
        txt_lastname6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_lastname6KeyTyped(evt);
            }
        });
        jPanel6.add(txt_lastname6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 170, -1));

        txt_lastname7.setEditable(false);
        txt_lastname7.setBackground(new java.awt.Color(255, 255, 255));
        txt_lastname7.setBorder(null);
        txt_lastname7.setForeground(new java.awt.Color(58, 159, 171));
        txt_lastname7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_lastname7.setPlaceholder("Specialization");
        txt_lastname7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_lastname7KeyTyped(evt);
            }
        });
        jPanel6.add(txt_lastname7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 170, -1));

        txt_lastname8.setEditable(false);
        txt_lastname8.setBackground(new java.awt.Color(255, 255, 255));
        txt_lastname8.setBorder(null);
        txt_lastname8.setForeground(new java.awt.Color(58, 159, 171));
        txt_lastname8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_lastname8.setPlaceholder("Current day");
        txt_lastname8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_lastname8KeyTyped(evt);
            }
        });
        jPanel6.add(txt_lastname8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 170, -1));

        txt_date.setEditable(false);
        txt_date.setBackground(new java.awt.Color(255, 255, 255));
        txt_date.setBorder(null);
        txt_date.setForeground(new java.awt.Color(58, 159, 171));
        txt_date.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_date.setPlaceholder("Current date");
        txt_date.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dateKeyTyped(evt);
            }
        });
        jPanel6.add(txt_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 170, -1));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel42.setText("Day :");
        jPanel6.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 80, 30));

        checkBlue1.setText("Common Illness");
        checkBlue1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkBlue1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkBlue1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                checkBlue1MousePressed(evt);
            }
        });
        checkBlue1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBlue1ActionPerformed(evt);
            }
        });
        jPanel6.add(checkBlue1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, 30));

        checkRed1.setText("Others");
        checkRed1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkRed1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkRed1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                checkRed1MousePressed(evt);
            }
        });
        checkRed1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkRed1ActionPerformed(evt);
            }
        });
        jPanel6.add(checkRed1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, -1, 30));

        OLD.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 310, 300));

        jPanel5.setBackground(new java.awt.Color(240, 240, 240));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Patient Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        asterisk11.setBackground(new java.awt.Color(255, 255, 255));
        asterisk11.setFont(new java.awt.Font("Arial", 3, 9)); // NOI18N
        asterisk11.setForeground(new java.awt.Color(204, 0, 0));
        asterisk11.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                asterisk11AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel5.add(asterisk11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 160, 30));

        jLabel170.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel170.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel170.setText("Address :");
        jPanel5.add(jLabel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 70, 30));

        jLabel169.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel169.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel169.setText("+63");
        jPanel5.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 70, 30));

        jLabel168.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel168.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel168.setText("Age :");
        jPanel5.add(jLabel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 70, 30));

        jLabel167.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel167.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel167.setText("Gender :");
        jPanel5.add(jLabel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 70, 30));

        txt_lastname5.setEditable(false);
        txt_lastname5.setBackground(new java.awt.Color(255, 255, 255));
        txt_lastname5.setBorder(null);
        txt_lastname5.setForeground(new java.awt.Color(58, 159, 171));
        txt_lastname5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_lastname5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_lastname5.setPlaceholder("Current location");
        txt_lastname5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_lastname5KeyTyped(evt);
            }
        });
        jPanel5.add(txt_lastname5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 170, -1));

        txt_lastname4.setEditable(false);
        txt_lastname4.setBackground(new java.awt.Color(255, 255, 255));
        txt_lastname4.setBorder(null);
        txt_lastname4.setForeground(new java.awt.Color(58, 159, 171));
        txt_lastname4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_lastname4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_lastname4.setPlaceholder("Contact number");
        txt_lastname4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_lastname4KeyTyped(evt);
            }
        });
        jPanel5.add(txt_lastname4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 170, -1));

        age.setEditable(false);
        age.setBackground(new java.awt.Color(255, 255, 255));
        age.setBorder(null);
        age.setForeground(new java.awt.Color(58, 159, 171));
        age.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        age.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        age.setPlaceholder("Current age");
        age.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ageKeyTyped(evt);
            }
        });
        jPanel5.add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 170, -1));

        gndr.setEditable(false);
        gndr.setBackground(new java.awt.Color(255, 255, 255));
        gndr.setBorder(null);
        gndr.setForeground(new java.awt.Color(58, 159, 171));
        gndr.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gndr.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        gndr.setPlaceholder("Gender");
        gndr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gndrKeyTyped(evt);
            }
        });
        jPanel5.add(gndr, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 170, -1));

        txt_lastname1.setEditable(false);
        txt_lastname1.setBackground(new java.awt.Color(255, 255, 255));
        txt_lastname1.setBorder(null);
        txt_lastname1.setForeground(new java.awt.Color(58, 159, 171));
        txt_lastname1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_lastname1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_lastname1.setPlaceholder("First name");
        txt_lastname1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_lastname1KeyTyped(evt);
            }
        });
        jPanel5.add(txt_lastname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 100, -1));

        txt_mi.setEditable(false);
        txt_mi.setBackground(new java.awt.Color(255, 255, 255));
        txt_mi.setBorder(null);
        txt_mi.setForeground(new java.awt.Color(58, 159, 171));
        txt_mi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_mi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_mi.setPlaceholder("Last name");
        txt_mi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_miKeyTyped(evt);
            }
        });
        jPanel5.add(txt_mi, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 110, -1));

        txt_mi1.setEditable(false);
        txt_mi1.setBackground(new java.awt.Color(255, 255, 255));
        txt_mi1.setBorder(null);
        txt_mi1.setForeground(new java.awt.Color(58, 159, 171));
        txt_mi1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_mi1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_mi1.setPlaceholder("Middle name");
        txt_mi1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_mi1KeyTyped(evt);
            }
        });
        jPanel5.add(txt_mi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 100, -1));

        jLabel166.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel166.setText("Patient ID:");
        jPanel5.add(jLabel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 70, 30));

        pat_ID.setEditable(false);
        pat_ID.setBackground(new java.awt.Color(255, 255, 255));
        pat_ID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pat_ID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pat_ID.setEnabled(false);
        pat_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pat_IDActionPerformed(evt);
            }
        });
        jPanel5.add(pat_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 48, 30));

        CB_type2.setEditable(true);
        CB_type2.setMaximumRowCount(4);
        CB_type2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select patient ID" }));
        CB_type2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        CB_type2.setPreferredSize(new java.awt.Dimension(188, 30));
        CB_type2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                CB_type2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        CB_type2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CB_type2MouseEntered(evt);
            }
        });
        CB_type2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_type2ActionPerformed(evt);
            }
        });
        jPanel5.add(CB_type2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 160, -1));

        OLD.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 360, 300));

        reserveBTN.setText("Reserve");
        reserveBTN.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        reserveBTN.setMaximumSize(new java.awt.Dimension(82, 26));
        reserveBTN.setMinimumSize(new java.awt.Dimension(82, 26));
        reserveBTN.setPreferredSize(new java.awt.Dimension(88, 28));
        reserveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reserveBTNActionPerformed(evt);
            }
        });
        OLD.add(reserveBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 180, 50));

        upcomingBtn.setText("Reserve Upcoming");
        upcomingBtn.setFont(new java.awt.Font("Roboto Medium", 1, 13)); // NOI18N
        upcomingBtn.setMaximumSize(new java.awt.Dimension(82, 26));
        upcomingBtn.setMinimumSize(new java.awt.Dimension(82, 26));
        upcomingBtn.setPreferredSize(new java.awt.Dimension(88, 28));
        upcomingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upcomingBtnActionPerformed(evt);
            }
        });
        OLD.add(upcomingBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 180, 50));

        noMED1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        noMED1.setForeground(new java.awt.Color(255, 0, 51));
        noMED1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OLD.add(noMED1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 280, 40));

        noMED.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        noMED.setForeground(new java.awt.Color(255, 0, 51));
        noMED.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OLD.add(noMED, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 280, 40));

        upcoming.setEditable(false);
        upcoming.setBackground(new java.awt.Color(255, 255, 255));
        upcoming.setBorder(null);
        upcoming.setForeground(new java.awt.Color(58, 159, 171));
        upcoming.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        upcoming.setPlaceholder("First name");
        OLD.add(upcoming, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 210, -1));

        jPanel3.add(OLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 700, 450));

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon_SystemLogo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        icon_SystemLogo.setForeground(new java.awt.Color(102, 102, 255));
        icon_SystemLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon_SystemLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hms50x48.png"))); // NOI18N
        jPanel2.add(icon_SystemLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        cerrar.setBackground(new java.awt.Color(255, 255, 255));
        cerrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 159, 171), 2));
        cerrar.setText("X");
        cerrar.setToolTipText("<html> <head> <style> #contenedor{background:white;color:black; padding-left:10px;padding-right:10px;margin:0; padding-top:5px;padding-bottom:5px;} </style> </head> <body> <h4 id=\"contenedor\">Exit</h4> </body> </html>");
        cerrar.setAlignmentX(5.0F);
        cerrar.setAlignmentY(1.0F);
        cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cerrar.setFont(new java.awt.Font("Roboto Medium", 1, 20)); // NOI18N
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });
        jPanel2.add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 5, 40, 40));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 50));

        CB_type.setEditable(true);
        CB_type.setMaximumRowCount(4);
        CB_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "OLD", "NEW" }));
        CB_type.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        CB_type.setPreferredSize(new java.awt.Dimension(188, 30));
        CB_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_typeActionPerformed(evt);
            }
        });
        jPanel3.add(CB_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 90, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
        );

        setBounds(400, 250, 721, 570);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jRadioButton5ActionPerformed
    {//GEN-HEADEREND:event_jRadioButton5ActionPerformed
        type = "CASH";
        asterisk10.setVisible(false);
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jRadioButton6ActionPerformed
    {//GEN-HEADEREND:event_jRadioButton6ActionPerformed
        type = "HMO";
        asterisk10.setVisible(false);
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void txt_c_idActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_c_idActionPerformed
    {//GEN-HEADEREND:event_txt_c_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_c_idActionPerformed

    private void pat_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pat_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pat_IDActionPerformed

    private void txt_lastname1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_lastname1KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }

        if (!Character.isAlphabetic(evt.getKeyChar()) && !Character.isSpaceChar(evt.getKeyChar())) {
            evt.consume();
        } else if (txt_lastname1.getText().trim().length() == 0 && Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_txt_lastname1KeyTyped

    private void txt_mi1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mi1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mi1KeyTyped

    private void txt_miKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_miKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_miKeyTyped

    private void gndrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gndrKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_gndrKeyTyped

    private void ageKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ageKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_ageKeyTyped

    private void txt_lastname4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_lastname4KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lastname4KeyTyped

    private void txt_lastname5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_lastname5KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lastname5KeyTyped

    private void CB_type2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CB_type2MouseEntered

        CB_type2.removeAllItems();
        patient();
    }//GEN-LAST:event_CB_type2MouseEntered

    private void CB_type2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_CB_type2PopupMenuWillBecomeInvisible

        String diagnose = (String) CB_type2.getSelectedItem();
        //       String sql = "select diagnose_description,medicine,dosage,medicine_type,take,medicine_description"
        //               + "from  Core1_opd_treatmentmedicine where title = ?";

        //   String sql = "select * from Core1_pr_PatientRegistration where FirstName =?";
        //  String sql = "select * from Core1_pr_PatientRegistration where FirstName =?";
        String sql = "select Patient_ID,DATEDIFF(YEAR,PR_Birthdate,convert (nvarchar,GETDATE(),101) )  as age ,\n"
                + "LastName,FirstName,MiddleName,address,PR_MobileNo,PR_Gender\n"
                + " from  Core1_pr_PatientRegistration where Patient_ID = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, diagnose);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add111 = rs.getString("FirstName");
                txt_lastname1.setText(add111);
                String add11 = rs.getString("LastName");
                txt_mi.setText(add11);
                String add12 = rs.getString("MiddleName");
                txt_mi1.setText(add12);
                String add1 = rs.getString("PR_Gender");
                gndr.setText(add1);
                String add2 = rs.getString("age");
                age.setText(add2);
                String add3 = rs.getString("PR_MobileNo");
                txt_lastname4.setText(add3);
                String add4 = rs.getString("address");
                txt_lastname5.setText(add4);
                String add5 = rs.getString("Patient_ID");
                pat_ID.setText(add5);

            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, err);
        }
    }//GEN-LAST:event_CB_type2PopupMenuWillBecomeInvisible

    private void txt_lastname6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_lastname6KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lastname6KeyTyped

    private void txt_lastname7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_lastname7KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lastname7KeyTyped

    private void txt_lastname8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_lastname8KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lastname8KeyTyped

    private void txt_dateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dateKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dateKeyTyped

    private void checkBlue1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBlue1ActionPerformed
        if (checkBlue1.isSelected()) {
            CB_type3.setVisible(true);

        } else {
            CB_type3.setVisible(false);

        }

    }//GEN-LAST:event_checkBlue1ActionPerformed

    private void checkRed1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkRed1ActionPerformed
        if (checkRed1.isSelected()) {
            txt_pat_ill.setVisible(true);

        } else {
            txt_pat_ill.setVisible(false);

        }
    }//GEN-LAST:event_checkRed1ActionPerformed

    private void checkBlue1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkBlue1MouseClicked

    }//GEN-LAST:event_checkBlue1MouseClicked

    private void checkRed1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkRed1MouseClicked

    }//GEN-LAST:event_checkRed1MouseClicked

    private void checkRed1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkRed1MousePressed

    }//GEN-LAST:event_checkRed1MousePressed

    private void checkBlue1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkBlue1MousePressed

    }//GEN-LAST:event_checkBlue1MousePressed

    private void txt_pat_illKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pat_illKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }

        if (!Character.isAlphabetic(evt.getKeyChar()) && !Character.isSpaceChar(evt.getKeyChar())) {
            evt.consume();
        } else if (txt_pat_ill.getText().trim().length() == 0 && Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_txt_pat_illKeyTyped

    private void CB_type3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CB_type3KeyTyped

    }//GEN-LAST:event_CB_type3KeyTyped

    private void CB_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_typeActionPerformed
        if (CB_type.getSelectedItem().equals("NEW")) {
            patRegistration patient = new patRegistration();
            patient.setVisible(true);
            CB_type.setSelectedIndex(0);

        } else if (CB_type.getSelectedItem().equals("OLD")) {
            OLD.setVisible(true);
            reserveBTN.setVisible(true);
            patRegistration patient = new patRegistration();
            patient.setVisible(false);

        }
    }//GEN-LAST:event_CB_typeActionPerformed

    private void reserveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reserveBTNActionPerformed
        // Add schedule SELECT PATIENT ILLNESS HERE
        if (CB_type2.getSelectedItem().equals("Select patient ID")) {
            // Validation message. 
            InputStream in;
            try {

                in = new FileInputStream(new File("C:\\Users\\iRHONman\\Desktop\\PS1\\Template\\undone\\src\\VoiceOverNotif\\VoiceOver\\Pat_miss.wav"));

                AudioStream audios = new AudioStream(in);
                AudioPlayer.player.start(audios);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            DesktopNotify.showDesktopMessage("INPUT MISSING...", "Please select Patient ID",
                    DesktopNotify.INPUT_REQUEST, 8000);
            asterisk11.setBorder(BorderFactory.createLineBorder(Color.red));
            asterisk11.setVisible(true);
            asterisk9.setVisible(true);
        } else if (buttonGroup2.getSelection() == null) {
            // Validation message. 
            InputStream in;
            try {

                in = new FileInputStream(new File("C:\\Users\\iRHONman\\Desktop\\PS1\\Template\\undone\\src\\VoiceOverNotif\\VoiceOver\\Pat_miss.wav"));

                AudioStream audios = new AudioStream(in);
                AudioPlayer.player.start(audios);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            DesktopNotify.showDesktopMessage("INPUT MISSING...", "Please select mode of payment of " + txt_lastname1.getText(),
                    DesktopNotify.INPUT_REQUEST, 8000);
            asterisk10.setBorder(BorderFactory.createLineBorder(Color.red));
            asterisk10.setVisible(true);
            asterisk9.setBorder(BorderFactory.createLineBorder(Color.red));
            asterisk9.setVisible(false);

        } else {
            try {

                String query = "insert  into Core1_opd_consultlist values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                con = MysqlConnect.ConnectDB();
                pst = con.prepareStatement(query);
                String patiet;
                patiet = CB_type2.getSelectedItem().toString();
                pst.setString(1, patiet);
                //   pst.setString(2, txtuser.getText());
                pst.setString(2, txt_lastname1.getText() + ", " + txt_mi.getText() + " " + txt_mi1.getText());
                pst.setString(3, age.getText());
                pst.setString(4, gndr.getText());
                pst.setString(5, txt_lastname4.getText());
                pst.setString(6, txt_lastname5.getText());
                pst.setString(7, (String) CB_type.getSelectedItem());
                pst.setString(8, type);
                pst.setString(9, txt_lastname6.getText());
                pst.setString(10, txt_lastname7.getText());
                String Patient;
                if (checkBlue1.isSelected()) {
                    CB_type3.setVisible(true);
                    String illness;
                    illness = CB_type3.getSelectedItem().toString();
                    pst.setString(11, illness);
                }
                if (checkRed1.isSelected()) {
                    txt_pat_ill.setVisible(true);
                    pst.setString(11, txt_pat_ill.getText());
                }

                pst.setString(12, txt_lastname8.getText());
                pst.setString(13, txt_date.getText());
                pst.setString(14, "No vital signs yet");
                pst.setString(15, pat_ID.getText());
                pst.setString(16, "Outpatient");
                pst.execute();

                DesktopNotify.showDesktopMessage("SUCESSFULLY...", "Patient reserve slot",
                        DesktopNotify.SUCCESS, 8000);

                InputStream in;
                try {

                    in = new FileInputStream(new File("C:\\Users\\iRHONman\\Desktop\\PS1\\Template\\undone\\src\\VoiceOverNotif\\VoiceOver\\reserveslot.wav"));

                    AudioStream audios = new AudioStream(in);
                    AudioPlayer.player.start(audios);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }

                try {

                    int slotleft = Integer.parseInt(Patient_slot.getText());
                    int totalqa = slotleft - 1;
                    String query2 = "update Core1_dra_publish set Max_patient_today = " + totalqa + " where Name = '" + txt_lastname6.getText() + "'";

                    java.sql.Statement st = null;

                    con = MysqlConnect.ConnectDB();
                    st = con.createStatement();
                    st.executeUpdate(query2);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                    //"Not Saved!, please check your remaining filled"

                }

                // JOptionPane.showMessageDialog(null, "Patient successfully reserve slot");
                int choice1 = JOptionPane.showConfirmDialog(null, "Reserved another slot?", "Warning", JOptionPane.YES_NO_OPTION);
                if (choice1 == JOptionPane.YES_OPTION) {

                    txt_lastname1.setText("");
                    txt_mi.setText("");
                    txt_mi1.setText("");
                    gndr.setText("");
                    age.setText("");
                    txt_lastname4.setText("");
                    txt_lastname5.setText("");
                    auto_dr_number();
                    setVisible(true);
                } else {
                    txt_lastname1.setText("");
                    txt_mi.setText("");
                    txt_mi1.setText("");
                    gndr.setText("");
                    age.setText("");
                    txt_lastname4.setText("");
                    txt_lastname5.setText("");

                    setVisible(false);
                    Post_Schedule update = new Post_Schedule();
                    update.setVisible(true);

                }

            } catch (Exception ex) {
                // JOptionPane.showMessageDialog(null, e);
                InputStream in;
                try {

                    in = new FileInputStream(new File("C:\\Users\\iRHONman\\Desktop\\PS1\\Template\\undone\\src\\VoiceOverNotif\\VoiceOver\\Pat_miss.wav"));

                    AudioStream audios = new AudioStream(in);
                    AudioPlayer.player.start(audios);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                DesktopNotify.showDesktopMessage("INPUT MISSING...", "Please select if OTHERS or COMMON  the illness of  patient " + txt_lastname1.getText(),
                        DesktopNotify.INPUT_REQUEST, 8000);
                asterisk10.setBorder(BorderFactory.createLineBorder(Color.red));
                asterisk10.setVisible(true);
            }
        }


    }//GEN-LAST:event_reserveBTNActionPerformed

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cerrarActionPerformed

    private void upcomingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upcomingBtnActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_upcomingBtnActionPerformed

    private void CB_type2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_type2ActionPerformed

        Object obj = evt.getSource();
        {
            if (obj == CB_type2) {

                try {

                    String sql = "select name from Core1_PR_Overview where Patient_ID = '" + pat_ID.getText() + "' and remarks = 'Upcoming'";
                    pst = con.prepareStatement(sql);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String add12 = rs.getString("name");
                        upcoming.setText(add12);
                        noMED.setText(upcoming.getText() + "");
                        noMED1.setText("HAVE FOLLOW CHECK-Up");

                    } else {
                        noMED.setText("NO UPCOMING APPOINTMENT");
                        noMED1.setText("");

                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }//GEN-LAST:event_CB_type2ActionPerformed

    private void asterisk11AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_asterisk11AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_asterisk11AncestorAdded

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(reserve_appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reserve_appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reserve_appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reserve_appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reserve_appointment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSComboMetro CB_type;
    private rojerusan.RSComboMetro CB_type2;
    private rojerusan.RSComboMetro CB_type3;
    private javax.swing.JPanel OLD;
    public static javax.swing.JLabel Patient_slot;
    public static app.bolivia.swing.JCTextField age;
    private javax.swing.JLabel asterisk10;
    private javax.swing.JLabel asterisk11;
    private javax.swing.JLabel asterisk12;
    private javax.swing.JLabel asterisk9;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private principal.MaterialButton cerrar;
    private check.CheckBlue checkBlue1;
    private check.CheckRed checkRed1;
    public static app.bolivia.swing.JCTextField gndr;
    private javax.swing.JLabel icon_SystemLogo;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JLabel noMED;
    private javax.swing.JLabel noMED1;
    public static javax.swing.JTextField pat_ID;
    private rojerusan.RSMaterialButtonRound reserveBTN;
    public static javax.swing.JTextField txt_c_id;
    public static app.bolivia.swing.JCTextField txt_date;
    public static app.bolivia.swing.JCTextField txt_lastname1;
    public static app.bolivia.swing.JCTextField txt_lastname4;
    public static app.bolivia.swing.JCTextField txt_lastname5;
    public static app.bolivia.swing.JCTextField txt_lastname6;
    public static app.bolivia.swing.JCTextField txt_lastname7;
    public static app.bolivia.swing.JCTextField txt_lastname8;
    public static app.bolivia.swing.JCTextField txt_mi;
    public static app.bolivia.swing.JCTextField txt_mi1;
    public static app.bolivia.swing.JCTextField txt_pat_ill;
    public static app.bolivia.swing.JCTextField upcoming;
    private rojerusan.RSMaterialButtonRound upcomingBtn;
    // End of variables declaration//GEN-END:variables
}
