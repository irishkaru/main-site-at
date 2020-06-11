package ru.geekbrains.main.site.at;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class NavigationTest extends BaseTest {
    String header;
    String footer;

    @ParameterizedTest
    @MethodSource("pageAndNameGenerator") //метод должен быть public static
    public void navigationPanelTest(String pageLink, String pageTitle) {

        driver.get(BASE_URL + "/career");

        //Кнопка
        WebElement careerNavItemButton = driver
                .findElement(By.cssSelector("nav > a[href='/" + pageLink + "']"));
        careerNavItemButton.click();
        // для страницы Курсы
       if (pageLink == "courses") {
           driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

           //Закрываем баннер
           driver.findElement(By.xpath("//div/div/button[*]")).click();
       }

        header = driver.findElement(By.className("gb-header__title")).getText();
        assertEquals(pageTitle, header);

        footer = driver.findElement(By.cssSelector("div > a[href='/feedbacks']")).getText();
        assertEquals("Отзывы", footer);

    }

    public static Stream<Arguments> pageAndNameGenerator() {
        return Stream.of(
                Arguments.of("career", "Карьера"),
                Arguments.of("courses", "Курсы"),
                Arguments.of("events", "Вебинары"),
                Arguments.of("topics", "Форум"),
                Arguments.of("posts", "Блог"),
                Arguments.of("tests", "Тесты"));
    }

}
