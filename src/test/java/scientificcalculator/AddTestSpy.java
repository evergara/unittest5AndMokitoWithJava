package scientificcalculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import scientificcalculator.util.PrintMessage;
import scientificcalculator.util.ValidaterDateCalculator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddTestSpy {
    @InjectMocks
    private Add add;
    @Mock
    private ValidaterDateCalculator validaterDateCalculator;
    @Mock
    private PrintMessage printMessage;

    @Captor
    private ArgumentCaptor<Integer> captor;

    @Spy
    List<String> spies = new ArrayList<>();
    @Spy
    List<String> mocks = new ArrayList<>();

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        System.out.println("@BeforeEach -> setUp()");
    }

    @AfterEach
    public void tearDown(){
        validaterDateCalculator = null;
        add = null;
        printMessage = null;
        System.out.println("@AfterEach -> tearDown()");
    }

    @Test
    public void addTest(){
        spies.add("1");
        spies.add("3");
        BDDMockito.verify(spies).add("1");
        BDDMockito.verify(spies).add("3");

        assertEquals(2,spies.size());

    }

    @Test
    public void addMockTest(){
        mocks.add("1");
        mocks.add("3");
        BDDMockito.verify(mocks).add("1");
        BDDMockito.verify(mocks).add("3");
        System.out.println(mocks.size());
        assertEquals(2,mocks.size());
    }

    @Test
    public void addMock2Test(){
        mocks.add("1");
        mocks.add("3");
        BDDMockito.verify(mocks).add("1");
        BDDMockito.verify(mocks).add("3");
        BDDMockito.given(mocks.size()).willReturn(2);
        System.out.println(mocks.size());

        assertEquals(2,mocks.size());
    }

}