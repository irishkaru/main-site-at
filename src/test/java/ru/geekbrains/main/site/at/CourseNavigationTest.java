package ru.geekbrains.main.site.at;

import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.geekbrains.main.site.at.base.BaseTest;
import ru.geekbrains.main.site.at.pages.AuthorizationPage;

import java.util.concurrent.TimeUnit;

public class CourseNavigationTest extends BaseTest {

    //Переходим на страницу авторизации
    @BeforeEach
    public void openSite() {
        driver.get(BASE_URL + "/login");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Description("Тестирование страницы курсы на сайте https://geekbrains.ru")
    @Test
    public void authorizationTest() {

        AuthorizationPage authorizationPage = new AuthorizationPage(driver);

        authorizationPage.inputEmail("hao17583@bcaoo.com")
                .inputPassword("hao17583")
                .clickLoginSubmitButton()
                .checkHeader()
        .clickButtonSidebar()//не знаю как убрать
        .clickButtonCourses()
        .clickСoursesPageTabCourses()
        .clickCheckboxFree()
        .clickCheckboxTester()
        .checkVisibilityCourse("Тестирование ПО. Уровень 1");
    }


}
