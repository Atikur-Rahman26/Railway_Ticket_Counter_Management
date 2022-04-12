package com.example.railway_ticket_management_system;

import com.example.ControllerLogic.UserHomePage;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class BookTicket extends UserHomePage implements Initializable {

    @FXML
    private ImageView exit,minimize,threebar;

    @FXML
    private ComboBox DateComboBox,DepartureComboBox,DestinationComboBox,TrainComboBox;

    @FXML
    private Label wrongLabel;

    @FXML
    private AnchorPane sideBar,MenuPane;

    public void SelectDeparture(ActionEvent actionEvent) throws IOException, SQLException {
        try{
            setDeparture(DepartureComboBox.getSelectionModel().getSelectedItem().toString());
            ObservableList<String> list = FXCollections.observableArrayList(getReturnDestination());
            DestinationComboBox.setItems(list);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void SelectDestination(ActionEvent actionEvent) throws IOException,SQLException{
        try{
            setDestination(DestinationComboBox.getSelectionModel().getSelectedItem().toString());
            ObservableList<String> list = FXCollections.observableArrayList(getReturnTrain());
            TrainComboBox.setItems(list);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void SelectTrain(ActionEvent actionEvent) throws IOException,SQLException{
        try{
            setTrain(TrainComboBox.getSelectionModel().getSelectedItem().toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void SelectDate(ActionEvent actionEvent) throws IOException,SQLException{
        try{
            setDate(DateComboBox.getSelectionModel().getSelectedItem().toString());
            setTripId(tripId(getDeparture(),getDestination(),getTrain(),getDate()));
            System.out.println(getDate());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void Proceed(ActionEvent actionEvent) throws IOException,SQLException{
        System.out.println(Departure);
        try{
            if(!isNULL()){
                System.out.println(getTripId());
                CheckCompartment(getTripId());
                setSeatId(getSeatIdfromTable(getTripId()));
                setSeatStatus(getSeatStatus(getTripId()));

                for (int i=0,j=0;i<32;i++){
                    if (i==seatId[j]){
                        j++;
                    }
                    else {
                        seatStatus[i]=3;
                    }
                }
                SeatPageStage(actionEvent);
            }
            else{
                wrongLabel.setText("No Field can be set empty");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
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

        ObservableList<String> list = null;
        try {
            list = FXCollections.observableArrayList(getReturnDeparture());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DepartureComboBox.setItems(list);

        LocalDate localDate=LocalDate.now();
        String today=localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        localDate=localDate.now().plusDays(1);
        String tomorrow=localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        ObservableList<String> list1=FXCollections.observableArrayList(today,tomorrow);
        DateComboBox.setItems(list1);


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
}
