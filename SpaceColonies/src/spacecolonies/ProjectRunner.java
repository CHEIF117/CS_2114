// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Gunnar Nelson (905956285)
package spacecolonies;

import java.io.FileNotFoundException;
import bsh.ParseException;

/**
 * @author name Gunnar Nelson
 * @version 2020.04.16
 * 
 *          This is our ProjectRunner which is built to execute the code with
 *          our GUI being our final output
 */

public class ProjectRunner {

    /**
     * This is our main method to execute the Project Runner class
     * 
     * @param args
     *            Arguments provided by program.
     * @throws SpaceColonyDataException
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public static void main(String[] args)
        throws SpaceColonyDataException,
        FileNotFoundException,
        ParseException {
        @SuppressWarnings("unused")
        ColonyReader colonyReader;

        if (args.length == 2) {
            colonyReader = new ColonyReader(args[0], args[1]);
        }
        else {
            colonyReader = new ColonyReader("input.txt", "planets.txt");
        }

    }

}
