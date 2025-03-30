package md.test_spring.calculator.interfaces;

public interface CalculatorService {
    String greeting();

    Integer minusNumbers(Integer num1, Integer num2);

    Integer sumNumbers(Integer num1, Integer num2);

    Integer multiplyNumbers(Integer num1, Integer num2);

    Double divideNumbers(Integer num1, Integer num2);
}
