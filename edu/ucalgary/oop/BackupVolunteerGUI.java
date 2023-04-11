package edu.ucalgary.oop;

import java.awt.BorderLayout;

import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.CountDownLatch;
import java.awt.FlowLayout;

public class BackupVolunteerGUI extends JFrame {
    /*
     * BackupVolunteerGUI is a class the creates the GUI prompt for the user to confirm
     * the backup volunteer. It extends JFrame and implements the ActionListener interface.
     * Has two class variables of type JLabel, message and explanation.
     */

    private JLabel message;
    private JLabel explanation;
    private CountDownLatch latch;


    /*
     * BackupVolunteerGUI constructor. Takes no arguments. Uses JFrame super to create a JFrame
     * window. Does basic JFrame setup.
     */
    public BackupVolunteerGUI(CountDownLatch latch, int startHour){
        super("Backup Volunteer"); //tab title
        setupGUI(latch, startHour);
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.latch = latch;  
      
    }

    /*
     * Void method setupGUI() takes no arguments. Creates a message and explanation for the GUI user prompt
     * Does all the setup for the GUI window and alls those to the window.
     */
    public void setupGUI(CountDownLatch latch, int startHour) {
        message = new JLabel("Backup Volunteer Request");
        System.out.println(String.valueOf(startHour));
        String taskListTime = String.valueOf(startHour) + ":00";
        explanation = new JLabel("<html>The current task list for " + taskListTime + " cannot be completed by a single worker.<br></br>Please confirm a backup volunteer may be called.</html>");

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());

        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new FlowLayout());

        JButton submitInfo = new JButton("Click here to confirm backup volunteer");
        
        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());

        headerPanel.add(message);
        clientPanel.add(explanation);
        submitPanel.add(submitInfo);

        this.add(headerPanel, BorderLayout.NORTH);
        this.add(clientPanel, BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.PAGE_END); 
    }
} 
