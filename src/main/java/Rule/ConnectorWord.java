package Rule;/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2021
 * Instructor: Prof. Chris Dancy
 *
 * Name: Christiaan Smith
 * Section: 1:50pm - 2:40pm
 * Date: 5/6/2021
 * Time: 8:41 PM
 *
 * Project: CSCI205SP21finalproject
 * Package: PACKAGE_NAME
 * Class: Rule.ConnectorWord
 *
 * Description: THIS IS A DESCRIPTION Y’ALL AND I NEED TO CHANGE THIS!
 *
 * ****************************************
 */

/**
 * Word such as IS and AND, which are used to glue RuleWords to NameWords
 */
public abstract class ConnectorWord implements GeneralObject {

    //coordinates
    private int x;
    private int y;

    //type info
    private String color;

    //returns the corresponding connector type to the word (PRETTY SURE ONLY NEED 'IS' RIGHT NOW)
    abstract public String getConnector();

    @Override
    public String getType() { return "ConnectorWord"; }

    @Override
    public String getColor() {return this.color;}

    @Override
    public int getX() {return this.x;}

    @Override
    public int getY() {return this.y;}

    @Override
    public void move(int newX, int newY) {
        this.y += newY;
        this.x += newX;
    }

    public void setCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isPushable() {return this.isPushable();}
}
