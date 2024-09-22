package calculator.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CalculatorOfComplexNumbers implements Calculator<ComplexNumber> {

    private final Map<String, Operation<ComplexNumber>> operations;

    public CalculatorOfComplexNumbers() {
        operations = new HashMap<>();

        operations.put("+", (args) -> {
            ComplexNumber res = new ComplexNumber();
            return ComplexNumber.addition(args[0], args[1]);
        });
        operations.put("-", (args) -> {
            ComplexNumber res = new ComplexNumber();
            return ComplexNumber.subtraction(args[0], args[1]);
        });
        operations.put("*", (args) -> {
            ComplexNumber res = new ComplexNumber();
            return ComplexNumber.multiplication(args[0], args[1]);
        });
        operations.put("/", (args) -> {
            ComplexNumber res = new ComplexNumber();
            return ComplexNumber.division(args[0], args[1]);
        });
    }

    @Override
    public Set<String> getOperations() {
        return operations.keySet();
    }

    @Override
    public ComplexNumber calculate(String operator, ComplexNumber[] args) {
        return operations.get(operator).calculate(args);
    }

}
