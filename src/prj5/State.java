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
 * State Class to store the information of the state
 * 
 * @author Jason Tran (thejtrann)
 * @author Xinbei Zhu (helen19)
 * @author Anvitha Amumolu (anvithanumolu)
 * @version 11/21/2020
 */
public class State {
    private DLList<DataPoint> stateInfo;
    private String name;

    /**
     * 
     * @param stateInfo
     *            the DLList stores the information of the state
     * @param name
     *            the name of the state
     */
    public State(DLList<DataPoint> stateInfo, String name) {
        this.stateInfo = stateInfo;
        this.name = name;

    }


    /**
     * 
     * @return the name of the state
     */
    public String getName() {
        return name;
    }


    /**
     * 
     * @return the covid-19 situation of White
     */
    public DataPoint getWhite() {
        return stateInfo.get(0);
    }


    /**
     * 
     * @return the covid-19 situation of Black
     */
    public DataPoint getBlack() {
        return stateInfo.get(1);
    }


    /**
     * 
     * @return the covid-19 situation of Asian
     */
    public DataPoint getAsian() {
        return stateInfo.get(3);
    }


    /**
     * 
     * @return the covid-19 situation of Latin
     */
    public DataPoint getLatinx() {
        return stateInfo.get(2);
    }


    /**
     * 
     * @return the covid-19 situation of other races
     */
    public DataPoint getOther() {
        return stateInfo.get(4);
    }


    /**
     * 
     * @return the stateInfo variable
     */
    public DLList<DataPoint> getInfo() {
        return stateInfo;
    }


    /**
     * @return String of the covid-19 information of the state
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        boolean isWhole = false;

        for (int i = 0; i < stateInfo.size(); i++) {
            int tempCases = ((int)stateInfo.get(i).getCases());

            if (stateInfo.get(i).getCFR() % 1.0 == 0) {
                isWhole = true;
            }

            if (!isWhole) {

                if (stateInfo.get(i).getName().equals("asian")) {
                    str.append("asian: " + tempCases + " cases, " + stateInfo
                        .get(i).getCFR() + "% CFR" + "\n");
                }
                if (stateInfo.get(i).getName().equals("black")) {
                    str.append("black: " + tempCases + " cases, " + stateInfo
                        .get(i).getCFR() + "% CFR" + "\n");
                }
                if (stateInfo.get(i).getName().equals("latinx")) {
                    str.append("latinx: " + tempCases + " cases, " + stateInfo
                        .get(i).getCFR() + "% CFR" + "\n");
                }
                if (stateInfo.get(i).getName().equals("other")) {
                    str.append("other: " + tempCases + " cases, " + stateInfo
                        .get(i).getCFR() + "% CFR" + "\n");
                }
                if (stateInfo.get(i).getName().equals("white")) {
                    str.append("white: " + tempCases + " cases, " + stateInfo
                        .get(i).getCFR() + "% CFR" + "\n");
                }
            }
            else {
                int tempCFR = ((int)stateInfo.get(i).getCFR());
                if (stateInfo.get(i).getName().equals("asian")) {
                    str.append("asian: " + tempCases + " cases, " + tempCFR
                        + "% CFR" + "\n");
                }
                if (stateInfo.get(i).getName().equals("black")) {
                    str.append("black: " + tempCases + " cases, " + tempCFR
                        + "% CFR" + "\n");
                }
                if (stateInfo.get(i).getName().equals("latinx")) {
                    str.append("latinx: " + tempCases + " cases, " + tempCFR
                        + "% CFR" + "\n");
                }
                if (stateInfo.get(i).getName().equals("other")) {
                    str.append("other: " + tempCases + " cases, " + tempCFR
                        + "% CFR" + "\n");
                }
                if (stateInfo.get(i).getName().equals("white")) {
                    str.append("white: " + tempCases + " cases, " + tempCFR
                        + "% CFR" + "\n");
                }
            }
            isWhole = false;
        }
        str.append("=====");
        return str.toString();
    }

}
