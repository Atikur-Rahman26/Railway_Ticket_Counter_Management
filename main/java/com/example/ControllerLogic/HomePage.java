package com.example.ControllerLogic;

import com.example.railway_ticket_management_system.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePage extends TicketConfirmationPage {
    double x,y=0;

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
}
