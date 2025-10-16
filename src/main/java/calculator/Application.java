package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String arguments = getInput(scanner);
        int result = calculateSum(arguments);
        printResult(result);
    }

    private static String getInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static int calculateSum(String input) {
        String[] stringArray = splitInput(input);
        return getSum(stringArray);
    }

    private static int getSum(String[] stringArray) {
        int sum = 0;
        for (String numStr : stringArray) {
            sum += Integer.parseInt(numStr);
        }
        return sum;
    }

    private static String[] splitInput(String input) {
        if (input.startsWith("//") && input.contains("\\n")) {
            int newlineIndex = input.indexOf("\\n");
            String customDelimiter = input.substring(2, newlineIndex);
            String inputWithoutCustomDelimiter = input.substring(newlineIndex + 2);
            return inputWithoutCustomDelimiter.split(customDelimiter);
        }
        return SplitByDefaultDeligiters(input);
    }

    private static String[] SplitByDefaultDeligiters(String input) {
        if (input.contains(",")) {
            return input.split(",");
        }
        return input.split(":");
    }

    private static void printResult(int result) {
        System.out.printf("결과 : %d", result);
    }
}
