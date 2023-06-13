// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- helen 19
// -- thejtrann
// -- anvithanumolu
package prj5;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Iterator;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

/**
 * GUIWindow class that provides the front-end of the project.
 * 
 * @author Jason Tran (thejtrann)
 * @author Xinbei Zhu (helen19)
 * @author Anvitha Amumolu (anvithanumolu)
 * @version 12/1/2020
 */
public class GUIWindow {

    // creating fields in order to initialize and utilize later
    private Window window;
    private Button quit;
    private Button sortByAlpha;
    private Button sortByCFR;
    private Button representDC;
    private Button representGA;
    private Button representMD;
    private Button representNC;
    private Button representTN;
    private Button representVA;

    private static final int WIN_WIDTH = 850;
    private static final int WIN_HEIGHT = 600;
    private static final int NBARS = 5;
    private static final int BAR_WIDTH = 20;
    private static final int[] BAR_X = { WIN_WIDTH / (NBARS + 1), WIN_WIDTH
        / (NBARS + 1) * 2, WIN_WIDTH / (NBARS + 1) * 3, WIN_WIDTH / (NBARS + 1)
            * 4, WIN_WIDTH / (NBARS + 1) * 5 };
    private static final int BAR_Y = WIN_HEIGHT - 250;
    private static final int HEIGHT_FACTOR = 30;

    DecimalFormat df;
    DLList<DataPoint> races;
    Iterator<DataPoint> raceIterator;

    private int sortType = 0;
    private DLList<State> states;
    private State stateGraph;

    /**
     * Constructor that represents a GUIWindow.
     */
    public GUIWindow(DLList<State> stateData) {

        states = stateData;
        stateGraph = null;
        df = new DecimalFormat("###.#");

        // initializing the window
        window = new Window("anvithanumolu thejtrann helen19");
        window.setSize(800, 800);

        // initializing the buttons

        sortByAlpha = new Button("Sort by Alpha");
        sortByAlpha.onClick(this, "clickedSortByAlpha");
        window.addButton(sortByAlpha, WindowSide.NORTH);

        quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");
        window.addButton(quit, WindowSide.NORTH);

        sortByCFR = new Button("Sort by CFR");
        sortByCFR.onClick(this, "clickedSortByCFR");
        window.addButton(sortByCFR, WindowSide.NORTH);

        representDC = new Button("Represent DC");
        representDC.onClick(this, "clickedRepresentDC");
        window.addButton(representDC, WindowSide.SOUTH);

        representGA = new Button("Represent GA");
        representGA.onClick(this, "clickedRepresentGA");
        window.addButton(representGA, WindowSide.SOUTH);

        representMD = new Button("Represent MD");
        representMD.onClick(this, "clickedRepresentMD");
        window.addButton(representMD, WindowSide.SOUTH);

        representNC = new Button("Represent NC");
        representNC.onClick(this, "clickedRepresentNC");
        window.addButton(representNC, WindowSide.SOUTH);

        representTN = new Button("Represent TN");
        representTN.onClick(this, "clickedRepresentTN");
        window.addButton(representTN, WindowSide.SOUTH);

        representVA = new Button("Represent VA");
        representVA.onClick(this, "clickedRepresentVA");
        window.addButton(representVA, WindowSide.SOUTH);
    }


    /**
     * Method that supports the "quit" button.
     */
    public void clickedQuit() {
        System.exit(0);
    }


    /**
     * Method that supports the "sortByAlpha" button.
     */
    public void clickedSortByAlpha(Button button) {
        window.removeAllShapes();

        if (stateGraph == null) {
            sortType = 1;
        }
        else {
            sortType = 1;
            updateGraphTitle(stateGraph.getName());
            CovidCalculator temp = new CovidCalculator(stateGraph);
            State sortedTemp = temp.sortAlpha();

            showRaces(sortedTemp.getInfo());
        }
    }


    /**
     * Method that supports the "sortByCFR" button.
     */
    public void clickedSortByCFR(Button button) {
        window.removeAllShapes();

        if (stateGraph == null) {
            sortType = 0;
        }
        else {
            sortType = 0;
            updateGraphTitle(stateGraph.getName());
            CovidCalculator temp = new CovidCalculator(stateGraph);
            State sortedTemp = temp.sortCFR();

            showRaces(sortedTemp.getInfo());
        }
    }


    /**
     * Method that supports the "representDC" button.
     * 
     * @param button
     */
    public void clickedRepresentDC(Button button) {
        // reaching data from back-end
        // GUIReader reader = new GUIReader()
        clickedRep(states.get(0));
    }


    /**
     * Method that supports the "representGA" button.
     */
    public void clickedRepresentGA(Button button) {
        clickedRep(states.get(1));
    }


    /**
     * Method that supports the "representMD" button.
     */
    public void clickedRepresentMD(Button button) {
        clickedRep(states.get(2));
    }


    /**
     * Method that supports the "representNC" button.
     */
    public void clickedRepresentNC(Button button) {
        clickedRep(states.get(3));
    }


    /**
     * Method that supports the "representTN" button.
     */
    public void clickedRepresentTN(Button button) {
        clickedRep(states.get(4));
    }


    /**
     * Method that supports the "representVA" button.
     */
    public void clickedRepresentVA(Button button) {
        clickedRep(states.get(5));
    }


    /**
     * Changes the title of the graph based on which state is being viewed
     * 
     * @param name
     *            name of state
     */
    public void updateGraphTitle(String name) {
        TextShape title = new TextShape(0, 25, name
            + " Case Fatality Ratios By Race");
        title.setX(window.getWidth() / 2 - title.getWidth() / 2);
        window.addShape(title);
    }


    /**
     * Helper method that iterates over the race data and outputs it onto the
     * window
     * 
     * @param raceData
     *            Double-Linked-List that holds the data for the given state
     */
    private void showRaces(DLList<DataPoint> raceData) {
        raceIterator = raceData.iterator();
        int i = 0;
        while (raceIterator.hasNext()) {
            DataPoint curr = raceIterator.next();
            window.addShape(makeBar(i, curr.getCFR()));
            window.addShape(new TextShape(BAR_X[i], BAR_Y + 10, curr
                .getName()));
            window.addShape(new TextShape(BAR_X[i], BAR_Y + 40, String.valueOf(
                df.format(curr.getCFR()) + "%")));
            i++;
        }
    }


    /**
     * Creates the bar shape for the graph
     * 
     * @param index
     *            Determines position of bar based on index value
     * @param CFR
     * @return Bar shape with height based on CFR
     */
    public Shape makeBar(int index, double CFR) {
        if (CFR > 0) {
            int height = (int)(CFR * HEIGHT_FACTOR);
            return new Shape(BAR_X[index], BAR_Y - height, BAR_WIDTH, height,
                Color.BLUE);
        }
        else {
            return new TextShape(BAR_X[index], BAR_Y - 10, "NA");
        }
    }


    /**
     * Helper method for Represent state buttons
     * 
     * @param givenState
     */
    public void clickedRep(State givenState) {
        window.removeAllShapes();
        stateGraph = givenState;
        updateGraphTitle(givenState.getName());

        if (sortType == 0) {
            CovidCalculator temp = new CovidCalculator(stateGraph);
            State sortedTemp = temp.sortCFR();
            showRaces(sortedTemp.getInfo());
        }
        else {
            CovidCalculator temp = new CovidCalculator(stateGraph);
            State sortedTemp = temp.sortAlpha();
            showRaces(sortedTemp.getInfo());
        }
    }

}
