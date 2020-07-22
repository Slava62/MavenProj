package ru.geekbrains.java.oop.at.assertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тестовый набор для массива")
public class AssertArrayEqualsTest {

    @DisplayName("Тестовый случай: одинаковые массивы")
    @Test
    void arrayTest() {
        int[] a = {1, 2, 3, 5};
        int[] b = {1, 2, 3, 5};

        Assertions.assertArrayEquals(a, b,"массивы разные");
    }
}
