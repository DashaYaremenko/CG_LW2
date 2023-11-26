package com.example.cg_lw2;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

import java.util.Arrays;

public class HelloController {
    @FXML
    private void initialize() {
        initD();
        initY();
        initA();

        init0();
        init4();
        init0_1();
        init9();
        init2_1();
        init0_2();
        init0_3();
        init3();
    }

    double minX = 0; double minY = 0; double maxX = 1500; double maxY = 570;
    // D
    private int xSpinPointD; private int ySpinPointD; @FXML private Circle pointSpinD;
    @FXML private Slider widthSliderD, spinPointSliderD, xPointD, yPointD;
    @FXML private ColorPicker fillColorD, lineColorD, spinColorD;
    @FXML private Pane canvasD; private double[][] pointsD;
    private void initD() {
        pointSpinD.setOnMouseDragged(this::DraggedPointD);
        xSpinPointD = (int) pointSpinD.getCenterX();
        ySpinPointD = (int) pointSpinD.getCenterY();
        xPointD.valueProperty().addListener((observable, oldValue, newValue) -> redrawD());
        yPointD.valueProperty().addListener((observable, oldValue, newValue) -> redrawD());
        spinPointSliderD.valueProperty().addListener((observable, oldValue, newValue) -> redrawD());
        fillColorD.setValue(Color.rgb(16, 13, 93));
        lineColorD.setValue(Color.YELLOW);
        spinColorD.setValue(Color.RED);
        changeColor(canvasD, lineColorD, spinColorD, fillColorD, pointSpinD);
        fillColorD.setOnAction(event -> changeColor(canvasD, lineColorD, spinColorD, fillColorD, pointSpinD));
        lineColorD.setOnAction(event -> changeColor(canvasD, lineColorD, spinColorD, fillColorD, pointSpinD));
        spinColorD.setOnAction(event -> changeColor(canvasD, lineColorD, spinColorD, fillColorD, pointSpinD));
        widthSliderD.valueProperty().addListener((observable, oldValue, newValue) -> redrawD());
        redrawD();
    }
    private void redrawD() {
        canvasD.getChildren().clear();
        int wD = (int) widthSliderD.getValue(); int xD = (int) (wD / 15.0); int yD = (int) (wD / 15.0); int wL = 2;
        double mainPointY = yPointD.getValue(); double mainPointX = xPointD.getValue();
        double initialX = (mainPointY / xD); double initialY = (mainPointX / yD);
        int angle = (int) spinPointSliderD.getValue(); double angleRadians = Math.toRadians(angle); double cosAngle = Math.cos(angleRadians); double sinAngle = Math.sin(angleRadians);
        double[][] tempPoints = new double[][]{
                {initialY * yD, initialX * xD},
                {(initialY + 7) * yD, (initialX + 0) * xD},
                {(initialY + 9) * yD, (initialX + 3) * xD},
                {(initialY + 9) * yD, (initialX + 7) * xD},
                {(initialY + 7) * yD, (initialX + 10) * xD},
                {(initialY + 0) * yD, (initialX + 10) * xD},
                {(initialY + 0) * yD, (initialX + 0) * xD},
                {(initialY + 2) * yD, (initialX + 0) * xD},
                {(initialY + 2) * yD, (initialX + 9) * xD},
                {(initialY + 6) * yD, (initialX + 9) * xD},
                {(initialY + 8) * yD, (initialX + 7) * xD},
                {(initialY + 8) * yD, (initialX + 3) * xD},
                {(initialY + 7) * yD, (initialX + 1) * xD},
                {(initialY + 2) * yD, (initialX + 1) * xD},
//


                {initialY * yD, initialX * xD}
        };
        boolean pointsWithinBounds = Arrays.stream(tempPoints).noneMatch(point -> point[0] < minX || point[0] > maxX || point[1] < minY || point[1] > maxY);
        if (pointsWithinBounds) pointsD = rotate(pointsD, tempPoints, cosAngle, sinAngle, xSpinPointD, ySpinPointD);
        for (int i = 1; i < pointsD.length; i++) {
            double[] currentPoint = pointsD[i - 1];
            double[] nextPoint = pointsD[i];
            drawPoint(currentPoint[0], currentPoint[1], nextPoint[0], nextPoint[1], wL, lineColorD.getValue(), canvasD);
        }
        fillShape(fillColorD, canvasD, pointsD);
    }

