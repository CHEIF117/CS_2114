// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Gunnar Nelson (ngunn15)
package towerofhanoi;

import CS2114.Button;
import CS2114.Shape;
import CS2114.Window;
import CS2114.WindowSide;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

/**
 * @author name Gunnar Nelson
 * @version 2020-03-22
 * 
 *          This class builds the game PuzzleWindow to build our puzzle tower.
 *          Each component will indicate the size of the rods and disks
 */
public class PuzzleWindow implements Observer {
    private HanoiSolver game;
    private Shape left;
    private Shape right;
    private Shape middle;
    private Window window;
    public final int DISK_GAP = 0;
    public static final int DISK_HEIGHT = 10;
    private final int ROD_HEIGHT = 100;
    private final int ROD_WIDTH = 5;
    public final int DISC_WIDTH_DIFF = 10;
    public final int DISC_WIDTH = 10;
    private final int ROD_Y_LOC = 100;
    private final int ROD_X_LOC = 200;
    private final int ROD_SPACE = 100;
    private Button solveButton;

    /**
     * PuzzleWindow creates our window, shape, and positions of our disks and
     * rods
     * Also the sole button is created and put at the south side of the window
     */
    public PuzzleWindow(HanoiSolver game) {
        this.game = game;
        this.game.addObserver(this);
        this.window = new Window("Tower of Hanoi");
        this.left = new Shape(ROD_X_LOC, ROD_Y_LOC, ROD_WIDTH, ROD_HEIGHT,
            new Color(200, 200, 200));
        this.middle = new Shape(ROD_X_LOC + ROD_SPACE, ROD_Y_LOC, ROD_WIDTH,
            ROD_HEIGHT, new Color(200, 200, 200));
        this.right = new Shape(ROD_X_LOC + ROD_SPACE * 2, ROD_Y_LOC, ROD_WIDTH,
            ROD_HEIGHT, new Color(200, 200, 200));

        for (int i = this.game.disks(); i > 0; i--) {
            Disk disk = new Disk(DISC_WIDTH_DIFF * i + DISC_WIDTH);
            window.addShape(disk);
            this.game.getTower(Position.RIGHT).push(disk);
            moveDisk(Position.RIGHT);
        }

        this.window.addShape(this.left);
        this.window.addShape(this.middle);
        this.window.addShape(this.right);
        this.solveButton = new Button("clickedSolve");
        this.window.addButton(solveButton, WindowSide.SOUTH);
        this.solveButton.onClick(this, "clickedSolve");

    }


    /**
     * This method tells the system to update when a disk has been moved
     */
    public void update(Observable o, Object arg) {
        if (arg.getClass() == Position.class) {
            moveDisk((Position)arg);

        }
        sleep();

    }


    /**
     * The following method slows down the runtime so the end user can see
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }


    /**
     * clickedSolve method tells the system when the solve button is clicked
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }


    /**
     * This method showcases the different position of the disks and the poles
     * 
     * @param disk
     *            is the position of the disks
     * @param currentPole
     *            is the position of the poles.
     */
    private void moveDisk(Position position) {
        Disk currentDisk = this.game.getTower(position).peek();
        Shape currentPole;
        switch (position) {
            case LEFT:
                currentPole = this.left;
                break;
            case MIDDLE:
                currentPole = this.middle;
                break;
            case RIGHT:
                currentPole = this.right;
                break;
            default:
                currentPole = this.right;
                break;
        }
        int x = currentPole.getX();
        int y = currentPole.getY() + this.ROD_HEIGHT - (this.game.getTower(
            position).size() * (this.DISK_HEIGHT + this.DISK_GAP));
        int width = currentDisk.getWidth();
        int height = currentDisk.getHeight();
        int size = this.game.getTower(position).size();
        currentDisk.moveTo(x - (currentDisk.getWidth() - this.ROD_WIDTH) / 2, y
            - (this.DISK_GAP));
    }

}
