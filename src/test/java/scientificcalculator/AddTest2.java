package scientificcalculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import scientificcalculator.util.ValidaterDateCalculator;

import static org.junit.jupiter.api.Assertions.*;

class AddTest2 {
    @InjectMocks
    private Add add;
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
        //assertEquals(expected, actual);
        Mockito.verify(validaterDateCalculator).check(3);
        Mockito.verify(validaterDateCalculator).check(2);
        System.out.println(" @Test -> subtractAssertTest()");
    }

    @Test
    public void addAnswerTest(){
        //1.Arrange or setUp
        int expected = 5;
        int actual;

        Answer<Boolean> answer = new Answer<Boolean>() {
            @Override
            public Boolean answer(InvocationOnMock invocationOnMock) throws Throwable {
                return true;
            }
        };
        Mockito.when(validaterDateCalculator.check(3)).thenAnswer(answer);

        //2.Act
        actual =  add.add(3,2);
        //3.Assert
        assertEquals(expected, actual);
        Mockito.verify(validaterDateCalculator).check(3);
        Mockito.verify(validaterDateCalculator).check(2);
    }

}