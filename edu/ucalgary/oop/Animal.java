package edu.ucalgary.oop;


public class Animal {
    /*
     * Animal class populates an ArrayList of type ArrayList<Animal> that contains all of
     * the animals for a given database. All private class variables are final.
     */
    private final int ANIMALID;
    private final String ANIMALNICKNAME;
    private final String ANIMALSPECIES;

    /*
     * Animal class constructor, takes in arguments (int, String, String), 
     * and assigns private class variables.
     */
    public Animal(int animalId, String animalNickname, String animalSpecies) {
        try {
            if (animalId < 0 || animalNickname == null || animalSpecies == null) {
                throw new IllegalArgumentException("Invalid Animal Constructor parameters");
            }
            this.ANIMALID = animalId;
            this.ANIMALNICKNAME = animalNickname;
            this.ANIMALSPECIES = animalSpecies;
        } catch (IllegalArgumentException error) {
            System.err.println(error.getMessage());
            throw error;
        }
    }

    /*
     * Returns the integer animal ID. No args.
     */
    public int getAnimalId() {
        return this.ANIMALID;
    }

    /*
     * Returns the String animal nickname. No args.
     */
    public String getAnimalNickname() {
        return this.ANIMALNICKNAME;
    }

    /*
     * Returns the String animal species. No args.
     */
    public String getAnimalSpecies() {
        return this.ANIMALSPECIES;
    }
}
