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
 * ChangingDB class extends JFrame. This class creates a query to update the database
 * when the treatment tasks within an hour exceed 120 minutes. All class variables are private.
 */

package edu.ucalgary.oop;
import javax.swing.*;
import java.sql.*;
   
public class ChangingDB extends JFrame {

    private JComboBox<Integer> hourComboBox;
    private int inputHour;
    private Connection dbConnection; 
    private int treatmentID;
    private Main myClass;

    /*
     * Constructor ChangingDB takes arguments in the types (Connection, int, Main) and uses the
     * JFrame super to construct the GUI window. Sets local private class variables. 
     */
    public ChangingDB(Connection dbConnection, int treatmentID, Main myClass) {
        super("Hour Selection");
        this.dbConnection = dbConnection;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        this.treatmentID = treatmentID;
        this.myClass = myClass;
        
        hourComboBox = new JComboBox<>(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
                                                      13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23});
        
        JPanel hourPanel = new JPanel();
        hourPanel.setLayout(new BoxLayout(hourPanel, BoxLayout.Y_AXIS));
        hourPanel.add(new JLabel("You have too many tasks in this hour. Please select a later start hour."));
        hourPanel.add(Box.createVerticalStrut(10)); // Add a small vertical space
        hourPanel.add(new JLabel("Hour:"));
        hourPanel.add(hourComboBox);
        
        // Create a button to confirm the selection
        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(e -> {
            this.inputHour = (int) hourComboBox.getSelectedItem();
            JOptionPane.showMessageDialog(this, "You selected hour " + this.inputHour);
            dispose();
            updateDB(inputHour);
        });
        
        // Create a panel to hold the confirm button
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(confirmButton);
        
        // Add the panels to the frame
        getContentPane().add(hourPanel, "North");
        getContentPane().add(buttonPanel, "South");
        
        setVisible(true);
    }

    /*
     * Void method updateDB takes an integer argument. This method creates a query
     * to update the database. It updates the starthour of a treatment that does not
     * fit in the current hour to have a new starthour.
     */
    public void updateDB(int inputHour) {
        try {
            // Update a row in the database
            String updateQuery = "UPDATE TREATMENTS SET StartHour = ? WHERE TreatmentID = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(updateQuery);
            preparedStatement.setInt(1, inputHour);
            preparedStatement.setInt(2, treatmentID);
            preparedStatement.executeUpdate();
            
            System.out.println("Row updated successfully");
            myClass.reset();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // try {
            //     if (dbConnection != null) {
            //         dbConnection.close();
            //     }
            // } catch (SQLException e) {
            //     e.printStackTrace();
            // }
        }
    }
}



