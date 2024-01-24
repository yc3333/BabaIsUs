package Rule;/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2021
 * Instructor: Prof. Chris Dancy
 *
 * Name: Yuhan Chen
 * Section: YOUR SECTION
 * Date: 5/15/2021
 * Time: 11:39 PM
 *
 * Project: CSCI205SP21finalproject
 * Package: PACKAGE_NAME
 * Class: Rule.NameWordImpl
 *
 * Description: The implement class of Rule.NameWord to generate a specific Rule.NameWord object
 *
 * ****************************************
 */

import javafx.scene.image.Image;

public class NameWordImpl extends NameWord {
    //coordinates
    private int x;
    private int y;

    public NameWordImpl() {
        this.x = 0;
        this.y = 0;
    }
    public NameWordImpl(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean isPushable() {
        return super.isPushable();
    }

    @Override
    public String getName() {
        return null;
    }
    @Override
    public String getType() { return "Rule.NameWord"; }

    @Override
    public String getColor() {
        return null;
    }

    @Override
    public Image getImage() {
        return null;
    }

    public boolean isPassable() {return false;}

}