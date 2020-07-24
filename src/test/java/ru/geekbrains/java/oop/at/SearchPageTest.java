package ru.geekbrains.java.oop.at;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.java.oop.at.base.BaseTest;
import org.hamcrest.MatcherAssert;
import ru.geekbrains.java.oop.at.page.ContentPage;
import ru.geekbrains.java.oop.at.page.SearchPage;

import static org.hamcrest.Matchers.*;

@DisplayName("Проверка поиска")
public class SearchPageTest extends BaseTest {
    private SearchPage searchPage;

    @DisplayName("Проверка поиска строки \"java\"")
    @Test
    public void searchJava() {
       searchPage = new SearchPage(chromeDriver);
       // кликаем сэндвич-баттон
        clickCSS(searchPage.getButtonMenu());
       // выбираем курсы
        clickCSS(searchPage.getButton("Курсы"));
       // закрываем попап
        clickCSS(searchPage.getButtonClosePopUp2());
       // кликаем сэндвич-баттон снова
        clickCSS(searchPage.getButtonMenu());
       // кликаем иконку поиска
        clickCSS(searchPage.getSearchIcon());
       // вводим текст в поле поиска
        searchPage.getTextFieldSearch().sendKeys("java");
       // ждем пока найдет
        wait.until(ExpectedConditions.textToBePresentInElement(
        searchPage.getNameBlockProfessions(),"Профессии"));
       // Профессий не менее чем 2
        assertion(searchPage.getBlockProfessions().getText(), greaterThanOrEqualTo(2));
        // Курсов более 15
        wait.until(ExpectedConditions.textToBePresentInElement(
        searchPage.getNameBlockCourses(),"Курсы"));
        assertion(searchPage.getBlockCourses().getText(), greaterThan(15));
        // Вебинаров больше чем 180, но меньше 300
        wait.until(ExpectedConditions.textToBePresentInElement(
        searchPage.getNameBlockWebinars(),"Вебинары"));
        assertion(searchPage.getBlockWebinars().getText(), greaterThan(180));
        assertion(searchPage.getBlockWebinars().getText(), lessThan(300));
        // В вебинарах отображается первым “Java Junior. Что нужно знать для успешного собеседования?”
        MatcherAssert.assertThat("Java Junior. Что нужно знать для успешного собеседования?", equalTo(
                chromeDriver.findElements(By.cssSelector("a[class=\"event__title h3 search_text\"]"))
                        .get(0).getText()));
        // Блогов более 300
        wait.until(ExpectedConditions.textToBePresentInElement(
        searchPage.getNameBlockBlogs(),"Блоги"));
        assertion(searchPage.getBlockBlogs().getText(), greaterThan(300));
        // Форумов не 350
        wait.until(ExpectedConditions.textToBePresentInElement(
        searchPage.getNameBlockForums(),"Форум"));
        assertion(searchPage.getBlockForums().getText(), not(350));
        //Тестов не 0
        wait.until(ExpectedConditions.textToBePresentInElement(
        searchPage.getNameBlockTests(),"Тесты"));
        assertion(searchPage.getBlockTests().getText(), not(0));
        // В Проектах и компаниях отображается GeekBrains
        wait.until(ExpectedConditions.textToBePresentInElement(
        searchPage.getNameBlockProjectAndCompanies(),"Проекты и компании"));
        MatcherAssert.assertThat(searchPage.getBlockProjectAndCompanies().getText()
                , containsString("GeekBrains"));
    }


}
