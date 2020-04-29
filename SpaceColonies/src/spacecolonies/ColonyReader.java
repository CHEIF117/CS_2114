// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Gunnar Nelson (905956285)
package spacecolonies;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import bsh.ParseException;

/**
 * @author name Gunnar Nelson
 * @version 2020.04.09
 */
public class ColonyReader {
    private Planet[] planets;
    private ArrayQueue<Person> queue;

    /**
     * Here we are testing our ColonyReader class
     * 
     * @param applicantFileName
     *            File name for applicant.
     * @param planetFileName
     *            File name for applicant.
     * @throws SpaceColonyDataException
     * @throws FileNotFoundException
     * @throws ParseException
     */
    @SuppressWarnings("unused")
    public ColonyReader(String applicantFileName, String planetFileName)
        throws FileNotFoundException,
        SpaceColonyDataException,
        ParseException {
        queue = readQueueFile(applicantFileName);
        planets = readPlanetFile(planetFileName);

        SpaceWindow spaceWindow = new SpaceWindow(new ColonyCalculator(queue,
            planets));
    }


    /**
     * This method reads a planet file and returns a planet array.
     * Focusing on agriculature, medical, and technology skills
     * 
     * Finally
     * 
     * @param string
     *            File name to read.
     * @return array of planets from file.
     * @throws FileNotFoundException
     * @throws SpaceColonyDataException
     * @throws ParseException
     */
    private Planet[] readPlanetFile(String string)
        throws FileNotFoundException,
        SpaceColonyDataException,
        ParseException {
        Planet[] planets = new Planet[ColonyCalculator.NUM_PLANETS + 1];
        Scanner kb = new Scanner(new File(string));

        int counter = 1;
        while (counter <= ColonyCalculator.NUM_PLANETS && kb.hasNextLine()) {
            String[] tempArr = kb.nextLine().split(", *");

            if (tempArr.length != 5) {
                kb.close();
                throw new ParseException(
                    "There are not 5 comma separated values on the line");
            }

            int agricultureSkill = Integer.parseInt(tempArr[1]);
            int medicineSkill = Integer.parseInt(tempArr[2]);
            int techonolySkill = Integer.parseInt(tempArr[3]);
            if (!isInSkillRange(agricultureSkill, medicineSkill,
                techonolySkill)) {
                kb.close();
                throw new SpaceColonyDataException(
                    "Skills are not between 1 and 5.");
            }
            Planet tempPlanet = new Planet(tempArr[0], agricultureSkill,
                medicineSkill, techonolySkill, Integer.parseInt(tempArr[4]));

            planets[counter] = tempPlanet;
            counter++;
        }
        kb.close();
        if (counter != ColonyCalculator.NUM_PLANETS + 1) {
            throw new SpaceColonyDataException(
                "There are less than 3 planets.");
        }

        return planets;

    }


    /**
     * Reads person file and returns an ArrayQueue.
     * 
     * @param string
     *            File name to read.
     * @return ArrayQueue of people from file.
     * @throws FileNotFoundException
     * @throws SpaceColonyDataException
     */
    private ArrayQueue<Person> readQueueFile(String string)
        throws FileNotFoundException,
        ParseException,
        SpaceColonyDataException {
        ArrayQueue<Person> persons = new ArrayQueue<Person>();
        Scanner kb = new Scanner(new File(string));

        while (kb.hasNextLine()) {
            String[] tempArr = kb.nextLine().split(", *", -1);

            int agricultureSkill = Integer.parseInt(tempArr[1]);
            int medicineSkill = Integer.parseInt(tempArr[2]);
            int techonolySkill = Integer.parseInt(tempArr[3]);
            if (!isInSkillRange(agricultureSkill, medicineSkill,
                techonolySkill)) {
                kb.close();
                throw new SpaceColonyDataException(
                    "Skills are not between 1 and 5.");
            }
            Person tempPerson = new Person(tempArr[0], agricultureSkill,
                medicineSkill, techonolySkill, tempArr[4]);

            persons.enqueue(tempPerson);

        }
        kb.close();

        return persons;
    }


    /**
     * The isInSkillRange method checks to see the level of skills within the
     * range
     * 
     * @param skills
     *            Skill to check if in range.
     * @return If skill is in range.
     */
    private boolean skillChekcer(int skills) {
        return (skills <= ColonyCalculator.MAX_SKILL_LEVEL)
            && (skills >= ColonyCalculator.MIN_SKILL_LEVEL);
    }


    /**
     * 
     * Checks to see if the integer values for the skills are in range
     * 
     * @param num1
     *            Agriculture skill level.
     * @param num2
     *            Medicine skill level.
     * @param num3
     *            Technology skill level.
     * @return
     */
    private boolean isInSkillRange(int num1, int num2, int num3) {
        return skillChekcer(num1) && skillChekcer(num2) && skillChekcer(num3);
    }

}
