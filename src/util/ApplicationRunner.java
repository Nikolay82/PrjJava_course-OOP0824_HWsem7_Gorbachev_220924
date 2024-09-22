package util;

import calculator.model.CalculatorOfComplexNumbers;
import calculator.view.ConsoleUI;
import calculator.view.UIViewer;

public class ApplicationRunner {
    private ApplicationRunner() {

        UIViewer uiViewer= new ConsoleUI(new CalculatorOfComplexNumbers());
        uiViewer.run();
    }

    public static void run() {
        new ApplicationRunner();
    }
}
