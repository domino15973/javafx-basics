package com.example.javafxbasics;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    private Stage stage;
    private Scene scene;

    public void switchToCalculator(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("calculator.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setTitle("Calculator");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToToDoList(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("todolist.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setTitle("ToDoList");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToWeatherApp(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("weatherapp.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setTitle("WeatherApp");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}
