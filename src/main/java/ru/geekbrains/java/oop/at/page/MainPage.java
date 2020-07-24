package ru.geekbrains.java.oop.at.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    //header
    @FindBy(css = "[class=\"header home-page-header\"]")
    private WebElement header;
    //footer
    @FindBy(css = "[class=\"home-page-footer text-center\"]")
    private WebElement footer;
    // поле логин
    @FindBy(css ="[name=\"user[email]\"]")
    private WebElement inputLogin;
    //поле пароль
    @FindBy(css = "[name=\"user[password]\"]")
    private WebElement inputPassword;
    // кнопка "начать изменения"
    @FindBy(css = "[id=\"registration-form-button\"]")
    private WebElement buttonSingUp;
    // кнопка войти
    @FindBy(css = "[class=\"header home-page-header\"] [class=\"btn sign-in\"]")
    private WebElement buttonSingIn;
    // заголовок блока регистрации
    @FindBy(css = "[class=\"registration-title\"]")
    private WebElement registrationTitle;
    // панель с иконками соцсетей
    @FindBy(css = "[class=\"social-buttons-v2 social-buttons-content social-buttons-content_all\"]")
    private WebElement panelWithIcons;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getInputLogin() {
        return inputLogin;
    }

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public WebElement getButtonSingUp() {
        return buttonSingUp;
    }

    public WebElement getButtonSingIn() {
        return buttonSingIn;
    }

    public WebElement getHeader() {
        return header;
    }

    public WebElement getFooter() {
        return footer;
    }

    public WebElement getRegistrationTitle() {
        return registrationTitle;
    }

    public WebElement getPanelWithIcons() {
        return panelWithIcons;
    }
}
