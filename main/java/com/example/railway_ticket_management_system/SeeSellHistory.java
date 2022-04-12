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
import java.util.ResourceBundle;

public class SeeSellHistory extends UserHomePage implements Initializable {

    @FXML
    private ImageView exit,minimize,threebar;

    @FXML
    private Label Total_TickeT,Total_SEll;

    @FXML
    private ComboBox DateComboBox;

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

        String[] str= new String[0];
        try {
            str = getDateFromSellingHistroy(user_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(int i=0;i<str.length;i++){
            System.out.println("Date From Sell History: "+str[i]);
        }

        try {
            ObservableList<String> list = FXCollections.observableArrayList(getDateForSeelingHistory(user_id));
            DateComboBox.setItems(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }

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

    public void SelectDate(ActionEvent actionEvent) throws SQLException{
        try{
            String dt=DateComboBox.getSelectionModel().getSelectedItem().toString();
            int[] arr=getSellHistory(user_id,dt);
            Total_TickeT.setText(String.valueOf(arr[0]));
            Total_SEll.setText(String.valueOf(arr[1]));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void HomE(ActionEvent actionEvent) throws IOException{
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
