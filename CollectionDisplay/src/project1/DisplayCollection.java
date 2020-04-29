// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Gunnar Nelson (90595625)
package project1;

import java.util.Random;
import bag.Bag;
import bag.BagInterface;

/**
 * @author name Gunnar Nelson
 * @version 1.82 Java
 */
public class DisplayCollection {
    /**
     * Outlines the elements that the bag will contain
     * our values for red circle, blue circle, etc.
     */
    private BagInterface<String> itemBag;
    /**
     * Here we have set up our bag to inclue the STRINGS array
     */
    public static final String[] STRINGS = { "red circle", "blue circle",
        "red square", "blue square" };

    /**
     * This is our Display Collection Constructor
     * It will implement our Random outputs
     * As well as set up our array from 5 to 15
     */
    public DisplayCollection() {
        /**
         * With our Display Collection constructor,
         * random value object is
         * defined, then selects items from the
         * STRINGS array,
         * and adds them to the bag
         * 
         */
        Random random = new Random();
        int count = random.nextInt(11) + 5;
        this.itemBag = new Bag<>();
        for (int i = 0; i < count; i++) {
            int index = random.nextInt(4);
            System.out.println(STRINGS[index]);
            itemBag.add(STRINGS[index]);

        }

    }


    /**
     * The following constructor outputs our bag
     * @return itemBag
     */
    public BagInterface<String> getItemBag() {
        /**
         * With our Bag Interface we are able to output our bag
         * 
         */
        return itemBag;

    }

}
