package groceries;

import java.io.*;
import java.util.Scanner;

/**
 * Practice reading and writing to a file.
 * 
 * @author Megan Rigsbee (mrigsbee0
 * @version 2015.03.24
 */
public class FileIO {
    /**
     * Reads groceries from a file and adds them to a GroceryBag object,
     * the writes the groceries back to a file using GroceryBag's
     * toString method.
     * 
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {
        try {
            GroceryBag bag = new GroceryBag();
            File file = new File("grocerylist.txt");
            Scanner s = new Scanner(file);
            s.hasNext();
            while (s.hasNext()) {
                String nxt = s.next();
                bag.add(nxt);
            }
            s.close();
            PrintWriter printing = new PrintWriter("output.txt");
            printing.print(bag.toString());
            printing.close();

        }
        catch (FileNotFoundException e) {
            System.out.println("Scanner error opening the file ");
            System.out.println(e.getMessage());
        }

    }
}
