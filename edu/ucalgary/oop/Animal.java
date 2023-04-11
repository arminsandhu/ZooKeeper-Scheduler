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
 * Animal class populates an ArrayList of type ArrayList<Animal> that contains all of
 * the animals for a given database. All private class variables are final.
 */

package edu.ucalgary.oop;

public class Animal {
    
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
