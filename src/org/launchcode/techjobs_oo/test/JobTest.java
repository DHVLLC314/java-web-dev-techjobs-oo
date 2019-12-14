package org.launchcode.techjobs_oo.test;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void testSettingJobId(){
        Job test_Job1 = new Job();
        Job test_Job2 = new Job();
        assertTrue(test_Job1.getId() != test_Job2.getId());
        assertEquals( test_Job1.getId() + 1, test_Job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job test_Job3 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        System.out.println(test_Job3.getId());
        assertTrue(Integer.class.isInstance(test_Job3.getId()) && test_Job3.getId()==6);
        assertTrue(test_Job3.getName() instanceof String && test_Job3.getName().equals("Product tester"));
        assertTrue(test_Job3.getEmployer() instanceof Employer && test_Job3.getEmployer().getValue().equals("ACME"));
        assertTrue(test_Job3.getPositionType() instanceof PositionType && test_Job3.getPositionType().getValue().equals("Quality control"));
        assertTrue(test_Job3.getLocation() instanceof Location && test_Job3.getLocation().getValue().equals("Desert"));
        assertTrue(test_Job3.getCoreCompetency() instanceof CoreCompetency && test_Job3.getCoreCompetency().getValue().equals("Persistence"));
    }

    @Test
    public void testJobsForEquality() {
        Job test_Job4= new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job  test_Job5 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertEquals(false,test_Job4.equals(test_Job5));
    }

    @Test
    public void testToStringPadding() {
        Job  test_Job6 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals(
            "\n" +
            "ID: " + test_Job6.getId() + "\n" +
            "Name: Product tester\n" +
            "Employer: ACME\n" +
            "Location: Desert\n" +
            "Position Type: Quality control\n" +
            "Core Competency: Persistence\n",test_Job6.toString()
        );

    }

    @Test
    public void testEmptyField() {
        Job test_Job7 = new Job("Product tester",
                new Employer(""),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertEquals("\n" +
                "ID: " + test_Job7.getId() + "\n" +
                "Name: Product tester\n" +
                "Employer: Data not available\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n",test_Job7.toString());
    }

    @Test
    public void testNoDataObject() {
        Job test_Job8 = new Job("",
                new Employer(""),
                new Location(""),
                new PositionType(""),
                new CoreCompetency(""));
        assertEquals("OOPS! This job does not seem to exist.",test_Job8.toString());
    }
}
