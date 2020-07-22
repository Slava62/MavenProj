package ru.geekbrains.java.oop.at.assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssertNotNullAndNullTest {

    @Test
    void notNullValue() {
        Object i = new Object();
        Assertions.assertNotNull(i);
    }

    @Test
    void nullValue() {
        Object i =null;
        Assertions.assertNull(i);

    }
}
