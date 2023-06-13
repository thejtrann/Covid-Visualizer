// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- helen 19
// -- thejtrann
// -- anvithanumolu
package prj5;

import student.TestCase;

/**
 * Tests for CovidCalculator class
 * 
 * @author Jason Tran (thejtrann)
 * @author Anvitha Anumolu (anvithanumolu)
 * @author Xinbei Zhu (helen19)
 * 
 * @version 11/21/2020
 */
public class CovidCalculatorTest extends TestCase {
    private CovidCalculator testCFR;
    private CovidCalculator testCFR2;

    private CovidCalculator testAlpha;

    /**
     * Setup test variables for test methods
     */
    public void setUp() {

        DataPoint asian = new DataPoint("asian", 5407, 254);
        DataPoint black = new DataPoint("black", 179563, 13365);
        DataPoint latinx = new DataPoint("latinx", 97118, 2269);
        DataPoint other = new DataPoint("other", 108784, 170);
        DataPoint white = new DataPoint("white", 70678, 1924);

        DataPoint asian2 = new DataPoint("asian", 179563, 13365);
        DataPoint black2 = new DataPoint("black", 5407, 254);
        DataPoint latinx2 = new DataPoint("latinx", 25000, 2500);

        DLList<DataPoint> temp = new DLList<DataPoint>();
        temp.add(white);
        temp.add(black);
        temp.add(latinx);
        temp.add(asian);
        temp.add(other);

        DLList<DataPoint> temp2 = new DLList<DataPoint>();
        temp2.add(white);
        temp2.add(black2);
        temp2.add(latinx2);
        temp2.add(asian2);
        temp2.add(other);

        State testState = new State(temp, "DC");
        State testState2 = new State(temp2, "DC");

        testCFR = new CovidCalculator(testState);
        testAlpha = new CovidCalculator(testState);

        testCFR2 = new CovidCalculator(testState2);
    }


    /**
     * Test method for sortCFR
     */
    public void testSortCFR() {
        String ans = "black: 179563 cases, 7.4% CFR\r\n"
            + "asian: 5407 cases, 4.7% CFR\r\n"
            + "white: 70678 cases, 2.7% CFR\r\n"
            + "latinx: 97118 cases, 2.3% CFR\r\n"
            + "other: 108784 cases, 0.2% CFR\r\n" + "=====";

        String ans2 = "latinx: 25000 cases, 10% CFR\r\n"
            + "asian: 179563 cases, 7.4% CFR\r\n"
            + "black: 5407 cases, 4.7% CFR\r\n"
            + "white: 70678 cases, 2.7% CFR\r\n"
            + "other: 108784 cases, 0.2% CFR\r\n" + "=====";

        assertEquals(ans, testCFR.sortCFR().toString());
        assertEquals(ans2, testCFR2.sortCFR().toString());
    }


    /**
     * Test method for sortAlpha
     */
    public void testSortAlpha() {
        String ans = "asian: 5407 cases, 4.7% CFR\r\n"
            + "black: 179563 cases, 7.4% CFR\r\n"
            + "latinx: 97118 cases, 2.3% CFR\r\n"
            + "other: 108784 cases, 0.2% CFR\r\n"
            + "white: 70678 cases, 2.7% CFR\r\n" + "=====";
        assertEquals(ans, testAlpha.sortAlpha().toString());
    }
}

