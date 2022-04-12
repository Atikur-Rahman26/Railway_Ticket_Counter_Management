package com.example.railway_ticket_management_system;

import com.example.DB.Passenger;
import com.example.DB.ServiceHolder;
import com.example.Structure.Stuff;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {

    public double x,y=0;
    public int count=0;

    @Override
    public void start(Stage stage) throws IOException {
        try{
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("WelcomePage.fxml"));
            Parent root=fxmlLoader.load();
            if(count==0){
                stage.initStyle(StageStyle.UNDECORATED);
                count++;
            }

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
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        launch(args);
    }
}
