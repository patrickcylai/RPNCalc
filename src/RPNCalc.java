/**
 * Created by patricklai on 25/11/2015.
 */
import java.util.*;

public class RPNCalc {
    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    public static void displayResult(double result) {
        System.out.println(result);
    }

    public static void main(String[] args) {
        Stack<Double> numStack = new Stack<>();
        Scanner cin;

        while (true) {
            cin = new Scanner(System.in);
            String str = cin.nextLine();
            String[] splitStr = str.split("\\s+");

            double result = 0;
            for (int i = 0; i < splitStr.length; ++i) {
                switch (splitStr[i]) {
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
                    default:
                        if (isNumeric(splitStr[i])) {
                            numStack.push(Double.parseDouble(splitStr[i]));
                        }
                        break;
                }
            }
            displayResult(result);
        }
    }
}
