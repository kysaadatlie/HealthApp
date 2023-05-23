package com.example.calorietracker.Controllers;

import com.example.calorietracker.Food;
import com.example.calorietracker.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddFoodController implements Initializable {

    private int amount, amount2, total, calories;

    @FXML
    private TableView<Food> foodTableView;

    @FXML
    private Label amountLabel;

    @FXML
    private Slider amountSlider;

    @FXML
    private TableColumn<Food, Integer> caloriesTColumn;

    @FXML
    private TextField caloriesTextField;

    @FXML
    private TableColumn<Food, String> foodItemTColumn;

    @FXML
    private TextField foodItemTextField;

    @FXML
    private TextField totalTextField;

    @FXML
    private DatePicker datePicker;

    @FXML
    void addButtonPressed(ActionEvent event) {
        amount2 = Integer.parseInt(amountLabel.getText());
        calories = Integer.parseInt(caloriesTextField.getText());
        total = amount2*calories;
        totalTextField.setText(String.valueOf(total));
    }

    @FXML
    void homeButtonPressed(ActionEvent event) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(foodItemTextField.getText().toString() + ",");
        stringBuilder.append(caloriesTextField.getText().toString() + ",");
        stringBuilder.append(amountLabel.getText().toString() + ",");
        stringBuilder.append(totalTextField.getText().toString() + ",");
        stringBuilder.append(datePicker.getValue());

        File file = new File("/home/saadat/IdeaProjects/CalorieTracker/foodPicked.txt");
        FileWriter W = new FileWriter(file);
        W.write(stringBuilder.toString());
        W.close();

        Main main = new Main();
        main.changeScene("MainView.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //adding food item to table
        foodItemTColumn.setCellValueFactory(new PropertyValueFactory<Food, String>("foodName"));
        caloriesTColumn.setCellValueFactory(new PropertyValueFactory<Food, Integer>("calories"));
        setupTable();

        //slider
        amountSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                amount = newValue.intValue();
                amountLabel.setText(String.valueOf(amount));
            }
        });
    }

    @FXML
    void rowClicked(MouseEvent event) {

        Food clickedFood = foodTableView.getSelectionModel().getSelectedItem();
        foodItemTextField.setText(clickedFood.getFoodName());
        caloriesTextField.setText(String.valueOf(clickedFood.getCalories()));
    }

    private void setupTable() {

        Food food1 = new Food("Apple", 44);
        Food food2 = new Food("Apricot", 35);
        Food food3 = new Food("Banana", 107);
        Food food4 = new Food("Avocado", 150);
        Food food5 = new Food("Broccoli", 27);
        Food food6 = new Food("Bread white", 96);
        Food food7 = new Food("Noodles (boiled)", 175);
        Food food8 = new Food("Naan bread", 300);
        Food food9 = new Food("Macaroni (boiled)", 238);
        Food food10 = new Food("Potatoes (boiled)", 210);
        Food food11 = new Food("Potatoes (roast)", 420);
        Food food12 = new Food("Rice white (boiled)", 420);
        Food food13 = new Food("Rice brown", 405);
        Food food14 = new Food("Buckwheat (boiled)", 360);
        Food food15 = new Food("Broccoli", 27);
        Food food16 = new Food("Beef (roast)", 300);
        Food food17 = new Food("Chicken", 220);
        Food food18 = new Food("Duck (roast)", 400);
        Food food19 = new Food("Lamb (roast)", 300);
        Food food20 = new Food("Sausage roll", 290);
        Food food21 = new Food("Cauliflower (boiled)", 15);
        Food food22 = new Food("Cherry", 35);
        Food food23 = new Food("Cucumber", 3);
        Food food24 = new Food("Peach", 35);
        Food food25 = new Food("Grapes", 55);
        Food food26 = new Food("Carrot (boiled)", 16);
        Food food27 = new Food("Orange", 40);
        Food food28 = new Food("Pear", 45);


        foodTableView.getItems().addAll(food1, food2, food3, food4, food5, food6, food7, food8, food9, food10, food11, food12, food13, food14, food15, food16, food17, food18, food19, food20, food21, food22, food23, food24, food25, food26, food27, food28);

    }
}

