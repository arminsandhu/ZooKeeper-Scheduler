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

    // I dont think we need to test the two SQL setters because they have no input.
    // @Test
    // public void testSetIterationsList() {
    //     int[] i = { 1, 3 };
    //     cal.addScheduledTreaments(i);
    //     assertEquals(2, cal.getIsScheduledTasks().size());
    //     assertEquals(3, cal.getIsScheduledTasks().get(0).getUniqueID());
    //     assertEquals(1, cal.getIsScheduledTasks().get(1).getUniqueID());
    // }

    // @Test
    // public void testBuildIsScheduled() {
    //     cal.buildIsScheduled(1);
    //     assertEquals(1, cal.getIsScheduledTasks().size());
    //     assertEquals(1, cal.getIsScheduledTasks().get(0).getUniqueID());
    // }

    // @Test
    // public void testIsKit() {
    //     Animal adultBeaver = new Animal(1, "beaver", "adult");
    //     assertFalse(cal.isKit(adultBeaver));
    //     Animal beaverKit = new Animal(2, "beaver", "kit");
    //     assertTrue(cal.isKit(beaverKit));
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
     * Gtters should correctly return the unique ID, animal ID, task ID, start hour
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
}

