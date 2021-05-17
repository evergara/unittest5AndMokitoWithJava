package scientificcalculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import scientificcalculator.util.PrintMessage;
import scientificcalculator.util.ValidaterDateCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddTest2 {
    @InjectMocks
    private Add add;
    @Mock
    private ValidaterDateCalculator validaterDateCalculator;
    @Mock
    private PrintMessage printMessage;

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
        //1.Arrange or setUp --> Given
        int expected = 5;
        int actual;

        Answer<Boolean> answer = new Answer<Boolean>() {
            @Override
            public Boolean answer(InvocationOnMock invocationOnMock) throws Throwable {
                return true;
            }
        };
        Mockito.when(validaterDateCalculator.check(3)).thenAnswer(answer);
        Mockito.when(validaterDateCalculator.check(2)).thenAnswer(answer);
        //2.Act --> When
        actual =  add.add(3,2);
        //3.Assert --> Then
        assertEquals(expected, actual);
        Mockito.verify(validaterDateCalculator).check(3);
        Mockito.verify(validaterDateCalculator).check(2);
    }


    @Test
    public void addAnswerWithAnyTest(){
        //1.Arrange or setUp --> Given
        int expected = 5;
        int actual;

        Answer<Boolean> answer = new Answer<Boolean>() {
            @Override
            public Boolean answer(InvocationOnMock invocationOnMock) throws Throwable {
                return true;
            }
        };
        Mockito.when(validaterDateCalculator.check(Mockito.anyInt())).thenAnswer(answer);
        //2.Act --> When
        actual =  add.add(3,2);
        //3.Assert --> Then
        assertEquals(expected, actual);

    }

    @Test
    public void addPrintTest(){
        //1.Arrange --> Given
        int expected = 9;
        int actual;
        String messageError = "Numero Invalido";
        BDDMockito.given(validaterDateCalculator.check(4)).willReturn(true);
        BDDMockito.given(validaterDateCalculator.check(5)).willReturn(true);
        //2.Act --> When
        add.addPrint(4,5);
        //3.Assert --> Then

        BDDMockito.verify(printMessage).showMessage(9);
        BDDMockito.verify(printMessage,BDDMockito.never()).showError(messageError);
        BDDMockito.verify(validaterDateCalculator).check(4);
        BDDMockito.verify(validaterDateCalculator).check(5);
        BDDMockito.verify(validaterDateCalculator, BDDMockito.times(1)).check(4);
        BDDMockito.verify(validaterDateCalculator, BDDMockito.times(1)).check(5);
        BDDMockito.verify(validaterDateCalculator, BDDMockito.never()).check(99);
        BDDMockito.verify(validaterDateCalculator, BDDMockito.atLeast(1)).check(4);
        BDDMockito.verify(validaterDateCalculator, BDDMockito.atMost(1)).check(4);
    }

}