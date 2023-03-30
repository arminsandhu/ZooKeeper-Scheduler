package edu.ucalgary.oop;

public enum AnimalSpecies {
    // ASK IF THIS IS RIGHT
    // I'd assume we want to return a string since the species name shouldn't be all capitalized hahah
    
    COYOTE {
        public String toString() {
            return "coyote";
        }
    },
    FOX {
        public String toString() {
            return "fox";
        }
    },
    PORCUPINE {
        public String toString() {
            return "porcupine";
        }
    },
    RACCOON {
        public String toString() {
            return "raccoon";
        }
    },
    BEAVER {
        public String toString() {
            return "beaver";
        }
    };

    public abstract String toString();
}
