package Rule;/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2021
 * Instructor: Prof. Chris Dancy
 *
 * Name: Jane Yan, Yuhan Chen
 * Section: YOUR SECTION
 * Date: 5/14/2021
 * Time: 7:34 AM
 *
 * Project: CSCI205SP21finalproject
 * Package: PACKAGE_NAME
 * Class: Isimp
 *
 * Description: THIS IS A DESCRIPTION Y’ALL AND I NEED TO CHANGE THIS!
 *
 * ****************************************
 */

import Rule.ConnectorWord;
import javafx.scene.image.Image;

public class Is extends ConnectorWord {
    public String name = "Rule.Is";
    javafx.scene.image.Image image = new javafx.scene.image.Image(getClass().getResource("/image/TextIs.png").toExternalForm(),40,40,false,false);

    public Is(int x, int y) {
        setCoordinate(x,y);
    }

    @Override
    public String getConnector() {
        return name;
    }

    public Image getImage() {
        return this.image;
    }

    public boolean isPushable() {return true;}

}