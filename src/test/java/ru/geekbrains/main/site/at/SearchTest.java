package ru.geekbrains.main.site.at;

import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.geekbrains.main.site.at.base.BaseTest;
import ru.geekbrains.main.site.at.pages.NavigationTab;

import java.util.concurrent.TimeUnit;

public class SearchTest extends BaseTest {

    @BeforeEach
    public void openSite() {
        driver.get(BASE_URL + "/courses");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Description("Тест проверяет блоки поиска на сайте https://geekbrains.ru")
    @Test
    public void searchJavaTest() {

        String buttonTitle = "Поиск";

        NavigationTab navigationTab = new NavigationTab(driver);

        navigationTab.clickButtonPopUp()
                .clickButton(buttonTitle)
                .searchText("Java")
                .checkVisibilityTab("professions")
                .checkGreaterThanOrEqual(2)
                .checkVisibilityTab("courses")
                .checkGreaterThan(15)
                .checkVisibilityTab("webinars")
                .checkInterval(180, 300)
                .checkVisibilityTab("blogs")
                .checkGreaterThan(300)
                .checkVisibilityTab("forums")
                .checkNotNumber(350)
                .checkVisibilityTab("tests")
                .checkNotNumber(0);
    }

}


