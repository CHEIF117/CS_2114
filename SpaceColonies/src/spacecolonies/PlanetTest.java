// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Gunnar Nelson (905956285)
package spacecolonies;

import student.TestCase;

/**
 * @author name Gunnar Nelson
 * @version 2020-04-15
 * 
 *          Tests methods from the Planet class
 * 
 */

public class PlanetTest extends TestCase {
    private Planet known;
    private Planet unknown;
    private Planet unknown2;
    private Planet nully;

    /**
     * Sets up the fields to be used in testing
     */
    public void setUp() {
        known = new Planet("Earth", 1, 2, 3, 5);
        unknown = new Planet("", 5, 2, 3, 4);
        unknown2 = new Planet("", 5, 2, 3, 4);
        nully = null;
    }


    /**
     * Test method for getName.
     */
    public void testGetName() {
        assertEquals("", unknown.getName());
        assertEquals("Earth", known.getName());
    }


    /**
     * Test method for setName.
     */
    public void testSetName() {
        unknown.setName("Venus");
        known.setName("");

        assertEquals("Venus", unknown.getName());
        assertEquals("", known.getName());
    }


    /**
     * Test method for getSkills.
     */
    public void testGetSkills() {
        assertEquals(new Skills(1, 2, 3), known.getSkills());
        assertEquals(new Skills(5, 2, 3), unknown.getSkills());
    }


    /**
     * Test method for capacity.
     */
    public void testCapacity() {
        assertEquals(4, unknown.getCapacity());
        assertEquals(5, known.getCapacity());
    }


    /**
     * Test method for getPopulation.
     */
    public void testGetPopulation() {
        Person tempPerson = new Person("John Doe", 1, 2, 3, "");
        assertTrue(known.addPerson(tempPerson));
        assertEquals(tempPerson, known.getPopulation()[0]);
    }


    /**
     * Test method for getPopulationSize.
     */
    public void testGetPopulationSize() {
        assertEquals(0, known.getPopulationSize());
        Person tempPerson = new Person("John Doe", 1, 2, 3, "");
        assertTrue(known.addPerson(tempPerson));
        assertEquals(1, known.getPopulationSize());
    }


    /**
     * Test method for getCapacity.
     */
    public void testGetCapacity() {
        assertEquals(4, unknown.getCapacity());
        assertEquals(5, known.getCapacity());
    }


    /**
     * Test method for getAvailability.
     */
    public void testGetAvailability() {
        assertEquals(5, known.getAvailability());
        assertEquals(4, unknown.getAvailability());
    }


    /**
     * Test method for isFull.
     */
    public void testIsFull() {
        assertFalse(known.isFull());
        assertFalse(unknown.isFull());
        for (int i = 0; i < 100; i++) {
            Person tempPerson = new Person("John Doe", 5, 5, 5, "");
            unknown.addPerson(tempPerson);
        }
        System.out.println(unknown.getPopulationSize());
        System.out.println(unknown.getCapacity());
        assertTrue(unknown.isFull());
    }


    /**
     * Test method for addPerson.
     */
    public void testAddPerson() {

        Person tempPerson = new Person("John Doe", 5, 5, 5, "");
        Person tempPerson3 = new Person("John Doe", 1, 1, 1, "");
        assertTrue(unknown2.addPerson(tempPerson));
        assertFalse(unknown2.addPerson(tempPerson3));
        assertEquals(tempPerson, unknown2.getPopulation()[0]);
        for (int i = 0; i < 100; i++) {
            Person tempPerson2 = new Person("John Doe", 5, 5, 5, "");
            unknown.addPerson(tempPerson2);
        }
        assertFalse(unknown.addPerson(tempPerson));
    }


    /**
     * 
     * Test method for compareTo.
     */
    public void testCompareTo() {
        assertEquals(0, known.compareTo(known));
        assertEquals(0, unknown.compareTo(unknown));

        assertEquals(1, known.compareTo(unknown));
        assertEquals(-1, unknown.compareTo(known));
    }


    /**
     * Test method for setName.
     */
    public void testToString() {
        System.out.println(known);
        System.out.println(unknown);
        assertEquals(
            "Earth, population 0 (cap: 5), Requires: A >= 1, M >= 2, T >= 3",
            known.toString());
        assertEquals("population 0 (cap: 4), Requires: A >= 5, M >= 2, T >= 3",
            unknown.toString());
    }


    /**
     * Tests the equals method
     */
    public void testEquals() {
        assertTrue(known.equals(known));
        assertFalse(known.equals(nully));
        assertFalse(known.equals(unknown));
        assertFalse(known.equals(new Object()));
        assertTrue(unknown2.equals(unknown2));
        assertFalse(known.equals(new Planet("Yuh", 1, 2, 3, 5)));
        assertFalse(known.equals(new Planet("Earth", 1, 2, 3, 7)));
        assertFalse(known.equals(new Planet("Earth", 2, 2, 3, 5)));
    }

}
