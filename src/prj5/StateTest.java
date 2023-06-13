// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- helen 19
// -- thejtrann
// -- anvithanumolu
package prj5;

/**
 * StateTest Class to test the State class
 * 
 * @author Jason Tran (thejtrann)
 * @author Xinbei Zhu (helen19)
 * @author Anvitha Amumolu (anvithanumolu)
 * @version 11/21/2020
 */

public class StateTest extends student.TestCase {
    private DataPoint white;
    private DataPoint black;
    private DataPoint latinx;
    private DataPoint asian;
    private DataPoint other;

    

    private State state;

    /**
     * set up
     */
    public void setUp() {
        DLList<DataPoint> stateInfo = new DLList<DataPoint>() ;
        white = new DataPoint("white", 200, 100);
        black = new DataPoint("black", 200, 100);
        latinx = new DataPoint("latinx", 200, 100);
        asian = new DataPoint("asian", 200, 100);
        other = new DataPoint("other", 200, 100);
        stateInfo = new DLList<DataPoint>();
        stateInfo.add(white);
        stateInfo.add(black);
        stateInfo.add(latinx);
        stateInfo.add(asian);
        stateInfo.add(other);
        state = new State(stateInfo, "DC");
    }


    /**
     * test for getName
     */
    public void testGetName() {
        assertEquals("DC", state.getName());
    }


    /**
     * test for getWhite
     */
    public void testGetWhite() {
        assertEquals(white, state.getWhite());
    }


    /**
     * test for getBlack
     */
    public void testGetBlack() {
        assertEquals(black, state.getBlack());
    }


    /**
     * test for getLatinx
     */
    public void testGetLatinx() {
        assertEquals(latinx, state.getLatinx());
    }


    /**
     * test for getAsian
     */
    public void testGetAsian() {
        assertEquals(asian, state.getAsian());
    }


    /**
     * test for getOther
     */
    public void testGetOther() {
        assertEquals(other, state.getOther());
    }

    /**
     * test for toString
     */
    public void testToString() {
        DataPoint whiteNew = new DataPoint("white", 1000, 234);
        DLList<DataPoint> stateInfoNew = new DLList<DataPoint>();
        stateInfoNew.add(whiteNew);
        stateInfoNew.add(black);
        stateInfoNew.add(latinx);
        stateInfoNew.add(asian);
        stateInfoNew.add(other);
        State state1 = new State(stateInfoNew, "state1");
        
        assertEquals("white: 200 cases, 50% CFR\r\n" + 
            "black: 200 cases, 50% CFR\r\n" + 
            "latinx: 200 cases, 50% CFR\r\n" + 
            "asian: 200 cases, 50% CFR\r\n" + 
            "other: 200 cases, 50% CFR\r\n" + 
            "=====", state.toString());
        assertEquals("white: 1000 cases, 23.4% CFR\r\n" + 
            "black: 200 cases, 50% CFR\r\n" + 
            "latinx: 200 cases, 50% CFR\r\n" + 
            "asian: 200 cases, 50% CFR\r\n" + 
            "other: 200 cases, 50% CFR\r\n" + 
            "=====", state1.toString());
    }
}
