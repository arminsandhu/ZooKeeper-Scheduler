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
 * Main class. Executes the main functionality of the program and has some methods to help with execution. 
 */

package edu.ucalgary.oop;

import java.io.IOException;
import java.util.*;
import java.awt.EventQueue;
import java.util.concurrent.CountDownLatch;


public class Main {
    private ScheduleBuilder schedule;
    private CreateArrayList instance;
    private static int[] iterationsList;

    public Main() {

    }
    public boolean reset() {

        //call method to populate treatmentsArray
        schedule.setTreatmentsArray();

        setIterationsList();
        
        instance = new CreateArrayList(schedule);
        instance.fillArrays();
        instance.addScheduledTreaments(iterationsList);
        
        // HERE IS THE LINE TO CALL THE CHANGEDB THING!!!!!!!!!!!!!!!!!!
        // ADD THIS LINE TO THE LOGIC
        //ChangingDB changeDB = new ChangingDB(schedule.getConnection(), treatment.getTaskID(), myClass);

        for (int hour = 0; hour < 24; hour++) {
            // System.out.println(hour);
            // System.out.println(schedule.getTimeRemaining());

            if (schedule.getTimeRemaining() > 0) {
                schedule.checkTreatments(hour, schedule, instance);
                schedule.checkPreppedFeeding(hour, schedule, instance);
                schedule.checkFeeding(hour, schedule, instance);
                schedule.checkCleaning(hour, schedule, instance);
                TreeSet<FinalSchedule> reverseOrder = new TreeSet<>(Collections.reverseOrder());
                reverseOrder.addAll(schedule.getFinalTree());
                schedule.setFinalTree(reverseOrder);
                schedule.setFinalSchedule(hour, schedule.getFinalTree());
                // for (FinalSchedule s : schedule.getFinalTree()) {
                //     System.out.println(s.getDescription() + "   -   " + s.getUniqueId());
                //     count++;
                // }
                schedule.setTimeRemaining(60);
                schedule.setTimeCompleted(0);
                schedule.resetFinalTree();
            }  
        }
        return true;
    }

    public static void main(String[] args) {
        //print gui welcome message
        CountDownLatch latch = new CountDownLatch(1);
        WelcomeGUI gui = new WelcomeGUI(latch);
        gui.setVisible(true);
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // code after the latch has been released will continue to run
        System.out.println("Button has been pressed.");

        //make schedule object of class ScheduleBuilder 
        Main myClass = new Main();
        myClass.schedule = new ScheduleBuilder();
        myClass.schedule.createConnection();
                //call method to popoulate animalsArray
        myClass.schedule.setAnimalsArray();
                //call method to populate tasksArray
        myClass.schedule.setTasksArray();
        //call method createConnection()
        //schedule.createConnection(); // may need to throw exception here
        boolean output = myClass.reset();

        if (output) {
        myClass.createOutput(myClass); }
        // // ella and armin added to print txt file
        // try {
        //     new TextFileOutput(myClass.schedule);
        // } catch (IOException e) {
        //     System.out.println("There was an error.");
        //     e.printStackTrace();
        // }
        // // ella and armin added to print txt file

        // //ella added to make gui table
        // EventQueue.invokeLater(() -> {
        //     TableGUI tableGUI = new TableGUI(myClass.schedule);
        //     tableGUI.setVisible(true);        
        // });
        // //ella added to make gui table
    }
    public void setIterationsList() {
        int p;
        iterationsList = new int[schedule.getTreatmentsArray().size()];
        for (p = 0; p< schedule.getTreatmentsArray().size(); p++) {
            iterationsList[p] = p;
        }
    }

    public void createOutput(Main myClass) {
        // ella and armin added to print txt file
        try {
            new TextFileOutput(myClass.schedule);
        } catch (IOException e) {
            System.out.println("There was an error.");
            e.printStackTrace();
        }
        // ella and armin added to print txt file
        
        //ella added to make gui table
        EventQueue.invokeLater(() -> {
            TableGUI tableGUI = new TableGUI(myClass.schedule);
            tableGUI.setVisible(true);        
        });
        //ella added to make gui table
    }
}