    // Y
    private double[][] pointsY; @FXML private Pane canvasY;
    private void initY() {
        xPointD.valueProperty().addListener((observable, oldValue, newValue) -> redrawY());
        yPointD.valueProperty().addListener((observable, oldValue, newValue) -> redrawY());
        spinPointSliderD.valueProperty().addListener((observable, oldValue, newValue) -> redrawY());
        changeColor(canvasY, lineColorD, spinColorD, fillColorD, pointSpinD);
        fillColorD.setOnAction(event -> changeColor(canvasY, lineColorD, spinColorD, fillColorD, pointSpinD));
        lineColorD.setOnAction(event -> changeColor(canvasY, lineColorD, spinColorD, fillColorD, pointSpinD));
        spinColorD.setOnAction(event -> changeColor(canvasY, lineColorD, spinColorD, fillColorD, pointSpinD));
        widthSliderD.valueProperty().addListener((observable, oldValue, newValue) -> redrawY());
        redrawY();
    }
    private void redrawY() {
        canvasY.getChildren().clear();
        int wY = (int) widthSliderD.getValue(); int xY = (int) (wY / 15.0); int yY = (int) (wY / 15.0); int wL = 2;
        double mainPointY = yPointD.getValue(); double mainPointX = xPointD.getValue();
        double initialX = (mainPointY / xY); double initialY = (mainPointX / yY) + 10;
        int angle = (int) spinPointSliderD.getValue(); double angleRadians = Math.toRadians(angle); double cosAngle = Math.cos(angleRadians); double sinAngle = Math.sin(angleRadians);
        double[][] tempPoints = new double[][]{
                {initialY * yY, initialX * xY},
                {(initialY + 0) * yY, (initialX + 0) * xY},
                {(initialY + 3) * yY, (initialX + 5) * xY},
                {(initialY + 3) * yY, (initialX + 10) * xY},
                {(initialY + 5) * yY, (initialX + 10) * xY},
                {(initialY + 5) * yY, (initialX + 5) * xY},
                {(initialY + 8) * yY, (initialX + 0) * xY},
                {(initialY + 6) * yY, (initialX + 0) * xY},
                {(initialY + 4) * yY, (initialX + 3) * xY},
                {(initialY + 2) * yY, (initialX + 0) * xY},
                {initialY * yY, initialX * xY}
        };

        boolean pointsWithinBounds = Arrays.stream(tempPoints).noneMatch(point -> point[0] < minX || point[0] > maxX || point[1] < minY || point[1] > maxY);
        if (pointsWithinBounds) pointsY = rotate(pointsY, tempPoints, cosAngle, sinAngle, xSpinPointD, ySpinPointD);
        for (int i = 1; i < pointsY.length; i++) {
            double[] currentPoint = pointsY[i - 1];
            double[] nextPoint = pointsY[i];
            drawPoint(currentPoint[0], currentPoint[1], nextPoint[0], nextPoint[1], wL, lineColorD.getValue(), canvasY);
        }
        fillShape(fillColorD, canvasY, pointsY);
    }

    //    // A
    private double[][] pointsA; @FXML private Pane canvasA;
    private void initA() {
        xPointD.valueProperty().addListener((observable, oldValue, newValue) -> redrawA());
        yPointD.valueProperty().addListener((observable, oldValue, newValue) -> redrawA());
        spinPointSliderD.valueProperty().addListener((observable, oldValue, newValue) -> redrawA());
        changeColor(canvasA, lineColorD, spinColorD, fillColorD, pointSpinD);
        fillColorD.setOnAction(event -> changeColor(canvasA, lineColorD, spinColorD, fillColorD, pointSpinD));
        lineColorD.setOnAction(event -> changeColor(canvasA, lineColorD, spinColorD, fillColorD, pointSpinD));
        spinColorD.setOnAction(event -> changeColor(canvasA, lineColorD, spinColorD, fillColorD, pointSpinD));
        widthSliderD.valueProperty().addListener((observable, oldValue, newValue) -> redrawA());
        redrawA();
    }
    private void redrawA() {
        canvasA.getChildren().clear();
        int wA = (int) widthSliderD.getValue(); int xA = (int) (wA / 15.0); int yA = (int) (wA / 15.0); int wL = 2;
        double mainPointY = yPointD.getValue(); double mainPointX = xPointD.getValue();
        double initialX = (mainPointY / xA); double initialY = (mainPointX / yA) + 20;
        int angle = (int) spinPointSliderD.getValue(); double angleRadians = Math.toRadians(angle); double cosAngle = Math.cos(angleRadians); double sinAngle = Math.sin(angleRadians);
        double[][] tempPoints = new double[][]{
                {(initialY ) * yA, (initialX ) * xA},
                {(initialY + 0) * yA, (initialX + 10) * xA},
                {(initialY + 2) * yA, (initialX + 10) * xA},
                {(initialY + 3) * yA, (initialX + 7) * xA},
                {(initialY + 5) * yA, (initialX + 7) * xA},
                {(initialY + 6) * yA, (initialX + 10) * xA},
                {(initialY + 8) * yA, (initialX + 10) * xA},
                {(initialY + 5) * yA, (initialX + 0) * xA},
                {(initialY + 3) * yA, (initialX + 0) * xA},
                {(initialY + 0) * yA, (initialX + 10) * xA},
                {(initialY + 0) * yA, (initialX + 0) * xA},
                {(initialY + 2) * yA, (initialX + 0) * xA},
                {(initialY + 5) * yA, (initialX + 6) * xA},
                {(initialY + 3) * yA, (initialX + 6) * xA},
                {(initialY + 4) * yA, (initialX + 2) * xA},
                {(initialY + 2) * yA, (initialX + 0) * xA},
                {initialY * yA, initialX * xA}
        };
        boolean pointsWithinBounds = Arrays.stream(tempPoints).noneMatch(point -> point[0] < minX || point[0] > maxX || point[1] < minY || point[1] > maxY);
        if (pointsWithinBounds) pointsA = rotate(pointsA, tempPoints, cosAngle, sinAngle, xSpinPointD, ySpinPointD);
        for (int i = 1; i < pointsA.length; i++) {
            double[] currentPoint = pointsA[i - 1];
            double[] nextPoint = pointsA[i];
            drawPoint(currentPoint[0], currentPoint[1], nextPoint[0], nextPoint[1], wL, lineColorD.getValue(), canvasA);
        }
        fillShape(fillColorD, canvasA, pointsA);
    }


