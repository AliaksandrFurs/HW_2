import com.it_academy.practice.junit_basics.Calculator;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class CustomArrayCalculatorProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
            Arguments.of(new int [] {-1,0,1}, new int[] {-2,0,0,0}),
            Arguments.of(new int [] {Integer.MAX_VALUE,0, Integer.MIN_VALUE}, new int[] {-1,-1,0,0}),
            Arguments.of(new int [] {Integer.MAX_VALUE-1,1, Integer.MIN_VALUE-1, -1}, new int[] {-1,-3,0,Integer.MAX_VALUE})
        );
    }
}
