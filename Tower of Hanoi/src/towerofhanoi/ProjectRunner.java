// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Gunnar Nelson (ngunn15)
package towerofhanoi;

/**
 * @author name Gunnar Nelson
 * @version 2020-03-22
 *
 */
public class ProjectRunner {

    /**
     * 
     * @param args
     *            this represents the the length of the disks and windows
     * @param disk
     *           represents the number of disks in program. This program will have 5 disks. 
     */
    public static void main(String[] args) {
        int disks = 7;
        if (args.length == 1) {
            disks = Integer.parseInt(args[0]);
        }
        HanoiSolver hanoi = new HanoiSolver(disks);
        PuzzleWindow window = new PuzzleWindow(hanoi);

    }


    /**
     * This constructor is left empty on purpose to execute the stack program.
     */
    public ProjectRunner() {

    }

}
