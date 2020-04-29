// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Gunnar Nelson (ngunn15)
package towerofhanoi;

import java.util.EmptyStackException;
import student.TestCase;

/**
 * @author name Gunnar Nelson
 * @version 2020-03-22
 *
 */
public class LinkedStackTest extends TestCase {
    private LinkedStack<String> stackTest;

    /**
     * The method setsUp our LinkStack test to test different methods of our
     * LinkedStack program to see if executed properly.
     */
    public void setUp() {
        stackTest = new LinkedStack<>();
    }


    /**
     * testClear push method checks to see if an element, such as a string, is
     * added to the stack.
     */
    public void testClear() {
        assertEquals(0, stackTest.size());
        stackTest.push("milk");
        stackTest.push("cookies");
        stackTest.push("chocolate");
        assertEquals(3, stackTest.size());
        stackTest.clear();
        assertEquals(0, stackTest.size());
    }


    /**
     * The method tests the isEmpty method to check whether the method returns
     * the correct boolean value depicting whether the Linked Stack is empty or
     * not.
     */
    public void testIsEmpty() {
        assertTrue(stackTest.isEmpty());
        stackTest.push("milk");
        assertFalse(stackTest.isEmpty());
    }


    /**
     * testToString method checks if the elements are added in the correct order
     * when called upon
     */
    public void testToString() {
        stackTest.push("milk");
        stackTest.push("cookies");
        stackTest.push("chocolate");
        assertEquals("[chocolate, cookies, milk]", stackTest.toString());
    }


    /**
     * testPeek push method checks to see if an element, such as a string, are
     * added properly at from the bottom to the peek of the stack.
     */
    public void testPeek() {
        Exception thrown = null;
        try {
            stackTest.peek();
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertTrue(thrown instanceof EmptyStackException);
        stackTest.push("milk");
        stackTest.push("cookies");
        assertEquals("cookies", stackTest.peek());
    }


    /**
     * testPop checks to see if an element is popped from the stack, and here we
     * implement an empty stack exception to check to see if what will happen if
     * a stack is empty.
     */
    public void testPop() {
        Exception thrown = null;
        try {
            stackTest.pop();
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof EmptyStackException);
        stackTest.push("milk");
        stackTest.push("cookies");
        stackTest.push("chocolate");
        assertEquals("chocolate", stackTest.pop());
        assertEquals(2, stackTest.size());
    }


    /**
     * testPush method checks to see if an element, such as a string, is
     * added to the stack
     */
    public void testPush() {
        stackTest.push("milk");
        stackTest.push("cookies");
        stackTest.push("chocolate");
        assertEquals(3, stackTest.size());
    }


    /**
     * testSize method checks to see if the elements are the correct size for
     * the stack
     */
    public void testSize() {
        assertEquals(0, stackTest.size());
        stackTest.push("milk");
        stackTest.push("cookies");
        stackTest.push("chocolate");
        assertEquals(3, stackTest.size());
        stackTest.pop();
        assertEquals(2, stackTest.size());
    }
    
}
