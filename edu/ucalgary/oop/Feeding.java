package edu.ucalgary.oop;

public class Feeding {
    /*
     * Feeding class populates a Task ArrayList of type ArrayList<Task> that contains all 
     * the feeding tasks for a given database. This is the 3rd lowest priority task.
     */
    
    private final int UNIQUEID;
    private int startHour;
    private int maxWindow;
    private String description;

    /*
     * Feeding class constructor. Takes in arguments of types (int, int, int, String) and assigns the values
     * to the priavte variables TASKID, startHour, maxWindow and description.
     */
    public Feeding(int uniqueID, int startHour, int maxWindow, String description) {
        this.startHour = startHour;
        this.maxWindow = maxWindow;
        this.UNIQUEID = uniqueID;
        this.description = description;
    }

    /*
     * Getters for the variables of a Feeding object. None have arguments,
     * first 3 are return type int, getDescription() is of return type String.
     */
    public int getUniqueID() { return this.UNIQUEID; }
    public int getStartHour() { return this.startHour; }
    public int getMaxWindow() { return this.maxWindow; }
    public String getDescription() { return this.description; }
}
