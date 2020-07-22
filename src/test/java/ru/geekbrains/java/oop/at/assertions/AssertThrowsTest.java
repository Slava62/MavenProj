package ru.geekbrains.java.oop.at.assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class AssertThrowsTest {
    @Timeout(value = 4)
    @Test
    void parseIntTest()  {
        String num = "20.5";
        Assertions.assertThrows(NumberFormatException.class,
                () -> Integer.parseInt(num));
    }
}
