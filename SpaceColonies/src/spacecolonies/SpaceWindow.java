// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Gunnar Nelson (905956285)
package spacecolonies;

/**
 * 
 * @author name Gunnar Nelson
 * @version 2020-04-16
 * 
 * 
 *          Here we are stting up our SpaceWindow GUI.
 *          This is where the magic begins
 * 
 */

import CS2114.Window;
import CS2114.Button;
import CS2114.WindowSide;
import CS2114.TextShape;
import CS2114.Shape;
import CS2114.CircleShape;
import CS2114.SquareShape;
import java.awt.Color;
import list.AList;

public class SpaceWindow {
    private Window window;
    private Button accept;
    private Button reject;
    private AList<CircleShape> personCircles;
    private ColonyCalculator colonyCalculator;
    private TextShape applicantInformation;
    private TextShape[] planets = new TextShape[3];
    public static final int INFO_STARTX = 570;
    public static final int QUEUE_STARTX = 100;
    public static final int PLANET_STARTX = 500;
    public static final int PLANET_STARTY = 350;
    public static final int QUEUE_STARTY = 150;
    public static final int CIRCLE_SIZE = 50;
    public static final int SQUARE_SIZE = 100;

    /**
     * Creates new SpaceWindow object forthe SpaceWindow class.
     * 
     * @param colonyCalculator
     *            Colony Calculator instance to be used.
     */
    public SpaceWindow(ColonyCalculator colonyCalculator) {
        this.colonyCalculator = colonyCalculator;
        window = new Window("Space Colony Placement");
        window.setSize(1400, 600);
        accept = new Button("ACCEPT");
        window.addButton(accept, WindowSide.SOUTH);
        accept.onClick(this, "clickedAccept");
        reject = new Button("REJECT");
        window.addButton(reject, WindowSide.SOUTH);
        reject.onClick(this, "clickedReject");

        if (colonyCalculator.getQueue().isEmpty()) {
            applicantInformation = new TextShape(INFO_STARTX, QUEUE_STARTY
                - CIRCLE_SIZE, "");
        }
        else {
            applicantInformation = new TextShape(INFO_STARTX, QUEUE_STARTY
                - CIRCLE_SIZE, colonyCalculator.getQueue().getFront()
                    .toString());
        }
        applicantInformation.setBackgroundColor(Color.WHITE);

        Planet[] tempPlanents = new Planet[4];

        for (int i = 1; i <= 3; i++) {
            tempPlanents[i] = colonyCalculator.planetByNumber(i);
            System.out.print(tempPlanents[i]);
        }

        planets[0] = new TextShape(PLANET_STARTX, PLANET_STARTY, tempPlanents[1]
            .getName() + ", 0/10");
        planets[0].setBackgroundColor(Color.WHITE);

        if (tempPlanents[1] != null) {
            planets[1] = new TextShape(PLANET_STARTX + SQUARE_SIZE * 3 / 2,
                PLANET_STARTY, tempPlanents[2].getName() + ", 0/10");
            planets[1].setBackgroundColor(Color.WHITE);
        }

        if (tempPlanents[2] != null) {
            planets[2] = new TextShape(PLANET_STARTX + SQUARE_SIZE * 3,
                PLANET_STARTY, tempPlanents[3].getName() + ", 0/10");
            planets[2].setBackgroundColor(Color.WHITE);
        }

        for (int i = 0; i < 3; i++) {
            window.addShape(planets[i]);
        }

        window.addShape(applicantInformation);
        moveForward();
    }


    /**
     * Creates the GUI and function for moveFoward
     */
    public void moveForward() {
        if (colonyCalculator.getQueue().isEmpty()) {
            finishGUI();
        }
        else {
            window.removeAllShapes();
            updateText();
            updatePlanets();
            updateCircles();
        }
    }


    /**
     * Using the Colony Calculator, planets will be updated with each click
     */
    public void updatePlanets() {
        for (int i = 1; i < ColonyCalculator.NUM_PLANETS + 1; i++) {
            Shape planetshape = new Shape(PLANET_STARTX + SQUARE_SIZE * 3 / 2
                * (i - 1), PLANET_STARTY - SQUARE_SIZE, SQUARE_SIZE,
                SQUARE_SIZE);
            Shape fillShape = planetshape;
            Planet currentPlanet = colonyCalculator.planetByNumber(i);
            if (currentPlanet != null) {
                int newSS = SQUARE_SIZE * currentPlanet.getAvailability()
                    / currentPlanet.getCapacity();
                fillShape = new Shape(PLANET_STARTX + SQUARE_SIZE * 3 / 2 * (i
                    - 1), PLANET_STARTY - SQUARE_SIZE, SQUARE_SIZE, newSS);
                window.moveToFront(fillShape);
            }

            if (i == 1) {

                fillShape.setBackgroundColor(Color.GRAY);
            }
            else if (i == 2) {

                fillShape.setBackgroundColor(Color.PINK);
            }
            else {

                fillShape.setBackgroundColor(Color.cyan);
            }

            window.addShape(planetshape);
            window.addShape(fillShape);
            window.moveToBack(planetshape);
        }

        for (int i = 0; i < 3; i++) {
            window.addShape(planets[i]);
        }
    }


