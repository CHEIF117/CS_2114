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
 * @version 2020.04.15
 * 
 *          Tests the person's methods
 */

public class PersonTest extends TestCase {
    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;
    private Person crud;

    /**
     * Setups the variables for testing the Person methods.
     */
    public void setUp() {
        person1 = new Person("Bob Derick", 1, 3, 4, "");
        person2 = new Person("Billy Bob", 4, 2, 3, "Earth");
        person3 = new Person("Billy Bob Joe", 4, 2, 3, "nowhere");
        person4 = new Person("Bob Derick", 1, 3, 4, "");
        crud = null;
    }


    /**
     * Test getPlanet method
     */
    public void testGetPlanet() {
        assertEquals("Earth", person2.getPlanetName());
        assertEquals("", person1.getPlanetName());
        assertEquals("", person3.getPlanetName());
    }


    /**
     * Tests getName method
     */
    public void testGetName() {
        assertEquals("Bob Derick", person1.getName());
        assertEquals("Billy Bob", person2.getName());
        assertEquals("Billy Bob Joe", person3.getName());
    }


    /**
     * Tests getSkills method
     */
    public void testGetSkills() {
        assertEquals(person1.getSkills(), new Skills(1, 3, 4));
        assertFalse(person1.getSkills().isBelow(person2.getSkills()));

        assertEquals(person2.getSkills(), new Skills(4, 2, 3));
        assertTrue(person2.getSkills().isBelow(person2.getSkills()));
        assertEquals(person3.getSkills(), new Skills(4, 2, 3));

    }


    /**
     * Tests toString method
     */
    public void testToString() {
        assertEquals("Billy Bob A:4 M:2 T:3 Wants: Earth", person2.toString());
        assertEquals("No-Planet Bob Derick A:1 M:3 T:4", person1.toString());
        assertEquals("No-Planet Billy Bob Joe A:4 M:2 T:3", person3.toString());
    }


    /**
     * Tests equals method
     */
    public void testEquals() {
        assertTrue(person1.equals(person1));
        assertFalse(person1.equals(crud));
        assertFalse(person1.equals(person2));
        assertFalse(person1.equals(new Object()));
        assertTrue(person1.equals(person4));
        assertFalse(person1.equals(new Person("Billy Derick", 4, 3, 1, "")));
        assertFalse(person1.equals(new Person("Billy Derick ", 1, 3, 4, "")));
    }
}
