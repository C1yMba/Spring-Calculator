package md.test_spring.calculator.service;

import md.test_spring.calculator.exceptions.DivideException;
import md.test_spring.calculator.interfaces.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public String greeting() {
        return "Добро пожаловать в калькулятор!";
    }

    @Override
    public Integer minusNumbers(Integer num1, Integer num2) {
        return num1 - num2;
    }

    @Override
    public Integer sumNumbers(Integer num1, Integer num2) {
        return num1 + num2;
    }

    @Override
    public Integer multiplyNumbers(Integer num1, Integer num2) {
        return num1 * num2;
    }

    @Override
    public Double divideNumbers(Integer num1, Integer num2) {
        if (num2 == 0) {
            throw new DivideException("Division by 0 is prohibited");
        }

        return (double) num1 / num2;
    }
}
