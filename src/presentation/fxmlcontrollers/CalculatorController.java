package presentation.fxmlcontrollers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import business.Calculator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Calculator
 *
 * @author Mikkel Pedersen
 */
public class CalculatorController implements Initializable {

    Calculator calc;

    @FXML
    private GridPane keypad_grid;
    @FXML
    private Button button_5;
    @FXML
    private Label savedResultLabel;
    @FXML
    private Label resultLabel;
    @FXML
    private Button button_CE;
    @FXML
    private Button button_7;
    @FXML
    private Button button_4;
    @FXML
    private Button button_1;
    @FXML
    private Button button_S;
    @FXML
    private Button button_C;
    @FXML
    private Button button_8;
    @FXML
    private Button button_2;
    @FXML
    private Button button_0;
    @FXML
    private Button button_del;
    @FXML
    private Button button_9;
    @FXML
    private Button button_6;
    @FXML
    private Button button_3;
    @FXML
    private Button button_comma;
    @FXML
    private Button button_divide;
    @FXML
    private Button button_times;
    @FXML
    private Button button_minus;
    @FXML
    private Button button_plus;
    @FXML
    private Button button_equals;
    @FXML
    private Label firstNumberCalculation;

    String number;
    String firstNumber;
    String secondNumber;
    String resultNumber;
    String savedNumber;
    int mathType; // 0 = plus, 1 = minus, 2 = times, 3 = divide
    int calculatorStage; // 0 = first number, 1 = second number, 2 = result

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        calc = new Calculator();

