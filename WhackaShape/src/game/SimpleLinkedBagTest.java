// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Gunnar Nelson (90595625)
package game;

import student.TestCase;

/**
 * @author name Gunnar Nelson
 * @version 2020-02-28
 *          Here we are testing our SimpleLinkedBag
 */
public class SimpleLinkedBagTest extends TestCase {
    private SimpleLinkedBag<String> bag1;
    private SimpleLinkedBag<String> bag2;
    private SimpleLinkedBag<String> bag3;
    private SimpleLinkedBag<String> bag4;
    private SimpleLinkedBag<String> bag5;

    /**
     * Setting up 4 bags to test the methods
     * Each with three different strings
     * and one null bag
     */
    public void setUp() {
        bag1 = new SimpleLinkedBag<String>();
        bag1.add("chicken");
        bag1.add("protein");
        bag1.add("chips");

        bag2 = new SimpleLinkedBag<String>();
        bag2.add("raisin");
        bag2.add("cookie");
        bag2.add("chocolate");

        bag3 = new SimpleLinkedBag<String>();
        bag3.add("pie");
        bag3.add("spinach");
        bag3.add("chicken");

        bag4 = new SimpleLinkedBag<String>();

        bag5 = new SimpleLinkedBag<String>();
        bag5.add("one");

    }


    /**
     * Testing our Add method
     */
    public void testAdd() {
        String anEntry = null;
        assertFalse(bag1.add(anEntry));
    }


    /**
     * returns the current size of the bag (the number of items)
     * 
     */
    public void testgetCurrentSize() {
        assertEquals(bag3.getCurrentSize(), 3);
    }


    /**
     * Here we are testing our isEmpty method
     * Doing so by creating a new empty bag
     */
    public void testisEmpty() {
        SimpleArrayBag<String> bag6 = new SimpleArrayBag<String>();
        assertTrue(bag6.isEmpty());
    }


    /**
     * Testing our testPick method
     * A new bag was created to test for the assertNull
     * Then making sure, when picking a random item from bag2
     * All of the strings in the bag are set to random
     */
    public void testPick() {
        bag4.pick();
        assertEquals("one", bag5.pick());
        Object string = bag2.pick();
        assertTrue(string.equals("raisin") || string.equals("cookie") || string
            .equals("chocolate"));

    }


    /**
     * Testing our testRemove method
     */
    public void testRemove() {
        assertTrue(bag1.remove("chips"));
        assertFalse(bag1.remove("vanilla"));
    }

}
