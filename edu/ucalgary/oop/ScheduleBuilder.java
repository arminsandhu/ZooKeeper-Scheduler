package edu.ucalgary.oop;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import com.mysql.cj.xdevapi.DbDoc;

import java.awt.EventQueue;


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
    private int count = 0;
    private TreeSet<FinalSchedule> finalTree = new TreeSet<>();

    public static void main(String[] args) {

        //print gui welcome message
        // EventQueue.invokeLater(() -> {
        //      new WelcomeGUI().setVisible(true);        
        //     });

        // testing backup volunteer
        // EventQueue.invokeLater(() -> {
        //     new BackupVolunteerGUI().setVisible(true);        
        //     });

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

        schedule.setIterationsList(schedule);
        // This is here only to test printing the 
        //System.out.println(schedule.getAnimalsArray());
        // This is here only to test printing the 
        //System.out.println(schedule.getAnimalsArray());
        CreateArrayList instance = new CreateArrayList(schedule);
        instance.addScheduledTreaments(iterationsList);
        //HERE IS THE LINE TO CALL THE CHANGEDB THING!!!!!!!!!!!!!!!!!!
        //ChangingDB changeDB = new ChangingDB(schedule.getConnection());

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
        //schedule.treatmentsArray.add(new Treatment(60, 7, 9, 13));
        //instance.getIsScheduledTasks().add(new IsScheduled(60));
        int count = 0;
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
                for (FinalSchedule g : schedule.getFinalTree()) {
                    System.out.println(g.getUniqueId());
                }
                schedule.resetFinalTree();
                
            }  
        }
        // for (IsScheduled i : instance.getIsScheduledTasks()) {
        //     System.out.println(i.getIsScheduled());
        //     System.out.println(i.getUniqueID());
        // }
        // System.out.println(schedule.getFinalSchedule());

        // ella and armin added to print txt file
        try {
            TextFileOutput txtOutput = new TextFileOutput(schedule);
        } catch (IOException e) {
            System.out.println("There was an error.");
            e.printStackTrace();
        }
        // ella and armin added to print txt file

        //ella added to make gui table
        EventQueue.invokeLater(() -> {
            TableGUI tableGUI = new TableGUI(schedule);
            tableGUI.setVisible(true);        
            });
        //ella added to make gui table
        
        // System.out.println(schedule.getFinalSchedule());
        // System.out.println(count);

    }

                
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
        this.finalTree = new TreeSet<>();
    }

    public void setFinalTree(TreeSet<FinalSchedule> finalTree) {
        this.finalTree = finalTree;
    }

    public void setFinalSchedule(int hour, TreeSet<FinalSchedule> finalTree) {
        this.finalSchedule.put(hour, finalTree);
    }

    public void setIterationsList(ScheduleBuilder schedule) {
        int p;
        iterationsList = new int[treatmentsArray.size()];
        for (p = 0; p< schedule.treatmentsArray.size(); p++) {
            iterationsList[p] = p;
        }
    }

    public Connection getConnection() {
        return this.dbConnection;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount() {
        this.count = 1;
    }

    public void resetCount() {
        this.count = 0;
    }

    public void checkTreatments(int hour, ScheduleBuilder schedule, CreateArrayList instance) {
        int timeRemaining = schedule.getTimeRemaining();
        int timeCompleted = schedule.getTimeCompleted();
        int count = schedule.getCount();
        
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
                                                            schedule.setCount();
                                                            schedule.setTimeRemaining(60);
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
                                                            schedule.setTimeRemaining(timeRemaining + 60);
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
                                        
                                        
                                        FinalSchedule finalTask = new FinalSchedule(treatment.getUniqueID(), task.getDescription(), 4, timeCompleted, timeRemaining);
                                        finalTree.add(finalTask);
                                        item.setIsScheduled();
                                    }
                                    else if (timeRemaining == task.getDuration()) {
                                        timeRemaining -= task.getDuration();
                                        timeCompleted += task.getDuration();
                                        setTimeRemaining(timeRemaining);
                                        setTimeCompleted(timeCompleted);
                                        
                                        
                                        FinalSchedule finalTask = new FinalSchedule(treatment.getUniqueID(), task.getDescription(), 4, timeCompleted, timeRemaining);
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




    public void checkPreppedFeeding(int hour, CreateArrayList instance) {
        int timeRemaining = getTimeRemaining();
        int timeCompleted = getTimeCompleted();
        int countFox = 0;
        int countCoyote = 0;
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
                                FinalSchedule finalTask = new FinalSchedule(prep.getUniqueID(), prep.getDescription(), 4, timeCompleted, timeRemaining);
                                finalTree.add(finalTask);
                                item.setIsScheduled();
                            }
                            else if (timeRemaining == prep.getDuration()) {
                                
                                timeRemaining -= prep.getDuration();
                                timeCompleted += prep.getDuration();
                                setTimeRemaining(timeRemaining);
                                setTimeCompleted(timeCompleted);
                                FinalSchedule finalTask = new FinalSchedule(prep.getUniqueID(), prep.getDescription(), 4, timeCompleted, timeRemaining);
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


    public void checkFeeding(int hour, CreateArrayList instance) {
        int timeRemaining = getTimeRemaining();
        int timeCompleted = getTimeCompleted();
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
                                FinalSchedule finalTask = new FinalSchedule(feeding.getUniqueID(), feeding.getDescription(), 4, timeCompleted, timeRemaining);
                                finalTree.add(finalTask);
                                item.setIsScheduled();
                            }
                            else if (timeRemaining == feeding.getDuration()) {
                                
                                timeRemaining -= feeding.getDuration();
                                timeCompleted += feeding.getDuration();
                                setTimeRemaining(timeRemaining);
                                setTimeCompleted(timeCompleted);
                                FinalSchedule finalTask = new FinalSchedule(feeding.getUniqueID(), feeding.getDescription(), 4, timeCompleted, timeRemaining);
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


    public void checkCleaning(int hour, CreateArrayList instance) {
        int timeRemaining = getTimeRemaining();
        int timeCompleted = getTimeCompleted();
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
                            FinalSchedule finalTask = new FinalSchedule(clean.getUniqueID(), clean.getDescription(), 4, timeCompleted, timeRemaining);
                            finalTree.add(finalTask);
                            item.setIsScheduled();
                        }
                        else if (timeRemaining == clean.getDuration()) {
                            
                            timeRemaining -= clean.getDuration();
                            timeCompleted += clean.getDuration();
                            setTimeRemaining(timeRemaining);
                            setTimeCompleted(timeCompleted);
                            FinalSchedule finalTask = new FinalSchedule(clean.getUniqueID(), clean.getDescription(), 4, timeCompleted, timeRemaining);
                            finalTree.add(finalTask);
                            item.setIsScheduled();
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
}
