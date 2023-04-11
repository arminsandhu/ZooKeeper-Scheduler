/**
 * ENSF 380 - L02 - Group 24 
@author Armin Sandhu<a href="mailto:armin.sandhu@ucalgary.ca">armin.sandhu@ucalgary.ca</a>
@author Dominico Mendes<a href="mailto:dominico.mendes@ucalgary.ca">dominico.mendes@ucalgary.ca</a>
@author Ella Boulanger<a href="mailto:ella.boulanger@ucalgary.ca">ella.boulanger@ucalgary.ca</a>
@author Raina Jugdev<a href="mailto:raina.jugdev@ucalgary.ca">raina.jugdev@ucalgary.ca</a>
@version 1.177
@since 1.0
*/
/*
 * PreppedFeeding class populates a Task ArrayList of type ArrayList<Task> that contains all 
 * the feeding tasks with prep time for a givens database. This is the second most prioritized task.
 */

package edu.ucalgary.oop;

public class PreppedFeeding {

    private final int UNIQUEID;
    private int startHour;
    private int maxWindow;
    private String description;
    private int prepTime;
    private int duration;
    private final int ANIMALID;

    /*
     * PreppedFeeding constructor. Has arguments of the following types (int, int, int, String, int).
     * Constructs the attributes of preppedfeeding object.
     */
    public PreppedFeeding(int uniqueID, int startHour, int maxWindow, String description, int prepTime, int duration, int animalID) {
        this.startHour = startHour;
        this.maxWindow = maxWindow;
        this.UNIQUEID = uniqueID;
        this.description = description;
        this.prepTime = prepTime;
        this.duration = duration;
        this.ANIMALID = animalID; 
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
    public int getAnimalID() { return this.ANIMALID; }
}