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
 *          Tests our Skills methods
 */

public class SkillsTest extends TestCase {
    private Skills[] skills = new Skills[3];

    /**
     * Setups our variables to test for the Skills methods
     */
    public void setUp() {
        skills[0] = new Skills(1, 2, 3);
        skills[1] = new Skills(3, 2, 1);
        skills[2] = null;
    }


    /**
     * Tests getAgriculture method
     */
    public void testGetAgr() {
        assertEquals(1, skills[0].getAgriculture());
        assertEquals(3, skills[1].getAgriculture());
    }


    /**
     * Tests getMedicine method
     */
    public void testGetMed() {
        assertEquals(2, skills[0].getMedicine());
        assertEquals(2, skills[1].getMedicine());
    }


    /**
     * Tests getTechnology method
     */
    public void testGetTech() {
        assertEquals(3, skills[0].getTechnology());
        assertEquals(1, skills[1].getTechnology());
    }


    /**
     * Tests isBelow method
     */
    public void testIsBelow() {
        assertFalse(skills[0].isBelow(skills[1]));
        assertTrue(skills[0].isBelow(skills[0]));
        assertFalse(skills[1].isBelow(skills[0]));
    }


    /**
     * Tests toString method
     */
    public void testToString() {
        assertEquals("A:1 M:2 T:3", skills[0].toString());
        assertEquals("A:3 M:2 T:1", skills[1].toString());
    }


    /**
     * Tests equals method
     */
    public void testEquals() {
        assertTrue(skills[0].equals(skills[0]));
        assertFalse(skills[0].equals(skills[2]));
        assertFalse(skills[0].equals(skills[1]));
        assertFalse(skills[0].equals(new Object()));
        assertFalse(skills[0].equals(new Skills(2, 1, 3)));
        assertFalse(skills[0].equals(new Skills(2, 2, 3)));
        assertFalse(skills[0].equals(new Skills(1, 3, 2)));
        assertTrue(skills[0].equals(new Skills(1, 2, 3)));
        assertFalse(skills[0].equals(new Skills(1, 4, 3)));
        assertFalse(skills[0].equals(new Skills(1, 2, 4)));
    }

}
