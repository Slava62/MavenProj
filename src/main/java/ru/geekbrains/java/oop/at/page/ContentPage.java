package ru.geekbrains.java.oop.at.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.hamcrest.Matchers.*;
import org.hamcrest.MatcherAssert;

public class ContentPage extends PageFactory {
    //header
    @FindBy(css = "[id=\"top-menu\"]")
    private WebElement header;
    //footer
    @FindBy(css = "[class=\"site-footer\"]")
    private WebElement footer;
    //namepage
    @FindBy(css = "[id=\"top-menu\"] h2")
    private WebElement namePage;
    //popup buttons
    @FindBy(css = "[class=\"gb-empopup-close\"]")
    private WebElement buttonClosePopUp1;

    @FindBy(css = "button [class=\"svg-icon icon-popup-close-button \"]")
    private WebElement buttonClosePopUp2;

    //buttons
    @FindBy(css = "[class=\"nav\"] a[href=\"/posts\"]")
    private WebElement buttonPosts;

    @FindBy(css = "[class=\"nav\"] a[href=\"/topics\"]")
    private WebElement buttonTopics;

    @FindBy(css = "[class=\"nav\"] a[href=\"/events\"]")
    private WebElement buttonEvents;

    @FindBy(css = "[class=\"nav\"] a[href=\"/tests\"]")
    private WebElement buttonTests;

    @FindBy(css = "[class=\"nav\"] a[href=\"/career\"]")
    private WebElement buttonCareer;

    @FindBy(css = "[class=\"nav\"] a[href=\"/courses\"]")
    private WebElement buttonCourses;

    // кнопка навигации Курсы
    @FindBy(css ="[class=\"nav nav-tabs js-offset-top hidden-xs callback-shown\"] a[id =\"cour-link\"]")
    private WebElement navButtonCourses;

    //чекбоксы
    //чекбокс "Бесплатные"
    @FindBy(css ="[id=\"filter-0\"]")
    private WebElement checkboxFree;
    //чекбокс "Тестирование"
    @FindBy(css ="[id=\"filter-9\"]")
    private WebElement checkboxTesting;

    //сэндвич-баттон
    @FindBy(css = "[class=\"top-menu-mobile-toggle pull-right js-top-menu-mobile-toggle\"]")
    private WebElement buttonMenu;

    public ContentPage(WebDriver webDriver) {
        initElements(webDriver, this);
    }

    public WebElement checkNamePage(String expectedNamePage) {
        MatcherAssert.assertThat(expectedNamePage, equalTo( namePage.getText()));
        return namePage;
    }

    public WebElement getButtonClosePopUp1() {
        return buttonClosePopUp1;
    }

    public WebElement getButtonClosePopUp2() {
        return buttonClosePopUp2;
    }

    public WebElement getHeader() {
        return header;
    }

    public WebElement getFooter() {
        return footer;
    }

    public WebElement getButtonMenu() {
        return buttonMenu;
    }

    public WebElement getNavButtonCourses() { return navButtonCourses; }

    public WebElement getButton(String nameButton) {

        switch (nameButton) {
            case "Курсы": {
                return buttonCourses;
            }
            case "Вебинары": {
                return buttonEvents;
            }
            case "Форум": {
                return buttonTopics;
            }
            case "Блог": {
                return buttonPosts;
            }
            case "Тесты": {
                return buttonTests;
            }
            case "Карьера": {
                return buttonCareer;
            }
        }
        throw new RuntimeException("кнопки: " + nameButton + " нет на странице!");
    }

    public WebElement getCheckboxFree() {
        return checkboxFree;
    }

    public WebElement getCheckboxTesting() {
        return checkboxTesting;
    }
}
