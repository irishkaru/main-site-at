package ru.geekbrains.main.site.at.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationPage extends BasePage {

    @FindBy(css = "div > input[type='submit']")
    private WebElement loginSubmitButton;

    @FindBy(css = "input[id='user_email']")
    private WebElement userEmailBox;

    @FindBy(css = "input[id='user_password']")
    private WebElement userPasswordBox;

    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввод email")
    public AuthorizationPage inputEmail(String userEmailText) {
        userEmailBox.sendKeys(userEmailText);

        return this;
    }

    @Step("Ввод пароля")
    public AuthorizationPage inputPassword(String userPasswordText) {
        userPasswordBox.sendKeys(userPasswordText);

        return this;
    }

    @Step("Нажатие кнопки 'Войти'")
    public HomePage clickLoginSubmitButton() {
        loginSubmitButton.click();
        return new HomePage(driver);
    }

}
