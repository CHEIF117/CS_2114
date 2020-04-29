// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Gunnar Nelson (905956285)
package spacecolonies;

/**
 * @author name Gunnar Nelson
 * @version 2020.04.15
 * 
 *          Here we are setting up our Planet class
 *          and instantiating our fields of name, minSkills
 *          populationSize, and capacity
 */

public class Planet implements Comparable<Planet> {
    private String name;
    private Skills minSkills;
    private Person[] population;
    private int populationSize;
    private final int capacity;

    /**
     * Here we creating a new planet object.
     * 
     * @param planetName
     *            Name of planet.
     * @param planetAgri
     *            Minimum skill level required in agriculture.
     * @param planetMedi
     *            Minimum skill level required in medicine.
     * @param planetTech
     *            Minimum skill level required in technology.
     * @param planetCap
     *            Planet capacity.
     */
    public Planet(
        String planetName,
        int planetAgri,
        int planetMedi,
        int planetTech,
        int planetCap) {

        name = planetName;
        minSkills = new Skills(planetAgri, planetMedi, planetTech);
        population = new Person[planetCap];
        capacity = planetCap;
    }


    /**
     * Public class to set up name
     * 
     * @param name
     *            New name for planet.
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Outputs name of planet.
     * 
     * @return name of this planet.
     */
    public String getName() {
        return name;
    }


    /**
     * Returns minimum skill levels for this planet.
     * 
     * @return minimum skill levels for this planet.
     */
    public Skills getSkills() {
        return minSkills;
    }


    /**
     * Returns population of planet.
     * 
     * @return population of planet.
     */
    public Person[] getPopulation() {
        return population;
    }


    /**
     * Returns population size of planet.
     * 
     * @return population size of planet.
     */
    public int getPopulationSize() {
        return populationSize;
    }


    /**
     * Returns capacity of planet.
     * 
     * @return capacity of planet.
     */
    public int getCapacity() {
        return capacity;
    }


    /**
     * Returns number of available places left in the planet.
     * 
     * @return number of available places left in the planet.
     */
    public int getAvailability() {
        return capacity - populationSize;
    }


    /**
     * Returns true if the planet’s population has reached max capacity.
     * 
     * @return whether he planet’s population has reached max capacity.
     */
    public boolean isFull() {
        return populationSize >= capacity;
    }


    /**
     * Attempts to add a Person to the Planet.
     * 
     * @param newbie
     *            The applicant to the planet.
     * @return whether person can be added.
     */
    public boolean addPerson(Person newbie) {
        if (isQualified(newbie) && !isFull()) {
            population[populationSize] = newbie;
            populationSize += 1;
            return true;
        }
        return false;
    }


    /**
     * Helper method to see if person is qualified to live on planet.
     * 
     * @return whether applicant is qualified to live on planet.
     * @param newbie
     *            The applicant to the planet.
     * 
     */
    public boolean isQualified(Person newbie) {
        return getSkills().isBelow(newbie.getSkills());
    }


    /**
     * Our toString method outputs our string with population, population
     * size, capacity, and skill level for planet
     * 
     * @return string representation of our planet.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (name.length() > 0) {
            sb.append(name + ", population " + populationSize + " (cap: "
                + capacity + ")");
        }
        else {
            sb.append("population " + populationSize + " (cap: " + capacity
                + ")");
        }
        sb.append(", Requires: A >= " + minSkills.getAgriculture() + ", "
            + "M >= " + minSkills.getMedicine() + ", " + "T >= " + minSkills
                .getTechnology());
        return sb.toString();
    }


    /**
     * Compares planets by available spots. A planet with more spots will be
     * greater than one with less spots.
     * 
     * @param other
     *            Other planet to be compared to.
     * @return 0 if availability is equal, 1 if other availability is greater,
     *         and -1
     *         if other availability is greater
     */
    public int compareTo(Planet other) {
        if (getAvailability() == other.getAvailability()) {
            return 0;
        }
        else if (getAvailability() > other.getAvailability()) {
            return 1;
        }
        return -1;
    }


    /**
     * Our equals method compares our current planet object to another object.
     * 
     * @param obj
     *            Object to be compared to this.
     * @return whether of not the two objects are equal
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        if (this.getClass() == obj.getClass()) {
            Planet otherPlanet = (Planet)obj;
            return name.equals(otherPlanet.getName()) && minSkills.equals(
                otherPlanet.getSkills()) && populationSize == otherPlanet
                    .getPopulationSize() && capacity == otherPlanet
                        .getCapacity();
        }
        return false;
    }
}
