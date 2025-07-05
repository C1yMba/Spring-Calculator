package md.test_spring.calculator.exceptions;

public class DivideException extends IllegalArgumentException{

    public DivideException(String s) {
        super(s);
    }
}
