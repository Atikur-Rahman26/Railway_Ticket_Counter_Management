package com.example.railway_ticket_management_system;

import com.example.ControllerLogic.UserHomePage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Login extends UserHomePage implements Initializable {

    @FXML
    private ImageView exit,minimize;

    @FXML
    private TextField u_id;

    @FXML
    private PasswordField userpassword;

    @FXML
    private Label wrongLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        exit.setOnMouseClicked(mouseEvent -> {
            System.exit(0);
        });

        minimize.setOnMouseClicked(mouseEvent -> {
            Stage stage=(Stage) ((ImageView)mouseEvent.getSource()).getScene().getWindow();

            stage.setIconified(true);
        });

        u_id.setOnKeyPressed(event->{
            if (event.getCode().equals(KeyCode.ENTER)){
                userpassword.requestFocus();
            }
        });

        userpassword.setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode().equals(KeyCode.ENTER)){
//                keyEvent=keyEvent.
//                login(keyEvent);
            }
        });
    }

    public void login(ActionEvent actionEvent) throws IOException{
        try{

            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("Loginpage.fxml"));
            String userId,Password;

            userId=u_id.getText();
            Password=userpassword.getText();
            setUser_id(userId);
            setPassword(Password);
            updateDate();
//            if(true){
            if (Validlogin()){
                setNameServer();
                updateSellHistoryTable();
                HomepageStage(actionEvent);

            }
            else{
                Login loginPage1=fxmlLoader.getController();
                wrongLabel.setText("username or password is incorrect");
                userpassword.setText("");
                u_id.setText("");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
