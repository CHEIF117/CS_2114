// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Gunnar Nelson (90595625)
package project1;

/**
 * @author name Gunnar Nelson
 *         Here our two constructors are used to output our window from
 *         the DisplayCollection and ShapeWindow constructors
 */
public class ProjectRunner {

    public static void main(String args[]) {

        DisplayCollection dp = new DisplayCollection();
        ShapeWindow sw = new ShapeWindow(dp.getItemBag());

    }

}
