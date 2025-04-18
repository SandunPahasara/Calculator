import java.util.Scanner;

public class Calculator {
    // ANSI color codes for console colors
    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[36m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        printHeader();
        
        while (true) {
            printMenu();
            
            System.out.print(YELLOW + "\nEnter your choice (1-5): " + RESET);
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(RED + "Invalid input! Please enter a number." + RESET);
                scanner.nextLine(); // clear the invalid input
                continue;
            }
            
            if (choice == 5) {
                System.out.println(PURPLE + "\nThank you for using the Beautiful Calculator!");
                System.out.println("Goodbye! 👋" + RESET);
                break;
            }
            
            if (choice < 1 || choice > 5) {
                System.out.println(RED + "Invalid choice! Please select 1-5." + RESET);
                continue;
            }
            
            double[] numbers = getNumbers(scanner);
            if (numbers == null) continue; // if invalid input was provided
            
            double num1 = numbers[0];
            double num2 = numbers[1];
            double result = 0;
            String operation = "";
            boolean error = false;
            
            switch (choice) {
                case 1:
                    result = num1 + num2;
                    operation = "+";
                    break;
                case 2:
                    result = num1 - num2;
                    operation = "-";
                    break;
                case 3:
                    result = num1 * num2;
                    operation = "×";
                    break;
                case 4:
                    if (num2 != 0) {
                        result = num1 / num2;
                        operation = "÷";
                    } else {
                        System.out.println(RED + "\nError: Cannot divide by zero!" + RESET);
                        error = true;
                    }
                    break;
            }
            
            if (!error) {
                printResult(num1, num2, result, operation);
            }
        }
        
        scanner.close();
    }
    
    private static void printHeader() {
        System.out.println(CYAN + "╔══════════════════════════════════════╗");
        System.out.println("║" + BLUE + "        BEAUTIFUL CALCULATOR       " + CYAN + "║");
        System.out.println("╚══════════════════════════════════════╝" + RESET);
    }
    
    private static void printMenu() {
        System.out.println(PURPLE + "\nChoose an operation:");
        System.out.println(GREEN + "1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (÷)");
        System.out.println(RED + "5. Exit" + RESET);
    }
    
    private static double[] getNumbers(Scanner scanner) {
        double[] numbers = new double[2];
        
        try {
            System.out.print(CYAN + "\nEnter first number: " + RESET);
            numbers[0] = scanner.nextDouble();
            
            System.out.print(CYAN + "Enter second number: " + RESET);
            numbers[1] = scanner.nextDouble();
        } catch (Exception e) {
            System.out.println(RED + "Invalid number! Please enter numeric values." + RESET);
            scanner.nextLine(); // clear the invalid input
            return null;
        }
        
        return numbers;
    }
    
    private static void printResult(double num1, double num2, double result, String operation) {
        System.out.println(GREEN + "\n╔══════════════════════════════════════╗");
        System.out.println("║              RESULT               ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf("║ %-10.2f %2s %-10.2f = %-10.2f ║\n", num1, operation, num2, result);
        System.out.println("╚══════════════════════════════════════╝" + RESET);
    }
}