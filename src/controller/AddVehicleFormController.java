package controller;

import db.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Vehicle;

import java.io.IOException;
import java.util.Optional;

public class AddVehicleFormController {
    public AnchorPane AddVehicleContext;
    public ComboBox cmblVehicleType;
    public TextField txtVehicleNum;
    public TextField txtMaximumWeight;
    public TextField txtNoPassengers;

    public void initialize() {
        cmblVehicleType.getItems().add("Van");
        cmblVehicleType.getItems().add("Cargo Lorry");
        cmblVehicleType.getItems().add("Bus");
    }

    public void addlVehicleOnAction(ActionEvent actionEvent) {
        if (txtVehicleNum.getText().equals("") || txtMaximumWeight.getText().equals("") || txtNoPassengers.getText().equals("") || cmblVehicleType.getValue() == null) {


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "DATA NOT ENTERED",
                    ButtonType.OK);
            Optional<ButtonType> buttonType = alert.showAndWait();

            if (buttonType.get().equals(ButtonType.OK)) {


            }

        } else {

            switch ((String) cmblVehicleType.getValue()) {
                case "Van":
                    if (txtVehicleNum.getText().matches("[A-Z 0-9]{2}[-][0-9]{4}") && txtMaximumWeight.getText().matches("[0-9]{3}") && txtNoPassengers.getText().matches("[1-9]{1}")) {
                        Vehicle v1 = new Vehicle(txtVehicleNum.getText(), (String) cmblVehicleType.getValue(), txtMaximumWeight.getText(), txtNoPassengers.getText());
                        Database.vehicles.add(v1);
                        new Alert(Alert.AlertType.CONFIRMATION,"Van added successfully!..").show();

                        Stage stage = (Stage) AddVehicleContext.getScene().getWindow();
                        stage.close();
                    } else {
                        new Alert(Alert.AlertType.WARNING, "Data not Validate!").show();
                        if (txtVehicleNum.getText().matches("[A-Z 0-9]{2}[-][0-9]{4}")!=true){
                            txtVehicleNum.setText("");
                        }
                        if (txtMaximumWeight.getText().matches("[0-9]{3}")!=true){
                            txtMaximumWeight.setText("");
                        }
                        if (txtNoPassengers.getText().matches("[1-9]{1}")!=true){
                            txtNoPassengers.setText("");
                        }
                    }
                    break;

                case "Cargo Lorry":
                    if (txtVehicleNum.getText().matches("[A-Z 0-9]{2}[-][0-9]{4}") && txtMaximumWeight.getText().matches("[0-9]{5}") && txtNoPassengers.getText().matches("[1-9]{1}")) {
                        Vehicle v1 = new Vehicle(txtVehicleNum.getText(), (String) cmblVehicleType.getValue(), txtMaximumWeight.getText(), txtNoPassengers.getText());
                        Database.vehicles.add(v1);
                        new Alert(Alert.AlertType.CONFIRMATION,"Cargo Lorry added successfully!..").show();
                        Stage stage = (Stage) AddVehicleContext.getScene().getWindow();
                        stage.close();
                    } else {
                        new Alert(Alert.AlertType.WARNING, "Data not Validate!").show();
                        if (txtVehicleNum.getText().matches("[A-Z 0-9]{2}[-][0-9]{4}")!=true){
                            txtVehicleNum.setText("");
                        }
                        if (txtMaximumWeight.getText().matches("[0-9]{5}")!=true){
                            txtMaximumWeight.setText("");
                        }
                        if (txtNoPassengers.getText().matches("[1-9]{1}")!=true){
                            txtNoPassengers.setText("");
                        }
                    }
                    break;

                case "Bus":
                    if (txtVehicleNum.getText().matches("[A-Z 0-9]{2}[-][0-9]{4}") && txtMaximumWeight.getText().matches("[0-9]{4}") && txtNoPassengers.getText().matches("[1-9]{1,2}")) {
                        Vehicle v1 = new Vehicle(txtVehicleNum.getText(), (String) cmblVehicleType.getValue(), txtMaximumWeight.getText(), txtNoPassengers.getText());
                        Database.vehicles.add(v1);
                        new Alert(Alert.AlertType.CONFIRMATION,"Bus added successfully!..").show();
                        Stage stage = (Stage) AddVehicleContext.getScene().getWindow();
                        stage.close();
                    } else {
                        new Alert(Alert.AlertType.WARNING, "Data not Validate!").show();
                        if (txtVehicleNum.getText().matches("[A-Z 0-9]{2}[-][0-9]{4}")!=true){
                            txtVehicleNum.setText("");
                        }
                        if (txtMaximumWeight.getText().matches("[0-9]{4}")!=true){
                            txtMaximumWeight.setText("");
                        }
                        if (txtNoPassengers.getText().matches("[1-9]{1,2}")!=true){
                            txtNoPassengers.setText("");
                        }
                    }
                    break;
            }
        }

    }
}
