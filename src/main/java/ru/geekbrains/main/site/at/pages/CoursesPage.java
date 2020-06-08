package ru.geekbrains.main.site.at.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoursesPage extends BasePage {

    @FindBy(css = "a[href='#cour-new']")
    private WebElement coursesPageTabCourses;

    @FindBy(css = ".js-checkbox[value='free']")
    private WebElement checkboxFree;

    @FindBy(css = ".js-checkbox[value='tester']")
    private WebElement checkboxTester;

    @FindBy(css = "span.gb-course-card__title-text")
    private List<WebElement> coursesSelection;

    public CoursesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Нажатие на кнопку Курсы в шапке")
    public CoursesPage clickСoursesPageTabCourses() {
        coursesPageTabCourses.click();
        return this;
    }

    @Step("Ставим галочку в фильтре 'Бесплатные'")
    public CoursesPage clickCheckboxFree() {
        checkboxFree.click();
        return this;
    }

    @Step("Ставим галочку в фильтре 'Тестирование'")
    public CoursesPage clickCheckboxTester() {
        checkboxTester.click();
        return this;
    }

    @Step("Проверка наличия курса {expected}")
    public CoursesPage checkVisibilityCourse(String expected) {
        boolean visible = false;

        for (WebElement webElement : coursesSelection) {
           // System.out.println(webElement.getText());
            if (webElement.getText().equals(expected)) {
                visible = true;
                break;
            }
        }
        assertTrue(visible);
        return this;
    }
}
