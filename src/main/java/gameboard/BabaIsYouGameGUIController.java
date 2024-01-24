package gameboard;/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2021
 * Instructor: Prof. Chris Dancy
 *
 * Name: Nguyen Nguyen
 * Section: Section 02 - 1:50-2:42am
 * Date: 5/12/2021
 * Time: 7:33 PM
 *
 * Project: CSCI205SP21finalproject
 * Package: PACKAGE_NAME
 * Class: gameboard.BabaIsYouGameGUIController
 *
 * Description: Master Controller of the Game GUI
 *
 * ****************************************
 */

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.awt.*;
import java.util.ArrayList;

import gameManager.GameManager;

public class BabaIsYouGameGUIController {
    /** The width of the board */
    private static final int WIDTH = 800;
    /** The height of the board */
    private static final int HEIGHT = 600;
    /** The number of rows of the board */
    private static final int ROWS = 40;
    /** The number of columns of the board */
    private static final int COLUMNS = 30;
    /** The size of a square */
    private static final int SQUARE_SIZE = WIDTH/ROWS;

    /** For character movement */
    private int moveUp = 1;
    private int moveDown = 1;
    private int moveRight = 1;
    private int moveLeft = 1;

    private static Color defaultBackground = setDefaultBackground();

    /** For the levels to maintain their state */
    private static int countLvl1 = 0;
    private static int countLvl2 = 0;
    private static int countLvl3 = 0;

    /** Character color */
    private KeyCode code;

    /** The current level */
    private static int currentLvl = 1;

    /** Setting up theModel and theView */
    private BabaIsYouGameGUIModel theModel;
    private BabaIsYouGameGUIView theView;
    private Timeline timeline;

