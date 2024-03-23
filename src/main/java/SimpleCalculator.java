import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        System.out.println("Welcome to my simple calculator!");
        System.out.println("Remember, this calculator does not follow the mathematical rules and the operations will be calculated from left to right. Enjoy! ");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter an arithmetic expression with spaces (or 'exit' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            try {
                double result = evaluateExpression(input);
                System.out.println("Result: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static double evaluateExpression(String expression) {
        String[] symbols = expression.split("\\s+");
        if (symbols.length % 2 == 0) {
            throw new IllegalArgumentException("Invalid expression: Missing numbers or operands.");
        }

        double result = Double.parseDouble(symbols[0]);

        for (int i = 1; i < symbols.length; i += 2) {
            char number = symbols[i].charAt(0);
            double operand = Double.parseDouble(symbols[i + 1]);

            switch (number) {
                case '+':
                    result += operand;
                    break;
                case '-':
                    result -= operand;
                    break;
                case '*':
                    result *= operand;
                    break;
                case '/':
                    if (operand == 0) {
                        throw new IllegalArgumentException("You can't divide by zero!");
                    }
                    result /= operand;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid number");
            }
        }

        return result;
    }
}
