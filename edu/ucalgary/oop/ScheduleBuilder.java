/**
 * ENSF 380 - L02 - Group 24 
@author Armin Sandhu<a href="mailto:armin.sandhu@ucalgary.ca">armin.sandhu@ucalgary.ca</a>
@author Dominico Mendes<a href="mailto:dominico.mendes@ucalgary.ca">dominico.mendes@ucalgary.ca</a>
@author Ella Boulanger<a href="mailto:ella.boulanger@ucalgary.ca">ella.boulanger@ucalgary.ca</a>
@author Raina Jugdev<a href="mailto:raina.jugdev@ucalgary.ca">raina.jugdev@ucalgary.ca</a>
@version 1.182
@since 1.0
*/
/*
 * ScheduleBuilder is a java class that implements the key logic and functionality of the program's
 * scheduling. It include methods to assist in the functionality as well as methods to sort the tasks
 * by their importance in the final schedule.
 */

package edu.ucalgary.oop;

import java.sql.*;
import java.util.*;
import java.util.concurrent.CountDownLatch;

public class ScheduleBuilder {
    private Connection dbConnection;
    private ResultSet results;
    private ArrayList<Animal> animalsArray;
    private ArrayList<Treatment> treatmentsArray;
    private ArrayList<Task> tasksArray;
    private HashMap<Integer, TreeSet<FinalSchedule>> finalSchedule = new HashMap<Integer, TreeSet<FinalSchedule>>();
    private int iterator = 0;
    private static int[] iterationsList;
    private int timeRemaining = 60;
    private int timeCompleted = 0;
    private int count = 0;
    private TreeSet<FinalSchedule> finalTree = new TreeSet<>();
    
    /*
     * Empty constructor for ScheduleBuilder
     */
    public ScheduleBuilder(){ }


