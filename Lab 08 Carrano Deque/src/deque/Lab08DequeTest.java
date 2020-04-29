package deque;

import student.TestCase;

/**
 * Tests for the DLinkedDeque class.
 *
 * @author Gunnar Nelson (ngunn15)
 * @version 2020.03.28
 */
public class Lab08DequeTest extends TestCase {
    private Lab08Deque<String> deque;

    /**
     * This is our setUp method, here we created our Dequeue
     * Which will be strings
     */
    public void setUp() {
        deque = new Lab08Deque<String>();
    }


    /**
     * testAddToFront checks and sees if an item has been added to the front of
     * the Dequeue
     * 
     */
    public void testAddToFront() {
        deque.addToFront("milk");
        deque.addToFront("cookies");
        deque.addToFront("chocolate");
        assertEquals(3, deque.size());
        assertEquals("chocolate", deque.getFront());
    }


    /**
     * testAddToFront checks and sees if an item has been added to the back of
     * the Dequeue
     */
    public void testAddToBack() {
        deque.addToBack("milk");
        deque.addToBack("cookies");
        deque.addToBack("chocolate");
        assertEquals(3, deque.size());
        assertEquals("chocolate", deque.getBack());
    }


    /**
     * testRemoveFront checks if an item has been removed from the deque at the
     * front
     */
    public void testRemoveFront() {
        Exception thrown = null;
        try {
            deque.removeFront();
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof EmptyQueueException);
        deque.addToFront("milk");
        deque.addToFront("cookies");
        deque.addToFront("chocolate");
        deque.removeFront();
        assertEquals(2, deque.size());
        deque.removeFront();
        deque.removeFront();
        assertEquals(0, deque.size());
    }


    /**
     * testRemoveFront2 checks if an item has been removed from the deque at the
     * front, for if statement in test
     */
    public void testRemoveFront2() {
        deque.addToFront("milk");
        Exception thrown = null;
        deque.removeFront();

        try {
            deque.removeFront();
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof EmptyQueueException);

    }


    /**
     * testRemoveBack checks if an item has been removed from the Dequeue at
     * the
     * back
     */
    public void testRemoveBack() {
        Exception thrown = null;
        try {
            deque.removeBack();
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof EmptyQueueException);
        deque.addToBack("milk");
        deque.addToBack("cookies");
        deque.addToBack("chocolate");
        deque.removeBack();
        assertEquals(2, deque.size());
    }


    /**
     * testRemoveBack checks if an item has been removed from the Dequeue at
     * the back, for the if statement
     * 
     */
    public void testRemoveBack2() {
        deque.addToBack("milk");
        Exception thrown = null;
        deque.removeBack();

        try {
            deque.getBack();
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof EmptyQueueException);

    }


    /**
     * testgetFront method checks to see when the entry has
     * been returned from the front of the Dequeue.
     */
    public void testGetFront() {
        Exception thrown = null;
        try {
            deque.getFront();
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof EmptyQueueException);
        deque.addToFront("milk");
        deque.addToFront("cookies");
        deque.addToFront("chocolate");
        assertEquals("chocolate", deque.getFront());
    }


    /**
     * testgetBack method checks to see when the entry has
     * been returned from the back of the Dequeue.
     */
    public void testGetBack() {
        Exception thrown = null;
        try {
            deque.getBack();
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof EmptyQueueException);
        deque.addToFront("milk");
        deque.addToFront("cookies");
        deque.addToFront("chocolate");
        assertEquals("milk", deque.getBack());
    }


    /**
     * testisEmpty tests to see if the correct boolean
     * value is returned.
     */
    public void testIsEmpty() {
        assertTrue(deque.isEmpty());
        deque.addToFront("milk");
        assertFalse(deque.isEmpty());
    }


    /**
     * testClear literally tests the scenario when the Dequeue is clear.
     */
    public void testClear() {
        deque.addToFront("milk");
        deque.addToFront("cookies");
        deque.addToFront("chocolate");
        deque.clear();
        assertEquals(0, deque.size());
    }


    /**
     * testtoString method checks to see if the toString method returns the
     * proper array.
     */
    public void testToString() {
        deque.addToFront("milk");
        deque.addToFront("cookies");
        assertEquals("[cookies, milk]", deque.toString());
    }


    public void testRemoveSecond() {
        Exception thrown = null;
        try {
            deque.removeSecond();
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof EmptyQueueException);

        deque.addToFront("milk");
        assertEquals(null, deque.removeSecond());

        deque.addToFront("chocolate");
        deque.addToFront("milk");
        assertEquals("chocolate", deque.removeSecond());
    }

    
    public void testRemoveSecondToLast() {
        Exception thrown = null;
        try {
            deque.removeSecondToLast();
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof EmptyQueueException);

        deque.addToFront("milk");
        assertEquals(null, deque.removeSecondToLast());

        deque.addToFront("chocolate");
        deque.addToFront("cookies");
        deque.addToFront("milk");
        assertEquals("chocolate", deque.removeSecondToLast());
    }

}
