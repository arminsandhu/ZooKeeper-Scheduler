package edu.ucalgary.oop;

public enum AnimalSpecies {
    /*
     * this will hold all the info about each species look at the photo i(ella) took
     */
    COYOTE {
        public String toString() {
            return "coyote";
        }

        public int getCleaningTime() {
            return 5;
        }

        public int getFoodPrepTime() {
            return 10;
        }

        public int getFeedingTime() {
            return 5;
        }
    },
    FOX {
        public String toString() {
            return "fox";
        }

        public int getCleaningTime() {
            return 5;
        }

        public int getFoodPrepTime() {
            return 10;
        }

        public int getFeedingTime() {
            return 5;
        }
    },
    PORCUPINE {
        public String toString() {
            return "porcupine";
        }

        public int getCleaningTime() {
            return 5;
        }

        public int getFoodPrepTime() {
            return 10;
        }

        public int getFeedingTime() {
            return 5;
        }
    },
    RACCOON {
        public String toString() {
            return "raccoon";
        }

        public int getCleaningTime() {
            return 5;
        }

        public int getFoodPrepTime() {
            return 10;
        }

        public int getFeedingTime() {
            return 5;
        }
    },
    BEAVER {
        public String toString() {
            return "beaver";
        }

        public int getCleaningTime() {
            return 5;
        }

        public int getFoodPrepTime() {
            return 10;
        }

        public int getFeedingTime() {
            return 5;
        }
    };

    public abstract String toString();

    public abstract int getC
}
