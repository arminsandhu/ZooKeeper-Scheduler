package edu.ucalgary.oop;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class ScheduleTest {

    private ScheduleBuilder sched;
    private CreateArrayList cal;

    @Before
    public void setUp() {
        sched = new ScheduleBuilder();
        cal = new CreateArrayList(sched);
    }

    @Test
    public void testFillArrays() {
        cal.fillArrays();
        assertEquals(2, cal.getFeedingTasks().size());
        assertEquals(2, cal.getCleaningTasks().size());
        assertEquals(2, cal.getPreppedFeedingTasks().size());
        assertEquals(6, cal.getIsScheduledTasks().size());
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
