package Rule;/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2021
 * Instructor: Prof. Chris Dancy
 *
 * Name: Christiaan Smith
 * Section: 1:50pm - 2:40pm
 * Date: 4/27/2021
 * Time: 11:46 AM
 *
 * Project: CSCI205SP21finalproject
 * Package: PACKAGE_NAME
 * Class: Rule.Entity
 *
 * Description: Rule.Entity specific General Object data type meant to represent Entities on screen
 *
 * ****************************************
 */

/**
 * Object Class for all phyiscal non-word entities in the game, object stores the entity
 * image, name, applied rules, and coordinates (UNLESS CHOOSE TO STORE BY BOARD)
 *
 * @author Christiaan
 */
 public abstract class Entity implements GeneralObject{

     //coordinates
     private int x;
     private int y;

     //type info
     private String color;

    @Override
    public String getType() {
        return "Rule.Entity";
    }

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


    /**
     * Returns the specific name of the exact type of entity. This is used when applying rules
     * and movement to objects.
     * @return      Name of the specific Rule.Entity (SHOULD MATCH WORD VERSION)
     */
    public abstract String getName();
}
