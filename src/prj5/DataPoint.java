// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Group 152 (Anvitha, Jason, Xinbei)

package prj5;

/**
 * DataPoint class that create a datapoint object and its functionalities.
 * 
 * @author Jason Tran (thejtrann)
 * @author Anvitha Anumolu (anvithanumolu)
 * @author Xinbei Zhu (helen19)
 * 
 * @version 11/21/2020
 */
public class DataPoint {
    private String name;
    private int cases;
    private double deaths;
    private double cfr;

    /**
     * 
     * @param name
     *            the name of this race
     * @param cases
     *            the covid-19 cases among this race
     * @param deaths
     *            the deaths due to covid-19 ammong this race
     */
    public DataPoint(String name, int cases, int deaths) {
        this.name = name;
        this.cases = cases;
        this.deaths = deaths;
        if (cases == -1 || deaths == -1) {
            this.cfr = -1.0;
        }
        else {
            this.cfr = (this.deaths / this.cases) * 100;
            this.cfr = Math.round(cfr * 10.0) / 10.0;
        }
    }


    /**
     * @return the name of the race
     */
    public String getName() {
        return this.name;
    }


    /**
     * 
     * @return the deaths in this race
     */
    public double getDeaths() {
        return this.deaths;
    }


    /**
     * 
     * @return the cases among this race
     */
    public int getCases() {
        return this.cases;
    }


    /**
     * 
     * @return the CFR in this race
     */
    public double getCFR() {
        if (this.getCases() != 0) {
            return this.cfr;
        }
        return -1.0;

    }


    /**
     *
     * @return String type of the covid-19 information of this race
     */
    public String toString() {
        StringBuilder ans = new StringBuilder();
        ans.append(name);
        ans.append(": ");
        ans.append(cases);
        ans.append(" cases, ");
        ans.append(cfr);
        ans.append("% CFR");
        return ans.toString();
    }


    /**
     * 
     * @param other
     *            the other object to be compared
     * 
     * @return int value of comparison
     */
    public int compareTo(DataPoint other) {
        if (this.getCFR() > other.getCFR()) {
            return 1;
        }
        else if (this.getCFR() < other.getCFR()) {
            return -1;
        }
        return other.getName().compareTo(this.getName());
    }
}
