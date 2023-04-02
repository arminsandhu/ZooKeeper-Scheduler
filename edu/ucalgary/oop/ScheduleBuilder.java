package edu.ucalgary.oop;

import java.sql.*;

public class ScheduleBuilder {
    /*
     * 
     * 
     * 
     */
    private Connection dbConnection;

    private Object[][] animalsArray;
    
    private Object[][] treatmentsArray;

    private Object[][] tasksArray;



    public void createConnection(){
                
        try{
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/treatments", "oop", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setAnimalsArray() {
        //pull data same form as sql table
        //use queries
    }

    public void setTreatmentsArray() {
        //pull data same form as sql table
        //use queries
    }

    public void setTasksArray() {
        //pull data same form as sql table
        //use queries
    }

    public Object[][] getAnimalsArray() {
        return this.animalsArray;
    }

    public Object[][] getTreatmentsArray() {
        return this.treatmentsArray;
    }

    public Object[][] getTasksArray() {
        return this.tasksArray;
    }

    

    public static void main() {

        //print gui welcome message

        //call method createConnection()

        //call method to popoulate animalsArray

        //call method to populate tasksArray

        //call method to populate treatmentsArray

        



    }
}
