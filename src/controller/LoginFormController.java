package controller;

import com.jfoenix.controls.JFXTextField;
import db.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane logInContext;
    public JFXTextField txtUserName;
    public PasswordField txtPassword;
    int attempts = 0;


    public void cancelOnAction(ActionEvent actionEvent) throws IOException {
            Stage stage = (Stage) logInContext.getScene().getWindow();
            stage.close();

    }

    public void logInOnAction(ActionEvent actionEvent) throws IOException {
        attempts++;
        if (attempts<=3) {
            String tempUserName = txtUserName.getText();
            String tempPassword = txtPassword.getText();
            if (tempUserName.equals("admin") && tempPassword.equals("1234")) {
                Stage stage = (Stage) logInContext.getScene().getWindow();
                stage.close();
               Database.lowerpn.getChildren().clear();
                Parent parent = FXMLLoader.load(getClass().getResource("../view/InParkingForm.fxml"));
                Database.lowerpn.getChildren().add(parent);

            } else {
                new Alert(Alert.AlertType.WARNING, "Try again").show();
            }
        }else {
            txtUserName.setEditable(false);
            txtPassword.setEditable(false);
        }
    }

}
