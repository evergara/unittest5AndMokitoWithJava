package scientificcalculator.util;

import calculator.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidaterDateCalculatorTest {
    ValidaterDateCalculator validaterDateCalculator;
    @BeforeEach
    public void setUp(){
        validaterDateCalculator = new ValidaterDateCalculator();
        System.out.println("@BeforeEach -> setUp()");
    }

    @AfterEach
    public void tearDown(){
        validaterDateCalculator = null;
        System.out.println("@AfterEach -> tearDown()");
    }

    @Test
    public void checkTest() {
        assertEquals(true, validaterDateCalculator.check(5));
    }

    @Test
    public void checkNegativeTest() {
        assertEquals(false, validaterDateCalculator.check(-5));
    }

    @Test
    public void checkStringTest() {
        assertEquals(false, validaterDateCalculator.check("-5"));
    }


    @Test
    public void checkZeroTest() {
        assertEquals(true, validaterDateCalculator.check(5));
    }

    @Test
    public void checkZeroNegativeTest() {
        assertEquals(true, validaterDateCalculator.checkZero(-5));
    }

    @Test
    public void checkZeroStringTest() {
        assertEquals(false, validaterDateCalculator.checkZero("-5"));
    }

    @Test
    public void checkZeroWhenIsZeroTest() {
        assertThrows(ArithmeticException.class, ()->validaterDateCalculator.checkZero(0), "No se puede dividir por Zero");
    }

    @Test
    public void checkZeroWhenIsZeroStringTest() {
        assertEquals(false, validaterDateCalculator.checkZero("0"));
    }

    @Test
    public void checkZeroWhenIsZeroExceptionTest() {
        Exception exception = null;

        //Mockito.when(validaterDateCalculator.checkZero(0)).thenThrow(new ArithmeticException("No se puede dividir por Zero"));

        try {
            validaterDateCalculator.checkZero(0);
        }catch (ArithmeticException e){
            exception = e;
        }
        assertNotNull(exception);
    }
}