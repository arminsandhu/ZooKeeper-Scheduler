package edu.ucalgary.oop;

public class Cleaning {
    /*
     * Cleaning class populates a Task ArrayList of type ArrayList<Task> that contains all 
     * the cleaning tasks for a given database. This is the lowest priority task.
    */
    private final int UNIQUEID;
    private String description;
    private int duration;
    private final int ANIMALID;

    /*
     * Cleaning object constructor. Recieves arguments of type (int, String) and sets the 
     * private variables TASKID and description.
     */
    public Cleaning(int uniqueID, String description, int duration, int animalID) {
        this.UNIQUEID = uniqueID;
        this.description = description;
        this.duration = duration;
        this.ANIMALID = animalID;
    }

    /*
     * Getters. No arguments, getTaskID() returns int and getDescription() returns String.
     */
    public int getUniqueID() { return this.UNIQUEID; }
    public String getDescription() { return this.description; }
    public int getDuration() { return this.duration; }
    public int getAnimalID() { return this.ANIMALID; }
    
}
