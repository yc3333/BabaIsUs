/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2021
 * Instructor: Prof. Chris Dancy
 *
 * Name: Nguyen Nguyen
 * Section: Section 02 - 1:50-2:42am
 * Date: 5/18/2021
 * Time: 11:55 AM
 *
 * Project: CSCI205SP21finalproject
 * Package: gameboard
 * Class: ExitScene
 *
 * Description: Once th game is won, this code outputs a victory screen.
 *
 * ****************************************
 */
package gameboard;

import gameManager.GameManager;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Used to display the game won message once the game is completed.
 */
public class ExitScene {
    /** The width of the board */
    private static final int WIDTH = 800;
    /** The height of the board */
    private static final int HEIGHT = 600;

    /** The scene */
    private static Scene exitScene;

    public static void generateMessage() {
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.getStyleClass().add("with-opaque-background");
        Label exitMessage = new Label("Congratulations!!! The game was easy, right?\nIt took a long time to develop though....\nIt's the end. Time to exit the game! \n               Team BaBaIsUs");
        exitMessage.getStyleClass().add("wide-blue-text");
        layout.getChildren().addAll(exitMessage);
        exitScene = new Scene(layout, WIDTH, HEIGHT);
        exitScene.getStylesheets().add(GameManager.styleSheet);
    }

    public static Scene getExitScene() {
        return exitScene;
    }
}
