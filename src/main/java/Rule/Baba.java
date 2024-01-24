package Rule;/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2021
 * Instructor: Prof. Chris Dancy
 *
 * Name: Jane Yan, Yuhan Chen
 * Section: YOUR SECTION
 * Date: 5/14/2021
 * Time: 6:22 AM
 *
 * Project: CSCI205SP21finalproject
 * Package: PACKAGE_NAME
 * Class: BabaImpl
 *
 * Description: THIS IS A DESCRIPTION Y’ALL AND I NEED TO CHANGE THIS!
 *
 * ****************************************
 */


import javafx.scene.image.Image;

public class Baba extends NameWordImpl {

    public int x;
    public int y;

    public String name = "Baba";
    javafx.scene.image.Image image = new javafx.scene.image.Image(getClass().getResource("/image/Baba.png").toExternalForm(), 40, 40, false, false);

    public Baba(int x, int y) {
        setCoordinate(x,y);
    }

    @Override
    public String getName() {
        return name;
    }

    public Image getImage() {
        return image;
    }

    @Override public boolean isPushable() {return true;}

    public boolean isPassable() {return false;}


}

