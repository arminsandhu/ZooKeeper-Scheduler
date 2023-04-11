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
 * Class IsScheduled creates objects to fill the ArrayList of every task to be scheduled. 
 */

package edu.ucalgary.oop;

public class IsScheduled {

    /**
     * @param UNIQUEID - private and final integer that holds the value of the task's unique ID
     * for every class object.
     * @param isSched - private boolean value set to false. This holds the truth value for if a task
     * has been scheduled before. 
     * */     
    private final int UNIQUEID;
    private boolean isSched = false;

    /*
     * Animal class constructor, takes in an argument (int), 
     * and assigns a private class variable.
     */
    public IsScheduled(int uniqueID) {
        this.UNIQUEID = uniqueID;
    }

    /*
     * Void method that sets the isSched private variable to true. No args.
     */
    public void setIsScheduled() {
        this.isSched = true;
    }

    /*
     * Void method that sets the isSched private variable to false. No args.
     */
    public void setFalse() {
        this.isSched = false;
    }

    /*
     * Returns the integer Unique ID. No args.
     */
    public int getUniqueID() {
        return this.UNIQUEID;
    }

    /*
     * Returns a boolean vlaue of the isSched private variable. No args.
     */
    public boolean getIsScheduled() {
        return this.isSched;
    }
}
