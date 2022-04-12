package com.example.DB;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class sorting {
    public  String[] unique(String str, int length){

        int i=0,j=0;
        int count_comma=0;
        int[] count=new int[length];
        for (i=0;i<length;i++){
            if (str.charAt(i)==','){
                count_comma++;
                count[j]=i;
                j++;
            }
        }
        String[] strings=new String[count_comma];
        String[] unique_string=new String[count_comma];

        //spliting string
        for (i=0;i<count_comma;i++){
            strings[i]="";
            if(i==0){
                for(j=0;j<count[i];j++){
                    strings[i]+=str.charAt(j);
                }
            }
            else{
                for(j=count[i-1]+1;j<count[i];j++){
                    strings[i]+=str.charAt(j);
                }
            }
        }

        Set<String> temp = new HashSet<String>(Arrays.asList(strings));
        String[] uq = temp.toArray(new String[temp.size()]);
        return uq;
    }

    public String[] sortDate(String[] str) throws IOException, ParseException {
        Date date[];
        date=new Date[str.length];
        String[] new1=new String[2];
        SimpleDateFormat sobj=new SimpleDateFormat("dd/MM/yyyy");
        for (int i=0;i<str.length;i++){
            date[i]= sobj.parse(str[i]);
        }
        Arrays.sort(date);
        int i=0;

        for (Date date1:date){
            new1[i]=(sobj.format(date1)).toString();
            i++;
        }
        return new1;
    }
}
