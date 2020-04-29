// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Gunnar Nelson (90595625)
package game;

import student.TestableRandom;
import bag.SimpleBagInterface;

/**
 * The simple array bag that uses an array to store the items.
 * Side note added bag.SimpleBagInterface, since we are dealing with bags for
 * this class
 * 
 * @author name Gunnar Nelson
 * @version 2020-02-28
 * @param <T>
 *            is the type of parameter we will be working on this project
 */
public class SimpleArrayBag<T> implements SimpleBagInterface<T> {
    private int numberOfEntries;
    /**
     * This is our MAX value set to 25
     */
    public static final int MAX = 25;
    private T[] bag;

    /**
     * With our initial constructor we instantiate our bag to the MAX value 25
     * and then set our numberOfEntries to 0
     * In order to create our range from 0 to 25 values
     */
    public SimpleArrayBag() {
        @SuppressWarnings("unchecked")
        T[] tempbag = (T[])new Object[MAX];
        bag = tempbag;
        numberOfEntries = 0;
    }


    /**
     * This is the part where we increment the values into our bag
     * 
     * @param anEntry
     *            is the item to be added
     * @return true
     *         if item was successfully added
     * 
     */
    @Override
    public boolean add(T anEntry) {
        if (numberOfEntries == 25 || anEntry == null) {
            return false;
        }
        bag[numberOfEntries] = anEntry;
        numberOfEntries++;
        return true;

    }


    /**
     * Here we are the getting the size of our bag
     * 
     * @return the number of items in our bag
     */
    @Override
    public int getCurrentSize() {

        return numberOfEntries;
    }


    /**
     * this boolean value will return true if the bag is empty
     * hence the set value zero
     * 
     * @return true when bag is empty
     */
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }


    /**
     * we are picking a random item from bag
     * 
     * @return the item from the bag is to be returned
     */
    @Override
    public T pick() {
        if (isEmpty()) {
            return null;
        }
        TestableRandom generator = new TestableRandom();
        int index = generator.nextInt(numberOfEntries);
        return bag[index];

    }


    /**
     * Here we are removing an item from a bag
     * 
     * @return returns true if item was removed
     *         returns false if item is absent from bag
     * @param anEntry
     *            is the item to be removed
     */
    @Override
    public boolean remove(T anEntry) {
        int index = getIndexOf(anEntry);
        if (index == -1) {
            return false;
        }
        bag[index] = bag[numberOfEntries - 1];
        bag[numberOfEntries - 1] = null;
        bag[index] = null;
        numberOfEntries--;
        return true;

    }


    /**
     * returns index of the inputed item from the bag
     * 
     * @param anEntry
     *            is the inputed item
     * @return we are returning the index of our bag
     */
    private int getIndexOf(T anEntry) {
        for (int index = 0; index < numberOfEntries; index++) {
            if (bag[index].equals(anEntry)) {
                return index;
            }
        }

        return -1;

    }

}
