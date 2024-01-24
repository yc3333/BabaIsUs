/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2021
 * Instructor: Prof. Chris Dancy
 *
 * Name: Tran Duc Anh
 * Section: 02 - 1:50pm to 2:40pm
 * Date: 4/27/21
 * Time: 00:45
 *
 * Project: CSCI205SP21finalproject
 * Package: levelMenu
 * Class: LevelMenuView
 *
 * Description: UI for the level menu
 *
 * ****************************************
 */
package levelMenu;

import gameManager.GameManager;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * UI for the level menu
 */
public class LevelMenuView {
    // add roots
    private VBox root;

    // add labels (but are really buttons)
    private Label demo, level1, level2, level3;

    // button to return home
    private Button backToMenu;



    /**
     * Instantiate the view of the level menu
     */
    public LevelMenuView(){
        // create root and add styling
        root = new VBox();
        root.getStyleClass().add("with-opaque-background");
        root.setMinHeight(GameManager.GAME_HEIGHT);
        root.setMinWidth(GameManager.GAME_WIDTH);
        root.setAlignment(Pos.CENTER);

        // add all three labels + styling
        demo = new Label("Demo");
        level1 = new Label("Level 1");
        level2 = new Label("Level 2");
        level3 = new Label("Level 3");

        demo.getStyleClass().add("wide-blue-text");
        level1.getStyleClass().add("wide-blue-text");
        level2.getStyleClass().add("wide-blue-text");
        level3.getStyleClass().add("wide-blue-text");

        // add button and styling
        backToMenu = new Button("Return");
        backToMenu.getStyleClass().add("wide-blue-text");

        // add all nodes to root
        root.getChildren().addAll(demo,level1, level2, level3, backToMenu);
    }

    /**
     * Getters for the controller
     * @return - UI elements in the scene
     */
    public Label getDemo() {
        return demo;
    }
    public VBox getRoot() {
        return root;
    }
    public Label getLevel1() {
        return level1;
    }
    public Label getLevel2() {
        return level2;
    }
    public Label getLevel3() {
        return level3;
    }
    public Button getBackToMenu() {
        return backToMenu;
    }

}