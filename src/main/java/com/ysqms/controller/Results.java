package com.ysqms.controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class Results extends Application{


    @FXML
    Button btnPlot;

    @FXML
    static  LineChart<Integer, Double> lineChart;
    @FXML
    static  Label PhPercent;

    @FXML
    static  Label ffiPercent;

    @FXML
    static  Label labbqPercent;

    @FXML
    static   Label sqrgv;

    @FXML
    static   Label sql;

    @FXML
    static   Label sqrcv;


    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     * <p>
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set. The primary stage will be embedded in
     *                     the browser if the application was launched as an applet.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages and will not be embedded in the browser.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../../resources/LineChart.fxml"));
        Scene scene = new Scene(root, 2000, 1010);
        primaryStage.setScene(scene);

        primaryStage.show();

        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Shelf Time");
        final LineChart<Number, Number> lineChart = new LineChart<>(
                xAxis, yAxis);

        lineChart.setTitle("YSQMS");
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("My Data");
        // populating the series with data
        series.getData().add(new XYChart.Data<>(1, 23));
        series.getData().add(new XYChart.Data<>(2, 114));
        series.getData().add(new XYChart.Data<>(3, 15));
        series.getData().add(new XYChart.Data<>(4, 124));


    }

    public static void main(String[] args) {
        launch(args);
    }
    static void setData(String mySQL, String mySQRCV, String mySQRGV, double phPercent, double labbq_percent, double ffi_percent, int shelfTime, double SQL) {
        DecimalFormat df = new DecimalFormat("#.##");
        PhPercent.setText(String.valueOf(df.format(phPercent)));
        labbqPercent.setText(String.valueOf(df.format(labbq_percent)));
        ffiPercent.setText(String.valueOf(df.format(ffi_percent)));
        sql.setText(String.valueOf(df.format(mySQL)));
        sqrcv.setText(String.valueOf(String.valueOf(df.format(mySQRCV))));
        sqrgv.setText(String.valueOf(String.valueOf(df.format(mySQRGV))));



    }

    static void plotWith(int shelfTime, double sql) {
        XYChart.Series series = new XYChart.Series();

        series.getData().add(new XYChart.Data(shelfTime, sql));
        lineChart.getData().addAll(series);
    }
}



