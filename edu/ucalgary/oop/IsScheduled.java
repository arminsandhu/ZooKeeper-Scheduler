package edu.ucalgary.oop;

public class IsScheduled {
    /**
     * Class IsScheduled creates objects to fill the ArrayList of every task to be scheduled.
     * @param UNIQUEID - private and final integer that holds the value of the task's unique ID
     * for every class object.
     * @param isSched - private boolean value set to false. This holds the truth value for if a task
     * has been scheduled before. 
     */
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
