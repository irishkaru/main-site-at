package ru.geekbrains.main.site.at.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Sidebar extends BasePage{

    //кнопки бокового меню
    @FindBy(css = "nav > a[href='/career'")
    private WebElement careerButton;

    @FindBy(css = "nav > a[href='/courses'")
    private WebElement coursesButton;

    @FindBy(css = "nav > a[href='/events'")
    private WebElement eventsButton;

    @FindBy(css = "nav > a[href='/topics'")
    private WebElement topicsButton;

    @FindBy(css = "nav > a[href='/posts'")
    private WebElement postsButton;

    @FindBy(css = "nav > a[href='/tests'")
    private WebElement testsButton;

    public Sidebar(WebDriver driver) {
        super(driver);
    }

    @Step("Нажатие кнопки Курсы")
    public CoursesPage clickButtonCourses() {
        coursesButton.click();
        return new CoursesPage(driver);
    }

}
