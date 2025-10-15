package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String argument = scanner.nextLine();

        int result = 0;
        String[] stringArray = argument.split(",");
        for(int i = 0; i < stringArray.length; i++){
            result += Integer.parseInt(stringArray[i]);
        }
        System.out.printf("결과 : %d", result);
    }
}