    // 0
    private int xSpinPoint0; private int ySpinPoint0;  @FXML private Circle pointSpin0;
    @FXML private Slider widthSlider0, spinPointSlider0, xPoint0, yPoint0;
    @FXML private ColorPicker fillColorPicker0, lineColorPicker0, spinColorPicker0;
    @FXML private Pane canvas0;   private double[][] points0;
    private void init0() {
        pointSpin0.setOnMouseDragged(this::DraggedPoint0);
        xSpinPoint0 = (int) pointSpin0.getCenterX();
        ySpinPoint0 = (int) pointSpin0.getCenterY();
        xPoint0.valueProperty().addListener((observable, oldValue, newValue) -> redraw0());
        yPoint0.valueProperty().addListener((observable, oldValue, newValue) -> redraw0());
        spinPointSlider0.valueProperty().addListener((observable, oldValue, newValue) -> redraw0());
        fillColorPicker0.setValue(Color.rgb(225, 0, 0));
        lineColorPicker0.setValue(Color.BLACK);
        spinColorPicker0.setValue(Color.GREEN);
        changeColor(canvas0, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0);
        fillColorPicker0.setOnAction(event -> changeColor(canvas0, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0));
        lineColorPicker0.setOnAction(event -> changeColor(canvas0, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0));
        spinColorPicker0.setOnAction(event -> changeColor(canvas0, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0));
        widthSlider0.valueProperty().addListener((observable, oldValue, newValue) -> redraw0());
        redraw0();
    }
    private void redraw0() {
        canvas0.getChildren().clear();
        int wK = (int) widthSlider0.getValue(); int xK = (int) (wK / 15.0); int yK = (int) (wK / 15.0); int wL = 2;
        double mainPointY = yPoint0.getValue(); double mainPointX = xPoint0.getValue() + 800;
        double initialX = (mainPointY / xK); double initialY = (mainPointX / yK);
        int angle = (int) spinPointSlider0.getValue(); double angleRadians = Math.toRadians(angle); double cosAngle = Math.cos(angleRadians); double sinAngle = Math.sin(angleRadians);
        double[][] tempPoints = new double[][]{
                {(initialY + 2) * yK, (initialX + 3) * xK},
                {(initialY + 2) * yK, (initialX + 0) * xK},
                {(initialY + 0) * yK, (initialX + 2) * xK},
                {(initialY + 0) * yK, (initialX + 8) * xK},
                {(initialY + 2) * yK, (initialX + 10)* xK},
                {(initialY + 5) * yK, (initialX + 10)* xK},
                {(initialY + 7) * yK, (initialX + 8) * xK},
                {(initialY + 7) * yK, (initialX + 2) * xK},
                {(initialY + 5) * yK, (initialX + 0) * xK},
                {(initialY + 2) * yK, (initialX + 0) * xK},
                {(initialY + 2) * yK, (initialX + 3) * xK},
                {(initialY + 3) * yK, (initialX + 2) * xK},
                {(initialY + 4) * yK, (initialX + 2) * xK},
                {(initialY + 5) * yK, (initialX + 3) * xK},
                {(initialY + 5) * yK, (initialX + 7) * xK},
                {(initialY + 4) * yK, (initialX + 8) * xK},
                {(initialY + 3) * yK, (initialX + 8) * xK},
                {(initialY + 2) * yK, (initialX + 7) * xK},
                {(initialY + 2) * yK, (initialX + 3) * xK},
        };
        boolean pointsWithinBounds = Arrays.stream(tempPoints).noneMatch(point -> point[0] < minX || point[0] > maxX || point[1] < minY || point[1] > maxY);
        if (pointsWithinBounds) points0 = rotate(points0, tempPoints, cosAngle, sinAngle, xSpinPoint0, ySpinPoint0);
        for (int i = 1; i < points0.length; i++) {
            double[] currentPoint = points0[i - 1];
            double[] nextPoint = points0[i];
            drawPoint(currentPoint[0], currentPoint[1], nextPoint[0], nextPoint[1], wL, lineColorPicker0.getValue(), canvas0);
        }
        fillShape(fillColorPicker0, canvas0, points0);
    }
    //4
    private double[][] points4; @FXML private Pane canvas4;
    private void init4() {
        xPoint0.valueProperty().addListener((observable, oldValue, newValue) -> redraw4());
        yPoint0.valueProperty().addListener((observable, oldValue, newValue) -> redraw4());
        spinPointSlider0.valueProperty().addListener((observable, oldValue, newValue) -> redraw4());
        changeColor(canvas4, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0);
        fillColorPicker0.setOnAction(event -> changeColor(canvas4, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0));
        lineColorPicker0.setOnAction(event -> changeColor(canvas4, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0));
        spinColorPicker0.setOnAction(event -> changeColor(canvas4, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0));
        widthSlider0.valueProperty().addListener((observable, oldValue, newValue) -> redraw4());
        redraw4();
    }
    private void redraw4() {
        canvas4.getChildren().clear();
        int w4 = (int) widthSlider0.getValue(); int x4 = (int) (w4 / 15.0); int y4 = (int) (w4 / 15.0); int wL = 2;
        double mainPointY = yPoint0.getValue(); double mainPointX = xPoint0.getValue() + 800;
        double initialX = (mainPointY / x4); double initialY = (mainPointX / y4) + 10;
        int angle = (int) spinPointSlider0.getValue(); double angleRadians = Math.toRadians(angle); double cosAngle = Math.cos(angleRadians); double sinAngle = Math.sin(angleRadians);
        double[][] tempPoints = new double[][]{
                {(initialY + 0) * y4, (initialX + 0) * x4},
                {(initialY + 0) * y4, (initialX + 6) * x4},
                {(initialY + 4) * y4, (initialX + 6) * x4},
                {(initialY + 4) * y4, (initialX + 10) * x4},
                {(initialY + 6) * y4, (initialX + 10) * x4},
                {(initialY + 6) * y4, (initialX + 0) * x4},
                {(initialY + 4) * y4, (initialX + 0) * x4},
                {(initialY + 4) * y4, (initialX + 4) * x4},
                {(initialY + 2) * y4, (initialX + 4) * x4},
                {(initialY + 2) * y4, (initialX + 0) * x4},
                {(initialY + 0) * y4, (initialX + 0) * x4},
        };
        boolean pointsWithinBounds = Arrays.stream(tempPoints).noneMatch(point -> point[0] < minX || point[0] > maxX || point[1] < minY || point[1] > maxY);
        if (pointsWithinBounds) points4 = rotate(points4, tempPoints, cosAngle, sinAngle, xSpinPoint0, ySpinPoint0);
        for (int i = 1; i < points4.length; i++) {
            double[] currentPoint = points4[i - 1];
            double[] nextPoint = points4[i];
            drawPoint(currentPoint[0], currentPoint[1], nextPoint[0], nextPoint[1], wL, lineColorPicker0.getValue(), canvas4);
        }
        fillShape(fillColorPicker0, canvas4, points4);
        Circle circle = new Circle();
        circle.setCenterX(points4[3][0]+w4/4);
        circle.setCenterY(points4[3][1]);
        circle.setRadius(w4/20);
        circle.setFill(Color.RED);
        canvas4.getChildren().add(circle);
    }
    //0_1
    private double[][] points0_1; @FXML private Pane canvas0_1;
    private void init0_1() {
        xPoint0.valueProperty().addListener((observable, oldValue, newValue) -> redraw0_1());
        yPoint0.valueProperty().addListener((observable, oldValue, newValue) -> redraw0_1());
        spinPointSlider0.valueProperty().addListener((observable, oldValue, newValue) -> redraw0_1());
        changeColor(canvas0_1, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0);
        fillColorPicker0.setOnAction(event -> changeColor(canvas0_1, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0));
        lineColorPicker0.setOnAction(event -> changeColor(canvas0_1, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0));
        spinColorPicker0.setOnAction(event -> changeColor(canvas0_1, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0));
        widthSlider0.valueProperty().addListener((observable, oldValue, newValue) -> redraw0_1());
        redraw0_1();
    }
    private void redraw0_1() {
        canvas0_1.getChildren().clear();
        int w0 = (int) widthSlider0.getValue(); int x0 = (int) (w0 / 15.0); int y0 = (int) (w0 / 15.0); int wL = 2;
        double mainPointY = yPoint0.getValue(); double mainPointX = xPoint0.getValue() + 800;
        double initialX = (mainPointY / x0); double initialY = (mainPointX / y0) + 20;
        int angle = (int) spinPointSlider0.getValue(); double angleRadians = Math.toRadians(angle); double cosAngle = Math.cos(angleRadians); double sinAngle = Math.sin(angleRadians);
        double[][] tempPoints = new double[][]{
                {(initialY + 2) * y0, (initialX + 3) * x0},
                {(initialY + 2) * y0, (initialX + 0) * x0},
                {(initialY + 0) * y0, (initialX + 2) * x0},
                {(initialY + 0) * y0, (initialX + 8) * x0},
                {(initialY + 2) * y0, (initialX + 10)* x0},
                {(initialY + 5) * y0, (initialX + 10)* x0},
                {(initialY + 7) * y0, (initialX + 8) * x0},
                {(initialY + 7) * y0, (initialX + 2) * x0},
                {(initialY + 5) * y0, (initialX + 0) * x0},
                {(initialY + 2) * y0, (initialX + 0) * x0},
                {(initialY + 2) * y0, (initialX + 3) * x0},
                {(initialY + 3) * y0, (initialX + 2) * x0},
                {(initialY + 4) * y0, (initialX + 2) * x0},
                {(initialY + 5) * y0, (initialX + 3) * x0},
                {(initialY + 5) * y0, (initialX + 7) * x0},
                {(initialY + 4) * y0, (initialX + 8) * x0},
                {(initialY + 3) * y0, (initialX + 8) * x0},
                {(initialY + 2) * y0, (initialX + 7) * x0},
                {(initialY + 2) * y0, (initialX + 3) * x0},
        };
        boolean pointsWithinBounds = Arrays.stream(tempPoints).noneMatch(point -> point[0] < minX || point[0] > maxX || point[1] < minY || point[1] > maxY);
        if (pointsWithinBounds) points0_1 = rotate(points0_1, tempPoints, cosAngle, sinAngle, xSpinPoint0, ySpinPoint0);
        for (int i = 1; i < points0_1.length; i++) {
            double[] currentPoint = points0_1[i - 1];
            double[] nextPoint = points0_1[i];
            drawPoint(currentPoint[0], currentPoint[1], nextPoint[0], nextPoint[1], wL, lineColorPicker0.getValue(), canvas0_1);
        }
        fillShape(fillColorPicker0, canvas0_1, points0_1);
    }
    //9
    private double[][] points9; @FXML private Pane canvas9;
    private void init9() {
        xPoint0.valueProperty().addListener((observable, oldValue, newValue) -> redraw9());
        yPoint0.valueProperty().addListener((observable, oldValue, newValue) -> redraw9());
        spinPointSlider0.valueProperty().addListener((observable, oldValue, newValue) -> redraw9());
        changeColor(canvas9, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0);
        fillColorPicker0.setOnAction(event -> changeColor(canvas9, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0));
        lineColorPicker0.setOnAction(event -> changeColor(canvas9, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0));
        spinColorPicker0.setOnAction(event -> changeColor(canvas9, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0));
        widthSlider0.valueProperty().addListener((observable, oldValue, newValue) -> redraw9());
        redraw9();
    }
    private void redraw9() {
        canvas9.getChildren().clear();
        int w9 = (int) widthSlider0.getValue(); int x9 = (int) (w9 / 15.0); int y9 = (int) (w9 / 15.0); int wL = 2;
        double mainPointY = yPoint0.getValue(); double mainPointX = xPoint0.getValue() + 800;
        double initialX = (mainPointY / x9); double initialY = (mainPointX / y9) + 30;
        int angle = (int) spinPointSlider0.getValue(); double angleRadians = Math.toRadians(angle); double cosAngle = Math.cos(angleRadians); double sinAngle = Math.sin(angleRadians);
        double[][] tempPoints = new double[][]{
                {(initialY) * y9, (initialX) * x9},
                {(initialY + 8) * y9, (initialX + 0) * x9},
                {(initialY + 8) * y9, (initialX + 10) * x9},
                {(initialY + 0) * y9, (initialX + 10) * x9},
                {(initialY + 0) * y9, (initialX + 8) * x9},
                {(initialY + 6) * y9, (initialX + 8) * x9},
                {(initialY + 6) * y9, (initialX + 2) * x9},
                {(initialY + 2) * y9, (initialX + 2) * x9},
                {(initialY + 2) * y9, (initialX + 4) * x9},
                {(initialY + 6) * y9, (initialX + 4) * x9},
                {(initialY + 6) * y9, (initialX + 6) * x9},
                {(initialY + 0) * y9, (initialX + 6) * x9},
                {(initialY) * y9, (initialX) * x9}
        };
        boolean pointsWithinBounds = Arrays.stream(tempPoints).noneMatch(point -> point[0] < minX || point[0] > maxX || point[1] < minY || point[1] > maxY);
        if (pointsWithinBounds) points9 = rotate(points9, tempPoints, cosAngle, sinAngle, xSpinPoint0, ySpinPoint0);
        for (int i = 1; i < points9.length; i++) {
            double[] currentPoint = points9[i - 1];
            double[] nextPoint = points9[i];
            drawPoint(currentPoint[0], currentPoint[1], nextPoint[0], nextPoint[1], wL, lineColorPicker0.getValue(), canvas9);
        }
        fillShape(fillColorPicker0, canvas9, points9);
        Circle circle = new Circle();
        circle.setCenterX(points9[2][0]+w9/10);
        circle.setCenterY(points9[2][1]);
        circle.setRadius(w9/20);
        circle.setFill(Color.RED);
        canvas9.getChildren().add(circle);
    }

