// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Gunnar Nelson (905956285)
package spacecolonies;

/**
 * @author name Gunnar Nelson
 * @version 2020.04.16
 *          Person class representing the a given person and their attributes.
 */

public class Person {
    private String name;
    private Skills skills;
    private String planetPreference;

    /**
     * Creates new Person object.
     * 
     * @param name
     *            Name of person.
     * @param agri
     *            Person's agriculture skill level
     * @param medi
     *            Person's medicine skill level
     * @param tech
     *            Person's technology skill level
     * @param planet
     *            Person's preferred planet.
     */
    public Person(String name, int agri, int medi, int tech, String planet) {
        this.name = name;
        this.skills = new Skills(agri, medi, tech);
        if (planet.equals("nowhere")) {
            this.planetPreference = "";
        }
        else {
            this.planetPreference = planet;
        }
    }


    /**
     * Allows other classes to get name's value.
     * 
     * @return name of person.
     */
    public String getName() {
        return name;
    }


    /**
     * Allows other classes to get skills value.
     * 
     * @return skill levels of person.
     */
    public Skills getSkills() {
        return skills;
    }


    /**
     * Allows other classes to get planetPreference value.
     * 
     * @return Planet preference of person
     */
    public String getPlanetName() {
        return planetPreference;
    }


    /**
     * The toString method outputs our string value with planetPreference
     * 
     * @return string representation of this object.
     */
    public String toString() {
        if (planetPreference.length() > 0) {
            return name + " " + skills + " Wants: " + planetPreference;
        }
        return "No-Planet " + name + " " + skills;
    }


    /**
     * Compares this object to another object.
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
            Person otherPerson = (Person)obj;

            return this.getName().equals(otherPerson.getName()) && this
                .getSkills().equals(otherPerson.getSkills()) && this
                    .getPlanetName().equals(otherPerson.getPlanetName());
        }
        return false;

    }

}
