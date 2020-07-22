package ru.geekbrains.java.oop.at.assertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertEqualsTest {
    @Test
    void integerTest() {
        assertEquals(100, 100);
    }

    @Test
    void stringTest() {
        assertEquals("some string", "some string");
    }
}
