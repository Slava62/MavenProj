package ru.geekbrains.java.oop.at;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.java.oop.at.base.BaseTest;
import ru.geekbrains.java.oop.at.page.AuthorizationPage;
import ru.geekbrains.java.oop.at.page.ContentPage;

import java.util.List;

import static org.hamcrest.Matchers.*;
import io.qameta.allure.*;

@Epic(value = "Авторизация на главной странице GeekBrains")
@Feature("Тест-кейс: Авторизация с валидными и не валидными данными")
//@Story("Проверка авторизации")
@DisplayName("Тест-кейс авторизации пользователя с валидными и не валидными данными")
public class AuthorizationPageTest extends BaseTest {
    private ContentPage contentPage;
    private AuthorizationPage authorizationPage;
    public static final String LOGIN_PAGE = "https://geekbrains.ru/login";
    public static final String LOGIN = "hks47018@eoopy.com";
    public static final String PASSWORD="hks47018";


    @Description("Проверяем что страница \"Главная\" отображается при успешной аторизации")
   // @Issue("BUG-100500")
   // @TmsLink("TEST-100")
    @DisplayName("Проверка: отображается страница \"Главная\"")
    @Step("Логин: {this.LOGIN} пароль: {this.PASSWORD}.")
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void authorizationValidData() {
        chromeDriver.get(LOGIN_PAGE);
        authorizationPage = new AuthorizationPage(chromeDriver);
        contentPage = authorizationPage.authorization(LOGIN, PASSWORD);
        checkFilter();
    }

    @Step("Проверка работы фильтра курсов")
    @Description("Проверяем что курсы \"Тестирование ПО. Уровень 1\" и" +
            " \"Теститрование ПО. Уровень 2\" отображаются при выборе чекбоксов" +
            " Бесплатные и Тестирование в разделе Курсы")
    public void checkFilter() {

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

    @Description("Проверяем сообщение об ошибке при некорректном логине")
    // @Issue("BUG-100500")
    // @TmsLink("TEST-100")
    @DisplayName("Проверка: остаемся на странице \"Вход\" при вводе некорректного логина")
    @Test
    @Step("Логин: \" \" пароль: {this.PASSWORD}.")
    @Severity(SeverityLevel.CRITICAL)
    public void authorizationInvalidLogin() {
        chromeDriver.get(LOGIN_PAGE);
        authorizationPage = new AuthorizationPage(chromeDriver);
        contentPage = authorizationPage.authorization(" ",PASSWORD);
        contentPage.checkNamePage("Вход");
    }
    @DisplayName("Проверка: остаемся на странице \"Вход\" при вводе некорректного пароля")
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Step("Логин: {this.LOGIN} пароль: \"password\".")
    public void authorizationInvalidPassword() {
        chromeDriver.get(LOGIN_PAGE);
        authorizationPage = new AuthorizationPage(chromeDriver);
        contentPage = authorizationPage.authorization(LOGIN,"password");
        contentPage.checkNamePage("Вход");
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
