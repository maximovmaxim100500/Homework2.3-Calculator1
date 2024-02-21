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
        Double num1 = 5d;
        Double num2 = 6d;
        Double expected = 11d;
        Double actual = out.plus(num1, num2);
        assertEquals(expected, actual);
    }

    @Test
    void minus() {
        Double num1 = 5d;
        Double num2 = 6d;
        Double expected = -1d;
        Double actual = out.minus(num1, num2);
        assertEquals(expected, actual);
    }

    @Test
    void multiply() {
        Double num1 = 5d;
        Double num2 = 6d;
        Double expected = 30d;
        Double actual = out.multiply(num1, num2);
        assertEquals(expected, actual);
    }

    @Test
    void divide() {
        Double num1 = 18d;
        Double num2 = 6d;
        Double expected = 3d;
        Double actual = out.divide(num1, num2);
        assertEquals(expected, actual);
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
                Arguments.of(18d, 6d, 24d, 12d, 108d, 3d)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void plus(Double num1, Double num2, Double expectedPlus, Double expectedMinus,
                     Double expectedMultiply, Double expectedDivide) {
        Double actual = out.plus(num1, num2);
        assertEquals(expectedPlus, actual);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void minus(Double num1, Double num2, Double expectedPlus, Double expectedMinus,
                      Double expectedMultiply, Double expectedDivide) {
        Double actual = out.minus(num1, num2);
        assertEquals(expectedMinus, actual);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void multiply(Double num1, Double num2, Double expectedPlus, Double expectedMinus,
                         Double expectedMultiply, Double expectedDivide) {
        Double actual = out.multiply(num1, num2);
        assertEquals(expectedMultiply, actual);
    }


    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void divide(Double num1, Double num2, Double expectedPlus, Double expectedMinus,
                       Double expectedMultiply, Double expectedDivide) {
        Double actual = out.divide(num1, num2);
        assertEquals(expectedDivide, actual);
    }
}