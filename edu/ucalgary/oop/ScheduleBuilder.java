package edu.ucalgary.oop;

import java.sql.*;
import java.util.*;


public class ScheduleBuilder {
    /*
     * 
     * 
     * 
     */
    private Connection dbConnection;
    private ResultSet results;
    private ArrayList<Animal> animalsArray; // should we change it back to object?
    private ArrayList<Treatment> treatmentsArray;
    private ArrayList<Task> tasksArray;
    private HashMap<Integer, TreeSet<FinalSchedule>> finalSchedule = new HashMap<Integer, TreeSet<FinalSchedule>>();
    private int iterator = 0;
    private static int[] iterationsList;

    private int timeRemaining = 60;
    private int timeCompleted = 0;
    private TreeSet<FinalSchedule> finalTree = new TreeSet<>();

                
    public ScheduleBuilder(){ // added this empty constructor; may not need it

        
    }

    public void createConnection(){
                
        try{
            // connects to database EWR with user 'oop', password 'password'
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/EWR", "oop", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setAnimalsArray() {
        this.animalsArray = new ArrayList<Animal>();
        try {                    
            Statement myStmt = dbConnection.createStatement();
            results = myStmt.executeQuery("SELECT * FROM animals");
            while (results.next()){          
                // uncomment out the bottom to test if it works on your computer
                //System.out.println("Print results: " + results.getInt("AnimalID") + ", " + results.getString("AnimalNickname") + ", " + results.getString("AnimalSpecies"));
                int animalID = results.getInt("AnimalID");
                String animalNickname = results.getString("AnimalNickname");
                String animalSpecies = results.getString("AnimalSpecies");
                animalsArray.add(new Animal(animalID, animalNickname, animalSpecies));
            }
            
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        //pull data same form as sql table
        //use queries
    }

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
        
        //pull data same form as sql table
        //use queries
    }

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

        
        //pull data same form as sql table
        //use queries
    }

    public ArrayList<Animal> getAnimalsArray() {
        return this.animalsArray;
    }

    public ArrayList<Treatment> getTreatmentsArray() {
        return this.treatmentsArray;
    }

    public ArrayList<Task> getTasksArray() {
        return this.tasksArray;
    }

    public int getIterator() {
        return this.iterator;
    }
    
    public HashMap<Integer, TreeSet<FinalSchedule>> getFinalSchedule() {
        return this.finalSchedule;
    }
    public TreeSet<FinalSchedule> getFinalTree() {
        return this.finalTree;
    }

    public void resetFinalTree() {
        this.finalTree.clear();
    }

    public void setIterationsList(ScheduleBuilder schedule) {
        int p;
        iterationsList = new int[treatmentsArray.size()];
        for (p = 0; p< schedule.treatmentsArray.size(); p++) {
            iterationsList[p] = p;
        }
    }



    public void checkTreatments(int hour, ScheduleBuilder schedule) {
        int timeRemaining = getTimeRemaining();
        int timeCompleted = getTimeCompleted();
        for (Treatment treatment : schedule.getTreatmentsArray()) {
            if (treatment.getStartHour() <= hour) {
                for (Task task : tasksArray) { //tasksArray is an array list of all task objects
                    if (task.getIsScheduled() == false) {
                        if (task.getTaskId() == treatment.getTaskID()) {
                            if (timeRemaining == 0) {
                                break;
                            }
                            if (timeRemaining >= 0 && timeRemaining < task.getDuration()) {
                                continue;
                            }
                            else if (timeRemaining > task.getDuration()) {
                                timeRemaining -= task.getDuration();
                                timeCompleted += task.getDuration();
                                setTimeRemaining(timeRemaining);
                                setTimeCompleted(timeCompleted);
                                FinalSchedule finalTask = new FinalSchedule(treatment.getUniqueID(), "", 4, timeCompleted, timeRemaining) 
                                finalTree.add(finalTask);
                                task.setIsScheduled();
                            }
                            else if (timeRemaining == task.getDuration()) {
                                timeRemaining -= task.getDuration();
                                timeCompleted += task.getDuration();
                                setTimeRemaining(timeRemaining);
                                setTimeCompleted(timeCompleted);
                                FinalSchedule finalTask = new FinalSchedule(treatment.getUniqueID(), "", 4, timeCompleted, timeRemaining) 
                                finalTree.add(finalTask);
                                task.setIsScheduled();
                                break;
                            }
                            // Idk like I think we add task to schedule and set specified task to false right?
                        }
                        if (timeRemaining == 0) {
                            break;
                        }
                    }
                    if (timeRemaining == 0) {
                        break;
                    }
                }
                if (timeRemaining == 0) {
                    break;
                }
            }
            if (timeRemaining == 0) {
                break;
            }
        }
    }




