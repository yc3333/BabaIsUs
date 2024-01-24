package Rule;/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2021
 * Instructor: Prof. Chris Dancy
 *
 * Name: Jane Yan, Yuhan Chen
 * Section: YOUR SECTION
 * Date: 5/14/2021
 * Time: 8:02 AM
 *
 * Project: CSCI205SP21finalproject
 * Package: PACKAGE_NAME
 * Class: Rule.Rock
 *
 * Description: THIS IS A DESCRIPTION Y’ALL AND I NEED TO CHANGE THIS!
 *
 * ****************************************
 */

import javafx.scene.image.Image;

public class Rock extends NameWordImpl {
    public String name = "Rule.Rock";
    javafx.scene.image.Image image = new javafx.scene.image.Image(getClass().getResource("/image/Rock.png").toExternalForm(), 40, 40,false,false);;

    public Rock(int x, int y) {
        setCoordinate(x,y);
        this.image = image;
    }

    @Override
    public String getName() {
        return name;
    }

    public Image getImage() {
        return this.image;
    }

    public boolean isPushable() {return true;}
}