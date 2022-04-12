package com.example.railway_ticket_management_system;

import com.example.ControllerLogic.UserHomePage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Home extends UserHomePage implements Initializable {

    @FXML
    private ImageView exit,minimize;


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

    public void LogOut(ActionEvent actionEvent)throws IOException{
        user_id="";
        Password="";
        name="";
        WelcomeLogicStage(actionEvent);
    }
    public void BookTicket(ActionEvent  actionEvent)throws IOException{
        TicketConfirmationPageStage(actionEvent);
    }
    public void TrainSchedule(ActionEvent actionEvent)throws IOException{
        TrainSchedulePageStage(actionEvent);

    }


    public void SeeSellHistory(ActionEvent actionEvent)throws IOException{
        SeeSellHistoryPageStage(actionEvent);
    }
}
