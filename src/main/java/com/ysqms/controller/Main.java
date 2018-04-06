package com.ysqms.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("/yoghurtSample.fxml"));

            Scene scene = new Scene(root, 1292, 950);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (NullPointerException ex){
            System.out.println("Haiskubatika");
        }

    }
}