    //2_1
    private double[][] points2_1; @FXML private Pane canvas2_1;
    private void init2_1() {
        xPoint0.valueProperty().addListener((observable, oldValue, newValue) -> redraw2_1());
        yPoint0.valueProperty().addListener((observable, oldValue, newValue) -> redraw2_1());
        spinPointSlider0.valueProperty().addListener((observable, oldValue, newValue) -> redraw2_1());
        changeColor(canvas2_1, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0);
        fillColorPicker0.setOnAction(event -> changeColor(canvas2_1, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0));
        lineColorPicker0.setOnAction(event -> changeColor(canvas2_1, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0));
        spinColorPicker0.setOnAction(event -> changeColor(canvas2_1, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0));
        widthSlider0.valueProperty().addListener((observable, oldValue, newValue) -> redraw2_1());
        redraw2_1();
    }
    private void redraw2_1() {
        canvas2_1.getChildren().clear();
        int w2 = (int) widthSlider0.getValue(); int x2 = (int) (w2 / 15.0); int y2 = (int) (w2 / 15.0); int wL = 2;
        double mainPointY = yPoint0.getValue(); double mainPointX = xPoint0.getValue() + 800;
        double initialX = (mainPointY / x2); double initialY = (mainPointX / y2) + 42;
        int angle = (int) spinPointSlider0.getValue(); double angleRadians = Math.toRadians(angle); double cosAngle = Math.cos(angleRadians); double sinAngle = Math.sin(angleRadians);
        double[][] tempPoints = new double[][]{
                {(initialY) * y2, (initialX) * x2},
                {(initialY + 8) * y2, (initialX + 0) * x2},
                {(initialY + 8) * y2, (initialX + 6) * x2},
                {(initialY + 2) * y2, (initialX + 6) * x2},
                {(initialY + 2) * y2, (initialX + 8) * x2},
                {(initialY + 8) * y2, (initialX + 8) * x2},
                {(initialY + 8) * y2, (initialX + 10) * x2},
                {(initialY) * y2, (initialX + 10) * x2},
                {(initialY) * y2, (initialX + 4) * x2},
                {(initialY + 6) * y2, (initialX + 4) * x2},
                {(initialY + 6) * y2, (initialX + 2) * x2},
                {(initialY) * y2, (initialX + 2) * x2},
                {(initialY) * y2, (initialX) * x2}
        };
        boolean pointsWithinBounds = Arrays.stream(tempPoints).noneMatch(point -> point[0] < minX || point[0] > maxX || point[1] < minY || point[1] > maxY);
        if (pointsWithinBounds) points2_1 = rotate(points2_1, tempPoints, cosAngle, sinAngle, xSpinPoint0, ySpinPoint0);
        for (int i = 1; i < points2_1.length; i++) {
            double[] currentPoint = points2_1[i - 1];
            double[] nextPoint = points2_1[i];
            drawPoint(currentPoint[0], currentPoint[1], nextPoint[0], nextPoint[1], wL, lineColorPicker0.getValue(), canvas2_1);
        }
        fillShape(fillColorPicker0, canvas2_1, points2_1);
    }

