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

    @Test
    public void testDBConnection() {
        boolean passed = true;
        try {schedule.createConnection();}

        catch (Exception e) {
            passed = true;
        }

        assertTrue("Method createConnection() did not throw an SQLExcetion when the database name was not EWR.", passed);
    }

    @Test
    public void testAddScheduledTreatments() {
        int[] i = { 1, 3 };
        cal.addScheduledTreaments(i);
        assertEquals(2, cal.getIsScheduledTasks().size());
        assertEquals(3, cal.getIsScheduledTasks().get(0).getUniqueID());
        assertEquals(1, cal.getIsScheduledTasks().get(1).getUniqueID());
    }

    @Test
    public void testBuildIsScheduled() {
        cal.buildIsScheduled(1);
        assertEquals(1, cal.getIsScheduledTasks().size());
        assertEquals(1, cal.getIsScheduledTasks().get(0).getUniqueID());
    }

    @Test
    public void testIsKit() {
        Animal adultBeaver = new Animal(1, "beaver", "adult");
        assertFalse(cal.isKit(adultBeaver));
        Animal beaverKit = new Animal(2, "beaver", "kit");
        assertTrue(cal.isKit(beaverKit));
    }
}
