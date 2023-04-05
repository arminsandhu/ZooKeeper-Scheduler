package edu.ucalgary.oop;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.util.*;

public class table_GUI extends JFrame implements ActionListener, MouseListener {

    //private JFrame = new JFrame();
    private JLabel message;
    private JLabel closingMessage;
     

    private TreeSet<String> ts1 = new TreeSet<>();
    private TreeSet<String> ts2 = new TreeSet<>();
    private TreeSet<String> ts3 = new TreeSet<>();
    private TreeSet<String> ts4 = new TreeSet<>();
    private TreeSet<String> ts5 = new TreeSet<>();
    private HashMap<String, TreeSet> hash = new HashMap<String, TreeSet>();
    private String[] columnNames = {"Hour", "Task description", "Qty", "Time spent", "Time available"};
    private Object[][] data = new Object[100][100];


    public table_GUI(){
        super("Completed Schedule"); //tab title
        setupGUI();
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        
    }

    public void setupGUI() {
        message = new JLabel("Zoo Schedule");
        closingMessage = new JLabel("Thank you for using the Zoo Scheduling Program.");
        //explanation = new JLabel("<html>This program will take in an sql database containing the requirements for a given days task.<br></br> The program will create an optimized and efficient hourly schedule.</html>");
        buildTreeSets();
        buildHash(); 
        System.out.println(hash);

        int row = 0;
        for (HashMap.Entry<String, TreeSet> entry : hash.entrySet()) {
            
            String hour = entry.getKey();
            TreeSet tasks = entry.getValue();

             for (Object uniqueTask : tasks) {
                //for real data, gain access to all these using getter hopefully
                // String taskDescription = "";
                // int quantity = 0;
                // int timeSpent = 0;
                // int timeAvailable = 0;
                // Object[] rowValues = {hour, taskDescription, quantity, timeSpent, timeAvailable};

                Object[] rowValues = {hour, uniqueTask, uniqueTask + "qty", uniqueTask + "ts", uniqueTask + "ta"}; //dp
                data[row] = rowValues;             
                
                row+=1;
            }            
        }
        
        // for ( int i = 0; data[i] != null && i < data.length - 1; i++) {
        //     for ( int j = 0; data[i][j] != null && j < data[i].length - 1; j++) {
        //         System.out.println(data[i][j]);
        //     }
        // }
        
        JTable table = new JTable(data, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());

        // JPanel clientPanel = new JPanel();
        // clientPanel.setLayout(new FlowLayout());

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());

        headerPanel.add(message);
        //clientPanel.add(table);
        bottomPanel.add(closingMessage);
        
        
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(table, BorderLayout.CENTER);
        //this.add(clientPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.PAGE_END); 
    }
   
    
    public void actionPerformed(ActionEvent event){
        // after they click to start the program this is hit
        JOptionPane.showMessageDialog(this, "Starting program ..."); //take this out and add methods
        
    }
    
    public void mouseClicked(MouseEvent event){
                
    }
    
    public void mouseEntered(MouseEvent event){
        
    }

    public void mouseExited(MouseEvent event){
        
    }

    public void mousePressed(MouseEvent event){
        
    }

    public void mouseReleased(MouseEvent event){
        
    }
    
    public void buildHash() {
        hash.put("1", ts1);
        hash.put("2", ts2);
        hash.put("3", ts3);
        hash.put("4", ts4);
        hash.put("5", ts5);

    }

    public void buildTreeSets() {
        //hash key 1
        ts1.add("A");
        ts1.add("B");
        ts1.add("C");

        //hash key 2
        ts2.add("D");
        ts2.add("E");
        ts2.add("F");

        //hash key 3
        ts3.add("G");
        ts3.add("H");
        ts3.add("I");

        //hash key 4
        ts4.add("J");
        ts4.add("K");
        ts4.add("L");

        //hash key 5
        ts5.add("M");
        ts5.add("N");
        ts5.add("O");


    };

    
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            new table_GUI().setVisible(true);        
        });

    }
        
}