/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2021
 * Instructor: Prof. Chris Dancy
 *
 * Name: Yuhan Chen
 * Section: YOUR SECTION
 * Date: 5/18/2021
 * Time: 2:30 AM
 *
 * Project: CSCI205SP21finalproject
 * Package: Rule
 * Class: DemoRuleThree
 *
 * Description: THIS IS A DESCRIPTION Y’ALL AND I NEED TO CHANGE THIS!
 *
 * ****************************************
 */
package Rule;

import javafx.scene.input.KeyCode;

import java.util.ArrayList;

public class DemoRuleThree {
    /** The width of the board */
    private static final int WIDTH = 800;
    /** The height of the board */
    private static final int HEIGHT = 800;
    /** The number of rows of the board */
    private static final int ROWS = 20;
    /** The number of columns of the board */
    private static final int COLUMNS = 20;
    /** The size of a square */
    private static final int SQUARE_SIZE = WIDTH/ROWS;

    //Generate objects for the demo
    public static Baba babaObj = new Baba(400,520);
    public static Is isObjOne = new Is(240,200);
    public static Is isObjTwo = new Is(480,520);
    public static Win winObj = new Win(400,240);
    public static WallText wallTextOne = new WallText(520,520);
    public static WallText wallTextTwo = new WallText(200,200);
    public static Stop stopObj = new Stop(280,200);
    public static Wall wallKeyObj = new Wall(760, 400);
    public static ArrayList<Wall> wallObjs = new ArrayList<Wall>(20);

    //Generate Rule.Wall objects
    public static void setWallObjs(ArrayList<Wall> wallObjs) {
        for (int i = 0; i < 760; i += 40) {
            wallObjs.add(new Wall(i, 400));
        }
    }

    // Generate a character that player currently moved
    public static NameWordImpl player = new NameWordImpl();

    //ruleStop represents the rule "baba is wall"
    //ruleWin represents the rule "wall win"
    public static boolean ruleWall = false;
    public static boolean ruleWin = false;

    //Create a list for all objects
    public static ArrayList<GeneralObject> objs = new ArrayList<GeneralObject>();

    //Set the object list
    public static void setObjs(ArrayList<GeneralObject> objs) {
        objs.add(babaObj);
        objs.add(wallTextOne);
        objs.add(wallTextTwo);
        objs.add(isObjOne);
        objs.add(isObjTwo);
        objs.add(winObj);
        objs.add(stopObj);
        objs.add(wallKeyObj);
        objs.addAll(wallObjs);
    }



    /**
     * Check if the character is on the right a normal object
     * @return the normal object
     */
    public static GeneralObject atObjectLocation(GeneralObject generalObject){
        for (GeneralObject obj: objs) {
            if(!obj.equals(generalObject)) {
                if (generalObject.getX() == (obj.getX()) && generalObject.getY() == obj.getY())
                    return obj;
            }
        }
        return generalObject;
    }

    /**
     * Check if the character is on the right a normal object
     * @return the normal object
     */
    public static GeneralObject nearObjectRight(GeneralObject generalObject){
        for (GeneralObject obj: objs) {
            if(!obj.equals(generalObject)) {
                if (generalObject.getX() == (obj.getX()+ SQUARE_SIZE) && generalObject.getY() == obj.getY())
                    return obj;
            }
        }
        return generalObject;
    }

    /**
     * Check if the character is on the right a normal object
     * @return the normal object
     */
    public static GeneralObject nearObjectLeft(GeneralObject generalObject){
        for (GeneralObject obj: objs) {
            if(!obj.equals(generalObject)) {
                if (generalObject.getX() == (obj.getX() - SQUARE_SIZE) && generalObject.getY() == obj.getY())
                    return obj;
            }
        }
        return generalObject;
    }

    /**
     * Check if the character is above a normal object
     * @return the normal object
     */
    public static GeneralObject nearObjectUp(GeneralObject generalObject){
        for (GeneralObject obj: objs) {
            if (!obj.equals(generalObject)) {
                if ((generalObject.getX()  == obj.getX()) && (generalObject.getY() == obj.getY()-SQUARE_SIZE))
                    return obj;
            }
        }
        return generalObject;
    }

    /**
     * Check if the character is below a normal object
     * @return the normal object
     */
    public static GeneralObject nearObjectDown(GeneralObject generalObject){
        for (GeneralObject obj: objs) {
            if (!obj.equals(generalObject)) {
                if ((generalObject.getX()  == obj.getX()) && (generalObject.getY()  == obj.getY()+SQUARE_SIZE))
                    return obj;
            }
        }
        return generalObject;
    }

