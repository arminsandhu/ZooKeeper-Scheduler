package edu.ucalgary.oop;

public class Treatment implements FormattedOutput {
    /*
     * populate treatmentTask array (highest priority)
     * treatmentTasks = [[(int)animalID, (int)taskID, (int)startHour, (int)duration, (int)maxWindow, (boolean)schdeuled?]]
     */
    private boolean isScheduled = false;

    private Object[][] treatmentsToSchedule;

    public Treatment(Object[] tasksArray, Object[] treatmentsArray) {
        // treatmentTasks = [[(int)animalID, (int)taskID, (int)startHour, (int)duration, (int)maxWindow, (boolean)schdeuled?]]
    }

    public boolean getScheduled(int index) {
        return this.treatmentsToSchedule[index][5];
    }

    public boolean setScheduled(int index) {
        this.treatmentsToSchedule[index][5]
    }




//old shit
    // private final int ANIMALID;
    // private final int TASKID;
    // private final int STARTHOUR;


    // public Treatment(int id, int taskID, int hour) {
    //     // ADD STUFF
    // }

    // public int getAnimalID() {
    //     return this.ANIMALID;
    // }

    // public int getTaskID() {
    //     return this.TASKID;
    // }

    // public int getStartHour() {
    //     return this.STARTHOUR;
    // }


    // // DO WE NEED SETTERS???

}