    public void checkPreppedFeeding(int hour, CreateArrayList instance) {
        int timeRemaining = getTimeRemaining();
        int timeCompleted = getTimeCompleted();
        for (PreppedFeeding prep : instance.getPreppedFeedingTasks()) {
            if (prep.getStartHour() <= hour) {
                for (Task task : tasksArray) { //tasksArray is an array list of all task objects
                    if (task.getIsScheduled() == false) {
                        if (task.getUniqueId() == prep.getUniqueID()) {
                            if (timeRemaining >= 0 && timeRemaining < task.getDuration()) {
                                continue;
                            }
                            else if (timeRemaining > task.getDuration()) {
                                timeRemaining -= task.getDuration();
                                timeCompleted += task.getDuration();
                                setTimeRemaining(timeRemaining);
                                setTimeCompleted(timeCompleted);
                                FinalSchedule finalTask = new FinalSchedule(treatment.getUniqueID(), "", 4, timeCompleted, timeRemaining) 
                                finalTree.add(finalTask);
                                task.setIsScheduled();
                            }
                            else if (timeRemaining == task.getDuration()) {
                                timeRemaining -= task.getDuration();
                                timeCompleted += task.getDuration();
                                setTimeRemaining(timeRemaining);
                                setTimeCompleted(timeCompleted);
                                FinalSchedule finalTask = new FinalSchedule(treatment.getUniqueID(), "", 4, timeCompleted, timeRemaining) 
                                finalTree.add(finalTask);
                                task.setIsScheduled();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }


    public void checkFeeding(int hour, CreateArrayList instance) {
        int timeRemaining = getTimeRemaining();
        int timeCompleted = getTimeCompleted();
        for (Feeding feeding : instance.getFeedingTasks()) {
            if (feeding.getStartHour() <= hour) {
                for (Task task : tasksArray) { //tasksArray is an array list of all task objects
                    if (task.getIsScheduled() == false) {
                        if (task.getUniqueId() == feeding.getUniqueID()) {
                            if (timeRemaining >= 0 && timeRemaining < task.getDuration()) {
                                continue;
                            }
                            else if (timeRemaining > task.getDuration()) {
                                timeRemaining -= task.getDuration();
                                timeCompleted += task.getDuration();
                                setTimeRemaining(timeRemaining);
                                setTimeCompleted(timeCompleted);
                                FinalSchedule finalTask = new FinalSchedule(treatment.getUniqueID(), "", 4, timeCompleted, timeRemaining) 
                                finalTree.add(finalTask);
                                task.setIsScheduled();
                            }
                            else if (timeRemaining == task.getDuration()) {
                                timeRemaining -= task.getDuration();
                                timeCompleted += task.getDuration();
                                setTimeRemaining(timeRemaining);
                                setTimeCompleted(timeCompleted);
                                FinalSchedule finalTask = new FinalSchedule(treatment.getUniqueID(), "", 4, timeCompleted, timeRemaining) 
                                finalTree.add(finalTask);
                                task.setIsScheduled();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }


    public void checkCleaning(int hour, CreateArrayList instance) {
        int timeRemaining = getTimeRemaining();
        int timeCompleted = getTimeCompleted();
        for (Cleaning clean : instance.getCleaningTasks()) {
            for (Task task : tasksArray) { //tasksArray is an array list of all task objects (for ex, we would have unique ids 1-30 for treatment, and then 31-? would be the rest of the tasks such as prepped feeding, feeding and cleaning)
                if (task.getIsScheduled() == false) {
                    if (task.getUniqueId() == clean.getUniqueID()) {
                        if (timeRemaining >= 0 && timeRemaining < task.getDuration()) {
                            continue;
                        }
                        else if (timeRemaining > task.getDuration()) {
                            timeRemaining -= task.getDuration();
                            timeCompleted += task.getDuration();
                            setTimeRemaining(timeRemaining);
                            setTimeCompleted(timeCompleted);
                            FinalSchedule finalTask = new FinalSchedule(treatment.getUniqueID(), "", 4, timeCompleted, timeRemaining) 
                            finalTree.add(finalTask);
                            task.setIsScheduled();
                        }
                        else if (timeRemaining == task.getDuration()) {
                            timeRemaining -= task.getDuration();
                            timeCompleted += task.getDuration();
                            setTimeRemaining(timeRemaining);
                            setTimeCompleted(timeCompleted);
                            FinalSchedule finalTask = new FinalSchedule(treatment.getUniqueID(), "", 4, timeCompleted, timeRemaining) 
                            finalTree.add(finalTask);
                            task.setIsScheduled();
                            break;
                        }
                    }
                }
            }
            
        }
    }

    public void setTimeRemaining(int timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    public void setTimeCompleted(int timeCompleted) {
        this.timeCompleted = timeCompleted;
    }

    public int getTimeRemaining() {
        return this.timeRemaining;
    }

    public int getTimeCompleted() {
        return this.timeCompleted;
    }


    public static void main(String[] args) {

        //print gui welcome message

        //make schedule object of class ScheduleBuilder 
        ScheduleBuilder schedule = new ScheduleBuilder();
 
        //call method createConnection()
        schedule.createConnection(); // may need to throw exception here

        //call method to popoulate animalsArray
        schedule.setAnimalsArray();

        //call method to populate tasksArray
        schedule.setTasksArray();

        //call method to populate treatmentsArray
        schedule.setTreatmentsArray();

        // This is here only to test printing the 
        //System.out.println(schedule.getAnimalsArray());
        // This is here only to test printing the 
        //System.out.println(schedule.getAnimalsArray());
        CreateArrayList instance = new CreateArrayList(schedule);
        instance.addScheduledTreaments(iterationsList);

        // THE BELOW CODE IS TO PRINT THE UNQIUE IDS OF EVERY TASK.
        // ArrayList<IsScheduled> scheduledTasks = instance.getIsScheduledTasks();
        // HashSet<Integer> uniqueIds = new HashSet<>();
        // for (IsScheduled task : scheduledTasks) {
        //     int taskId = task.getUniqueID();
        //     System.out.println(taskId);
        //     uniqueIds.add(taskId);
        // }
        //System.out.println(instance.getFeedingTasks().get(0).getDescription());
        //System.out.println(instance.getPreppedFeedingTasks());
        //System.out.println(instance.getCleaningTasks());

       
        for (int hour = 0; hour < 24; hour++) {
            while (schedule.getTimeRemaining() > 0) {
                schedule.checkTreatments(hour, schedule);
                schedule.checkPreppedFeeding(hour, instance);
                schedule.checkFeeding(hour, instance);
                schedule.checkCleaning(hour, instance);
                schedule.getFinalSchedule().put(hour, schedule.getFinalTree());
                schedule.resetFinalTree();

            }
        }
    }
}
