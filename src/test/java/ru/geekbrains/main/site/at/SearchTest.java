package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.geekbrains.main.site.at.base.BaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SearchTest extends BaseTest {

    private static String selector(String dataTab) {
        String selector = "ul.search-page-tabs > li > a[data-tab='" + dataTab + "']";

        return selector;
    }

    public void searchJavaTest() {

        driver.get(BASE_URL + "/courses");

//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//        // Закрываем баннер
//        driver.findElement(By.xpath("//div/div/button[*]")).click();

        //Поиск
        WebElement searchButton = driver.findElement(By.cssSelector("ul > li > .show-search-form"));
        searchButton.click();

        WebElement searchInput = driver.findElement(By.cssSelector(".search-panel__search-field"));
        searchInput.sendKeys("java");

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.search-page-tabs")));
    }

    @Test
    public void searchJavaTestProfessions() {
        searchJavaTest();

        // Профессии
        String professionsSelector = selector("professions");
        WebElement professionsTab = driver.findElement(By.cssSelector(professionsSelector));
        // Проверка на видимость
        assertTrue(professionsTab.isDisplayed());

        //не менее 2
        String professionsValue = driver.findElement(By.cssSelector(professionsSelector + " > span")).getText();
        int professionCount = Integer.parseInt(professionsValue);
        assertThat(professionCount, greaterThanOrEqualTo(2));

    }

    @Test
   public void searchJavaTestCourses() {

        searchJavaTest();

        //Курсы
        String coursesSelector = selector("courses");
        WebElement coursesTab = driver.findElement(By.cssSelector(coursesSelector));
        assertTrue(coursesTab.isDisplayed());

        //более 15
        String coursesValue = driver.findElement(By.cssSelector(coursesSelector + " > span")).getText();
        int coursesCount = Integer.parseInt(coursesValue);
        assertThat(coursesCount, greaterThan(15));

    }

    @Test
   public void searchJavaTestWebinars() {
        searchJavaTest();

        //Вебинары
        String webinarsSelector = selector("webinars");
        WebElement webinarsTab = driver.findElement(By.cssSelector(webinarsSelector));
        assertTrue(webinarsTab.isDisplayed());

        //больше 180, меньше 300
        String webinarsValue = driver.findElement(By.cssSelector(webinarsSelector + " > span")).getText();
        int webinarsCount = Integer.parseInt(webinarsValue);
        assertThat(webinarsCount, allOf(
                greaterThan(180),
                lessThan(300)));
    }

    @Test
   public void searchJavaTestBlogs() {
        searchJavaTest();

        //Блоги
        String blogsSelector = selector("blogs");
        WebElement blogsTab = driver.findElement(By.cssSelector(blogsSelector));
        assertTrue(blogsTab.isDisplayed());

        //более 300
        String blogsValue = driver.findElement(By.cssSelector(blogsSelector + " > span")).getText();
        int blogsCount = Integer.parseInt(blogsValue);
        assertThat(blogsCount, greaterThan(300));

    }

    @Test
   public void searchJavaTestForums() {

        searchJavaTest();

        //Форумы
        String forumsSelector = selector("forums");
        WebElement Tab = driver.findElement(By.cssSelector(forumsSelector));
        assertTrue(Tab.isDisplayed());

        //не 350
        String forumsValue = driver.findElement(By.cssSelector(forumsSelector + " > span")).getText();
        int forumsCount = Integer.parseInt(forumsValue);
        assertThat(forumsCount, not(350));

    }

    @Test
   public void searchJavaTestTests() {

        searchJavaTest();

        //Тесты
        String testsSelector = selector("tests");
        WebElement testsTab = driver.findElement(By.cssSelector(testsSelector));
        assertTrue(testsTab.isDisplayed());

        //не 0
        String testsValue = driver.findElement(By.cssSelector(testsSelector + " > span")).getText();
        int testsCount = Integer.parseInt(testsValue);
        assertThat(testsCount, not(0));
    }

}


