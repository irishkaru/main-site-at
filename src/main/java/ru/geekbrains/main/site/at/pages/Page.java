package ru.geekbrains.main.site.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Page extends BasePage {

    @FindBy(className = "gb-header__title")
    private WebElement pageHeader;

    @FindBy(css = ".search-panel__search-field")
    private WebElement searchBox;

    @FindBy(css = "ul.search-page-tabs > li > a[data-tab]")
    private List<WebElement> searchPageTabs;

    @FindBy(css = "ul.search-page-tabs > li > a > span")
    private List<WebElement> searchPageTabsSpan;

    @FindBy(css = "ul.search-page-tabs > li > a[data-tab='professions'] > span")
    private WebElement searchPageTabProfessions;

    @FindBy(css = "ul.search-page-tabs > li > a[data-tab='courses'] > span")
    private WebElement searchPageTabCourses;

    @FindBy(css = "ul.search-page-tabs > li > a[data-tab='webinars'] > span")
    private WebElement searchPageTabWebinars;

    @FindBy(css = "ul.search-page-tabs > li > a[data-tab='blogs'] > span")
    private WebElement searchPageTabBlogs;

    @FindBy(css = "ul.search-page-tabs > li > a[data-tab='forums'] > span")
    private WebElement searchPageTabForums;

    @FindBy(css = "ul.search-page-tabs > li > a[data-tab='tests'] > span")
    private WebElement searchPageTabTests;

    private WebElement searchPageTabValue;

    @FindBy(css = "div button svg[class=\"svg-icon icon-popup-close-button \"]")
    private WebElement buttonPopUpClosed;

    private NavigationTab navigationTab;

    public Page(WebDriver driver) {
        super(driver);
        navigationTab = new NavigationTab(driver);

    }

    public NavigationTab getNavigationTab() {
        return navigationTab;
    }

    public void searchPageTabValue(String searchPageTab) {
        switch (searchPageTab) {
            case "professions": {
                searchPageTabValue = searchPageTabProfessions;
                break;
            }
            case "courses": {
                searchPageTabValue = searchPageTabCourses;
                break;
            }
            case "webinars": {
                searchPageTabValue = searchPageTabWebinars;
                break;
            }
            case "blogs": {
                searchPageTabValue = searchPageTabBlogs;
                break;
            }
            case "forums": {
                searchPageTabValue = searchPageTabForums;
                break;
            }
            case "tests": {
                searchPageTabValue = searchPageTabTests;
                break;
            }
            default: {
                throw new NotFoundException("Element not found" + searchPageTab);
            }
        }
    }

    public Page checkHeader(String expected) {
        assertEquals(expected, pageHeader.getText());
        return this;
    }

    public Page checkVisibilityTab(String searchPageTab) {
        boolean visible = false;

        for (WebElement webElement : searchPageTabs) {
            if (webElement.getAttribute("data-tab").contentEquals(searchPageTab)
                    && webElement.isDisplayed()) {
                visible = true;
                break;
            }
        }
        assertTrue(visible);
        searchPageTabValue(searchPageTab);
        return this;
    }

    public Page searchText(String searchText) {
        searchBox.sendKeys(searchText);

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.search-page-tabs")));
        return this;
    }

    public Page checkGreaterThan(int number) {
        int searchPageTabCount = Integer.parseInt(searchPageTabValue.getText());
        assertThat(searchPageTabCount, greaterThan(number));
        return this;
    }

    public Page checkGreaterThanOrEqual(int number) {
        int searchPageTabCount = Integer.parseInt(searchPageTabValue.getText());
        assertThat(searchPageTabCount, greaterThanOrEqualTo(number));
        return this;
    }

    public Page checkLessThan(int number) {
        int searchPageTabCount = Integer.parseInt(searchPageTabValue.getText());
        assertThat(searchPageTabCount, lessThan(number));
        return this;
    }

    public Page checkInterval(int lowerNumber, int largerNumber) {
        int searchPageTabCount = Integer.parseInt(searchPageTabValue.getText());
        assertThat(searchPageTabCount, allOf(
                greaterThan(lowerNumber),
                lessThan(largerNumber)));
        return this;
    }

    public Page checkNotNumber(int number) {
        int searchPageTabCount = Integer.parseInt(searchPageTabValue.getText());
        assertThat(searchPageTabCount, not(number));
        return this;
    }

}
