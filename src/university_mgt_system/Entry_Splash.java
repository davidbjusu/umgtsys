package university_mgt_system;

import javax.swing.*;
import java.awt.*;

public class Entry_Splash extends JFrame implements Runnable {
    
    Thread t;
    Entry_Splash () {
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/njala_splash01.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        NoIconFrame.setFrameIcon(this);
        
        t = new Thread(this);
        t.start();
        
        setVisible(true);
        
        int x = 1;
        for (int i = 2; i <= 600; i+=4, x+=1) {
            setLocation(600 - ((i + x)/2), 330 - (i/2));
            setSize(i + 2*x, i + x/2);
            
            try {
                Thread.sleep(20);
            } catch (Exception e) {}
        }        
    }
    
    public void run() {
        try {
            Thread.sleep(6000);
            setVisible(false);
            
            // Next Frame
            new Login();
        } catch (Exception e) {
            
        }
    }
    
    public static void main(String[] args) {
        new Entry_Splash();
    }
}
