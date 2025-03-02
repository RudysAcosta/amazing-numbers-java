package dev.ncrousset.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberTest {

    @Test
    void testGetValue() {
        Number number = new Number(12345);
        assertEquals(12345, number.getValue());
    }

    @Test
    void testGetLastDigit() {
        Number number = new Number(98765);
        assertEquals(5, number.getLastDigit());
    }

    @Test
    void testGetFirstDigit() {
        Number number = new Number(45678);
        assertEquals(4, number.getFirstDigit());
    }

    @Test
    void testGetDigits() {
        Number number = new Number(12345);
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, number.getDigits());
    }

    @Test
    void testGetDigitsWithSingleDigit() {
        Number number = new Number(9);
        int[] expected = {9};
        assertArrayEquals(expected, number.getDigits());
    }
}
