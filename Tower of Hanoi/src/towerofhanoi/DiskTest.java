// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Gunnar Nelson (ngunn15)
package towerofhanoi;

import student.TestCase;

/**
 * @author name Gunnar Nelson
 * @version 2020-03-12
 */
public class DiskTest extends TestCase {
    private Disk discTest1;

    /**
     * setUp literally setsup our DiskTest field so we can test different
     * methods for our Disk class.
     */
    public void setUp() {
        discTest1 = new Disk(10);
    }


    /**
     * testing the toString method to check if the correct method returns in a
     * form of a string.
     */
    public void testToString() {
        assertEquals("10", discTest1.toString());
    }


    /**
     * Here we are testing the compareTo method to check whether if the right
     * integer si returned
     * after comparing their widths.
     */
    public void testCompareTo() {
        Disk discTest2 = new Disk(11);
        Disk discTest3 = new Disk(9);
        Disk discTest4 = new Disk(10);
        assertEquals(-1, discTest1.compareTo(discTest2));
        assertEquals(1, discTest1.compareTo(discTest3));
        assertEquals(0, discTest1.compareTo(discTest4));
    }


    /**
     * The reason for a second CompareTo test is to test the compareTo method to
     * see whether what happens when a null is passed through.
     */
    public void testCompareTo2() {
        Disk discTest5 = null;
        Exception thrown = null;
        try {
            discTest1.compareTo(discTest5);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof IllegalArgumentException);
    }


    /**
     * The testEquals method checks when a null parameter and a disk is passed
     * through.
     */
    public void testEquals() {
        Object someNull = null;
        assertTrue(discTest1.equals(discTest1));
        assertFalse(discTest1.equals(someNull));
    }


    /**
     * Reason for the second testEquals method is to check different widths
     * being passed through the parameters.
     */
    public void testEquals2() {
        Disk discTest2 = new Disk(10);
        Disk discTest3 = new Disk(12);
        String str = " ";
        assertTrue(discTest1.equals(discTest2));
        assertFalse(discTest1.equals(discTest3));
        assertFalse(discTest1.equals(str));
    }
}
