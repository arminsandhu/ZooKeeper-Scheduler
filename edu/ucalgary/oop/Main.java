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

    /*
     * Empty constructor for Main. No args.
     */
    public Main() { }


    /*
     * Returns true and contains functions calls to iterate per hour of the day to build the final schedule.
     */
    public boolean reset() {
        schedule.setTreatmentsArray();
        setIterationsList();
        instance = new CreateArrayList(schedule);
        instance.fillArrays();
        instance.addScheduledTreaments(iterationsList);

        for (int hour = 0; hour < 24; hour++) {
            if (schedule.getTimeRemaining() > 0) {
                schedule.checkTreatments(hour, schedule, instance);
                schedule.checkPreppedFeeding(hour, schedule, instance);
                schedule.checkFeeding(hour, schedule, instance);
                schedule.checkCleaning(hour, schedule, instance);
                TreeSet<FinalSchedule> reverseOrder = new TreeSet<>(Collections.reverseOrder());
                reverseOrder.addAll(schedule.getFinalTree());
                schedule.setFinalTree(reverseOrder);
                schedule.setFinalSchedule(hour, schedule.getFinalTree());
                schedule.setTimeRemaining(60);
                schedule.setTimeCompleted(0);
                schedule.resetFinalTree();
            }  
        }
        return true;
    }

    /*
     * Void main method that runs the entire program.
     */
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1);
        WelcomeGUI gui = new WelcomeGUI(latch);
        gui.setVisible(true);
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Button has been pressed.");

        Main myClass = new Main();
        myClass.schedule = new ScheduleBuilder();
        myClass.schedule.createConnection();
        myClass.schedule.setAnimalsArray();
        myClass.schedule.setTasksArray();
        boolean output = myClass.reset();

        if (output) {
        myClass.createOutput(myClass); }
    }


    /*
     * Void method that sets the iterations list which helps create the unique ids of each task.
     */
    public void setIterationsList() {
        int p;
        iterationsList = new int[schedule.getTreatmentsArray().size()];
        for (p = 0; p< schedule.getTreatmentsArray().size(); p++) {
            iterationsList[p] = p;
        }
    }

    /**
     * Void method that outputs the final schedule to the user through GUI and the creation of the .txt file.
     * @param myClass - the inputted Main object used to access the final schedule created.
     */
    public void createOutput(Main myClass) {
        try {
            new TextFileOutput(myClass.schedule);
        } catch (IOException e) {
            System.out.println("There was an error.");
            e.printStackTrace();
        }
        EventQueue.invokeLater(() -> {
            TableGUI tableGUI = new TableGUI(myClass.schedule);
            tableGUI.setVisible(true);        
        });
    }
}
