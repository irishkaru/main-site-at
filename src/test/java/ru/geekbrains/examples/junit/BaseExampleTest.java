package ru.geekbrains.examples.junit;

import org.junit.jupiter.api.*;

@Disabled
public class BaseExampleTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Base class before all");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Base class before each");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Base class after all");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Base class after each");
    }
}

