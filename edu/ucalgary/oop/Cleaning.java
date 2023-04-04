package edu.ucalgary.oop;

public class Cleaning {
    /*
     * Cleaning class populates a Task ArrayList of type ArrayList<Task> that contains all 
     * the cleaning tasks for a given database. This is the lowest priority task.
    */
    private final int UNIQUEID;
    private String description;
    private int duration;

    /*
     * Cleaning object constructor. Recieves arguments of type (int, String) and sets the 
     * private variables TASKID and description.
     */
    public Cleaning(int uniqueID, String description, int duration) {
        this.UNIQUEID = uniqueID;
        this.description = description;
        this.duration = duration;
    }

    /*
     * Getters. No arguments, getTaskID() returns int and getDescription() returns String.
     */
    public int getUniqueID() { return this.UNIQUEID; }
    public String getDescription() { return this.description; }
    public int getDuration() { return this.duration; }
    
}
