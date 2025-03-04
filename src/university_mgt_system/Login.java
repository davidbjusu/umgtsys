package university_mgt_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class Login extends JFrame implements ActionListener{

    JButton login, cancel;
    JTextField tfusername, tfpassword;
    JComboBox txtusertype;
    
    Login () {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel lblicon = new JLabel("Njala University Management System Login");
        lblicon.setFont(new Font("serif", Font.BOLD, 20));
        lblicon.setBounds(100, 0, 400, 40);
        add(lblicon);
        
        JLabel lblusertype = new JLabel("Usertype");
        lblusertype.setBounds(40, 80, 200, 30);
        
        add(lblusertype);
        
        String users[] = {"Administrator"};
        txtusertype = new JComboBox(users);
        txtusertype.setBounds(150, 80, 150, 30);
        txtusertype.setBackground(Color.WHITE);
        add(txtusertype);
        
      
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 130, 100, 20);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 130, 150, 20);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 160, 100, 20);
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 160, 150, 20);
        add(tfpassword);
        
        login = new JButton("Login");
        login.setBounds(40, 200, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(login);
       
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 200, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 40, 200, 200);
        add(image);
        
        
        NoIconFrame.setFrameIcon(this);
        setSize(600, 350);
       // setLocation(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        
        getRootPane().setDefaultButton(login);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            
            String query = "select * from userlogin_tbl where username='"+username+"' and password='"+password+"'";
            
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null,"Login Succesful");
                    setVisible(false);
                    new Main_Menu();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(true);
                    tfusername.setText("");
                    tfpassword.setText("");
                    tfusername.requestFocus();
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            System.exit(0);
            //setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
        new NoIconFrame();
        
    }
}
