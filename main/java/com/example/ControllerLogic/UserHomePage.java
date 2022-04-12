package com.example.ControllerLogic;

import com.example.Structure.Stuff;
import com.example.railway_ticket_management_system.Login;
import com.example.railway_ticket_management_system.Main;
import com.example.railway_ticket_management_system.Seat;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class UserHomePage extends Stuff {

    double x,y=0;
    public void confirmationpageStage(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(Main.class.getResource("ConfirmationPage.fxml"));
        Stage stage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

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
    }

    public  void HomepageStage(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader=new FXMLLoader(Main.class.getResource("Home.fxml"));
        Stage stage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

        Parent root=fxmlLoader.load();
        Scene scene=new Scene(root);

        root.setOnMousePressed(mouseEvent -> {
            x=mouseEvent.getSceneX();
            y=mouseEvent.getSceneY();
        });

        root.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX()-x);
            stage.setY(mouseEvent.getScreenY()-y);
        });
        stage.setScene(scene);
        stage.show();
    }

    public void LoginPageStage(ActionEvent actionEvent)throws IOException{
        FXMLLoader fxmlLoader=new FXMLLoader(Login.class.getResource("Login.fxml"));
        Stage stage=(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
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
    }

    public void passengerDetailsPageStage(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader=new FXMLLoader(Main.class.getResource("PassengerDetails.fxml"));
        Stage stage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

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

    }

    public void SeatPageStage(ActionEvent actionEvent) throws IOException, SQLException {

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

    public void SeeSellHistoryPageStage(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader=new FXMLLoader(Main.class.getResource("SeeSellHistory.fxml"));
        Stage stage=(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
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



    }

    public void TicketConfirmationPageStage(ActionEvent actionEvent) throws IOException{
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(Main.class.getResource("BookTicket.fxml"));
            Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            Parent root=fxmlLoader.load();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
            System.out.println(name);

            root.setOnMousePressed(mouseEvent -> {
                x=mouseEvent.getSceneX();
                y=mouseEvent.getSceneY();
            });

            root.setOnMouseDragged(mouseEvent -> {
                stage.setX(mouseEvent.getScreenX()-x);
                stage.setY(mouseEvent.getScreenY()-y);
            });
        }
        catch (Exception a){
            a.printStackTrace();
        }
    }

    public void WelcomeLogicStage(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader=new FXMLLoader(Main.class.getResource("WelcomePage.fxml"));
        Parent root=fxmlLoader.load();
        Stage stage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
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
    }

    public void TrainSchedulePageStage(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader=new FXMLLoader(Main.class.getResource("TrainSchedule.fxml"));
        Stage stage=(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
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
    }
}
