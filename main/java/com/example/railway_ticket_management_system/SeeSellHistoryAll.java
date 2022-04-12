package com.example.railway_ticket_management_system;

import com.example.ControllerLogic.AdminHomePage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SeeSellHistoryAll extends AdminHomePage implements Initializable {

    public static String NaME,uId="";

    @FXML
    private Label TT,DaTe,TS,NaMe;

    @FXML
    private ImageView exit,minimize;

    @FXML
    private ComboBox DateComboBoxForSell,NameComboBoxForSell;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        exit.setOnMouseClicked(mouseEvent -> {
            System.exit(0);
        });

        minimize.setOnMouseClicked(mouseEvent -> {
            Stage stage=(Stage) ((ImageView)mouseEvent.getSource()).getScene().getWindow();

            stage.setIconified(true);
        });

        ObservableList<String> list = null;
        try {
            list = FXCollections.observableArrayList(NameForComboBox());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        NameComboBoxForSell.setItems(list);

    }

    public void SelectNameFromComboBox(ActionEvent actionEvent) throws SQLException{
        try{
            NaME=NameComboBoxForSell.getSelectionModel().getSelectedItem().toString();
            System.out.println(NaME);
            uId=getUSERID(NaME);
            System.out.println(uId);
            ObservableList<String> list=FXCollections.observableArrayList(getDateForSeelingHistory(uId));
            DateComboBoxForSell.setItems(list);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void SelectDateFromComboBox(ActionEvent actionEvent) throws SQLException{
        try{
            String dt=DateComboBoxForSell.getSelectionModel().getSelectedItem().toString();

            int[] arr=getSellHistory(uId,dt);
            NaMe.setText(NaME);
            DaTe.setText(dt);
            TT.setText(String.valueOf(arr[0]));
            TS.setText(String.valueOf(arr[1]));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void Home(ActionEvent actionEvent) throws IOException{
        AdminHomePAge(actionEvent);
    }
}
