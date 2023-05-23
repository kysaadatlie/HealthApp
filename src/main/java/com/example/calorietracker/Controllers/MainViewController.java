package com.example.calorietracker.Controllers;

import com.example.calorietracker.Main;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.*;
import java.nio.file.Files;
import java.util.Collection;
import java.util.stream.Collectors;

public class MainViewController {
    int sum = 0;
    int t, a, r;

    @FXML
    private TableView<FoodSelected> MainTable;

    @FXML
    private TableColumn<FoodSelected, String> amountColumn;

    @FXML
    private TableColumn<FoodSelected, String> caloriesColumn;

    @FXML
    private TextField caloriesTextField;

    @FXML
    private TableColumn<FoodSelected, String> dateColumn;

    @FXML
    private TableColumn<FoodSelected, String> foodItemColumn;

    @FXML
    private TextField goalTextField;

    @FXML
    private TextField remainingTextField;

    @FXML
    private TableColumn<FoodSelected, String> totalColumn;

    @FXML
    void updateButtonPressed(ActionEvent event) throws IOException {

        FileReader reader = new FileReader("/home/saadat/IdeaProjects/CalorieTracker/AMR.txt");
        BufferedReader br = new BufferedReader(reader);
        goalTextField.setText(br.readLine());
        a = Integer.parseInt(goalTextField.getText());
        reader.close();

        String filepath = "/home/saadat/IdeaProjects/CalorieTracker/foodPicked.txt";
        File file = new File(filepath);

        try{
            Collection<FoodSelected> list = Files.readAllLines(new File("/home/saadat/IdeaProjects/CalorieTracker/foodPicked.txt").toPath())
                    .stream()
                    .map(line -> {
                        String[] details = line.split(",");
                        FoodSelected fs = new FoodSelected();
                        fs.setFoodName(details[0]);
                        fs.setCalories(details[1]);
                        fs.setAmount(details[2]);
                        fs.setTotal(details[3]);
                        fs.setDate(details[4]);
                        t = Integer.parseInt(details[3]);
                        return fs;
                    })
                    .collect(Collectors.toList());

            ObservableList<FoodSelected> details = FXCollections.observableArrayList(list);

            foodItemColumn.setCellValueFactory(data -> data.getValue().foodNameProperty());
            caloriesColumn.setCellValueFactory(data -> data.getValue().caloriesProperty());
            amountColumn.setCellValueFactory(data -> data.getValue().amountProperty());
            totalColumn.setCellValueFactory(data -> data.getValue().totalProperty());
            dateColumn.setCellValueFactory(data -> data.getValue().dateProperty());

            MainTable.setItems(details);

            sum += t;
            caloriesTextField.setText(String.valueOf(sum));

            r = a - sum;
            remainingTextField.setText(String.valueOf(r));
        }
        catch (Exception ex){
        }
    }

    private class FoodSelected {
        StringProperty foodName = new SimpleStringProperty();
        StringProperty calories = new SimpleStringProperty();
        StringProperty amount = new SimpleStringProperty();
        StringProperty total = new SimpleStringProperty();
        StringProperty date = new SimpleStringProperty();

        public final StringProperty foodNameProperty() {
            return this.foodName;
        }

        public final java.lang.String getFoodName() {
            return this.foodNameProperty().get();
        }

        public final void setFoodName(final java.lang.String foodName) {
            this.foodNameProperty().set(foodName);
        }

        public final StringProperty caloriesProperty() {
            return this.calories;
        }

        public final java.lang.String getCalories() {
            return this.caloriesProperty().get();
        }

        public final void setCalories(final java.lang.String calories) {
            this.caloriesProperty().set(calories);
        }

        public final StringProperty amountProperty() {
            return this.amount;
        }

        public final java.lang.String getAmount() {
            return this.amountProperty().get();
        }

        public final void setAmount(final java.lang.String amount) {
            this.amountProperty().set(amount);
        }

        public final StringProperty totalProperty() {
            return this.total;
        }

        public final java.lang.String getTotal() {
            return this.totalProperty().get();
        }

        public final void setTotal(final java.lang.String total) {
            this.totalProperty().set(total);
        }
        public final StringProperty dateProperty() {
            return this.date;
        }

        public final java.lang.String getDate() {
            return this.dateProperty().get();
        }

        public final void setDate(final java.lang.String date) {
            this.dateProperty().set(date);
        }
    }

    @FXML
    void addFoodButtonPressed(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("AddFood.fxml");
    }

    @FXML
    void profileButtonPressed(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("Profile.fxml");
    }

}