    /**
     * Checks if object is passable
     * @param code - keyboard input
     * @return true if is, false otherwise
     */
    public static boolean isPassable(KeyCode code) {
        switch (code) {
            case DOWN:
                if (!nearObjectUp(player).equals(player)) {
                    if (nearObjectUp(player).isPassable()) {
                        return true;
                    }

                    else {return false;}
                }
                else {return true;}
            case UP:
                if (!nearObjectDown(player).equals(player)) {
                    if (nearObjectDown(player).isPassable()) {
                        return true;
                    }
                    else {return false;}
                }
                else {return true;}
            case RIGHT:
                if (!nearObjectLeft(player).equals(player)) {
                    if (nearObjectLeft(player).isPassable()) {
                        return true;
                    }
                    else {return false;}
                }
                else {return true;}
            case LEFT:
                if (!nearObjectRight(player).equals(player)) {
                    if (nearObjectRight(player).isPassable()) {
                        return true;
                    }
                    else {return false;}
                }
                else {return false;}
        }
        return false;
    }

    /**
     * Check if character is movable and move if character is movable
     * @param code - Keyboard input
     */
    public static void moveCharacter(KeyCode code) {
        GeneralObject generalObject = player;
        if (player.isPushable()) {
            if (code == KeyCode.UP) {
                if(isPassable(code)) {
                    player.move(0,-SQUARE_SIZE);
                    while(!atObjectLocation(generalObject).equals(generalObject)) {
                        generalObject = atObjectLocation(generalObject);
                        generalObject.move(0, -SQUARE_SIZE);
                    }
                }
            }
            if (code == KeyCode.DOWN) {
                if(isPassable(code)) {

                    player.move(0, SQUARE_SIZE);
                    while (!atObjectLocation(generalObject).equals(generalObject)) {
                        generalObject = atObjectLocation(generalObject);
                        generalObject.move(0, SQUARE_SIZE);
                    }
                }
            }
            if (code == KeyCode.RIGHT) {
                player.move(SQUARE_SIZE,0);
                while(!atObjectLocation(generalObject).equals(generalObject)) {
                    generalObject = atObjectLocation(generalObject);
                    generalObject.move(SQUARE_SIZE,0);
                }
            }
            if (code == KeyCode.LEFT) {
                player.move(-SQUARE_SIZE,0);
                while(!atObjectLocation(generalObject).equals(generalObject)) {
                    generalObject = atObjectLocation(generalObject);
                    generalObject.move(-SQUARE_SIZE,0);
                }
            }
        }

    }

    /**
     * The character that the player manipulate is changed when "baba is wall"
     */
    public static void changeCharacter() {
        if (player.equals(babaObj)) {
            if (nearObjectLeft(babaObj).equals(isObjTwo) && nearObjectRight(wallTextOne).equals(isObjTwo)) {
                player = wallKeyObj;
            }
            if (nearObjectUp(babaObj).equals(isObjTwo) && nearObjectDown(wallTextOne).equals((isObjTwo))) {
                player = wallKeyObj;
            }
        }
        if (player.equals(wallKeyObj)) {
            if (nearObjectLeft(wallKeyObj).equals(isObjTwo) && nearObjectRight(babaObj).equals(isObjTwo)) {
                player = babaObj;
            }
            if (nearObjectUp(wallKeyObj).equals(isObjTwo) && nearObjectDown(babaObj).equals((isObjTwo))) {
                player = babaObj;
            }
        }
    }

    /**
     * ruleWin is true
     * @return win or not yet
     */
    public static boolean isWin() {
        return ruleWin;
    }

    /**
     * The rule is only established when "baba is win" or " rock is win" is connected
     */
    public static void ruleChange() {
        for (Wall obj: wallObjs) {
            obj.setPassable(true);
        }
        ruleWin = false;
        ruleWall = false;
        if (nearObjectLeft(wallKeyObj).equals(winObj) || nearObjectRight(wallKeyObj).equals(winObj)
                || nearObjectDown(wallKeyObj).equals(winObj) || nearObjectUp(wallKeyObj).equals(winObj)) {
            ruleWin = true;
        }
        if (nearObjectLeft(babaObj).equals(winObj) || nearObjectRight(babaObj).equals(winObj)
                || nearObjectDown(babaObj).equals(winObj) || nearObjectUp(babaObj).equals(winObj)) {
            ruleWin = true;
        }
        if (nearObjectLeft(wallTextTwo).equals(isObjOne) && nearObjectRight(stopObj).equals(isObjOne)) {
            for (Wall obj: wallObjs) {
                obj.setPassable(false);
            }

            ruleWall = true;



        }

    }
}