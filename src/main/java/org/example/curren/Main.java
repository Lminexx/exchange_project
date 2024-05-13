package org.example.curren;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;
public class Main extends Application {
    public static void main(String[] args) {
        launch();

    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("/com.example.currencies/sample.fxml")));
        stage.setTitle("Currencies project");
        stage.setScene(new Scene(root,834,500));
        stage.show();
    }
}
