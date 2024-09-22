package calculator.view;

import calculator.model.Calculator;
import calculator.model.ComplexNumber;
import java.util.Scanner;
public class ConsoleUI implements UIViewer {
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

            switch (enteredLine) {
                case "+":
                    args[0] = inputComplexNumber("Введите первое число");
                    args[1] = inputComplexNumber("Введите второе число");
                    System.out.println("(" + args[0] + ") + (" + args[1] + ") = " + (ComplexNumber) calculator.calculate(enteredLine, args));
                    break;
                case "-":
                    args[0] = inputComplexNumber("Введите первое число");
                    args[1] = inputComplexNumber("Введите второе число");
                    System.out.println("(" + args[0] + ") - (" + args[1] + ") = " + (ComplexNumber) calculator.calculate(enteredLine, args));
                    break;
                case "*":
                    args[0] = inputComplexNumber("Введите первое число");
                    args[1] = inputComplexNumber("Введите второе число");
                    System.out.println("(" + args[0] + ") * (" + args[1] + ") = " + (ComplexNumber) calculator.calculate(enteredLine, args));
                    break;
                case "/":
                    args[0] = inputComplexNumber("Введите первое число");
                    args[1] = inputComplexNumber("Введите второе число");
                    System.out.println("(" + args[0] + ") / (" + args[1] + ") = " + (ComplexNumber) calculator.calculate(enteredLine, args));
                    break;

                case "e": System.exit(0);
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
