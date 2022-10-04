package controller;

import com.jfoenix.controls.JFXTextField;
import db.Database;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Drivers;
import model.InParking;
import model.OnDelivery;
import model.Vehicle;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

public class ParkingSystemFormController extends ParkingSlotAndType {
    public ComboBox<String> cmbSelectVehicle;
    public JFXTextField txtVehicleType;
    public ComboBox<String> cmbDriver;
    public Label lblSlotNum;
    public Label lblTime;
    public Label lblDate;
    public AnchorPane parkingSystemContext;
    public Label lblVehicleType;
    public Label lbltype;
    String addVehicleNumber[] = new String[14];
    int next;


    public void initialize() {


        cmbSelectVehicle.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            park(newValue);
            if (isExistsSlot()) {
                lblSlotNum.setText("This vehicle already park");
            } else {
                lblSlotNum.setText(vehicleSlot);
            }
        });
        dateAndTime();


        ObservableList<String> vehicleList = FXCollections.observableArrayList();
        for (Vehicle v1 : Database.vehicles) {
            vehicleList.add(v1.getVehicleNum());
        }
        cmbSelectVehicle.setItems(vehicleList);

        ObservableList<String> driverList = FXCollections.observableArrayList();
        for (Drivers d1 : Database.drivers) {
            driverList.add(d1.getName());
        }
        cmbDriver.setItems(driverList);
    }

    public void parkVehicleOnAction(ActionEvent actionEvent) {
        if (isExistsSlot()) {
            new Alert(Alert.AlertType.WARNING, "Already Parked!!").show();
        } else {
            InParking inParking = new InParking(cmbSelectVehicle.getValue(), lbltype.getText(), lblSlotNum.getText(), lblTime.getText());
            Database.inParking.add(inParking);
            addVehicleNumber[next++] = cmbSelectVehicle.getValue();
        }

    }

    public void onDiliveryOnAction(ActionEvent actionEvent) {
        if (Database.inParking.size() == 0) {
            new Alert(Alert.AlertType.WARNING, "Parked the vehicle first").show();
        } else {
            for (int i = 0; i < Database.inParking.size(); i++) {
                if (cmbSelectVehicle.getValue().equals(Database.inParking.get(i).getVehicleNum())) {


                     Database.inParking.remove(i);
                    OnDelivery onDelivery = new OnDelivery(cmbSelectVehicle.getValue(), lbltype.getText(), cmbDriver.getValue(), lblTime.getText());
                    Database.onDelivery.add(onDelivery);
                    new Alert(Alert.AlertType.CONFIRMATION, "DILIVERED!..").show();
                    break;
                }/*else {
                    Alert alert=new Alert(Alert.AlertType.WARNING,"NOT PARKED VEHICLE!..");
                    alert.show();
                }*/

            }

        }
    }


        public void managementLogInOnAction (ActionEvent actionEvent) throws IOException {
            Database.lowerpn = parkingSystemContext;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/LoginForm.fxml"));
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        }

        private void dateAndTime () {


            Calendar clndr = Calendar.getInstance();
            SimpleDateFormat format1 = new SimpleDateFormat(" aa");


            Timeline clock = new Timeline(new KeyFrame(Duration.INDEFINITE.ZERO, e -> {
                LocalTime currenttime = LocalTime.now();
                LocalDate currentdate = LocalDate.now();
                lblTime.setText(currenttime.getHour() + ":" + currenttime.getMinute() + ":" + currenttime.getSecond() + "  " + format1.format(clndr.getTime()));
                lblDate.setText(currentdate.getDayOfMonth() + "-" + currentdate.getMonthValue() + "-" + currentdate.getYear());

            }),
                    new KeyFrame(Duration.seconds(1))
            );
            clock.setCycleCount(Animation.INDEFINITE);
            clock.play();
        }

        public void selectVehicleOnAction (ActionEvent actionEvent){
            for (int i = 0; i < Database.vehicles.size(); i++) {
                if (cmbSelectVehicle.getValue().equals(Database.vehicles.get(i).getVehicleNum())) {
                    lbltype.setText(Database.vehicles.get(i).getVehicleType());
                }
            }

        }
        public boolean isExistsSlot () {
            for (int i = 0; i < next; i++) {
                if (addVehicleNumber[i].equals(cmbSelectVehicle.getValue())) {
                    return true;
                }
            }
            return false;
        }

}
