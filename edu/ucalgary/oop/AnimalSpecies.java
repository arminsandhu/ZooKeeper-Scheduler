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
 * AnimalSpecies enumeration. Contains data regarding animal
 * cleaning time, feeding time, food prep time, task start hour and max window.
 */

package edu.ucalgary.oop;

public enum AnimalSpecies {

    COYOTE, FOX, PORCUPINE, RACCOON, BEAVER;

    /*
     * Getter getCleaningTime() returns the default integer 5 for all animals.
     */
    public int getCleaningTime() {
        switch(this) {
            default:
                return 5; 
        }
    }

    /*
     * Getter getFeedingTime() returns the default integer 5 for all animals.
     */
    public int getFeedingTime() {
        switch(this) {
            default:
                return 5;
        }
    }

    /*
     * Getter getFoodPrepTime() returns the prep time as an integer for foxes and 
     * coyotes. The default return is 0 for all other animals.
     */
    public int getFoodPrepTime() {
        switch(this) {
            case FOX:
                return 10;
            
            case COYOTE:
                return 10;

            default:
                return 0;
        }
    }

    /*
     * Getter getStartHour() returns the corresponding start hour for animal
     * feeding times as an integer.
     */
    public int getStartHour() {
        switch(this) {
            case FOX:
                return 0;

            case RACCOON:
                return 0;
            
            case COYOTE: 
                return 19;
            
            case PORCUPINE:
                return 19;

            case BEAVER:
                return 8;

            default:
                return 0;
        }
    }

    /*
     * Getter getMaxWindow() returns the max window for feeding tasks. This is 
     * 3 for all animals.
     */
    public int getMaxWindow() {
        switch(this) {
            default:
                return 3;
        }
    }

    /*
     * Getter getCleaningDescription() returns the String description for cleaning tasks
     * for each animal.
     */
    public String getCleaningDescription() {
        switch(this) {
            case FOX:
                return "Cleaning fox cage";

            case RACCOON:
                return "Cleaning raccoon cage";
            
            case COYOTE: 
                return "Cleaning coyote cage";
            
            case PORCUPINE:
                return "Cleaning porcupine cage";

            case BEAVER:
                return "Cleaning beaver cage";

            default:
                return null;
        }
    }


    /*
     * Getter getFeedingDescription() returns the String description for feeding tasks
     * for each animal.
     */
    public String getFeedingDescription() {
        switch(this) {
            case FOX:
                return "Feed foxes";

            case RACCOON:
                return "Feed raccoons";
            
            case COYOTE: 
                return "Feed coyotes";
            
            case PORCUPINE:
                return "Feed porcupines";

            case BEAVER:
                return "Feed beavers";

            default:
                return null;
        }
    }
}