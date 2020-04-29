package Introduction;

import student.TestCase;

/**
 * CalculatorTest will test all of the methods in Calculator to make
 * sure that they run and perform as expected
 *
 * @author <GunnarNelson> <ngunn15>
 * @version <1/22/2020>
 */

public class CalculatorTest extends TestCase {
    private Calculator test1;
    private Calculator test2;

    /**
     * sets up each test method before it runs
     */
    public void setUp() {
        test1 = new Calculator(3, 7);
        test2 = new Calculator(7, 0);
    }


    /**
     * Setting up the first input prior to testing
     */
    public void testGetFirstInput() {
        assertEquals(3, test1.getFirstInput(), 0.01);

    }


    /**
     * Setting up the second input prior to testing
     */

    public void testGetSecondInput() {
        assertEquals(7, test1.getSecondInput(), 0.01);
    }


    /**
     * Testing for the multiply function
     */
    public void testMultiply() {
        assertEquals(21, test1.multiply(), 0.01);
    }


    /**
     * Testing for the divide function
     */

    public void testDivide() {
        assertEquals(3.0 / 7.0, test1.divide(), 0.01);
        assertEquals(Double.NaN, test2.divide(), 0.01);
    }


    /**
     * Testing for the subtract function
     */

    public void testsubtract() {
        assertEquals(3 - 7, test1.subtract(), 0.01);
    }


    /**
     * Testing for the add function
     */

    public void testadd() {
        assertEquals(10, test1.add(), 0.01);
    }


    /**
     * Testing for the power function
     */

    public void testPower() {
        assertEquals(Math.pow(3, 7), test1.power(), 0.01);
    }
}
