package com.example.calorietracker.Controllers;

import com.example.calorietracker.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileWriter;

public class ProfileController {
    String sex;
    double amr, bmr, k;

    @FXML
    private TextField AMRTextField;

    @FXML
    private TextField ageTextField;

    @FXML
    private TextField heightTextField;

    @FXML
    private TextField weightTextField;


    @FXML
    void calculateButtonPressed(ActionEvent event) {
        try{

            double weight = Double.parseDouble(weightTextField.getText());
            double height = Double.parseDouble(heightTextField.getText());
            int age = Integer.parseInt(ageTextField.getText());

            if(sex.equals("female")){
                bmr = 655.1 + 9.563*weight + 1.850*height - 4.676*age;
            }
            if(sex.equals("male")){
                bmr = 66.47 + 13.75*weight + 5.003*height - 6.755*age;
            }
            amr = k * bmr;
            AMRTextField.setText(String.valueOf(Math.round(amr)));

        }
        catch (Exception ex) {

            weightTextField.setText("Enter weight in kg");
            weightTextField.selectAll();
            weightTextField.requestFocus();

            heightTextField.setText("Enter height in cm");
            heightTextField.selectAll();
            heightTextField.requestFocus();

            ageTextField.setText("Enter age");
            ageTextField.selectAll();
            ageTextField.requestFocus();

        }
    }

    @FXML
    void homeButtonPressed(ActionEvent event) {
        try{
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(AMRTextField.getText().toString());

            File file = new File("/home/saadat/IdeaProjects/CalorieTracker/AMR.txt");
            FileWriter W = new FileWriter(file);
            W.write(stringBuilder.toString());
            W.close();

            Main main = new Main();
            main.changeScene("MainView.fxml");
        }
        catch (Exception ex){

        }
    }

    @FXML
    void Male(ActionEvent event) {
        sex = "male";
    }
    @FXML
    void Female(ActionEvent event) {
        sex = "female";
    }

    @FXML
    void Active(ActionEvent event) {
        k = 1.725;
    }

    @FXML
    void LightlyActive(ActionEvent event) {
        k = 1.375;
    }

    @FXML
    void ModeratelyActive(ActionEvent event) {
        k = 1.55;
    }

    @FXML
    void Sedentary(ActionEvent event) {
        k = 1.2;
    }

    @FXML
    void VeryActive(ActionEvent event) {
        k = 1.9;
    }
}
