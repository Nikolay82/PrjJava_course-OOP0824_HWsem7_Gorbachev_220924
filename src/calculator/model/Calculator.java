package calculator.model;

import java.util.Set;

public interface Calculator<T> {

    public Set<String> getOperations();

    public T calculate(String operator, T[] args);
}
