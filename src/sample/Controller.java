package sample;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;

import javax.swing.*;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField sicaklikId;

    @FXML
    private ComboBox comboBox1;

    @FXML
    private ComboBox comboBox2;


    public void clickButton() {

        if (!sicaklikId.getText().trim().isEmpty()) {

            if (comboBox1.getSelectionModel().getSelectedItem() == "Celcius" && comboBox2.getSelectionModel().getSelectedItem() == "Fahrenheit") {
                celciusToFahrenheit(Double.parseDouble(sicaklikId.getText()));
            }
            if (comboBox1.getSelectionModel().getSelectedItem() == "Fahrenheit" && comboBox2.getSelectionModel().getSelectedItem() == "Celcius") {
                fahrenheitToCelcius(Double.parseDouble(sicaklikId.getText()));
            }
            if (comboBox1.getSelectionModel().getSelectedItem() == "Celcius" && comboBox2.getSelectionModel().getSelectedItem() == "Kelvin") {
                celciusToKelvin(Double.parseDouble(sicaklikId.getText()));
            }
            if (comboBox1.getSelectionModel().getSelectedItem() == "Kelvin" && comboBox2.getSelectionModel().getSelectedItem() == "Celcius") {
                kelvinToCelicus(Double.parseDouble(sicaklikId.getText()));
            }
            if (comboBox1.getSelectionModel().getSelectedItem() == "Fahrenheit" && comboBox2.getSelectionModel().getSelectedItem() == "Kelvin") {
                fahrenheitToKelvin(Double.parseDouble(sicaklikId.getText()));
            }
            if (comboBox1.getSelectionModel().getSelectedItem() == "Kelvin" && comboBox2.getSelectionModel().getSelectedItem() == "Fahrenheit") {
                kelvinToFahrenheit(Double.parseDouble(sicaklikId.getText()));
            }
            if (comboBox1.getSelectionModel().getSelectedItem().equals(comboBox2.getSelectionModel().getSelectedItem())) {
                JOptionPane.showMessageDialog(null, "Çevirilecek değerlerin farklı olmasi gerekir!", "Sonuç!", JOptionPane.INFORMATION_MESSAGE);
            }


        } else {
            JOptionPane.showMessageDialog(null, "Lütfen bir değer giriniz..", "Error", JOptionPane.ERROR_MESSAGE);
        }
        sicaklikId.setText("");
        comboBox1.getSelectionModel().selectFirst();
        comboBox2.getSelectionModel().selectFirst();
    }


    public void celciusToFahrenheit(double celcius) {

        double resultFahrenheit = (celcius * 1.8) + 32;

        messageDiaolog(resultFahrenheit + " °F");
    }

    public void fahrenheitToCelcius(double fahrenheit) {

        double resultCelcius = (fahrenheit - 32) / 1.8;

        messageDiaolog(resultCelcius + " °C");
    }

    public void celciusToKelvin(double celcius) {

        double resultKelvin = celcius + 273.15;

        messageDiaolog(resultKelvin + " °K");
    }

    public void kelvinToCelicus(double kelvin) {

        double resultCelcius = kelvin - 273.15;

        messageDiaolog(resultCelcius + "°C");
    }

    public void fahrenheitToKelvin(double fahrenheit) {

        double resultKelvin = fahrenheit + 457.87;

        messageDiaolog(resultKelvin + "°K");
    }

    public void kelvinToFahrenheit(double kelvin) {

        double resultFahrenheit = kelvin - 457.87;

        messageDiaolog(resultFahrenheit + " °F");
    }

    private void messageDiaolog(String message) {
        JOptionPane.showMessageDialog(null, message, "Sonuç!", JOptionPane.INFORMATION_MESSAGE);
    }


    @FXML
    void close(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

    }


    @FXML
    void min(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox1.getItems().removeAll(comboBox1.getItems());
        comboBox1.getItems().addAll("Celcius", "Fahrenheit", "Kelvin");


        comboBox2.getItems().removeAll(comboBox2.getItems());
        comboBox2.getItems().addAll("Celcius", "Fahrenheit", "Kelvin");


    }
}
