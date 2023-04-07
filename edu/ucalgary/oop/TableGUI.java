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
                int quantity = 0;
                int timeSpent = uniqueTask.getTimeSpent();
                int timeAvailable = uniqueTask.getTimeAvailable();
                Object[] rowValues = {hour, taskDescription, quantity, timeSpent, timeAvailable};

                 
                for (int r = 0; r < data.length; r++) {

                    // if (r != 0 && data[r][0] != data[r - 1][0]) {
                    //     quantity = 0;
                    // }

                    if (data[r][0] != null && rowValues[0] != null && data[row][2] != null && (Integer) data[row][2] + 1 != 0) {

                        // if (r != 0 && data[r][1] != data[r - 1][1]) {
                        //     quantity = 0;
                        // }

                        if (data[r][1] == rowValues[1] && data[r][0] == rowValues[0]) {
                            quantity = (Integer) data[row][2] + 1;
                            rowValues[2] = quantity;

                            data[row] = rowValues;
                        }
                        
                        else {
                            continue;
                        }
                    }

                    else {
                        data[row] = rowValues;
                    }
                }
                
                // data[row] = rowValues;
                
                             
                row+=1;
            }
                
        }

        //

        // Object[][] reversedData = new Object[data.length][5];
        // int ro = 0;
        // for (int w = data.length - 1; w >= 0; w--) {
        //     for (int g = 0; g < data[w].length - 1; g++ ) {
        //         if (reversedData[ro][g] == null) {
        //             break;
        //         }

        //         reversedData[ro][g] = data[w][g];
        //     }
        //     ro++;
        // }

        //now get rid of duplicates at data[row][1] 
        
            // for (int dataRow = 1; dataRow < data.length; dataRow++) {
            //     for (int pastRow = 0; pastRow < dataRow; pastRow++) {
            //         if (data[dataRow] != null && data[pastRow] != null && data[dataRow][1] != null && data[pastRow][1] != null) {
            //             if (data[dataRow][1] == data[pastRow][1] && data[dataRow][0] == data[pastRow][0]) {
            //                 System.arraycopy(data, dataRow + 1, data, dataRow, data.length - dataRow - 1);
            //                 data[data.length - 1] = null; // or new int[0];
            //                 dataRow--; // adjust the index to avoid skipping the next row
            //                 break; // stop checking past rows since the match is found
                            
            //             }
                        
            //         }
            //     }
            // }

            // for (int dataRow = 1; dataRow < reversedData.length; dataRow++) {
            //     for (int pastRow = 0; pastRow < dataRow; pastRow++) {
            //         if (reversedData[dataRow] != null && reversedData[pastRow] != null && reversedData[dataRow][1] != null && reversedData[pastRow][1] != null) {
            //             if (data[dataRow][1] == reversedData[pastRow][1] && reversedData[dataRow][0] == reversedData[pastRow][0]) {
            //                 System.arraycopy(reversedData, dataRow + 1, reversedData, dataRow, reversedData.length - dataRow - 1);
            //                 reversedData[reversedData.length - 1] = null; // or new int[0];
            //                 dataRow--; // adjust the index to avoid skipping the next row
            //                 break; // stop checking past rows since the match is found
                            
            //             }
                        
            //         }
            //     }
            // }

        //reverse it back
        // int rw = 0;
        // for (int w = reversedData.length - 1; w >= 0; w--) {
        //     for (int g = 0; g < reversedData[w].length - 1; g++ ) {
        //         if (data[rw][g] == null) {
        //             break;
        //         }

        //         data[rw][g] = reversedData[w][g];
        //     }
        //     rw++;
        // }
            
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