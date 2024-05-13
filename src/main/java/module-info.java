module org.example.curren{
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jsoup;
    requires java.desktop;
    exports org.example.curren;
    opens org.example.curren to javafx.fxml;
    exports org.example.curren.Controller;
    opens org.example.curren.Controller to javafx.fxml;
}