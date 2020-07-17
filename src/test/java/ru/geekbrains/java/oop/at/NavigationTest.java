package ru.geekbrains.java.oop.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.geekbrains.java.oop.at.base.BaseTest;

public class NavigationTest extends BaseTest {

//    Перейти на сайт https://geekbrains.ru/courses
//    Нажать на кнопку Курсы
//    Проверить что страница Курсы открылась
//    Повторить для
//    Курсы *
//            Вебинары *
//    Форум *
//            Блог *
//    Тесты *
//            Карьера *

    @Test
    public void courses() {
        // кликаем сэндвич-баттон
        clickCSS("[class=\"top-menu-mobile-toggle pull-right js-top-menu-mobile-toggle\"]");
        // выбираем курсы
        clickCSS("[class=\"nav\"] a[href=\"/courses\"]");
        // закрываем попап
        clickCSS("button [class=\"svg-icon icon-popup-close-button \"]");
        // Проверяем отображение "Курсы"
        Assertions.assertEquals(
                "Курсы",
                getText("[id=\"top-menu\"] h2")
        );
        // проверяем header
        Assertions.assertTrue(hasHeader("[class=\"gb-header js-main-top-menu\"]"));
        // проверяем footer
        Assertions.assertTrue(hasFooter("[class=\"site-footer\"]"));
    }

    @Test
    public void topics() {
        // кликаем сэндвич-баттон
        clickCSS("[class=\"top-menu-mobile-toggle pull-right js-top-menu-mobile-toggle\"]");
        // выбираем "Форум"
        clickCSS("[class=\"nav\"] a[href=\"/topics\"]");
        // проверяем отображение "Форум"
        Assertions.assertEquals(
                "Форум",
               getText("[id=\"top-menu\"] h2")
        );
        // проверяем header
        Assertions.assertTrue(hasHeader("[class=\"gb-header js-main-top-menu\"]"));
        // проверяем footer
        Assertions.assertTrue(hasFooter("[class=\"site-footer\"]"));
    }

    @Test
    public void posts() {
        // кликаем сэндвич-баттон
        clickCSS("[class=\"top-menu-mobile-toggle pull-right js-top-menu-mobile-toggle\"]");
        // выбираем "Блог"
        clickCSS("[class=\"nav\"] a[href=\"/posts\"]");
        // закрываем первый попап
        clickCSS("button [class=\"svg-icon icon-popup-close-button \"]");
        // закрываем второй попап
        clickCSS("[class=\"gb-empopup-close\"]");
        // проверяем отображение "Блог"
        Assertions.assertEquals(
                "Блог",
               getText("[id=\"top-menu\"] h2")
        );
        // проверяем header
        Assertions.assertTrue(hasHeader("[class=\"gb-header js-main-top-menu\"]"));
        // проверяем footer
        Assertions.assertTrue(hasFooter("[class=\"site-footer\"]"));
    }

    @Test
    public void events() {
        // кликаем сэндвич-баттон
        clickCSS("[class=\"top-menu-mobile-toggle pull-right js-top-menu-mobile-toggle\"]");
        // выбираем "Вебинары"
        clickCSS("[class=\"nav\"] a[href=\"/events\"]");
        // проверяем отображение "Вебинары"
        Assertions.assertEquals(
                "Вебинары",
                getText("[id=\"top-menu\"] h2")
        );
        // проверяем header
        Assertions.assertTrue(hasHeader("[class=\"gb-header js-main-top-menu\"]"));
        // проверяем footer
        Assertions.assertTrue(hasFooter("[class=\"site-footer\"]"));
    }

    @Test
    public void tests() {
        // кликаем сэндвич-баттон
        clickCSS("[class=\"top-menu-mobile-toggle pull-right js-top-menu-mobile-toggle\"]");
        // выбираем "Тесты"
        clickCSS("[class=\"nav\"] a[href=\"/tests\"]");
        // проверяем отображение "Тесты"
        Assertions.assertEquals(
                "Тесты",
                getText("[id=\"top-menu\"] h2")
        );
        // проверяем header
        Assertions.assertTrue(hasHeader("[class=\"gb-header js-main-top-menu\"]"));
        // проверяем footer
        Assertions.assertTrue(hasFooter("[class=\"site-footer\"]"));
    }

    @Test
    public void career() {
        // кликаем сэндвич-баттон
        clickCSS("[class=\"top-menu-mobile-toggle pull-right js-top-menu-mobile-toggle\"]");
        // выбираем "Карьера"
        clickCSS("[class=\"nav\"] a[href=\"/career\"]");
        // проверяем отображение "Карьера"
        Assertions.assertEquals(
                "Карьера",
              getText("[id=\"top-menu\"] h2")
        );
        // проверяем header
        Assertions.assertTrue(hasHeader("[class=\"gb-header js-main-top-menu\"]"));
        // проверяем footer
        Assertions.assertTrue(hasFooter("[class=\"site-footer\"]"));
    }

}
