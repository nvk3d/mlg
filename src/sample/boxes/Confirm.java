package sample.boxes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.common.Sizes;
import sample.common.Words;

/**
 * Created by nvk3d on 12.06.17.
 */
public class Confirm {
    private static Stage window;
    private static Label label;
    private static VBox layout;
    private static Scene scene;
    private static Button yes, no;
    private static boolean answer;

    public static boolean display(String title, String message) {
        // Создаем новое окно
        window = new Stage();
        // Указываем тип
        window.initModality(Modality.APPLICATION_MODAL);
        window.setResizable(false);
        window.setTitle(title);
        window.setWidth(Sizes.CONFIRM_WINDOW_WIDTH);
        window.setHeight(Sizes.CONFIRM_WINDOW_HEIGHT);
        // Надпись
        label = new Label();
        label.setText(message);

        yes = new Button(Words.YES_BTN);
        yes.setMinWidth(Sizes.CONFIRM_BTN_WIDTH);
        // Закрываем это окно при клике на yes
        // и отдаем положительный результат завершения программы
        yes.setOnAction(event -> {
            answer = true;
            window.close();
        });

        no = new Button(Words.NO_BTN);
        no.setMinWidth(Sizes.CONFIRM_BTN_WIDTH);
        // Закрываем окно при клике на no
        // и отдаем отрицательный результат завершения программы
        no.setOnAction(event -> {
            answer = false;
            window.close();
        });

        layout = new VBox(10);
        layout.getChildren().addAll(label, yes, no);
        layout.setAlignment(Pos.CENTER);
        // Новая сцена
        scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }

}
