package ru.geekbrains.main.site.at.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage extends BasePage {

    @FindBy(className = "gb-header__title")
    private WebElement pageHeader;

    @FindBy(className = "gb-header__title")
    private WebElement coursesNavButton;

    private NavigationTab navigationTab;

    public HomePage(WebDriver driver) {
        super(driver);
        navigationTab = new NavigationTab(driver);
    }

    @Step("Проверка открытия страницы")
    public HomePage checkHeader() {
        assertEquals("Главная", pageHeader.getText());
        return this;
    }

    @Step("Нажатие кнопки")
    public Sidebar clickButtonSidebar() {
        return new Sidebar(driver);
    }

}
