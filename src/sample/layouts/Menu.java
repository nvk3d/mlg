package sample.layouts;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.models.MlgGame;
import sample.boxes.Confirm;
import sample.common.Sizes;
import sample.common.Words;

/**
 * Created by nvk3d on 12.06.17.
 */
public class Menu {
    private Stage window;
    private VBox layout;
    private Button contnue, newGame, stats, exit;
    private Label label;
    private MlgGame mlgGame;

    public Menu(Stage primaryStage) {
        // Получаем главное окно
        window = primaryStage;

        // Инициализируем конструктор
        layout = new VBox(20);
        // Ставим вывеску
        label = new Label();
        label.setText(Words.MLG_GAME);

        // Инициализируем кнопки
        // Продолжить игру
        contnue = new Button(Words.CONTINUE_BTN);
        contnue.setMinWidth(Sizes.MENU_BTN_WIDTH);

        // Новая игра
        newGame = new Button(Words.NEW_GAME_BTN);
        newGame.setMinWidth(Sizes.MENU_BTN_WIDTH);
        newGame.setOnAction(e -> {
            //mlgGame = new MlgGame(window);
            //mlgGame.start();
            LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
            cfg.title = "mlg";
            //cfg.useGL30 = true;
            cfg.width = 800;
            cfg.height = 600;

            new LwjglApplication(new MlgGame(window), cfg);
        });

        // Статистика
        stats = new Button(Words.STATS_BTN);
        stats.setMinWidth(Sizes.MENU_BTN_WIDTH);

        // Выход из игры
        exit = new Button(Words.EXIT_BTN);
        exit.setMinWidth(Sizes.MENU_BTN_WIDTH);
        exit.setOnAction(e -> closeProgram());

        // Ставим подтверждающее окно на крестик
        window.setOnCloseRequest(event -> {
            event.consume();
            closeProgram();
        });

        // Добавяляем все в конструктор меню
        layout.getChildren().addAll(label, contnue, newGame, stats, exit);
        layout.setAlignment(Pos.CENTER);
    }

    public VBox getLayout() {
        return layout;
    }

    private void closeProgram() {
        // Получаем ответ от подтверждаюего окна
        boolean result = Confirm.display(Words.CONFIRM_EXIT, Words.CONFIRM_QUESTION);
        if (result) {
            window.close();
        }
    }

}
