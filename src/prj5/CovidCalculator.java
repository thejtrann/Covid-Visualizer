// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Group 152 (Anvitha, Jason, Xinbei)

package prj5;

/**
 * CovidCalculator Class
 * 
 * @author Jason Tran (thejtrann)
 * @author Anvitha Anumolu (anvithanumolu)
 * @author Xinbei Zhu (helen19)
 * 
 * @version 11/10/2020
 */
public class CovidCalculator {

    private State covidState;

    /**
     * Constructor for CovidCalculator
     * 
     * @param state
     *            State holds all the data for each race in that particular
     *            state
     */
    public CovidCalculator(State state) {
        covidState = state;
    }


    /**
     * Outputs State object with sorted CFR data (highest -> lowest)
     * 
     * @return state object with sorted CFR
     */
    public State sortCFR() {
        DLList<DataPoint> ans = new DLList<DataPoint>();
        DataPoint[] temp = new DataPoint[4];

        DataPoint asian = covidState.getAsian();
        DataPoint black = covidState.getBlack();
        DataPoint latinx = covidState.getLatinx();
        DataPoint other = covidState.getOther();
        DataPoint white = covidState.getWhite();

        temp[0] = latinx;
        temp[1] = other;
        temp[2] = white;

        if (asian.compareTo(black) > 0) {
            ans.add(asian);
            ans.add(black);
        }
        else if (asian.compareTo(black) < 0) {
            ans.add(black);
            ans.add(asian);
        }

        int index = 0;

        while (ans.size() != 5) {

            for (int i = 0; i < ans.size(); i++) {
                if (ans.get(i).compareTo(temp[index]) < 0 && i == 0) {
                    ans.add(0, temp[index]);
                    break;
                }
                if (ans.get(i).compareTo(temp[index]) > 0 && i == ans.size()
                    - 1) {
                    ans.add(temp[index]);
                    break;
                }
                if (ans.get(i).compareTo(temp[index]) > 0 && ans.get(i + 1)
                    .compareTo(temp[index]) < 0) {
                    ans.add(i + 1, temp[index]);
                    break;
                }
            }
            index++;
        }
        return new State(ans, covidState.getName());
    }


    /**
     * Outputs State object sorted Alphabetically by race
     * 
     * @return state object with sorted Alpha
     */
    public State sortAlpha() {

        DLList<DataPoint> info = new DLList<DataPoint>();
        info.add(covidState.getAsian());
        info.add(covidState.getBlack());
        info.add(covidState.getLatinx());
        info.add(covidState.getOther());
        info.add(covidState.getWhite());

        return new State(info, covidState.getName());
    }
}
