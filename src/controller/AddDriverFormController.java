package controller;

import db.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Drivers;
import model.Vehicle;

import java.io.IOException;
import java.util.Optional;

public class AddDriverFormController {
    public AnchorPane AddDriverContext;
    public TextField txtDriverName;
    public TextField txtNic;
    public TextField txtDrivingLiNo;
    public TextField txtAddress;
    public TextField txtContactNo;

    public void addlDriverOnAction(ActionEvent actionEvent) {
        if (txtDriverName.getText().equals("") || txtNic.getText().equals("") ||txtDrivingLiNo.getText().equals("") ||txtAddress.getText().equals("") || txtContactNo.getText().equals("")  ) {



            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"DATA NOT ENTERED",
                    ButtonType.OK);
            Optional<ButtonType> buttonType = alert.showAndWait();

            if(buttonType.get().equals(ButtonType.OK)){


            }

        }
        else {

            if (txtDriverName.getText().matches("[A-Z]{1}[a-z]*[ ][A-Z]{1}[a-z]*") && txtNic.getText().matches("[0-9]{10}[V]") && txtDrivingLiNo.getText().matches("[B][0-9]{7}") &&
                    txtAddress.getText().matches("[A-Z]{1}[a-z]*") && txtContactNo.getText().matches("[0]{1}[0-9]{2}[-][0-9]{7}")){
                Drivers d2 = new Drivers(txtDriverName.getText(), txtNic.getText(), txtDrivingLiNo.getText(), txtAddress.getText(), txtContactNo.getText());
                Database.drivers.add(d2);
                new Alert(Alert.AlertType.CONFIRMATION,"Driver successfully added!..").show();
                Stage stage = (Stage) AddDriverContext.getScene().getWindow();
                stage.close();
            }else {

                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Data not validate!..",
                        ButtonType.OK);
                Optional<ButtonType> buttonType = alert.showAndWait();

                if(txtDriverName.getText().matches("[A-Z]{1}[a-z]*[ ][A-Z]{1}[a-z]*")!=true) {

                    txtDriverName.setText("");
                }
                else if(txtNic.getText().matches("[0-9]{10}[V]")!=true) {

                    txtNic.setText("");
                }
                else if(txtDrivingLiNo.getText().matches("[B][0-9]{7}")!=true) {

                    txtDrivingLiNo.setText("");
                }
                else if(txtAddress.getText().matches("[A-Z]{1}[a-z]*")!=true) {

                    txtAddress.setText("");
                }
                else if (txtContactNo.getText().matches("[0]{1}[0-9]{2}[-][0-9]{7}")!=true) {

                    txtContactNo.setText("");
                }


            }

        }
    }
    }

