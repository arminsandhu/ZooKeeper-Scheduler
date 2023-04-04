package edu.ucalgary.oop;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;

public class WelcomeGUI extends JFrame implements ActionListener {

    private JLabel message;
    private JLabel explanation;

    public WelcomeGUI(){
        super("Welcome to the Scheduling Program"); //tab title
        setupGUI();
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        
    }
    public void setupGUI() {
        message = new JLabel("Welcome the the Zoo Scheduling Program.");
        explanation = new JLabel("<html>This program will take in an sql database containing the requirements for a given days task.<br></br> The program will create an optimized and efficient hourly schedule.</html>");

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());

        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new FlowLayout());

        JButton submitInfo = new JButton("Click here to start the program");
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
        JOptionPane.showMessageDialog(this, "Starting program ..."); //take this out and add methods
        
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
    
    
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            new WelcomeGUI().setVisible(true);        
        });

    }
        
}