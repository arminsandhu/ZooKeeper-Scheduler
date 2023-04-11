/**
 * ENSF 380 - L02 - Group 24 
@author Armin Sandhu<a href="mailto:armin.sandhu@ucalgary.ca">armin.sandhu@ucalgary.ca</a>
@author Dominico Mendes<a href="mailto:dominico.mendes@ucalgary.ca">dominico.mendes@ucalgary.ca</a>
@author Ella Boulanger<a href="mailto:ella.boulanger@ucalgary.ca">ella.boulanger@ucalgary.ca</a>
@author Raina Jugdev<a href="mailto:raina.jugdev@ucalgary.ca">raina.jugdev@ucalgary.ca</a>
@version 1.177
@since 1.0
*/
/*
 * CreateArrayList is a class that extends the ScheduleBuilder class. This class creates all the
 * ArrayLists to be used throughout our program. It populates each with objects from their
 * corresponding classes and has getter methods for each of these ArrayLists.
 */

package edu.ucalgary.oop;
import java.util.*;

public class CreateArrayList extends ScheduleBuilder {
    
    private ArrayList<Feeding> feedingTasks;
    private ArrayList<PreppedFeeding> preppedFeedingTasks;
    private ArrayList<Cleaning> cleaningTasks;
    private ScheduleBuilder sched;
    private ArrayList<IsScheduled> isScheduledTasks;
    private int i;

    /**
     * CreateArrayList constructor. Instantiates the ArrayLists for feeding tasks,
     * prepped feeding tasks and cleaning tasks. Calls the fillArrays method within the
     * class to populate each array by adding tasks.
     * @param sched - object of class ScheduleBuilder
     */
    public CreateArrayList(ScheduleBuilder sched) throws IllegalArgumentException{
        try {        
            this.feedingTasks = new ArrayList<Feeding>();
            this.cleaningTasks = new ArrayList<Cleaning>();
            this.preppedFeedingTasks = new ArrayList<PreppedFeeding>();
            this.isScheduledTasks = new ArrayList<IsScheduled>();
            this.sched = sched;
            this.i = sched.getIterator();
        } catch (IllegalArgumentException error) {
            error.printStackTrace();
        }
    }

    /*
     * fillArrays method. This method is called only within this class to populate
     * the different ArrayLists that contain different objects. It iterates through each animal in the animals
     * ArrayList<Animal> from the ScheduleBuilder class, and populates the neccessary arraylists by its respective species.
     * No returns and no arguments.   
    */
    public void fillArrays() {
        ArrayList<Animal> animals = this.sched.getAnimalsArray();

        
        for (Animal animal : animals) {
            String species = animal.getAnimalSpecies();
            if (species.equals("beaver")) {
                populateAnimalTasks(animal, AnimalSpecies.BEAVER);
            }

            if (species.equals("porcupine")) {
                populateAnimalTasks(animal, AnimalSpecies.PORCUPINE);
            }

            if (species.equals("fox")) {
                populatePreppedFeedingAnimalTasks(animal, AnimalSpecies.FOX);
            }
        
            if (species.equals("coyote")) {
                populatePreppedFeedingAnimalTasks(animal, AnimalSpecies.COYOTE);  
            }

            if (species.equals("raccoon")) {
                populateAnimalTasks(animal, AnimalSpecies.RACCOON);
            }   
        }
    }


    /**
     * Void method that populates the cleaning tasks array list and the prepped feeding tasks array list.
     * @param animal - the inputted Animal object used to access a specific animalID
     * @param species - the inputted AnimalSpecies object used to get the cleaning information for a specific Animal object.
     */
    public void populatePreppedFeedingAnimalTasks (Animal animal, AnimalSpecies species) {
        cleaningTasks.add(new Cleaning(i, species.getCleaningDescription(), 
            species.getCleaningTime(), animal.getAnimalId()));
        buildIsScheduled(i);
        i+=1; 
        
        if (!isKit(animal)) {
            preppedFeedingTasks.add(new PreppedFeeding(i, species.getStartHour(), 
                species.getMaxWindow(), species.getFeedingDescription(), 
                species.getFoodPrepTime(), species.getFeedingTime(), animal.getAnimalId()));
            buildIsScheduled(i);
            i+=1;
        } 
    }

    /**
     * Void method that populates the cleaning tasks array list and feeding tasks array list.
     * @param animal - the inputted Animal object used to access a specific animalID
     * @param species - the inputted AnimalSpecies object used to get the cleaning information for a specific Animal object.
     */
    public void populateAnimalTasks (Animal animal, AnimalSpecies species) {               
        cleaningTasks.add(new Cleaning(i, species.getCleaningDescription(), 
            species.getCleaningTime(), animal.getAnimalId()));
        buildIsScheduled(i);
        i+=1;
        
        if (!isKit(animal)) {
            feedingTasks.add(new Feeding(i, species.getStartHour(), 
                species.getMaxWindow(), species.getFeedingDescription(), 
                species.getFeedingTime(), animal.getAnimalId()));
            buildIsScheduled(i);
            i+=1; 
        }
    }



    /**
     * Void method that adds all the tasks with a unique id to the array list of IsScheduled objects.
     * @param i - The integer list of unique IDs. 
    */
    public void addScheduledTreaments(int[] i) {
        for (int j = i.length - 1; j >= 0; j--) {
            isScheduledTasks.add(0, new IsScheduled(i[j])); // add element at index 0
        }
    }    


    /**
     * Building the is IsScheduled array which serves to tell which of the required tasks in the day have
     * been scheduled or not
     * @param i - The unique ID of the given task
    */
    public void buildIsScheduled(int i) {
        isScheduledTasks.add(new IsScheduled(i));
    }


    /**
     * Checks if an animal is a kit or not
     * If the animal is a kit, then treat its feeding as a medical treatment
     * @param animal - an object of class Animal
    */
    public boolean isKit(Animal animal) {
        int animalID = animal.getAnimalId();
        ArrayList<Treatment> treatments = this.sched.getTreatmentsArray();

        for (Treatment t : treatments) {
            if (t.getAnimalID() == animalID) {
                int treatmentID = t.getTaskID();
                if (treatmentID == 1) {
                    return true;
                }
            }
        }
        return false;
    }


    /*
     * Getters. Return the type ArrayList<Class Object>, where Class Object corresponds to the 
     * type of task list. No arguments.
     */
    public ArrayList<Feeding> getFeedingTasks() { return this.feedingTasks; }
    public ArrayList<PreppedFeeding> getPreppedFeedingTasks() { return this.preppedFeedingTasks; }
    public ArrayList<Cleaning> getCleaningTasks() { return this.cleaningTasks; }
    public ArrayList<IsScheduled> getIsScheduledTasks() { return this.isScheduledTasks; }
}
