/**
 * 
 */
package recursion;

/**
 * @author Gunnar Nelson
 * @version 03-04-20202
 */
public class ReverseStringGenerator {
    /**
     * This is our constructor
     * 
     * @param str
     *            this is our parameter
     * 
     * @return str or our substring at the start of the string and at the end
     * 
     * 
     */
    public static String reverse(String str) {
        /**
         * Our if else statement
         */
        if (str.length() <= 1) {
            return str;
        }

        else {
            return reverse(str.substring(1)) + str.charAt(0);
        }
    }

}
