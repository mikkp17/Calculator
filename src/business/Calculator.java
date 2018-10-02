package business;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Calculator
 *
 * @author Mikkel Pedersen
 */
public class Calculator extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/resources/fxml/Calculator.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(350);
        stage.setMinHeight(500);
        stage.setTitle("Calculator");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public double calculate(double numberOne, double numberTwo, int mathType) {
        switch (mathType) {
            case 0: // 0 = +
                return numberOne + numberTwo;
            case 1: // 1 = -
                return numberOne - numberTwo;
            case 2: // 2 = *
                return numberOne * numberTwo;
            case 3: // 3 = /
                return numberOne / numberTwo;
            default:
                return 0;
        }
    }
}
