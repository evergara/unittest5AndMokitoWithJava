package scientificcalculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import scientificcalculator.util.ValidaterDateCalculator;

import static org.junit.jupiter.api.Assertions.*;

class AddTest {
    private Add add;
    private ValidaterDateCalculator validaterDateCalculator;

    @BeforeEach
    public void setUp(){
        validaterDateCalculator = Mockito.mock(ValidaterDateCalculator.class);
        add = new Add(validaterDateCalculator);
        System.out.println("@BeforeEach -> setUp()");
    }

    @AfterEach
    public void tearDown(){
        validaterDateCalculator = null;
        add = null;
        System.out.println("@AfterEach -> tearDown()");
    }

    @Test
    public void addTest(){
        //1.Arrange or setUp
        int expected = 5;
        int actual;

        Mockito.when(validaterDateCalculator.check(3)).thenReturn(true);
        Mockito.when(validaterDateCalculator.check(2)).thenReturn(true);

        //2.Act
        actual =  add.add(3,2);
        //3.Assert
        assertEquals(expected, actual);
        Mockito.verify(validaterDateCalculator).check(3);
        Mockito.verify(validaterDateCalculator).check(2);
        System.out.println(" @Test -> subtractAssertTest()");
    }

    @Test
    public void addNegativeTest(){
        //1.Arrange or setUp
        int expected = -1;
        int actual;

        Mockito.when(validaterDateCalculator.check(-3)).thenReturn(true);
        Mockito.when(validaterDateCalculator.check(2)).thenReturn(true);

        //2.Act
        actual =  add.add(-3,2);
        //3.Assert
        assertEquals(expected, actual);
        Mockito.verify(validaterDateCalculator).check(-3);
        Mockito.verify(validaterDateCalculator).check(2);
        System.out.println(" @Test -> addTest()");
    }

    @Test
    public void addStringTest(){
        //1.Arrange or setUp
        int expected = 0;
        int actual;

        Mockito.when(validaterDateCalculator.check(-3)).thenReturn(true);
        Mockito.when(validaterDateCalculator.check("2")).thenReturn(false);

        //2.Act
        actual =  add.add(-3,"2");
        //3.Assert
        assertEquals(expected, actual);
        Mockito.verify(validaterDateCalculator).check(-3);
        Mockito.verify(validaterDateCalculator).check("2");
        System.out.println(" @Test -> addTest()");
    }

    @Test
    public void addRealMethodTest(){
        Mockito.when(validaterDateCalculator.check(3)).thenCallRealMethod();
        assertEquals(true, validaterDateCalculator.check(3));
    }

    @Test
    public void addRealMethod2Test(){
        Mockito.when(validaterDateCalculator.check(0)).thenCallRealMethod();
        assertEquals(false, validaterDateCalculator.check(0));
    }
}