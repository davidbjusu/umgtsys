package university_mgt_system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class add_student extends JFrame implements ActionListener{
    
    
    
    PreparedStatement pst;
    
    
    JTextField txt_surname,txt_othername,txt_matno,txt_telephone
              ,txt_address,txt_parent,txt_major,txt_fee;
    JDateChooser dcdob;
    JComboBox cmb_year,cmb_gender,cmb_nationality,cmb_fsupport;
    JButton back,submit, cancel;
    private JComboBox<String> cmb_school;
    private JComboBox<String> cmb_dept;
    private JComboBox<String> cmb_prog;
    private JComboBox<String> cmb_prog_year;
    
    private JLabel lblSchoolID;
    private JLabel lbldeptID;
    private JLabel lblprogID;
    private JLabel lblyrID;
    
    
    add_student() {
        lblSchoolID = new JLabel();
        lblSchoolID.setVisible(false);
        this.add(lblSchoolID);
        //departments
        lbldeptID = new JLabel();
        lbldeptID.setVisible(false);
        this.add(lbldeptID);
        
        //programs
        lblprogID = new JLabel();
        lblprogID.setVisible(false);
        this.add(lblprogID);
        
        //year
        lblyrID = new JLabel();
        lblyrID.setVisible(false);
        this.add(lblyrID);
         cmb_school = new JComboBox<>();
         cmb_dept = new JComboBox<>();
         cmb_prog = new JComboBox<>();
         cmb_prog_year = new JComboBox<>();
        loadSchools();
        loadacademicYear();
        setTitle("Njala University Management System");
        
        NoIconFrame.setFrameIcon(this);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
                
        JLabel heading = new JLabel("Student Registration Form");
        heading.setBounds(300, 10, 500, 50);
        heading.setFont(new Font("sanserif", Font.BOLD, 30));
        heading.setForeground(Color.blue);
        add(heading);
              
        JLabel lbl_1 = new JLabel("ACADEMIC YEAR");
        lbl_1.setBounds(20, 150, 120, 30);
        lbl_1.setFont(new Font("sanserif", Font.BOLD, 12));
        lbl_1.setForeground(Color.red);
        add(lbl_1);
        
        String year[] = {"Select","2020/2021", "2021/2022", "2022/2023", "2023/2024", "2024/2025", "2025/2026"};
        cmb_year = new JComboBox(year);
        cmb_year.setBounds(150, 160, 150, 25);
        cmb_year.setFont(new Font("sanserif", Font.PLAIN, 12));
        cmb_year.setBackground(Color.WHITE);
        add(cmb_year);
                
        JLabel lbl_2 = new JLabel("SURNAME");
        lbl_2.setBounds(350, 150, 200, 30);
        lbl_2.setFont(new Font("sanserif", Font.BOLD, 12));
        lbl_2.setForeground(Color.red);
        add(lbl_2);
        
        txt_surname = new JTextField();
        txt_surname.setBounds(450, 160, 150, 25);
        txt_surname.setFont(new Font("sanseriff", Font.PLAIN, 14));
        add(txt_surname);
        
        JLabel lbl_3 = new JLabel("OTHER NAMES");
        lbl_3.setBounds(640, 150, 200, 30);
        lbl_3.setFont(new Font("sanserif", Font.BOLD, 12));
        lbl_3.setForeground(Color.red);
        add(lbl_3);
        
        txt_othername = new JTextField();
        txt_othername.setBounds(740, 160, 150, 25);
        txt_othername.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(txt_othername);
        
        
        JLabel lbl_4 = new JLabel("MAT-NO");
        lbl_4.setBounds(20, 200, 200, 30);
        lbl_4.setFont(new Font("sanserif", Font.BOLD, 12));
        lbl_4.setForeground(Color.red);
        add(lbl_4);
        
        txt_matno = new JTextField();
        txt_matno.setBounds(150, 210, 150, 25);
        txt_matno.setFont(new Font("sanseriff", Font.PLAIN, 15));
        add(txt_matno);
        
        JLabel lbl_5 = new JLabel("TELEPHONE");
        lbl_5.setBounds(350, 200, 200, 30);
        lbl_5.setFont(new Font("sanserif", Font.BOLD, 12));
        add(lbl_5);
        
        txt_telephone = new JTextField();
        txt_telephone.setBounds(450, 210, 150, 25);
        txt_telephone.setFont(new Font("sanseriff", Font.PLAIN, 15));
        add(txt_telephone);
        
        JLabel lbl_6 = new JLabel("GENDER");
        lbl_6.setBounds(640, 200, 200, 30);
        lbl_6.setFont(new Font("sanserif", Font.BOLD, 12));
        add(lbl_6);
        
        String gender[] = {"Select","Male", "Female", "Others"};
        cmb_gender = new JComboBox(gender);
        cmb_gender.setBounds(740, 210, 150, 25);
        cmb_gender.setFont(new Font("sanserif", Font.PLAIN, 12));
        cmb_gender.setBackground(Color.WHITE);
        add(cmb_gender);
        
        JLabel lbl_7 = new JLabel("NATIONALITY");
        lbl_7.setBounds(20, 250, 200, 30);
        lbl_7.setFont(new Font("sanserif", Font.BOLD, 12));
        add(lbl_7);
        
        String nationality[] = {"Select","Sierra Leone", "Guinea", "Liberia","Kenya","Ghana"};
        cmb_nationality = new JComboBox(nationality);
        cmb_nationality.setBounds(150, 260, 150, 25);
        cmb_nationality.setFont(new Font("sanserif", Font.PLAIN, 12));
        cmb_nationality.setBackground(Color.WHITE);
        add(cmb_nationality);
          
        JLabel lbl_8 = new JLabel("ADDRESS");
        lbl_8.setBounds(350, 250, 200, 30);
        lbl_8.setFont(new Font("sanserif", Font.BOLD, 12));
        add(lbl_8);
        
        txt_address = new JTextField();
        txt_address.setBounds(450, 260, 150, 25);
        add(txt_address);
        
        JLabel lbl_9 = new JLabel("PARENT");
        lbl_9.setBounds(640, 250, 200, 25);
        lbl_9.setFont(new Font("sanserif", Font.BOLD, 12));
        lbl_9.setForeground(Color.red);
        add(lbl_9);
        
        txt_parent = new JTextField();
        txt_parent.setBounds(740, 260, 150, 25);
        add(txt_parent);
            
        JLabel lbl_10 = new JLabel("SCHOOL");
        lbl_10.setBounds(20, 300, 200, 25);
        lbl_10.setFont(new Font("sanserif", Font.BOLD, 12));
        lbl_10.setForeground(Color.red);
        add(lbl_10);
        
        
        cmb_school = new JComboBox<>();
        loadSchools();
        cmb_school.addActionListener(this);
        cmb_school.setBounds(150, 310, 150, 25);
        cmb_school.setFont(new Font("sanserif", Font.PLAIN, 12));
        cmb_school.setBackground(Color.WHITE);
        add(cmb_school);
        
        JLabel lbl_20 = new JLabel("DEPARTMENT");
        lbl_20.setBounds(350, 300, 200, 25);
        lbl_20.setFont(new Font("sanserif", Font.BOLD, 12));
        lbl_20.setForeground(Color.red);
        add(lbl_20);
        
       
        cmb_dept = new JComboBox<>();
        //loadPrograms();
        this.add(cmb_dept);
        cmb_dept.addActionListener(this);
        cmb_dept.setBounds(450, 310, 150, 25);
        cmb_dept.setFont(new Font("sanserif", Font.PLAIN, 12));
        cmb_dept.setBackground(Color.WHITE);
        add(cmb_dept);
        
        JLabel lbl_11 = new JLabel("PROGRAMME");
        lbl_11.setBounds(640, 300, 200, 25);
        lbl_11.setFont(new Font("sanserif", Font.BOLD, 12));
        add(lbl_11);
        
        //String program[] = {"Select","BSC.", "B.A","BSc(Hons)", "Higher Diploma","Certificate","MSc"};
        cmb_prog = new JComboBox<>();
        this.add(cmb_prog);
        cmb_prog.addActionListener(this);
        cmb_prog.setBounds(740, 310, 150, 25);
        cmb_prog.setFont(new Font("sanserif", Font.PLAIN, 12));
        cmb_prog.setBackground(Color.WHITE);
        add(cmb_prog);
        
        
        
        JLabel lbl_13 = new JLabel("PROGRAMME YR");
        lbl_13.setBounds(350, 350, 200, 25);
        lbl_13.setFont(new Font("sanserif", Font.BOLD, 12));
        add(lbl_13);
        
       // String prog_year[] = {"Select","1", "2", "3","4"};
        cmb_prog_year = new JComboBox<>();
        loadacademicYear();
        cmb_prog_year.addActionListener(this);
        cmb_prog_year.setBounds(450, 360, 150, 25);
        cmb_prog_year.setFont(new Font("sanserif", Font.PLAIN, 12));
        cmb_prog_year.setBackground(Color.WHITE);
        add(cmb_prog_year);
        
        JLabel lbl_14 = new JLabel("FUNDING");
        lbl_14.setBounds(640, 350, 200, 25);
        lbl_14.setFont(new Font("sanserif", Font.BOLD, 12));
        add(lbl_14);
        
        String funding[] = {"Select","Private", "Waiver", "SLG","Others"};
        cmb_fsupport = new JComboBox(funding);
        cmb_fsupport.setBounds(740, 360, 150, 25);
        cmb_fsupport.setFont(new Font("sanserif", Font.PLAIN, 12));
        cmb_fsupport.setBackground(Color.WHITE);
        add(cmb_fsupport);
                
        JLabel lbl_15 = new JLabel("AMOUNT PAID");
        lbl_15.setBounds(20, 350, 200, 25);
        lbl_15.setFont(new Font("sanserif", Font.BOLD, 12));
        add(lbl_15);
        
        txt_fee = new JTextField();
        txt_fee.setBounds(150, 360, 150, 25);
        add(txt_fee);
        
        back = new JButton("BACK(/MAIN MENU)");
        back.setBounds(50, 60, 200, 20);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(back);
        
        submit = new JButton("SUBMIT");
        submit.setBounds(250, 500, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("CANCEL");
        cancel.setBounds(450, 500, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        getRootPane().setDefaultButton(submit);
        
        setVisible(true);
        
    }
    //Loading Academic Years
    private void loadacademicYear() {
       if (cmb_prog_year == null){
       System.out.println("Error CmbSchool is null");
       return;
       }
    try {
        Conn con = new Conn();
        String query = "SELECT year_id,year_name FROM academic_years";
        pst = con.c.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
       
        cmb_prog_year.removeAllItems();  // Clear previous data
        cmb_prog_year.addItem("-- Select Year --");
       
        while (rs.next()) {
            String YearID = rs.getString("year_id");
            String yearname = rs.getString("year_name");
            System.out.println("Adding "+yearname);
            cmb_prog_year.addItem(rs.getString("year_name"));
        }
            System.out.println("Years loaded Successfully");
            
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    }
    
   private void loadSchools() {
       if (cmb_school == null){
       System.out.println("Error CmbSchool is null");
       return;
       }
    try {
        Conn con = new Conn();
        String query = "SELECT school_id,school_name FROM schools_tbl";
        pst = con.c.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
       
        cmb_school.removeAllItems();  // Clear previous data
        cmb_school.addItem("-- Select School --");
       
        while (rs.next()) {
            String schoolID = rs.getString("school_id");
            String schoolname = rs.getString("school_name");
            System.out.println("Adding "+schoolname);
            cmb_school.addItem(rs.getString("school_name"));
        }
            System.out.println("Schools loaded Successfully");
            
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
   //Loading Programs
    private void loadPrograms() {
        
        cmb_prog.removeAllItems(); 
        lblprogID.setText("");
        cmb_prog.addItem("-- Select Program --");
    String selecteddept = (String) cmb_prog.getSelectedItem();
    
    if (selecteddept == null || selecteddept.equals("-- Select Department --")){
       return;
       }

       try {
           Conn con = new Conn();
        
        String query = "SELECT program_id, program_name FROM program_tbl Where dept_id = ?";
        pst = con.c.prepareStatement(query);
        pst.setString(1, lbldeptID.getText());
        ResultSet rs = pst.executeQuery();

        

        while (rs.next()) {
            String programID = rs.getString("program_id");//testdebugging
            String progname = rs.getString("program_name");
            System.out.println("Loaded Dept "+programID);
            System.out.println("School ID is "+progname);//testdebugging
            cmb_prog.addItem(rs.getString("program_name"));
        }
            cmb_prog.revalidate();
            cmb_prog.repaint();
    } catch (Exception ex) {
        System.out.println("Error Loading Programs");
        ex.printStackTrace();
    }
}
   
   //Loading departments
    private void loadDepartments() {
    String selectedSchool = (String) cmb_school.getSelectedItem();
    
    if (selectedSchool == null || selectedSchool.equals("-- Select School --")){
       return;
       }

       try {
           Conn con = new Conn();
        
        String query = "SELECT s.school_id,d.dept_id,d.dept_name FROM departments_tbl d JOIN schools_tbl s ON d.school_id = s.school_id WHERE s.school_name = ?";
        pst = con.c.prepareStatement(query);
        pst.setString(1, selectedSchool);
        ResultSet rs = pst.executeQuery();

        cmb_dept.removeAllItems(); 
        cmb_dept.addItem("-- Select Department --");

        while (rs.next()) {
            String schoolID = rs.getString("school_id");//testdebugging
            String deptname = rs.getString("dept_name");
            System.out.println("Loaded Dept "+deptname);
            System.out.println("School ID is "+schoolID);//testdebugging
            cmb_dept.addItem(rs.getString("dept_name"));
        }
            cmb_dept.revalidate();
            cmb_dept.repaint();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}   
    
    
    @Override        
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == cmb_school){
            //loadDepartments();
            String selectedschool = (String) cmb_school.getSelectedItem();
                        if(selectedschool != null){
                            try {
                                Conn con = new Conn();
        
                                String query = "SELECT school_id FROM schools_tbl WHERE school_name = ?";
                            pst = con.c.prepareStatement(query);
                            pst.setString(1, selectedschool);
                            ResultSet rs = pst.executeQuery();
                                if(rs.next()){
                                    String schoolID = rs.getString("school_id");//testdebugging
                                    System.out.println("School ID is "+schoolID);//testdebugging
                                lblSchoolID.setText(rs.getString("school_id"));
                                loadDepartments();
                                }
                             } catch (Exception ex) {
                            ex.printStackTrace();
    }
                        }
        }
        else if 
               (ae.getSource() == cmb_dept){
            //loadDepartments();
            String selectedDept = (String) cmb_dept.getSelectedItem();
                        if(selectedDept != null){
                            try {
                                Conn con = new Conn();
        
                                String query = "SELECT dept_id FROM departments_tbl WHERE dept_name = ?";
                            pst = con.c.prepareStatement(query);
                            pst.setString(1, selectedDept);
                            ResultSet rs = pst.executeQuery();
                                if(rs.next()){
                                  String deptID = rs.getString("dept_id");//testdebugging 
                                  System.out.println("Dept ID is "+deptID);//testdebugging
                                lbldeptID.setText(rs.getString("dept_id"));
                                //loadDepartments(rs.getString("school_id"));
                                loadPrograms();
                                }
                             } catch (Exception ex) {
                            ex.printStackTrace();
    }
                        }
        }
        else if 
                (ae.getSource() == cmb_prog)
        {
            String selectedprog = (String) cmb_prog.getSelectedItem();
                        if(selectedprog != null){
                            try {
                                Conn con = new Conn();
        
                                String query = "SELECT program_id FROM program_tbl WHERE program_name = ?";
                            pst = con.c.prepareStatement(query);
                            pst.setString(1, selectedprog);
                            ResultSet rs = pst.executeQuery();
                                if(rs.next()){
                                    String progID = rs.getString("program_id");//testdebugging
                                    System.out.println("program ID is "+progID);//testdebugging
                                lblprogID.setText(rs.getString("program_id"));
                                
                                }
                             } catch (Exception ex) {
                            ex.printStackTrace();
    }
                        }
        }
        else if 
                (ae.getSource() == cmb_prog_year)
        {
            String selectedyr = (String) cmb_prog_year.getSelectedItem();
                        if(selectedyr != null){
                            try {
                                Conn con = new Conn();
        
                                String query = "SELECT year_id FROM academic_years WHERE year_name = ?";
                            pst = con.c.prepareStatement(query);
                            pst.setString(1, selectedyr);
                            ResultSet rs = pst.executeQuery();
                                if(rs.next()){
                                    String yrID = rs.getString("year_id");//testdebugging
                                    System.out.println("Year ID is "+yrID);//testdebugging
                                lblyrID.setText(rs.getString("year_id"));
                                
                                }
                             } catch (Exception ex) {
                            ex.printStackTrace();
    }
                        }
        }
        else if (ae.getSource() == submit) {           
            String academicYear,sname,oname,matno,tel,gender,nationality,
            address,parent,school,dept,program,fee,year,fsupport,major;
            
        academicYear = cmb_year.getSelectedItem().toString();
        sname = txt_surname.getText();
        oname = txt_othername.getText();
        matno = txt_matno.getText();
        tel = txt_telephone.getText();
        gender = cmb_gender.getSelectedItem().toString();
        nationality = cmb_nationality.getSelectedItem().toString();
        address = txt_address.getText();
        parent = txt_parent.getText();
        school = lblSchoolID.getText();
        dept = lbldeptID.getText();
        program = lblprogID.getText();
        year = lblyrID.getText();
        fsupport = cmb_fsupport.getSelectedItem().toString();
        fee = txt_fee.getText();
        //major = txt_fee.getText();
            
            try {
                 String query = "insert into student_registration_tbl values('"+academicYear+"', '"+matno+"', '"+sname+"', '"+oname+"', '"+tel+"', '"+gender+"', '"+nationality+"', '"+address+"', '"+parent+"', '"+school+"', '"+dept+"', '"+program+"', '"+year+"', '"+fsupport+"', '"+fee+"')";
           
           Conn con = new Conn();
           con.s.executeUpdate(query);
           
           JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
            
           txt_surname.setText(" ");
           txt_othername.setText(" ");
           txt_matno.setText(" ");
           txt_telephone.setText(" ");
           txt_address.setText(" ");
           txt_parent.setText(" ");
           txt_fee.setText(" ");
           txt_surname.requestFocus();
           
            //setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(ae.getSource() == back){
            Main_Menu ob = new Main_Menu();
            ob.setVisible(true);
            dispose();
            }
        else {
            setVisible(false);
        }
    }
    
    
    
    public static void main(String[] args) {
        new add_student();
        
    }
        }
 
                
                
                
