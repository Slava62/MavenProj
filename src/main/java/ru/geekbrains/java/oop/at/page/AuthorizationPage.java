package ru.geekbrains.java.oop.at.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorizationPage {

    @FindBy(css ="[id=\"user_email\"]")
    private WebElement inputLogin;

    @FindBy(css = "[id=\"user_password\"]")
    private WebElement inputPassword;

    @FindBy(css = "[class=\"btn btn-block btn-success\"]")
    private WebElement buttonSingIn;

    private WebDriver webDriver;

    public AuthorizationPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public ContentPage authorization(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonSingIn.click();
        return new ContentPage(webDriver);
    }

    public WebElement getInputLogin() {
        return inputLogin;
    }

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public WebElement getButtonSingIn() {
        return buttonSingIn;
    }
}
