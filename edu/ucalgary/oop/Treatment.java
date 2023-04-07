package edu.ucalgary.oop;


public class Treatment {
    /*
     * Treatment class populates a ScheduleBuilder ArrayList of type ArrayList<Treatment> that contains all 
     * the medical treatments for a given database. 
     */
    private final int ANIMALID;
    private final int TASKID;
    private int startHour;
    private final int UNIQUEID;

    // constrcutor for Treatment class
    public Treatment(int uniqueID, int id, int taskID, int hour) {
        this.ANIMALID = id;
        this.TASKID = taskID;
        this.startHour = hour;
        this.UNIQUEID = uniqueID;
    }

    // get ANIMALID
    public int getAnimalID() {
        return this.ANIMALID;
    }

    // get TASKID
    public int getTaskID() {
        return this.TASKID;
    }

    // get the startHour of the task
    public int getStartHour() {
        return this.startHour;
    }
    
    // set the startHour of the task
    public void setStartHour(int hour) {
        this.startHour = hour;
    }

    // get the UNIQUEID of the task
    public int getUniqueID() {
        return this.UNIQUEID;
    }
}