package Rule;/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2021
 * Instructor: Prof. Chris Dancy
 *
 * Name: Christiaan Smith
 * Section: 1:50pm - 2:40pm
 * Date: 4/27/2021
 * Time: 11:47 AM
 *
 * Project: CSCI205SP21finalproject
 * Package: PACKAGE_NAME
 * Class: Word
 *
 * Description: Word-Specific General Object more tailored towards dealing with word-based interactions
 *
 * ****************************************
 */


/**
 * Words which represent the physical entities on the screen, if this object has a connector attached with a ruleword
 * ,then the corresponding entity to this Rule.NameWord has those rules applied.
 *
 * @author Christiaan
 */
public abstract class NameWord implements GeneralObject {

    //coordinates
    private int x;
    private int y;

    //type info
    private String color;

    //returns the corresponding entity name to the word (SHOULD MATCH IDENTICAL ENTITY VERSION)
    public abstract String getName();

    public NameWord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public NameWord() {
        this.x = 0;
        this.y = 0;
    }

    @Override
    public String getType() { return "Rule.NameWord"; }

    @Override
    public int getX() {return this.x;}

    @Override
    public int getY() {return this.y;}

    @Override
    public void move(int newX, int newY) {
        this.y += newY;
        this.x += newX;
    }

    @Override
    public void setCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
