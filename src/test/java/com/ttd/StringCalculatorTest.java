package com.ttd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    StringCalculator calculator = new StringCalculator();
    @Test
    void add_emptyString_returnsZero() {

        assertEquals(0, calculator.add(""));
    }

    @Test
    void add_numbers_returnSum(){
        assertEquals(1, calculator.add("1"));
        assertEquals(6, calculator.add("1,5"));
    }
}