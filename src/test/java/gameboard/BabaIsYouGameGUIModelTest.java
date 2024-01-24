package gameboard;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BabaIsYouGameGUIModelTest {

    BabaIsYouGameGUIModel theModel = new BabaIsYouGameGUIModel();

    @Test
    void nearObjectLeft() {
        BabaIsYouGameGUIModel.setCharacter(new Point(2,3));
        assertTrue(theModel.nearObjectLeft());
        BabaIsYouGameGUIModel.setCharacter(new Point(4,3));
        assertFalse(theModel.nearObjectLeft());
    }

    @Test
    void nearObjectRight() {
        BabaIsYouGameGUIModel.setCharacter(new Point(2,3));
        assertFalse(theModel.nearObjectRight());
        BabaIsYouGameGUIModel.setCharacter(new Point(4,3));
        assertTrue(theModel.nearObjectRight());
    }

    @Test
    void nearObjectUp() {
        BabaIsYouGameGUIModel.setCharacter(new Point(3,2));
        assertTrue(theModel.nearObjectUp());
        BabaIsYouGameGUIModel.setCharacter(new Point(4,4));
        assertFalse(theModel.nearObjectUp());
    }

    @Test
    void nearObjectDown() {
        BabaIsYouGameGUIModel.setCharacter(new Point(3,4));
        assertTrue(theModel.nearObjectDown());
        BabaIsYouGameGUIModel.setCharacter(new Point(4,3));
        assertFalse(theModel.nearObjectDown());
    }

    @Test
    void isPassable() {
        BabaIsYouGameGUIModel.setBabaObj(new Point(20, 20));
        BabaIsYouGameGUIModel.setIsObj(new Point(40, 20));
        BabaIsYouGameGUIModel.setPassObj(new Point(60, 20));
        assertTrue(theModel.isPassable());
        BabaIsYouGameGUIModel.setPassObj(new Point(20, 20));
        assertFalse(theModel.isPassable());
    }
}