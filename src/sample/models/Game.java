package sample.models;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sample.common.Sizes;

/**
 * Created by nvk3d on 12.06.17.
 */
public class Game {
    private Stage window;
    private Scene scene;
    private Group group;
    private Canvas canvas;
    private GraphicsContext gc;
    private Image background;
    private String pathToImages = "file:src/sample/resources/images/";

    public Game(Stage primaryStage) {
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

    public void start() {
        gc.drawImage(background, 0, 0);
        window.setScene(scene);
    }

}
