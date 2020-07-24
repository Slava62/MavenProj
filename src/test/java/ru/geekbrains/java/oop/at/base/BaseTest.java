package ru.geekbrains.java.oop.at.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    public ChromeDriver chromeDriver;
    public WebDriverWait wait;

    @BeforeAll
    public static void beforeAll(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeEach() {
        ChromeOptions  options = new ChromeOptions();
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
    public void afterEach() {
        chromeDriver.quit();
    }
    // кликаем по элементу, передавая web element
    protected void clickCSS(WebElement webElement){
        if(chromeDriver != null)
       webElement.click();
    }

    protected void assertion(String actual, Matcher matcher){
        int result;
        try {
            result = Integer.parseInt(actual);
            MatcherAssert.assertThat(result, matcher);
        }  catch (NumberFormatException e){
            Assertions.fail("Ошибка преобразования в тип int");
        }
    }

    }

