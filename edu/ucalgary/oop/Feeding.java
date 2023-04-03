package edu.ucalgary.oop;

import java.util.*;

public class Feeding extends ScheduleBuilder {
    /*
     * Feeding class populates a Task ArrayList of type ArrayList<Task> that contains all 
     * the feeding tasks for a given database. This is the 3rd lowest priority task.
     */
    
    private ArrayList<Task> feedingTasks;

    public Feeding() {
        ArrayList<Animal> animals = getAnimalsArray();
        this.feedingTasks = new ArrayList<Task>();
        for (Animal animal : animals) {
            String species = animal.getAnimalSpecies();
        }

    }

}
