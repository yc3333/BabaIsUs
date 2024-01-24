/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2021
 * Instructor: Prof. Chris Dancy
 *
 * Name: Tran Duc Anh
 * Section: 02 - 1:50pm to 2:40pm
 * Date: 5/16/21
 * Time: 17:14
 *
 * Project: CSCI205SP21finalproject
 * Package: settings
 * Class: SettingsView
 *
 * Description: THIS IS A DESCRIPTION Y’ALL AND I NEED TO CHANGE THIS!
 *
 * ****************************************
 */
package settings;

import gameManager.GameManager;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class SettingsView {
    private VBox root;

    private FlowPane volumeLine;

    private Slider volumeSlider;

    private Button backToMenu;

    public SettingsView(){
        root = new VBox();
        root.getStyleClass().add("with-opaque-background");
        root.setMinHeight(GameManager.GAME_HEIGHT);
        root.setMinWidth(GameManager.GAME_WIDTH);
        root.setAlignment(Pos.CENTER);

        volumeLine = new FlowPane(Orientation.HORIZONTAL);
        volumeLine.setAlignment(Pos.CENTER);
        volumeLine.setHgap(10);

        volumeSlider = new Slider();
        volumeSlider.setMin(0);
        volumeSlider.setMax(100);
        volumeSlider.setValue(50);
        volumeSlider.setPrefWidth(400);
        volumeSlider.setPrefHeight(100);

        volumeLine.getChildren().addAll(new Label("VOLUME"), volumeSlider);

        backToMenu = new Button("Return");

        root.getChildren().addAll(volumeLine, backToMenu);
    }

    public VBox getRoot() {
        return root;
    }

    public Slider getVolumeSlider() {
        return volumeSlider;
    }

    public Button getBackToMenu() {
        return backToMenu;
    }
}