package com.ttd;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String[] tokens = numbers.split(",");
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        } else if (tokens.length == 2) {
            return Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[1]);
        }
        return 0;
    }
}
