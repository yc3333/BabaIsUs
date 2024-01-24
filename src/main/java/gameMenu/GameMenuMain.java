package gameMenu;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main Application to run the GameMenu, loads in a GameMenuView to load the visuals
 */
public class GameMenuMain extends Application {

    // view for the menu
    private GameMenuView theView;

    /**
     * Main method for calling the game from cmd line
     * @param args - arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Initialize the game with the view
     * @throws Exception
     */
    @Override
    public void init() throws Exception {
        super.init();
        this.theView = new GameMenuView();
    }

    /**
     * Add logic and show
     * @param primaryStage - stage to show
     */
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(theView.getRoot());
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.setTitle("Rule.Baba is Us");
        primaryStage.show();
    }

    /**
     * gets the root of the game
     * @return - the root of the game with controls attached
     */
    public static Parent getRoot(){
        GameMenuView view = new GameMenuView();
        GameMenuController controller = new GameMenuController(view);
        return view.getRoot();
    }
}
