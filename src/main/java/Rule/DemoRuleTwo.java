package Rule;/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2021
 * Instructor: Prof. Chris Dancy
 *
 * Name: Yuhan Chen
 * Section: YOUR SECTION
 * Date: 5/16/2021
 * Time: 9:46 PM
 *
 * Project: CSCI205SP21finalproject
 * Package: PACKAGE_NAME
 * Class: Rule.DemoRuleTwo
 *
 * Description: THIS IS A DESCRIPTION Y’ALL AND I NEED TO CHANGE THIS!
 *
 * ****************************************
 */

import javafx.scene.input.KeyCode;

import java.util.ArrayList;

public class DemoRuleTwo {
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
    public static Baba babaObj = new Baba(200,40);
    public static Is isObj = new Is(240,200);
    public static Win winObj = new Win(400,440);
    public static WallText wallText = new WallText(200,200);
    public static Stop stopObj = new Stop(280,200);
    public static ArrayList<Wall> wallObjs = new ArrayList<Wall>(20);

    public DemoRuleTwo() {}

    //Generate Rule.Wall objects
    public static void setWallObjs(ArrayList<Wall> wallObjs) {
        for (int i = 0; i < 800; i += 40) {
            wallObjs.add(new Wall(i, 400));
        }
    }

    // Generate a character that player currently moved
    public static NameWordImpl player = new NameWordImpl();

    //ruleStop represents the rule "wall is stop"(which is supposed to be false to win)
    //ruleWin represents the rule "Baba win"
    public static boolean ruleStop = true;
    public static boolean ruleWin = false;

    //Create a list for all objects
    public static ArrayList<GeneralObject> objs = new ArrayList<GeneralObject>();

    //Set the object list
    public static void setObjs(ArrayList<GeneralObject> objs) {
        objs.add(babaObj);
        objs.add(wallText);
        objs.add(isObj);
        objs.add(winObj);
        objs.add(stopObj);
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
                 player.move(0,-SQUARE_SIZE);
                 while(!atObjectLocation(generalObject).equals(generalObject)){
                     generalObject = atObjectLocation(generalObject);
                     generalObject.move(0, -SQUARE_SIZE);
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
     * The character that the player manipulate is changed in two condition:
     * "Rule.Baba is rock" or "Rule.Rock is baba"
     */
    public static void changeCharacter() {
        if (player.equals(babaObj)) {
            if (nearObjectLeft(babaObj).equals(isObj) && nearObjectRight(wallText).equals(isObj)) {
                player = wallText;
            }
            if (nearObjectUp(babaObj).equals(isObj) && nearObjectDown(wallText).equals((isObj))) {
                player = wallText;
            }
        }
        if (player.equals(wallText)) {
            if (nearObjectLeft(wallText).equals(isObj) && nearObjectRight(babaObj).equals(isObj)) {
                player = babaObj;
            }
            if (nearObjectUp(wallText).equals(isObj) && nearObjectDown(babaObj).equals((isObj))) {
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
        for (Wall obj:wallObjs) {
            obj.setPassable(true);
        }
        ruleWin = false;
        ruleStop = false;
        if (nearObjectLeft(babaObj).equals(winObj) || nearObjectRight(babaObj).equals(winObj)
                || nearObjectDown(babaObj).equals(winObj) || nearObjectUp(babaObj).equals(winObj)) {
            ruleWin = true;
        }
        if (nearObjectLeft(wallText).equals(isObj) && nearObjectRight(stopObj).equals(isObj)) {
            ruleStop = true;
            for (Wall obj:wallObjs) {
                obj.setPassable(false);
            }
        }
    }
}