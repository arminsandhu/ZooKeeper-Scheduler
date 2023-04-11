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
 * ScheduleTest is a java junit testing program that uses the unit testing to test the functionality of every
 * class and method of this scheduling program.
 */

package edu.ucalgary.oop;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


import org.junit.Before;
import org.junit.Test;

public class ScheduleTest {

    private ScheduleBuilder schedule;

    @Before
    public void setUp() {
        this.schedule = new ScheduleBuilder();
    }


    @Test
    /*
     * 3-argument constructor Animal() should throw an IllegalArgumentException 
     * when a an invalid parameter is passed in.
    */
    public void testAnimalClassConstructor() {
        boolean failed = false;
        
        // Testing if invalid animal ID throws an exception
        try {
            Animal animal = new Animal(-1, "Danny", "Dog");
        }
        catch (IllegalArgumentException e) {
            failed = true;
        }
        catch (Exception e) { }
        assertTrue("3-argument constructor Animal() did not throw an IllegalArgumentException when invalid animal ID was passed in", failed);


        // Testing if invalid animal nickname throws an exception
        failed = false;
        try {
            Animal animal = new Animal(123, null, "Dog");
        }
        catch (IllegalArgumentException e) {
            failed = true;
        }
        catch (Exception e) { }
        assertTrue("3-argument constructor Animal() did not throw an IllegalArgumentException when invalid animal nickname was passed in", failed);


        // Testing if invalid animal species throws an exception
        failed = false;
        try {
            Animal animal = new Animal(123, "Doug", null);
        }
        catch (IllegalArgumentException e) {
            failed = true;
        }
        catch (Exception e) { }
        assertTrue("3-argument constructor Animal() did not throw an IllegalArgumentException when invalid animal species was passed in", failed);
    }
    
    
    
    @Test
    /*
     * Testing the getAnimalID getter method in a class Animal object
     * Getter should correctly return the animal ID
    */
    public void testAnimalClassAnimalIDGetter() {    
        Animal animal = new Animal(123, "Danny", "Dog");
        
        // Testing the getter for Animal ID
        int expResult = 123;
        int result = animal.getAnimalId();
        assertEquals("The Animal ID was incorrect: ", expResult, result);

       
    }

    @Test
    /*
     * Testing the getAnimalNickname getter method in a class Animal object
     * Getter should correctly return the animal nickname
    */
    public void testAnimalClassAnimalNicknameGetter() {    
        Animal animal = new Animal(123, "Danny", "Dog");

        // Testing the getter for the Animal species
        String expResult2 = "Dog";
        String result2 = animal.getAnimalSpecies();
        assertEquals("The Animal ID was incorrect: ", expResult2, result2);
    }


    @Test
    /*
     * Testing the getAnimalSpecies getter method in a class Animal object
     * Getter should correctly return the animal species
    */
    public void testAnimalClassAnimalSpeciesGetter() {    
        Animal animal = new Animal(123, "Danny", "Dog");

        // Testing the getter for the Animal species
        String expResult2 = "Dog";
        String result2 = animal.getAnimalSpecies();
        assertEquals("The Animal ID was incorrect: ", expResult2, result2);
    }




    @Test
    /*
     * 4-argument constructor Task() should throw an IllegalArgumentException 
     * when a an invalid parameter is passed in.
    */
    public void testTaskClassConstructor() {
        boolean failed = false;
        
        // Testing if invalid task ID throws an exception
        try {
            Task task = new Task(-5, "description", 25, 4);
        }
        catch (IllegalArgumentException e) {
            failed = true;
        }
        catch (Exception e) { }
        assertTrue("4-argument constructor Task() did not throw an IllegalArgumentException when invalid task ID was passed in", failed);


        // Testing if invalid description throws an exception
        failed = false;
        try {
            Task task = new Task(123, null, 25, 4);
        }
        catch (IllegalArgumentException e) {
            failed = true;
        }
        catch (Exception e) { }
        assertTrue("4-argument constructor Task() did not throw an IllegalArgumentException when invalid description was passed in", failed);

    }


    @Test
    /*
     * Testing the getTaskId getter method in a class task object
     * Getter should correctly return the task ID
    */
    public void testTaskClassTaskIdGetter() {    
        Task task = new Task(123, "description", 25, 4);
        
        // Testing the getter for Task ID
        int expResult = 123;
        int result = task.getTaskId();
        assertEquals("The Task ID was incorrect: ", expResult, result);
    }


    @Test
    /*
     * Testing the getDescription getter method in a class task object
     * Getter should correctly return the task description
    */
    public void testTaskClassTaskDescriptionGetter() {    
        Task task = new Task(123, "description", 25, 4);
        
        // Testing the getter for the description
        String expResult1 = "description";
        String result1 = task.getDescription();
        assertEquals("The description was incorrect: ", expResult1, result1);
    }


