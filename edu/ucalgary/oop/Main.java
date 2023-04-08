package edu.ucalgary.oop;

import java.io.IOException;
//import java.sql.*;
import java.util.*;
import java.awt.EventQueue;


public class Main {
    private ScheduleBuilder schedule;
    private CreateArrayList instance;
    private static int[] iterationsList;

    public void reset() {

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
                schedule.checkPreppedFeeding(hour, instance);
                schedule.checkFeeding(hour, instance);
                schedule.checkCleaning(hour, instance);
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
    }

    public static void main(String[] args) {
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
        myClass.reset();

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
    public void setIterationsList() {
        int p;
        iterationsList = new int[schedule.getTreatmentsArray().size()];
        for (p = 0; p< schedule.getTreatmentsArray().size(); p++) {
            iterationsList[p] = p;
        }
    }
}
