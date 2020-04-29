// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will
// I accept the actions of those who do.
// -- Gunnar Nelson (905956285)
package spacecolonies;

import student.TestCase;
import queue.EmptyQueueException;

/**
 * @author name Gunnar Nelson
 * @version 2020-04-15
 *
 */
public class ArrayQueueTest extends TestCase {
    private ArrayQueue<String> arrayX;
    private ArrayQueue<String> arrayY;
    private ArrayQueue<String> crud;

    /**
     * Setup method
     */
    public void setUp() {
        arrayX = new ArrayQueue<String>();
        arrayY = new ArrayQueue<String>();
        crud = null;
    }


    /**
     * Test getLength method
     */
    public void testGetLength() {
        assertEquals(11, arrayX.getLength());
        for (int i = 0; i < 12; i++) {
            arrayX.enqueue("hello1");
        }
        assertEquals(21, arrayX.getLength());
    }


    /**
     * Test getSize method.
     */
    public void testGetSize() {
        assertEquals(0, arrayX.getSize());
        for (int i = 0; i < 5; i++) {
            arrayX.enqueue("hello1");
        }
        assertEquals(5, arrayX.getSize());
    }


    /**
     * Tests isEmpty method.
     */
    public void testIsEmpty() {
        assertTrue(arrayY.isEmpty());
        arrayX.enqueue("rand");
        assertFalse(arrayX.isEmpty());
    }


    /**
     * Test enqueue method.
     */
    public void testEnqueue() {
        arrayX.enqueue("hello");
        arrayX.enqueue("hello");
        arrayX.enqueue("hello");
        arrayX.enqueue("hello");
        arrayX.enqueue("hello");
        assertEquals(5, arrayX.getSize());

        for (int i = 0; i < 100; i++) {
            arrayY.enqueue("hello");
        }
        Exception exception = null;
        try {
            arrayY.enqueue("hello");
            fail("compareTo() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalStateException);
    }


    /**
     * Test dequeue method
     */
    public void testDequeue() {
        arrayX.enqueue("hello2");
        assertEquals("hello2", arrayX.dequeue());
        arrayY.enqueue("hello3");
        assertEquals("hello3", arrayY.dequeue());

        // Trigger exception
        Exception exception = null;
        try {
            arrayY.dequeue();
            fail("compareTo() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof EmptyQueueException);
    }


    /**
     * Tests getFront method
     */
    public void testGetFront() {
        arrayX.enqueue("hello2");
        assertEquals("hello2", arrayX.getFront());
        arrayX.dequeue();

        // Trigger exception
        Exception exception = null;
        try {
            arrayY.getFront();
            fail("compareTo() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        // checks whether an Exception was actually thrown
        assertNotNull(exception);
        // checks whether the right type of Exception was thrown
        assertTrue(exception instanceof EmptyQueueException);

    }


    /**
     * Tests clear method
     */
    public void testClear() {
        arrayX.enqueue("hello");
        assertEquals(11, arrayX.getLength());
        assertEquals(1, arrayX.getSize());

        for (int i = 0; i < 12; i++) {
            arrayX.enqueue("hello1");
        }
        assertEquals(21, arrayX.getLength());

        arrayX.clear();
        assertEquals(11, arrayX.getLength());
        assertEquals(0, arrayX.getSize());
    }


    /**
     * Test toArray method
     */
    public void testToArray() {
        String[] compArr = { "hello1", "hello2", "hello3", "hello4", "hello5" };

        arrayX.enqueue("hello1");
        arrayX.enqueue("hello2");
        arrayX.enqueue("hello3");
        arrayX.enqueue("hello4");
        arrayX.enqueue("hello5");

        for (int i = 0; i < compArr.length; i++) {
            assertEquals(compArr[i], arrayX.toArray()[i]);
        }

        for (int i = 0; i < compArr.length; i++) {
            arrayX.dequeue();
        }

        Exception exception = null;
        try {
            arrayX.toArray();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof EmptyQueueException);
    }


    /**
     * Tests toString method
     */
    public void testToString() {

        arrayX.enqueue("hello1");
        arrayX.enqueue("hello2");
        arrayX.enqueue("hello3");
        arrayX.enqueue("hello4");
        arrayX.enqueue("hello5");
        System.out.println(arrayY);
        assertEquals("[]", arrayY.toString());
        assertEquals("[hello1, hello2, hello3, hello4, hello5]", arrayX
            .toString());

    }


    /**
     * Tests equals method
     */
    public void testEquals() {
        arrayX.enqueue("hello2");
        arrayX.enqueue("hello2");
        arrayX.enqueue("hello3");

        arrayY.enqueue("hello2");
        arrayY.enqueue("hello2");
        arrayY.enqueue("hello2");
        arrayY.enqueue("hello2");

        assertTrue(arrayX.equals(arrayX));
        assertFalse(arrayX.equals(crud));
        assertFalse(arrayX.equals(arrayY));
        arrayY.dequeue();
        assertFalse(arrayX.equals(arrayY));
        assertFalse(arrayX.equals(new Object()));
        arrayY.dequeue();
        arrayY.enqueue("hello3");
        assertTrue(arrayX.equals(arrayY));
    }
}
