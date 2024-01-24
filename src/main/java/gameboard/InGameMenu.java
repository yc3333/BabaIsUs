package gameboard;/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2021
 * Instructor: Prof. Chris Dancy
 *
 * Name: Nguyen Nguyen
 * Section: Section 02 - 1:50-2:42am
 * Date: 5/2/2021
 * Time: 8:03 PM
 *
 * Project: CSCI205SP21finalproject
 * Package: PACKAGE_NAME
 * Class: gameboard.InGameMenu
 *
 * Description: THIS IS A DESCRIPTION Y’ALL AND I NEED TO CHANGE THIS!
 *
 * ****************************************
 */

import gameManager.SceneManager;
import gameboard.BabaIsYouGameGUIMain;
import gameboard.BabaIsYouGameGUIModel;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import gameManager.GameManager;

import java.io.File;

public class InGameMenu {
    /** The width of the board */
    private static final int WIDTH = 800;
    /** The height of the board */
    private static final int HEIGHT = 600;
    /** The BabaIsYou game GUI */
    private static BabaIsYouGameGUIMain gameGUI;
    /** The scenes */
    private static Scene menuScene, hintScene, customizeScene;
    private static BabaIsYouGameGUIModel theModel;
    private static BabaIsYouGameGUIController theController;

    /**
     * Generate the in-game menu after ESC is pressed while playing. Loads up a
     * menu with options for the game, hints, a way to restart, and exit the game.
     */
    public static void generateInGameMenu() {
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.getStyleClass().add("with-opaque-background");

        Button returnButton = new Button("Return");
        returnButton.setOnAction(event -> {
            GameManager.gamePrimaryStage.setScene(GameManager.scene);
        });
        Button customizeButton = new Button("Pick theme");
        customizeButton.setOnAction(event -> {
            GameManager.gamePrimaryStage.setScene(customizeScene);
        });
        Button restartButton = new Button("Restart");
        restartButton.setOnAction(event -> {
            System.out.println(BabaIsYouGameGUIController.getCurrentLvl());
            if (BabaIsYouGameGUIController.getCurrentLvl() == 1) {
                BabaIsYouGameGUIController.setCountLvl1(0);
            }
            else if (BabaIsYouGameGUIController.getCurrentLvl() == 2)
                BabaIsYouGameGUIController.setCountLvl2(0);
            else if (BabaIsYouGameGUIController.getCurrentLvl() == 3)
                BabaIsYouGameGUIController.setCountLvl3(0);
        });
        Button hintButton = new Button("Get hint");
        hintButton.setOnAction(event -> {
            GameManager.gamePrimaryStage.setScene(hintScene);
        });
        Button goToMainMenu = new Button("Main menu");
        goToMainMenu.setOnAction(e -> {
            GameManager.scene.setRoot(SceneManager.getSceneRoot(SceneManager.GAME_MENU));
            GameManager.gamePrimaryStage.setScene(GameManager.scene);
        });

        returnButton.getStyleClass().add("wide-blue-text");
        customizeButton.getStyleClass().add("wide-blue-text");
        restartButton.getStyleClass().add("wide-blue-text");
        hintButton.getStyleClass().add("wide-blue-text");
        goToMainMenu.getStyleClass().add("wide-blue-text");

        layout.getChildren().addAll(returnButton, customizeButton, restartButton, hintButton, goToMainMenu);

        menuScene = new Scene(layout, WIDTH, HEIGHT);
        menuScene.getStylesheets().add(GameManager.styleSheet);
    }

    /**
     * Go to the hints
     * Creates a layout with a go back button and labels as hints.
     */
    public static void generateHint(){
        VBox hintLayout = new VBox();
        hintLayout.setAlignment(Pos.CENTER);
        hintLayout.getStyleClass().add("with-opaque-background");

        Button backButton = new Button("Return");
        backButton.setOnAction(event -> {
            GameManager.gamePrimaryStage.setScene(menuScene);
        });
        backButton.getStyleClass().add("wide-blue-text");

        Label hint1 = new Label("Hint for lvl 1: Purple-Blue-Red to pass through Orange,\nPurple-Blue-Pink to win and go to next level");

        Label hint2 = new Label("Hint for lvl 2: Same as level 1                        ");

        Label hint3 = new Label("Hint for lvl 3: get Purple-Blue-Red first              ");
        hintLayout.getChildren().addAll(hint1, hint2, hint3, backButton);
        hint1.getStyleClass().add("wide-blue-text");
        hint2.getStyleClass().add("wide-blue-text");
        hint3.getStyleClass().add("wide-blue-text");
        hintScene = new Scene(hintLayout, WIDTH, HEIGHT);
        hintScene.getStylesheets().add(GameManager.styleSheet);
    }

    /**
     * Go to the part where we can customize the colors
     * Generate a layout with a go-back button and radio buttons to change colors
     */
    public static void generateCustomizeTheme(){
        VBox customizeLayout = new VBox();
        customizeLayout.getStyleClass().add("with-opaque-background");
        customizeLayout.setAlignment(Pos.CENTER);

        Button backButton = new Button("Return");
        backButton.setOnAction(event -> {
            GameManager.gamePrimaryStage.setScene(menuScene);
        });

        VBox radioButtonHolder = new VBox();
        radioButtonHolder.setAlignment(Pos.TOP_LEFT);
        radioButtonHolder.setMaxHeight(120);
        radioButtonHolder.setMaxWidth(400);

        Label temp1 = new Label("Adjust character color");

        RadioButton btnCharBlue = new RadioButton("Blue");

        RadioButton btnCharWhite = new RadioButton("White");
        btnCharWhite.setOnAction(event -> {
            theModel.setCurrentColor(Color.WHITE);
        });
        RadioButton btnCharYellow = new RadioButton("Yellow");
        btnCharYellow.setOnAction(event -> {
            theModel.setCurrentColor(Color.YELLOW);
        });

        radioButtonHolder.getChildren().addAll(temp1, btnCharWhite, btnCharYellow);

        customizeLayout.getChildren().addAll(radioButtonHolder, backButton);
        customizeScene = new Scene(customizeLayout, WIDTH, HEIGHT);
        customizeScene.getStylesheets().add(GameManager.styleSheet);
    }

    /** Get the menu scene */
    public static Scene getMenuScene() {
        return menuScene;
    }
}
