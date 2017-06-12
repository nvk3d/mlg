package sample.layouts;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Boxes.Confirm;
import sample.common.Words;

/**
 * Created by nvk3d on 12.06.17.
 */
public class Menu {
    private Stage window;
    private VBox layout;
    private Button contnue, newGame, stats, exit;
    private Label label;

    public Menu (Stage primaryStage) {
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

        // Новая игра
        newGame = new Button(Words.NEW_GAME_BTN);

        // Статистика
        stats = new Button(Words.STATS_BTN);

        // Выход из игры
        exit = new Button(Words.EXIT_BTN);
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
