package com.example.javafxbasics;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorController {

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
    private Text savedNumbers;
    private String firstNumber = "";
    private String currentNumber = "";
    private String calculationType;

    @FXML
    void addAction() {
        calculationSetup("+");
    }

    @FXML
    void minusAction() {
        calculationSetup("-");
    }

    @FXML
    void multiplicationAction() {
        calculationSetup("*");
    }

    @FXML
    void divideAction() {
        calculationSetup("/");
    }

    @FXML
    void percentageAction() {
        calculationSetup("%");
    }

    @FXML
    void rootingAction() {
        calculationSetup("sqrt");
        double calculatedNumber = Math.sqrt(Double.parseDouble(firstNumber));
        savedNumbers.setText("sqrt(" + firstNumber + ") = " + calculatedNumber);
        textField.setText(String.valueOf(calculatedNumber));
    }

    public void calculationSetup(String calculationType){
        this.calculationType = calculationType;
        firstNumber = currentNumber;
        currentNumber = "";
        savedNumbers.setText(firstNumber + " " + calculationType);
    }

    @FXML
    void calculate() {
        double firstNumberDouble = Double.parseDouble(firstNumber);
        double secondNumberDouble = Double.parseDouble(currentNumber);

        switch (calculationType) {
            case "+" -> {
                double calculatedNumber = firstNumberDouble + secondNumberDouble;
                savedNumbers.setText(firstNumber + " + " + currentNumber + " = " + calculatedNumber);
                textField.setText(String.valueOf(calculatedNumber));
            }
            case "-" -> {
                double calculatedNumber = firstNumberDouble - secondNumberDouble;
                savedNumbers.setText(firstNumber + " - " + currentNumber + " = " + calculatedNumber);
                textField.setText(String.valueOf(calculatedNumber));
            }
            case "*" -> {
                double calculatedNumber = firstNumberDouble * secondNumberDouble;
                savedNumbers.setText(firstNumber + " * " + currentNumber + " = " + calculatedNumber);
                textField.setText(String.valueOf(calculatedNumber));
            }
            case "/" -> {
                double calculatedNumber = firstNumberDouble / secondNumberDouble;
                savedNumbers.setText(firstNumber + " / " + currentNumber + " = " + calculatedNumber);
                textField.setText(String.valueOf(calculatedNumber));
            }
            case "%" -> {
                double calculatedNumber = firstNumberDouble/100 * secondNumberDouble;
                savedNumbers.setText(firstNumber + " % * " + currentNumber + " = " + calculatedNumber);
                textField.setText(String.valueOf(calculatedNumber));
            }
        }
    }

    @FXML
    void clearTextField() {
        currentNumber = "";
        textField.setText("0");
        savedNumbers.setText("");
    }

    @FXML
    void button0Clicked() {
        if(!currentNumber.equals("0")){
            addNumber("0");
        }
    }

    @FXML
    void button1Clicked() {
        addNumber("1");
    }

    @FXML
    void button2Clicked() {
        addNumber("2");
    }

    @FXML
    void button3Clicked() {
        addNumber("3");
    }

    @FXML
    void button4Clicked() {
        addNumber("4");
    }

    @FXML
    void button5Clicked() {
        addNumber("5");
    }

    @FXML
    void button6Clicked() {
        addNumber("6");
    }

    @FXML
    void button7Clicked() {
        addNumber("7");
    }

    @FXML
    void button8Clicked() {
        addNumber("8");
    }

    @FXML
    void button9Clicked() {
        addNumber("9");
    }

    public void updateTextField(){
        textField.setText(currentNumber);
    }

    public void addNumber(String number){
        currentNumber += number;
        updateTextField();
    }
}
