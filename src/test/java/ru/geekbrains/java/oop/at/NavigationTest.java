package ru.geekbrains.java.oop.at;

import org.junit.jupiter.params.provider.CsvSource;
import ru.geekbrains.java.oop.at.base.BaseTest;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

public class NavigationTest extends BaseTest {

/*   Перейти на сайт https://geekbrains.ru/courses
//    Нажать на кнопку Курсы
//    Проверить что страница Курсы открылась
//    Повторить для
//    Курсы *
//            Вебинары *
//    Форум *
//            Блог *
//    Тесты *
           Карьера * */

    @Test
    public void courses() {
        // кликаем сэндвич-баттон
        clickCSS("[class=\"top-menu-mobile-toggle pull-right js-top-menu-mobile-toggle\"]");
        // выбираем курсы
        clickCSS("[class=\"nav\"] a[href=\"/courses\"]");
        // закрываем попап
        clickCSS("button [class=\"svg-icon icon-popup-close-button \"]");
        // Проверяем отображение "Курсы"
       MatcherAssert.assertThat(
                "Курсы",
               equalTo(getText("[id=\"top-menu\"] h2")));
        // проверяем header (проверка с not)
        MatcherAssert.assertThat(false, not(hasHeader("[class=\"gb-header js-main-top-menu\"]")));
        // проверяем footer (проверка с is)
        MatcherAssert.assertThat(true, is(hasFooter("[class=\"site-footer\"]")));
    }

    @Test
    public void topics() {
        // кликаем сэндвич-баттон
        clickCSS("[class=\"top-menu-mobile-toggle pull-right js-top-menu-mobile-toggle\"]");
        // выбираем "Форум"
        clickCSS("[class=\"nav\"] a[href=\"/topics\"]");
        // проверяем отображение "Форум"
        MatcherAssert.assertThat(
                "Форум",
              equalTo( getText("[id=\"top-menu\"] h2"))
        );
        // проверяем header (проверка с not)
        MatcherAssert.assertThat(false, not(hasHeader("[class=\"gb-header js-main-top-menu\"]")));
        // проверяем footer (проверка с is)
        MatcherAssert.assertThat(true, is(hasFooter("[class=\"site-footer\"]")));
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
        MatcherAssert.assertThat(
                "Блог",
            equalTo(   getText("[id=\"top-menu\"] h2"))
        );
        // проверяем header (проверка с not)
        MatcherAssert.assertThat(false, not(hasHeader("[class=\"gb-header js-main-top-menu\"]")));
        // проверяем footer (проверка с is)
        MatcherAssert.assertThat(true, is(hasFooter("[class=\"site-footer\"]")));
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
        // проверяем header (проверка с not)
        MatcherAssert.assertThat(false, not(hasHeader("[class=\"gb-header js-main-top-menu\"]")));
        // проверяем footer (проверка с is)
        MatcherAssert.assertThat(true, is(hasFooter("[class=\"site-footer\"]")));
    }

    @Test
    public void tests() {
        // кликаем сэндвич-баттон
        clickCSS("[class=\"top-menu-mobile-toggle pull-right js-top-menu-mobile-toggle\"]");
        // выбираем "Тесты"
        clickCSS("[class=\"nav\"] a[href=\"/tests\"]");
        // проверяем отображение "Тесты"
        MatcherAssert.assertThat(
                "Тесты",
               equalTo( getText("[id=\"top-menu\"] h2"))
        );
        // проверяем header (проверка с not)
        MatcherAssert.assertThat(false, not(hasHeader("[class=\"gb-header js-main-top-menu\"]")));
        // проверяем footer (проверка с is)
        MatcherAssert.assertThat(true, is(hasFooter("[class=\"site-footer\"]")));
    }

    @Test
    public void career() {
        // кликаем сэндвич-баттон
        clickCSS("[class=\"top-menu-mobile-toggle pull-right js-top-menu-mobile-toggle\"]");
        // выбираем "Карьера"
        clickCSS("[class=\"nav\"] a[href=\"/career\"]");
        // проверяем отображение "Карьера"
        MatcherAssert.assertThat(
                "Карьера",
           equalTo(getText("[id=\"top-menu\"] h2"))
        );
        // проверяем header (проверка с not)
        MatcherAssert.assertThat(false, not(hasHeader("[class=\"gb-header js-main-top-menu\"]")));
        // проверяем footer (проверка с is)
        MatcherAssert.assertThat(true, is(hasFooter("[class=\"site-footer\"]")));
    }

 /* @CsvSource({
            "Курсы,[class=\"nav\"] a[href=\"/courses\"]",
            "Карьера,[class=\"nav\"] a[href=\"/career\"]",
            "Тесты,[class=\"nav\"] a[href=\"/tests\"]",
            "Вебинары,[class=\"nav\"] a[href=\"/events\"]",
            "Форум,[class=\"nav\"] a[href=\"/topics\"]",
            "Блог,[class=\"nav\"] a[href=\"/posts\"]"
    })
*/
    @ParameterizedTest
    @MethodSource("listCategoryNameSelector")
    void methodMulti(String CategoryName, String CategorySelector) {
        // кликаем сэндвич-баттон
        clickCSS("[class=\"top-menu-mobile-toggle pull-right js-top-menu-mobile-toggle\"]");
        // выбираем CategoryName
        clickCSS(CategorySelector);
        if (CategoryName.equals("Курсы") | CategoryName.equals("Блог"))
            // закрываем попап
            clickCSS("button [class=\"svg-icon icon-popup-close-button \"]");
        if (CategoryName.equals("Блог"))
            // закрываем попап
            clickCSS("[class=\"gb-empopup-close\"]");
        // проверяем отображение CategoryName
        MatcherAssert.assertThat(
                CategoryName,
                equalTo(getText("[id=\"top-menu\"] h2"))
        );
        // проверяем header (проверка с not)
    MatcherAssert.assertThat(false, not(hasHeader("[class=\"gb-header js-main-top-menu\"]")));
        // проверяем footer (проверка с is)
       MatcherAssert.assertThat(true, is(hasFooter("[class=\"site-footer\"]")));
    }
    // Аргументы для параметризованного теста
    static Stream<Arguments> listCategoryNameSelector() {
       return Stream.of(
                // аргументы: название, пункт выпадающего меню, селектор на странице
                // для сравнения с названием
                Arguments.of("Курсы","[class=\"nav\"] a[href=\"/courses\"]"),
                Arguments.of("Карьера","[class=\"nav\"] a[href=\"/career\"]"),
                Arguments.of("Тесты","[class=\"nav\"] a[href=\"/tests\"]"),
                Arguments.of("Вебинары","[class=\"nav\"] a[href=\"/events\"]"),
                Arguments.of("Форум","[class=\"nav\"] a[href=\"/topics\"]"),
                Arguments.of("Блог","[class=\"nav\"] a[href=\"/posts\"]"));
    }


}
