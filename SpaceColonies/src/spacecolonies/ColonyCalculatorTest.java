// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Gunnar Nelson (905956285)
package spacecolonies;

import student.TestCase;

/**
 * @author name Gunnar Nelson
 * @version 2020.04.15
 * 
 *          Tests the methods from the Colony Calculator method
 */

public class ColonyCalculatorTest extends TestCase {

    private ColonyCalculator colonyCalc;
    private ArrayQueue<Person> persons;
    private Planet[] planets;

    /**
     * setsUp our variables to test for ColonyCalculator methods
     */
    public void setUp() {
        persons = new ArrayQueue<Person>();
        planets = new Planet[4];
        planets[1] = new Planet("Mercury", 1, 1, 2, 2);
        planets[2] = new Planet("Venus", 2, 1, 4, 4);
        planets[3] = new Planet("Earth", 5, 4, 3, 1);

        persons.enqueue(new Person("Thiccus", 5, 1, 5, "Mercury"));
        persons.enqueue(new Person("Meanus", 1, 1, 1, "Venus"));
        persons.enqueue(new Person("Dale", 4, 5, 1, "Earth"));
        persons.enqueue(new Person("John", 4, 1, 2, ""));
        persons.enqueue(new Person("Meanus", 4, 5, 1, "Venus"));

        colonyCalc = new ColonyCalculator(persons, planets);
    }


    /**
     * Test getQueue method
     */
    public void testGetQueue() {
        assertEquals(5, colonyCalc.getQueue().getSize());
        Person compPerson = new Person("Thiccus", 5, 1, 5, "Mercury");
        assertEquals(compPerson, colonyCalc.getQueue().getFront());

        assertTrue(colonyCalc.accept());
        colonyCalc.reject();

        persons = new ArrayQueue<Person>();
        colonyCalc = new ColonyCalculator(persons, planets);

        assertFalse(colonyCalc.accept());

    }


    /**
     * Test getPlanets method.
     */
    public void testGetPlanets() {
        Planet temp = new Planet("Earth", 5, 4, 3, 1);
        assertEquals(temp, ColonyCalculator.getPlanets()[3]);
    }


    /**
     * Test getPlanetForPerson method
     */
    public void testGetPlanetForPerson() {
        Person tempPerson = new Person("Thiccus Maximus", 5, 3, 4, "");
        System.out.println(colonyCalc.getPlanetForPerson(tempPerson));
        assertEquals(new Planet("Venus", 2, 1, 4, 4), colonyCalc
            .getPlanetForPerson(tempPerson));
    }


    /**
     * Test planetByNumber method.
     */
    public void testPlanetByNumber() {
        Person compPerson = null;
        assertNull(colonyCalc.getPlanetForPerson(compPerson));
        assertNotNull(colonyCalc.getPlanetForPerson(colonyCalc.getQueue()
            .dequeue()));
        assertNull(colonyCalc.getPlanetForPerson(colonyCalc.getQueue()
            .dequeue()));
    }


    /**
     * Test getPlanetIndex method.
     */
    public void testPlanetIndex() {
        assertEquals(2, colonyCalc.getPlanetIndex("Venus"));
        assertEquals(1, colonyCalc.getPlanetIndex("Mercury"));
    }

}
