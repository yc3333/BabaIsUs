/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2021
 * Instructor: Prof. Chris Dancy
 *
 * Name: Tran Duc Anh
 * Section: 02 - 1:50pm to 2:40pm
 * Date: 5/1/21
 * Time: 01:05
 *
 * Project: CSCI205SP21finalproject
 * Package: levelMenu
 * Class: LevelMenuController
 *
 * Description: controller for the level menu
 *
 * ****************************************
 */
package levelMenu;

import gameManager.GameManager;
import gameManager.SceneManager;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import Rule.TestGUIOne;
import Rule.TestGUITwo;
import Rule.TestGUIThree;

/**
 * Controls the redirection of the level menu
 */
public class LevelMenuController {
    // view of the level menu
    private LevelMenuView view;

    /**
     * Attaches redirection events for all elemts
     * @param theView - ui of the level menu
     */
    public LevelMenuController(LevelMenuView theView){
        this.view = theView;

        // attach return to game menu
        Button menuButton = view.getBackToMenu();

        menuButton.setOnAction(e->{
            menuButton.getScene().setRoot(SceneManager.getSceneRoot(SceneManager.GAME_MENU));
        });

        Label demo = view.getDemo();
        demo.setOnMouseClicked(e->{
            demo.getScene().setRoot(SceneManager.getSceneRoot(SceneManager.GAMEPLAY));
        });

        // for all three labels, redirect to the appropriate scene
        Label lvlOne = view.getLevel1();
        Label lvlTwo = view.getLevel2();
        Label lvlThree = view.getLevel3();

        lvlOne.setOnMouseClicked(e->{
            TestGUIOne firstLvl = new TestGUIOne();
            firstLvl.createScene();
            GameManager.gamePrimaryStage.setScene(firstLvl.getScene());
        });

        lvlTwo.setOnMouseClicked(e->{
            TestGUITwo secondLvl = new TestGUITwo();
            secondLvl.createScene();
            GameManager.gamePrimaryStage.setScene(secondLvl.getScene());
        });

        lvlThree.setOnMouseClicked(e->{
            TestGUIThree thirdLvl = new TestGUIThree();
            thirdLvl.createScene();
            GameManager.gamePrimaryStage.setScene(thirdLvl.getScene());
        });
    }
}