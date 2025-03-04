package university_mgt_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class update_student extends JFrame implements ActionListener{
    
    JTextField txt_surname,txt_othername,txt_telephone,txt_address,txt_major,txt_fee,
            cmb_program,cmb_fsupport,cmb_school,cmb_prog_year;
    JButton back,submit, cancel;
    Choice cmatno;
    JLabel lbl_academic_year,lbl_matno,lbl_gender,lbl_nationality,lbl_parent;
    
    update_student() {
        
        setSize(900, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(300, 10, 500, 40);
        heading.setFont(new Font("sanserif", Font.PLAIN, 35));
        add(heading);
        
        JLabel lbl_mat = new JLabel("SELECT MAT-NO");
        lbl_mat.setBounds(50, 100, 200, 20);
        lbl_mat.setFont(new Font("sanserif", Font.PLAIN, 20));
        add(lbl_mat);
        
        cmatno = new Choice();
        cmatno.setBounds(250, 100, 200, 20);
        add(cmatno);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student_registration_tbl");
            while(rs.next()) {
                cmatno.add(rs.getString("mat_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lbl_1 = new JLabel("Academic Year");
        lbl_1.setBounds(20, 150, 120, 30);
        lbl_1.setFont(new Font("sanserif", Font.BOLD, 15));
        add(lbl_1);
        
        lbl_academic_year = new JLabel();
        lbl_academic_year.setBounds(150, 160, 150, 25);
        lbl_academic_year.setFont(new Font("sanserif", Font.BOLD, 14));
        add(lbl_academic_year);
        
        JLabel lbl_2 = new JLabel("Surname");
        lbl_2.setBounds(350, 150, 200, 30);
        lbl_2.setFont(new Font("sanserif", Font.BOLD, 15));
        add(lbl_2);
        
        txt_surname = new JTextField();
        txt_surname.setBounds(450, 160, 150, 25);
        txt_surname.setFont(new Font("sanseriff", Font.PLAIN, 14));
        add(txt_surname);
        
        JLabel lbl_3 = new JLabel("other Name");
        lbl_3.setBounds(620, 150, 200, 30);
        lbl_3.setFont(new Font("sanserif", Font.BOLD, 14));
        add(lbl_3);
        
        txt_othername = new JTextField();
        txt_othername.setBounds(720, 160, 150, 25);
        txt_othername.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(txt_othername);
        
        
        JLabel lbl_4 = new JLabel("Mat No");
        lbl_4.setBounds(20, 200, 200, 30);
        lbl_4.setFont(new Font("sanserif", Font.BOLD, 15));
        add(lbl_4);
        
        lbl_matno = new JLabel();
        lbl_matno.setBounds(150, 210, 150, 25);
        lbl_matno.setFont(new Font("sanseriff", Font.PLAIN, 15));
        add(lbl_matno);
        
        JLabel lbl_5 = new JLabel("Telephone");
        lbl_5.setBounds(350, 200, 200, 30);
        lbl_5.setFont(new Font("sanserif", Font.BOLD, 15));
        add(lbl_5);
        
        txt_telephone = new JTextField();
        txt_telephone.setBounds(450, 210, 150, 25);
        txt_telephone.setFont(new Font("sanseriff", Font.PLAIN, 15));
        add(txt_telephone);
        
        JLabel lbl_6 = new JLabel("Gender");
        lbl_6.setBounds(620, 200, 200, 30);
        lbl_6.setFont(new Font("sanserif", Font.BOLD, 15));
        add(lbl_6);
        
        lbl_gender = new JLabel();
        lbl_gender.setBounds(720, 210, 150, 25);
        add(lbl_gender);
        
        JLabel lbl_7 = new JLabel("Nationality");
        lbl_7.setBounds(20, 250, 200, 30);
        lbl_7.setFont(new Font("sanserif", Font.BOLD, 15));
        add(lbl_7);
        
        lbl_nationality = new JLabel();
        lbl_nationality.setBounds(150, 260, 150, 25);
        add(lbl_nationality);
        
        JLabel lbl_8 = new JLabel("Address");
        lbl_8.setBounds(350, 250, 200, 30);
        lbl_8.setFont(new Font("sanserif", Font.BOLD, 15));
        add(lbl_8);
        
        txt_address = new JTextField();
        txt_address.setBounds(450, 260, 150, 25);
        add(txt_address);
        
        JLabel lbl_9 = new JLabel("Parent");
        lbl_9.setBounds(620, 250, 200, 25);
        lbl_9.setFont(new Font("sanserif", Font.BOLD, 15));
        add(lbl_9);
        
        lbl_parent = new JLabel();
        lbl_parent.setBounds(720, 260, 150, 25);
        lbl_parent.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(lbl_parent);
        
        JLabel lbl_10 = new JLabel("School");
        lbl_10.setBounds(20, 300, 200, 25);
        lbl_10.setFont(new Font("sanserif", Font.BOLD, 15));
        add(lbl_10);
        
        cmb_school = new JTextField();
        cmb_school.setBounds(150, 310, 150, 25);
        cmb_school.setFont(new Font("sanserif", Font.PLAIN, 12));
        cmb_school.setBackground(Color.WHITE);
        add(cmb_school);
        
        JLabel lbl_11 = new JLabel("Program");
        lbl_11.setBounds(350, 300, 200, 25);
        lbl_11.setFont(new Font("sanserif", Font.BOLD, 15));
        add(lbl_11);
        
        
        cmb_program = new JTextField();
        cmb_program.setBounds(450, 310, 150, 25);
        cmb_program.setFont(new Font("sanserif", Font.PLAIN, 12));
        cmb_program.setBackground(Color.WHITE);
        add(cmb_program);
        
        JLabel lbl_12 = new JLabel("Major");
        lbl_12.setBounds(620, 300, 200, 25);
        lbl_12.setFont(new Font("sanserif", Font.BOLD, 15));
        add(lbl_12);
        
        txt_major = new JTextField();
        txt_major.setBounds(720, 310, 150, 25);
        add(txt_major);
        
        JLabel lbl_13 = new JLabel("PROGRAM YEAR");
        lbl_13.setBounds(20, 350, 200, 25);
        lbl_13.setFont(new Font("sanserif", Font.BOLD, 15));
        add(lbl_13);
        
        
        cmb_prog_year = new JTextField();
        cmb_prog_year.setBounds(150, 360, 150, 25);
        cmb_prog_year.setFont(new Font("sanserif", Font.PLAIN, 12));
        cmb_prog_year.setBackground(Color.WHITE);
        add(cmb_prog_year);
        
        JLabel lbl_14 = new JLabel("Funding");
        lbl_14.setBounds(350, 350, 200, 25);
        lbl_14.setFont(new Font("sanserif", Font.BOLD, 15));
        add(lbl_14);
        
        
        cmb_fsupport = new JTextField();
        cmb_fsupport.setBounds(450, 360, 150, 25);
        cmb_fsupport.setFont(new Font("sanserif", Font.PLAIN, 12));
        cmb_fsupport.setBackground(Color.WHITE);
        add(cmb_fsupport);
        
        JLabel lbl_15 = new JLabel("Amount Paid");
        lbl_15.setBounds(620, 350, 200, 25);
        lbl_15.setFont(new Font("sanserif", Font.BOLD, 15));
        add(lbl_15);
        
        txt_fee = new JTextField();
        txt_fee.setBounds(720, 360, 150, 25);
        add(txt_fee);
        
        try {
            Conn c = new Conn();
            String query = "select * from student_registration_tbl where mat_no='"+cmatno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lbl_academic_year.setText(rs.getString("academic-year"));
                txt_surname.setText(rs.getString("surname"));
                txt_othername.setText(rs.getString("othername"));
                lbl_matno.setText(rs.getString("mat_no"));
                txt_telephone.setText(rs.getString("telephone"));
                lbl_gender.setText(rs.getString("gender"));
                lbl_nationality.setText(rs.getString("nationality"));
                txt_address.setText(rs.getString("address"));
                lbl_parent.setText(rs.getString("parent"));
                cmb_school.setText(rs.getString("school"));
                cmb_program.setText(rs.getString("program"));
                txt_major.setText(rs.getString("major"));
                cmb_prog_year.setText(rs.getString("year"));
                cmb_fsupport.setText(rs.getString("fsupport"));
                txt_fee.setText(rs.getString("fee"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        cmatno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from student_registration_tbl where mat_no='"+cmatno.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        lbl_academic_year.setText(rs.getString("academic-year"));
                        txt_surname.setText(rs.getString("surname"));
                        txt_othername.setText(rs.getString("othername"));
                        lbl_matno.setText(rs.getString("mat_no"));
                        txt_telephone.setText(rs.getString("telephone"));
                        lbl_gender.setText(rs.getString("address"));
                        lbl_nationality.setText(rs.getString("nationality"));
                        txt_address.setText(rs.getString("address"));
                        lbl_parent.setText(rs.getString("parent"));
                        cmb_school.setText(rs.getString("school"));
                        cmb_program.setText(rs.getString("program"));
                        txt_major.setText(rs.getString("major"));
                        cmb_prog_year.setText(rs.getString("year"));
                        cmb_fsupport.setText(rs.getString("fsupport"));
                        txt_fee.setText(rs.getString("fee"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        
        back = new JButton("BACK(/MAIN MENU)");
        back.setBounds(50, 60, 200, 20);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(back);
        
        submit = new JButton("Update");
        submit.setBounds(250, 500, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 500, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String sname,oname,matno,tel,
            address,school,program,major,year,fsupport,fee;
            
        matno = lbl_matno.getText();
        sname = txt_surname.getText();
        oname = txt_othername.getText();
        tel = txt_telephone.getText();
        address = txt_address.getText();
        school = cmb_school.getText();
        program = cmb_program.getText();
        major = txt_major.getText();
        year = cmb_prog_year.getText();
        fsupport = cmb_fsupport.getText();
        fee = txt_fee.getText();
            
            try {
                String query = "update student_registration_tbl set surname='"+sname+"', othername='"+oname+"', telephone='"+tel+"', address='"+address+"', "
                + "school='"+school+"', program='"+program+"', "
                + "major='"+major+"', year='"+year+"', fsupport='"+fsupport+"', fee='"+fee+"' where mat_no='"+matno+"'";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Student Details Updated Successfully");
                setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(ae.getSource() == back){
            Main_Menu ob = new Main_Menu();
            ob.setVisible(true);
            dispose();
            }
        else {
            System.exit(0);
            
        }
    }
    
    public static void main(String[] args) {
        new update_student();
    }
}
