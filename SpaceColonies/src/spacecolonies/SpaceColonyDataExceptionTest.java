// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Gunnar Nelson (905956285)
package spacecolonies;

/**
 * 
 * Test for SpaceColonyDataException.
 * 
 * @author name Gunnar Neson
 * @version 2020-04-17
 * 
 * This tests for our SpaceColonyDataException methods
 * 
 */

public class SpaceColonyDataExceptionTest {

    /**
     * SpaceColonyDataException Test method.
     */
    public void testDataException() {
        try {
            throw (new SpaceColonyDataException("An Error Occured"));
        }
        catch (SpaceColonyDataException e) {
            e.printStackTrace();
        }
    }

}