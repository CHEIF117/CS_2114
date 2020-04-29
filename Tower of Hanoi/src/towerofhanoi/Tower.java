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
public class Tower extends LinkedStack<Disk> {
    private Position position;

    /**
     * This is our Tower constructor
     * 
     * @param p
     *            this indicates our position
     */
    public Tower(Position p) {
        super();
        this.position = p;
    }


    /**
     * This method showcases our position constructor
     * @return returning the position
     */
    public Position position() {
        return this.position;
    }


    /**
     * This method is our push method
     * It allows us to move one disk to another position
     * While keeping the size of the disks together
     * 
     * @param disk
     *            Showcases our disk size and comparable sizes of the disk in a
     *            tower fashion
     */
    @Override
    public void push(Disk disk) {
        System.out.println("Performing Tower Push Operation...");
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        else if ((this.size() > 0) && (this.peek().compareTo(disk) < 0)) {
            throw new IllegalStateException();
        }
        super.push(disk);

    }
}
