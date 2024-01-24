package settings;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import levelMenu.LevelMenuView;

public class SettingsMain extends Application {

    private SettingsView theView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
        this.theView = new SettingsView();
    }


    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(theView.getRoot());

        primaryStage.sizeToScene();
        primaryStage.sizeToScene();
        primaryStage.setTitle("Baba is Us");
        primaryStage.show();
    }

    public static Parent getRoot(){
        SettingsView view = new SettingsView();
        SettingsController controller = new SettingsController(view);
        return view.getRoot();
    }

}
