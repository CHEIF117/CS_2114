/**
 * 
 */
package recursion;

import student.TestCase;

/**
 * @author Gunnar Nelson
 * @version 03-04-20202
 */
public class ReverseStringGeneratorTest extends TestCase {
    /**
     * setUp constructor
     */
    public void setUp() {
        new ReverseStringGenerator();
    }


    /**
     * testingReverse
     */
    public void testReverse() {
        assertEquals("olleh", ReverseStringGenerator.reverse("hello"));
        assertEquals("", ReverseStringGenerator.reverse(""));
        assertEquals("h", ReverseStringGenerator.reverse("h"));

    }

}
