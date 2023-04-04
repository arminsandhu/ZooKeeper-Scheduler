package edu.ucalgary.oop;
import java.util.ArrayList;

public class Treatment {
    /*
     * populate treatmentTask array (highest priority)
     * treatmentTasks = [[(int)animalID, (int)taskID, (int)startHour, (int)duration, (int)maxWindow, (boolean)schdeuled?]]
     */
    private final int ANIMALID;
    private final int TASKID;
    private int startHour;
    private final int UNIQUEID;

    public Treatment(int uniqueID, int id, int taskID, int hour) {
        this.ANIMALID = id;
        this.TASKID = taskID;
        this.startHour = hour;
        this.UNIQUEID = uniqueID;
    }

    public int getAnimalID() {
        return this.ANIMALID;
    }

    public int getTaskID() {
        return this.TASKID;
    }

    public int getStartHour() {
        return this.startHour;
    }
    
    
    public void setStartHour(int hour) {
        this.startHour = hour;
    }

    public int getUniqueID() {
        return this.UNIQUEID;
    }


}