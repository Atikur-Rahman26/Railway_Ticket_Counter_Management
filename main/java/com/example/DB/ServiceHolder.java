package com.example.DB;

import java.sql.*;

public class ServiceHolder extends Passenger{

    public String[][] Check() throws SQLException{
        String[][] str=new String[3][2];
        int i=0;
        String sqlStatement="SELECT * FROM StuffTable";
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sqlStatement);
        while (resultSet.next()){
            str[i][0]=resultSet.getString(1);
            str[i][1]=resultSet.getString(2);
            i++;
        }
//        String[][] arr=new String[][];
        return str;
    }

    public void UpdateDataStuffTable(String PAssword,String name,String Station,int total_ticket_sell,
                                     int total_amount,String old_user) throws SQLException{
        String sqlStatement="UPDATE StuffTable SET Password='"+ PAssword+"',Name='"+name+"'," +
                "Total_sell_Ticket="+total_ticket_sell+",Total_amount="+total_amount +" WHERE Unique_id='"+old_user+"';";
        Statement statement=connection.createStatement();
        statement.execute(sqlStatement);
        statement.close();
    }
    public void UpdateDataStuffTable(int total_ticket_sell,int total_amount,String old_user) throws SQLException{
        String sqlStatement="UPDATE StuffTable SET Total_sell_Ticket="+total_ticket_sell+",Total_amount="
                +total_amount +" WHERE Unique_id='"+old_user+"';";
        Statement statement=connection.createStatement();
        statement.execute(sqlStatement);
        statement.close();
    }

    public void UpdateDataStuffTable(String serviceMan,String Password,String Name
            ,String Station) throws SQLException{
        String sqlStatement="UPDATE StuffTable SET Password='"+Password+"',Name='"+Name +"',Station='" +
                ""+ Station+"' WHERE Unique_id='"+serviceMan+"';";
        Statement statement=connection.createStatement();
        statement.execute(sqlStatement);
        statement.close();
    }

    public void CreateSellingHistory() throws SQLException{
        String sqlStatement="CREATE TABLE IF NOT EXISTS SellingHistory (Date TEXT,UserID TEXT,Name " +
                "TEXT,TicketNumber INTEGER,TicketSell INTEGER);";
        PreparedStatement preparedStatement=connection.prepareStatement(sqlStatement);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    public void InsertSellingHistory(String UserID,String Name,String Date,int ticketNumber,
                                     int ticketsell) throws SQLException{
        String sqlStatement="INSERT INTO SellingHistory (Date,UserID,Name" +
                ",TicketNumber,TicketSell) VALUES(?,?,?,?,?);";
        PreparedStatement preparedStatement=connection.prepareStatement(sqlStatement);
        preparedStatement.setString(1,Date);
        preparedStatement.setString(2,UserID);
        preparedStatement.setString(3,Name);
        preparedStatement.setInt(4,ticketNumber);
        preparedStatement.setInt(5,ticketsell);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void UpdateSellingHistory(String UserID,String Date,int ticketNumber,int ticketSell)throws SQLException{
        String sqlStatement = "UPDATE SellingHistory SET TicketNumber="+ticketNumber+",TicketSell="+ticketSell+" " +
                "WHERE Date='"+Date+"' AND UserID='"+UserID+"';";
        Statement statement=connection.createStatement();
        statement.execute(sqlStatement);
        statement.close();
    }

    public String[] getDateFromSellingHistroy(String UserId)throws SQLException{
        String sqlStatment="SELECT * FROM SellingHistory ";
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sqlStatment);
        String[] date=new String[1000];
        String str="";
        int i=0;
        while (resultSet.next()){
            str=resultSet.getString(2);
            if(str.equals(UserId)){
                date[i]=resultSet.getString(1);
                i++;
            }
        }

        String[] str1=new String[i];
        for (int j=0;j<i;j++){
            str1[j]=date[j];
        }

        for(int j=0;j<i;j++){
            System.out.println("-----"+str1[j]);
        }
        statement.close();
        resultSet.close();
        return str1;
    }



    public int[] getSellHistory(String userId,String Date) throws SQLException{
        String date,str=null;
        int[] arr=new int[2];
        String sqlStatment="SELECT * FROM SellingHistory ";
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sqlStatment);
        while (resultSet.next()){
            date=resultSet.getString(1);
            str=resultSet.getString(2);
            if (date.equals(Date)&&userId.equals(str)){
                arr[0]=resultSet.getInt(4);
                arr[1]=resultSet.getInt(5);
                break;
            }
        }

        statement.close();
        resultSet.close();
        return arr;
    }

    public String getNameServe(String userID) throws SQLException{
        String sqlStatement="SELECT * FROM StuffTable ";
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sqlStatement);
        String str="";
        String us="";
        while (resultSet.next()){
            us=resultSet.getString(1);
            if (us.equals(userID)){
                str=resultSet.getString(3);
                break;
            }
        }

        statement.close();
        resultSet.close();
        return str;
    }

    public String[][] getUserIDandName() throws SQLException{
        String sql="SELECT * FROM StuffTable ";
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sql);
        String[][] str=new String[3][2];
        int i=0;
        while(resultSet.next()){
                str[i][0]=resultSet.getString(1);
                str[i][1]=resultSet.getString(3);

            i++;
        }
        statement.close();
        resultSet.close();
        return str;
    }

    public String getLastDate()throws SQLException{
        String str="";
        String sqlStatement="SELECT * FROM SellingHistory";
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sqlStatement);

        while(resultSet.next()){
            str=resultSet.getString(1);
        }

        statement.close();
        resultSet.close();
        return str;
    }

    public String[] GetNamE() throws SQLException{
        String sqlSatament="SELECT *  FROM StuffTable ";
        String[] name=new String[3];
        int i=0;
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sqlSatament);

        while(resultSet.next()){
            name[i]=resultSet.getString(3);
            i++;
        }

        statement.close();
        resultSet.close();
        return name;
    }

    public String getUSERID(String name) throws SQLException{
        String SqlStatement="SELECT * FROM StuffTable ";
        String uID="";
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(SqlStatement);
        String uid="";
        while(resultSet.next()){
            uID=resultSet.getString(3);
            if (uID.equals(name)){
                uid=resultSet.getString(1);
            }
        }
        statement.close();
        resultSet.close();

        return uid;
    }
}
