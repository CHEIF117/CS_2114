// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Gunnar Nelson (905956285)
package spacecolonies;

import java.util.ArrayList;
import java.util.Collections;
import list.AList;

/**
 * @author name Gunnar Nelson
 * @version 2019.11.09
 * 
 * 
 *          Here we are creating our ColonyCalculator class
 *          which includes number of planets, min & max skills,
 *          and fields for applicants and rejectbus
 * 
 */
public class ColonyCalculator {
    /**
     * This is the number of planets
     */
    public static final int NUM_PLANETS = 3;
    /**
     * This is the number of min skills
     */
    public static final int MIN_SKILL_LEVEL = 1;
    /**
     * This is the number of planets
     */
    public static final int MAX_SKILL_LEVEL = 5;
    private ArrayQueue<Person> applicantQueue;
    private AList<Person> rejectBus;
    private static Planet[] planets = new Planet[NUM_PLANETS + 1];

    /**
     * Here we are creating our new ColonyCalculator object.
     * 
     * @param persons
     *            Persons to be added to planet.
     * @param planets
     *            Planets to add persons to.
     * @throws IllegalArgumentException
     *             If arrayqueue of people is null.
     */
    public ColonyCalculator(ArrayQueue<Person> persons, Planet[] planets) {
        if (persons == null) {
            throw new IllegalArgumentException("ArrayQueue of people is null.");
        }

        applicantQueue = persons;
        ColonyCalculator.planets = planets;
        rejectBus = new AList<Person>();
    }


    /**
     * Returns applicationQueue ArrayQueue.
     * 
     * @return applicationQueue ArrayQueue.
     */
    public ArrayQueue<Person> getQueue() {
        return applicantQueue;
    }


    /**
     * Returns planets array.
     * 
     * @return static planets array.
     */
    public static Planet[] getPlanets() {
        return planets;
    }


    /**
     * Determines if the next person can be accepted to a planet based on
     * skills.
     * 
     * @param nextPerson
     *            Person for planet.
     * @return null if the person cannot be added to any planet,
     *         then checks to see if the next person is available
     */
    public Planet getPlanetForPerson(Person nextPerson) {
        if (nextPerson == null || applicantQueue.isEmpty()) {
            return null;
        }
        return getMostAvailablePlanet(nextPerson);
    }


    /**
     * Checks to see if a person will be added to an available planet.
     * 
     * @param person
     *            Person to be checked.
     * @return Planet which person can be added to or null if no
     *         planet available
     */
    private Planet getMostAvailablePlanet(Person person) {
        ArrayList<Planet> copyPlanets = new ArrayList<Planet>();
        for (int i = 0; i < planets.length; i++) {
            if (planets[i] != null) {
                copyPlanets.add(planets[i]);
            }
        }

        Collections.sort(copyPlanets);
        copyPlanets.add(0, null);
        boolean qualified = false;
        Planet highest = copyPlanets.get(1);
        for (int i = 0; i < NUM_PLANETS + 1; i++) {
            Planet currentPerson = copyPlanets.get(i);
            if (currentPerson != null && currentPerson.isQualified(person)
                && !currentPerson.isFull() && currentPerson.compareTo(
                    highest) >= 0) {
                qualified = true;
                highest = currentPerson;
            }
        }
        if (qualified) {
            return highest;
        }
        else {
            return null;
        }
    }


    /**
     * This method is suppose to accept a person
     * 
     * @return boolean value if false then person not added.
     *         If true, the person is then added to the planet
     */
    public boolean accept() {
        if (!applicantQueue.isEmpty()) {
            Person p = applicantQueue.getFront();
            Planet send = getPlanetForPerson(p);
            if (send == null) {
                return false;
            }
            send.addPerson(p);
            applicantQueue.dequeue();
            return true;
        }
        return false;
    }


    /**
     * Rejects person if person doesn't have skills for planet, and puts them in
     * rejectBus.
     */
    public void reject() {
        if (!applicantQueue.isEmpty()) {
            Person p = applicantQueue.getFront();
            applicantQueue.dequeue();

            rejectBus.add(p);
        }

    }


    /**
     * Retrieves planet index.
     * 
     * @param index
     *            Index of the planet.
     * @return Planet at the index.
     */
    public Planet planetByNumber(int index) {
        return (index >= 1 && index <= 3) ? planets[index] : null;
    }


    /**
     * Returns index of planet by name via string
     * 
     * @param string
     *            Name of planet being indexed.
     * @return index of planet if it exist, otherwise 0.
     */
    public int getPlanetIndex(String string) {
        for (int i = 1; i < planets.length; i++) {
            if (planets[i].getName().equals(string)) {
                return i;
            }
        }
        return 0;
    }

}
