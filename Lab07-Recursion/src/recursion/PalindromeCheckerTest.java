/**
 * 
 */
package recursion;

import student.TestCase;

/**
 * @author Gunnar Nelson
 * @version 03-04-20202
 *
 */
public class PalindromeCheckerTest extends TestCase {

    /**
     * setUp constructor
     */
    public void setUp() {
        new PalindromeChecker();

    }


    /**
     * testing our IsPalidrome
     */
    public void testIsPalindrome() {

        assertTrue(PalindromeChecker.isPalindrome(
            "Go hang a salami, I'm a lasagna hog."));
        assertTrue(PalindromeChecker.isPalindrome(
            "A Toyota! Race fast, safe car. A Toyota."));
        assertTrue(PalindromeChecker.isPalindrome(
            "\"Tie Mandie,\" I'd name it."));
        assertTrue(PalindromeChecker.isPalindrome("Wonton? Not now."));
        assertFalse(PalindromeChecker.isPalindrome(
            "Glorious MOTHA RUSSIA BUTIFAL JAVA DOC"));
        assertFalse(PalindromeChecker.isPalindrome(null));
    }

}
