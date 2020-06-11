package ru.geekbrains.examples.junit;

import org.junit.jupiter.api.*;

@Disabled
public class BeforeAfterExampleTest extends BaseExampleTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Child class before all");

    }

    @BeforeEach
    void setUp() {
        System.out.println("Child class before each");
    }

    @Test
    public void test01(){
        System.out.println("test01");
    }

    @Test
    public void test02(){
        System.out.println("test02");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Child class after all");

    }

    @AfterEach
    void tearDown() {
        System.out.println("Child class after each");
    }
}
