/**
 * ENSF 380 - L02 - Group 24 
@author Armin Sandhu<a href="mailto:armin.sandhu@ucalgary.ca">armin.sandhu@ucalgary.ca</a>
@author Dominico Mendes<a href="mailto:dominico.mendes@ucalgary.ca">dominico.mendes@ucalgary.ca</a>
@author Ella Boulanger<a href="mailto:ella.boulanger@ucalgary.ca">ella.boulanger@ucalgary.ca</a>
@author Raina Jugdev<a href="mailto:raina.jugdev@ucalgary.ca">raina.jugdev@ucalgary.ca</a>
@version 1.179
@since 1.0
*/
/*
* BackupVolunteerGUI is a class the creates the GUI prompt for the user to confirm
* the backup volunteer. It extends JFrame and implements the ActionListener interface.
* Has two class variables of type JLabel, message and explanation.
*/


package edu.ucalgary.oop;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class BackupVolunteerGUI extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JLabel message;
    private JLabel explanation;
    private CountDownLatch latch;

    /*
     * BackupVolunteerGUI constructor. Takes no arguments. Uses JFrame super to create a JFrame
     * window. Does basic JFrame setup.
     */
    public BackupVolunteerGUI(CountDownLatch latch, int startHour) {
        super("Backup Volunteer"); //tab title
        this.latch = latch;
        setupGUI(latch, startHour);
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /*
     * Void method setupGUI() takes no arguments. Creates a message and explanation for the GUI user prompt
     * Does all the setup for the GUI window and alls those to the window.
     */
    public void setupGUI(CountDownLatch latch, int startHour) {
        message = new JLabel("Backup Volunteer Request");
        String taskListTime = String.valueOf(startHour) + ":00";
        explanation = new JLabel("<html>The current task list for hour " + taskListTime + " cannot be completed by a single worker.<br></br>Please confirm a backup volunteer may be called.</html>");
    
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());
    
        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new FlowLayout());
    
        JButton submitInfo = new JButton("Click here to confirm backup volunteer");
        submitInfo.addActionListener(this);
            
        
        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());
        submitPanel.add(submitInfo);
    
        headerPanel.add(message);
        clientPanel.add(explanation);
        submitPanel.add(submitInfo);
    
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(clientPanel, BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.PAGE_END); 
    }
    
    /**
     * Called when the confirmation button is clicked. Prompts the user with a confirmation dialog box. If the user clicks "yes",
     * the window is closed and the count down latch is decremented.
     *
     * @param event the ActionEvent that triggered this method call
     */
    public void actionPerformed(ActionEvent event) {
        
        int result = JOptionPane.showConfirmDialog(this, "Can a backup volunteer be called?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            super.dispose(); 
            latch.countDown();   
        }
    }
}
