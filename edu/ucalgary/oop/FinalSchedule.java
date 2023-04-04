package edu.ucalgary.oop;

public class FinalSchedule implements Comparable<FinalSchedule> {
    private final int UNIQUEID;
    private String description;
    private int quantity;
    private int timeSpent;
    private int timeAvailable;

    public FinalSchedule(int unique, String description, int quantity, int timeSpent, int timeAvailable) {
        this.UNIQUEID = unique;
        this.description = description;
        this.quantity = quantity;
        this.timeSpent = timeSpent;
        this.timeAvailable = timeAvailable;
    }
    
    public int getUniqueId() {
        return this.UNIQUEID;
    }

    public String getDescription() {
        return this.description;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getTimeSpent() {
        return this.timeSpent;
    }

    public int getTimeAvailable() {
        return this.timeAvailable;
    }

    @Override
    public int compareTo(FinalSchedule other) {
        if (this.timeAvailable < other.timeAvailable) {
            return -1;
        } else if (this.timeAvailable > other.timeAvailable) {
            return 1;
        } else {
            return 0;
        }
    }

}
