/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2021
 * Instructor: Prof. Chris Dancy
 *
 * Name: Tran Duc Anh
 * Section: 02 - 1:50pm to 2:40pm
 * Date: 5/1/21
 * Time: 01:10
 *
 * Project: CSCI205SP21finalproject
 * Package: settingsPane
 * Class: SettingsController
 *
 * Description: Controller for instructions
 *
 * ****************************************
 */
package instructions;

import gameManager.SceneManager;
import javafx.scene.control.Button;

/**
 * Controller for instructions scene
 */
public class InstructionsController {
    // viewer of the instructions scene
    private InstructionsView view;

    /**
     * Attach a return-to-menu action to the instruction scene
     * @param theView - view of the instruction scene
     */
    public InstructionsController(InstructionsView theView){
        this.view = theView;

        Button menuButton = theView.getMenuButton();
        menuButton.setOnAction(e -> {
            menuButton.getScene().setRoot(SceneManager.getSceneRoot(SceneManager.GAME_MENU));
        });
    }
}