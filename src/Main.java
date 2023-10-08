import java.io.Console;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input: ");
        try {
            System.out.println("Output: \n" + calc(scanner.nextLine()));
        } catch (Exception e) {
            System.out.println("throw exception");
        }
    }

    public static String calc(String input) throws Exception {
        String[] nums = input.split("\\s+");
        if (nums.length != 3) {
            throw new Exception("throw exception");
        }

        String firstOperand = nums[0];
        String operator = nums[1];
        String secondOperand = nums[2];

        boolean isRoman = hasValue(firstOperand) && hasValue(secondOperand);
        boolean isArabic = firstOperand.matches("\\d+") && secondOperand.matches("\\d+");

        if (!isRoman && !isArabic) {
            throw new IllegalArgumentException("throw exception");
        }

        int num1;
        int num2;

        if (isRoman) {
            num1 = Rome.valueOf(firstOperand).getValue();
            num2 = Rome.valueOf(secondOperand).getValue();
        } else {
            num1 = Integer.parseInt(firstOperand);
            num2 = Integer.parseInt(secondOperand);
        }

        int result;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    throw new Exception("throw exception");
                }
                result = num1 / num2;
                break;
            default:
                throw new Exception("throw exception");
        }

        if (isRoman) {
            if (result <= 0) {
                throw new Exception("throw exception");
            }
        }

        return "" + result;
    }

    public static boolean hasValue(String value) {
        boolean hasValueBool;
        switch (value) {
            case "I":
            case "II":
            case "III":
            case "IV":
            case "V":
            case "VI":
            case "VII":
            case "VIII":
            case "IX":
            case "X":
                hasValueBool = true;
                break;
            default:
                hasValueBool = false;
                break;


        }
        return hasValueBool;
    }
    }
