package md.test_spring.calculator.controller;

import md.test_spring.calculator.exceptions.DivideException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculatorControllerParametrizedTest {

    @Autowired
    CalculatorController calculatorController;

    @ParameterizedTest
    @MethodSource("paramsForSumTest")
    void sumNumbersParameterized(int num1, int num2, String expectedResult) {
        String actual = calculatorController.sumNumbers(num1, num2);
        assertEquals(expectedResult, actual);
    }

    @ParameterizedTest
    @MethodSource("paramsForMinusTest")
    void minusNumbersParameterized(int num1, int num2, String expectedResult) {
        String actual = calculatorController.minusNumbers(num1, num2);
        assertEquals(expectedResult, actual);
    }

    @ParameterizedTest
    @MethodSource("paramsForMultiplyTest")
    void multiplyNumbersParameterized(int num1, int num2, String expectedResult) {
        String actual = calculatorController.multiplyNumbers(num1, num2);
        assertEquals(expectedResult, actual);
    }

    @ParameterizedTest
    @MethodSource("paramsForDivideTest")
    void divideNumbersParameterized(int num1, int num2, String expectedResult) {
        String actual = calculatorController.divideNumbers(num1, num2);
        assertEquals(expectedResult, actual);
    }

    private static Stream<Arguments> paramsForSumTest() {
        return Stream.of(
                Arguments.of(5, 6, "5 + 6 = 11"),
                Arguments.of(10, 8, "10 + 8 = 18"),
                Arguments.of(-1, 3, "-1 + 3 = 2"),
                Arguments.of(0, 0, "0 + 0 = 0")
        );
    }

    private static Stream<Arguments> paramsForMinusTest() {
        return Stream.of(
                Arguments.of(5, 6, "5 - 6 = -1"),
                Arguments.of(10, 8, "10 - 8 = 2"),
                Arguments.of(-1, 3, "-1 - 3 = -4"),
                Arguments.of(0, 0, "0 - 0 = 0")
        );
    }

    private static Stream<Arguments> paramsForMultiplyTest() {
        return Stream.of(
                Arguments.of(5, 6, "5 * 6 = 30"),
                Arguments.of(10, 8, "10 * 8 = 80"),
                Arguments.of(-1, 3, "-1 * 3 = -3"),
                Arguments.of(0, 0, "0 * 0 = 0")
        );
    }

    private static Stream<Arguments> paramsForDivideTest() {
        return Stream.of(
                Arguments.of(5, 5, "5 / 5 = 1,00"),
                Arguments.of(16, 8, "16 / 8 = 2,00"),
                Arguments.of(-1, 3, "-1 / 3 = -0,33"),
                Arguments.of(1, 1, "1 / 1 = 1,00")
        );
    }
}