package com.example.DB;

import java.sql.*;

public class TrainSchedule extends Compartment{


    public  String[] getStation() throws SQLException {
        String SqlStament="SELECT * FROM Schedule";
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(SqlStament);

        String Departure="";
        while (resultSet.next()){
            Departure+=resultSet.getString("Departure_Station")+',';
        }
        String[] Station=new String[20];
        Station=unique(Departure,Departure.length());
        statement.close();
        return Station;
    }


    public  String[] getStation(String Departure) throws SQLException{
        Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/RTCM.db");
        String SqlStament="SELECT * FROM Schedule";
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(SqlStament);

        String Station1="";
        while (resultSet.next()){
            String DepartureStation=resultSet.getString("Departure_Station");
            if(DepartureStation.equals(Departure)){
                Station1+=resultSet.getString("Destination_Station")+',';
            }
        }
        String[] Station=new String[20];
        Station=unique(Station1,Station1.length());
        statement.close();
        return Station;
    }


    public String[] getStation(String Departure,String Destination) throws SQLException{

        String SqlStament="SELECT * FROM Schedule";
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(SqlStament);

        String Station1="";
        while (resultSet.next()){
            String DepartureStation=resultSet.getString("Departure_Station");
            String destinationStation=resultSet.getString("Destination_Station");
            if(DepartureStation.equals(Departure)&&destinationStation.equals(Destination)){
                Station1+=resultSet.getString("Train_Name")+',';
            }
        }
        String[] Station =unique(Station1,Station1.length());


        statement.close();
        return Station;
    }

    public int tripId(String Departure,String Destination,String TrainName
            ,String Date) throws SQLException{
        int a=0;
        String sqlStatement="SELECT * FROM Schedule";
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sqlStatement);

        String Dep,Des,dat,Tr="";
        while (resultSet.next()){
            Dep=resultSet.getString(2);
            Des=resultSet.getString(3);
            Tr=resultSet.getString(5);
            dat=resultSet.getString(6);

            if (Dep.equals(Departure)&&Des.equals(Destination)&&TrainName.equals(Tr)&&Date.equals(dat)){
                a=resultSet.getInt(1);
            }
        }
        statement.close();
        return a;
    }


    public int[] getTripId(String date) throws SQLException{
        Connection connection=DriverManager.getConnection("jdbc:sqlite:src/main/" +
                "resources/RTCM.db");

        int[] arr=new int[240];
        int i=0;

        String query="SELECT * FROM Schedule WHERE Date = '"+date+"'";
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(query);

        while(resultSet.next()){
            arr[i]=resultSet.getInt(1);
            i++;
        }

        statement.close();
        resultSet.close();
        return arr;
    }

    public String[]  getTime(int TripId) throws SQLException{
        String sqlStatement="SELECT * FROM Schedule";
        String[] Time=new String[3];
        int a=0;
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sqlStatement);
        while (resultSet.next()){
            a=resultSet.getInt(1);
            if(a==TripId) {
                Time[1] = resultSet.getString(7);
                Time[2] = resultSet.getString(8);
                Time[0] = resultSet.getString(5);
                break;
            }
        }

        statement.close();
        resultSet.close();
        return Time;
    }

    public int[] getTripIdFromSchedule(String Departure,String Destination,
                                       String Date) throws SQLException{

        String SqlStatment="SELECT * FROM  Schedule WHERE Departure_Station = " +
                "'"+Departure+"' AND Destination_Station='"+Destination+"' AND Date='"+Date+"'";
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(SqlStatment);

        int[] arr=new int[3];
        int i=0;
        while (resultSet.next()){
            arr[i]=resultSet.getInt(1);
            i++;
        }

        statement.close();
        resultSet.close();
        return arr;
    }

    public void insertDataIntoTrainSchedule(String Departure,String Destination,String Train,
                                            String UpDown,String DepartureTime,String DestinationTime,
                                            String date) throws SQLException{
        String sqlStatement="INSERT INTO Schedule (Trip_ID,Departure_Station,Destination_Station,"
                +"Up_Down,Train_Name,Date,DepartureTime,DestinationTime) "+
                "VALUES(?,?,?,?,?,?,?,?);";
        PreparedStatement preparedStatement=connection.prepareStatement(sqlStatement);
        preparedStatement.setString(2,Departure);
        preparedStatement.setString(3,Destination);
        preparedStatement.setString(4,UpDown);
        preparedStatement.setString(5,Train);
        preparedStatement.setString(6,date);
        preparedStatement.setString(7,DepartureTime);
        preparedStatement.setString(8,DestinationTime);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void insertIntoCompartment(int trip_id,String ComprtmentName,int SeatID)throws SQLException{
        String sqlStament="INSERT INTO Compartment (Trip_ID,Compartment_Name," +
                "Seat_ID,Status) VALUES(?,?,?,?);";
        PreparedStatement preparedStatement=connection.prepareStatement(sqlStament);
        preparedStatement.setInt(1,trip_id);
        preparedStatement.setString(2,ComprtmentName);
        preparedStatement.setInt(3,SeatID);
        preparedStatement.setInt(4,0);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
