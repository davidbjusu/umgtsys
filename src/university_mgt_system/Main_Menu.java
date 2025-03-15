package university_mgt_system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main_Menu extends JFrame implements ActionListener {

    Main_Menu() {
        
        NoIconFrame.setFrameIcon(this);
        setSize(1000, 600);
        setLocation(200, 50);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        JMenuBar mb = new JMenuBar();
        
        // New Information
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);
        
        JMenuItem lecturer_info = new JMenuItem("New Lecturer Information");
        lecturer_info.setBackground(Color.WHITE);
        lecturer_info.addActionListener(this);
        newInformation.add(lecturer_info);
        
        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);
        
        // Details
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.RED);
        mb.add(details);
        
        JMenuItem lecturer_details = new JMenuItem("View Lecturer Details");
        lecturer_details.setBackground(Color.WHITE);
        lecturer_details.addActionListener(this);
        details.add(lecturer_details);
        
        JMenuItem studentdetails = new JMenuItem("View Student Details");
        studentdetails.setBackground(Color.WHITE);
        studentdetails.addActionListener(this);
        details.add(studentdetails);
        
        // Leave
        JMenu leave = new JMenu("Leave Application");
        leave.setForeground(Color.BLUE);
        mb.add(leave);
        
        JMenuItem facultyleave = new JMenuItem("Apply for Leave");
        facultyleave.setBackground(Color.WHITE);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);
        
        
        
        // Leave Details
        JMenu leaveDetails = new JMenu("View Leave Applications");
        leaveDetails.setForeground(Color.RED);
        mb.add(leaveDetails);
        
        JMenuItem lecturer_leave_details = new JMenuItem("Lecturer Leave");
        lecturer_leave_details.setBackground(Color.WHITE);
        lecturer_leave_details.addActionListener(this);
        leaveDetails.add(lecturer_leave_details);
        
        
        // Exams
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLUE);
        mb.add(exam);
        
        JMenuItem examinationdetails = new JMenuItem("View Examination Results");
        examinationdetails.setBackground(Color.WHITE);
        examinationdetails.addActionListener(this);
        exam.add(examinationdetails);
        
        JMenuItem entermarks = new JMenuItem("Enter Marks");
        entermarks.setBackground(Color.WHITE);
        entermarks.addActionListener(this);
        exam.add(entermarks);
        
        // UpdateInfo
        JMenu updateInfo = new JMenu("Update Application Details");
        updateInfo.setForeground(Color.RED);
        mb.add(updateInfo);
        
        JMenuItem update_lecturer_info = new JMenuItem("Update Faculty Details");
        update_lecturer_info.setBackground(Color.WHITE);
        update_lecturer_info.addActionListener(this);
        updateInfo.add(update_lecturer_info);
        
        JMenuItem updatestudentinfo = new JMenuItem("Update Student Details");
        updatestudentinfo.setBackground(Color.WHITE);
        updatestudentinfo.addActionListener(this);
        updateInfo.add(updatestudentinfo);
        
        // fee
        JMenu fee = new JMenu("Fees Payment");
        fee.setForeground(Color.BLUE);
        mb.add(fee);
        
        JMenuItem feestructure = new JMenuItem("View Fee Structure");
        feestructure.setBackground(Color.WHITE);
        feestructure.addActionListener(this);
        fee.add(feestructure);
        
        JMenuItem feeform = new JMenuItem("Student Fee Form");
        feeform.setBackground(Color.WHITE);
        feeform.addActionListener(this);
        fee.add(feeform);
        
        // Utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.RED);
        mb.add(utility);
        
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);
        
        JMenuItem gradepoint = new JMenuItem("Grade Point Calculator");
        gradepoint.setBackground(Color.WHITE);
        gradepoint.addActionListener(this);
        utility.add(gradepoint);
        
        // about
        JMenu about = new JMenu("About");
        about.setForeground(Color.BLUE);
        mb.add(about);
        
        JMenuItem ab = new JMenuItem("About");
        ab.setBackground(Color.WHITE);
        ab.addActionListener(this);
        about.add(ab);
        
        // exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.RED);
        mb.add(exit);
        
        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);
        
        setJMenuBar(mb);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        
        if (msg.equals("Exit")) {
        System.exit(0);
        //setVisible(false);
        }  else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                
            }
        } 
        else if (msg.equals("New Lecturer Information")) {
            add_lecturer ob = new add_lecturer();
            ob.setVisible(true);
            
            
        } else if (msg.equals("New Student Information")) {
            add_student ob = new add_student();
            ob.setVisible(true);
        } else if (msg.equals("View Lecturer Details")) {
            lecturer_details ob = new lecturer_details();
            ob.setVisible(true);
        } else if (msg.equals("View Student Details")) {
            student_details ob = new student_details();
            ob.setVisible(true);
            dispose();
        } else if (msg.equals("Apply for Leave")) {
            lecturer_leave ob = new lecturer_leave();
            ob.setVisible(true);
        }  else if (msg.equals("Lecturer Leave")) {
           lecturer_leave_details ob = new lecturer_leave_details();
           ob.setVisible(true);
        }  else if (msg.equals("Update Lecturer Details")) {
            update_lecturer ob = new update_lecturer();
            ob.setVisible(true);
        } else if (msg.equals("Update Student Details")) {
            update_student ob =new update_student();
            ob.setVisible(true);
            dispose();
        } else if (msg.equals("Enter Marks")) {
            enter_grades ob = new enter_grades();
            ob.setVisible(true);
            dispose();
        } else if (msg.equals("View Examination Results")) {
            exam_info ob = new exam_info();
            ob.setVisible(true);
            dispose();
        }    else if (msg.equals("Grade Point Calculator")){
            grade_point_checker ob = new grade_point_checker();
            ob.setVisible(true);
            dispose();
        }  else if (msg.equals("About")) {
           about_app ob = new about_app();
           ob.setVisible(true);
        } else if (msg.equals("Student Fee Form")) {
           student_fee ob = new student_fee();
           ob.setVisible(true);
           dispose();
        }
    }

    public static void main(String[] args) {
        new Main_Menu();
    }
}
