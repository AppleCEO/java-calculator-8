package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        String input = getInput(args);
        int result = calculateSum(input);
        printResult(result);
    }

    private static String getInput(String[] args) {
        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            String input = getInput(scanner);
            return input;
        }
        return args[0];
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
            sum += parsePositiveNumber(numStr);
        }
        return sum;
    }

    private static int parsePositiveNumber(String string) {
        int number = getNumber(string);
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        return number;
    }

    private static int getNumber(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자와 숫자 사이의 구분자로만 작성해야 합니다.");
        }
    }

    private static String[] splitInput(String input) {
        if (input.startsWith("//") && input.contains("\\n")) {
            return SplitByCustomDeligiters(input);
        }
        return SplitByDefaultDeligiters(input);
    }

    private static String[] SplitByCustomDeligiters(String input) {
        int newlineIndex = input.indexOf("\\n");
        String customDelimiter = input.substring(2, newlineIndex);
        String inputWithoutCustomDelimiter = input.substring(newlineIndex + 2);
        return inputWithoutCustomDelimiter.split(customDelimiter);
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
