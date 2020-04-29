/**
 * 
 */
package recursion;

import student.TestCase;

/**
 * @author Gunnar Nelson
 * @version 03-04-20202
 */
public class FibonacciGeneratorTest extends TestCase {
    /**
     * setUp constructor
     */
    public void setUp() {
        new FibonacciGenerator();
    }


    /**
     * testing our Fib
     */
    public void testFib() {
        assertEquals(0, FibonacciGenerator.fib(0));
        assertEquals(1, FibonacciGenerator.fib(1));
        assertEquals(8, FibonacciGenerator.fib(6));
    }

}