    // 0_2
    private double[][] points0_2; @FXML private Pane canvas0_2;
    private void init0_2() {
        xPoint0.valueProperty().addListener((observable, oldValue, newValue) -> redraw0_2());
        yPoint0.valueProperty().addListener((observable, oldValue, newValue) -> redraw0_2());
        spinPointSlider0.valueProperty().addListener((observable, oldValue, newValue) -> redraw0_2());
        changeColor(canvas0_2, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0);
        fillColorPicker0.setOnAction(event -> changeColor(canvas0_2, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0));
        lineColorPicker0.setOnAction(event -> changeColor(canvas0_2, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0));
        spinColorPicker0.setOnAction(event -> changeColor(canvas0_2, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0));
        widthSlider0.valueProperty().addListener((observable, oldValue, newValue) -> redraw0_2());
        redraw0_2();
    }
    private void redraw0_2() {
        canvas0_2.getChildren().clear();
        int w0 = (int) widthSlider0.getValue(); int x0 = (int) (w0 / 15.0); int y0 = (int) (w0 / 15.0); int wL = 2;
        double mainPointY = yPoint0.getValue(); double mainPointX = xPoint0.getValue() + 800;
        double initialX = (mainPointY / x0); double initialY = (mainPointX / y0) + 52;
        int angle = (int) spinPointSlider0.getValue(); double angleRadians = Math.toRadians(angle); double cosAngle = Math.cos(angleRadians); double sinAngle = Math.sin(angleRadians);
        double[][] tempPoints = new double[][]{
                {(initialY + 2) * y0, (initialX + 3) * x0},
                {(initialY + 2) * y0, (initialX + 0) * x0},
                {(initialY + 0) * y0, (initialX + 2) * x0},
                {(initialY + 0) * y0, (initialX + 8) * x0},
                {(initialY + 2) * y0, (initialX + 10)* x0},
                {(initialY + 5) * y0, (initialX + 10)* x0},
                {(initialY + 7) * y0, (initialX + 8) * x0},
                {(initialY + 7) * y0, (initialX + 2) * x0},
                {(initialY + 5) * y0, (initialX + 0) * x0},
                {(initialY + 2) * y0, (initialX + 0) * x0},
                {(initialY + 2) * y0, (initialX + 3) * x0},
                {(initialY + 3) * y0, (initialX + 2) * x0},
                {(initialY + 4) * y0, (initialX + 2) * x0},
                {(initialY + 5) * y0, (initialX + 3) * x0},
                {(initialY + 5) * y0, (initialX + 7) * x0},
                {(initialY + 4) * y0, (initialX + 8) * x0},
                {(initialY + 3) * y0, (initialX + 8) * x0},
                {(initialY + 2) * y0, (initialX + 7) * x0},
                {(initialY + 2) * y0, (initialX + 3) * x0},
        };
        boolean pointsWithinBounds = Arrays.stream(tempPoints).noneMatch(point -> point[0] < minX || point[0] > maxX || point[1] < minY || point[1] > maxY);
        if (pointsWithinBounds) points0_2 = rotate(points0_2, tempPoints, cosAngle, sinAngle, xSpinPoint0, ySpinPoint0);
        for (int i = 1; i < points0_2.length; i++) {
            double[] currentPoint = points0_2[i - 1];
            double[] nextPoint = points0_2[i];
            drawPoint(currentPoint[0], currentPoint[1], nextPoint[0], nextPoint[1], wL, lineColorPicker0.getValue(), canvas0_2);
        }
        fillShape(fillColorPicker0, canvas0_2, points0_2);
    }

