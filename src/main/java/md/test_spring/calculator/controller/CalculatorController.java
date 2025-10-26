package md.test_spring.calculator.controller;

import lombok.RequiredArgsConstructor;
import md.test_spring.calculator.interfaces.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
//@RequiredArgsConstructor
public class CalculatorController {

    @Autowired
    private final CalculatorService calculatorService;

    CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }

    @GetMapping()
    public String greeting() {
        return calculatorService.greeting();

    }

    @GetMapping(path = "/plus")
    public String sumNumbers(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        String validationMessage = checkNumbers(num1, num2);
        if (validationMessage != null) {
            return validationMessage;
        }
        return String.format("%d + %d = %d", num1, num2, calculatorService.sumNumbers(num1, num2));
    }

    @GetMapping(path = "/minus")
    public String minusNumbers(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        String validationMessage = checkNumbers(num1, num2);
        if (validationMessage != null) {
            return validationMessage;
        }
        return String.format("%d - %d = %d", num1, num2, calculatorService.minusNumbers(num1, num2));
    }

    @GetMapping(path = "/multiply")
    public String multiplyNumbers(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        String validationMessage = checkNumbers(num1, num2);
        if (validationMessage != null) {
            return validationMessage;
        }
        return String.format("%d * %d = %d", num1, num2, calculatorService.multiplyNumbers(num1, num2));
    }

    @GetMapping(path = "/divide")
    public String divideNumbers(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        String validationMessage = checkNumbers(num1, num2);
        if (validationMessage != null) {
            return validationMessage;
        }
        if (num2 == 0) {
            return "Деление на 0 запрещенно, пожалуйста измените параметры так чтобы num2 не был равен 0";
        }
        return String.format("%d / %d = %f", num1, num2, calculatorService.divideNumbers(num1, num2));
    }

    private String checkNumbers(Integer firstNumber, Integer secondNumber) {
        if (firstNumber == null && secondNumber == null) {
            return "Ошибка: не заданы оба числа!";
        }
        if (firstNumber == null) {
            return "Ошибка: не задано первое число!";
        }
        if (secondNumber == null) {
            return "Ошибка: не задано второе число!";
        }
        return null;
    }


}
