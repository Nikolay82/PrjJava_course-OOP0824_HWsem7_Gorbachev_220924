package calculator.view;

import calculator.model.Calculator;
import calculator.model.ComplexNumber;
import util.ApplicationRunner;
import util.logger.Log;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleUI implements UIViewer {

    private static final Logger log = Log.log(ApplicationRunner.class.getName());
    private final Scanner scanner = new Scanner(System.in);
    private final Calculator calculator;

    public ConsoleUI(Calculator calculator) {
        this.calculator = calculator;
    }

    public void run() {

        System.out.println(">>Калькулятор комплексных чисел<<");

        while (true) {
            System.out.println("Введите операцию(" + calculator.getOperations() + ", e - выход):");
            String enteredLine = scanner.nextLine();
            ComplexNumber[] args = new ComplexNumber[2];
            String res_str = "";
            switch (enteredLine) {
                case "+":
                    args[0] = inputComplexNumber("Введите первое число");
                    args[1] = inputComplexNumber("Введите второе число");
                    res_str = "(" + args[0] + ") + (" + args[1] + ") = " + (ComplexNumber) calculator.calculate(enteredLine, args);
                    System.out.println(res_str);
                    log.log(Level.INFO, "Operation \"" + enteredLine + "\": " + res_str);
                    break;
                case "-":
                    args[0] = inputComplexNumber("Введите первое число");
                    args[1] = inputComplexNumber("Введите второе число");
                    res_str = "(" + args[0] + ") - (" + args[1] + ") = " + (ComplexNumber) calculator.calculate(enteredLine, args);
                    System.out.println(res_str);
                    log.log(Level.INFO, "Operation \"" + enteredLine + "\": " + res_str);
                    break;
                case "*":
                    args[0] = inputComplexNumber("Введите первое число");
                    args[1] = inputComplexNumber("Введите второе число");
                    res_str = "(" + args[0] + ") * (" + args[1] + ") = " + (ComplexNumber) calculator.calculate(enteredLine, args);
                    System.out.println(res_str);
                    log.log(Level.INFO, "Operation \"" + enteredLine + "\": " + res_str);
                    break;
                case "/":
                    args[0] = inputComplexNumber("Введите первое число");
                    args[1] = inputComplexNumber("Введите второе число");
                    res_str = "(" + args[0] + ") / (" + args[1] + ") = " + (ComplexNumber) calculator.calculate(enteredLine, args);
                    System.out.println(res_str);
                    log.log(Level.INFO, "Operation \"" + enteredLine + "\": " + res_str);
                    break;

                case "e":
                    log.log(Level.INFO, "Application completed");
                    System.exit(0);
            }
        }
    }

    private ComplexNumber inputComplexNumber(String message) {
        System.out.println(message);

        System.out.print("Действительная составляющая=");
        String enteredLine = scanner.nextLine();

        while (!isNumber(enteredLine)) {
            System.out.println("не корректный ввод числа! повторите ввод:");
            System.out.print("Действительная составляющая=");
            enteredLine = scanner.nextLine();
        }
        double cnReal = Double.parseDouble(enteredLine);

        System.out.print("Мнимая составляющая=");
        enteredLine = scanner.nextLine();

        while (!isNumber(enteredLine)) {
            System.out.println("не корректный ввод числа! повторите ввод:");
            System.out.print("Мнимая составляющая=");
            enteredLine = scanner.nextLine();
        }
        double cnImaginary = Double.parseDouble(enteredLine);

        return new ComplexNumber(cnReal, cnImaginary);
    }

    private boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
