// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Gunnar Nelson (ngunn15)
package towerofhanoi;

import student.TestCase;

/**
 * @author name Gunnar Nelson
 * @version 2020-03-22
 *
 */
public class HanoiSolverTest extends TestCase {

    private HanoiSolver solver;

    /**
     * The setUp method initializes the HanoiSolver so that the various methods
     * in the same class could be tested.
     */
    public void setUp() {
        solver = new HanoiSolver(7);
    }


    /**
     * The method tests the discs method to check whether it returns the correct
     * number of discs.
     */
    public void testDisks() {
        assertEquals(7, solver.disks());
    }


    /**
     * The method tests the toString method to check whether it returns the
     * proper string with the width of the discs in order.
     */
    public void testToString() {
        solver.getTower(Position.LEFT).push(new Disk(5));
        solver.getTower(Position.MIDDLE).push(new Disk(8));
        solver.getTower(Position.RIGHT).push(new Disk(10));
        assertEquals("[5][8][10]", solver.toString());
    }


    /**
     * The method tests the solve method to check whether it properly solves the
     * game and whether all the discs appear on the right tower.
     */
    public void testSolve() {
        for (int i = 7; i > 0; i--) {
            solver.getTower(Position.RIGHT).push(new Disk(i * 7));
        }
        System.out.println(solver.toString());
        solver.solve();
        System.out.println(solver.toString());
        assertFalse(solver.getTower(Position.LEFT).isEmpty());
        assertTrue(solver.getTower(Position.MIDDLE).isEmpty());
        assertTrue(solver.getTower(Position.RIGHT).isEmpty());
        assertTrue(solver.getTower(Position.DEFAULT).isEmpty());
        assertEquals(solver.getTower(Position.LEFT).size(), 7);
    }


    /**
     * testPush tests the push method in Tower class to ensure that it throws
     * errors when invalid moves are called.
     * First test sees when a larger disk is placed on a smaller disk, and then
     * when null is passed through
     */
    public void testPush() {
        solver.getTower(Position.LEFT).push(new Disk(5));
        Exception thrown = null;
        try {
            solver.getTower(Position.LEFT).push(new Disk(10));
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof IllegalStateException);
        Exception thrown2 = null;
        Disk newDisk = null;
        try {
            solver.getTower(Position.RIGHT).push(newDisk);
        }
        catch (Exception exp) {
            thrown2 = exp;
        }
        assertTrue(thrown2 instanceof IllegalArgumentException);
    }
}
