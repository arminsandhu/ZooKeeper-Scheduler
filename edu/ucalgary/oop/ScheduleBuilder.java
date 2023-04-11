package edu.ucalgary.oop;

//import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.concurrent.CountDownLatch;

// import com.mysql.cj.xdevapi.DbDoc;
import java.awt.EventQueue;

public class ScheduleBuilder {
    /*
     * 
     * Logic???
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
    // private String nickname;


    // public void reset() {

    // }
    // public static void main(String[] args) {

    //     //print gui welcome message
    //     // EventQueue.invokeLater(() -> {
    //     //      new WelcomeGUI().setVisible(true);        
    //     //     });

    //     // testing backup volunteer
    //     // EventQueue.invokeLater(() -> {
    //     //     new BackupVolunteerGUI().setVisible(true);        
    //     //     });

    //     //make schedule object of class ScheduleBuilder 
        
    //     ScheduleBuilder schedule = new ScheduleBuilder();
 

    //     //call method createConnection()
    //     //schedule.createConnection(); // may need to throw exception here

    //     //call method to popoulate animalsArray
    //     schedule.setAnimalsArray();

    //     //call method to populate tasksArray
    //     schedule.setTasksArray();

    //     //call method to populate treatmentsArray
    //     schedule.setTreatmentsArray();

    //     schedule.setIterationsList(schedule);
    //     // This is here only to test printing the 
    //     //System.out.println(schedule.getAnimalsArray());
    //     // This is here only to test printing the 
    //     //System.out.println(schedule.getAnimalsArray());
    //     CreateArrayList instance = new CreateArrayList(schedule);
    //     instance.addScheduledTreaments(iterationsList);
    //     //HERE IS THE LINE TO CALL THE CHANGEDB THING!!!!!!!!!!!!!!!!!!
    //     //ChangingDB changeDB = new ChangingDB(schedule.getConnection());

    //     // THE BELOW CODE IS TO PRINT THE UNQIUE IDS OF EVERY TASK.
    //     // ArrayList<IsScheduled> scheduledTasks = instance.getIsScheduledTasks();
    //     // HashSet<Integer> uniqueIds = new HashSet<>();
    //     // for (IsScheduled task : scheduledTasks) {
    //     //     int taskId = task.getUniqueID();
    //     //     System.out.println(taskId);
    //     //     uniqueIds.add(taskId);
    //     // }
    //     //System.out.println(instance.getFeedingTasks().get(0).getDescription());
    //     //System.out.println(instance.getPreppedFeedingTasks());
    //     //System.out.println(instance.getCleaningTasks());
    //     //schedule.treatmentsArray.add(new Treatment(60, 7, 9, 13));
    //     //instance.getIsScheduledTasks().add(new IsScheduled(60));
    //     int count = 0;
    //     for (int hour = 0; hour < 24; hour++) {
    //         // System.out.println(hour);
    //         // System.out.println(schedule.getTimeRemaining());

    //         if (schedule.getTimeRemaining() > 0) {
    //             schedule.checkTreatments(hour, schedule, instance);
    //             schedule.checkPreppedFeeding(hour, instance);
    //             schedule.checkFeeding(hour, instance);
    //             schedule.checkCleaning(hour, instance);
    //             TreeSet<FinalSchedule> reverseOrder = new TreeSet<>(Collections.reverseOrder());
    //             reverseOrder.addAll(schedule.getFinalTree());
    //             schedule.setFinalTree(reverseOrder);
    //             schedule.setFinalSchedule(hour, schedule.getFinalTree());
    //             // for (FinalSchedule s : schedule.getFinalTree()) {
    //             //     System.out.println(s.getDescription() + "   -   " + s.getUniqueId());
    //             //     count++;
    //             // }
    //             schedule.setTimeRemaining(60);
    //             schedule.setTimeCompleted(0);
    //             schedule.resetFinalTree();

                
    //         }  
    //     }
    //     // for (IsScheduled i : instance.getIsScheduledTasks()) {
    //     //     System.out.println(i.getIsScheduled());
    //     //     System.out.println(i.getUniqueID());
    //     // }
    //     // System.out.println(schedule.getFinalSchedule());

    //     // ella and armin added to print txt file
    //     try {
    //         TextFileOutput txtOutput = new TextFileOutput(schedule);
    //     } catch (IOException e) {
    //         System.out.println("There was an error.");
    //         e.printStackTrace();
    //     }
    //     // ella and armin added to print txt file

    //     //ella added to make gui table
    //     EventQueue.invokeLater(() -> {
    //         TableGUI tableGUI = new TableGUI(schedule);
    //         tableGUI.setVisible(true);        
    //         });
    //     //ella added to make gui table
        
    //     // System.out.println(schedule.getFinalSchedule());
    //     // System.out.println(count);

    // }

                
    public ScheduleBuilder(){ // added this empty constructor; may not need it
    }


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
        
        //pull data same form as sql table
        //use queries
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
        //pull data same form as sql table
        //use queries
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


    // had to make this setter for testing
    // should we keep it?
    /**
     * Void method that sets the treatments array
     * @param treatmentsArray - the inputted ArrayList<Treatment> to set to treatmentsArray
     */
    public void setTreatmentsArray(ArrayList<Treatment> treatmentsArray) {
        this.treatmentsArray = treatmentsArray;
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
     * Returns the database connection. No args.
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
     * @param schedule - the inputted ScheduleBuilder object to get access to methods (SPECIFY I THINK)
     * @param instance - the inputted CreateArrayList object to get access to the scheduled tasks array
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
     * Void method that adds applicable prepped feeding tasks to the finalTree
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


    // /**
    //  * Void method that sets the nickname of the animal for a specific task.
    //  * @param nickname - the inputted string to set as the nickname
    //  */
    // public void setNickname(String nickname) {
    //     this.nickname = nickname;
    // }

    // /*
    //  * Returns the nickname of an animal.
    //  */
    // public String getNickname() {
    //     return this.nickname;
    // }


}