    @Test
    /*
     * Testing the getDuration getter method in a class task object
     * Getter should correctly return the task duration
    */
    public void testTaskClassTaskDurationGetter() {    
        Task task = new Task(123, "description", 25, 4);
        
        // Testing the getter for the duration
        int expResult2 = 25;
        int result2 = task.getDuration();
        assertEquals("The duration was incorrect: ", expResult2, result2);
    }


    @Test
    /*
     * Testing the getMaxWindow getter method in a class task object
     * Getter should correctly return the tasks max window
    */
    public void testTaskClassTaskMaxWindowGetter() {    
        Task task = new Task(123, "description", 25, 4);
        
        // Testing the getter for the max window
        int expResult3 = 4;
        int result3 = task.getMaxWindow();
        assertEquals("The max window was incorrect: ", expResult3, result3);
    }


    
    @Test
    /*
     * 4-argument constructor Treatment() should throw an IllegalArgumentException 
     * when a an invalid parameter is passed in.
    */
    public void testTreatementClassConstructor() {
        boolean failed = false;
        
        // Testing if invalid unique ID (int) throws an exception
        try {
            Treatment treatment = new Treatment(-23, 456, 890, 0);
        }
        catch (IllegalArgumentException e) {
            failed = true;
        }
        catch (Exception e) { }
        assertTrue("4-argument constructor Treatment() did not throw an IllegalArgumentException when invalid unique ID was passed in", failed);


    }



    @Test
    /*
     * Testing the getUniqueID getter method in a class Treament object
     * Getter should correctly return the unique ID
    */
    public void testTreatmentClassUniqueIDGetter() {    
        Treatment treatment = new Treatment(123, 456, 890, 0);
        
        // Testing the getter for unique ID
        int expResult = 123;
        int result = treatment.getUniqueID();
        assertEquals("The Unique ID was incorrect: ", expResult, result);

    }



