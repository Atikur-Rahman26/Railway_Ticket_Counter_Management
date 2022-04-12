package com.example.railway_ticket_management_system;

import com.example.ControllerLogic.UserHomePage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConfirmationPage extends UserHomePage implements Initializable {

    @FXML
    private ImageView exit,minimize;

    @FXML
    private Label NiD,DEParture,DEstination,TRaiN,
            DaTe,ComPartment,PersonS,SeaT,BiLL,NamE;

    public void initialize(URL url, ResourceBundle resourceBundle){
        exit.setOnMouseClicked(mouseEvent -> {
            System.exit(0);
        });

        minimize.setOnMouseClicked(mouseEvent -> {
            Stage stage=(Stage) ((ImageView)mouseEvent.getSource()).getScene().getWindow();

            stage.setIconified(true);
        });
        NamE.setText(PassengerName);
        NiD.setText(NId);
        DEParture.setText(Departure);
        DEstination.setText(Destination);
        TRaiN.setText(Train);
        DaTe.setText(Date);
        ComPartment.setText(Compartment);
        PersonS.setText(String.valueOf(passengerNumber));
        if(seatCount==0){
            SeaT.setText("Standing Ticket");
        }
        else {
            SeaT.setText(String.valueOf(FromSeat)+" to "+String.valueOf(ToSeat));
        }
        BiLL.setText(String.valueOf(Total_amount));

        System.out.println( "----"+PassengerName);
    }
    public void home(ActionEvent actionEvent) throws IOException {
        setNULL();
        HomepageStage(actionEvent);

    }
}
