package com.example.DB;

import java.sql.*;

public class Passenger extends sorting{


    public Connection connection;
    {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/RTCM.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void CreatePassenger() throws SQLException{
        String sqlStatement="CREATE TABLE IF NOT EXISTS Passenger (Name TEXT,NID TEXT," +
                "Departure TEXT,Destination TEXT," +
                "Train TEXT,Compartment TEXT,Date TEXT,Passenger INTEGER," +
                "ByPerson TEXT,Bill INTEGER);";
        PreparedStatement preparedStatement=connection.prepareStatement(sqlStatement);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void InsertPassengerData(String Name,String NID,String Departure,String Destination,String Train,
                                    String Compartment,String Date,int Passenger,String Byperson,int bill) throws SQLException{
        String sqlStatement="INSERT INTO Passenger "+"(Name,NID," +
                "Departure,Destination," +
                "Train,Compartment,Date,Passenger,ByPerson,Bill) VALUES(?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement preparedStatement=connection.prepareStatement(sqlStatement);
        preparedStatement.setString(1,Name);
        preparedStatement.setString(2,NID);
        preparedStatement.setString(3,Departure);
        preparedStatement.setString(4,Destination);
        preparedStatement.setString(5,Train);
        preparedStatement.setString(6,Compartment);
        preparedStatement.setString(7,Date);
        preparedStatement.setString(9,Byperson);
        preparedStatement.setInt(8,Passenger);
        preparedStatement.setInt(10,bill);

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public String[][] getPassengerDetails() throws SQLException{
        String sqlStatement="SELECT * FROM Passenger";
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sqlStatement);

        int i=0;
        String[][] pssngr=new String[10000][10];
        while (resultSet.next()){
            pssngr[i][0]=resultSet.getString(1);
            pssngr[i][1]=resultSet.getString(2);
            pssngr[i][2]=resultSet.getString(3);
            pssngr[i][3]=resultSet.getString(4);
            pssngr[i][4]=resultSet.getString(5);
            pssngr[i][5]=resultSet.getString(6);
            pssngr[i][6]=resultSet.getString(7);
            int a=resultSet.getInt(8);
            pssngr[i][7]=String.valueOf(a);
            pssngr[i][8]=resultSet.getString(9);
            a=resultSet.getInt(10);
            pssngr[i][9]=String.valueOf(a);
            i++;
        }

        String[][] store=new String[i][10];
        for(int j=0;j<i;j++){
            for(int a=0;a<10;a++){
                store[j][a]=pssngr[j][a];
            }
        }

        for(int j=0;j<i;j++){
            for (int a=0;a<10;a++){
                System.out.println("S: "+store[j][a]);
            }
        }
        resultSet.close();
        statement.close();
        return store;

    }
}
