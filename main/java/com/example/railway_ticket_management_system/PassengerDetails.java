package com.example.railway_ticket_management_system;

import com.example.ControllerLogic.UserHomePage;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PassengerDetails extends UserHomePage implements Initializable {
    @FXML
    private ImageView exit,minimize,threebar;

    @FXML
    private Label PassengersLabel,SeatLabel,CompartmentLabel,DateLabel,
            TrainLabel,DestinationLabel,DepartureLabel,TotalBill,Wronglabel;

    @FXML
    private TextField PAssengerName,NIDPass,PerPerSONPrice;

    @FXML
    private AnchorPane StatusOfSeat,sideBar,MenuPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        exit.setOnMouseClicked(mouseEvent -> {
            System.exit(0);
        });

        minimize.setOnMouseClicked(mouseEvent -> {
            Stage stage=(Stage) ((ImageView)mouseEvent.getSource()).getScene().getWindow();

            stage.setIconified(true);
        });

        PassengersLabel.setText(String.valueOf(passengerNumber));
        if(SS==1){
            SeatLabel.setText(String.valueOf(FromSeat)+" to "+String.valueOf(ToSeat));
        }
        else{
            SeatLabel.setText(String.valueOf("Standing Ticket "));
            FromSeat=0;
            ToSeat=0;
        }
        CompartmentLabel.setText(Compartment);
        TrainLabel.setText(Train);
        DestinationLabel.setText(Destination);
        DepartureLabel.setText(Departure);
        DateLabel.setText(Date);

        PAssengerName.setOnKeyPressed(event->{
            if (event.getCode().equals(KeyCode.ENTER)){
                NIDPass.requestFocus();
            }
        });

        NIDPass.setOnKeyPressed(event->{
            if(event.getCode().equals(KeyCode.ENTER)){
                PerPerSONPrice.requestFocus();
            }
        });

        PerPerSONPrice.setOnKeyPressed(event->{
            if(event.getCode().equals(KeyCode.ENTER)){
                PerPersonPrice=Integer.parseInt(PerPerSONPrice.getText());
                int bil=totalbill(passengerNumber,PerPersonPrice);
                TotalBill.setText(String.valueOf(bil));
            }
        });
        MenuPane.setVisible(false);

        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(0.5), MenuPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(0.5),sideBar);
        translateTransition.setByX(-600);
        translateTransition.play();

        threebar.setOnMouseClicked(event->{
            MenuPane.setVisible(true);


            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5),MenuPane);
            fadeTransition1.setFromValue(0);
            fadeTransition1.setToValue(0.15);
            fadeTransition1.play();

            TranslateTransition translateTransition1=new TranslateTransition(Duration.seconds(0.5),sideBar);
            translateTransition1.setByX(+600);
            translateTransition1.play();

        });


        MenuPane.setOnMouseClicked(event->{
            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5),MenuPane);
            fadeTransition1.setFromValue(0.15);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();

            fadeTransition1.setOnFinished(mouseEvent->{
                MenuPane.setVisible(false);
            });

            TranslateTransition translateTransition1=new TranslateTransition(Duration.seconds(0.5),sideBar);
            translateTransition1.setByX(-600);
            translateTransition1.play();
        });
    }

    public void Home(ActionEvent actionEvent) throws IOException{
        HomepageStage(actionEvent);
    }

    public void BookTicket(ActionEvent actionEvent) throws IOException{
        TicketConfirmationPageStage(actionEvent);
    }

    public void SeeSellHistory(ActionEvent actionEvent) throws IOException{
        SeeSellHistoryPageStage(actionEvent);
    }

    public void TrainSchedule(ActionEvent actionEvent) throws IOException{
        TrainSchedulePageStage(actionEvent);
    }

    public void LogOUT(ActionEvent actionEvent) throws IOException {
        WelcomeLogicStage(actionEvent);
    }


    public void Confirm(ActionEvent actionEvent) throws IOException, SQLException {
        try {
            NId=NIDPass.getText();
            setPassengerName(PAssengerName.getText());
            PerPersonPrice=Integer.parseInt(PerPerSONPrice.getText());
            Total_amount=totalbill(passengerNumber,PerPersonPrice);
            System.out.println(PassengerName+"---###"+NId+"-----"+PerPerSONPrice.getText());
            if(PassengerName.equals("")||NId.equals("")||PerPerSONPrice.getText().equals("")){
                Wronglabel.setText("No field can be left empty!");
            }
            else {
                updateSellHistory(passengerNumber, Total_amount);
                InsertPassengerData(PassengerName, NId, Departure, Destination, Train, Compartment,
                        Date, passengerNumber, name, Total_amount);
                for (int i = 0; i < 32; i++) {
                    if (seatStatus[i] != 3) {
                        updateSeatStatus(getTripId(), seatStatus[i], i);
                    }
                }
                confirmationpageStage(actionEvent);
            }
        }
        catch (Exception e){

        }
    }
}
