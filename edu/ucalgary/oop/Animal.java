package edu.ucalgary.oop;


public class Animal {
    /*
     * Animal class populates a ScheduleBuilder ArrayList of type ArrayList<Animal> that contains all 
     * the animals for a given database. 
     */
    private final int ANIMALID;
    private final String ANIMALNICKNAME;
    private final String ANIMALSPECIES;

    // constructor for Animal class
    public Animal(int animalId, String animalNickname, String animalSpecies) {
        this.ANIMALID = animalId;
        this.ANIMALNICKNAME = animalNickname;
        this.ANIMALSPECIES = animalSpecies;
    }

    // get ANIMALID
    public int getAnimalId() {
        return this.ANIMALID;
    }

    // get ANIMALNICKNAME
    public String getAnimalNickname() {
        return this.ANIMALNICKNAME;
    }

    // get ANIMALSPECIES
    public String getAnimalSpecies() {
        return this.ANIMALSPECIES;
    }
}
