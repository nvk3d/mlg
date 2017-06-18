package sample.models;

import com.badlogic.gdx.Game;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sample.GameScreen;
import sample.common.Sizes;

/**
 * Created by nvk3d on 12.06.17.
 */
public class MlgGame extends Game {
    private Stage window;
    private Scene scene;
    private Group group;
    private Canvas canvas;
    private GraphicsContext gc;
    private Image background;
    private String pathToImages = "file:src/sample/resources/images/";

    public MlgGame(Stage primaryStage) {
        // Получаем главное окно
        window = primaryStage;
        // Инициализируем группу объектов
        group = new Group();
        // Полотно на котором рисуем
        canvas = new Canvas(Sizes.WINDOW_WIDTH, Sizes.WINDOW_HEIGHT);
        // Добавляем в корень
        group.getChildren().add(canvas);
        // Инициализируем рисовалку
        gc = canvas.getGraphicsContext2D();
        // Инициализация картинок
        background = new Image(pathToImages + "worm.png");
        // Инициализируем сцену
        scene = new Scene(group);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void create() {
        setScreen(new GameScreen());
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

}
