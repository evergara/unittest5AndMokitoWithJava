package scientificcalculator.util;

import calculator.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}