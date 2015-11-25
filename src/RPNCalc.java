/**
 * Basic Reverse Polish Notation Calculator
 * Created by Patrick Lai on 25/11/2015.
 */
import java.util.*;

public class RPNCalc {
    /*
    Determines if the string is a numeric type
     */
    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    /*
    Displays the result
     */
    public static void displayResult(double result) {
        System.out.println(result);
    }

    /*
    Main Calculator
     */
    public static void main(String[] args) {
        Scanner scanner;
        double temp = 0;
        Stack<Double> numStack = new Stack<>();
        while (true) {
            scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            String[] splitStr = str.split("\\s+");

            double result = 0;
            calcLoop :for (int i = 0; i < splitStr.length; ++i) {
                switch (splitStr[i]) { // Check whether there is a operator
                    case "+":
                        result = numStack.pop() + numStack.pop();
                        numStack.push(result);
                        break;
                    case "-":
                        result = numStack.pop() - numStack.pop();
                        numStack.push(result);
                        break;
                    case "*":
                        result = numStack.pop() * numStack.pop();
                        numStack.push(result);
                        break;
                    case "/":
                        result = numStack.pop() / numStack.pop();
                        numStack.push(result);
                        break;
                    case "ans":
                        numStack.push(temp);
                        break;
                    case "stack()":
                        System.out.println(numStack);
                        break;
                    case "clearstack()":
                        numStack = new Stack<>();
                        System.out.println("Stack Cleared");
                        break;
                    case "quit()":
                        scanner.close();
                        return;
                    default: // If it isn't an operator
                        if (isNumeric(splitStr[i])) { // Check if numeric so it can be pushed to stack
                            numStack.push(Double.parseDouble(splitStr[i]));
                        } else {
                            System.out.println(str + " is not a valid command");
                            break calcLoop;
                        }
                        break;
                }
            }
            displayResult(result);
            temp = result;
        }
    }
}
