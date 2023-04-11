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
 * A class that creates a final schedule object that implements the Comparable interface with a type parameter
 * of FinalSchedule. 
 */

package edu.ucalgary.oop;

public class FinalSchedule implements Comparable<FinalSchedule> {
    
    private final int UNIQUEID;
    private String description;
    private int quantity;
    private int timeSpent;
    private int timeAvailable;
    private String nickname;

    /**
     * Constructor for the FinalSchedule class.
     * @param unique The unique ID of the schedule.
     * @param description The description of the schedule.
     * @param quantity The quantity of the schedule.
     * @param timeSpent The time spent on the schedule.
     * @param timeAvailable The time available for the schedule.
     */
    public FinalSchedule(int unique, String description, int quantity, int timeSpent, int timeAvailable, String nickname) {
        this.UNIQUEID = unique;
        this.description = description;
        this.quantity = quantity;
        this.timeSpent = timeSpent;
        this.timeAvailable = timeAvailable;
        this.nickname = nickname;
    }
    
    /*
     * Getters, getUniqueId(), getQuantity(), getTimeSpent() and getTimeAvailable() all return
     * type int. getDescription() returns a String.
     */
    public int getUniqueId() { return this.UNIQUEID; }
    public String getDescription() { return this.description; }
    public int getQuantity() { return this.quantity; }
    public int getTimeSpent() { return this.timeSpent; }
    public int getTimeAvailable() { return this.timeAvailable; }
    public String getNickname() { return this.nickname; }

    /**
     * Compares two FinalSchedule objects based on their timeAvailable variable.
     * @param other The other FinalSchedule object to be compared.
     * @return -1 if this object's timeAvailable is less than the other object's timeAvailable,
     *          1 if this object's timeAvailable is greater than the other object's timeAvailable,
     *          0 if this object's timeAvailable is equal to the other object's timeAvailable.
     */
    @Override
    public int compareTo(FinalSchedule other) {
        if (this.timeAvailable < other.timeAvailable) {
            return -1;
        } else if (this.timeAvailable > other.timeAvailable) {
            return 1;
        } else {
            return 0;
        }
    }
}
