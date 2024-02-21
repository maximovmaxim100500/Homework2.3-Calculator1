package pro.sky.calculator;

public interface CalculatorService {
    String calculatorHello();

    Double plus(Double num1, Double num2);

    Double minus(Double num1, Double num2);

    Double multiply(Double num1, Double num2);

    Double divide(Double num1, Double num2);

    void checkingValues(Double num1, Double num2);
}
