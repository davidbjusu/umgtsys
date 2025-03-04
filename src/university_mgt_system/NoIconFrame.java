/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university_mgt_system;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Baddest
 */

public class NoIconFrame {
    // Set a predefined icon path
    private static final String ICON_PATH = "C:\\Users\\Baddest\\OneDrive\\Documents\\NetBeansProjects\\Advanced_University_Mgt_System\\src\\icons\\njala logo.jpg"; // Replace with your actual path

    public static void setFrameIcon(JFrame frame) {
        // Load the image from the predefined path
        ImageIcon icon = new ImageIcon(ICON_PATH);
        // Set the image as the icon for the JFrame
        frame.setIconImage(icon.getImage());
    }
}