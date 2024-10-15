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


    @Test
    void add_mutipleNumbers_returnsSum()
    {
        assertEquals(6, calculator.add("1,2,3"));
        assertEquals(22, calculator.add("4,5,6,7"));
    }

    @Test
    void add_numbersWithNewlines_returnsSum() {
        assertEquals(6, calculator.add("1\n2,3"));
        assertEquals(15, calculator.add("4\n5\n6"));
        assertEquals(10, calculator.add("1\n2\n3,4"));
    }

    @Test
    void add_customDelimiter_returnsSum() {
        assertEquals(3, calculator.add("//;\n1;2"));
        assertEquals(15, calculator.add("//|\n4|5|6"));
    }


}