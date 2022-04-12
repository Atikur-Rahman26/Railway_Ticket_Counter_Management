package com.example.railway_ticket_management_system;

import com.example.ControllerLogic.AdminHomePage;
import com.example.ControllerLogic.UserHomePage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminHome extends AdminHomePage implements Initializable {

    @FXML
    private ImageView exit,minimize,Home;

    public void AddTrainInfo(ActionEvent actionEvent) throws IOException{
        AddTrainInfoStage(actionEvent);
    }
    public void LOGOUT(ActionEvent actionEvent) throws IOException{
        UserHomePage userHomePage=new UserHomePage();
        userHomePage.WelcomeLogicStage(actionEvent);
    }

    public void SeeSellHistory(ActionEvent actionEvent) throws IOException{
        AdminHomePage adminHomePage=new AdminHomePage();
        adminHomePage.SeeSellHistoryStage(actionEvent);

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

    }


}
