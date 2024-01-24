package gameboard;/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2021
 * Instructor: Prof. Chris Dancy
 *
 * Name: Nguyen Nguyen
 * Section: Section 02 - 1:50-2:42am
 * Date: 5/12/2021
 * Time: 6:42 PM
 *
 * Project: CSCI205SP21finalproject
 * Package: PACKAGE_NAME
 * Class: gameboard.BabaIsYouGameGUIView
 *
 * Description: THIS IS A DESCRIPTION Y’ALL AND I NEED TO CHANGE THIS!
 *
 * ****************************************
 */

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

public class BabaIsYouGameGUIView {
    /** The width of the board */
    private static final int WIDTH = 800;
    /** The height of the board */
    private static final int HEIGHT = 600;
    /** The number of rows of the board */
    private static final int ROWS = 40;
    /** The number of columns of the board */
    private static final int COLUMNS = 40;
    /** The size of a square */
    private static final int SQUARE_SIZE = WIDTH/ROWS;



    /** Graphics for game */
    private GraphicsContext gc;
    /** The character as a Point object */
    private Point character = new Point(0,0);


    /** The root */
    private static Group root;
    /** The in-game layout */
    private static Canvas canvas;
    /** The in-game scene */
    protected static Scene scene;
    private BabaIsYouGameGUIModel theModel;


    /**
     * Loads up the Game GUI into the given model
     * @param theModel  BabaIsYouGameGUIModel object to be manipulated.
     */
    public BabaIsYouGameGUIView(BabaIsYouGameGUIModel theModel){
        this.theModel = new BabaIsYouGameGUIModel();
        //Setting up the screen...
        root = new Group();
        canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);

        //Initiate the graphic context gc
        gc = canvas.getGraphicsContext2D();
    }


    public Group getRoot() {
        return root;
    }

    public GraphicsContext getGc() {
        return gc;
    }

    public Scene getScene() {
        return scene;
    }
}