    @Test
    /*
     * Testing the getAnimalID getter method in a class Treament object
     * Getter should correctly return the animal ID
    */
    public void testTreatmentClassAnimalIDGetter() {    
        Treatment treatment = new Treatment(123, 456, 890, 0);

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
     * Testing the getTaskID getter method in a class Treament object
     * Getter should correctly return the task ID
    */
    public void testTreatmentClassTaskIDGetter() {    
        Treatment treatment = new Treatment(123, 456, 890, 0);

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
     * Testing the getStartHour getter method in a class Treament object
     * Getter should correctly return the task ID
    */
    public void testTreatmentClassStartHourGetter() {    
        Treatment treatment = new Treatment(123, 456, 890, 0);

        // Testing the getter for the start hour
        int expResult3 = 0;
        int result3 = treatment.getStartHour();
        assertEquals("The Start Hour was incorrect: ", expResult3, result3);
    }

    @Test
    /*
     * Testing the getUniqueID getter method in a class Cleaning object
     * Getter should correctly return the unique ID
    */
    public void testCleaningClassUniqueIDGetter() {    
        Cleaning cleaning = new Cleaning(987, "this is the description", 20, 456);
        
        // Testing the getter for unique ID
        int expResult = 987;
        int result = cleaning.getUniqueID();
        assertEquals("The Unique ID was incorrect: ", expResult, result);

    }


    @Test
    /*
     * Testing the getDescription getter method in a class Cleaning object
     * Getter should correctly return the description
    */
    public void testCleaningClassDescriptionGetter() {    
        Cleaning cleaning = new Cleaning(987, "this is the description", 20, 456);
        
        // Testing the getter for the description
        String expResult1 = "this is the description";
        String result1 = cleaning.getDescription();
        assertEquals("The description was incorrect: ", expResult1, result1);

        // Testing the getter for the duration
        int expResult2 = 20;
        int result2 = cleaning.getDuration();
        assertEquals("The duration was incorrect: ", expResult2, result2);


        // Testing the getter for the animal ID
        int expResult3 = 456;
        int result3 = cleaning.getAnimalID();
        assertEquals("The duration was incorrect: ", expResult3, result3);
    }


    @Test
    /*
     * Testing the getDuration getter method in a class Cleaning object
     * Getter should correctly return the duration
    */
    public void testCleaningClassDurationGetter() {    
        Cleaning cleaning = new Cleaning(987, "this is the description", 20, 456);
        
        // Testing the getter for the duration
        int expResult2 = 20;
        int result2 = cleaning.getDuration();
        assertEquals("The duration was incorrect: ", expResult2, result2);

        // Testing the getter for the animal ID
        int expResult3 = 456;
        int result3 = cleaning.getAnimalID();
        assertEquals("The duration was incorrect: ", expResult3, result3);
    }


    @Test
    /*
     * Testing the getAnimalID getter method in a class Cleaning object
     * Getter should correctly return the animal ID
    */
    public void testCleaningClassAnimalIDGetter() {    
        Cleaning cleaning = new Cleaning(987, "this is the description", 20, 456);
        
        // Testing the getter for the animal ID
        int expResult3 = 456;
        int result3 = cleaning.getAnimalID();
        assertEquals("The duration was incorrect: ", expResult3, result3);
    }


    @Test
    /*
     * Testing the getUniqueID getter method in a class Feeding object
     * Getter should correctly return the unique ID
    */
    public void testFeedingClassUniqueIDGetter() {    
        Feeding feeding = new Feeding(456, 4, 2, "this is the description", 35, 234);
        
        // Testing the getter for unique ID
        int expResult = 456;
        int result = feeding.getUniqueID();
        assertEquals("The Unique ID was incorrect: ", expResult, result);

    }



    @Test
    /*
     * Testing the getStartHour getter method in a class Feeding object
     * Getter should correctly return the start hour
    */
    public void testFeedingClassStartHourGetter() {    
        Feeding feeding = new Feeding(456, 4, 2, "this is the description", 35, 234);

        // Testing the getter for the start hour
        int expResult1 = 4;
        int result1 = feeding.getStartHour();
        assertEquals("The start hour was incorrect: ", expResult1, result1);
    }


    @Test
    /*
     * Testing the getMaxWindow getter method in a class Feeding object
     * Getter should correctly return the max window
    */
    public void testFeedingClassMaxWindowGetter() {    
        Feeding feeding = new Feeding(456, 4, 2, "this is the description", 35, 234);

        // Testing the getter for the max window
        int expResult2 = 2;
        int result2 = feeding.getMaxWindow();
        assertEquals("The max window was incorrect: ", expResult2, result2);
    }


    @Test
    /*
     * Testing the getDescription getter method in a class Feeding object
     * Getter should correctly return the description
    */
    public void testFeedingClassDescriptionGetter() {    
        Feeding feeding = new Feeding(456, 4, 2, "this is the description", 35, 234);

        // Testing the getter for the description
        String expResult3 = "this is the description";
        String result3 = feeding.getDescription();
        assertEquals("The description was incorrect: ", expResult3, result3);
    }


    @Test
    /*
     * Testing the getDuration getter method in a class Feeding object
     * Getter should correctly return the duration
    */
    public void testFeedingClassDurationGetter() {    
        Feeding feeding = new Feeding(456, 4, 2, "this is the description", 35, 234);

        // Testing the getter for the duration
        int expResult4 = 35;
        int result4 = feeding.getDuration();
        assertEquals("The duration was incorrect: ", expResult4, result4);
    }


    @Test
    /*
     * Testing the getAnimalID getter method in a class Feeding object
     * Getter should correctly return the animal ID
    */
    public void testFeedingClassAnimalIDGetter() {    
        Feeding feeding = new Feeding(456, 4, 2, "this is the description", 35, 234);

        // Testing the getter for the animal ID
        int expResult5 = 234;
        int result5 = feeding.getAnimalID();
        assertEquals("The animalID was incorrect: ", expResult5, result5);
    }




    @Test
    /*
     * Testing the getUniqueID getter method in a class PreppedFeeding object
     * Getter should correctly return the unique ID
    */
    public void testPreppedFeedingClassUniqueIDGetters() {    
        PreppedFeeding preppedFeeding = new PreppedFeeding(789, 11, 2, "this is another description", 15, 30, 678);
        
        // Testing the getter for unique ID
        int expResult = 789;
        int result = preppedFeeding.getUniqueID();
        assertEquals("The Unique ID was incorrect: ", expResult, result);
    }


    @Test
    /*
     * Testing the getStartHour getter method in a class PreppedFeeding object
     * Getter should correctly return the start hour
    */
    public void testPreppedFeedingClassStartHourGetters() {    
        PreppedFeeding preppedFeeding = new PreppedFeeding(789, 11, 2, "this is another description", 15, 30, 678);

        // Testing the getter for the start hour
        int expResult1 = 11;
        int result1 = preppedFeeding.getStartHour();
        assertEquals("The start hour was incorrect: ", expResult1, result1);
    }


    @Test
    /*
     * Testing the getMaxWindow getter method in a class PreppedFeeding object
     * Getter should correctly return the max window
    */
    public void testPreppedFeedingClassMaxWindowGetters() {    
        PreppedFeeding preppedFeeding = new PreppedFeeding(789, 11, 2, "this is another description", 15, 30, 678);

        // Testing the getter for the max window
        int expResult2 = 2;
        int result2 = preppedFeeding.getMaxWindow();
        assertEquals("The max window was incorrect: ", expResult2, result2);
    }


    @Test
    /*
     * Testing the getDescription getter method in a class PreppedFeeding object
     * Getter should correctly return the description
    */
    public void testPreppedFeedingClassDescriptionGetters() {    
        PreppedFeeding preppedFeeding = new PreppedFeeding(789, 11, 2, "this is another description", 15, 30, 678);

        // Testing the getter for the description
        String expResult3 = "this is another description";
        String result3 = preppedFeeding.getDescription();
        assertEquals("The description was incorrect: ", expResult3, result3);

    }



    @Test
    /*
     * Testing the getPrepTime getter method in a class PreppedFeeding object
     * Getter should correctly return the prep time
    */
    public void testPreppedFeedingClassPrepTimeGetters() {    
        PreppedFeeding preppedFeeding = new PreppedFeeding(789, 11, 2, "this is another description", 15, 30, 678);

        // Testing the getter for the prep time
        int expResult4 = 15;
        int result4 = preppedFeeding.getPrepTime();
        assertEquals("The prep time was incorrect: ", expResult4, result4);

    }


    @Test
    /*
     * Testing the getDuration getter method in a class PreppedFeeding object
     * Getter should correctly return the duration
    */
    public void testPreppedFeedingClassDurationGetters() {    
        PreppedFeeding preppedFeeding = new PreppedFeeding(789, 11, 2, "this is another description", 15, 30, 678);

        // Testing the getter for the duration
        int expResult5 = 30;
        int result5 = preppedFeeding.getDuration();
        assertEquals("The duration was incorrect: ", expResult5, result5);

    }


    @Test
    /*
     * Testing the getAnimalID getter method in a class PreppedFeeding object
     * Getter should correctly return the animal ID
    */
    public void testPreppedFeedingClassAnimalIDGetters() {    
        PreppedFeeding preppedFeeding = new PreppedFeeding(789, 11, 2, "this is another description", 15, 30, 678);

        // Testing the getter for animal ID
        int expResult6 = 678;
        int result6 = preppedFeeding.getAnimalID();
        assertEquals("The animal ID was incorrect: ", expResult6, result6);

    }



    @Test
    /*
     * Testing the getUniqueID getter method in a class IsScheduled object
     * Getter should correctly return the unique ID
    */
    public void testIsScheduledClassUniqueIDGetter() {    
        IsScheduled isScheduled = new IsScheduled(135);
        
        // Testing the getter for unique ID
        int expResult = 135;
        int result = isScheduled.getUniqueID();
        assertEquals("The Unique ID was incorrect: ", expResult, result);
    }


    @Test
    /*
     * Testing the getIsScheduled getter method in a class IsScheduled object
     * Getter should correctly return the truth value for if a given task is scheduled
    */
    public void testIsScheduledClassIsScheduledGetter() {    
        IsScheduled isScheduled = new IsScheduled(135);
        
        // Testing the getter for isSched
        boolean expResult1 = false;
        boolean result1 = isScheduled.getIsScheduled();
        assertEquals("The boolean isSched was incorrect: ", expResult1, result1);
    }


    @Test
    /*
     * Testing the setIsScheduled setter method in a class IsScheduled object
     * Setter should correctly assign the truth value for if a given task is scheduled
    */
    public void testIsScheduledClassIsScheduledSetter() {    
        IsScheduled isScheduled = new IsScheduled(135);
        
        // Testing the setter for the isSched, should set isSched to true
        // set isSched to true
        isScheduled.setIsScheduled();
        boolean expResult2 = true;
        
        // get value of isSched in isScheduled (which should now be true)
        boolean result2 = isScheduled.getIsScheduled();
        assertEquals("The boolean isSched was incorrect: ", expResult2, result2);

    }


    @Test
    /*
     * Testing PopulatePreppedFeedingAnimalTasks() method in CreateArrayList class.
     * Ensuring that the method populates the cleaning tasks for each animal
     * Ensuring that the method populates the right amount of tasks in each array for that object
     * 
     */
    public void testPopulatePreppedFeedingAnimalTasks() {
        ScheduleBuilder sched = new ScheduleBuilder();
        CreateArrayList createArrayList = new CreateArrayList(sched);
        
        Animal animal = new Animal(230, "Penny", "fox");

        AnimalSpecies species = AnimalSpecies.FOX;
        
        ArrayList<Treatment> treatmentsArray = new ArrayList<Treatment>();
        treatmentsArray.add(new Treatment(1, 230, 2, 0));

        sched.setTreatmentsArray(treatmentsArray);

        createArrayList.populatePreppedFeedingAnimalTasks(animal, species);

        // Testing to see if a preppped feeding task object is made when the method is called
        assertFalse(createArrayList.getPreppedFeedingTasks().isEmpty());
        
        // Testing to see if a cleaning task object is made when the method is called
        assertFalse(createArrayList.getCleaningTasks().isEmpty());

        // Testing to see if the right amount of tasks (1) are created for passed in animal object
        assertEquals(1, createArrayList.getPreppedFeedingTasks().size());
        assertEquals(1, createArrayList.getCleaningTasks().size());
    }



    
    @Test
    /*
     * Testing PopulateAnimalTasks() method in CreateArrayList class.
     * Ensuring that the method populates the cleaning tasks for each animal
     * Ensuring that the method populates the right amount of tasks in each array for that object
     */
    public void testPopulateAnimalTasks() {
        ScheduleBuilder sched = new ScheduleBuilder();
        CreateArrayList createArrayList = new CreateArrayList(sched);
        
        Animal animal = new Animal(230, "Poppy", "beaver");

        AnimalSpecies species = AnimalSpecies.BEAVER;

        ArrayList<Treatment> treatmentsArray = new ArrayList<Treatment>();
        // not a kit
        treatmentsArray.add(new Treatment(1, 230, 2, 0));

        sched.setTreatmentsArray(treatmentsArray);

        createArrayList.populateAnimalTasks(animal, species);

        // Testing to see if a feeding task object is made when the method is called and animal is not a kit
        assertFalse(createArrayList.getFeedingTasks().isEmpty());
       
        // Testing to see if a cleaning task object is made when the method is called
        assertFalse(createArrayList.getCleaningTasks().isEmpty());

        // Testing to see if the right amount of tasks (1) are created for passed in animal object
        assertEquals(1, createArrayList.getFeedingTasks().size());
        assertEquals(1, createArrayList.getCleaningTasks().size());
    }



    @Test
    /*
     * Testing the buildIsScheduled() method in CreateArrayList class.
     * This method should populate the IsScheduledTasks array list.
     */
    public void testBuildIsScheduled() {
       
        ScheduleBuilder sched = new ScheduleBuilder();
        CreateArrayList createArrayList = new CreateArrayList(sched);

        createArrayList.buildIsScheduled(1);
        createArrayList.buildIsScheduled(2);

        // Tests to make sure tasks are adding into IsScheduledTasks
        assertFalse(createArrayList.getIsScheduledTasks().isEmpty());
        
        // Tests to see if the right amount of tasks are inserted into IsScheduledTasks
        assertEquals(2, createArrayList.getIsScheduledTasks().size());
    }





    @Test
    /*
     * 1-argument constructor CreateArrayList() shouldn't throw an IllegalArgumentException 
     * when a ScheduleBuilder object is passed in.
    */
    public void testCreateArrayListObject() {
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
     * Testing the getter cleaning time method in AnimalSpecies class for enums COYOTE, FOX, PORCUPINE, RACCOON, BEAVER
     * Getters should correctly return the cleaning time for each specified animal species
    */
    public void testGetCleaningTime() {
        // Testing if the AnimalSpecies method getCleaningTime equals the expected cleaning time
        assertEquals(5, AnimalSpecies.COYOTE.getCleaningTime());

        assertEquals(5, AnimalSpecies.FOX.getCleaningTime());

        assertEquals(5, AnimalSpecies.PORCUPINE.getCleaningTime());

        assertEquals(5, AnimalSpecies.RACCOON.getCleaningTime());

        assertEquals(5, AnimalSpecies.BEAVER.getCleaningTime());
    }




    @Test
    /*
     * Testing the getter feeding time method in AnimalSpecies class for enums COYOTE, FOX, PORCUPINE, RACCOON, BEAVER
     * Getters should correctly return the feeding time for each specified animal species
    */
    public void testGetFeedingTime() {
        // Testing if the AnimalSpecies method getFeedingTime equals the expected feeding time
        assertEquals(5, AnimalSpecies.COYOTE.getFeedingTime());

        assertEquals(5, AnimalSpecies.FOX.getFeedingTime());

        assertEquals(5, AnimalSpecies.PORCUPINE.getFeedingTime());

        assertEquals(5, AnimalSpecies.RACCOON.getFeedingTime());

        assertEquals(5, AnimalSpecies.BEAVER.getFeedingTime());
    }




    @Test
    /*
     * Testing the getter foor prep time method in AnimalSpecies class for enums COYOTE, FOX, PORCUPINE, RACCOON, BEAVER
     * Getters should correctly return the food prep time for each specified animal species
    */
    public void testGetFoodPrepTime() {
        // Testing if the AnimalSpecies method getFoodPrepTime equals the expected food prep time
        assertEquals(10, AnimalSpecies.COYOTE.getFoodPrepTime());

        assertEquals(10, AnimalSpecies.FOX.getFoodPrepTime());

        assertEquals(0, AnimalSpecies.PORCUPINE.getFoodPrepTime());

        assertEquals(0, AnimalSpecies.RACCOON.getFoodPrepTime());

        assertEquals(0, AnimalSpecies.BEAVER.getFoodPrepTime());
    }




    @Test
    /*
     * Testing the getter start hour method in AnimalSpecies class for enums COYOTE, FOX, PORCUPINE, RACCOON, BEAVER
     * Getters should correctly return the start hour for each specified animal species
    */
    public void testGetStartHour() {
        // Testing if the AnimalSpecies method getStartHour equals the expected start hour
        assertEquals(19, AnimalSpecies.COYOTE.getStartHour());

        assertEquals(0, AnimalSpecies.FOX.getStartHour());

        assertEquals(19, AnimalSpecies.PORCUPINE.getStartHour());

        assertEquals(0, AnimalSpecies.RACCOON.getStartHour());

        assertEquals(8, AnimalSpecies.BEAVER.getStartHour());
    }




    @Test
    /*
     * Testing the getter max window method in AnimalSpecies class for enums COYOTE, FOX, PORCUPINE, RACCOON, BEAVER
     * Getters should correctly return the max window for each specified animal species
    */
    public void testGetMaxWindow() {
        // Testing if the AnimalSpecies method getMaxWindow equals the expected max window
        assertEquals(3, AnimalSpecies.COYOTE.getMaxWindow());

        assertEquals(3, AnimalSpecies.FOX.getMaxWindow());

        assertEquals(3, AnimalSpecies.PORCUPINE.getMaxWindow());

        assertEquals(3, AnimalSpecies.RACCOON.getMaxWindow());

        assertEquals(3, AnimalSpecies.BEAVER.getMaxWindow());
    }




    @Test
    /*
     * Testing the getter cleaning description method in AnimalSpecies class for enums COYOTE, FOX, PORCUPINE, RACCOON, BEAVER
     * Getters should correctly return the cleaning description for each specified animal species
    */
    public void testGetCleaningDescription() {
        // Testing if the AnimalSpecies method getCleaningDescription equals the expected cleaning description
        assertEquals("Cleaning coyote cage", AnimalSpecies.COYOTE.getCleaningDescription());

        assertEquals("Cleaning fox cage", AnimalSpecies.FOX.getCleaningDescription());

        assertEquals("Cleaning porcupine cage", AnimalSpecies.PORCUPINE.getCleaningDescription());

        assertEquals("Cleaning raccoon cage", AnimalSpecies.RACCOON.getCleaningDescription());

        assertEquals("Cleaning beaver cage", AnimalSpecies.BEAVER.getCleaningDescription());
    }




    @Test
    /*
     * Testing the getter feeding description  method in AnimalSpecies class for enums COYOTE, FOX, PORCUPINE, RACCOON, BEAVER
     * Getters should correctly return the feeding description for each specified animal species
    */
    public void testGetFeedingDescription() {
        // Testing if the AnimalSpecies method getFeedingDescription equals the expected feeding description
        assertEquals("Feed coyotes", AnimalSpecies.COYOTE.getFeedingDescription());

        assertEquals("Feed foxes", AnimalSpecies.FOX.getFeedingDescription());

        assertEquals("Feed porcupines", AnimalSpecies.PORCUPINE.getFeedingDescription());

        assertEquals("Feed raccoons", AnimalSpecies.RACCOON.getFeedingDescription());

        assertEquals("Feed beavers", AnimalSpecies.BEAVER.getFeedingDescription());
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


    /**
     * Tests the constructor and getters of the FinalSchedule class by creating a new instance of the class
     * and asserting that the values returned by the getters match the values passed to the constructor.
     */
    @Test
    public void testFinalScheduleConstructorAndGetters() {
        int unique = 1;
        String description = "Final exam";
        int quantity = 1;
        int timeSpent = 0;
        int timeAvailable = 120;
        String nickname = "Exam";
        FinalSchedule schedule = new FinalSchedule(unique, description, quantity, timeSpent, timeAvailable, nickname);
        assertEquals(unique, schedule.getUniqueId());
        assertEquals(description, schedule.getDescription());
        assertEquals(quantity, schedule.getQuantity());
        assertEquals(timeSpent, schedule.getTimeSpent());
        assertEquals(timeAvailable, schedule.getTimeAvailable());
        assertEquals(nickname, schedule.getNickname());
    }

    /**
     * Tests the compareTo method of the FinalSchedule class by creating two instances of the class with different
     * timeAvailable values and asserting that the comparison result is less than 0.
     */
    @Test
    public void testFinalScheduleCompareToLessThan() {
        FinalSchedule schedule1 = new FinalSchedule(1, "Final exam 1", 1, 0, 60, "Exam 1");
        FinalSchedule schedule2 = new FinalSchedule(2, "Final exam 2", 1, 0, 120, "Exam 2");
        assertTrue(schedule1.compareTo(schedule2) < 0);
    }

    /**
     * Tests the compareTo method of the FinalSchedule class by creating two instances of the class with different
     * timeAvailable values and asserting that the comparison result is greater than 0.
     */
    @Test
    public void testFinalScheduleCompareToGreaterThan() {
        FinalSchedule schedule1 = new FinalSchedule(1, "Final exam 1", 1, 0, 120, "Exam 1");
        FinalSchedule schedule2 = new FinalSchedule(2, "Final exam 2", 1, 0, 60, "Exam 2");
        assertTrue(schedule1.compareTo(schedule2) > 0);
    }

    /**
     * Tests the compareTo method of the FinalSchedule class by creating two instances of the class with different
     * timeAvailable values and asserting that the comparison result is equal.
     */
    @Test
    public void testFinalScheduleCompareToEquals() {
        FinalSchedule schedule1 = new FinalSchedule(1, "Final exam 1", 1, 0, 60, "Exam 1");
        FinalSchedule schedule2 = new FinalSchedule(2, "Final exam 2", 1, 0, 60, "Exam 2");
        assertTrue(schedule1.compareTo(schedule2) == 0);
    }




    @Test
    /*
     * Testing the constructor of the TableGUI Class
     * Checks if the constructor does not initialize the object to null
     * Checks if the title of the table object is Completed Schedule
     */
    public void testTableGUIConstructor() {
      
      // Create a new ScheduleBuilder instance
      ScheduleBuilder schedule = new ScheduleBuilder();
      
      // Create a new TableGUI instance, passing the schedule as a parameter
      TableGUI tableGUI = new TableGUI(schedule);
      
      // Assert that the tableGUI object is not null
      assertNotNull(tableGUI);
      
      // Assert that the title of the tableGUI object is "Completed Schedule"
      assertEquals("Completed Schedule", tableGUI.getTitle());
    }



    @Test
    /*
     * Testing the setUpTableData method in TableGUI
     * Testing the getters to ensure all getters work correctly
     * The getter used by passing in the column we want to header for 
     */
    public void testSetUpTableData() {
      ScheduleBuilder schedule = new ScheduleBuilder();
      TableGUI tableGUI = new TableGUI(schedule);
      tableGUI.setUpTableData();
      DefaultTableModel model = (DefaultTableModel) ((JTable) ((JScrollPane) tableGUI.getContentPane().getComponent(1)).getViewport().getView()).getModel();
      assertEquals("Hour", model.getColumnName(0));
      assertEquals("Task description", model.getColumnName(1));
      assertEquals("Animal Name", model.getColumnName(2));
      assertEquals("Qty", model.getColumnName(3));
      assertEquals("Time spent", model.getColumnName(4));
      assertEquals("Time available", model.getColumnName(5));
      assertEquals(0, model.getRowCount());
    }


    @Test
    /*
     * Testing the getter and setter of the treatmentsArray in the ScheduleBuilder class
     * Creates an array list of treatment objects and sets the array list to the treatmentsArray in ScheduleBuilder object
     * Uses the getter to retrieve the treatmentsArray in ScheduleBuilder object
     * 
     */
    public void testSetTreatmentArray() {
        ScheduleBuilder schedule = new ScheduleBuilder();
        ArrayList<Treatment> treatmentsArray = new ArrayList<Treatment>();
        treatmentsArray.add(new Treatment(1, 230, 1, 0));
        treatmentsArray.add(new Treatment(2, 340, 4, 0));

        schedule.setTreatmentsArray(treatmentsArray);

        ArrayList<Treatment> expected = treatmentsArray;
        ArrayList<Treatment> actual = schedule.getTreatmentsArray();

        assertEquals("The treatment array was incorrect: ", expected, actual);

    }


    @Test
    /*
     * Testing the getter and setter of the tasksArray in the ScheduleBuilder class
     * Creates an array list of task objects and sets the array list to the tasksArray in ScheduleBuilder object
     * Uses the getter to retrieve the tasksArray in ScheduleBuilder object
     * 
     */
    public void testSetTaskArray() {
        ScheduleBuilder schedule = new ScheduleBuilder();
        ArrayList<Task> taskArray = new ArrayList<Task>();
        taskArray.add(new Task(1, "description", 10, 2));
        taskArray.add(new Task(2, "description2", 40, 4));

        schedule.setTasksArray(taskArray);

        ArrayList<Task> expected = taskArray;
        ArrayList<Task> actual = schedule.getTasksArray();

        assertEquals("The task array was incorrect: ", expected, actual);

    }




    @Test
    /*
     * Testing the getter and setter of the animalsArray in the ScheduleBuilder class
     * Creates an array list of animal objects and sets the array list to the animalsArray in ScheduleBuilder object
     * Uses the getter to retrieve the animalsArray in ScheduleBuilder object
     * 
     */
    public void testSetAnimalArray() {
        ScheduleBuilder schedule = new ScheduleBuilder();
        ArrayList<Animal> animalArray = new ArrayList<Animal>();
        animalArray.add(new Animal(1, "Don", "bird"));
        animalArray.add(new Animal(2, "Cam", "penguin"));

        schedule.setAnimalsArray(animalArray);

        ArrayList<Animal> expected = animalArray;
        ArrayList<Animal> actual = schedule.getAnimalsArray();

        assertEquals("The animal array was incorrect: ", expected, actual);

    }


    @Test
    /*
     * Testing the getter and setter of the FinalSchedule in the ScheduleBuilder class
     * Creates an TreeSet of Final Schedule objects and sets it to Final Schedule in ScheduleBuilder
     * Uses the getter to retrieve the Final Schedule in ScheduleBuilder object
     * 
     */
    public void testSetAndGetFinalSchedule() {
        ScheduleBuilder schedule = new ScheduleBuilder();
        
        HashMap<Integer, TreeSet<FinalSchedule>> testData = new HashMap<>();
        
        TreeSet<FinalSchedule> schedules = new TreeSet<>();
        
        schedules.add(new FinalSchedule(3, "description", 5, 10, 50, "Katy"));
        
        testData.put(0, schedules);

        schedule.setFinalSchedule(0, schedules);

        assertEquals("The final schedule was incorrect: ", testData, schedule.getFinalSchedule());
    }

    



    @Test
    /*
     * Testing the getter and setter of the finalTree in the ScheduleBuilder class
     * Creates an TreeSet of Final Schedule objects and sets it to Final Schedule in ScheduleBuilder
     * Uses the getter to retrieve the Final Tree in ScheduleBuilder object
     * 
     */
    public void testGetFinalTree() {
        ScheduleBuilder schedule = new ScheduleBuilder();

        TreeSet<FinalSchedule> expectedTree = new TreeSet<>();
                
        
        // Add some data to the expectedTree set
        expectedTree.add(new FinalSchedule(0, "description 1", 1, 10, 50, "Jack"));
        expectedTree.add(new FinalSchedule(1, "description 2", 2, 20, 40, "Jill"));
        expectedTree.add(new FinalSchedule(2, "description 3", 3, 30, 30, "Bill"));

        schedule.setFinalTree(expectedTree);
        TreeSet<FinalSchedule> actualTree = schedule.getFinalTree();
        assertEquals("The final tree was incorrect: ", expectedTree, actualTree);
    }


    @Test
    /*
     * Testing the resetFinalTree() method in ScheduleBuilder
     * Creates a TreeSet of FinalSchedule objects and adds to the TreeSet 
     * Calls the resetFinalTree() method 
     */
    public void testResetFinalTree() {
        // Create a new ScheduleBuilder object
        ScheduleBuilder scheduleBuilder = new ScheduleBuilder();

        // Add some data to the finalTree set
        TreeSet<FinalSchedule> expectedFinalTree = new TreeSet<>();
        expectedFinalTree.add(new FinalSchedule(0, "description 1", 1, 10, 50, "Jack"));
        expectedFinalTree.add(new FinalSchedule(1, "description 2", 2, 20, 40, "Jill"));
        expectedFinalTree.add(new FinalSchedule(2, "description 3", 3, 30, 30, "Bill"));
        scheduleBuilder.setFinalTree(expectedFinalTree);

        // Call the resetFinalTree method
        scheduleBuilder.resetFinalTree();

        // Test that the finalTree set is empty
        TreeSet<FinalSchedule> actualFinalTree = scheduleBuilder.getFinalTree();
        assertTrue(actualFinalTree.isEmpty());
    }









}

