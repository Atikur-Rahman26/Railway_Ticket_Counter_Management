package com.example.DB;

import java.sql.*;

public class Compartment extends ServiceHolder{

    public static int[] seatStatus=new int[32];
    public static int[] seatId=new int[32];
    public static String Compartment;

    public String getCompartment() {
        return Compartment;
    }

    public void setCompartment(String compartment) {
        Compartment = compartment;
    }

    public int[] getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(int[] seatStatus) {
        this.seatStatus = seatStatus;
    }

    public int[] getSeatId() {
        return seatId;
    }

    public void setSeatId(int[] seatId) {
        this.seatId = seatId;
    }

    public int[] getSeatIdfromTable(int Trip_ID) throws SQLException {
        int[] arr = new int[32];
        String stmnt = "SELECT * FROM Compartment";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(stmnt);

        int j = 0;
        while (resultSet.next()) {
            int id=resultSet.getInt(1);
            if(id==Trip_ID){
                arr[j]=resultSet.getInt(3);
                j++;
            }
        }
        statement.close();
        resultSet.close();
        return arr;
    }


    public int[] getSeatStatus(int Trip_ID) throws SQLException {
        int[] arr = new int[32];
        String stmnt = "SELECT * FROM Compartment";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(stmnt);

        int j = 0;
        while (resultSet.next()) {
            int id=resultSet.getInt(1);
            if(id==Trip_ID){
                arr[j]=resultSet.getInt(4);
                j++;
            }
        }

        statement.close();
        resultSet.close();
        return arr;
    }

    public void updateSeatStatus(int Trip_ID,int Status,int SeatID) throws SQLException{
        String query="UPDATE Compartment SET Status= "+Status+" WHERE Trip_ID= "+Trip_ID+" AND Seat_ID = "+SeatID;

        Statement statement=connection.createStatement();
        statement.executeUpdate(query);
        statement.close();
    }

    public void updateSeatStatus(int TripId) throws SQLException{
        String query="UPDATE Compartment SET Status = 0 WHERE Trip_ID = "+TripId;
        Statement statement1=connection.createStatement();
        statement1.executeUpdate(query);
//        System.out.println("1213231231");
        statement1.close();
    }

    public void CheckCompartment(int tripId)throws SQLException{
        String SqlStatement="SELECT * FROM Compartment";
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(SqlStatement);

        int a;
        while(resultSet.next()){
            a=resultSet.getInt(1);
            if(a==tripId){
                setCompartment(resultSet.getString(2));
                break;
            }
        }
        statement.close();
        resultSet.close();
    }
}
