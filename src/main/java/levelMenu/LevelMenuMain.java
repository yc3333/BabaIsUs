package levelMenu;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LevelMenuMain extends Application {

    // view for the menu
    private LevelMenuView theView;

    // main method
    public static void main(String[] args) {
        launch(args);
    }

    // mainly for testing
    @Override
    public void init() throws Exception {
        super.init();
        this.theView = new LevelMenuView();
    }

    // mainly for testing
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(theView.getRoot());
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.setTitle("Rule.Baba is Us");
        primaryStage.show();
    }

    /**
     * Gets the root + controller attachment, then return the root
     * @return - the root of the level menu
     */
    public static Parent getRoot(){
        LevelMenuView view = new LevelMenuView();
        LevelMenuController controller = new LevelMenuController(view);
        return view.getRoot();
    }
}