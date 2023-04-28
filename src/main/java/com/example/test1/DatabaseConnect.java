package com.example.test1;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class DatabaseConnect {
    static Connection conn;
    public DatabaseConnect() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net/sql12613114", "sql12613114", "eCZsBjGQ8s");
        System.out.println("Database is connected !");
    }
    private static Object[][] getUserList(){
        List<Integer> PatientIDls=new ArrayList<>();
        List<String> UserNamels=new ArrayList<>();
        List<Integer> Agels=new ArrayList<>();
        List<String> Sexls=new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT Patient_id,Name,Age,Sex FROM patient");
            while (resultSet.next()) {
                PatientIDls.add(resultSet.getInt("Patient_id"));
                UserNamels.add(resultSet.getString("Name"));
                Agels.add(resultSet.getInt("Age"));
                Sexls.add(resultSet.getString("Sex"));
            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Object[] PatientID= PatientIDls.toArray();
        Object[] UserN=UserNamels.toArray();
        Object[] AgeArr=Agels.toArray();
        Object[] SexArr=Sexls.toArray();
        return new Object[][]{PatientID,UserN,AgeArr,SexArr};
    }
    static int[] getPatientID(){
        Object[][] Arr=getUserList();
//        Object[] Arr=ResultArr[4];
        Integer[] IDArr=Arrays.copyOf(Arr[0], Arr[0].length, Integer[].class);
        int[] ID = new int[IDArr.length];
        for (int i = 0; i < IDArr.length; i++) {
            ID[i] = IDArr[i].intValue();
        }
        return ID;
    }
    static String[] getPatientName(){
        Object[] Arr= getUserList()[1];
        String[] User=new String[Arr.length];
        for (int i = 0; i < Arr.length; i++) {
            User[i] = Arr[i].toString();
        }
        return User;
    }
    static int[] getPatientAge(){
        Object[][] Arr=getUserList();
//        Object[] Arr=ResultArr[4];
        Integer[] AgeArr=Arrays.copyOf(Arr[2], Arr[2].length, Integer[].class);
        int[] Age = new int[AgeArr.length];
        for (int i = 0; i < AgeArr.length; i++) {
            Age[i] = AgeArr[i].intValue();
        }
        return Age;
    }
    static String[] getPatientSex(){
        Object[] Arr= getUserList()[3];
        String[] User=new String[Arr.length];
        for (int i = 0; i < Arr.length; i++) {
            User[i] = Arr[i].toString();
        }
        return User;
    }

    static Object[][] getDataArr(int User, Date Fromdate, Date Todate) {
        List<Date> Datels = new ArrayList<>();
        List<Time> Timels = new ArrayList<>();
        List<Integer> HRls = new ArrayList<>();
        List<Integer> SpO2ls = new ArrayList<>();
        List<Integer> Templs = new ArrayList<>();
        try {
            // Use PreparedStatement to prevent SQL injection attacks
            String query = "SELECT * FROM HealthParameters WHERE Patient_id=? AND Date BETWEEN ? AND ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, User);
            statement.setDate(2, Fromdate);
            statement.setDate(3, Todate);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Datels.add(resultSet.getDate("Date"));
                Timels.add(resultSet.getTime("Date"));
                HRls.add(resultSet.getInt("HR"));
                SpO2ls.add(resultSet.getInt("SpO2"));
                Templs.add(resultSet.getInt("Temp"));
            }
        } catch (SQLException e) {
            System.out.println("not exist");
        }
        return new Object[][]{Datels.toArray(), Timels.toArray(), HRls.toArray(), SpO2ls.toArray(), Templs.toArray()};
    }

    static Date[] DateArr(Object[][] ResultArr){
        Object[] Arr=ResultArr[0];
        Date[] DateArr=Arrays.copyOf(Arr, Arr.length, Date[].class);
        return DateArr;
    }
    static Time[] TimeArr(Object[][] ResultArr){
        Object[] Arr=ResultArr[1];
        Time[] TimeArr=Arrays.copyOf(Arr, Arr.length, Time[].class);
        return TimeArr;
    }
    static int[] HRArr(Object[][] ResultArr){
        Object[] Arr=ResultArr[2];
        Integer[] HRArr=Arrays.copyOf(Arr, Arr.length, Integer[].class);
        int[] result = new int[HRArr.length];
        for (int i = 0; i < HRArr.length; i++) {
            result[i] = HRArr[i].intValue();
        }
        return result;
    }
    static int[] SpO2Arr(Object[][] ResultArr){
        Object[] Arr=ResultArr[3];
        Integer[] SpO2Arr=Arrays.copyOf(Arr, Arr.length, Integer[].class);
        int[] result = new int[SpO2Arr.length];
        for (int i = 0; i < SpO2Arr.length; i++) {
            result[i] = SpO2Arr[i].intValue();
        }
        return result;
    }
    static int[] TempArr(Object[][] ResultArr){
        Object[] Arr=ResultArr[4];
        Integer[] TempArr=Arrays.copyOf(Arr, Arr.length, Integer[].class);
        int[] result = new int[TempArr.length];
        for (int i = 0; i < TempArr.length; i++) {
            result[i] = TempArr[i].intValue();
        }
        return result;
    }

}
