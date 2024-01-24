package Rule;/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2021
 * Instructor: Prof. Chris Dancy
 *
 * Name: Christiaan Smith
 * Section: 1:50pm - 2:40pm
 * Date: 4/27/2021
 * Time: 11:41 AM
 *
 * Project: CSCI205SP21finalproject
 * Package: PACKAGE_NAME
 * Class: Rule.Entity
 *
 * Description: Abstract Rule.Entity Object Class with template to be implemented by all game objects
 *
 * ****************************************
 */

import javafx.scene.image.Image;

/**
 * ABSTRACT PARENT TO ALL GAME BOARD OBJECTS
 *
 * This class is the essential interface that all GameObjects inherit, in order to generate the game board
 * as well as interactions between different objects easily.
 *
 * @author Christiaan
 */
public interface GeneralObject {

    /**
     * Returns the type of Rule.GeneralObject
     *
     * @return      String indicating the type of Rule.GeneralObject the object that the object is.
     */
    public String getType();

    /**
     * Returns the given color of the chosen object (until we implement images)
     *
     * @return      String to use with javaFX color drawing
     */
    public String getColor();

    /**
     * returns the X coordinate location of the Rule.GeneralObject
     * @returns X   integer corresponding to the object's current x coordinate
     *
     */
    public int getX();


    public int getY();

    public Image getImage();

    /**
     * Sets the objects location to the given coordinates
     * @param newX     integer x coordinate
     * @param newY     integer y coordinate
     */
    public void move (int newX, int newY);

    public default boolean isPushable() {return false;}

    public void setCoordinate(int x, int y);

    public default boolean isPassable() {return false;}
}



