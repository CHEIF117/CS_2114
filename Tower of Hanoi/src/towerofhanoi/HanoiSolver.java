// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Aayush Jain (aayushj)

package towerofhanoi;

import java.util.Observable;

/**
 * @author Aayush Jain (aayushj)
 * @version 2020.03.22
 */
public class HanoiSolver extends Observable {

    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDiscs;


    /**
     * The constructor initializes the three different positions to be three
     * different towers.
     * 
     * @param numDiscs
     *            It is the number of discs that starts in the left most tower.
     */
    public HanoiSolver(int numDiscs) {
        this.numDiscs = numDiscs;
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
    }


    /**
     * It is a getter method that returns the number of discs present in the
     * left most tower.
     * 
     * @return Returns the number of discs.
     */
    public int disks() {
        return numDiscs;
    }


    /**
     * It returns the tower relative to its position.
     * 
     * @param pos
     *            The position of the tower that is to be returned.
     * @return The tower whose position matches with the parameter.
     */
    public Tower getTower(Position pos) {
        switch (pos) {
            case LEFT:
                return left;
            case MIDDLE:
                return middle;
            case RIGHT:
                return right;
            default:
                return right;
        }
    }


    /**
     * toString returns a string which has the width of disks in each tower.
     * 
     * @return Returns a string that contains the width of disks in each tower
     */
    public String toString() {
       
        return left.toString() + middle.toString() + right.toString();
      
    }


    /**
     * The method removes the disc from the source tower to the destination
     * tower. It also notifies the front end that the disc has been moved so
     * that it can be changed on the window.
     * 
     * @param source
     *            The tower from where the disc is to be removed.
     * @param destination
     *            The tower where the disc is to be added.
     */
    private void move(Tower source, Tower destination) {
        Disk disk = source.pop();
        destination.push(disk);
        setChanged();
        notifyObservers(destination.position());
    }


    /**
     * The method runs recursively and solves the Hanoi Tower puzzle.
     * 
     * @param currentDiscs
     *            It is the number of discs in the right most tower.
     * @param startPole
     *            It is the left most pole.
     * @param tempPole
     *            It is the middle pole.
     * @param endPole
     *            It is the right most pole.
     */
    private void solveTowers(
        int currentDiscs,
        Tower startPole,
        Tower tempPole,
        Tower endPole) {

        if (currentDiscs == 1) {
            move(startPole, endPole);
        }

        else {
            solveTowers(currentDiscs - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDiscs - 1, tempPole, startPole, endPole);
        }
    }


    /**
     * This method solves the Hanoi Tower by calling the solveTower method,
     * which runs recursively, solving the entire puzzle.
     */
    public void solve() {
        this.solveTowers(numDiscs, right, middle, left);
    }
}
