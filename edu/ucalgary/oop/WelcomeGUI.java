package edu.ucalgary.oop;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;

public class WelcomeGUI extends JFrame implements ActionListener {

    private JLabel message;
    private JLabel explanation;
    private JPanel headerPanel = new JPanel();
    private JPanel clientPanel = new JPanel();
    private JPanel submitPanel = new JPanel();
    private JButton submitInfo = new JButton("Click here to start the program");


    public WelcomeGUI(){
        super("Welcome to the Scheduling Program"); //tab title
        setupGUI();
        setSize(500,300);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        
    }
    public void setupGUI() {
        message = new JLabel("Welcome the the Zoo Scheduling Program.");
        explanation = new JLabel("<html>This program will take in an sql database containing the requirements for a given days task.<br></br> The program will create an optimized and efficient hourly schedule.</html>");

        headerPanel.setLayout(new FlowLayout());
        clientPanel.setLayout(new FlowLayout());

        submitInfo.addActionListener(this);
        
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
            
}