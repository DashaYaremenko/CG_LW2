package com.example.cg_lw2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Screen secondScreen = Screen.getScreens().get(0);
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root, 1500, 800);
        primaryStage.setTitle("CG 2");
        Rectangle2D visualBounds = secondScreen.getVisualBounds();
        double centerX = visualBounds.getMinX() + (visualBounds.getWidth() - scene.getWidth()) / 2;
        double centerY = visualBounds.getMinY() + (visualBounds.getHeight() - scene.getHeight()) / 2;
        primaryStage.setX(centerX);
        primaryStage.setY(centerY);
        primaryStage.setWidth(scene.getWidth());
        primaryStage.setHeight(scene.getHeight());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}