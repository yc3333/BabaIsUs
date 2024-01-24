/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2021
 * Instructor: Prof. Chris Dancy
 *
 * Name: Tran Duc Anh
 * Section: 02 - 1:50pm to 2:40pm
 * Date: 5/16/21
 * Time: 17:38
 *
 * Project: CSCI205SP21finalproject
 * Package: settings
 * Class: SettingsController
 *
 * Description: THIS IS A DESCRIPTION Y’ALL AND I NEED TO CHANGE THIS!
 *
 * ****************************************
 */
package settings;

import gameManager.SceneManager;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import mediaPlayer.MusicPlayer;


public class SettingsController {
    private SettingsView view;

    public SettingsController(SettingsView theView){
        this.view = theView;

        Slider volumeSlider = view.getVolumeSlider();
        volumeSlider.valueProperty().addListener(e ->{
            System.out.println("VALUE IS:" + volumeSlider.getValue());
            MusicPlayer.adjustVolume(volumeSlider.getValue());
        });
        // volumeSlider.setOnDragDetected(e->{
        //     System.out.println("VALUE IS:" + volumeSlider.getValue());
        // });

        Button returnButton = view.getBackToMenu();
        returnButton.setOnAction(e->{
            returnButton.getScene().setRoot(SceneManager.getSceneRoot(SceneManager.GAME_MENU));
        });
    }
}