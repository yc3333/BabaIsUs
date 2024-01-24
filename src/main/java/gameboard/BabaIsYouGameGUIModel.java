package gameboard;/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2021
 * Instructor: Prof. Chris Dancy
 *
 * Name: Nguyen Nguyen
 * Section: Section 02 - 1:50-2:42am
 * Date: 5/12/2021
 * Time: 6:43 PM
 *
 * Project: CSCI205SP21finalproject
 * Package: PACKAGE_NAME
 * Class: gameboard.BabaIsYouGameGUIModel
 *
 * Description: GUI GAME MODEL FOR PLAN B OF GAME
 *
 * ****************************************
 */

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.ArrayList;

public class BabaIsYouGameGUIModel {
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

    /** The character as a Point object */
    private static Point character = new Point(0,0);
    /** The objects */
    private Point obj;



    /** Key objects */
    private static Point babaObj = new Point(2* SQUARE_SIZE,2* SQUARE_SIZE);
    private static Point isObj = new Point(3* SQUARE_SIZE,3* SQUARE_SIZE);
    private static Point passObj = new Point(4* SQUARE_SIZE,4* SQUARE_SIZE);
    private static Point winObj = new Point(5 * SQUARE_SIZE, 5 * SQUARE_SIZE);

    /** Character color */
    protected static Color currentColor = defaultColor();

    /** List of objects */
    private ArrayList<Point> objs = setTempObjs();


    /** The in-game scene */
    protected static Scene scene;


    public BabaIsYouGameGUIModel(){}


    /**
     * Check if the character is on the left a normal object
     * @return true/false
     */
    public boolean nearObjectLeft(){
        for (Point obj: objs) {
            if (character.getX()*SQUARE_SIZE == (obj.getX() - 1*SQUARE_SIZE) && character.getY()*SQUARE_SIZE == obj.getY()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if the character is on the right a normal object
     * @return true/false
     */
    public boolean nearObjectRight(){
        for (Point obj: objs) {
            if (character.getX()*SQUARE_SIZE  == (obj.getX() + 1*SQUARE_SIZE) && character.getY()*SQUARE_SIZE  == obj.getY())
                return true;
        }
        return false;
    }

    /**
     * Check if the character is above a normal object
     * @return true/false
     */
    public boolean nearObjectUp(){
        for (Point obj: objs) {
            if (character.getX()*SQUARE_SIZE  == (obj.getX()) && character.getY()*SQUARE_SIZE  == obj.getY() - 1*SQUARE_SIZE )
                return true;
        }
        return false;
    }

    /**
     * Check if the character is below a normal object
     * @return true/false
     */
    public boolean nearObjectDown(){
        for (Point obj: objs) {
            if (character.getX()*SQUARE_SIZE  == (obj.getX()) && character.getY()*SQUARE_SIZE  == obj.getY() + 1*SQUARE_SIZE )
                return true;
        }
        return false;
    }

    public ArrayList<Point> setTempObjs(){
        ArrayList<Point> objects = new ArrayList<>();
        objects.add(new Point(60,60));
        objects.add(new Point (80, 80));
        return objects;
    }
    /**
     * Check if Baba-Is-Pass is viable. Return true if so.
     * @return true if Baba-Is-Pass, false otherwise
     */
    public boolean isPassable(){
        if (babaObj.getX() == (isObj.getX()-SQUARE_SIZE) && (isObj.getX() == (passObj.getX()-SQUARE_SIZE))
                && (babaObj.getY() == (isObj.getY())) && (isObj.getY() == (passObj.getY()))){
            return true;
        }
        return false;
    }



    /**
     * Default color
     */
    private static javafx.scene.paint.Color defaultColor(){
        return Color.WHITE;
    }

    public static void setCurrentColor(Color newColor){
        currentColor = newColor;
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public static Point getCharacter() {
        return character;
    }

    public static Point getBabaObj() {
        return babaObj;
    }

    public static Point getIsObj() {
        return isObj;
    }

    public static Point getPassObj() {
        return passObj;
    }

    public static Point getWinObj(){
        return winObj;
    }

    public  ArrayList<Point> getObjs() {
        return objs;
    }

    public static void setCharacter(Point character) {
        BabaIsYouGameGUIModel.character = character;
    }

    public void setObj(Point obj) {
        this.obj = obj;
    }

    public void setObjs(ArrayList<Point> objs) {
        this.objs = objs;
    }

    public static void setPassObj(Point p) {
        passObj = p;
    }

    public static void setWinObj(Point w) {
        winObj = w;
    }

    public static void setBabaObj(Point b) {
        babaObj = b;
    }

    public static void setIsObj(Point i) {
        isObj = i;
    }
}
