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
 * Cleaning class populates a Task ArrayList of type ArrayList<Task> that contains all 
 * the cleaning tasks for a given database. This is the lowest priority task.
 */

package edu.ucalgary.oop;

public class Cleaning {

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
