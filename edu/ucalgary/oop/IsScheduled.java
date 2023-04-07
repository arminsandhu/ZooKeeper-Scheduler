package edu.ucalgary.oop;

public class IsScheduled {
    private final int UNIQUEID;
    private boolean isSched = false;

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
