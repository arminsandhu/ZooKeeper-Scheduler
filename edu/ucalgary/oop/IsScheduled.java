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

    /**
     * IsScheduled constructor. 
     * 
     */
    public IsScheduled(int uniqueID) {
        this.UNIQUEID = uniqueID;
    }

    public void setIsScheduled() {
        this.isSched = true;
    }

    public void setFalse() {
        this.isSched = false;
    }

    public int getUniqueID() {
        return this.UNIQUEID;
    }

    public boolean getIsScheduled() {
        return this.isSched;
    }
}
