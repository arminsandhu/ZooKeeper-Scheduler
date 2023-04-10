package edu.ucalgary.oop;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.CountDownLatch;
import java.awt.FlowLayout;

public class WelcomeGUI extends JFrame implements ActionListener {

    private JLabel message;
    private JLabel explanation;
    private JPanel headerPanel = new JPanel();
    private JPanel clientPanel = new JPanel();
    private JPanel submitPanel = new JPanel();
    private JButton submitInfo = new JButton("Click here to start the program");
    private CountDownLatch latch;

    public WelcomeGUI(CountDownLatch latch){
        super("Welcome to the Scheduling Program"); //tab title
        this.latch = latch;
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
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to start the program?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if(result == JOptionPane.YES_OPTION) {
            super.dispose(); //take this out and add methods  
            latch.countDown();   
        }
    }
}
