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
            fillArrays();
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
        //ScheduleBuilder sched = new ScheduleBuilder();
        //ArrayList<Animal> animals = new ArrayList<Animal>();
        ArrayList<Animal> animals = this.sched.getAnimalsArray();
        //System.out.println(animals);
        
        for (Animal animal : animals) {
            //System.out.println(animal.getAnimalId());
            //System.out.println(animal.getAnimalSpecies());
            String species = animal.getAnimalSpecies();
            //System.out.println(species);
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



    public void populatePreppedFeedingAnimalTasks (Animal animal, AnimalSpecies species) {
        cleaningTasks.add(new Cleaning(i, species.getCleaningDescription(), 
            species.getCleaningTime()));
        buildIsScheduled(i);
        i+=1; 
        
        if (!isKit(animal)) {
            preppedFeedingTasks.add(new PreppedFeeding(i, species.getStartHour(), 
                species.getMaxWindow(), species.getFeedingDescription(), 
                species.getFoodPrepTime(), species.getFeedingTime()));
            buildIsScheduled(i);
            i+=1;
        } 
    }

    public void populateAnimalTasks (Animal animal, AnimalSpecies species) {               
        cleaningTasks.add(new Cleaning(i, species.getCleaningDescription(), 
            species.getCleaningTime()));
        buildIsScheduled(i);
        i+=1;
        
        if (!isKit(animal)) {
            feedingTasks.add(new Feeding(i, species.getStartHour(), 
                species.getMaxWindow(), species.getFeedingDescription(), 
                species.getFeedingTime()));
            buildIsScheduled(i);
            i+=1; 
        }
    }



    /**
     * NEED TO FINISH
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
