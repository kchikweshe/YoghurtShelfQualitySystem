package com.ysqms.controller; /**
 * Skeleton for 'sample.fxml' Controller Class
 */

import com.ysqms.model.YoghurtSample;
import com.ysqms.service.YoghurtSampleBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;

public class Controller {
    DecimalFormat df = new DecimalFormat("#.##");
    @FXML
    private Pane detailPane;
    @FXML
    private TextField Temperature;
    @FXML
    private TextField CriticalTemperature;
    @FXML
    private TextField pH;
    @FXML
    private TextField bostwickConsistency;
    @FXML
    private TextField TotalSolids;
    @FXML
    private TextField ShelfTime;

    @FXML
    private TextField correctedPH;
    @FXML
    private Pane pane;
    @FXML
    private Label PhPercent;

    @FXML
    private Label ffiPercent;

    @FXML
    private Label labbqPercent;

    @FXML
    private Label sqrgv;

    @FXML
    private    Label sql;
    @FXML
    private ComboBox<?> xComboBox;

    @FXML
    private ComboBox<?> yComboBox;

    @FXML
    private    Label sqrcv;

    @FXML
    void resetEverything(ActionEvent event) {
        /*
        In this method, we clear all text-boxes to reset everything.
        * */
        correctedPH.setText("");
        CriticalTemperature.setText("");
        Temperature.setText("");
        TotalSolids.setText("");
        ShelfTime.setText("");
         sql.setText("");
         sqrcv.setText("");
         sqrgv.setText("");
         labbqPercent.setText("");
        pH.setText("");
         PhPercent.setText("");
        bostwickConsistency.setText("");

    }


    @FXML
    void calculate(ActionEvent event) {
        double temperature = Double.parseDouble(Temperature.getText());
        float Bostwick_Value = Float.parseFloat(bostwickConsistency.getText());
        double totalSolids = Double.parseDouble(TotalSolids.getText());
        double ph = Double.parseDouble(pH.getText());
        int shelfTime = Integer.parseInt(ShelfTime.getText());
        double criticalTemperature = Double.parseDouble(CriticalTemperature.getText());
        double phPercent;
        double LABBQ_Percent;
        double FFI_Percent;
        double SQRGV;
        double SQRCV;
        double SQL;


        // Outputs

        float FFi = (float) (totalSolids / (temperature * Bostwick_Value));
        double phC = ph + 0.0073692 * (temperature - criticalTemperature);
        correctedPH.setText(String.valueOf(df.format(phC)));
        double LABBQ = (-42.16 - 0.4256 * shelfTime + 27.15 * (phC) + 0.08122 * (shelfTime * phC) - 3.586 * (pow(phC, 2)));
        phPercent = 100 - (10 * (4.50 - phC) * 100) / 7;
         PhPercent.setText(String.valueOf(df.format(phPercent)));

        LABBQ_Percent = ((50 * LABBQ) - 150) / 3;
         labbqPercent.setText(String.valueOf(df.format(LABBQ_Percent)));

        double formula1 = (totalSolids / (Bostwick_Value * (pow(temperature, 2))) / (totalSolids / (Bostwick_Value * temperature)));
        double constant;
        if (totalSolids <= 17) {
            constant = 0.0170863893;
            FFI_Percent = 100 * pow(formula1, (temperature * constant));
             ffiPercent.setText(String.valueOf(df.format(FFI_Percent)));
            SQRGV = (phPercent + LABBQ_Percent + FFI_Percent) / 3;
            sqrgv.setText(String.valueOf(df.format(SQRGV)));
            SQRCV = (phPercent + LABBQ_Percent + FFI_Percent - 150) / 3;
            sqrcv.setText(String.valueOf(df.format(SQRCV)));
            SQL = 100 - (phPercent + LABBQ_Percent + FFI_Percent) / 3;
            sql.setText(String.valueOf(df.format(SQL)));

            YoghurtSample yoghurtSample = new YoghurtSample();
            yoghurtSample.setTotalSolids(totalSolids);
            yoghurtSample.setPh(phPercent);
            yoghurtSample.setCriticalTemperature(criticalTemperature);
            yoghurtSample.setBostwick_Value(Bostwick_Value);
            yoghurtSample.setPh(ph);
            yoghurtSample.setTemperature(temperature);
            yoghurtSample.setFfiPercent(FFI_Percent);
            yoghurtSample.setLabbqPercent(LABBQ_Percent);
            yoghurtSample.setPhPercent(phPercent);
            yoghurtSample.setShelfTime(shelfTime);
            yoghurtSample.setSqrcv(SQRCV);
            yoghurtSample.setSqrgv(SQRGV);
            yoghurtSample.setShelfQualityLoss(SQL);




        } else if (totalSolids > 17) {
            constant = 0.008545437;
            FFI_Percent = 100 * pow(formula1, (temperature * constant));
            ffiPercent.setText(String.valueOf(df.format(FFI_Percent)));

            SQRGV = (phPercent + LABBQ_Percent + FFI_Percent) / 3;
            sqrgv.setText(String.valueOf(df.format(SQRGV)));
            SQRCV = (phPercent + LABBQ_Percent + FFI_Percent - 150) / 3;
            sqrcv.setText(String.valueOf(df.format(SQRCV)));
            SQL = 100 - (phPercent + LABBQ_Percent + FFI_Percent) / 3;
            sql.setText(String.valueOf(df.format(SQL)));

            YoghurtSample yoghurtSample = new YoghurtSample();
            yoghurtSample.setTotalSolids(totalSolids);
            yoghurtSample.setPh(phPercent);
            yoghurtSample.setCriticalTemperature(criticalTemperature);
            yoghurtSample.setBostwick_Value(Bostwick_Value);
            yoghurtSample.setPh(ph);
            yoghurtSample.setTemperature(temperature);
            yoghurtSample.setFfiPercent(FFI_Percent);
            yoghurtSample.setLabbqPercent(LABBQ_Percent);
            yoghurtSample.setPhPercent(phPercent);
            yoghurtSample.setShelfTime(shelfTime);
            yoghurtSample.setSqrcv(SQRCV);
            yoghurtSample.setSqrgv(SQRGV);
            yoghurtSample.setShelfQualityLoss(SQL);

            YoghurtSampleBean a =new YoghurtSampleBean();

            a.create(yoghurtSample);

            List<YoghurtSample> yoghurtSampleList = new ArrayList<>();
            yoghurtSampleList.add(yoghurtSample);

            final ComboBox comboBox = new ComboBox((ObservableList) yoghurtSampleList);

        }





    }


}
