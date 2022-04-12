package com.example.ControllerLogic;

import com.example.railway_ticket_management_system.BookTicket;
import com.example.railway_ticket_management_system.Seat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class SeatPage extends PassengerDetailsPage {

    double x,y=0;
    public void SeatPageStage(ActionEvent actionEvent) throws IOException,SQLException{

        FXMLLoader fxmlLoader=new FXMLLoader(Seat.class.getResource("Seat.fxml"));
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        Parent root=fxmlLoader.load();

        root.setOnMousePressed(mouseEvent -> {
            x=mouseEvent.getSceneX();
            y=mouseEvent.getSceneY();
        });

        root.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX()-x);
            stage.setY(mouseEvent.getScreenY()-y);
        });
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("=="+getTripId());
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
    }


}
