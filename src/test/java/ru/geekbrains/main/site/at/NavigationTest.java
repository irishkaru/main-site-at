package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

@Disabled
public class NavigationTest extends BaseTest {
    String header;
    String footer;

    @Test
    void navigationPanelTestCareer() {

        driver.get(BASE_URL + "/career");

        //Кнопка карьера
        WebElement careerNavItemButton = driver
                .findElement(By.cssSelector("nav > a[href='/career']"));
        careerNavItemButton.click();

        header = driver.findElement(By.className("gb-header__title")).getText();
        Assertions.assertEquals("Карьера", header);

        footer = driver.findElement(By.cssSelector("div > a[href='/feedbacks']")).getText();
        Assertions.assertEquals("Отзывы", footer);

    }

    @Test
    void navigationPanelTestCourses() {

        driver.get(BASE_URL + "/career");

        //Кнопка Курсы
        WebElement coursesNavItemButton = driver
                .findElement(By.cssSelector("nav > a[href='/courses']"));
        coursesNavItemButton.click();


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Закрываем баннер
        driver.findElement(By.xpath("//div/div/button[*]")).click();

        header = driver.findElement(By.className("gb-header__title")).getText();
        Assertions.assertEquals("Курсы", header);

        footer = driver.findElement(By.cssSelector("div > a[href='/feedbacks']")).getText();
        Assertions.assertEquals("Отзывы", footer);

    }

    @Test
    void navigationPanelTestEvents() {

        driver.get(BASE_URL + "/career");

        //Кнопка Вебинары
        WebElement eventsNavItemButton = driver
                .findElement(By.cssSelector("nav > a[href='/events']"));
        eventsNavItemButton.click();

        header = driver.findElement(By.className("gb-header__title")).getText();
        Assertions.assertEquals("Вебинары", header);

        footer = driver.findElement(By.cssSelector("div > a[href='/feedbacks']")).getText();
        Assertions.assertEquals("Отзывы", footer);

    }

    @Test
    void navigationPanelTestTopics() {

        driver.get(BASE_URL + "/career");

        //Кнопка Форум
        WebElement topicsNavItemButton = driver
                .findElement(By.cssSelector("nav > a[href='/topics']"));
        topicsNavItemButton.click();

        header = driver.findElement(By.className("gb-header__title")).getText();
        Assertions.assertEquals("Форум", header);

        footer = driver.findElement(By.cssSelector("div > a[href='/feedbacks']")).getText();
        Assertions.assertEquals("Отзывы", footer);

    }

    @Test
    void navigationPanelTestPosts() {

        driver.get(BASE_URL + "/career");

        //Кнопка Блог
        WebElement postsNavItemButton = driver
                .findElement(By.cssSelector("nav > a[href='/posts']"));
        postsNavItemButton.click();

        header = driver.findElement(By.className("gb-header__title")).getText();
        Assertions.assertEquals("Блог", header);

        footer = driver.findElement(By.cssSelector("div > a[href='/feedbacks']")).getText();
        Assertions.assertEquals("Отзывы", footer);

    }

    @Test
    void navigationPanelTestTests() {

        driver.get(BASE_URL + "/career");

        //Кнопка Тесты
        WebElement testsNavItemButton = driver
                .findElement(By.cssSelector("nav > a[href='/tests']"));
        testsNavItemButton.click();

        header = driver.findElement(By.className("gb-header__title")).getText();
        Assertions.assertEquals("Тесты", header);

        footer = driver.findElement(By.cssSelector("div > a[href='/feedbacks']")).getText();
        Assertions.assertEquals("Отзывы", footer);

    }

}
