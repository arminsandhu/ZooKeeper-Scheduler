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
    
    private ArrayList<Task> treatmentTasks; // addded on saturday, need to change
    

    public Treatment(int id, int taskID, int hour) {
        this.ANIMALID = id;
        this.TASKID = taskID;
        this.startHour = hour;
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


}