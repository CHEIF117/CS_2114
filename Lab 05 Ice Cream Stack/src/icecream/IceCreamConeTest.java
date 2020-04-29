package icecream;

import student.TestCase;

/**
 * 
 * @author name Gunnar Nelson
 * @version 2020-02-19
 */

public class IceCreamConeTest extends TestCase {
    private IceCreamCone cone1;
    private IceCreamCone cone2;
    private IceCreamCone cone3;
    private IceCreamCone cone4;

    /**
     * 
     * Setting up our fields
     *
     */
    public void setUp() {
        cone1 = new IceCreamCone();
        cone2 = new IceCreamCone();
        cone3 = null;
        cone4 = new IceCreamCone();
    }


    /**
     * 
     * Here we are adding a scoop to cone 1
     *
     */
    public void testAdd() {
        cone1.addScoop("chocolate");
        assertTrue(cone1.contains("chocolate"));
        assertFalse(cone1.emptyCone());
    }


    /**
     * 
     * Testing eat scoop
     *
     */
    public void testEatScoop() {
        cone1.addScoop("chocolate");
        assertEquals("chocolate", cone1.eatScoop());
    }


    /**
     * 
     * Testing flavor string
     *
     */
    public void testToString() {
        cone1.addScoop("chocolate");
        assertEquals("[chocolate]", cone1.toString());
    }


    /**
     * 
     * Testing different methods
     *
     */
    public void testEquals() {
        cone1.addScoop("chocolate");
        cone2.addScoop("chocolate");
        cone4.addScoop("vanilla");
        String nullString = null;
        String oreo = "oreo";
        assertTrue(cone1.equals(cone1));
        assertTrue(cone2.equals(cone2));
        assertEquals(cone1.currentScoop(), "chocolate");
        assertFalse(cone1.equals("SuperCone"));
        assertFalse(cone1.equals(nullString));
        assertFalse(oreo.equals(nullString));
        assertFalse(cone1.equals(cone3));
        assertTrue(cone1.equals(cone2));
        assertFalse(cone1.equals(cone4));
        assertFalse(cone1.equals(new Object()));
    }


    /**
     * 
     * testing number of scoops
     *
     */
    public void testNumscoop() {
        cone1.addScoop("chocolate");
        assertEquals(1, cone1.numScoops());
    }


    /**
     * 
     * testing contains
     *
     */
    public void testContain() {
        cone1.addScoop("chocolate");
        assertTrue(cone1.contains("chocolate"));
        assertFalse(cone1.contains("vanilla"));
    }


    /**
     * 
     * testing empty
     *
     */
    public void testEmpty() {
        assertTrue(cone2.emptyCone());
        cone1.addScoop("chocolate");
        assertFalse(cone1.emptyCone());
    }
}
