package com.example.railway_ticket_management_system;

import com.example.ControllerLogic.UserHomePage;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Seat extends UserHomePage implements Initializable {
    int st = 0;
    public int getSt() {
        return st;
    }

    public void setSt(int st1) {
        final int st = st1;
    }


    public static int[] SEATSTATUS=new int[32];


    @FXML
    private ImageView exit,minimize,threebar;


    @FXML
    private Button seat1,seat2,seat3,seat4,seat5,seat6,seat7,seat8,seat9,seat10,seat11,seat12,
            seat13,seat14,seat15,seat16,seat17,seat18,seat19,seat20,seat21,seat22,seat23,seat24,seat25,seat26,
            seat27,seat28,seat29,seat30,seat31,seat32,StandingTicket,SeeSeat;

    @FXML
    private AnchorPane StatusOfSeat,sideBar,MenuPane;

    @FXML
    private Label Wronglabel;

    public void SetSeatStatusFromSeatId()throws SQLException{
        if (SEATSTATUS[0]==0){
            seat1.setStyle("-fx-background-color: green;");
        }
        else{
            seat1.setStyle("-fx-background-color: red;");
        }

        if (SEATSTATUS[1]==0) {
            seat2.setStyle("-fx-background-color: green;");
        }
        else{
            seat2.setStyle("-fx-background-color: red;");
        }

        if (SEATSTATUS[2]==0){
            seat3.setStyle("-fx-background-color: green;");
        }
        else {
            seat3.setStyle("-fx-background-color: red;");
        }

        if(SEATSTATUS[3]==0){
            seat4.setStyle("-fx-background-color: green;");
        }else {
            seat4.setStyle("-fx-background-color: red;");
        }

        if(SEATSTATUS[4]==0){
            seat5.setStyle("-fx-background-color: green;");
        }else {
            seat5.setStyle("-fx-background-color: red;");
        }

        if(SEATSTATUS[5]==0){
            seat6.setStyle("-fx-background-color: green;");
        }else {
            seat6.setStyle("-fx-background-color: red;");
        }

        if(SEATSTATUS[6]==0){
            seat7.setStyle("-fx-background-color: green;");
        }else{
            seat7.setStyle("-fx-background-color: red;");
        }

        if(SEATSTATUS[7]==0){
            seat8.setStyle("-fx-background-color: green;");
        }else{
            seat8.setStyle("-fx-background-color: red;");
        }

        if(SEATSTATUS[8]==0){
            seat9.setStyle("-fx-background-color: green;");
        }else{
            seat9.setStyle("-fx-background-color: red;");
        }

        if(SEATSTATUS[9]==0){
            seat10.setStyle("-fx-background-color: green;");
        }else{
            seat10.setStyle("-fx-background-color: red;");
        }

        if (SEATSTATUS[10]==0){
            seat11.setStyle("-fx-background-color: green;");
        }else{
            seat11.setStyle("-fx-background-color: red;");
        }

        if (SEATSTATUS[11]==0){
            seat12.setStyle("-fx-background-color: green;");
        }else{
            seat12.setStyle("-fx-background-color: red;");
        }

        if (SEATSTATUS[12]==0){
            seat13.setStyle("-fx-background-color: green;");
        }else {
            seat13.setStyle("-fx-background-color: red;");
        }

        if (SEATSTATUS[13]==0){
            seat14.setStyle("-fx-background-color: green;");
        }else {
            seat14.setStyle("-fx-background-color: red;");
        }

        if(SEATSTATUS[14]==0){
            seat15.setStyle("-fx-background-color: green;");
        }else{
            seat15.setStyle("-fx-background-color: red;");
        }


        if(SEATSTATUS[15]==0){
            seat16.setStyle("-fx-background-color: green;");
        }else{
            seat16.setStyle("-fx-background-color: red;");
        }

        if(SEATSTATUS[16]==0){
            seat17.setStyle("-fx-background-color: green;");
        }else{
            seat17.setStyle("-fx-background-color: red;");
        }

        if(SEATSTATUS[17]==0){
            seat18.setStyle("-fx-background-color: green;");
        }else{
            seat18.setStyle("-fx-background-color: red;");
        }

        if(SEATSTATUS[18]==0){
            seat19.setStyle("-fx-background-color: green;");
        }else{
            seat19.setStyle("-fx-background-color: red;");
        }

        if(SEATSTATUS[19]==0){
            seat20.setStyle("-fx-background-color: green;");
        }else{
            seat20.setStyle("-fx-background-color: red;");
        }

        if (SEATSTATUS[20]==0){
            seat21.setStyle("-fx-background-color: green;");
        }else{
            seat21.setStyle("-fx-background-color: red;");
        }

        if (SEATSTATUS[21]==0){
            seat22.setStyle("-fx-background-color: green;");
        }else{
            seat22.setStyle("-fx-background-color: red;");
        }

        if (SEATSTATUS[22]==0){
            seat23.setStyle("-fx-background-color: green;");
        }else {
            seat23.setStyle("-fx-background-color: red;");
        }

        if (SEATSTATUS[23]==0){
            seat24.setStyle("-fx-background-color: green;");
        }else {
            seat24.setStyle("-fx-background-color: red;");
        }

        if(SEATSTATUS[24]==0){
            seat25.setStyle("-fx-background-color: green;");
        }else{
            seat25.setStyle("-fx-background-color: red;");
        }


        if(SEATSTATUS[25]==0){
            seat26.setStyle("-fx-background-color: green;");
        }else{
            seat26.setStyle("-fx-background-color: red;");
        }

        if(SEATSTATUS[26]==0){
            seat27.setStyle("-fx-background-color: green;");
        }else{
            seat27.setStyle("-fx-background-color: red;");
        }

        if(SEATSTATUS[27]==0){
            seat28.setStyle("-fx-background-color: green;");
        }else{
            seat28.setStyle("-fx-background-color: red;");
        }

        if(SEATSTATUS[28]==0){
            seat29.setStyle("-fx-background-color: green;");
        }else{
            seat29.setStyle("-fx-background-color: red;");
        }

        if(SEATSTATUS[29]==0){
            seat30.setStyle("-fx-background-color: green;");
        }else{
            seat30.setStyle("-fx-background-color: red;");
        }

        if(SEATSTATUS[30]==0){
            seat31.setStyle("-fx-background-color: green;");
        }else{
            seat31.setStyle("-fx-background-color: red;");
        }

        if(SEATSTATUS[31]==0){
            seat32.setStyle("-fx-background-color: green;");
        }else{
            seat32.setStyle("-fx-background-color: red;");
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



        for (int i=0;i<32;i++){
            SEATSTATUS[i]=seatStatus[i];
            if (SEATSTATUS[i]==0){
                seatCount++;
            }
        }
        System.out.println(seatCount+"  sfsdsdf ");
        if (seatCount==0){
            SeeSeat.setStyle("-fx-background-color: red;");
            SeeSeat.setText("No Seat Available!");
        }
        try {
            SetSeatStatusFromSeatId();
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


    public void SEAT31(ActionEvent actionEvent) {
        if (SEATSTATUS[30]==0){
            SEATSTATUS[30]=01;
            seat31.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[30]==0){
            SEATSTATUS[30]=0;
            seat31.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT32(ActionEvent actionEvent) {
        if (SEATSTATUS[31]==0){
            SEATSTATUS[31]=01;
            seat32.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[31]==0){
            SEATSTATUS[31]=0;
            seat32.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT1(ActionEvent actionEvent) {
        if (SEATSTATUS[0]==0){
            SEATSTATUS[0]=01;
            seat1.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[0]==0){
            SEATSTATUS[0]=0;
            seat1.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT2(ActionEvent actionEvent) {
        if (SEATSTATUS[1]==0){
            SEATSTATUS[1]=01;
            seat2.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[1]==0){
            SEATSTATUS[1]=0;
            seat2.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT3(ActionEvent actionEvent) {
        if (SEATSTATUS[2]==0){
            SEATSTATUS[2]=01;
            seat3.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[2]==0){
            SEATSTATUS[2]=0;
            seat3.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT4(ActionEvent actionEvent) {
        if (SEATSTATUS[3]==0){
            SEATSTATUS[3]=01;
            seat4.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[3]==0){
            SEATSTATUS[3]=0;
            seat4.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT5(ActionEvent actionEvent) {
        if (SEATSTATUS[4]==0){
            SEATSTATUS[4]=01;
            seat5.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[4]==0){
            SEATSTATUS[4]=0;
            seat5.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT6(ActionEvent actionEvent) {
        if (SEATSTATUS[5]==0){
            SEATSTATUS[5]=01;
            seat6.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[5]==0){
            SEATSTATUS[5]=0;
            seat6.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT7(ActionEvent actionEvent) {
        if (SEATSTATUS[6]==0){
            SEATSTATUS[6]=01;
            seat7.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[6]==0){
            SEATSTATUS[6]=0;
            seat7.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT8(ActionEvent actionEvent) {
        if (SEATSTATUS[7]==0){
            SEATSTATUS[7]=01;
            seat8.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[7]==0){
            SEATSTATUS[7]=0;
            seat8.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT9(ActionEvent actionEvent) {
        if (SEATSTATUS[8]==0){
            SEATSTATUS[8]=01;
            seat9.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[8]==0){
            SEATSTATUS[8]=0;
            seat9.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT10(ActionEvent actionEvent) {
        if (SEATSTATUS[9]==0){
            SEATSTATUS[9]=01;
            seat10.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[9]==0){
            SEATSTATUS[9]=0;
            seat10.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT11(ActionEvent actionEvent) {
        if (SEATSTATUS[10]==0){
            SEATSTATUS[10]=01;
            seat11.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[10]==0){
            SEATSTATUS[10]=0;
            seat11.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT12(ActionEvent actionEvent) {
        if (SEATSTATUS[11]==0){
            SEATSTATUS[11]=01;
            seat12.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[11]==0){
            SEATSTATUS[11]=0;
            seat12.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT13(ActionEvent actionEvent) {
        if (SEATSTATUS[12]==0){
            SEATSTATUS[12]=01;
            seat13.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[12]==0){
            SEATSTATUS[12]=0;
            seat13.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT14(ActionEvent actionEvent) {
        if (SEATSTATUS[13]==0){
            SEATSTATUS[13]=01;
            seat14.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[13]==0){
            SEATSTATUS[13]=0;
            seat14.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT15(ActionEvent actionEvent) {
        if (SEATSTATUS[14]==0){
            SEATSTATUS[14]=01;
            seat15.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[14]==0){
            SEATSTATUS[14]=0;
            seat15.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT16(ActionEvent actionEvent) {
        if (SEATSTATUS[15]==0){
            SEATSTATUS[15]=01;
            seat16.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[15]==0){
            SEATSTATUS[15]=0;
            seat16.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT17(ActionEvent actionEvent) {
        if (SEATSTATUS[16]==0){
            SEATSTATUS[16]=01;
            seat17.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[16]==0){
            SEATSTATUS[16]=0;
            seat17.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT18(ActionEvent actionEvent) {
        if (SEATSTATUS[17]==0){
            SEATSTATUS[17]=01;
            seat18.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[17]==0){
            SEATSTATUS[17]=0;
            seat18.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT19(ActionEvent actionEvent) {
        if (SEATSTATUS[18]==0){
            SEATSTATUS[18]=01;
            seat19.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[18]==0){
            SEATSTATUS[18]=0;
            seat19.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT20(ActionEvent actionEvent) {
        if (SEATSTATUS[19]==0){
            SEATSTATUS[19]=01;
            seat20.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[19]==0){
            SEATSTATUS[19]=0;
            seat20.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT21(ActionEvent actionEvent) {
        if (SEATSTATUS[20]==0){
            SEATSTATUS[20]=01;
            seat21.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[20]==0){
            SEATSTATUS[20]=0;
            seat21.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT22(ActionEvent actionEvent) {
        if (SEATSTATUS[21]==0){
            SEATSTATUS[21]=01;
            seat22.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[21]==0){
            SEATSTATUS[21]=0;
            seat22.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT23(ActionEvent actionEvent) {
        if (SEATSTATUS[22]==0){
            SEATSTATUS[22]=01;
            seat23.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[22]==0){
            SEATSTATUS[22]=0;
            seat23.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT24(ActionEvent actionEvent) {
        if (SEATSTATUS[23]==0){
            SEATSTATUS[23]=01;
            seat24.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[23]==0){
            SEATSTATUS[23]=0;
            seat24.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT25(ActionEvent actionEvent) {
        if (SEATSTATUS[24]==0){
            SEATSTATUS[24]=01;
            seat25.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[24]==0){
            SEATSTATUS[24]=0;
            seat25.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT26(ActionEvent actionEvent) {
        if (SEATSTATUS[25]==0){
            SEATSTATUS[25]=01;
            seat26.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[25]==0){
            SEATSTATUS[25]=0;
            seat26.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT27(ActionEvent actionEvent) {
        if (SEATSTATUS[26]==0){
            SEATSTATUS[26]=01;
            seat27.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[26]==0){
            SEATSTATUS[26]=0;
            seat27.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT28(ActionEvent actionEvent) {
        if (SEATSTATUS[27]==0){
            SEATSTATUS[27]=01;
            seat28.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[27]==0){
            SEATSTATUS[27]=0;
            seat28.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT29(ActionEvent actionEvent) {
        if (SEATSTATUS[28]==0){
            SEATSTATUS[28]=1;
            seat29.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[28]==0){
            SEATSTATUS[28]=0;
            seat29.setStyle("-fx-background-color: red;");
        }
    }

    public void SEAT30(ActionEvent actionEvent) {
        if (SEATSTATUS[29]==0){
            SEATSTATUS[29]=1;
            seat30.setStyle("-fx-background-color: red;");
        }else if (SEATSTATUS[29]==0){
            SEATSTATUS[29]=0;
            seat30.setStyle("-fx-background-color: red;");
        }
    }

    public void Confirm(ActionEvent actionEvent) throws SQLException, IOException {
        int count=0;
        for(int i=0;i<32;i++){
            if(SEATSTATUS[i]!=seatStatus[i]){
                count++;
            }
        }

        if(count==0){
            Wronglabel.setText("NO SEAT HAS CHOOSEN!! ");
        }
        else {
            setPassengerNumbeR(SEATSTATUS);
            setFromSeat(SEATSTATUS);
            setToSeat(SEATSTATUS);
            setSeatStatus(SEATSTATUS);
            SS = 1;
            passengerDetailsPageStage(actionEvent);
        }
    }

    public void SeeSeat(ActionEvent actionEvent) throws SQLException{
        if(seatCount!=0) {
            StatusOfSeat.setVisible(false);
        }
    }
    public void StandingTicket(ActionEvent actionEvent) throws IOException{
        SS=0;
        passengerNumber=1;
        passengerDetailsPageStage(actionEvent);

    }
}
