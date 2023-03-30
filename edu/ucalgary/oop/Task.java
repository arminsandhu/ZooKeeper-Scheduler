package edu.ucalgary.oop;

public class Task {
    private Task task;
    private String volunteerName;
    private String backupVolunteerName;

    public void volunteer(String id, String name, String backupName) {
        
    }

    public String setVolunteerName(String name) {
        return "";      // FINISH
    }

    public Task getTask() {
        return this.task;
    }

    public String getBackupVolunteer() {
        return this.backupVolunteerName;
    }

    public String getVolunteerName() {
        return this.volunteerName;
    }

    public void setBackupVolunteer(String name) {
        this.backupVolunteerName = name;
    }
}
