package edu.ucalgary.oop;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class ScheduleTest {

    private ScheduleBuilder schedule;
    private CreateArrayList cal;

    @Before
    public void setUp() {
        this.schedule = new ScheduleBuilder();
    }




    // NOTES: we dont have to test the connection
    // @Test
    // public void testDBConnection() {
    //     boolean passed = true;
    //     try {schedule.createConnection();}

    //     catch (Exception e) {
    //         passed = true;
    //     }

    //     assertTrue("Method createConnection() did not throw an SQLExcetion when the database name was not EWR.", passed);
    // }


    // @Test
    // public void testBuildIsScheduled() {
    //     cal.buildIsScheduled(1);
    //     assertEquals(1, cal.getIsScheduledTasks().size());
    //     assertEquals(1, cal.getIsScheduledTasks().get(0).getUniqueID());
    // }




    @Test
    /*
     * Testing the getter methods in a class Animal object
     * Gtters should correctly return the animal ID, animal nickname, animal species
    */
    public void testAnimalClassGetters() {    
        Animal animal = new Animal(123, "Danny", "Dog");
        
        // Testing the getter for Animal ID
        int expResult = 123;
        int result = animal.getAnimalId();
        assertEquals("The Animal ID was incorrect: ", expResult, result);

        // Testing the getter for the Animal nickname
        String expResult1 = "Danny";
        String result1 = animal.getAnimalNickname();
        assertEquals("The Animal ID was incorrect: ", expResult1, result1);

        // Testing the getter for the Animal species
        String expResult2 = "Dog";
        String result2 = animal.getAnimalSpecies();
        assertEquals("The Animal ID was incorrect: ", expResult2, result2);
    }




    @Test
    /*
     * Testing the getter methods in a class task object
     * Gtters should correctly return the task ID, description, duration, max window
    */
    public void testTaskClassGetters() {    
        Task task = new Task(123, "description", 25, 4);
        
        // Testing the getter for Task ID
        int expResult = 123;
        int result = task.getTaskId();
        assertEquals("The Task ID was incorrect: ", expResult, result);

        // Testing the getter for the description
        String expResult1 = "description";
        String result1 = task.getDescription();
        assertEquals("The description was incorrect: ", expResult1, result1);

        // Testing the getter for the duration
        int expResult2 = 25;
        int result2 = task.getDuration();
        assertEquals("The duration was incorrect: ", expResult2, result2);

        // Testing the getter for the max window
        int expResult3 = 4;
        int result3 = task.getMaxWindow();
        assertEquals("The max window was incorrect: ", expResult3, result3);
    }




    @Test
    /*
     * Testing the getter methods in a class Treament object
     * Getters should correctly return the unique ID, animal ID, task ID, start hour
    */
    public void testTreatmentClassGetters() {    
        Treatment treatment = new Treatment(123, 456, 890, 0);
        
        // Testing the getter for unique ID
        int expResult = 123;
        int result = treatment.getUniqueID();
        assertEquals("The Unique ID was incorrect: ", expResult, result);

        // Testing the getter for the Animal ID
        int expResult1 = 456;
        int result1 = treatment.getAnimalID();
        assertEquals("The Animal ID was incorrect: ", expResult1, result1);

        // Testing the getter for the Task ID
        int expResult2 = 890;
        int result2 = treatment.getTaskID();
        assertEquals("The Task ID was incorrect: ", expResult2, result2);

        // Testing the getter for the start hour
        int expResult3 = 0;
        int result3 = treatment.getStartHour();
        assertEquals("The Start Hour was incorrect: ", expResult3, result3);
    }






    @Test
    /*
     * 1-argument constructor CreateArrayList() shouldn't throw an IllegalArgumentException 
     * when a ScheduleBuilder object is passed in.
    */
    public void testDoesNotThrowsExceptionWithInvalidObject() {
        boolean failed = false;
        
        ScheduleBuilder schedule = new ScheduleBuilder();
        
        try {
            CreateArrayList instance = new CreateArrayList(schedule);
        }
        catch (IllegalArgumentException e) {
            failed = true;
        }
        catch (Exception e) { }
        assertFalse("1-argument constructor CreateArrayList() thre IllegalArgumentException when ScheduleBuilder object was passed in", failed);
    }




    @Test
    /*
     * isKit() method in CreateArrayList should accurately return whether or not the passed 
     * in animal object is of an animal that is a kit, or not a kit.
     * returns true if the animal is a kit
     * returns false is the animal is not a kit  
    */
    public void testIsKit() {
        ScheduleBuilder schedule = new ScheduleBuilder();
        CreateArrayList instance = new CreateArrayList(schedule);
        
        Animal animal = new Animal(230, "Penny", "fox");
        Animal animal1 = new Animal(340, "Bart", "bird");
        
        ArrayList<Treatment> treatmentsArray = new ArrayList<Treatment>();
        treatmentsArray.add(new Treatment(1, 230, 1, 0));
        treatmentsArray.add(new Treatment(2, 340, 4, 0));

        schedule.setTreatmentsArray(treatmentsArray);

        boolean expResult = true;
        boolean result = instance.isKit(animal);
        assertEquals("animal is a kit but return value says it is not", expResult, result);

        boolean expResult1 = false;
        boolean result1 = instance.isKit(animal1);
        assertEquals("animal is not a kit but return value says it is", expResult1, result1);
    }

    // @Test
    // public void testScheduleBuilderGetters() {
    //     ScheduleBuilder schedule = new ScheduleBuilder();
    //     CreateArrayList instance = new CreateArrayList(schedule);
    //     int[] iterationsList;

    //     instance.setAnimalsArray();
    //     instance.setTasksArray();
    //     instance.set;
    //     instance.setAnimalsArray();
    // }




    // @Test
    // /*
    //  * program successfully calls a backup volunteer when priortized task in an hour exceed 60 
    //  * minutes.
    //  * MORE DETAIL
    // */
    // public void testCallBackUpVolunteer() {
    //     // implementation
    // }


    // @Test
    // /*
    //  * program successfully prompts for user input and updates the start hour in the database when a schedule cannot be made.
    //  * 
    // */
    // public void testUpdateStartHourInDatabase() {
    //     // implementation
    // }

    

}

