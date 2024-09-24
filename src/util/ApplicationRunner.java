package util;

import calculator.model.CalculatorOfComplexNumbers;
import calculator.view.ConsoleUI;
import calculator.view.UIViewer;
import util.logger.Log;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationRunner {
    private static final Logger log = Log.log(ApplicationRunner.class.getName());
    private ApplicationRunner() {
        log.log(Level.INFO, "Application started");
        UIViewer uiViewer= new ConsoleUI(new CalculatorOfComplexNumbers());
        uiViewer.run();
    }

    public static void run() {
        new ApplicationRunner();
    }
}
