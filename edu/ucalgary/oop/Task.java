package edu.ucalgary.oop;

public class Task {
    protected final int ANIMALID;
    protected final int TASKID;
    private final String DESCRIPTION;
    private final static int MAXWINDOW;
    private final int DURATION;


    public Task(int taskID, String description, int duration, int maxWindow) implements FormattedOutput{
        // ADD STUFFF
    }

    public int getTaskID() {
        return this.TASKID;
    }

    public String getDescription() {
        return this.DESCRIPTION
    }

    public int getDuration() {
        return this.DURATION;
    }

    public int getAnimalID() {
        return this.ANIMALID;
    }

    public int getMaxWindow() {
        return this.MAXWINDOW;
    }

    public int feedingTime() {
        // ADD STUFFF
    }


    // DO WE NEED SETTERS???



}
