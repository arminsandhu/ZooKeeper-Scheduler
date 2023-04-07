package edu.ucalgary.oop;


public class Task {
    /*
     * Task class populates a ScheduleBuilder ArrayList of type ArrayList<Task> that contains all 
     * the tasks for a given database. 
     */
    private final int TASKID;
    private final String DESCRIPTION;
    private final int DURATION;
    private final int MAXWINDOW;


    // Constructor for Task class
    public Task(int taskId, String description, int duration, int maxWindow) {
        this.TASKID = taskId;
        this.DESCRIPTION = description; 
        this.DURATION = duration;
        this.MAXWINDOW = maxWindow;
    }


    // get TASKID
    public int getTaskId() {
        return this.TASKID;
    }

    // get DESCRIPTION of task
    public String getDescription() {
        return this.DESCRIPTION;
    }

    // get DURATION of task
    public int getDuration() {
        return this.DURATION;
    }

    // get the MAXWINDOOW to complete the task
    public int getMaxWindow() {
        return this.MAXWINDOW;
    }


}
