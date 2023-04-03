package edu.ucalgary.oop;

public class Task {
    private final int TASKID;
    private String DESCRIPTION;
    private final int DURATION;
    private final int MAXWINDOW;

    public Task(int taskId, String description, int duration, int maxWindow) {
        this.TASKID = taskId;
        this.DESCRIPTION = description; 
        this.DURATION = duration;
        this.MAXWINDOW = maxWindow;
    }

    // getters 
    // We dont need setter?

    public int getTaskId() {
        return this.TASKID;
    }

    public String getDescription() {
        return this.DESCRIPTION;
    }

    public int getDuration() {
        return this.DURATION;
    }

    public int getMaxWindow() {
        return this.MAXWINDOW;
    }


}
