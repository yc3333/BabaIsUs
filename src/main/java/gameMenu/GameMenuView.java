/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2021
 * Instructor: Prof. Chris Dancy
 *
 * Name: Tran Duc Anh
 * Section: 02 - 1:50pm to 2:40pm
 * Date: 4/26/21
 * Time: 18:26
 *
 * Project: CSCI205SP21finalproject
 * Package: gameMenu
 * Class: GameMenuView
 *
 * Description: Class storing most of the visual information for the GameMenu
 *
 * ****************************************
 */
package gameMenu;

import gameManager.GameManager;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.FileInputStream;

/**
 * Used to add visuals to the game menu in GameMenuMain
 */
public class GameMenuView {
    // root of the menu
    private VBox root;

    // play label
    private Label play;

    // image label for cool game name
    private Image image;

    // all other labels
    private Label instructions, settings, exit;


    /**
     * Configures the main menu visually by loading the required pictures, and generating
     * buttons or labels.
     */
    public GameMenuView(){
        // vertical root, set to min height + width, with id for background styling
        root = new VBox();
        root.getStyleClass().add("with-opaque-background");
        root.setId("menu-root");
        root.setMinHeight(GameManager.GAME_HEIGHT);
        root.setMinWidth(GameManager.GAME_WIDTH);
        root.setAlignment(Pos.CENTER);

        // get image for the Baba is Us game name
        File file;
        try {
            file = new File("src/main/Resources/image/baba-is-us-cropped.png");
            image = new Image(new FileInputStream(file));
        } catch (Exception e) {
            System.out.println("File wasn't found");
        }
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(125);
        imageView.setFitWidth(500);

        // margin between game name and options
        Region space_one = new Region();
        space_one.setPrefHeight(100);

        // options to choose from
        play = new Label("START THE GAME");
        instructions = new Label("GAME RULES");
        settings = new Label("SETTINGS");
        exit = new Label("EXIT");

        // add styling to the buttons
        play.getStyleClass().add("wide-blue-text");
        instructions.getStyleClass().add("wide-blue-text");
        settings.getStyleClass().add("wide-blue-text");
        exit.getStyleClass().add("wide-blue-text");

        // margin to balance out the vertical centering
        Region space_two = new Region();
        space_two.setPrefHeight(100);

        // add to root
        root.getChildren().addAll(imageView, space_one, play,
                instructions, settings, exit, space_two);
    }

    /**
     * Getters for the controller to attach events
     * @return - elements in the UI
     */

    public VBox getRoot() {
        return root;
    }

    public Label getPlay() {
        return play;
    }

    public Label getInstructions() {
        return instructions;
    }

    public Label getSettings() {
        return settings;
    }

    public Label getExit() {
        return exit;
    }
}