    // 0_3
    private double[][] points0_3; @FXML private Pane canvas0_3;

    private void init0_3() {
        xPoint0.valueProperty().addListener((observable, oldValue, newValue) -> redraw0_3());
        yPoint0.valueProperty().addListener((observable, oldValue, newValue) -> redraw0_3());
        spinPointSlider0.valueProperty().addListener((observable, oldValue, newValue) -> redraw0_3());
        changeColor(canvas0_3, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0);
        fillColorPicker0.setOnAction(event -> changeColor(canvas0_3, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0));
        lineColorPicker0.setOnAction(event -> changeColor(canvas0_3, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0));
        spinColorPicker0.setOnAction(event -> changeColor(canvas0_3, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0));
        widthSlider0.valueProperty().addListener((observable, oldValue, newValue) -> redraw0_3());
        redraw0_3();
    }

    private void redraw0_3() {
        canvas0_3.getChildren().clear();
        int w0 = (int) widthSlider0.getValue(); int x0 = (int) (w0 / 15.0); int y0 = (int) (w0 / 15.0); int wL = 2;
        double mainPointY = yPoint0.getValue(); double mainPointX = xPoint0.getValue() + 800;
        double initialX = (mainPointY / x0); double initialY = (mainPointX / y0) + 61;
        int angle = (int) spinPointSlider0.getValue(); double angleRadians = Math.toRadians(angle); double cosAngle = Math.cos(angleRadians); double sinAngle = Math.sin(angleRadians);
        double[][] tempPoints = new double[][]{
                {(initialY + 2) * y0, (initialX + 3) * x0},
                {(initialY + 2) * y0, (initialX + 0) * x0},
                {(initialY + 0) * y0, (initialX + 2) * x0},
                {(initialY + 0) * y0, (initialX + 8) * x0},
                {(initialY + 2) * y0, (initialX + 10)* x0},
                {(initialY + 5) * y0, (initialX + 10)* x0},
                {(initialY + 7) * y0, (initialX + 8) * x0},
                {(initialY + 7) * y0, (initialX + 2) * x0},
                {(initialY + 5) * y0, (initialX + 0) * x0},
                {(initialY + 2) * y0, (initialX + 0) * x0},
                {(initialY + 2) * y0, (initialX + 3) * x0},
                {(initialY + 3) * y0, (initialX + 2) * x0},
                {(initialY + 4) * y0, (initialX + 2) * x0},
                {(initialY + 5) * y0, (initialX + 3) * x0},
                {(initialY + 5) * y0, (initialX + 7) * x0},
                {(initialY + 4) * y0, (initialX + 8) * x0},
                {(initialY + 3) * y0, (initialX + 8) * x0},
                {(initialY + 2) * y0, (initialX + 7) * x0},
                {(initialY + 2) * y0, (initialX + 3) * x0},
        };
        boolean pointsWithinBounds = Arrays.stream(tempPoints).noneMatch(point -> point[0] < minX || point[0] > maxX || point[1] < minY || point[1] > maxY);
        if (pointsWithinBounds) points0_3 = rotate(points0_3, tempPoints, cosAngle, sinAngle, xSpinPoint0, ySpinPoint0);
        for (int i = 1; i < points0_3.length; i++) {
            double[] currentPoint = points0_3[i - 1];
            double[] nextPoint = points0_3[i];
            drawPoint(currentPoint[0], currentPoint[1], nextPoint[0], nextPoint[1], wL, lineColorPicker0.getValue(), canvas0_3);
        }
        fillShape(fillColorPicker0, canvas0_3, points0_3);
    }

