package edu.ucalgary.oop;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


import java.awt.event.*;
import java.awt.FlowLayout;
import java.util.*;

public class TableGUI extends JFrame implements ActionListener {

   
    private JLabel message;
    private JLabel closingMessage;
    
    private String[] columnNames = {"Hour", "Task description", "Qty", "Time spent", "Time available"};
    private Object[][] data = new Object[100][100];
    private HashMap<Integer, TreeSet<FinalSchedule>> hash;


    public TableGUI(ScheduleBuilder schedule) {
        super("Completed Schedule"); //tab title
        this.hash = schedule.getFinalSchedule();
        
        setupGUI();
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        
    };

    public void setupGUI() {
        message = new JLabel("Zoo Schedule");
        closingMessage = new JLabel("Thank you for using the Zoo Scheduling Program.");
        //explanation = new JLabel("<html>This program will take in an sql database containing the requirements for a given days task.<br></br> The program will create an optimized and efficient hourly schedule.</html>");
        
        int row = 0;
        for (HashMap.Entry<Integer, TreeSet<FinalSchedule>> entry : hash.entrySet()) {
            
            Integer hour = entry.getKey();
            TreeSet<FinalSchedule> tasks = entry.getValue();


            for (FinalSchedule uniqueTask : tasks) {
                //for real data, gain access to all these using getter hopefully
                String taskDescription = uniqueTask.getDescription();
                int quantity = uniqueTask.getQuantity();
                int timeSpent = uniqueTask.getTimeSpent();
                int timeAvailable = uniqueTask.getTimeAvailable();
                Object[] rowValues = {hour, taskDescription, quantity, timeSpent, timeAvailable};

                data[row] = rowValues;
                             
                row+=1;
            }
                
        }
        
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        JTable table = new JTable(model);


        JScrollPane scrollPane = new JScrollPane(table);
        

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());

        headerPanel.add(message);
        
        bottomPanel.add(closingMessage);
        
        
        this.add(headerPanel, BorderLayout.NORTH);
        
        add(scrollPane, BorderLayout.CENTER);
        
        this.add(bottomPanel, BorderLayout.PAGE_END); 
    }
    
    public void actionPerformed(ActionEvent event){
        // after they click to start the program this is hit
        JOptionPane.showMessageDialog(this, "Starting program ..."); //take this out and add methods
        
    }
            
}