package ru.geekbrains.main.site.at;

import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import ru.geekbrains.main.site.at.base.BaseTest;
import ru.geekbrains.main.site.at.pages.NavigationTab;

import java.util.stream.Stream;

@Execution(value = ExecutionMode.CONCURRENT)
public class NavigationTest extends BaseTest {

    @BeforeEach
    public void openSite() {
        driver.get(BASE_URL + "/career");
    }

    @Description("Тест проверяет навигацию по кнопкам бокового меню сайта https://geekbrains.ru")
    @ParameterizedTest
    @DisplayName("check navigation items")
    @MethodSource("pageGenerator")
    public void navigationPanelTest(String buttonTitle) {
        new NavigationTab(driver)
                .clickButton(buttonTitle)
                .checkHeader(buttonTitle);
    }

    public static Stream<String> pageGenerator() {
        return Stream.of("Карьера", "Курсы", "Вебинары", "Форум", "Блог", "Тесты");
    }

}
