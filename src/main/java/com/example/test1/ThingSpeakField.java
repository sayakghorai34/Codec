package com.example.test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class ThingSpeakField {
/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
METHODS>>>>>>>>>>>>>>METHODS>>>>>>>>>>>>>>>METHODS>>>>>>>>>>>>>>>>>>METHODS>>>>>>>>>>>>>>>>>METHODS>>>>>>>>>>>>>>>>>>>METHODS>>>>>>>>>>>>>>>>>>>>>>>>>>>METHODS>>>>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
    public int[][] main(int User) {
    String Url="https://api.thingspeak.com/channels/1826042/feeds.json?results=1000";
    String output= getUrlContents(Url);
    int[][] Data={getHR(output,User),getSpO2(output,User),getTemp(output,User)};
    return Data;
}

//GET USER Array
//=================================================================================================================================================================
    private static int[] UserArr(String Output){
        List<Integer> UserList = new ArrayList<Integer>();
        Output = Output.substring(Output.indexOf("[")+1,Output.indexOf("]"));
        String[] res=Output.split("[}{]");
        for(int i=1;i<res.length;i++) {
            if(res[i].equals(",")) {
                continue;
            }
            else {
                try {
                    UserList.add(Integer.parseInt(res[i].substring(res[i].indexOf("field1\":")+9,res[i].indexOf("field2\":")-3)));
                } catch (NumberFormatException e) {}
            }
        }
        int[] User = new int[UserList.size()];
        for(int i = 0; i < User.length; i++)
            User[i] = UserList.get(i);
        return User;
    }
//=================================================================================================================================================================

//GET TEMPERATURE Array
//=================================================================================================================================================================
    private static int[] TempArr(String Output){
        List<Integer> TempList = new ArrayList<Integer>();
        Output = Output.substring(Output.indexOf("[")+1,Output.indexOf("]"));
        String[] res=Output.split("[}{]");
        for(int i=1;i<res.length;i++) {
            if(res[i].equals(",")) {
                continue;
            }
            else {
                try {
                    TempList.add(Integer.parseInt(res[i].substring(res[i].indexOf("field2\":")+9,res[i].indexOf("field3\":")-3)));
                } catch (NumberFormatException e) {}
            }
        }
        int[] Temp = new int[TempList.size()];
        for(int i = 0; i < Temp.length; i++)
            Temp[i] = TempList.get(i);
        return Temp;
    }
    //=================================================================================================================================================================
//GET HeartRate Array
//=================================================================================================================================================================
    private static int[] HRArr(String Output){
        List<Integer> HRList = new ArrayList<Integer>();
        Output = Output.substring(Output.indexOf("[")+1,Output.indexOf("]"));
        String[] res=Output.split("[}{]");
        for(int i=1;i<res.length;i++) {
            if(res[i].equals(",")) {
                continue;
            }
            else {
                try {
                    HRList.add(Integer.parseInt(res[i].substring(res[i].indexOf("field3\":")+9,res[i].indexOf("field4\":")-3)));
                } catch (NumberFormatException e) {}
            }
        }
        int[] HR = new int[HRList.size()];
        for(int i = 0; i < HR.length; i++)
            HR[i] = HRList.get(i);
        return HR;
    }
//=================================================================================================================================================================

//GET SpO2
//=================================================================================================================================================================
    private static int[] SpO2Arr(String Output){
        List<Integer>SpO2List = new ArrayList<Integer>();
        Output = Output.substring(Output.indexOf("[")+1,Output.indexOf("]"));
        String[] res=Output.split("[}{]");
        for(int i=1;i<res.length;i++) {
            if(res[i].equals(",")) {
                continue;
            }
            else {
                try {
                    SpO2List.add(Integer.parseInt(res[i].substring(res[i].indexOf("field4\":")+9,res[i].length()-1)));
                } catch (NumberFormatException e) {}
            }
        }
        int[] SpO2 = new int[SpO2List.size()];
        for(int i = 0; i < SpO2.length; i++)
            SpO2[i] = SpO2List.get(i);
        return SpO2;
    }
//=================================================================================================================================================================


//################################################################################################################################################################
    private  static int[] getIndex(String Output,int User){
        List<Integer>IndexList = new ArrayList<Integer>();
        int[] UserArr=UserArr(Output);
        for(int i=0;i<UserArr.length;i++){
            if(UserArr[i]==User){
                IndexList.add(i);
            }
        }
        int[] Index = new int[IndexList.size()];
        for(int i = 0; i < Index.length; i++)
            Index[i] = IndexList.get(i);
        return Index;
}
//===============================UserSpecific HR ==============================================================================================================
    private static int[] getHR(String Output,int User){
        int[] getHR = HRArr(Output);
        int[] Index=getIndex(Output,User);
        int[] HR=new int[Index.length];
        for(int i=0;i<Index.length;i++){
            HR[i]=getHR[Index[i]];
        }
        return HR;
}
//==============================================================================================================================================================


//===============================UserSpecific SpO2 ==============================================================================================================
    private static int[] getSpO2(String Output,int User){
        int[] getSpO2 = SpO2Arr(Output);
        int[] Index=getIndex(Output,User);
        int[] SpO2=new int[Index.length];
        for(int i=0;i<Index.length;i++){
            SpO2[i]=getSpO2[Index[i]];
        }
        return SpO2;
    }
//==============================================================================================================================================================

//===============================UserSpecific Temp ==============================================================================================================
    private static int[] getTemp(String Output,int User){
        int[] getTemp = TempArr(Output);
        int[] Index=getIndex(Output,User);
        int[] Temp=new int[Index.length];
        for(int i=0;i<Index.length;i++){
            Temp[i]=getTemp[Index[i]];
        }
        return Temp;
    }
//==============================================================================================================================================================


    private static String getUrlContents(String theUrl){
        StringBuilder content = new StringBuilder();
        try
        {
            URL url = new URL(theUrl); // creating a url object
            URLConnection urlConnection = url.openConnection(); // creating a urlconnection object

            // wrapping the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            // reading from the urlconnection using the bufferedreader
            while ((line = bufferedReader.readLine()) != null)
            {
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return content.toString();
    }


}
