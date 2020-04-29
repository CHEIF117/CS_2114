// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Gunnar Nelson (90595625)
package project1;

import student.TestCase;

import bag.BagInterface;

/**
 * @author name Gunnar Nelson
 * @version java 1.82
 */
public class DisplayCollectionTest extends TestCase {
    /**
     * Setup method; plot twist its going to be left blank
     * 
     */
    private DisplayCollection testBag;

    /**
     * Setup method; plot twist its going to be left blank
     * 
     */
    public void setUp() {
        /**
         * Setup left intentionally blank
         * 
         */
    }


    /**
     * Tests the contents of the bag
     * Each element in the bag is being made sure that each part of the STRINGS
     * Array is approved
     *
     */
    public void testBagContents() {
        DisplayCollection a = new DisplayCollection();
        BagInterface<String> bag = a.getItemBag();
        while (!bag.isEmpty()) {
            String test = bag.remove();
            assertTrue(test.equals(DisplayCollection.STRINGS[0]) || test.equals(
                DisplayCollection.STRINGS[1]) || test.equals(
                    DisplayCollection.STRINGS[2]) || test.equals(
                        DisplayCollection.STRINGS[3]));
        }
    }


    /**
     * Tests the bag size
     * With our size we are stating the size of the bag's parameters is less
     * than 15
     * and our bag size is greater than 5
     */
    public void testBagSize() {
        for (int i = 0; i <= 20; i++) {
            testBag = new DisplayCollection();
            int size = testBag.getItemBag().getCurrentSize();
            System.out.println(size);
            assertTrue(size <= 15 && size >= 5);
            assertFalse(size < 5);
            assertFalse(size > 15);

        }

    }

}
