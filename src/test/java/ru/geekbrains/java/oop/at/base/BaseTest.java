package ru.geekbrains.java.oop.at.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    public ChromeDriver chromeDriver;
    public WebDriverWait wait;

    @BeforeEach
    public void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "C:\\\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        // отключить уведомления
        options.addArguments("--disable-notifications");
        // отключить попапы
        options.addArguments("--disable-popup-blocking");
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        options.addArguments("--window-size=1024,768");
        chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        
        // на мониторе 15' сначала грузимся на курсы
        chromeDriver.get("https://geekbrains.ru/topics");

        wait = new WebDriverWait(chromeDriver, 90);
    }


    @AfterEach
    public void afterAll() {
        chromeDriver.quit();
    }
    // кликаем по элементу, передавая css
    protected void clickCSS(String cssSelector){
        if(chromeDriver != null)
        chromeDriver.findElement(By.cssSelector
                (cssSelector)).click();
    }
    // кликаем по элементу, передавая xpath
    protected void clickXPATH(String xpathSelector){
        if(chromeDriver != null)
            chromeDriver.findElement(By.xpath(xpathSelector)).click();
    }
    // возвращает текст элемента
    protected String getText(String cssSelector){
       return chromeDriver.findElement(By.cssSelector
                (cssSelector)).getText();
    }
    // проверяет header
    protected boolean hasHeader(String cssSelector){
       return chromeDriver.findElement(By.cssSelector
                (cssSelector)).isDisplayed();
    }
    // проверяет footer
    protected boolean hasFooter(String cssSelector){
        return chromeDriver.findElement(By.cssSelector
                (cssSelector)).isDisplayed();
    }
}
