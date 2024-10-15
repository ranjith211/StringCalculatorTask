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
    @Test
    void add_negativeNumbers_throwsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            calculator.add("1,-2")
        );
        assertEquals("negatives not allowed: -2", exception.getMessage());

        Exception exception2 = assertThrows(IllegalArgumentException.class, () ->
            calculator.add("//;\n-1;2;-4")
        );
        assertEquals("negatives not allowed: -1, -4", exception2.getMessage());
    }

    @Test
    void getCalledCount_returnsNumberOfAddCalls() {
        assertEquals(0, calculator.getCalledCount());

        calculator.add("");
        assertEquals(1, calculator.getCalledCount());

        calculator.add("1");
        assertEquals(2, calculator.getCalledCount());

        calculator.add("1,2");
        assertEquals(3, calculator.getCalledCount());
    }

    @Test
    void add_numbersBiggerThan1000_areIgnored() {
        assertEquals(2, calculator.add("2,1001"));
        assertEquals(1002, calculator.add("1000,1001,2"));
        assertEquals(0, calculator.add("1234"));
    }
    @Test
    void add_customDelimiterAnyLength_returnsSum() {
        assertEquals(15, calculator.add("//[####]\n4####5####6"));
    }

    @Test
    void add_multipleDelimiters_returnsSum() {
        assertEquals(6, calculator.add("//[*][%]\n1*2%3"));
    }





}