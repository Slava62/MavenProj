package ru.geekbrains.java.oop.at.assertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class AssertTrueFalseTest {
    @Test
    void trueTest() {
        Assertions.assertTrue(true,"true test fail");
    }
    @Disabled
    @Test
    void falseTest() {
        Assertions.assertFalse(false,"false test fail");
    }
}
