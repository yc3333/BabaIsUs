package Rule;/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2021
 * Instructor: Prof. Chris Dancy
 *
 * Name: Jane Yan, Yuhan Chen
 * Section: YOUR SECTION
 * Date: 5/16/2021
 * Time: 9:59 PM
 *
 * Project: CSCI205SP21finalproject
 * Package: PACKAGE_NAME
 * Class: Rule.WallText
 *
 * Description: THIS IS A DESCRIPTION Y’ALL AND I NEED TO CHANGE THIS!
 *
 * ****************************************
 */

import javafx.scene.image.Image;

public class WallText extends NameWordImpl{
    public String name = "Rule.Wall";
    javafx.scene.image.Image image = new javafx.scene.image.Image(getClass().getResource("/image/TextWall.png").toExternalForm(), 40, 40,false,false);;

    public WallText(int x, int y) {
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

    public boolean isPassable() {return true;}
}