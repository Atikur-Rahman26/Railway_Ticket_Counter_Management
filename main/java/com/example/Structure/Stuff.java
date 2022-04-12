package com.example.Structure;

import com.example.DB.Passenger;
import com.example.DB.TrainSchedule;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Stuff extends Train {
    public static String Password;
    public static String user_id;
    public static int seatCount=0;

    public static String servingStation;
    public static String PassengerDeparture,PassengerDestination;
    public static String PassengerTrain,NId,PassengerName;

    public static String Admin="Admin",AdminPassword="1901@";

    public static String getPassengerName() {
        return PassengerName;
    }

    public static void setPassengerName(String passengerName) {
        PassengerName = passengerName;
    }

    public static String name;
    public static int total_ticket_sell,Total_amount,SS=0;

    public static int passengerNumber,FromSeat,ToSeat,PerPersonPrice;

    public  String getPassengerDeparture() {
        return PassengerDeparture;
    }

    public  void setPassengerDeparture(String passengerDeparture) {
        PassengerDeparture = passengerDeparture;
    }

    public  String getPassengerDestination() {
        return PassengerDestination;
    }

    public  void setPassengerDestination(String passengerDestination) {
        PassengerDestination = passengerDestination;
    }

    public  String getPassengerTrain() {
        return PassengerTrain;
    }

    public  void setPassengerTrain(String passengerTrain) {
        PassengerTrain = passengerTrain;
    }

    public String getServingStation() {
        return servingStation;
    }

    public void setServingStation(String station) {
        servingStation = station;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal_ticket_sell() {
        return total_ticket_sell;
    }

    public void setTotal_ticket_sell(int total_ticket_sell) {
        this.total_ticket_sell = total_ticket_sell;
    }

    public int getTotal_amount() {
        return Total_amount;
    }

    public void setTotal_amount(int total_amount) {
        Total_amount = total_amount;
    }



    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public boolean Validlogin() throws SQLException {
        String[][] str=Check();
        System.out.println(user_id+"----"+Password);
        for (int i=0;i<3;i++){
            if(str[i][0].equals(user_id)&&str[i][1].equals(Password)){
                return true;
            }
        }
        return false;
    }

    public void settingName()throws SQLException{
        String sqlStatement="SELECT * FROM StuffTable";
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sqlStatement);

        while (resultSet.next()){
            String user_id=resultSet.getString(1);
            if(user_id.equals(getUser_id())){
                setName(resultSet.getString(3));
                setServingStation(resultSet.getString(4));
                setTotal_ticket_sell(resultSet.getInt(5));
                setTotal_amount(resultSet.getInt(6));
                break;
            }
        }
    }

    public boolean isSeatAvailable()throws SQLException{
        int count=0;
        for(int i=0;i<32;i++){
            if(seatStatus[i]!=0){
                count++;
            }
        }
        if (count==32){
            return false;
        }
        else {
            return  true;
        }
    }

    public List<String> getDateSell()throws SQLException {
        String[] str=getDateFromSellingHistroy(user_id);
        List<String> list=new ArrayList<>();
        for (int i=0;i<str.length;i++){
            list.add(str[i]);
        }
        return list;
    }


    public void BookTicket(String pname,String Nid,String Departure,String Destination,
                           String Date,
                           String Train,int ticket,int bill) throws SQLException{
        InsertPassengerData(pname,Nid,Departure,Destination,Train,Compartment,
                Date,ticket,name,bill);

    }


    public int[] SeeSelfHistory(String userId,String Date) throws SQLException{
        int i=0;
        int[] arr=getSellHistory(userId,Date);
        for (i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
        return arr;
    }

    public void addTicketHistory(String userID,String Date,int ticketnumber,int ticketPrice) throws SQLException{
        UpdateDataStuffTable(ticketnumber,ticketnumber,userID);
    }

    public void updateName(String userId,String Name,String Password,String Station) throws SQLException{
        UpdateDataStuffTable(userId,Password,Name,Station);
    }
    public void setNameServer()throws SQLException{
        name=getNameServe(user_id);
    }

    public void setPassengerNumbeR(int[] arr){
        int count=0;
        for (int i=0;i<32;i++){
            if (seatStatus[i]!=arr[i]){
                count++;
            }
        }
        passengerNumber=count;
    }

    public void setFromSeat(int [] arr){
        for (int i=0;i<32;i++){
            if(seatStatus[i]!=arr[i]){
                System.out.println(seatStatus[i]+"-----"+arr[i]);
                FromSeat=i+1;
                break;
            }
        }
    }

    public void setToSeat(int [] arr){
        for (int i=0;i<32;i++){
            if(seatStatus[i]!=arr[i]){
                ToSeat=i+1;
            }
        }
    }


    public int totalbill(int passengerNumber,int perPersonPrice) {
        int a=0;
        a=passengerNumber*perPersonPrice;
        return a;
    }

    public void updateSellHistory(int passengerNumber,int totalprice)throws SQLException{
        int arr[]=getSellHistory(user_id,Date);
        arr[0]=arr[0]+passengerNumber;
        arr[1]=arr[1]+totalprice;
        UpdateSellingHistory(user_id,Date,arr[0],arr[1]);
    }

    public void updateSellHistoryTable() throws SQLException{
        LocalDate localDate=LocalDate.now();
        String today=localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        String str=getLastDate();
        String[][] userInfo=getUserIDandName();

        localDate=LocalDate.now().plusDays(1);
        String tomorrow=localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if (str.equals(today)){
            for(int i=0;i<3;i++){
                InsertSellingHistory(userInfo[i][0],userInfo[i][1],tomorrow,0,0);
            }
        }
        else if (str.equals(tomorrow)){

        }
        else {
            for(int i=0;i<3;i++){
                InsertSellingHistory(userInfo[i][0],userInfo[i][1],today,0,0);
            }
            for(int i=0;i<3;i++){
                InsertSellingHistory(userInfo[i][0],userInfo[i][1],tomorrow,0,0);
            }
        }

        System.out.println("Date from seelhistroy: "+str);
    }

    public void updateSellHistroy(int ticketNumber,int bill) throws SQLException{
        int[] arr=getSellHistory(user_id,Date);
        arr[0]+=ticketNumber;
        arr[1]+=bill;
        UpdateSellingHistory(user_id,Date,arr[0],arr[1]);
    }

    public void setNULL() {
        Departure="";
        Destination="";
        Train="";
        Date="";
        Compartment="";
        FromSeat=0;
        ToSeat=0;
        PassengerName="";
        NId="";
        Total_amount=0;
        passengerNumber=0;
        seatCount=0;
    }

    public boolean isNULL(){
        if (Departure==null|| Departure==null||Train==null ||Date==null){
            return true;
        }
        else {
            return false;
        }
    }

    public List<String>getDateForSeelingHistory(String userId) throws SQLException{
        String[] str= getDateFromSellingHistroy(userId);
        List<String>list=new ArrayList<>();

        for(int i=0;i< str.length;i++){
            list.add(str[i]);
        }
        return list;
    }


    public List<String>NameForComboBox() throws SQLException{
        String[] str= GetNamE();
        List<String>list=new ArrayList<>();

        for(int i=0;i< str.length;i++){
            list.add(str[i]);
        }
        return list;
    }



//    public String[] getDateFromSellHistory()throws SQLException{
//
//    }
}
