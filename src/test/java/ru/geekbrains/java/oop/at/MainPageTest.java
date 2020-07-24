package ru.geekbrains.java.oop.at;

import static org.hamcrest.Matchers.equalTo;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.java.oop.at.base.BaseTest;
import ru.geekbrains.java.oop.at.page.MainPage;


@DisplayName("Проверка главной страницы GeekBrains")
public class MainPageTest extends BaseTest {
    private MainPage mainPage;
    public static final String MAIN_PAGE = "https://geekbrains.ru";

    @DisplayName("Проверка элементов на главной странице")
    @Test
    public void checkMainPage() {
       chromeDriver.get(MAIN_PAGE);
       mainPage = new MainPage(chromeDriver);

       //проверка кнопки войти
       wait.until(ExpectedConditions.visibilityOf(mainPage.getButtonSingIn()));
       //проверка блока регистрации
       // проверка заголовка блока
        MatcherAssert.assertThat("Бесплатная регистрация",
                equalTo(mainPage.getRegistrationTitle().getText()));
        //проверка панели с иконками
        wait.until(ExpectedConditions.visibilityOf(mainPage.getPanelWithIcons()));
        //проверка поля e-mail
        wait.until(ExpectedConditions.visibilityOf(mainPage.getInputLogin()));
       //проверка поля пароль
        wait.until(ExpectedConditions.visibilityOf(mainPage.getInputPassword()));
       //проверка наличия кнопки "начать изменения"
        wait.until(ExpectedConditions.visibilityOf(mainPage.getButtonSingUp()));
    }
    @AfterEach
    @Override
    public void afterEach() {
        //проверка хедера и футтера
        wait.until(ExpectedConditions.visibilityOf(
                mainPage.getHeader()));
        wait.until(ExpectedConditions.visibilityOf(
                mainPage.getFooter()));
        chromeDriver.quit();
    }

}
