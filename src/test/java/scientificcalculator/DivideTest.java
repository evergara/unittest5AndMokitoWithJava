package scientificcalculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import scientificcalculator.util.ValidaterDateCalculator;

import static org.junit.jupiter.api.Assertions.*;

class DivideTest {
    @InjectMocks
    private Divide divide;
    @Mock
    private ValidaterDateCalculator validaterDateCalculator;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        System.out.println("@BeforeEach -> setUp()");
    }

    @AfterEach
    public void tearDown(){
        validaterDateCalculator = null;
        divide = null;
        System.out.println("@AfterEach -> tearDown()");
    }

    @Test
    public void divideTest(){
        //Arrance
        int expected = 10;
        int actual;

        Mockito.when(validaterDateCalculator.check(50)).thenReturn(true);
        Mockito.when(validaterDateCalculator.check(5)).thenReturn(true);
        Mockito.when(validaterDateCalculator.checkZero(50)).thenReturn(true);
        Mockito.when(validaterDateCalculator.checkZero(5)).thenReturn(true);

        //Action
        actual = divide.divide(50,5);

        //aassert
        assertEquals(expected, actual);

        Mockito.verify(validaterDateCalculator).check(50);
        Mockito.verify(validaterDateCalculator).check(5);
        Mockito.verify(validaterDateCalculator).check(50);
        Mockito.verify(validaterDateCalculator).checkZero(5);
    }
    @Test
    public void divideStringTest(){
        //Arrance
        int expected = 0;
        int actual;

        Mockito.when(validaterDateCalculator.check(50)).thenReturn(true);
        Mockito.when(validaterDateCalculator.checkZero("0")).thenReturn(true);
        Mockito.when(validaterDateCalculator.checkZero(50)).thenReturn(true);
        Mockito.when(validaterDateCalculator.checkZero("0")).thenReturn(false);



        //Action
        actual = divide.divide(50,5);

        //aassert
        assertEquals(expected, actual);

        Mockito.verify(validaterDateCalculator).check(50);
        Mockito.verify(validaterDateCalculator).check("0");
        Mockito.verify(validaterDateCalculator).checkZero(50);
        Mockito.verify(validaterDateCalculator).checkZero("0");
    }

    @Test
    public void divideZeroTest(){
        //Arrance
        int expected = 0;
        int actual = 0;
        Exception exception = null;

        Mockito.when(validaterDateCalculator.check(50)).thenReturn(true);
        Mockito.when(validaterDateCalculator.check(0)).thenReturn(true);
        Mockito.when(validaterDateCalculator.checkZero(50)).thenReturn(true);
        Mockito.when(validaterDateCalculator.checkZero(0)).thenThrow(new ArithmeticException("No se puede dividir por Zero"));

        //Action
        try {
            actual = divide.divide(50,0);
        }catch (ArithmeticException e){
            exception = e;
        }


        //aassert
        assertEquals(expected, actual);
        assertNotNull(exception);

        Mockito.verify(validaterDateCalculator).check(50);
        Mockito.verify(validaterDateCalculator).check(0);
        Mockito.verify(validaterDateCalculator).checkZero(50);
        Mockito.verify(validaterDateCalculator).checkZero(0);
    }
}