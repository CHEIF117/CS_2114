// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Gunnar Nelson (905956285)
package spacecolonies;

/**
 * 
 * @author name Gunnar Nelson
 * @version 2020.04.15
 * 
 *          This is our Skills class
 * 
 */

public class Skills {

    private int agriculture;
    private int medicine;
    private int technology;

    /**
     * Creates new Skill objects.
     * We will have three in this case
     * One for Ag, Med, and Tech
     * 
     * @param ag
     *            agriculture skill level.
     * 
     * @param med
     *            medicine skill level.
     * @param tech
     *            technology skill level.
     */
    public Skills(int ag, int med, int tech) {
        agriculture = ag;
        medicine = med;
        technology = tech;
    }


    /**
     * We allow other classes to interact with ag's value
     * 
     * @return ag value.
     */
    public int getAgriculture() {
        return agriculture;
    }


    /**
     * We allow other classes to interact with med's value
     * 
     * @return med value.
     */
    public int getMedicine() {
        return medicine;
    }


    /**
     * AWe allow other classes to interact with tech's value
     * 
     * @return tech value.
     */
    public int getTechnology() {
        return technology;
    }


    /**
     * Checks if this skill object has lower skill levels than another object.
     * 
     * @param other
     *            Skill object to compare this to.
     * @return whether of not this has lower values for all of the fields
     *         compared to other.
     */
    public boolean isBelow(Skills other) {
        return agriculture <= other.getAgriculture() && medicine <= other
            .getMedicine() && technology <= other.getTechnology();
    }


    /**
     * Our toString method showcasing our string
     * 
     * @return string representation of this object.
     */
    public String toString() {
        return "A:" + agriculture + " M:" + medicine + " T:" + technology;
    }


    /**
     * Equals method compares object to another object
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
            Skills otherSkill = (Skills)obj;

            return this.getAgriculture() == otherSkill.getAgriculture() && this
                .getMedicine() == otherSkill.getMedicine() && this
                    .getTechnology() == otherSkill.getTechnology();
        }
        return false;

    }

}
