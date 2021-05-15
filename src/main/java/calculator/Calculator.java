package calculator;

public class Calculator {

    public  int add(int n1, int n2){
        return n1 + n2;
    }

    public  int subtract(int n1, int n2){
        return n1 - n2;
    }

    public  int multiply(int n1, int n2){
        return n1 * n2;
    }

    public  int divide(int n1, int n2){
        if(n2 == 0){
            return 0;
        }
        return n1 / n2;
    }

    public  int divideByZero(int n1, int n2){
        if(n2 == 0){
            throw new ArithmeticException("No se puede dividir entre cero");
        }
        return divide(n1, n2);
    }
}
