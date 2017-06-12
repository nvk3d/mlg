package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.common.Sizes;
import sample.layouts.Menu;

public class Main extends Application {
    Stage window;
    Scene main;
    sample.layouts.Menu menu;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        // Инициализируем меню
        menu = new Menu(primaryStage);
        // Ставим сцену
        main = new Scene(menu.getLayout(), Sizes.WINDOW_WIDTH, Sizes.WINDOW_HEIGHT);
        window.setScene(main);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
