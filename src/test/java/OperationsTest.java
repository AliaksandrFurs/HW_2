import com.it_academy.practice.junit_basics.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import static org.junit.jupiter.api.Assertions.*;

public class OperationsTest {

    @BeforeAll
    public static void testBeforeClass() {
        System.out.println("Run starts");
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
        System.out.println("Run ends");
    }


    @ParameterizedTest(name = "#{index} - Run test with args={0}")
    @DisplayName("Minus operation")
    @ArgumentsSource(CustomSimpleCalculatorProvider.class)
    void testMinusOperation(Calculator calculator, float [] result) {
        System.out.println("Value A: "+ calculator.getA() + " Value B: " + calculator.getB());
        assertEquals(result[0], calculator.calculate('-'));
    }

    @ParameterizedTest (name = "#{index} - Run test with args={0}")
    @ArgumentsSource(CustomSimpleCalculatorProvider.class)
    @DisplayName("Plus operation")
    void testPlusOperation(Calculator calculator, float [] result) {
        System.out.println("Value A: "+ calculator.getA() + " Value B: " + calculator.getB());
        assertEquals(result[1], calculator.calculate('+'));
    }

    @ParameterizedTest (name = "#{index} - Run test with args={0}")
    @ArgumentsSource(CustomSimpleCalculatorProvider.class)
    @DisplayName("Multiply operation")
    void testMultiplyOperation(Calculator calculator, float [] result) {
        System.out.println("Value A: "+ calculator.getA() + " Value B: " + calculator.getB());
        assertEquals(result[3], calculator.calculate('*'));
    }
    @ParameterizedTest (name = "#{index} - Run test with args={0}")
    @ArgumentsSource(CustomSimpleCalculatorProvider.class)
    @DisplayName("Divide operation")
    void testDivideOperation(Calculator calculator, float [] result) {
        System.out.println("Value A: "+ calculator.getA() + " Value B: " + calculator.getB());
        assertEquals(result[2], calculator.calculate('/'));
    }

    @ParameterizedTest
    @ArgumentsSource(CustomSimpleCalculatorProvider.class)
    @DisplayName("SQRT operation")
    void testSqrtOperation (Calculator calculator, float [] result) {
        System.out.println("Value A: "+ calculator.getA() + " Value B: " + calculator.getB());
        assertEquals(result[4], calculator.calculate('^'));
    }

    @ParameterizedTest
    @ArgumentsSource(CustomSimpleCalculatorProvider.class)
    @DisplayName("Round operation")
    void testRoundOperation (Calculator calculator, float [] result) {
        System.out.println("Value A: "+ calculator.getA() + " Value B: " + calculator.getB());
        assertEquals(result[5], calculator.calculate('#'));
    }

    @Test
    @DisplayName("Divide on zero")
    void testDivideOnZeroWithoutTryCatch(){
        assertThrows(ArithmeticException.class, () -> new Calculator(1,0).calculate('/'));
    }

    @Test
    @DisplayName("Divide on zero")
    void testDivideOnZero(){
        Calculator calculator = new Calculator(1,0);
        float result = calculator.calculate('/');
        String error = calculator.getStrError();
        assertEquals("Divide by zero!", error);
    }

    @ParameterizedTest
    @ArgumentsSource(CustomArrayCalculatorProvider.class)
    @DisplayName("Test with multi minus parameters")
    void testCalcVarMinus(int [] arguments, int [] arrayResults){
        assertEquals(arrayResults[0], Calculator.calcVar('-', arguments));
    }

    @ParameterizedTest
    @ArgumentsSource(CustomArrayCalculatorProvider.class)
    @DisplayName("Test with multi plus parameters")
    void testCalcVarPlus(int [] arguments, int [] arrayResults){
        assertEquals(arrayResults[1], Calculator.calcVar('+', arguments));
    }

    @ParameterizedTest
    @ArgumentsSource(CustomArrayCalculatorProvider.class)
    @DisplayName("Test with multi divide parameters")
    void testCalcVarDivide(int [] arguments, int [] arrayResults){
        assertEquals(arrayResults[2], Calculator.calcVar('/', arguments));
    }

    @ParameterizedTest
    @ArgumentsSource(CustomArrayCalculatorProvider.class)
    @DisplayName("Test with multi divide parameters")
    void testCalcVarMultiply(int [] arguments, int [] arrayResults){
        assertEquals(arrayResults[3], Calculator.calcVar('*', arguments));
    }
}




