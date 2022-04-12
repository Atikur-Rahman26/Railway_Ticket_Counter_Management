package com.example.ControllerLogic;

import com.example.railway_ticket_management_system.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketConfirmationPage extends SeatPage{
    double x,y=0;


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
}