    /**
     * The updateText method will update the text as the planets are being
     * configured
     */
    public void updateText() {
        applicantInformation.remove();
        applicantInformation = new TextShape(INFO_STARTX, QUEUE_STARTY
            - CIRCLE_SIZE * 3 / 2, colonyCalculator.getQueue().getFront()
                .toString());
        applicantInformation.setBackgroundColor(Color.WHITE);

        Planet[] tempPlanents = new Planet[4];

        for (int i = 1; i <= 3; i++) {
            tempPlanents[i] = colonyCalculator.planetByNumber(i);
        }

        planets[0].setText(tempPlanents[1].getName() + ", " + tempPlanents[1]
            .getPopulationSize() + "/" + tempPlanents[1].getCapacity());
        TextShape skillsText1 = new TextShape(PLANET_STARTX, PLANET_STARTY + 15,
            tempPlanents[1].getSkills().toString());
        window.addShape(skillsText1);
        skillsText1.setBackgroundColor(Color.WHITE);

        planets[1].setText(tempPlanents[2].getName() + ", " + tempPlanents[2]
            .getPopulationSize() + "/" + tempPlanents[2].getCapacity());
        TextShape skillsText2 = new TextShape(PLANET_STARTX + SQUARE_SIZE * 3
            / 2, PLANET_STARTY + 15, tempPlanents[2].getSkills().toString());
        skillsText2.setBackgroundColor(Color.WHITE);
        window.addShape(skillsText2);

        planets[2].setText(tempPlanents[3].getName() + ", " + tempPlanents[3]
            .getPopulationSize() + "/" + tempPlanents[3].getCapacity());

        TextShape skillsText3 = new TextShape(PLANET_STARTX + SQUARE_SIZE * 3,
            PLANET_STARTY + 15, tempPlanents[3].getSkills().toString());
        skillsText3.setBackgroundColor(Color.WHITE);
        window.addShape(skillsText3);

        window.addShape(applicantInformation);
    }


    /**
     * The updateCirucles method will update the circles as the planets are
     * being configured
     */
    public void updateCircles() {
        ArrayQueue<Person> temp = null;
        if (!colonyCalculator.getQueue().isEmpty()) {
            temp = colonyCalculator.getQueue();
        }

        for (int i = 0; i < temp.getSize(); i++) {
            CircleShape circleShape = new CircleShape(QUEUE_STARTX + CIRCLE_SIZE
                * i, QUEUE_STARTY, CIRCLE_SIZE);

            String plan = ((Person)temp.toArray()[i]).getPlanetName();
            int selectedPlanet = colonyCalculator.getPlanetIndex(plan);

            if (selectedPlanet == 1) {
                circleShape.setForegroundColor(Color.GRAY);
            }
            else if (selectedPlanet == 2) {
                circleShape.setForegroundColor(Color.PINK);
            }
            else if (selectedPlanet == 3) {
                circleShape.setForegroundColor(Color.CYAN);
            }
            else {
                circleShape.setForegroundColor(Color.RED);
            }

            window.addShape(circleShape);
        }
    }


    /**
     * In the finishGUI we output all of our Buttons and Windows, with the
     * accept and reject being on the south-side of the window
     */
    public void finishGUI() {
        window.removeAllShapes();
        window.removeButton(accept, WindowSide.SOUTH);
        window.removeButton(reject, WindowSide.SOUTH);
        TextShape doneText = new TextShape(window.getWidth() / 3, window
            .getHeight() / 3, "All Applicants Processed - Good Work!");

        doneText.setBackgroundColor(Color.WHITE);
        window.addShape(doneText);
    }


    /**
     * Our clickedAccept button returns a boolean value when it is clicked,
     * This the back-end for the button
     * 
     * @param button
     *            Button pressed and returns a boolean value to accept
     */
    public void clickedAccept(Button button) {
        boolean accepted = colonyCalculator.accept();
        if (accepted == true) {
            moveForward();
        }
        else {
            button.disable();
        }
    }


    /**
     * Our clickedAccept button returns a boolean value when it is clicked,
     * This the back-end for the button
     * 
     * @param button
     *            Button pressed and returns a boolean value to reject
     */
    public void clickedReject(Button button) {
        colonyCalculator.reject();
        moveForward();
        accept.enable();
    }
}
