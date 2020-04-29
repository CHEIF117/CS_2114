package linkedlist;
import java.util.Arrays;
import student.TestCase;
/**
 * 
 * Tests the equals and toArray methods of a singly linked list.
 * 
 * @author Margaret Ellis (maellis1)
 * 
 * @author Jeff Robertson (thejar)
 * 
 * @version 03/19/2017
 *
 */
public class SLLEqualsToArrayTest extends TestCase {
    private SinglyLinkedList<String> emptyListA;
    private SinglyLinkedList<String> emptyListB;
    private SinglyLinkedList<String> smallListA;
    private SinglyLinkedList<String> smallListB;
    private SinglyLinkedList<String> smallListC;
    private SinglyLinkedList<String> bigListA;
    private SinglyLinkedList<String> bigListB;
    private String nullObject;
    /**
     * Here we have lists A and B with a small number of items, and the other
     * list with a more items
     */
    public void setUp() {
        emptyListA = new SinglyLinkedList<String>();
        emptyListB = new SinglyLinkedList<String>();
        smallListA = new SinglyLinkedList<String>();
        smallListB = new SinglyLinkedList<String>();
        smallListC = new SinglyLinkedList<String>();
        smallListA.add("soccer");
        smallListA.add("swimming");
        smallListA.add("gymnastics");
        smallListB.add("soccer");
        smallListB.add("swimming");
        smallListB.add("gymnastics");
        smallListC.add("soccer");
        bigListA = new SinglyLinkedList<String>();
        for (int i = 0; i < 100; i++) {
            bigListA.add("sport" + i);
        }
        bigListB = new SinglyLinkedList<String>();
        for (int i = 0; i < 100; i++) {
            bigListB.add("sport" + i);
        }
        // to be explicit
        nullObject = null;
    }
    /**
     * tests the size method
     */
    public void testSize() {
        assertEquals(0, emptyListA.size());
        assertEquals(3, smallListA.size());
        assertEquals(100, bigListA.size());
    }
    /**
     * This test overrides add method, when object to be added is null
     */
    public void testOAddNullObject() {
        Exception thrown = null;
        try {
            smallListA.add(1, null);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof IllegalArgumentException);
    }
    /**
     * tests overridden add method when index is out of bounds
     */
    public void testOAddOutOfBound() {
        Exception thrown = null;
        try {
            smallListA.add(4, "add");
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }
    /**
     * tests overridden add method for empty list
     */
    public void testOAddEmptyList() {
        int size = emptyListA.size();
        emptyListA.add(0, "add");
        assertEquals(1, emptyListA.size());
        assertEquals(emptyListA.get(size), "add");
    }
    /**
     * tests overridden add method at a particular index
     */
    public void testOAddFirstIndex() {
        smallListA.add(0, "add");
        assertEquals(4, smallListA.size());
        assertEquals(smallListA.get(0), "add");
    }
    /**
     * tests overridden add method at a particular index
     */
    public void testOAddIndex() {
        smallListA.add(1, "add");
        assertEquals(4, smallListA.size());
        assertEquals(smallListA.get(1), "add");
    }
    /**
     * tests add method when object to be added is null
     */
    public void testAddNullObject() {
        Exception thrown = null;
        try {
            emptyListA.add(null);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof IllegalArgumentException);
    }
    /**
     * this tests the add method when object is added to empty list
     */
    public void testAddEmptyList() {
        int size = emptyListA.size();
        emptyListA.add("add");
        assertEquals(1, emptyListA.size());
        assertEquals(emptyListA.get(size), "add");
    }
    /**
     * tests the add method for list with items in it
     */
    public void testAddNotEmpty() {
        int size = smallListA.size();
        smallListA.add("add");
        assertEquals(4, smallListA.size());
        assertEquals(smallListA.get(size), "add");
    }
    /**
     * tests the clear method on non empty list
     */
    public void testClear() {
        smallListA.clear();
        assertEquals(0, smallListA.size());
    }
    /**
     * tests the clear method on empty list
     */
    public void testClearEmpty() {
        emptyListA.clear();
        assertEquals(0, emptyListA.size());
    }
    /**
     * tests remove(obj) when size is less than 2
     */
    /**
     * tests remove(int index) for exception more than
     */
    public void testRemoveExceptionHigh() {
        Exception thrown = null;
        try {
            smallListA.remove(3);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }
    /**
     * tests remove(int index) for exception less than
     */
    public void testRemoveExceptionLow() {
        Exception thrown = null;
        try {
            smallListA.remove(-1);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }
    /**
     * tests remove(int) and removes object at index = 0
     */
    public void testRemoveZero() {
        smallListA.remove(0);
        assertEquals(smallListA.get(0), "swimming");
        assertEquals(2, smallListA.size());
    }
    /**
     * tests remove(int) and removes object not at index = 0
     */
    public void testRemoveNotZero() {
        smallListA.remove(1);
        assertEquals(smallListA.get(1), "gymnastics");
        assertEquals(2, smallListA.size());
    }
    /**
     * tests remove for empty case
     */
    public void testRemoveEmpty() {
        Exception thrown = null;
        try {
            emptyListA.remove(0);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }
    /**
     * Tests the equals method on an empty list
     */
    public void testEqualsEmptyList() {
        assertEquals(emptyListA, emptyListA);
        assertEquals(emptyListA, emptyListB);
        assertFalse(emptyListA.equals(nullObject));
        assertFalse(emptyListA.equals("soccer"));
        assertFalse(emptyListA.equals(smallListA));
        assertFalse(smallListA.equals(emptyListA));
        emptyListB.add("jump roping");
        assertFalse(emptyListA.equals(emptyListB));
        smallListA.clear();
        assertEquals(emptyListA, smallListA);
    }
    /**
     * Tests the equals method on a list with a small number of items in it
     */
    public void testEqualsSmallList() {
        assertEquals(smallListA, smallListA);
        assertEquals(smallListA, smallListB);
        assertFalse(smallListA.equals(nullObject));
        assertFalse(smallListA.equals("soccer"));
        assertFalse(smallListA.equals(bigListA));
        assertFalse(smallListA.equals(emptyListA));
        smallListB.add("jump roping");
        assertFalse(smallListA.equals(smallListB));
        // Make smallListA and smallListB differ in
        // content, but have the same size
        smallListA.add("rope jumping");
        assertFalse(smallListA.equals(smallListB));
        // Replace the last element in smallListA
        // to make smallListA and smallListB equal again
        smallListA.remove("rope jumping");
        smallListA.add("jump roping");
        assertEquals(smallListA, smallListB);
    }
    /**
     * Tests the equals method on a list with a large number of items in it
     */
    public void testEqualsBigList() {
        assertEquals(bigListA, bigListA);
        assertEquals(bigListA, bigListB);
        assertFalse(bigListA.equals(nullObject));
        assertFalse(bigListA.equals("soccer"));
        assertFalse(bigListA.equals(smallListA));
        assertFalse(bigListA.equals(emptyListA));
        bigListB.add("jump roping");
        assertFalse(bigListA.equals(bigListB));
        // Same content, same size, but reversed
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 100; i > 0; i--) {
            bigListB.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListB));
        // one a subset of the other but with dups
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 50; i++) {
            bigListB.add("sport" + i);
        }
        for (int i = 0; i < 50; i++) {
            bigListB.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListB));
        // make them equal again
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 100; i++) {
            bigListB.add("sport" + i);
        }
        assertEquals(bigListA, bigListB);
    }
    /**
     * Tests the toArray method on an empty list
     */
    public void testToArrayEmpty() {
        Object[] emptyArray = {};
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(emptyListA.toArray(), smallListB.toArray()));
        Object[] oneItemArray = { "one thing" };
        emptyListA.add("one thing");
        assertTrue(Arrays.equals(emptyListA.toArray(), oneItemArray));
    }
    /**
     * Tests the toArray method on a list with items in it
     */
    public void testToArrayContents() {
        Object[] origArray = { "soccer", "swimming", "gymnastics" };
        assertTrue(Arrays.equals(smallListA.toArray(), origArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(smallListA.toArray(), bigListB.toArray()));
    }
    /**
     * test toString method
     */
    public void testToString() {
        assertEquals("{soccer, swimming, gymnastics}", smallListA.toString());
    }
    /**
     * tests lastIndexOf method
     */
    public void testLastIndexOf() {
        assertEquals(0, smallListA.lastIndexOf("soccer"));
    }
    /**
     * tests get method for when the data = null
     */
    public void testGet() {
        Exception thrown = null;
        try {
            emptyListA.get(0);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }
    /**
     * this test contains method
     */
    public void testContains() {
        assertTrue(smallListA.contains("swimming"));
        assertFalse(smallListA.contains("jump roping"));
    }
    /**
     * test remove for less than 2
     */
    public void testRemoveLess() {
        smallListC.remove("soccer");
        assertEquals(0, smallListC.size());
    }
    /**
     * tests remove for 2 or more 
     */
    public void testRemoveTwo() {
        smallListA.remove("soccer");
        assertEquals(2, smallListA.size());
    }
    /**
     * tests remove method for false case
     */
    public void testRemoveFalse() {
        assertFalse(smallListA.remove("rope jumping"));
    }
}
