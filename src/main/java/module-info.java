module com.example.javafxbasics {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;


    opens com.example.javafxbasics to javafx.fxml;
    exports com.example.javafxbasics;
}