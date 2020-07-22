package ru.geekbrains.java.oop.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.java.oop.at.base.BaseTest;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.*;

import static org.junit.jupiter.api.Assertions.fail;

public class SearchTest extends BaseTest {

//    Перейти на сайт https://geekbrains.ru/courses
//    Нажать на кнопку Поиск
//    В поле Поиск ввести текст: java
//    Проверить что отобразились блоки:
//    Профессии
//            Курсы
//    Вебинары
//            Блоги
//    Форум
//            Тесты
//    Проекты и компании


    @Test
    public void checkSearch() {
       int result;
       // кликаем сэндвич-баттон
       clickCSS("[class=\"top-menu-mobile-toggle pull-right js-top-menu-mobile-toggle\"]");
       // выбираем курсы
       clickCSS("[class=\"nav\"] a[href=\"/courses\"]");
       // закрываем попап
       clickCSS("button [class=\"svg-icon icon-popup-close-button \"]");
       // кликаем сэндвич-баттон снова
       clickCSS("[class=\"top-menu-mobile-toggle pull-right js-top-menu-mobile-toggle\"]");
       // кликаем иконку поиска
       clickCSS("[class=\"main-mobile-menu-header\"] a [class=\"svg-icon icon-search \"]");
       // вводим текст в поле поиска
       chromeDriver.findElementByCssSelector("[name=\"q\"]")
                .sendKeys("java");
        // ждем пока найдет
        wait.until(ExpectedConditions.textToBePresentInElement(
        chromeDriver.findElementByXPath("//div/header/h2[text()='Профессии']"),"Профессии"));
        // Профессий не менее чем 2
        try {
            result = Integer.parseInt(getText
                    ("ul[class=\"search-page-block__helper\"] a[data-tab='professions'] span"));
            MatcherAssert.assertThat(result, greaterThanOrEqualTo(2));
        }  catch (NumberFormatException e){
            Assertions.fail("Error in professions block");
        }
        // Курсов более 15
        wait.until(ExpectedConditions.textToBePresentInElement(
        chromeDriver.findElementByXPath("//div/header/h2[text()='Курсы']"),"Курсы"));
        try {
            result = Integer.parseInt(getText
                    ("ul[class=\"search-page-block__helper\"] a[data-tab='courses'] span"));
            MatcherAssert.assertThat(result, greaterThan(15));
        }  catch (NumberFormatException e){
            Assertions.fail("Error in courses block");
        }
        // Вебинаров больше чем 180, но меньше 300
        wait.until(ExpectedConditions.textToBePresentInElement(
        chromeDriver.findElementByXPath("//div/header/h2[text()='Вебинары']"),"Вебинары"));
        try {
            result = Integer.parseInt(getText
                    ("ul[class=\"search-page-block__helper\"] a[data-tab='webinars'] span"));
            MatcherAssert.assertThat(result, greaterThan(180));
            MatcherAssert.assertThat(result, lessThan(300));
        }  catch (NumberFormatException e){
            Assertions.fail("Error in webinars block");
        }
        // В вебинарах отображается первым “Java Junior. Что нужно знать для успешного собеседования?”
        MatcherAssert.assertThat("Java Junior. Что нужно знать для успешного собеседования?", equalTo(
                chromeDriver.findElements(By.cssSelector("a[class=\"event__title h3 search_text\"]"))
                        .get(0).getText()));
        // Блогов более 300
        wait.until(ExpectedConditions.textToBePresentInElement(
        chromeDriver.findElementByXPath("//div/header/h2[text()='Блоги']"),"Блоги"));
        try {
            result = Integer.parseInt(getText
                    ("ul[class=\"search-page-block__helper\"] a[data-tab='blogs'] span"));
            MatcherAssert.assertThat(result, greaterThan(300));
        }  catch (NumberFormatException e){
            Assertions.fail("Error in blogs block");
        }
        // Форумов не 350
        wait.until(ExpectedConditions.textToBePresentInElement(
        chromeDriver.findElementByXPath("//div/header/h2[text()='Форум']"),"Форум"));
        try {
            result = Integer.parseInt(getText
                    ("ul[class=\"search-page-block__helper\"] a[data-tab='forums'] span"));
            MatcherAssert.assertThat(result, not(350));
        }  catch (NumberFormatException e){
            Assertions.fail("Error in forums block");
        }
        //Тестов не 0
        wait.until(ExpectedConditions.textToBePresentInElement(
        chromeDriver.findElementByXPath("//div/header/h2[text()='Тесты']"),"Тесты"));
        try {
            result = Integer.parseInt(getText
                    ("ul[class=\"search-page-block__helper\"] a[data-tab='tests'] span"));
            MatcherAssert.assertThat(result, not(0));
        }  catch (NumberFormatException e){
            Assertions.fail("Error in tests block");
        }
        // В Проектах и компаниях отображается GeekBrains
        wait.until(ExpectedConditions.textToBePresentInElement(
        chromeDriver.findElementByXPath("//div/header/h2[text()='Проекты и компании']"),"Проекты и компании"));
        MatcherAssert.assertThat(
                getText("h3 a[href=\"/career/682\"]"), containsString("GeekBrains"));
    }
}
