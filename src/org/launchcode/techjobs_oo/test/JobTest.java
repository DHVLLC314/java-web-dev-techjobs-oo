package org.launchcode.techjobs_oo.test;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job test_Job1;
    Job test_Job2;

    @Before
    public void createObject (){
        test_Job1 = new Job("Product tester",
            new Employer("ACME"),
            new Location("Desert"),
            new PositionType("Quality control"),
            new CoreCompetency("Persistence"));
        test_Job2 = new Job("Product tester",
            new Employer("ACME"),
            new Location("Desert"),
            new PositionType("Quality control"),
            new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId(){
        assertTrue(test_Job1.getId() != test_Job2.getId());
        assertEquals( test_Job1.getId() + 1, test_Job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertTrue(Integer.class.isInstance(test_Job2.getId()) && test_Job2.getId()==4);
        assertTrue(test_Job2.getName() instanceof String && test_Job2.getName().equals("Product tester"));
        assertTrue(test_Job2.getEmployer() instanceof Employer && test_Job2.getEmployer().getValue().equals("ACME"));
        assertTrue(test_Job2.getPositionType() instanceof PositionType && test_Job2.getPositionType().getValue().equals("Quality control"));
        assertTrue(test_Job2.getLocation() instanceof Location && test_Job2.getLocation().getValue().equals("Desert"));
        assertTrue(test_Job2.getCoreCompetency() instanceof CoreCompetency && test_Job2.getCoreCompetency().getValue().equals("Persistence"));
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(test_Job1.equals(test_Job2));
    }



}
