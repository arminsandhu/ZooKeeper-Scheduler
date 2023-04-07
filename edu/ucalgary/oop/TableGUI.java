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
    private Object[][] data = new Object[100][5];
    private Object[][] noNullData;
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
        
        int row = 0;
        for (HashMap.Entry<Integer, TreeSet<FinalSchedule>> entry : hash.entrySet()) {
            
            Integer hour = entry.getKey();
            TreeSet<FinalSchedule> tasks = entry.getValue();


            for (FinalSchedule uniqueTask : tasks) {
                String taskDescription = uniqueTask.getDescription();
                Object quantity = 0;
                
                int timeSpent = uniqueTask.getTimeSpent();
                int timeAvailable = uniqueTask.getTimeAvailable();
                Object[] rowValues = {hour, taskDescription, quantity, timeSpent, timeAvailable};

                 
                for (int r = 0; r < data.length; r++) {


                    if (data[r][0] != null && rowValues[0] != null && data[row][2] != null) {

                        if (data[r][1] == rowValues[1] && data[r][0] == rowValues[0]) {
                            
                            if (data[r][1].toString().contains("Feed ") || data[r][1].toString().contains("Cleaning") ) {
                                quantity = (Integer) data[row][2] + 1;
                                rowValues[2] = quantity;
                                

                            }

                            else {
                                rowValues[2] = 1;
                                
                            }

                        }
                        
                        else {
                            continue;
                        }
                    }

                    else {
                        
                        data[row] = rowValues;
                    }
                }
                                                             
                row+=1;
            }
                
        }

        Object checkForZero = 0;
        Object checkForOne = 1;

        for (int ro = 0; ro < data.length; ro++) {
            if (data[ro][0] != null) {
                if (data[ro][2] == checkForZero || data[ro][2] == checkForOne) {
                    data[ro][2] = "-";
                }
            }
        }


        
        for (int dataRow = 1; dataRow < data.length; dataRow++) {
            for (int pastRow = dataRow - 1; pastRow < dataRow; pastRow++) {
                if (data[dataRow] != null && data[pastRow] != null && data[dataRow][1] != null && data[pastRow][1] != null) {    
                    
                    if (data[dataRow][1] == data[pastRow][1] && data[dataRow][0] == data[pastRow][0]) {
                        System.arraycopy(data, dataRow, data, pastRow, data.length - dataRow - 1);
                        data[data.length - 1] = null;
                        dataRow--;
                        break;
                        
                    }
                    
                }
            }
        }



        int rowCount = 0;
        for (int r = 0; r < data.length; r++) {
            if (data[r] != null) {
                if (data[r][0] != null)
                rowCount++;
            }
        }
        System.out.println(rowCount);

        noNullData = new Object[rowCount][5];

        
        for (int rw = 0; rw < rowCount; rw++) {
            System.arraycopy(data, rw, noNullData, rw, 1);
        }



        DefaultTableModel model = new DefaultTableModel(noNullData, columnNames) {
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