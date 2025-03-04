package university_mgt_system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.ResultSet;

public class add_student extends JFrame implements ActionListener{
    
    JTextField txt_surname,txt_othername,txt_matno,txt_telephone
              ,txt_address,txt_parent,txt_major,txt_fee;
    JDateChooser dcdob;
    JComboBox cmb_year,cmb_gender,cmb_nationality,cmb_school,cmb_program,cmb_prog_year,cmb_fsupport;
    JButton back,submit, cancel;
    
    
    
    add_student() {
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
        
        String school[] = {"Select","Technology", "Agriculture", "Medicine","Education","Social Sciences"};
        cmb_school = new JComboBox(school);
        cmb_school.setBounds(150, 310, 150, 25);
        cmb_school.setFont(new Font("sanserif", Font.PLAIN, 12));
        cmb_school.setBackground(Color.WHITE);
        add(cmb_school);
        
        JLabel lbl_11 = new JLabel("PROGRAM");
        lbl_11.setBounds(350, 300, 200, 25);
        lbl_11.setFont(new Font("sanserif", Font.BOLD, 12));
        add(lbl_11);
        
        String program[] = {"Select","BSC.", "B.A", "Higher Diploma","Certificate","MSc"};
        cmb_program = new JComboBox(program);
        cmb_program.setBounds(450, 310, 150, 25);
        cmb_program.setFont(new Font("sanserif", Font.PLAIN, 12));
        cmb_program.setBackground(Color.WHITE);
        add(cmb_program);
        
        JLabel lbl_12 = new JLabel("MAJOR");
        lbl_12.setBounds(640, 300, 200, 25);
        lbl_12.setFont(new Font("sanserif", Font.BOLD, 12));
        add(lbl_12);
        
        txt_major = new JTextField();
        txt_major.setBounds(740, 310, 150, 25);
        add(txt_major);
        
        JLabel lbl_13 = new JLabel("PROGRAM YEAR");
        lbl_13.setBounds(20, 350, 200, 25);
        lbl_13.setFont(new Font("sanserif", Font.BOLD, 12));
        add(lbl_13);
        
        String prog_year[] = {"Select","One", "Two", "Three","Four"};
        cmb_prog_year = new JComboBox(prog_year);
        cmb_prog_year.setBounds(150, 360, 150, 25);
        cmb_prog_year.setFont(new Font("sanserif", Font.PLAIN, 12));
        cmb_prog_year.setBackground(Color.WHITE);
        add(cmb_prog_year);
        
        JLabel lbl_14 = new JLabel("FUNDING");
        lbl_14.setBounds(350, 350, 200, 25);
        lbl_14.setFont(new Font("sanserif", Font.BOLD, 12));
        add(lbl_14);
        
        String funding[] = {"Select","Private", "Waiver", "SLG","Others"};
        cmb_fsupport = new JComboBox(funding);
        cmb_fsupport.setBounds(450, 360, 150, 25);
        cmb_fsupport.setFont(new Font("sanserif", Font.PLAIN, 12));
        cmb_fsupport.setBackground(Color.WHITE);
        add(cmb_fsupport);
                
        JLabel lbl_15 = new JLabel("AMOUNT PAID");
        lbl_15.setBounds(640, 350, 200, 25);
        lbl_15.setFont(new Font("sanserif", Font.BOLD, 12));
        add(lbl_15);
        
        txt_fee = new JTextField();
        txt_fee.setBounds(740, 360, 150, 25);
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
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {           
            String academicYear,sname,oname,matno,tel,gender,nationality,
            address,parent,school,program,major,year,fsupport,fee;
            
        academicYear = cmb_year.getSelectedItem().toString();
        sname = txt_surname.getText();
        oname = txt_othername.getText();
        matno = txt_matno.getText();
        tel = txt_telephone.getText();
        gender = cmb_gender.getSelectedItem().toString();
        nationality = cmb_nationality.getSelectedItem().toString();
        address = txt_address.getText();
        parent = txt_parent.getText();
        school = cmb_school.getSelectedItem().toString();
        program = cmb_program.getSelectedItem().toString();
        major = txt_major.getText();
        year = cmb_prog_year.getSelectedItem().toString();
        fsupport = cmb_fsupport.getSelectedItem().toString();
        fee = txt_fee.getText();
            
            try {
                 String query = "insert into student_registration_tbl values('"+academicYear+"', '"+matno+"', '"+sname+"', '"+oname+"', '"
           +tel+"', '"+gender+"', '"+nationality+"', '"+address+"', '"+parent+"', '"+school+"', '"+program+"', "
           + "'"+major+"', '"+year+"', '"+fsupport+"', '"+fee+"')";
           
           Conn con = new Conn();
           con.s.executeUpdate(query);
           
           JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
            
           txt_surname.setText(" ");
           txt_othername.setText(" ");
           txt_matno.setText(" ");
           txt_telephone.setText(" ");
           txt_address.setText(" ");
           txt_parent.setText(" ");
           txt_major.setText(" ");
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
