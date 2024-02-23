package pro.sky.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorServiceImplTest {
    private final CalculatorServiceImpl out = new CalculatorServiceImpl();

    @Test
    void calculatorHello() {
        String result = out.calculatorHello();
        Assertions.assertEquals("Добро пожаловать в калькулятор", result);
    }

    @Test
    void plus() {
        Double[] num1 = {5d, 0d, -10d, 50d};
        Double[] num2 = {6d, 47d, -20d, -57d};
        Double[] expected = {11d, 47d, -30d, -7d};
        for (int i = 0; i < num1.length; i++) {
            Double actual = out.plus(num1[i], num2[i]);
            assertEquals(expected[i], actual);
        }
    }

    @Test
    void minus() {
        Double[] num1 = {5d, 0d, -10d, 50d};
        Double[] num2 = {6d, 47d, -20d, -57d};
        Double[] expected = {-1d, -47d, 10d, 107d};
        for (int i = 0; i < num1.length; i++) {
            Double actual = out.minus(num1[i], num2[i]);
            assertEquals(expected[i], actual);
        }
    }

    @Test
    void multiply() {
        Double[] num1 = {5d, 0d, -10d, 50d};
        Double[] num2 = {6d, 47d, -20d, -57d};
        Double[] expected = {30d, 0d, 200d, -2850d};
        for (int i = 0; i < num1.length; i++) {
            Double actual = out.multiply(num1[i], num2[i]);
            assertEquals(expected[i], actual);
        }
    }

    @Test
    void divide() {
        Double[] num1 = {30d, 0d, -10d, 50d};
        Double[] num2 = {6d, 47d, -20d, -25d};
        Double[] expected = {5d, 0d, 0.5d, -2d};
        for (int i = 0; i < num1.length; i++) {
            Double actual = out.divide(num1[i], num2[i]);
            assertEquals(expected[i], actual);
        }
    }

    @Test
    void shouldReturnExceptionWhenNum2Equals0() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> out.divide(10d, 0d));
    }

    @Test
    void shouldReturnExceptionWhenNumNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> out.checkingValues(null, 2d));
    }

    public static Stream<Arguments> provideParamsForTests() {
        return Stream.of(
                Arguments.of(18d, 6d),
                Arguments.of(-5d, -10d),
                Arguments.of(0d, -10d),
                Arguments.of(-500d, 10d)    //Проверку деления на ноль в задании сказано не проверять
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void plus(Double num1, Double num2) {
        Double expectedPlus = num1 + num2;
        Double actual = out.plus(num1, num2);
        assertEquals(expectedPlus, actual);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void minus(Double num1, Double num2) {
        Double expectedMinus = num1 - num2;
        Double actual = out.minus(num1, num2);
        assertEquals(expectedMinus, actual);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void multiply(Double num1, Double num2) {
        Double expectedMultiply = num1 * num2;
        Double actual = out.multiply(num1, num2);
        assertEquals(expectedMultiply, actual);
    }


    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void divide(Double num1, Double num2) {
        Double expectedDivide = num1 / num2;
        Double actual = out.divide(num1, num2);
        assertEquals(expectedDivide, actual);
    }
}