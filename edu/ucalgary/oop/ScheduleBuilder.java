package edu.ucalgary.oop;

import java.sql.*;
import java.util.ArrayList;


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
        animalsArray = new ArrayList<Animal>();
        try {                    
            Statement myStmt = dbConnection.createStatement();
            results = myStmt.executeQuery("SELECT * FROM animals");
            
            while (results.next()){          
                // uncomment out the bottom to test if it works on your computer
            //    System.out.println("Print results: " + results.getInt("AnimalID") + ", " + results.getString("AnimalNickname") + ", " + results.getString("AnimalSpecies"));
                animalsArray.add(new Animal(results.getInt("AnimalID"), results.getString("AnimalNickname"), results.getString("AnimalSpecies")));
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
        try {                    
            Statement myStmt = dbConnection.createStatement();
            results = myStmt.executeQuery("SELECT * FROM treatments");
            
            // this may be not work
            while (results.next()){                
               treatmentsArray.add(new Treatment(results.getInt("AnimalID"), results.getInt("TaskID"), results.getInt("StartHour")));
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

        



    }
}
