// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Gunnar Nelson (905956285)
package spacecolonies;

/**
 * @author name Gunnar Nelson
 * @version 2020.04.16
 * 
 *          Sets up our SpaceCononyDataException class to output strings for the
 *          Space Colony Game
 * 
 */

@SuppressWarnings("serial")
public class SpaceColonyDataException extends Exception {
    /**
     * 
     * Creates new SpaceColonyDataException.
     * 
     * @param string
     *            String to be printed as the error.
     */
    public SpaceColonyDataException(String string) {
        super(string);
    }

}
