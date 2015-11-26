import java.util.Scanner;
import java.util.Stack;

/**
 * 
 */

/**
 * @author patricklai
 *
 */
public class RPNCalc {

	/*
     * Determines if the string is a numeric type
	 */
	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}

	/*
     * Displays the result
	 */
	public static void displayResult(double result) {
		System.out.println(result);
	}

	/*
	 * Display help information
	 */
	public static void displayHelp() {
		return;
	}

	/*
	 * Display Launch information
	 */
	
	public static void displayInfo() {
		System.out.println("RPNCalc by Patrick Lai. 2015.");
	}
	
	/**
	 * Main
	 * - need to make code more elegant and efficient especially for when args are provided
	 * @param args
	 */
	public static void main(String[] args) {
		boolean isArgs = false;
		
		if (args.length > 0) {
			isArgs = true;
		} else {
			displayInfo();
		}
		
		Scanner scanner;
		double temp = 0;
		Stack<Double> numStack = new Stack<>();
		
		while (true) {
			String str = args.toString();
			String[] splitStr;
			scanner = new Scanner(System.in);
			if (!isArgs) {
				str = scanner.nextLine();
				splitStr = str.split("\\s+");
			} else {
				splitStr = args;
			}
			
			boolean display = true;
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
				case "stack":
					System.out.println(numStack);
					display = false;
					break;
				case "clearstack":
					numStack = new Stack<>();
					System.out.println("Stack Cleared");
					display = false;
					break;
				case "help":
					displayHelp();
					display = false;
					break;
				case "quit":
					scanner.close();
					return;
				default: // If it isn't an operator
					if (isNumeric(splitStr[i])) { // Check if numeric so it can be pushed to stack
						numStack.push(Double.parseDouble(splitStr[i]));
					} else {
						System.out.println(str + " is not a valid command");
						display = false;
						break calcLoop;
					}
					break;
				}
			}
			if (display == true) {
				displayResult(result);
			}
			temp = result;
			if (isArgs == true) {
				return;
			}
		}
	}
}