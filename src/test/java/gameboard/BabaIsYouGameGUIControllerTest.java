package gameboard;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BabaIsYouGameGUIControllerTest {

    @Test
    void isNextLvl() {
        BabaIsYouGameGUIModel.setBabaObj(new Point(20, 20));
        BabaIsYouGameGUIModel.setIsObj(new Point(40, 20));
        BabaIsYouGameGUIModel.setWinObj(new Point(60, 20));
        assertTrue(BabaIsYouGameGUIController.isNextLvl());
        BabaIsYouGameGUIModel.setWinObj(new Point(20, 20));
        assertFalse(BabaIsYouGameGUIController.isNextLvl());
    }

}