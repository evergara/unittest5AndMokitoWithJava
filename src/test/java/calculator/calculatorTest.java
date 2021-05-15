package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @Test
    public void calculatorISNullTest(){
        assertNull(calculator, "Calculator debe ser Null");
    }

    @Test
    public void calculatorNotNullTest(){
        calculator = new Calculator();
        assertNotNull(calculator, "Calculator debe estar Instanciado y no ser Null");
    }
}