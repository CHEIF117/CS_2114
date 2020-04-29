// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Gunnar Nelson (ngunn15)
package towerofhanoi;

import CS2114.Shape;
import java.util.Random;
import java.awt.Color;

/**
 * @author name Gunnar Nelson
 * @version 2020-03-22
 */
public class Disk extends Shape implements Comparable<Disk> {

    /**
     * The Disk constructor also pulls in our our superclass constructor, with
     * width and
     * height indicated by the end user
     * 
     * @param width
     *            this indicates the width of the disk
     */
    public Disk(int width) {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        Random rand = new Random();
        Color col = new Color(rand.nextInt(256), rand.nextInt(256), rand
            .nextInt(256));
        this.setBackgroundColor(col);
    }


    /**
     * compareTo method literally compares the disks passed and returns which
     * disk is passed with
     * each width being bigger than the other disk
     * 
     * @param otherDisk
     *            the width of the otherDisk is compared with the other disks to
     *            be compared with
     * @return Returns the width of the other disk after passed through
     *         parameter
     */
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }

        return this.getWidth() - otherDisk.getWidth();
    }


    /**
     * toString method returns the width of the disk, in this case, in a string.
     * 
     * @return returns width of disk in a string data type.
     */
    public String toString() {
        return Integer.toString(getWidth());
    }


    /**
     * This boolean method checks if a disk is passed through the parameter, and
     * is equal to
     * the current disc, they will equal each other
     * 
     * @param obj
     *            gets the width of the other disk
     * @return Returns a boolean value to see if the widths of the other disks
     *         match after being passed through
     *         parameter
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (this.getClass().equals(obj.getClass())) {
            Disk disc2 = (Disk)obj;
            if (this.getWidth() == disc2.getWidth()) {
                return true;
            }
        }
        return false;
    }
}
