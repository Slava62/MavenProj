package ru.geekbrains.java.oop.at.assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.RepeatedTest;
public class AssertAllTest {


    @RepeatedTest(value = 3)
    void userDataTest() {
        String firstName ="Иван";
        String secondName ="Иванов";
        assertAll("Пользователь",
                () -> assertEquals("Иван", firstName),
                () -> assertEquals("Иванов", secondName)
        );
    }
}
