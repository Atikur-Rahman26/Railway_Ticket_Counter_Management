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

public class TrainSchedule extends UserHomePage implements Initializable {
    @FXML
    private ImageView exit,minimize,threebar;

    @FXML
    private ComboBox DepartureComboBox,DestinationComboBox;

    @FXML
    private Label Train1,Departure1,Destination1,Train11,Departure11,Destination11,
            Train111,Departure111,Destination111;

    @FXML
    private AnchorPane sideBar,MenuPane;

    public void initialize(URL url, ResourceBundle resourceBundle){
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

    public void SelectDeparture(ActionEvent actionEvent) throws SQLException, IOException{
        try{
            setDeparture(DepartureComboBox.getSelectionModel().getSelectedItem().toString());
            System.out.println(getDeparture());
            ObservableList<String> list = FXCollections.observableArrayList(getReturnDestination());
            DestinationComboBox.setItems(list);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void SelectDeatination(ActionEvent actionEvent) throws SQLException,IOException{
        try{
            LocalDate localDate=LocalDate.now();
            String today=localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            setDestination(DestinationComboBox.getSelectionModel().getSelectedItem().toString());

            int[] arr=getTripIdFromSchedule(Departure,Destination,today);
            String[] str=getTime(arr[0]);
            Train1.setText(str[0]);
            Departure1.setText(str[1]);
            Destination1.setText(str[2]);

            str=getTime(arr[1]);
            Train11.setText(str[0]);
            Departure11.setText(str[1]);
            Destination11.setText(str[2]);

            str=getTime(arr[2]);
            Train111.setText(str[0]);
            Departure111.setText(str[1]);
            Destination111.setText(str[2]);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    public void HomE(ActionEvent actionEvent) throws IOException {
        Departure="";
        Destination="";
        HomepageStage(actionEvent);
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
