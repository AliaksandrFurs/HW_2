import com.it_academy.practice.junit_basics.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import static org.junit.jupiter.api.Assertions.*;

public class OperationsTest {

    @BeforeAll
    public static void testBeforeClass() {
        System.out.println("All tests starts");
    }

    @BeforeEach
    public void testBeforeMethod() {
        System.out.println("Test starts");
    }

    @AfterEach
    public void testAfterEachMethod () {
        System.out.println("Test ends");
    }

    @AfterAll
    public static void testAfterAll () {
        System.out.println("Tests ends");
    }


    @ParameterizedTest(name = "#{index} - Run test with args={0}")
    @DisplayName("Minus operation")
    @ArgumentsSource(CustomCalculatorProvider.class)
    void testMinusOperation(Calculator calculator, float [] result) {
        System.out.println("Value A: "+ calculator.getA() + " Value B: " + calculator.getB());
        assertEquals(result[0], calculator.calculate('-'));
    }

    @ParameterizedTest (name = "#{index} - Run test with args={0}")
    @ArgumentsSource(CustomCalculatorProvider.class)
    @DisplayName("Plus operation")
    void testPlusOperation(Calculator calculator, float [] result) {
        System.out.println("Value A: "+ calculator.getA() + " Value B: " + calculator.getB());
        assertEquals(result[1], calculator.calculate('+'));
    }

    @ParameterizedTest (name = "#{index} - Run test with args={0}")
    @ArgumentsSource(CustomCalculatorProvider.class)
    @DisplayName("Multiply operation")
    void testMultiplyOperation(Calculator calculator, float [] result) {
        System.out.println("Value A: "+ calculator.getA() + " Value B: " + calculator.getB());
        assertEquals(result[3], calculator.calculate('*'));
    }
    @ParameterizedTest (name = "#{index} - Run test with args={0}")
    @ArgumentsSource(CustomCalculatorProvider.class)
    @DisplayName("Divide operation")
    void testDivideOperation(Calculator calculator, float [] result) {
        System.out.println("Value A: "+ calculator.getA() + " Value B: " + calculator.getB());
        assertEquals(result[2], calculator.calculate('/'));
    }

    @ParameterizedTest
    @ArgumentsSource(CustomCalculatorProvider.class)
    @DisplayName("SQRT operation")
    void testSqrtOperation (Calculator calculator, float [] result) {
        System.out.println("Value A: "+ calculator.getA() + " Value B: " + calculator.getB());
        assertEquals(result[4], calculator.calculate('^'));
    }

    @ParameterizedTest
    @ArgumentsSource(CustomCalculatorProvider.class)
    @DisplayName("SQRT operation")
    void testRoundOperation (Calculator calculator, float [] result) {
        System.out.println("Value A: "+ calculator.getA() + " Value B: " + calculator.getB());
        assertEquals(result[5], calculator.calculate('#'));
    }

    @Test
    @DisplayName("Divide on zero")
    void testDivideOnZero(){
        assertThrows(ArithmeticException.class, () -> new Calculator(1,0).calculate('/'));
    }




}




