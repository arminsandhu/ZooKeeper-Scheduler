package edu.ucalgary.oop;

public class PreppedFeeding {
    /*
     * PreppedFeeding class populates a Task ArrayList of type ArrayList<Task> that contains all 
     * the feeding tasks with prep time for a givens database. This is the second most prioritized task.
     */

    private final int UNIQUEID;
    private int startHour;
    private int maxWindow;
    private String description;
    private int prepTime;
    private int duration;

    /*
     * PreppedFeeding constructor. Has arguments of the following types (int, int, int, String, int).
     * Constructs the attributes of preppedfeeding object.
     */
    public PreppedFeeding(int uniqueID, int startHour, int maxWindow, String description, int prepTime, int duration) {
        this.startHour = startHour;
        this.maxWindow = maxWindow;
        this.UNIQUEID = uniqueID;
        this.description = description;
        this.prepTime = prepTime;
        this.duration = duration;
    }


    /*
     * Getters for the attributes of a PreppedFeeding object. None have arguments,
     * first 4 are return type int, getDescription() is of return type String.
     */
    public int getUniqueID() { return this.UNIQUEID; }
    public int getStartHour() { return this.startHour; }
    public int getMaxWindow() { return this.maxWindow; }
    public int getPrepTime() { return this.prepTime; }
    public int getDuration() { return this.duration; }
    public String getDescription() { return this.description; }
}