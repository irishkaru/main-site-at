package ru.geekbrains.main.site.at.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

@Disabled
public class ParametrizedExampleTest {

    @ParameterizedTest
    @ValueSource(strings = {"Courses", "Tests"})
    public void test01(String title) {
        assertNotNull(title);

    }

    @ParameterizedTest
    @MethodSource("stringGenerator") //метод должен быть public static
    public void test02(String title) {
        assertNotNull(title);

    }

    public static Stream<String> stringGenerator() {
        return Stream.of("Courses", "Tests", "Blogs");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test03_data_source.csv", numLinesToSkip = 1)
    public void test03(int a, int b, int result) {
        assertEquals(result, a + b);

    }

    @ParameterizedTest
    @MethodSource("argumentsStream")
    public void test04(int a, int b, int result) {
        assertEquals(result, a + b);

    }

    public static Stream<Arguments> argumentsStream() {
        return Stream.of(
                Arguments.of(-100, 100, 0),
                Arguments.of(0, 0, 0),
                Arguments.of(-1, -1, -2),
                Arguments.of(100, 100, 200)
        );
    }
}
