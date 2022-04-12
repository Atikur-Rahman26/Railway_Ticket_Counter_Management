package com.example.ControllerLogic;

import com.example.Structure.Stuff;
import com.example.railway_ticket_management_system.Main;
import com.example.railway_ticket_management_system.Seat;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.lang.reflect.AccessibleObject;

public class AdminHomePage extends Stuff {
    double x,y=0;

    public void AdminLoginPageStage(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader=new FXMLLoader(Seat.class.getResource("AdminLogin.fxml"));
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

    }

    public void AdminHomePAge(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader=new FXMLLoader(Seat.class.getResource("AdminHome.fxml"));
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
    }


    public void SeeSellHistoryStage(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader=new FXMLLoader(Main.class.getResource("SeeSellHistoryAll.fxml"));
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

    }

    public void AddTrainInfoStage(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader=new FXMLLoader(Main.class.getResource("AddTrainInfo.fxml"));
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
    }

}
