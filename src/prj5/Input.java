// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- helen 19
// -- thejtrann
// -- anvithanumolu
package prj5;

import java.io.FileNotFoundException;

/**
 * Input class which runs the program
 * 
 * @author Jason Tran (thejtrann)
 * @author Xinbei Zhu (helen19)
 * @author Anvitha Amumolu (anvithanumolu)
 * @version 11/21/2020
 */
public class Input {

    /**
     * Constructor
     */
    public Input() {
        // nothing here

    }


    /**
     * main method
     * 
     * @param args
     *            the csv file
     * @throws FileNotFoundException
     *             if the file is not found
     */
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 0) {
            GUIReader reader = new GUIReader(args[0]);
        }
        else {
            GUIReader reader = new GUIReader(
                "C:\\Users\\thejt\\eclipse-workspace\\project5\\src\\prj5\\Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        }
    }
}
