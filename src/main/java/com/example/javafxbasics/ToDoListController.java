package com.example.javafxbasics;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ToDoListController {

    public void switchToMenu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("menu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Menu");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private TextField textField;
    @FXML
    private VBox checkboxContainer;
    @FXML
    private Label completedTasksLabel;

    @FXML
    private void createCheckbox() {
        CheckBox checkBox = new CheckBox(textField.getText());
        checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> updateCompletedTasks(checkBox));
        checkboxContainer.getChildren().add(checkBox);
        textField.clear();
    }

    @FXML
    private void deleteAllTasks() {
        checkboxContainer.getChildren().clear();
        completedTasksLabel.setText("");
    }

    private void updateCompletedTasks(CheckBox checkBox) {
        String completedTasksText = completedTasksLabel.getText();
        if (checkBox.isSelected()) {
            completedTasksText += checkBox.getText() + "\n";
            checkboxContainer.getChildren().remove(checkBox);
        } else {
            completedTasksText = completedTasksText.replace(checkBox.getText() + "\n", "");
        }
        completedTasksLabel.setText(completedTasksText);
    }
}
