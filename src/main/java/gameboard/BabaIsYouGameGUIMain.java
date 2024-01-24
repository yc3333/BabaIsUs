package gameboard;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The BabaIsYouGameGUI, with the game board, character and objects
 *
 *
 */
public class BabaIsYouGameGUIMain extends Application {
    private static Stage stage;

    /** The in-game scene */
    private static Scene scene;
    /** Setting up theModel, theView and theController */
    private BabaIsYouGameGUIModel theModel;
    private BabaIsYouGameGUIView theView;
    private BabaIsYouGameGUIController theController;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Initializing the model and the view
     * @throws Exception
     */
    @Override
    public void init() throws Exception{
        super.init();
        this.theModel = new BabaIsYouGameGUIModel();
        this.theView = new BabaIsYouGameGUIView(theModel);
    }

    @Override
    public void start(Stage primaryStage) {
        this.theController = new BabaIsYouGameGUIController(theView, theModel);
        //The stage
        stage = primaryStage;
        scene = new Scene(theView.getRoot());
        //Setting the scene
        stage.setScene(scene);
        stage.setTitle("Purple-Blue-RedPass-PinkWin");
        stage.show();
    }

    public static Parent getRoot() {
        BabaIsYouGameGUIModel model = new BabaIsYouGameGUIModel();
        BabaIsYouGameGUIView view = new BabaIsYouGameGUIView(model);
        BabaIsYouGameGUIController controller = new BabaIsYouGameGUIController(view, model);
        return view.getRoot();
    }

    public static Stage getStage() {
        return stage;
    }

    public static Scene getScene() {
        return scene;
    }
}

// gameMenu -> gameboard (model -> view -> controller (-> scene (-> model -> view -> controller)))
// gameboard (model -> view -> controller (->scene)) chac la