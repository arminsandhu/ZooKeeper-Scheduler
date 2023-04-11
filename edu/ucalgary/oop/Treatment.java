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
 * Treatment class populates a ScheduleBuilder ArrayList of type ArrayList<Treatment> that contains all 
 * the medical treatments for a given database. 
 */

package edu.ucalgary.oop;

public class Treatment {

    private final int ANIMALID;
    private final int TASKID;
    private int startHour;
    private final int UNIQUEID;

    /*
     * Treatment class constructor, takes in arguments (int, int, int, int), 
     * and assigns private class variables.
     */
    public Treatment(int uniqueID, int id, int taskID, int hour) throws IllegalArgumentException{
        try {
            if (uniqueID < 0 || id < 0 || taskID < 0 || hour < 0) {
                throw new IllegalArgumentException("Invalid animal parameters");
            }
            this.ANIMALID = id;
            this.TASKID = taskID;
            this.startHour = hour;
            this.UNIQUEID = uniqueID;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    /*
     * Returns the integer animal ID. No args.
     */
    public int getAnimalID() {
        return this.ANIMALID;
    }

    /*
     * Returns the integer Task ID. No args.
     */
    public int getTaskID() {
        return this.TASKID;
    }

    /*
     * Returns the integer start hour. No args.
     */
    public int getStartHour() {
        return this.startHour;
    }
    
    
    /*
     * Void method that sets the start hour.
     * @param hour - the inputted value to set to start hour 
     */
    public void setStartHour(int hour) {
        this.startHour = hour;
    }

    /*
     * Returns the integer Unique ID. No args.
     */
    public int getUniqueID() {
        return this.UNIQUEID;
    }
}