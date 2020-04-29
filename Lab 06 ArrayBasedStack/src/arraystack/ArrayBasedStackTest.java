package arraystack;

import student.TestCase;

import java.util.EmptyStackException;

/**
 * 
 * @author name Gunnar Nelson
 * @version 2020-02-26
 */
public class ArrayBasedStackTest extends TestCase {
    private ArrayBasedStack<String> stack;
    private ArrayBasedStack<String> stack1;
    private ArrayBasedStack<String> stack2;
    private ArrayBasedStack<String> stack3;
    private ArrayBasedStack<String> stack4;
    private ArrayBasedStack<String> stack5;

    /**
     * 
     * setup
     */
    public void setUp() {
        stack = new ArrayBasedStack<String>();
        stack1 = new ArrayBasedStack<String>();
        stack2 = new ArrayBasedStack<String>();
        stack3 = new ArrayBasedStack<String>();
        stack4 = new ArrayBasedStack<String>();
        stack5 = new ArrayBasedStack<String>();
        stack1.push("raisin");
        stack1.push("cookie");
        stack1.push("chocolate");
        stack2 = null;
        stack3.push("vanilla");
        stack4.push("dog treats");
        stack4.push("ball");
        stack4.push("bone");
        stack5.push("cookie");
        stack5.push("raisin");
        stack5.push("chocolate");

    }


    /**
     * 
     * testempty
     */
    public void testisEmpty() {
        assertTrue(stack.isEmpty());
        stack1.push("raisin");
        assertFalse(stack1.isEmpty());
        assertFalse(stack3.isEmpty());

    }


    /**
     * 
     * testpeek
     */

    public void testPeek() {
        Exception thrown = null;
        try {
            // call your method here that will throw the exception
            stack.peek();
        }
        catch (Exception exception) {
            thrown = exception;
        }

// checks whether an Exception was actually thrown
        assertNotNull(thrown);

// checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof EmptyStackException);
        assertEquals("chocolate", stack1.peek());
        assertTrue(stack1.contains("chocolate"));
    }


    /**
     * Returns the item at the top of the stack without removing it.
     *
     * @throws EmptyStackException
     *             if stack is empty.
     * 
     */
    public void testPop() {

        Exception thrown = null;
        try {
            stack.pop();
        }
        catch (EmptyStackException exception) {
            thrown = exception;
        }

// checks whether an Exception was actually thrown
        assertNotNull(thrown);

// checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof EmptyStackException);
        assertTrue("chocolate".equals(stack1.pop()));
        assertFalse(stack1.contains("chocolate"));

    }


    /**
     * 
     * testpush
     */
    public void testPush() {
        stack1.push("cookie");
        assertTrue(stack1.contains("cookie"));
    }


    /**
     * 
     * testcontain
     */
    public void testContains() {
        stack1.push("chocolate");
        assertTrue(stack1.contains("chocolate"));
        assertFalse(stack1.isEmpty());
        assertFalse(stack1.contains("laptop"));
    }


    /**
     * 
     * testsize
     */
    public void testSize() {
        assertEquals(stack1.size(), 3);
    }


    /**
     * 
     * testclear
     */
    public void testClear() {
        stack1.clear();
        assertEquals(stack1.size(), 0);
    }


    /**
     * 
     * testtoArray
     */
    public void testToArray() {
        String[] mom = new String[3];
        mom[0] = "raisin";
        mom[1] = "cookie";
        mom[2] = "chocolate";
        Object[] name = stack1.toArray();
        assertEquals(mom[0], (String)(name[0]));
        assertEquals(mom[1], (String)(name[1]));
        assertEquals(mom[2], (String)(name[2]));
    }


    /**
     * 
     * testToString
     */
    public void testToString() {
        assertEquals(stack1.toString(), "[raisin, cookie, chocolate]");
        ArrayBasedStack<String> stackEmpty = new ArrayBasedStack<String>();
        assertEquals(stackEmpty.toString(), "[]");
    }


    /**
     * 
     * testEquals
     */
    public void testEquals() {
        assertFalse(stack1.equals(stack));
        assertFalse(stack1.equals(stack2));
        assertTrue(stack1.equals(stack1));
        assertFalse(stack1.equals(stack3));
        assertFalse(stack1.equals(stack4));
        assertFalse(stack1.equals(stack5));
        assertFalse(stack1.equals("candy"));

    }
    
    
    public void testDebuggerViews()

    {

                //Put a breakpoint on the line below

                ArrayBasedStack<String> testStack = new ArrayBasedStack<String>();

                 

                //Put a breakpoint on the line below. Use Step Over to see each push.

                testStack.push("blizzard");

                testStack.push("barrage");

                testStack.push("deadeye");

                testStack.push("resurrect");

                 

                assertTrue(testStack.toString().equals("[blizzard, barrage, deadeye, resurrect]"));

                 

                //Put a breakpoint on the line below. Hit Step Over once to watch the pop.

                testStack.pop();

                 

                assertTrue(testStack.toString().equals("[blizzard, barrage, deadeye]"));

                 

                Object[] toArrayResult = testStack.toArray();

                //Drop a breakpoint on the line below.

                //Use the debugger mode to compare toArrayResult to testStack.

                assertTrue(toArrayResult[0].toString().equals("blizzard"));

                assertEquals(toArrayResult.length, 3);

                 

                //The following test fails because the stack still has entries in it. However,

                //"expected <true> but was: <false>" is not very helpful.

                //Drop a breakpoint on the line below to see what the toString SHOULD look like.

                assertTrue(testStack.toString().equals("[]"));

    }

}
