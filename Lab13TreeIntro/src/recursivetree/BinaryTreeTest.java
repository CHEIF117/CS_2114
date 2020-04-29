/**
 * 
 */
package recursivetree;

import student.TestCase;

/**
 * @author name Gunnar Nelson
 * 
 * @version 2020-25-04
 *
 */
public class BinaryTreeTest extends TestCase {

    private BinaryTree<String> appleTree1;
    private BinaryTree<String> appleTree2;

    /**
     * Here we are setting up our variables
     */
    public void setUp() {
        appleTree1 = new BinaryTree<String>("4");
        appleTree2 = new BinaryTree<String>("4", appleTree1,
            new BinaryTree<String>("4"));
    }


    /**
     * Test method for getElement.
     */
    public void testGetElement() {
        assertEquals(appleTree1.getElement(), "4");
        assertEquals(appleTree2.getElement(), "4");
    }


    /**
     * Test method for setElement.
     */
    public void testSetElement() {
        appleTree1.setElement("tempTest");
        assertEquals(appleTree1.getElement(), "tempTest");

    }


    /**
     * Test method for getLeft.
     */
    public void testGetLeft() {
        assertNull(appleTree1.getLeft());

        BinaryTree<String> tempy = new BinaryTree<String>("c");
        appleTree1.setLeft(tempy);
        assertEquals(appleTree1.getLeft(), tempy);

    }


    /**
     * Test method for setLeft.
     */
    public void testSetLeft() {
        BinaryTree<String> tempy2 = new BinaryTree<String>("d");
        appleTree1.setLeft(tempy2);
        assertEquals(appleTree1.getLeft(), tempy2);
    }


    /**
     * Test method for getRight.
     */
    public void testGetRight() {
        assertNull(appleTree1.getRight());

        BinaryTree<String> tempy = new BinaryTree<String>("c");
        appleTree1.setRight(tempy);
        assertEquals(appleTree1.getRight(), tempy);
    }


    /**
     * Test method for setRight.
     */
    public void testSetRight() {
        assertEquals(1, appleTree1.size());

        BinaryTree<String> tempy2 = new BinaryTree<String>("d");
        appleTree1.setRight(tempy2);
        assertEquals(appleTree1.getRight(), tempy2);
    }


    /**
     * Test method for size.
     */
    public void testSize() {
        assertEquals(1, appleTree1.size());

        BinaryTree<String> left = new BinaryTree<String>("b");
        appleTree1.setLeft(left);
        assertEquals(2, appleTree1.size());

        BinaryTree<String> right = new BinaryTree<String>("b");
        appleTree1.setRight(right);
        assertEquals(3, appleTree1.size());
    }


    /**
     * Test method for height.
     */
    public void testHeight() {
        assertEquals(1, appleTree1.height());

        BinaryTree<String> left = new BinaryTree<String>("b");
        appleTree1.setLeft(left);
        assertEquals(2, appleTree1.height());

        BinaryTree<String> right = new BinaryTree<String>("b");
        appleTree1.setRight(right);
        assertEquals(2, appleTree1.height());

        BinaryTree<String> left2 = new BinaryTree<String>("b");
        appleTree1.getLeft().setLeft(left2);
        assertEquals(3, appleTree1.height());

    }


    /**
     * Test method for toPreOrderString.
     */
    public void testToPreOrderString() {
        assertEquals("(4)", appleTree1.toPreOrderString());
        System.out.println(appleTree1.toPreOrderString());

        BinaryTree<String> left = new BinaryTree<String>("2");
        appleTree1.setLeft(left);
        assertEquals("(4 (2))", appleTree1.toPreOrderString());

        System.out.println(appleTree1.toPreOrderString());

        BinaryTree<String> right = new BinaryTree<String>("3");
        appleTree1.setRight(right);
        assertEquals("(4 (2) (3))", appleTree1.toPreOrderString());
        System.out.println(appleTree1.toPreOrderString());
    }


    /**
     * Test method for toInOrderString.
     */
    public void testToInOrderString() {
        System.out.print(appleTree1.toInOrderString());
        assertEquals("(4)", appleTree1.toInOrderString());

        BinaryTree<String> left = new BinaryTree<String>("2");
        appleTree1.setLeft(left);
        assertEquals("((2)4)", appleTree1.toInOrderString());

        BinaryTree<String> right = new BinaryTree<String>("3");
        appleTree1.setRight(right);
        assertEquals("((2)4(3))", appleTree1.toInOrderString());

    }


    /**
     * Test method for toPostOrderString.
     */
    public void testToPostOrderString() {
        System.out.print(appleTree1.toPostOrderString());
        assertEquals("(4)", appleTree1.toPostOrderString());

        BinaryTree<String> left = new BinaryTree<String>("2");
        appleTree1.setLeft(left);
        assertEquals("((2)4)", appleTree1.toPostOrderString());

        BinaryTree<String> right = new BinaryTree<String>("3");
        appleTree1.setRight(right);
        assertEquals("((2)(3)4)", appleTree1.toPostOrderString());
    }

}
