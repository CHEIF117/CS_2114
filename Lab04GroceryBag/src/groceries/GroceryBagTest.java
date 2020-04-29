/**
 * 
 */
package groceries;

import student.TestCase;

/**
 * @author name Gunnar Nelson
 *         This will test our GroceryBag Class
 */
public class GroceryBagTest extends TestCase {
    private GroceryBag bag1; // unordered
    private GroceryBag bag2; // unordered with repeat items
    private GroceryBag bag3; // ordered
    private GroceryBag bag4; // ordered with repeat items

    /**
     * Sets up each test method.
     */
    public void setUp() {
        bag1 = new GroceryBag();
        bag1.add("apples");
        bag1.add("chips");
        bag1.add("yogurt");
        bag1.add("chicken");
        bag1.add("pasta");

        bag2 = new GroceryBag();
        bag2.add("pizza");
        bag2.add("broccoli");
        bag2.add("pasta");
        bag2.add("pasta");
        bag2.add("apples");

        bag3 = new GroceryBag();
        bag3.add("apples");
        bag3.add("chicken");
        bag3.add("chicken");
        bag3.add("pasta");
        bag3.add("pizza");
        bag3.add("soda");
        bag3.add("yogurt");
        bag3.add("wheat");

        bag4 = new GroceryBag();
        bag4.add("chicken");
        bag4.add("chicken");
        bag4.add("pasta");
        bag4.add("pasta");
        bag4.add("yogurt");
    }


    /**
     * Our Test Equals method
     */
    public void testEquals() {
        GroceryBag b = new GroceryBag();
        GroceryBag c = new GroceryBag();
        GroceryBag d = null;
        assertTrue(bag1.equals(bag1));
        assertFalse(bag1.equals(bag2));
        assertFalse(bag1.equals(b));
        assertFalse(bag1.equals(c));
        assertFalse(bag1.equals(d));
        assertFalse(bag1.equals("ab"));

    }


    /**
     * Our Test GroceryBagIntersection
     */

    public void testGroceryBagIntersection() {
        GroceryBag b = new GroceryBag();
        b.add("apples");
        b.add("pasta");
        assertTrue(bag1.intersection(bag2).equals(b));
        bag1.equals(bag1);
        GroceryBag c = new GroceryBag();
        c.add("pizza");
        c.add("pasta");
        c.add("apples");
        assertTrue(bag2.intersection(bag3).equals(c));
        bag2.equals(bag3);

    }

}