    //3
    private double[][] points3; @FXML private Pane canvas3;
    private void init3() {
        xPoint0.valueProperty().addListener((observable, oldValue, newValue) -> redraw3());
        yPoint0.valueProperty().addListener((observable, oldValue, newValue) -> redraw3());
        spinPointSlider0.valueProperty().addListener((observable, oldValue, newValue) -> redraw3());
        changeColor(canvas3, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0);
        fillColorPicker0.setOnAction(event -> changeColor(canvas3, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0));
        lineColorPicker0.setOnAction(event -> changeColor(canvas3, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0));
        spinColorPicker0.setOnAction(event -> changeColor(canvas3, lineColorPicker0, spinColorPicker0, fillColorPicker0, pointSpin0));
        widthSlider0.valueProperty().addListener((observable, oldValue, newValue) -> redraw3());
        redraw3();
    }
    private void redraw3() {
        canvas3.getChildren().clear();
        int w3 = (int) widthSlider0.getValue(); int x3 = (int) (w3 / 15.0); int y3 = (int) (w3 / 15.0); int wL = 2;
        double mainPointY = yPoint0.getValue(); double mainPointX = xPoint0.getValue() + 800;
        double initialX = (mainPointY / x3); double initialY = (mainPointX / y3) + 71;
        int angle = (int) spinPointSlider0.getValue(); double angleRadians = Math.toRadians(angle); double cosAngle = Math.cos(angleRadians); double sinAngle = Math.sin(angleRadians);
        double[][] tempPoints = new double[][]{
                {(initialY) * y3, (initialX ) * x3},
                {(initialY + 8) * y3, (initialX + 0) * x3},
                {(initialY + 8) * y3, (initialX + 10) * x3},
                {(initialY + 0) * y3, (initialX + 10) * x3},
                {(initialY + 0) * y3, (initialX + 8) * x3},
                {(initialY + 7) * y3, (initialX + 8) * x3},
                {(initialY + 7) * y3, (initialX + 6) * x3},
                {(initialY + 0) * y3, (initialX + 6) * x3},
                {(initialY + 0) * y3, (initialX + 4) * x3},
                {(initialY + 7) * y3, (initialX + 4) * x3},
                {(initialY + 7) * y3, (initialX + 2) * x3},
                {(initialY + 0) * y3, (initialX + 2) * x3},
                {(initialY) * y3, (initialX) * x3},
        };
        boolean pointsWithinBounds = Arrays.stream(tempPoints).noneMatch(point -> point[0] < minX || point[0] > maxX || point[1] < minY || point[1] > maxY);
        if (pointsWithinBounds) points3 = rotate(points3, tempPoints, cosAngle, sinAngle, xSpinPoint0, ySpinPoint0);
        for (int i = 1; i < points3.length; i++) {
            double[] currentPoint = points3[i - 1];
            double[] nextPoint = points3[i];
            drawPoint(currentPoint[0], currentPoint[1], nextPoint[0], nextPoint[1], wL, lineColorPicker0.getValue(), canvas3);
        }
        fillShape(fillColorPicker0, canvas3, points3);
    }

