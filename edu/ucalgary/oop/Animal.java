package edu.ucalgary.oop;

public class Animal {
    private final int ANIMALID;
    private final String ANIMALSPECIES;
    private Task assignedTask;
    private final String ANIMALNICKNAME;


    public Animal(int id, String name, String species, Task task) {
        // ADD STUFF
    }

    public void setAssignedTask(Task task) {
        this.assignedTask = task;
    }

    public String getAnimalSpecies() {
        return this.ANIMALSPECIES;
    }

    public Task getAssignedTask() {
        return this.assignedTask;
    }

    public int getAnimalID() {
        return this.ANIMALID;
    }

    public String getNickname() {
        return this.ANIMALNICKNAME;
    }
}
