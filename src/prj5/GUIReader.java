// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- helen 19
// -- thejtrann
// -- anvithanumolu
package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * GUIReader Class to read the csv file
 * 
 * @author Jason Tran (thejtrann)
 * @author Xinbei Zhu (helen19)
 * @author Anvitha Amumolu (anvithanumolu)
 * @version 11/21/2020
 */
public class GUIReader {
    private DLList<State> covidStates;

    /**
     * 
     * @param fileName
     *            the csv file
     * @throws FileNotFoundException
     *             if the file is not found
     */
    public GUIReader(String fileName) throws FileNotFoundException {
        this.covidStates = readCovidFile(fileName);

        for (int i = 0; i < covidStates.size(); i++) {
            CovidCalculator sortedAlpha = new CovidCalculator(covidStates.get(
                i));
            CovidCalculator sortedCFR = new CovidCalculator(covidStates.get(i));

            State stateAlpha = sortedAlpha.sortAlpha();
            State stateCFR = sortedCFR.sortCFR();

            /*
             * System.out.println(stateAlpha.getName());
             * System.out.println(stateAlpha.toString());
             * System.out.println(stateCFR.toString());
             */
        }

        GUIWindow window = new GUIWindow(covidStates);
    }


    /**
     * 
     * @param fileName
     *            the file to be read
     * @return
     *         the DLList of six states
     */
    private DLList<State> readCovidFile(String fileName) {
        covidStates = new DLList<State>();

        boolean skipLine = false;

        try {
            Scanner scanner = new Scanner(new File(fileName));

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                String[] values = line.split(",");

                DLList<DataPoint> temp = new DLList<DataPoint>();

                if (skipLine) {

                    DataPoint white = new DataPoint("white", convertValue(
                        values[1]), convertValue(values[6]));
                    DataPoint black = new DataPoint("black", convertValue(
                        values[2]), convertValue(values[7]));
                    DataPoint latinx = new DataPoint("latinx", convertValue(
                        values[3]), convertValue(values[8]));
                    DataPoint asian = new DataPoint("asian", convertValue(
                        values[4]), convertValue(values[9]));
                    DataPoint other = new DataPoint("other", convertValue(
                        values[5]), convertValue(values[10]));

                    temp.add(white);
                    temp.add(black);
                    temp.add(latinx);
                    temp.add(asian);
                    temp.add(other);

                    covidStates.add(new State(temp, values[0]));
                }
                skipLine = true;
            }

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return covidStates;
    }


    /**
     * 
     * @param arg
     *            the String to be converted
     * @return converted to int
     */
    private int convertValue(String arg) {
        if (arg.equals("NA")) {
            return -1;
        }
        else {
            return Integer.valueOf(arg);
        }
    }
}
