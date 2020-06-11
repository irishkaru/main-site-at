package ru.geekbrains.main.site.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationTab extends BasePage {

    //кнопки бокового меню
    @FindBy(css = "nav > a[href='/career'")
    private WebElement careerNavButton;

    @FindBy(css = "nav > a[href='/courses'")
    private WebElement coursesNavButton;

    @FindBy(css = "nav > a[href='/events'")
    private WebElement eventsNavButton;

    @FindBy(css = "nav > a[href='/topics'")
    private WebElement topicsNavButton;

    @FindBy(css = "nav > a[href='/posts'")
    private WebElement postsNavButton;

    @FindBy(css = "nav > a[href='/tests'")
    private WebElement testsNavButton;

    //кнопка поиска
    @FindBy(css = "ul > li > .show-search-form")
    private WebElement searchButton;

    //банер
     @FindBy(xpath = "//div/div/button[*]")
      private WebElement buttonPopUp;

    public NavigationTab(WebDriver driver) {
        super(driver);
    }

    public NavigationTab clickButtonPopUp() {
        buttonPopUp.click();
        return new NavigationTab(driver);
    }

    public Page clickButton(String buttonTitle) {

        switch (buttonTitle) {
            case "Карьера": {
                careerNavButton.click();
                break;
            }
            case "Курсы": {
                coursesNavButton.click();
                break;
            }
            case "Вебинары": {
                eventsNavButton.click();
                break;
            }
            case "Форум": {
                topicsNavButton.click();
                break;
            }
            case "Блог": {
                postsNavButton.click();
                break;
            }
            case "Тесты": {
                testsNavButton.click();
                break;
            }
            case "Поиск": {
                searchButton.click();
                break;
            }
            default: {
                throw new NotFoundException("Element not found" + buttonTitle);
            }
        }
        return new Page(driver);

    }


}
