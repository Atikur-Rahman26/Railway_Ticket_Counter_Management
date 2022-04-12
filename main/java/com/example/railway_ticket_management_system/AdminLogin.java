package com.example.railway_ticket_management_system;

import com.example.ControllerLogic.AdminHomePage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminLogin extends AdminHomePage implements Initializable {

    @FXML
    private ImageView exit,minimize;

    @FXML
    private Label wrongLabel;

    @FXML
    private TextField admin;

    @FXML
    private PasswordField AdminPassqword;



    public void login(ActionEvent actionEvent) throws IOException {
        if (admin.getText().equals(Admin)&&AdminPassqword.getText().equals(AdminPassword)){
            AdminHomePAge(actionEvent);
        }
        else{
            wrongLabel.setText("User Name or Password is wrong");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        exit.setOnMouseClicked(mouseEvent -> {
            System.exit(0);
        });

        minimize.setOnMouseClicked(mouseEvent -> {
            Stage stage=(Stage) ((ImageView)mouseEvent.getSource()).getScene().getWindow();

            stage.setIconified(true);
        });

        admin.setOnKeyPressed(event->{
            if (event.getCode().equals(KeyCode.ENTER)){
                AdminPassqword.requestFocus();
            }
        });

    }
}
