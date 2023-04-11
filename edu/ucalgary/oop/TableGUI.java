/**
 * ENSF 380 - L02 - Group 24 
@author Armin Sandhu<a href="mailto:armin.sandhu@ucalgary.ca">armin.sandhu@ucalgary.ca</a>
@author Dominico Mendes<a href="mailto:dominico.mendes@ucalgary.ca">dominico.mendes@ucalgary.ca</a>
@author Ella Boulanger<a href="mailto:ella.boulanger@ucalgary.ca">ella.boulanger@ucalgary.ca</a>
@author Raina Jugdev<a href="mailto:raina.jugdev@ucalgary.ca">raina.jugdev@ucalgary.ca</a>
@version 1.177
@since 1.0
*/
/** Class TableGUI extends JFrame and implements ActionListener, it's responsible for creating 
 * and displaying the completed schedule table in the user interface.
 * Has two class variables of type JLabel, message and closingMessage.
 * Has a class variable of type String[], columnNames.
 * Has two class variables of type Object[][], data and noNullData.
 * Has a class variable of type HashMap<Integer, TreeSet<FinalSchedule>>, hash.
 * Has two class variables of type String, taskDescription and animalName.
 * Has a class variable of type Object, quantity.
 * Has two class variables of type int, timeSpent and timeAvailable.
 * */

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
    
    private String[] columnNames = {"Hour", "Task description", "Animal Name", "Qty", "Time spent", "Time available"};
    private Object[][] data = new Object[100][5];
    private Object[][] noNullData;
    private HashMap<Integer, TreeSet<FinalSchedule>> hash;

    private String taskDescription;
    private String animalName;
    private Object quantity;
    private int timeSpent;
    private int timeAvailable;
    private String startHour;
    
    /**
     * Constructor for the TableGUI class.
     * @param schedule ScheduleBuilder object containing the final schedule data
     */
    public TableGUI(ScheduleBuilder schedule) {
        super("Completed Schedule"); //tab title
        this.hash = schedule.getFinalSchedule();
        
        setupGUI();
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        
    };



    

    /**
     * Sets up the GUI components for the table.
     */
    public void setupGUI() {
        message = new JLabel("Zoo Schedule");
        closingMessage = new JLabel("Thank you for using the Zoo Scheduling Program.");
        
        setUpTableData();

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
    


    /**
     * ActionListener method to perform an action when a button is clicked.
     * @param event ActionEvent object representing the button click
     */
    public void actionPerformed(ActionEvent event){
        // after they click to start the program this is hit
        JOptionPane.showMessageDialog(this, "Starting program ..."); //take this out and add methods
        
    }


    /**
     * A method that sets up the data for the JTable.
     */
    public void setUpTableData() {
        
        int row = 0;
        for (HashMap.Entry<Integer, TreeSet<FinalSchedule>> entry : hash.entrySet()) {
            
            Integer hour = entry.getKey();
            TreeSet<FinalSchedule> tasks = entry.getValue();

            int timeSpent = 0;
            for (FinalSchedule uniqueTask : tasks) {
                timeSpent = uniqueTask.getTimeSpent();
            }

            if (timeSpent > 60) {
                startHour = hour.toString() + ":00 [+ backup volunteer]";
            }
            else {
                startHour = hour.toString() + ":00";
            }

            for (FinalSchedule uniqueTask : tasks) {
                
                //startHour = hour;
                taskDescription = uniqueTask.getDescription();
                animalName = uniqueTask.getNickname();
                quantity = 0;
                timeSpent = uniqueTask.getTimeSpent();
                timeAvailable = uniqueTask.getTimeAvailable();
                Object[] rowValues = {startHour, taskDescription, animalName, quantity, timeSpent, timeAvailable};

                for (int r = 0; r < data.length; r++) {
                    
                    if (data[r][0] != null && rowValues[0] != null && data[row][2] != null) {
                        if (data[r][1] == rowValues[1] && data[r][0] == rowValues[0]) {   
                            if (data[r][1].toString().contains("Feed ") || data[r][1].toString().contains("Cleaning") ) {
                                
                                // updating quantities
                                if (data[r][1] != data[r - 1][1]) {
                                    quantity = 1;
                                    rowValues[3] = quantity;
                                    rowValues[2] = "-";
                                }  
                                else {
                                    quantity = (Integer) data[row][3] + 1;
                                    rowValues[3] = quantity;
                                    rowValues[2] = "-";
                                }
                            }
                            else {
                                rowValues[3] = 1;         
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

        replaceSingleQuantities();
        

        groupCleaningAndFeeding();


        eliminateNullRows();
        
        // Object lastHourLabel = 0;
        // for (int rw = 0; rw < noNullData.length; rw++) {
        //     if (rw > 0) {
                
        //          if (noNullData[rw - 1][0] == noNullData[rw][0]) {
        //              noNullData[rw][0] = " ";
        //          }
        //         if (noNullData[rw - 1][0] == " " && ) {
        //             noNullData[rw][0] = lastHourLabel;
        //         }
        //         else {
        //             lastHourLabel = noNullData[rw][0];
        //         }
                
        //     }
        //     else {
        //         lastHourLabel = noNullData[rw][0]
        //     }
        // }
        
    }



    /**
     * Replaces values in the quantity values of the data array with a hyphen ("-") for rows that 
     * have a quantity of 0 or 1 and are not feeding or cleanining tasks.
     */
    public void replaceSingleQuantities() {

        Object checkForZero = 0;
        Object checkForOne = 1;

        for (int ro = 0; ro < data.length; ro++) {
            if (data[ro][0] != null) {
                if (data[ro][3] == checkForZero || data[ro][3] == checkForOne) {
                    if (!data[ro][1].toString().contains("Feed ") && !data[ro][1].toString().contains("Cleaning") ) {
                        data[ro][3] = "-";
                    }
                }
            }
        }
    }

    
    /**
     * This method groups feeding and cleaning tasks within the data array.
     * It takes the last instance of a duplicate, so that the quantity and time variables are correct.
     */
    public void groupCleaningAndFeeding() {
        // if duplicate
        for (int dataRow = 1; dataRow < data.length; dataRow++) {
            for (int pastRow = dataRow - 1; pastRow < dataRow; pastRow++) {
                if (data[dataRow] != null && data[dataRow] != null) {
                    if (data[dataRow][1] != null && data[dataRow][1] != null) {
                        if (data[dataRow][1].toString().contains("Feed ") || data[dataRow][1].toString().contains("Cleaning") ) {
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
                }
            }
        }
    }


    /**
     * This method eliminates any null rows from the array that will be used to create the table.
     * It counts the number of rows without null values in them, then creates a new array of that many rows.
     * It then fills the new array with all the values from the original array.
     */
    public void eliminateNullRows() {
        int rowCount = 0;
        for (int r = 0; r < data.length; r++) {
            if (data[r] != null) {
                if (data[r][0] != null)
                rowCount++;
            }
        }

        noNullData = new Object[rowCount][5];

        for (int rw = 0; rw < rowCount; rw++) {
            System.arraycopy(data, rw, noNullData, rw, 1);
        }
    }

         
}