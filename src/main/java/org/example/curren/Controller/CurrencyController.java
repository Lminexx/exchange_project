package org.example.curren.Controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.example.curren.Currencies;

import java.net.URL;
import java.util.ResourceBundle;

public class CurrencyController  implements Initializable {
    @FXML
    private Label textLabel;

    @FXML
    private Label textNumber;
    private Stage stage;
    private Currencies currencies;
    private Controller controller;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

    }
    public void start() {
        try {
            // Загрузка fxml-файла вашего всплывающего окна
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com.example.currencies/currencyView.fxml"));
            Parent root = loader.load();
            // Создание сцены
            Scene scene = new Scene(root);
            // Создание нового окна
            stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Currency Popup");
            // Показать окно
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Label getTextLabel() {
        return textLabel;
    }

    public Label getTextNumber() {
        return textNumber;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
