package GeekBrians.Slava_5655380.Homework.Lesson14.Task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ClassTest {
    @ParameterizedTest
    @MethodSource("classMethodRegularOperations")
    public void classMethodValuesTest(int[] arr, boolean result) {
        Assertions.assertEquals(Class.method(arr), result);
    }

    public static Stream<Arguments> classMethodRegularOperations() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 1, 1, 4, 4, 1, 4, 4}, true));
        out.add(Arguments.arguments(new int[]{1, 1, 1, 1, 1, 1}, false));
        out.add(Arguments.arguments(new int[]{4, 4, 4, 4}, false));
        out.add(Arguments.arguments(new int[]{1, 4, 4, 1, 1, 4, 3}, false));
        return out.stream();
    }
}