package edu.ucalgary.oop;

public class Volunteer {
    private Task task;
    private String volunteerName;
    private String backupVolunteerName;

    public Volunteer(String id, String name, String backupName) {
        // ADD STUFFF
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
