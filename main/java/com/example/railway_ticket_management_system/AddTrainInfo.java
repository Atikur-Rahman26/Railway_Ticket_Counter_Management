package com.example.railway_ticket_management_system;

import com.example.ControllerLogic.AdminHomePage;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AddTrainInfo extends AdminHomePage implements Initializable {

    @FXML
    private ImageView exit,minimize,threebar;

    @FXML
    private TextField SeatTO,SeatFrom,Compartments,DestinationStation,
            DepartureStation,TrainName,DepartureTime,DestinationTime,up_Down;

    @FXML
    private Label WrongLabel;

    @FXML
    private AnchorPane SuccesfulPage,sideBar,MenuPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SuccesfulPage.setVisible(false);


        exit.setOnMouseClicked(mouseEvent -> {
            System.exit(0);
        });

        minimize.setOnMouseClicked(mouseEvent -> {
            Stage stage=(Stage) ((ImageView)mouseEvent.getSource()).getScene().getWindow();

            stage.setIconified(true);
        });

        TrainName.requestFocus();

        TrainName.setOnKeyPressed(event->{
            if (event.getCode().equals(KeyCode.ENTER)){
                DepartureStation.requestFocus();
            }
        });

        DepartureStation.setOnKeyPressed(event->{
            if (event.getCode().equals(KeyCode.ENTER)){
                DestinationStation.requestFocus();
            }
        });

        DestinationStation.setOnKeyPressed(event->{
            if (event.getCode().equals(KeyCode.ENTER)){
                Compartments.requestFocus();
            }
        });

        Compartments.setOnKeyPressed(event->{
            if (event.getCode().equals(KeyCode.ENTER)){
                SeatFrom.requestFocus();
            }
        });

        SeatFrom.setOnKeyPressed(event->{
            if (event.getCode().equals(KeyCode.ENTER)){
                SeatTO.requestFocus();
            }
        });

        SeatTO.setOnKeyPressed(event->{
            if (event.getCode().equals(KeyCode.ENTER)){
                up_Down.requestFocus();
            }
        });
        up_Down.setOnKeyPressed(event->{
            if (event.getCode().equals(KeyCode.ENTER)){
                DepartureTime.requestFocus();
            }
        });

        DepartureTime.setOnKeyPressed(event->{
            if (event.getCode().equals(KeyCode.ENTER)){
                DestinationTime.requestFocus();
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

    

    public void Done(ActionEvent actionEvent)  throws SQLException {
        System.out.println(TrainName.getText()+" "+DepartureStation.getText());
        if (TrainName.getText().equals("")||DepartureStation.getText().equals("")
        ||DestinationStation.getText().equals("")||Compartments.getText().equals("")
        ||SeatFrom.getText().equals("")||SeatTO.getText().equals("")
        ||DestinationTime.getText().equals("")||DestinationTime.getText().equals("")
        ||up_Down.getText().equals("")){
            WrongLabel.setText("No Field can be left empty");
        }
        else {
            LocalDate localDate=LocalDate.now();
            String today=localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            insertDataIntoTrainSchedule(DepartureStation.getText(),DestinationStation.getText(),TrainName.getText(),
                    up_Down.getText(),DepartureTime.getText(),DestinationTime.getText(),today);
            int a=tripId(DepartureStation.getText(),DestinationStation.getText(),TrainName.getText(),today);
            System.out.println(a+"---------");

            int FromSEAT=Integer.parseInt(SeatFrom.getText());
            int ToSEAT=Integer.parseInt(SeatTO.getText());
            for (int i=FromSEAT-1;i<ToSEAT;i++){
                insertIntoCompartment(a,Compartments.getText(),i);
            }

            localDate=LocalDate.now().plusDays(1);
            today=localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            insertDataIntoTrainSchedule(DepartureStation.getText(),DestinationStation.getText(),TrainName.getText(),
                    up_Down.getText(),DepartureTime.getText(),DestinationTime.getText(),today);
            a=tripId(DepartureStation.getText(),DestinationStation.getText(),TrainName.getText(),today);
            System.out.println(a+"---------");
            for (int i=FromSEAT-1;i<ToSEAT;i++){
                insertIntoCompartment(a,Compartments.getText(),i);
            }
            SuccesfulPage.setVisible(true);
        }
    }

    public void Home(ActionEvent actionEvent) throws IOException{
        AdminHomePAge(actionEvent);
    }

    public void ADDTRAIN(ActionEvent actionEvent) throws IOException {
        AddTrainInfoStage(actionEvent);
    }

    public void SeeSellHistory(ActionEvent actionEvent) throws IOException{
        SeeSellHistoryStage(actionEvent);
    }

    public void LogOUT(ActionEvent actionEvent) throws IOException{
        UserHomePage userHomePage=new UserHomePage();
        userHomePage.WelcomeLogicStage(actionEvent);
    }
}
