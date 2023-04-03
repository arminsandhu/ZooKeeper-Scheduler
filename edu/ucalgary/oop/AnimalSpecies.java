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

        public int getStartHour() {
            return 19;
        }

        public int getMaxWindow() {
            return 3;
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

        public int getStartHour() {
            return 0;
        }

        public int getMaxWindow() {
            return 3;
        }
    },
    PORCUPINE {
        public String toString() {
            return "porcupine";
        }

        public int getCleaningTime() {
            return 5;
        }

        public int getFeedingTime() {
            return 5;
        }

        public int getStartHour() {
            return 19;
        }

        public int getMaxWindow() {
            return 3;
        }
    },
    RACCOON {
        public String toString() {
            return "raccoon";
        }

        public int getCleaningTime() {
            return 5;
        }

        public int getFeedingTime() {
            return 5;
        }

        public int getStartHour() {
            return 0;
        }

        public int getMaxWindow() {
            return 3;
        }
    },
    BEAVER {
        public String toString() {
            return "beaver";
        }

        public int getCleaningTime() {
            return 5;
        }

        public int getFeedingTime() {
            return 5;
        }

        public int getStartHour() {
            return 8;
        }

        public int getMaxWindow() {
            return 3;
        }

    };

    public abstract String toString();

    public abstract int getC
}
