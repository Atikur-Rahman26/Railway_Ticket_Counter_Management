package com.example.Structure;

import com.example.DB.TrainSchedule;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Train extends TrainSchedule {
    public static int tripId;
    public static int[] Trip_Id=new int[240];
    public static String Departure,Destination,Train,Date;
    public static int[] trip_id_for_schedule=new int[3];


    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public int[] getTrip_Id() {
        return Trip_Id;
    }

    public void setTrip_Id(int[] trip_Id) {
        Trip_Id = trip_Id;
    }

    public String getDeparture() {
        return Departure;
    }

    public void setDeparture(String departure) {
        Departure = departure;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public String getTrain() {
        return Train;
    }

    public void setTrain(String train) {
        Train = train;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }


    public  void updateDate() throws SQLException, IOException, ParseException {
        String sqlStatement="SELECT * FROM Schedule";
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sqlStatement);
        String store="";
        int count=0,i=0;
        String[] getDate=new String[2];
        while(resultSet.next()){
            if(count==0){
                getDate[i]=resultSet.getString(6);
                i++;
                count++;
            }
            else {
                store=resultSet.getString(6);
                if (!(getDate[0].equals(store))){
                    getDate[i]=store;
                    break;
                }
            }
        }
        statement.close();


        String[] DATE=new String[2];
        LocalDate localDate=LocalDate.now();
        DATE[0]=localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        localDate=localDate.now().plusDays(1);
        DATE[1]=localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        getDate=sortDate(getDate);
        int[] arr=new int[240];


        if(DATE[0].equals(getDate[1])){
            arr=getTripId(getDate[0]);

            for (int a = 0; a<arr.length;a++){
                if(arr[a]!=0){
                    System.out.println("Updated :"+arr[a]);
                    updateSeatStatus(arr[a]);
                }
            }
            String query="UPDATE Schedule SET Date= '"+DATE[1]+"' WHERE Date = '"+getDate[0]+"';";
            System.out.println(query);
            Statement statement1=connection.createStatement();
            statement1.executeUpdate(query);
            statement1.close();
        }
        else {
            arr=getTripId(getDate[0]);
            int[] arr1=getTripId(getDate[1]);
            for (int a = 0; a<arr.length;a++){
                if(arr[a]!=0){
                    updateSeatStatus(arr[i]);
                }
            }

            for (int a = 0; a<arr1.length;a++){
                if(arr1[a]!=0){
                    updateSeatStatus(arr1[i]);
                }
            }
            String query="UPDATE Schedule SET Date= '"+DATE[0]+ "' WHERE Date= '"+getDate[0]+"';";
            Statement statement1=connection.createStatement();
            statement1.executeUpdate(query);


            query="UPDATE Schedule SET Date= '"+DATE[1]+"' WHERE Date='"+getDate[1]+"';";
            statement1=connection.createStatement();
            statement1.executeUpdate(query);
            statement1.close();
        }
    }

    public List<String> getReturnDeparture()throws SQLException {
        String[] str=getStation();
        List<String> list=new ArrayList<>();
        for (int i=0;i<str.length;i++){
            list.add(str[i]);
        }
        return list;
    }

    public List<String>getReturnDestination() throws SQLException{
        String[] str= getStation(getDeparture());
        List<String>list=new ArrayList<>();

        for(int i=0;i< str.length;i++){
            list.add(str[i]);
        }
        return list;
    }

    public List<String>getReturnTrain() throws SQLException{
        String[] str= getStation(getDeparture(),getDestination());
        List<String>list=new ArrayList<>();
        for(int i=0;i<str.length;i++){
            list.add(str[i]);
        }
        return list;
    }

    public void setTripIdForSchedule() throws SQLException{
        trip_id_for_schedule= getTripIdFromSchedule(Departure,Destination,Date);
    }
}
