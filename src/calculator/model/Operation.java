package calculator.model;

public interface Operation<T> {
    T calculate(T[] args);
}
