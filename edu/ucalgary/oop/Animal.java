package edu.ucalgary.oop;

public class Animal {
    private final int ANIMALID;
    private final String ANIMALNICKNAME;
    private final String ANIMALSPECIES;

    public Animal(int animalId, String animalNickname, String animalSpecies) {
        this.ANIMALID = animalId;
        this.ANIMALNICKNAME = animalNickname;
        this.ANIMALSPECIES = animalSpecies;
    }

    // getters
    // we dont need setters

    public int getAnimalId() {
        return this.ANIMALID;
    }

    public String getAnimalNickname() {
        return this.ANIMALNICKNAME;
    }

    public String getAnimalSpecies() {
        return this.ANIMALSPECIES;
    }
}
