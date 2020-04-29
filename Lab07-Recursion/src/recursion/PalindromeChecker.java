/**
 * 
 */
package recursion;

/**
 * @author Gunnar Nelson
 * @version 03-04-20202
 */
public class PalindromeChecker {
    /**
     * This is our constructor
     * 
     * @return true or false depending on situation
     * 
     * @param str
     *            this is a parameter
     */
    public static boolean isPalindrome(String str) {
        /**
         * Our if else statement
         */
        if (str == null) {
            return false;
        }

        if (str.length() == 1 || str.length() == 0) {
            return true;
        }

        String m = str.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(m);
        if (m.charAt(0) == m.charAt(m.length() - 1)) {
            return isPalindrome(m.substring(1, m.length() - 1));
        }
        return false;

    }

}