    // доповнення
    private double[][] rotate(double[][] points, double[][] temp_points, double cosAngle, double sinAngle, int xSpinPoint, int ySpinPoint) {
        boolean pointsWithinBounds = true;
        for (int i = 0; i < temp_points.length; i++) {
            double x = temp_points[i][0] - xSpinPoint;
            double y = temp_points[i][1] - ySpinPoint;
            double newX = x * cosAngle - y * sinAngle + xSpinPoint;
            double newY = x * sinAngle + y * cosAngle + ySpinPoint;
            if (newX < minX || newX > maxX || newY < minY || newY > maxY) {
                pointsWithinBounds = false; break;
            }
            temp_points[i] = new double[]{newX, newY};
        }
        if (!pointsWithinBounds) return points;
        return temp_points;
    }
    private void fillShape(ColorPicker fillColorPicker, Pane canvas, double[][] points) {
        Polygon Shape = new Polygon();
        for (double[] point : points) Shape.getPoints().addAll(point[0], point[1]);
        Shape.setFill(fillColorPicker.getValue());
        canvas.getChildren().add(Shape);
    }
    private void changeColor(Pane canvas, ColorPicker b, ColorPicker c, ColorPicker a, Circle d) {
        for (Node node : canvas.getChildren()) {
            if (node instanceof Polygon) { Polygon Shape = (Polygon) node; Shape.setFill(a.getValue()); }
            if (node instanceof Circle) { Circle point = (Circle) node; point.setFill(b.getValue()); }
        }
        d.setFill(c.getValue());
        redrawD();
        redrawY();
        redrawA();
        redraw0();
        redraw4();
        redraw0_1();
        redraw9();
        redraw2_1();
        redraw0_2();
        redraw0_3();
        redraw3();

    }
    private void drawPoint(double x1, double y1, double x2, double y2, int wL, Color lineColor, Pane canvas) {
        int startX = (int) x1; int startY = (int) y1;
        int endX = (int) x2; int endY = (int) y2;
        int dx = Math.abs(endX - startX); int dy = Math.abs(endY - startY);
        int sx = startX < endX ? 1 : -1; int sy = startY < endY ? 1 : -1;
        int err = dx - dy;
        while (true) {
            canvas.getChildren().add(new Circle(startX, startY, wL, lineColor));
            if (startX == endX && startY == endY) break;
            int e2 = 2 * err;
            if (e2 > -dy) { err -= dy; startX += sx; }
            if (e2 < dx) { err += dx; startY += sy; }
        }
    }

    private void DraggedPointD(MouseEvent event) {
        pointSpinD.setCenterX(event.getX());
        pointSpinD.setCenterY(event.getY());
        xSpinPointD = (int) pointSpinD.getCenterX();
        ySpinPointD = (int) pointSpinD.getCenterY();
    }
    private void DraggedPoint0(MouseEvent event) {
        pointSpin0.setCenterX(event.getX());
        pointSpin0.setCenterY(event.getY());
        xSpinPoint0 =  (int) pointSpin0.getCenterX();
        ySpinPoint0 =  (int) pointSpin0.getCenterY();
    }
}
