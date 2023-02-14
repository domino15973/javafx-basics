package com.example.javafxbasics;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class WeatherAppController {

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
    private TextField cityTextField;
    @FXML
    private Label mainLabel, tempLabel, fellsLikeLabel, maxMinLabel, humidityLabel, pressureLabel;


    private static final String URL = "https://api.openweathermap.org/data/2.5/weather?q=";
    private static final String API_KEY = "&appid=" + System.getenv("WEATHER_API_KEY");
    private static final String SETTINGS = "&units=metric";

    @FXML
    private void getWeatherForCity() {
        String city = cityTextField.getText();
        cityTextField.clear();
        try {
            String urlString = URL + city + API_KEY + SETTINGS;
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                JSONObject json = new JSONObject(response.toString());
                JSONObject main = json.getJSONObject("main");
                mainLabel.setText("Weather in " + city);
                double temp = main.getDouble("temp");
                tempLabel.setText("Temperature is " + temp + "°C");
                double feelsLikeTemp = main.getDouble("feels_like");
                fellsLikeLabel.setText("Feels like temperature is " + feelsLikeTemp + "°C");
                double minTemp = main.getDouble("temp_min");
                double maxTemp = main.getDouble("temp_max");
                maxMinLabel.setText("Minimum temperature is " + minTemp + "°C and maximum is " + maxTemp + "°C");
                double humidity = main.getDouble("humidity");
                humidityLabel.setText("Humidity is " + humidity + "%");
                double pressure = main.getDouble("pressure");
                pressureLabel.setText("Pressure is " + pressure + " hPa");
            } else {
                mainLabel.setText("Unable to fetch data from the API, Response Code: " + responseCode);
            }
        } catch (Exception e) {
            mainLabel.setText("Error connecting to the API: " + e.getMessage());
        }
    }

}