        calculatorStage = 0;
        number = "0";
        firstNumber = "";
        secondNumber = "";
        resultNumber = "";
        savedNumber = "";
        firstNumberCalculation.setText("");
        resultLabel.setText(number);
        savedResultLabel.setText("");
    }

    @FXML
    private void numberPressed(ActionEvent event) {
        if (calculatorStage == 2) {
            savedResultLabel.setText(resultNumber);
            savedNumber = resultNumber;
            resultNumber = "";
            calculatorStage = 0;
        }
        if (event.getSource() == button_0) {
            if (number.startsWith("0") && number.length() == 1) {
                number = "0";
            } else {
                number += 0;
            }
        } else if (event.getSource() == button_1) {
            if (number.startsWith("0") && number.length() == 1) {
                number = "1";
            } else {
                number += 1;
            }
        } else if (event.getSource() == button_2) {
            if (number.startsWith("0") && number.length() == 1) {
                number = "2";
            } else {
                number += 2;
            }
        } else if (event.getSource() == button_3) {
            if (number.startsWith("0") && number.length() == 1) {
                number = "3";
            } else {
                number += 3;
            }
        } else if (event.getSource() == button_4) {
            if (number.startsWith("0") && number.length() == 1) {
                number = "4";
            } else {
                number += 4;
            }
        } else if (event.getSource() == button_5) {
            if (number.startsWith("0") && number.length() == 1) {
                number = "5";
            } else {
                number += 5;
            }
        } else if (event.getSource() == button_6) {
            if (number.startsWith("0") && number.length() == 1) {
                number = "6";
            } else {
                number += 6;
            }
        } else if (event.getSource() == button_7) {
            if (number.startsWith("0") && number.length() == 1) {
                number = "7";
            } else {
                number += 7;
            }
        } else if (event.getSource() == button_8) {
            if (number.startsWith("0") && number.length() == 1) {
                number = "8";
            } else {
                number += 8;
            }
        } else if (event.getSource() == button_9) {
            if (number.startsWith("0") && number.length() == 1) {
                number = "9";
            } else {
                number += 9;
            }
        }
        resultLabel.setText(number);
    }

    @FXML
    private void clearPressed(ActionEvent event) {
        number = "0";
        firstNumber = "";
        secondNumber = "";
        resultNumber = "";
        resultLabel.setText(number);
        firstNumberCalculation.setText("");
        calculatorStage = 0;
    }

    @FXML
    private void clearAllPressed(ActionEvent event) {
        number = "0";
        firstNumber = "";
        secondNumber = "";
        resultNumber = "";
        resultLabel.setText(number);
        savedResultLabel.setText("");
        firstNumberCalculation.setText("");
        calculatorStage = 0;
    }

    @FXML
    private void mPressed(ActionEvent event) {
        number = savedNumber;
        resultLabel.setText(number);
    }

    @FXML
    private void delPressed(ActionEvent event) {
        if (!number.equals("0") && number.length() > 0) {
            number = number.substring(0, number.length() - 1);
            if (number.length() == 0) {
                number = "0";
            }
            resultLabel.setText(number);
        } else if (calculatorStage == 2) {
            savedResultLabel.setText(resultNumber);
            savedNumber = resultNumber;
            resultNumber = "";
            number = "0";
            resultLabel.setText(number);
            calculatorStage = 0;
        }
    }

    @FXML
    private void commaPressed(ActionEvent event) {
        number += ".";
        resultLabel.setText(number);
    }

    @FXML
    private void dividePressed(ActionEvent event) {
        if (number.startsWith("0") && number.length() == 1) {
            // Do Nothing
        } else if (calculatorStage == 0) {
            firstNumber = number;
            firstNumberCalculation.setText(firstNumber + " / ");
            mathType = 3;
            calculatorStage++;
            number = "0";
            resultLabel.setText(number);
        } else if (calculatorStage == 1) {
            secondNumber = number;
            number = "0";

            Double result = calc.calculate(Double.parseDouble(firstNumber), Double.parseDouble(secondNumber), mathType);
            if (result % 1 == 0) {
                resultNumber = Integer.toString(result.intValue());
            } else {
                resultNumber = Double.toString(result);
            }
            mathType = 3;
            firstNumber = resultNumber;
            firstNumberCalculation.setText(firstNumber + " / ");
            resultLabel.setText(resultNumber);
        }
    }

    @FXML
    private void timesPressed(ActionEvent event) {
        if (number.startsWith("0") && number.length() == 1) {
            // Do Nothing
        } else if (calculatorStage == 0) {
            firstNumber = number;
            firstNumberCalculation.setText(firstNumber + " * ");
            mathType = 2;
            calculatorStage++;
            number = "0";
            resultLabel.setText(number);
        } else if (calculatorStage == 1) {
            secondNumber = number;
            number = "0";

            Double result = calc.calculate(Double.parseDouble(firstNumber), Double.parseDouble(secondNumber), mathType);
            if (result % 1 == 0) {
                resultNumber = Integer.toString(result.intValue());
            } else {
                resultNumber = Double.toString(result);
            }
            mathType = 2;
            firstNumber = resultNumber;
            firstNumberCalculation.setText(firstNumber + " * ");
            resultLabel.setText(resultNumber);
        }
    }

    @FXML
    private void minusPressed(ActionEvent event) {
        if (number.startsWith("0") && number.length() == 1) {
            // Do Nothing
        } else if (calculatorStage == 0) {
            firstNumber = number;
            firstNumberCalculation.setText(firstNumber + " - ");
            mathType = 1;
            calculatorStage++;
            number = "0";
            resultLabel.setText(number);
        } else if (calculatorStage == 1) {
            secondNumber = number;
            number = "0";

            Double result = calc.calculate(Double.parseDouble(firstNumber), Double.parseDouble(secondNumber), mathType);
            if (result % 1 == 0) {
                resultNumber = Integer.toString(result.intValue());
            } else {
                resultNumber = Double.toString(result);
            }
            mathType = 1;
            firstNumber = resultNumber;
            firstNumberCalculation.setText(firstNumber + " - ");
            resultLabel.setText(resultNumber);
        }
    }

    @FXML
    private void plusPressed(ActionEvent event) {
        if (number.startsWith("0") && number.length() == 1) {
            // Do Nothing
        } else if (calculatorStage == 0) {
            firstNumber = number;
            firstNumberCalculation.setText(firstNumber + " + ");
            mathType = 0;
            calculatorStage++;
            number = "0";
            resultLabel.setText(number);
        } else if (calculatorStage == 1) {
            secondNumber = number;
            number = "0";

            Double result = calc.calculate(Double.parseDouble(firstNumber), Double.parseDouble(secondNumber), mathType);
            if (result % 1 == 0) {
                resultNumber = Integer.toString(result.intValue());
            } else {
                resultNumber = Double.toString(result);
            }
            mathType = 0;
            firstNumber = resultNumber;
            firstNumberCalculation.setText(firstNumber + " + ");
            resultLabel.setText(resultNumber);
        }
    }

    @FXML
    private void equalsPressed(ActionEvent event) {
        if (calculatorStage == 1) {
            secondNumber = number;
            number = "0";

            Double result = calc.calculate(Double.parseDouble(firstNumber), Double.parseDouble(secondNumber), mathType);
            if (result % 1 == 0) {
                resultNumber = Integer.toString(result.intValue());
            } else {
                resultNumber = Double.toString(result);
            }
            firstNumber = "";
            firstNumberCalculation.setText("");
            resultLabel.setText(resultNumber);
            calculatorStage++;
        } else if (calculatorStage == 2) {
            firstNumber = resultNumber;
            Double result = calc.calculate(Double.parseDouble(firstNumber), Double.parseDouble(secondNumber), mathType);
            if (result % 1 == 0) {
                resultNumber = Integer.toString(result.intValue());
            } else {
                resultNumber = Double.toString(result);
            }
            firstNumberCalculation.setText(firstNumber);
            resultLabel.setText(resultNumber);
        }
    }

}
