package instructions;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;
import levelMenu.LevelMenuController;
import levelMenu.LevelMenuView;

/**
 * Main instructions scene for the game
 */
public class InstructionsMain extends Application {

    // main method
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Default, not really used
     * @param primaryStage - stage to show the scene
     */
    @Override
    public void start(Stage primaryStage) {

    }

    /**
     * Gets the root of the scene, with controllers attached
     * @return - the root of the instruction scene
     */
    public static Parent getRoot(){
        InstructionsView view = new InstructionsView();
        InstructionsController controller = new InstructionsController(view);
        return view.getRoot();
    }
}
