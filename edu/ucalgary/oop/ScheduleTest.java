package edu.ucalgary.oop;

import static org.junit.Assert.*;
import java.util.ArrayList;
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
     * Testing the getter methods in a class Cleaning object
     * Getters should correctly return the unique ID, description, duration, animal ID
    */
    public void testCleaningClassGetters() {    
        Cleaning cleaning = new Cleaning(987, "this is the description", 20, 456);
        
        // Testing the getter for unique ID
        int expResult = 987;
        int result = cleaning.getUniqueID();
        assertEquals("The Unique ID was incorrect: ", expResult, result);

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
     * Testing the getter methods in a class Feeding object
     * Getters should correctly return the unique ID, start hour, max window, description, duration, animal ID
    */
    public void testFeedingClassGetters() {    
        Feeding feeding = new Feeding(456, 4, 2, "this is the description", 35, 234);
        
        // Testing the getter for unique ID
        int expResult = 456;
        int result = feeding.getUniqueID();
        assertEquals("The Unique ID was incorrect: ", expResult, result);

        // Testing the getter for the start hour
        int expResult1 = 4;
        int result1 = feeding.getStartHour();
        assertEquals("The start hour was incorrect: ", expResult1, result1);

        // Testing the getter for the max window
        int expResult2 = 2;
        int result2 = feeding.getMaxWindow();
        assertEquals("The max window was incorrect: ", expResult2, result2);

        // Testing the getter for the description
        String expResult3 = "this is the description";
        String result3 = feeding.getDescription();
        assertEquals("The description was incorrect: ", expResult3, result3);


        // Testing the getter for the duration
        int expResult4 = 35;
        int result4 = feeding.getDuration();
        assertEquals("The duration was incorrect: ", expResult4, result4);


        // Testing the getter for the animal ID
        int expResult5 = 234;
        int result5 = feeding.getAnimalID();
        assertEquals("The animalID was incorrect: ", expResult5, result5);
    }





    @Test
    /*
     * Testing the getter methods in a class PreppedFeeding object
     * Getters should correctly return the unique ID, start hour, max window, description, prep time, duration, animal ID
    */
    public void testPreppedFeedingClassGetters() {    
        PreppedFeeding preppedFeeding = new PreppedFeeding(789, 11, 2, "this is another description", 15, 30, 678);
        
        // Testing the getter for unique ID
        int expResult = 789;
        int result = preppedFeeding.getUniqueID();
        assertEquals("The Unique ID was incorrect: ", expResult, result);

        // Testing the getter for the start hour
        int expResult1 = 11;
        int result1 = preppedFeeding.getStartHour();
        assertEquals("The start hour was incorrect: ", expResult1, result1);

        // Testing the getter for the max window
        int expResult2 = 2;
        int result2 = preppedFeeding.getMaxWindow();
        assertEquals("The max window was incorrect: ", expResult2, result2);

        // Testing the getter for the description
        String expResult3 = "this is another description";
        String result3 = preppedFeeding.getDescription();
        assertEquals("The description was incorrect: ", expResult3, result3);


        // Testing the getter for the prep time
        int expResult4 = 15;
        int result4 = preppedFeeding.getPrepTime();
        assertEquals("The prep time was incorrect: ", expResult4, result4);


        // Testing the getter for the duration
        int expResult5 = 30;
        int result5 = preppedFeeding.getDuration();
        assertEquals("The duration was incorrect: ", expResult5, result5);


        // Testing the getter for animal ID
        int expResult6 = 678;
        int result6 = preppedFeeding.getAnimalID();
        assertEquals("The animal ID was incorrect: ", expResult6, result6);
    }


    
    
    @Test
    /*
     * Testing the getter/setter methods in a class IsScheduled object
     * Getters should correctly return the unique ID, and boolean is scheduled field
     * Setter should correctly set isSched to boolean true
    */
    public void testIsScheduledClass() {    
        IsScheduled isScheduled = new IsScheduled(135);
        
        // Testing the getter for unique ID
        int expResult = 135;
        int result = isScheduled.getUniqueID();
        assertEquals("The Unique ID was incorrect: ", expResult, result);

        // Testing the getter for isSched
        boolean expResult1 = false;
        boolean result1 = isScheduled.getIsScheduled();
        assertEquals("The boolean isSched was incorrect: ", expResult1, result1);

        // Testing the setter for the isSched, should set isSched to true
        // set isSched to true
        isScheduled.setIsScheduled();
        boolean expResult2 = true;
        
        // get value of isSched in isScheduled (which should now be true)
        boolean result2 = isScheduled.getIsScheduled();
        assertEquals("The boolean isSched was incorrect: ", expResult2, result2);
    }





    @Test
    public void testPopulatePreppedFeedingAnimalTasks() {
        ScheduleBuilder sched = new ScheduleBuilder();
        CreateArrayList createArrayList = new CreateArrayList(sched);
        
        Animal animal = new Animal(230, "Penny", "fox");

        AnimalSpecies species = AnimalSpecies.FOX;
        
        ArrayList<Treatment> treatmentsArray = new ArrayList<Treatment>();
        treatmentsArray.add(new Treatment(1, 230, 2, 0));

        sched.setTreatmentsArray(treatmentsArray);

        createArrayList.populatePreppedFeedingAnimalTasks(animal, species);

        assertFalse(createArrayList.getPreppedFeedingTasks().isEmpty());
        assertFalse(createArrayList.getCleaningTasks().isEmpty());

        assertEquals(1, createArrayList.getPreppedFeedingTasks().size());
        assertEquals(1, createArrayList.getCleaningTasks().size());
    }



    
    @Test
    public void testPopulateAnimalTasks() {
        ScheduleBuilder sched = new ScheduleBuilder();
        CreateArrayList createArrayList = new CreateArrayList(sched);
        
        Animal animal = new Animal(230, "Poppy", "beaver");

        AnimalSpecies species = AnimalSpecies.BEAVER;

        ArrayList<Treatment> treatmentsArray = new ArrayList<Treatment>();
        treatmentsArray.add(new Treatment(1, 230, 2, 0));

        sched.setTreatmentsArray(treatmentsArray);

        createArrayList.populateAnimalTasks(animal, species);

        assertFalse(createArrayList.getFeedingTasks().isEmpty());
        assertFalse(createArrayList.getCleaningTasks().isEmpty());

        assertEquals(1, createArrayList.getFeedingTasks().size());
        assertEquals(1, createArrayList.getCleaningTasks().size());
    }



    @Test
    public void testBuildIsScheduled() {
       
        ScheduleBuilder sched = new ScheduleBuilder();
        CreateArrayList createArrayList = new CreateArrayList(sched);

        createArrayList.buildIsScheduled(1);
        createArrayList.buildIsScheduled(2);

        assertFalse(createArrayList.getIsScheduledTasks().isEmpty());
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




}

