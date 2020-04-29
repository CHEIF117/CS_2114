// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Gunnar Nelson (90595625)
package game;

import bag.Node;
import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * @author name Gunnar Nelson
 * @version 2020-02-28
 *          There is a SimpleLinkedBag testing nodes
 * @param <T>
 *            is the type of parameter we will be working on this project
 */
public class SimpleLinkedBag<T> implements SimpleBagInterface<T> {

    private Node<T> firstNode;
    private int numberOfEntries;

    /**
     * the default constructor that sets the first
     * node to null
     */
    public SimpleLinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }


    /**
     * This boolean adds an item to the bag
     * 
     * @param anEntry
     *            is the item added to the bag
     * @return returns true
     *         if the item was successfully to the bag
     */
    @Override
    public boolean add(T anEntry) {
        Node<T> node = new Node<T>(anEntry);
        if (anEntry == null) {
            return false;
        }
        if (isEmpty()) {
            firstNode = node;
            numberOfEntries++;

            return true;
        }
        else {
            node.setNext(firstNode);
            firstNode = node;
            numberOfEntries++;
            return true;
        }

    }


    /**
     * returns the current size of the bag (the number of items)
     * 
     * @return returns the number of items
     */
    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }


    /**
     * @return true
     *         if bag is empty, hence set to zero
     */
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }


    /**
     * This method picks a random item from bag
     * 
     * @return picks the item from the bag
     */
    @Override
    public T pick() {
        if (isEmpty()) {
            return null;
        }

        TestableRandom generator = new TestableRandom();
        int index = generator.nextInt(numberOfEntries);

        Node<T> node = firstNode;

        for (int i = 0; i < index; i++) {
            node = node.next();
        }

        return node.data();

    }


    /**
     * This method removes item from bag
     * 
     * @param anEntry
     *            is to be removed
     * @return returns true if the item was retrieved from bag
     */
    @Override
    public boolean remove(T anEntry) {

        if (getReferenceTo(anEntry) == null) {
            return false;
        }
        Node<T> node = getReferenceTo(anEntry);
        node.setData(firstNode.data());
        firstNode = firstNode.next();
        numberOfEntries--;
        return true;

    }


    /**
     * This method finds the node the item was referencing to
     * 
     * @param anEntry
     *            is the item to be found
     * @return the node the referencing anEntry
     */
    private Node<T> getReferenceTo(T anEntry) {
        boolean found = false;
        Node<T> currentNode = firstNode;

        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data())) {
                found = true;
            }
            else {
                currentNode = currentNode.next();
            }
        }

        return currentNode;
    }

}
