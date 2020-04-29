// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Gunnar Nelson (90595625)
package game;

/**
 * In the ProjectRunner Class we have our constructors from WhackAShape output
 * our window.
 * This is where the final magic happens.
 * 
 * @author name Gunnar Nelson
 * @version 2020-02-28
 * 
 */
public class ProjectRunner {

    /**
     * Our main method returns the default constructor from WhackAShape
     * or the other constructor depending on what was inputed
     * 
     * @param string
     */
    public static void main(String[] string) {
        if (string.length > 0) {
            WhackAShape whack = new WhackAShape(string);

        }
        else {
            WhackAShape whack = new WhackAShape();

        }
    }

}
