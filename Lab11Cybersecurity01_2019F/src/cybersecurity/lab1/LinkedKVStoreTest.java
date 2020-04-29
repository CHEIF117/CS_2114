package cybersecurity.lab1;
import student.TestCase;
import java.util.Iterator;


/**
 * Test class for LinkedKVStore
 * 
 * @author name Gunnar Nelson
 * @version 2020-04-16
 */
public class LinkedKVStoreTest extends TestCase {

    private LinkedKVStore<Integer, String> store;


    /**
     * Setup our test methods to test for LinkedKVStore test
     */
    public void setUp() {
        store = new LinkedKVStore<Integer, String>();

    }


    /**
     * Tests isEmpty method
     */
    public void testIsEmpty() {
        assertTrue(store.isEmpty());
        store.put(2, "two");
        store.put(3, "two");
        assertFalse(store.isEmpty());

    }


    /**
     * Tests Size method
     */
    public void testSize() {
        assertEquals(0, store.size());
        store.addFirst(2, "two");
        assertEquals(1, store.size());

    }


    /**
     * Test Clear method
     */
    public void testClear() {
        store.addFirst(2, "two");
        assertEquals(1, store.size());
        store.clear();
        assertEquals(0, store.size());
    }


    /**
     * Test method for GetFirst
     */
    public void testGetFirst() {
        store.addFirst(2, "two");
        assertEquals("two", store.getFirst(2));

    }


    /**
     * Test method for GetLast
     */
    public void testGetLast() {
        store.addLast(2, "two");
        assertEquals("two", store.getLast(2));
    }


    /**
     * Test method for addFirst
     */
    public void testAddFirst() {
        store.put(1, "one");
        store.addFirst(2, "two");
        Iterator<Integer> it = store.iterator();
        assertEquals(2, it.next().intValue());
        assertEquals(1, it.next().intValue());
        assertEquals("two", store.getFirst(2));
        assertEquals("one", store.getFirst(1));
        assertTrue(store.removeLast(1));
        assertNull(store.getLast(1));
        store.addFirst(1, "one");
        assertEquals("one", store.getLast(1));
        store.addFirst(1, "ONE");
        assertEquals("ONE", store.getFirst(1));
        assertEquals("one", store.getLast(1));
    }


    /**
     * Test method for addFirst
     */
    public void testAddLast() {
        store.put(1, "one");
        store.addLast(2, "two");
        Iterator<Integer> it = store.iterator();
        assertEquals(1, it.next().intValue());
        assertEquals(2, it.next().intValue());
        assertEquals("two", store.getLast(2));
        assertEquals("one", store.getLast(1));
        assertTrue(store.removeLast(1));
        assertNull(store.getLast(1));
        store.addFirst(1, "one");
        assertEquals("one", store.getFirst(1));
        store.addFirst(1, "ONE");
        assertEquals("one", store.getLast(1));
        assertEquals("ONE", store.getFirst(1));
    }


    /**
     * Test removeFirst method
     */
    public void testRemoveFirst() {
        assertFalse(store.removeFirst(1));
        store.put(1, "one");
        assertTrue(store.contains(1));
        assertTrue(store.removeFirst(1));
        assertFalse(store.contains(1));
        store.put(1, "1.one");
        store.put(1, "1.two");
        store.put(1, "1.three");
        assertTrue(store.removeFirst(1));
        assertEquals("[1, 1]", store.toString());
        assertEquals("1.two", store.getFirst(1));
    }


    /**
     * Test removeLast method
     */
    public void testRemoveLast() {
        assertFalse(store.removeLast(1));
        store.put(1, "one");
        assertTrue(store.contains(1));
        assertTrue(store.removeLast(1));
        assertFalse(store.contains(1));
        store.put(1, "1.one");
        store.put(1, "1.two");
        store.put(1, "1.three");
        assertTrue(store.removeLast(1));
        assertEquals("[1, 1]", store.toString());
        assertEquals("1.two", store.getLast(1));
    }


    /**
     * Test contains method
     */
    public void testContains() {
        assertFalse(store.contains(1));
        store.put(1, "one");
        assertTrue(store.contains(1));
    }


    /**
     * Tests get method
     */
    public void testGet() {
        store.put(1, "one");
        store.put(2, "two");
        assertEquals("one", store.get(1));
        assertEquals("two", store.get(2));
        assertEquals(null, store.get(3));
    }


    /**
     * Test method for Put
     */
    public void testPut() {
        store.put(1, "1.one");
        assertTrue(store.contains(1));

    }
}