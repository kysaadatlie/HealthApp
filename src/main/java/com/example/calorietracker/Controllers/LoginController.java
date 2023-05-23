package com.example.calorietracker.Controllers;

import com.example.calorietracker.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Label wrongLabel;

    @FXML
    void loginButtonPressed(ActionEvent event) throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException {

        Main main = new Main();

        if((emailTextField.getText().equals("lalala") && passwordTextField.getText().equals("123")) || (emailTextField.getText().equals("nurlan") && passwordTextField.getText().equals("777"))){
            wrongLabel.setText("Success!");
            main.changeScene("MainView.fxml");
        }
        else if (emailTextField.getText().isEmpty() && passwordTextField.getText().isEmpty()) {
            wrongLabel.setText("PLease enter your username and password.");
        } else {
            wrongLabel.setText("Wrong username or password!");
        }
    }

}
