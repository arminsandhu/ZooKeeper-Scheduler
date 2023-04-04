package edu.ucalgary.oop;

public class IsScheduled {
    private final int UNIQUEID;
    private boolean isSched = false;

    public IsScheduled(int uniqueID) {
        this.UNIQUEID = uniqueID;
    }

    public void setIsSched(boolean val) {
        this.isSched = val;
    }

    public int getUniqueID() {
        return this.UNIQUEID;
    }

    public boolean getIsSched() {
        return this.isSched;
    }
}
