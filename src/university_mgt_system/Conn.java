package university_mgt_system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;

    Conn () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://umgtsys-db.cjiwygm4wndl.eu-north-1.rds.amazonaws.com:3306/umgtsys-db", "root", "davidjusu218");
            s = c.createStatement();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
