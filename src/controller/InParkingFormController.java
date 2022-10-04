package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import db.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.InParking;
import model.OnDelivery;
import view.TM.InParkingTM;
import view.TM.OnDeliveryTM;

import java.io.IOException;
import java.net.URL;

public class InParkingFormController {
    public AnchorPane InParkingContext;

    public JFXButton btnLogOut;

    public TableView tblInParking;
    public TableColumn colVehicleNum;
    public TableColumn colVehicleType;
    public TableColumn colSlotNumber;
    public TableColumn colParkedTime;
    public JFXComboBox cmbInParking;


    public void initialize(){


       loadParkedTables();


        cmbInParking.getItems().add("In Parking");
        cmbInParking.getItems().add("On Delivery");


    }

    public void addDriverOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddDriverForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }



    public void addVehicleOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddVehicleForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        InParkingContext.getChildren().clear();
        Parent parent= FXMLLoader.load(getClass().getResource("../view/ParkingSystemForm.fxml"));
        InParkingContext.getChildren().add(parent);

    }


private void loadDiliveryTables(){
    ObservableList<OnDeliveryTM> j = FXCollections.observableArrayList();
    for (OnDelivery i: Database.onDelivery){
        OnDeliveryTM od=new OnDeliveryTM(i.getVehicleNum(),i.getVehicleType(),i.getDriverName(),i.getLeftTime());
        j.add(od);


    }
    colVehicleNum.setCellValueFactory(new PropertyValueFactory("vehicleNum"));
    colVehicleType.setCellValueFactory(new PropertyValueFactory("vehicleType"));
    colSlotNumber.setCellValueFactory(new PropertyValueFactory("driverName"));
    colParkedTime.setCellValueFactory(new PropertyValueFactory("leftTime"));
    tblInParking.setItems(j);
}
    public void loadParkedTables() {
        ObservableList<InParkingTM> p = FXCollections.observableArrayList();

        for (InParking i : Database.inParking) {
            InParkingTM ip = new InParkingTM(i.getVehicleNum(), i.getVehicleType(), i.getParkingSlot(), i.getParkedTime());
            p.add(ip);


        }
        colVehicleNum.setCellValueFactory(new PropertyValueFactory("vehicleNum"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory("vehicleType"));
        colSlotNumber.setCellValueFactory(new PropertyValueFactory("vehiSlot"));
        colParkedTime.setCellValueFactory(new PropertyValueFactory("time"));
        tblInParking.setItems(p);



    }

    public void inParkingOnAction1(ActionEvent actionEvent) {
        if (cmbInParking.getValue().equals("On Delivery")){
            colSlotNumber.setText("Driver Name");
            colParkedTime.setText("Left Time");
            btnLogOut.setVisible(false);
            loadDiliveryTables();
        }
        if (cmbInParking.getValue().equals("In Parking")){
            btnLogOut.setVisible(true);
            colSlotNumber.setText("Parking Slot");
            colParkedTime.setText("Parked Time");

            loadParkedTables();
        }

    }
}
