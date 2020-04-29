/**
 * 
 */
package recursion;

/**
 * @author Gunnar Nelson
 * @version 03-04-20202
 */

public class FibonacciGenerator {

    /**
     * @param n
     *            it is a parameter
     * @return n for the if statement, and else
     */
    public static int fib(int n) {
        /**
         * This is our if else statement
         */
        if (n <= 1) {
            return n;
        }
        else {
            return fib(n - 2) + fib(n - 1);
        }

    }

}
