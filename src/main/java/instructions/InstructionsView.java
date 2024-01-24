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
 * Class: SettingsView
 *
 * Description: UI for the instructions scene
 *
 * ****************************************
 */
package instructions;

import gameManager.GameManager;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * UI for the instructions scene
 */
public class InstructionsView {
    // root node
    private VBox root;

    // Text node for the game explanations
    private Text gameExplanations;
    // Scroller for the game explanations
    private ScrollPane explanationsScroller;

    // return to menu button
    private Button menuButton;

    /**
     * Create the instruction scene view
     */
    public InstructionsView(){
        // add root with styling + centering
        root = new VBox();
        root.getStyleClass().add("with-opaque-background");
        root.setMinHeight(GameManager.GAME_HEIGHT);
        root.setMinWidth(GameManager.GAME_WIDTH);
        root.setAlignment(Pos.CENTER);

        // create the game explanation and style it
        gameExplanations = new Text("Baba is Us game rules: \n\n\n" +
                "There are three different kinds of blocks to " +
                "make rules in the game, ones representing " +
                "Objects in the level, ones representing actions, " +
                "and ones used to connect these together.\n\n" +
                "In the demo, the main objective is to connect the Purple-Blue-Pink blocks horizontally to move to the next level" +
                " To assist this, you can connect the Purple-Blue-Red blocks to walk through walks." +
                " To move your character, simply use the arrow buttons on your keyboard." +
                " Orange blocks are walls, and can't be pushed. Every other objects are pushable.\n\n" +
                "In the 3 levels (currently in alpha), the objective is to go reach the 'win' block" +
                " by breaking or creating 3-block rules that exist in the level. These rules" +
                " let you change characters, move immovable objects, and more. \n\n" +
                "Have fun!"
        );
        gameExplanations.setFill(Color.WHITE);
        gameExplanations.setWrappingWidth(600);
        gameExplanations.setTextAlignment(TextAlignment.JUSTIFY);

        // create scroll pane, attach game explanations
        explanationsScroller = new ScrollPane();
        explanationsScroller.setContent(gameExplanations);
        explanationsScroller.setPrefHeight(400);
        explanationsScroller.setMaxWidth(650);

        // margin between game name and options
        Region space_one = new Region();
        space_one.setPrefHeight(50);

        // create button
        menuButton = new Button("Return");

        // add all elements to root node
        root.getChildren().addAll(explanationsScroller, space_one, menuButton);
    }

    /**
     * Getters for the controller
     * @return - UI elements
     */
    public VBox getRoot() {
        return root;
    }
    public Text getGameExplanations() {
        return gameExplanations;
    }
    public Button getMenuButton() {
        return menuButton;
    }
}