package com.example.test1;
//Import Modules
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.net.URL;
import java.time.ZoneId;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.ResourceBundle;

public class secondController implements Initializable{
    int PatientID;
    int PatientAge;
    String PatientSex;
    Date From_Date;
    Date To_Date;
//    ThingSpeakField t = new ThingSpeakField();
    DatabaseConnect dbc=new DatabaseConnect();
//Declare Variables~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    URL u;
    ResourceBundle r;
    @FXML
    private LineChart<Number, Number> HRChart;
    @FXML
    private LineChart<Number, Number> SpO2Chart;
    @FXML
    private LineChart<Number, Number> TempChart;
    @FXML
    private Label HRLabel;
    @FXML
    private Label SpO2Label;
    @FXML
    private Label TempLabel;
    @FXML
    private Label AgeLabel;
    @FXML
    private  Label SexLabel;
    @FXML
    private DatePicker Fromdatepicker;
    @FXML
    private DatePicker Todatepicker;
    Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);

                        // Disable dates before today
                        if (item.isBefore(LocalDate.now())) {
                            setDisable(false);
                        }
                        // Disable dates after one year from today
                        if (item.isAfter(LocalDate.now())) {
                            setDisable(true);
                        }
                    }
                };
            }
        };
    public secondController() throws Exception {
    }

    //Method declaration Starts»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»
    public void ChoiceInput(Scene scene) {
        int[] ID= DatabaseConnect.getPatientID();
        String[] Name= DatabaseConnect.getPatientName();
        int[] Age=DatabaseConnect.getPatientAge();
        String[] Sex=DatabaseConnect.getPatientSex();
        MenuButton dynamicMenuButton = (MenuButton) scene.lookup("#dynamicMenuButton");
        for(int i=0;i<ID.length;i++) {
            MenuItem menuI = new MenuItem(Name[i]);
            final int finalID = ID[i];
            final int finalage=Age[i];
            final String finalSex=Sex[i];
            final String finalName=Name[i];
            menuI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    PatientID=finalID;
                    PatientSex=finalSex;
                    PatientAge=finalage;
                    dynamicMenuButton.setText(finalName);
                }
            });
            dynamicMenuButton.getItems().add(menuI);
        }

        // Set the default value of the DatePicker
        Todatepicker.setDayCellFactory(dayCellFactory);
        Fromdatepicker.setDayCellFactory(dayCellFactory);
        Fromdatepicker.setValue(LocalDate.now());
        Fromdatepicker.setOnAction(event -> {
            LocalDate selectedDate = Fromdatepicker.getValue();
//            Date sqlDate = Date.valueOf(localDate);
            From_Date =  Date.valueOf(selectedDate);
        });

        Todatepicker.setValue(LocalDate.now());
        Todatepicker.setOnAction(event -> {
            LocalDate selectedDate = Todatepicker.getValue();
//            To_Date = Date.from(selectedDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            To_Date=Date.valueOf(selectedDate);
        });
    }
    @FXML
    public void SeeDetailsAct(ActionEvent n){
        Object[][] ResultArr= DatabaseConnect.getDataArr(PatientID, (java.sql.Date) From_Date, (java.sql.Date) To_Date);
        int[] HRArr=DatabaseConnect.HRArr(ResultArr);
        int[] SpO2Arr=DatabaseConnect.SpO2Arr(ResultArr);
        int[] TempArr=DatabaseConnect.TempArr(ResultArr);
        LabelUpdate(HRArr,SpO2Arr,TempArr,PatientAge,PatientSex);
        initialize1(u,r,HRArr,SpO2Arr,TempArr);
        System.out.println(Arrays.toString(HRArr)+Arrays.toString(SpO2Arr)+Arrays.toString(TempArr));

    }

//    @FXML
//    public void u10act(ActionEvent n){
//        try{
//            int[] HR = t.main(10)[0];
//            int[] SpO2 = t.main(10)[1];
//            int[] Temp = t.main(10)[2];
//            // System.out.println(Arrays.toString(HR) +"||"+ Arrays.toString(SpO2) +"||"+ Arrays.toString(Temp));
//            LabelUpdate(HR, SpO2, Temp);
//            initialize1(u, r, HR, SpO2, Temp);
//        }
//        catch(Exception exp){
//            System.out.println("USer Not Available");
//        }
//
//    }

    @FXML
    public void ChatAct(ActionEvent n) throws Exception {
        OpenBrowser.main();
    }


//Graph Functions »»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»
    @Override
    public void initialize(URL url, ResourceBundle rb){
        u=url;
        r=rb;
    }   //to fool the system

    public void initialize1(URL url,ResourceBundle rb,int[] HR,int[] SpO2, int[] Temp){
        initialize(u,r);
        clearGraph();
        drawGraph(HR,SpO2,Temp);


    }   //Actual Use

    public void drawGraph(int[] HR, int[] SpO2, int... Temp){
        HRChart.getYAxis().setAutoRanging(true);
        SpO2Chart.getYAxis().setAutoRanging(true);
        TempChart.getYAxis().setAutoRanging(true);

        //Draw HR Chart»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»
        int i=1;
        XYChart.Series series1=new XYChart.Series();
        for(int ele:HR) {
            series1.getData().add(new XYChart.Data(Integer.toString(i), ele));
            i++;
        }
        HRChart.getData().addAll(series1);
        //Draw SpO2 Chart»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»
        int j=1;
        XYChart.Series series2=new XYChart.Series();
        for(int ele:SpO2) {
            series2.getData().add(new XYChart.Data(Integer.toString(j), ele));
            j++;
        }
        SpO2Chart.getData().addAll(series2);
        //Draw Temperature Chart»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»
        int k=1;
        XYChart.Series series3=new XYChart.Series();
        for(int ele:Temp) {
            series3.getData().add(new XYChart.Data(Integer.toString(k), ele));
            k++;
        }
        TempChart.getData().addAll(series3);
    }
    public void clearGraph(){
        HRChart.getData().clear();
        SpO2Chart.getData().clear();
        TempChart.getData().clear();
    }

//Show The Latest Data of User In Window»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»
    public void LabelUpdate(int[] HR, int[] SpO2, int[] Temp,int Age,String Sex){

        try{
            HRLabel.setText(Integer.toString(HR[HR.length - 1]));
            SpO2Label.setText(Integer.toString(SpO2[SpO2.length - 1]));
            TempLabel.setText(Integer.toString(Temp[Temp.length - 1]));
            AgeLabel.setText(Integer.toString(Age));
            SexLabel.setText(Sex);
        }catch(Exception e){
            HRLabel.setText("-  -");
            SpO2Label.setText("-  -");
            TempLabel.setText("-  -");}
    }

//Open Browser Code»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»

}