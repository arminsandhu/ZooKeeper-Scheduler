/**
 * ENSF 380 - L02 - Group 24 
@author Armin Sandhu<a href="mailto:armin.sandhu@ucalgary.ca">armin.sandhu@ucalgary.ca</a>
@author Dominico Mendes<a href="mailto:dominico.mendes@ucalgary.ca">dominico.mendes@ucalgary.ca</a>
@author Ella Boulanger<a href="mailto:ella.boulanger@ucalgary.ca">ella.boulanger@ucalgary.ca</a>
@author Raina Jugdev<a href="mailto:raina.jugdev@ucalgary.ca">raina.jugdev@ucalgary.ca</a>
@version 1.179
@since 1.0
*/
/*
 * Task class populates an ArrayList of type ArrayList<Task> that contains all 
 * the tasks for a given database. All private class variables are final.
 */

package edu.ucalgary.oop;

public class Task {

    private final int TASKID;
    private final String DESCRIPTION;
    private final int DURATION;
    private final int MAXWINDOW;

    /*
     * Task class constructor, takes in arguments (int, String, int, int), 
     * and assigns private class variables.
     */
    public Task(int taskId, String description, int duration, int maxWindow) {
        try {
            if (taskId < 0 || description == null || duration < 0 || maxWindow < 0) {
                throw new IllegalArgumentException("Invalid Task Constructor parameters");
            }
            this.TASKID = taskId;
            this.DESCRIPTION = description; 
            this.DURATION = duration;
            this.MAXWINDOW = maxWindow;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    /*
     * Returns the integer Task ID. No args.
     */
    public int getTaskId() {
        return this.TASKID;
    }

    /*
     * Returns the String description ID. No args.
     */
    public String getDescription() {
        return this.DESCRIPTION;
    }

    /*
     * Returns the integer duration. No args.
     */
    public int getDuration() {
        return this.DURATION;
    }
    /*
     * Returns the integer max window. No args.
     */
    public int getMaxWindow() {
        return this.MAXWINDOW;
    }
}
