package ru.geekbrains.main.site.at.junit;

import static org.junit.jupiter.api.Assertions.assertTrue; //что бы везде ниже не писать Assertions.assertTrue
import static java.lang.Thread.sleep;
import org.junit.jupiter.api.*;
import java.util.Random;

public class AnnotationExampleTest {

    @Disabled //чтобы пропустить test01
    @Test
    public void test01() {
        assertTrue(true);
    }

    @DisplayName("Проверка истинности истинного") //имена тестам
    @Test
    public void test02() {
        assertTrue(true);
    }

    @Disabled
    @RepeatedTest(100) //повторить тест 100 раз
    @Test
    public void test03() {
        int x = new Random().nextInt(100);
        assertTrue(x>50);
    }

    @Timeout(2) //упади через секунду
    @Test
    public void test04() throws InterruptedException{
        sleep(1100);
        assertTrue(true);
    }

}
