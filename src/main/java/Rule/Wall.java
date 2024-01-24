package Rule;/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2021
 * Instructor: Prof. Chris Dancy
 *
 * Name: Jane Yan, Yuhan Chen
 * Section: YOUR SECTION
 * Date: 5/16/2021
 * Time: 9:53 PM
 *
 * Project: CSCI205SP21finalproject
 * Package: PACKAGE_NAME
 * Class: Rule.Wall
 *
 * Description: THIS IS A DESCRIPTION Y’ALL AND I NEED TO CHANGE THIS!
 *
 * ****************************************
 */

import javafx.scene.image.Image;

public class Wall extends NameWordImpl{
    public boolean passable;
    public String name = "Wall";
    javafx.scene.image.Image image = new javafx.scene.image.Image(getClass().getResource("/image/Wall.png").toExternalForm(), 40, 40,false,false);

    public Wall(int x, int y) {
        this.passable = true;
        setCoordinate(x,y);
    }

    @Override
    public String getName() {
        return name;
    }

    public Image getImage() {
        return image;
    }

    public boolean isPushable() {return true;}

    public void setPassable(boolean newPassable) {
        this.passable = newPassable;
    }

    public boolean isPassable() {return this.passable;}
}