package gui;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class SettingsScene extends Pane {
    private Button begin;
    private Button next;
    boolean nameOffer;
    private Text error;
    public  String size;

    private VBox vbox = new VBox();

    public Button getBeginButton() {
        return begin;
    }

    public SettingsScene() {
        getChildren().add(vbox);
        begin = new Button("Начать игру");
        firstName();
    }

    private void firstName() {
        TextField text11 = new TextField();
        next = new Button("Далее");
        if (!nameOffer) {
            Text text1 = new Text(10, 20, "Первый игрок, введите своё имя:");
            vbox.getChildren().add(text1);
            vbox.getChildren().add(text11);
            vbox.getChildren().add(next);
            nameOffer = true;
        }
        next.setOnAction(event -> {
            if (text11.getText().isEmpty()) emptyName(1);
            else {
                nameOffer = false;
                secondName();
            }
        });
    }

    private void secondName() {
        TextField text22 = new TextField();
        next = new Button("Далее");
        if (!nameOffer) {
            Text text2 = new Text(10, 20, "Второй игрок, введите своё имя:");
            vbox.getChildren().add(text2);
            vbox.getChildren().add(text22);
            vbox.getChildren().add(next);
            nameOffer = true;
        }
        next.setOnAction(event -> {
            if (text22.getText().isEmpty()) emptyName(2);
            else {
                nameOffer = false;
                fieldSize();
            }
        });
    }

    private void fieldSize() {
        TextField text33 = new TextField();
        next = new Button("Далее");
        if (!nameOffer) {
            Text text3 = new Text(10, 20, "Введите размер поля:");
            vbox.getChildren().add(text3);
            vbox.getChildren().add(text33);
            vbox.getChildren().add(next);
            nameOffer = true;
        }
        next.setOnAction(event -> {
            Text error1 = new Text(10, 20, "Введите размер поля");
            Text error2 = new Text(10, 20, "Введите корректный размер поля," +
                    "значение не менее 3 и не более 9");
            String size = text33.getText();
            if (text33.getText().isEmpty()) {
                vbox.getChildren().add(error1);
                fieldSize();
            } else if (size.length() > 1 || size.charAt(0) < '3' || size.charAt(0) > '9') {
                vbox.getChildren().add(error2);
                fieldSize();
            } else {
                size = text33.getText();
                vbox.getChildren().add(begin);
            }
        });
    }

    private void emptyName(int i) {
        Text error = new Text(10, 20, "Имя не может быть пустым,попробуйте еще раз:");
        vbox.getChildren().add(error);
        if (i == 1) firstName();
        else secondName();
    }
}

