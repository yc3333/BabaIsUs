package Rule;/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2021
 * Instructor: Prof. Chris Dancy
 *
 * Name: Yuhan Chen
 * Section: YOUR SECTION
 * Date: 5/15/2021
 * Time: 9:10 AM
 *
 * Project: CSCI205SP21finalproject
 * Package: PACKAGE_NAME
 * Class: Rule.DemoRuleOne
 *
 * Description: Includes all rules and win conditions to the demo
 *
 * ****************************************
 */

import javafx.scene.input.KeyCode;

import java.util.ArrayList;

public class DemoRuleOne {
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
    //TODO: initialize the coordinates of the character
    public static Baba babaObj = new Baba(0,0);
    public static Is isObj = new Is(80,80);
    public static Rock rockObj = new Rock(200,200);
    public static Win winObj = new Win(400,400);

    // Generate a character that player currently moved
    public static NameWordImpl player = new NameWordImpl();
    //TODO: initialize the player to baba

    //ruleBaba represents the rule "Rule.Baba is win"
    //ruleRock represents the rule "Rule.Rock is win"
    public static boolean ruleBaba = false;
    public static boolean ruleRock = false;

    //Create a list for all objects
    public static ArrayList<GeneralObject> objs = new ArrayList<GeneralObject>(4);



    /**
     * Check if the character is on the position a normal object
     * @return the normal object
     */
    public static GeneralObject atObjectLocation(GeneralObject generalObject){
        for (GeneralObject obj: objs) {
            if(!obj.equals(generalObject)) {
                if (generalObject.getX() == (obj.getX()) && (generalObject.getY() == obj.getY())) {
                    return obj;
                }
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
                if (generalObject.getX()  == (obj.getX()) && generalObject.getY() == obj.getY()-SQUARE_SIZE)
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
                if (generalObject.getX()  == (obj.getX()) && generalObject.getY()  == obj.getY()+SQUARE_SIZE)
                    return obj;
            }
        }
        return generalObject;
    }

    //Set the object list
    public static void setObjs(ArrayList<GeneralObject> objs) {
        objs.add(babaObj);
        objs.add(rockObj);
        objs.add(isObj);
        objs.add(winObj);
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
                player.move(0, SQUARE_SIZE);
                while(!atObjectLocation(generalObject).equals(generalObject)){
                    generalObject = atObjectLocation(generalObject);
                    generalObject.move(0, SQUARE_SIZE);
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
            if (nearObjectLeft(babaObj).equals(isObj) && nearObjectRight(rockObj).equals(isObj)) {
                player = rockObj;
            }
            if (nearObjectUp(babaObj).equals(isObj) && nearObjectDown(rockObj).equals((isObj))) {
                player = rockObj;
            }
        }
        if (player.equals(rockObj)) {
            if (nearObjectLeft(rockObj).equals(isObj) && nearObjectRight(babaObj).equals(isObj)) {
                player = babaObj;
            }
            if (nearObjectUp(rockObj).equals(isObj) && nearObjectDown(babaObj).equals((isObj))) {
                player = babaObj;
            }
        }
    }

    /**
     * Two win condition:
     * if the character that player manipulates is the one that has set up in the rule, then win
     * if the character that player moves is adjacent to the NameObject that has set up in the rule, then win
     * @return win or not yet
     */
    public static boolean isWin() {
        if (nearObjectLeft(babaObj).equals(winObj) || nearObjectRight(babaObj).equals(winObj)
                || nearObjectDown(babaObj).equals(winObj) || nearObjectUp(babaObj).equals(winObj)) {
            return true;
        }
        else if (nearObjectLeft(rockObj).equals(winObj) || nearObjectRight(rockObj).equals(winObj)
                || nearObjectDown(rockObj).equals(winObj) || nearObjectUp(rockObj).equals(winObj)) {
            return true;
        }

        return false;
    }

    /**
     * The rule is only established when "baba is win" or " rock is win" is connected
     */
    public static void ruleChange() {
        ruleBaba = false;
        ruleRock = false;
        if (nearObjectLeft(babaObj).equals(isObj) && nearObjectRight(winObj).equals(isObj)) {
            ruleBaba = true;
        }
        if (nearObjectUp(babaObj).equals(isObj) && nearObjectDown(winObj).equals(isObj)) {
            ruleBaba = true;
        }
        if (nearObjectLeft(rockObj).equals(isObj) && nearObjectRight(winObj).equals(isObj)) {
            ruleRock = true;
        }
        if (nearObjectUp(rockObj).equals(isObj) && nearObjectDown(winObj).equals(isObj)) {
            ruleRock = true;
        }
    }
}