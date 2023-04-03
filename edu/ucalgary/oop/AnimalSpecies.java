package edu.ucalgary.oop;

public enum AnimalSpecies {
    /*
     * this will hold all the info about each species look at the photo i(ella) took
     */
    COYOTE, FOX, PORCUPINE, RACCOON, BEAVER;

    public int getCleaningTime() {
        switch(this) {
            default:
                return 5; 
        }
    }

    public int getFeedingTime() {
        switch(this) {
            default:
                return 5;
        }
    }

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
    public int getMaxWindow() {
        switch(this) {
            default:
                return 3;
        }
    }
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