package GeekBrians.Slava_5655380.Homework.Lesson14.Task1;

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
    public void classMethodValuesTest(int[] arr, int[] resArr) {
        Assertions.assertArrayEquals(Class.method(arr), resArr);
    }

    @ParameterizedTest
    @MethodSource("classMethodExceptionalOperations")
    public void classMethodExceptionsTest(int[] arr) {
        Assertions.assertThrows(RuntimeException.class, () -> {
            Class.method(arr);
        });
    }

    public static Stream<Arguments> classMethodRegularOperations() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}));
        out.add(Arguments.arguments(new int[]{4, 1, 2, 3, 3, 5, 6, 7}, new int[]{1, 2, 3, 3, 5, 6, 7}));
        out.add(Arguments.arguments(new int[]{1, 1, 1, 1, 1, 1, 4}, new int[]{}));
        out.add(Arguments.arguments(new int[]{4, 4, 4, 4, 4, 4, 4, 4}, new int[]{}));
        return out.stream();
    }

    public static Stream<Arguments> classMethodExceptionalOperations() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 1, 1, 1, 1, 1}));
        out.add(Arguments.arguments(new int[]{}));
        return out.stream();
    }
}
