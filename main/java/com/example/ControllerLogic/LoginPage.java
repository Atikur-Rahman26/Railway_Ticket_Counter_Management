package com.example.ControllerLogic;

import com.example.railway_ticket_management_system.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPage extends HomePage{
    public double x,y=0;

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
}
