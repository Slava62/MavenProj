package ru.geekbrains.java.oop.at.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends PageFactory{

    //сэндвич-баттон
    @FindBy(css = "[class=\"top-menu-mobile-toggle pull-right js-top-menu-mobile-toggle\"]")
    private WebElement buttonMenu;
    @FindBy(css = "[class=\"nav\"] a[href=\"/courses\"]")
    private WebElement buttonCourses;
    //иконка поиска
    @FindBy(css ="[class=\"main-mobile-menu-header\"] a [class=\"svg-icon icon-search \"]")
    private WebElement searchIcon;
    //popup button
    @FindBy(css = "button [class=\"svg-icon icon-popup-close-button \"]")
    private WebElement buttonClosePopUp2;
    //текстовое поле для поиска
    @FindBy(css = "[name=\"q\"]")
    private WebElement textFieldSearch;
    //Блоки
    //Блок профессии
    @FindBy(css = "ul[class=\"search-page-block__helper\"] a[data-tab='professions'] span")
    private WebElement blockProfessions;
    //Блок курсы
    @FindBy(css = "ul[class=\"search-page-block__helper\"] a[data-tab='courses'] span")
    private WebElement blockCourses;
    //Блок вебинары
    @FindBy(css = "ul[class=\"search-page-block__helper\"] a[data-tab='webinars'] span")
    private WebElement blockWebinars;
    //Блок блоги
    @FindBy(css = "ul[class=\"search-page-block__helper\"] a[data-tab='blogs'] span")
    private WebElement blockBlogs;
    //Блок форумы
    @FindBy(css = "ul[class=\"search-page-block__helper\"] a[data-tab='forums'] span")
    private WebElement blockForums;
    //Блок тесты
    @FindBy(css = "ul[class=\"search-page-block__helper\"] a[data-tab='tests'] span")
    private WebElement blockTests;
    //Блок проекты и компании
    @FindBy(css = "h3 a[href=\"/career/682\"]")
    private WebElement blockProjectAndCompanies;

    //Названия блоков
    //Блок профессии
    @FindBy(xpath = "//div/header/h2[text()='Профессии']")
    private WebElement nameBlockProfessions;
    //Блок курсы
    @FindBy(xpath = "//div/header/h2[text()='Курсы']")
    private WebElement nameBlockCourses;
    //Блок вебинары
    @FindBy(xpath = "//div/header/h2[text()='Вебинары']")
    private WebElement nameBlockWebinars;
    //Блок блоги
    @FindBy(xpath = "//div/header/h2[text()='Блоги']")
    private WebElement nameBlockBlogs;
    //Блок форумы
    @FindBy(xpath = "//div/header/h2[text()='Форум']")
    private WebElement nameBlockForums;
    //Блок тесты
    @FindBy(xpath = "//div/header/h2[text()='Тесты']")
    private WebElement nameBlockTests;
    //Блок проекты и компании
    @FindBy(xpath = "//div/header/h2[text()='Проекты и компании']")
    private WebElement nameBlockProjectAndCompanies;

    public SearchPage(WebDriver webDriver) {
        initElements(webDriver, this);
    }
    public WebElement getButtonMenu() {
        return buttonMenu;
    }

    public WebElement getSearchIcon() {
        return searchIcon;
    }

    public WebElement getButton(String nameButton) {

        switch (nameButton) {
            case "Курсы": {
                return buttonCourses;
            }
        }
        throw new RuntimeException("кнопки: " + nameButton + " нет на странице!");
    }

    public WebElement getButtonClosePopUp2() {
        return buttonClosePopUp2;
    }

    public WebElement getTextFieldSearch() {
        return textFieldSearch;
    }

    //blocks getters
    public WebElement getBlockProfessions() {return blockProfessions;}

    public WebElement getBlockCourses() { return blockCourses;    }

    public WebElement getBlockWebinars() { return blockWebinars; }

    public WebElement getBlockBlogs() { return blockBlogs; }

    public WebElement getBlockForums() { return blockForums; }

    public WebElement getBlockTests() { return blockTests; }

    public WebElement getBlockProjectAndCompanies() { return blockProjectAndCompanies; }

    //block name getters
    public WebElement getNameBlockProfessions() { return nameBlockProfessions; }

    public WebElement getNameBlockCourses() { return nameBlockCourses; }

    public WebElement getNameBlockWebinars() { return nameBlockWebinars; }

    public WebElement getNameBlockBlogs() { return nameBlockBlogs; }

    public WebElement getNameBlockForums() { return nameBlockForums; }

    public WebElement getNameBlockTests() { return nameBlockTests; }

    public WebElement getNameBlockProjectAndCompanies() { return nameBlockProjectAndCompanies; }

}
