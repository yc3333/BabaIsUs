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

public class TestGUITwo extends Application {
    /** The width of the board */
    private static final int WIDTH = 800;
    /** The height of the board */
    private static final int HEIGHT = 600;
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
    public static Scene scene;
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

        //Initiate the character to Rule.Baba
        DemoRuleTwo.player = DemoRuleTwo.babaObj;

        //Initiate the objects list
        DemoRuleTwo.setWallObjs(DemoRuleTwo.wallObjs);
        DemoRuleTwo.setObjs(DemoRuleTwo.objs);

        //Changing the characters coordinate based on key press
        keyboardInput();

        //Setting the scene
        stage.setScene(scene);
        stage.setTitle("Baba Is You");
        stage.show();


    }

    private void keyboardInput() {
        scene.setOnKeyPressed(event -> {

            code = event.getCode();
            DemoRuleTwo.moveCharacter(code);
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
        DemoRuleTwo.changeCharacter();
        DemoRuleTwo.ruleChange();
        if (DemoRuleTwo.isWin()){
            TestGUIThree thirdLvl = new TestGUIThree();
            thirdLvl.createScene();
            GameManager.gamePrimaryStage.setScene(thirdLvl.getScene());
            timeline.stop();
        };
    }



    private void drawBabaObj(){
        gc.drawImage(DemoRuleTwo.babaObj.getImage(), DemoRuleTwo.babaObj.getX(), DemoRuleTwo.babaObj.getY());
    }
    private void drawIsObj(){
        gc.drawImage(DemoRuleTwo.isObj.getImage(), DemoRuleTwo.isObj.getX(), DemoRuleTwo.isObj.getY());
    }
    private void drawWallText(){
        gc.drawImage(DemoRuleTwo.wallText.getImage(), DemoRuleTwo.wallText.getX(), DemoRuleTwo.wallText.getY());
    }
    private void drawWinObj(){
        gc.drawImage(DemoRuleTwo.winObj.getImage(), DemoRuleTwo.winObj.getX(), DemoRuleTwo.winObj.getY());
    }
    private void drawStopObj(){
        gc.drawImage(DemoRuleTwo.stopObj.getImage(), DemoRuleTwo.stopObj.getX(), DemoRuleTwo.stopObj.getY());
    }
    private void drawWallObj(){
        for (Wall wall:DemoRuleTwo.wallObjs) {
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

        //Initiate the character to Rule.Baba
        DemoRuleTwo.player = DemoRuleTwo.babaObj;

        //Initiate the objects list
        DemoRuleTwo.setWallObjs(DemoRuleTwo.wallObjs);
        DemoRuleTwo.setObjs(DemoRuleTwo.objs);

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