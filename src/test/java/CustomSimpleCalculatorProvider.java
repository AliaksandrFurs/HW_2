import com.it_academy.practice.junit_basics.Calculator;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.stream.Stream;

public class CustomSimpleCalculatorProvider implements ArgumentsProvider {

    // комбинаций тестов с граничными значениями по трём точкам можно запилимть много
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(new Calculator(0, 0), new float[] {0,0,0,0, 0, 1} ),
                Arguments.of(new Calculator(1, 1), new float[] {0,2,1,1,1, 1} ),
                Arguments.of(new Calculator(-1, -1), new float[] {0,-2,1,1, Float.NaN, -1}),
                Arguments.of(new Calculator(1, -1), new float[] {2,0,-1,-1, 1, 1}),
                Arguments.of(new Calculator(-1, 1), new float[] {-2,0,-1,-1, Float.NaN, -1}),
                Arguments.of(new Calculator(Integer.MAX_VALUE, Integer.MAX_VALUE), new float[] {0,-2,1,1, ((float) 46340.95), Float.POSITIVE_INFINITY}),
                Arguments.of(new Calculator(Integer.MIN_VALUE, Integer.MIN_VALUE), new float[] {0,0,1,0, Float.NaN, 0}),
                Arguments.of(new Calculator(Integer.MAX_VALUE, Integer.MIN_VALUE), new float[] {-1,-1,0,0, ((float) 46340.95), 0}),
                Arguments.of(new Calculator(Integer.MIN_VALUE, Integer.MIN_VALUE), new float[] {0,0,1,0, Float.NaN, 0}),
                Arguments.of(new Calculator(0, Integer.MIN_VALUE), new float[] {Integer.MAX_VALUE,Integer.MIN_VALUE,0,0, 0, Float.POSITIVE_INFINITY}),
                Arguments.of(new Calculator(Integer.MIN_VALUE, 0), new float[] {Integer.MIN_VALUE,Integer.MIN_VALUE,0,0, 0, Float.POSITIVE_INFINITY}),
                Arguments.of(new Calculator(0, Integer.MAX_VALUE), new float[] {Integer.MAX_VALUE,Integer.MIN_VALUE,0,0, 0, Float.POSITIVE_INFINITY}),
                Arguments.of(new Calculator(Integer.MAX_VALUE, 0), new float[] {Integer.MAX_VALUE,Integer.MIN_VALUE,0,0, 0, Float.POSITIVE_INFINITY}),
                Arguments.of(new Calculator(Integer.MAX_VALUE, 1), new float[] {Integer.MAX_VALUE,Integer.MIN_VALUE,0,0, 0, Float.POSITIVE_INFINITY}),
                Arguments.of(new Calculator(1, Integer.MAX_VALUE), new float[] {Integer.MAX_VALUE,Integer.MIN_VALUE,0,0, 0, Float.POSITIVE_INFINITY}),
                Arguments.of(new Calculator(1, Integer.MIN_VALUE), new float[] {Integer.MAX_VALUE,Integer.MIN_VALUE,0,0, 0, Float.POSITIVE_INFINITY}),
                Arguments.of(new Calculator(Integer.MIN_VALUE, 1), new float[] {Integer.MAX_VALUE,Integer.MIN_VALUE,0,0, 0, Float.POSITIVE_INFINITY}),
                Arguments.of(new Calculator(Integer.MIN_VALUE, -1), new float[] {Integer.MAX_VALUE,Integer.MIN_VALUE,0,0, 0, Float.POSITIVE_INFINITY}),
                Arguments.of(new Calculator(-1, Integer.MIN_VALUE), new float[] {Integer.MAX_VALUE,Integer.MIN_VALUE,0,0, 0, Float.POSITIVE_INFINITY}),
                Arguments.of(new Calculator(0, Integer.MIN_VALUE - 1), new float[] {Integer.MAX_VALUE,Integer.MIN_VALUE,0,0, 0, Float.POSITIVE_INFINITY}),
                Arguments.of(new Calculator(0, Integer.MIN_VALUE + 1), new float[] {Integer.MAX_VALUE,Integer.MIN_VALUE,0,0, 0, Float.POSITIVE_INFINITY}),
                Arguments.of(new Calculator(Integer.MIN_VALUE - 1, 0), new float[] {Integer.MAX_VALUE,Integer.MIN_VALUE,0,0, 0, Float.POSITIVE_INFINITY}),
                Arguments.of(new Calculator(Integer.MIN_VALUE + 1, 0), new float[] {Integer.MAX_VALUE,Integer.MIN_VALUE,0,0, 0, Float.POSITIVE_INFINITY})

        );
    }
}
