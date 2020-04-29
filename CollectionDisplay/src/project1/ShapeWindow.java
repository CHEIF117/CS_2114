// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Gunnar Nelson (90595625)
package project1;

/**
 * @author name Gunnar Nelson
 *
 */

import bag.BagInterface;
import CS2114.TextShape;
import java.awt.*;
import CS2114.Window;
import CS2114.Button;
import CS2114.WindowSide;

public class ShapeWindow {
    private Window window;
    private TextShape textshape;
    private Button quitButton;
    private Button chooseButton;
    private BagInterface<String> itemBag;

    /**
     * Our parameters are defined inside the constructor
     *
     * @param bag
     */
    public ShapeWindow(BagInterface<String> bag) {
        this.window = new Window();
        quitButton = new Button("Quit");
        this.chooseButton = new Button("Choose");
        itemBag = bag;
        textshape = new TextShape(0, 0, "");
        window.addShape(textshape);
        window.setTitle("Project 1");
        quitButton.onClick(this, "clickedQuit");
        chooseButton.onClick(this, "clickedChoose");
        window.addButton(quitButton, WindowSide.NORTH);
        window.addButton(chooseButton, WindowSide.SOUTH);

    }


    /**
     * Exits the window when the Quit button is clicked
     *
     * @param Quit
     */
    public void clickedQuit(Button Quit) {
        System.out.println("quit button clicked");
        System.exit(0);
    }


    /**
     * Text is colored based on what is specified from the STRING array
     * (Ex: "red"=red and "blue"=blue)
     */
    private void colorText() {
        if (textshape.getText().contains("blue")) {
            textshape.setForegroundColor(Color.BLUE);
        }
        else if (textshape.getText().contains("red")) {
            textshape.setForegroundColor(Color.RED);
        }
        else {
            textshape.setForegroundColor(Color.BLACK);
        }

    }


    /**
     * Centers the text
     */
    private void centerText() {
        int windowx = window.getGraphPanelWidth();
        int windowy = window.getGraphPanelHeight();
        int textshapex = textshape.getWidth();
        int textshapey = textshape.getHeight();
        textshape.moveTo((windowx - textshapex) / 2, (windowy - textshapey)
            / 2);

    }


    /**
     * When the choose button is clicked; there is a random string generated
     * form the bag
     *
     * @param btn
     */
    public void clickedChoose(Button btn) {
        textshape.setBackgroundColor(Color.WHITE);
        if (itemBag.isEmpty() == false) {
            String bagItem = itemBag.remove();
            textshape.setText(bagItem);
        }
        else {
            textshape.setText("No more items.");
        }

        colorText();
        centerText();

    }

}