    /*
     * Void method that creates the connection to the database. No args.
     */
    public void createConnection(){    
        try{
            // connects to database EWR with user 'oop', password 'password'
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/EWR", "oop", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /*
     * Void method that sets the animals array using the database. No args.
     */
    public void setAnimalsArray() {
        this.animalsArray = new ArrayList<Animal>();
        try {                    
            Statement myStmt = dbConnection.createStatement();
            results = myStmt.executeQuery("SELECT * FROM animals");
            while (results.next()){          
                int animalID = results.getInt("AnimalID");
                String animalNickname = results.getString("AnimalNickname");
                String animalSpecies = results.getString("AnimalSpecies");
                animalsArray.add(new Animal(animalID, animalNickname, animalSpecies));
            }
            
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    /*
     * Void method that sets the treatments array using the database. No args.
     */
    public void setTreatmentsArray() {
        treatmentsArray = new ArrayList<Treatment>(); 
        int i = 0;
        try {                    
            Statement myStmt = dbConnection.createStatement();
            results = myStmt.executeQuery("SELECT * FROM treatments");
            
            // this may be not work
            while (results.next()){                
                treatmentsArray.add(new Treatment(this.iterator, results.getInt("AnimalID"), 
                    results.getInt("TaskID"), results.getInt("StartHour")));
                this.iterator++;
                i++;
            }
            
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    /*
     * Void method that sets the task array using the database. No args.
     */
    public void setTasksArray() {
        tasksArray = new ArrayList<Task>();
        try {                    
            Statement myStmt = dbConnection.createStatement();
            results = myStmt.executeQuery("SELECT * FROM tasks");
            
            while (results.next()){                
               tasksArray.add(new Task(results.getInt("TaskID"), results.getString("Description"), results.getInt("Duration"), results.getInt("Maxwindow")));
            }
            
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    /*
     * Returns the ArrayList<Animal> animals array. No args.
     */
    public ArrayList<Animal> getAnimalsArray() {
        return this.animalsArray;
    }

    /*
     * Returns the ArrayList<Treatment> treatment array. No args.
     */
    public ArrayList<Treatment> getTreatmentsArray() {
        return this.treatmentsArray;
    }

    /*
     * Returns the ArrayList<Task> task array. No args.
     */
    public ArrayList<Task> getTasksArray() {
        return this.tasksArray;
    }


    /*
     * Returns the integer iterator. No args.
     */
    public int getIterator() {
        return this.iterator;
    }

    
    /*
     * Returns the HashMap<Integer, TreeSet<FinalSchedule>> final schedule. No args.
     */
    public HashMap<Integer, TreeSet<FinalSchedule>> getFinalSchedule() {
        return this.finalSchedule;
    }

    /*
     * Returns the TreeSet<FinalSchedule> finalTree. No args.
     */
    public TreeSet<FinalSchedule> getFinalTree() {
        return this.finalTree;
    }

    /*
     * Void method that resets finalTree to a new TreeSet. No args.
     */
    public void resetFinalTree() {
        this.finalTree = new TreeSet<>();
    }

    /**
     * Void method that sets finalTree
     * @param finalTree - the inputted TreeSet<FinalSchedule> to set to finalTree
     */
    public void setFinalTree(TreeSet<FinalSchedule> finalTree) {
        this.finalTree = finalTree;
    }


    /**
     * Void method that sets the treatments array
     * @param treatmentsArray - the inputted ArrayList<Treatment> to set to treatmentsArray
     */
    public void setTreatmentsArray(ArrayList<Treatment> treatmentsArray) {
        this.treatmentsArray = treatmentsArray;
    }

    /**
     * Void method that sets the tasks array
     * @param array - the inputted ArrayList<Tasks> to set to tasksArray
     */
    public void setTasksArray(ArrayList<Task> array) {
        this.tasksArray = array;
    }

    /**
     * Void method that sets the animal array
     * @param array - the inputted ArrayList<Animal> to set to animalsArray
     */
    public void setAnimalsArray(ArrayList<Animal> array) {
        this.animalsArray = array;
    }

    /**
     * Void method that adds an (integer hour, TreeSet<FinalSchedule> finalTree) pair to the final schedule
     * @param finalTree - the inputted TreeSet<FinalSchedule> to put into finalSchedule
     */
    public void setFinalSchedule(int hour,TreeSet<FinalSchedule> finalTree) {
        this.finalSchedule.put(hour, finalTree);
    }

    /**
     * Void method that sets the iterations list.
     * @param schedule - the inputted ScheduleBuilder object to get access to treatmentsArray
     */
    public void setIterationsList(ScheduleBuilder schedule) {
        int p;
        iterationsList = new int[treatmentsArray.size()];
        for (p = 0; p< schedule.treatmentsArray.size(); p++) {
            iterationsList[p] = p;
        }
    }

    /*
     * Returns the database connection Connection object. No args.
     */
    public Connection getConnection() {
        return this.dbConnection;
    }

    /*
     * Returns the integer count. No args.
     */
    public int getCount() {
        return this.count;
    }

    /*
     * Void method that sets the count to 1.
     */
    public void setCount() {
        this.count = 1;
    }

    /*
     * Void method that resets the count to 0.
     */
    public void resetCount() {
        this.count = 0;
    }

    /**
     * Void method to set the backup GUI pop up to visible.
     */
    public void backupGUI(int startHour) {

        CountDownLatch latch = new CountDownLatch(1);
        BackupVolunteerGUI gui = new BackupVolunteerGUI(latch, startHour);
        gui.setVisible(true);
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Void method that adds applicable treatments tasks to the finalTree
     * @param hour - the inputted hour used as a key for (FINISH)
     * @param schedule - the inputted ScheduleBuilder object to get access to methods of schedule builder.
     * @param instance - the inputted CreateArrayList object to get access to the scheduled tasks array.
     */
    public void checkTreatments(int hour, ScheduleBuilder schedule, CreateArrayList instance) {
        int timeRemaining = schedule.getTimeRemaining();
        int timeCompleted = schedule.getTimeCompleted();
        int count = schedule.getCount();
        String nickname = "No nickname available";
        for (Treatment treatment : schedule.getTreatmentsArray()) {
            if (treatment.getStartHour() <= hour) {
                for (IsScheduled item : instance.getIsScheduledTasks()) { //tasksArray is an array list of all task objects
                    if (item.getIsScheduled() == false) {
                        if (item.getUniqueID() == treatment.getUniqueID()) {
                            for (Task task : tasksArray) {
                                if (task.getTaskId() == treatment.getTaskID()) {
                                    if (timeRemaining == 0) {
                                        if (count < 1) {
                                            for (IsScheduled i : instance.getIsScheduledTasks()) {
                                                if (i.getIsScheduled() == false) {
                                                    if (i.getUniqueID() == treatment.getUniqueID()) {
                                                        if (treatment.getStartHour() <= hour) {
                                                            backupGUI(treatment.getStartHour());
                                                            schedule.setCount();
                                                            schedule.setTimeRemaining(120);
                                                            schedule.setTimeCompleted(0);
                                                            for (IsScheduled in : instance.getIsScheduledTasks()) {
                                                                for (Treatment treat : schedule.getTreatmentsArray()) {
                                                                    if (treat.getStartHour() <= hour) {
                                                                        for (FinalSchedule f : schedule.getFinalTree()) {
                                                                            if (treat.getUniqueID() == f.getUniqueId() && in.getUniqueID() == f.getUniqueId()) {
                                                                                in.setFalse();
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            schedule.resetFinalTree();
                                                            schedule.checkTreatments(hour, schedule, instance);
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        else {
                                            break;
                                        }
                                    }
                                    if (timeRemaining >= 0 && timeRemaining < task.getDuration()) {
                                        if (count < 1) {
                                            for (IsScheduled i : instance.getIsScheduledTasks()) {
                                                if (i.getIsScheduled() == false) {
                                                    if (i.getUniqueID() == treatment.getUniqueID()) {
                                                        if (treatment.getStartHour() <= hour) {
                                                            schedule.setCount();
                                                            schedule.setTimeRemaining(120);
                                                            schedule.setTimeCompleted(0);
                                                            backupGUI(treatment.getStartHour());
                                                            for (IsScheduled in : instance.getIsScheduledTasks()) {
                                                                for (Treatment treat : schedule.getTreatmentsArray()) {
                                                                    if (treat.getStartHour() <= hour) {
                                                                        for (FinalSchedule f : schedule.getFinalTree()) {
                                                                            if (treat.getUniqueID() == f.getUniqueId() && in.getUniqueID() == f.getUniqueId()) {
                                                                                in.setFalse();
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            schedule.resetFinalTree();
                                                            schedule.checkTreatments(hour, schedule, instance);
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        continue;
                                    }
                                    else if (timeRemaining > task.getDuration()) {
                                        timeRemaining -= task.getDuration();
                                        timeCompleted += task.getDuration();
                                        setTimeRemaining(timeRemaining);
                                        setTimeCompleted(timeCompleted);
                                        for (Animal animal : schedule.getAnimalsArray()) {
                                            if (treatment.getAnimalID() == animal.getAnimalId()) {
                                                nickname = animal.getAnimalNickname();
                                            }
                                        }
                                        FinalSchedule finalTask = new FinalSchedule(treatment.getUniqueID(), task.getDescription(), 4, timeCompleted, timeRemaining, nickname);
                                        finalTree.add(finalTask);
                                        item.setIsScheduled();
                                    }
                                    else if (timeRemaining == task.getDuration()) {
                                        timeRemaining -= task.getDuration();
                                        timeCompleted += task.getDuration();
                                        setTimeRemaining(timeRemaining);
                                        setTimeCompleted(timeCompleted);
                                        for (Animal animal : schedule.getAnimalsArray()) {
                                            if (treatment.getAnimalID() == animal.getAnimalId()) {
                                                nickname = animal.getAnimalNickname();
                                            }
                                        }
                                        FinalSchedule finalTask = new FinalSchedule(treatment.getUniqueID(), task.getDescription(), 4, timeCompleted, timeRemaining, nickname);
                                        finalTree.add(finalTask);
                                        item.setIsScheduled();
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        schedule.resetCount();
    }

    /**
     * Void method that adds applicable prepped feeding tasks to the finalTree to be scheduled by the txt and gui.
     * @param hour - the inputted hour used as a key for (FINISH)
     * @param instance - the inputted CreateArrayList object to get access to the scheduled tasks array
     */
    public void checkPreppedFeeding(int hour, ScheduleBuilder schedule, CreateArrayList instance) {
        int timeRemaining = getTimeRemaining();
        int timeCompleted = getTimeCompleted();
        int countFox = 0;
        int countCoyote = 0;
        String nickname = "No nickname available";
        for (PreppedFeeding prep : instance.getPreppedFeedingTasks()) {
            if (prep.getStartHour() <= hour) {
                for (IsScheduled item : instance.getIsScheduledTasks()) { //tasksArray is an array list of all task objects
                    if (item.getIsScheduled() == false) {
                        if (item.getUniqueID() == prep.getUniqueID()) {
                            if (timeRemaining >= 0 && timeRemaining < prep.getDuration()) {
                                continue;
                            }
                            else if (timeRemaining > prep.getDuration()) {
                                if (prep.getDescription() == "Feed foxes" && countFox != 1) {
                                    timeRemaining -= prep.getDuration();
                                    timeRemaining -= prep.getPrepTime();
                                    timeCompleted += prep.getDuration();
                                    timeCompleted += prep.getPrepTime();
                                    countFox = 1;
                                }

                                else if (prep.getDescription() == "Feed coyotes" && countCoyote != 1) {
                                    timeRemaining -= prep.getDuration();
                                    timeRemaining -= prep.getPrepTime();
                                    timeCompleted += prep.getDuration();
                                    timeCompleted += prep.getPrepTime();
                                    countCoyote = 1;
                                }
                                else {
                                    timeRemaining -= prep.getDuration();
                                    timeCompleted += prep.getDuration();
                                }
                                
                                setTimeRemaining(timeRemaining);
                                setTimeCompleted(timeCompleted);
                                for (Animal animal : schedule.getAnimalsArray()) {
                                    if (prep.getAnimalID() == animal.getAnimalId()) {
                                        nickname = animal.getAnimalNickname();
                                    }
                                }
                                FinalSchedule finalTask = new FinalSchedule(prep.getUniqueID(), prep.getDescription(), 4, timeCompleted, timeRemaining, nickname);
                                finalTree.add(finalTask);
                                item.setIsScheduled();
                            }
                            else if (timeRemaining == prep.getDuration()) {
                                
                                timeRemaining -= prep.getDuration();
                                timeCompleted += prep.getDuration();
                                setTimeRemaining(timeRemaining);
                                setTimeCompleted(timeCompleted);
                                for (Animal animal : schedule.getAnimalsArray()) {
                                    if (prep.getAnimalID() == animal.getAnimalId()) {
                                        nickname = animal.getAnimalNickname();
                                    }
                                }
                                FinalSchedule finalTask = new FinalSchedule(prep.getUniqueID(), prep.getDescription(), 4, timeCompleted, timeRemaining, nickname);
                                finalTree.add(finalTask);
                                item.setIsScheduled();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }


    /**
     * Void method that adds applicable feeding tasks to the finalTree
     * @param hour - the inputted hour used as a key for (FINISH)
     * @param instance - the inputted CreateArrayList object to get access to the scheduled tasks array
     */
    public void checkFeeding(int hour, ScheduleBuilder schedule, CreateArrayList instance) {
        int timeRemaining = getTimeRemaining();
        int timeCompleted = getTimeCompleted();
        String nickname = "No nickname available";
        for (Feeding feeding : instance.getFeedingTasks()) {
            if (feeding.getStartHour() <= hour) {
                for (IsScheduled item : instance.getIsScheduledTasks()) { //tasksArray is an array list of all task objects
                    if (item.getIsScheduled() == false) {
                        if (item.getUniqueID() == feeding.getUniqueID()) {
                            if (timeRemaining >= 0 && timeRemaining < feeding.getDuration()) {
                                continue;
                            }
                            else if (timeRemaining > feeding.getDuration()) {
                                
                                timeRemaining -= feeding.getDuration();
                                timeCompleted += feeding.getDuration();
                                setTimeRemaining(timeRemaining);
                                setTimeCompleted(timeCompleted);
                                for (Animal animal : schedule.getAnimalsArray()) {
                                    if (feeding.getAnimalID() == animal.getAnimalId()) {
                                        nickname = animal.getAnimalNickname();
                                    }
                                }
                                FinalSchedule finalTask = new FinalSchedule(feeding.getUniqueID(), feeding.getDescription(), 4, timeCompleted, timeRemaining, nickname);
                                finalTree.add(finalTask);
                                item.setIsScheduled();
                            }
                            else if (timeRemaining == feeding.getDuration()) {
                                
                                timeRemaining -= feeding.getDuration();
                                timeCompleted += feeding.getDuration();
                                setTimeRemaining(timeRemaining);
                                setTimeCompleted(timeCompleted);
                                for (Animal animal : schedule.getAnimalsArray()) {
                                    if (feeding.getAnimalID() == animal.getAnimalId()) {
                                        nickname = animal.getAnimalNickname();
                                    }
                                }
                                FinalSchedule finalTask = new FinalSchedule(feeding.getUniqueID(), feeding.getDescription(), 4, timeCompleted, timeRemaining, nickname);
                                finalTree.add(finalTask);
                                item.setIsScheduled();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }


    /**
     * Void method that adds applicable cleaning tasks to the finalTree
     * @param hour - the inputted hour used as a key for (FINISH)
     * @param instance - the inputted CreateArrayList object to get access to the scheduled tasks array
     */
    public void checkCleaning(int hour, ScheduleBuilder schedule, CreateArrayList instance) {
        int timeRemaining = getTimeRemaining();
        int timeCompleted = getTimeCompleted();
        String nickname = "No nickname available";
        for (Cleaning clean : instance.getCleaningTasks()) {
            for (IsScheduled item : instance.getIsScheduledTasks()) { //tasksArray is an array list of all task objects (for ex, we would have unique ids 1-30 for treatment, and then 31-? would be the rest of the tasks such as prepped feeding, feeding and cleaning)
                if (item.getIsScheduled() == false) {
                    if (item.getUniqueID() == clean.getUniqueID()) {
                        if (timeRemaining >= 0 && timeRemaining < clean.getDuration()) {
                            continue;
                        }
                        else if (timeRemaining > clean.getDuration()) {
                            
                            timeRemaining -= clean.getDuration();
                            timeCompleted += clean.getDuration();
                            setTimeRemaining(timeRemaining);
                            setTimeCompleted(timeCompleted);
                            for (Animal animal : schedule.getAnimalsArray()) {
                                if (clean.getAnimalID() == animal.getAnimalId()) {
                                    nickname = animal.getAnimalNickname();
                                }
                            }
                            FinalSchedule finalTask = new FinalSchedule(clean.getUniqueID(), clean.getDescription(), 4, timeCompleted, timeRemaining, nickname);
                            finalTree.add(finalTask);
                            item.setIsScheduled();
                        }
                        else if (timeRemaining == clean.getDuration()) {
                            
                            timeRemaining -= clean.getDuration();
                            timeCompleted += clean.getDuration();
                            setTimeRemaining(timeRemaining);
                            setTimeCompleted(timeCompleted);
                            for (Animal animal : schedule.getAnimalsArray()) {
                                if (clean.getAnimalID() == animal.getAnimalId()) {
                                    nickname = animal.getAnimalNickname();
                                }
                            }
                            FinalSchedule finalTask = new FinalSchedule(clean.getUniqueID(), clean.getDescription(), 4, timeCompleted, timeRemaining, nickname);
                            finalTree.add(finalTask);
                            item.setIsScheduled();
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * Void method that sets the time remaining in an hour depending on the tasks completed.
     * @param timeRemaining - the inputted integer to set as the time remaining 
     */
    public void setTimeRemaining(int timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    /**
     * Void method that sets the time completed in an hour depending on the tasks completed.
     * @param timeCompleted - the inputted integer to set as the time completed
     */
    public void setTimeCompleted(int timeCompleted) {
        this.timeCompleted = timeCompleted;
    }

    /*
     * Returns the integer time remaining in an hour.
     */
    public int getTimeRemaining() {
        return this.timeRemaining;
    }

    /*
     * Returns the integer time completed in an hour.
     */
    public int getTimeCompleted() {
        return this.timeCompleted;
    }
}
