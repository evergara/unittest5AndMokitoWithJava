package calculator;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;
    private static Calculator staticCalculator;
    @BeforeAll
    public static void  beforeAllSetUp(){
        staticCalculator = new Calculator();
        System.out.println("@BeforeAll -> beforeAllSetUp()");
    }
    @AfterAll
    public static void tearDownAfterAll(){
        staticCalculator = null;
        System.out.println("@AfterAll -> tearDownAfterAll()");
    }

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
        System.out.println("@BeforeEach -> setUp()");
    }

    @AfterEach
    public void tearDown(){
        calculator = null;
        System.out.println("@AfterEach -> tearDown()");
    }

    @Test
    public void calculatorNotNullTest(){
        assertNotNull(calculator, "Calculator debe estar Instanciado y no ser Null");
        System.out.println(" @Test -> calculatorNotNullTest()");
    }

    @Test
    public void addAssertTest(){
        //1.Arrange or setUp
        int expected = 10;
        int actual;
        //2.Act
        actual = calculator.add(7,3);
        //3.Assert
        assertEquals(expected,actual);
        System.out.println(" @Test -> addAssertTest()");
    }

    @Test
    public void addAssertTestOnLinea(){
        assertEquals(25, calculator.add(15, 10));
        System.out.println(" @Test -> addAssertTestOnLinea()");
    }
    @Test
    public void subtractAssertTest(){
        //1.Arrange or setUp
        int expected = 20;
        int actual;
        //2.Act
        actual = calculator.subtract(50,30);
        //3.Assert
        assertEquals(expected,actual);
        System.out.println(" @Test -> subtractAssertTest()");
    }

    @Test
    public void multiplyAssertTestOnLinea(){
        assertEquals(50, calculator.multiply(5, 10));
        System.out.println(" @Test -> multiplyAssertTestOnLinea()");
    }

    @Test
    public void divideAssertTestOnLinea(){
        assertEquals(50, calculator.divide(500, 10));
        System.out.println(" @Test -> divideAssertTestOnLinea()");
    }
    @Test
    public void divideAssertEqualZeroTestOnLinea(){
        assertEquals(0, calculator.divide(500, 0));
        System.out.println(" @Test -> divideAssertEqualZeroTestOnLinea()");
    }

    @Test
    @DisplayName("Method divideByzero")
    public void divideByZeroAssertArithmeticException(){
       // fail("FAllo manual, \"No se puede dividir entre cero\"");
        assertThrows(ArithmeticException.class, ()->calculator.divideByZero(500, 0), "No se puede dividir entre cero");
        System.out.println(" @Test -> divideByZeroAssertArithmeticException()");
    }

    @Disabled("Disable unit bug 23 be resolved")
    @Test
    public void divideByZeroAssertArithmeticException2(){
        fail("FAllo manual, \"No se puede dividir entre cero\"");
        System.out.println(" @Test -> divideByZeroAssertArithmeticException2()");
    }

    @Nested
    class AddTest{
        @Test
        public void addNegativeTest(){
            assertEquals(-30, calculator.add(-15, -15));
        }

        @Test
        public void addZeroTest(){
            assertEquals(0, calculator.add(-1, 1));
        }

        @Test
        public void addPositiveTest(){
            assertEquals(50, calculator.add(25, 25));
        }
    }

    @Nested
    class AddTestUseBeforeAllSetUp{
        @Test
        public void addNegativeTest(){
            assertEquals(-30, staticCalculator.add(-15, -15));
        }

        @Test
        public void addZeroTest(){
            assertEquals(0, staticCalculator.add(-1, 1));
        }

        @Test
        public void addPositiveTest(){
            assertEquals(50, staticCalculator.add(25, 25));
        }
    }

}