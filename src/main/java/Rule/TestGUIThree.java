package Rule;

import gameManager.GameManager;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import gameboard.ExitScene;

import static javafx.application.Platform.exit;

public class TestGUIThree extends Application {
    /** The width of the board */
    private static final int WIDTH = 800;
    /** The height of the board */
    private static final int HEIGHT = 800;
    /** The number of rows of the board */
    private static final int ROWS = 40;
    /** The number of columns of the board */
    private static final int COLUMNS = 40;
    /** The size of a square */
    private static final int SQUARE_SIZE = WIDTH/ROWS;


    /** Graphics for game */
    private GraphicsContext gc;


    /** For character movement */
    private int moveUp = 1;
    private int moveDown = 1;
    private int moveRight = 1;
    private int moveLeft = 1;


    /** Character color */
    protected static Color currentColor = defaultColor();

    /** The root */
    private static Group root;
    /** The in-game layout */
    private static Canvas canvas;
    /** The in-game scene */
    protected static Scene scene;
    /** The stage */
    protected static Stage stage;
    /** The in-game menu */
    private KeyCode code;
    private Timeline timeline;

    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) {
        //The stage
        stage = primaryStage;
        //Setting up the screen...
        root = new Group();
        canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);
        scene = new Scene(root);

        //Initiate the graphic context gc
        gc = canvas.getGraphicsContext2D();

        //Initiate the character to Baba
        DemoRuleThree.player = DemoRuleThree.babaObj;

        //Initiate the objects list
        DemoRuleThree.setWallObjs(DemoRuleThree.wallObjs);
        DemoRuleThree.setObjs(DemoRuleThree.objs);

        //Changing the characters coordinate based on key press
        keyboardInput();

        //Setting the scene
        stage.setScene(scene);
        stage.setTitle("BabaIs You");
        stage.show();


    }

    private void keyboardInput() {
        scene.setOnKeyPressed(event -> {

            code = event.getCode();
            DemoRuleThree.moveCharacter(code);
        });
    }

    private void run(){
        colorBackground();
        drawBabaObj();
        drawIsObj();
        drawWallObj();
        drawWallText();
        drawStopObj();
        drawWinObj();
        drawWallKeyObj();
        DemoRuleThree.changeCharacter();
        DemoRuleThree.ruleChange();
        if (DemoRuleThree.isWin()){
            ExitScene.generateMessage();
            GameManager.gamePrimaryStage.setScene(ExitScene.getExitScene());
            timeline.stop();
        };
    }



    private void drawBabaObj(){
        gc.drawImage(DemoRuleThree.babaObj.getImage(), DemoRuleThree.babaObj.getX(), DemoRuleThree.babaObj.getY());
    }
    private void drawIsObj(){
        gc.drawImage(DemoRuleThree.isObjOne.getImage(), DemoRuleThree.isObjOne.getX(), DemoRuleThree.isObjOne.getY());
        gc.drawImage(DemoRuleThree.isObjTwo.getImage(), DemoRuleThree.isObjTwo.getX(), DemoRuleThree.isObjTwo.getY());
    }
    private void drawWallText(){
        gc.drawImage(DemoRuleThree.wallTextOne.getImage(), DemoRuleThree.wallTextOne.getX(), DemoRuleThree.wallTextOne.getY());
        gc.drawImage(DemoRuleThree.wallTextTwo.getImage(), DemoRuleThree.wallTextTwo.getX(), DemoRuleThree.wallTextTwo.getY());
    }
    private void drawWinObj(){
        gc.drawImage(DemoRuleThree.winObj.getImage(), DemoRuleThree.winObj.getX(), DemoRuleThree.winObj.getY());
    }
    private void drawStopObj(){
        gc.drawImage(DemoRuleThree.stopObj.getImage(), DemoRuleThree.stopObj.getX(), DemoRuleThree.stopObj.getY());
    }
    private void drawWallKeyObj() {
        gc.drawImage(DemoRuleThree.wallKeyObj.getImage(), DemoRuleThree.wallKeyObj.getX(), DemoRuleThree.wallKeyObj.getY());
    }
    private void drawWallObj(){
        for (Wall wall:DemoRuleThree.wallObjs) {
            gc.drawImage(wall.getImage(), wall.getX(), wall.getY());
        }
    }


    /**
     * colors the background
     */
    private void colorBackground(){
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 800,800);
    }


    /**
     * Default color
     */
    private static Color defaultColor(){
        return Color.WHITE;
    }

    /**
     * Creates the scene normally, so that we can call from other scenes
     * Only change from start() is that it does not use stage
     */
    public void createScene(){
        //Setting up the screen...
        root = new Group();
        canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);
        scene = new Scene(root);

        //Initiate the graphic context gc
        gc = canvas.getGraphicsContext2D();

        //Initiate the character to Baba
        DemoRuleThree.player = DemoRuleThree.babaObj;

        //Initiate the objects list
        DemoRuleThree.setWallObjs(DemoRuleThree.wallObjs);
        DemoRuleThree.setObjs(DemoRuleThree.objs);

        //Changing the characters coordinate based on key press
        keyboardInput();

        //Timeline for character animation
        timeline = new Timeline(new KeyFrame(new Duration(100), e -> run()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    /**
     * @return - the scene
     */
    public Scene getScene(){
        return scene;
    }
}