    /**
     *
     * @param theView
     * @param theModel
     */
    public BabaIsYouGameGUIController(BabaIsYouGameGUIView theView, BabaIsYouGameGUIModel theModel){
        this.theModel = new BabaIsYouGameGUIModel();
        this.theView = new BabaIsYouGameGUIView(theModel);




        //Timeline for character animation
        timeline = new Timeline(new KeyFrame(new Duration(10), e -> run()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }

    /**
     * The "state" of the board. Each run displays the current level, the objects, the characters, and check for interactions.
     * The timeline calls run() every 10 milliseconds, allowing the board to be updated once every 10 millis.
     * Source of reference:
     * @see
     * <a href=" https://github.com/mahmoudhamwi/Snake/blob/main/Snake/src/sample/Main.java">
     *   https://github.com/mahmoudhamwi/Snake/blob/main/Snake/src/sample/Main.java</a>
     */
    private void run(){
        if (getCurrentLvl() == 1) {
            countLvl1 += 1;
            if (countLvl1 <= 1) {
                theModel.setObjs(generateObjLvl1());
                BabaIsYouGameGUIModel.setBabaObj(new Point(600, 400));
                BabaIsYouGameGUIModel.setIsObj(new Point(80, 200));
                BabaIsYouGameGUIModel.setPassObj(new Point(700, 200));
                BabaIsYouGameGUIModel.setWinObj(new Point(100, 100));
            }
        }
        else if (getCurrentLvl() == 2) {
            countLvl2+= 1;
            if (countLvl2 <= 1) {
                theModel.setObjs(generateObjLvl2());
                BabaIsYouGameGUIModel.setBabaObj(new Point(600, 400));
                BabaIsYouGameGUIModel.setIsObj(new Point(80, 200));
                BabaIsYouGameGUIModel.setPassObj(new Point(700, 200));
                BabaIsYouGameGUIModel.setWinObj(new Point(100, 100));
            }
        }
        else if (getCurrentLvl() == 3){
            countLvl3 += 1;
            if (countLvl3 <= 1) {
                theModel.setObjs(generateObjLvl3());
                BabaIsYouGameGUIModel.setBabaObj(new Point(600, 400));
                BabaIsYouGameGUIModel.setIsObj(new Point(80, 200));
                BabaIsYouGameGUIModel.setPassObj(new Point(700, 200));
                BabaIsYouGameGUIModel.setWinObj(new Point(100, 100));
            }
        }
        else if (getCurrentLvl() > 3){
            goToExit();
            timeline.stop();
        }
        keyboardInput();
        colorBackground(defaultBackground);
        colorCharacter(theModel.getCurrentColor());
        drawObj();
        drawPassObj();
        drawBaBaObj();
        drawIsObj();
        drawWinObj();
        checkInteraction();
        nearKeyObject(BabaIsYouGameGUIModel.getBabaObj());
        nearKeyObject(BabaIsYouGameGUIModel.getIsObj());
        nearKeyObject(BabaIsYouGameGUIModel.getPassObj());
        nearKeyObject(BabaIsYouGameGUIModel.getWinObj());
        checkWinCondition();

    }
    /**
     * Initializes a list of objects with coordinates
     * @return list of objects
     */
    private ArrayList<Point> generateObjLvl3(){
        //ArrayList<Point> objs = new ArrayList<Point>();
        ArrayList<Point> coordinates = new ArrayList<Point>();
        coordinates.add(new Point(5,5));
        coordinates.add(new Point(6,5));
        coordinates.add(new Point(7,5));
        coordinates.add(new Point(8,5));
        coordinates.add(new Point(9,5));
        coordinates.add(new Point(10,5));
        coordinates.add(new Point(11,5));
        coordinates.add(new Point(5,6));
        coordinates.add(new Point(5,7));
        coordinates.add(new Point(5,8));
        coordinates.add(new Point(5,9));
        coordinates.add(new Point(5,10));
        coordinates.add(new Point(5,11));
        coordinates.add(new Point(9,12));

        for (int i=0; i< coordinates.size(); i++){
            coordinates.get(i).x *= SQUARE_SIZE;
            coordinates.get(i).y *= SQUARE_SIZE;
        }
        return coordinates;
    }

    /**
     * Initializes a list of objects with coordinates
     * @return list of objects
     */
    private ArrayList<Point> generateObjLvl2(){
        //ArrayList<Point> objs = new ArrayList<Point>();
        ArrayList<Point> coordinates = new ArrayList<Point>();
        coordinates.add(new Point(5,5));
        coordinates.add(new Point(6,5));
        coordinates.add(new Point(7,5));
        coordinates.add(new Point(8,5));
        coordinates.add(new Point(9,5));
        coordinates.add(new Point(10,5));
        coordinates.add(new Point(11,5));
        for (int i=0; i< coordinates.size(); i++){
            coordinates.get(i).x *= SQUARE_SIZE;
            coordinates.get(i).y *= SQUARE_SIZE;
        }
        return coordinates;
    }

    /**
     * Initializes a list of objects with coordinates
     * @return list of objects
     */
    private ArrayList<Point> generateObjLvl1(){
        ArrayList<Point> objs = new ArrayList<Point>();
        for (int i = 10; i< 21; i++) {
            int x = (i) * SQUARE_SIZE;
            int y = (i) * SQUARE_SIZE;

            objs.add(new Point(x, y));
        }
        return objs;
    }

    /**
     * Checks the keyboard input of user and move the character to the input
     * Go to the in-game menu if user choose ESC button
     */
    private void keyboardInput() {
        GameManager.scene.setOnKeyPressed(event -> {
            code = event.getCode();
            if (code == KeyCode.RIGHT){
                BabaIsYouGameGUIModel.getCharacter().x += moveRight;
            } else if (code == KeyCode.LEFT){
                BabaIsYouGameGUIModel.getCharacter().x -= moveLeft;
            } else if (code == KeyCode.UP){
                BabaIsYouGameGUIModel.getCharacter().y -= moveUp;
            } else if (code == KeyCode.DOWN){
                BabaIsYouGameGUIModel.getCharacter().y+= moveDown;
            } else if (code == KeyCode.ESCAPE){
                goToInGameMenu();
            }
        });
    }

    /**
     * If is next level, go to next level, as we've won the current level
     */
    private static void checkWinCondition(){
        if (isNextLvl())
            goToNextLvl();
    }

    public static void goToNextLvl() {
        currentLvl++;
    }

    public static int getCurrentLvl() {
        return currentLvl;
    }

    /**
     * Check if Baba-Is-Win is viable. Return true if so.
     * @return true if Baba-Is-Pass, false otherwise
     */
    public static boolean isNextLvl(){
        if (BabaIsYouGameGUIModel.getBabaObj().getX() == (BabaIsYouGameGUIModel.getIsObj().getX()-SQUARE_SIZE) && (BabaIsYouGameGUIModel.getIsObj().getX() == (BabaIsYouGameGUIModel.getWinObj().getX()-SQUARE_SIZE))
                && (BabaIsYouGameGUIModel.getBabaObj().getY() == (BabaIsYouGameGUIModel.getIsObj().getY())) && (BabaIsYouGameGUIModel.getIsObj().getY() == (BabaIsYouGameGUIModel.getWinObj().getY()))){
            return true;
        }
        return false;
    }

    /**
     * Check the interaction and the current state of the character and the normal objects
     * If the object is not passable or the character is at an edge, make the character unmovable
     */
    private void checkInteraction(){
        if (!theModel.isPassable()) {
            if (theModel.nearObjectLeft() || (theModel.getCharacter().getX() == ROWS -1))
                moveRight = 0;
            else {
                moveRight = 1;
            }
            if (theModel.nearObjectRight() || (theModel.getCharacter().getX() == 0))
                moveLeft = 0;
            else {
                moveLeft = 1;
            }
            if (theModel.nearObjectDown() || (theModel.getCharacter().getY() == 0))
                moveUp = 0;
            else {
                moveUp = 1;
            }
            if (theModel.nearObjectUp() || (theModel.getCharacter().getY() == COLUMNS - 1))
                moveDown = 0;
            else {
                moveDown = 1;
            }
        }
    }


    /**
     * Go to in-game menu by calling In-Game Menu methods
     */
    private void goToInGameMenu(){
        InGameMenu.generateInGameMenu();
        InGameMenu.generateHint();
        InGameMenu.generateCustomizeTheme();
        GameManager.gamePrimaryStage.setScene(InGameMenu.getMenuScene());

    }

    /**
     * GO to the exit scene
     */
    private void goToExit(){
        ExitScene.generateMessage();
        GameManager.gamePrimaryStage.setScene(ExitScene.getExitScene());
    }
    /**
     * colors the background
     */
    private void colorBackground(Color color){
        theView.getGc().setFill(color);
        theView.getGc().fillRect(0, 0, 800,600);
    }

    /**
     * colors the character
     * @param color - The desired color
     */
    private void colorCharacter(Color color){
        theView.getGc().setFill(color);
        theView.getGc().fillRect(theModel.getCharacter().getX()*SQUARE_SIZE, theModel.getCharacter().getY()*SQUARE_SIZE, SQUARE_SIZE-1, SQUARE_SIZE-1);
    }

    /**
     * Colors the objects based on its coordinate
     */
    private void drawObj(){
        for (Point obj: theModel.getObjs()) {
            theView.getGc().setFill(Color.ORANGE);
            theView.getGc().fillRect(obj.getX(), obj.getY(), SQUARE_SIZE - 1, SQUARE_SIZE - 1);
        }
    }

    /**
     * Draw the Pass object
     */
    private void drawPassObj(){
        theView.getGc().setFill(Color.RED);
        theView.getGc().fillRect(BabaIsYouGameGUIModel.getPassObj().getX(), BabaIsYouGameGUIModel.getPassObj().getY(), SQUARE_SIZE - 1, SQUARE_SIZE - 1);
    }

    /**
     * Draw the Is object
     */
    private void drawIsObj(){
        theView.getGc().setFill(Color.BLUE);
        theView.getGc().fillRect(BabaIsYouGameGUIModel.getIsObj().getX(), BabaIsYouGameGUIModel.getIsObj().getY(), SQUARE_SIZE - 1, SQUARE_SIZE - 1);
    }

    /**
     * Draw the Baba object
     */
    private void drawBaBaObj(){
        theView.getGc().setFill(Color.PURPLE);
        theView.getGc().fillRect(BabaIsYouGameGUIModel.getBabaObj().getX(), BabaIsYouGameGUIModel.getBabaObj().getY(), SQUARE_SIZE - 1, SQUARE_SIZE - 1);
    }

    /**
     * Draw the Win object
     */
    private void drawWinObj(){
        theView.getGc().setFill(Color.PINK);
        theView.getGc().fillRect(BabaIsYouGameGUIModel.getWinObj().getX(), BabaIsYouGameGUIModel.getWinObj().getY(), SQUARE_SIZE - 1, SQUARE_SIZE - 1);
    }

    /**
     * Check if the character is near the key objects (baba-is-pass)
     * @param keyObj baba-is-pass objects
     */
    private void nearKeyObject(Point keyObj){
        if (BabaIsYouGameGUIModel.getCharacter().getX()*SQUARE_SIZE == (keyObj.getX()) && BabaIsYouGameGUIModel.getCharacter().getY()*SQUARE_SIZE == keyObj.getY()) {
            if (code == KeyCode.RIGHT) {
                keyObj.x += SQUARE_SIZE;
            }
            else if (code == KeyCode.LEFT)
                keyObj.x -= SQUARE_SIZE;
            else if (code == KeyCode.UP)
                keyObj.y -= SQUARE_SIZE;
            else if (code == KeyCode.DOWN)
                keyObj.y+= SQUARE_SIZE;
        }
    }

    public static void setCountLvl1(int newCountLvl1) {
        countLvl1 = newCountLvl1;
    }

    public static void setCountLvl2(int newCountLvl2) {
        countLvl2 = newCountLvl2;
    }

    public static void setCountLvl3(int newCountLvl3) {
        countLvl3 = newCountLvl3;
    }

    public static void setDefaultBackground(Color newDefaultBackground) {
        defaultBackground = newDefaultBackground;
    }

    private static javafx.scene.paint.Color setDefaultBackground(){
        return Color.BLACK;
    }


}
