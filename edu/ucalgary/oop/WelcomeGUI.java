/**
 * ENSF 380 - L02 - Group 24 
@author Armin Sandhu<a href="mailto:armin.sandhu@ucalgary.ca">armin.sandhu@ucalgary.ca</a>
@author Dominico Mendes<a href="mailto:dominico.mendes@ucalgary.ca">dominico.mendes@ucalgary.ca</a>
@author Ella Boulanger<a href="mailto:ella.boulanger@ucalgary.ca">ella.boulanger@ucalgary.ca</a>
@author Raina Jugdev<a href="mailto:raina.jugdev@ucalgary.ca">raina.jugdev@ucalgary.ca</a>
@version 1.177
@since 1.0
*/
/*
 * The WelcomeGUI class extends JFrame and implements ActionListener. It creates a GUI window with a header,
 * a message, an explanation, and a submit button. When the submit button is clicked, it prompts the user with a
 * confirmation dialog box. If the user clicks "yes", the window is closed and the count down latch is decremented.
 * Has two class variables of type JLabel, message and explanation.
 * Has three class variables of type Jpanel, headerPanel, clientPanel and submitPanel.
 * Has one class variable of type JButton submitPanel.
 * Has one class variable of type CountDownLatch latch.
 */

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

    /**
     * Constructs a new WelcomeGUI object with the specified CountDownLatch.
     *
     * @param latch the countdown latch used to synchronize the program
     */
    public WelcomeGUI(CountDownLatch latch){
        super("Welcome to the Scheduling Program"); //tab title
        this.latch = latch;
        setupGUI();
        setSize(700,300);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           
    }

    /**
     * Sets up the GUI by creating the header, message, explanation, and submit button panels, adding them to the window,
     * and adding an ActionListener to the submit button.
     */
    public void setupGUI() {
        message = new JLabel("Welcome the the Zoo Scheduling Program.");
        explanation = new JLabel("<html>This program will take in an sql database containing the tasks required for each hour in a given day.<br></br>Please ensure the database is named EWR.<br></br>The program will create an optimized and efficient hourly schedule.</html>");
        
        explanation.setBounds(50, 50, 100, 40);
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

    /**
     * Called when the submit button is clicked. Prompts the user with a confirmation dialog box. If the user clicks "yes",
     * the window is closed and the count down latch is decremented.
     *
     * @param event the ActionEvent that triggered this method call
     */
    public void actionPerformed(ActionEvent event){
        super.dispose();  
        latch.countDown();
        // int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to start the program?", "Confirmation", JOptionPane.YES_NO_OPTION);
        // if(result == JOptionPane.YES_OPTION) {
        //     super.dispose();  
        //     latch.countDown();   
        // }
    }
}

