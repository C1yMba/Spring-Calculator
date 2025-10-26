package md.test_spring.calculator.controller;

import md.test_spring.calculator.exceptions.DivideException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CalculatorControllerTest {

    @Autowired
    CalculatorController calculatorController;

    @Test
    void greeting() {
        String expected = calculatorController.greeting();
        String actual = "Добро пожаловать в калькулятор!";
        assertEquals(actual, expected);
        String expected1 = calculatorController.greeting();
        String actual1 = "Добро пожаловать в магазин!";
        assertNotEquals(actual1, expected1);
    }

    @Test
    void sumNumbers() {
        String expected = calculatorController.sumNumbers(5,6);
        String actual = "5 + 6 = 11";
        assertEquals(actual, expected);
        String expected1 = calculatorController.sumNumbers(7, 8);
        String actual1 = "7 + 8 = 18";
        assertNotEquals(actual1, expected1);
    }

    @Test
    void minusNumbers() {
        String expected = calculatorController.minusNumbers(5,6);
        String actual = "5 - 6 = -1";
        assertEquals(actual, expected);
        String expected1 = calculatorController.minusNumbers(10, 8);
        String actual1 = "10 - 8 = 3";
        assertNotEquals(actual1, expected1);
    }

    @Test
    void multiplyNumbers() {
        String expected = calculatorController.multiplyNumbers(5,6);
        String actual = "5 * 6 = 30";
        assertEquals(actual, expected);
        String expected1 = calculatorController.multiplyNumbers(10, 8);
        String actual1 = "10 * 8 = 18";
        assertNotEquals(actual1, expected1);
    }

    @Test
    void divideNumbers_OK() {
        String expected = calculatorController.divideNumbers(5,5);
        String actual = "5 / 5 = 1,00";
        assertEquals(actual, expected);
        String expected1 = calculatorController.divideNumbers(10, 8);
        String actual1 = "10 / 8 = 2";
        assertNotEquals(actual1, expected1);
    }

    @Test
    void divideNumbers_KO() {
        assertThrows(DivideException.class,() -> calculatorController.divideNumbers(5, 0));
    }
}