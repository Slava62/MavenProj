package ru.geekbrains.java.oop.at;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.java.oop.at.base.BaseTest;
import ru.geekbrains.java.oop.at.page.AuthorizationPage;
import ru.geekbrains.java.oop.at.page.ContentPage;
import ru.geekbrains.java.oop.at.page.SearchPage;

import java.util.List;

import static org.hamcrest.Matchers.*;

@DisplayName("Проверка авторизации")
public class AuthorizationPageTest extends BaseTest {
    private ContentPage contentPage;
    private AuthorizationPage authorizationPage;
    public static final String LOGIN_PAGE = "https://geekbrains.ru/login";
    public static final String LOGIN = "hks47018@eoopy.com";
    public static final String PASSWORD="hks47018";

    @DisplayName("Проверка авторизации с валидными данными")
    @Test
    public void authorizationValidData() {
       chromeDriver.get(LOGIN_PAGE);
       authorizationPage = new AuthorizationPage(chromeDriver);
       contentPage = authorizationPage.authorization(LOGIN,PASSWORD);
       contentPage.checkNamePage("Главная");
       contentPage.getButtonMenu().click();
       contentPage.getButton("Курсы").click();
       contentPage.getNavButtonCourses().click();
       contentPage.getCheckboxFree().click();
       contentPage.getCheckboxTesting().click();

       List<WebElement> filteredElements = chromeDriver.findElements(By.cssSelector
               ("[class=\"gb-course-card__title-text\"]"));
        int count = 0;
       for (WebElement webElement : filteredElements){
           if (webElement.getText().equals("Тестирование ПО. Уровень 1")){count++;}
           if (webElement.getText().equals("Тестирование ПО. Уровень 2")){count++;}
       }
        assertion("2", equalTo(2));
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
