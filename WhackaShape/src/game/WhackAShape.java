// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Gunnar Nelson (90595625)
package game;

import bag.SimpleBagInterface;
import CS2114.Button;
import CS2114.Shape;
import CS2114.Window;
import CS2114.WindowSide;
import CS2114.SquareShape;
import student.TestableRandom;
import CS2114.TextShape;
import java.awt.Color;
import CS2114.CircleShape;

/**
 * 
 * 
 * @author name Gunnar Nelson
 * @version 2020-02-28
 * 
 *          This class builds the game WhackAShape to build our bag
 *
 */
public class WhackAShape {
    private SimpleBagInterface<Shape> bag;
    private Window window;
    private TestableRandom randomGenerator;
    private Shape currentShape;

    /**
     * This is our WhackAShape constructor
     * Sets up the our shapes, window, and quit button
     * Each value will be randomly generated
     * We have also set up our bag size from 7 to 12
     */
    public WhackAShape() {
        bag = new SimpleArrayBag<Shape>();
        window = new Window();
        randomGenerator = new TestableRandom();
        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.SOUTH);
        bag.add(buildShape("red circle"));
        bag.add(buildShape("blue circle"));
        bag.add(buildShape("red square"));
        bag.add(buildShape("blue square"));
        int num = randomGenerator.nextInt(6);
        num = num + 7;
        window.addShape(bag.pick());
    }


    /**
     * THis constructor will have an array of strings put in its system
     * However, we are throwing an exception using a try and catch method
     * In order to construct and randomly generate our shapes in the window
     * We are literally picking random items from the bag.
     * 
     * @param shapes
     *            is the array of strings, which are shapes, (hence the name)
     *            being added to the bag.
     */
    public WhackAShape(String[] shapes) {
        bag = new SimpleLinkedBag<Shape>();
        window = new Window();
        randomGenerator = new TestableRandom();
        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.SOUTH);
        for (int index = 0; index < shapes.length; index++) {
            Exception thrown = null;
            try {
                bag.add(buildShape(shapes[index]));
            }
            catch (Exception exception) {
                thrown = exception;
                thrown.printStackTrace();
            }
        }
        window.addShape(bag.pick());
    }


    /**
     * This method returns the items in the bag, our shapes
     * 
     * @return the bag
     */
    public SimpleBagInterface<Shape> getBag() {
        return bag;
    }


    /**
     * Outputs the window
     * 
     * @return returning the window
     */
    public Window getWindow() {
        return window;
    }


    /**
     * This is the part that allows the end user to close the game
     * 
     * @param button
     *            quit button
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * This part causes different shapes to appear and disappear after
     * being clicked on. Since we are picking random items from our bag,
     * random shapes will appear. Once the bag is empty, the string, "You Win!"
     * will appear on the window, dead center.
     * 
     * @param shape
     *            shape being clicked
     */
    public void clickedShape(Shape shape) {
        window.removeShape(shape);
        bag.remove(shape);
        Shape nextShape = bag.pick();
        if (nextShape == null) {
            TextShape text = new TextShape(0, 0, "You Win!");
            int x = window.getGraphPanelWidth() / 2 - text.getWidth() / 2;
            int y = window.getGraphPanelHeight() / 2 - text.getHeight() / 2;
            text.setX(x);
            text.setY(y);
            window.addShape(text);
        }
        else {
            window.addShape(nextShape);
        }
    }


    /**
     * This method builds the shapes, our red circle, blue circle, red square,
     * and blue square.
     * 
     * @param shape
     *            the shape from our declared shapes in the constructor
     * @return returning the shape which is outputed
     */
    private Shape buildShape(String shape) {
        int size = randomGenerator.nextInt(101) + 100;
        int x = randomGenerator.nextInt(window.getGraphPanelWidth() - size);
        int y = randomGenerator.nextInt(window.getGraphPanelHeight() - size);
        if (!shape.contains("red") && !shape.contains("blue")) {
            throw new IllegalArgumentException();
        }

        if (!shape.contains("circle") && !shape.contains("square")) {
            throw new IllegalArgumentException();
        }

        if (shape.contains("circle") && shape.contains("red")) {
            currentShape = new CircleShape(x, y, size, Color.RED);
        }
        else if (shape.contains("circle") && shape.contains("blue")) {
            currentShape = new CircleShape(x, y, size, Color.BLUE);
        }
        else if (shape.contains("square") && shape.contains("red")) {
            currentShape = new SquareShape(x, y, size, Color.red);
        }
        else if (shape.contains("square") && shape.contains("blue")) {
            currentShape = new SquareShape(x, y, size, Color.BLUE);
        }
        currentShape.onClick(this, "clickedShape");
        return currentShape;
    }

}
