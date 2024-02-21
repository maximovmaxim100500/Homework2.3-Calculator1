package pro.sky.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public String calculatorHello() {
        return "Добро пожаловать в калькулятор";
    }

    @Override
    public Double plus(Double num1, Double num2) {
        return num1 + num2;
    }

    @Override
    public Double minus(Double num1, Double num2) {
        return num1 - num2;
    }

    @Override
    public Double multiply(Double num1, Double num2) {
        return num1 * num2;
    }
    @Override
    public Double divide(Double num1, Double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("На ноль делить нельзя!");
        } else
            return num1 / num2;
    }

    @Override
    public void checkingValues(Double num1, Double num2) {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("Ошибка! Не заданы одно или оба значения!");
        }
    }
}


