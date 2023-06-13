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
 * DataPointTest Class to test the DataPoint class
 * 
 * @author Jason Tran (thejtrann)
 * @author Xinbei Zhu (helen19)
 * @author Anvitha Amumolu (anvithanumolu)
 * @version 11/21/2020
 */
public class DataPointTest extends student.TestCase {
    private DataPoint test;
    private DataPoint test1;
    private DataPoint test2;
    private DataPoint test3;
    private DataPoint test4;

    /**
     * set up
     */
    public void setUp() {
        test = new DataPoint("a", 1000, 200);
        test1 = new DataPoint("b", -1, 100);
        test2 = new DataPoint("c", 100, -1);
        test3 = new DataPoint("d", 0, 100);
        test4 = new DataPoint("e", 1000, 300);
    }


    /**
     * test for getName
     */
    public void testGetName() {
        assertEquals("a", test.getName());
    }


    /**
     * test for getDeaths
     */
    public void testGetDeaths() {
        assertEquals(200.0, test.getDeaths(), 0.1);
    }


    /**
     * test for getCases
     */
    public void testGetCases() {
        assertEquals(1000.0, test.getCases(), 0.1);
    }


    /**
     * test for getCFR
     */
    public void testGetCFR() {
        assertEquals(20.0, test.getCFR(), 0.1);
        assertEquals(-1.0, test1.getCFR(), 0.1);
        assertEquals(-1.0, test2.getCFR(), 0.1);
        assertEquals(-1.0, test3.getCFR(), 0.1);
    }


    /**
     * test for toString
     */
    public void testToString() {
        assertEquals("a: 1000 cases, 20.0% CFR", test.toString());
    }
    
    /**
     * test for compareTo
     */
    public void testCompareTo() {
        DataPoint test5 = new DataPoint("f", 1000, 200);
        assertEquals(1, test.compareTo(test1));
        assertEquals(1, test.compareTo(test2));
        assertEquals(1, test.compareTo(test3));
        assertEquals(-1, test.compareTo(test4));
        assertEquals(5, test.compareTo(test5));
    }
    
}
