package edu.ucalgary.oop;

import java.awt.BorderLayout;

import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;

public class BackupVolunteerGUI extends JFrame implements ActionListener {

    private JLabel message;
    private JLabel explanation;

    public BackupVolunteerGUI(){
        super("Backup Volunteer"); //tab title
        setupGUI();
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        
    }
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
        // after they click to start the program this is hit
        super.dispose(); //take this out and add methods
        
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