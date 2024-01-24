package Rule;/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2021
 * Instructor: Prof. Chris Dancy
 *
 * Name: Jane Yan, Yuhan Chen
 * Section: YOUR SECTION
 * Date: 5/14/2021
 * Time: 8:03 AM
 *
 * Project: CSCI205SP21finalproject
 * Package: PACKAGE_NAME
 * Class: Rule.Win
 *
 * Description: THIS IS A DESCRIPTION Y’ALL AND I NEED TO CHANGE THIS!
 *
 * ****************************************
 */

import javafx.scene.image.Image;

public class Win extends RuleWord{
    public String name = "Rule.Win";
    javafx.scene.image.Image image = new javafx.scene.image.Image(getClass().getResource("/image/TextWin.png").toExternalForm(),40,40,false,false);;

    public Win(int x, int y) {
        setCoordinate(x,y);
    }
    @Override
    public String getRule() {
        return name;
    }
    public Image getImage() {
        return image;
    }
    public boolean isPushable() {return false;}
}