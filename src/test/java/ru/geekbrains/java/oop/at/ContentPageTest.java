package ru.geekbrains.java.oop.at;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.java.oop.at.base.BaseTest;
import org.junit.jupiter.api.Test;
import ru.geekbrains.java.oop.at.page.ContentPage;

import java.util.stream.Stream;



@DisplayName("Проверка контента")
public class ContentPageTest extends BaseTest {
    private ContentPage contentPage;

    @DisplayName("Страница Курсы")
    @Test
    public void courses() {
        contentPage= new ContentPage(chromeDriver);
        String name = "Курсы";
        // кликаем сэндвич-баттон
        clickCSS(contentPage.getButtonMenu());
        // выбираем курсы
        clickCSS(contentPage.getButton(name));
        // закрываем попап
        clickCSS(contentPage.getButtonClosePopUp2());
        // Проверяем отображение "Курсы"
        contentPage.checkNamePage(name);
    }
    @DisplayName("Страница Форум")
    @Test
    public void topics() {
        contentPage= new ContentPage(chromeDriver);
        String name = "Форум";
        // кликаем сэндвич-баттон
        clickCSS(contentPage.getButtonMenu());
        // выбираем Форум
        clickCSS(contentPage.getButton(name));
        // Проверяем отображение "Форум"
        contentPage.checkNamePage(name);
    }
    @DisplayName("Страница Блог")
    @Test
    public void posts() {
        contentPage= new ContentPage(chromeDriver);
        String name = "Блог";
        // кликаем сэндвич-баттон
        clickCSS(contentPage.getButtonMenu());
        // выбираем Блог
        clickCSS(contentPage.getButton(name));
        // закрываем первый попап
        clickCSS(contentPage.getButtonClosePopUp2());
        // закрываем второй попап
        clickCSS(contentPage.getButtonClosePopUp1());
        // Проверяем отображение "Блог"
        contentPage.checkNamePage(name);
    }
    @DisplayName("Страница Вебинары")
    @Test
    public void events() {
        contentPage= new ContentPage(chromeDriver);
        String name = "Вебинары";
        // кликаем сэндвич-баттон
        clickCSS(contentPage.getButtonMenu());
        // выбираем Вебинары
        clickCSS(contentPage.getButton(name));
        // Проверяем отображение "Вебинары"
        contentPage.checkNamePage(name);
    }
    @DisplayName("Страница Тесты")
    @Test
    public void tests() {
        contentPage= new ContentPage(chromeDriver);
        String name = "Тесты";
        // кликаем сэндвич-баттон
        clickCSS(contentPage.getButtonMenu());
        // выбираем Тесты
        clickCSS(contentPage.getButton(name));
        // Проверяем отображение "Тесты"
        contentPage.checkNamePage(name);
    }
    @DisplayName("Страница Карьера")
    @Test
    public void career() {
        contentPage= new ContentPage(chromeDriver);
        String name = "Карьера";
        // кликаем сэндвич-баттон
        clickCSS(contentPage.getButtonMenu());
        // выбираем Карьера
        clickCSS(contentPage.getButton(name));
        // Проверяем отображение "Карьера"
        contentPage.checkNamePage(name);
    }
    @DisplayName("параметризованный метод")
    @ParameterizedTest
    @MethodSource("listCategoryNameSelector")
    void methodMulti(String CategoryName, String CategorySelector) {
        contentPage= new ContentPage(chromeDriver);
        // кликаем сэндвич-баттон
        clickCSS(contentPage.getButtonMenu());
        // выбираем CategoryName
        clickCSS(contentPage.getButton(CategoryName));
        if (CategoryName.equals("Курсы") | CategoryName.equals("Блог"))
            // закрываем попап
            clickCSS(contentPage.getButtonClosePopUp2());
        if (CategoryName.equals("Блог"))
            // закрываем попап
            clickCSS(contentPage.getButtonClosePopUp1());
        // проверяем отображение CategoryName
            contentPage.checkNamePage(CategoryName);
    }
    // Аргументы для параметризованного теста
    static Stream<Arguments> listCategoryNameSelector() {
        return Stream.of(
                // аргументы: название, пункт выпадающего меню, селектор на странице
                // для сравнения с названием
                Arguments.of("Вебинары","[class=\"nav\"] a[href=\"/events\"]"),
                Arguments.of("Курсы","[class=\"nav\"] a[href=\"/courses\"]"),
                Arguments.of("Карьера","[class=\"nav\"] a[href=\"/career\"]"),
                Arguments.of("Тесты","[class=\"nav\"] a[href=\"/tests\"]"),
                Arguments.of("Форум","[class=\"nav\"] a[href=\"/topics\"]"),
                Arguments.of("Блог","[class=\"nav\"] a[href=\"/posts\"]"));
    }

    @AfterEach
    @Override
    public void afterEach() {
        wait.until(ExpectedConditions.visibilityOf(
                contentPage.getHeader()));
        wait.until(ExpectedConditions.visibilityOf(
                contentPage.getFooter()));
        chromeDriver.quit();
    }

}
