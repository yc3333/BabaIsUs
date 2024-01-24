/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2021
 * Instructor: Prof. Chris Dancy
 *
 * Name: Tran Duc Anh
 * Section: 02 - 1:50pm to 2:40pm
 * Date: 4/26/21
 * Time: 23:32
 *
 * Project: CSCI205SP21finalproject
 * Package: gameMenu
 * Class: GameMenuController
 *
 * Description: Controller for the GameMenu
 *
 * ****************************************
 */
package gameMenu;

import javafx.application.Platform;
import javafx.scene.control.Label;
import gameManager.SceneManager;

/**
 * Controller for the game menu
 */
public class GameMenuController {

    // private SceneManager sceneManager;
    private GameMenuView view;

    /**
     * Attaches redirection events to the view
     * @param theView - view of the Game Menu
     */
    public GameMenuController(GameMenuView theView){
        view = theView;

        // get play label and attach root transition event
        Label play = view.getPlay();

        play.setOnMouseClicked(e->{
            play.getScene().setRoot(SceneManager.getSceneRoot(SceneManager.LEVEL_MENU));
        });

        // get view label and attach root transition event
        Label instruction = view.getInstructions();

        instruction.setOnMouseClicked(e->{
            instruction.getScene().setRoot(SceneManager.getSceneRoot(SceneManager.INSTRUCTIONS));
        });

        // get settings label and attach root transition event
        Label settings = view.getSettings();

        settings.setOnMouseClicked(e -> {
            settings.getScene().setRoot(SceneManager.getSceneRoot(SceneManager.SETTINGS));
        });

        // get exit label , and exit when clicked
        Label exit = view.getExit();

        exit.setOnMouseClicked(e->{
            Platform.exit();
        });
    }
}