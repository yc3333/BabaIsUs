/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2021
 * Instructor: Prof. Chris Dancy
 *
 * Name: Tran Duc Anh
 * Section: 02 - 1:50pm to 2:40pm
 * Date: 5/16/21
 * Time: 13:55
 *
 * Project: CSCI205SP21finalproject
 * Package: mediaPlayer
 * Class: MusicPlayer
 *
 * Description: Music player for the game
 *
 * ****************************************
 */
package mediaPlayer;


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.io.File;
import java.nio.file.Paths;

/**
 * Music player: handles the music loading + volume
 */
public class MusicPlayer {

    // must be here for reference + if deleted, gets garbage collected
    public static MediaPlayer player;

    /**
     * Gets the music file
     * @param filepath - path to the music
     */
    public static void getMedia(String filepath){
        Media media = new Media(Paths.get(new File(".").getAbsolutePath()
                +filepath).toUri().toString());
        player = new MediaPlayer(media);
    }


    /**
     * Attaches settings to make the music loop
     */
    public static void putMediaOnLoop(){
        MediaView viewer = new MediaView();
        viewer.setMediaPlayer(player);
        player.setAutoPlay(true);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        player.seek(Duration.ZERO);
        player.setOnEndOfMedia(() -> {
            player.seek(Duration.ZERO);
            player.play();
        });
    }

    /**
     * Adjust the volume of the music
     * @param vol - loudness (from 0 - 100)
     */
    public static void adjustVolume(double vol){
        player.setVolume(vol/100);
    }
}