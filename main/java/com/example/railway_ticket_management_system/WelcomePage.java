package com.example.railway_ticket_management_system;

import com.example.ControllerLogic.AdminHomePage;
import com.example.ControllerLogic.UserHomePage;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomePage extends UserHomePage implements Initializable {
    public static int count=0;
    @FXML
    private AnchorPane loginpage,welcome;

    @FXML
    private ImageView minimize,exit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(count==0){
            loginpage.setVisible(false);

            FadeTransition fadeTransition=new FadeTransition(Duration.seconds(3),welcome);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.setCycleCount(1);

            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(2),welcome);
            fadeTransition1.setFromValue(1);
            fadeTransition1.setToValue(0);
            fadeTransition1.setCycleCount(1);

            FadeTransition fadeTransition11=new FadeTransition(Duration.seconds(2),loginpage);
            fadeTransition11.setFromValue(0);
            fadeTransition11.setToValue(1);
            fadeTransition11.setCycleCount(1);

            fadeTransition.play();

            fadeTransition.setOnFinished(event->{
                fadeTransition1.play();

            });
            fadeTransition1.setOnFinished(event->{
                fadeTransition11.play();
            });
            fadeTransition1.setOnFinished(event->{
                loginpage.setVisible(true);
            });
            count++;
        }
        else{
            loginpage.setVisible(true);
        }
        exit.setOnMouseClicked(mouseEvent -> {
            System.exit(0);
        });

        minimize.setOnMouseClicked(mouseEvent -> {
            Stage stage=(Stage) ((ImageView)mouseEvent.getSource()).getScene().getWindow();

            stage.setIconified(true);
        });
    }

    public void Admin(ActionEvent actionEvent) throws IOException {
        AdminHomePage adminHomePage =new AdminHomePage();
        adminHomePage.AdminLoginPageStage(actionEvent);

    }

    public void User(ActionEvent actionEvent) throws IOException{
        LoginPageStage(actionEvent);
    }
}
