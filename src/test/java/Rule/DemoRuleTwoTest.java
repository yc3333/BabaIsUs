package Rule;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DemoRuleTwoTest {

    DemoRuleTwo demoRuleTwo = new DemoRuleTwo();

    private static Wall wallTest = new Wall(0,0);
    private static Rock rockTest = new Rock(40,80);
    private static Baba babaTest = new Baba(80,80);
    private static Is isTest = new Is(80,40);
    private static Win winObj = new Win(80,120 );

    @BeforeAll
    void setUp() {
        demoRuleTwo.setWallObjs(demoRuleTwo.wallObjs);
        demoRuleTwo.setObjs(demoRuleTwo.objs);
    }


    @Test
    void atObjectLocation() {
        GeneralObject rtnObj = demoRuleTwo.atObjectLocation(wallTest);
        assertEquals(demoRuleTwo.babaObj.getX(), rtnObj.getX());
        assertEquals(demoRuleTwo.babaObj.getY(), rtnObj.getY());

    }


    @Test
    void nearObjectRight() {
        GeneralObject rtnObj = demoRuleTwo.nearObjectRight(babaTest);
        assertNotEquals(demoRuleTwo.isObj.getX(), rtnObj.getX());
        assertNotEquals(demoRuleTwo.isObj.getY(), rtnObj.getY());
    }

    @Test
    void nearObjectLeft() {
        GeneralObject rtnObj = demoRuleTwo.nearObjectLeft(rockTest);
        assertEquals(demoRuleTwo.isObj.getX(), rtnObj.getX());
        assertEquals(demoRuleTwo.isObj.getY(), rtnObj.getY());
    }

    @Test
    void nearObjectUp() {
        GeneralObject rtnObj = demoRuleTwo.nearObjectUp(isTest);
        assertEquals(demoRuleTwo.isObj.getX(), rtnObj.getX());
        assertEquals(demoRuleTwo.isObj.getY(), rtnObj.getY());
    }

    @Test
    void nearObjectDown() {
        GeneralObject rtnObj = demoRuleTwo.nearObjectDown(winObj);
        assertEquals(demoRuleTwo.isObj.getX(), rtnObj.getX());
        assertEquals(demoRuleTwo.isObj.getY(), rtnObj.getY());
    }
}