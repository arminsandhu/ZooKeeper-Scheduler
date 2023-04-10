package edu.ucalgary.oop;

import java.awt.BorderLayout;

import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.CountDownLatch;
import java.awt.FlowLayout;

public class BackupVolunteerGUI extends JFrame implements ActionListener {
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
    public BackupVolunteerGUI(CountDownLatch latch){
        super("Backup Volunteer"); //tab title
        setupGUI();
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.latch = latch;       
        
    }

    /*
     * Void method setupGUI() takes no arguments. Creates a message and explanation for the GUI user prompt
     * Does all the setup for the GUI window and alls those to the window.
     */
    public void setupGUI() {
        message = new JLabel("Backup Volunteer Request");
        explanation = new JLabel("<html>The current task list for HOUR connot be completed by a single worker.<br></br>Please confirm a backup volunteer may be called.</html>");

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());

        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new FlowLayout());

        JButton submitInfo = new JButton("Click here to confirm backup volunteer");
        submitInfo.addActionListener(this);

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());

        headerPanel.add(message);
        clientPanel.add(explanation);
        submitPanel.add(submitInfo);

        this.add(headerPanel, BorderLayout.NORTH);
        this.add(clientPanel, BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.PAGE_END); 
    }
   
    
    public void actionPerformed(ActionEvent event){
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to start the program?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if(result == JOptionPane.YES_OPTION) {
            super.dispose(); //take this out and add methods  
            latch.countDown();   
        }
        
    }
    
    // public void mouseClicked(MouseEvent event){
                
    // }
    
    // public void mouseEntered(MouseEvent event){
        
    // }

    // public void mouseExited(MouseEvent event){
        
    // }

    // public void mousePressed(MouseEvent event){
        
    // }

    // public void mouseReleased(MouseEvent event){
        
    // }
    
    
    
    // public static void main(String[] args) {
        
    //     EventQueue.invokeLater(() -> {
    //         new BackupVolunteerGUI().setVisible(true);        
    //     });

    // }
        
}