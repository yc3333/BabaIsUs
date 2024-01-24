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

import static javafx.application.Platform.exit;

public class TestGUIOne extends Application {
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
    protected static javafx.scene.paint.Color currentColor = defaultColor();

    /** The root */
    private static Group root;
    /** The in-game layout */
    private static javafx.scene.canvas.Canvas canvas;
    /** The in-game scene */
    protected static Scene scene;
    /** The stage */
    protected static Stage stage;

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

        //Initiate the character to Rule.Baba
        DemoRuleOne.player = DemoRuleOne.babaObj;

        //Initiate the objects list
        DemoRuleOne.setObjs(DemoRuleOne.objs);

        //Changing the characters coordinate based on key press
        keyboardInput();

        //Setting the scene
        stage.setScene(scene);
        stage.setTitle("Baba Is You");
        stage.show();



    }

    /**
     * Check the keyboard input and move the character
     */
    private void keyboardInput() {
        scene.setOnKeyPressed(event -> {

            code = event.getCode();
            DemoRuleOne.moveCharacter(code);
        });
    }

    /**
     * Run everything
     */
    private void run(){
        colorBackground();
        drawBabaObj();
        drawIsObj();
        drawRockObj();
        drawWinObj();
        DemoRuleOne.changeCharacter();
        DemoRuleOne.ruleChange();
        if (DemoRuleOne.isWin()){
            TestGUITwo secondLvl = new TestGUITwo();
            secondLvl.createScene();
            GameManager.gamePrimaryStage.setScene(secondLvl.getScene());
            timeline.stop();
        }
    }


    /**
     * Draw the objects
     */
    private void drawBabaObj(){
        gc.drawImage(DemoRuleOne.babaObj.getImage(), DemoRuleOne.babaObj.getX(), DemoRuleOne.babaObj.getY());
    }
    private void drawIsObj(){
        gc.drawImage(DemoRuleOne.isObj.getImage(), DemoRuleOne.isObj.getX(), DemoRuleOne.isObj.getY());
    }
    private void drawRockObj(){
        gc.drawImage(DemoRuleOne.rockObj.getImage(), DemoRuleOne.rockObj.getX(), DemoRuleOne.rockObj.getY());
    }
    private void drawWinObj(){
        gc.drawImage(DemoRuleOne.winObj.getImage(), DemoRuleOne.winObj.getX(), DemoRuleOne.winObj.getY());
    }


    /**
     * colors the background
     */
    private void colorBackground(){
        gc.setFill(javafx.scene.paint.Color.BLACK);
        gc.fillRect(0, 0, 800,800);
    }


    /**
     * Default color
     */
    private static javafx.scene.paint.Color defaultColor(){
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

        //Initiate the character to Rule.Baba
        DemoRuleOne.player = DemoRuleOne.babaObj;

        //Initiate the objects list
        DemoRuleOne.setObjs(DemoRuleOne.objs);

        //Changing the characters coordinate based on key press
        keyboardInput();

        //Timeline for character animation
        timeline = new Timeline(new KeyFrame(new Duration(10), e -> run()));
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